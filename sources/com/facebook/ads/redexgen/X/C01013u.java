package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import com.facebook.ads.RewardData;

/* renamed from: com.facebook.ads.redexgen.X.3u, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C01013u extends C3X {

    @Nullable
    public C00893i A00;
    public final C00993s A01;

    public C01013u(C00993s c00993s) {
        super(c00993s.A0A, A02(c00993s));
        this.A01 = c00993s;
    }

    public static InterfaceC00913k A02(final C00993s c00993s) {
        return new InterfaceC00913k() { // from class: com.facebook.ads.redexgen.X.3t
            @Override // com.facebook.ads.redexgen.X.InterfaceC00913k
            public final InterfaceC00963p A3m(C3S c3s, C3X c3x) {
                return new InterfaceC00963p(C00993s.this.A0A, C00993s.this, c3s, c3x) { // from class: com.facebook.ads.redexgen.X.3r
                    public static byte[] A04;
                    public final C3X A00;
                    public final C3S A01;
                    public final C00993s A02;
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
                            byte[] r1 = com.facebook.ads.redexgen.X.C00983r.A04
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
                            r0 = r0 ^ 104(0x68, float:1.46E-43)
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00983r.A00(int, int, int):java.lang.String");
                    }

                    public static void A01() {
                        A04 = new byte[]{89, 93, 94, 106, 123, 118, 122, 113, 124, 122, 81, 122, 107, 104, 112, 109, 116, 18, 55, 115, 60, 49, 57, 54, 48, 39, 115, 58, 32, 115, 61, 38, 63, 63, 17, 22, 12, 7, 29, 10, 10, 23, 10, 7, 27, 23, 28, 29, 7, 19, 29, 1, 99, 100, 126, 117, 120, 124, 117, 124, 99, 110, 111, 101, 117, 110, Byte.MAX_VALUE, 120, 107, 126, 99, 101, 100, 117, 97, 111, 115, 20, 5, 28, 89, 78, 85, 95, 87, 94, 68, 94, 67, 79, 73, 90, 72, 68, 80, 94, 66, 91, Byte.MAX_VALUE, 101, 101, Byte.MAX_VALUE, 120, 113, 54, 116, 99, 120, 114, 122, 115, 54, 112, 121, 100, 54, 123, 115, 101, 101, 119, 113, 115, 56, 42, 45, 43, 38, 60, 43, 43, 54, 43, 38, 52, 60, 42, 42, 56, 62, 60, 38, 50, 60, 32, 31, 55, 33, 33, 51, 53, 55, 104, 114, 124, Byte.MAX_VALUE, 126, 119, 111, 121, 126, 102, 113, 124, 121, 116, 113, 100, 121, Byte.MAX_VALUE, 126, 111, 100, 121, 125, 117, 111, 123, 117, 105, 6, 34, 56, 56, 34, 37, 44, 107, 41, 62, 37, 47, 39, 46, 107, 45, 36, 57, 107, 38, 46, 56, 56, 42, 44, 46};
                    }

                    {
                        this.A03 = r1;
                        this.A02 = r2;
                        this.A01 = c3s;
                        this.A00 = c3x;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:176:0x02a8, code lost:            return;     */
                    @Override // com.facebook.ads.redexgen.X.InterfaceC00963p
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void A54(android.os.Message r17) {
                        /*
                            Method dump skipped, instructions count: 800
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00983r.A54(android.os.Message):void");
                    }
                };
            }
        };
    }

    @Override // com.facebook.ads.redexgen.X.C3X
    public final void A04() {
        if (this.A00 != null) {
            this.A00.A0C();
        }
        super.A00.A8F(C3Y.A03);
    }

    public final void A06() {
        this.A00 = new C00893i(this.A01, this, this.A02);
        this.A00.A0E(this.A01.A04, this.A01.A07);
    }

    public final void A07(RewardData rewardData) {
        this.A01.A02 = rewardData;
        if (this.A00 != null) {
            this.A00.A0D(rewardData);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A08(com.facebook.ads.RewardedVideoAd r3, @android.support.annotation.Nullable java.lang.String r4, boolean r5) {
        /*
            r2 = this;
            r1 = r2
            com.facebook.ads.redexgen.X.3S r0 = r1.A00
            boolean r0 = r0.A45()
            if (r0 == 0) goto L3b
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L3d;
                case 3: goto Le;
                case 4: goto L1f;
                case 5: goto L2a;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.3u r1 = (com.facebook.ads.redexgen.X.C01013u) r1
            com.facebook.ads.RewardedVideoAd r3 = (com.facebook.ads.RewardedVideoAd) r3
            com.facebook.ads.redexgen.X.3s r0 = r1.A01
            r0.A01(r3)
            com.facebook.ads.redexgen.X.3i r0 = r1.A00
            if (r0 == 0) goto L1d
            r0 = 4
            goto La
        L1d:
            r0 = 5
            goto La
        L1f:
            com.facebook.ads.redexgen.X.3u r1 = (com.facebook.ads.redexgen.X.C01013u) r1
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.redexgen.X.3i r0 = r1.A00
            r0.A0E(r4, r5)
            r0 = 2
            goto La
        L2a:
            com.facebook.ads.redexgen.X.3u r1 = (com.facebook.ads.redexgen.X.C01013u) r1
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.redexgen.X.3s r0 = r1.A01
            r0.A04 = r4
            com.facebook.ads.redexgen.X.3s r0 = r1.A01
            r0.A07 = r5
            r1.A06()
            r0 = 2
            goto La
        L3b:
            r0 = 3
            goto La
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01013u.A08(com.facebook.ads.RewardedVideoAd, java.lang.String, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x003f, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A09() {
        /*
            r7 = this;
            r5 = r7
            r6 = 0
            com.facebook.ads.redexgen.X.3i r0 = r5.A00
            if (r0 == 0) goto L3d
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L30;
                case 3: goto L3f;
                case 4: goto L20;
                case 5: goto Le;
                case 6: goto Lb;
                case 7: goto L3a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r6 = 1
            r0 = 3
            goto L7
        Le:
            com.facebook.ads.redexgen.X.3u r5 = (com.facebook.ads.redexgen.X.C01013u) r5
            long r3 = com.facebook.ads.redexgen.X.K4.A00()
            com.facebook.ads.redexgen.X.3s r0 = r5.A01
            long r1 = r0.A01
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L1e
            r0 = 6
            goto L7
        L1e:
            r0 = 7
            goto L7
        L20:
            com.facebook.ads.redexgen.X.3u r5 = (com.facebook.ads.redexgen.X.C01013u) r5
            com.facebook.ads.redexgen.X.3s r0 = r5.A01
            long r3 = r0.A01
            r1 = 0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L2e
            r0 = 5
            goto L7
        L2e:
            r0 = 7
            goto L7
        L30:
            com.facebook.ads.redexgen.X.3u r5 = (com.facebook.ads.redexgen.X.C01013u) r5
            com.facebook.ads.redexgen.X.3i r0 = r5.A00
            boolean r6 = r0.A0F()
            r0 = 3
            goto L7
        L3a:
            r6 = 0
            r0 = 3
            goto L7
        L3d:
            r0 = 4
            goto L7
        L3f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01013u.A09():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x002d, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0A() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.3i r0 = r3.A00
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
            com.facebook.ads.redexgen.X.3u r3 = (com.facebook.ads.redexgen.X.C01013u) r3
            com.facebook.ads.redexgen.X.3i r0 = r3.A00
            boolean r2 = r0.A0G()
            r0 = 3
            goto L7
        L15:
            com.facebook.ads.redexgen.X.3u r3 = (com.facebook.ads.redexgen.X.C01013u) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01013u.A0A():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0B(com.facebook.ads.RewardedVideoAd r7, com.facebook.ads.RewardedVideoAd.RewardedVideoShowAdConfig r8) {
        /*
            r6 = this;
            r5 = r6
            r0 = 0
            r0 = 0
            r4 = 0
            com.facebook.ads.redexgen.X.9L r8 = (com.facebook.ads.redexgen.X.C9L) r8
            int r3 = r8.A00()
            com.facebook.ads.redexgen.X.3S r0 = r5.A00
            boolean r0 = r0.A46()
            if (r0 == 0) goto L46
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L48;
                case 3: goto L17;
                case 4: goto L28;
                case 5: goto L32;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            com.facebook.ads.redexgen.X.3u r5 = (com.facebook.ads.redexgen.X.C01013u) r5
            com.facebook.ads.RewardedVideoAd r7 = (com.facebook.ads.RewardedVideoAd) r7
            com.facebook.ads.redexgen.X.3s r0 = r5.A01
            r0.A01(r7)
            com.facebook.ads.redexgen.X.3i r0 = r5.A00
            if (r0 == 0) goto L26
            r0 = 4
            goto L13
        L26:
            r0 = 5
            goto L13
        L28:
            com.facebook.ads.redexgen.X.3u r5 = (com.facebook.ads.redexgen.X.C01013u) r5
            com.facebook.ads.redexgen.X.3i r0 = r5.A00
            boolean r4 = r0.A0H(r3)
            r0 = 2
            goto L13
        L32:
            com.facebook.ads.redexgen.X.3u r5 = (com.facebook.ads.redexgen.X.C01013u) r5
            com.facebook.ads.redexgen.X.3i r2 = new com.facebook.ads.redexgen.X.3i
            com.facebook.ads.redexgen.X.3s r1 = r5.A01
            java.lang.String r0 = r5.A02
            r2.<init>(r1, r5, r0)
            r5.A00 = r2
            com.facebook.ads.redexgen.X.3i r0 = r5.A00
            r0.A0H(r3)
            r0 = 2
            goto L13
        L46:
            r0 = 3
            goto L13
        L48:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01013u.A0B(com.facebook.ads.RewardedVideoAd, com.facebook.ads.RewardedVideoAd$RewardedVideoShowAdConfig):boolean");
    }
}
