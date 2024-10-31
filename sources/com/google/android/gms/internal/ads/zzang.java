package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public interface zzang extends IInterface {
    zzyp getVideoController() throws RemoteException;

    void showInterstitial() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzwf zzwfVar, zzanj zzanjVar) throws RemoteException;

    void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzamy zzamyVar, zzalm zzalmVar, zzwf zzwfVar) throws RemoteException;

    void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzana zzanaVar, zzalm zzalmVar) throws RemoteException;

    void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzanc zzancVar, zzalm zzalmVar) throws RemoteException;

    void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzane zzaneVar, zzalm zzalmVar) throws RemoteException;

    void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException;

    void zzn(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzans zzvi() throws RemoteException;

    zzans zzvj() throws RemoteException;

    void zzvk() throws RemoteException;
}
