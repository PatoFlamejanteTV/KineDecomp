package bolts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: Task.java */
/* loaded from: classes.dex */
public class p<TResult> {

    /* renamed from: d */
    private static volatile b f3409d;
    private boolean j;
    private boolean k;
    private TResult l;
    private Exception m;
    private boolean n;
    private r o;

    /* renamed from: a */
    public static final ExecutorService f3406a = g.a();

    /* renamed from: b */
    private static final Executor f3407b = g.b();

    /* renamed from: c */
    public static final Executor f3408c = bolts.b.b();

    /* renamed from: e */
    private static p<?> f3410e = new p<>((Object) null);

    /* renamed from: f */
    private static p<Boolean> f3411f = new p<>(true);

    /* renamed from: g */
    private static p<Boolean> f3412g = new p<>(false);

    /* renamed from: h */
    private static p<?> f3413h = new p<>(true);
    private final Object i = new Object();
    private List<i<TResult, Void>> p = new ArrayList();

    /* compiled from: Task.java */
    /* loaded from: classes.dex */
    public class a extends q<TResult> {
        a() {
        }
    }

    /* compiled from: Task.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(p<?> pVar, UnobservedTaskException unobservedTaskException);
    }

    public p() {
    }

    public static b e() {
        return f3409d;
    }

    private void j() {
        synchronized (this.i) {
            Iterator<i<TResult, Void>> it = this.p.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.p = null;
        }
    }

    public Exception c() {
        Exception exc;
        synchronized (this.i) {
            if (this.m != null) {
                this.n = true;
                if (this.o != null) {
                    this.o.a();
                    this.o = null;
                }
            }
            exc = this.m;
        }
        return exc;
    }

    public TResult d() {
        TResult tresult;
        synchronized (this.i) {
            tresult = this.l;
        }
        return tresult;
    }

    public boolean f() {
        boolean z;
        synchronized (this.i) {
            z = this.k;
        }
        return z;
    }

    public boolean g() {
        boolean z;
        synchronized (this.i) {
            z = this.j;
        }
        return z;
    }

    public boolean h() {
        boolean z;
        synchronized (this.i) {
            z = c() != null;
        }
        return z;
    }

    public boolean i() {
        synchronized (this.i) {
            if (this.j) {
                return false;
            }
            this.j = true;
            this.k = true;
            this.i.notifyAll();
            j();
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <TResult> p<TResult> a(TResult tresult) {
        if (tresult == 0) {
            return (p<TResult>) f3410e;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (p<TResult>) f3411f : (p<TResult>) f3412g;
        }
        q qVar = new q();
        qVar.a((q) tresult);
        return qVar.a();
    }

    public static <TResult> p<TResult>.a b() {
        return new a();
    }

    private p(TResult tresult) {
        b((p<TResult>) tresult);
    }

    public static <TContinuationResult, TResult> void d(q<TContinuationResult> qVar, i<TResult, TContinuationResult> iVar, p<TResult> pVar, Executor executor, h hVar) {
        try {
            executor.execute(new m(hVar, qVar, iVar, pVar));
        } catch (Exception e2) {
            qVar.a(new ExecutorException(e2));
        }
    }

    public <TContinuationResult> p<TContinuationResult> b(i<TResult, p<TContinuationResult>> iVar, Executor executor, h hVar) {
        boolean g2;
        q qVar = new q();
        synchronized (this.i) {
            g2 = g();
            if (!g2) {
                this.p.add(new k(this, qVar, iVar, executor, hVar));
            }
        }
        if (g2) {
            c(qVar, iVar, this, executor, hVar);
        }
        return qVar.a();
    }

    private p(boolean z) {
        if (z) {
            i();
        } else {
            b((p<TResult>) null);
        }
    }

    public static <TResult> p<TResult> a(Exception exc) {
        q qVar = new q();
        qVar.a(exc);
        return qVar.a();
    }

    public <TContinuationResult> p<TContinuationResult> c(i<TResult, TContinuationResult> iVar, Executor executor, h hVar) {
        return a(new l(this, hVar, iVar), executor);
    }

    public static <TContinuationResult, TResult> void c(q<TContinuationResult> qVar, i<TResult, p<TContinuationResult>> iVar, p<TResult> pVar, Executor executor, h hVar) {
        try {
            executor.execute(new o(hVar, qVar, iVar, pVar));
        } catch (Exception e2) {
            qVar.a(new ExecutorException(e2));
        }
    }

    public static <TResult> p<TResult> a() {
        return (p<TResult>) f3413h;
    }

    public <TContinuationResult> p<TContinuationResult> a(i<TResult, TContinuationResult> iVar, Executor executor, h hVar) {
        boolean g2;
        q qVar = new q();
        synchronized (this.i) {
            g2 = g();
            if (!g2) {
                this.p.add(new j(this, qVar, iVar, executor, hVar));
            }
        }
        if (g2) {
            d(qVar, iVar, this, executor, hVar);
        }
        return qVar.a();
    }

    public <TContinuationResult> p<TContinuationResult> b(i<TResult, TContinuationResult> iVar) {
        return c(iVar, f3407b, null);
    }

    public boolean b(TResult tresult) {
        synchronized (this.i) {
            if (this.j) {
                return false;
            }
            this.j = true;
            this.l = tresult;
            this.i.notifyAll();
            j();
            return true;
        }
    }

    public <TContinuationResult> p<TContinuationResult> a(i<TResult, TContinuationResult> iVar) {
        return a(iVar, f3407b, null);
    }

    public <TContinuationResult> p<TContinuationResult> a(i<TResult, p<TContinuationResult>> iVar, Executor executor) {
        return b(iVar, executor, null);
    }

    public boolean b(Exception exc) {
        synchronized (this.i) {
            if (this.j) {
                return false;
            }
            this.j = true;
            this.m = exc;
            this.n = false;
            this.i.notifyAll();
            j();
            if (!this.n && e() != null) {
                this.o = new r(this);
            }
            return true;
        }
    }
}
