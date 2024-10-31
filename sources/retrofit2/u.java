package retrofit2;

import java.io.IOException;
import retrofit2.v;

/* compiled from: OkHttpCall.java */
/* loaded from: classes3.dex */
class u extends okio.l {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ v.a f29520b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(v.a aVar, okio.z zVar) {
        super(zVar);
        this.f29520b = aVar;
    }

    @Override // okio.l, okio.z
    public long b(okio.g gVar, long j) throws IOException {
        try {
            return super.b(gVar, j);
        } catch (IOException e2) {
            this.f29520b.f29530c = e2;
            throw e2;
        }
    }
}
