package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.g */
/* loaded from: classes2.dex */
public final class C1363g extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ String f13455e;

    /* renamed from: f */
    private final /* synthetic */ zzea f13456f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1363g(zzea zzeaVar, String str) {
        super(zzeaVar);
        this.f13456f = zzeaVar;
        this.f13455e = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13456f.zzadr;
        zzdnVar.beginAdUnitExposure(this.f13455e, this.f13575b);
    }
}
