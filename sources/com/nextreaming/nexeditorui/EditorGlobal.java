package com.nextreaming.nexeditorui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.TypedValue;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class EditorGlobal {
    public static final boolean e;
    public static final VersionType f;
    public static final DataUsage g;
    public static final boolean h;
    public static final String i;
    public static final boolean j;
    public static final boolean k;
    public static final Executor l;
    public static final Executor m;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f4471a = {".jpg", ".jpeg", ".png", ".webp", ".bmp", ".gif"};
    public static final String[] b = {".mp4", ".3gp", ".3gpp", ".mov", ".k3g", ".acc", ".avi", ".wmv"};
    public static final String[] c = {".aac", ".mp3", ".3gp", ".3gpp"};
    private static final Edition n = com.nexstreaming.app.kinemasterfree.a.f3245a;
    private static final Date o = a(0, 0, 0);
    private static final Date p = a(2016, 5, 15);
    private static final Date q = a(2016, 8, 1);
    private static final Date r = a(2016, 8, 1);
    private static final Date s = a(2016, 12, 31);
    public static final String d = null;

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
        Release
    }

    static {
        e = n != Edition.DeviceLock;
        f = VersionType.RC;
        g = n == Edition.PlayStore ? DataUsage.WIFI_AND_MOBILE : DataUsage.ASK_WIFI_MOBILE_NEVER;
        h = n == Edition.DeviceLock;
        i = null;
        j = n == Edition.PlayStore;
        k = n == Edition.PlayStore;
        l = Executors.newCachedThreadPool();
        m = Executors.newCachedThreadPool();
    }

    public static NexEditor a() {
        return KineMasterApplication.a().h();
    }

    public static String b() {
        return "Google";
    }

    public static void a(Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int c() {
        int i2 = 0;
        if (n == Edition.DeviceLock) {
            int i3 = 0;
            while (i3 < 4) {
                i3++;
                i2 = (i2 << 8) | 32;
            }
        } else if (n == Edition.TimeLock || n == Edition.PlayStore) {
            i2 = 33878;
            int i4 = 0;
            while (i4 < 1) {
                i4++;
                i2 = (i2 << 16) | 10309;
            }
        }
        return (i2 ^ 323616768) ^ 38286;
    }

    public static String d() {
        return Build.MODEL;
    }

    public static boolean e() {
        return n == Edition.PlayStore;
    }

    public static boolean a(Resources resources) {
        int i2 = resources.getConfiguration().screenLayout & 15;
        return i2 == 4 || i2 == 3;
    }

    public static boolean b(Resources resources) {
        return false;
    }

    public static int a(Context context, int i2) {
        float f2 = 0.0f;
        try {
            f2 = TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
        } catch (Exception e2) {
            Log.e("EditorGlobal", "getDpToPixel() Error");
        }
        return (int) f2;
    }

    public static String a(int i2) {
        return i2 >= 3600000 ? String.format(Locale.US, "%02d:%02d:%02d.%01d", Integer.valueOf(i2 / 3600000), Integer.valueOf((i2 % 3600000) / 60000), Integer.valueOf((i2 % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED), Integer.valueOf((i2 % LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / 100)) : i2 >= 60000 ? String.format(Locale.US, "%02d:%02d.%02d", Integer.valueOf(i2 / 60000), Integer.valueOf((i2 % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED), Integer.valueOf((i2 % LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / 10)) : String.format(Locale.US, "%02d.%03d", Integer.valueOf(i2 / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED), Integer.valueOf((i2 % LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / 1));
    }

    public static String b(int i2) {
        return i2 > 3600000 ? String.format(Locale.US, "%d:%02d:%02d.%01d", Integer.valueOf(i2 / 3600000), Integer.valueOf((i2 % 3600000) / 60000), Integer.valueOf((i2 % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED), Integer.valueOf((i2 % LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / 100)) : String.format(Locale.US, "%02d:%02d.%01d", Integer.valueOf((i2 % 3600000) / 60000), Integer.valueOf((i2 % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED), Integer.valueOf((i2 % LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / 100));
    }

    public static String a(Resources resources, int i2) {
        if (i2 >= 3600000) {
            return resources.getString(R.string.duration_h_m_s, Integer.valueOf(i2 / 3600000), Integer.valueOf((i2 % 3600000) / 60000), Integer.valueOf((i2 % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED), Integer.valueOf((i2 % LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / 100));
        }
        if (i2 >= 60000) {
            return resources.getString(R.string.duration_m_s, Integer.valueOf(i2 / 60000), Integer.valueOf((i2 % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED), Integer.valueOf((i2 % LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / 100));
        }
        return resources.getString(R.string.duration_s, Integer.valueOf(i2 / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED), Integer.valueOf((i2 % LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / 100));
    }

    public static String b(Resources resources, int i2) {
        if (i2 >= 3600000) {
            return resources.getString(R.string.export_time_h_m_s, Integer.valueOf(i2 / 3600000), Integer.valueOf((i2 % 3600000) / 60000), Integer.valueOf((i2 % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED));
        }
        if (i2 >= 60000) {
            return resources.getString(R.string.export_time_m_s, Integer.valueOf((i2 % 3600000) / 60000), Integer.valueOf((i2 % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED));
        }
        return resources.getString(R.string.export_time_s, Integer.valueOf(i2 / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED));
    }

    public static String a(long j2) {
        return j2 > 3600000 ? String.format(Locale.US, "%d:%02d:%02d", Long.valueOf(j2 / 3600000), Long.valueOf((j2 % 3600000) / 60000), Long.valueOf((j2 % 60000) / 1000)) : String.format(Locale.US, "%02d:%02d", Long.valueOf((j2 % 3600000) / 60000), Long.valueOf((j2 % 60000) / 1000));
    }

    public static String a(Context context, long j2) {
        if (j2 < 1) {
            return "?";
        }
        if (j2 < 1024) {
            return j2 + " B";
        }
        int log10 = (int) (Math.log10(j2) / 3.0103d);
        return String.format(context.getResources().getConfiguration().locale, "%.1f %sB", Double.valueOf(j2 / Math.pow(1024.0d, log10)), Character.valueOf("KMGTPE".charAt(log10 - 1)));
    }

    public static File f() {
        return Environment.getExternalStorageDirectory();
    }

    public static File g() {
        return new File(f().getAbsolutePath() + File.separator + "KineMaster");
    }

    public static File h() {
        return new File(f().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Log");
    }

    public static File i() {
        return new File(f().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Plugins");
    }

    public static String a(Context context) {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static File b(Context context) {
        if (context == null) {
            return new File(f().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Converted");
        }
        File file = new File(a(context) + File.separator + "KineMaster" + File.separator + "Converted");
        file.mkdirs();
        return file;
    }

    public static File c(Context context) {
        if (context == null) {
            return new File(f().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Reversed");
        }
        File file = new File(a(context) + File.separator + "KineMaster" + File.separator + "Reversed");
        file.mkdirs();
        return file;
    }

    public static File d(Context context) {
        if (context == null) {
            return new File(f().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Export");
        }
        return new File(a(context) + File.separator + "KineMaster" + File.separator + "Export");
    }

    public static File e(Context context) {
        if (context == null) {
            return new File(f().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Export");
        }
        File file = new File(a(context) + File.separator + "KineMaster" + File.separator + "Export");
        file.mkdirs();
        return file;
    }

    public static File f(Context context) {
        if (context == null) {
            return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Download");
        }
        File file = new File(context.getSharedPreferences("sdcardloc", 0).getString("sdcardlocation", Environment.getExternalStorageDirectory().getAbsolutePath()) + File.separator + "KineMaster" + File.separator + "Download");
        file.mkdirs();
        return file;
    }

    public static File j() {
        return new File(f().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Projects");
    }

    public static File k() {
        return new File(f().getAbsolutePath() + File.separator + "KineMaster" + File.separator + "Projects" + File.separator + "Overlays");
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        for (String str2 : f4471a) {
            if (lowerCase.endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        for (String str2 : b) {
            if (lowerCase.endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static Date a(int i2, int i3, int i4) {
        return a(i2, i3, i4, 0, 0, 0);
    }

    private static Date a(int i2, int i3, int i4, int i5, int i6, int i7) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.set(i2, i3 - 1, i4, i5, i6, i7);
        return gregorianCalendar.getTime();
    }

    public static Date l() {
        if (n == Edition.TimeLock) {
            return o;
        }
        if (j && f == VersionType.Beta) {
            return p;
        }
        if (j && f == VersionType.Dev) {
            return q;
        }
        if (f == VersionType.ShowDemo) {
            return r;
        }
        return null;
    }

    public static Date m() {
        return s;
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final File f4473a;

        @SuppressLint({"SimpleDateFormat"})
        public a(String str) {
            EditorGlobal.h().mkdirs();
            this.f4473a = new File(EditorGlobal.h(), str + ".log");
            a(null, "--- " + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + " -----------------------------------------");
        }

        public void a(String str, String str2) {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.f4473a, true));
                if (str == null) {
                    StringBuilder sb = new StringBuilder();
                    if (str2 == null) {
                        str2 = "(null)";
                    }
                    dataOutputStream.writeUTF(sb.append(str2).append("\n").toString());
                } else {
                    StringBuilder append = new StringBuilder().append(str).append(": ");
                    if (str2 == null) {
                        str2 = "(null)";
                    }
                    dataOutputStream.writeUTF(append.append(str2).append("\n").toString());
                }
                dataOutputStream.close();
            } catch (IOException e) {
            }
        }
    }

    public static String c(String str) {
        return d("com.nexstreaming.kinemaster.builtin.watermark." + str);
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
            sb.append((char) ((((("Ax/VXn_zsAiwFi[CITPC;y2c}*0B'S0-7&QznQlMa6U9gmSoighZeC&@$-hAaXiN".charAt((i3 + i5) % 64) + (str.charAt(i5) - ' ')) - cArr[(i4 + i5) % 8]) + 188) % 94) + 32));
        }
        return sb.toString();
    }

    public static boolean a(SharedPreferences sharedPreferences, boolean z) {
        switch (g) {
            case ASK_WIFI_MOBILE_NEVER:
                String string = sharedPreferences.getString("data_usage", "none");
                if (string.equalsIgnoreCase("mobile")) {
                    return true;
                }
                if (string.equalsIgnoreCase("wifi")) {
                    return z;
                }
                return false;
            case ASK_WIFI_OR_MOBILE:
                return z || sharedPreferences.getBoolean("mobile_updates", false);
            case NEVER:
            default:
                return false;
            case WIFI_AND_MOBILE:
                return true;
            case WIFI_ONLY:
                return z;
        }
    }

    public static boolean g(Context context) {
        return a(PreferenceManager.getDefaultSharedPreferences(context), com.nexstreaming.kinemaster.h.a.a(context));
    }

    public static int b(Context context, int i2) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("aud_rec_from_camcorder", "auto");
        if (!string.equals("auto")) {
            if (string.equals("mic")) {
                return 1;
            }
            if (string.equals("cam")) {
                return 5;
            }
            return i2;
        }
        return i2;
    }

    public static boolean n() {
        return PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.a().getApplicationContext()).getBoolean("export_diagnostics", false);
    }
}
