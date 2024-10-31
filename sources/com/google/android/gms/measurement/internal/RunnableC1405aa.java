package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.aa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1405aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f13738a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f13739b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f13740c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f13741d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ boolean f13742e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzda f13743f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1405aa(zzda zzdaVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f13743f = zzdaVar;
        this.f13738a = atomicReference;
        this.f13739b = str;
        this.f13740c = str2;
        this.f13741d = str3;
        this.f13742e = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13743f.f13672a.j().a(this.f13738a, this.f13739b, this.f13740c, this.f13741d, this.f13742e);
    }
}
