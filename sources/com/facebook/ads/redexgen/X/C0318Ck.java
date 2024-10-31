package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Ck, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0318Ck implements InterfaceC0267Al {
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0318Ck.A01
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
            r0 = r0 ^ 99
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0318Ck.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{5, 15, 14, 28, 119, 98};
    }

    public C0318Ck(D1 d1) {
        this.A00 = d1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0092, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0267Al
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.AbstractC0351Dr A44() throws java.io.UnsupportedEncodingException, java.security.NoSuchAlgorithmException {
        /*
            r8 = this;
            r7 = r8
            r1 = 0
            r6 = 0
            r5 = 0
            com.facebook.ads.redexgen.X.D1 r0 = r7.A00
            android.content.pm.ServiceInfo[] r0 = com.facebook.ads.redexgen.X.D1.A0B(r0)
            if (r0 == 0) goto L8c
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L61;
                case 3: goto L44;
                case 4: goto L24;
                case 5: goto L15;
                case 6: goto L11;
                case 7: goto L54;
                case 8: goto L69;
                case 9: goto L8e;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            int r5 = r5 + 1
            r0 = 3
            goto Ld
        L15:
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            r3 = 0
            r2 = 1
            r0 = 108(0x6c, float:1.51E-43)
            java.lang.String r0 = A00(r3, r2, r0)
            r6.append(r0)
            r0 = 6
            goto Ld
        L24:
            com.facebook.ads.redexgen.X.Ck r7 = (com.facebook.ads.redexgen.X.C0318Ck) r7
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            com.facebook.ads.redexgen.X.D1 r0 = r7.A00
            android.content.pm.ServiceInfo[] r0 = com.facebook.ads.redexgen.X.D1.A0B(r0)
            r0 = r0[r5]
            java.lang.String r0 = r0.name
            r6.append(r0)
            com.facebook.ads.redexgen.X.D1 r0 = r7.A00
            android.content.pm.ServiceInfo[] r0 = com.facebook.ads.redexgen.X.D1.A0B(r0)
            int r0 = r0.length
            int r0 = r0 + (-1)
            if (r5 == r0) goto L42
            r0 = 5
            goto Ld
        L42:
            r0 = 6
            goto Ld
        L44:
            com.facebook.ads.redexgen.X.Ck r7 = (com.facebook.ads.redexgen.X.C0318Ck) r7
            com.facebook.ads.redexgen.X.D1 r0 = r7.A00
            android.content.pm.ServiceInfo[] r0 = com.facebook.ads.redexgen.X.D1.A0B(r0)
            int r0 = r0.length
            if (r5 >= r0) goto L51
            r0 = 4
            goto Ld
        L51:
            r0 = 8
            goto Ld
        L54:
            com.facebook.ads.redexgen.X.Ck r7 = (com.facebook.ads.redexgen.X.C0318Ck) r7
            com.facebook.ads.redexgen.X.D1 r1 = r7.A00
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A06
            com.facebook.ads.redexgen.X.Dr r1 = r1.A07(r0)
            r0 = 9
            goto Ld
        L61:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r5 = 0
            r0 = 3
            goto Ld
        L69:
            com.facebook.ads.redexgen.X.Ck r7 = (com.facebook.ads.redexgen.X.C0318Ck) r7
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            com.facebook.ads.redexgen.X.D1 r4 = r7.A00
            java.lang.String r3 = r6.toString()
            r2 = 1
            r1 = 5
            r0 = 57
            java.lang.String r0 = A00(r2, r1, r0)
            byte[] r1 = r3.getBytes(r0)
            com.facebook.ads.redexgen.X.EI r0 = com.facebook.ads.redexgen.X.EI.A05
            java.lang.String r0 = com.facebook.ads.redexgen.X.EJ.A08(r1, r0)
            com.facebook.ads.redexgen.X.Dr r1 = r4.A08(r0)
            r0 = 9
            goto Ld
        L8c:
            r0 = 7
            goto Ld
        L8e:
            com.facebook.ads.redexgen.X.Dr r1 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r1
            com.facebook.ads.redexgen.X.Dr r1 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0318Ck.A44():com.facebook.ads.redexgen.X.Dr");
    }
}
