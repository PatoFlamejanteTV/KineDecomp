package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout.java */
/* loaded from: classes3.dex */
public class m extends B {

    /* renamed from: e */
    private B f29250e;

    public m(B b2) {
        if (b2 != null) {
            this.f29250e = b2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final m a(B b2) {
        if (b2 != null) {
            this.f29250e = b2;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // okio.B
    public B b() {
        return this.f29250e.b();
    }

    @Override // okio.B
    public long c() {
        return this.f29250e.c();
    }

    @Override // okio.B
    public boolean d() {
        return this.f29250e.d();
    }

    @Override // okio.B
    public void e() throws IOException {
        this.f29250e.e();
    }

    public final B g() {
        return this.f29250e;
    }

    @Override // okio.B
    public B a(long j, TimeUnit timeUnit) {
        return this.f29250e.a(j, timeUnit);
    }

    @Override // okio.B
    public B a(long j) {
        return this.f29250e.a(j);
    }

    @Override // okio.B
    public B a() {
        return this.f29250e.a();
    }
}
