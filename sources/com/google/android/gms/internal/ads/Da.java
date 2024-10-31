package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Da implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f11453a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzaik f11454b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Da(zzaik zzaikVar, String str) {
        this.f11454b = zzaikVar;
        this.f11453a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbgg zzbggVar;
        zzbggVar = this.f11454b.zzdin;
        zzbggVar.loadData(this.f11453a, "text/html", "UTF-8");
    }
}
