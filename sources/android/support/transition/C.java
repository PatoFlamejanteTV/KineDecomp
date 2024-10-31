package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* compiled from: PropertyValuesHolderUtils.java */
/* loaded from: classes.dex */
class C {

    /* renamed from: a */
    private static final F f530a;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f530a = new E();
        } else {
            f530a = new D();
        }
    }

    public static PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        return f530a.a(property, path);
    }
}
