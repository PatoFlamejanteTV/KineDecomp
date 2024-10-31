package io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Fabric.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a */
    static volatile f f26842a;

    /* renamed from: b */
    static final o f26843b = new c();

    /* renamed from: c */
    private final Context f26844c;

    /* renamed from: d */
    private final Map<Class<? extends l>, l> f26845d;

    /* renamed from: e */
    private final ExecutorService f26846e;

    /* renamed from: f */
    private final Handler f26847f;

    /* renamed from: g */
    private final j<f> f26848g;

    /* renamed from: h */
    private final j<?> f26849h;
    private final IdManager i;
    private b j;
    private WeakReference<Activity> k;
    private AtomicBoolean l = new AtomicBoolean(false);
    final o m;
    final boolean n;

    f(Context context, Map<Class<? extends l>, l> map, io.fabric.sdk.android.services.concurrency.o oVar, Handler handler, o oVar2, boolean z, j jVar, IdManager idManager, Activity activity) {
        this.f26844c = context;
        this.f26845d = map;
        this.f26846e = oVar;
        this.f26847f = handler;
        this.m = oVar2;
        this.n = z;
        this.f26848g = jVar;
        this.f26849h = a(map.size());
        this.i = idManager;
        a(activity);
    }

    public static f c(f fVar) {
        if (f26842a == null) {
            synchronized (f.class) {
                if (f26842a == null) {
                    d(fVar);
                }
            }
        }
        return f26842a;
    }

    private static void d(f fVar) {
        f26842a = fVar;
        fVar.j();
    }

    public static o f() {
        if (f26842a == null) {
            return f26843b;
        }
        return f26842a.m;
    }

    public static boolean h() {
        if (f26842a == null) {
            return false;
        }
        return f26842a.n;
    }

    static f i() {
        if (f26842a != null) {
            return f26842a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    private void j() {
        this.j = new b(this.f26844c);
        this.j.a(new d(this));
        c(this.f26844c);
    }

    public String d() {
        return "io.fabric.sdk.android:fabric";
    }

    public Collection<l> e() {
        return this.f26845d.values();
    }

    public String g() {
        return "1.4.2.22";
    }

    public Activity b() {
        WeakReference<Activity> weakReference = this.k;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* compiled from: Fabric.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        private final Context f26850a;

        /* renamed from: b */
        private l[] f26851b;

        /* renamed from: c */
        private io.fabric.sdk.android.services.concurrency.o f26852c;

        /* renamed from: d */
        private Handler f26853d;

        /* renamed from: e */
        private o f26854e;

        /* renamed from: f */
        private boolean f26855f;

        /* renamed from: g */
        private String f26856g;

        /* renamed from: h */
        private String f26857h;
        private j<f> i;

        public a(Context context) {
            if (context != null) {
                this.f26850a = context;
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public a a(l... lVarArr) {
            if (this.f26851b == null) {
                this.f26851b = lVarArr;
                return this;
            }
            throw new IllegalStateException("Kits already set.");
        }

        public a a(boolean z) {
            this.f26855f = z;
            return this;
        }

        public f a() {
            Map b2;
            if (this.f26852c == null) {
                this.f26852c = io.fabric.sdk.android.services.concurrency.o.a();
            }
            if (this.f26853d == null) {
                this.f26853d = new Handler(Looper.getMainLooper());
            }
            if (this.f26854e == null) {
                if (this.f26855f) {
                    this.f26854e = new c(3);
                } else {
                    this.f26854e = new c();
                }
            }
            if (this.f26857h == null) {
                this.f26857h = this.f26850a.getPackageName();
            }
            if (this.i == null) {
                this.i = j.f26861a;
            }
            l[] lVarArr = this.f26851b;
            if (lVarArr != null) {
                b2 = f.b(Arrays.asList(lVarArr));
            } else {
                b2 = new HashMap();
            }
            Map map = b2;
            Context applicationContext = this.f26850a.getApplicationContext();
            return new f(applicationContext, map, this.f26852c, this.f26853d, this.f26854e, this.f26855f, this.i, new IdManager(applicationContext, this.f26857h, this.f26856g, map.values()), f.d(this.f26850a));
        }
    }

    public static Activity d(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public static f a(Context context, l... lVarArr) {
        if (f26842a == null) {
            synchronized (f.class) {
                if (f26842a == null) {
                    a aVar = new a(context);
                    aVar.a(lVarArr);
                    d(aVar.a());
                }
            }
        }
        return f26842a;
    }

    public static Map<Class<? extends l>, l> b(Collection<? extends l> collection) {
        HashMap hashMap = new HashMap(collection.size());
        a(hashMap, collection);
        return hashMap;
    }

    Future<Map<String, n>> b(Context context) {
        return c().submit(new h(context.getPackageCodePath()));
    }

    void c(Context context) {
        StringBuilder sb;
        Future<Map<String, n>> b2 = b(context);
        Collection<l> e2 = e();
        p pVar = new p(b2, e2);
        ArrayList<l> arrayList = new ArrayList(e2);
        Collections.sort(arrayList);
        pVar.injectParameters(context, this, j.f26861a, this.i);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).injectParameters(context, this, this.f26849h, this.i);
        }
        pVar.initialize();
        if (f().isLoggable("Fabric", 3)) {
            sb = new StringBuilder("Initializing ");
            sb.append(d());
            sb.append(" [Version: ");
            sb.append(g());
            sb.append("], with the following kits:\n");
        } else {
            sb = null;
        }
        for (l lVar : arrayList) {
            lVar.initializationTask.addDependency(pVar.initializationTask);
            a(this.f26845d, lVar);
            lVar.initialize();
            if (sb != null) {
                sb.append(lVar.getIdentifier());
                sb.append(" [Version: ");
                sb.append(lVar.getVersion());
                sb.append("]\n");
            }
        }
        if (sb != null) {
            f().d("Fabric", sb.toString());
        }
    }

    public f a(Activity activity) {
        this.k = new WeakReference<>(activity);
        return this;
    }

    void a(Map<Class<? extends l>, l> map, l lVar) {
        io.fabric.sdk.android.services.concurrency.h hVar = lVar.dependsOnAnnotation;
        if (hVar != null) {
            for (Class<?> cls : hVar.value()) {
                if (cls.isInterface()) {
                    for (l lVar2 : map.values()) {
                        if (cls.isAssignableFrom(lVar2.getClass())) {
                            lVar.initializationTask.addDependency(lVar2.initializationTask);
                        }
                    }
                } else if (map.get(cls) != null) {
                    lVar.initializationTask.addDependency(map.get(cls).initializationTask);
                } else {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                }
            }
        }
    }

    public b a() {
        return this.j;
    }

    public static <T extends l> T a(Class<T> cls) {
        return (T) i().f26845d.get(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(Map<Class<? extends l>, l> map, Collection<? extends l> collection) {
        for (Object obj : collection) {
            map.put(obj.getClass(), obj);
            if (obj instanceof m) {
                a(map, ((m) obj).getKits());
            }
        }
    }

    j<?> a(int i) {
        return new e(this, i);
    }

    public ExecutorService c() {
        return this.f26846e;
    }
}
