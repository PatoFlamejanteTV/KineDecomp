package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class W implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f13708a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ boolean f13709b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzda f13710c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public W(zzda zzdaVar, AtomicReference atomicReference, boolean z) {
        this.f13710c = zzdaVar;
        this.f13708a = atomicReference;
        this.f13709b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13710c.o().a(this.f13708a, this.f13709b);
    }
}
