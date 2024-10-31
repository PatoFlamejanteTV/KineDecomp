package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzpu;

/* loaded from: classes.dex */
class ia extends zzpu.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1617a;
    final /* synthetic */ String b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ zzlm d;
    final /* synthetic */ zzlm e;
    final /* synthetic */ zzpu f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ia(zzpu zzpuVar, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, zzlm zzlmVar, zzlm zzlmVar2) {
        super(googleApiClient, null);
        this.f = zzpuVar;
        this.f1617a = str;
        this.b = str2;
        this.c = bArr;
        this.d = zzlmVar;
        this.e = zzlmVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzpt zzptVar) throws RemoteException {
        zzptVar.zza(this, this.f1617a, this.b, this.c, this.d, this.e);
    }
}
