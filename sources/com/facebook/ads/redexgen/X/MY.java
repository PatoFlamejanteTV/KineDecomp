package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: assets/audience_network.dex */
public class MY implements MX {
    public static byte[] A01;
    public final /* synthetic */ MZ A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.MY.A01
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
            r0 = r0 ^ 68
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.MY.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{93, 81, 83, 16, 88, 95, 93, 91, 92, 81, 81, 85, 16, 95, 90, 77, 16, 95, 90, 76, 91, 78, 81, 76, 74, 87, 80, 89, 16, 120, 119, 112, 119, 109, 118, 97, Byte.MAX_VALUE, 122, 97, 108, 123, 110, 113, 108, 106, 119, 112, 121, 97, 120, 114, 113, 105};
    }

    public MY(MZ mz) {
        this.A00 = mz;
    }

    @Override // com.facebook.ads.redexgen.X.MX
    public final void A3g() {
        AnonymousClass81 anonymousClass81;
        AnonymousClass81 anonymousClass812;
        anonymousClass81 = this.A00.A06;
        if (anonymousClass81 == null) {
            return;
        }
        anonymousClass812 = this.A00.A06;
        anonymousClass812.A3b(A00(0, 53, 122));
    }

    @Override // com.facebook.ads.redexgen.X.MX
    public final void A3h() {
        InterfaceC0524Ko interfaceC0524Ko;
        InterfaceC0524Ko interfaceC0524Ko2;
        this.A00.A0L();
        interfaceC0524Ko = this.A00.A07;
        if (interfaceC0524Ko != null) {
            interfaceC0524Ko2 = this.A00.A07;
            interfaceC0524Ko2.A7O(true);
        }
        this.A00.A0A();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.MX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A52() {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.MZ r0 = r2.A00
            com.facebook.ads.redexgen.X.46 r0 = com.facebook.ads.redexgen.X.MZ.A05(r0)
            if (r0 != 0) goto L48
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L4a;
                case 4: goto L15;
                case 5: goto L2c;
                case 6: goto L35;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.MY r2 = (com.facebook.ads.redexgen.X.MY) r2
            r2.A3h()
            r0 = 3
            goto La
        L15:
            com.facebook.ads.redexgen.X.MY r2 = (com.facebook.ads.redexgen.X.MY) r2
            com.facebook.ads.redexgen.X.MZ r0 = r2.A00
            com.facebook.ads.redexgen.X.MZ.A01(r0)
            com.facebook.ads.redexgen.X.MZ r0 = r2.A00
            com.facebook.ads.redexgen.X.46 r0 = com.facebook.ads.redexgen.X.MZ.A05(r0)
            com.facebook.ads.redexgen.X.46 r0 = r0.A02()
            if (r0 != 0) goto L2a
            r0 = 5
            goto La
        L2a:
            r0 = 6
            goto La
        L2c:
            com.facebook.ads.redexgen.X.MY r2 = (com.facebook.ads.redexgen.X.MY) r2
            com.facebook.ads.redexgen.X.MZ r0 = r2.A00
            com.facebook.ads.redexgen.X.MZ.A0E(r0)
            r0 = 3
            goto La
        L35:
            com.facebook.ads.redexgen.X.MY r2 = (com.facebook.ads.redexgen.X.MY) r2
            com.facebook.ads.redexgen.X.MZ r1 = r2.A00
            com.facebook.ads.redexgen.X.MZ r0 = r2.A00
            com.facebook.ads.redexgen.X.46 r0 = com.facebook.ads.redexgen.X.MZ.A05(r0)
            com.facebook.ads.redexgen.X.46 r0 = r0.A02()
            com.facebook.ads.redexgen.X.MZ.A0G(r1, r0)
            r0 = 3
            goto La
        L48:
            r0 = 4
            goto La
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.MY.A52():void");
    }

    @Override // com.facebook.ads.redexgen.X.MX
    public final void A5J() {
        C0362Ec c0362Ec;
        AnonymousClass45 anonymousClass45;
        C0362Ec c0362Ec2;
        C0362Ec c0362Ec3;
        String str;
        c0362Ec = this.A00.A04;
        if (!TextUtils.isEmpty(AnonymousClass43.A0C(c0362Ec.A00()))) {
            JM jm = new JM();
            c0362Ec2 = this.A00.A04;
            c0362Ec3 = this.A00.A04;
            Uri parse = Uri.parse(AnonymousClass43.A0C(c0362Ec3.A00()));
            str = this.A00.A08;
            JM.A08(jm, c0362Ec2, parse, str);
        }
        anonymousClass45 = this.A00.A02;
        anonymousClass45.A04();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:            r4 = r4;        r0 = r4.A00.A02;        r0.A06();        r4.A00.A0A();     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0077, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.MX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A5K() {
        /*
            r5 = this;
            r4 = r5
            com.facebook.ads.redexgen.X.MZ r0 = r4.A00
            r0.A0L()
            com.facebook.ads.redexgen.X.MZ r0 = r4.A00
            com.facebook.ads.redexgen.X.Ko r0 = com.facebook.ads.redexgen.X.MZ.A08(r0)
            if (r0 == 0) goto L65
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L13;
                case 3: goto L21;
                case 4: goto L3b;
                case 5: goto L67;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.MY r4 = (com.facebook.ads.redexgen.X.MY) r4
            com.facebook.ads.redexgen.X.MZ r0 = r4.A00
            com.facebook.ads.redexgen.X.Ko r1 = com.facebook.ads.redexgen.X.MZ.A08(r0)
            r0 = 1
            r1.A7O(r0)
            r0 = 3
            goto Lf
        L21:
            com.facebook.ads.redexgen.X.MY r4 = (com.facebook.ads.redexgen.X.MY) r4
            com.facebook.ads.redexgen.X.MZ r0 = r4.A00
            com.facebook.ads.redexgen.X.Ec r0 = com.facebook.ads.redexgen.X.MZ.A06(r0)
            com.facebook.ads.redexgen.X.Ef r0 = r0.A00()
            java.lang.String r0 = com.facebook.ads.redexgen.X.AnonymousClass43.A06(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L39
            r0 = 4
            goto Lf
        L39:
            r0 = 5
            goto Lf
        L3b:
            com.facebook.ads.redexgen.X.MY r4 = (com.facebook.ads.redexgen.X.MY) r4
            com.facebook.ads.redexgen.X.JM r3 = new com.facebook.ads.redexgen.X.JM
            r3.<init>()
            com.facebook.ads.redexgen.X.MZ r0 = r4.A00
            com.facebook.ads.redexgen.X.Ec r2 = com.facebook.ads.redexgen.X.MZ.A06(r0)
            com.facebook.ads.redexgen.X.MZ r0 = r4.A00
            com.facebook.ads.redexgen.X.Ec r0 = com.facebook.ads.redexgen.X.MZ.A06(r0)
            com.facebook.ads.redexgen.X.Ef r0 = r0.A00()
            java.lang.String r0 = com.facebook.ads.redexgen.X.AnonymousClass43.A06(r0)
            android.net.Uri r1 = android.net.Uri.parse(r0)
            com.facebook.ads.redexgen.X.MZ r0 = r4.A00
            java.lang.String r0 = com.facebook.ads.redexgen.X.MZ.A09(r0)
            com.facebook.ads.redexgen.X.JM.A08(r3, r2, r1, r0)
            r0 = 5
            goto Lf
        L65:
            r0 = 3
            goto Lf
        L67:
            com.facebook.ads.redexgen.X.MY r4 = (com.facebook.ads.redexgen.X.MY) r4
            com.facebook.ads.redexgen.X.MZ r0 = r4.A00
            com.facebook.ads.redexgen.X.45 r0 = com.facebook.ads.redexgen.X.MZ.A04(r0)
            r0.A06()
            com.facebook.ads.redexgen.X.MZ r0 = r4.A00
            com.facebook.ads.redexgen.X.MZ.A0F(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.MY.A5K():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:            r3.A00.A0D(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.MX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A74(com.facebook.ads.redexgen.X.AnonymousClass44 r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.MZ r0 = r3.A00
            com.facebook.ads.redexgen.X.MZ.A00(r0)
            com.facebook.ads.redexgen.X.MZ r0 = r3.A00
            com.facebook.ads.redexgen.X.MZ.A03(r0, r5)
            com.facebook.ads.redexgen.X.MZ r0 = r3.A00
            com.facebook.ads.redexgen.X.44 r1 = com.facebook.ads.redexgen.X.MZ.A02(r0)
            com.facebook.ads.redexgen.X.44 r0 = com.facebook.ads.redexgen.X.AnonymousClass44.A03
            if (r1 != r0) goto L3f
            r0 = 2
        L17:
            switch(r0) {
                case 2: goto L1b;
                case 3: goto L41;
                case 4: goto L2d;
                default: goto L1a;
            }
        L1a:
            goto L17
        L1b:
            com.facebook.ads.redexgen.X.MY r3 = (com.facebook.ads.redexgen.X.MY) r3
            com.facebook.ads.redexgen.X.MZ r0 = r3.A00
            com.facebook.ads.redexgen.X.Ec r0 = com.facebook.ads.redexgen.X.MZ.A06(r0)
            com.facebook.ads.redexgen.X.Ef r0 = r0.A00()
            com.facebook.ads.redexgen.X.46 r2 = com.facebook.ads.redexgen.X.AnonymousClass43.A03(r0)
            r0 = 3
            goto L17
        L2d:
            com.facebook.ads.redexgen.X.MY r3 = (com.facebook.ads.redexgen.X.MY) r3
            com.facebook.ads.redexgen.X.MZ r0 = r3.A00
            com.facebook.ads.redexgen.X.Ec r0 = com.facebook.ads.redexgen.X.MZ.A06(r0)
            com.facebook.ads.redexgen.X.Ef r0 = r0.A00()
            com.facebook.ads.redexgen.X.46 r2 = com.facebook.ads.redexgen.X.AnonymousClass43.A04(r0)
            r0 = 3
            goto L17
        L3f:
            r0 = 4
            goto L17
        L41:
            com.facebook.ads.redexgen.X.MY r3 = (com.facebook.ads.redexgen.X.MY) r3
            com.facebook.ads.redexgen.X.46 r2 = (com.facebook.ads.redexgen.X.AnonymousClass46) r2
            com.facebook.ads.redexgen.X.MZ r0 = r3.A00
            com.facebook.ads.redexgen.X.MZ.A0G(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.MY.A74(com.facebook.ads.redexgen.X.44):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.MX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A7B(com.facebook.ads.redexgen.X.AnonymousClass46 r4) {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.MZ r0 = r2.A00
            com.facebook.ads.redexgen.X.MZ.A00(r0)
            com.facebook.ads.redexgen.X.MZ r0 = r2.A00
            com.facebook.ads.redexgen.X.45 r1 = com.facebook.ads.redexgen.X.MZ.A04(r0)
            int r0 = r4.A01()
            r1.A07(r0)
            java.util.List r0 = r4.A05()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L38
            r0 = 2
        L1e:
            switch(r0) {
                case 2: goto L22;
                case 3: goto L3a;
                case 4: goto L2d;
                default: goto L21;
            }
        L21:
            goto L1e
        L22:
            com.facebook.ads.redexgen.X.MY r2 = (com.facebook.ads.redexgen.X.MY) r2
            com.facebook.ads.redexgen.X.46 r4 = (com.facebook.ads.redexgen.X.AnonymousClass46) r4
            com.facebook.ads.redexgen.X.MZ r0 = r2.A00
            com.facebook.ads.redexgen.X.MZ.A0H(r0, r4)
            r0 = 3
            goto L1e
        L2d:
            com.facebook.ads.redexgen.X.MY r2 = (com.facebook.ads.redexgen.X.MY) r2
            com.facebook.ads.redexgen.X.46 r4 = (com.facebook.ads.redexgen.X.AnonymousClass46) r4
            com.facebook.ads.redexgen.X.MZ r0 = r2.A00
            com.facebook.ads.redexgen.X.MZ.A0G(r0, r4)
            r0 = 3
            goto L1e
        L38:
            r0 = 4
            goto L1e
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.MY.A7B(com.facebook.ads.redexgen.X.46):void");
    }
}
