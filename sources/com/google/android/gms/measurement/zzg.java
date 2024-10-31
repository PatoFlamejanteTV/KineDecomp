package com.google.android.gms.measurement;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpd;
import java.lang.Thread;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class zzg {

    /* renamed from: a, reason: collision with root package name */
    private static volatile zzg f2079a;
    private final Context b;
    private final List<zzh> c;
    private final zzb d;
    private final a e;
    private volatile zzpb f;
    private Thread.UncaughtExceptionHandler g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends ThreadPoolExecutor {
        public a() {
            super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            setThreadFactory(new b(null));
        }

        @Override // java.util.concurrent.AbstractExecutorService
        protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new e(this, runnable, t);
        }
    }

    /* loaded from: classes.dex */
    private static class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private static final AtomicInteger f2081a = new AtomicInteger();

        private b() {
        }

        /* synthetic */ b(d dVar) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new c(runnable, "measurement-" + f2081a.incrementAndGet());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Thread {
        c(Runnable runnable, String str) {
            super(runnable, str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    zzg(Context context) {
        Context applicationContext = context.getApplicationContext();
        zzx.a(applicationContext);
        this.b = applicationContext;
        this.e = new a();
        this.c = new CopyOnWriteArrayList();
        this.d = new zzb();
    }

    public static zzg a(Context context) {
        zzx.a(context);
        if (f2079a == null) {
            synchronized (zzg.class) {
                if (f2079a == null) {
                    f2079a = new zzg(context);
                }
            }
        }
        return f2079a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(zzc zzcVar) {
        zzx.c("deliver should be called from worker thread");
        zzx.b(zzcVar.f(), "Measurement must be submitted");
        List<zzi> c2 = zzcVar.c();
        if (c2.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (zzi zziVar : c2) {
            Uri a2 = zziVar.a();
            if (!hashSet.contains(a2)) {
                hashSet.add(a2);
                zziVar.a(zzcVar);
            }
        }
    }

    public static void d() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public zzpb a() {
        if (this.f == null) {
            synchronized (this) {
                if (this.f == null) {
                    zzpb zzpbVar = new zzpb();
                    PackageManager packageManager = this.b.getPackageManager();
                    String packageName = this.b.getPackageName();
                    zzpbVar.setAppId(packageName);
                    zzpbVar.setAppInstallerId(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.b.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.e("GAv4", "Error retrieving package info: appName set to " + packageName);
                    }
                    zzpbVar.setAppName(packageName);
                    zzpbVar.setAppVersion(str);
                    this.f = zzpbVar;
                }
            }
        }
        return this.f;
    }

    public <V> Future<V> a(Callable<V> callable) {
        zzx.a(callable);
        if (!(Thread.currentThread() instanceof c)) {
            return this.e.submit(callable);
        }
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(zzc zzcVar) {
        if (zzcVar.j()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        }
        if (zzcVar.f()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        }
        zzc a2 = zzcVar.a();
        a2.g();
        this.e.execute(new d(this, a2));
    }

    public void a(Runnable runnable) {
        zzx.a(runnable);
        this.e.submit(runnable);
    }

    public void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.g = uncaughtExceptionHandler;
    }

    public zzpd b() {
        DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
        zzpd zzpdVar = new zzpd();
        zzpdVar.setLanguage(zzam.a(Locale.getDefault()));
        zzpdVar.zzhX(displayMetrics.widthPixels);
        zzpdVar.zzhY(displayMetrics.heightPixels);
        return zzpdVar;
    }

    public Context c() {
        return this.b;
    }
}
