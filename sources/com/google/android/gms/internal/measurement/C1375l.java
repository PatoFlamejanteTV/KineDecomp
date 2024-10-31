package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.l */
/* loaded from: classes2.dex */
public final class C1375l extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ zzea.a f13473e;

    /* renamed from: f */
    private final /* synthetic */ zzea f13474f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1375l(zzea zzeaVar, zzea.a aVar) {
        super(zzeaVar);
        this.f13474f = zzeaVar;
        this.f13473e = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13474f.zzadr;
        zzdnVar.generateEventId(this.f13473e);
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    protected final void c() {
        this.f13473e.zzb(null);
    }
}
