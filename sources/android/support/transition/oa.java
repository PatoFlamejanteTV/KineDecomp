package android.support.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi21.java */
/* loaded from: classes.dex */
class oa extends na {

    /* renamed from: e */
    private static Method f613e;

    /* renamed from: f */
    private static boolean f614f;

    /* renamed from: g */
    private static Method f615g;

    /* renamed from: h */
    private static boolean f616h;

    private void c() {
        if (f614f) {
            return;
        }
        try {
            f613e = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
            f613e.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e2);
        }
        f614f = true;
    }

    private void d() {
        if (f616h) {
            return;
        }
        try {
            f615g = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
            f615g.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e2);
        }
        f616h = true;
    }

    @Override // android.support.transition.la, android.support.transition.qa
    public void a(View view, Matrix matrix) {
        d();
        Method method = f615g;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // android.support.transition.la, android.support.transition.qa
    public void b(View view, Matrix matrix) {
        c();
        Method method = f613e;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
