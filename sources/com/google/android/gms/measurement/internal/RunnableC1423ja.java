package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.ja, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1423ja implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f13783a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzk f13784b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ boolean f13785c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzeb f13786d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1423ja(zzeb zzebVar, AtomicReference atomicReference, zzk zzkVar, boolean z) {
        this.f13786d = zzebVar;
        this.f13783a = atomicReference;
        this.f13784b = zzkVar;
        this.f13785c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar;
        synchronized (this.f13783a) {
            try {
                try {
                    zzajVar = this.f13786d.f14019d;
                } catch (RemoteException e2) {
                    this.f13786d.b().q().a("Failed to get user properties", e2);
                }
                if (zzajVar == null) {
                    this.f13786d.b().q().a("Failed to get user properties");
                    return;
                }
                this.f13783a.set(zzajVar.a(this.f13784b, this.f13785c));
                this.f13786d.E();
                this.f13783a.notify();
            } finally {
                this.f13783a.notify();
            }
        }
    }
}
