package com.google.android.gms.internal.config;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* loaded from: classes2.dex */
public interface zzaf extends IInterface {
    void zza(Status status) throws RemoteException;

    void zza(Status status, zzad zzadVar) throws RemoteException;

    void zza(Status status, Map map) throws RemoteException;

    void zza(Status status, byte[] bArr) throws RemoteException;
}
