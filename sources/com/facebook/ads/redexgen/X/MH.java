package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class MH extends AbstractC02238s {
    public static byte[] A01;
    public final /* synthetic */ ML A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.MH.A01
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
            r0 = r0 ^ 61
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.MH.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{114, 109, 96, 97, 107, 77, 106, 112, 97, 118, 119, 112, 109, 112, 101, 104, 65, 114, 97, 106, 112};
    }

    public MH(ML ml) {
        this.A00 = ml;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C1S
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A03(QM qm) {
        AnonymousClass81 anonymousClass81;
        anonymousClass81 = this.A00.A04;
        anonymousClass81.A3c(A00(0, 21, 57), qm);
    }
}
