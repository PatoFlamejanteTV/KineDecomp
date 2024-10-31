package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
/* loaded from: classes.dex */
public final class ScrollerCompat {

    /* renamed from: a */
    OverScroller f2016a;

    ScrollerCompat(Context context, Interpolator interpolator) {
        this.f2016a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public static ScrollerCompat create(Context context) {
        return create(context, null);
    }

    @Deprecated
    public void abortAnimation() {
        this.f2016a.abortAnimation();
    }

    @Deprecated
    public boolean computeScrollOffset() {
        return this.f2016a.computeScrollOffset();
    }

    @Deprecated
    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f2016a.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    @Deprecated
    public float getCurrVelocity() {
        return this.f2016a.getCurrVelocity();
    }

    @Deprecated
    public int getCurrX() {
        return this.f2016a.getCurrX();
    }

    @Deprecated
    public int getCurrY() {
        return this.f2016a.getCurrY();
    }

    @Deprecated
    public int getFinalX() {
        return this.f2016a.getFinalX();
    }

    @Deprecated
    public int getFinalY() {
        return this.f2016a.getFinalY();
    }

    @Deprecated
    public boolean isFinished() {
        return this.f2016a.isFinished();
    }

    @Deprecated
    public boolean isOverScrolled() {
        return this.f2016a.isOverScrolled();
    }

    @Deprecated
    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.f2016a.notifyHorizontalEdgeReached(i, i2, i3);
    }

    @Deprecated
    public void notifyVerticalEdgeReached(int i, int i2, int i3) {
        this.f2016a.notifyVerticalEdgeReached(i, i2, i3);
    }

    @Deprecated
    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f2016a.springBack(i, i2, i3, i4, i5, i6);
    }

    @Deprecated
    public void startScroll(int i, int i2, int i3, int i4) {
        this.f2016a.startScroll(i, i2, i3, i4);
    }

    @Deprecated
    public static ScrollerCompat create(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    @Deprecated
    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f2016a.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    @Deprecated
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.f2016a.startScroll(i, i2, i3, i4, i5);
    }
}
