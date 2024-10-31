package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.support.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.RewardData;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.2n, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00682n implements C1M {
    public static byte[] A04;

    @Nullable
    public EV A00;
    public NT A01 = NT.A05;
    public final C2W A02;
    public final InterfaceC00331e A03;

    static {
        A05();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C00682n.A04
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
            int r0 = r0 + (-95)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00682n.A04(int, int, int):java.lang.String");
    }

    public static void A05() {
        A04 = new byte[]{45, 50, 56, 41, 54, 55, 56, 45, 56, 45, 37, 48, 47, 48, 49, 52, 57, 52, 63, 52, 58, 57, -52, -15, -9, -24, -11, -15, -28, -17, -93, -56, -11, -11, -14, -11, -93, -75, -77, -77, -71, -93, -6, -20, -9, -21, -14, -8, -9, -93, -28, -93, -7, -28, -17, -20, -25, -93, -60, -25, -52, -15, -23, -14, -79, -82, -24, -12, -19, -20, -43, -28, -35, 7, 4, 23, 4, -55, -52, -57, -52, -55, -36, -55, -57, -54, -35, -42, -52, -44, -51};
    }

    public C00682n(C0362Ec c0362Ec, Map<String, Object> map, InterfaceC00331e interfaceC00331e, @Nullable String str) {
        this.A02 = A01(c0362Ec, map, str, (JSONObject) map.get(A04(73, 4, 68)));
        this.A03 = interfaceC00331e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.AdError A00(com.facebook.ads.redexgen.X.C0362Ec r7) {
        /*
            r6 = this;
            r1 = 0
            com.facebook.ads.redexgen.X.2W r0 = r6.A02
            java.util.List r0 = r0.A0V()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L3c
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L3e;
                case 4: goto L39;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.Ec r7 = (com.facebook.ads.redexgen.X.C0362Ec) r7
            r2 = 70
            r1 = 3
            r0 = 21
            java.lang.String r5 = A04(r2, r1, r0)
            int r4 = com.facebook.ads.redexgen.X.C0512Kc.A0O
            com.facebook.ads.redexgen.X.Ke r3 = new com.facebook.ads.redexgen.X.Ke
            r2 = 22
            r1 = 43
            r0 = 36
            java.lang.String r0 = A04(r2, r1, r0)
            r3.<init>(r0)
            com.facebook.ads.redexgen.X.C0511Kb.A06(r7, r5, r4, r3)
            r0 = 2006(0x7d6, float:2.811E-42)
            com.facebook.ads.AdError r1 = com.facebook.ads.AdError.internalError(r0)
            r0 = 3
            goto Le
        L39:
            r1 = 0
            r0 = 3
            goto Le
        L3c:
            r0 = 4
            goto Le
        L3e:
            com.facebook.ads.AdError r1 = (com.facebook.ads.AdError) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00682n.A00(com.facebook.ads.redexgen.X.Ec):com.facebook.ads.AdError");
    }

    public static C2W A01(C0362Ec c0362Ec, Map<String, Object> map, @Nullable String str, JSONObject jSONObject) {
        C2W adDataBundle = C2W.A01(jSONObject, c0362Ec);
        adDataBundle.A0a(str);
        C0403Fr c0403Fr = (C0403Fr) map.get(A04(12, 10, 108));
        if (c0403Fr != null) {
            adDataBundle.A0Y(c0403Fr.A06());
        }
        return adDataBundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.X.EV A03(com.facebook.ads.redexgen.X.C0362Ec r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.EV r0 = r2.A00
            if (r0 == 0) goto L1a
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1c;
                case 4: goto L11;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.2n r2 = (com.facebook.ads.redexgen.X.C00682n) r2
            com.facebook.ads.redexgen.X.EV r1 = r2.A00
            r0 = 3
            goto L7
        L11:
            com.facebook.ads.redexgen.X.Ec r4 = (com.facebook.ads.redexgen.X.C0362Ec) r4
            com.facebook.ads.redexgen.X.EV r1 = new com.facebook.ads.redexgen.X.EV
            r1.<init>(r4)
            r0 = 3
            goto L7
        L1a:
            r0 = 4
            goto L7
        L1c:
            com.facebook.ads.redexgen.X.EV r1 = (com.facebook.ads.redexgen.X.EV) r1
            com.facebook.ads.redexgen.X.EV r1 = (com.facebook.ads.redexgen.X.EV) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00682n.A03(com.facebook.ads.redexgen.X.Ec):com.facebook.ads.redexgen.X.EV");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0083, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06(com.facebook.ads.redexgen.X.C0362Ec r11, java.util.EnumSet<com.facebook.ads.CacheFlag> r12) {
        /*
            r10 = this;
            r9 = r10
            r8 = 0
            r7 = 0
            r0 = 0
            r6 = 0
            r5 = 0
            com.facebook.ads.redexgen.X.2W r0 = r9.A02
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            com.facebook.ads.redexgen.X.2e r4 = r0.A05()
            if (r4 == 0) goto L81
            r0 = 2
        L17:
            switch(r0) {
                case 2: goto L79;
                case 3: goto L48;
                case 4: goto L29;
                case 5: goto L83;
                case 6: goto L1b;
                case 7: goto L75;
                default: goto L1a;
            }
        L1a:
            goto L17
        L1b:
            com.facebook.ads.redexgen.X.2n r9 = (com.facebook.ads.redexgen.X.C00682n) r9
            com.facebook.ads.redexgen.X.Ec r11 = (com.facebook.ads.redexgen.X.C0362Ec) r11
            com.facebook.ads.redexgen.X.2m r8 = (com.facebook.ads.redexgen.X.C00672m) r8
            com.facebook.ads.redexgen.X.2W r1 = r9.A02
            r0 = 1
            com.facebook.ads.redexgen.X.C00802z.A02(r11, r1, r0, r8)
            r0 = 5
            goto L17
        L29:
            com.facebook.ads.redexgen.X.2n r9 = (com.facebook.ads.redexgen.X.C00682n) r9
            com.facebook.ads.redexgen.X.Ec r11 = (com.facebook.ads.redexgen.X.C0362Ec) r11
            com.facebook.ads.redexgen.X.EV r6 = (com.facebook.ads.redexgen.X.EV) r6
            com.facebook.ads.redexgen.X.2t r5 = (com.facebook.ads.redexgen.X.C00742t) r5
            com.facebook.ads.redexgen.X.Gv r2 = new com.facebook.ads.redexgen.X.Gv
            com.facebook.ads.redexgen.X.2W r0 = r9.A02
            java.lang.String r1 = r0.A0P()
            com.facebook.ads.redexgen.X.Gl r0 = r11.A05()
            r2.<init>(r1, r0)
            r6.A0W(r2)
            r5.A07()
            r0 = 5
            goto L17
        L48:
            com.facebook.ads.redexgen.X.2n r9 = (com.facebook.ads.redexgen.X.C00682n) r9
            com.facebook.ads.redexgen.X.Ec r11 = (com.facebook.ads.redexgen.X.C0362Ec) r11
            com.facebook.ads.redexgen.X.NT r7 = (com.facebook.ads.redexgen.X.NT) r7
            r9.A08(r7)
            com.facebook.ads.redexgen.X.2m r8 = new com.facebook.ads.redexgen.X.2m
            r8.<init>()
            com.facebook.ads.redexgen.X.EV r6 = new com.facebook.ads.redexgen.X.EV
            r6.<init>(r11)
            com.facebook.ads.redexgen.X.2t r5 = new com.facebook.ads.redexgen.X.2t
            com.facebook.ads.redexgen.X.2W r3 = r9.A02
            r2 = 0
            r1 = 12
            r0 = 101(0x65, float:1.42E-43)
            java.lang.String r0 = A04(r2, r1, r0)
            r5.<init>(r9, r3, r0, r6)
            boolean r0 = r5.A08()
            if (r0 == 0) goto L73
            r0 = 4
            goto L17
        L73:
            r0 = 6
            goto L17
        L75:
            com.facebook.ads.redexgen.X.NT r7 = com.facebook.ads.redexgen.X.NT.A05
            r0 = 3
            goto L17
        L79:
            com.facebook.ads.redexgen.X.2e r4 = (com.facebook.ads.redexgen.X.C00592e) r4
            com.facebook.ads.redexgen.X.NT r7 = r4.A0A()
            r0 = 3
            goto L17
        L81:
            r0 = 7
            goto L17
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00682n.A06(com.facebook.ads.redexgen.X.Ec, java.util.EnumSet):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x020c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A07(com.facebook.ads.redexgen.X.C0362Ec r24, java.util.EnumSet<com.facebook.ads.CacheFlag> r25) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00682n.A07(com.facebook.ads.redexgen.X.Ec, java.util.EnumSet):void");
    }

    private void A08(NT nt) {
        this.A01 = nt;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0070, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.IY A09() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.2W r0 = r3.A02
            java.lang.String r0 = r0.A0Q()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L6a
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L32;
                case 3: goto L2e;
                case 4: goto L6c;
                case 5: goto L17;
                case 6: goto L13;
                case 7: goto L3c;
                case 8: goto L54;
                case 9: goto L58;
                case 10: goto L2a;
                case 11: goto L66;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.IY r2 = com.facebook.ads.redexgen.X.IY.A06
            r0 = 4
            goto Lf
        L17:
            com.facebook.ads.redexgen.X.2n r3 = (com.facebook.ads.redexgen.X.C00682n) r3
            com.facebook.ads.redexgen.X.2W r0 = r3.A02
            java.util.List r0 = r0.A0V()
            int r1 = r0.size()
            r0 = 1
            if (r1 <= r0) goto L28
            r0 = 6
            goto Lf
        L28:
            r0 = 7
            goto Lf
        L2a:
            com.facebook.ads.redexgen.X.IY r2 = com.facebook.ads.redexgen.X.IY.A09
            r0 = 4
            goto Lf
        L2e:
            com.facebook.ads.redexgen.X.IY r2 = com.facebook.ads.redexgen.X.IY.A03
            r0 = 4
            goto Lf
        L32:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r1 < r0) goto L3a
            r0 = 3
            goto Lf
        L3a:
            r0 = 5
            goto Lf
        L3c:
            com.facebook.ads.redexgen.X.2n r3 = (com.facebook.ads.redexgen.X.C00682n) r3
            com.facebook.ads.redexgen.X.2W r0 = r3.A02
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            com.facebook.ads.redexgen.X.2e r0 = r0.A05()
            if (r0 == 0) goto L51
            r0 = 8
            goto Lf
        L51:
            r0 = 9
            goto Lf
        L54:
            com.facebook.ads.redexgen.X.IY r2 = com.facebook.ads.redexgen.X.IY.A08
            r0 = 4
            goto Lf
        L58:
            com.facebook.ads.redexgen.X.2n r3 = (com.facebook.ads.redexgen.X.C00682n) r3
            boolean r0 = r3.A0F()
            if (r0 == 0) goto L63
            r0 = 10
            goto Lf
        L63:
            r0 = 11
            goto Lf
        L66:
            com.facebook.ads.redexgen.X.IY r2 = com.facebook.ads.redexgen.X.IY.A07
            r0 = 4
            goto Lf
        L6a:
            r0 = 5
            goto Lf
        L6c:
            com.facebook.ads.redexgen.X.IY r2 = (com.facebook.ads.redexgen.X.IY) r2
            com.facebook.ads.redexgen.X.IY r2 = (com.facebook.ads.redexgen.X.IY) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00682n.A09():com.facebook.ads.redexgen.X.IY");
    }

    public final NT A0A() {
        return this.A01;
    }

    public final String A0B() {
        return this.A02.A0P();
    }

    public final void A0C() {
        this.A03.A8V();
    }

    public final void A0D(Intent intent, RewardData rewardData, String str) {
        this.A02.A0Z(rewardData);
        this.A02.A0c(str);
        intent.putExtra(A04(77, 14, 9), this.A02);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0E(com.facebook.ads.redexgen.X.C0362Ec r5, java.util.EnumSet<com.facebook.ads.CacheFlag> r6) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            com.facebook.ads.AdError r2 = r3.A00(r5)
            if (r2 == 0) goto L41
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L43;
                case 4: goto L18;
                case 5: goto L2b;
                case 6: goto L36;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.2n r3 = (com.facebook.ads.redexgen.X.C00682n) r3
            com.facebook.ads.AdError r2 = (com.facebook.ads.AdError) r2
            com.facebook.ads.redexgen.X.1e r0 = r3.A03
            r0.A66(r2)
            r0 = 3
            goto L9
        L18:
            com.facebook.ads.redexgen.X.2n r3 = (com.facebook.ads.redexgen.X.C00682n) r3
            com.facebook.ads.redexgen.X.1e r0 = r3.A03
            r0.A82()
            com.facebook.ads.redexgen.X.IY r1 = r3.A09()
            com.facebook.ads.redexgen.X.IY r0 = com.facebook.ads.redexgen.X.IY.A08
            if (r1 != r0) goto L29
            r0 = 5
            goto L9
        L29:
            r0 = 6
            goto L9
        L2b:
            com.facebook.ads.redexgen.X.2n r3 = (com.facebook.ads.redexgen.X.C00682n) r3
            com.facebook.ads.redexgen.X.Ec r5 = (com.facebook.ads.redexgen.X.C0362Ec) r5
            java.util.EnumSet r6 = (java.util.EnumSet) r6
            r3.A06(r5, r6)
            r0 = 3
            goto L9
        L36:
            com.facebook.ads.redexgen.X.2n r3 = (com.facebook.ads.redexgen.X.C00682n) r3
            com.facebook.ads.redexgen.X.Ec r5 = (com.facebook.ads.redexgen.X.C0362Ec) r5
            java.util.EnumSet r6 = (java.util.EnumSet) r6
            r3.A07(r5, r6)
            r0 = 3
            goto L9
        L41:
            r0 = 4
            goto L9
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00682n.A0E(com.facebook.ads.redexgen.X.Ec, java.util.EnumSet):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0F() {
        /*
            r2 = this;
            r1 = 0
            com.facebook.ads.redexgen.X.2W r0 = r2.A02
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            java.lang.String r0 = r0.A07()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L20
            r0 = 2
        L16:
            switch(r0) {
                case 2: goto L1a;
                case 3: goto L22;
                case 4: goto L1d;
                default: goto L19;
            }
        L19:
            goto L16
        L1a:
            r1 = 1
            r0 = 3
            goto L16
        L1d:
            r1 = 0
            r0 = 3
            goto L16
        L20:
            r0 = 4
            goto L16
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00682n.A0F():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.C1M
    public final void A6H() {
        this.A03.A67();
    }

    @Override // com.facebook.ads.redexgen.X.C1M
    public final void A6I() {
        this.A03.A66(AdError.CACHE_ERROR);
    }
}
