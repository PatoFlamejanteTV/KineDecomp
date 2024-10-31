package android.support.transition;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewUtilsApi19.java */
/* loaded from: classes.dex */
public class na extends ma {

    /* renamed from: a */
    private static Method f606a;

    /* renamed from: b */
    private static boolean f607b;

    /* renamed from: c */
    private static Method f608c;

    /* renamed from: d */
    private static boolean f609d;

    private void b() {
        if (f607b) {
            return;
        }
        try {
            f606a = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
            f606a.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e2);
        }
        f607b = true;
    }

    @Override // android.support.transition.la, android.support.transition.qa
    public void a(View view) {
    }

    @Override // android.support.transition.la, android.support.transition.qa
    public void a(View view, float f2) {
        b();
        Method method = f606a;
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(f2));
                return;
            } catch (IllegalAccessException unused) {
                return;
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        view.setAlpha(f2);
    }

    @Override // android.support.transition.la, android.support.transition.qa
    public void c(View view) {
    }

    @Override // android.support.transition.la, android.support.transition.qa
    public float d(View view) {
        a();
        Method method = f608c;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return super.d(view);
    }

    private void a() {
        if (f609d) {
            return;
        }
        try {
            f608c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
            f608c.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e2);
        }
        f609d = true;
    }
}
