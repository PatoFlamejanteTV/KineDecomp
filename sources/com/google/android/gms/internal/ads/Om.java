package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* loaded from: classes2.dex */
public final class Om extends zzbcl<InputStream> {

    /* renamed from: a */
    private final /* synthetic */ zzue f11743a;

    public Om(zzue zzueVar) {
        this.f11743a = zzueVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbcl, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.f11743a.disconnect();
        return super.cancel(z);
    }
}
