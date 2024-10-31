package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class Yl implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f11996a;

    /* renamed from: b */
    private final /* synthetic */ long f11997b;

    /* renamed from: c */
    private final /* synthetic */ long f11998c;

    /* renamed from: d */
    private final /* synthetic */ zzqv f11999d;

    public Yl(zzqv zzqvVar, String str, long j, long j2) {
        this.f11999d = zzqvVar;
        this.f11996a = str;
        this.f11997b = j;
        this.f11998c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqu zzquVar;
        zzquVar = this.f11999d.zzbko;
        zzquVar.zzd(this.f11996a, this.f11997b, this.f11998c);
    }
}
