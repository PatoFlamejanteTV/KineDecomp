package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.w */
/* loaded from: classes2.dex */
public final class C1396w extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ Bundle f13542e;

    /* renamed from: f */
    private final /* synthetic */ zzea f13543f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1396w(zzea zzeaVar, Bundle bundle) {
        super(zzeaVar);
        this.f13543f = zzeaVar;
        this.f13542e = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13543f.zzadr;
        zzdnVar.setConditionalUserProperty(this.f13542e, this.f13574a);
    }
}
