package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzqn;

/* loaded from: classes.dex */
class iv extends zzqn.b {

    /* renamed from: a */
    final /* synthetic */ byte[] f1637a;
    final /* synthetic */ zzqn b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iv(zzqn zzqnVar, GoogleApiClient googleApiClient, byte[] bArr) {
        super(googleApiClient);
        this.b = zzqnVar;
        this.f1637a = bArr;
    }

    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a */
    public void zza(zzqo zzqoVar) throws RemoteException {
        zzqoVar.zza(this.c, this.f1637a);
    }
}
