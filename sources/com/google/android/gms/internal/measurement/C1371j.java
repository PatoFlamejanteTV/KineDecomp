package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.j */
/* loaded from: classes2.dex */
public final class C1371j extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ zzea.a f13467e;

    /* renamed from: f */
    private final /* synthetic */ zzea f13468f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1371j(zzea zzeaVar, zzea.a aVar) {
        super(zzeaVar);
        this.f13468f = zzeaVar;
        this.f13467e = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13468f.zzadr;
        zzdnVar.getGmpAppId(this.f13467e);
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    protected final void c() {
        this.f13467e.zzb(null);
    }
}
