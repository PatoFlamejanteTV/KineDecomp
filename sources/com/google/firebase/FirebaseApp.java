package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.events.Publisher;
import com.google.firebase.internal.DefaultIdTokenListenersCountChangedListener;
import com.google.firebase.internal.InternalTokenProvider;
import com.google.firebase.internal.InternalTokenResult;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
@PublicApi
/* loaded from: classes.dex */
public class FirebaseApp {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f16321a = Arrays.asList("com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId");

    /* renamed from: b, reason: collision with root package name */
    private static final List<String> f16322b = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");

    /* renamed from: c, reason: collision with root package name */
    private static final List<String> f16323c = Arrays.asList("com.google.android.gms.measurement.AppMeasurement");

    /* renamed from: d, reason: collision with root package name */
    private static final List<String> f16324d = Arrays.asList(new String[0]);

    /* renamed from: e, reason: collision with root package name */
    private static final Set<String> f16325e = Collections.emptySet();

    /* renamed from: f, reason: collision with root package name */
    private static final Object f16326f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static final Executor f16327g = new b();

    /* renamed from: h, reason: collision with root package name */
    static final Map<String, FirebaseApp> f16328h = new ArrayMap();
    private final Context i;
    private final String j;
    private final FirebaseOptions k;
    private final ComponentRuntime l;
    private final SharedPreferences m;
    private final Publisher n;
    private final AtomicBoolean q;
    private InternalTokenProvider u;
    private IdTokenListenersCountChangedListener v;
    private final AtomicBoolean o = new AtomicBoolean(false);
    private final AtomicBoolean p = new AtomicBoolean();
    private final List<IdTokenListener> r = new CopyOnWriteArrayList();
    private final List<BackgroundStateChangeListener> s = new CopyOnWriteArrayList();
    private final List<FirebaseAppLifecycleListener> t = new CopyOnWriteArrayList();

