package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import org.json.JSONException;

/* loaded from: assets/audience_network.dex */
public class IM extends IL {
    public static byte[] A02;
    public final /* synthetic */ long A00;
    public final /* synthetic */ IQ A01;

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
            byte[] r1 = com.facebook.ads.redexgen.X.IM.A02
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
            r0 = r0 ^ 110(0x6e, float:1.54E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IM.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A02 = new byte[]{14, 56, 47, 43, 56, 47, 125, 56, 47, 47, 50, 47, 125, 50, 62, 62, 40, 47, 47, 56, 57, 83, 101, 114, 118, 101, 114, 32, 114, 101, 112, 108, 105, 101, 100, 32, 115, 117, 99, 99, 101, 115, 115, 102, 117, 108, 108, 121, 80, 86, 1, 82, 3, 3, 82, 87, 81, 81, 4, 82, 85, 87, 93, 80, 95, 94, 115, 95, 93, 64, 92, 85, 68, 85, 19, 18, 57, 14, 14, 19, 14};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001d. Please report as an issue. */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private final void A02(J9 j9) {
        IH ih;
        IR ir;
        C0362Ec c0362Ec;
        String str;
        AdErrorType adErrorType = null;
        String str2 = null;
        String str3 = null;
        IQ iq = null;
        ih = this.A01.A01;
        IG.A06(ih);
        this.A01.A03 = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        j9 = j9;
                        JA A00 = j9.A00();
                        if (A00 == null) {
                            break;
                        } else {
                            str3 = A00.A01();
                            ir = this.A01.A07;
                            c0362Ec = this.A01.A06;
                            long j = this.A00;
                            str = this.A01.A04;
                            IT A06 = ir.A06(c0362Ec, str3, j, str);
                            if (A06.A01() != IS.A03) {
                                break;
                            } else {
                                IV iv = (IV) A06;
                                str2 = iv.A04();
                                adErrorType = AdErrorType.adErrorTypeFromCode(iv.A03(), AdErrorType.ERROR_MESSAGE);
                                iq = this.A01;
                                c = str2 == null ? (char) 23 : (char) 25;
                            }
                        }
                    } catch (JSONException unused) {
                        break;
                    }
                case 23:
                    iq.A0J(C0453Hr.A02(adErrorType, str3));
                    return;
                case 25:
                    str2 = str2;
                    str3 = str2;
                    c = 23;
            }
        }
        this.A01.A0J(C0453Hr.A02(AdErrorType.NETWORK_ERROR, j9.getMessage()));
    }

    public IM(IQ iq, long j) {
        this.A01 = iq;
        this.A00 = j;
    }

    @Override // com.facebook.ads.redexgen.X.IL
    public final void A03(JA ja) {
        IH ih;
        I5.A05(A00(64, 10, 94), A00(21, 27, 110), A00(56, 8, 11));
        if (ja != null) {
            String A01 = ja.A01();
            ih = this.A01.A01;
            IG.A06(ih);
            this.A01.A03 = null;
            this.A01.A0S(A01, this.A00);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.IL
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A04(java.lang.Exception r7) {
        /*
            r6 = this;
            r4 = r6
            r2 = 74
            r1 = 7
            r0 = 18
            java.lang.String r5 = A00(r2, r1, r0)
            r2 = 0
            r1 = 21
            r0 = 51
            java.lang.String r3 = A00(r2, r1, r0)
            r2 = 48
            r1 = 8
            r0 = 9
            java.lang.String r0 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.X.I5.A05(r5, r3, r0)
            java.lang.Class<com.facebook.ads.redexgen.X.J9> r1 = com.facebook.ads.redexgen.X.J9.class
            java.lang.Class r0 = r7.getClass()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L52
            r0 = 2
        L2d:
            switch(r0) {
                case 2: goto L31;
                case 3: goto L54;
                case 4: goto L3d;
                default: goto L30;
            }
        L30:
            goto L2d
        L31:
            com.facebook.ads.redexgen.X.IM r4 = (com.facebook.ads.redexgen.X.IM) r4
            java.lang.Exception r7 = (java.lang.Exception) r7
            r0 = r7
            com.facebook.ads.redexgen.X.J9 r0 = (com.facebook.ads.redexgen.X.J9) r0
            r4.A02(r0)
            r0 = 3
            goto L2d
        L3d:
            com.facebook.ads.redexgen.X.IM r4 = (com.facebook.ads.redexgen.X.IM) r4
            java.lang.Exception r7 = (java.lang.Exception) r7
            com.facebook.ads.redexgen.X.IQ r2 = r4.A01
            com.facebook.ads.internal.protocol.AdErrorType r1 = com.facebook.ads.internal.protocol.AdErrorType.NETWORK_ERROR
            java.lang.String r0 = r7.getMessage()
            com.facebook.ads.redexgen.X.Hr r0 = com.facebook.ads.redexgen.X.C0453Hr.A02(r1, r0)
            com.facebook.ads.redexgen.X.IQ.A0L(r2, r0)
            r0 = 3
            goto L2d
        L52:
            r0 = 4
            goto L2d
        L54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IM.A04(java.lang.Exception):void");
    }
}
