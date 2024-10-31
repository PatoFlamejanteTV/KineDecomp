package com.google.android.gms.internal.ads;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.ml */
/* loaded from: classes2.dex */
public final class RunnableC1004ml implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzoz f12330a;

    /* renamed from: b */
    private final /* synthetic */ int f12331b;

    /* renamed from: c */
    private final /* synthetic */ int f12332c;

    /* renamed from: d */
    private final /* synthetic */ zzfs f12333d;

    /* renamed from: e */
    private final /* synthetic */ int f12334e;

    /* renamed from: f */
    private final /* synthetic */ Object f12335f;

    /* renamed from: g */
    private final /* synthetic */ long f12336g;

    /* renamed from: h */
    private final /* synthetic */ long f12337h;
    private final /* synthetic */ long i;
    private final /* synthetic */ long j;
    private final /* synthetic */ long k;
    private final /* synthetic */ IOException l;
    private final /* synthetic */ boolean m;
    private final /* synthetic */ zzkt n;

    public RunnableC1004ml(zzkt zzktVar, zzoz zzozVar, int i, int i2, zzfs zzfsVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
        this.n = zzktVar;
        this.f12330a = zzozVar;
        this.f12331b = i;
        this.f12332c = i2;
        this.f12333d = zzfsVar;
        this.f12334e = i3;
        this.f12335f = obj;
        this.f12336g = j;
        this.f12337h = j2;
        this.i = j3;
        this.j = j4;
        this.k = j5;
        this.l = iOException;
        this.m = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzks zzksVar;
        long zzx;
        long zzx2;
        zzksVar = this.n.zzavv;
        zzoz zzozVar = this.f12330a;
        int i = this.f12331b;
        int i2 = this.f12332c;
        zzfs zzfsVar = this.f12333d;
        int i3 = this.f12334e;
        Object obj = this.f12335f;
        zzx = this.n.zzx(this.f12336g);
        zzx2 = this.n.zzx(this.f12337h);
        zzksVar.zza(zzozVar, i, i2, zzfsVar, i3, obj, zzx, zzx2, this.i, this.j, this.k, this.l, this.m);
    }
}
