package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/* compiled from: TimelineItemTrimDecoration.java */
/* loaded from: classes2.dex */
public class J extends A implements Observer {
    private static final String l = "J";
    private int A;
    private b B;
    private final Rect C;
    private NexTimeline.c D;
    private NexTimelineItem.x E;
    private List<a> F;
    private final NexTimelineItem m;
    private X n;
    private Drawable o;
    private Rect p;
    private Path q;
    private RectF r;
    private float s;
    private int t;
    private int u;
    private int v;
    private float w;
    private int x;
    private Rect y;
    private Rect z;

    /* compiled from: TimelineItemTrimDecoration.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(J j, NexTimelineItem nexTimelineItem);

        void a(J j, NexTimelineItem nexTimelineItem, int i);

        void b(J j, NexTimelineItem nexTimelineItem);
    }

    /* compiled from: TimelineItemTrimDecoration.java */
    /* loaded from: classes2.dex */
    public class b extends PopupWindow {

        /* renamed from: a */
        private boolean f22593a;

        /* renamed from: b */
        private boolean f22594b;

        b() {
            super(J.this.g().inflate(R.layout.popup_time_balloon, (ViewGroup) null), -2, -2, false);
        }

        boolean c() {
            return this.f22594b;
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            if (this.f22594b) {
                return;
            }
            this.f22594b = true;
            getContentView().animate().setInterpolator(new LinearOutSlowInInterpolator()).setDuration(300L).setListener(new L(this)).scaleX(0.95f).scaleY(0.95f).alpha(0.0f).start();
        }

        @Override // android.widget.PopupWindow
        public boolean isShowing() {
            return super.isShowing() && this.f22593a;
        }

        @Override // android.widget.PopupWindow
        public void showAtLocation(View view, int i, int i2, int i3) {
            if (this.f22594b || isShowing()) {
                return;
            }
            try {
                super.showAtLocation(view, i, i2, i3);
            } catch (WindowManager.BadTokenException unused) {
            }
            getContentView().setVisibility(4);
            getContentView().addOnLayoutChangeListener(new K(this, view));
        }

        @Override // android.widget.PopupWindow
        public void update(int i, int i2, int i3, int i4) {
            super.update(i, i2, i3, i4);
        }

        public int b() {
            return getContentView().getMeasuredWidth();
        }

        public void a(String str) {
            TextView textView = (TextView) getContentView().findViewById(R.id.content);
            if (textView != null) {
                textView.setText(str);
            }
        }

        public int a() {
            return getContentView().getMeasuredHeight();
        }
    }

