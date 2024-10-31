package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Ea implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f11480a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzaik f11481b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ea(zzaik zzaikVar, String str) {
        this.f11481b = zzaikVar;
        this.f11480a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbgg zzbggVar;
        zzbggVar = this.f11481b.zzdin;
        zzbggVar.loadUrl(this.f11480a);
    }
}
