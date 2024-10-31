package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;

/* loaded from: classes2.dex */
final class C extends zzea.b {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Activity f13354e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzea.a f13355f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzea.e f13356g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(zzea.e eVar, Activity activity, zzea.a aVar) {
        super(zzea.this);
        this.f13356g = eVar;
        this.f13354e = activity;
        this.f13355f = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = zzea.this.zzadr;
        zzdnVar.onActivitySaveInstanceState(ObjectWrapper.a(this.f13354e), this.f13355f, this.f13575b);
    }
}
