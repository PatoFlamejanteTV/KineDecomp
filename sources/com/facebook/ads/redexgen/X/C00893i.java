package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.RewardData;
import com.facebook.ads.S2SRewardedVideoAdExtendedListener;

/* renamed from: com.facebook.ads.redexgen.X.3i, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00893i implements InterfaceC00813a {
    public static byte[] A07;
    public static final String A08;
    public C3Q A02;

    @Nullable
    public String A03;
    public final S2SRewardedVideoAdExtendedListener A05;
    public final C00993s A06;
    public int A00 = 0;
    public boolean A04 = false;
    public long A01 = -1;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C00893i.A07
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
            r0 = r0 ^ 19
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00893i.A04(int, int, int):java.lang.String");
    }

    public static void A06() {
        A07 = new byte[]{67, 116, 116, 105, 116, 38, 106, 105, 103, 98, 111, 104, 97, 38, 116, 99, 113, 103, 116, 98, 99, 98, 38, 112, 111, 98, 99, 105, 38, 103, 98, 42, 59, 34, 39, 8, 70, 7, 2, 70, 10, 9, 7, 2, 70, 15, 21, 70, 7, 10, 20, 3, 7, 2, 31, 70, 15, 8, 70, 22, 20, 9, 1, 20, 3, 21, 21, 72, 70, 63, 9, 19, 70, 21, 14, 9, 19, 10, 2, 70, 17, 7, 15, 18, 70, 0, 9, 20, 70, 7, 2, 42, 9, 7, 2, 3, 2, 78, 79, 70, 18, 9, 70, 4, 3, 70, 5, 7, 10, 10, 3, 2};
    }

    static {
        A06();
        A08 = C00893i.class.getSimpleName();
    }

    public C00893i(C00993s c00993s, C3W c3w, String str) {
        this.A06 = c00993s;
        this.A05 = new C01053y(str, c3w, this, c00993s);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0029, code lost:            r2 = r2;        r2.A09(false);        r2.A04 = false;        r3 = new com.facebook.ads.redexgen.X.AnonymousClass31(r2.A06.A0B, com.facebook.ads.redexgen.X.EnumC0458Hx.A07, com.facebook.ads.internal.protocol.AdPlacementType.REWARDED_VIDEO, com.facebook.ads.redexgen.X.EnumC0457Hw.A07, 1);        r3.A07(r11);        r3.A05(r2.A06.A05);        r3.A06(r2.A06.A06);        r2.A02 = new com.facebook.ads.redexgen.X.C3Q(r2.A06.A0A, r3);        r2.A02.A0E(new com.facebook.ads.redexgen.X.C00873g(r2));        r2.A02.A0G(r10);     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A08(@android.support.annotation.Nullable java.lang.String r10, boolean r11) {
        /*
            r9 = this;
            r2 = r9
            r0 = 0
            r0 = 0
            boolean r0 = r2.A04
            if (r0 != 0) goto L27
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L16;
                case 4: goto L29;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.3i r2 = (com.facebook.ads.redexgen.X.C00893i) r2
            com.facebook.ads.redexgen.X.3Q r0 = r2.A02
            if (r0 == 0) goto L14
            r0 = 3
            goto L8
        L14:
            r0 = 4
            goto L8
        L16:
            java.lang.String r4 = com.facebook.ads.redexgen.X.C00893i.A08
            r3 = 34
            r1 = 78
            r0 = 117(0x75, float:1.64E-43)
            java.lang.String r0 = A04(r3, r1, r0)
            android.util.Log.w(r4, r0)
            r0 = 4
            goto L8
        L27:
            r0 = 4
            goto L8
        L29:
            com.facebook.ads.redexgen.X.3i r2 = (com.facebook.ads.redexgen.X.C00893i) r2
            java.lang.String r10 = (java.lang.String) r10
            r0 = 0
            r2.A09(r0)
            r2.A04 = r0
            com.facebook.ads.redexgen.X.31 r3 = new com.facebook.ads.redexgen.X.31
            com.facebook.ads.redexgen.X.3s r0 = r2.A06
            java.lang.String r4 = r0.A0B
            com.facebook.ads.redexgen.X.Hx r5 = com.facebook.ads.redexgen.X.EnumC0458Hx.A07
            com.facebook.ads.internal.protocol.AdPlacementType r6 = com.facebook.ads.internal.protocol.AdPlacementType.REWARDED_VIDEO
            com.facebook.ads.redexgen.X.Hw r7 = com.facebook.ads.redexgen.X.EnumC0457Hw.A07
            r8 = 1
            r3.<init>(r4, r5, r6, r7, r8)
            r3.A07(r11)
            com.facebook.ads.redexgen.X.3s r0 = r2.A06
            java.lang.String r0 = r0.A05
            r3.A05(r0)
            com.facebook.ads.redexgen.X.3s r0 = r2.A06
            java.lang.String r0 = r0.A06
            r3.A06(r0)
            com.facebook.ads.redexgen.X.3Q r1 = new com.facebook.ads.redexgen.X.3Q
            com.facebook.ads.redexgen.X.3s r0 = r2.A06
            com.facebook.ads.redexgen.X.Ec r0 = r0.A0A
            r1.<init>(r0, r3)
            r2.A02 = r1
            com.facebook.ads.redexgen.X.3Q r1 = r2.A02
            com.facebook.ads.redexgen.X.3g r0 = new com.facebook.ads.redexgen.X.3g
            r0.<init>()
            r1.A0E(r0)
            com.facebook.ads.redexgen.X.3Q r0 = r2.A02
            r0.A0G(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00893i.A08(java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(boolean z) {
        if (this.A02 != null) {
            this.A02.A0E(new C1G() { // from class: com.facebook.ads.redexgen.X.3h
            });
            this.A02.A0I(z);
            this.A02 = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:            return r1;     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long A0B() {
        /*
            r4 = this;
            r3 = r4
            r1 = 0
            com.facebook.ads.redexgen.X.3Q r0 = r3.A02
            if (r0 == 0) goto L1a
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1c;
                case 4: goto L16;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.3i r3 = (com.facebook.ads.redexgen.X.C00893i) r3
            com.facebook.ads.redexgen.X.3Q r0 = r3.A02
            long r1 = r0.A05()
            r0 = 3
            goto L8
        L16:
            r1 = -1
            r0 = 3
            goto L8
        L1a:
            r0 = 4
            goto L8
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00893i.A0B():long");
    }

    public final void A0C() {
        A09(true);
    }

    public final void A0D(RewardData rewardData) {
        this.A06.A02 = rewardData;
        if (this.A04) {
            this.A02.A0M(rewardData);
        }
    }

    public final void A0E(@Nullable String str, boolean z) {
        this.A01 = System.currentTimeMillis();
        try {
            A08(str, z);
        } catch (Exception e) {
            Log.e(A08, A04(0, 31, 21), e);
            C0511Kb.A06(this.A06.A0A, A04(31, 3, 88), C0512Kc.A0P, new C0514Ke(e));
            AdError internalError = AdError.internalError(2004);
            this.A06.A0A.A08().A2a(K4.A01(this.A01), internalError.getErrorCode(), internalError.getErrorMessage());
            this.A05.onError(this.A06.A00(), internalError);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0F() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.3Q r0 = r2.A02
            if (r0 == 0) goto L1f
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L19;
                case 4: goto L21;
                case 5: goto L1c;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.3i r2 = (com.facebook.ads.redexgen.X.C00893i) r2
            com.facebook.ads.redexgen.X.3Q r0 = r2.A02
            boolean r0 = r0.A0J()
            if (r0 == 0) goto L17
            r0 = 3
            goto L7
        L17:
            r0 = 5
            goto L7
        L19:
            r1 = 1
            r0 = 4
            goto L7
        L1c:
            r1 = 0
            r0 = 4
            goto L7
        L1f:
            r0 = 3
            goto L7
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00893i.A0F():boolean");
    }

    public final boolean A0G() {
        return this.A04;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0H(int r6) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r3 = 0
            boolean r0 = r4.A04
            if (r0 != 0) goto L42
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L44;
                case 4: goto L1d;
                case 5: goto L27;
                case 6: goto L3b;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.3i r4 = (com.facebook.ads.redexgen.X.C00893i) r4
            com.facebook.ads.S2SRewardedVideoAdExtendedListener r2 = r4.A05
            com.facebook.ads.redexgen.X.3s r0 = r4.A06
            com.facebook.ads.RewardedVideoAd r1 = r0.A00()
            com.facebook.ads.AdError r0 = com.facebook.ads.AdError.SHOW_CALLED_BEFORE_LOAD_ERROR
            r2.onError(r1, r0)
            r0 = 3
            goto L8
        L1d:
            com.facebook.ads.redexgen.X.3i r4 = (com.facebook.ads.redexgen.X.C00893i) r4
            com.facebook.ads.redexgen.X.3Q r0 = r4.A02
            if (r0 == 0) goto L25
            r0 = 5
            goto L8
        L25:
            r0 = 6
            goto L8
        L27:
            com.facebook.ads.redexgen.X.3i r4 = (com.facebook.ads.redexgen.X.C00893i) r4
            r1 = 0
            com.facebook.ads.redexgen.X.3Q r0 = r4.A02
            com.facebook.ads.redexgen.X.31 r0 = r0.A07
            r0.A02(r6)
            com.facebook.ads.redexgen.X.3Q r0 = r4.A02
            r0.A0A()
            r4.A04 = r1
            r3 = 1
            r0 = 3
            goto L8
        L3b:
            com.facebook.ads.redexgen.X.3i r4 = (com.facebook.ads.redexgen.X.C00893i) r4
            r3 = 0
            r4.A04 = r3
            r0 = 3
            goto L8
        L42:
            r0 = 4
            goto L8
        L44:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00893i.A0H(int):boolean");
    }
}
