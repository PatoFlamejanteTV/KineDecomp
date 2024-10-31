package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.kl */
/* loaded from: classes2.dex */
public final class RunnableC0976kl implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzoz f12279a;

    /* renamed from: b */
    private final /* synthetic */ int f12280b;

    /* renamed from: c */
    private final /* synthetic */ int f12281c;

    /* renamed from: d */
    private final /* synthetic */ zzfs f12282d;

    /* renamed from: e */
    private final /* synthetic */ int f12283e;

    /* renamed from: f */
    private final /* synthetic */ Object f12284f;

    /* renamed from: g */
    private final /* synthetic */ long f12285g;

    /* renamed from: h */
    private final /* synthetic */ long f12286h;
    private final /* synthetic */ long i;
    private final /* synthetic */ long j;
    private final /* synthetic */ long k;
    private final /* synthetic */ zzkt l;

    public RunnableC0976kl(zzkt zzktVar, zzoz zzozVar, int i, int i2, zzfs zzfsVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        this.l = zzktVar;
        this.f12279a = zzozVar;
        this.f12280b = i;
        this.f12281c = i2;
        this.f12282d = zzfsVar;
        this.f12283e = i3;
        this.f12284f = obj;
        this.f12285g = j;
        this.f12286h = j2;
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
        zzoz zzozVar = this.f12279a;
        int i = this.f12280b;
        int i2 = this.f12281c;
        zzfs zzfsVar = this.f12282d;
        int i3 = this.f12283e;
        Object obj = this.f12284f;
        zzx = this.l.zzx(this.f12285g);
        zzx2 = this.l.zzx(this.f12286h);
        zzksVar.zza(zzozVar, i, i2, zzfsVar, i3, obj, zzx, zzx2, this.i, this.j, this.k);
    }
}
