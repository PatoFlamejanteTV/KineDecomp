package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.Wallet;

/* loaded from: classes.dex */
class jk extends Wallet.zzb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f1651a;
    final /* synthetic */ zzrn b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jk(zzrn zzrnVar, GoogleApiClient googleApiClient, int i) {
        super(googleApiClient);
        this.b = zzrnVar;
        this.f1651a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzro zzroVar) {
        zzroVar.zzkA(this.f1651a);
        zzb((jk) Status.f979a);
    }
}
