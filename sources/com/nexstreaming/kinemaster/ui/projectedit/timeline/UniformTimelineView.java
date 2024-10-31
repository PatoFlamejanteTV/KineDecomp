package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.InputDeviceCompat;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import c.e.a.a.d;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Ea;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.mediaprep.C1803a;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.WhichTimeline;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class UniformTimelineView extends RecyclerView implements InterfaceC2025f {
    private boolean Ab;
    private boolean Bb;
    private boolean Cb;
    private MediaPrepManager Db;
    private final C1803a Eb;
    private ScaleGestureDetector.OnScaleGestureListener Fb;
    private final int Ia;
    private final int Ja;
    private final int Ka;
    private NexTimeline La;
    private int Ma;
    private int Na;
    private int Oa;
    private int Pa;
    private int Qa;
    private boolean Ra;
    private boolean Sa;
    private ScaleGestureDetector Ta;
    private boolean Ua;
    private boolean Va;
    private int Wa;
    private int Xa;
    private int Ya;
    private Paint Za;
    private Paint _a;
    private Paint ab;
    private Paint bb;
    private Paint cb;
    private Paint db;
    private RectF eb;
    private TimelineView.d fb;
    private boolean gb;
    private int hb;
    private Rect ib;
    private b jb;
    private c kb;
    private Set<Fa> lb;
    private Set<Fa> mb;
    private NexTimelineItem nb;
    private int ob;
    private c.e.a.a.f pb;
    private PurchaseType qb;
    private VideoEditor rb;
    private boolean sb;
    private int tb;
    private int ub;
    private Paint vb;
    private int wb;
    private int xb;
    private boolean yb;
    private List<a> zb;

    /* loaded from: classes2.dex */
    public interface a {
        void onDrawForeground(Canvas canvas);
    }

    /* loaded from: classes2.dex */
    public interface b {
        boolean a(UniformTimelineView uniformTimelineView, View view, NexTimelineItem nexTimelineItem, MotionEvent motionEvent);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(Set set, Fa fa);
    }

    public UniformTimelineView(Context context) {
        this(context, null);
    }

    private void Y() {
        UniformTimelineLayoutManager uniformTimelineLayoutManager = getUniformTimelineLayoutManager();
        if (uniformTimelineLayoutManager != null) {
            uniformTimelineLayoutManager.Z = this.wb;
            uniformTimelineLayoutManager.aa = this.xb;
        }
    }

    private void Z() {
        NexTimelineItem selectedItem = getSelectedItem();
        if (J()) {
            return;
        }
        if (selectedItem != null && selectedItem.isTrimmable() && (this.yb || !c(selectedItem))) {
            setEditingMode(R.id.editmode_trim);
        } else {
            setEditingMode(0);
        }
        if (this.fb != null) {
            Ea selectedTrack = getSelectedTrack();
            if (selectedTrack != null) {
                this.fb.a(selectedTrack);
            } else {
                this.fb.a(getSelectedTimeline(), getSelectedIndex(), selectedItem);
            }
        }
        if (getLayoutManager() instanceof UniformTimelineLayoutManager) {
            ((UniformTimelineLayoutManager) getLayoutManager()).a(selectedItem);
        }
    }

    private void aa() {
        setLayoutManager(new UniformTimelineLayoutManager(this.La, getContext()));
        setAdapter(new T(this.La, this));
        Y();
    }

    private void c(Canvas canvas) {
        if (this.sb) {
            UniformTimelineLayoutManager uniformTimelineLayoutManager = getUniformTimelineLayoutManager();
            float f2 = uniformTimelineLayoutManager.B * uniformTimelineLayoutManager.A;
            this.eb.left = ((int) Math.floor((this.tb * f2) - uniformTimelineLayoutManager.t)) + 1;
            this.eb.right = ((int) Math.floor((this.ub * f2) - uniformTimelineLayoutManager.t)) - 1;
            RectF rectF = this.eb;
            rectF.top = this.Ya;
            rectF.bottom = getHeight();
            canvas.drawRect(this.eb, this.vb);
        }
    }

    private boolean d(MotionEvent motionEvent) {
        if (this.ob == R.id.editmode_multi_select) {
            return false;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(this.ib);
                if (this.ib.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    Fa item = ((T) getAdapter()).getItem(getChildAdapterPosition(childAt));
                    if (item != null && !(item instanceof C2036q)) {
                        b bVar = this.jb;
                        if (bVar != null && (item instanceof NexTimelineItem)) {
                            return bVar.a(this, childAt, (NexTimelineItem) item, motionEvent);
                        }
                        if (!(item instanceof NexTimelineItem) && !(item instanceof M)) {
                            if (!(item instanceof Ea) || getSelectedItem() != item) {
                                setSelectedItem((NexTimelineItem) null);
                            }
                        } else if (getSelectedItem() == null && getSelectedTrack() == null) {
                            if (b(item)) {
                                setSelectedItem(item);
                            }
                        } else {
                            setSelectedItem((NexTimelineItem) null);
                        }
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        b bVar2 = this.jb;
        if (bVar2 != null) {
            return bVar2.a(this, null, null, motionEvent);
        }
        setSelectedItem((NexTimelineItem) null);
        return true;
    }

    private boolean e(MotionEvent motionEvent) {
        if (this.ob == R.id.editmode_multi_select && getAdapter() != null) {
            Drawable drawable = getResources().getDrawable(R.drawable.checkbox_clip_normal);
            int applyDimension = (int) TypedValue.applyDimension(1, 8.0f, getContext().getResources().getDisplayMetrics());
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                Fa item = ((T) getAdapter()).getItem(getChildAdapterPosition(childAt));
                if ((item instanceof NexTimelineItem) && !(item instanceof NexTransitionItem)) {
                    Rect rect = new Rect();
                    childAt.getHitRect(rect);
                    int i2 = rect.left + applyDimension;
                    int intrinsicWidth = drawable.getIntrinsicWidth() + i2;
                    int height = rect.top + ((rect.height() / 2) - (drawable.getIntrinsicHeight() / 2));
                    int intrinsicHeight = drawable.getIntrinsicHeight() + height;
                    int applyDimension2 = (int) TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics());
                    if (new Rect(i2, height, intrinsicWidth, intrinsicHeight).intersect(new Rect(((int) motionEvent.getX()) - applyDimension2, ((int) motionEvent.getY()) - applyDimension2, ((int) motionEvent.getX()) + applyDimension2, ((int) motionEvent.getY()) + applyDimension2))) {
                        if (this.lb.contains(item)) {
                            this.lb.remove(item);
                        } else {
                            this.lb.add(item);
                        }
                        c cVar = this.kb;
                        if (cVar != null) {
                            cVar.a(this.lb, item);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private float getScaledPPM() {
        UniformTimelineLayoutManager uniformTimelineLayoutManager = getUniformTimelineLayoutManager();
        if (uniformTimelineLayoutManager == null) {
            return 0.0f;
        }
        return uniformTimelineLayoutManager.f();
    }

    private int getSelectedTimelineInt() {
        NexTimelineItem selectedItem = getSelectedItem();
        if (selectedItem == null) {
            return 0;
        }
        if (selectedItem instanceof NexPrimaryTimelineItem) {
            return 1;
        }
        return selectedItem instanceof NexSecondaryTimelineItem ? 2 : 0;
    }

    private UniformTimelineLayoutManager getUniformTimelineLayoutManager() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof UniformTimelineLayoutManager) {
            return (UniformTimelineLayoutManager) layoutManager;
        }
        return null;
    }

    public void I() {
        this.wb = Integer.MIN_VALUE;
        this.xb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        Y();
    }

    public boolean J() {
        return this.yb && this.ob == R.id.editmode_multi_select;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public Rect a(NexTimelineItem nexTimelineItem) {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void a(NexTimelineItem nexTimelineItem, TimelineView.AnimType animType, int i) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void a(boolean z, Context context) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public boolean a() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.widget.RecyclerView
    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration, int i) {
        if (itemDecoration instanceof a) {
            a((a) itemDecoration);
        }
        super.addItemDecoration(itemDecoration, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.lb.isEmpty()) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.save();
        super.dispatchDraw(canvas);
        canvas.restore();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Fa item = ((T) getAdapter()).getItem(getChildAdapterPosition(childAt));
            if (this.lb.contains(item)) {
                childAt.getHitRect(this.ib);
                a(canvas, childAt, this.ib, item);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        b(canvas);
        d(canvas);
        e(canvas);
        a(canvas);
        c(canvas);
        List<a> list = this.zb;
        if (list != null) {
            for (a aVar : list) {
                if (aVar != null) {
                    aVar.onDrawForeground(canvas);
                }
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void e() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void f() {
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean fling(int i, int i2) {
        UniformTimelineLayoutManager uniformTimelineLayoutManager = getUniformTimelineLayoutManager();
        return (uniformTimelineLayoutManager == null || !uniformTimelineLayoutManager.j()) && super.fling(i, i2);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public int g() {
        return 0;
    }

    public void g(int i, int i2) {
        super.scrollBy(i, i2);
        d(getCurrentTime(), true);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f, com.nextreaming.nexeditorui.NexTimelineItem.w
    public int getCurrentTime() {
        UniformTimelineLayoutManager uniformTimelineLayoutManager = getUniformTimelineLayoutManager();
        if (uniformTimelineLayoutManager == null) {
            return 0;
        }
        int width = (int) ((uniformTimelineLayoutManager.t + (getWidth() / 2)) / uniformTimelineLayoutManager.f());
        NexTimeline nexTimeline = this.La;
        int timeFromFrame = nexTimeline.getTimeFromFrame(nexTimeline.getFrameFromTime(width));
        if (timeFromFrame > getMaxScrollTime()) {
            timeFromFrame = getMaxScrollTime();
        }
        if (timeFromFrame < 0) {
            return 0;
        }
        return timeFromFrame;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public int getCurrentTimeAndStopFling() {
        stopScroll();
        return getCurrentTime();
    }

    public int getEditingMode() {
        return this.ob;
    }

    public c.e.a.a.f getImageWorker() {
        return this.pb;
    }

    public int getInsertIndexForPrimaryItemAtTime() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public int getMSPerPixel() {
        return (int) (1.0f / getScaledPPM());
    }

    public int getMaxScrollTime() {
        return Math.max(getTimeline().getTotalSecondaryTime(), getTimeline().getTotalTime());
    }

    public MediaPrepManager getMediaPrepManager() {
        return this.Db;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public NexTimelineItem getOldSelectedItem() {
        return this.nb;
    }

    public float getPixelsPerSecond() {
        return 0.0f;
    }

    public PurchaseType getPurchaseType() {
        return this.qb;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public int getSelectedIndex() {
        NexTimelineItem selectedItem = getSelectedItem();
        if (selectedItem == null) {
            return -1;
        }
        if (selectedItem instanceof NexPrimaryTimelineItem) {
            return getTimeline().getIndexOfPrimaryItem((NexPrimaryTimelineItem) selectedItem);
        }
        if (selectedItem instanceof NexSecondaryTimelineItem) {
            return getTimeline().getIndexOfSecondaryItem((NexSecondaryTimelineItem) selectedItem);
        }
        return -1;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public NexTimelineItem getSelectedItem() {
        if (J()) {
            return null;
        }
        Iterator<Fa> it = this.lb.iterator();
        if (it.hasNext()) {
            Fa next = it.next();
            if (!it.hasNext() && (next instanceof NexTimelineItem)) {
                return (NexTimelineItem) next;
            }
        }
        return null;
    }

    public Set<Fa> getSelectedItems() {
        if (this.mb == null) {
            this.mb = Collections.unmodifiableSet(this.lb);
        }
        return this.mb;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public WhichTimeline getSelectedTimeline() {
        if (getSelectedTimelineInt() == 0 || getSelectedIndex() == -1) {
            return null;
        }
        return getSelectedTimelineInt() == 1 ? WhichTimeline.PRIMARY : WhichTimeline.SECONDARY;
    }

    public Ea getSelectedTrack() {
        for (Fa fa : this.lb) {
            if (fa instanceof Ea) {
                return (Ea) fa;
            }
        }
        return null;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f, com.nextreaming.nexeditorui.NexTimelineItem.w
    public NexTimeline getTimeline() {
        if (this.La == null) {
            this.La = new NexTimeline();
            aa();
        }
        return this.La;
    }

    public VideoEditor getVideoEditor() {
        return this.rb;
    }

    public void h(int i, int i2) {
        super.smoothScrollBy(i, i2);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public boolean h() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void i() {
        this.sb = false;
        invalidate();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public boolean j() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public boolean k() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void l() {
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        TimelineView.d dVar;
        super.onScrollStateChanged(i);
        if (i == 0) {
            if (this.gb) {
                this.gb = false;
                TimelineView.d dVar2 = this.fb;
                if (dVar2 != null) {
                    dVar2.a(this.hb, true);
                    return;
                }
                return;
            }
            return;
        }
        if (!this.Ab || this.sb || !getVideoEditor().w().isPlaying() || (dVar = this.fb) == null) {
            return;
        }
        dVar.c();
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        super.onScrolled(i, i2);
        d(getCurrentTime(), false);
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        UniformTimelineLayoutManager uniformTimelineLayoutManager = getUniformTimelineLayoutManager();
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            this.Ab = true;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.Ab = false;
        }
        if (uniformTimelineLayoutManager != null) {
            uniformTimelineLayoutManager.ca = this.Ab;
        }
        boolean z2 = this.Ua || this.Va;
        boolean onTouchEvent = this.Ta.onTouchEvent(motionEvent);
        boolean z3 = this.Ua;
        if (!z3 && !(z = this.Va)) {
            if (actionMasked == 0) {
                this.Ma = motionEvent.getPointerId(0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.Pa = x;
                this.Na = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.Qa = y;
                this.Oa = y;
                this.Sa = false;
                this.Ra = false;
                this.Cb = false;
            } else if (actionMasked == 1) {
                if (!this.Cb && !this.Ra && !this.Sa && !z3 && !z) {
                    if (e(motionEvent)) {
                        invalidate();
                    } else if (d(motionEvent)) {
                        onTouchEvent = true;
                    }
                }
                this.Cb = false;
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.Ma);
                if (findPointerIndex >= 0) {
                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    int i = this.Pa - x2;
                    int i2 = this.Qa - y2;
                    if (!this.Ra && !this.Sa) {
                        if (Math.abs(i) > this.Ia) {
                            this.Ra = true;
                        } else if (Math.abs(i2) > this.Ia) {
                            this.Sa = true;
                        }
                    }
                }
            } else if (actionMasked == 5) {
                this.Ma = motionEvent.getPointerId(actionIndex);
                int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.Pa = x3;
                this.Na = x3;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.Qa = y3;
                this.Oa = y3;
            }
            if (uniformTimelineLayoutManager != null) {
                uniformTimelineLayoutManager.J = this.Ra;
                uniformTimelineLayoutManager.K = this.Sa;
                uniformTimelineLayoutManager.T = true;
            }
            boolean z4 = super.onTouchEvent(motionEvent) || onTouchEvent;
            if (uniformTimelineLayoutManager != null) {
                uniformTimelineLayoutManager.T = false;
            }
            if (getSelectedItem() == null && motionEvent.getAction() == 1 && !this.Ra && !this.Sa && !this.Ua && !this.Va) {
                float f2 = getResources().getDisplayMetrics().density * 25.0f;
                if (motionEvent.getY() < f2) {
                    int x4 = (int) ((motionEvent.getX() + uniformTimelineLayoutManager.t) / uniformTimelineLayoutManager.f());
                    int[] bookmarks = this.La.getBookmarks();
                    int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    int i4 = 0;
                    for (int i5 : bookmarks) {
                        int abs = Math.abs(x4 - i5);
                        if (abs < i3) {
                            i4 = i5;
                            i3 = abs;
                        }
                    }
                    if (i3 < f2 / uniformTimelineLayoutManager.f()) {
                        TimelineView.d dVar = this.fb;
                        if (dVar != null) {
                            dVar.a(i4, true);
                        }
                        a(i4, true);
                    }
                }
            }
            return z4;
        }
        if (!z2) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            super.onTouchEvent(obtain);
        }
        if (motionEvent.getActionMasked() == 1) {
            this.Va = false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.widget.RecyclerView
    public void removeItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        if (itemDecoration instanceof a) {
            b((a) itemDecoration);
        }
        super.removeItemDecoration(itemDecoration);
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public void scrollBy(int i, int i2) {
        this.Bb = true;
        g(i, i2);
        d(getCurrentTime(), true);
        this.Bb = false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setEditingMode(int i) {
        this.ob = i;
        a(getSelectedItems());
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setEditor(VideoEditor videoEditor) {
        this.rb = videoEditor;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setExpanded(boolean z) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setExpandingAnimation(boolean z) {
    }

    public void setIgnoreTouchEvent(boolean z) {
        this.Cb = z;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setImageWorker(FragmentManager fragmentManager) {
        if (fragmentManager == null || this.pb != null) {
            return;
        }
        this.pb = new W(this, getContext());
        this.pb.a(fragmentManager, new d.a(getContext(), "TIMELINE_ITEM_THUMB_CACHE"));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setListener(TimelineView.d dVar) {
        this.fb = dVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setMediaPrepManager(MediaPrepManager mediaPrepManager) {
        this.Db = mediaPrepManager;
    }

    public void setMulitSelectListener(c cVar) {
        this.kb = cVar;
    }

    public void setOnItemClickListener(b bVar) {
        this.jb = bVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setOnTimelineScrollListener(TimelineView.f fVar) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setPlaying(boolean z) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setPurchaseType(PurchaseType purchaseType) {
        this.qb = purchaseType;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setSelectedItem(NexTimelineItem nexTimelineItem) {
        setSelectedItem((Fa) nexTimelineItem);
        if (nexTimelineItem == null) {
            I();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setSuppressScrollEvents(boolean z) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void setTimeline(NexTimeline nexTimeline) {
        if (nexTimeline == this.La) {
            return;
        }
        if (nexTimeline == null) {
            nexTimeline = new NexTimeline();
        }
        this.La = nexTimeline;
        aa();
    }

    public void setTimelineExpanded(boolean z) {
        this.yb = z;
    }

    public void setTimelineGuideVisibility(boolean z) {
        TimelineView.d dVar = this.fb;
        if (dVar != null) {
            dVar.c(z);
        }
    }

    @Override // android.support.v7.widget.RecyclerView
    public void smoothScrollBy(int i, int i2) {
        this.Bb = true;
        h(i, i2);
        this.Bb = false;
    }

    public UniformTimelineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Canvas canvas) {
        int[] bookmarks = this.La.getBookmarks();
        Math.max(1, getMSPerPixel() * 15);
        if (getUniformTimelineLayoutManager() != null) {
            UniformTimelineLayoutManager uniformTimelineLayoutManager = getUniformTimelineLayoutManager();
            float f2 = uniformTimelineLayoutManager.f();
            int floor = (int) Math.floor(uniformTimelineLayoutManager.t / f2);
            int ceil = (int) Math.ceil(((uniformTimelineLayoutManager.t + getWidth()) - 1.0f) / f2);
            Drawable drawable = null;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 : bookmarks) {
                if (i4 >= floor && i4 < ceil) {
                    int i5 = (int) ((i4 * f2) - uniformTimelineLayoutManager.t);
                    if (drawable == null) {
                        drawable = getResources().getDrawable(R.drawable.timeline_bookmark);
                        i = (-drawable.getIntrinsicWidth()) / 2;
                        i2 = drawable.getIntrinsicWidth() + i;
                        getResources().getDimensionPixelOffset(R.dimen.timeline3_bookmarkTopMargin);
                        i3 = this.Ya + 0;
                    }
                    drawable.setBounds(i5 + i, 0, i5 + i2, i3);
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void b(int i, int i2, boolean z) {
        this.wb = i;
        this.xb = i2;
        Y();
        int currentTime = getCurrentTime();
        if (currentTime < i) {
            a(i, z);
        } else if (currentTime > i2) {
            a(i2, z);
        }
    }

    public UniformTimelineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ma = -1;
        this.Ua = false;
        this.Va = false;
        this.eb = new RectF();
        this.hb = Integer.MIN_VALUE;
        this.ib = new Rect();
        this.lb = new HashSet();
        this.ob = 0;
        this.wb = Integer.MIN_VALUE;
        this.xb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.yb = false;
        this.Ab = false;
        this.Bb = false;
        this.Eb = new C1803a();
        this.Fb = new V(this);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        Resources resources = context.getResources();
        this.Ia = viewConfiguration.getScaledTouchSlop();
        this.Ta = new ScaleGestureDetector(context, this.Fb);
        this.Wa = resources.getDimensionPixelSize(R.dimen.timeline_min_tick_spacing);
        this.Xa = resources.getDimensionPixelSize(R.dimen.timeline_min_second_tick_spacing);
        this.Ka = resources.getDimensionPixelSize(R.dimen.timeline_min_number_spacing);
        this.Za = new Paint();
        this.Za.setColor(resources.getColor(R.color.timeline_scale_marks));
        this.bb = new Paint();
        this.bb.setColor(resources.getColor(R.color.timeline_scale_marks));
        this.bb.setAntiAlias(true);
        this._a = new Paint();
        this._a.setColor(resources.getColor(R.color.timeline_bg_color));
        this.ab = new Paint();
        this.ab.setTextAlign(Paint.Align.CENTER);
        this.ab.setTextSize(getResources().getDimensionPixelSize(R.dimen.timeline3_ctsTextSize));
        this.ab.setTypeface(Typeface.DEFAULT);
        this.ab.setAntiAlias(true);
        this.ab.setColor(-1);
        this.cb = new Paint();
        this.cb.setColor(resources.getColor(R.color.timeline_scale_numbers));
        this.cb.setAntiAlias(true);
        this.cb.setTextAlign(Paint.Align.CENTER);
        this.cb.setTextSize(resources.getDimensionPixelSize(R.dimen.timeline_text_size_second));
        this.db = new Paint();
        this.db.setColor(InputDeviceCompat.SOURCE_ANY);
        this.db.setStyle(Paint.Style.STROKE);
        this.db.setStrokeWidth(3.0f);
        this.Ya = resources.getDimensionPixelSize(R.dimen.timeline3_timescale_height);
        this.Ja = resources.getDimensionPixelSize(R.dimen.timeline_mark_size_second);
        this.vb = new Paint();
        this.vb.setColor(getResources().getColor(R.color.timeline_recording_color));
        setItemAnimator(null);
        setHasFixedSize(true);
    }

    public static UniformTimelineView g(View view) {
        if (view instanceof UniformTimelineView) {
            return (UniformTimelineView) view;
        }
        if (view.getParent() instanceof ViewGroup) {
            return g((View) view.getParent());
        }
        return null;
    }

    public void setSelectedItem(Fa fa) {
        if (fa == null) {
            d();
            return;
        }
        if (fa instanceof M) {
            fa = ((M) fa).a();
        }
        if (this.lb.contains(fa) && this.lb.size() == 1) {
            return;
        }
        Iterator<Fa> it = this.lb.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        if (!J()) {
            this.lb.clear();
        }
        this.lb.add(fa);
        if (fa instanceof Ea) {
            Ea ea = (Ea) fa;
            this.lb.add(M.a(ea));
            a(M.a(ea));
        }
        if (fa instanceof NexTimelineItem) {
            this.nb = (NexTimelineItem) fa;
        }
        invalidate();
        Z();
    }

    private void b(Canvas canvas) {
        if (J() && getAdapter() != null) {
            Drawable drawable = getResources().getDrawable(R.drawable.checkbox_clip_normal);
            Drawable drawable2 = getResources().getDrawable(R.drawable.checkbox_clip_focus);
            int applyDimension = (int) TypedValue.applyDimension(1, 8.0f, getContext().getResources().getDisplayMetrics());
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                Fa item = ((T) getAdapter()).getItem(getChildAdapterPosition(childAt));
                if ((item instanceof NexTimelineItem) && !(item instanceof NexTransitionItem)) {
                    Rect rect = new Rect();
                    childAt.getHitRect(rect);
                    int i2 = rect.left + applyDimension;
                    int intrinsicWidth = drawable.getIntrinsicWidth() + i2;
                    int height = rect.top + ((rect.height() / 2) - (drawable.getIntrinsicHeight() / 2));
                    int intrinsicHeight = drawable.getIntrinsicHeight() + height;
                    canvas.save();
                    UniformTimelineLayoutManager uniformTimelineLayoutManager = getUniformTimelineLayoutManager();
                    if ((item instanceof NexSecondaryTimelineItem) && uniformTimelineLayoutManager != null) {
                        canvas.clipRect(uniformTimelineLayoutManager.H, uniformTimelineLayoutManager.E + uniformTimelineLayoutManager.U, canvas.getWidth(), canvas.getHeight());
                    } else if ((item instanceof NexPrimaryTimelineItem) && uniformTimelineLayoutManager != null) {
                        canvas.clipRect(uniformTimelineLayoutManager.H, uniformTimelineLayoutManager.E, canvas.getWidth(), canvas.getHeight());
                    }
                    if (this.lb.contains(item)) {
                        drawable2.setBounds(i2, height, intrinsicWidth, intrinsicHeight);
                        drawable2.draw(canvas);
                    } else {
                        drawable.setBounds(i2, height, intrinsicWidth, intrinsicHeight);
                        drawable.draw(canvas);
                    }
                    canvas.restore();
                }
            }
        }
    }

    private boolean c(NexTimelineItem nexTimelineItem) {
        return (nexTimelineItem instanceof NexAudioClipItem) && ((NexAudioClipItem) nexTimelineItem).getIsVoiceRecording();
    }

    public void c(int i, boolean z) {
        int round = Math.round((i - getCurrentTime()) * getScaledPPM());
        if (z) {
            h(round, 0);
        } else {
            g(round, 0);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public int c() {
        return d(getCurrentTime());
    }

    private void a(Canvas canvas, View view, Rect rect, Fa fa) {
        UniformTimelineLayoutManager uniformTimelineLayoutManager;
        if (J()) {
            return;
        }
        if (fa instanceof Ea) {
            canvas.save();
            UniformTimelineLayoutManager uniformTimelineLayoutManager2 = getUniformTimelineLayoutManager();
            if (uniformTimelineLayoutManager2 != null) {
                canvas.clipRect(0, uniformTimelineLayoutManager2.E + uniformTimelineLayoutManager2.U, canvas.getWidth(), canvas.getHeight());
            }
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.track_select);
            drawable.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            drawable.draw(canvas);
            canvas.restore();
            return;
        }
        if (fa instanceof NexTransitionItem) {
            return;
        }
        if (fa instanceof NexTimelineItem) {
            if (getEditingMode() == R.id.editmode_trim) {
                return;
            }
            canvas.save();
            if ((fa instanceof NexSecondaryTimelineItem) && (uniformTimelineLayoutManager = getUniformTimelineLayoutManager()) != null) {
                canvas.clipRect(uniformTimelineLayoutManager.H, uniformTimelineLayoutManager.E + uniformTimelineLayoutManager.U, canvas.getWidth(), canvas.getHeight());
            }
            Drawable drawable2 = getContext().getResources().getDrawable(R.drawable.timeline_item_border_sel_v5);
            drawable2.setBounds(rect.left - 1, rect.top - 1, rect.right + 1, rect.bottom + 1);
            drawable2.draw(canvas);
            canvas.restore();
            return;
        }
        if (!(fa instanceof M)) {
            throw new IllegalStateException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineView.d(android.graphics.Canvas):void");
    }

    private void e(Canvas canvas) {
        Drawable drawable = getResources().getDrawable(R.drawable.timeline_total_time_bg);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.timeline3_ctsBoxWidth);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.timeline3_ctsBoxHeight);
        int width = (getWidth() - dimensionPixelOffset) - ((int) TypedValue.applyDimension(1, 2.0f, getContext().getResources().getDisplayMetrics()));
        drawable.setBounds(width, 0, width + dimensionPixelOffset, dimensionPixelOffset2);
        drawable.draw(canvas);
        canvas.drawText(c.d.b.m.o.a(getTimeline().getTotalTime()), width + (dimensionPixelOffset / 2), dimensionPixelOffset2 - ((int) (getContext().getResources().getDisplayMetrics().density * 4.0f)), this.ab);
    }

    public boolean b(Fa fa) {
        Ea track;
        return !(fa instanceof NexSecondaryTimelineItem) || (track = ((NexSecondaryTimelineItem) fa).getTrack()) == null || track.m();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public int b(NexTimelineItem nexTimelineItem, boolean z) {
        if (nexTimelineItem == null) {
            return 0;
        }
        getUniformTimelineLayoutManager().scrollToPosition(((T) getAdapter()).a(nexTimelineItem));
        int currentTime = getCurrentTime();
        nexTimelineItem.postNotification();
        b(nexTimelineItem);
        return currentTime;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void a(NexTimelineItem nexTimelineItem, boolean z, boolean z2) {
        if (nexTimelineItem == null) {
            return;
        }
        b(nexTimelineItem, z);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void a(NexTimelineItem nexTimelineItem, boolean z) {
        if (nexTimelineItem == null) {
            return;
        }
        b(nexTimelineItem, z);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f, com.nextreaming.nexeditorui.NexTimelineItem.w
    public void a(int i) {
        a(i, false);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f, com.nextreaming.nexeditorui.NexTimelineItem.w
    public void a(int i, boolean z) {
        int round = Math.round((i - getCurrentTime()) * getScaledPPM());
        if (z) {
            smoothScrollBy(round, 0);
        } else {
            scrollBy(round, 0);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void b(NexTimelineItem nexTimelineItem) {
        a((Fa) nexTimelineItem);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void b() {
        RecyclerView.Adapter adapter;
        if (isComputingLayout() || (adapter = getAdapter()) == null || !(adapter instanceof T)) {
            return;
        }
        adapter.notifyDataSetChanged();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f, com.nextreaming.nexeditorui.NexTimelineItem.w
    public int a(boolean z) {
        if (getScrollState() != 0) {
            z = true;
        }
        return b(getSelectedItem(), z);
    }

    public void b(a aVar) {
        List<a> list = this.zb;
        if (list != null) {
            list.remove(aVar);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void a(int i, int i2, int i3) {
        this.sb = true;
        this.tb = i;
        this.ub = i2;
        invalidate();
    }

    public void a(Fa fa) {
        RecyclerView.Adapter adapter;
        if (isComputingLayout() || (adapter = getAdapter()) == null || !(adapter instanceof T)) {
            return;
        }
        int itemCount = adapter.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (fa == ((T) adapter).getItem(i)) {
                adapter.notifyItemChanged(i);
            }
        }
    }

    public void a(Set<Fa> set) {
        RecyclerView.Adapter adapter;
        if (isComputingLayout() || set == null || (adapter = getAdapter()) == null || !(adapter instanceof T)) {
            return;
        }
        int itemCount = adapter.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (set.contains(((T) adapter).getItem(i))) {
                adapter.notifyItemChanged(i);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f
    public void d() {
        if (this.lb.isEmpty()) {
            return;
        }
        Iterator<Fa> it = this.lb.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.lb.clear();
        Z();
        invalidate();
    }

    public void a(a aVar) {
        if (this.zb == null) {
            this.zb = new ArrayList();
        }
        this.zb.add(aVar);
    }

    public int d(int i) {
        int primaryItemCount = this.La.getPrimaryItemCount();
        int i2 = 0;
        for (int i3 = 0; i3 < primaryItemCount; i3++) {
            int representedDuration = this.La.getPrimaryItem(i3).getRepresentedDuration();
            if (i < (representedDuration / 2) + i2) {
                return i3;
            }
            i2 += representedDuration;
        }
        return primaryItemCount;
    }

    private void d(int i, boolean z) {
        TimelineView.d dVar;
        if (this.Bb || (dVar = this.fb) == null || this.hb == i) {
            return;
        }
        this.hb = i;
        dVar.a(getCurrentTime(), z);
        this.gb = !z;
    }
}
