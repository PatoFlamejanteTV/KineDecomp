package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* loaded from: classes2.dex */
public final class r extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ String f13515e;

    /* renamed from: f */
    private final /* synthetic */ zzea.a f13516f;

    /* renamed from: g */
    private final /* synthetic */ zzea f13517g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(zzea zzeaVar, String str, zzea.a aVar) {
        super(zzeaVar);
        this.f13517g = zzeaVar;
        this.f13515e = str;
        this.f13516f = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13517g.zzadr;
        zzdnVar.getMaxUserProperties(this.f13515e, this.f13516f);
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    protected final void c() {
        this.f13516f.zzb(null);
    }
}
