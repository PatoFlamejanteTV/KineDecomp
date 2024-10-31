package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UserAttributeParcel f2051a;
    final /* synthetic */ AppMetadata b;
    final /* synthetic */ zzw c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(zzw zzwVar, UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        this.c = zzwVar;
        this.f2051a = userAttributeParcel;
        this.b = appMetadata;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzv zzvVar;
        zzvVar = this.c.f2074a;
        zzvVar.a(this.f2051a, this.b);
    }
}
