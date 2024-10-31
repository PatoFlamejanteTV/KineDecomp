package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Wallet;

/* loaded from: classes.dex */
class jj extends Wallet.zzb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NotifyTransactionStatusRequest f1650a;
    final /* synthetic */ zzrn b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jj(zzrn zzrnVar, GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        super(googleApiClient);
        this.b = zzrnVar;
        this.f1650a = notifyTransactionStatusRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzro zzroVar) {
        zzroVar.zza(this.f1650a);
        zzb((jj) Status.f979a);
    }
}
