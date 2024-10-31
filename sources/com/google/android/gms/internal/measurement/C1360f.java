package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.f */
/* loaded from: classes2.dex */
final class C1360f extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ boolean f13446e;

    /* renamed from: f */
    private final /* synthetic */ zzea f13447f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1360f(zzea zzeaVar, boolean z) {
        super(zzeaVar);
        this.f13447f = zzeaVar;
        this.f13446e = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13447f.zzadr;
        zzdnVar.setMeasurementEnabled(this.f13446e, this.f13574a);
    }
}
