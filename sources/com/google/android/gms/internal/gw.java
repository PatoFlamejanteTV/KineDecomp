package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.internal.zzno;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gw extends zzno.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DataSet f1587a;
    final /* synthetic */ boolean b;
    final /* synthetic */ zzop c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gw(zzop zzopVar, GoogleApiClient googleApiClient, DataSet dataSet, boolean z) {
        super(googleApiClient);
        this.c = zzopVar;
        this.f1587a = dataSet;
        this.b = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzno zznoVar) throws RemoteException {
        ((zznz) zznoVar.zzpc()).zza(new DataInsertRequest(this.f1587a, new zzou(this), this.b));
    }
}
