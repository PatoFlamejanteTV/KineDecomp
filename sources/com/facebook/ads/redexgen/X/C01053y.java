package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import com.facebook.ads.AdError;
import com.facebook.ads.S2SRewardedVideoAdExtendedListener;

/* renamed from: com.facebook.ads.redexgen.X.3y, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C01053y extends C01023v implements S2SRewardedVideoAdExtendedListener {
    public static byte[] A02;
    public final C00893i A00;
    public final C00993s A01;

    static {
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C01053y.A02
            int r0 = r2 + r3
            byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            if (r1 >= r0) goto L17
            r0 = 3
            goto Lc
        L17:
            r0 = 4
            goto Lc
        L19:
            byte[] r2 = (byte[]) r2
            r0 = r2[r1]
            int r0 = r0 - r4
            int r0 = r0 + (-57)
            byte r0 = (byte) r0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L27:
            byte[] r2 = (byte[]) r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01053y.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A02 = new byte[]{-26, -21, -15, -4, -30, -17, -17, -20, -17, -4, -32, -20, -31, -30, -4, -24, -30, -10, -76, -71, -65, -54, -67, -63, -54, -63, -76, -81, -80, -70, -54, -81, -64, -67, -84, -65, -76, -70, -71, -54, -74, -80, -60, -23, -22, -24, -11, -37, -24, -24, -27, -24, -11, -29, -37, -23, -23, -41, -35, -37, -11, -31, -37, -17, -17, -14, -15, -22, 2, -20, -15, -7, -28, -17, -20, -25, -28, -9, -20, -14, -15, 2, -9, -20, -16, -24, 2, -18, -24, -4};
    }

    public C01053y(String str, C3W c3w, C00893i c00893i, C00993s c00993s) {
        super(str, c3w);
        this.A00 = c00893i;
        this.A01 = c00993s;
    }

    public final void onAdClicked(com.facebook.ads.Ad ad) {
        super.A00.A75(2104, super.A01, null);
    }

    public final void onAdLoaded(com.facebook.ads.Ad ad) {
        Bundle bundle = new Bundle();
        bundle.putLong(A00(64, 26, 106), this.A00.A0B());
        bundle.putInt(A00(18, 25, 50), this.A01.A00);
        super.A00.A75(2100, super.A01, bundle);
    }

    public final void onError(com.facebook.ads.Ad ad, AdError adError) {
        Bundle bundle = new Bundle();
        bundle.putString(A00(43, 21, 93), adError.getErrorMessage());
        bundle.putInt(A00(0, 18, 100), adError.getErrorCode());
        super.A00.A75(2103, super.A01, bundle);
    }

    public final void onLoggingImpression(com.facebook.ads.Ad ad) {
        super.A00.A75(2105, super.A01, null);
    }

    public final void onRewardServerFailed() {
        super.A00.A75(3002, super.A01, null);
    }

    public final void onRewardServerSuccess() {
        super.A00.A75(3001, super.A01, null);
    }

    public final void onRewardedVideoActivityDestroyed() {
        super.A00.A75(2106, super.A01, null);
    }

    public final void onRewardedVideoClosed() {
        super.A00.A75(2110, super.A01, null);
    }

    public final void onRewardedVideoCompleted() {
        super.A00.A75(3000, super.A01, null);
    }
}
