package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;

/* compiled from: TransportTracer.java */
/* loaded from: classes3.dex */
public final class Rc {

    /* renamed from: a */
    private static final c f27491a = new Qc();

    /* renamed from: b */
    private static final a f27492b = new a(f27491a);

    /* renamed from: c */
    private final c f27493c;

    /* renamed from: d */
    private long f27494d;

    /* renamed from: e */
    private long f27495e;

    /* renamed from: f */
    private long f27496f;

    /* renamed from: g */
    private long f27497g;

    /* renamed from: h */
    private long f27498h;
    private b i;
    private long j;
    private long k;
    private final InterfaceC2496vb l;
    private volatile long m;

    /* compiled from: TransportTracer.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        private c f27499a;

        @VisibleForTesting
        public a(c cVar) {
            this.f27499a = cVar;
        }

        public Rc a() {
            return new Rc(this.f27499a, null);
        }
    }

    /* compiled from: TransportTracer.java */
    /* loaded from: classes3.dex */
    public interface b {
    }

    /* compiled from: TransportTracer.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public interface c {
        long a();
    }

    /* synthetic */ Rc(c cVar, Qc qc) {
        this(cVar);
    }

    private long e() {
        return TimeUnit.MILLISECONDS.toNanos(this.f27493c.a());
    }

    public void a(boolean z) {
        if (z) {
            this.f27496f++;
        } else {
            this.f27497g++;
        }
    }

    public void b() {
        this.f27498h++;
    }

    public void c() {
        this.f27494d++;
        this.f27495e = e();
    }

    public void d() {
        this.l.add(1L);
        this.m = e();
    }

    public Rc() {
        this.l = C2499wb.a();
        this.f27493c = f27491a;
    }

    public void a(int i) {
        if (i == 0) {
            return;
        }
        this.j += i;
        this.k = e();
    }

    private Rc(c cVar) {
        this.l = C2499wb.a();
        this.f27493c = cVar;
    }

    public void a(b bVar) {
        Preconditions.a(bVar);
        this.i = bVar;
    }

    public static a a() {
        return f27492b;
    }
}
