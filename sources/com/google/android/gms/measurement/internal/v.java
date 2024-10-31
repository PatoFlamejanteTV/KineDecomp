package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class V implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f13702a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f13703b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Object f13704c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ long f13705d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzda f13706e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V(zzda zzdaVar, String str, String str2, Object obj, long j) {
        this.f13706e = zzdaVar;
        this.f13702a = str;
        this.f13703b = str2;
        this.f13704c = obj;
        this.f13705d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13706e.a(this.f13702a, this.f13703b, this.f13704c, this.f13705d);
    }
}
