package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class D6 implements InterfaceC0267Al {
    public static byte[] A01;
    public final /* synthetic */ D8 A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.D6.A01
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
            r0 = r0 ^ 89
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.D6.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{57, 47, 36, 57, 37, 56};
    }

    public D6(D8 d8) {
        this.A00 = d8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0095, code lost:            return r5;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0267Al
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.AbstractC0351Dr A44() throws java.lang.Exception {
        /*
            r9 = this;
            r2 = r9
            r3 = 0
            r4 = 0
            r5 = 0
            com.facebook.ads.redexgen.X.D8 r8 = r2.A00
            com.facebook.ads.redexgen.X.D8 r0 = r2.A00
            android.content.Context r7 = com.facebook.ads.redexgen.X.D8.A01(r0)
            r6 = 0
            r1 = 6
            r0 = 19
            java.lang.String r0 = A00(r6, r1, r0)
            java.lang.Object r0 = r7.getSystemService(r0)
            android.hardware.SensorManager r0 = (android.hardware.SensorManager) r0
            r8.A00 = r0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 20
            if (r1 >= r0) goto L8f
            r0 = 2
        L23:
            switch(r0) {
                case 2: goto L55;
                case 3: goto L91;
                case 4: goto L49;
                case 5: goto L3d;
                case 6: goto L27;
                case 7: goto L61;
                case 8: goto L6f;
                case 9: goto L83;
                default: goto L26;
            }
        L26:
            goto L23
        L27:
            com.facebook.ads.redexgen.X.D6 r2 = (com.facebook.ads.redexgen.X.D6) r2
            com.facebook.ads.redexgen.X.D8 r0 = r2.A00
            android.hardware.SensorManager r1 = r0.A00
            r0 = -1
            java.util.List r0 = r1.getSensorList(r0)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r4 = r0.iterator()
            r0 = 7
            goto L23
        L3d:
            com.facebook.ads.redexgen.X.D6 r2 = (com.facebook.ads.redexgen.X.D6) r2
            com.facebook.ads.redexgen.X.D8 r1 = r2.A00
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A06
            com.facebook.ads.redexgen.X.Dr r5 = r1.A07(r0)
            r0 = 3
            goto L23
        L49:
            com.facebook.ads.redexgen.X.D6 r2 = (com.facebook.ads.redexgen.X.D6) r2
            com.facebook.ads.redexgen.X.D8 r0 = r2.A00
            android.hardware.SensorManager r0 = r0.A00
            if (r0 != 0) goto L53
            r0 = 5
            goto L23
        L53:
            r0 = 6
            goto L23
        L55:
            com.facebook.ads.redexgen.X.D6 r2 = (com.facebook.ads.redexgen.X.D6) r2
            com.facebook.ads.redexgen.X.D8 r1 = r2.A00
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A04
            com.facebook.ads.redexgen.X.Dr r5 = r1.A07(r0)
            r0 = 3
            goto L23
        L61:
            java.util.Iterator r4 = (java.util.Iterator) r4
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L6c
            r0 = 8
            goto L23
        L6c:
            r0 = 9
            goto L23
        L6f:
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r1 = r4.next()
            android.hardware.Sensor r1 = (android.hardware.Sensor) r1
            com.facebook.ads.redexgen.X.D7 r0 = new com.facebook.ads.redexgen.X.D7
            r0.<init>(r1)
            r3.add(r0)
            r0 = 7
            goto L23
        L83:
            com.facebook.ads.redexgen.X.D6 r2 = (com.facebook.ads.redexgen.X.D6) r2
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            com.facebook.ads.redexgen.X.D8 r0 = r2.A00
            com.facebook.ads.redexgen.X.Dr r5 = r0.A0D(r3)
            r0 = 3
            goto L23
        L8f:
            r0 = 4
            goto L23
        L91:
            com.facebook.ads.redexgen.X.Dr r5 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r5
            com.facebook.ads.redexgen.X.Dr r5 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.D6.A44():com.facebook.ads.redexgen.X.Dr");
    }
}
