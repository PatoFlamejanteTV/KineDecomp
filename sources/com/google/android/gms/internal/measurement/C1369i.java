package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;
import com.google.android.gms.measurement.internal.zzcx;

/* renamed from: com.google.android.gms.internal.measurement.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1369i extends zzea.b {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzcx f13462e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzea f13463f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1369i(zzea zzeaVar, zzcx zzcxVar) {
        super(zzeaVar);
        this.f13463f = zzeaVar;
        this.f13462e = zzcxVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13463f.zzadr;
        zzdnVar.setEventInterceptor(new zzea.c(this.f13462e));
    }
}
