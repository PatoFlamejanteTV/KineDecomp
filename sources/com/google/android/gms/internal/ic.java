package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzpu;

/* loaded from: classes.dex */
class ic extends zzpu.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1619a;
    final /* synthetic */ zzpu b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ic(zzpu zzpuVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient, null);
        this.b = zzpuVar;
        this.f1619a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzpt zzptVar) throws RemoteException {
        zzptVar.zzp(this, this.f1619a);
    }
}
