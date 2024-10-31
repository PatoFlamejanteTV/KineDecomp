package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.zznq;
import com.google.android.gms.internal.zzor;

/* loaded from: classes.dex */
class hc extends zznq.a<ListSubscriptionsResult> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DataType f1594a;
    final /* synthetic */ zzor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hc(zzor zzorVar, GoogleApiClient googleApiClient, DataType dataType) {
        super(googleApiClient);
        this.b = zzorVar;
        this.f1594a = dataType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListSubscriptionsResult zzb(Status status) {
        return ListSubscriptionsResult.a(status);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zznq zznqVar) throws RemoteException {
        ((zzob) zznqVar.zzpc()).zza(new ListSubscriptionsRequest(this.f1594a, new zzor.a(this, null)));
    }
}
