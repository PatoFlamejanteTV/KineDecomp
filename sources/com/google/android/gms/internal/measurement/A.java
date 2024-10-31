package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;

/* loaded from: classes2.dex */
final class A extends zzea.b {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Activity f13347e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzea.e f13348f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(zzea.e eVar, Activity activity) {
        super(zzea.this);
        this.f13348f = eVar;
        this.f13347e = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = zzea.this.zzadr;
        zzdnVar.onActivityPaused(ObjectWrapper.a(this.f13347e), this.f13575b);
    }
}
