package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f13720a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f13721b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f13722c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f13723d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzda f13724e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Z(zzda zzdaVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f13724e = zzdaVar;
        this.f13720a = atomicReference;
        this.f13721b = str;
        this.f13722c = str2;
        this.f13723d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13724e.f13672a.j().a(this.f13720a, this.f13721b, this.f13722c, this.f13723d);
    }
}
