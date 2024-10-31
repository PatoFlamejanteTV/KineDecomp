package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Fq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0402Fq {
    public static byte[] A05;
    public C0403Fr A01;

    @Nullable
    public String A02;

    @Nullable
    public String A03;
    public int A00 = 0;
    public List<C0400Fo> A04 = new ArrayList();

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0402Fq.A05
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
            r0 = r0 ^ r4
            r0 = r0 ^ 54
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0402Fq.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A05 = new byte[]{87, 64};
    }

    public C0402Fq(C0403Fr c0403Fr, @Nullable String str, @Nullable String str2) {
        this.A01 = c0403Fr;
        this.A03 = str;
        this.A02 = str2;
    }

    public final int A02() {
        return this.A04.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long A03() {
        /*
            r5 = this;
            r4 = r5
            r2 = 0
            com.facebook.ads.redexgen.X.Fr r0 = r4.A01
            if (r0 == 0) goto L22
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L24;
                case 4: goto L1e;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Fq r4 = (com.facebook.ads.redexgen.X.C0402Fq) r4
            com.facebook.ads.redexgen.X.Fr r0 = r4.A01
            long r2 = r0.A0C()
            com.facebook.ads.redexgen.X.Fr r0 = r4.A01
            int r0 = r0.A03()
            long r0 = (long) r0
            long r2 = r2 + r0
            r0 = 3
            goto L8
        L1e:
            r2 = -1
            r0 = 3
            goto L8
        L22:
            r0 = 4
            goto L8
        L24:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0402Fq.A03():long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.C0400Fo A04() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            int r1 = r3.A00
            java.util.List<com.facebook.ads.redexgen.X.Fo> r0 = r3.A04
            int r0 = r0.size()
            if (r1 >= r0) goto L2a
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L2c;
                case 4: goto L27;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.Fq r3 = (com.facebook.ads.redexgen.X.C0402Fq) r3
            int r0 = r3.A00
            int r0 = r0 + 1
            r3.A00 = r0
            java.util.List<com.facebook.ads.redexgen.X.Fo> r1 = r3.A04
            int r0 = r3.A00
            int r0 = r0 + (-1)
            java.lang.Object r2 = r1.get(r0)
            com.facebook.ads.redexgen.X.Fo r2 = (com.facebook.ads.redexgen.X.C0400Fo) r2
            r0 = 3
            goto Ld
        L27:
            r2 = 0
            r0 = 3
            goto Ld
        L2a:
            r0 = 4
            goto Ld
        L2c:
            com.facebook.ads.redexgen.X.Fo r2 = (com.facebook.ads.redexgen.X.C0400Fo) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0402Fq.A04():com.facebook.ads.redexgen.X.Fo");
    }

    public final C0403Fr A05() {
        return this.A01;
    }

    @Nullable
    public final String A06() {
        return this.A02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:            return r2;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A07() {
        /*
            r5 = this;
            r4 = r5
            r2 = 0
            int r0 = r4.A00
            if (r0 <= 0) goto L3d
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1b;
                case 4: goto L3f;
                case 5: goto L3a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.Fq r4 = (com.facebook.ads.redexgen.X.C0402Fq) r4
            int r1 = r4.A00
            java.util.List<com.facebook.ads.redexgen.X.Fo> r0 = r4.A04
            int r0 = r0.size()
            if (r1 > r0) goto L19
            r0 = 3
            goto L7
        L19:
            r0 = 5
            goto L7
        L1b:
            com.facebook.ads.redexgen.X.Fq r4 = (com.facebook.ads.redexgen.X.C0402Fq) r4
            java.util.List<com.facebook.ads.redexgen.X.Fo> r1 = r4.A04
            int r0 = r4.A00
            int r0 = r0 + (-1)
            java.lang.Object r0 = r1.get(r0)
            com.facebook.ads.redexgen.X.Fo r0 = (com.facebook.ads.redexgen.X.C0400Fo) r0
            org.json.JSONObject r3 = r0.A05()
            r2 = 0
            r1 = 2
            r0 = 2
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.String r2 = r3.optString(r0)
            r0 = 4
            goto L7
        L3a:
            r2 = 0
            r0 = 4
            goto L7
        L3d:
            r0 = 5
            goto L7
        L3f:
            java.lang.String r2 = (java.lang.String) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0402Fq.A07():java.lang.String");
    }

    @Nullable
    public final String A08() {
        return this.A03;
    }

    public final void A09(C0400Fo c0400Fo) {
        this.A04.add(c0400Fo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0A() {
        /*
            r8 = this;
            r7 = r8
            r6 = 0
            com.facebook.ads.redexgen.X.Fr r0 = r7.A01
            if (r0 == 0) goto L2d
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L27;
                case 4: goto L2f;
                case 5: goto L2a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.Fq r7 = (com.facebook.ads.redexgen.X.C0402Fq) r7
            long r4 = com.facebook.ads.redexgen.X.K4.A00()
            com.facebook.ads.redexgen.X.Fr r0 = r7.A01
            long r2 = r0.A0C()
            com.facebook.ads.redexgen.X.Fr r0 = r7.A01
            int r0 = r0.A03()
            long r0 = (long) r0
            long r2 = r2 + r0
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L25
            r0 = 3
            goto L7
        L25:
            r0 = 5
            goto L7
        L27:
            r6 = 1
            r0 = 4
            goto L7
        L2a:
            r6 = 0
            r0 = 4
            goto L7
        L2d:
            r0 = 3
            goto L7
        L2f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0402Fq.A0A():boolean");
    }
}
