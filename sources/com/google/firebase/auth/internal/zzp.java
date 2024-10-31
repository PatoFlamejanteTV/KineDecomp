package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.firebase.auth.ProviderQueryResult;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzp implements ProviderQueryResult {

    /* renamed from: a */
    private List<String> f16543a;

    public zzp(zzcj zzcjVar) {
        Preconditions.a(zzcjVar);
        this.f16543a = zzcjVar.getAllProviders();
    }

    @Override // com.google.firebase.auth.ProviderQueryResult
    public final List<String> a() {
        return this.f16543a;
    }
}
