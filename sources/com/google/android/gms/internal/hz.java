package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzpu;

/* loaded from: classes.dex */
class hz extends zzpu.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1615a;
    final /* synthetic */ long b;
    final /* synthetic */ zzlm c;
    final /* synthetic */ zzpu d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hz(zzpu zzpuVar, GoogleApiClient googleApiClient, String str, long j, zzlm zzlmVar) {
        super(googleApiClient, null);
        this.d = zzpuVar;
        this.f1615a = str;
        this.b = j;
        this.c = zzlmVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzpt zzptVar) throws RemoteException {
        zzptVar.zza(this, this.f1615a, this.b, this.c);
    }
}
