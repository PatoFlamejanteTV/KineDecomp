package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class F implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbcl f11520a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzaft f11521b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(zzaft zzaftVar, zzbcl zzbclVar) {
        this.f11521b = zzaftVar;
        this.f11520a = zzbclVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzafk zzafkVar;
        try {
            zzbcl zzbclVar = this.f11520a;
            zzafkVar = this.f11521b.zzdgm;
            zzbclVar.set(zzafkVar.zzte());
        } catch (DeadObjectException e2) {
            this.f11520a.setException(e2);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        zzbcl zzbclVar = this.f11520a;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzbclVar.setException(new RuntimeException(sb.toString()));
    }
}
