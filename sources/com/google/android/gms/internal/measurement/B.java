package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;

/* loaded from: classes2.dex */
final class B extends zzea.b {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Activity f13352e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzea.e f13353f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(zzea.e eVar, Activity activity) {
        super(zzea.this);
        this.f13353f = eVar;
        this.f13352e = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = zzea.this.zzadr;
        zzdnVar.onActivityStopped(ObjectWrapper.a(this.f13352e), this.f13575b);
    }
}
