package com.umeng.commonsdk.framework;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public class UMFrUtils {
    private static final String KEY_LAST_INSTANT_SUCC_BUILD_TIME = "last_instant_build_time";
    private static final String KEY_LAST_SUCC_BUILD_TIME = "last_successful_build_time";
    private static Object mEnvelopeBuildTimeLock = new Object();
    private static String mDefaultEnvelopeDir = "envelope";
    private static String mDefaultEnvelopeDirPath = null;
    private static Object mEnvelopeFileLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.umeng.commonsdk.framework.UMFrUtils$1 */
    /* loaded from: classes3.dex */
    public static class AnonymousClass1 implements Comparator<File> {

        /* renamed from: a */
        final /* synthetic */ Context f26031a;

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            String name = file.getName();
            String name2 = file2.getName();
            String createTimeFromFileName = UMFrUtils.getCreateTimeFromFileName(name);
            String createTimeFromFileName2 = UMFrUtils.getCreateTimeFromFileName(name2);
            if (!TextUtils.isEmpty(createTimeFromFileName) && !TextUtils.isEmpty(createTimeFromFileName2)) {
                try {
                    long longValue = Long.valueOf(createTimeFromFileName).longValue() - Long.valueOf(createTimeFromFileName2).longValue();
                    if (longValue > 0) {
                        return 1;
                    }
                    return longValue == 0 ? 0 : -1;
                } catch (NumberFormatException e2) {
                    UMCrashManager.reportCrash(context, e2);
                }
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.umeng.commonsdk.framework.UMFrUtils$2 */
    /* loaded from: classes3.dex */
    public static class AnonymousClass2 implements Comparator<File> {

        /* renamed from: a */
        final /* synthetic */ Context f26032a;

        AnonymousClass2(Context context) {
            context = context;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            String name = file.getName();
            String name2 = file2.getName();
            String createTimeFromFileName = UMFrUtils.getCreateTimeFromFileName(name);
            String createTimeFromFileName2 = UMFrUtils.getCreateTimeFromFileName(name2);
            if (!TextUtils.isEmpty(createTimeFromFileName) && !TextUtils.isEmpty(createTimeFromFileName2)) {
                try {
                    long longValue = Long.valueOf(createTimeFromFileName).longValue() - Long.valueOf(createTimeFromFileName2).longValue();
                    if (longValue > 0) {
                        return 1;
                    }
                    return longValue == 0 ? 0 : -1;
                } catch (NumberFormatException e2) {
                    UMCrashManager.reportCrash(context, e2);
                }
            }
            return 1;
        }
    }

    private static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(applicationContext, th);
                return false;
            }
        } else {
            try {
                if (applicationContext.getPackageManager().checkPermission(str, applicationContext.getPackageName()) != 0) {
                    return false;
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(applicationContext, th2);
                return false;
            }
        }
        return true;
    }

    public static int envelopeFileNumber(Context context) {
        String[] list;
        if (context != null) {
            try {
                File file = new File(getEnvelopeDirPath(context));
                synchronized (mEnvelopeFileLock) {
                    if (file.isDirectory() && (list = file.list()) != null) {
                        return list.length;
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
        return 0;
    }

    public static String getCreateTimeFromFileName(String str) {
        Context appContext = UMModuleRegister.getAppContext();
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(95) + 1;
            try {
                return str.substring(indexOf, str.indexOf(95, indexOf));
            } catch (IndexOutOfBoundsException e2) {
                UMCrashManager.reportCrash(appContext, e2);
            }
        }
        return "";
    }

    public static String getCurrentProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.size() <= 0) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
            return "";
        }
    }

    private static long getDistanceDays(long j, long j2) {
        return (j < j2 ? j2 - j : j - j2) / 86400000;
    }

    public static String getEnvelopeDirPath(Context context) {
        String str;
        synchronized (mEnvelopeFileLock) {
            try {
                if (mDefaultEnvelopeDirPath == null) {
                    mDefaultEnvelopeDirPath = context.getFilesDir().getAbsolutePath() + "/." + mDefaultEnvelopeDir;
                }
                File file = new File(mDefaultEnvelopeDirPath);
                if (!file.exists() && !file.mkdir()) {
                    ULog.d("--->>> Create Envelope Directory failed!!!");
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
            str = mDefaultEnvelopeDirPath;
        }
        return str;
    }

    public static File getEnvelopeFile(Context context) {
        if (context == null) {
            return null;
        }
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.2

                    /* renamed from: a */
                    final /* synthetic */ Context f26032a;

                    AnonymousClass2(Context context2) {
                        context = context2;
                    }

                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file22) {
                        String name = file2.getName();
                        String name2 = file22.getName();
                        String createTimeFromFileName = UMFrUtils.getCreateTimeFromFileName(name);
                        String createTimeFromFileName2 = UMFrUtils.getCreateTimeFromFileName(name2);
                        if (!TextUtils.isEmpty(createTimeFromFileName) && !TextUtils.isEmpty(createTimeFromFileName2)) {
                            try {
                                long longValue = Long.valueOf(createTimeFromFileName).longValue() - Long.valueOf(createTimeFromFileName2).longValue();
                                if (longValue > 0) {
                                    return 1;
                                }
                                return longValue == 0 ? 0 : -1;
                            } catch (NumberFormatException e2) {
                                UMCrashManager.reportCrash(context, e2);
                            }
                        }
                        return 1;
                    }
                });
                return listFiles[0];
            }
            return null;
        }
    }

    public static long getLastInstantBuildTime(Context context) {
        long j;
        synchronized (mEnvelopeBuildTimeLock) {
            j = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, 0L);
        }
        return j;
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        long j;
        synchronized (mEnvelopeBuildTimeLock) {
            j = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_SUCC_BUILD_TIME, 0L);
        }
        return j;
    }

    public static String getLegacyEnvelopeDir(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                ULog.d("--->>> getEnvelopeDir: can't get process name, use default envelope directory.");
                return mDefaultEnvelopeDir;
            }
            if (runningAppProcesses.size() == 0) {
                return mDefaultEnvelopeDir;
            }
            try {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == Process.myPid()) {
                        String replace = runningAppProcessInfo.processName.replace(':', '_');
                        ULog.d("--->>> getEnvelopeDir: use current process name as envelope directory.");
                        return replace;
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
        return mDefaultEnvelopeDir;
    }

    public static String getSubProcessName(Context context) {
        try {
            String currentProcessName = getCurrentProcessName(context);
            int indexOf = currentProcessName.indexOf(":");
            return indexOf < 0 ? currentProcessName.substring(context.getPackageName().length() + 1, currentProcessName.length()) : indexOf >= 0 ? currentProcessName.substring(indexOf + 1) : "";
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
            return "";
        }
    }

    public static boolean hasEnvelopeFile(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        File[] listFiles;
        String str = uMBusinessType == UMLogDataProtocol.UMBusinessType.U_INTERNAL ? e.aq : e.al;
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            try {
                try {
                    listFiles = file.listFiles();
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        if (file2.getName().startsWith(str)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } finally {
            }
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
            return false;
        }
    }

    public static boolean removeEnvelopeFile(File file) {
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            try {
                if (file != null) {
                    try {
                        if (file.exists()) {
                            return file.delete();
                        }
                    } catch (Throwable th) {
                        UMCrashManager.reportCrash(appContext, th);
                    }
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void removeRedundantEnvelopeFiles(Context context, int i) {
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > i) {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.1

                    /* renamed from: a */
                    final /* synthetic */ Context f26031a;

                    AnonymousClass1(Context context2) {
                        context = context2;
                    }

                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file22) {
                        String name = file2.getName();
                        String name2 = file22.getName();
                        String createTimeFromFileName = UMFrUtils.getCreateTimeFromFileName(name);
                        String createTimeFromFileName2 = UMFrUtils.getCreateTimeFromFileName(name2);
                        if (!TextUtils.isEmpty(createTimeFromFileName) && !TextUtils.isEmpty(createTimeFromFileName2)) {
                            try {
                                long longValue = Long.valueOf(createTimeFromFileName).longValue() - Long.valueOf(createTimeFromFileName2).longValue();
                                if (longValue > 0) {
                                    return 1;
                                }
                                return longValue == 0 ? 0 : -1;
                            } catch (NumberFormatException e2) {
                                UMCrashManager.reportCrash(context, e2);
                            }
                        }
                        return 1;
                    }
                });
                if (listFiles.length > i) {
                    for (int i2 = 0; i2 < listFiles.length - i; i2++) {
                        try {
                            if (!listFiles[i2].delete()) {
                                ULog.d("--->>> remove [" + i2 + "] file fail.");
                            }
                        } catch (Throwable th) {
                            UMCrashManager.reportCrash(context2, th);
                        }
                    }
                }
            }
        }
    }

    public static int saveEnvelopeFile(Context context, String str, byte[] bArr) {
        if (bArr == null) {
            return 101;
        }
        File file = new File(getEnvelopeDirPath(context) + "/" + str);
        synchronized (mEnvelopeFileLock) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.close();
                        boolean a2 = com.umeng.commonsdk.statistics.internal.a.a(context).a(str);
                        boolean b2 = com.umeng.commonsdk.statistics.internal.a.a(context).b(str);
                        if (a2) {
                            updateLastSuccessfulBuildTime(context);
                        }
                        if (b2) {
                            updateLastInstantBuildTime(context);
                        }
                        return 0;
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        UMCrashManager.reportCrash(context, e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th) {
                                UMCrashManager.reportCrash(context, th);
                            }
                        }
                        return 101;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                UMCrashManager.reportCrash(context, th3);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public static void syncLegacyEnvelopeIfNeeded(Context context) {
        String legacyEnvelopeDir;
        if (context == null) {
            return;
        }
        try {
            legacyEnvelopeDir = getLegacyEnvelopeDir(context);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        if (TextUtils.isEmpty(legacyEnvelopeDir) || legacyEnvelopeDir.equals(mDefaultEnvelopeDir)) {
            return;
        }
        File file = new File(context.getFilesDir().getAbsolutePath() + "/." + legacyEnvelopeDir);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                try {
                    String envelopeDirPath = getEnvelopeDirPath(context);
                    for (int i = 0; i < listFiles.length; i++) {
                        listFiles[i].renameTo(new File(envelopeDirPath + "/" + listFiles[i].getName()));
                    }
                    if (file.isDirectory()) {
                        file.delete();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    UMCrashManager.reportCrash(context, th2);
                    return;
                }
            }
            try {
                if (file.isDirectory()) {
                    file.delete();
                    return;
                }
                return;
            } catch (Throwable th3) {
                UMCrashManager.reportCrash(context, th3);
                return;
            }
            UMCrashManager.reportCrash(context, th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5 */
    public static byte[] toByteArray(String str) throws IOException {
        IOException e2;
        FileChannel channel;
        byte[] bArr;
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            try {
                try {
                    channel = new RandomAccessFile(str, "r").getChannel();
                } catch (IOException e3) {
                    e2 = e3;
                } catch (Throwable th) {
                    th = th;
                    str = 0;
                    try {
                        str.close();
                    } catch (Throwable th2) {
                        UMCrashManager.reportCrash(appContext, th2);
                    }
                    throw th;
                }
                try {
                    MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).load();
                    System.out.println(load.isLoaded());
                    bArr = new byte[(int) channel.size()];
                    if (load.remaining() > 0) {
                        load.get(bArr, 0, load.remaining());
                    }
                    try {
                        channel.close();
                    } catch (Throwable th3) {
                        UMCrashManager.reportCrash(appContext, th3);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    UMCrashManager.reportCrash(appContext, e2);
                    throw e2;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        return bArr;
    }

    private static void updateLastInstantBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }

    private static void updateLastSuccessfulBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }
}
