package com.google.android.gms.internal.p000authapi;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* loaded from: classes2.dex */
abstract class g<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzr> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GoogleApiClient googleApiClient) {
        super(Auth.f10422f, googleApiClient);
    }

    protected abstract void a(Context context, zzw zzwVar) throws DeadObjectException, RemoteException;

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected /* synthetic */ void a(zzr zzrVar) throws RemoteException {
        zzr zzrVar2 = zzrVar;
        a(zzrVar2.getContext(), (zzw) zzrVar2.getService());
    }
}
