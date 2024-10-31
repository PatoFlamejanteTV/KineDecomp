package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

/* renamed from: com.facebook.ads.redexgen.X.3o, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00953o extends C3X {

    @VisibleForTesting
    public static final InterfaceC00933m A03 = new InterfaceC00933m() { // from class: com.facebook.ads.redexgen.X.3n
        @Override // com.facebook.ads.redexgen.X.InterfaceC00933m
        public final InterfaceC00913k A3n(final C00903j c00903j) {
            return new InterfaceC00913k() { // from class: com.facebook.ads.redexgen.X.3l
                @Override // com.facebook.ads.redexgen.X.InterfaceC00913k
                public final InterfaceC00963p A3m(final C3S c3s, final C3X c3x) {
                    final C0362Ec A05 = c00903j.A05();
                    final C00903j c00903j2 = c00903j;
                    return new InterfaceC00963p(A05, c00903j2, c3s, c3x) { // from class: com.facebook.ads.redexgen.X.3q
                        public static byte[] A04;
                        public final C3X A00;
                        public final C3S A01;
                        public final C00903j A02;
                        public final C0362Ec A03;

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
                                byte[] r1 = com.facebook.ads.redexgen.X.C00973q.A04
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
                                r0 = r0 ^ 44
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00973q.A00(int, int, int):java.lang.String");
                        }

                        public static void A01() {
                            A04 = new byte[]{105, 109, 110, 90, 75, 70, 74, 65, 76, 74, 97, 74, 91, 88, 64, 93, 68, 120, 93, 25, 86, 91, 83, 92, 90, 77, 25, 80, 74, 25, 87, 76, 85, 85, 43, 44, 54, 61, 39, 48, 48, 45, 48, 61, 33, 45, 38, 39, 61, 41, 39, 59, 123, 106, 115, 38, 49, 42, 32, 40, 33, 59, 33, 60, 48, 54, 37, 55, 59, 47, 33, 61, 60, 24, 2, 2, 24, 31, 22, 81, 19, 4, 31, 21, 29, 20, 81, 23, 30, 3, 81, 28, 20, 2, 2, 16, 22, 20, 95, 80, 87, 81, 92, 70, 81, 81, 76, 81, 92, 78, 70, 80, 80, 66, 68, 70, 92, 72, 70, 90, 79, 103, 113, 113, 99, 101, 103, 56, 34, 80, 83, 82, 91, 67, 85, 82, 74, 93, 80, 85, 88, 93, 72, 85, 83, 82, 67, 72, 85, 81, 89, 67, 87, 89, 69};
                        }

                        {
                            this.A03 = A05;
                            this.A02 = c00903j2;
                            this.A01 = c3s;
                            this.A00 = c3x;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:185:0x02be, code lost:            return;     */
                        @Override // com.facebook.ads.redexgen.X.InterfaceC00963p
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final void A54(android.os.Message r17) {
                            /*
                                Method dump skipped, instructions count: 822
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00973q.A54(android.os.Message):void");
                        }
                    };
                }
            };
        }
    };

    @Nullable
    public C00863f A00;
    public final C00903j A01;
    public final C0362Ec A02;

    public C00953o(C00903j c00903j) {
        super(c00903j.A05(), A03.A3n(c00903j));
        this.A01 = c00903j;
        this.A02 = c00903j.A05();
    }

    @Override // com.facebook.ads.redexgen.X.C3X
    public final void A04() {
        if (this.A00 != null) {
            this.A00.A0A();
        }
        super.A00.A8F(C3Y.A03);
    }

    public final void A06() {
        this.A00 = new C00863f(this.A01, this, super.A02);
        this.A00.A0B(this.A01.A0A(), this.A01.A06());
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A07(com.facebook.ads.InterstitialAd r3, java.util.EnumSet<com.facebook.ads.CacheFlag> r4, @android.support.annotation.Nullable java.lang.String r5) {
        /*
            r2 = this;
            r1 = r2
            com.facebook.ads.redexgen.X.3S r0 = r1.A00
            boolean r0 = r0.A45()
            if (r0 == 0) goto L41
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L43;
                case 3: goto Le;
                case 4: goto L1f;
                case 5: goto L2c;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.3o r1 = (com.facebook.ads.redexgen.X.C00953o) r1
            com.facebook.ads.InterstitialAd r3 = (com.facebook.ads.InterstitialAd) r3
            com.facebook.ads.redexgen.X.3j r0 = r1.A01
            r0.A0C(r3)
            com.facebook.ads.redexgen.X.3f r0 = r1.A00
            if (r0 == 0) goto L1d
            r0 = 4
            goto La
        L1d:
            r0 = 5
            goto La
        L1f:
            com.facebook.ads.redexgen.X.3o r1 = (com.facebook.ads.redexgen.X.C00953o) r1
            java.util.EnumSet r4 = (java.util.EnumSet) r4
            java.lang.String r5 = (java.lang.String) r5
            com.facebook.ads.redexgen.X.3f r0 = r1.A00
            r0.A0B(r4, r5)
            r0 = 2
            goto La
        L2c:
            com.facebook.ads.redexgen.X.3o r1 = (com.facebook.ads.redexgen.X.C00953o) r1
            java.util.EnumSet r4 = (java.util.EnumSet) r4
            java.lang.String r5 = (java.lang.String) r5
            com.facebook.ads.redexgen.X.3j r0 = r1.A01
            r0.A0J(r4)
            com.facebook.ads.redexgen.X.3j r0 = r1.A01
            r0.A0G(r5)
            r1.A06()
            r0 = 2
            goto La
        L41:
            r0 = 3
            goto La
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00953o.A07(com.facebook.ads.InterstitialAd, java.util.EnumSet, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0043, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A08() {
        /*
            r7 = this;
            r5 = r7
            r6 = 0
            com.facebook.ads.redexgen.X.3f r0 = r5.A00
            if (r0 == 0) goto L41
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L34;
                case 3: goto L43;
                case 4: goto L22;
                case 5: goto Le;
                case 6: goto Lb;
                case 7: goto L3e;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r6 = 1
            r0 = 3
            goto L7
        Le:
            com.facebook.ads.redexgen.X.3o r5 = (com.facebook.ads.redexgen.X.C00953o) r5
            long r3 = com.facebook.ads.redexgen.X.K4.A00()
            com.facebook.ads.redexgen.X.3j r0 = r5.A01
            long r1 = r0.A00()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L20
            r0 = 6
            goto L7
        L20:
            r0 = 7
            goto L7
        L22:
            com.facebook.ads.redexgen.X.3o r5 = (com.facebook.ads.redexgen.X.C00953o) r5
            com.facebook.ads.redexgen.X.3j r0 = r5.A01
            long r3 = r0.A00()
            r1 = 0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L32
            r0 = 5
            goto L7
        L32:
            r0 = 7
            goto L7
        L34:
            com.facebook.ads.redexgen.X.3o r5 = (com.facebook.ads.redexgen.X.C00953o) r5
            com.facebook.ads.redexgen.X.3f r0 = r5.A00
            boolean r6 = r0.A0C()
            r0 = 3
            goto L7
        L3e:
            r6 = 0
            r0 = 3
            goto L7
        L41:
            r0 = 4
            goto L7
        L43:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00953o.A08():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x002d, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A09() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.3f r0 = r3.A00
            if (r0 == 0) goto L2b
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L2d;
                case 4: goto L15;
                case 5: goto L25;
                case 6: goto L28;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.3o r3 = (com.facebook.ads.redexgen.X.C00953o) r3
            com.facebook.ads.redexgen.X.3f r0 = r3.A00
            boolean r2 = r0.A0D()
            r0 = 3
            goto L7
        L15:
            com.facebook.ads.redexgen.X.3o r3 = (com.facebook.ads.redexgen.X.C00953o) r3
            com.facebook.ads.redexgen.X.3S r0 = r3.A00
            com.facebook.ads.redexgen.X.3Y r1 = r0.A4G()
            com.facebook.ads.redexgen.X.3Y r0 = com.facebook.ads.redexgen.X.C3Y.A05
            if (r1 != r0) goto L23
            r0 = 5
            goto L7
        L23:
            r0 = 6
            goto L7
        L25:
            r2 = 1
            r0 = 3
            goto L7
        L28:
            r2 = 0
            r0 = 3
            goto L7
        L2b:
            r0 = 4
            goto L7
        L2d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00953o.A09():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0A(com.facebook.ads.InterstitialAd r6, com.facebook.ads.InterstitialAd.InterstitialShowAdConfig r7) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r3 = 0
            com.facebook.ads.redexgen.X.3S r0 = r4.A00
            boolean r0 = r0.A46()
            if (r0 == 0) goto L3f
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L41;
                case 3: goto L2e;
                case 4: goto L10;
                case 5: goto L1a;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.3o r4 = (com.facebook.ads.redexgen.X.C00953o) r4
            com.facebook.ads.redexgen.X.3f r0 = r4.A00
            boolean r3 = r0.A0E()
            r0 = 2
            goto Lc
        L1a:
            com.facebook.ads.redexgen.X.3o r4 = (com.facebook.ads.redexgen.X.C00953o) r4
            com.facebook.ads.redexgen.X.3f r2 = new com.facebook.ads.redexgen.X.3f
            com.facebook.ads.redexgen.X.3j r1 = r4.A01
            java.lang.String r0 = r4.A02
            r2.<init>(r1, r4, r0)
            r4.A00 = r2
            com.facebook.ads.redexgen.X.3f r0 = r4.A00
            r0.A0E()
            r0 = 2
            goto Lc
        L2e:
            com.facebook.ads.redexgen.X.3o r4 = (com.facebook.ads.redexgen.X.C00953o) r4
            com.facebook.ads.InterstitialAd r6 = (com.facebook.ads.InterstitialAd) r6
            com.facebook.ads.redexgen.X.3j r0 = r4.A01
            r0.A0C(r6)
            com.facebook.ads.redexgen.X.3f r0 = r4.A00
            if (r0 == 0) goto L3d
            r0 = 4
            goto Lc
        L3d:
            r0 = 5
            goto Lc
        L3f:
            r0 = 3
            goto Lc
        L41:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00953o.A0A(com.facebook.ads.InterstitialAd, com.facebook.ads.InterstitialAd$InterstitialShowAdConfig):boolean");
    }
}
