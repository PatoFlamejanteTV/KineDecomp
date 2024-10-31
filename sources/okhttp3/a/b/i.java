package okhttp3.a.b;

import javax.annotation.Nullable;
import okhttp3.C;
import okhttp3.O;

/* compiled from: RealResponseBody.java */
/* loaded from: classes3.dex */
public final class i extends O {

    /* renamed from: b */
    @Nullable
    private final String f28888b;

    /* renamed from: c */
    private final long f28889c;

    /* renamed from: d */
    private final okio.i f28890d;

    public i(@Nullable String str, long j, okio.i iVar) {
        this.f28888b = str;
        this.f28889c = j;
        this.f28890d = iVar;
    }

    @Override // okhttp3.O
    public long b() {
        return this.f28889c;
    }

    @Override // okhttp3.O
    public C c() {
        String str = this.f28888b;
        if (str != null) {
            return C.b(str);
        }
        return null;
    }

    @Override // okhttp3.O
    public okio.i r() {
        return this.f28890d;
    }
}
