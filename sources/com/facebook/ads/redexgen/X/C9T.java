package com.facebook.ads.redexgen.X;

import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.9T, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9T implements C9M {
    public static byte[] A02;
    public static final String A03;
    public final C9U A00;
    public final EV A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C9T.A02
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
            r0 = r0 ^ 101(0x65, float:1.42E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9T.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{27, 0, 5, 0, 1, 25, 0, 75, 28, 73, 73, 25, 24, 27, 27, 2, 77, 23, 28, 29, 2, 30, 30, 74, 22, 2, 78, 29, 78, 28, 2, 29, 78, 29, 78, 74, 29, 75, 77, 76, 76, 74, 27, 66, 96, 119, 126, 125, 115, 118, 123, 124, 117, 50, 100, 123, 118, 119, 125, 40, 50, 55, 97, 126, 92, 75, 66, 65, 79, 74, 71, 64, 73, 14, 11, 74, 14, 79, 93, 93, 75, 90, 93, 94, 92, 75, 72, 75, 90, 77, 70, 74, 104, Byte.MAX_VALUE, 118, 117, 123, 126, 115, 116, 125, 58, 115, 119, 123, 125, Byte.MAX_VALUE, 32, 58, 63, 105, 124, 94, 73, 64, 67, 77, 72, 69, 66, 75, 12, 65, 77, 94, 71, 89, 92, 22, 12, 9, 95};
    }

    static {
        A02();
        A03 = C9T.class.getSimpleName();
    }

    public C9T(C9U c9u, C0365Ef c0365Ef) {
        this.A00 = c9u;
        this.A00.A35(new C9P() { // from class: com.facebook.ads.redexgen.X.9Q
            @Override // com.facebook.ads.redexgen.X.C9P
            public final void A3D() {
                C9T.this.A01();
            }
        });
        this.A01 = new EV(c0365Ef);
        A01();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:            r3 = r3;        r3.A01.A0P(new com.facebook.ads.redexgen.X.C9R(r3), new com.facebook.ads.redexgen.X.EP(A00(7, 36, 74), A00(0, 7, 11)));     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a9, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A01() {
        /*
            r7 = this;
            r3 = r7
            r4 = 0
            r0 = 0
            java.util.Locale r6 = java.util.Locale.US
            r2 = 63
            r1 = 20
            r0 = 75
            java.lang.String r5 = A00(r2, r1, r0)
            r0 = 1
            java.lang.Object[] r2 = new java.lang.Object[r0]
            r1 = 0
            com.facebook.ads.redexgen.X.9U r0 = r3.A00
            java.util.Set r0 = r0.A4I()
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2[r1] = r0
            java.lang.String.format(r6, r5, r2)
            com.facebook.ads.redexgen.X.9U r0 = r3.A00
            java.util.Set r0 = r0.A4I()
            java.util.Iterator r2 = r0.iterator()
            r0 = 2
        L31:
            switch(r0) {
                case 2: goto L7b;
                case 3: goto L5c;
                case 4: goto L4f;
                case 5: goto L42;
                case 6: goto L35;
                case 7: goto L87;
                default: goto L34;
            }
        L34:
            goto L31
        L35:
            com.facebook.ads.redexgen.X.9T r3 = (com.facebook.ads.redexgen.X.C9T) r3
            com.facebook.ads.redexgen.X.9a r4 = (com.facebook.ads.redexgen.X.InterfaceC02319a) r4
            java.lang.String r0 = r4.getUrl()
            r3.A04(r0)
            r0 = 2
            goto L31
        L42:
            com.facebook.ads.redexgen.X.9T r3 = (com.facebook.ads.redexgen.X.C9T) r3
            com.facebook.ads.redexgen.X.9a r4 = (com.facebook.ads.redexgen.X.InterfaceC02319a) r4
            java.lang.String r0 = r4.getUrl()
            r3.A06(r0)
            r0 = 2
            goto L31
        L4f:
            com.facebook.ads.redexgen.X.9T r3 = (com.facebook.ads.redexgen.X.C9T) r3
            com.facebook.ads.redexgen.X.9a r4 = (com.facebook.ads.redexgen.X.InterfaceC02319a) r4
            java.lang.String r0 = r4.getUrl()
            r3.A05(r0)
            r0 = 2
            goto L31
        L5c:
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r2.next()
            com.facebook.ads.redexgen.X.9a r4 = (com.facebook.ads.redexgen.X.InterfaceC02319a) r4
            int[] r1 = com.facebook.ads.redexgen.X.C9S.A00
            com.facebook.ads.redexgen.X.9c r0 = r4.A51()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L75;
                case 2: goto L77;
                case 3: goto L79;
                default: goto L73;
            }
        L73:
            r0 = 2
            goto L31
        L75:
            r0 = 6
            goto L31
        L77:
            r0 = 5
            goto L31
        L79:
            r0 = 4
            goto L31
        L7b:
            java.util.Iterator r2 = (java.util.Iterator) r2
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L85
            r0 = 3
            goto L31
        L85:
            r0 = 7
            goto L31
        L87:
            com.facebook.ads.redexgen.X.9T r3 = (com.facebook.ads.redexgen.X.C9T) r3
            com.facebook.ads.redexgen.X.EV r6 = r3.A01
            com.facebook.ads.redexgen.X.9R r5 = new com.facebook.ads.redexgen.X.9R
            r5.<init>()
            com.facebook.ads.redexgen.X.EP r4 = new com.facebook.ads.redexgen.X.EP
            r2 = 7
            r1 = 36
            r0 = 74
            java.lang.String r3 = A00(r2, r1, r0)
            r2 = 0
            r1 = 7
            r0 = 11
            java.lang.String r0 = A00(r2, r1, r0)
            r4.<init>(r3, r0)
            r6.A0P(r5, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9T.A01():void");
    }

    private void A04(String str) {
        String.format(Locale.US, A00(91, 20, 127), str);
        ES es = new ES(str, -1, -1, A00(7, 36, 74), A00(0, 7, 11));
        es.A01 = A00(83, 8, 75);
        this.A01.A0Q(es);
    }

    private void A05(String str) {
        String.format(Locale.US, A00(111, 21, 73), str);
        EU eu = new EU(str, A00(7, 36, 74), A00(0, 7, 11));
        eu.A03 = true;
        eu.A01 = A00(83, 8, 75);
        this.A01.A0S(eu);
    }

    private void A06(String str) {
        String.format(Locale.US, A00(43, 20, 119), str);
        EU eu = new EU(str, A00(7, 36, 74), A00(0, 7, 11));
        eu.A03 = false;
        eu.A01 = A00(83, 8, 75);
        this.A01.A0V(eu);
    }
}
