package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c extends a {
    private final /* synthetic */ ProxyRequest s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(zzar zzarVar, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        super(googleApiClient);
        this.s = proxyRequest;
    }

    @Override // com.google.android.gms.internal.auth.a
    protected final void a(Context context, zzan zzanVar) throws RemoteException {
        zzanVar.zza(new d(this), this.s);
    }
}
