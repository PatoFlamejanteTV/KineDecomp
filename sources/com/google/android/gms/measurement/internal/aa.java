package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppMetadata f2023a;
    final /* synthetic */ zzw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(zzw zzwVar, AppMetadata appMetadata) {
        this.b = zzwVar;
        this.f2023a = appMetadata;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzv zzvVar;
        zzvVar = this.b.f2074a;
        zzvVar.a(this.f2023a);
    }
}
