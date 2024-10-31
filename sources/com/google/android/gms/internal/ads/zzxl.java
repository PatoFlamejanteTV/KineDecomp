package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public interface zzxl extends IInterface {
    void destroy() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getAdUnitId() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzyp getVideoController() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(zzabg zzabgVar) throws RemoteException;

    void zza(zzaow zzaowVar) throws RemoteException;

    void zza(zzapc zzapcVar, String str) throws RemoteException;

    void zza(zzavb zzavbVar) throws RemoteException;

    void zza(zzwf zzwfVar) throws RemoteException;

    void zza(zzwx zzwxVar) throws RemoteException;

    void zza(zzxa zzxaVar) throws RemoteException;

    void zza(zzxq zzxqVar) throws RemoteException;

    void zza(zzxt zzxtVar) throws RemoteException;

    void zza(zzxz zzxzVar) throws RemoteException;

    void zza(zzyv zzyvVar) throws RemoteException;

    void zza(zzzw zzzwVar) throws RemoteException;

    void zzap(String str) throws RemoteException;

    boolean zzb(zzwb zzwbVar) throws RemoteException;

    IObjectWrapper zzie() throws RemoteException;

    zzwf zzif() throws RemoteException;

    void zzih() throws RemoteException;

    zzxt zzir() throws RemoteException;

    zzxa zzis() throws RemoteException;

    String zzje() throws RemoteException;
}
