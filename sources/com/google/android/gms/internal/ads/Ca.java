package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Ca implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f11433a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzaik f11434b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ca(zzaik zzaikVar, String str) {
        this.f11434b = zzaikVar;
        this.f11433a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbgg zzbggVar;
        zzbggVar = this.f11434b.zzdin;
        zzbggVar.loadData(this.f11433a, "text/html", "UTF-8");
    }
}
