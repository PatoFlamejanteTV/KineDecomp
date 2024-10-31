package android.support.design.widget;

import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.math.MathUtils;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: BottomSheetBehavior.java */
/* renamed from: android.support.design.widget.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0183i extends ViewDragHelper.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BottomSheetBehavior f473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0183i(BottomSheetBehavior bottomSheetBehavior) {
        this.f473a = bottomSheetBehavior;
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public int clampViewPositionHorizontal(View view, int i, int i2) {
        return view.getLeft();
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public int clampViewPositionVertical(View view, int i, int i2) {
        BottomSheetBehavior bottomSheetBehavior = this.f473a;
        return MathUtils.clamp(i, bottomSheetBehavior.f330e, bottomSheetBehavior.f332g ? bottomSheetBehavior.n : bottomSheetBehavior.f331f);
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public int getViewVerticalDragRange(View view) {
        int i;
        int i2;
        BottomSheetBehavior bottomSheetBehavior = this.f473a;
        if (bottomSheetBehavior.f332g) {
            i = bottomSheetBehavior.n;
            i2 = bottomSheetBehavior.f330e;
        } else {
            i = bottomSheetBehavior.f331f;
            i2 = bottomSheetBehavior.f330e;
        }
        return i - i2;
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public void onViewDragStateChanged(int i) {
        if (i == 1) {
            this.f473a.c(1);
        }
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        this.f473a.a(i2);
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public void onViewReleased(View view, float f2, float f3) {
        int i;
        int i2;
        int i3 = 3;
        if (f3 < 0.0f) {
            i2 = this.f473a.f330e;
        } else {
            BottomSheetBehavior bottomSheetBehavior = this.f473a;
            if (bottomSheetBehavior.f332g && bottomSheetBehavior.a(view, f3)) {
                i2 = this.f473a.n;
                i3 = 5;
            } else {
                if (f3 == 0.0f) {
                    int top = view.getTop();
                    if (Math.abs(top - this.f473a.f330e) < Math.abs(top - this.f473a.f331f)) {
                        i2 = this.f473a.f330e;
                    } else {
                        i = this.f473a.f331f;
                    }
                } else {
                    i = this.f473a.f331f;
                }
                i2 = i;
                i3 = 4;
            }
        }
        if (this.f473a.j.settleCapturedViewAt(view.getLeft(), i2)) {
            this.f473a.c(2);
            ViewCompat.postOnAnimation(view, new BottomSheetBehavior.c(view, i3));
        } else {
            this.f473a.c(i3);
        }
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public boolean tryCaptureView(View view, int i) {
        WeakReference<V> weakReference;
        View view2;
        BottomSheetBehavior bottomSheetBehavior = this.f473a;
        int i2 = bottomSheetBehavior.i;
        if (i2 == 1 || bottomSheetBehavior.u) {
            return false;
        }
        return ((i2 == 3 && bottomSheetBehavior.s == i && (view2 = bottomSheetBehavior.p.get()) != null && view2.canScrollVertically(-1)) || (weakReference = this.f473a.o) == 0 || weakReference.get() != view) ? false : true;
    }
}
