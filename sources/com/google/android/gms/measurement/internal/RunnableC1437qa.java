package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.qa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1437qa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f13825a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ boolean f13826b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzo f13827c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzk f13828d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzo f13829e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzeb f13830f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1437qa(zzeb zzebVar, boolean z, boolean z2, zzo zzoVar, zzk zzkVar, zzo zzoVar2) {
        this.f13830f = zzebVar;
        this.f13825a = z;
        this.f13826b = z2;
        this.f13827c = zzoVar;
        this.f13828d = zzkVar;
        this.f13829e = zzoVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar;
        zzajVar = this.f13830f.f14019d;
        if (zzajVar == null) {
            this.f13830f.b().q().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f13825a) {
            this.f13830f.a(zzajVar, this.f13826b ? null : this.f13827c, this.f13828d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f13829e.f14073a)) {
                    zzajVar.a(this.f13827c, this.f13828d);
                } else {
                    zzajVar.a(this.f13827c);
                }
            } catch (RemoteException e2) {
                this.f13830f.b().q().a("Failed to send conditional user property to the service", e2);
            }
        }
        this.f13830f.E();
    }
}
