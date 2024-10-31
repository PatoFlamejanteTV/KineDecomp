package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzkz;

/* loaded from: classes.dex */
public class zzkx extends com.google.android.gms.common.internal.zzj<zzkz> implements IBinder.DeathRecipient {
    private static final com.google.android.gms.cast.internal.zzl zzVo = new com.google.android.gms.cast.internal.zzl("CastRemoteDisplayClientImpl");
    private CastDevice zzUY;
    private CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzZT;

    public zzkx(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, CastDevice castDevice, CastRemoteDisplay.CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 83, zzfVar, connectionCallbacks, onConnectionFailedListener);
        zzVo.b("instance created", new Object[0]);
        this.zzZT = castRemoteDisplaySessionCallbacks;
        this.zzUY = castDevice;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        zzVo.b("disconnect", new Object[0]);
        this.zzZT = null;
        this.zzUY = null;
        try {
            zzpc().disconnect();
            super.disconnect();
        } catch (RemoteException e) {
            super.disconnect();
        } catch (IllegalStateException e2) {
            super.disconnect();
        } catch (Throwable th) {
            super.disconnect();
            throw th;
        }
    }

    public void zza(zzky zzkyVar) throws RemoteException {
        zzVo.b("stopRemoteDisplay", new Object[0]);
        zzpc().zza(zzkyVar);
    }

    public void zza(zzky zzkyVar, int i) throws RemoteException {
        zzpc().zza(zzkyVar, i);
    }

    public void zza(zzky zzkyVar, zzla zzlaVar, String str) throws RemoteException {
        zzVo.b("startRemoteDisplay", new Object[0]);
        zzpc().zza(zzkyVar, new fk(this, zzlaVar), this.zzUY.b(), str);
    }

    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzaC, reason: merged with bridge method [inline-methods] */
    public zzkz zzW(IBinder iBinder) {
        return zzkz.zza.zzaE(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.cast.remote_display.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }
}
