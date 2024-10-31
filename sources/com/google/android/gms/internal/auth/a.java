package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.AuthProxy;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* loaded from: classes2.dex */
abstract class a extends BaseImplementation.ApiMethodImpl<ProxyApi.ProxyResult, zzak> {
    public a(GoogleApiClient googleApiClient) {
        super(AuthProxy.f10431c, googleApiClient);
    }

    protected abstract void a(Context context, zzan zzanVar) throws RemoteException;

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected /* synthetic */ void a(zzak zzakVar) throws RemoteException {
        zzak zzakVar2 = zzakVar;
        a(zzakVar2.getContext(), (zzan) zzakVar2.getService());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result a(Status status) {
        return new g(status);
    }
}
