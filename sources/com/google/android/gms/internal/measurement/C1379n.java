package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.n */
/* loaded from: classes2.dex */
public final class C1379n extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ zzea.a f13492e;

    /* renamed from: f */
    private final /* synthetic */ zzea f13493f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1379n(zzea zzeaVar, zzea.a aVar) {
        super(zzeaVar);
        this.f13493f = zzeaVar;
        this.f13492e = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13493f.zzadr;
        zzdnVar.getCurrentScreenClass(this.f13492e);
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    protected final void c() {
        this.f13492e.zzb(null);
    }
}