    public J(UniformTimelineView uniformTimelineView, NexTimelineItem nexTimelineItem) {
        super(uniformTimelineView);
        this.p = new Rect();
        this.q = new Path();
        this.r = new RectF();
        this.C = new Rect();
        this.m = nexTimelineItem;
        this.n = a(nexTimelineItem);
        Log.d(l, "[Trim] viewHolder: " + this.n + ", item: " + nexTimelineItem);
        if (this.n == null) {
            this.n = c().createViewHolder(n(), nexTimelineItem.getTimelineViewLayoutResource());
            c().bindViewHolder(this.n, h().a((Fa) nexTimelineItem));
        }
        this.s = j().getDimensionPixelSize(R.dimen.timeline3_itemCornerRadius);
        this.t = a(10.0f);
        this.u = a(40.0f);
        if (nexTimelineItem instanceof NexAudioClipItem) {
            NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) nexTimelineItem;
            if (nexAudioClipItem.isExtendToEnd()) {
                this.v = 0;
            } else if (nexAudioClipItem.isLoop()) {
                this.v = 2;
            } else {
                this.v = 3;
            }
        } else {
            int timelineViewLayoutResource = nexTimelineItem.getTimelineViewLayoutResource();
            if (timelineViewLayoutResource != R.layout.timeline_item_primary_image && timelineViewLayoutResource != R.layout.timeline_item_secondary_imagelayer) {
                this.v = 3;
            } else {
                this.v = 2;
            }
        }
        int i = this.v;
        if (i == 0) {
            this.o = b(R.drawable.timeline_item_border_sel_v5);
        } else if (i == 2) {
            this.o = b(R.drawable.grip_yellow_right_v5);
        } else {
            this.o = b(R.drawable.grip_yellow_v5);
        }
        nexTimelineItem.addObserver(this);
        n().addItemDecoration(this);
    }

    private void A() {
        NexTimelineItem.x xVar;
        b bVar = this.B;
        if (bVar == null || !bVar.isShowing() || (xVar = this.E) == null) {
            return;
        }
        this.B.a(xVar.a());
        this.n.itemView.getGlobalVisibleRect(this.C);
        int b2 = this.B.b();
        int a2 = this.B.a();
        if (b2 < 0 || a2 < 0) {
            return;
        }
        this.B.update((this.A == 1 ? this.C.left : this.C.right) - (b2 / 2), this.C.top - a2, b2, a2);
    }

    private void c(Canvas canvas) {
        canvas.save();
        if (v()) {
            int i = h().H;
            int i2 = h().E + h().U;
            canvas.clipRect(i, i2, canvas.getWidth() + i, canvas.getHeight() + i2);
        }
        Rect rect = this.p;
        canvas.translate(rect.left, rect.top);
        int i3 = this.v != 0 ? this.t : 0;
        int i4 = this.m instanceof NexSecondaryTimelineItem ? h().G / 2 : 0;
        this.o.setBounds(-i3, -i4, this.p.width() + i3, this.p.height() + i4);
        this.o.draw(canvas);
        canvas.restore();
    }

    private void t() {
        b bVar = this.B;
        if (bVar == null || bVar.c()) {
            return;
        }
        this.B.dismiss();
        this.B = null;
    }

    private boolean u() {
        return this.m instanceof NexPrimaryTimelineItem;
    }

    private boolean v() {
        return this.m instanceof NexSecondaryTimelineItem;
    }

    private void w() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).a(this, this.m);
        }
    }

    private void x() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).b(this, this.m);
        }
    }

    private void y() {
        t();
        this.B = new b();
        this.B.showAtLocation(this.n.itemView, 0, -1, -1);
    }

    private void z() {
        this.n.itemView.getHitRect(this.p);
        this.r.set(this.p);
        if (v()) {
            this.r.top += h().E + h().U;
        }
        this.q.reset();
        Path path = this.q;
        RectF rectF = this.r;
        float f2 = this.s;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        if ((this.v & 1) == 1) {
            if (this.y == null) {
                this.y = new Rect();
            }
            Rect rect = this.y;
            int i = this.p.left;
            int i2 = this.u;
            rect.left = i - ((this.t + i2) / 2);
            rect.right = rect.left + i2;
            if (u()) {
                Rect rect2 = this.y;
                Rect rect3 = this.p;
                rect2.top = rect3.top;
                rect2.bottom = rect3.bottom;
            } else {
                this.y.top = this.p.top - (h().G / 2);
                this.y.bottom = this.p.bottom + (h().G / 2);
            }
        }
        if ((this.v & 2) == 2) {
            if (this.z == null) {
                this.z = new Rect();
            }
            Rect rect4 = this.z;
            int i3 = this.p.right;
            int i4 = this.u;
            rect4.left = i3 - ((i4 - this.t) / 2);
            rect4.right = rect4.left + i4;
            if (u()) {
                Rect rect5 = this.z;
                Rect rect6 = this.p;
                rect5.top = rect6.top;
                rect5.bottom = rect6.bottom;
                return;
            }
            this.z.top = this.p.top - (h().G / 2);
            this.z.bottom = this.p.bottom + (h().G / 2);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.A
    public void b() {
        super.b();
        t();
        this.y = null;
        this.z = null;
        this.F.clear();
        this.m.deleteObserver(this);
        n().removeItemDecoration(this);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.A
    protected int l() {
        return 2;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (n().getEditingMode() != R.id.editmode_trim) {
            return;
        }
        z();
        b(canvas);
        a(canvas);
        c(canvas);
    }

    public int s() {
        return this.A;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        int i;
        NexTimelineItem nexTimelineItem = this.m;
        if (nexTimelineItem instanceof NexAudioClipItem) {
            NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) nexTimelineItem;
            if (nexAudioClipItem.isExtendToEnd()) {
                i = 0;
            } else {
                i = nexAudioClipItem.isLoop() ? 2 : 3;
            }
            if (this.v != i) {
                this.v = i;
                int i2 = this.v;
                if (i2 == 0) {
                    this.o = b(R.drawable.timeline_item_border_sel_v5);
                } else if (i2 == 2) {
                    this.o = b(R.drawable.grip_yellow_right_v5);
                } else {
                    this.o = b(R.drawable.grip_yellow_v5);
                }
            }
            n().invalidateItemDecorations();
        }
        this.n = a(this.m);
        if (this.n == null) {
            this.n = c().createViewHolder(n(), this.m.getTimelineViewLayoutResource());
            c().bindViewHolder(this.n, h().a((Fa) this.m));
        }
    }

    public J a(a aVar) {
        if (this.F == null) {
            this.F = new ArrayList();
        }
        if (!this.F.contains(aVar)) {
            this.F.add(aVar);
        }
        return this;
    }

    private void a(Canvas canvas) {
        NexVideoClipItem nexVideoClipItem;
        NexVideoClipItem nexVideoClipItem2;
        int i;
        NexTimelineItem nexTimelineItem = this.m;
        if ((nexTimelineItem instanceof NexVideoClipItem) && (nexVideoClipItem = (NexVideoClipItem) nexTimelineItem) != null && nexVideoClipItem.isVideo()) {
            int firstRepresentedTime = nexVideoClipItem.getFirstRepresentedTime();
            int representedDuration = nexVideoClipItem.getRepresentedDuration();
            int representedDurationWithoutSpeedControl = nexVideoClipItem.getRepresentedDurationWithoutSpeedControl();
            int startOverlap = nexVideoClipItem.getStartOverlap() + ((nexVideoClipItem.getTrimTimeStart() * 100) / nexVideoClipItem.getPlaybackSpeed());
            Drawable drawable = j().getDrawable(R.drawable.iframe_mark);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int applyDimension = (int) TypedValue.applyDimension(1, 2.5f, j().getDisplayMetrics());
            int[] G = MediaInfo.a(nexVideoClipItem.getMediaPath()).G();
            canvas.save();
            Rect rect = this.p;
            canvas.translate(rect.left, rect.top);
            int i2 = 0;
            while (G != null && i2 < G.length) {
                int i3 = G[i2];
                if (i3 < firstRepresentedTime || i3 > firstRepresentedTime + representedDurationWithoutSpeedControl) {
                    nexVideoClipItem2 = nexVideoClipItem;
                    i = firstRepresentedTime;
                } else {
                    nexVideoClipItem2 = nexVideoClipItem;
                    i = firstRepresentedTime;
                    int playbackSpeed = (int) (((((i3 * 100) / nexVideoClipItem.getPlaybackSpeed()) - startOverlap) * this.p.width()) / representedDuration);
                    int i4 = intrinsicWidth / 2;
                    drawable.setBounds(playbackSpeed - i4, applyDimension, playbackSpeed + i4, applyDimension + intrinsicHeight);
                    drawable.draw(canvas);
                }
                i2++;
                nexVideoClipItem = nexVideoClipItem2;
                firstRepresentedTime = i;
            }
            canvas.restore();
        }
    }

    private void b(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.q);
        Rect rect = this.p;
        canvas.translate(rect.left, rect.top);
        this.n.itemView.draw(canvas);
        Log.d(l, "[drawItemView] viewHolder: " + this.n + ", itemView: " + this.n.itemView.getLeft() + ", " + this.n.itemView.getTop() + ", itemBounds: " + this.p);
        canvas.restore();
    }

    private void c(int i) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).a(this, this.m, i);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.A
    public void a(MotionEvent motionEvent) {
        Rect rect;
        Rect rect2;
        super.a(motionEvent);
        if (n().getEditingMode() != R.id.editmode_trim) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if ((this.v & 2) == 2 && (rect2 = this.z) != null && rect2.contains(o(), p())) {
                this.A = 2;
            } else if ((this.v & 1) == 1 && (rect = this.y) != null && rect.contains(o(), p())) {
                this.A = 1;
            } else {
                this.A = 0;
            }
            if (this.A != 0) {
                a(true);
                if (u()) {
                    this.D = m().beginTimeChange();
                }
                this.E = this.m.beginTrim(new NexTimelineItem.y(d(), n(), h()), this.A);
                this.w = motionEvent.getX();
                this.x = 0;
                y();
                w();
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.A != 0) {
                a(false);
                t();
                NexTimelineItem.x xVar = this.E;
                if (xVar != null) {
                    xVar.commit();
                    this.E = null;
                }
                NexTimeline.c cVar = this.D;
                if (cVar != null) {
                    cVar.apply();
                }
                x();
                this.A = 0;
                this.w = 0.0f;
                return;
            }
            return;
        }
        if (actionMasked != 2) {
            return;
        }
        int i = this.A;
        if (i == 1 || i == 2) {
            float x = motionEvent.getX();
            float f2 = x - this.w;
            this.w = x;
            if (f2 != 0.0f) {
                this.x += (int) ((f2 / h().f()) + 0.5f);
                NexTimelineItem.x xVar2 = this.E;
                if (xVar2 != null) {
                    xVar2.a(this.x);
                }
                NexTimeline.c cVar2 = this.D;
                if (cVar2 != null) {
                    cVar2.apply();
                }
                if (u() && this.A == 1) {
                    h().d((int) (-f2), 0);
                }
                A();
                c(this.x);
            }
        }
    }
}
