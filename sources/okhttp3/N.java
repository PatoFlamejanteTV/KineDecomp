package okhttp3;

import javax.annotation.Nullable;

/* compiled from: ResponseBody.java */
/* loaded from: classes3.dex */
public class N extends O {

    /* renamed from: b */
    final /* synthetic */ C f28835b;

    /* renamed from: c */
    final /* synthetic */ long f28836c;

    /* renamed from: d */
    final /* synthetic */ okio.i f28837d;

    public N(C c2, long j, okio.i iVar) {
        this.f28835b = c2;
        this.f28836c = j;
        this.f28837d = iVar;
    }

    @Override // okhttp3.O
    public long b() {
        return this.f28836c;
    }

    @Override // okhttp3.O
    @Nullable
    public C c() {
        return this.f28835b;
    }

    @Override // okhttp3.O
    public okio.i r() {
        return this.f28837d;
    }
}
