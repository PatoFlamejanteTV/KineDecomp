package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.ra, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1438ra implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f13833a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f13834b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f13835c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f13836d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzk f13837e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzeb f13838f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1438ra(zzeb zzebVar, AtomicReference atomicReference, String str, String str2, String str3, zzk zzkVar) {
        this.f13838f = zzebVar;
        this.f13833a = atomicReference;
        this.f13834b = str;
        this.f13835c = str2;
        this.f13836d = str3;
        this.f13837e = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar;
        synchronized (this.f13833a) {
            try {
                try {
                    zzajVar = this.f13838f.f14019d;
                } catch (RemoteException e2) {
                    this.f13838f.b().q().a("Failed to get conditional properties", zzas.a(this.f13834b), this.f13835c, e2);
                    this.f13833a.set(Collections.emptyList());
                }
                if (zzajVar == null) {
                    this.f13838f.b().q().a("Failed to get conditional properties", zzas.a(this.f13834b), this.f13835c, this.f13836d);
                    this.f13833a.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.f13834b)) {
                    this.f13833a.set(zzajVar.a(this.f13835c, this.f13836d, this.f13837e));
                } else {
                    this.f13833a.set(zzajVar.a(this.f13834b, this.f13835c, this.f13836d));
                }
                this.f13838f.E();
                this.f13833a.notify();
            } finally {
                this.f13833a.notify();
            }
        }
    }
}
