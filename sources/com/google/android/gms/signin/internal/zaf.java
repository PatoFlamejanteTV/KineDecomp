package com.google.android.gms.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;

/* loaded from: classes2.dex */
public interface zaf extends IInterface {
    void a(int i) throws RemoteException;

    void a(IAccountAccessor iAccountAccessor, int i, boolean z) throws RemoteException;

    void a(zah zahVar, zad zadVar) throws RemoteException;
}
