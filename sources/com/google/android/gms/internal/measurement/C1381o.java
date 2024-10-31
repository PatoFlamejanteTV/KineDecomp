package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.o */
/* loaded from: classes2.dex */
public final class C1381o extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ String f13498e;

    /* renamed from: f */
    private final /* synthetic */ String f13499f;

    /* renamed from: g */
    private final /* synthetic */ boolean f13500g;

    /* renamed from: h */
    private final /* synthetic */ zzea.a f13501h;
    private final /* synthetic */ zzea i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1381o(zzea zzeaVar, String str, String str2, boolean z, zzea.a aVar) {
        super(zzeaVar);
        this.i = zzeaVar;
        this.f13498e = str;
        this.f13499f = str2;
        this.f13500g = z;
        this.f13501h = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.i.zzadr;
        zzdnVar.getUserProperties(this.f13498e, this.f13499f, this.f13500g, this.f13501h);
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    protected final void c() {
        this.f13501h.zzb(null);
    }
}
