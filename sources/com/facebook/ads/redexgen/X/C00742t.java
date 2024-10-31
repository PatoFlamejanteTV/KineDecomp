package com.facebook.ads.redexgen.X;

import java.util.List;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.2t, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00742t {
    public static byte[] A0C;
    public C1M A00;
    public C2I A01;
    public EV A02;
    public String A03;
    public String A04;
    public List<C00692o> A05;
    public List<C00702p> A06;
    public List<C00712q> A07;
    public List<C00692o> A08;
    public List<C00702p> A09;
    public List<C00712q> A0A;
    public boolean A0B;

    static {
        A05();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C00742t.A0C
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
            r0 = r0 ^ 85
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00742t.A01(int, int, int):java.lang.String");
    }

    public static void A05() {
        A0C = new byte[]{77, 79, 77, 70, 75, 113, 67, 79, 64, 74, 79, 90, 65, 92, 87, 113, 71, 67, 79, 73, 75, 93, 45, 47, 45, 38, 43, 17, 35, 47, 32, 42, 47, 58, 33, 60, 55, 17, 56, 39, 42, 43, 33, 61, 28, 59, 35, 52, 57, 60, 49, 117, 22, 52, 54, 61, 48, 29, 48, 57, 37, 48, 39, 117, 60, 38, 117, 33, 39, 44, 60, 59, 50, 117, 33, 58, 117, 54, 52, 54, 61, 48, 117, 52, 38, 38, 48, 33, 38, 82, 80, 82, 89, 84, 110, 92, 80, 95, 85, 80, 69, 94, 67, 72, 110, 87, 88, 93, 84, 66};
    }

    public C00742t(C1M c1m, C2I c2i, String str, EV ev) {
        this.A01 = c2i;
        if (!A08()) {
            this.A0B = false;
            return;
        }
        this.A0B = true;
        JSONObject A0W = this.A01.A0W();
        this.A00 = c1m;
        try {
            this.A06 = C00722r.A05(A0W);
            this.A07 = C00722r.A06(A0W);
            this.A05 = C00722r.A04(A0W);
            this.A09 = C00722r.A08(A0W);
            this.A0A = C00722r.A09(A0W);
            this.A08 = C00722r.A07(A0W);
        } catch (IllegalStateException unused) {
            this.A00.A6I();
        }
        this.A04 = c2i.A0T();
        this.A03 = str;
        this.A02 = ev;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e6, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02() {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00742t.A02():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e5, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A03() {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00742t.A03():void");
    }

    private void A04() {
        this.A02.A0P(new C1Z() { // from class: com.facebook.ads.redexgen.X.2s
            @Override // com.facebook.ads.redexgen.X.C1Z
            public final void A6I() {
                C1M c1m;
                c1m = C00742t.this.A00;
                c1m.A6I();
            }

            @Override // com.facebook.ads.redexgen.X.C1Z
            public final void A6P() {
                C1M c1m;
                c1m = C00742t.this.A00;
                c1m.A6H();
            }
        }, new EP(this.A04, this.A03));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A06(java.lang.String r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.2I r0 = r2.A01
            if (r0 == 0) goto L1e
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L20;
                case 4: goto L1b;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.2t r2 = (com.facebook.ads.redexgen.X.C00742t) r2
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.redexgen.X.2I r0 = r2.A01
            org.json.JSONObject r0 = r0.A0W()
            boolean r1 = r0.has(r4)
            r0 = 3
            goto L7
        L1b:
            r1 = 0
            r0 = 3
            goto L7
        L1e:
            r0 = 4
            goto L7
        L20:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00742t.A06(java.lang.String):boolean");
    }

    public final void A07() {
        if (!A08()) {
            throw new IllegalStateException(A01(44, 45, 0));
        }
        A02();
        A03();
        A04();
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x007b, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A08() {
        /*
            r6 = this;
            r4 = r6
            r3 = 0
            r5 = 0
            com.facebook.ads.redexgen.X.2I r0 = r4.A01
            if (r0 == 0) goto L78
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L64;
                case 3: goto L57;
                case 4: goto L41;
                case 5: goto L2a;
                case 6: goto Lc;
                case 7: goto L74;
                case 8: goto L7b;
                case 9: goto L60;
                case 10: goto L23;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.2t r4 = (com.facebook.ads.redexgen.X.C00742t) r4
            r2 = 89
            r1 = 21
            r0 = 100
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r4.A06(r0)
            if (r0 == 0) goto L20
            r0 = 7
            goto L8
        L20:
            r0 = 9
            goto L8
        L23:
            com.facebook.ads.redexgen.X.2t r4 = (com.facebook.ads.redexgen.X.C00742t) r4
            boolean r3 = r4.A0B
            r0 = 8
            goto L8
        L2a:
            com.facebook.ads.redexgen.X.2t r4 = (com.facebook.ads.redexgen.X.C00742t) r4
            r2 = 22
            r1 = 22
            r0 = 27
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r4.A06(r0)
            if (r0 == 0) goto L3e
            r0 = 6
            goto L8
        L3e:
            r0 = 9
            goto L8
        L41:
            com.facebook.ads.redexgen.X.2t r4 = (com.facebook.ads.redexgen.X.C00742t) r4
            r2 = 0
            r1 = 22
            r0 = 123(0x7b, float:1.72E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r4.A06(r0)
            if (r0 == 0) goto L54
            r0 = 5
            goto L8
        L54:
            r0 = 9
            goto L8
        L57:
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            if (r5 == 0) goto L5d
            r0 = 4
            goto L8
        L5d:
            r0 = 9
            goto L8
        L60:
            r3 = 0
            r0 = 8
            goto L8
        L64:
            com.facebook.ads.redexgen.X.2t r4 = (com.facebook.ads.redexgen.X.C00742t) r4
            com.facebook.ads.redexgen.X.2I r0 = r4.A01
            org.json.JSONObject r5 = r0.A0W()
            boolean r0 = r4.A0B
            if (r0 != 0) goto L72
            r0 = 3
            goto L8
        L72:
            r0 = 7
            goto L8
        L74:
            r3 = 1
            r0 = 8
            goto L8
        L78:
            r0 = 10
            goto L8
        L7b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00742t.A08():boolean");
    }
}
