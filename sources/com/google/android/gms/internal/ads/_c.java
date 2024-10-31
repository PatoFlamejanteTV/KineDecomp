package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class _c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzwb f12031a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzalj f12032b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzavk f12033c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _c(zzavk zzavkVar, zzwb zzwbVar, zzalj zzaljVar) {
        this.f12033c = zzavkVar;
        this.f12031a = zzwbVar;
        this.f12032b = zzaljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12033c.zza(this.f12031a, this.f12032b);
    }
}
