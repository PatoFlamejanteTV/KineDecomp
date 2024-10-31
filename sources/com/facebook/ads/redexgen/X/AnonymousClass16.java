package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.16, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class AnonymousClass16 extends AnonymousClass11 {
    public static byte[] A02;
    public final C1E A00;
    public final boolean A01;

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
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass16.A02
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
            int r0 = r0 + (-29)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass16.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A02 = new byte[]{-110, -111, -109, -101, -113, -92, -103, -99, -107, -62, -21, -24, -30, -22, -97, -21, -18, -26, -26, -28, -29, -112, -119, -123, -102, -119, -125, -104, -115, -111, -119, -50, -44, -45, -62, -50, -52, -60};
    }

    public abstract void A0B();

    public AnonymousClass16(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, String str, @Nullable C1E c1e, boolean z) {
        super(c0362Ec, interfaceC0422Gl, str);
        this.A00 = c1e;
        this.A01 = z;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
    public final void A03() {
        if (this.A00 != null) {
            this.A00.A07(this.A02);
        }
        A0B();
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a8, code lost:            com.facebook.ads.redexgen.X.JP.A02(((com.facebook.ads.redexgen.X.AnonymousClass11) r3).A00, A00(9, 12, 98));     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b9, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0C(java.util.Map<java.lang.String, java.lang.String> r9, @android.support.annotation.Nullable com.facebook.ads.redexgen.X.AnonymousClass10 r10) {
        /*
            r8 = this;
            r3 = r8
            r0 = 0
            r7 = 0
            r5 = -1
            java.lang.String r0 = r3.A02
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto La5
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L49;
                case 3: goto L2b;
                case 4: goto L38;
                case 5: goto L1c;
                case 6: goto L13;
                case 7: goto La8;
                case 8: goto L54;
                case 9: goto L97;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.16 r3 = (com.facebook.ads.redexgen.X.AnonymousClass16) r3
            com.facebook.ads.redexgen.X.1E r0 = r3.A00
            r0.A05()
            r0 = 7
            goto Lf
        L1c:
            com.facebook.ads.redexgen.X.16 r3 = (com.facebook.ads.redexgen.X.AnonymousClass16) r3
            com.facebook.ads.redexgen.X.10 r10 = (com.facebook.ads.redexgen.X.AnonymousClass10) r10
            com.facebook.ads.redexgen.X.1E r0 = r3.A00
            r0.A06(r10)
            if (r7 == 0) goto L29
            r0 = 6
            goto Lf
        L29:
            r0 = 7
            goto Lf
        L2b:
            com.facebook.ads.redexgen.X.16 r3 = (com.facebook.ads.redexgen.X.AnonymousClass16) r3
            java.util.Map r9 = (java.util.Map) r9
            com.facebook.ads.redexgen.X.Gl r1 = r3.A01
            java.lang.String r0 = r3.A02
            r1.A5p(r0, r9)
            r0 = 4
            goto Lf
        L38:
            com.facebook.ads.redexgen.X.16 r3 = (com.facebook.ads.redexgen.X.AnonymousClass16) r3
            com.facebook.ads.redexgen.X.10 r10 = (com.facebook.ads.redexgen.X.AnonymousClass10) r10
            boolean r7 = com.facebook.ads.redexgen.X.AnonymousClass10.A02(r10)
            com.facebook.ads.redexgen.X.1E r0 = r3.A00
            if (r0 == 0) goto L46
            r0 = 5
            goto Lf
        L46:
            r0 = 8
            goto Lf
        L49:
            com.facebook.ads.redexgen.X.16 r3 = (com.facebook.ads.redexgen.X.AnonymousClass16) r3
            boolean r0 = r3 instanceof com.facebook.ads.redexgen.X.AnonymousClass17
            if (r0 == 0) goto L51
            r0 = 3
            goto Lf
        L51:
            r0 = 9
            goto Lf
        L54:
            com.facebook.ads.redexgen.X.16 r3 = (com.facebook.ads.redexgen.X.AnonymousClass16) r3
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r2 = 21
            r1 = 10
            r0 = 7
            java.lang.String r1 = A00(r2, r1, r0)
            java.lang.String r0 = java.lang.Long.toString(r5)
            r4.put(r1, r0)
            r2 = 0
            r1 = 9
            r0 = 19
            java.lang.String r1 = A00(r2, r1, r0)
            java.lang.String r0 = java.lang.Long.toString(r5)
            r4.put(r1, r0)
            r2 = 31
            r1 = 7
            r0 = 66
            java.lang.String r1 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.X.10 r0 = com.facebook.ads.redexgen.X.AnonymousClass10.A03
            java.lang.String r0 = r0.name()
            r4.put(r1, r0)
            com.facebook.ads.redexgen.X.Gl r1 = r3.A01
            java.lang.String r0 = r3.A02
            r1.A5s(r0, r4)
            r0 = 7
            goto Lf
        L97:
            com.facebook.ads.redexgen.X.16 r3 = (com.facebook.ads.redexgen.X.AnonymousClass16) r3
            java.util.Map r9 = (java.util.Map) r9
            com.facebook.ads.redexgen.X.Gl r1 = r3.A01
            java.lang.String r0 = r3.A02
            r1.A5c(r0, r9)
            r0 = 4
            goto Lf
        La5:
            r0 = 7
            goto Lf
        La8:
            com.facebook.ads.redexgen.X.16 r3 = (com.facebook.ads.redexgen.X.AnonymousClass16) r3
            com.facebook.ads.redexgen.X.Ec r3 = r3.A00
            r2 = 9
            r1 = 12
            r0 = 98
            java.lang.String r0 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.X.JP.A02(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass16.A0C(java.util.Map, com.facebook.ads.redexgen.X.10):void");
    }
}
