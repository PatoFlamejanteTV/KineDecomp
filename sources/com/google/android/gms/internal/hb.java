package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.zznq;
import com.google.android.gms.internal.zzor;

/* loaded from: classes.dex */
class hb extends zznq.a<ListSubscriptionsResult> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzor f1593a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hb(zzor zzorVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f1593a = zzorVar;
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
        ((zzob) zznqVar.zzpc()).zza(new ListSubscriptionsRequest(null, new zzor.a(this, null)));
    }
}
