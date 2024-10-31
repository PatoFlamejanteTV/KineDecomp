package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.ka, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1425ka implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f13790a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzk f13791b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzeb f13792c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1425ka(zzeb zzebVar, AtomicReference atomicReference, zzk zzkVar) {
        this.f13792c = zzebVar;
        this.f13790a = atomicReference;
        this.f13791b = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar;
        synchronized (this.f13790a) {
            try {
                try {
                    zzajVar = this.f13792c.f14019d;
                } catch (RemoteException e2) {
                    this.f13792c.b().q().a("Failed to get app instance id", e2);
                }
                if (zzajVar == null) {
                    this.f13792c.b().q().a("Failed to get app instance id");
                    return;
                }
                this.f13790a.set(zzajVar.d(this.f13791b));
                String str = (String) this.f13790a.get();
                if (str != null) {
                    this.f13792c.m().a(str);
                    this.f13792c.i().m.a(str);
                }
                this.f13792c.E();
                this.f13790a.notify();
            } finally {
                this.f13790a.notify();
            }
        }
    }
}
