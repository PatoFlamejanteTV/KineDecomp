package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.math.MathUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* compiled from: HeaderScrollingViewBehavior.java */
/* loaded from: classes.dex */
abstract class x extends P<View> {

    /* renamed from: d, reason: collision with root package name */
    final Rect f519d;

    /* renamed from: e, reason: collision with root package name */
    final Rect f520e;

    /* renamed from: f, reason: collision with root package name */
    private int f521f;

    /* renamed from: g, reason: collision with root package name */
    private int f522g;

    public x() {
        this.f519d = new Rect();
        this.f520e = new Rect();
        this.f521f = 0;
    }

    private static int c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    abstract View a(List<View> list);

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View a2;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (a2 = a(coordinatorLayout.b(view))) == null) {
            return false;
        }
        if (ViewCompat.getFitsSystemWindows(a2) && !ViewCompat.getFitsSystemWindows(view)) {
            ViewCompat.setFitsSystemWindows(view, true);
            if (ViewCompat.getFitsSystemWindows(view)) {
                view.requestLayout();
                return true;
            }
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.a(view, i, i2, View.MeasureSpec.makeMeasureSpec((size - a2.getMeasuredHeight()) + c(a2), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    abstract float b(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.design.widget.P
    public void b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View a2 = a(coordinatorLayout.b(view));
        if (a2 != null) {
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) view.getLayoutParams();
            Rect rect = this.f519d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, a2.getBottom() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((coordinatorLayout.getHeight() + a2.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.f520e;
            GravityCompat.apply(c(eVar.f354c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int a3 = a(a2);
            view.layout(rect2.left, rect2.top - a3, rect2.right, rect2.bottom - a3);
            this.f521f = rect2.top - a2.getBottom();
            return;
        }
        super.b(coordinatorLayout, (CoordinatorLayout) view, i);
        this.f521f = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int d() {
        return this.f521f;
    }

    public final int c() {
        return this.f522g;
    }

    public x(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f519d = new Rect();
        this.f520e = new Rect();
        this.f521f = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(View view) {
        if (this.f522g == 0) {
            return 0;
        }
        float b2 = b(view);
        int i = this.f522g;
        return MathUtils.clamp((int) (b2 * i), 0, i);
    }

    public final void b(int i) {
        this.f522g = i;
    }
}
