package io.grpc.internal;

import com.facebook.share.internal.ShareConstants;
import com.google.common.base.Preconditions;
import io.grpc.InterfaceC2514o;
import io.grpc.InterfaceC2521p;
import io.grpc.InterfaceC2527w;
import io.grpc.internal.C2463n;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.Oc;
import java.io.InputStream;

/* compiled from: AbstractStream.java */
/* renamed from: io.grpc.internal.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2427e implements Nc {

    /* compiled from: AbstractStream.java */
    /* renamed from: io.grpc.internal.e$a */
    /* loaded from: classes3.dex */
    public static abstract class a implements C2463n.b, MessageDeframer.a {

        /* renamed from: a, reason: collision with root package name */
        private InterfaceC2436ga f27597a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f27598b = new Object();

        /* renamed from: c, reason: collision with root package name */
        private final Mc f27599c;

        /* renamed from: d, reason: collision with root package name */
        private final Rc f27600d;

        /* renamed from: e, reason: collision with root package name */
        private int f27601e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f27602f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f27603g;

        /* JADX INFO: Access modifiers changed from: protected */
        public a(int i, Mc mc, Rc rc) {
            Preconditions.a(mc, "statsTraceCtx");
            this.f27599c = mc;
            Preconditions.a(rc, "transportTracer");
            this.f27600d = rc;
            this.f27597a = new MessageDeframer(this, InterfaceC2514o.b.f27821a, i, mc, rc);
        }

        private boolean e() {
            boolean z;
            synchronized (this.f27598b) {
                z = this.f27602f && this.f27601e < 32768 && !this.f27603g;
            }
            return z;
        }

        private void f() {
            boolean e2;
            synchronized (this.f27598b) {
                e2 = e();
            }
            if (e2) {
                b().a();
            }
        }

        protected abstract Oc b();

        /* JADX INFO: Access modifiers changed from: protected */
        public final void b(boolean z) {
            if (z) {
                this.f27597a.close();
            } else {
                this.f27597a.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void c() {
            Preconditions.b(b() != null);
            synchronized (this.f27598b) {
                Preconditions.b(this.f27602f ? false : true, "Already allocated");
                this.f27602f = true;
            }
            f();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void d(int i) {
            this.f27597a.b(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void a(GzipInflatingBuffer gzipInflatingBuffer) {
            this.f27597a.a(gzipInflatingBuffer);
            this.f27597a = new C2463n(this, this, (MessageDeframer) this.f27597a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void d() {
            synchronized (this.f27598b) {
                this.f27603g = true;
            }
        }

        public final void b(int i) {
            try {
                this.f27597a.a(i);
            } catch (Throwable th) {
                a(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(int i) {
            synchronized (this.f27598b) {
                this.f27601e += i;
            }
        }

        @Override // io.grpc.internal.MessageDeframer.a
        public void a(Oc.a aVar) {
            b().a(aVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void a(InterfaceC2426dc interfaceC2426dc) {
            try {
                this.f27597a.a(interfaceC2426dc);
            } catch (Throwable th) {
                a(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void a(InterfaceC2527w interfaceC2527w) {
            this.f27597a.a(interfaceC2527w);
        }

        public final void a(int i) {
            boolean z;
            synchronized (this.f27598b) {
                Preconditions.b(this.f27602f, "onStreamAllocated was not called, but it seems the stream is active");
                z = true;
                boolean z2 = this.f27601e < 32768;
                this.f27601e -= i;
                boolean z3 = this.f27601e < 32768;
                if (z2 || !z3) {
                    z = false;
                }
            }
            if (z) {
                f();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Rc a() {
            return this.f27600d;
        }
    }

    @Override // io.grpc.internal.Nc
    public final void a(InputStream inputStream) {
        Preconditions.a(inputStream, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        try {
            if (!c().isClosed()) {
                c().a(inputStream);
            }
        } finally {
            GrpcUtil.a(inputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        c().close();
    }

    protected abstract Ra c();

    protected abstract a d();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(int i) {
        d().e(i);
    }

    @Override // io.grpc.internal.Nc
    public final void flush() {
        if (c().isClosed()) {
            return;
        }
        c().flush();
    }

    @Override // io.grpc.internal.Nc
    public final void a(InterfaceC2521p interfaceC2521p) {
        Ra c2 = c();
        Preconditions.a(interfaceC2521p, "compressor");
        c2.a(interfaceC2521p);
    }
}
