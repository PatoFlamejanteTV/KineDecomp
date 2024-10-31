package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;

/* loaded from: classes2.dex */
final class d extends zzaj {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ c f12748a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f12748a = cVar;
    }

    @Override // com.google.android.gms.internal.auth.zzaj, com.google.android.gms.internal.auth.zzal
    public final void zza(ProxyResponse proxyResponse) {
        this.f12748a.a((c) new g(proxyResponse));
    }
}
