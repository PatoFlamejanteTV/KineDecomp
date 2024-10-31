package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* renamed from: com.facebook.ads.redexgen.X.Pj, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0647Pj {
    public static byte[] A05;
    public Executor A00 = KJ.A05;
    public final C0362Ec A01;
    public final AnonymousClass81 A02;
    public final MQ A03;

    @Nullable
    public final String A04;

    static {
        A04();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0647Pj.A05
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
            int r0 = r0 + (-48)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0647Pj.A02(int, int, int):java.lang.String");
    }

    public static void A04() {
        A05 = new byte[]{-8, 7, 7, 0, -5, 5, 17, 17, 13, 16, -41, -52, -52, 20, 20, 20, -53, 3, -2, 0, 2, -1, 12, 12, 8, -53, 0, 12, 10, -52, -2, 18, 1, 6, 2, 11, 0, 2, -4, 11, 2, 17, 20, 12, 15, 8, -52, 16, 2, 15, 19, 2, 15, -4, 16, 6, 1, 2, -4, 15, 2, 20, -2, 15, 1, -96, -84, -84, -88, -85, 114, 103, 103, -81, -81, -81, 102, 93, -85, 102, -98, -103, -101, -99, -102, -89, -89, -93, 102, -101, -89, -91, 103, -103, -83, -100, -95, -99, -90, -101, -99, -105, -90, -99, -84, -81, -89, -86, -93, 103, -85, -99, -86, -82, -99, -86, -105, -85, -95, -100, -99, -105, -86, -99, -81, -103, -86, -100, -74, -87, 6, 10, -1, -6, 23, 28, 16, 11};
    }

    public C0647Pj(C0362Ec c0362Ec, MQ mq, @Nullable String str, AnonymousClass81 anonymousClass81) {
        this.A01 = c0362Ec;
        this.A03 = mq;
        this.A04 = str;
        this.A02 = anonymousClass81;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ca, code lost:            return r3;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(@android.support.annotation.Nullable com.facebook.ads.RewardData r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = 0
            r4 = 0
            r3 = 0
            if (r6 == 0) goto Lc4
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto Lb4;
                case 3: goto La6;
                case 4: goto L9a;
                case 5: goto La;
                case 6: goto Lc8;
                case 7: goto L7f;
                case 8: goto Lc0;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.RewardData r6 = (com.facebook.ads.RewardData) r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r5 = (java.lang.String) r5
            android.net.Uri r1 = android.net.Uri.parse(r5)
            android.net.Uri$Builder r3 = new android.net.Uri$Builder
            r3.<init>()
            java.lang.String r0 = r1.getScheme()
            r3.scheme(r0)
            java.lang.String r0 = r1.getAuthority()
            r3.authority(r0)
            java.lang.String r0 = r1.getPath()
            r3.path(r0)
            java.lang.String r0 = r1.getQuery()
            r3.query(r0)
            java.lang.String r0 = r1.getFragment()
            r3.fragment(r0)
            r2 = 134(0x86, float:1.88E-43)
            r1 = 4
            r0 = 119(0x77, float:1.67E-43)
            java.lang.String r1 = A02(r2, r1, r0)
            java.lang.String r0 = r6.getUserID()
            r3.appendQueryParameter(r1, r0)
            r2 = 128(0x80, float:1.8E-43)
            r1 = 2
            r0 = 22
            java.lang.String r1 = A02(r2, r1, r0)
            java.lang.String r0 = r6.getCurrency()
            r3.appendQueryParameter(r1, r0)
            r2 = 130(0x82, float:1.82E-43)
            r1 = 4
            r0 = 102(0x66, float:1.43E-43)
            java.lang.String r0 = A02(r2, r1, r0)
            r3.appendQueryParameter(r0, r7)
            r2 = 0
            r1 = 5
            r0 = 103(0x67, float:1.44E-43)
            java.lang.String r0 = A02(r2, r1, r0)
            r3.appendQueryParameter(r0, r8)
            android.net.Uri r0 = r3.build()
            java.lang.String r3 = r0.toString()
            r0 = 6
            goto L6
        L7f:
            java.lang.String r4 = (java.lang.String) r4
            java.util.Locale r5 = java.util.Locale.US
            r2 = 65
            r1 = 63
            r0 = 8
            java.lang.String r2 = A02(r2, r1, r0)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r0 = 0
            r1[r0] = r4
            java.lang.String r5 = java.lang.String.format(r5, r2, r1)
            r0 = 5
            goto L6
        L9a:
            r2 = 5
            r1 = 60
            r0 = 109(0x6d, float:1.53E-43)
            java.lang.String r5 = A02(r2, r1, r0)
            r0 = 5
            goto L6
        La6:
            java.lang.String r4 = (java.lang.String) r4
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto Lb1
            r0 = 4
            goto L6
        Lb1:
            r0 = 7
            goto L6
        Lb4:
            java.lang.String r4 = com.facebook.ads.AdSettings.getUrlPrefix()
            if (r4 == 0) goto Lbd
            r0 = 3
            goto L6
        Lbd:
            r0 = 4
            goto L6
        Lc0:
            r3 = 0
            r0 = 6
            goto L6
        Lc4:
            r0 = 8
            goto L6
        Lc8:
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0647Pj.A03(com.facebook.ads.RewardData, java.lang.String, java.lang.String):java.lang.String");
    }

    public final void A05() {
        if (!TextUtils.isEmpty(this.A04)) {
            AnonymousClass79 anonymousClass79 = new AnonymousClass79(this.A01, new HashMap());
            anonymousClass79.A07(new C0646Pi(this));
            anonymousClass79.executeOnExecutor(this.A00, this.A04);
        }
    }
}
