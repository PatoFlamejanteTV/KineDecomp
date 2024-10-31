package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqh;

/* loaded from: classes.dex */
class im extends zzqh.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1629a;
    final /* synthetic */ zzqh b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public im(zzqh zzqhVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient, null);
        this.b = zzqhVar;
        this.f1629a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
        zzeVar.a(this.f1629a);
        zzb((im) Status.f979a);
    }
}
