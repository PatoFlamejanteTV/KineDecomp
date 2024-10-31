package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzpz;

/* renamed from: com.google.android.gms.internal.if, reason: invalid class name */
/* loaded from: classes2.dex */
class Cif extends zzpz.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Uri f1622a;
    final /* synthetic */ zzpz b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cif(zzpz zzpzVar, GoogleApiClient googleApiClient, Uri uri) {
        super(googleApiClient);
        this.b = zzpzVar;
        this.f1622a = uri;
    }

    @Override // com.google.android.gms.internal.zzpz.c
    protected void a(Context context, zzpy zzpyVar) throws RemoteException {
        zzpz.zza(context, zzpyVar, new zzpz.b(this), this.f1622a, null);
    }
}
