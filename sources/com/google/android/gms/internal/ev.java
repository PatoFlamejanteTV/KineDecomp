package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class ev extends zzlb.zza<ProxyApi.ProxyResult, zzki> {
    public ev(GoogleApiClient googleApiClient) {
        super(Auth.f782a, googleApiClient);
    }

    @Override // com.google.android.gms.internal.zzlc
    /* renamed from: a */
    public ProxyApi.ProxyResult zzb(Status status) {
        return new ey(status);
    }

    protected abstract void a(Context context, zzkk zzkkVar) throws RemoteException;

    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a */
    public final void zza(zzki zzkiVar) throws RemoteException {
        a(zzkiVar.getContext(), zzkiVar.zzpc());
    }
}
