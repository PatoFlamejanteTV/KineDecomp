package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.u */
/* loaded from: classes2.dex */
public final class C1392u extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ Long f13525e;

    /* renamed from: f */
    private final /* synthetic */ String f13526f;

    /* renamed from: g */
    private final /* synthetic */ String f13527g;

    /* renamed from: h */
    private final /* synthetic */ Bundle f13528h;
    private final /* synthetic */ boolean i = true;
    private final /* synthetic */ boolean j;
    private final /* synthetic */ zzea k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1392u(zzea zzeaVar, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzeaVar);
        this.k = zzeaVar;
        this.f13525e = l;
        this.f13526f = str;
        this.f13527g = str2;
        this.f13528h = bundle;
        this.j = z2;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        Long l = this.f13525e;
        long longValue = l == null ? this.f13574a : l.longValue();
        zzdnVar = this.k.zzadr;
        zzdnVar.logEvent(this.f13526f, this.f13527g, this.f13528h, this.i, this.j, longValue);
    }
}
