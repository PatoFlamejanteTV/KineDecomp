package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@zzark
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzbfw extends zzbfk implements zzbez {
    private String url;
    private boolean zzexf;
    private zzbes zzexl;
    private Exception zzexm;
    private boolean zzexn;

    public zzbfw(zzbdz zzbdzVar, zzbdy zzbdyVar) {
        super(zzbdzVar);
        this.zzexl = new zzbes(zzbdzVar.getContext(), zzbdyVar);
        this.zzexl.zza(this);
    }

    private final void zzfa(String str) {
        synchronized (this) {
            this.zzexf = true;
            notify();
            release();
        }
        String str2 = this.url;
        if (str2 != null) {
            String zzey = zzey(str2);
            Exception exc = this.zzexm;
            if (exc != null) {
                zza(this.url, zzey, "badUrl", zzb(str, exc));
            } else {
                zza(this.url, zzey, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void abort() {
        zzfa(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbfk, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzbes zzbesVar = this.zzexl;
        if (zzbesVar != null) {
            zzbesVar.zza((zzbez) null);
            this.zzexl.release();
        }
        super.release();
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zza(String str, Exception exc) {
        this.zzexm = exc;
        zzbbd.zzc("Precache error", exc);
        zzfa(str);
    }

    public final zzbes zzadd() {
        synchronized (this) {
            this.zzexn = true;
            notify();
        }
        this.zzexl.zza((zzbez) null);
        zzbes zzbesVar = this.zzexl;
        this.zzexl = null;
        return zzbesVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zzb(final boolean z, final long j) {
        final zzbdz zzbdzVar = this.zzewo.get();
        if (zzbdzVar != null) {
            zzbcg.zzepo.execute(new Runnable(zzbdzVar, z, j) { // from class: com.google.android.gms.internal.ads.vf

                /* renamed from: a, reason: collision with root package name */
                private final zzbdz f12607a;

                /* renamed from: b, reason: collision with root package name */
                private final boolean f12608b;

                /* renamed from: c, reason: collision with root package name */
                private final long f12609c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12607a = zzbdzVar;
                    this.f12608b = z;
                    this.f12609c = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12607a.zza(this.f12608b, this.f12609c);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zzcz(int i) {
        this.zzexl.zzacz().zzdf(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zzda(int i) {
        this.zzexl.zzacz().zzdg(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zzdb(int i) {
        this.zzexl.zzacz().zzdb(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zzdc(int i) {
        this.zzexl.zzacz().zzdc(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zzdd(int i) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f3, code lost:            return true;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22, types: [long] */
    /* JADX WARN: Type inference failed for: r1v26 */
    @Override // com.google.android.gms.internal.ads.zzbfk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzex(java.lang.String r34) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfw.zzex(java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbfk
    public final String zzey(String str) {
        String valueOf = String.valueOf(super.zzey(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zzp(int i, int i2) {
    }

    private static String zzb(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }
}
