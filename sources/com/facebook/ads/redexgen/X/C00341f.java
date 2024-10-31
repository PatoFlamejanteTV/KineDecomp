package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.support.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.EnumSet;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.facebook.ads.redexgen.X.1f, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00341f implements C1F, InterfaceC00331e {
    public static byte[] A0B;
    public long A00;
    public RewardData A01;
    public AnonymousClass20 A02;
    public AnonymousClass21 A03;
    public C00682n A04;
    public C0362Ec A05;
    public String A06;

    @Nullable
    public String A07;
    public String A08;
    public boolean A09;
    public final String A0A = UUID.randomUUID().toString();

    static {
        A05();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C00341f.A0B
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
            int r0 = r0 + (-61)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00341f.A03(int, int, int):java.lang.String");
    }

    public static void A05() {
        A0B = new byte[]{-65, -35, -22, -93, -16, -100, -17, -16, -35, -18, -16, -100, -67, -15, -32, -27, -31, -22, -33, -31, -54, -31, -16, -13, -21, -18, -25, -67, -33, -16, -27, -14, -27, -16, -11, -86, -100, -55, -35, -25, -31, -100, -17, -15, -18, -31, -100, -16, -28, -35, -16, -100, -27, -16, -93, -17, -100, -27, -22, -100, -11, -21, -15, -18, -100, -67, -22, -32, -18, -21, -27, -32, -55, -35, -22, -27, -30, -31, -17, -16, -86, -12, -23, -24, -100, -30, -27, -24, -31, -86, -94, -69, -73, -74, -22, -39, -34, -38, -29, -40, -38, -61, -38, -23, -20, -28, -25, -32, -32, -19, -34, -32, -30, -13, -24, -11, -24, -13, -8, -69, -82, -86, -68, -103, -66, -75, -86, -20, -34, -29, -39, -28, -20, 44, 31, 43, 47, 31, 45, 46, 14, 35, 39, 31, -24, -22, -35, -36, -35, -34, -31, -26, -35, -36, -57, -22, -31, -35, -26, -20, -39, -20, -31, -25, -26, -61, -35, -15, -36, -43, -48, -40, -36, -52, -80, -53, -39, -30, -33, -37, -28, -22, -54, -27, -31, -37, -28, 12, 8, -3, -1, 1, 9, 1, 10, 16, -27, 0, -60, -68, -69, -64, -72, -53, -64, -58, -59, -101, -72, -53, -72};
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0059, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A00() {
        /*
            r5 = this;
            r0 = 0
            r4 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ec r3 = r5.A05
            r2 = 127(0x7f, float:1.78E-43)
            r1 = 6
            r0 = 56
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.Object r0 = r3.getSystemService(r0)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            int r2 = r0.getRotation()
            com.facebook.ads.redexgen.X.NT r1 = r5.A02()
            com.facebook.ads.redexgen.X.NT r0 = com.facebook.ads.redexgen.X.NT.A05
            if (r1 != r0) goto L57
            r0 = 2
        L25:
            switch(r0) {
                case 2: goto L35;
                case 3: goto L59;
                case 4: goto L38;
                case 5: goto L2c;
                case 6: goto L29;
                case 7: goto L43;
                case 8: goto L47;
                case 9: goto L50;
                case 10: goto L53;
                default: goto L28;
            }
        L28:
            goto L25
        L29:
            r4 = 0
            r0 = 3
            goto L25
        L2c:
            switch(r2) {
                case 2: goto L31;
                case 3: goto L33;
                default: goto L2f;
            }
        L2f:
            r0 = 6
            goto L25
        L31:
            r0 = 7
            goto L25
        L33:
            r0 = 7
            goto L25
        L35:
            r4 = -1
            r0 = 3
            goto L25
        L38:
            com.facebook.ads.redexgen.X.NT r1 = (com.facebook.ads.redexgen.X.NT) r1
            com.facebook.ads.redexgen.X.NT r0 = com.facebook.ads.redexgen.X.NT.A03
            if (r1 != r0) goto L40
            r0 = 5
            goto L25
        L40:
            r0 = 8
            goto L25
        L43:
            r4 = 8
            r0 = 3
            goto L25
        L47:
            switch(r2) {
                case 2: goto L4d;
                default: goto L4a;
            }
        L4a:
            r0 = 9
            goto L25
        L4d:
            r0 = 10
            goto L25
        L50:
            r4 = 1
            r0 = 3
            goto L25
        L53:
            r4 = 9
            r0 = 3
            goto L25
        L57:
            r0 = 4
            goto L25
        L59:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00341f.A00():int");
    }

    private final IY A01() {
        return this.A04.A09();
    }

    private NT A02() {
        return this.A04.A0A();
    }

    private void A04() {
        this.A09 = true;
    }

    private void A06(Intent intent) {
        this.A04.A0D(intent, this.A01, C0647Pj.A03(this.A01, this.A0A, this.A06));
    }

    private final void A07(C0362Ec c0362Ec, AnonymousClass20 anonymousClass20, Map<String, Object> map, EnumSet<CacheFlag> enumSet, @Nullable String str) {
        this.A04 = new C00682n(c0362Ec, map, this, str);
        this.A04.A0E(c0362Ec, enumSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00bb, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A08(com.facebook.ads.redexgen.X.IY r4) {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.IY r0 = com.facebook.ads.redexgen.X.IY.A06
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb8
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L49;
                case 3: goto Lbb;
                case 4: goto L3b;
                case 5: goto L1d;
                case 6: goto Le;
                case 7: goto L58;
                case 8: goto L67;
                case 9: goto L77;
                case 10: goto L2c;
                case 11: goto L86;
                case 12: goto L98;
                case 13: goto La8;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.IY r4 = (com.facebook.ads.redexgen.X.IY) r4
            com.facebook.ads.redexgen.X.IY r0 = com.facebook.ads.redexgen.X.IY.A09
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L1a
            r0 = 7
            goto La
        L1a:
            r0 = 8
            goto La
        L1d:
            com.facebook.ads.redexgen.X.1f r2 = (com.facebook.ads.redexgen.X.C00341f) r2
            com.facebook.ads.redexgen.X.Ec r0 = r2.A05
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            com.facebook.ads.redexgen.X.0x r0 = com.facebook.ads.redexgen.X.EnumC00260x.A06
            r1.A8M(r0)
            r0 = 3
            goto La
        L2c:
            com.facebook.ads.redexgen.X.IY r4 = (com.facebook.ads.redexgen.X.IY) r4
            com.facebook.ads.redexgen.X.IY r0 = com.facebook.ads.redexgen.X.IY.A03
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L39
            r0 = 11
            goto La
        L39:
            r0 = 3
            goto La
        L3b:
            com.facebook.ads.redexgen.X.IY r4 = (com.facebook.ads.redexgen.X.IY) r4
            com.facebook.ads.redexgen.X.IY r0 = com.facebook.ads.redexgen.X.IY.A07
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L47
            r0 = 5
            goto La
        L47:
            r0 = 6
            goto La
        L49:
            com.facebook.ads.redexgen.X.1f r2 = (com.facebook.ads.redexgen.X.C00341f) r2
            com.facebook.ads.redexgen.X.Ec r0 = r2.A05
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            com.facebook.ads.redexgen.X.0x r0 = com.facebook.ads.redexgen.X.EnumC00260x.A03
            r1.A8M(r0)
            r0 = 3
            goto La
        L58:
            com.facebook.ads.redexgen.X.1f r2 = (com.facebook.ads.redexgen.X.C00341f) r2
            com.facebook.ads.redexgen.X.Ec r0 = r2.A05
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            com.facebook.ads.redexgen.X.0x r0 = com.facebook.ads.redexgen.X.EnumC00260x.A08
            r1.A8M(r0)
            r0 = 3
            goto La
        L67:
            com.facebook.ads.redexgen.X.IY r4 = (com.facebook.ads.redexgen.X.IY) r4
            com.facebook.ads.redexgen.X.IY r0 = com.facebook.ads.redexgen.X.IY.A08
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L74
            r0 = 9
            goto La
        L74:
            r0 = 10
            goto La
        L77:
            com.facebook.ads.redexgen.X.1f r2 = (com.facebook.ads.redexgen.X.C00341f) r2
            com.facebook.ads.redexgen.X.Ec r0 = r2.A05
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            com.facebook.ads.redexgen.X.0x r0 = com.facebook.ads.redexgen.X.EnumC00260x.A07
            r1.A8M(r0)
            r0 = 3
            goto La
        L86:
            com.facebook.ads.redexgen.X.1f r2 = (com.facebook.ads.redexgen.X.C00341f) r2
            com.facebook.ads.redexgen.X.2n r0 = r2.A04
            boolean r0 = r0.A0F()
            if (r0 == 0) goto L94
            r0 = 12
            goto La
        L94:
            r0 = 13
            goto La
        L98:
            com.facebook.ads.redexgen.X.1f r2 = (com.facebook.ads.redexgen.X.C00341f) r2
            com.facebook.ads.redexgen.X.Ec r0 = r2.A05
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            com.facebook.ads.redexgen.X.0x r0 = com.facebook.ads.redexgen.X.EnumC00260x.A05
            r1.A8M(r0)
            r0 = 3
            goto La
        La8:
            com.facebook.ads.redexgen.X.1f r2 = (com.facebook.ads.redexgen.X.C00341f) r2
            com.facebook.ads.redexgen.X.Ec r0 = r2.A05
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            com.facebook.ads.redexgen.X.0x r0 = com.facebook.ads.redexgen.X.EnumC00260x.A04
            r1.A8M(r0)
            r0 = 3
            goto La
        Lb8:
            r0 = 4
            goto La
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00341f.A08(com.facebook.ads.redexgen.X.IY):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:            r6 = r6;        r9 = r15;        r6.A06 = r5;        r6.A00 = ((java.lang.Long) r9.get(A03(133, 11, 125))).longValue();        r6.A07 = r18;        r6.A01 = r19;        r6.A07(r13, r14, r9, r16, r17);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x007f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A09(com.facebook.ads.redexgen.X.C0362Ec r13, com.facebook.ads.redexgen.X.AnonymousClass20 r14, java.util.Map<java.lang.String, java.lang.Object> r15, java.util.EnumSet<com.facebook.ads.CacheFlag> r16, @android.support.annotation.Nullable java.lang.String r17, @android.support.annotation.Nullable java.lang.String r18, @android.support.annotation.Nullable com.facebook.ads.RewardData r19) {
        /*
            r12 = this;
            r3 = r19
            r8 = r14
            r7 = r13
            r9 = r15
            r10 = r16
            r11 = r17
            r4 = r18
            r6 = r12
            r5 = 0
            r6.A05 = r7
            r6.A02 = r8
            r2 = 187(0xbb, float:2.62E-43)
            r1 = 11
            r0 = 95
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r6.A08 = r0
            java.lang.String r0 = r6.A08
            if (r0 == 0) goto L4c
            r0 = 2
        L28:
            switch(r0) {
                case 2: goto L2c;
                case 3: goto L4e;
                case 4: goto L41;
                default: goto L2b;
            }
        L2b:
            goto L28
        L2c:
            com.facebook.ads.redexgen.X.1f r6 = (com.facebook.ads.redexgen.X.C00341f) r6
            java.lang.String r5 = r6.A08
            r2 = 90
            r1 = 1
            r0 = 6
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.String[] r1 = r5.split(r0)
            r0 = 0
            r5 = r1[r0]
            r0 = 3
            goto L28
        L41:
            r2 = 119(0x77, float:1.67E-43)
            r1 = 0
            r0 = 98
            java.lang.String r5 = A03(r2, r1, r0)
            r0 = 3
            goto L28
        L4c:
            r0 = 4
            goto L28
        L4e:
            com.facebook.ads.redexgen.X.1f r6 = (com.facebook.ads.redexgen.X.C00341f) r6
            com.facebook.ads.redexgen.X.Ec r7 = (com.facebook.ads.redexgen.X.C0362Ec) r7
            com.facebook.ads.redexgen.X.20 r8 = (com.facebook.ads.redexgen.X.AnonymousClass20) r8
            java.util.Map r9 = (java.util.Map) r9
            java.util.EnumSet r10 = (java.util.EnumSet) r10
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.RewardData r3 = (com.facebook.ads.RewardData) r3
            java.lang.String r5 = (java.lang.String) r5
            r6.A06 = r5
            r2 = 133(0x85, float:1.86E-43)
            r1 = 11
            r0 = 125(0x7d, float:1.75E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.Object r0 = r9.get(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r6.A00 = r0
            r6.A07 = r4
            r6.A01 = r3
            r6.A07(r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00341f.A09(com.facebook.ads.redexgen.X.Ec, com.facebook.ads.redexgen.X.20, java.util.Map, java.util.EnumSet, java.lang.String, java.lang.String, com.facebook.ads.RewardData):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fd, code lost:            return r7;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0A() {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00341f.A0A():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    @Nullable
    public final String A4V() {
        return this.A04.A0B();
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final AdPlacementType A4p() {
        return AdPlacementType.INTERSTITIAL;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00331e
    public final void A66(AdError adError) {
        if (this.A02 != null) {
            this.A02.A6u(this, adError);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00331e
    public final void A67() {
        A04();
        this.A02.A6t(this);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00331e
    public final void A82() {
        this.A03 = new AnonymousClass21(this.A05, this.A0A, this, this.A02);
        this.A03.A02();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00331e
    public final void A8V() {
        if (this.A03 != null) {
            this.A03.A03();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final void onDestroy() {
        if (this.A04 != null) {
            this.A04.A0C();
        }
    }
}
