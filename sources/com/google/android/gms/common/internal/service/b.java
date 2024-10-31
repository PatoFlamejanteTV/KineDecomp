package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class b extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zad zadVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zai zaiVar) throws RemoteException {
        ((zal) zaiVar.getService()).a(new c(this));
    }
}
