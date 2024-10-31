package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Jq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0500Jq implements InterfaceC0497Jn {
    public static byte[] A03;
    public int A00;

    @Nullable
    public String A01;
    public final InterfaceC0497Jn A02;

    static {
        A02();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0500Jq.A03
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
            r0 = r0 ^ 88
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0500Jq.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A03 = new byte[]{80, 80, 94, 93};
    }

    public C0500Jq(InterfaceC0497Jn interfaceC0497Jn) {
        this.A02 = interfaceC0497Jn;
    }

    private void A01() {
        if (this.A01 != null) {
            this.A02.A7r(this.A01 + A00(0, 4, 38) + this.A00);
            this.A01 = null;
            this.A00 = 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0497Jn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A7r(java.lang.String r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = com.facebook.ads.redexgen.X.C0504Ju.A0B(r4)
            if (r0 == 0) goto L47
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L49;
                case 4: goto L29;
                case 5: goto L3d;
                case 6: goto L1b;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.Jq r2 = (com.facebook.ads.redexgen.X.C0500Jq) r2
            java.lang.String r4 = (java.lang.String) r4
            r2.A01()
            com.facebook.ads.redexgen.X.Jn r0 = r2.A02
            r0.A7r(r4)
            r0 = 3
            goto L9
        L1b:
            com.facebook.ads.redexgen.X.Jq r2 = (com.facebook.ads.redexgen.X.C0500Jq) r2
            java.lang.String r1 = (java.lang.String) r1
            r2.A01()
            r2.A01 = r1
            r0 = 1
            r2.A00 = r0
            r0 = 3
            goto L9
        L29:
            com.facebook.ads.redexgen.X.Jq r2 = (com.facebook.ads.redexgen.X.C0500Jq) r2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r1 = com.facebook.ads.redexgen.X.C0504Ju.A05(r4)
            java.lang.String r0 = r2.A01
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L3b
            r0 = 5
            goto L9
        L3b:
            r0 = 6
            goto L9
        L3d:
            com.facebook.ads.redexgen.X.Jq r2 = (com.facebook.ads.redexgen.X.C0500Jq) r2
            int r0 = r2.A00
            int r0 = r0 + 1
            r2.A00 = r0
            r0 = 3
            goto L9
        L47:
            r0 = 4
            goto L9
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0500Jq.A7r(java.lang.String):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0497Jn
    public final void flush() {
        A01();
        this.A02.flush();
    }
}
