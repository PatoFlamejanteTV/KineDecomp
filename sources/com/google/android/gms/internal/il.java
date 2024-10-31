package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.plus.model.moments.Moment;

/* loaded from: classes.dex */
class il extends zzqh.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Moment f1628a;
    final /* synthetic */ zzqh b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public il(zzqh zzqhVar, GoogleApiClient googleApiClient, Moment moment) {
        super(googleApiClient, null);
        this.b = zzqhVar;
        this.f1628a = moment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
        zzeVar.a(this, this.f1628a);
    }
}
