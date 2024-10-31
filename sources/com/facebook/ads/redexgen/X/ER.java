package com.facebook.ads.redexgen.X;

import java.util.concurrent.Callable;

/* loaded from: assets/audience_network.dex */
public class ER implements Callable<Boolean> {
    public static byte[] A02;
    public final EU A00;
    public final /* synthetic */ EV A01;

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.ER.A02
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
            r0 = r0 ^ 37
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ER.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{71, 88, 85, 84, 94, 14, 2, 17, 8, 22, 19};
    }

    public ER(EV ev, EU eu) {
        this.A01 = ev;
        this.A00 = eu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a1, code lost:            return java.lang.Boolean.valueOf(r4);     */
    @Override // java.util.concurrent.Callable
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean call() {
        /*
            r12 = this;
            r3 = r12
            r4 = 0
            r5 = 0
            r9 = 0
            com.facebook.ads.redexgen.X.EU r0 = r3.A00
            boolean r0 = r0.A03
            if (r0 == 0) goto L97
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L2f;
                case 3: goto L4a;
                case 4: goto L39;
                case 5: goto L12;
                case 6: goto Lf;
                case 7: goto L9b;
                case 8: goto L89;
                case 9: goto L8c;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            r4 = 1
            r0 = 7
            goto Lb
        L12:
            com.facebook.ads.redexgen.X.ER r3 = (com.facebook.ads.redexgen.X.ER) r3
            com.facebook.ads.redexgen.X.08 r5 = (com.facebook.ads.redexgen.X.AnonymousClass08) r5
            com.facebook.ads.redexgen.X.EV r0 = r3.A01
            com.facebook.ads.redexgen.X.Eb r0 = com.facebook.ads.redexgen.X.EV.A07(r0)
            com.facebook.ads.redexgen.X.Ef r0 = r0.A00()
            com.facebook.ads.redexgen.X.02 r0 = com.facebook.ads.redexgen.X.EV.A03(r0)
            java.lang.String r0 = r0.A8C(r5)
            if (r0 == 0) goto L2c
            r0 = 6
            goto Lb
        L2c:
            r0 = 8
            goto Lb
        L2f:
            r2 = 5
            r1 = 6
            r0 = 70
            java.lang.String r9 = A01(r2, r1, r0)
            r0 = 3
            goto Lb
        L39:
            com.facebook.ads.redexgen.X.ER r3 = (com.facebook.ads.redexgen.X.ER) r3
            com.facebook.ads.redexgen.X.08 r5 = (com.facebook.ads.redexgen.X.AnonymousClass08) r5
            java.util.Map r1 = com.facebook.ads.redexgen.X.EV.A09()
            com.facebook.ads.redexgen.X.EU r0 = r3.A00
            java.lang.String r0 = r0.A07
            r1.put(r0, r5)
            r0 = 5
            goto Lb
        L4a:
            com.facebook.ads.redexgen.X.ER r3 = (com.facebook.ads.redexgen.X.ER) r3
            java.lang.String r9 = (java.lang.String) r9
            com.facebook.ads.redexgen.X.08 r5 = new com.facebook.ads.redexgen.X.08
            com.facebook.ads.redexgen.X.EU r0 = r3.A00
            java.lang.String r6 = r0.A07
            com.facebook.ads.redexgen.X.EU r0 = r3.A00
            java.lang.String r7 = r0.A06
            com.facebook.ads.redexgen.X.EU r0 = r3.A00
            java.lang.String r8 = r0.A05
            com.facebook.ads.redexgen.X.EU r0 = r3.A00
            java.lang.String r10 = r0.A01
            com.facebook.ads.redexgen.X.EU r0 = r3.A00
            boolean r11 = r0.A04
            r5.<init>(r6, r7, r8, r9, r10, r11)
            com.facebook.ads.redexgen.X.EU r0 = r3.A00
            java.lang.String r0 = r0.A02
            r5.A04 = r0
            com.facebook.ads.redexgen.X.EU r0 = r3.A00
            java.lang.Integer r0 = r0.A00
            r5.A02 = r0
            com.facebook.ads.redexgen.X.EU r0 = r3.A00
            boolean r0 = r0.A03
            r5.A05 = r0
            com.facebook.ads.redexgen.X.EV r0 = r3.A01
            com.facebook.ads.redexgen.X.Eb r0 = com.facebook.ads.redexgen.X.EV.A07(r0)
            boolean r0 = com.facebook.ads.redexgen.X.EY.A06(r0)
            if (r0 == 0) goto L87
            r0 = 4
            goto Lb
        L87:
            r0 = 5
            goto Lb
        L89:
            r4 = 0
            r0 = 7
            goto Lb
        L8c:
            r2 = 0
            r1 = 5
            r0 = 20
            java.lang.String r9 = A01(r2, r1, r0)
            r0 = 3
            goto Lb
        L97:
            r0 = 9
            goto Lb
        L9b:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ER.call():java.lang.Boolean");
    }
}
