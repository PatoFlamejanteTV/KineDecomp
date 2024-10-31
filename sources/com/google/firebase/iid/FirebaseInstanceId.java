package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class FirebaseInstanceId {

    /* renamed from: a, reason: collision with root package name */
    private static final long f17309a = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: b, reason: collision with root package name */
    private static C1620r f17310b;

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    private static ScheduledThreadPoolExecutor f17311c;

    /* renamed from: d, reason: collision with root package name */
    private final Executor f17312d;

    /* renamed from: e, reason: collision with root package name */
    private final FirebaseApp f17313e;

    /* renamed from: f, reason: collision with root package name */
    private final zzan f17314f;

    /* renamed from: g, reason: collision with root package name */
    private MessagingChannel f17315g;

    /* renamed from: h, reason: collision with root package name */
    private final C1616m f17316h;
    private final v i;
    private boolean j;
    private final a k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseInstanceId(FirebaseApp firebaseApp, Subscriber subscriber) {
        this(firebaseApp, new zzan(firebaseApp.b()), A.b(), A.b(), subscriber);
    }

    public static FirebaseInstanceId b() {
        return getInstance(FirebaseApp.c());
    }

    @Keep
    public static FirebaseInstanceId getInstance(FirebaseApp firebaseApp) {
        return (FirebaseInstanceId) firebaseApp.a(FirebaseInstanceId.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
    }

    private final synchronized void n() {
        if (!this.j) {
            a(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        s f2 = f();
        if (!k() || f2 == null || f2.b(this.f17314f.b()) || this.i.a()) {
            n();
        }
    }

    private static String p() {
        return zzan.a(f17310b.b("").a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(boolean z) {
        this.j = z;
    }

    public Task<InstanceIdResult> c() {
        return b(zzan.a(this.f17313e), "*");
    }

    @Deprecated
    public String d() {
        s f2 = f();
        if (f2 == null || f2.b(this.f17314f.b())) {
            n();
        }
        if (f2 != null) {
            return f2.f17380b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final FirebaseApp e() {
        return this.f17313e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final s f() {
        return c(zzan.a(this.f17313e), "*");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String g() throws IOException {
        return a(zzan.a(this.f17313e), "*");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void i() {
        f17310b.b();
        if (this.k.a()) {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean j() {
        return this.f17315g.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k() {
        return this.f17315g.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l() throws IOException {
        a(this.f17315g.a(p(), s.a(f())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m() {
        f17310b.c("");
        n();
    }

    private final Task<InstanceIdResult> b(final String str, final String str2) {
        final String c2 = c(str2);
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f17312d.execute(new Runnable(this, str, str2, taskCompletionSource, c2) { // from class: com.google.firebase.iid.E

            /* renamed from: a, reason: collision with root package name */
            private final FirebaseInstanceId f17299a;

            /* renamed from: b, reason: collision with root package name */
            private final String f17300b;

            /* renamed from: c, reason: collision with root package name */
            private final String f17301c;

            /* renamed from: d, reason: collision with root package name */
            private final TaskCompletionSource f17302d;

            /* renamed from: e, reason: collision with root package name */
            private final String f17303e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f17299a = this;
                this.f17300b = str;
                this.f17301c = str2;
                this.f17302d = taskCompletionSource;
                this.f17303e = c2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f17299a.a(this.f17300b, this.f17301c, this.f17302d, this.f17303e);
            }
        });
        return taskCompletionSource.a();
    }

    @VisibleForTesting
    private static s c(String str, String str2) {
        return f17310b.a("", str, str2);
    }

    private static String c(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(long j) {
        a(new t(this, this.f17314f, this.i, Math.min(Math.max(30L, j << 1), f17309a)), j);
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: b, reason: collision with root package name */
        private final Subscriber f17318b;

        /* renamed from: c, reason: collision with root package name */
        private EventHandler<DataCollectionDefaultChange> f17319c;

        /* renamed from: a, reason: collision with root package name */
        private final boolean f17317a = c();

        /* renamed from: d, reason: collision with root package name */
        private Boolean f17320d = b();

        a(Subscriber subscriber) {
            this.f17318b = subscriber;
            if (this.f17320d == null && this.f17317a) {
                this.f17319c = new EventHandler(this) { // from class: com.google.firebase.iid.H

                    /* renamed from: a, reason: collision with root package name */
                    private final FirebaseInstanceId.a f17329a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f17329a = this;
                    }

                    @Override // com.google.firebase.events.EventHandler
                    public final void a(Event event) {
                        FirebaseInstanceId.a aVar = this.f17329a;
                        synchronized (aVar) {
                            if (aVar.a()) {
                                FirebaseInstanceId.this.o();
                            }
                        }
                    }
                };
                subscriber.a(DataCollectionDefaultChange.class, this.f17319c);
            }
        }

        private final Boolean b() {
            ApplicationInfo applicationInfo;
            Context b2 = FirebaseInstanceId.this.f17313e.b();
            SharedPreferences sharedPreferences = b2.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = b2.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(b2.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        private final boolean c() {
            try {
                Class.forName("com.google.firebase.messaging.FirebaseMessaging");
                return true;
            } catch (ClassNotFoundException unused) {
                Context b2 = FirebaseInstanceId.this.f17313e.b();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(b2.getPackageName());
                ResolveInfo resolveService = b2.getPackageManager().resolveService(intent, 0);
                return (resolveService == null || resolveService.serviceInfo == null) ? false : true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final synchronized boolean a() {
            if (this.f17320d != null) {
                return this.f17320d.booleanValue();
            }
            return this.f17317a && FirebaseInstanceId.this.f17313e.g();
        }

        final synchronized void a(boolean z) {
            if (this.f17319c != null) {
                this.f17318b.b(DataCollectionDefaultChange.class, this.f17319c);
                this.f17319c = null;
            }
            SharedPreferences.Editor edit = FirebaseInstanceId.this.f17313e.b().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z);
            edit.apply();
            if (z) {
                FirebaseInstanceId.this.o();
            }
            this.f17320d = Boolean.valueOf(z);
        }
    }

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzan zzanVar, Executor executor, Executor executor2, Subscriber subscriber) {
        this.j = false;
        if (zzan.a(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (f17310b == null) {
                    f17310b = new C1620r(firebaseApp.b());
                }
            }
            this.f17313e = firebaseApp;
            this.f17314f = zzanVar;
            if (this.f17315g == null) {
                MessagingChannel messagingChannel = (MessagingChannel) firebaseApp.a(MessagingChannel.class);
                if (messagingChannel != null && messagingChannel.b()) {
                    this.f17315g = messagingChannel;
                } else {
                    this.f17315g = new I(firebaseApp, zzanVar, executor);
                }
            }
            this.f17315g = this.f17315g;
            this.f17312d = executor2;
            this.i = new v(f17310b);
            this.k = new a(subscriber);
            this.f17316h = new C1616m(executor);
            if (this.k.a()) {
                o();
                return;
            }
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str) throws IOException {
        s f2 = f();
        if (f2 != null && !f2.b(this.f17314f.b())) {
            a(this.f17315g.a(p(), f2.f17380b, str));
            return;
        }
        throw new IOException("token not available");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (f17311c == null) {
                f17311c = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            f17311c.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    @VisibleForTesting
    public final void b(boolean z) {
        this.k.a(z);
    }

    public String a() {
        o();
        return p();
    }

    public String a(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((InstanceIdResult) a(b(str, str2))).a();
        }
        throw new IOException("MAIN_THREAD");
    }

    private final <T> T a(Task<T> task) throws IOException {
        try {
            return (T) Tasks.a(task, com.umeng.commonsdk.proguard.c.f26227d, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    i();
                }
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) throws IOException {
        s f2 = f();
        if (f2 != null && !f2.b(this.f17314f.b())) {
            a(this.f17315g.b(p(), f2.f17380b, str));
            return;
        }
        throw new IOException("token not available");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(final String str, String str2, final TaskCompletionSource taskCompletionSource, final String str3) {
        final String p = p();
        s c2 = c(str, str2);
        if (c2 != null && !c2.b(this.f17314f.b())) {
            taskCompletionSource.a((TaskCompletionSource) new N(p, c2.f17380b));
        } else {
            final String a2 = s.a(c2);
            this.f17316h.a(str, str3, new InterfaceC1618o(this, p, a2, str, str3) { // from class: com.google.firebase.iid.F

                /* renamed from: a, reason: collision with root package name */
                private final FirebaseInstanceId f17304a;

                /* renamed from: b, reason: collision with root package name */
                private final String f17305b;

                /* renamed from: c, reason: collision with root package name */
                private final String f17306c;

                /* renamed from: d, reason: collision with root package name */
                private final String f17307d;

                /* renamed from: e, reason: collision with root package name */
                private final String f17308e;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f17304a = this;
                    this.f17305b = p;
                    this.f17306c = a2;
                    this.f17307d = str;
                    this.f17308e = str3;
                }

                @Override // com.google.firebase.iid.InterfaceC1618o
                public final Task a() {
                    return this.f17304a.a(this.f17305b, this.f17306c, this.f17307d, this.f17308e);
                }
            }).a(this.f17312d, new OnCompleteListener(this, str, str3, taskCompletionSource, p) { // from class: com.google.firebase.iid.G

                /* renamed from: a, reason: collision with root package name */
                private final FirebaseInstanceId f17324a;

                /* renamed from: b, reason: collision with root package name */
                private final String f17325b;

                /* renamed from: c, reason: collision with root package name */
                private final String f17326c;

                /* renamed from: d, reason: collision with root package name */
                private final TaskCompletionSource f17327d;

                /* renamed from: e, reason: collision with root package name */
                private final String f17328e;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f17324a = this;
                    this.f17325b = str;
                    this.f17326c = str3;
                    this.f17327d = taskCompletionSource;
                    this.f17328e = p;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f17324a.a(this.f17325b, this.f17326c, this.f17327d, this.f17328e, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str, String str2, TaskCompletionSource taskCompletionSource, String str3, Task task) {
        if (task.e()) {
            String str4 = (String) task.b();
            f17310b.a("", str, str2, str4, this.f17314f.b());
            taskCompletionSource.a((TaskCompletionSource) new N(str3, str4));
            return;
        }
        taskCompletionSource.a(task.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task a(String str, String str2, String str3, String str4) {
        return this.f17315g.a(str, str2, str3, str4);
    }
}
