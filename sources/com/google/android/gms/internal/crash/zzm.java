package com.google.android.gms.internal.crash;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes2.dex */
public interface zzm extends IInterface {
    void log(String str) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzk zzkVar) throws RemoteException;

    void zza(String str, long j, Bundle bundle) throws RemoteException;

    void zza(List<String> list) throws RemoteException;

    void zza(boolean z) throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzb(String str) throws RemoteException;

    void zzb(boolean z) throws RemoteException;

    boolean zzd() throws RemoteException;
}
