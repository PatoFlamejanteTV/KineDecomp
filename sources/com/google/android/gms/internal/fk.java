package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzla;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fk extends zzla.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzla f1555a;
    final /* synthetic */ zzkx b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fk(zzkx zzkxVar, zzla zzlaVar) {
        this.b = zzkxVar;
        this.f1555a = zzlaVar;
    }

    @Override // com.google.android.gms.internal.zzla
    public void zzbg(int i) throws RemoteException {
        com.google.android.gms.cast.internal.zzl zzlVar;
        CastRemoteDisplay.CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks;
        CastRemoteDisplay.CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks2;
        zzlVar = zzkx.zzVo;
        zzlVar.b("onRemoteDisplayEnded", new Object[0]);
        if (this.f1555a != null) {
            this.f1555a.zzbg(i);
        }
        castRemoteDisplaySessionCallbacks = this.b.zzZT;
        if (castRemoteDisplaySessionCallbacks != null) {
            castRemoteDisplaySessionCallbacks2 = this.b.zzZT;
            castRemoteDisplaySessionCallbacks2.a(new Status(i));
        }
    }
}
