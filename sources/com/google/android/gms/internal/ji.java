package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.Wallet;

/* loaded from: classes.dex */
class ji extends Wallet.zzb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1649a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ zzrn d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ji(zzrn zzrnVar, GoogleApiClient googleApiClient, String str, String str2, int i) {
        super(googleApiClient);
        this.d = zzrnVar;
        this.f1649a = str;
        this.b = str2;
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzro zzroVar) {
        zzroVar.zze(this.f1649a, this.b, this.c);
        zzb((ji) Status.f979a);
    }
}
