package a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: Task.java */
/* loaded from: classes.dex */
public class g<TResult> {
    private boolean e;
    private boolean f;
    private TResult g;
    private Exception h;

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutorService f6a = d.a();
    private static final Executor c = d.b();
    public static final Executor b = a.a.b();
    private final Object d = new Object();
    private List<f<TResult, Void>> i = new ArrayList();

    private g() {
    }

    public static <TResult> g<TResult>.a a() {
        g gVar = new g();
        gVar.getClass();
        return new a(gVar, null);
    }

    public boolean b() {
        boolean z;
        synchronized (this.d) {
            z = this.e;
        }
        return z;
    }

    public boolean c() {
        boolean z;
        synchronized (this.d) {
            z = this.f;
        }
        return z;
    }

    public boolean d() {
        boolean z;
        synchronized (this.d) {
            z = this.h != null;
        }
        return z;
    }

    public TResult e() {
        TResult tresult;
        synchronized (this.d) {
            tresult = this.g;
        }
        return tresult;
    }

    public Exception f() {
        Exception exc;
        synchronized (this.d) {
            exc = this.h;
        }
        return exc;
    }

    public static <TResult> g<TResult> a(TResult tresult) {
        a a2 = a();
        a2.b((a) tresult);
        return a2.a();
    }

    public static <TResult> g<TResult> a(Exception exc) {
        a a2 = a();
        a2.b(exc);
        return a2.a();
    }

    public static <TResult> g<TResult> g() {
        a a2 = a();
        a2.c();
        return a2.a();
    }

    public <TContinuationResult> g<TContinuationResult> a(f<TResult, TContinuationResult> fVar, Executor executor, e eVar) {
        boolean b2;
        a a2 = a();
        synchronized (this.d) {
            b2 = b();
            if (!b2) {
                this.i.add(new n(this, a2, fVar, executor, eVar));
            }
        }
        if (b2) {
            c(a2, fVar, this, executor, eVar);
        }
        return a2.a();
    }

    public <TContinuationResult> g<TContinuationResult> a(f<TResult, TContinuationResult> fVar) {
        return a(fVar, c, null);
    }

    public <TContinuationResult> g<TContinuationResult> a(f<TResult, g<TContinuationResult>> fVar, Executor executor) {
        return b(fVar, executor, null);
    }

    public <TContinuationResult> g<TContinuationResult> b(f<TResult, g<TContinuationResult>> fVar, Executor executor, e eVar) {
        boolean b2;
        a a2 = a();
        synchronized (this.d) {
            b2 = b();
            if (!b2) {
                this.i.add(new i(this, a2, fVar, executor, eVar));
            }
        }
        if (b2) {
            d(a2, fVar, this, executor, eVar);
        }
        return a2.a();
    }

    public <TContinuationResult> g<TContinuationResult> c(f<TResult, TContinuationResult> fVar, Executor executor, e eVar) {
        return a(new j(this, eVar, fVar), executor);
    }

    public <TContinuationResult> g<TContinuationResult> b(f<TResult, TContinuationResult> fVar) {
        return c(fVar, c, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void c(g<TContinuationResult>.a aVar, f<TResult, TContinuationResult> fVar, g<TResult> gVar, Executor executor, e eVar) {
        executor.execute(new k(eVar, aVar, fVar, gVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void d(g<TContinuationResult>.a aVar, f<TResult, g<TContinuationResult>> fVar, g<TResult> gVar, Executor executor, e eVar) {
        executor.execute(new l(eVar, aVar, fVar, gVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        synchronized (this.d) {
            Iterator<f<TResult, Void>> it = this.i.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.i = null;
        }
    }

    /* compiled from: Task.java */
    /* loaded from: classes.dex */
    public class a {
        /* synthetic */ a(g gVar, h hVar) {
            this();
        }

        private a() {
        }

        public g<TResult> a() {
            return g.this;
        }

        public boolean b() {
            boolean z = true;
            synchronized (g.this.d) {
                if (!g.this.e) {
                    g.this.e = true;
                    g.this.f = true;
                    g.this.d.notifyAll();
                    g.this.h();
                } else {
                    z = false;
                }
            }
            return z;
        }

        public boolean a(TResult tresult) {
            boolean z = true;
            synchronized (g.this.d) {
                if (!g.this.e) {
                    g.this.e = true;
                    g.this.g = tresult;
                    g.this.d.notifyAll();
                    g.this.h();
                } else {
                    z = false;
                }
            }
            return z;
        }

        public boolean a(Exception exc) {
            boolean z = true;
            synchronized (g.this.d) {
                if (!g.this.e) {
                    g.this.e = true;
                    g.this.h = exc;
                    g.this.d.notifyAll();
                    g.this.h();
                } else {
                    z = false;
                }
            }
            return z;
        }

        public void c() {
            if (!b()) {
                throw new IllegalStateException("Cannot cancel a completed task.");
            }
        }

        public void b(TResult tresult) {
            if (!a((a) tresult)) {
                throw new IllegalStateException("Cannot set the result of a completed task.");
            }
        }

        public void b(Exception exc) {
            if (!a(exc)) {
                throw new IllegalStateException("Cannot set the error on a completed task.");
            }
        }
    }
}
