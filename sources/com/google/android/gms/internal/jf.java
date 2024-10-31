package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.Wallet;

/* loaded from: classes.dex */
class jf extends Wallet.zzb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f1646a;
    final /* synthetic */ zzrn b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jf(zzrn zzrnVar, GoogleApiClient googleApiClient, int i) {
        super(googleApiClient);
        this.b = zzrnVar;
        this.f1646a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzro zzroVar) {
        zzroVar.zzkz(this.f1646a);
        zzb((jf) Status.f979a);
    }
}
