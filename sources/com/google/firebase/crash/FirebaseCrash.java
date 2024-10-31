package com.google.firebase.crash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.crash.zzg;
import com.google.android.gms.internal.crash.zzh;
import com.google.android.gms.internal.crash.zzi;
import com.google.android.gms.internal.crash.zzj;
import com.google.android.gms.internal.crash.zzm;
import com.google.android.gms.internal.crash.zzq;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import java.lang.Thread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@Deprecated
/* loaded from: classes2.dex */
public class FirebaseCrash {

    /* renamed from: a, reason: collision with root package name */
    private static volatile FirebaseCrash f16601a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<zzd> f16602b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f16603c;

    /* renamed from: d, reason: collision with root package name */
    private final ExecutorService f16604d;

    /* renamed from: e, reason: collision with root package name */
    private final FirebaseApp f16605e;

    /* renamed from: f, reason: collision with root package name */
    private final a f16606f;

    /* renamed from: g, reason: collision with root package name */
    private final CountDownLatch f16607g;

    /* renamed from: h, reason: collision with root package name */
    private zzq f16608h;
    private String i;

    @VisibleForTesting
    /* loaded from: classes2.dex */
    class b implements Thread.UncaughtExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        private final Thread.UncaughtExceptionHandler f16611a;

        public b(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f16611a = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th) {
            Log.e("UncaughtException", "", th);
            if (!FirebaseCrash.this.b()) {
                try {
                    FirebaseCrash.this.c();
                    Future<?> a2 = FirebaseCrash.this.a(th);
                    if (a2 != null) {
                        a2.get(10000L, TimeUnit.MILLISECONDS);
                    }
                } catch (Exception e2) {
                    Log.e("UncaughtException", "Ouch! My own exception handler threw an exception.", e2);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f16611a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface zza {
        zzm zzh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum zzd {
        UNSPECIFIED,
        ENABLED,
        DISABLED
    }

    @Keep
    public FirebaseCrash(FirebaseApp firebaseApp) {
        this.f16602b = new AtomicReference<>(zzd.UNSPECIFIED);
        this.f16606f = new a(null);
        this.f16607g = new CountDownLatch(1);
        throw new IllegalStateException("This method shouldn't be invoked");
    }

    public static FirebaseCrash a() {
        if (f16601a == null) {
            f16601a = getInstance(FirebaseApp.c());
        }
        return f16601a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        try {
            this.f16607g.await(20000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            Log.e("FirebaseCrash", "Failed waiting for crash api to load.", e2);
        }
    }

    @VisibleForTesting
    private final boolean e() {
        if (b()) {
            return false;
        }
        d();
        zzd zzdVar = this.f16602b.get();
        if (this.f16606f.zzh() != null) {
            if (zzdVar != zzd.UNSPECIFIED) {
                if (zzdVar == zzd.ENABLED) {
                    return true;
                }
            } else if (FirebaseApp.c().g()) {
                return true;
            }
        }
        return false;
    }

    private final zzd f() {
        SharedPreferences sharedPreferences = this.f16603c.getSharedPreferences("FirebaseCrashSharedPrefs", 0);
        try {
            if (sharedPreferences.contains("firebase_crash_collection_enabled")) {
                if (sharedPreferences.getBoolean("firebase_crash_collection_enabled", false)) {
                    return zzd.ENABLED;
                }
                return zzd.DISABLED;
            }
        } catch (ClassCastException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.d("FirebaseCrash", valueOf.length() != 0 ? "Unable to access enable value: ".concat(valueOf) : new String("Unable to access enable value: "));
        }
        Boolean g2 = g();
        if (g2 == null) {
            return zzd.UNSPECIFIED;
        }
        return g2.booleanValue() ? zzd.ENABLED : zzd.DISABLED;
    }

    private final Boolean g() {
        try {
            Bundle bundle = this.f16603c.getPackageManager().getApplicationInfo(this.f16603c.getPackageName(), 128).metaData;
            if (bundle.containsKey("firebase_crash_collection_enabled")) {
                return Boolean.valueOf(bundle.getBoolean("firebase_crash_collection_enabled", false));
            }
            return null;
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.e("FirebaseCrash", valueOf.length() != 0 ? "No crash enable meta data found: ".concat(valueOf) : new String("No crash enable meta data found: "));
            return null;
        }
    }

    @Keep
    public static FirebaseCrash getInstance(FirebaseApp firebaseApp) {
        return (FirebaseCrash) firebaseApp.a(FirebaseCrash.class);
    }

    @VisibleForTesting
    public final boolean b() {
        return this.f16604d.isShutdown();
    }

    final void c() {
        if (this.i == null && !b() && e()) {
            this.i = FirebaseInstanceId.b().a();
            this.f16604d.execute(new zzj(this.f16603c, this.f16606f, this.i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a implements zza {

        /* renamed from: a, reason: collision with root package name */
        private final Object f16609a;

        /* renamed from: b, reason: collision with root package name */
        private zzm f16610b;

        private a() {
            this.f16609a = new Object();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzm zzmVar) {
            synchronized (this.f16609a) {
                this.f16610b = zzmVar;
            }
        }

        @Override // com.google.firebase.crash.FirebaseCrash.zza
        public final zzm zzh() {
            zzm zzmVar;
            synchronized (this.f16609a) {
                zzmVar = this.f16610b;
            }
            return zzmVar;
        }

        /* synthetic */ a(d dVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzm zzmVar) {
        zzq zzqVar;
        if (zzmVar == null) {
            this.f16604d.shutdownNow();
        } else {
            AnalyticsConnector analyticsConnector = (AnalyticsConnector) this.f16605e.a(AnalyticsConnector.class);
            if (analyticsConnector == null) {
                Log.w("FirebaseCrashAnalytics", "Unable to log event, missing Google Analytics for Firebase library");
                zzqVar = null;
            } else {
                zzqVar = new zzq(analyticsConnector);
            }
            this.f16608h = zzqVar;
            this.f16606f.a(zzmVar);
            if (this.f16608h != null && !b()) {
                this.f16608h.zza(this.f16603c, this.f16604d, this.f16606f);
                Log.d("FirebaseCrash", "Firebase Analytics Listener for Firebase Crash is initialized");
            }
        }
        this.f16607g.countDown();
        if (FirebaseApp.c().g()) {
            return;
        }
        a(false, false);
    }

    public FirebaseCrash(FirebaseApp firebaseApp, Subscriber subscriber) {
        this(firebaseApp, subscriber, null);
        zzf zzfVar = new zzf(firebaseApp);
        Thread.setDefaultUncaughtExceptionHandler(new b(Thread.getDefaultUncaughtExceptionHandler()));
        e eVar = new e(this);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        newFixedThreadPool.submit(new g(zzfVar, newFixedThreadPool.submit(new f(zzfVar)), 10000L, eVar));
        newFixedThreadPool.shutdown();
        this.f16604d.execute(new d(this));
    }

    private final synchronized void a(final boolean z, final boolean z2) {
        if (b()) {
            return;
        }
        if (z2 || this.f16602b.get() == zzd.UNSPECIFIED) {
            zzi zziVar = new zzi(this.f16603c, this.f16606f, z);
            zziVar.getTask().a(new OnSuccessListener(this, z2, z) { // from class: com.google.firebase.crash.c

                /* renamed from: a, reason: collision with root package name */
                private final FirebaseCrash f16615a;

                /* renamed from: b, reason: collision with root package name */
                private final boolean f16616b;

                /* renamed from: c, reason: collision with root package name */
                private final boolean f16617c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f16615a = this;
                    this.f16616b = z2;
                    this.f16617c = z;
                }

                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f16615a.a(this.f16616b, this.f16617c, (Void) obj);
                }
            });
            this.f16604d.execute(zziVar);
        }
    }

    @VisibleForTesting
    private FirebaseCrash(FirebaseApp firebaseApp, Subscriber subscriber, ExecutorService executorService) {
        this.f16602b = new AtomicReference<>(zzd.UNSPECIFIED);
        this.f16606f = new a(null);
        this.f16607g = new CountDownLatch(1);
        this.f16605e = firebaseApp;
        this.f16603c = firebaseApp.b();
        this.f16602b.set(f());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f16604d = threadPoolExecutor;
        subscriber.a(DataCollectionDefaultChange.class, com.google.firebase.crash.a.f16613a, new EventHandler(this) { // from class: com.google.firebase.crash.b

            /* renamed from: a, reason: collision with root package name */
            private final FirebaseCrash f16614a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16614a = this;
            }

            @Override // com.google.firebase.events.EventHandler
            public final void a(Event event) {
                this.f16614a.a(event);
            }
        });
    }

    final Future<?> a(Throwable th) {
        if (th == null || b()) {
            return null;
        }
        return this.f16604d.submit(new zzg(this.f16603c, this.f16606f, th, this.f16608h));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        if (b()) {
            return;
        }
        this.f16604d.submit(new zzh(this.f16603c, this.f16606f, z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(boolean z, boolean z2, Void r4) {
        if (z) {
            this.f16602b.set(z2 ? zzd.ENABLED : zzd.DISABLED);
            this.f16603c.getSharedPreferences("FirebaseCrashSharedPrefs", 0).edit().putBoolean("firebase_crash_collection_enabled", z2).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Event event) {
        a(((DataCollectionDefaultChange) event.a()).f16320a, false);
    }
}
