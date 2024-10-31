package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.internal.zzno;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gz extends zzno.a<DailyTotalResult> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DataType f1590a;
    final /* synthetic */ zzop b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gz(zzop zzopVar, GoogleApiClient googleApiClient, DataType dataType) {
        super(googleApiClient);
        this.b = zzopVar;
        this.f1590a = dataType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DailyTotalResult zzb(Status status) {
        return DailyTotalResult.a(status, this.f1590a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzno zznoVar) throws RemoteException {
        ((zznz) zznoVar.zzpc()).zza(new DailyTotalRequest(new ha(this), this.f1590a));
    }
}
