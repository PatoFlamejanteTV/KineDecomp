package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Ea;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.C2034o;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.HandlerC2029j;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.I;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.J;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.T;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.r;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.y;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class UniformTimelineLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.OnItemTouchListener, T.b, HandlerC2029j.a, I.e, y.a, C2034o.b, J.a, r.a {
    private static final Class[] s = {Ea.class, NexSecondaryTimelineItem.class, M.class, C2035p.class, NexVideoClipItem.class, NexTransitionItem.class, C2036q.class};
    float B;
    int C;
    int D;
    int E;
    int F;
    int G;
    int H;
    private NexTimeline I;
    boolean J;
    boolean K;
    private Context L;
    private T M;
    private UniformTimelineView P;
    private HandlerC2029j Q;
    private A R;
    private final float S;
    int U;
    private int X;
    private Rect Y;
    private List<a> ba;
    float t = -2.1474836E9f;
    float u = 0.0f;
    float v = 0.0f;
    float w = 0.0f;
    float x = 0.0f;
    float y = 0.0f;
    float z = 0.0f;
    float A = 0.035f;
    private com.nexstreaming.app.general.util.z N = new com.nexstreaming.app.general.util.z();
    private Set<String> O = Collections.synchronizedSet(new HashSet());
    public boolean T = false;
    private O V = new O();
    private final Map<String, Integer> W = new HashMap();
    int Z = Integer.MIN_VALUE;
    int aa = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    boolean ca = false;
    private int da = 0;

    /* loaded from: classes2.dex */
    interface a {
        void a(RecyclerView.Recycler recycler, RecyclerView.State state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Scroller f22653a;

        /* renamed from: b, reason: collision with root package name */
        float f22654b;

        /* renamed from: c, reason: collision with root package name */
        float f22655c;

        /* renamed from: d, reason: collision with root package name */
        float f22656d;

        /* renamed from: e, reason: collision with root package name */
        int f22657e;

        b(float f2, float f3, float f4, int i) {
            this.f22653a = new Scroller(UniformTimelineLayoutManager.this.L, new LinearOutSlowInInterpolator());
            this.f22654b = f2;
            this.f22655c = f3;
            this.f22656d = f4;
            this.f22657e = i;
        }

        void b() {
            this.f22653a.startScroll(0, 0, (int) (this.f22655c - this.f22654b), 0);
            UniformTimelineLayoutManager.this.postOnAnimation(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f22653a.computeScrollOffset()) {
                UniformTimelineLayoutManager uniformTimelineLayoutManager = UniformTimelineLayoutManager.this;
                uniformTimelineLayoutManager.A = uniformTimelineLayoutManager.S / ((UniformTimelineLayoutManager.this.S - this.f22653a.getCurrX()) / this.f22656d);
                UniformTimelineLayoutManager.this.P.a(this.f22657e);
                UniformTimelineLayoutManager.this.postOnAnimation(this);
            }
            UniformTimelineLayoutManager.this.requestLayout();
        }
    }

    public UniformTimelineLayoutManager(NexTimeline nexTimeline, Context context) {
        this.L = context;
        Resources resources = e().getResources();
        this.B = resources.getDimension(R.dimen.timeline_millisecond_size);
        this.C = resources.getDimensionPixelSize(R.dimen.timeline3_primaryTimelineHeight);
        this.D = resources.getDimensionPixelSize(R.dimen.timeline3_primaryTimelineMinHeight);
        this.E = resources.getDimensionPixelSize(R.dimen.timeline3_timescale_height);
        this.F = resources.getDimensionPixelSize(R.dimen.timeline3_audioTrackHeight);
        this.G = resources.getDimensionPixelSize(R.dimen.timeline3_secondarySubTrackSpacing);
        this.H = resources.getDimensionPixelSize(R.dimen.timeline3_trackHeaderWidth);
        this.I = nexTimeline;
        this.Q = new HandlerC2029j(this.L, this);
        this.S = resources.getDimensionPixelSize(R.dimen.timeline3_clipMinWidth);
    }

    private void d(int i) {
        this.N.a(i);
    }

    private void k() {
        this.W.clear();
    }

    private void l() {
        this.V.a();
    }

    private void m() {
        this.N.clear();
        this.O.clear();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I.e
    public void a(I i, InterfaceC2024e interfaceC2024e) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.y.a
    public void a(I i, InterfaceC2024e interfaceC2024e, int i2) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.T.b
    public void a(X x) {
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.J || !this.ca || j();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.K || !this.ca || j();
    }

    public Context e() {
        return this.L;
    }

    public float f() {
        return this.B * this.A;
    }

    public float g() {
        return this.C + this.E + this.G;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(0, 0);
    }

    public NexTimeline h() {
        return this.P.getTimeline();
    }

    public UniformTimelineView i() {
        return this.P;
    }

    public boolean j() {
        A a2 = this.R;
        return a2 != null && a2.q();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        super.onAdapterChanged(adapter, adapter2);
        if (adapter instanceof T) {
            ((T) adapter).b(this);
        }
        this.M = adapter2 instanceof T ? (T) adapter2 : null;
        T t = this.M;
        if (t != null) {
            t.a(this);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        if (recyclerView instanceof UniformTimelineView) {
            this.P = (UniformTimelineView) recyclerView;
            this.P.addOnItemTouchListener(this);
        } else {
            throw new RuntimeException("Unsupport view type: " + recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        UniformTimelineView uniformTimelineView = this.P;
        if (uniformTimelineView != null) {
            uniformTimelineView.removeOnItemTouchListener(this);
            this.P = null;
        }
        super.onDetachedFromWindow(recyclerView, recycler);
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.Q.a(motionEvent);
        A a2 = this.R;
        if (a2 == null) {
            return false;
        }
        a2.a(motionEvent);
        this.Q.a();
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        a(recycler, state);
        List<a> list = this.ba;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.ba.get(size).a(recycler, state);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.HandlerC2029j.a
    public void onLongPress(MotionEvent motionEvent) {
        int adapterPosition;
        UniformTimelineView uniformTimelineView = this.P;
        if (uniformTimelineView == null || this.M == null) {
            return;
        }
        if (uniformTimelineView.getParent() != null) {
            this.P.getParent().requestDisallowInterceptTouchEvent(true);
        }
        View findChildViewUnder = this.P.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (findChildViewUnder != null && (adapterPosition = this.P.getChildViewHolder(findChildViewUnder).getAdapterPosition()) != -1 && adapterPosition < this.M.getItemCount()) {
            Fa item = this.M.getItem(adapterPosition);
            if (!item.isDraggable()) {
                return;
            } else {
                b(item, motionEvent);
            }
        }
        this.P.setIgnoreTouchEvent(true);
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        this.da = i;
        d();
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (j() && this.T) {
            return 0;
        }
        float f2 = this.t;
        d(i, 0);
        int i2 = (int) (this.t - f2);
        if (i2 != 0) {
            a(recycler, state);
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b3, code lost:            if (r1 > r0) goto L33;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003c, code lost:            if (r0 > r7) goto L14;     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060 A[LOOP:0: B:15:0x005a->B:17:0x0060, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa  */
    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void scrollToPosition(int r7) {
        /*
            Method dump skipped, instructions count: 195
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineLayoutManager.scrollToPosition(int):void");
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (j() && this.T) {
            return 0;
        }
        float f2 = this.u;
        d(0, i);
        int i2 = (int) (this.u - f2);
        if (i2 != 0) {
            a(recycler, state);
        }
        return i2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        super.smoothScrollToPosition(recyclerView, state, i);
    }

    private int a(String str) {
        if (this.W.containsKey(str)) {
            return this.W.get(str).intValue();
        }
        return 0;
    }

    private void b(int i, int i2, int i3) {
        this.V.a(i, i2, i3);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I.e
    public void c(I i, InterfaceC2024e interfaceC2024e) {
        m();
        k();
        l();
        if (this.P != null) {
            if (interfaceC2024e.getItem() instanceof NexTimelineItem) {
                this.P.getVideoEditor().c((NexTimelineItem) interfaceC2024e.getItem());
            }
            this.P.getVideoEditor().J();
            if (this.M != null && !this.P.isComputingLayout()) {
                this.M.notifyDataSetChanged();
            }
            this.P.getParent().requestDisallowInterceptTouchEvent(false);
            this.P.setOverScrollMode(this.X);
            this.P.requestLayout();
        }
        A a2 = this.R;
        if (a2 != null) {
            a2.b();
            this.R = null;
        }
    }

    public void d() {
        float f2 = this.B * this.A;
        float width = getWidth() / 2;
        this.y = (this.I.getTotalTime() * f2) - width;
        this.z = (this.I.getTotalTime() * f2) - width;
        this.x = -width;
        UniformTimelineView uniformTimelineView = this.P;
        if (uniformTimelineView != null && (uniformTimelineView.getSelectedItem() instanceof NexSecondaryTimelineItem)) {
            NexSecondaryTimelineItem nexSecondaryTimelineItem = (NexSecondaryTimelineItem) this.P.getSelectedItem();
            Ea track = nexSecondaryTimelineItem.getTrack();
            int i = 0;
            for (int i2 = 0; i2 < track.d(); i2++) {
                i += a(this.I.getTrackAtIndex(i2));
            }
            int subTrackMapping = nexSecondaryTimelineItem.getSubTrackMapping();
            int i3 = this.F;
            int i4 = this.G;
            this.w = ((i + (subTrackMapping * (i3 + i4))) + this.D) - (i4 * 2);
            this.v = this.w + ((float) i3) > ((float) (this.P.getHeight() - this.C)) ? ((this.w + this.F) + this.G) - (this.P.getHeight() - this.C) : 0.0f;
        } else {
            this.w = (this.I.getRequiredSubTrackCount() * this.F) + this.C;
            this.v = 0.0f;
        }
        if (j()) {
            return;
        }
        if (this.da == 2) {
            float f3 = (this.Z * f2) - width;
            float f4 = (this.aa * f2) - width;
            if (f4 < f3) {
                f4 = f3;
            }
            if (this.x < f3 && this.t >= f3) {
                this.x = f3;
            }
            if (this.z > f4 && this.t <= f4) {
                this.z = f4;
            }
            if (this.y <= f4 || this.t > f4) {
                return;
            }
            this.y = f4;
            return;
        }
        float f5 = (this.Z * f2) - width;
        float f6 = (this.aa * f2) - width;
        if (f6 < f5) {
            f6 = f5;
        }
        if (this.x < f5) {
            this.x = f5;
        }
        if (this.z > f6) {
            this.z = f6;
        }
        if (this.y > f6) {
            this.y = f6;
        }
    }

    public void b(a aVar) {
        List<a> list = this.ba;
        if (list != null) {
            list.remove(aVar);
        }
    }

    public void a(a aVar) {
        if (this.ba == null) {
            this.ba = new ArrayList();
        }
        if (this.ba.contains(aVar)) {
            return;
        }
        this.ba.add(aVar);
    }

    private void b(String str) {
        this.O.add(str);
    }

    private void b(Fa fa, MotionEvent motionEvent) {
        this.P.d();
        A a2 = this.R;
        if (a2 != null) {
            a2.b();
            this.R = null;
        }
        this.R = a(fa, motionEvent);
        this.R.a(motionEvent);
    }

    private void a(View view, boolean z) {
        view.setHovered(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x024a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.support.v7.widget.RecyclerView.Recycler r22, android.support.v7.widget.RecyclerView.State r23) {
        /*
            Method dump skipped, instructions count: 900
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineLayoutManager.a(android.support.v7.widget.RecyclerView$Recycler, android.support.v7.widget.RecyclerView$State):void");
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I.e
    public void b(I i, InterfaceC2024e interfaceC2024e) {
        if (i != this.R) {
            return;
        }
        Fa item = interfaceC2024e.getItem();
        if (item instanceof M) {
            d(((M) item).a().c());
        } else if (item instanceof NexTimelineItem) {
            b(((NexTimelineItem) item).getUniqueId().toString());
        }
        UniformTimelineView uniformTimelineView = this.P;
        if (uniformTimelineView != null) {
            this.X = uniformTimelineView.getOverScrollMode();
            this.P.setOverScrollMode(2);
            this.P.requestLayout();
        }
    }

    public int c(int i, int i2) {
        int i3 = this.E + this.C + (this.G / 2);
        int trackCount = h().getTrackCount();
        for (int i4 = 0; i4 < trackCount; i4++) {
            Ea trackAtIndex = this.I.getTrackAtIndex(i4);
            int a2 = a(trackAtIndex);
            if (i2 > i3 && i2 < i3 + a2) {
                Log.d("TimelineLayoutManager", "[getTrackIdAtLocation] y: " + i2 + ", trackOffset: " + i3 + ", height: " + a2);
                return trackAtIndex.c();
            }
            i3 += a2;
        }
        return -1;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.J.a
    public void b(J j, NexTimelineItem nexTimelineItem) {
        UniformTimelineView uniformTimelineView = this.P;
        if (uniformTimelineView != null) {
            uniformTimelineView.setOverScrollMode(this.X);
            this.P.setTimelineGuideVisibility(true);
            this.P.b(nexTimelineItem.getUIStartTime(), nexTimelineItem.getUIEndTime(), false);
            VideoEditor videoEditor = this.P.getVideoEditor();
            videoEditor.p().onComplete(new U(this, videoEditor, nexTimelineItem));
            int s2 = j.s();
            if (s2 == 2) {
                this.P.c(nexTimelineItem.getAbsEndTime(), true);
            } else if (s2 == 1) {
                this.P.c(nexTimelineItem.getAbsStartTime(), true);
            }
        }
        requestLayout();
    }

    public Rect c(int i) {
        if (this.M == null) {
            return null;
        }
        if (this.Y == null) {
            this.Y = new Rect();
        }
        int itemCount = this.M.getItemCount() - 1;
        while (true) {
            if (itemCount < 0) {
                break;
            }
            Fa item = this.M.getItem(itemCount);
            if (item instanceof Ea) {
                Ea ea = (Ea) item;
                if (ea.c() == i) {
                    View a2 = a(itemCount);
                    if (a2 != null) {
                        a2.getHitRect(this.Y);
                        this.Y.left += this.H;
                    } else {
                        Rect rect = this.Y;
                        rect.left = this.H;
                        rect.top = b(ea.c());
                        this.Y.right = getWidth();
                        Rect rect2 = this.Y;
                        rect2.bottom = rect2.top + a(ea);
                    }
                }
            }
            itemCount--;
        }
        int i2 = (int) (-this.t);
        Rect rect3 = this.Y;
        if (rect3.left < i2) {
            rect3.left = i2;
        }
        int totalTime = (int) ((this.I.getTotalTime() * f()) - this.t);
        Rect rect4 = this.Y;
        if (rect4.right > totalTime) {
            rect4.right = totalTime;
        }
        return this.Y;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.r.a
    public void b(r rVar) {
        requestLayout();
    }

    public int b(int i) {
        int i2 = this.C + this.E + (this.G / 2);
        int trackCount = h().getTrackCount();
        for (int i3 = 0; i3 < trackCount; i3++) {
            Ea trackAtIndex = h().getTrackAtIndex(i3);
            if (trackAtIndex.c() == i) {
                break;
            }
            i2 += a(trackAtIndex);
        }
        return i2;
    }

    public void d(int i, int i2) {
        d();
        this.u += i2;
        float f2 = this.u;
        float f3 = this.w;
        if (f2 > f3) {
            this.u = f3;
        }
        float f4 = this.u;
        float f5 = this.v;
        if (f4 < f5) {
            this.u = f5;
        }
        double d2 = this.t;
        float f6 = this.y;
        double d3 = f6;
        Double.isNaN(d3);
        if (d2 >= d3 - 1.0E-4d) {
            f6 = this.z;
        }
        this.t += i;
        if (this.t > f6) {
            this.t = f6;
        }
        float f7 = this.t;
        float f8 = this.x;
        if (f7 < f8) {
            this.t = f8;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I.e
    public void d(I i, InterfaceC2024e interfaceC2024e) {
        if (i != this.R) {
            return;
        }
        int action = interfaceC2024e.getAction();
        Fa item = interfaceC2024e.getItem();
        if (item instanceof NexSecondaryTimelineItem) {
            NexSecondaryTimelineItem nexSecondaryTimelineItem = (NexSecondaryTimelineItem) item;
            if (action == 5) {
                nexSecondaryTimelineItem.setTrackId(this.I.addTrack(this.I.getTrackById(interfaceC2024e.c()).d()).c());
            } else if (action == 6) {
                nexSecondaryTimelineItem.setTrackId(this.I.addTrack(this.I.getTrackById(interfaceC2024e.c()).d() + 1).c());
            } else if (this.I.getTrackIdByItem(nexSecondaryTimelineItem) == interfaceC2024e.c()) {
                int d2 = (int) ((interfaceC2024e.d() + this.t) / f());
                int duration = nexSecondaryTimelineItem.getDuration() + d2;
                nexSecondaryTimelineItem.setStartTime(d2);
                nexSecondaryTimelineItem.setEndTime(duration);
            } else {
                nexSecondaryTimelineItem.setTrackId(interfaceC2024e.c());
            }
        }
        requestLayout();
        UniformTimelineView uniformTimelineView = this.P;
        if (uniformTimelineView != null) {
            uniformTimelineView.getVideoEditor().H();
        }
    }

    public int a(Ea ea) {
        return Math.max(1, ea.e()) * (this.F + this.G);
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        layoutDecorated(view, i, i2, i3, i4);
    }

    private I a(Fa fa, MotionEvent motionEvent) {
        if (fa instanceof NexTransitionItem) {
            r rVar = new r(this.P, (NexTransitionItem) fa, motionEvent);
            rVar.a((r.a) this);
            rVar.a((I.e) this);
            return rVar;
        }
        if (fa instanceof NexPrimaryTimelineItem) {
            C2034o c2034o = new C2034o(this.P, (NexPrimaryTimelineItem) fa, motionEvent);
            c2034o.a((C2034o.b) this);
            c2034o.a((I.e) this);
            return c2034o;
        }
        if (fa instanceof M) {
            y yVar = new y(this.P, fa, motionEvent);
            yVar.a((y.a) this);
            yVar.a((I.e) this);
            return yVar;
        }
        C2039u c2039u = new C2039u(this.P, fa, motionEvent);
        c2039u.a(this);
        return c2039u;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.C2034o.b
    public void a(NexPrimaryTimelineItem nexPrimaryTimelineItem, int i) {
        this.W.put(nexPrimaryTimelineItem.getUniqueId().toString(), Integer.valueOf(i));
        requestLayout();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.C2034o.b
    public void a(NexPrimaryTimelineItem nexPrimaryTimelineItem, int i, int i2) {
        i().getVideoEditor().a(i, i2);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.y.a
    public void a(I i, InterfaceC2024e interfaceC2024e, int i2, int i3) {
        int action;
        if (i2 != i3 && ((action = interfaceC2024e.getAction()) == 5 || action == 6)) {
            Ea removeTrack = h().removeTrack(h().getTrackIndexById(i2));
            int trackIndexById = h().getTrackIndexById(i3);
            if (action == 6) {
                trackIndexById++;
            }
            h().addTrack(trackIndexById, removeTrack);
        }
        l();
        requestLayout();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.y.a
    public void a(I i, InterfaceC2024e interfaceC2024e, int i2, int i3, int i4) {
        int i5;
        int a2;
        int b2;
        int i6;
        if (interfaceC2024e.a() == -1) {
            i5 = i2;
            i2 = i3;
        } else if (interfaceC2024e.a() == 1) {
            i5 = i3;
        } else {
            i5 = -1;
            i2 = -1;
        }
        if (i2 == -1 || i5 == -1) {
            return;
        }
        int trackIndexById = h().getTrackIndexById(i2);
        int trackIndexById2 = h().getTrackIndexById(i5);
        if (trackIndexById < 0 || trackIndexById2 < 0) {
            return;
        }
        l();
        while (trackIndexById <= trackIndexById2) {
            Ea trackAtIndex = h().getTrackAtIndex(trackIndexById);
            Rect bounds = interfaceC2024e.b().getBounds();
            Rect c2 = c(trackAtIndex.c());
            if (trackAtIndex.c() == i3) {
                if (interfaceC2024e.a() == -1) {
                    b2 = b(trackAtIndex.c()) + c2.height();
                    i6 = bounds.top;
                } else {
                    b2 = b(trackAtIndex.c());
                    i6 = bounds.bottom;
                }
                a2 = b2 - (i6 - i4);
            } else {
                a2 = a(trackAtIndex) * (-interfaceC2024e.a());
            }
            b(trackAtIndex.c(), trackAtIndex.c(), (int) (a2 * (bounds.height() / c2.height())));
            trackIndexById++;
        }
        requestLayout();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.J.a
    public void a(J j, NexTimelineItem nexTimelineItem) {
        UniformTimelineView uniformTimelineView = this.P;
        if (uniformTimelineView != null) {
            this.X = uniformTimelineView.getOverScrollMode();
            this.P.setOverScrollMode(2);
            this.P.setTimelineGuideVisibility(false);
        }
        requestLayout();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.J.a
    public void a(J j, NexTimelineItem nexTimelineItem, int i) {
        requestLayout();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.r.a
    public void a(r rVar) {
        requestLayout();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.r.a
    public void a(r rVar, NexTransitionItem nexTransitionItem, int i) {
        requestLayout();
    }

    public View a(int i) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        UniformTimelineView uniformTimelineView = this.P;
        if (uniformTimelineView == null || i == -1 || (findViewHolderForAdapterPosition = uniformTimelineView.findViewHolderForAdapterPosition(i)) == null) {
            return null;
        }
        return findViewHolderForAdapterPosition.itemView;
    }

    public int a(Fa fa) {
        T t = this.M;
        if (t == null) {
            return -1;
        }
        int itemCount = t.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (this.M.getItem(i) == fa) {
                return i;
            }
        }
        return -1;
    }

    public void a(NexTimelineItem nexTimelineItem) {
        float uIEndTime;
        float f2;
        A a2 = this.R;
        if (a2 != null) {
            a2.b();
            this.R = null;
        }
        if (nexTimelineItem != null && nexTimelineItem.isClipReady() && nexTimelineItem.isTrimmable()) {
            J j = new J(this.P, nexTimelineItem);
            j.a(this);
            this.R = j;
        }
        d();
        float f3 = this.u;
        float f4 = this.w;
        if (f3 > f4) {
            d(0, (int) (f4 - f3));
        } else {
            float f5 = this.v;
            if (f3 < f5) {
                d(0, (int) (f5 - f3));
            }
        }
        if (nexTimelineItem != null) {
            if (nexTimelineItem instanceof NexTransitionItem) {
                NexTransitionItem nexTransitionItem = (NexTransitionItem) nexTimelineItem;
                NexVideoClipItem leftClip = nexTransitionItem.getLeftClip();
                NexVideoClipItem rightClip = nexTransitionItem.getRightClip();
                uIEndTime = (rightClip.getAbsEndTime() - rightClip.getEndOverlap()) - (leftClip.getAbsStartTime() + leftClip.getStartOverlap());
                f2 = f();
            } else {
                uIEndTime = nexTimelineItem.getUIEndTime() - nexTimelineItem.getUIStartTime();
                f2 = f();
            }
            float f6 = uIEndTime * f2;
            float f7 = this.S;
            if (f6 < f7) {
                new b(f6, f7, this.A, this.P.getCurrentTime()).b();
            }
        }
    }

    public static UniformTimelineLayoutManager a(View view) {
        UniformTimelineView g2 = UniformTimelineView.g(view);
        if (g2 == null || !(g2.getLayoutManager() instanceof UniformTimelineLayoutManager)) {
            return null;
        }
        return (UniformTimelineLayoutManager) g2.getLayoutManager();
    }
}
