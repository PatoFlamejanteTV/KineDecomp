package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1173z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzach f12692a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzact f12693b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1173z(zzact zzactVar, zzach zzachVar) {
        this.f12693b = zzactVar;
        this.f12692a = zzachVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12693b.zza(this.f12692a);
    }
}
