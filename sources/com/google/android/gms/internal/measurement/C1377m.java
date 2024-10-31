package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.m */
/* loaded from: classes2.dex */
public final class C1377m extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ zzea.a f13483e;

    /* renamed from: f */
    private final /* synthetic */ zzea f13484f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1377m(zzea zzeaVar, zzea.a aVar) {
        super(zzeaVar);
        this.f13484f = zzeaVar;
        this.f13483e = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13484f.zzadr;
        zzdnVar.getCurrentScreenName(this.f13483e);
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    protected final void c() {
        this.f13483e.zzb(null);
    }
}
