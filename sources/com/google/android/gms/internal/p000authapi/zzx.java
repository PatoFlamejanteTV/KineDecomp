package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

/* loaded from: classes2.dex */
public final class zzx extends zzc implements zzw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    @Override // com.google.android.gms.internal.p000authapi.zzw
    public final void zzc(zzu zzuVar, CredentialRequest credentialRequest) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zze.zzc(obtainAndWriteInterfaceToken, zzuVar);
        zze.zzc(obtainAndWriteInterfaceToken, credentialRequest);
        transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.p000authapi.zzw
    public final void zzc(zzu zzuVar, zzy zzyVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zze.zzc(obtainAndWriteInterfaceToken, zzuVar);
        zze.zzc(obtainAndWriteInterfaceToken, zzyVar);
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.p000authapi.zzw
    public final void zzc(zzu zzuVar, zzs zzsVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zze.zzc(obtainAndWriteInterfaceToken, zzuVar);
        zze.zzc(obtainAndWriteInterfaceToken, zzsVar);
        transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.p000authapi.zzw
    public final void zzc(zzu zzuVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zze.zzc(obtainAndWriteInterfaceToken, zzuVar);
        transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken);
    }
}
