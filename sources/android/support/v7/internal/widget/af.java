package android.support.v7.internal.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private static Method f166a;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f166a = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                if (!f166a.isAccessible()) {
                    f166a.setAccessible(true);
                }
            } catch (NoSuchMethodException e) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    public static boolean a(View view) {
        return android.support.v4.g.p.a(view) == 1;
    }

    public static int a(int i, int i2) {
        return i | i2;
    }

    public static void a(View view, Rect rect, Rect rect2) {
        if (f166a != null) {
            try {
                f166a.invoke(view, rect, rect2);
            } catch (Exception e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }
}
