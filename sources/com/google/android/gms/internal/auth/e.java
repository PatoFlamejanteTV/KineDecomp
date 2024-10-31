package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class e extends b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(zzar zzarVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.internal.auth.b
    protected final void a(Context context, zzan zzanVar) throws RemoteException {
        zzanVar.zza(new f(this));
    }
}
