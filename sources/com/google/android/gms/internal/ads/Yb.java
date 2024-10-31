package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Yb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbcl f11973a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f11974b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzapw f11975c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Yb(zzapw zzapwVar, zzbcl zzbclVar, String str) {
        this.f11975c = zzapwVar;
        this.f11973a = zzbclVar;
        this.f11974b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzbb zzbbVar;
        zzbcl zzbclVar = this.f11973a;
        zzbbVar = this.f11975c.zzdtf;
        zzbclVar.set(zzbbVar.G().get(this.f11974b));
    }
}
