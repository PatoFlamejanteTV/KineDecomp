package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {

    /* renamed from: a, reason: collision with root package name */
    private static final Class f1136a;

    /* renamed from: b, reason: collision with root package name */
    private static final Constructor f1137b;

    /* renamed from: c, reason: collision with root package name */
    private static final Method f1138c;

    /* renamed from: d, reason: collision with root package name */
    private static final Method f1139d;

    /* renamed from: e, reason: collision with root package name */
    private static final Method f1140e;

    /* renamed from: f, reason: collision with root package name */
    private static final Method f1141f;

    /* renamed from: g, reason: collision with root package name */
    private static final Method f1142g;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
            method3 = cls.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
            method4 = cls.getMethod("freeze", new Class[0]);
            method5 = cls.getMethod("abortCreation", new Class[0]);
            method = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
            method.setAccessible(true);
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        f1137b = constructor;
        f1136a = cls;
        f1138c = method2;
        f1139d = method3;
        f1140e = method4;
        f1141f = method5;
        f1142g = method;
    }

    private static boolean a() {
        if (f1138c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return f1138c != null;
    }

    private static Object b() {
        try {
            return f1137b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean c(Object obj) {
        try {
            return ((Boolean) f1140e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        if (!a()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i);
        }
        Object b2 = b();
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
            if (!a(context, b2, fontFileResourceEntry.getFileName(), 0, fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic() ? 1 : 0)) {
                a(b2);
                return null;
            }
        }
        if (c(b2)) {
            return b(b2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[Catch: IOException -> 0x005e, SYNTHETIC, TRY_LEAVE, TryCatch #3 {IOException -> 0x005e, blocks: (B:9:0x0014, B:12:0x0022, B:17:0x0045, B:24:0x005a, B:25:0x005d), top: B:8:0x0014 }] */
    @Override // android.support.v4.graphics.TypefaceCompatApi21Impl, android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r10, android.os.CancellationSignal r11, android.support.v4.provider.FontsContractCompat.FontInfo[] r12, int r13) {
        /*
            r9 = this;
            int r0 = r12.length
            r1 = 1
            r2 = 0
            if (r0 >= r1) goto L6
            return r2
        L6:
            boolean r0 = a()
            if (r0 != 0) goto L5f
            android.support.v4.provider.FontsContractCompat$FontInfo r12 = r9.a(r12, r13)
            android.content.ContentResolver r10 = r10.getContentResolver()
            android.net.Uri r13 = r12.getUri()     // Catch: java.io.IOException -> L5e
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r10 = r10.openFileDescriptor(r13, r0, r11)     // Catch: java.io.IOException -> L5e
            if (r10 != 0) goto L26
            if (r10 == 0) goto L25
            r10.close()     // Catch: java.io.IOException -> L5e
        L25:
            return r2
        L26:
            android.graphics.Typeface$Builder r11 = new android.graphics.Typeface$Builder     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            java.io.FileDescriptor r13 = r10.getFileDescriptor()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            r11.<init>(r13)     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            int r13 = r12.getWeight()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            android.graphics.Typeface$Builder r11 = r11.setWeight(r13)     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            boolean r12 = r12.isItalic()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            android.graphics.Typeface$Builder r11 = r11.setItalic(r12)     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            android.graphics.Typeface r11 = r11.build()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            if (r10 == 0) goto L48
            r10.close()     // Catch: java.io.IOException -> L5e
        L48:
            return r11
        L49:
            r11 = move-exception
            r12 = r2
            goto L52
        L4c:
            r11 = move-exception
            throw r11     // Catch: java.lang.Throwable -> L4e
        L4e:
            r12 = move-exception
            r8 = r12
            r12 = r11
            r11 = r8
        L52:
            if (r10 == 0) goto L5d
            if (r12 == 0) goto L5a
            r10.close()     // Catch: java.lang.Throwable -> L5d
            goto L5d
        L5a:
            r10.close()     // Catch: java.io.IOException -> L5e
        L5d:
            throw r11     // Catch: java.io.IOException -> L5e
        L5e:
            return r2
        L5f:
            java.util.Map r10 = android.support.v4.provider.FontsContractCompat.prepareFontData(r10, r12, r11)
            java.lang.Object r11 = b()
            int r0 = r12.length
            r3 = 0
            r4 = 0
        L6a:
            if (r3 >= r0) goto L95
            r5 = r12[r3]
            android.net.Uri r6 = r5.getUri()
            java.lang.Object r6 = r10.get(r6)
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            if (r6 != 0) goto L7b
            goto L92
        L7b:
            int r4 = r5.getTtcIndex()
            int r7 = r5.getWeight()
            boolean r5 = r5.isItalic()
            boolean r4 = a(r11, r6, r4, r7, r5)
            if (r4 != 0) goto L91
            a(r11)
            return r2
        L91:
            r4 = 1
        L92:
            int r3 = r3 + 1
            goto L6a
        L95:
            if (r4 != 0) goto L9b
            a(r11)
            return r2
        L9b:
            boolean r10 = c(r11)
            if (r10 != 0) goto La2
            return r2
        La2:
            android.graphics.Typeface r10 = b(r11)
            android.graphics.Typeface r10 = android.graphics.Typeface.create(r10, r13)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        if (!a()) {
            return super.createFromResourcesFontFile(context, resources, i, str, i2);
        }
        Object b2 = b();
        if (!a(context, b2, str, 0, -1, -1)) {
            a(b2);
            return null;
        }
        if (c(b2)) {
            return b(b2);
        }
        return null;
    }

    private static Typeface b(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) f1136a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f1142g.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean a(Context context, Object obj, String str, int i, int i2, int i3) {
        try {
            return ((Boolean) f1138c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) f1139d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void a(Object obj) {
        try {
            f1141f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }
}
