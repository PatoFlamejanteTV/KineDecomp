package com.google.android.gms.internal.ads;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.vl */
/* loaded from: classes2.dex */
final class C1129vl implements zzlv {

    /* renamed from: a */
    private final int f12614a;

    /* renamed from: b */
    private final /* synthetic */ C1032ol f12615b;

    public C1129vl(C1032ol c1032ol, int i) {
        this.f12615b = c1032ol;
        this.f12614a = i;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final boolean isReady() {
        return this.f12615b.a(this.f12614a);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final int zzb(zzfu zzfuVar, zzho zzhoVar, boolean z) {
        return this.f12615b.a(this.f12614a, zzfuVar, zzhoVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzev() throws IOException {
        this.f12615b.b();
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzz(long j) {
        this.f12615b.a(this.f12614a, j);
    }
}
