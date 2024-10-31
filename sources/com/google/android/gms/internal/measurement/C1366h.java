package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.h */
/* loaded from: classes2.dex */
public final class C1366h extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ String f13457e;

    /* renamed from: f */
    private final /* synthetic */ zzea f13458f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1366h(zzea zzeaVar, String str) {
        super(zzeaVar);
        this.f13458f = zzeaVar;
        this.f13457e = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13458f.zzadr;
        zzdnVar.endAdUnitExposure(this.f13457e, this.f13575b);
    }
}
