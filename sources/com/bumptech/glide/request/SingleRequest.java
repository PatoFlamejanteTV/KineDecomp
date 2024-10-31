package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.g.a.d;
import com.bumptech.glide.g.n;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.E;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.s;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class SingleRequest<R> implements c, com.bumptech.glide.request.a.h, g, d.c {

    /* renamed from: a, reason: collision with root package name */
    private static final Pools.Pool<SingleRequest<?>> f9060a = com.bumptech.glide.g.a.d.a(150, new h());

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f9061b = Log.isLoggable("Request", 2);
    private Drawable A;
    private int B;
    private int C;
    private RuntimeException D;

    /* renamed from: c, reason: collision with root package name */
    private boolean f9062c;

    /* renamed from: d, reason: collision with root package name */
    private final String f9063d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.g.a.g f9064e;

    /* renamed from: f, reason: collision with root package name */
    private e<R> f9065f;

    /* renamed from: g, reason: collision with root package name */
    private d f9066g;

    /* renamed from: h, reason: collision with root package name */
    private Context f9067h;
    private com.bumptech.glide.e i;
    private Object j;
    private Class<R> k;
    private a<?> l;
    private int m;
    private int n;
    private Priority o;
    private com.bumptech.glide.request.a.i<R> p;
    private List<e<R>> q;
    private s r;
    private com.bumptech.glide.request.b.g<? super R> s;
    private Executor t;
    private E<R> u;
    private s.d v;
    private long w;
    private Status x;
    private Drawable y;
    private Drawable z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleRequest() {
        this.f9063d = f9061b ? String.valueOf(super.hashCode()) : null;
        this.f9064e = com.bumptech.glide.g.a.g.a();
    }

    public static <R> SingleRequest<R> a(Context context, com.bumptech.glide.e eVar, Object obj, Class<R> cls, a<?> aVar, int i, int i2, Priority priority, com.bumptech.glide.request.a.i<R> iVar, e<R> eVar2, List<e<R>> list, d dVar, s sVar, com.bumptech.glide.request.b.g<? super R> gVar, Executor executor) {
        SingleRequest<R> singleRequest = (SingleRequest) f9060a.acquire();
        if (singleRequest == null) {
            singleRequest = new SingleRequest<>();
        }
        singleRequest.b(context, eVar, obj, cls, aVar, i, i2, priority, iVar, eVar2, list, dVar, sVar, gVar, executor);
        return singleRequest;
    }

    private synchronized void b(Context context, com.bumptech.glide.e eVar, Object obj, Class<R> cls, a<?> aVar, int i, int i2, Priority priority, com.bumptech.glide.request.a.i<R> iVar, e<R> eVar2, List<e<R>> list, d dVar, s sVar, com.bumptech.glide.request.b.g<? super R> gVar, Executor executor) {
        this.f9067h = context;
        this.i = eVar;
        this.j = obj;
        this.k = cls;
        this.l = aVar;
        this.m = i;
        this.n = i2;
        this.o = priority;
        this.p = iVar;
        this.f9065f = eVar2;
        this.q = list;
        this.f9066g = dVar;
        this.r = sVar;
        this.s = gVar;
        this.t = executor;
        this.x = Status.PENDING;
        if (this.D == null && eVar.g()) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    private void g() {
        if (this.f9062c) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean h() {
        d dVar = this.f9066g;
        return dVar == null || dVar.f(this);
    }

    private boolean i() {
        d dVar = this.f9066g;
        return dVar == null || dVar.b(this);
    }

    private boolean j() {
        d dVar = this.f9066g;
        return dVar == null || dVar.c(this);
    }

    private void k() {
        g();
        this.f9064e.b();
        this.p.a((com.bumptech.glide.request.a.h) this);
        s.d dVar = this.v;
        if (dVar != null) {
            dVar.a();
            this.v = null;
        }
    }

    private Drawable l() {
        if (this.y == null) {
            this.y = this.l.e();
            if (this.y == null && this.l.d() > 0) {
                this.y = a(this.l.d());
            }
        }
        return this.y;
    }

    private Drawable m() {
        if (this.A == null) {
            this.A = this.l.f();
            if (this.A == null && this.l.g() > 0) {
                this.A = a(this.l.g());
            }
        }
        return this.A;
    }

    private Drawable n() {
        if (this.z == null) {
            this.z = this.l.l();
            if (this.z == null && this.l.m() > 0) {
                this.z = a(this.l.m());
            }
        }
        return this.z;
    }

    private boolean o() {
        d dVar = this.f9066g;
        return dVar == null || !dVar.d();
    }

    private void p() {
        d dVar = this.f9066g;
        if (dVar != null) {
            dVar.d(this);
        }
    }

    private void q() {
        d dVar = this.f9066g;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    private synchronized void r() {
        if (i()) {
            Drawable m = this.j == null ? m() : null;
            if (m == null) {
                m = l();
            }
            if (m == null) {
                m = n();
            }
            this.p.c(m);
        }
    }

    @Override // com.bumptech.glide.request.c
    public synchronized boolean c() {
        return isComplete();
    }

    @Override // com.bumptech.glide.request.c
    public synchronized void clear() {
        g();
        this.f9064e.b();
        if (this.x == Status.CLEARED) {
            return;
        }
        k();
        if (this.u != null) {
            a((E<?>) this.u);
        }
        if (h()) {
            this.p.b(n());
        }
        this.x = Status.CLEARED;
    }

    @Override // com.bumptech.glide.g.a.d.c
    public com.bumptech.glide.g.a.g d() {
        return this.f9064e;
    }

    @Override // com.bumptech.glide.request.c
    public synchronized boolean e() {
        return this.x == Status.FAILED;
    }

    @Override // com.bumptech.glide.request.c
    public synchronized boolean f() {
        return this.x == Status.CLEARED;
    }

    @Override // com.bumptech.glide.request.c
    public synchronized boolean isComplete() {
        return this.x == Status.COMPLETE;
    }

    @Override // com.bumptech.glide.request.c
    public synchronized boolean isRunning() {
        boolean z;
        if (this.x != Status.RUNNING) {
            z = this.x == Status.WAITING_FOR_SIZE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.c
    public synchronized void a() {
        g();
        this.f9064e.b();
        this.w = com.bumptech.glide.g.h.a();
        if (this.j == null) {
            if (n.b(this.m, this.n)) {
                this.B = this.m;
                this.C = this.n;
            }
            a(new GlideException("Received null model"), m() == null ? 5 : 3);
            return;
        }
        if (this.x != Status.RUNNING) {
            if (this.x == Status.COMPLETE) {
                a((E<?>) this.u, DataSource.MEMORY_CACHE);
                return;
            }
            this.x = Status.WAITING_FOR_SIZE;
            if (n.b(this.m, this.n)) {
                a(this.m, this.n);
            } else {
                this.p.b(this);
            }
            if ((this.x == Status.RUNNING || this.x == Status.WAITING_FOR_SIZE) && i()) {
                this.p.a(n());
            }
            if (f9061b) {
                a("finished run method in " + com.bumptech.glide.g.h.a(this.w));
            }
            return;
        }
        throw new IllegalArgumentException("Cannot restart a running request");
    }

    @Override // com.bumptech.glide.request.c
    public synchronized void b() {
        g();
        this.f9067h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = -1;
        this.n = -1;
        this.p = null;
        this.q = null;
        this.f9065f = null;
        this.f9066g = null;
        this.s = null;
        this.v = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = -1;
        this.C = -1;
        this.D = null;
        f9060a.release(this);
    }

    private void a(E<?> e2) {
        this.r.b(e2);
        this.u = null;
    }

    private Drawable a(int i) {
        return com.bumptech.glide.load.c.b.a.a(this.i, i, this.l.r() != null ? this.l.r() : this.f9067h.getTheme());
    }

    @Override // com.bumptech.glide.request.a.h
    public synchronized void a(int i, int i2) {
        try {
            this.f9064e.b();
            if (f9061b) {
                a("Got onSizeReady in " + com.bumptech.glide.g.h.a(this.w));
            }
            if (this.x != Status.WAITING_FOR_SIZE) {
                return;
            }
            this.x = Status.RUNNING;
            float q = this.l.q();
            this.B = a(i, q);
            this.C = a(i2, q);
            if (f9061b) {
                a("finished setup for calling load in " + com.bumptech.glide.g.h.a(this.w));
            }
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.v = this.r.a(this.i, this.j, this.l.p(), this.B, this.C, this.l.o(), this.k, this.o, this.l.c(), this.l.s(), this.l.z(), this.l.x(), this.l.i(), this.l.v(), this.l.u(), this.l.t(), this.l.h(), this, this.t);
                if (this.x != Status.RUNNING) {
                    this.v = null;
                }
                if (f9061b) {
                    a("finished onSizeReady in " + com.bumptech.glide.g.h.a(this.w));
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static int a(int i, float f2) {
        return i == Integer.MIN_VALUE ? i : Math.round(f2 * i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.g
    public synchronized void a(E<?> e2, DataSource dataSource) {
        this.f9064e.b();
        this.v = null;
        if (e2 == null) {
            a(new GlideException("Expected to receive a Resource<R> with an object of " + this.k + " inside, but instead got null."));
            return;
        }
        Object obj = e2.get();
        if (obj != null && this.k.isAssignableFrom(obj.getClass())) {
            if (!j()) {
                a(e2);
                this.x = Status.COMPLETE;
                return;
            } else {
                a(e2, obj, dataSource);
                return;
            }
        }
        a(e2);
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to receive an object of ");
        sb.append(this.k);
        sb.append(" but instead got ");
        sb.append(obj != null ? obj.getClass() : "");
        sb.append("{");
        sb.append(obj);
        sb.append("} inside Resource{");
        sb.append(e2);
        sb.append("}.");
        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
        a(new GlideException(sb.toString()));
    }

    private synchronized void a(E<R> e2, R r, DataSource dataSource) {
        boolean z;
        boolean o = o();
        this.x = Status.COMPLETE;
        this.u = e2;
        if (this.i.e() <= 3) {
            Log.d("Glide", "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.j + " with size [" + this.B + FragmentC2201x.f23219a + this.C + "] in " + com.bumptech.glide.g.h.a(this.w) + " ms");
        }
        boolean z2 = true;
        this.f9062c = true;
        try {
            if (this.q != null) {
                Iterator<e<R>> it = this.q.iterator();
                z = false;
                while (it.hasNext()) {
                    z |= it.next().a(r, this.j, this.p, dataSource, o);
                }
            } else {
                z = false;
            }
            if (this.f9065f == null || !this.f9065f.a(r, this.j, this.p, dataSource, o)) {
                z2 = false;
            }
            if (!(z2 | z)) {
                this.p.a(r, this.s.a(dataSource, o));
            }
            this.f9062c = false;
            q();
        } catch (Throwable th) {
            this.f9062c = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.g
    public synchronized void a(GlideException glideException) {
        a(glideException, 5);
    }

    private synchronized void a(GlideException glideException, int i) {
        boolean z;
        this.f9064e.b();
        glideException.setOrigin(this.D);
        int e2 = this.i.e();
        if (e2 <= i) {
            Log.w("Glide", "Load failed for " + this.j + " with size [" + this.B + FragmentC2201x.f23219a + this.C + "]", glideException);
            if (e2 <= 4) {
                glideException.logRootCauses("Glide");
            }
        }
        this.v = null;
        this.x = Status.FAILED;
        boolean z2 = true;
        this.f9062c = true;
        try {
            if (this.q != null) {
                Iterator<e<R>> it = this.q.iterator();
                z = false;
                while (it.hasNext()) {
                    z |= it.next().a(glideException, this.j, this.p, o());
                }
            } else {
                z = false;
            }
            if (this.f9065f == null || !this.f9065f.a(glideException, this.j, this.p, o())) {
                z2 = false;
            }
            if (!(z | z2)) {
                r();
            }
            this.f9062c = false;
            p();
        } catch (Throwable th) {
            this.f9062c = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.c
    public synchronized boolean a(c cVar) {
        boolean z = false;
        if (!(cVar instanceof SingleRequest)) {
            return false;
        }
        SingleRequest<?> singleRequest = (SingleRequest) cVar;
        synchronized (singleRequest) {
            if (this.m == singleRequest.m && this.n == singleRequest.n && n.a(this.j, singleRequest.j) && this.k.equals(singleRequest.k) && this.l.equals(singleRequest.l) && this.o == singleRequest.o && a(singleRequest)) {
                z = true;
            }
        }
        return z;
    }

    private synchronized boolean a(SingleRequest<?> singleRequest) {
        boolean z;
        synchronized (singleRequest) {
            z = (this.q == null ? 0 : this.q.size()) == (singleRequest.q == null ? 0 : singleRequest.q.size());
        }
        return z;
    }

    private void a(String str) {
        Log.v("Request", str + " this: " + this.f9063d);
    }
}
