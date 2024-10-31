package com.google.android.gms.appdatasearch;

import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzlb;

/* loaded from: classes.dex */
class a extends zzjr<GetRecentContextCall.Response> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GetRecentContextCall.zza f768a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GetRecentContextCall.zza zzaVar, zzlb.zzb zzbVar) {
        super(zzbVar);
        this.f768a = zzaVar;
    }

    @Override // com.google.android.gms.internal.zzjr, com.google.android.gms.internal.zzjq
    public void zza(GetRecentContextCall.Response response) {
        this.zzRb.zzp(response);
    }
}
