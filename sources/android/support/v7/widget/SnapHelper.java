package android.support.v7.widget;

import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

/* loaded from: classes.dex */
public abstract class SnapHelper extends RecyclerView.OnFlingListener {

    /* renamed from: a, reason: collision with root package name */
    RecyclerView f3052a;

    /* renamed from: b, reason: collision with root package name */
    private Scroller f3053b;

    /* renamed from: c, reason: collision with root package name */
    private final RecyclerView.OnScrollListener f3054c = new RecyclerView.OnScrollListener() { // from class: android.support.v7.widget.SnapHelper.1

        /* renamed from: a, reason: collision with root package name */
        boolean f3055a = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.f3055a) {
                this.f3055a = false;
                SnapHelper.this.a();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.f3055a = true;
        }
    };

    private boolean a(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        RecyclerView.SmoothScroller a2;
        int findTargetSnapPosition;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (a2 = a(layoutManager)) == null || (findTargetSnapPosition = findTargetSnapPosition(layoutManager, i, i2)) == -1) {
            return false;
        }
        a2.setTargetPosition(findTargetSnapPosition);
        layoutManager.startSmoothScroll(a2);
        return true;
    }

    private void b() {
        this.f3052a.removeOnScrollListener(this.f3054c);
        this.f3052a.setOnFlingListener(null);
    }

    private void c() throws IllegalStateException {
        if (this.f3052a.getOnFlingListener() == null) {
            this.f3052a.addOnScrollListener(this.f3054c);
            this.f3052a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f3052a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            b();
        }
        this.f3052a = recyclerView;
        if (this.f3052a != null) {
            c();
            this.f3053b = new Scroller(this.f3052a.getContext(), new DecelerateInterpolator());
            a();
        }
    }

    public abstract int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view);

    public int[] calculateScrollDistance(int i, int i2) {
        this.f3053b.fling(0, 0, i, i2, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        return new int[]{this.f3053b.getFinalX(), this.f3053b.getFinalY()};
    }

    public abstract View findSnapView(RecyclerView.LayoutManager layoutManager);

    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2);

    @Override // android.support.v7.widget.RecyclerView.OnFlingListener
    public boolean onFling(int i, int i2) {
        RecyclerView.LayoutManager layoutManager = this.f3052a.getLayoutManager();
        if (layoutManager == null || this.f3052a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f3052a.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && a(layoutManager, i, i2);
    }

    @Deprecated
    protected LinearSmoothScroller b(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.f3052a.getContext()) { // from class: android.support.v7.widget.SnapHelper.2
                @Override // android.support.v7.widget.LinearSmoothScroller, android.support.v7.widget.RecyclerView.SmoothScroller
                protected void a(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    SnapHelper snapHelper = SnapHelper.this;
                    RecyclerView recyclerView = snapHelper.f3052a;
                    if (recyclerView == null) {
                        return;
                    }
                    int[] calculateDistanceToFinalSnap = snapHelper.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
                    int i = calculateDistanceToFinalSnap[0];
                    int i2 = calculateDistanceToFinalSnap[1];
                    int a2 = a(Math.max(Math.abs(i), Math.abs(i2)));
                    if (a2 > 0) {
                        action.update(i, i2, a2, this.i);
                    }
                }

                @Override // android.support.v7.widget.LinearSmoothScroller
                protected float a(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }

    void a() {
        RecyclerView.LayoutManager layoutManager;
        View findSnapView;
        RecyclerView recyclerView = this.f3052a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (findSnapView = findSnapView(layoutManager)) == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
        if (calculateDistanceToFinalSnap[0] == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.f3052a.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
    }

    protected RecyclerView.SmoothScroller a(RecyclerView.LayoutManager layoutManager) {
        return b(layoutManager);
    }
}
