package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes2.dex */
public interface zzalj extends IInterface {
    void destroy() throws RemoteException;

    Bundle getInterstitialAdapterInfo() throws RemoteException;

    zzyp getVideoController() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzavz zzavzVar, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzwb zzwbVar, String str, zzalm zzalmVar) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzwb zzwbVar, String str, zzavz zzavzVar, String str2) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzwb zzwbVar, String str, String str2, zzalm zzalmVar) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzwb zzwbVar, String str, String str2, zzalm zzalmVar, zzacp zzacpVar, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzwf zzwfVar, zzwb zzwbVar, String str, zzalm zzalmVar) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzwf zzwfVar, zzwb zzwbVar, String str, String str2, zzalm zzalmVar) throws RemoteException;

    void zza(zzwb zzwbVar, String str, String str2) throws RemoteException;

    void zzc(zzwb zzwbVar, String str) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzut() throws RemoteException;

    zzals zzuu() throws RemoteException;

    zzalv zzuv() throws RemoteException;

    Bundle zzuw() throws RemoteException;

    Bundle zzux() throws RemoteException;

    boolean zzuy() throws RemoteException;

    zzadx zzuz() throws RemoteException;

    zzaly zzva() throws RemoteException;
}
