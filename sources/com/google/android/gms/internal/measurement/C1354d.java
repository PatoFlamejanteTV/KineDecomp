package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.d */
/* loaded from: classes2.dex */
public final class C1354d extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ String f13431e;

    /* renamed from: f */
    private final /* synthetic */ String f13432f;

    /* renamed from: g */
    private final /* synthetic */ zzea.a f13433g;

    /* renamed from: h */
    private final /* synthetic */ zzea f13434h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1354d(zzea zzeaVar, String str, String str2, zzea.a aVar) {
        super(zzeaVar);
        this.f13434h = zzeaVar;
        this.f13431e = str;
        this.f13432f = str2;
        this.f13433g = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13434h.zzadr;
        zzdnVar.getConditionalUserProperties(this.f13431e, this.f13432f, this.f13433g);
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    protected final void c() {
        this.f13433g.zzb(null);
    }
}
