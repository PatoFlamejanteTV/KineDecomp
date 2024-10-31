package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* compiled from: ObjectAnimatorUtils.java */
/* renamed from: android.support.transition.w */
/* loaded from: classes.dex */
class C0216w {

    /* renamed from: a */
    private static final InterfaceC0219z f659a;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f659a = new C0218y();
        } else {
            f659a = new C0217x();
        }
    }

    public static <T> ObjectAnimator a(T t, Property<T, PointF> property, Path path) {
        return f659a.a(t, property, path);
    }
}
