package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzjy;

/* loaded from: classes.dex */
public class zzjw extends com.google.android.gms.common.internal.zzj<zzjy> {
    private final String zzRq;

    public zzjw(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, 77, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzRq = zzfVar.h();
    }

    private Bundle zzlz() {
        Bundle bundle = new Bundle();
        bundle.putString("authPackage", this.zzRq);
        return bundle;
    }

    public void zza(zzjx zzjxVar, String str) {
        try {
            zzpc().zza(zzjxVar, str);
        } catch (RemoteException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzaj, reason: merged with bridge method [inline-methods] */
    public zzjy zzW(IBinder iBinder) {
        return zzjy.zza.zzal(iBinder);
    }

    public void zzb(zzjx zzjxVar, String str) {
        try {
            zzpc().zzb(zzjxVar, str);
        } catch (RemoteException e) {
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.appinvite.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.appinvite.internal.IAppInviteService";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzly() {
        return zzlz();
    }
}
