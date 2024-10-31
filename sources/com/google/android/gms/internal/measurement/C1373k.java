package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.k */
/* loaded from: classes2.dex */
public final class C1373k extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ zzea.a f13471e;

    /* renamed from: f */
    private final /* synthetic */ zzea f13472f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1373k(zzea zzeaVar, zzea.a aVar) {
        super(zzeaVar);
        this.f13472f = zzeaVar;
        this.f13471e = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13472f.zzadr;
        zzdnVar.getCachedAppInstanceId(this.f13471e);
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    protected final void c() {
        this.f13471e.zzb(null);
    }
}
