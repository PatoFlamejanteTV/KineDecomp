package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public class NestedScrollingChildHelper {

    /* renamed from: a */
    private ViewParent f1804a;

    /* renamed from: b */
    private ViewParent f1805b;

    /* renamed from: c */
    private final View f1806c;

    /* renamed from: d */
    private boolean f1807d;

    /* renamed from: e */
    private int[] f1808e;

    public NestedScrollingChildHelper(View view) {
        this.f1806c = view;
    }

    private ViewParent a(int i) {
        if (i == 0) {
            return this.f1804a;
        }
        if (i != 1) {
            return null;
        }
        return this.f1805b;
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        ViewParent a2;
        if (!isNestedScrollingEnabled() || (a2 = a(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(a2, this.f1806c, f2, f3, z);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        ViewParent a2;
        if (!isNestedScrollingEnabled() || (a2 = a(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(a2, this.f1806c, f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return dispatchNestedScroll(i, i2, i3, i4, iArr, 0);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1807d;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.f1806c);
    }

    public void onStopNestedScroll(View view) {
        ViewCompat.stopNestedScroll(this.f1806c);
    }

    public void setNestedScrollingEnabled(boolean z) {
        if (this.f1807d) {
            ViewCompat.stopNestedScroll(this.f1806c);
        }
        this.f1807d = z;
    }

    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent a2;
        int i4;
        int i5;
        if (!isNestedScrollingEnabled() || (a2 = a(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f1806c.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.f1808e == null) {
                this.f1808e = new int[2];
            }
            iArr = this.f1808e;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        ViewParentCompat.onNestedPreScroll(a2, this.f1806c, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.f1806c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent a2;
        int i6;
        int i7;
        if (!isNestedScrollingEnabled() || (a2 = a(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f1806c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        ViewParentCompat.onNestedScroll(a2, this.f1806c, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.f1806c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean hasNestedScrollingParent(int i) {
        return a(i) != null;
    }

    public boolean startNestedScroll(int i, int i2) {
        if (hasNestedScrollingParent(i2)) {
            return true;
        }
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        View view = this.f1806c;
        for (ViewParent parent = this.f1806c.getParent(); parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.onStartNestedScroll(parent, view, this.f1806c, i, i2)) {
                a(i2, parent);
                ViewParentCompat.onNestedScrollAccepted(parent, view, this.f1806c, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void stopNestedScroll(int i) {
        ViewParent a2 = a(i);
        if (a2 != null) {
            ViewParentCompat.onStopNestedScroll(a2, this.f1806c, i);
            a(i, null);
        }
    }

    private void a(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f1804a = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.f1805b = viewParent;
        }
    }
}
