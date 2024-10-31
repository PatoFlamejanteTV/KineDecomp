package android.support.v4.text;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public final class ICUCompat {

    /* renamed from: a */
    private static Method f1679a;

    /* renamed from: b */
    private static Method f1680b;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                f1680b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                return;
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f1679a = cls.getMethod("getScript", String.class);
                f1680b = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e3) {
            f1679a = null;
            f1680b = null;
            Log.w("ICUCompat", e3);
        }
    }

    private ICUCompat() {
    }

    private static String a(String str) {
        try {
            if (f1679a != null) {
                return (String) f1679a.invoke(null, str);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return null;
    }

    public static String maximizeAndGetScript(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f1680b.invoke(null, locale)).getScript();
            } catch (IllegalAccessException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            } catch (InvocationTargetException e3) {
                Log.w("ICUCompat", e3);
                return locale.getScript();
            }
        }
        String a2 = a(locale);
        if (a2 != null) {
            return a(a2);
        }
        return null;
    }

    private static String a(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f1680b != null) {
                return (String) f1680b.invoke(null, locale2);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return locale2;
    }
}
