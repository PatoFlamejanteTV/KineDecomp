package com.nextreaming.nexeditorui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.preference.PreferenceManager;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.util.TypedValue;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class EditorGlobal {
    private static int A;
    public static float B;
    public static final Executor C;
    public static final Executor D;

    /* renamed from: a */
    public static final String[] f24022a = {".jpg", ".jpeg", ".png", ".webp", ".bmp", ".gif"};

    /* renamed from: b */
    public static final String[] f24023b = {".mp4", ".3gp", ".3gpp", ".mov", ".k3g", ".acc", ".avi", ".wmv"};

    /* renamed from: c */
    public static final String[] f24024c = {".aac", ".mp3", ".3gp", ".3gpp"};

    /* renamed from: d */
    public static boolean f24025d = false;

    /* renamed from: e */
    public static final VersionType f24026e = VersionType.RC;

    /* renamed from: f */
    private static final Edition f24027f = com.nexstreaming.app.kinemasterfree.a.f19912b;

    /* renamed from: g */
    private static final Date f24028g = a(0, 0, 0);

    /* renamed from: h */
    private static final Date f24029h = a(2018, 6, 30);
    private static final Date i = a(2018, 12, 31);
    private static final Date j = a(2017, 10, 31);
    private static final Date k = a(2017, 12, 31);
    private static final Date l = a(2016, 10, 10);
    public static final Date m = a(2017, 1, 15);
    public static final String n = null;
    public static final boolean o;
    public static final boolean p;
    public static final boolean q;
    public static final DataUsage r;
    public static final boolean s;
    public static final String t;
    public static final boolean u;
    public static final boolean v;
    public static String w;
    public static int x;
    private static float y;
    private static int z;

    /* loaded from: classes.dex */
    public enum DataUsage {
        WIFI_AND_MOBILE,
        WIFI_ONLY,
        NEVER,
        ASK_WIFI_OR_MOBILE,
        ASK_WIFI_MOBILE_NEVER
    }

    /* loaded from: classes.dex */
    public enum Edition {
        DeviceLock,
        TimeLock,
        PlayStore
    }

    /* loaded from: classes.dex */
    public enum VersionType {
        Alpha,
        Beta,
        Dev,
        ShowDemo,
        RC,
        Release,
        Eval,
        TeamEval
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private final File f24030a;

        @SuppressLint({"SimpleDateFormat"})
        public a(String str) {
            EditorGlobal.g().mkdirs();
            this.f24030a = new File(EditorGlobal.g(), str + ".log");
            a(null, "--- " + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + " -----------------------------------------");
        }

        public void a(String str, String str2) {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.f24030a, true));
                if (str == null) {
                    StringBuilder sb = new StringBuilder();
                    if (str2 == null) {
                        str2 = "(null)";
                    }
                    sb.append(str2);
                    sb.append("\n");
                    dataOutputStream.writeUTF(sb.toString());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(": ");
                    if (str2 == null) {
                        str2 = "(null)";
                    }
                    sb2.append(str2);
                    sb2.append("\n");
                    dataOutputStream.writeUTF(sb2.toString());
                }
                dataOutputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    static {
        o = f24027f != Edition.DeviceLock;
        p = c.d.b.c.a.d(KineMasterApplication.f24056d.getApplicationContext());
        q = f24026e == VersionType.ShowDemo;
        r = f24027f == Edition.PlayStore ? DataUsage.WIFI_AND_MOBILE : DataUsage.ASK_WIFI_MOBILE_NEVER;
        s = f24027f == Edition.DeviceLock;
        t = null;
        u = f24027f == Edition.PlayStore;
        v = f24027f == Edition.PlayStore;
        w = "com.km.thumbnailCacheVersion";
        x = 1;
        y = 1.7777778f;
        z = 1280;
        A = 720;
        B = 20.0f;
        C = Executors.newCachedThreadPool();
        D = Executors.newCachedThreadPool();
    }

    public static void a(float f2) {
        y = f2;
        z = 720;
        A = 720;
        float f3 = y;
        if (f3 == 1.7777778f) {
            z = 1280;
        } else if (f3 == 0.5625f) {
            A = 1280;
        }
    }

    public static void a(Intent intent) {
    }

    public static String b(int i2) {
        if (i2 > 3600000) {
            return String.format(Locale.US, "%d:%02d:%02d.%01d", Integer.valueOf(i2 / 3600000), Integer.valueOf((i2 % 3600000) / 60000), Integer.valueOf((i2 % 60000) / 1000), Integer.valueOf((i2 % 1000) / 100));
        }
        return String.format(Locale.US, "%02d:%02d.%01d", Integer.valueOf((i2 % 3600000) / 60000), Integer.valueOf((i2 % 60000) / 1000), Integer.valueOf((i2 % 1000) / 100));
    }

    public static File c() {
        return new File(p().getAbsolutePath() + File.separator + "KineMaster");
    }

    public static String d() {
        return Build.MODEL;
    }

    public static File e(Context context) {
        if (context == null) {
            return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Download");
        }
        File file = new File(context.getSharedPreferences("sdcardloc", 0).getString("sdcardlocation", Environment.getExternalStorageDirectory().getAbsolutePath()) + File.separator + "KineMaster" + File.separator + "Download");
        file.mkdirs();
        return file;
    }

    public static File f(Context context) {
        if (context == null) {
            return new File(p().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Reversed");
        }
        File file = new File(c(context) + File.separator + "KineMaster" + File.separator + "Reversed");
        file.mkdirs();
        return file;
    }

    public static File g() {
        return new File(p().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Log");
    }

    public static int h(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static String h() {
        return "Android";
    }

    public static NexEditor i() {
        return KineMasterApplication.f24056d.r();
    }

    public static File j() {
        return new File(p().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Projects" + File.separator + "Overlays");
    }

    public static File k() {
        return new File(p().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "AssetPlugins");
    }

    public static float l() {
        return y;
    }

    public static int m() {
        return A;
    }

    public static int n() {
        return z;
    }

    public static File o() {
        return new File(p().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Projects");
    }

    public static File p() {
        return Environment.getExternalStorageDirectory();
    }

    public static int q() {
        int i2;
        int i3 = 0;
        if (f24027f == Edition.DeviceLock) {
            i2 = 0;
            while (i3 < 4) {
                i2 = (i2 << 8) | 32;
                i3++;
            }
        } else if (f24027f == Edition.TimeLock || f24027f == Edition.PlayStore) {
            i2 = 33878;
            while (i3 < 1) {
                i2 = (i2 << 16) | 10309;
                i3++;
            }
        } else {
            i2 = 0;
        }
        return (i2 ^ 323616768) ^ 38286;
    }

    public static Date r() {
        if (f24027f == Edition.TimeLock) {
            return f24028g;
        }
        if (u && f24026e == VersionType.Beta) {
            return f24029h;
        }
        if (u && f24026e == VersionType.Dev) {
            return i;
        }
        if (u && f24026e == VersionType.Eval) {
            return i;
        }
        if (u && f24026e == VersionType.TeamEval) {
            return j;
        }
        if (f24026e == VersionType.ShowDemo) {
            return k;
        }
        return null;
    }

    public static boolean s() {
        if (c.d.b.m.e.f3850a.a()) {
            return PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext()).getBoolean("is_subscription_or_promotion", false);
        }
        return false;
    }

    public static boolean t() {
        return PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext()).getBoolean("show_demo_content_only", false);
    }

    public static boolean u() {
        return PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext()).getBoolean("export_diagnostics", false);
    }

    public static boolean v() {
        return f24027f == Edition.PlayStore;
    }

    public static boolean w() {
        return PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext()).getBoolean("unlimited_layers", false);
    }

    public static String c(Context context) {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static File d(Context context) {
        if (context == null) {
            return new File(p().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Export");
        }
        File file = new File(c(context) + File.separator + "KineMaster" + File.separator + "Export");
        file.mkdirs();
        return file;
    }

    public static File g(Context context) {
        if (context == null) {
            return new File(p().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Reversed");
        }
        File file = new File(c(context) + File.separator + "KineMaster" + File.separator + ".tmpReverse");
        file.mkdirs();
        return file;
    }

    public static boolean c(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        for (String str2 : f24023b) {
            if (lowerCase.endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static Date f() {
        return l;
    }

    private static String d(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        Random random = new Random();
        char[] cArr = new char[8];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = (char) (((random.nextInt() & 268435455) % 94) + 32);
        }
        int i3 = cArr[0] ^ '?';
        int i4 = cArr[1] ^ 129;
        sb.append(cArr);
        for (int i5 = 0; i5 < length; i5++) {
            sb.append((char) ((((((str.charAt(i5) - ' ') + "Ax/VXn_zsAiwFi[CITPC;y2c}*0B'S0-7&QznQlMa6U9gmSoighZeC&@$-hAaXiN".charAt((i3 + i5) % 64)) - cArr[(i4 + i5) % 8]) + 188) % 94) + 32));
        }
        return sb.toString();
    }

    public static String e() {
        HashMap<String, Integer> e2 = i().e();
        return "(engine " + e2.get(NexEditor.EngineVersion.MAJOR.name()).intValue() + "." + e2.get(NexEditor.EngineVersion.MINOR.name()).intValue() + "." + e2.get(NexEditor.EngineVersion.PATCH.name()).intValue() + ")";
    }

    public static boolean a(Resources resources) {
        int i2 = resources.getConfiguration().screenLayout & 15;
        return i2 == 4 || i2 == 3;
    }

    public static int a(Context context, int i2) {
        float f2;
        try {
            f2 = TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
        } catch (Exception unused) {
            Log.e("EditorGlobal", "getDpToPixel() Error");
            f2 = 0.0f;
        }
        return (int) f2;
    }

    public static String a(int i2) {
        if (i2 >= 3600000) {
            return String.format(Locale.US, "%02d:%02d:%02d.%01d", Integer.valueOf(i2 / 3600000), Integer.valueOf((i2 % 3600000) / 60000), Integer.valueOf((i2 % 60000) / 1000), Integer.valueOf((i2 % 1000) / 100));
        }
        if (i2 >= 60000) {
            return String.format(Locale.US, "%02d:%02d.%02d", Integer.valueOf(i2 / 60000), Integer.valueOf((i2 % 60000) / 1000), Integer.valueOf((i2 % 1000) / 10));
        }
        return String.format(Locale.US, "%02d.%03d", Integer.valueOf(i2 / 1000), Integer.valueOf((i2 % 1000) / 1));
    }

    public static String b(Resources resources, int i2) {
        if (i2 >= 3600000) {
            return resources.getString(R.string.export_time_h_m_s, Integer.valueOf(i2 / 3600000), Integer.valueOf((i2 % 3600000) / 60000), Integer.valueOf((i2 % 60000) / 1000));
        }
        if (i2 >= 60000) {
            return resources.getString(R.string.export_time_m_s, Integer.valueOf((i2 % 3600000) / 60000), Integer.valueOf((i2 % 60000) / 1000));
        }
        return resources.getString(R.string.export_time_s, Integer.valueOf(i2 / 1000));
    }

    public static File b() {
        return new File(KineMasterApplication.f24056d.getApplicationContext().getFilesDir(), "captest");
    }

    public static String a(Resources resources, int i2) {
        if (i2 >= 3600000) {
            return resources.getString(R.string.duration_h_m_s, Integer.valueOf(i2 / 3600000), Integer.valueOf((i2 % 3600000) / 60000), Integer.valueOf((i2 % 60000) / 1000), Integer.valueOf((i2 % 1000) / 100));
        }
        if (i2 >= 60000) {
            return resources.getString(R.string.duration_m_s, Integer.valueOf(i2 / 60000), Integer.valueOf((i2 % 60000) / 1000), Integer.valueOf((i2 % 1000) / 100));
        }
        return resources.getString(R.string.duration_s, Integer.valueOf(i2 / 1000), Integer.valueOf((i2 % 1000) / 100));
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        for (String str2 : f24022a) {
            if (lowerCase.endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String b(Context context) {
        int myPid = Process.myPid();
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String a(long j2) {
        if (j2 > 3600000) {
            return String.format(Locale.US, "%d:%02d:%02d", Long.valueOf(j2 / 3600000), Long.valueOf((j2 % 3600000) / 60000), Long.valueOf((j2 % 60000) / 1000));
        }
        return String.format(Locale.US, "%02d:%02d", Long.valueOf((j2 % 3600000) / 60000), Long.valueOf((j2 % 60000) / 1000));
    }

    public static String a(Context context, long j2) {
        if (j2 < 1) {
            return "?";
        }
        if (j2 < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return j2 + " B";
        }
        double d2 = j2;
        int log10 = (int) (Math.log10(d2) / 3.0103d);
        if (context == null) {
            return "";
        }
        Locale locale = context.getResources().getConfiguration().locale;
        double pow = Math.pow(1024.0d, log10);
        Double.isNaN(d2);
        return String.format(locale, "%.1f %sB", Double.valueOf(d2 / pow), Character.valueOf("KMGTPE".charAt(log10 - 1)));
    }

    public static File a() {
        return new File(p().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "CapabilityReport");
    }

    public static File a(Context context) {
        if (context == null) {
            return new File(p().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Converted");
        }
        File file = new File(c(context) + File.separator + "KineMaster" + File.separator + "Converted");
        file.mkdirs();
        return file;
    }

    private static Date a(int i2, int i3, int i4) {
        return a(i2, i3, i4, 0, 0, 0);
    }

    private static Date a(int i2, int i3, int i4, int i5, int i6, int i7) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.set(i2, i3 - 1, i4, i5, i6, i7);
        return gregorianCalendar.getTime();
    }

    public static String a(String str) {
        return d("com.nexstreaming.kinemaster.builtin.watermark." + str);
    }

    public static void a(boolean z2) {
        PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext()).edit().putBoolean("unlimited_layers", z2).apply();
    }

    public static Rect a(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect;
    }
}
