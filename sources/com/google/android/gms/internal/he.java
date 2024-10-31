package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.internal.zznq;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class he extends zznq.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DataType f1596a;
    final /* synthetic */ zzor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public he(zzor zzorVar, GoogleApiClient googleApiClient, DataType dataType) {
        super(googleApiClient);
        this.b = zzorVar;
        this.f1596a = dataType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zznq zznqVar) throws RemoteException {
        ((zzob) zznqVar.zzpc()).zza(new UnsubscribeRequest(this.f1596a, null, new zzou(this)));
    }
}
