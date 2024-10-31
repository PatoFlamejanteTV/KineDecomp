package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.java */
/* loaded from: classes3.dex */
public final class N {

    /* renamed from: a */
    static final StringBuilder f25600a = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Utils.java */
    @TargetApi(11)
    /* loaded from: classes3.dex */
    public static class a {
        static int a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Utils.java */
    @TargetApi(12)
    /* loaded from: classes3.dex */
    public static class b {
        static int a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Utils.java */
    /* loaded from: classes3.dex */
    public static class c {
        static Downloader a(Context context) {
            return new v(context);
        }
    }

    /* compiled from: Utils.java */
    /* loaded from: classes3.dex */
    private static class d extends Thread {
        public d(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* compiled from: Utils.java */
    /* loaded from: classes3.dex */
    static class e implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new d(runnable);
        }
    }

    public static int a(Bitmap bitmap) {
        int rowBytes;
        if (Build.VERSION.SDK_INT >= 12) {
            rowBytes = b.a(bitmap);
        } else {
            rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (rowBytes >= 0) {
            return rowBytes;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    static boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static Downloader c(Context context) {
        try {
            Class.forName("com.squareup.okhttp.C");
            return c.a(context);
        } catch (ClassNotFoundException unused) {
            return new L(context);
        }
    }

    public static boolean d(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static File b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static byte[] c(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static void a() {
        if (!b()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    public static boolean b(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[12];
        return inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) && "WEBP".equals(new String(bArr, 8, 4, "US-ASCII"));
    }

    public static String a(RunnableC2396i runnableC2396i) {
        return a(runnableC2396i, "");
    }

    public static String a(RunnableC2396i runnableC2396i, String str) {
        StringBuilder sb = new StringBuilder(str);
        AbstractC2388a c2 = runnableC2396i.c();
        if (c2 != null) {
            sb.append(c2.f25623b.d());
        }
        List<AbstractC2388a> d2 = runnableC2396i.d();
        if (d2 != null) {
            int size = d2.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || c2 != null) {
                    sb.append(", ");
                }
                sb.append(d2.get(i).f25623b.d());
            }
        }
        return sb.toString();
    }

    public static void a(String str, String str2, String str3) {
        a(str, str2, str3, "");
    }

    public static void a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", str, str2, str3, str4));
    }

    public static String a(C c2) {
        String a2 = a(c2, f25600a);
        f25600a.setLength(0);
        return a2;
    }

    static String a(C c2, StringBuilder sb) {
        String str = c2.f25549g;
        if (str != null) {
            sb.ensureCapacity(str.length() + 50);
            sb.append(c2.f25549g);
        } else {
            Uri uri = c2.f25547e;
            if (uri != null) {
                String uri2 = uri.toString();
                sb.ensureCapacity(uri2.length() + 50);
                sb.append(uri2);
            } else {
                sb.ensureCapacity(50);
                sb.append(c2.f25548f);
            }
        }
        sb.append('\n');
        if (c2.n != 0.0f) {
            sb.append("rotation:");
            sb.append(c2.n);
            if (c2.q) {
                sb.append('@');
                sb.append(c2.o);
                sb.append('x');
                sb.append(c2.p);
            }
            sb.append('\n');
        }
        if (c2.c()) {
            sb.append("resize:");
            sb.append(c2.i);
            sb.append('x');
            sb.append(c2.j);
            sb.append('\n');
        }
        if (c2.k) {
            sb.append("centerCrop");
            sb.append('\n');
        } else if (c2.l) {
            sb.append("centerInside");
            sb.append('\n');
        }
        List<J> list = c2.f25550h;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(c2.f25550h.get(i).key());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public static void a(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException unused) {
        }
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split(" ", 2);
        if ("CACHE".equals(split[0])) {
            return true;
        }
        if (split.length == 1) {
            return false;
        }
        try {
            if ("CONDITIONAL_CACHE".equals(split[0])) {
                return Integer.parseInt(split[1]) == 304;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static long a(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (statFs.getBlockCount() * statFs.getBlockSize()) / 50;
        } catch (IllegalArgumentException unused) {
            j = 5242880;
        }
        return Math.max(Math.min(j, 52428800L), 5242880L);
    }

    public static int a(Context context) {
        ActivityManager activityManager = (ActivityManager) a(context, "activity");
        boolean z = (context.getApplicationInfo().flags & 1048576) != 0;
        int memoryClass = activityManager.getMemoryClass();
        if (z && Build.VERSION.SDK_INT >= 11) {
            memoryClass = a.a(activityManager);
        }
        return (memoryClass * 1048576) / 7;
    }

    public static <T> T a(Context context, String str) {
        return (T) context.getSystemService(str);
    }

    public static int a(Resources resources, C c2) throws FileNotFoundException {
        Uri uri;
        if (c2.f25548f == 0 && (uri = c2.f25547e) != null) {
            String authority = uri.getAuthority();
            if (authority != null) {
                List<String> pathSegments = c2.f25547e.getPathSegments();
                if (pathSegments != null && !pathSegments.isEmpty()) {
                    if (pathSegments.size() == 1) {
                        try {
                            return Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Last path segment is not a resource ID: " + c2.f25547e);
                        }
                    }
                    if (pathSegments.size() == 2) {
                        return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    }
                    throw new FileNotFoundException("More than two path segments: " + c2.f25547e);
                }
                throw new FileNotFoundException("No path segments: " + c2.f25547e);
            }
            throw new FileNotFoundException("No package provided: " + c2.f25547e);
        }
        return c2.f25548f;
    }

    public static Resources a(Context context, C c2) throws FileNotFoundException {
        Uri uri;
        if (c2.f25548f == 0 && (uri = c2.f25547e) != null) {
            String authority = uri.getAuthority();
            if (authority != null) {
                try {
                    return context.getPackageManager().getResourcesForApplication(authority);
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new FileNotFoundException("Unable to obtain resources for package: " + c2.f25547e);
                }
            }
            throw new FileNotFoundException("No package provided: " + c2.f25547e);
        }
        return context.getResources();
    }

    public static void a(Looper looper) {
        M m = new M(looper);
        m.sendMessageDelayed(m.obtainMessage(), 1000L);
    }
}
