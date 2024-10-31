package com.google.android.gms.analytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzcz;
import com.google.android.gms.internal.gtm.zzq;
import com.google.android.gms.internal.gtm.zzv;
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

@VisibleForTesting
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes.dex */
public final class zzk {

    /* renamed from: a */
    private static volatile zzk f10374a;

    /* renamed from: b */
    private final Context f10375b;

    /* renamed from: c */
    private final List<zzn> f10376c;

    /* renamed from: d */
    private final zze f10377d;

    /* renamed from: e */
    private final a f10378e;

    /* renamed from: f */
    private volatile zzq f10379f;

    /* renamed from: g */
    private Thread.UncaughtExceptionHandler f10380g;

    /* loaded from: classes.dex */
    public class a extends ThreadPoolExecutor {
        public a() {
            super(1, 1, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
            setThreadFactory(new b(null));
            allowCoreThreadTimeOut(true);
        }

        @Override // java.util.concurrent.AbstractExecutorService
        protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new d(this, runnable, t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements ThreadFactory {

        /* renamed from: a */
        private static final AtomicInteger f10382a = new AtomicInteger();

        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            int incrementAndGet = f10382a.incrementAndGet();
            StringBuilder sb = new StringBuilder(23);
            sb.append("measurement-");
            sb.append(incrementAndGet);
            return new c(runnable, sb.toString());
        }

        /* synthetic */ b(com.google.android.gms.analytics.c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends Thread {
        c(Runnable runnable, String str) {
            super(runnable, str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    @VisibleForTesting
    private zzk(Context context) {
        Context applicationContext = context.getApplicationContext();
        Preconditions.a(applicationContext);
        this.f10375b = applicationContext;
        this.f10378e = new a();
        this.f10376c = new CopyOnWriteArrayList();
        this.f10377d = new zze();
    }

    public static zzk a(Context context) {
        Preconditions.a(context);
        if (f10374a == null) {
            synchronized (zzk.class) {
                if (f10374a == null) {
                    f10374a = new zzk(context);
                }
            }
        }
        return f10374a;
    }

    public static void d() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final zzq b() {
        if (this.f10379f == null) {
            synchronized (this) {
                if (this.f10379f == null) {
                    zzq zzqVar = new zzq();
                    PackageManager packageManager = this.f10375b.getPackageManager();
                    String packageName = this.f10375b.getPackageName();
                    zzqVar.setAppId(packageName);
                    zzqVar.setAppInstallerId(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.f10375b.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        String valueOf = String.valueOf(packageName);
                        Log.e("GAv4", valueOf.length() != 0 ? "Error retrieving package info: appName set to ".concat(valueOf) : new String("Error retrieving package info: appName set to "));
                    }
                    zzqVar.setAppName(packageName);
                    zzqVar.setAppVersion(str);
                    this.f10379f = zzqVar;
                }
            }
        }
        return this.f10379f;
    }

    public final zzv c() {
        DisplayMetrics displayMetrics = this.f10375b.getResources().getDisplayMetrics();
        zzv zzvVar = new zzv();
        zzvVar.setLanguage(zzcz.zza(Locale.getDefault()));
        zzvVar.zzul = displayMetrics.widthPixels;
        zzvVar.zzum = displayMetrics.heightPixels;
        return zzvVar;
    }

    public final void a(zzg zzgVar) {
        if (!zzgVar.i()) {
            if (!zzgVar.f()) {
                zzg a2 = zzgVar.a();
                a2.g();
                this.f10378e.execute(new com.google.android.gms.analytics.c(this, a2));
                return;
            }
            throw new IllegalStateException("Measurement can only be submitted once");
        }
        throw new IllegalStateException("Measurement prototype can't be submitted");
    }

    public final Context a() {
        return this.f10375b;
    }

    public final void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f10380g = uncaughtExceptionHandler;
    }

    public final <V> Future<V> a(Callable<V> callable) {
        Preconditions.a(callable);
        if (Thread.currentThread() instanceof c) {
            FutureTask futureTask = new FutureTask(callable);
            futureTask.run();
            return futureTask;
        }
        return this.f10378e.submit(callable);
    }

    public static void b(zzg zzgVar) {
        Preconditions.c("deliver should be called from worker thread");
        Preconditions.a(zzgVar.f(), "Measurement must be submitted");
        List<zzo> c2 = zzgVar.c();
        if (c2.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (zzo zzoVar : c2) {
            Uri c3 = zzoVar.c();
            if (!hashSet.contains(c3)) {
                hashSet.add(c3);
                zzoVar.a(zzgVar);
            }
        }
    }

    public final void a(Runnable runnable) {
        Preconditions.a(runnable);
        this.f10378e.submit(runnable);
    }
}
