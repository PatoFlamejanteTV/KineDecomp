package com.google.android.gms.internal.firebase_dynamic_links;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class c extends b<Status> {
    private final String s;

    public c(zze zzeVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.s = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result a(Status status) {
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzn zznVar) throws RemoteException {
        zzn zznVar2 = zznVar;
        try {
            ((zzr) zznVar2.getService()).zza(new d(this), this.s);
        } catch (RemoteException unused) {
        }
    }
}
