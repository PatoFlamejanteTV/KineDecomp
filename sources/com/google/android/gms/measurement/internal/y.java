package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UserAttributeParcel f2050a;
    final /* synthetic */ AppMetadata b;
    final /* synthetic */ zzw c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(zzw zzwVar, UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        this.c = zzwVar;
        this.f2050a = userAttributeParcel;
        this.b = appMetadata;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzv zzvVar;
        zzvVar = this.c.f2074a;
        zzvVar.b(this.f2050a, this.b);
    }
}
