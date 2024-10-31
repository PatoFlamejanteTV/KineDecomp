package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EventParcel f2049a;
    final /* synthetic */ AppMetadata b;
    final /* synthetic */ zzw c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(zzw zzwVar, EventParcel eventParcel, AppMetadata appMetadata) {
        this.c = zzwVar;
        this.f2049a = eventParcel;
        this.b = appMetadata;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzv zzvVar;
        zzvVar = this.c.f2074a;
        zzvVar.a(this.f2049a, this.b);
    }
}
