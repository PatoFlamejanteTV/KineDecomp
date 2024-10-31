package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import org.json.JSONException;

/* loaded from: assets/audience_network.dex */
public class IK implements InterfaceC0436Gz {
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
            byte[] r1 = com.facebook.ads.redexgen.X.IK.A02
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
            int r0 = r0 + (-107)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IK.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A02 = new byte[]{-56, -38, -25, -21, -38, -25, -107, -38, -25, -25, -28, -25, -107, -28, -40, -40, -22, -25, -25, -38, -39, -47, -38, -42, -43, -52, -1, -22, -20, -9, -5, -16, -10, -11, -63, -89, 6, 24, 37, 41, 24, 37, -45, 37, 24, 35, 31, 28, 24, 23, -45, 38, 40, 22, 22, 24, 38, 38, 25, 40, 31, 31, 44, 4, 3, -40, 4, 2, 5, 1, -6, 9, -6, -54, -7, -53, -54, -10, -57, -5, -58, -34, -35, -33, -31, 15, -27, -28, -34, 51, 50, 9, 54, 54, 51, 54};
    }

    public IK(IQ iq, long j) {
        this.A01 = iq;
        this.A00 = j;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0020. Please report as an issue. */
    private final void A02(EQ eq) {
        IH ih;
        C0362Ec c0362Ec;
        long j;
        C0362Ec c0362Ec2;
        long j2;
        C0362Ec c0362Ec3;
        long j3;
        IR ir;
        C0362Ec c0362Ec4;
        String str;
        EQ eq2 = eq;
        IK ik = this;
        String str2 = null;
        String str3 = null;
        FN fn = null;
        IT serverResponse = null;
        String str4 = null;
        AdErrorType adErrorType = null;
        ih = ik.A01.A01;
        IG.A06(ih);
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    eq2 = eq2;
                    fn = eq2.A00();
                    c = fn != null ? (char) 4 : '$';
                case 4:
                    try {
                        fn = fn;
                        str2 = fn.A4M();
                        ir = ik.A01.A07;
                        c0362Ec4 = ik.A01.A06;
                        long j4 = ik.A00;
                        str = ik.A01.A04;
                        serverResponse = ir.A06(c0362Ec4, str2, j4, str);
                        c = serverResponse.A01() == IS.A03 ? (char) 16 : '$';
                    } catch (JSONException e) {
                        AdErrorType adErrorType2 = AdErrorType.NETWORK_ERROR;
                        String message = eq2.getMessage();
                        c0362Ec3 = ik.A01.A06;
                        InterfaceC00050c A08 = c0362Ec3.A08();
                        j3 = ik.A01.A00;
                        A08.A2j(K4.A01(j3), adErrorType2.getErrorCode(), A00(21, 15, 28) + e.getMessage(), adErrorType2.isPublicError());
                        ik.A01.A0J(C0453Hr.A02(adErrorType2, message));
                        return;
                    }
                case 16:
                    serverResponse = serverResponse;
                    IV iv = (IV) serverResponse;
                    str4 = iv.A04();
                    adErrorType = AdErrorType.adErrorTypeFromCode(iv.A03(), AdErrorType.ERROR_MESSAGE);
                    c = str4 == null ? (char) 22 : (char) 23;
                case 22:
                    str2 = str2;
                    str3 = str2;
                    c = 24;
                case 23:
                    str4 = str4;
                    str3 = str4;
                    c = 24;
                case 24:
                    ik = ik;
                    c0362Ec2 = ik.A01.A06;
                    InterfaceC00050c A082 = c0362Ec2.A08();
                    j2 = ik.A01.A00;
                    A082.A2j(K4.A01(j2), adErrorType.getErrorCode(), str3, adErrorType.isPublicError());
                    ik.A01.A0J(C0453Hr.A02(adErrorType, str3));
                    return;
                case '$':
                    IK ik2 = ik;
                    AdErrorType adErrorType3 = AdErrorType.NETWORK_ERROR;
                    String message2 = eq2.getMessage();
                    c0362Ec = ik2.A01.A06;
                    InterfaceC00050c A083 = c0362Ec.A08();
                    j = ik2.A01.A00;
                    A083.A2j(K4.A01(j), adErrorType3.getErrorCode(), message2, adErrorType3.isPublicError());
                    ik2.A01.A0J(C0453Hr.A02(adErrorType3, message2));
                    return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0436Gz
    public final void A6N(FN fn) {
        IH ih;
        I5.A05(A00(63, 10, 42), A00(36, 27, 72), A00(73, 8, 42));
        if (fn != null) {
            String A4M = fn.A4M();
            ih = this.A01.A01;
            IG.A06(ih);
            this.A01.A0S(A4M, this.A00);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0073, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0436Gz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A6Z(java.lang.Exception r11) {
        /*
            r10 = this;
            r3 = r10
            r2 = 89
            r1 = 7
            r0 = 89
            java.lang.String r5 = A00(r2, r1, r0)
            r2 = 0
            r1 = 21
            r0 = 10
            java.lang.String r4 = A00(r2, r1, r0)
            r2 = 81
            r1 = 8
            r0 = 66
            java.lang.String r0 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.X.I5.A05(r5, r4, r0)
            java.lang.Class<com.facebook.ads.redexgen.X.EQ> r1 = com.facebook.ads.redexgen.X.EQ.class
            java.lang.Class r0 = r11.getClass()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L71
            r0 = 2
        L2d:
            switch(r0) {
                case 2: goto L31;
                case 3: goto L73;
                case 4: goto L3d;
                default: goto L30;
            }
        L30:
            goto L2d
        L31:
            com.facebook.ads.redexgen.X.IK r3 = (com.facebook.ads.redexgen.X.IK) r3
            java.lang.Exception r11 = (java.lang.Exception) r11
            r0 = r11
            com.facebook.ads.redexgen.X.EQ r0 = (com.facebook.ads.redexgen.X.EQ) r0
            r3.A02(r0)
            r0 = 3
            goto L2d
        L3d:
            com.facebook.ads.redexgen.X.IK r3 = (com.facebook.ads.redexgen.X.IK) r3
            java.lang.Exception r11 = (java.lang.Exception) r11
            com.facebook.ads.internal.protocol.AdErrorType r2 = com.facebook.ads.internal.protocol.AdErrorType.NETWORK_ERROR
            java.lang.String r8 = r11.getMessage()
            com.facebook.ads.redexgen.X.IQ r0 = r3.A01
            com.facebook.ads.redexgen.X.Ec r0 = com.facebook.ads.redexgen.X.IQ.A01(r0)
            com.facebook.ads.redexgen.X.0c r4 = r0.A08()
            com.facebook.ads.redexgen.X.IQ r0 = r3.A01
            long r0 = com.facebook.ads.redexgen.X.IQ.A00(r0)
            long r5 = com.facebook.ads.redexgen.X.K4.A01(r0)
            int r7 = r2.getErrorCode()
            boolean r9 = r2.isPublicError()
            r4.A2j(r5, r7, r8, r9)
            com.facebook.ads.redexgen.X.IQ r1 = r3.A01
            com.facebook.ads.redexgen.X.Hr r0 = com.facebook.ads.redexgen.X.C0453Hr.A02(r2, r8)
            com.facebook.ads.redexgen.X.IQ.A0L(r1, r0)
            r0 = 3
            goto L2d
        L71:
            r0 = 4
            goto L2d
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IK.A6Z(java.lang.Exception):void");
    }
}
