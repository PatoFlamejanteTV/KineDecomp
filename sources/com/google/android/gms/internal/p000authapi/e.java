package com.google.android.gms.internal.p000authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class e extends g<Status> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(zzi zziVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result a(Status status) {
        return status;
    }

    @Override // com.google.android.gms.internal.p000authapi.g
    protected final void a(Context context, zzw zzwVar) throws RemoteException {
        zzwVar.zzc(new f(this));
    }
}
