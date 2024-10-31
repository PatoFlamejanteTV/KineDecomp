package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class ka {

    /* renamed from: a */
    private static final qa f591a;

    /* renamed from: b */
    private static Field f592b;

    /* renamed from: c */
    private static boolean f593c;

    /* renamed from: d */
    static final Property<View, Float> f594d;

    /* renamed from: e */
    static final Property<View, Rect> f595e;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 22) {
            f591a = new pa();
        } else if (i >= 21) {
            f591a = new oa();
        } else if (i >= 19) {
            f591a = new na();
        } else if (i >= 18) {
            f591a = new ma();
        } else {
            f591a = new la();
        }
        f594d = new ia(Float.class, "translationAlpha");
        f595e = new ja(Rect.class, "clipBounds");
    }

    public static void a(View view, float f2) {
        f591a.a(view, f2);
    }

    public static ha b(View view) {
        return f591a.b(view);
    }

    public static float c(View view) {
        return f591a.d(view);
    }

    public static va d(View view) {
        return f591a.e(view);
    }

    public static void e(View view) {
        f591a.a(view);
    }

    public static void a(View view) {
        f591a.c(view);
    }

    public static void b(View view, Matrix matrix) {
        f591a.a(view, matrix);
    }

    public static void a(View view, int i) {
        a();
        Field field = f592b;
        if (field != null) {
            try {
                f592b.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    public static void a(View view, Matrix matrix) {
        f591a.b(view, matrix);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        f591a.a(view, i, i2, i3, i4);
    }

    private static void a() {
        if (f593c) {
            return;
        }
        try {
            f592b = View.class.getDeclaredField("mViewFlags");
            f592b.setAccessible(true);
        } catch (NoSuchFieldException unused) {
            Log.i("ViewUtils", "fetchViewFlagsField: ");
        }
        f593c = true;
    }
}
