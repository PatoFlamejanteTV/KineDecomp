package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ll */
/* loaded from: classes2.dex */
public final class RunnableC0990ll implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzoz f12304a;

    /* renamed from: b */
    private final /* synthetic */ int f12305b;

    /* renamed from: c */
    private final /* synthetic */ int f12306c;

    /* renamed from: d */
    private final /* synthetic */ zzfs f12307d;

    /* renamed from: e */
    private final /* synthetic */ int f12308e;

    /* renamed from: f */
    private final /* synthetic */ Object f12309f;

    /* renamed from: g */
    private final /* synthetic */ long f12310g;

    /* renamed from: h */
    private final /* synthetic */ long f12311h;
    private final /* synthetic */ long i;
    private final /* synthetic */ long j;
    private final /* synthetic */ long k;
    private final /* synthetic */ zzkt l;

    public RunnableC0990ll(zzkt zzktVar, zzoz zzozVar, int i, int i2, zzfs zzfsVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        this.l = zzktVar;
        this.f12304a = zzozVar;
        this.f12305b = i;
        this.f12306c = i2;
        this.f12307d = zzfsVar;
        this.f12308e = i3;
        this.f12309f = obj;
        this.f12310g = j;
        this.f12311h = j2;
        this.i = j3;
        this.j = j4;
        this.k = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzks zzksVar;
        long zzx;
        long zzx2;
        zzksVar = this.l.zzavv;
        zzoz zzozVar = this.f12304a;
        int i = this.f12305b;
        int i2 = this.f12306c;
        zzfs zzfsVar = this.f12307d;
        int i3 = this.f12308e;
        Object obj = this.f12309f;
        zzx = this.l.zzx(this.f12310g);
        zzx2 = this.l.zzx(this.f12311h);
        zzksVar.zzb(zzozVar, i, i2, zzfsVar, i3, obj, zzx, zzx2, this.i, this.j, this.k);
    }
}
