package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Cn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0321Cn implements InterfaceC0267Al {
    public static byte[] A01;
    public final /* synthetic */ D1 A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0321Cn.A01
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
            r0 = r0 ^ 5
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0321Cn.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{53, 61, 60, 46, 69, 80};
    }

    public C0321Cn(D1 d1) {
        this.A00 = d1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0090, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0267Al
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.AbstractC0351Dr A44() throws java.io.UnsupportedEncodingException, java.security.NoSuchAlgorithmException {
        /*
            r8 = this;
            r7 = r8
            r6 = 0
            r1 = 0
            r5 = 0
            com.facebook.ads.redexgen.X.D1 r0 = r7.A00
            java.lang.String[] r0 = com.facebook.ads.redexgen.X.D1.A0D(r0)
            if (r0 == 0) goto L8a
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L15;
                case 3: goto L4a;
                case 4: goto L2c;
                case 5: goto L1d;
                case 6: goto L11;
                case 7: goto L7d;
                case 8: goto L5a;
                case 9: goto L8c;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            int r5 = r5 + 1
            r0 = 3
            goto Ld
        L15:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r5 = 0
            r0 = 3
            goto Ld
        L1d:
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            r3 = 0
            r2 = 1
            r0 = 58
            java.lang.String r0 = A00(r3, r2, r0)
            r6.append(r0)
            r0 = 6
            goto Ld
        L2c:
            com.facebook.ads.redexgen.X.Cn r7 = (com.facebook.ads.redexgen.X.C0321Cn) r7
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            com.facebook.ads.redexgen.X.D1 r0 = r7.A00
            java.lang.String[] r0 = com.facebook.ads.redexgen.X.D1.A0D(r0)
            r0 = r0[r5]
            r6.append(r0)
            com.facebook.ads.redexgen.X.D1 r0 = r7.A00
            java.lang.String[] r0 = com.facebook.ads.redexgen.X.D1.A0D(r0)
            int r0 = r0.length
            int r0 = r0 + (-1)
            if (r5 == r0) goto L48
            r0 = 5
            goto Ld
        L48:
            r0 = 6
            goto Ld
        L4a:
            com.facebook.ads.redexgen.X.Cn r7 = (com.facebook.ads.redexgen.X.C0321Cn) r7
            com.facebook.ads.redexgen.X.D1 r0 = r7.A00
            java.lang.String[] r0 = com.facebook.ads.redexgen.X.D1.A0D(r0)
            int r0 = r0.length
            if (r5 >= r0) goto L57
            r0 = 4
            goto Ld
        L57:
            r0 = 8
            goto Ld
        L5a:
            com.facebook.ads.redexgen.X.Cn r7 = (com.facebook.ads.redexgen.X.C0321Cn) r7
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            com.facebook.ads.redexgen.X.D1 r4 = r7.A00
            java.lang.String r3 = r6.toString()
            r2 = 1
            r1 = 5
            r0 = 109(0x6d, float:1.53E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            byte[] r1 = r3.getBytes(r0)
            com.facebook.ads.redexgen.X.EI r0 = com.facebook.ads.redexgen.X.EI.A05
            java.lang.String r0 = com.facebook.ads.redexgen.X.EJ.A08(r1, r0)
            com.facebook.ads.redexgen.X.Dr r1 = r4.A08(r0)
            r0 = 9
            goto Ld
        L7d:
            com.facebook.ads.redexgen.X.Cn r7 = (com.facebook.ads.redexgen.X.C0321Cn) r7
            com.facebook.ads.redexgen.X.D1 r1 = r7.A00
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A06
            com.facebook.ads.redexgen.X.Dr r1 = r1.A07(r0)
            r0 = 9
            goto Ld
        L8a:
            r0 = 7
            goto Ld
        L8c:
            com.facebook.ads.redexgen.X.Dr r1 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r1
            com.facebook.ads.redexgen.X.Dr r1 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0321Cn.A44():com.facebook.ads.redexgen.X.Dr");
    }
}
