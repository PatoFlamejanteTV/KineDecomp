package okio;

import java.io.IOException;

/* compiled from: ForwardingSink.java */
/* loaded from: classes3.dex */
public abstract class k implements y {

    /* renamed from: a */
    private final y f29248a;

    public k(y yVar) {
        if (yVar != null) {
            this.f29248a = yVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // okio.y
    public void a(g gVar, long j) throws IOException {
        this.f29248a.a(gVar, j);
    }

    @Override // okio.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29248a.close();
    }

    @Override // okio.y
    public B e() {
        return this.f29248a.e();
    }

    @Override // okio.y, java.io.Flushable
    public void flush() throws IOException {
        this.f29248a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f29248a.toString() + ")";
    }
}
