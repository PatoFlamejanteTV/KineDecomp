package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.nearby.connection.AppMetadata;

/* loaded from: classes.dex */
class hy extends zzpu.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1614a;
    final /* synthetic */ AppMetadata b;
    final /* synthetic */ long c;
    final /* synthetic */ zzlm d;
    final /* synthetic */ zzpu e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hy(zzpu zzpuVar, GoogleApiClient googleApiClient, String str, AppMetadata appMetadata, long j, zzlm zzlmVar) {
        super(googleApiClient, null);
        this.e = zzpuVar;
        this.f1614a = str;
        this.b = appMetadata;
        this.c = j;
        this.d = zzlmVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzpt zzptVar) throws RemoteException {
        zzptVar.zza(this, this.f1614a, this.b, this.c, this.d);
    }
}
