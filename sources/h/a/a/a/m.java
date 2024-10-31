package h.a.a.a;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TypefaceUtils.java */
/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a */
    private static final Map<String, Typeface> f26810a = new HashMap();

    /* renamed from: b */
    private static final Map<Typeface, g> f26811b = new HashMap();

    public static Typeface a(AssetManager assetManager, String str) {
        synchronized (f26810a) {
            try {
                try {
                    if (!f26810a.containsKey(str)) {
                        Typeface createFromAsset = Typeface.createFromAsset(assetManager, str);
                        f26810a.put(str, createFromAsset);
                        return createFromAsset;
                    }
                    return f26810a.get(str);
                } catch (Exception e2) {
                    Log.w("Calligraphy", "Can't create asset from " + str + ". Make sure you have passed in the correct path and file name.", e2);
                    f26810a.put(str, null);
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean b(Typeface typeface) {
        return typeface != null && f26810a.containsValue(typeface);
    }

    public static g a(Typeface typeface) {
        if (typeface == null) {
            return null;
        }
        synchronized (f26811b) {
            if (!f26811b.containsKey(typeface)) {
                g gVar = new g(typeface);
                f26811b.put(typeface, gVar);
                return gVar;
            }
            return f26811b.get(typeface);
        }
    }
}
