package okio;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsyncTimeout.java */
/* renamed from: okio.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2575b implements z {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f29232a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2576c f29233b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2575b(C2576c c2576c, z zVar) {
        this.f29233b = c2576c;
        this.f29232a = zVar;
    }

    @Override // okio.z
    public long b(g gVar, long j) throws IOException {
        this.f29233b.h();
        try {
            try {
                long b2 = this.f29232a.b(gVar, j);
                this.f29233b.a(true);
                return b2;
            } catch (IOException e2) {
                throw this.f29233b.a(e2);
            }
        } catch (Throwable th) {
            this.f29233b.a(false);
            throw th;
        }
    }

    @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            try {
                this.f29232a.close();
                this.f29233b.a(true);
            } catch (IOException e2) {
                throw this.f29233b.a(e2);
            }
        } catch (Throwable th) {
            this.f29233b.a(false);
            throw th;
        }
    }

    @Override // okio.z
    public B e() {
        return this.f29233b;
    }

    public String toString() {
        return "AsyncTimeout.source(" + this.f29232a + ")";
    }
}
