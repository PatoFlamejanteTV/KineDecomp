package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class Lm implements zzsw {

    /* renamed from: a */
    private final /* synthetic */ zztq f11674a;

    public Lm(zztq zztqVar) {
        this.f11674a = zztqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzs(boolean z) {
        if (z) {
            this.f11674a.connect();
        } else {
            this.f11674a.disconnect();
        }
    }
}
