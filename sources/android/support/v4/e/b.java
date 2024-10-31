package android.support.v4.e;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ICUCompatIcs.java */
/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private static Method f73a;
    private static Method b;

    static {
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f73a = cls.getMethod("getScript", String.class);
                b = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e) {
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String a(String str) {
        try {
            if (f73a != null) {
                return (String) f73a.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    public static String b(String str) {
        try {
            if (b != null) {
                return (String) b.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return str;
    }
}
