package com.facebook.ads.redexgen.X;

import android.widget.TextView;

/* loaded from: assets/audience_network.dex */
public final class R0 extends QJ {
    public static byte[] A03;
    public final TextView A00;
    public final C1S<QT> A01;
    public final String A02;

    static {
        A07();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.R0.A03
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
            int r0 = r0 + (-66)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.R0.A04(int, int, int):java.lang.String");
    }

    public static void A07() {
        A03 = new byte[]{-68, -68, -58, -68, -68, -32, -21, -19, 31, -11, -32, -21, -19, 31, 15, 15, -26, -39, -31, -43, -35, -30, -35, -30, -37, -13, -24, -35, -31, -39, 17, 17};
    }

    public R0(C0362Ec c0362Ec, String str) {
        super(c0362Ec);
        this.A01 = new C0689Qz(this);
        this.A00 = new TextView(c0362Ec);
        this.A02 = str;
        addView(this.A00);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009b, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String A05(long r17) {
        /*
            r16 = this;
            r9 = r16
            r14 = 0
            r5 = 0
            r0 = 0
            r0 = 0
            r12 = 0
            r0 = 0
            r8 = 2
            r11 = 1
            r0 = 0
            r6 = 0
            r2 = r17
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 > 0) goto L95
            r0 = 2
        L16:
            switch(r0) {
                case 2: goto L1a;
                case 3: goto L97;
                case 4: goto L24;
                case 5: goto L43;
                case 6: goto L63;
                default: goto L19;
            }
        L19:
            goto L16
        L1a:
            r4 = 0
            r1 = 5
            r0 = 74
            java.lang.String r5 = A04(r4, r1, r0)
            r0 = 3
            goto L16
        L24:
            com.facebook.ads.redexgen.X.R0 r9 = (com.facebook.ads.redexgen.X.R0) r9
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r14 = r0.toMinutes(r2)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0 = 60000(0xea60, double:2.9644E-319)
            long r0 = r2 % r0
            long r12 = r4.toSeconds(r0)
            java.lang.String r0 = r9.A02
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L41
            r0 = 5
            goto L16
        L41:
            r0 = 6
            goto L16
        L43:
            r6 = 0
            java.util.Locale r5 = java.util.Locale.US
            r4 = 5
            r1 = 9
            r0 = 121(0x79, float:1.7E-43)
            java.lang.String r4 = A04(r4, r1, r0)
            java.lang.Object[] r1 = new java.lang.Object[r8]
            java.lang.Long r0 = java.lang.Long.valueOf(r14)
            r1[r6] = r0
            java.lang.Long r0 = java.lang.Long.valueOf(r12)
            r1[r11] = r0
            java.lang.String r5 = java.lang.String.format(r5, r4, r1)
            r0 = 3
            goto L16
        L63:
            com.facebook.ads.redexgen.X.R0 r9 = (com.facebook.ads.redexgen.X.R0) r9
            r10 = 0
            java.lang.String r7 = r9.A02
            r4 = 14
            r1 = 18
            r0 = 82
            java.lang.String r6 = A04(r4, r1, r0)
            java.util.Locale r5 = java.util.Locale.US
            r4 = 5
            r1 = 9
            r0 = 121(0x79, float:1.7E-43)
            java.lang.String r4 = A04(r4, r1, r0)
            java.lang.Object[] r1 = new java.lang.Object[r8]
            java.lang.Long r0 = java.lang.Long.valueOf(r14)
            r1[r10] = r0
            java.lang.Long r0 = java.lang.Long.valueOf(r12)
            r1[r11] = r0
            java.lang.String r0 = java.lang.String.format(r5, r4, r1)
            java.lang.String r5 = r7.replace(r6, r0)
            r0 = 3
            goto L16
        L95:
            r0 = 4
            goto L16
        L97:
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r5 = (java.lang.String) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.R0.A05(long):java.lang.String");
    }

    @Override // com.facebook.ads.redexgen.X.QJ
    public final void A09() {
        super.A09();
        if (getVideoView() != null) {
            getVideoView().getEventBus().A05(this.A01);
        }
    }

    @Override // com.facebook.ads.redexgen.X.QJ
    public final void A0A() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().A06(this.A01);
        }
        super.A0A();
    }

    public void setCountdownTextColor(int i) {
        this.A00.setTextColor(i);
    }
}
