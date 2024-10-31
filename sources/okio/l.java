package okio;

import java.io.IOException;

/* compiled from: ForwardingSource.java */
/* loaded from: classes3.dex */
public abstract class l implements z {

    /* renamed from: a */
    private final z f29249a;

    public l(z zVar) {
        if (zVar != null) {
            this.f29249a = zVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final z a() {
        return this.f29249a;
    }

    @Override // okio.z
    public long b(g gVar, long j) throws IOException {
        return this.f29249a.b(gVar, j);
    }

    @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29249a.close();
    }

    @Override // okio.z
    public B e() {
        return this.f29249a.e();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f29249a.toString() + ")";
    }
}
