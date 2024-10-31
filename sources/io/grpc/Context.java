package io.grpc;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class Context {

    /* renamed from: a */
    private static final Logger f27076a = Logger.getLogger(Context.class.getName());

    /* renamed from: b */
    private static final X<d<?>, Object> f27077b = new X<>();

    /* renamed from: c */
    public static final Context f27078c = new Context(null, f27077b);

    /* renamed from: d */
    private static final AtomicReference<f> f27079d = new AtomicReference<>();

    /* renamed from: e */
    private ArrayList<c> f27080e;

    /* renamed from: f */
    private b f27081f = new e(this, null);

    /* renamed from: g */
    final a f27082g;

    /* renamed from: h */
    final X<d<?>, Object> f27083h;
    final int i;

    /* loaded from: classes3.dex */
    public enum DirectExecutor implements Executor {
        INSTANCE;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Context.DirectExecutor";
        }
    }

    /* loaded from: classes3.dex */
    public static final class a extends Context implements Closeable {
        private final C2526v j;
        private final Context k;
        private boolean l;
        private Throwable m;
        private ScheduledFuture<?> n;

        public boolean a(Throwable th) {
            boolean z;
            synchronized (this) {
                z = true;
                if (this.l) {
                    z = false;
                } else {
                    this.l = true;
                    if (this.n != null) {
                        this.n.cancel(false);
                        this.n = null;
                    }
                    this.m = th;
                }
            }
            if (z) {
                w();
            }
            return z;
        }

        @Override // io.grpc.Context
        public Context b() {
            return this.k.b();
        }

        @Override // io.grpc.Context
        boolean c() {
            return true;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a((Throwable) null);
        }

        @Override // io.grpc.Context
        public Throwable r() {
            if (v()) {
                return this.m;
            }
            return null;
        }

        @Override // io.grpc.Context
        public C2526v u() {
            return this.j;
        }

        @Override // io.grpc.Context
        public boolean v() {
            synchronized (this) {
                if (this.l) {
                    return true;
                }
                if (!super.v()) {
                    return false;
                }
                a(super.r());
                return true;
            }
        }

        @Override // io.grpc.Context
        public void b(Context context) {
            this.k.b(context);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(Context context);
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: a */
        private final Executor f27084a;

        /* renamed from: b */
        private final b f27085b;

        /* synthetic */ c(Context context, Executor executor, b bVar, RunnableC2523s runnableC2523s) {
            this(executor, bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f27085b.a(Context.this);
        }

        private c(Executor executor, b bVar) {
            this.f27084a = executor;
            this.f27085b = bVar;
        }

        public void b() {
            try {
                this.f27084a.execute(this);
            } catch (Throwable th) {
                Context.f27076a.log(Level.INFO, "Exception notifying context listener", th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d<T> {

        /* renamed from: a */
        private final String f27087a;

        /* renamed from: b */
        private final T f27088b;

        d(String str) {
            this(str, null);
        }

        public T a() {
            return a(Context.s());
        }

        public String toString() {
            return this.f27087a;
        }

        d(String str, T t) {
            Context.a(str, "name");
            this.f27087a = str;
            this.f27088b = t;
        }

        public T a(Context context) {
            T t = (T) context.a((d<?>) this);
            return t == null ? this.f27088b : t;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements b {
        private e() {
        }

        @Override // io.grpc.Context.b
        public void a(Context context) {
            Context context2 = Context.this;
            if (context2 instanceof a) {
                ((a) context2).a(context.r());
            } else {
                context2.w();
            }
        }

        /* synthetic */ e(Context context, RunnableC2523s runnableC2523s) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class f {
        public abstract Context a();

        @Deprecated
        public void a(Context context) {
            throw new UnsupportedOperationException("Deprecated. Do not call.");
        }

        public abstract void a(Context context, Context context2);

        public Context b(Context context) {
            a();
            a(context);
            throw null;
        }
    }

    private Context(Context context, X<d<?>, Object> x) {
        this.f27082g = a(context);
        this.f27083h = x;
        this.i = context == null ? 0 : context.i + 1;
        a(this.i);
    }

    public static <T> d<T> e(String str) {
        return new d<>(str);
    }

    public static Context s() {
        Context a2 = x().a();
        return a2 == null ? f27078c : a2;
    }

    static f x() {
        f fVar = f27079d.get();
        return fVar == null ? y() : fVar;
    }

    private static f y() {
        try {
            f27079d.compareAndSet(null, (f) Class.forName("io.grpc.override.ContextStorageOverride").getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (ClassNotFoundException e2) {
            if (f27079d.compareAndSet(null, new fa())) {
                f27076a.log(Level.FINE, "Storage override doesn't exist. Using default", (Throwable) e2);
            }
        } catch (Exception e3) {
            throw new RuntimeException("Storage override failed to initialize", e3);
        }
        return f27079d.get();
    }

    public Context b() {
        Context b2 = x().b(this);
        return b2 == null ? f27078c : b2;
    }

    boolean c() {
        return this.f27082g != null;
    }

    public Throwable r() {
        a aVar = this.f27082g;
        if (aVar == null) {
            return null;
        }
        return aVar.r();
    }

    public C2526v u() {
        a aVar = this.f27082g;
        if (aVar == null) {
            return null;
        }
        return aVar.u();
    }

    public boolean v() {
        a aVar = this.f27082g;
        if (aVar == null) {
            return false;
        }
        return aVar.v();
    }

    void w() {
        if (c()) {
            synchronized (this) {
                if (this.f27080e == null) {
                    return;
                }
                ArrayList<c> arrayList = this.f27080e;
                this.f27080e = null;
                for (int i = 0; i < arrayList.size(); i++) {
                    if (!(arrayList.get(i).f27085b instanceof e)) {
                        arrayList.get(i).b();
                    }
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (arrayList.get(i2).f27085b instanceof e) {
                        arrayList.get(i2).b();
                    }
                }
                a aVar = this.f27082g;
                if (aVar != null) {
                    aVar.a(this.f27081f);
                }
            }
        }
    }

    static /* synthetic */ Object a(Object obj, Object obj2) {
        b(obj, obj2);
        return obj;
    }

    public void b(Context context) {
        b(context, "toAttach");
        x().a(this, context);
    }

    public void a(b bVar, Executor executor) {
        b(bVar, "cancellationListener");
        b(executor, "executor");
        if (c()) {
            c cVar = new c(this, executor, bVar, null);
            synchronized (this) {
                if (v()) {
                    cVar.b();
                } else if (this.f27080e == null) {
                    this.f27080e = new ArrayList<>();
                    this.f27080e.add(cVar);
                    if (this.f27082g != null) {
                        this.f27082g.a(this.f27081f, (Executor) DirectExecutor.INSTANCE);
                    }
                } else {
                    this.f27080e.add(cVar);
                }
            }
        }
    }

    private static <T> T b(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public void a(b bVar) {
        if (c()) {
            synchronized (this) {
                if (this.f27080e != null) {
                    int size = this.f27080e.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        if (this.f27080e.get(size).f27085b == bVar) {
                            this.f27080e.remove(size);
                            break;
                        }
                        size--;
                    }
                    if (this.f27080e.isEmpty()) {
                        if (this.f27082g != null) {
                            this.f27082g.a(this.f27081f);
                        }
                        this.f27080e = null;
                    }
                }
            }
        }
    }

    public Object a(d<?> dVar) {
        return this.f27083h.a(dVar);
    }

    static a a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof a) {
            return (a) context;
        }
        return context.f27082g;
    }

    private static void a(int i) {
        if (i == 1000) {
            f27076a.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }
}
