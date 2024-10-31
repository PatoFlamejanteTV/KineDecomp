package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/* loaded from: classes3.dex */
public class CommonUtils {

    /* renamed from: a */
    private static Boolean f26873a;

    /* renamed from: b */
    private static final char[] f26874b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c */
    private static long f26875c = -1;

    /* renamed from: d */
    public static final Comparator<File> f26876d = new k();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum Architecture {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;

        private static final Map<String, Architecture> matcher = new HashMap(4);

        static {
            matcher.put("armeabi-v7a", ARMV7);
            matcher.put("armeabi", ARMV6);
            matcher.put("arm64-v8a", ARM64);
            matcher.put("x86", X86_32);
        }

        static Architecture getValue() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                io.fabric.sdk.android.f.f().d("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            Architecture architecture = matcher.get(str.toLowerCase(Locale.US));
            return architecture == null ? UNKNOWN : architecture;
        }
    }

    public static String a(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return "?";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:            r2 = r3[1];     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "Failed to close system file reader."
            boolean r1 = r7.exists()
            r2 = 0
            if (r1 == 0) goto L61
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r4 = 1024(0x400, float:1.435E-42)
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
        L15:
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            if (r3 == 0) goto L36
            java.lang.String r4 = "\\s*:\\s*"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            r5 = 2
            java.lang.String[] r3 = r4.split(r3, r5)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            int r4 = r3.length     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            r5 = 1
            if (r4 <= r5) goto L15
            r4 = 0
            r4 = r3[r4]     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            boolean r4 = r4.equals(r8)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            if (r4 == 0) goto L15
            r7 = r3[r5]     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            r2 = r7
        L36:
            a(r1, r0)
            goto L61
        L3a:
            r8 = move-exception
            goto L41
        L3c:
            r7 = move-exception
            r1 = r2
            goto L5d
        L3f:
            r8 = move-exception
            r1 = r2
        L41:
            io.fabric.sdk.android.o r3 = io.fabric.sdk.android.f.f()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r4 = "Fabric"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r5.<init>()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r6 = "Error parsing "
            r5.append(r6)     // Catch: java.lang.Throwable -> L5c
            r5.append(r7)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L5c
            r3.c(r4, r7, r8)     // Catch: java.lang.Throwable -> L5c
            goto L36
        L5c:
            r7 = move-exception
        L5d:
            a(r1, r0)
            throw r7
        L61:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.common.CommonUtils.a(java.io.File, java.lang.String):java.lang.String");
    }

