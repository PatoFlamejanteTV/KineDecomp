package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f2045a;
    final /* synthetic */ s b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, boolean z) {
        this.b = sVar;
        this.f2045a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzv zzvVar;
        zzvVar = this.b.b;
        zzvVar.a(this.f2045a);
    }
}
