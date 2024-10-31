package android.support.transition;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewGroupUtilsApi18.java */
/* loaded from: classes.dex */
class da extends ca {

    /* renamed from: f */
    private static Method f576f;

    /* renamed from: g */
    private static boolean f577g;

    @Override // android.support.transition.ca, android.support.transition.ea
    public Z a(ViewGroup viewGroup) {
        return new Y(viewGroup);
    }

    @Override // android.support.transition.ca, android.support.transition.ea
    public void a(ViewGroup viewGroup, boolean z) {
        a();
        Method method = f576f;
        if (method != null) {
            try {
                method.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e2) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e2);
            } catch (InvocationTargetException e3) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e3);
            }
        }
    }

    private void a() {
        if (f577g) {
            return;
        }
        try {
            f576f = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
            f576f.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e2);
        }
        f577g = true;
    }
}
