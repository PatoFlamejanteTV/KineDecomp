package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Tm implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbcl f11865a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzue f11866b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tm(zzue zzueVar, zzbcl zzbclVar) {
        this.f11866b = zzueVar;
        this.f11865a = zzbclVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Object obj;
        obj = this.f11866b.mLock;
        synchronized (obj) {
            this.f11865a.setException(new RuntimeException("Connection failed."));
        }
    }
}
