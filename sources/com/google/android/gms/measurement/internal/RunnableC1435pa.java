package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.pa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1435pa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f13813a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ boolean f13814b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzag f13815c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzk f13816d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ String f13817e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzeb f13818f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1435pa(zzeb zzebVar, boolean z, boolean z2, zzag zzagVar, zzk zzkVar, String str) {
        this.f13818f = zzebVar;
        this.f13813a = z;
        this.f13814b = z2;
        this.f13815c = zzagVar;
        this.f13816d = zzkVar;
        this.f13817e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar;
        zzajVar = this.f13818f.f14019d;
        if (zzajVar == null) {
            this.f13818f.b().q().a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f13813a) {
            this.f13818f.a(zzajVar, this.f13814b ? null : this.f13815c, this.f13816d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f13817e)) {
                    zzajVar.a(this.f13815c, this.f13816d);
                } else {
                    zzajVar.a(this.f13815c, this.f13817e, this.f13818f.b().z());
                }
            } catch (RemoteException e2) {
                this.f13818f.b().q().a("Failed to send event to the service", e2);
            }
        }
        this.f13818f.E();
    }
}
