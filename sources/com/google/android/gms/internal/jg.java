package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.Wallet;

/* loaded from: classes.dex */
class jg extends Wallet.zzb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MaskedWalletRequest f1647a;
    final /* synthetic */ int b;
    final /* synthetic */ zzrn c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jg(zzrn zzrnVar, GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i) {
        super(googleApiClient);
        this.c = zzrnVar;
        this.f1647a = maskedWalletRequest;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzro zzroVar) {
        zzroVar.zza(this.f1647a, this.b);
        zzb((jg) Status.f979a);
    }
}
