package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;

/* renamed from: com.google.android.gms.internal.measurement.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1398x extends zzea.b {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Activity f13548e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Bundle f13549f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzea.e f13550g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1398x(zzea.e eVar, Activity activity, Bundle bundle) {
        super(zzea.this);
        this.f13550g = eVar;
        this.f13548e = activity;
        this.f13549f = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = zzea.this.zzadr;
        zzdnVar.onActivityCreated(ObjectWrapper.a(this.f13548e), this.f13549f, this.f13575b);
    }
}
