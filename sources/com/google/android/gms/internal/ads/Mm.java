package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Mm implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zztq f11698a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mm(zztq zztqVar) {
        this.f11698a = zztqVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Object obj;
        Object obj2;
        zztx zztxVar;
        zztx zztxVar2;
        obj = this.f11698a.mLock;
        synchronized (obj) {
            try {
                zztxVar = this.f11698a.zzbzr;
                if (zztxVar != null) {
                    zztq zztqVar = this.f11698a;
                    zztxVar2 = this.f11698a.zzbzr;
                    zztqVar.zzbzs = zztxVar2.zzoh();
                }
            } catch (DeadObjectException e2) {
                zzbbd.zzb("Unable to obtain a cache service instance.", e2);
                this.f11698a.disconnect();
            }
            obj2 = this.f11698a.mLock;
            obj2.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Object obj;
        Object obj2;
        obj = this.f11698a.mLock;
        synchronized (obj) {
            this.f11698a.zzbzs = null;
            obj2 = this.f11698a.mLock;
            obj2.notifyAll();
        }
    }
}
