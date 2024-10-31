package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzqn;
import java.util.List;

/* loaded from: classes.dex */
class iw extends zzqn.c {

    /* renamed from: a */
    final /* synthetic */ List f1638a;
    final /* synthetic */ String b;
    final /* synthetic */ zzqn c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iw(zzqn zzqnVar, GoogleApiClient googleApiClient, List list, String str) {
        super(googleApiClient);
        this.c = zzqnVar;
        this.f1638a = list;
        this.b = str;
    }

    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a */
    public void zza(zzqo zzqoVar) throws RemoteException {
        zzqoVar.zza(this.d, this.f1638a, 1, this.b);
    }
}
