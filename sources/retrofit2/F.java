package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.InterfaceC2562f;
import okhttp3.L;
import okhttp3.O;
import retrofit2.C2577a;
import retrofit2.InterfaceC2579c;
import retrofit2.j;

/* compiled from: Retrofit.java */
/* loaded from: classes3.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Method, G<?>> f29426a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    final InterfaceC2562f.a f29427b;

    /* renamed from: c, reason: collision with root package name */
    final okhttp3.A f29428c;

    /* renamed from: d, reason: collision with root package name */
    final List<j.a> f29429d;

    /* renamed from: e, reason: collision with root package name */
    final List<InterfaceC2579c.a> f29430e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    final Executor f29431f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f29432g;

    /* compiled from: Retrofit.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final A f29433a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private InterfaceC2562f.a f29434b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private okhttp3.A f29435c;

        /* renamed from: d, reason: collision with root package name */
        private final List<j.a> f29436d;

        /* renamed from: e, reason: collision with root package name */
        private final List<InterfaceC2579c.a> f29437e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private Executor f29438f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f29439g;

        a(A a2) {
            this.f29436d = new ArrayList();
            this.f29437e = new ArrayList();
            this.f29433a = a2;
        }

        public a a(okhttp3.F f2) {
            H.a(f2, "client == null");
            a((InterfaceC2562f.a) f2);
            return this;
        }

        public a a(InterfaceC2562f.a aVar) {
            H.a(aVar, "factory == null");
            this.f29434b = aVar;
            return this;
        }

        public a a(String str) {
            H.a(str, "baseUrl == null");
            a(okhttp3.A.b(str));
            return this;
        }

        public a() {
            this(A.d());
        }

        public a a(okhttp3.A a2) {
            H.a(a2, "baseUrl == null");
            if ("".equals(a2.j().get(r0.size() - 1))) {
                this.f29435c = a2;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + a2);
        }

        public a a(j.a aVar) {
            List<j.a> list = this.f29436d;
            H.a(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public a a(InterfaceC2579c.a aVar) {
            List<InterfaceC2579c.a> list = this.f29437e;
            H.a(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public F a() {
            if (this.f29435c != null) {
                InterfaceC2562f.a aVar = this.f29434b;
                if (aVar == null) {
                    aVar = new okhttp3.F();
                }
                InterfaceC2562f.a aVar2 = aVar;
                Executor executor = this.f29438f;
                if (executor == null) {
                    executor = this.f29433a.a();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.f29437e);
                arrayList.addAll(this.f29433a.a(executor2));
                ArrayList arrayList2 = new ArrayList(this.f29436d.size() + 1 + this.f29433a.c());
                arrayList2.add(new C2577a());
                arrayList2.addAll(this.f29436d);
                arrayList2.addAll(this.f29433a.b());
                return new F(aVar2, this.f29435c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor2, this.f29439g);
            }
            throw new IllegalStateException("Base URL required.");
        }
    }

    F(InterfaceC2562f.a aVar, okhttp3.A a2, List<j.a> list, List<InterfaceC2579c.a> list2, @Nullable Executor executor, boolean z) {
        this.f29427b = aVar;
        this.f29428c = a2;
        this.f29429d = list;
        this.f29430e = list2;
        this.f29431f = executor;
        this.f29432g = z;
    }

    private void b(Class<?> cls) {
        A d2 = A.d();
        for (Method method : cls.getDeclaredMethods()) {
            if (!d2.a(method)) {
                a(method);
            }
        }
    }

    public <T> T a(Class<T> cls) {
        H.a((Class) cls);
        if (this.f29432g) {
            b(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new E(this, cls));
    }

    public <T> j<T, String> c(Type type, Annotation[] annotationArr) {
        H.a(type, "type == null");
        H.a(annotationArr, "annotations == null");
        int size = this.f29429d.size();
        for (int i = 0; i < size; i++) {
            j<T, String> jVar = (j<T, String>) this.f29429d.get(i).b(type, annotationArr, this);
            if (jVar != null) {
                return jVar;
            }
        }
        return C2577a.d.f29459a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public G<?> a(Method method) {
        G<?> g2;
        G<?> g3 = this.f29426a.get(method);
        if (g3 != null) {
            return g3;
        }
        synchronized (this.f29426a) {
            g2 = this.f29426a.get(method);
            if (g2 == null) {
                g2 = G.a(this, method);
                this.f29426a.put(method, g2);
            }
        }
        return g2;
    }

    public <T> j<O, T> b(Type type, Annotation[] annotationArr) {
        return a((j.a) null, type, annotationArr);
    }

    public InterfaceC2579c<?, ?> a(Type type, Annotation[] annotationArr) {
        return a((InterfaceC2579c.a) null, type, annotationArr);
    }

    public InterfaceC2579c<?, ?> a(@Nullable InterfaceC2579c.a aVar, Type type, Annotation[] annotationArr) {
        H.a(type, "returnType == null");
        H.a(annotationArr, "annotations == null");
        int indexOf = this.f29430e.indexOf(aVar) + 1;
        int size = this.f29430e.size();
        for (int i = indexOf; i < size; i++) {
            InterfaceC2579c<?, ?> a2 = this.f29430e.get(i).a(type, annotationArr, this);
            if (a2 != null) {
                return a2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f29430e.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f29430e.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f29430e.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> j<T, L> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return a(null, type, annotationArr, annotationArr2);
    }

    public <T> j<T, L> a(@Nullable j.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        H.a(type, "type == null");
        H.a(annotationArr, "parameterAnnotations == null");
        H.a(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f29429d.indexOf(aVar) + 1;
        int size = this.f29429d.size();
        for (int i = indexOf; i < size; i++) {
            j<T, L> jVar = (j<T, L>) this.f29429d.get(i).a(type, annotationArr, annotationArr2, this);
            if (jVar != null) {
                return jVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f29429d.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f29429d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f29429d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> j<O, T> a(@Nullable j.a aVar, Type type, Annotation[] annotationArr) {
        H.a(type, "type == null");
        H.a(annotationArr, "annotations == null");
        int indexOf = this.f29429d.indexOf(aVar) + 1;
        int size = this.f29429d.size();
        for (int i = indexOf; i < size; i++) {
            j<O, T> jVar = (j<O, T>) this.f29429d.get(i).a(type, annotationArr, this);
            if (jVar != null) {
                return jVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f29429d.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f29429d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f29429d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }
}
