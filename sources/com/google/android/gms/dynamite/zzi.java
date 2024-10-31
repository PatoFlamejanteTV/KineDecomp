package com.google.android.gms.dynamite;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public interface zzi extends IInterface {
    int a(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException;

    IObjectWrapper a(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException;

    int b(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException;

    IObjectWrapper b(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException;

    int l() throws RemoteException;
}
