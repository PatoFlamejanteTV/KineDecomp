package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.c */
/* loaded from: classes2.dex */
public final class C1351c extends zzea.b {

    /* renamed from: e */
    private final /* synthetic */ String f13424e;

    /* renamed from: f */
    private final /* synthetic */ String f13425f;

    /* renamed from: g */
    private final /* synthetic */ Bundle f13426g;

    /* renamed from: h */
    private final /* synthetic */ zzea f13427h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1351c(zzea zzeaVar, String str, String str2, Bundle bundle) {
        super(zzeaVar);
        this.f13427h = zzeaVar;
        this.f13424e = str;
        this.f13425f = str2;
        this.f13426g = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13427h.zzadr;
        zzdnVar.clearConditionalUserProperty(this.f13424e, this.f13425f, this.f13426g);
    }
}
