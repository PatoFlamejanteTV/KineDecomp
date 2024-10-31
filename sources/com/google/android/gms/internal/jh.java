package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.Wallet;

/* loaded from: classes.dex */
class jh extends Wallet.zzb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FullWalletRequest f1648a;
    final /* synthetic */ int b;
    final /* synthetic */ zzrn c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jh(zzrn zzrnVar, GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i) {
        super(googleApiClient);
        this.c = zzrnVar;
        this.f1648a = fullWalletRequest;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzro zzroVar) {
        zzroVar.zza(this.f1648a, this.b);
        zzb((jh) Status.f979a);
    }
}
