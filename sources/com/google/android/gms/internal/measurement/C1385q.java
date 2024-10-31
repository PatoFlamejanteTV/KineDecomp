package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.q */
/* loaded from: classes2.dex */
public final class C1385q extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ Bundle f13511e;

    /* renamed from: f */
    private final /* synthetic */ zzea.a f13512f;

    /* renamed from: g */
    private final /* synthetic */ zzea f13513g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1385q(zzea zzeaVar, Bundle bundle, zzea.a aVar) {
        super(zzeaVar);
        this.f13513g = zzeaVar;
        this.f13511e = bundle;
        this.f13512f = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13513g.zzadr;
        zzdnVar.performAction(this.f13511e, this.f13512f, this.f13574a);
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    protected final void c() {
        this.f13512f.zzb(null);
    }
}
