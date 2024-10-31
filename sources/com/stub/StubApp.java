package com.stub;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import com.qihoo.util.C0002;
import dalvik.system.DexFile;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class StubApp extends Application {

    /* renamed from: ᵢˑ, reason: contains not printable characters */
    private static Context f5;

    /* renamed from: ᵢˋ, reason: contains not printable characters */
    private static Application f2 = null;
    public static String strEntryApplication = "entryRunApplication";

    /* renamed from: ᵢˎ, reason: contains not printable characters */
    private static Application f3 = null;

    /* renamed from: ᵢˏ, reason: contains not printable characters */
    private static String f4 = "libjiagu";
    private static boolean loadFromLib = false;
    private static boolean needX86Bridge = false;

    /* renamed from: ᵢי, reason: contains not printable characters */
    private static String f6 = null;

    /* renamed from: ᵢـ, reason: contains not printable characters */
    private static String f7 = null;

    /* renamed from: ᵢٴ, reason: contains not printable characters */
    private static String f8 = null;

    /* renamed from: ᵢᐧ, reason: contains not printable characters */
    private static String f9 = null;

    /* renamed from: ᵢᴵ, reason: contains not printable characters */
    private static String f10 = null;

    /* renamed from: ᵢᵎ, reason: contains not printable characters */
    private static Map<Integer, String> f11 = new ConcurrentHashMap();

    public static native void interface11(int i);

    public static native Enumeration<String> interface12(DexFile dexFile);

    public static native long interface13(int i, long j, long j2, long j3, int i2, int i3, long j4);

    public static native String interface14(int i);

    public static native AssetFileDescriptor interface17(AssetManager assetManager, String str);

    public static native InputStream interface18(Class cls, String str);

    public static native InputStream interface19(ClassLoader classLoader, String str);

    public static native void interface20();

    public static native void interface21(Application application);

    public static native void interface22(int i, String[] strArr, int[] iArr);

    public static native void interface5(Application application);

    public static native String interface6(String str);

    public static native boolean interface7(Application application, Context context);

    public static native boolean interface8(Application application, Context context);

    public static native Location mark(LocationManager locationManager, String str);

    public static native void mark();

    public static native void mark(Location location);

    public static native void n0110();

    public static native boolean n0111();

    public static native int n0111111131(int i, int i2, int i3, int i4, int i5, Object obj);

    public static native int n011111311131(int i, int i2, int i3, Object obj, int i4, int i5, int i6, Object obj2);

    public static native long n01112(int i);

    public static native long n0112();

    public static native Object n0113();

    public static native void n01130(Object obj);

    public static native boolean n01131(Object obj);

    public static native void n011310(Object obj, boolean z);

    public static native boolean n011311(Object obj, boolean z);

    public static native Object n011313(Object obj, boolean z);

    public static native void n0113130(Object obj, int i, Object obj2);

    public static native Object n0113133(Object obj, int i, Object obj2);

    public static native void n0113220(Object obj, double d, double d2);

    public static native Object n01133(Object obj);

    public static native void n011330(Object obj, Object obj2);

    public static native Object n011333(Object obj, Object obj2);

    public static native void n0113330(Object obj, Object obj2, Object obj3);

    public static native long n0113331333112(Object obj, Object obj2, Object obj3, int i, Object obj4, Object obj5, Object obj6, int i2, int i3);

    public static native Object n0113333(Object obj, Object obj2, Object obj3);

    public native synchronized void n1100();

    public native synchronized void n11030(Object obj);

    public native void n1110();

    public native int n1111();

    public native void n11110(int i);

    public native int n11111(int i);

    public native void n111110(float f, float f12);

    public native int n111111(int i, int i2);

    public native void n1111110(float f, float f12, float f13);

    public native int n1111111(int i, int i2, int i3);

    public native void n11111110(float f, float f12, float f13, float f14);

    public native int n111111111(float f, float f12, float f13, float f14, int i);

    public native void n1111111110(int i, int i2, float f, float f12, float f13, float f14);

    public native void n11111111110(int i, float f, float f12, float f13, float f14, float f15, float f16);

    public native void n111111311111111110(int i, int i2, int i3, Object obj, int i4, int i5, int i6, float f, float f12, float f13, float f14, float f15, boolean z, int i7);

    public native int n1111131(int i, int i2, Object obj);

    public native void n11111311111111110(int i, int i2, Object obj, int i3, int i4, int i5, float f, float f12, float f13, float f14, float f15, boolean z, int i6);

    public native void n111113311111111110(int i, int i2, Object obj, Object obj2, int i3, int i4, int i5, float f, float f12, float f13, float f14, float f15, boolean z, int i6);

    public native void n111130(int i, Object obj);

    public native int n111131(int i, Object obj);

    public native void n1111311111111110(int i, Object obj, int i2, int i3, int i4, float f, float f12, float f13, float f14, float f15, boolean z, int i5);

    public native boolean n11113311(int i, Object obj, Object obj2, int i2);

    public native Object n1113();

    public native void n11130(Object obj);

    public native int n11131(Object obj);

    public native void n111310(Object obj, boolean z);

    public native int n111311(Object obj, int i);

    public native int n11131111(Object obj, int i, int i2, int i3);

    public native int n11131112111111111111(Object obj, int i, int i2, int i3, long j, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14);

    public native void n11131130(Object obj, int i, int i2, Object obj2);

    public native void n1113130(Object obj, int i, Object obj2);

    public native long n11132(Object obj);

    public native Object n11133(Object obj);

    public native void n111330(Object obj, Object obj2);

    public native int n111331(Object obj, Object obj2);

    public native int n1113311(Object obj, Object obj2, int i);

    public native void n11133110(Object obj, Object obj2, boolean z, int i);

    public native int n11133111(Object obj, Object obj2, int i, int i2);

    public native int n111331111(Object obj, Object obj2, int i, int i2, int i3);

    public native int n1113311111111(Object obj, Object obj2, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public native int n111331111121131(Object obj, Object obj2, int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, Object obj3);

    public native int n111331131(Object obj, Object obj2, int i, int i2, Object obj3);

    public native void n1113330(Object obj, Object obj2, Object obj3);

    public native boolean n1113331(Object obj, Object obj2, Object obj3);

    public native void n11133310(Object obj, Object obj2, Object obj3, int i);

    public native int n11133311121111(Object obj, Object obj2, Object obj3, int i, int i2, int i3, long j, int i4, int i5, int i6);

    public native void n111333133310(Object obj, Object obj2, Object obj3, int i, Object obj4, Object obj5, Object obj6, int i2);

    public native Object n1113333(Object obj, Object obj2, Object obj3);

    public native boolean n11133331(Object obj, Object obj2, Object obj3, Object obj4);

    public static String getSoPath1() {
        return f7;
    }

    public static String getSoPath2() {
        return f8;
    }

    public static String getDir() {
        return f9;
    }

    public static Context getAppContext() {
        return f5;
    }

    public static Context getOrigApplicationContext(Context context) {
        if (context == f2) {
            return f3;
        }
        return context;
    }

    /* renamed from: ᵢˋ, reason: contains not printable characters */
    private static Application m25(Context context) {
        ClassLoader classLoader;
        Class<?> loadClass;
        try {
            if (f3 == null && (classLoader = context.getClassLoader()) != null && (loadClass = classLoader.loadClass(strEntryApplication)) != null) {
                f3 = (Application) loadClass.newInstance();
            }
        } catch (Exception e) {
        }
        return f3;
    }

    @Override // android.app.Application
    public final void onCreate() {
        System.currentTimeMillis();
        super.onCreate();
        try {
            interface7(f3, f2.getBaseContext());
        } catch (Exception e) {
        }
        if (f3 != null) {
            f3.onCreate();
        }
        interface21(f3);
    }

    @Override // android.content.ContextWrapper
    protected final void attachBaseContext(Context context) {
        boolean m22;
        System.currentTimeMillis();
        super.attachBaseContext(context);
        C0002.m24();
        f5 = context;
        if (f2 == null) {
            f2 = this;
        }
        if (f3 == null) {
            Boolean valueOf = Boolean.valueOf(C0002.m21());
            Boolean bool = false;
            Boolean bool2 = false;
            if (Build.CPU_ABI.contains("64") || Build.CPU_ABI2.contains("64")) {
                bool = true;
            }
            if (Build.CPU_ABI.contains("mips") || Build.CPU_ABI2.contains("mips")) {
                bool2 = true;
            }
            if (valueOf.booleanValue() && needX86Bridge) {
                System.loadLibrary("X86Bridge");
            }
            if (loadFromLib) {
                if (valueOf.booleanValue() && !needX86Bridge) {
                    System.loadLibrary("jiagu_x86");
                } else {
                    System.loadLibrary("jiagu");
                }
            } else {
                String absolutePath = context.getFilesDir().getParentFile().getAbsolutePath();
                try {
                    absolutePath = context.getFilesDir().getParentFile().getCanonicalPath();
                } catch (Exception e) {
                }
                String str = absolutePath + "/.jiagu";
                f10 = m26(str, bool.booleanValue(), bool2.booleanValue());
                f6 = m26(str, false, false);
                f7 = str + File.separator + f6;
                f8 = str + File.separator + f10;
                f9 = str;
                if (bool2.booleanValue()) {
                    C0002.m22(context, f4 + "_mips.so", str, f6);
                } else if (valueOf.booleanValue() && !needX86Bridge) {
                    C0002.m22(context, f4 + "_x86.so", str, f6);
                } else {
                    C0002.m22(context, f4 + ".so", str, f6);
                }
                if (bool.booleanValue() && !bool2.booleanValue()) {
                    if (valueOf.booleanValue() && !needX86Bridge) {
                        m22 = C0002.m22(context, f4 + "_x64.so", str, f10);
                    } else {
                        m22 = C0002.m22(context, f4 + "_a64.so", str, f10);
                    }
                    if (m22) {
                        System.load(str + "/" + f10);
                    } else {
                        System.load(str + "/" + f6);
                    }
                } else {
                    System.load(str + "/" + f6);
                }
            }
        }
        interface5(f2);
        if (f3 == null) {
            f3 = m25(context);
            if (f3 != null) {
                try {
                    Method declaredMethod = Application.class.getDeclaredMethod("attach", Context.class);
                    if (declaredMethod != null) {
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(f3, context);
                    }
                    interface8(f3, context);
                    return;
                } catch (Exception e2) {
                    throw new RuntimeException("Failed to call attachBaseContext.", e2);
                }
            }
            System.exit(1);
        }
    }

    /* renamed from: ᵢˋ, reason: contains not printable characters */
    private static String m26(String str, boolean z, boolean z2) {
        String str2 = f4;
        if (Build.VERSION.SDK_INT < 23) {
            str2 = str2 + str.hashCode();
        }
        if (z && !z2) {
            return str2 + "_64.so";
        }
        return str2 + ".so";
    }

    public static String getString2(int i) {
        String str = f11.get(Integer.valueOf(i));
        if (str == null) {
            str = interface14(i);
            f11.put(Integer.valueOf(i), str);
        }
        if (str != null) {
            return str.intern();
        }
        return str;
    }

    public static String getString2(String str) {
        try {
            return getString2(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
}
