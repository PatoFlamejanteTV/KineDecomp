package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzpz;

/* loaded from: classes2.dex */
class ie extends zzpz.a {

    /* renamed from: a */
    final /* synthetic */ Uri f1621a;
    final /* synthetic */ zzpz b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ie(zzpz zzpzVar, GoogleApiClient googleApiClient, Uri uri) {
        super(googleApiClient);
        this.b = zzpzVar;
        this.f1621a = uri;
    }

    @Override // com.google.android.gms.internal.zzpz.c
    protected void a(Context context, zzpy zzpyVar) throws RemoteException {
        zzpyVar.zza(new zzpz.b(this), this.f1621a, null, false);
    }
}
