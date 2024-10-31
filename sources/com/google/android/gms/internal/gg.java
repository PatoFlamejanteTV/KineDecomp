package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.gh;
import com.google.android.gms.internal.zzlz;

/* loaded from: classes.dex */
class gg extends gh.a {

    /* renamed from: a */
    final /* synthetic */ zzlz f1571a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gg(zzlz zzlzVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f1571a = zzlzVar;
    }

    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a */
    public void zza(zzmb zzmbVar) throws RemoteException {
        zzmbVar.zzpc().zza(new zzlz.a(this));
    }
}
