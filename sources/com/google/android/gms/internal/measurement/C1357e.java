package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.measurement.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1357e extends zzea.b {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Activity f13438e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f13439f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f13440g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzea f13441h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1357e(zzea zzeaVar, Activity activity, String str, String str2) {
        super(zzeaVar);
        this.f13441h = zzeaVar;
        this.f13438e = activity;
        this.f13439f = str;
        this.f13440g = str2;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.f13441h.zzadr;
        zzdnVar.setCurrentScreen(ObjectWrapper.a(this.f13438e), this.f13439f, this.f13440g, this.f13574a);
    }
}
