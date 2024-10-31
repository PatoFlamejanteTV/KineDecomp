package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.base.zac;

/* loaded from: classes.dex */
public final class zah extends com.google.android.gms.internal.base.zaa implements ISignInButtonCreator {
    public zah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    @Override // com.google.android.gms.common.internal.ISignInButtonCreator
    public final IObjectWrapper a(IObjectWrapper iObjectWrapper, SignInButtonConfig signInButtonConfig) throws RemoteException {
        Parcel zaa = zaa();
        zac.zaa(zaa, iObjectWrapper);
        zac.zaa(zaa, signInButtonConfig);
        Parcel zaa2 = zaa(2, zaa);
        IObjectWrapper a2 = IObjectWrapper.Stub.a(zaa2.readStrongBinder());
        zaa2.recycle();
        return a2;
    }
}
