package okhttp3;

import android.support.v4.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okio.C2576c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealCall.java */
/* loaded from: classes3.dex */
public final class H implements InterfaceC2562f {

    /* renamed from: a, reason: collision with root package name */
    final F f28793a;

    /* renamed from: b, reason: collision with root package name */
    final okhttp3.a.b.k f28794b;

    /* renamed from: c, reason: collision with root package name */
    final C2576c f28795c = new G(this);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private w f28796d;

    /* renamed from: e, reason: collision with root package name */
    final I f28797e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f28798f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28799g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RealCall.java */
    /* loaded from: classes3.dex */
    public final class a extends okhttp3.a.b {

        /* renamed from: b, reason: collision with root package name */
        private final InterfaceC2563g f28800b;

        a(InterfaceC2563g interfaceC2563g) {
            super("OkHttp %s", H.this.b());
            this.f28800b = interfaceC2563g;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    H.this.f28796d.a(H.this, interruptedIOException);
                    this.f28800b.a(H.this, interruptedIOException);
                    H.this.f28793a.h().b(this);
                }
            } catch (Throwable th) {
                H.this.f28793a.h().b(this);
                throw th;
            }
        }

        @Override // okhttp3.a.b
        protected void c() {
            IOException e2;
            boolean z;
            H.this.f28795c.h();
            try {
                try {
                    z = true;
                    try {
                        this.f28800b.a(H.this, H.this.a());
                    } catch (IOException e3) {
                        e2 = e3;
                        IOException a2 = H.this.a(e2);
                        if (!z) {
                            H.this.f28796d.a(H.this, a2);
                            this.f28800b.a(H.this, a2);
                        } else {
                            okhttp3.a.d.f.a().a(4, "Callback failure for " + H.this.c(), a2);
                        }
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    z = false;
                }
            } finally {
                H.this.f28793a.h().b(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public H d() {
            return H.this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String e() {
            return H.this.f28797e.g().g();
        }
    }

    private H(F f2, I i, boolean z) {
        this.f28793a = f2;
        this.f28797e = i;
        this.f28798f = z;
        this.f28794b = new okhttp3.a.b.k(f2, z);
        this.f28795c.a(f2.b(), TimeUnit.MILLISECONDS);
    }

    private void d() {
        this.f28794b.a(okhttp3.a.d.f.a().a("response.body().close()"));
    }

    @Override // okhttp3.InterfaceC2562f
    public boolean S() {
        return this.f28794b.b();
    }

    String b() {
        return this.f28797e.g().m();
    }

    String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(S() ? "canceled " : "");
        sb.append(this.f28798f ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(b());
        return sb.toString();
    }

    @Override // okhttp3.InterfaceC2562f
    public void cancel() {
        this.f28794b.a();
    }

    @Override // okhttp3.InterfaceC2562f
    public M execute() throws IOException {
        synchronized (this) {
            if (!this.f28799g) {
                this.f28799g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        d();
        this.f28795c.h();
        this.f28796d.b(this);
        try {
            try {
                this.f28793a.h().a(this);
                M a2 = a();
                if (a2 != null) {
                    return a2;
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                IOException a3 = a(e2);
                this.f28796d.a(this, a3);
                throw a3;
            }
        } finally {
            this.f28793a.h().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static H a(F f2, I i, boolean z) {
        H h2 = new H(f2, i, z);
        h2.f28796d = f2.j().a(h2);
        return h2;
    }

    public H clone() {
        return a(this.f28793a, this.f28797e, this.f28798f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public IOException a(@Nullable IOException iOException) {
        if (!this.f28795c.i()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @Override // okhttp3.InterfaceC2562f
    public void a(InterfaceC2563g interfaceC2563g) {
        synchronized (this) {
            if (!this.f28799g) {
                this.f28799g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        d();
        this.f28796d.b(this);
        this.f28793a.h().a(new a(interfaceC2563g));
    }

    M a() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f28793a.n());
        arrayList.add(this.f28794b);
        arrayList.add(new okhttp3.a.b.a(this.f28793a.g()));
        arrayList.add(new okhttp3.a.a.b(this.f28793a.o()));
        arrayList.add(new okhttp3.internal.connection.a(this.f28793a));
        if (!this.f28798f) {
            arrayList.addAll(this.f28793a.p());
        }
        arrayList.add(new okhttp3.a.b.b(this.f28798f));
        M a2 = new okhttp3.a.b.h(arrayList, null, null, null, 0, this.f28797e, this, this.f28796d, this.f28793a.d(), this.f28793a.v(), this.f28793a.z()).a(this.f28797e);
        if (!this.f28794b.b()) {
            return a2;
        }
        okhttp3.a.e.a(a2);
        throw new IOException("Canceled");
    }
}
