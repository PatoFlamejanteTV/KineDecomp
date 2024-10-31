package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.measurement.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1394v extends zzea.b {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ String f13533e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f13534f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ Object f13535g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ boolean f13536h = true;
    private final /* synthetic */ zzea i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1394v(zzea zzeaVar, String str, String str2, Object obj, boolean z) {
        super(zzeaVar);
        this.i = zzeaVar;
        this.f13533e = str;
        this.f13534f = str2;
        this.f13535g = obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.i.zzadr;
        zzdnVar.setUserProperty(this.f13533e, this.f13534f, ObjectWrapper.a(this.f13535g), this.f13536h, this.f13574a);
    }
}
