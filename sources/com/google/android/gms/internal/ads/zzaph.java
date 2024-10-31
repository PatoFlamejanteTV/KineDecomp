package com.google.android.gms.internal.ads;

import android.content.Context;

@zzark
/* loaded from: classes2.dex */
public abstract class zzaph extends zzaxv {
    protected final Context mContext;
    protected final Object mLock;
    protected final zzapm zzdsj;
    protected final zzaxg zzdsk;
    protected zzasm zzdsl;
    protected final Object zzdsn;

    public zzaph(Context context, zzaxg zzaxgVar, zzapm zzapmVar) {
        super(true);
        this.mLock = new Object();
        this.zzdsn = new Object();
        this.mContext = context;
        this.zzdsk = zzaxgVar;
        this.zzdsl = zzaxgVar.zzehy;
        this.zzdsj = zzapmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public void onStop() {
    }

    protected abstract void zzap(long j) throws zzapk;

    protected abstract zzaxf zzcr(int i);

    /* JADX WARN: Removed duplicated region for block: B:22:0x0033 A[Catch: all -> 0x0061, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000c, B:7:0x0051, B:8:0x005f, B:14:0x0015, B:19:0x0020, B:20:0x002f, B:22:0x0033, B:23:0x0046, B:24:0x003b, B:25:0x0028), top: B:3:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b A[Catch: all -> 0x0061, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000c, B:7:0x0051, B:8:0x005f, B:14:0x0015, B:19:0x0020, B:20:0x002f, B:22:0x0033, B:23:0x0046, B:24:0x003b, B:25:0x0028), top: B:3:0x0003, inners: #1 }] */
    @Override // com.google.android.gms.internal.ads.zzaxv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzki() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            java.lang.String r1 = "AdRendererBackgroundTask started."
            com.google.android.gms.internal.ads.zzbbd.zzdn(r1)     // Catch: java.lang.Throwable -> L61
            com.google.android.gms.internal.ads.zzaxg r1 = r5.zzdsk     // Catch: java.lang.Throwable -> L61
            int r1 = r1.errorCode     // Catch: java.lang.Throwable -> L61
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch: com.google.android.gms.internal.ads.zzapk -> L14 java.lang.Throwable -> L61
            r5.zzap(r2)     // Catch: com.google.android.gms.internal.ads.zzapk -> L14 java.lang.Throwable -> L61
            goto L51
        L14:
            r1 = move-exception
            int r2 = r1.getErrorCode()     // Catch: java.lang.Throwable -> L61
            r3 = 3
            if (r2 == r3) goto L28
            r3 = -1
            if (r2 != r3) goto L20
            goto L28
        L20:
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L61
            com.google.android.gms.internal.ads.zzbbd.zzeo(r1)     // Catch: java.lang.Throwable -> L61
            goto L2f
        L28:
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L61
            com.google.android.gms.internal.ads.zzbbd.zzen(r1)     // Catch: java.lang.Throwable -> L61
        L2f:
            com.google.android.gms.internal.ads.zzasm r1 = r5.zzdsl     // Catch: java.lang.Throwable -> L61
            if (r1 != 0) goto L3b
            com.google.android.gms.internal.ads.zzasm r1 = new com.google.android.gms.internal.ads.zzasm     // Catch: java.lang.Throwable -> L61
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L61
            r5.zzdsl = r1     // Catch: java.lang.Throwable -> L61
            goto L46
        L3b:
            com.google.android.gms.internal.ads.zzasm r1 = new com.google.android.gms.internal.ads.zzasm     // Catch: java.lang.Throwable -> L61
            com.google.android.gms.internal.ads.zzasm r3 = r5.zzdsl     // Catch: java.lang.Throwable -> L61
            long r3 = r3.zzdlx     // Catch: java.lang.Throwable -> L61
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L61
            r5.zzdsl = r1     // Catch: java.lang.Throwable -> L61
        L46:
            android.os.Handler r1 = com.google.android.gms.internal.ads.zzayh.zzelc     // Catch: java.lang.Throwable -> L61
            com.google.android.gms.internal.ads.Rb r3 = new com.google.android.gms.internal.ads.Rb     // Catch: java.lang.Throwable -> L61
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L61
            r1.post(r3)     // Catch: java.lang.Throwable -> L61
            r1 = r2
        L51:
            com.google.android.gms.internal.ads.zzaxf r1 = r5.zzcr(r1)     // Catch: java.lang.Throwable -> L61
            android.os.Handler r2 = com.google.android.gms.internal.ads.zzayh.zzelc     // Catch: java.lang.Throwable -> L61
            com.google.android.gms.internal.ads.Sb r3 = new com.google.android.gms.internal.ads.Sb     // Catch: java.lang.Throwable -> L61
            r3.<init>(r5, r1)     // Catch: java.lang.Throwable -> L61
            r2.post(r3)     // Catch: java.lang.Throwable -> L61
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L61
            return
        L61:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L61
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaph.zzki():void");
    }
}
