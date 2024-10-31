package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.nl */
/* loaded from: classes2.dex */
public final class RunnableC1018nl implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f12363a;

    /* renamed from: b */
    private final /* synthetic */ zzfs f12364b;

    /* renamed from: c */
    private final /* synthetic */ int f12365c;

    /* renamed from: d */
    private final /* synthetic */ Object f12366d;

    /* renamed from: e */
    private final /* synthetic */ long f12367e;

    /* renamed from: f */
    private final /* synthetic */ zzkt f12368f;

    public RunnableC1018nl(zzkt zzktVar, int i, zzfs zzfsVar, int i2, Object obj, long j) {
        this.f12368f = zzktVar;
        this.f12363a = i;
        this.f12364b = zzfsVar;
        this.f12365c = i2;
        this.f12366d = obj;
        this.f12367e = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzks zzksVar;
        long zzx;
        zzksVar = this.f12368f.zzavv;
        int i = this.f12363a;
        zzfs zzfsVar = this.f12364b;
        int i2 = this.f12365c;
        Object obj = this.f12366d;
        zzx = this.f12368f.zzx(this.f12367e);
        zzksVar.zza(i, zzfsVar, i2, obj, zzx);
    }
}
