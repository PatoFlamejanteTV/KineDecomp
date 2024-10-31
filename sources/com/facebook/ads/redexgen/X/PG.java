package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: assets/audience_network.dex */
public final class PG extends C7L {
    public static byte[] A0G;

    @Nullable
    public PI A02;
    public List<PH> A03;
    public boolean A07;
    public final int A08;
    public final C01636i A09;
    public final AbstractC01696p A0A;
    public final FP A0E;
    public final Set<Integer> A0F = new HashSet();
    public boolean A06 = true;
    public boolean A04 = true;
    public boolean A05 = true;
    public int A01 = -1;
    public float A00 = 0.0f;
    public final OS A0D = new PD(this);
    public final OQ A0B = new PE(this);
    public final OR A0C = new PF(this);

    static {
        A08();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A05(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.PG.A0G
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
            int r0 = r0 + (-17)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PG.A05(int, int, int):java.lang.String");
    }

    public static void A08() {
        A0G = new byte[]{112, 105, 102, 111, 103, 95, 121, 102, 95, 112, 95, 102, 121, 106, 91, 108, 91, 103, 88, 108, 107, 102, 118, 103, 99, 88, 112, 118, 92, 101, 88, 89, 99, 92, 91, 118, 103, 88, 105, 88, 100, 104, 114, 126, 101, 104, 113, 114, 115, 126, 117, 104, 99, 100, 110, 126, 111, 96, 113, 96, 108};
    }

    public PG(C0532Kw c0532Kw, int i, List<PH> list, FP fp, @Nullable Bundle bundle) {
        this.A09 = c0532Kw.getLayoutManager();
        this.A08 = i;
        this.A03 = list;
        this.A0E = fp;
        this.A0A = new C01706q(c0532Kw.getContext());
        c0532Kw.A1Y(this);
        A0H(bundle);
    }

    @Nullable
    private OH A02(int i, int i2) {
        return A03(i, i2, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x00a4, code lost:            return r2;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.X.OH A03(int r7, int r8, boolean r9) {
        /*
            r6 = this;
            r5 = r6
            r0 = 0
            r0 = 0
            r4 = 0
            r3 = 0
            r2 = 0
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L37;
                case 3: goto L23;
                case 4: goto L20;
                case 5: goto La2;
                case 6: goto Lb;
                case 7: goto L3d;
                case 8: goto L4b;
                case 9: goto L53;
                case 10: goto L18;
                case 11: goto L67;
                case 12: goto L7d;
                case 13: goto L83;
                case 14: goto L75;
                case 15: goto L93;
                case 16: goto L9d;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.OH r4 = (com.facebook.ads.redexgen.X.OH) r4
            boolean r3 = A0O(r4)
            if (r2 != 0) goto L15
            r0 = 7
            goto L7
        L15:
            r0 = 13
            goto L7
        L18:
            if (r9 == 0) goto L1d
            r0 = 11
            goto L7
        L1d:
            r0 = 12
            goto L7
        L20:
            r2 = 0
            r0 = 5
            goto L7
        L23:
            com.facebook.ads.redexgen.X.PG r5 = (com.facebook.ads.redexgen.X.PG) r5
            com.facebook.ads.redexgen.X.6i r0 = r5.A09
            android.view.View r4 = r0.A1q(r7)
            com.facebook.ads.redexgen.X.OH r4 = (com.facebook.ads.redexgen.X.OH) r4
            boolean r0 = r4.A0i()
            if (r0 == 0) goto L35
            r0 = 4
            goto L7
        L35:
            r0 = 6
            goto L7
        L37:
            if (r7 > r8) goto L3b
            r0 = 3
            goto L7
        L3b:
            r0 = 5
            goto L7
        L3d:
            com.facebook.ads.redexgen.X.OH r4 = (com.facebook.ads.redexgen.X.OH) r4
            boolean r0 = r4.A0j()
            if (r0 == 0) goto L48
            r0 = 8
            goto L7
        L48:
            r0 = 13
            goto L7
        L4b:
            if (r3 == 0) goto L50
            r0 = 9
            goto L7
        L50:
            r0 = 13
            goto L7
        L53:
            com.facebook.ads.redexgen.X.PG r5 = (com.facebook.ads.redexgen.X.PG) r5
            java.util.Set<java.lang.Integer> r1 = r5.A0F
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            boolean r0 = r1.contains(r0)
            if (r0 != 0) goto L64
            r0 = 10
            goto L7
        L64:
            r0 = 13
            goto L7
        L67:
            com.facebook.ads.redexgen.X.OH r4 = (com.facebook.ads.redexgen.X.OH) r4
            boolean r0 = A0Q(r4)
            if (r0 == 0) goto L72
            r0 = 12
            goto L7
        L72:
            r0 = 13
            goto L7
        L75:
            if (r3 != 0) goto L7a
            r0 = 15
            goto L7
        L7a:
            r0 = 16
            goto L7
        L7d:
            com.facebook.ads.redexgen.X.OH r4 = (com.facebook.ads.redexgen.X.OH) r4
            r2 = r4
            r0 = 13
            goto L7
        L83:
            com.facebook.ads.redexgen.X.OH r4 = (com.facebook.ads.redexgen.X.OH) r4
            boolean r0 = r4.A0j()
            if (r0 == 0) goto L8f
            r0 = 14
            goto L7
        L8f:
            r0 = 16
            goto L7
        L93:
            com.facebook.ads.redexgen.X.PG r5 = (com.facebook.ads.redexgen.X.PG) r5
            r0 = 0
            r5.A0G(r7, r0)
            r0 = 16
            goto L7
        L9d:
            int r7 = r7 + 1
            r0 = 2
            goto L7
        La2:
            com.facebook.ads.redexgen.X.OH r2 = (com.facebook.ads.redexgen.X.OH) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PG.A03(int, int, boolean):com.facebook.ads.redexgen.X.OH");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A05
            if (r0 != 0) goto L2a
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L2c;
                case 3: goto Lb;
                case 4: goto L23;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.PG r2 = (com.facebook.ads.redexgen.X.PG) r2
            com.facebook.ads.redexgen.X.6i r0 = r2.A09
            int r1 = r0.A28()
            com.facebook.ads.redexgen.X.6i r0 = r2.A09
            int r0 = r0.A29()
            com.facebook.ads.redexgen.X.OH r1 = r2.A02(r1, r0)
            if (r1 == 0) goto L21
            r0 = 4
            goto L7
        L21:
            r0 = 2
            goto L7
        L23:
            com.facebook.ads.redexgen.X.OH r1 = (com.facebook.ads.redexgen.X.OH) r1
            r1.A0e()
            r0 = 2
            goto L7
        L2a:
            r0 = 3
            goto L7
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PG.A06():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A07() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            com.facebook.ads.redexgen.X.6i r0 = r2.A09
            int r1 = r0.A27()
            r0 = -1
            if (r1 == r0) goto L29
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L20;
                case 4: goto L2b;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.PG r2 = (com.facebook.ads.redexgen.X.PG) r2
            java.util.List<com.facebook.ads.redexgen.X.PH> r0 = r2.A03
            int r0 = r0.size()
            int r0 = r0 + (-1)
            if (r1 >= r0) goto L1e
            r0 = 3
            goto Lc
        L1e:
            r0 = 4
            goto Lc
        L20:
            com.facebook.ads.redexgen.X.PG r2 = (com.facebook.ads.redexgen.X.PG) r2
            int r0 = r1 + 1
            r2.A0C(r0)
            r0 = 4
            goto Lc
        L29:
            r0 = 4
            goto Lc
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PG.A07():void");
    }

    private void A09(int i) {
        OH oh = (OH) this.A09.A1q(i);
        if (!A0O(oh)) {
            A0J(oh, false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0A(int r6) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r1 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.6i r0 = r4.A09
            android.view.View r2 = r0.A1q(r6)
            com.facebook.ads.redexgen.X.OH r2 = (com.facebook.ads.redexgen.X.OH) r2
            boolean r0 = A0O(r2)
            if (r0 == 0) goto L6b
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L61;
                case 3: goto L48;
                case 4: goto L17;
                case 5: goto L45;
                case 6: goto L56;
                case 7: goto L6d;
                case 8: goto L5d;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            com.facebook.ads.redexgen.X.PG r4 = (com.facebook.ads.redexgen.X.PG) r4
            com.facebook.ads.redexgen.X.OH r2 = (com.facebook.ads.redexgen.X.OH) r2
            java.util.List<com.facebook.ads.redexgen.X.PH> r1 = r4.A03
            r0 = -1593835536(0xffffffffa0fffff0, float:-4.3368046E-19)
            java.lang.Object r0 = r2.getTag(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.Object r0 = r1.get(r0)
            com.facebook.ads.redexgen.X.PH r0 = (com.facebook.ads.redexgen.X.PH) r0
            com.facebook.ads.redexgen.X.OS r1 = r4.A0D
            com.facebook.ads.redexgen.X.2L r0 = r0.A03()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            boolean r0 = r0.A08()
            if (r0 == 0) goto L42
            r0 = 5
            goto L13
        L42:
            r0 = 8
            goto L13
        L45:
            r3 = 0
            r0 = 6
            goto L13
        L48:
            com.facebook.ads.redexgen.X.PG r4 = (com.facebook.ads.redexgen.X.PG) r4
            com.facebook.ads.redexgen.X.OH r2 = (com.facebook.ads.redexgen.X.OH) r2
            boolean r0 = r4.A0P(r2)
            if (r0 == 0) goto L54
            r0 = 4
            goto L13
        L54:
            r0 = 7
            goto L13
        L56:
            com.facebook.ads.redexgen.X.OS r1 = (com.facebook.ads.redexgen.X.OS) r1
            r1.setVolume(r3)
            r0 = 7
            goto L13
        L5d:
            r3 = 1065353216(0x3f800000, float:1.0)
            r0 = 6
            goto L13
        L61:
            com.facebook.ads.redexgen.X.PG r4 = (com.facebook.ads.redexgen.X.PG) r4
            com.facebook.ads.redexgen.X.OH r2 = (com.facebook.ads.redexgen.X.OH) r2
            r0 = 1
            r4.A0J(r2, r0)
            r0 = 3
            goto L13
        L6b:
            r0 = 3
            goto L13
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PG.A0A(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B(int i) {
        OH A03 = A03(i + 1, this.A09.A29(), false);
        if (A03 != null) {
            A03.A0e();
            A0C(((Integer) A03.getTag(-1593835536)).intValue());
        }
    }

    private void A0C(int i) {
        this.A0A.A0A(i);
        this.A09.A1L(this.A0A);
    }

    private void A0D(int i, int i2) {
        A09(i);
        A09(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0016, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0E(int r3, int r4) {
        /*
            r2 = this;
            r1 = r2
            r0 = 0
            r0 = 2
        L3:
            switch(r0) {
                case 2: goto L7;
                case 3: goto Ld;
                case 4: goto L16;
                default: goto L6;
            }
        L6:
            goto L3
        L7:
            if (r3 > r4) goto Lb
            r0 = 3
            goto L3
        Lb:
            r0 = 4
            goto L3
        Ld:
            com.facebook.ads.redexgen.X.PG r1 = (com.facebook.ads.redexgen.X.PG) r1
            r1.A0A(r3)
            int r3 = r3 + 1
            r0 = 2
            goto L3
        L16:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PG.A0E(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0043, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0F(int r5, int r6, int r7) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r1 = 0
            boolean r0 = r3.A0N()
            if (r0 == 0) goto L41
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L29;
                case 3: goto L43;
                case 4: goto L1a;
                case 5: goto L17;
                case 6: goto Le;
                case 7: goto L33;
                case 8: goto L3b;
                case 9: goto L3e;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.PG r3 = (com.facebook.ads.redexgen.X.PG) r3
            com.facebook.ads.redexgen.X.PI r0 = r3.A02
            r0.A7y(r2)
            r0 = 3
            goto La
        L17:
            r2 = r1
            r0 = 6
            goto La
        L1a:
            com.facebook.ads.redexgen.X.PG r3 = (com.facebook.ads.redexgen.X.PG) r3
            com.facebook.ads.redexgen.X.6i r0 = r3.A09
            int r1 = r0.A27()
            r0 = -1
            if (r1 == r0) goto L27
            r0 = 5
            goto La
        L27:
            r0 = 7
            goto La
        L29:
            com.facebook.ads.redexgen.X.PG r3 = (com.facebook.ads.redexgen.X.PG) r3
            com.facebook.ads.redexgen.X.PI r0 = r3.A02
            if (r0 != 0) goto L31
            r0 = 3
            goto La
        L31:
            r0 = 4
            goto La
        L33:
            if (r7 >= 0) goto L38
            r0 = 8
            goto La
        L38:
            r0 = 9
            goto La
        L3b:
            r2 = r5
            r0 = 6
            goto La
        L3e:
            r2 = r6
            r0 = 6
            goto La
        L41:
            r0 = 3
            goto La
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PG.A0F(int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0G(int r4, boolean r5) {
        /*
            r3 = this;
            r2 = r3
            if (r5 == 0) goto L22
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L24;
                case 4: goto L15;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.PG r2 = (com.facebook.ads.redexgen.X.PG) r2
            java.util.Set<java.lang.Integer> r1 = r2.A0F
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            r1.add(r0)
            r0 = 3
            goto L4
        L15:
            com.facebook.ads.redexgen.X.PG r2 = (com.facebook.ads.redexgen.X.PG) r2
            java.util.Set<java.lang.Integer> r1 = r2.A0F
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            r1.remove(r0)
            r0 = 3
            goto L4
        L22:
            r0 = 4
            goto L4
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PG.A0G(int, boolean):void");
    }

    private void A0H(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.A00 = bundle.getFloat(A05(0, 18, 9), 0.0f);
        this.A05 = bundle.getBoolean(A05(18, 23, 6), true);
        this.A06 = bundle.getBoolean(A05(41, 20, 14), true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0012, code lost:            r2.setAlpha(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0017, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0I(android.view.View r2, boolean r3) {
        /*
            r1 = 0
            if (r3 == 0) goto L10
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L12;
                case 4: goto Lc;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            r1 = 1065353216(0x3f800000, float:1.0)
            r0 = 3
            goto L4
        Lc:
            r1 = 1056964608(0x3f000000, float:0.5)
            r0 = 3
            goto L4
        L10:
            r0 = 4
            goto L4
        L12:
            android.view.View r2 = (android.view.View) r2
            r2.setAlpha(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PG.A0I(android.view.View, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x002d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0J(com.facebook.ads.redexgen.X.OH r2, boolean r3) {
        /*
            r1 = this;
            boolean r0 = r1.A0N()
            if (r0 == 0) goto L2b
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L12;
                case 4: goto L18;
                case 5: goto L24;
                case 6: goto L2d;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.OH r2 = (com.facebook.ads.redexgen.X.OH) r2
            A0I(r2, r3)
            r0 = 3
            goto L7
        L12:
            if (r3 != 0) goto L16
            r0 = 4
            goto L7
        L16:
            r0 = 6
            goto L7
        L18:
            com.facebook.ads.redexgen.X.OH r2 = (com.facebook.ads.redexgen.X.OH) r2
            boolean r0 = r2.A0i()
            if (r0 == 0) goto L22
            r0 = 5
            goto L7
        L22:
            r0 = 6
            goto L7
        L24:
            com.facebook.ads.redexgen.X.OH r2 = (com.facebook.ads.redexgen.X.OH) r2
            r2.A0d()
            r0 = 6
            goto L7
        L2b:
            r0 = 3
            goto L7
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PG.A0J(com.facebook.ads.redexgen.X.OH, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0N() {
        return this.A08 == 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0O(android.view.View r3) {
        /*
            r2 = 0
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r3.getGlobalVisibleRect(r0)
            int r0 = r0.width()
            float r1 = (float) r0
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r1 = r1 / r0
            r0 = 1041865114(0x3e19999a, float:0.15)
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 < 0) goto L26
            r0 = 2
        L1c:
            switch(r0) {
                case 2: goto L20;
                case 3: goto L28;
                case 4: goto L23;
                default: goto L1f;
            }
        L1f:
            goto L1c
        L20:
            r2 = 1
            r0 = 3
            goto L1c
        L23:
            r2 = 0
            r0 = 3
            goto L1c
        L26:
            r0 = 4
            goto L1c
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PG.A0O(android.view.View):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0P(com.facebook.ads.redexgen.X.OH r4) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            boolean r0 = r2.A06
            if (r0 == 0) goto L20
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L18;
                case 4: goto L22;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.OH r4 = (com.facebook.ads.redexgen.X.OH) r4
            boolean r0 = r4.A0j()
            if (r0 == 0) goto L16
            r0 = 3
            goto L8
        L16:
            r0 = 4
            goto L8
        L18:
            com.facebook.ads.redexgen.X.PG r2 = (com.facebook.ads.redexgen.X.PG) r2
            r0 = 0
            r2.A06 = r0
            r1 = 1
            r0 = 4
            goto L8
        L20:
            r0 = 4
            goto L8
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PG.A0P(com.facebook.ads.redexgen.X.OH):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0Q(com.facebook.ads.redexgen.X.OH r4) {
        /*
            r3 = 0
            int r0 = r4.getWidth()
            float r1 = (float) r0
            r0 = 1067869798(0x3fa66666, float:1.3)
            float r1 = r1 * r0
            int r2 = (int) r1
            float r1 = r4.getX()
            int r0 = r4.getWidth()
            float r0 = (float) r0
            float r1 = r1 + r0
            int r0 = (int) r1
            if (r0 > r2) goto L23
            r0 = 2
        L19:
            switch(r0) {
                case 2: goto L1d;
                case 3: goto L25;
                case 4: goto L20;
                default: goto L1c;
            }
        L1c:
            goto L19
        L1d:
            r3 = 1
            r0 = 3
            goto L19
        L20:
            r3 = 0
            r0 = 3
            goto L19
        L23:
            r0 = 4
            goto L19
        L25:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PG.A0Q(com.facebook.ads.redexgen.X.OH):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.C7L
    public final void A0U(C01807a c01807a, int i) {
        super.A0U(c01807a, i);
        if (i == 0) {
            this.A07 = true;
            A06();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C7L
    public final void A0V(C01807a c01807a, int i, int i2) {
        super.A0V(c01807a, i, i2);
        this.A07 = false;
        if (this.A04) {
            this.A07 = true;
            A06();
            this.A04 = false;
        }
        int A28 = this.A09.A28();
        int A29 = this.A09.A29();
        A0D(A28, A29);
        A0E(A28, A29);
        A0F(A28, A29, i);
    }

    public final OQ A0W() {
        return this.A0B;
    }

    public final OR A0X() {
        return this.A0C;
    }

    public final OS A0Y() {
        return this.A0D;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0051, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0Z() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r0 = 0
            r0 = -1
            r4.A01 = r0
            com.facebook.ads.redexgen.X.6i r0 = r4.A09
            int r2 = r0.A28()
            com.facebook.ads.redexgen.X.6i r0 = r4.A09
            int r1 = r0.A29()
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L47;
                case 3: goto L30;
                case 4: goto L36;
                case 5: goto L23;
                case 6: goto L18;
                case 7: goto L51;
                case 8: goto L4d;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            com.facebook.ads.redexgen.X.PG r4 = (com.facebook.ads.redexgen.X.PG) r4
            com.facebook.ads.redexgen.X.OH r3 = (com.facebook.ads.redexgen.X.OH) r3
            r4.A01 = r2
            r3.A0d()
            r0 = 7
            goto L14
        L23:
            com.facebook.ads.redexgen.X.OH r3 = (com.facebook.ads.redexgen.X.OH) r3
            boolean r0 = r3.A0i()
            if (r0 == 0) goto L2d
            r0 = 6
            goto L14
        L2d:
            r0 = 8
            goto L14
        L30:
            if (r2 < 0) goto L34
            r0 = 4
            goto L14
        L34:
            r0 = 7
            goto L14
        L36:
            com.facebook.ads.redexgen.X.PG r4 = (com.facebook.ads.redexgen.X.PG) r4
            com.facebook.ads.redexgen.X.6i r0 = r4.A09
            android.view.View r3 = r0.A1q(r2)
            com.facebook.ads.redexgen.X.OH r3 = (com.facebook.ads.redexgen.X.OH) r3
            if (r3 == 0) goto L44
            r0 = 5
            goto L14
        L44:
            r0 = 8
            goto L14
        L47:
            if (r2 > r1) goto L4b
            r0 = 3
            goto L14
        L4b:
            r0 = 7
            goto L14
        L4d:
            int r2 = r2 + 1
            r0 = 2
            goto L14
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PG.A0Z():void");
    }

    public final void A0a() {
        OH oh = (OH) this.A09.A1q(this.A01);
        if (this.A01 >= 0) {
            oh.A0e();
        }
    }

    public final void A0b(Bundle bundle) {
        bundle.putFloat(A05(0, 18, 9), this.A00);
        bundle.putBoolean(A05(18, 23, 6), this.A05);
        bundle.putBoolean(A05(41, 20, 14), this.A06);
    }

    public final void A0c(PI pi) {
        this.A02 = pi;
    }
}
