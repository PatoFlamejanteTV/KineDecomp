package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdExtendedListener;

/* renamed from: com.facebook.ads.redexgen.X.3w, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C01033w extends C01023v implements InterstitialAdExtendedListener {
    public static byte[] A01;
    public final C00863f A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C01033w.A01
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
            int r0 = r0 + (-36)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01033w.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-24, -19, -13, -2, -28, -15, -15, -18, -15, -2, -30, -18, -29, -28, -2, -22, -28, -8, 119, 120, 118, -125, 105, 118, 118, 115, 118, -125, 113, 105, 119, 119, 101, 107, 105, -125, 111, 105, 125, -106, -103, -104, -111, -87, -109, -104, -96, -117, -106, -109, -114, -117, -98, -109, -103, -104, -87, -98, -109, -105, -113, -87, -107, -113, -93};
    }

    public C01033w(String str, C3W c3w, C00863f c00863f) {
        super(str, c3w);
        this.A00 = c00863f;
    }

    public final void onAdClicked(com.facebook.ads.Ad ad) {
        super.A00.A75(1024, this.A01, null);
    }

    public final void onAdLoaded(com.facebook.ads.Ad ad) {
        Bundle bundle = new Bundle();
        bundle.putLong(A00(39, 26, 38), this.A00.A09());
        super.A00.A75(1020, this.A01, bundle);
    }

    public final void onError(com.facebook.ads.Ad ad, AdError adError) {
        Bundle bundle = new Bundle();
        bundle.putString(A00(18, 21, 0), adError.getErrorMessage());
        bundle.putInt(A00(0, 18, 123), adError.getErrorCode());
        super.A00.A75(1023, this.A01, bundle);
    }

    public final void onInterstitialActivityDestroyed() {
        super.A00.A75(1026, this.A01, null);
    }

    public final void onInterstitialDismissed(com.facebook.ads.Ad ad) {
        super.A00.A75(1022, this.A01, null);
    }

    public final void onInterstitialDisplayed(com.facebook.ads.Ad ad) {
        super.A00.A75(1021, this.A01, null);
    }

    public final void onLoggingImpression(com.facebook.ads.Ad ad) {
        super.A00.A75(1025, this.A01, null);
    }

    public final void onRewardedAdCompleted() {
        super.A00.A75(3000, this.A01, null);
    }

    public final void onRewardedAdServerFailed() {
        super.A00.A75(3002, this.A01, null);
    }

    public final void onRewardedAdServerSucceeded() {
        super.A00.A75(3001, this.A01, null);
    }
}
