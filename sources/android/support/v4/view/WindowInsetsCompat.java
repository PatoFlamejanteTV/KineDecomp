package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class WindowInsetsCompat {

    /* renamed from: a */
    private final Object f1878a;

    private WindowInsetsCompat(Object obj) {
        this.f1878a = obj;
    }

    public static WindowInsetsCompat a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new WindowInsetsCompat(obj);
    }

    public WindowInsetsCompat consumeStableInsets() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new WindowInsetsCompat(((WindowInsets) this.f1878a).consumeStableInsets());
        }
        return null;
    }

    public WindowInsetsCompat consumeSystemWindowInsets() {
        if (Build.VERSION.SDK_INT >= 20) {
            return new WindowInsetsCompat(((WindowInsets) this.f1878a).consumeSystemWindowInsets());
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WindowInsetsCompat.class != obj.getClass()) {
            return false;
        }
        WindowInsetsCompat windowInsetsCompat = (WindowInsetsCompat) obj;
        Object obj2 = this.f1878a;
        return obj2 == null ? windowInsetsCompat.f1878a == null : obj2.equals(windowInsetsCompat.f1878a);
    }

    public int getStableInsetBottom() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f1878a).getStableInsetBottom();
        }
        return 0;
    }

    public int getStableInsetLeft() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f1878a).getStableInsetLeft();
        }
        return 0;
    }

    public int getStableInsetRight() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f1878a).getStableInsetRight();
        }
        return 0;
    }

    public int getStableInsetTop() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f1878a).getStableInsetTop();
        }
        return 0;
    }

    public int getSystemWindowInsetBottom() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1878a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public int getSystemWindowInsetLeft() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1878a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int getSystemWindowInsetRight() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1878a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int getSystemWindowInsetTop() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1878a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public boolean hasInsets() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1878a).hasInsets();
        }
        return false;
    }

    public boolean hasStableInsets() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f1878a).hasStableInsets();
        }
        return false;
    }

    public boolean hasSystemWindowInsets() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1878a).hasSystemWindowInsets();
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f1878a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean isConsumed() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f1878a).isConsumed();
        }
        return false;
    }

    public boolean isRound() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1878a).isRound();
        }
        return false;
    }

    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new WindowInsetsCompat(((WindowInsets) this.f1878a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public static Object a(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat == null) {
            return null;
        }
        return windowInsetsCompat.f1878a;
    }

    public WindowInsetsCompat(WindowInsetsCompat windowInsetsCompat) {
        if (Build.VERSION.SDK_INT >= 20) {
            this.f1878a = windowInsetsCompat != null ? new WindowInsets((WindowInsets) windowInsetsCompat.f1878a) : null;
        } else {
            this.f1878a = null;
        }
    }

    public WindowInsetsCompat replaceSystemWindowInsets(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new WindowInsetsCompat(((WindowInsets) this.f1878a).replaceSystemWindowInsets(rect));
        }
        return null;
    }
}
