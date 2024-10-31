package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd;

@zzark
/* loaded from: classes2.dex */
public final class zzade extends NativeAd.Image {
    private final Drawable mDrawable;
    private final Uri mUri;
    private final double zzdav;
    private final zzadb zzddr;

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|2|3|(9:5|6|7|8|9|10|11|12|13)|22|6|7|8|9|10|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:            r4 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:            com.google.android.gms.internal.ads.zzbbd.zzb("", r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0025, code lost:            r1 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0026, code lost:            com.google.android.gms.internal.ads.zzbbd.zzb("", r1);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzade(com.google.android.gms.internal.ads.zzadb r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            r3.<init>()
            r3.zzddr = r4
            r4 = 0
            com.google.android.gms.internal.ads.zzadb r1 = r3.zzddr     // Catch: android.os.RemoteException -> L17
            com.google.android.gms.dynamic.IObjectWrapper r1 = r1.zzsa()     // Catch: android.os.RemoteException -> L17
            if (r1 == 0) goto L1b
            java.lang.Object r1 = com.google.android.gms.dynamic.ObjectWrapper.a(r1)     // Catch: android.os.RemoteException -> L17
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1     // Catch: android.os.RemoteException -> L17
            goto L1c
        L17:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzb(r0, r1)
        L1b:
            r1 = r4
        L1c:
            r3.mDrawable = r1
            com.google.android.gms.internal.ads.zzadb r1 = r3.zzddr     // Catch: android.os.RemoteException -> L25
            android.net.Uri r4 = r1.getUri()     // Catch: android.os.RemoteException -> L25
            goto L29
        L25:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzb(r0, r1)
        L29:
            r3.mUri = r4
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            com.google.android.gms.internal.ads.zzadb r4 = r3.zzddr     // Catch: android.os.RemoteException -> L34
            double r1 = r4.getScale()     // Catch: android.os.RemoteException -> L34
            goto L38
        L34:
            r4 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzb(r0, r4)
        L38:
            r3.zzdav = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzade.<init>(com.google.android.gms.internal.ads.zzadb):void");
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final double getScale() {
        return this.zzdav;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Uri getUri() {
        return this.mUri;
    }
}
