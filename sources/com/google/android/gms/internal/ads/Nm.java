package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Nm implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zztq f11724a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Nm(zztq zztqVar) {
        this.f11724a = zztqVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Object obj;
        zztx zztxVar;
        Object obj2;
        obj = this.f11724a.mLock;
        synchronized (obj) {
            this.f11724a.zzbzs = null;
            zztxVar = this.f11724a.zzbzr;
            if (zztxVar != null) {
                zztq.zza(this.f11724a, (zztx) null);
            }
            obj2 = this.f11724a.mLock;
            obj2.notifyAll();
        }
    }
}
