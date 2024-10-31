package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Dh, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0341Dh implements InterfaceC0267Al {
    public static byte[] A01;
    public final /* synthetic */ C0342Di A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0341Dh.A01
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
            r0 = r0 ^ 78
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0341Dh.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{24, 20, 21, 21, 30, 24, 15, 30, 31, 91, 84, 94, 72, 85, 83, 94, 20, 82, 91, 72, 94, 77, 91, 72, 95, 20, 79, 73, 88, 20, 91, 89, 78, 83, 85, 84, 20, 111, 105, 120, 101, 105, 110, 123, 110, Byte.MAX_VALUE};
    }

    public C0341Dh(C0342Di c0342Di) {
        this.A00 = c0342Di;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:            return r8;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0267Al
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.AbstractC0351Dr A44() {
        /*
            r9 = this;
            r7 = r9
            r0 = 0
            r0 = 0
            r8 = 0
            r6 = 0
            r5 = 0
            com.facebook.ads.redexgen.X.Di r0 = r7.A00
            android.content.Context r4 = com.facebook.ads.redexgen.X.C0342Di.A01(r0)
            android.content.IntentFilter r3 = new android.content.IntentFilter
            r2 = 9
            r1 = 37
            r0 = 116(0x74, float:1.63E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            r3.<init>(r0)
            android.content.Intent r4 = r4.registerReceiver(r5, r3)
            if (r4 == 0) goto L5a
            r0 = 2
        L22:
            switch(r0) {
                case 2: goto L4f;
                case 3: goto L26;
                case 4: goto L38;
                case 5: goto L5c;
                case 6: goto L2c;
                case 7: goto L57;
                default: goto L25;
            }
        L25:
            goto L22
        L26:
            if (r6 == 0) goto L2a
            r0 = 4
            goto L22
        L2a:
            r0 = 6
            goto L22
        L2c:
            com.facebook.ads.redexgen.X.Dh r7 = (com.facebook.ads.redexgen.X.C0341Dh) r7
            com.facebook.ads.redexgen.X.Di r1 = r7.A00
            com.facebook.ads.redexgen.X.E5 r0 = com.facebook.ads.redexgen.X.E5.A06
            com.facebook.ads.redexgen.X.Dr r8 = r1.A07(r0)
            r0 = 5
            goto L22
        L38:
            com.facebook.ads.redexgen.X.Dh r7 = (com.facebook.ads.redexgen.X.C0341Dh) r7
            com.facebook.ads.redexgen.X.Di r3 = r7.A00
            r2 = 0
            r1 = 9
            r0 = 53
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r6.getBoolean(r0)
            com.facebook.ads.redexgen.X.Dr r8 = r3.A0F(r0)
            r0 = 5
            goto L22
        L4f:
            android.content.Intent r4 = (android.content.Intent) r4
            android.os.Bundle r6 = r4.getExtras()
            r0 = 3
            goto L22
        L57:
            r6 = r5
            r0 = 3
            goto L22
        L5a:
            r0 = 7
            goto L22
        L5c:
            com.facebook.ads.redexgen.X.Dr r8 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r8
            com.facebook.ads.redexgen.X.Dr r8 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0341Dh.A44():com.facebook.ads.redexgen.X.Dr");
    }
}
