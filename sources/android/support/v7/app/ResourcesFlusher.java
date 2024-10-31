package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: classes.dex */
class ResourcesFlusher {

    /* renamed from: a */
    private static Field f2191a;

    /* renamed from: b */
    private static boolean f2192b;

    /* renamed from: c */
    private static Class f2193c;

    /* renamed from: d */
    private static boolean f2194d;

    /* renamed from: e */
    private static Field f2195e;

    /* renamed from: f */
    private static boolean f2196f;

    /* renamed from: g */
    private static Field f2197g;

    /* renamed from: h */
    private static boolean f2198h;

    ResourcesFlusher() {
    }

    public static boolean a(Resources resources) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return d(resources);
        }
        if (i >= 23) {
            return c(resources);
        }
        if (i >= 21) {
            return b(resources);
        }
        return false;
    }

    private static boolean b(Resources resources) {
        Map map;
        if (!f2192b) {
            try {
                f2191a = Resources.class.getDeclaredField("mDrawableCache");
                f2191a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f2192b = true;
        }
        Field field = f2191a;
        if (field == null) {
            return false;
        }
        try {
            map = (Map) field.get(resources);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            map = null;
        }
        if (map == null) {
            return false;
        }
        map.clear();
        return true;
    }

    private static boolean c(Resources resources) {
        if (!f2192b) {
            try {
                f2191a = Resources.class.getDeclaredField("mDrawableCache");
                f2191a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f2192b = true;
        }
        Object obj = null;
        Field field = f2191a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
        }
        return (obj == null || obj == null || !a(obj)) ? false : true;
    }

    private static boolean d(Resources resources) {
        Object obj;
        if (!f2198h) {
            try {
                f2197g = Resources.class.getDeclaredField("mResourcesImpl");
                f2197g.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            f2198h = true;
        }
        Field field = f2197g;
        if (field == null) {
            return false;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        if (!f2192b) {
            try {
                f2191a = obj.getClass().getDeclaredField("mDrawableCache");
                f2191a.setAccessible(true);
            } catch (NoSuchFieldException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
            }
            f2192b = true;
        }
        Field field2 = f2191a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
            }
        }
        return obj2 != null && a(obj2);
    }

    private static boolean a(Object obj) {
        LongSparseArray longSparseArray;
        if (!f2194d) {
            try {
                f2193c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            f2194d = true;
        }
        Class cls = f2193c;
        if (cls == null) {
            return false;
        }
        if (!f2196f) {
            try {
                f2195e = cls.getDeclaredField("mUnthemedEntries");
                f2195e.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
            }
            f2196f = true;
        }
        Field field = f2195e;
        if (field == null) {
            return false;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e4) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
            longSparseArray = null;
        }
        if (longSparseArray == null) {
            return false;
        }
        longSparseArray.clear();
        return true;
    }
}