    /* compiled from: com.google.firebase:firebase-common@@16.0.4 */
    @KeepForSdk
    /* loaded from: classes2.dex */
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void a(boolean z);
    }

    /* compiled from: com.google.firebase:firebase-common@@16.0.4 */
    @KeepForSdk
    @Deprecated
    /* loaded from: classes2.dex */
    public interface IdTokenListener {
        @KeepForSdk
        void a(InternalTokenResult internalTokenResult);
    }

    /* compiled from: com.google.firebase:firebase-common@@16.0.4 */
    @KeepForSdk
    @Deprecated
    /* loaded from: classes2.dex */
    public interface IdTokenListenersCountChangedListener {
        @KeepForSdk
        void a(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-common@@16.0.4 */
    @TargetApi(14)
    /* loaded from: classes2.dex */
    public static class a implements BackgroundDetector.BackgroundStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private static AtomicReference<a> f16329a = new AtomicReference<>();

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (PlatformVersion.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f16329a.get() == null) {
                    a aVar = new a();
                    if (f16329a.compareAndSet(null, aVar)) {
                        BackgroundDetector.a(application);
                        BackgroundDetector.a().a(aVar);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public void a(boolean z) {
            synchronized (FirebaseApp.f16326f) {
                Iterator it = new ArrayList(FirebaseApp.f16328h.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.o.get()) {
                        firebaseApp.b(z);
                    }
                }
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-common@@16.0.4 */
    /* loaded from: classes2.dex */
    private static class b implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private static final Handler f16330a = new Handler(Looper.getMainLooper());

        private b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            f16330a.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-common@@16.0.4 */
    @TargetApi(24)
    /* loaded from: classes2.dex */
    public static class c extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private static AtomicReference<c> f16331a = new AtomicReference<>();

        /* renamed from: b, reason: collision with root package name */
        private final Context f16332b;

        public c(Context context) {
            this.f16332b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (f16331a.get() == null) {
                c cVar = new c(context);
                if (f16331a.compareAndSet(null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.f16326f) {
                Iterator<FirebaseApp> it = FirebaseApp.f16328h.values().iterator();
                while (it.hasNext()) {
                    it.next().k();
                }
            }
            a();
        }

        public void a() {
            this.f16332b.unregisterReceiver(this);
        }
    }

    protected FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        Preconditions.a(context);
        this.i = context;
        Preconditions.b(str);
        this.j = str;
        Preconditions.a(firebaseOptions);
        this.k = firebaseOptions;
        this.v = new DefaultIdTokenListenersCountChangedListener();
        this.m = context.getSharedPreferences("com.google.firebase.common.prefs", 0);
        this.q = new AtomicBoolean(l());
        this.l = new ComponentRuntime(f16327g, ComponentDiscovery.a(context).a(), Component.a(context, Context.class, new Class[0]), Component.a(this, FirebaseApp.class, new Class[0]), Component.a(firebaseOptions, FirebaseOptions.class, new Class[0]));
        this.n = (Publisher) this.l.a(Publisher.class);
    }

    @PublicApi
    public static FirebaseApp c() {
        FirebaseApp firebaseApp;
        synchronized (f16326f) {
            firebaseApp = f16328h.get("[DEFAULT]");
            if (firebaseApp == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    private void i() {
        Preconditions.b(!this.p.get(), "FirebaseApp was deleted");
    }

    private static List<String> j() {
        ArrayList arrayList = new ArrayList();
        synchronized (f16326f) {
            Iterator<FirebaseApp> it = f16328h.values().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().d());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        boolean isDeviceProtectedStorage = ContextCompat.isDeviceProtectedStorage(this.i);
        if (isDeviceProtectedStorage) {
            c.b(this.i);
        } else {
            this.l.a(h());
        }
        a(FirebaseApp.class, this, f16321a, isDeviceProtectedStorage);
        if (h()) {
            a(FirebaseApp.class, this, f16322b, isDeviceProtectedStorage);
            a(Context.class, this.i, f16323c, isDeviceProtectedStorage);
        }
    }

    private boolean l() {
        ApplicationInfo applicationInfo;
        if (this.m.contains("firebase_data_collection_default_enabled")) {
            return this.m.getBoolean("firebase_data_collection_default_enabled", true);
        }
        try {
            PackageManager packageManager = this.i.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.i.getPackageName(), 128)) != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("firebase_data_collection_default_enabled")) {
                return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return true;
    }

    @PublicApi
    public String d() {
        i();
        return this.j;
    }

    @PublicApi
    public FirebaseOptions e() {
        i();
        return this.k;
    }

    public boolean equals(Object obj) {
        if (obj instanceof FirebaseApp) {
            return this.j.equals(((FirebaseApp) obj).d());
        }
        return false;
    }

    @KeepForSdk
    public String f() {
        return Base64Utils.c(d().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.c(e().b().getBytes(Charset.defaultCharset()));
    }

    @KeepForSdk
    public boolean g() {
        i();
        return this.q.get();
    }

    @KeepForSdk
    public boolean h() {
        return "[DEFAULT]".equals(d());
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return Objects.a(this).a("name", this.j).a("options", this.k).toString();
    }

    @PublicApi
    public Context b() {
        i();
        return this.i;
    }

    @PublicApi
    public static FirebaseApp a(String str) {
        FirebaseApp firebaseApp;
        String str2;
        synchronized (f16326f) {
            firebaseApp = f16328h.get(b(str));
            if (firebaseApp == null) {
                List<String> j = j();
                if (j.isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", j);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", str, str2));
            }
        }
        return firebaseApp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator<BackgroundStateChangeListener> it = this.s.iterator();
        while (it.hasNext()) {
            it.next().a(z);
        }
    }

    private static String b(String str) {
        return str.trim();
    }

    @PublicApi
    public static FirebaseApp a(Context context) {
        synchronized (f16326f) {
            if (f16328h.containsKey("[DEFAULT]")) {
                return c();
            }
            FirebaseOptions a2 = FirebaseOptions.a(context);
            if (a2 == null) {
                Log.d("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return a(context, a2);
        }
    }

    @PublicApi
    public static FirebaseApp a(Context context, FirebaseOptions firebaseOptions) {
        return a(context, firebaseOptions, "[DEFAULT]");
    }

    @PublicApi
    public static FirebaseApp a(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        a.b(context);
        String b2 = b(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f16326f) {
            Preconditions.b(!f16328h.containsKey(b2), "FirebaseApp name " + b2 + " already exists!");
            Preconditions.a(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, b2, firebaseOptions);
            f16328h.put(b2, firebaseApp);
        }
        firebaseApp.k();
        return firebaseApp;
    }

    @KeepForSdk
    @Deprecated
    public void a(InternalTokenProvider internalTokenProvider) {
        Preconditions.a(internalTokenProvider);
        this.u = internalTokenProvider;
    }

    @KeepForSdk
    @Deprecated
    public void a(IdTokenListenersCountChangedListener idTokenListenersCountChangedListener) {
        Preconditions.a(idTokenListenersCountChangedListener);
        this.v = idTokenListenersCountChangedListener;
        this.v.a(this.r.size());
    }

    @KeepForSdk
    @Deprecated
    public Task<GetTokenResult> a(boolean z) {
        i();
        InternalTokenProvider internalTokenProvider = this.u;
        if (internalTokenProvider == null) {
            return Tasks.a((Exception) new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode."));
        }
        return internalTokenProvider.a(z);
    }

    @KeepForSdk
    public <T> T a(Class<T> cls) {
        i();
        return (T) this.l.a(cls);
    }

    @KeepForSdk
    @Deprecated
    public void a(InternalTokenResult internalTokenResult) {
        Log.d("FirebaseApp", "Notifying auth state listeners.");
        Iterator<IdTokenListener> it = this.r.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next().a(internalTokenResult);
            i++;
        }
        Log.d("FirebaseApp", String.format("Notified %d auth state listeners.", Integer.valueOf(i)));
    }

    @KeepForSdk
    @Deprecated
    public void a(IdTokenListener idTokenListener) {
        i();
        Preconditions.a(idTokenListener);
        this.r.add(idTokenListener);
        this.v.a(this.r.size());
    }

    @KeepForSdk
    public void a(BackgroundStateChangeListener backgroundStateChangeListener) {
        i();
        if (this.o.get() && BackgroundDetector.a().b()) {
            backgroundStateChangeListener.a(true);
        }
        this.s.add(backgroundStateChangeListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void a(Class<T> cls, T t, Iterable<String> iterable, boolean z) {
        for (String str : iterable) {
            if (z) {
                try {
                } catch (ClassNotFoundException unused) {
                    if (f16325e.contains(str)) {
                        throw new IllegalStateException(str + " is missing, but is required. Check if it has been removed by Proguard.");
                    }
                    Log.d("FirebaseApp", str + " is not linked. Skipping initialization.");
                } catch (IllegalAccessException e2) {
                    Log.wtf("FirebaseApp", "Failed to initialize " + str, e2);
                } catch (NoSuchMethodException unused2) {
                    throw new IllegalStateException(str + "#getInstance has been removed by Proguard. Add keep rule to prevent it.");
                } catch (InvocationTargetException e3) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
                }
                if (f16324d.contains(str)) {
                }
            }
            Method method = Class.forName(str).getMethod("getInstance", cls);
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, t);
            }
        }
    }
}
