package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public interface zzagb extends IInterface {
    void destroy() throws RemoteException;

    zzyp getVideoController() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzagd zzagdVar) throws RemoteException;
}
