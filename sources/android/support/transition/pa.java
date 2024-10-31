package android.support.transition;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi22.java */
/* loaded from: classes.dex */
class pa extends oa {
    private static Method i;
    private static boolean j;

    @SuppressLint({"PrivateApi"})
    private void e() {
        if (j) {
            return;
        }
        try {
            i = View.class.getDeclaredMethod("setLeftTopRightBottom", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            i.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e2);
        }
        j = true;
    }

    @Override // android.support.transition.la, android.support.transition.qa
    public void a(View view, int i2, int i3, int i4, int i5) {
        e();
        Method method = i;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
