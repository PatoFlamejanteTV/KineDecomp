package okhttp3.a.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okio.B;
import okio.g;
import okio.h;
import okio.i;
import okio.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CacheInterceptor.java */
/* loaded from: classes3.dex */
public class a implements z {

    /* renamed from: a, reason: collision with root package name */
    boolean f28855a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f28856b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c f28857c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ h f28858d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ b f28859e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, i iVar, c cVar, h hVar) {
        this.f28859e = bVar;
        this.f28856b = iVar;
        this.f28857c = cVar;
        this.f28858d = hVar;
    }

    @Override // okio.z
    public long b(g gVar, long j) throws IOException {
        try {
            long b2 = this.f28856b.b(gVar, j);
            if (b2 == -1) {
                if (!this.f28855a) {
                    this.f28855a = true;
                    this.f28858d.close();
                }
                return -1L;
            }
            gVar.a(this.f28858d.d(), gVar.size() - b2, b2);
            this.f28858d.g();
            return b2;
        } catch (IOException e2) {
            if (!this.f28855a) {
                this.f28855a = true;
                this.f28857c.abort();
            }
            throw e2;
        }
    }

    @Override // okio.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f28855a && !okhttp3.a.e.a(this, 100, TimeUnit.MILLISECONDS)) {
            this.f28855a = true;
            this.f28857c.abort();
        }
        this.f28856b.close();
    }

    @Override // okio.z
    public B e() {
        return this.f28856b.e();
    }
}
