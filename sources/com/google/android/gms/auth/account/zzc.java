package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface zzc extends IInterface {
    void a(zza zzaVar, Account account) throws RemoteException;

    void a(zza zzaVar, String str) throws RemoteException;

    void zzb(boolean z) throws RemoteException;
}
