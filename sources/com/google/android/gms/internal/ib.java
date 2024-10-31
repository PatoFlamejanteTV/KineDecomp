package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzpu;

/* loaded from: classes.dex */
class ib extends zzpu.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1618a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ zzlm c;
    final /* synthetic */ zzpu d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ib(zzpu zzpuVar, GoogleApiClient googleApiClient, String str, byte[] bArr, zzlm zzlmVar) {
        super(googleApiClient, null);
        this.d = zzpuVar;
        this.f1618a = str;
        this.b = bArr;
        this.c = zzlmVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzpt zzptVar) throws RemoteException {
        zzptVar.zza(this, this.f1618a, this.b, this.c);
    }
}
