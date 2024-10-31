package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzani extends zzew implements zzang {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzani(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzyp getVideoController() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        zzyp zzg = zzyq.zzg(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void showInterstitial() throws RemoteException {
        zza(7, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzwf zzwfVar, zzanj zzanjVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeString(str);
        zzey.zza(obtainAndWriteInterfaceToken, bundle);
        zzey.zza(obtainAndWriteInterfaceToken, bundle2);
        zzey.zza(obtainAndWriteInterfaceToken, zzwfVar);
        zzey.zza(obtainAndWriteInterfaceToken, zzanjVar);
        zza(1, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zza(10, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzans zzvi() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        zzans zzansVar = (zzans) zzey.zza(transactAndReadException, zzans.CREATOR);
        transactAndReadException.recycle();
        return zzansVar;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzans zzvj() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        zzans zzansVar = (zzans) zzey.zza(transactAndReadException, zzans.CREATOR);
        transactAndReadException.recycle();
        return zzansVar;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzvk() throws RemoteException {
        zza(9, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzamy zzamyVar, zzalm zzalmVar, zzwf zzwfVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzey.zza(obtainAndWriteInterfaceToken, bundle);
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzey.zza(obtainAndWriteInterfaceToken, zzamyVar);
        zzey.zza(obtainAndWriteInterfaceToken, zzalmVar);
        zzey.zza(obtainAndWriteInterfaceToken, zzwfVar);
        zza(4, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzana zzanaVar, zzalm zzalmVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzey.zza(obtainAndWriteInterfaceToken, bundle);
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzey.zza(obtainAndWriteInterfaceToken, zzanaVar);
        zzey.zza(obtainAndWriteInterfaceToken, zzalmVar);
        zza(6, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzane zzaneVar, zzalm zzalmVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzey.zza(obtainAndWriteInterfaceToken, bundle);
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzey.zza(obtainAndWriteInterfaceToken, zzaneVar);
        zzey.zza(obtainAndWriteInterfaceToken, zzalmVar);
        zza(8, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeStringArray(strArr);
        obtainAndWriteInterfaceToken.writeTypedArray(bundleArr, 0);
        zza(11, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzanc zzancVar, zzalm zzalmVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzey.zza(obtainAndWriteInterfaceToken, bundle);
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzey.zza(obtainAndWriteInterfaceToken, zzancVar);
        zzey.zza(obtainAndWriteInterfaceToken, zzalmVar);
        zza(12, obtainAndWriteInterfaceToken);
    }
}