    public static synchronized long b() {
        long j;
        synchronized (CommonUtils.class) {
            if (f26875c == -1) {
                long j2 = 0;
                String a2 = a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a2)) {
                    String upperCase = a2.toUpperCase(Locale.US);
                    try {
                        if (upperCase.endsWith("KB")) {
                            j2 = a(upperCase, "KB", 1024);
                        } else if (upperCase.endsWith("MB")) {
                            j2 = a(upperCase, "MB", 1048576);
                        } else if (upperCase.endsWith("GB")) {
                            j2 = a(upperCase, "GB", 1073741824);
                        } else {
                            io.fabric.sdk.android.f.f().d("Fabric", "Unexpected meminfo format while computing RAM: " + upperCase);
                        }
                    } catch (NumberFormatException e2) {
                        io.fabric.sdk.android.f.f().c("Fabric", "Unexpected meminfo format while computing RAM: " + upperCase, e2);
                    }
                }
                f26875c = j2;
            }
            j = f26875c;
        }
        return j;
    }

    public static String c(String str) {
        return a(str, "SHA-1");
    }

    public static String d(String str) {
        return a(str, "SHA-256");
    }

    public static Float e(Context context) {
        if (context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")) == null) {
            return null;
        }
        return Float.valueOf(r3.getIntExtra("level", -1) / r3.getIntExtra("scale", -1));
    }

    public static int f(Context context) {
        int i = l(context) ? 1 : 0;
        if (m(context)) {
            i |= 2;
        }
        return c() ? i | 4 : i;
    }

    public static boolean g(Context context) {
        return (l(context) || ((SensorManager) context.getSystemService(com.umeng.commonsdk.proguard.e.aa)).getDefaultSensor(8) == null) ? false : true;
    }

    public static String h(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    public static SharedPreferences i(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static boolean j(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean k(Context context) {
        if (f26873a == null) {
            f26873a = Boolean.valueOf(a(context, "com.crashlytics.Trace", false));
        }
        return f26873a.booleanValue();
    }

    public static boolean l(Context context) {
        return ServerProtocol.DIALOG_PARAM_SDK_VERSION.equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Settings.Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    public static boolean m(Context context) {
        boolean l = l(context);
        String str = Build.TAGS;
        if ((l || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            return !l && new File("/system/xbin/su").exists();
        }
        return true;
    }

    public static String n(Context context) {
        int a2 = a(context, "io.fabric.android.build_id", "string");
        if (a2 == 0) {
            a2 = a(context, "com.crashlytics.android.build_id", "string");
        }
        if (a2 == 0) {
            return null;
        }
        String string = context.getResources().getString(a2);
        io.fabric.sdk.android.f.f().d("Fabric", "Build ID is: " + string);
        return string;
    }

    public static void c(Context context, String str) {
        if (k(context)) {
            io.fabric.sdk.android.f.f().d("Fabric", str);
        }
    }

    public static int d(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static boolean c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static String c(Context context) {
        Throwable th;
        InputStream inputStream;
        try {
            inputStream = context.getResources().openRawResource(d(context));
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            a((Closeable) inputStream, "Failed to close icon input stream.");
            throw th;
        }
        try {
            try {
                String a2 = a(inputStream);
                String str = b(a2) ? null : a2;
                a((Closeable) inputStream, "Failed to close icon input stream.");
                return str;
            } catch (Throwable th3) {
                th = th3;
                a((Closeable) inputStream, "Failed to close icon input stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            io.fabric.sdk.android.f.f().c("Fabric", "Could not calculate hash for app icon.", e);
            a((Closeable) inputStream, "Failed to close icon input stream.");
            return null;
        }
    }

    public static int a() {
        return Architecture.getValue().ordinal();
    }

    static long a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * i;
    }

    public static ActivityManager.RunningAppProcessInfo a(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static String b(InputStream inputStream) throws IOException {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public static String a(InputStream inputStream) {
        return a(inputStream, "SHA-1");
    }

    public static String b(Context context, String str) {
        int a2 = a(context, str, "string");
        return a2 > 0 ? context.getString(a2) : "";
    }

    private static String a(String str, String str2) {
        return a(str.getBytes(), str2);
    }

    private static String a(InputStream inputStream, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    return a(messageDigest.digest());
                }
            }
        } catch (Exception e2) {
            io.fabric.sdk.android.f.f().c("Fabric", "Could not calculate hash for app icon.", e2);
            return "";
        }
    }

    public static boolean b(String str) {
        return str == null || str.length() == 0;
    }

    public static String b(int i) {
        if (i >= 0) {
            return String.format(Locale.US, "%1$10s", Integer.valueOf(i)).replace(' ', '0');
        }
        throw new IllegalArgumentException("value must be zero or greater");
    }

    @SuppressLint({"MissingPermission"})
    public static boolean b(Context context) {
        if (!a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    private static String a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            io.fabric.sdk.android.f.f().c("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e2);
            return "";
        }
    }

    public static String a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            return c(sb2);
        }
        return null;
    }

    public static long a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long a(String str) {
        long blockSize = new StatFs(str).getBlockSize();
        return (r0.getBlockCount() * blockSize) - (blockSize * r0.getAvailableBlocks());
    }

    public static void a(Context context, String str, Throwable th) {
        if (k(context)) {
            io.fabric.sdk.android.f.f().e("Fabric", str);
        }
    }

    public static void a(Context context, int i, String str, String str2) {
        if (k(context)) {
            io.fabric.sdk.android.f.f().log(i, "Fabric", str2);
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int a2 = a(context, str, "bool");
            if (a2 > 0) {
                return resources.getBoolean(a2);
            }
            int a3 = a(context, str, "string");
            if (a3 > 0) {
                return Boolean.parseBoolean(context.getString(a3));
            }
        }
        return z;
    }

    public static int a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, h(context));
    }

    public static int a(Context context, boolean z) {
        Float e2 = e(context);
        if (!z || e2 == null) {
            return 1;
        }
        if (e2.floatValue() >= 99.0d) {
            return 3;
        }
        return ((double) e2.floatValue()) < 99.0d ? 2 : 0;
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f26874b;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static void a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                io.fabric.sdk.android.f.f().c("Fabric", str, e2);
            }
        }
    }

    public static void a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (IOException e2) {
                io.fabric.sdk.android.f.f().c("Fabric", str, e2);
            }
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }
}
