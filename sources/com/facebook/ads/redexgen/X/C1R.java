package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.1R, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C1R implements C1F {
    public static byte[] A0B;
    public static final String A0C;
    public C1L A00;
    public C00471s A01;
    public C0364Ee A02;

    @Nullable
    public InterfaceC0422Gl A03;

    @Nullable
    public C1N A04;

    @Nullable
    public NM A05;
    public String A06;
    public Map<String, Object> A07;
    public boolean A08 = false;
    public boolean A09 = false;
    public boolean A0A = false;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A05(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C1R.A0B
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
            r0 = r0 ^ 43
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1R.A05(int, int, int):java.lang.String");
    }

    public static void A07() {
        A0B = new byte[]{33, 32, 35, 44, 43, 44, 49, 44, 42, 43, 64, 81, 76, 64, 27, 92, 64, 89, 88, 5, 4, 22, 93, 72, 110, 107, 126, 107};
    }

    static {
        A07();
        A0C = C1R.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0050, code lost:            r2.A3I(r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0055, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A06() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r2 = 0
            com.facebook.ads.redexgen.X.1L r0 = r4.A00
            if (r0 == 0) goto L4e
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L3c;
                case 3: goto L32;
                case 4: goto L28;
                case 5: goto L1d;
                case 6: goto Lc;
                case 7: goto L46;
                case 8: goto L50;
                case 9: goto L4a;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.1R r4 = (com.facebook.ads.redexgen.X.C1R) r4
            com.facebook.ads.redexgen.X.Ee r0 = r4.A02
            com.facebook.ads.redexgen.X.0d r2 = r0.A08()
            com.facebook.ads.redexgen.X.1L r0 = r4.A00
            if (r0 == 0) goto L1a
            r0 = 7
            goto L8
        L1a:
            r0 = 9
            goto L8
        L1d:
            com.facebook.ads.redexgen.X.1R r4 = (com.facebook.ads.redexgen.X.C1R) r4
            com.facebook.ads.redexgen.X.1L r1 = r4.A00
            com.facebook.ads.redexgen.X.NM r0 = r4.A05
            r1.A6E(r4, r0)
            r0 = 6
            goto L8
        L28:
            com.facebook.ads.redexgen.X.1R r4 = (com.facebook.ads.redexgen.X.C1R) r4
            boolean r0 = r4.A0A
            if (r0 != 0) goto L30
            r0 = 5
            goto L8
        L30:
            r0 = 6
            goto L8
        L32:
            com.facebook.ads.redexgen.X.1R r4 = (com.facebook.ads.redexgen.X.C1R) r4
            boolean r0 = r4.A09
            if (r0 != 0) goto L3a
            r0 = 4
            goto L8
        L3a:
            r0 = 5
            goto L8
        L3c:
            com.facebook.ads.redexgen.X.1R r4 = (com.facebook.ads.redexgen.X.C1R) r4
            boolean r0 = r4.A08
            if (r0 == 0) goto L44
            r0 = 3
            goto L8
        L44:
            r0 = 6
            goto L8
        L46:
            r3 = 1
            r0 = 8
            goto L8
        L4a:
            r3 = 0
            r0 = 8
            goto L8
        L4e:
            r0 = 6
            goto L8
        L50:
            com.facebook.ads.redexgen.X.0d r2 = (com.facebook.ads.redexgen.X.InterfaceC00060d) r2
            r2.A3I(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1R.A06():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00b3, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A09(com.facebook.ads.redexgen.X.C0403Fr r12) {
        /*
            r11 = this;
            r2 = r11
            r0 = 0
            java.util.Map<java.lang.String, java.lang.Object> r4 = r2.A07
            r3 = 24
            r1 = 4
            r0 = 33
            java.lang.String r0 = A05(r3, r1, r0)
            java.lang.Object r0 = r4.get(r0)
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            com.facebook.ads.redexgen.X.1q r1 = com.facebook.ads.redexgen.X.C00451q.A00(r0)
            java.lang.String r0 = r1.A4V()
            r2.A06 = r0
            com.facebook.ads.redexgen.X.Ee r3 = r2.A02
            com.facebook.ads.redexgen.X.Gl r0 = r2.A03
            boolean r0 = com.facebook.ads.redexgen.X.AnonymousClass15.A03(r3, r1, r0)
            if (r0 == 0) goto Lb0
            r0 = 2
        L28:
            switch(r0) {
                case 2: goto L2c;
                case 3: goto Lb3;
                case 4: goto L3b;
                default: goto L2b;
            }
        L2b:
            goto L28
        L2c:
            com.facebook.ads.redexgen.X.1R r2 = (com.facebook.ads.redexgen.X.C1R) r2
            com.facebook.ads.redexgen.X.1L r3 = r2.A00
            r0 = 2006(0x7d6, float:2.811E-42)
            com.facebook.ads.AdError r0 = com.facebook.ads.AdError.internalError(r0)
            r3.A6F(r2, r0)
            r0 = 3
            goto L28
        L3b:
            com.facebook.ads.redexgen.X.1R r2 = (com.facebook.ads.redexgen.X.C1R) r2
            com.facebook.ads.redexgen.X.Fr r12 = (com.facebook.ads.redexgen.X.C0403Fr) r12
            com.facebook.ads.redexgen.X.1q r1 = (com.facebook.ads.redexgen.X.C00451q) r1
            com.facebook.ads.redexgen.X.1P r0 = new com.facebook.ads.redexgen.X.1P
            r0.<init>()
            r2.A04 = r0
            com.facebook.ads.redexgen.X.NM r5 = new com.facebook.ads.redexgen.X.NM
            com.facebook.ads.redexgen.X.Ee r4 = r2.A02
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference
            com.facebook.ads.redexgen.X.1N r0 = r2.A04
            r3.<init>(r0)
            int r0 = r12.A04()
            r5.<init>(r4, r3, r0)
            r2.A05 = r5
            com.facebook.ads.redexgen.X.NM r4 = r2.A05
            int r3 = r12.A07()
            int r0 = r12.A08()
            r4.A0B(r3, r0)
            com.facebook.ads.redexgen.X.1Q r8 = new com.facebook.ads.redexgen.X.1Q
            r8.<init>()
            com.facebook.ads.redexgen.X.1s r3 = new com.facebook.ads.redexgen.X.1s
            com.facebook.ads.redexgen.X.Ee r4 = r2.A02
            com.facebook.ads.redexgen.X.Gl r5 = r2.A03
            com.facebook.ads.redexgen.X.NM r6 = r2.A05
            com.facebook.ads.redexgen.X.NM r0 = r2.A05
            com.facebook.ads.redexgen.X.FP r7 = r0.getViewabilityChecker()
            r3.<init>(r4, r5, r6, r7, r8)
            r2.A01 = r3
            com.facebook.ads.redexgen.X.1s r0 = r2.A01
            r0.A08(r1)
            com.facebook.ads.redexgen.X.NM r5 = r2.A05
            java.lang.String r6 = com.facebook.ads.redexgen.X.NN.A00()
            java.lang.String r7 = r1.A04()
            r4 = 10
            r3 = 9
            r0 = 31
            java.lang.String r8 = A05(r4, r3, r0)
            r4 = 19
            r3 = 5
            r0 = 91
            java.lang.String r9 = A05(r4, r3, r0)
            r10 = 0
            r5.loadDataWithBaseURL(r6, r7, r8, r9, r10)
            r0 = 1
            r2.A08 = r0
            r2.A06()
            r0 = 3
            goto L28
        Lb0:
            r0 = 4
            goto L28
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1R.A09(com.facebook.ads.redexgen.X.Fr):void");
    }

    public final void A0C(C0364Ee c0364Ee, InterfaceC0422Gl interfaceC0422Gl, EnumC0457Hw enumC0457Hw, C1L c1l, Map<String, Object> map) {
        c0364Ee.A08().A3H();
        this.A02 = c0364Ee;
        this.A03 = interfaceC0422Gl;
        this.A00 = c1l;
        this.A07 = map;
        this.A0A = C0413Gc.A0p(this.A02.getApplicationContext());
        A09((C0403Fr) this.A07.get(A05(0, 10, 110)));
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final String A4V() {
        return this.A06;
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final AdPlacementType A4p() {
        return AdPlacementType.BANNER;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0039, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C1F
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDestroy() {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r3 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ee r0 = r4.A02
            com.facebook.ads.redexgen.X.0d r2 = r0.A08()
            com.facebook.ads.redexgen.X.NM r0 = r4.A05
            if (r0 == 0) goto L37
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L17;
                case 4: goto L26;
                case 5: goto L39;
                case 6: goto L34;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            r3 = 1
            r0 = 3
            goto L10
        L17:
            com.facebook.ads.redexgen.X.1R r4 = (com.facebook.ads.redexgen.X.C1R) r4
            com.facebook.ads.redexgen.X.0d r2 = (com.facebook.ads.redexgen.X.InterfaceC00060d) r2
            r2.A3F(r3)
            com.facebook.ads.redexgen.X.NM r0 = r4.A05
            if (r0 == 0) goto L24
            r0 = 4
            goto L10
        L24:
            r0 = 5
            goto L10
        L26:
            com.facebook.ads.redexgen.X.1R r4 = (com.facebook.ads.redexgen.X.C1R) r4
            r1 = 0
            com.facebook.ads.redexgen.X.NM r0 = r4.A05
            r0.destroy()
            r4.A05 = r1
            r4.A04 = r1
            r0 = 5
            goto L10
        L34:
            r3 = 0
            r0 = 3
            goto L10
        L37:
            r0 = 6
            goto L10
        L39:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1R.onDestroy():void");
    }
}
