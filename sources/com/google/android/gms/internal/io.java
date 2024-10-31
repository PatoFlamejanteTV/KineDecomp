package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzqi;

/* loaded from: classes.dex */
class io extends zzqi.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f1631a;
    final /* synthetic */ String b;
    final /* synthetic */ zzqi c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public io(zzqi zzqiVar, GoogleApiClient googleApiClient, int i, String str) {
        super(googleApiClient, null);
        this.c = zzqiVar;
        this.f1631a = i;
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
        zza(zzeVar.a(this, this.f1631a, this.b));
    }
}
