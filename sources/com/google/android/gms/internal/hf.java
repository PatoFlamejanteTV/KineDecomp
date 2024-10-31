package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.internal.zznq;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class hf extends zznq.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DataSource f1597a;
    final /* synthetic */ zzor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hf(zzor zzorVar, GoogleApiClient googleApiClient, DataSource dataSource) {
        super(googleApiClient);
        this.b = zzorVar;
        this.f1597a = dataSource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zznq zznqVar) throws RemoteException {
        ((zzob) zznqVar.zzpc()).zza(new UnsubscribeRequest(null, this.f1597a, new zzou(this)));
    }
}
