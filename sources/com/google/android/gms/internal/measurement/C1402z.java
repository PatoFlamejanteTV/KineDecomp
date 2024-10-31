package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1402z extends zzea.b {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Activity f13567e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzea.e f13568f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1402z(zzea.e eVar, Activity activity) {
        super(zzea.this);
        this.f13568f = eVar;
        this.f13567e = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = zzea.this.zzadr;
        zzdnVar.onActivityResumed(ObjectWrapper.a(this.f13567e), this.f13575b);
    }
}
