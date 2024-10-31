package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.eb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0883eb implements zzbco {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbcl f12135a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzaji f12136b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0883eb(zzakg zzakgVar, zzbcl zzbclVar, zzaji zzajiVar) {
        this.f12135a = zzbclVar;
        this.f12136b = zzajiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void run() {
        this.f12135a.setException(new zzaju("Unable to obtain a JavascriptEngine."));
        this.f12136b.release();
    }
}
