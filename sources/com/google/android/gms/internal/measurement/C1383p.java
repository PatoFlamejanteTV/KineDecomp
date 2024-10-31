package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.measurement.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1383p extends zzea.b {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ int f13504e = 5;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f13505f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ Object f13506g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ Object f13507h;
    private final /* synthetic */ Object i;
    private final /* synthetic */ zzea j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1383p(zzea zzeaVar, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.j = zzeaVar;
        this.f13505f = str;
        this.f13506g = obj;
        this.f13507h = obj2;
        this.i = obj3;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.b
    final void b() throws RemoteException {
        zzdn zzdnVar;
        zzdnVar = this.j.zzadr;
        zzdnVar.logHealthData(this.f13504e, this.f13505f, ObjectWrapper.a(this.f13506g), ObjectWrapper.a(this.f13507h), ObjectWrapper.a(this.i));
    }
}
