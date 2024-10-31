package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface zzxd extends IInterface {
    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoading() throws RemoteException;

    void zza(zzwb zzwbVar, int i) throws RemoteException;

    void zzd(zzwb zzwbVar) throws RemoteException;

    String zzje() throws RemoteException;
}
