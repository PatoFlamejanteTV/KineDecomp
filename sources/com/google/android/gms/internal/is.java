package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzqi;

/* loaded from: classes.dex */
class is extends zzqi.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String[] f1635a;
    final /* synthetic */ zzqi b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public is(zzqi zzqiVar, GoogleApiClient googleApiClient, String[] strArr) {
        super(googleApiClient, null);
        this.b = zzqiVar;
        this.f1635a = strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
        zzeVar.a(this, this.f1635a);
    }
}
