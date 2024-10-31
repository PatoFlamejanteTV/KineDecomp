package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.6J, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C6J {
    public static byte[] A03;
    public final C6I A01;
    public final C6H A00 = new C6H();
    public final List<View> A02 = new ArrayList();

    static {
        A02();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C6J.A03
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
            r0 = r0 ^ 30
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6J.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A03 = new byte[]{13, 1, 73, 72, 69, 69, 68, 79, 1, 77, 72, 82, 85, 27, 123, 125, 118, 102, 97, 104, 47, 123, 96, 47, 122, 97, 103, 102, 107, 106, 47, 110, 47, 121, 102, 106, 120, 47, 123, 103, 110, 123, 47, 120, 110, 124, 47, 97, 96, 123, 47, 103, 102, 107, 107, 106, 97, 115, 108, 96, 114, 37, 108, 118, 37, 107, 106, 113, 37, 100, 37, 102, 109, 108, 105, 97, 41, 37, 102, 100, 107, 107, 106, 113, 37, 109, 108, 97, 96, 37};
    }

    public C6J(C6I c6i) {
        this.A01 = c6i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0050, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A00(int r7) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r3 = 0
            r0 = 0
            r2 = 0
            r1 = -1
            if (r7 >= 0) goto L4e
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L32;
                case 3: goto L50;
                case 4: goto L27;
                case 5: goto L20;
                case 6: goto Ld;
                case 7: goto L35;
                case 8: goto L44;
                case 9: goto L48;
                case 10: goto L4b;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.6J r5 = (com.facebook.ads.redexgen.X.C6J) r5
            com.facebook.ads.redexgen.X.6H r0 = r5.A00
            int r0 = r0.A03(r2)
            int r0 = r2 - r0
            int r3 = r7 - r0
            if (r3 != 0) goto L1d
            r0 = 7
            goto L9
        L1d:
            r0 = 9
            goto L9
        L20:
            if (r2 >= r4) goto L24
            r0 = 6
            goto L9
        L24:
            r0 = 10
            goto L9
        L27:
            com.facebook.ads.redexgen.X.6J r5 = (com.facebook.ads.redexgen.X.C6J) r5
            com.facebook.ads.redexgen.X.6I r0 = r5.A01
            int r4 = r0.A4Q()
            r2 = r7
            r0 = 5
            goto L9
        L32:
            r2 = r1
            r0 = 3
            goto L9
        L35:
            com.facebook.ads.redexgen.X.6J r5 = (com.facebook.ads.redexgen.X.C6J) r5
            com.facebook.ads.redexgen.X.6H r0 = r5.A00
            boolean r0 = r0.A08(r2)
            if (r0 == 0) goto L42
            r0 = 8
            goto L9
        L42:
            r0 = 3
            goto L9
        L44:
            int r2 = r2 + 1
            r0 = 7
            goto L9
        L48:
            int r2 = r2 + r3
            r0 = 5
            goto L9
        L4b:
            r2 = r1
            r0 = 3
            goto L9
        L4e:
            r0 = 4
            goto L9
        L50:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6J.A00(int):int");
    }

    private void A03(View view) {
        this.A02.add(view);
        this.A01.A6X(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A04(android.view.View r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            java.util.List<android.view.View> r0 = r2.A02
            boolean r0 = r0.remove(r4)
            if (r0 == 0) goto L1e
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L20;
                case 4: goto L1b;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.6J r2 = (com.facebook.ads.redexgen.X.C6J) r2
            android.view.View r4 = (android.view.View) r4
            com.facebook.ads.redexgen.X.6I r0 = r2.A01
            r0.A70(r4)
            r1 = 1
            r0 = 3
            goto Lb
        L1b:
            r1 = 0
            r0 = 3
            goto Lb
        L1e:
            r0 = 4
            goto Lb
        L20:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6J.A04(android.view.View):boolean");
    }

    public final int A05() {
        return this.A01.A4Q() - this.A02.size();
    }

    public final int A06() {
        return this.A01.A4Q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A07(android.view.View r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            r2 = -1
            com.facebook.ads.redexgen.X.6I r0 = r3.A01
            int r1 = r0.A58(r5)
            if (r1 != r2) goto L2b
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L2d;
                case 3: goto L11;
                case 4: goto L1f;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.6J r3 = (com.facebook.ads.redexgen.X.C6J) r3
            com.facebook.ads.redexgen.X.6H r0 = r3.A00
            boolean r0 = r0.A08(r1)
            if (r0 != 0) goto L1d
            r0 = 4
            goto Ld
        L1d:
            r0 = 2
            goto Ld
        L1f:
            com.facebook.ads.redexgen.X.6J r3 = (com.facebook.ads.redexgen.X.C6J) r3
            com.facebook.ads.redexgen.X.6H r0 = r3.A00
            int r0 = r0.A03(r1)
            int r2 = r1 - r0
            r0 = 2
            goto Ld
        L2b:
            r0 = 3
            goto Ld
        L2d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6J.A07(android.view.View):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0053, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View A08(int r7) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r3 = 0
            r0 = 0
            r0 = 0
            java.util.List<android.view.View> r0 = r5.A02
            int r2 = r0.size()
            r1 = 0
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L43;
                case 3: goto L29;
                case 4: goto L1d;
                case 5: goto L11;
                case 6: goto L51;
                case 7: goto L4a;
                case 8: goto L4e;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            boolean r0 = r4.A0c()
            if (r0 != 0) goto L1b
            r0 = 6
            goto Ld
        L1b:
            r0 = 7
            goto Ld
        L1d:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            boolean r0 = r4.A0b()
            if (r0 != 0) goto L27
            r0 = 5
            goto Ld
        L27:
            r0 = 7
            goto Ld
        L29:
            com.facebook.ads.redexgen.X.6J r5 = (com.facebook.ads.redexgen.X.C6J) r5
            java.util.List<android.view.View> r0 = r5.A02
            java.lang.Object r3 = r0.get(r1)
            android.view.View r3 = (android.view.View) r3
            com.facebook.ads.redexgen.X.6I r0 = r5.A01
            com.facebook.ads.redexgen.X.7Z r4 = r0.A4T(r3)
            int r0 = r4.A0I()
            if (r0 != r7) goto L41
            r0 = 4
            goto Ld
        L41:
            r0 = 7
            goto Ld
        L43:
            if (r1 >= r2) goto L47
            r0 = 3
            goto Ld
        L47:
            r0 = 8
            goto Ld
        L4a:
            int r1 = r1 + 1
            r0 = 2
            goto Ld
        L4e:
            r3 = 0
            r0 = 6
            goto Ld
        L51:
            android.view.View r3 = (android.view.View) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6J.A08(int):android.view.View");
    }

    public final View A09(int i) {
        return this.A01.A4P(A00(i));
    }

    public final View A0A(int i) {
        return this.A01.A4P(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:            r3.A01.A86();     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0B() {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            com.facebook.ads.redexgen.X.6H r0 = r3.A00
            r0.A04()
            java.util.List<android.view.View> r0 = r3.A02
            int r0 = r0.size()
            int r2 = r0 + (-1)
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L1a;
                case 4: goto L32;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            if (r2 < 0) goto L18
            r0 = 3
            goto L10
        L18:
            r0 = 4
            goto L10
        L1a:
            com.facebook.ads.redexgen.X.6J r3 = (com.facebook.ads.redexgen.X.C6J) r3
            com.facebook.ads.redexgen.X.6I r1 = r3.A01
            java.util.List<android.view.View> r0 = r3.A02
            java.lang.Object r0 = r0.get(r2)
            android.view.View r0 = (android.view.View) r0
            r1.A70(r0)
            java.util.List<android.view.View> r0 = r3.A02
            r0.remove(r2)
            int r2 = r2 + (-1)
            r0 = 2
            goto L10
        L32:
            com.facebook.ads.redexgen.X.6J r3 = (com.facebook.ads.redexgen.X.C6J) r3
            com.facebook.ads.redexgen.X.6I r0 = r3.A01
            r0.A86()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6J.A0B():void");
    }

    public final void A0C(int i) {
        int A00 = A00(i);
        this.A00.A09(A00);
        this.A01.A3y(A00);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0D(int r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            int r2 = r3.A00(r5)
            com.facebook.ads.redexgen.X.6I r0 = r3.A01
            android.view.View r1 = r0.A4P(r2)
            if (r1 != 0) goto L34
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L36;
                case 3: goto L14;
                case 4: goto L22;
                case 5: goto L2b;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.6J r3 = (com.facebook.ads.redexgen.X.C6J) r3
            com.facebook.ads.redexgen.X.6H r0 = r3.A00
            boolean r0 = r0.A09(r2)
            if (r0 == 0) goto L20
            r0 = 4
            goto L10
        L20:
            r0 = 5
            goto L10
        L22:
            com.facebook.ads.redexgen.X.6J r3 = (com.facebook.ads.redexgen.X.C6J) r3
            android.view.View r1 = (android.view.View) r1
            r3.A04(r1)
            r0 = 5
            goto L10
        L2b:
            com.facebook.ads.redexgen.X.6J r3 = (com.facebook.ads.redexgen.X.C6J) r3
            com.facebook.ads.redexgen.X.6I r0 = r3.A01
            r0.A87(r2)
            r0 = 2
            goto L10
        L34:
            r0 = 3
            goto L10
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6J.A0D(int):void");
    }

    public final void A0E(View view) {
        int A58 = this.A01.A58(view);
        if (A58 < 0) {
            throw new IllegalArgumentException(A01(57, 33, 27) + view);
        }
        this.A00.A06(A58);
        A03(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0F(android.view.View r4) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            com.facebook.ads.redexgen.X.6I r0 = r2.A01
            int r1 = r0.A58(r4)
            if (r1 >= 0) goto L2f
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L31;
                case 3: goto Lf;
                case 4: goto L1d;
                case 5: goto L26;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.6J r2 = (com.facebook.ads.redexgen.X.C6J) r2
            com.facebook.ads.redexgen.X.6H r0 = r2.A00
            boolean r0 = r0.A09(r1)
            if (r0 == 0) goto L1b
            r0 = 4
            goto Lb
        L1b:
            r0 = 5
            goto Lb
        L1d:
            com.facebook.ads.redexgen.X.6J r2 = (com.facebook.ads.redexgen.X.C6J) r2
            android.view.View r4 = (android.view.View) r4
            r2.A04(r4)
            r0 = 5
            goto Lb
        L26:
            com.facebook.ads.redexgen.X.6J r2 = (com.facebook.ads.redexgen.X.C6J) r2
            com.facebook.ads.redexgen.X.6I r0 = r2.A01
            r0.A87(r1)
            r0 = 2
            goto Lb
        L2f:
            r0 = 3
            goto Lb
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6J.A0F(android.view.View):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000b. Please report as an issue. */
    public final void A0G(View view) {
        C6J c6j = this;
        int A58 = c6j.A01.A58(view);
        char c = A58 < 0 ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalArgumentException(A01(57, 33, 27) + view);
                case 3:
                    c6j = c6j;
                    c = !c6j.A00.A08(A58) ? (char) 4 : (char) 5;
                case 4:
                    throw new RuntimeException(A01(14, 43, 17) + view);
                case 5:
                    C6J c6j2 = c6j;
                    c6j2.A00.A05(A58);
                    c6j2.A04(view);
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0033, code lost:            r2.A01.A3E(r4, r1, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0H(android.view.View r4, int r5, android.view.ViewGroup.LayoutParams r6, boolean r7) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            if (r5 >= 0) goto L31
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L13;
                case 4: goto L20;
                case 5: goto L33;
                case 6: goto L29;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.6J r2 = (com.facebook.ads.redexgen.X.C6J) r2
            com.facebook.ads.redexgen.X.6I r0 = r2.A01
            int r1 = r0.A4Q()
            r0 = 3
            goto L5
        L13:
            com.facebook.ads.redexgen.X.6J r2 = (com.facebook.ads.redexgen.X.C6J) r2
            com.facebook.ads.redexgen.X.6H r0 = r2.A00
            r0.A07(r1, r7)
            if (r7 == 0) goto L1e
            r0 = 4
            goto L5
        L1e:
            r0 = 5
            goto L5
        L20:
            com.facebook.ads.redexgen.X.6J r2 = (com.facebook.ads.redexgen.X.C6J) r2
            android.view.View r4 = (android.view.View) r4
            r2.A03(r4)
            r0 = 5
            goto L5
        L29:
            com.facebook.ads.redexgen.X.6J r2 = (com.facebook.ads.redexgen.X.C6J) r2
            int r1 = r2.A00(r5)
            r0 = 3
            goto L5
        L31:
            r0 = 6
            goto L5
        L33:
            com.facebook.ads.redexgen.X.6J r2 = (com.facebook.ads.redexgen.X.C6J) r2
            android.view.View r4 = (android.view.View) r4
            android.view.ViewGroup$LayoutParams r6 = (android.view.ViewGroup.LayoutParams) r6
            com.facebook.ads.redexgen.X.6I r0 = r2.A01
            r0.A3E(r4, r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6J.A0H(android.view.View, int, android.view.ViewGroup$LayoutParams, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0033, code lost:            r2.A01.addView(r4, r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0I(android.view.View r4, int r5, boolean r6) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            if (r5 >= 0) goto L31
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L13;
                case 4: goto L20;
                case 5: goto L33;
                case 6: goto L29;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.6J r2 = (com.facebook.ads.redexgen.X.C6J) r2
            com.facebook.ads.redexgen.X.6I r0 = r2.A01
            int r1 = r0.A4Q()
            r0 = 3
            goto L5
        L13:
            com.facebook.ads.redexgen.X.6J r2 = (com.facebook.ads.redexgen.X.C6J) r2
            com.facebook.ads.redexgen.X.6H r0 = r2.A00
            r0.A07(r1, r6)
            if (r6 == 0) goto L1e
            r0 = 4
            goto L5
        L1e:
            r0 = 5
            goto L5
        L20:
            com.facebook.ads.redexgen.X.6J r2 = (com.facebook.ads.redexgen.X.C6J) r2
            android.view.View r4 = (android.view.View) r4
            r2.A03(r4)
            r0 = 5
            goto L5
        L29:
            com.facebook.ads.redexgen.X.6J r2 = (com.facebook.ads.redexgen.X.C6J) r2
            int r1 = r2.A00(r5)
            r0 = 3
            goto L5
        L31:
            r0 = 6
            goto L5
        L33:
            com.facebook.ads.redexgen.X.6J r2 = (com.facebook.ads.redexgen.X.C6J) r2
            android.view.View r4 = (android.view.View) r4
            com.facebook.ads.redexgen.X.6I r0 = r2.A01
            r0.addView(r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6J.A0I(android.view.View, int, boolean):void");
    }

    public final void A0J(View view, boolean z) {
        A0I(view, -1, z);
    }

    public final boolean A0K(View view) {
        return this.A02.contains(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0L(android.view.View r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            r2 = 1
            com.facebook.ads.redexgen.X.6I r0 = r3.A01
            int r1 = r0.A58(r5)
            r0 = -1
            if (r1 != r0) goto L3f
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L41;
                case 4: goto L1b;
                case 5: goto L29;
                case 6: goto L3c;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.6J r3 = (com.facebook.ads.redexgen.X.C6J) r3
            android.view.View r5 = (android.view.View) r5
            r3.A04(r5)
            r0 = 3
            goto Le
        L1b:
            com.facebook.ads.redexgen.X.6J r3 = (com.facebook.ads.redexgen.X.C6J) r3
            com.facebook.ads.redexgen.X.6H r0 = r3.A00
            boolean r0 = r0.A08(r1)
            if (r0 == 0) goto L27
            r0 = 5
            goto Le
        L27:
            r0 = 6
            goto Le
        L29:
            com.facebook.ads.redexgen.X.6J r3 = (com.facebook.ads.redexgen.X.C6J) r3
            android.view.View r5 = (android.view.View) r5
            com.facebook.ads.redexgen.X.6H r0 = r3.A00
            r0.A09(r1)
            r3.A04(r5)
            com.facebook.ads.redexgen.X.6I r0 = r3.A01
            r0.A87(r1)
            r0 = 3
            goto Le
        L3c:
            r2 = 0
            r0 = 3
            goto Le
        L3f:
            r0 = 4
            goto Le
        L41:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6J.A0L(android.view.View):boolean");
    }

    public final String toString() {
        return this.A00.toString() + A01(0, 14, 63) + this.A02.size();
    }
}
