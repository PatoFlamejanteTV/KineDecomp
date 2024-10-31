package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzqi;

/* loaded from: classes.dex */
class ip extends zzqi.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1632a;
    final /* synthetic */ zzqi b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ip(zzqi zzqiVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient, null);
        this.b = zzqiVar;
        this.f1632a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
        zza(zzeVar.a(this, this.f1632a));
    }
}
