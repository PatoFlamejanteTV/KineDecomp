package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.jl */
/* loaded from: classes2.dex */
public final class RunnableC0962jl implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzoz f12238a;

    /* renamed from: b */
    private final /* synthetic */ int f12239b;

    /* renamed from: c */
    private final /* synthetic */ int f12240c;

    /* renamed from: d */
    private final /* synthetic */ zzfs f12241d;

    /* renamed from: e */
    private final /* synthetic */ int f12242e;

    /* renamed from: f */
    private final /* synthetic */ Object f12243f;

    /* renamed from: g */
    private final /* synthetic */ long f12244g;

    /* renamed from: h */
    private final /* synthetic */ long f12245h;
    private final /* synthetic */ long i;
    private final /* synthetic */ zzkt j;

    public RunnableC0962jl(zzkt zzktVar, zzoz zzozVar, int i, int i2, zzfs zzfsVar, int i3, Object obj, long j, long j2, long j3) {
        this.j = zzktVar;
        this.f12238a = zzozVar;
        this.f12239b = i;
        this.f12240c = i2;
        this.f12241d = zzfsVar;
        this.f12242e = i3;
        this.f12243f = obj;
        this.f12244g = j;
        this.f12245h = j2;
        this.i = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzks zzksVar;
        long zzx;
        long zzx2;
        zzksVar = this.j.zzavv;
        zzoz zzozVar = this.f12238a;
        int i = this.f12239b;
        int i2 = this.f12240c;
        zzfs zzfsVar = this.f12241d;
        int i3 = this.f12242e;
        Object obj = this.f12243f;
        zzx = this.j.zzx(this.f12244g);
        zzx2 = this.j.zzx(this.f12245h);
        zzksVar.zza(zzozVar, i, i2, zzfsVar, i3, obj, zzx, zzx2, this.i);
    }
}
