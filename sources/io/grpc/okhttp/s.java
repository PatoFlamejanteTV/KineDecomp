package io.grpc.okhttp;

import android.support.v4.internal.view.SupportMenu;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import io.grpc.C2403b;
import io.grpc.MethodDescriptor;
import io.grpc.P;
import io.grpc.Status;
import io.grpc.internal.AbstractC2411a;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Mc;
import io.grpc.internal.Rc;
import io.grpc.internal.Tc;
import io.grpc.internal._a;
import io.grpc.okhttp.internal.framed.ErrorCode;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OkHttpClientStream.java */
/* loaded from: classes3.dex */
public class s extends AbstractC2411a {

    /* renamed from: g, reason: collision with root package name */
    private static final okio.g f27992g = new okio.g();

    /* renamed from: h, reason: collision with root package name */
    private final MethodDescriptor<?, ?> f27993h;
    private final String i;
    private final Mc j;
    private String k;
    private Object l;
    private volatile int m;
    private final c n;
    private final b o;
    private final C2403b p;
    private boolean q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OkHttpClientStream.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        okio.g f27994a;

        /* renamed from: b, reason: collision with root package name */
        boolean f27995b;

        /* renamed from: c, reason: collision with root package name */
        boolean f27996c;

        a(okio.g gVar, boolean z, boolean z2) {
            this.f27994a = gVar;
            this.f27995b = z;
            this.f27996c = z2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OkHttpClientStream.java */
    /* loaded from: classes3.dex */
    public class c extends _a {
        private int A;
        private int B;
        private final l C;
        private final E D;
        private final w E;
        private final Object w;
        private List<io.grpc.okhttp.internal.framed.c> x;
        private Queue<a> y;
        private boolean z;

        public c(int i, Mc mc, Object obj, l lVar, E e2, w wVar) {
            super(i, mc, s.this.g());
            this.y = new ArrayDeque();
            this.z = false;
            this.A = SupportMenu.USER_MASK;
            this.B = SupportMenu.USER_MASK;
            Preconditions.a(obj, "lock");
            this.w = obj;
            this.C = lVar;
            this.D = e2;
            this.E = wVar;
        }

        private void h() {
            if (!e()) {
                this.E.a(s.this.k(), null, ClientStreamListener.RpcProgress.PROCESSED, false, ErrorCode.CANCEL, null);
            } else {
                this.E.a(s.this.k(), null, ClientStreamListener.RpcProgress.PROCESSED, false, null, null);
            }
        }

        @Override // io.grpc.internal._a
        protected void b(Status status, boolean z, P p) {
            c(status, z, p);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.internal.AbstractC2427e.a
        public void c() {
            super.c();
            a().c();
        }

        public void e(int i) {
            Preconditions.b(s.this.m == -1, "the stream has been started with id %s", i);
            s.this.m = i;
            s.this.n.c();
            if (this.y != null) {
                this.C.a(s.this.q, false, s.this.m, 0, this.x);
                s.this.j.b();
                this.x = null;
                boolean z = false;
                while (!this.y.isEmpty()) {
                    a poll = this.y.poll();
                    this.D.a(poll.f27995b, s.this.m, poll.f27994a, false);
                    if (poll.f27996c) {
                        z = true;
                    }
                }
                if (z) {
                    this.D.a();
                }
                this.y = null;
            }
        }

        @Override // io.grpc.internal.MessageDeframer.a
        public void c(int i) {
            this.B -= i;
            int i2 = this.B;
            if (i2 <= 32767) {
                int i3 = SupportMenu.USER_MASK - i2;
                this.A += i3;
                this.B = i2 + i3;
                this.C.a(s.this.k(), i3);
            }
        }

        @Override // io.grpc.internal.MessageDeframer.a
        public void a(Throwable th) {
            b(Status.a(th), true, new P());
        }

        @Override // io.grpc.internal._a, io.grpc.internal.AbstractC2411a.c, io.grpc.internal.MessageDeframer.a
        public void a(boolean z) {
            h();
            super.a(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Status status, boolean z, P p) {
            if (this.z) {
                return;
            }
            this.z = true;
            if (this.y != null) {
                this.E.a(s.this);
                this.x = null;
                Iterator<a> it = this.y.iterator();
                while (it.hasNext()) {
                    it.next().f27994a.a();
                }
                this.y = null;
                if (p == null) {
                    p = new P();
                }
                a(status, true, p);
                return;
            }
            this.E.a(s.this.k(), status, ClientStreamListener.RpcProgress.PROCESSED, z, ErrorCode.CANCEL, p);
        }

        @Override // io.grpc.internal.C2463n.b
        public void a(Runnable runnable) {
            synchronized (this.w) {
                runnable.run();
            }
        }

        public void a(List<io.grpc.okhttp.internal.framed.c> list, boolean z) {
            if (z) {
                c(F.b(list));
            } else {
                b(F.a(list));
            }
        }

        public void a(okio.g gVar, boolean z) {
            this.A -= (int) gVar.size();
            if (this.A < 0) {
                this.C.a(s.this.k(), ErrorCode.FLOW_CONTROL_ERROR);
                this.E.a(s.this.k(), Status.p.b("Received data size exceeded our receiving window size"), ClientStreamListener.RpcProgress.PROCESSED, false, null, null);
            } else {
                super.a(new y(gVar), z);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(okio.g gVar, boolean z, boolean z2) {
            if (this.z) {
                return;
            }
            Queue<a> queue = this.y;
            if (queue != null) {
                queue.add(new a(gVar, z, z2));
            } else {
                Preconditions.b(s.this.k() != -1, "streamId should be set");
                this.D.a(z, s.this.k(), gVar, z2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(P p, String str) {
            this.x = m.a(p, str, s.this.k, s.this.i, s.this.q);
            this.E.b(s.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MethodDescriptor<?, ?> methodDescriptor, P p, l lVar, w wVar, E e2, Object obj, int i, String str, String str2, Mc mc, Rc rc) {
        super(new C(), mc, rc, p, methodDescriptor.e());
        this.m = -1;
        this.o = new b();
        this.q = false;
        Preconditions.a(mc, "statsTraceCtx");
        this.j = mc;
        this.f27993h = methodDescriptor;
        this.k = str;
        this.i = str2;
        this.p = wVar.getAttributes();
        this.n = new c(i, mc, obj, lVar, e2, wVar);
    }

    public MethodDescriptor.MethodType j() {
        return this.f27993h.d();
    }

    public int k() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object i() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractC2411a
    public b e() {
        return this.o;
    }

    @Override // io.grpc.internal.X
    public void a(String str) {
        Preconditions.a(str, "authority");
        this.k = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractC2411a, io.grpc.internal.AbstractC2427e
    public c d() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Object obj) {
        this.l = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OkHttpClientStream.java */
    /* loaded from: classes3.dex */
    public class b implements AbstractC2411a.b {
        b() {
        }

        @Override // io.grpc.internal.AbstractC2411a.b
        public void a(P p, byte[] bArr) {
            String str = "/" + s.this.f27993h.a();
            if (bArr != null) {
                s.this.q = true;
                str = str + "?" + BaseEncoding.b().a(bArr);
            }
            synchronized (s.this.n.w) {
                s.this.n.a(p, str);
            }
        }

        @Override // io.grpc.internal.AbstractC2411a.b
        public void a(Tc tc, boolean z, boolean z2, int i) {
            okio.g b2;
            if (tc == null) {
                b2 = s.f27992g;
            } else {
                b2 = ((B) tc).b();
                int size = (int) b2.size();
                if (size > 0) {
                    s.this.d(size);
                }
            }
            synchronized (s.this.n.w) {
                s.this.n.a(b2, z, z2);
                s.this.g().a(i);
            }
        }

        @Override // io.grpc.internal.AbstractC2411a.b
        public void a(int i) {
            synchronized (s.this.n.w) {
                s.this.n.b(i);
            }
        }

        @Override // io.grpc.internal.AbstractC2411a.b
        public void a(Status status) {
            synchronized (s.this.n.w) {
                s.this.n.c(status, true, null);
            }
        }
    }
}
