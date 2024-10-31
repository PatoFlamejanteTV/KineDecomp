package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;

/* loaded from: classes2.dex */
public final class zag extends com.google.android.gms.internal.base.zaa implements zaf {
    public zag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void a(int i) throws RemoteException {
        Parcel zaa = zaa();
        zaa.writeInt(i);
        zab(7, zaa);
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void a(IAccountAccessor iAccountAccessor, int i, boolean z) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zaa(zaa, iAccountAccessor);
        zaa.writeInt(i);
        com.google.android.gms.internal.base.zac.writeBoolean(zaa, z);
        zab(9, zaa);
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void a(zah zahVar, zad zadVar) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zaa(zaa, zahVar);
        com.google.android.gms.internal.base.zac.zaa(zaa, zadVar);
        zab(12, zaa);
    }
}
