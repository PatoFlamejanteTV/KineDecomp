package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* loaded from: classes.dex */
final class c extends zaa {

    /* renamed from: a */
    private final BaseImplementation.ResultHolder<Status> f11170a;

    public c(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.f11170a = resultHolder;
    }

    @Override // com.google.android.gms.common.internal.service.zaa, com.google.android.gms.common.internal.service.zaj
    public final void b(int i) throws RemoteException {
        this.f11170a.a(new Status(i));
    }
}
