package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import io.fabric.sdk.android.services.common.a;

/* loaded from: classes.dex */
public class LinearSmoothScroller extends RecyclerView.SmoothScroller {
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    protected PointF j;
    private final float k;

    /* renamed from: h, reason: collision with root package name */
    protected final LinearInterpolator f2839h = new LinearInterpolator();
    protected final DecelerateInterpolator i = new DecelerateInterpolator();
    protected int l = 0;
    protected int m = 0;

    public LinearSmoothScroller(Context context) {
        this.k = a(context.getResources().getDisplayMetrics());
    }

    private int b(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller
    protected void a() {
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller
    protected void a(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        int calculateDxToMakeVisible = calculateDxToMakeVisible(view, d());
        int calculateDyToMakeVisible = calculateDyToMakeVisible(view, e());
        int a2 = a((int) Math.sqrt((calculateDxToMakeVisible * calculateDxToMakeVisible) + (calculateDyToMakeVisible * calculateDyToMakeVisible)));
        if (a2 > 0) {
            action.update(-calculateDxToMakeVisible, -calculateDyToMakeVisible, a2, this.i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller
    protected void b() {
        this.m = 0;
        this.l = 0;
        this.j = null;
    }

    public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public int calculateDxToMakeVisible(View view, int i) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return calculateDtToFit(layoutManager.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, layoutManager.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i);
    }

    public int calculateDyToMakeVisible(View view, int i) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return calculateDtToFit(layoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i);
    }

    public PointF computeScrollVectorForPosition(int i) {
        Object layoutManager = getLayoutManager();
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i);
        }
        Log.w("LinearSmoothScroller", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + RecyclerView.SmoothScroller.ScrollVectorProvider.class.getCanonicalName());
        return null;
    }

    protected int d() {
        PointF pointF = this.j;
        if (pointF != null) {
            float f2 = pointF.x;
            if (f2 != 0.0f) {
                return f2 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    protected int e() {
        PointF pointF = this.j;
        if (pointF != null) {
            float f2 = pointF.y;
            if (f2 != 0.0f) {
                return f2 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(int i) {
        return (int) Math.ceil(Math.abs(i) * this.k);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller
    protected void a(int i, int i2, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        if (getChildCount() == 0) {
            c();
            return;
        }
        this.l = b(this.l, i);
        this.m = b(this.m, i2);
        if (this.l == 0 && this.m == 0) {
            a(action);
        }
    }

    protected float a(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i) {
        double b2 = b(i);
        Double.isNaN(b2);
        return (int) Math.ceil(b2 / 0.3356d);
    }

    protected void a(RecyclerView.SmoothScroller.Action action) {
        PointF computeScrollVectorForPosition = computeScrollVectorForPosition(getTargetPosition());
        if (computeScrollVectorForPosition != null && (computeScrollVectorForPosition.x != 0.0f || computeScrollVectorForPosition.y != 0.0f)) {
            a(computeScrollVectorForPosition);
            this.j = computeScrollVectorForPosition;
            this.l = (int) (computeScrollVectorForPosition.x * 10000.0f);
            this.m = (int) (computeScrollVectorForPosition.y * 10000.0f);
            action.update((int) (this.l * 1.2f), (int) (this.m * 1.2f), (int) (b(a.DEFAULT_TIMEOUT) * 1.2f), this.f2839h);
            return;
        }
        action.jumpTo(getTargetPosition());
        c();
    }
}
