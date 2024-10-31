package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
class b extends zzh {

    /* renamed from: a */
    final /* synthetic */ String f841a;
    final /* synthetic */ String b;
    final /* synthetic */ Cast.CastApi.zza c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Cast.CastApi.zza zzaVar, GoogleApiClient googleApiClient, String str, String str2) {
        super(googleApiClient);
        this.c = zzaVar;
        this.f841a = str;
        this.b = str2;
    }

    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a */
    public void zza(zze zzeVar) throws RemoteException {
        try {
            zzeVar.a(this.f841a, this.b, this);
        } catch (IllegalArgumentException | IllegalStateException e) {
            zzba(2001);
        }
    }
}
