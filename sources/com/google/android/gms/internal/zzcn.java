package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd;

@zzgr
/* loaded from: classes.dex */
public class zzcn extends NativeAd.Image {
    private final Drawable mDrawable;
    private final Uri mUri;
    private final double zzwn;
    private final zzcm zzxc;

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:2|3)|(9:5|6|7|8|9|10|11|12|13)|22|6|7|8|9|10|11|12|13) */
    /* JADX WARN: Can't wrap try/catch for region: R(13:1|2|3|(9:5|6|7|8|9|10|11|12|13)|22|6|7|8|9|10|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:            r2 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get scale.", r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get uri.", r0);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzcn(com.google.android.gms.internal.zzcm r5) {
        /*
            r4 = this;
            r1 = 0
            r4.<init>()
            r4.zzxc = r5
            com.google.android.gms.internal.zzcm r0 = r4.zzxc     // Catch: android.os.RemoteException -> L29
            com.google.android.gms.dynamic.zzd r0 = r0.zzdv()     // Catch: android.os.RemoteException -> L29
            if (r0 == 0) goto L2f
            java.lang.Object r0 = com.google.android.gms.dynamic.zze.a(r0)     // Catch: android.os.RemoteException -> L29
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0     // Catch: android.os.RemoteException -> L29
        L14:
            r4.mDrawable = r0
            com.google.android.gms.internal.zzcm r0 = r4.zzxc     // Catch: android.os.RemoteException -> L31
            android.net.Uri r1 = r0.getUri()     // Catch: android.os.RemoteException -> L31
        L1c:
            r4.mUri = r1
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            com.google.android.gms.internal.zzcm r2 = r4.zzxc     // Catch: android.os.RemoteException -> L38
            double r0 = r2.getScale()     // Catch: android.os.RemoteException -> L38
        L26:
            r4.zzwn = r0
            return
        L29:
            r0 = move-exception
            java.lang.String r2 = "Failed to get drawable."
            com.google.android.gms.ads.internal.util.client.zzb.b(r2, r0)
        L2f:
            r0 = r1
            goto L14
        L31:
            r0 = move-exception
            java.lang.String r2 = "Failed to get uri."
            com.google.android.gms.ads.internal.util.client.zzb.b(r2, r0)
            goto L1c
        L38:
            r2 = move-exception
            java.lang.String r3 = "Failed to get scale."
            com.google.android.gms.ads.internal.util.client.zzb.b(r3, r2)
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcn.<init>(com.google.android.gms.internal.zzcm):void");
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public double getScale() {
        return this.zzwn;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public Uri getUri() {
        return this.mUri;
    }
}
