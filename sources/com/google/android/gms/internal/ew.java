package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ew extends ev {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProxyRequest f1541a;
    final /* synthetic */ zzkm b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ew(zzkm zzkmVar, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        super(googleApiClient);
        this.b = zzkmVar;
        this.f1541a = proxyRequest;
    }

    @Override // com.google.android.gms.internal.ev
    protected void a(Context context, zzkk zzkkVar) throws RemoteException {
        zzkkVar.zza(new ex(this), this.f1541a);
    }
}
