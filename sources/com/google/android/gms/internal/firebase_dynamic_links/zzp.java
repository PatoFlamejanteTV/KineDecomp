package com.google.android.gms.internal.firebase_dynamic_links;

import android.content.Intent;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public interface zzp extends IInterface {
    void zza(Status status) throws RemoteException;

    void zza(Status status, Intent intent) throws RemoteException;
}
