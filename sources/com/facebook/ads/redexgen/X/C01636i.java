package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState;

/* renamed from: com.facebook.ads.redexgen.X.6i, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C01636i extends AbstractC01616g implements InterfaceC01626h {
    public static byte[] A0F;
    public int A00;
    public int A01;
    public int A02;
    public LinearLayoutManager$SavedState A03;
    public AbstractC01726s A04;
    public boolean A05;
    public int A06;
    public C01676m A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final C01656k A0D;
    public final C01666l A0E;

    static {
        A0T();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0R(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C01636i.A0F
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
            int r0 = r0 + (-60)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0R(int, int, int):java.lang.String");
    }

    public static void A0T() {
        A0F = new byte[]{-91, -86, -78, -99, -88, -91, -96, 92, -85, -82, -91, -95, -86, -80, -99, -80, -91, -85, -86, 118};
    }

    public C01636i(Context context) {
        this(context, 1, false);
    }

    public C01636i(Context context, int i, boolean z) {
        this.A0A = false;
        this.A05 = false;
        this.A0C = false;
        this.A0B = true;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A03 = null;
        this.A0D = new C01656k(this);
        this.A0E = new C01666l();
        this.A06 = 2;
        A2E(i);
        A0f(z);
        A1V(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x006f, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int A02(int r9, com.facebook.ads.redexgen.X.C7O r10, com.facebook.ads.redexgen.X.C7W r11) {
        /*
            r8 = this;
            r7 = r8
            r2 = 0
            r6 = 0
            r5 = 0
            r0 = 0
            r0 = 0
            r4 = 1
            r3 = 0
            int r0 = r7.A0W()
            if (r0 == 0) goto L6d
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L45;
                case 3: goto L6f;
                case 4: goto L35;
                case 5: goto L32;
                case 6: goto L13;
                case 7: goto L4b;
                case 8: goto L53;
                case 9: goto L58;
                case 10: goto L66;
                case 11: goto L6a;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            com.facebook.ads.redexgen.X.7O r10 = (com.facebook.ads.redexgen.X.C7O) r10
            com.facebook.ads.redexgen.X.7W r11 = (com.facebook.ads.redexgen.X.C7W) r11
            r3 = 0
            int r6 = java.lang.Math.abs(r9)
            r7.A0W(r5, r6, r4, r11)
            com.facebook.ads.redexgen.X.6m r0 = r7.A07
            int r2 = r0.A07
            com.facebook.ads.redexgen.X.6m r0 = r7.A07
            int r0 = r7.A05(r10, r0, r11, r3)
            int r2 = r2 + r0
            if (r2 < 0) goto L30
            r0 = 7
            goto Lf
        L30:
            r0 = 3
            goto Lf
        L32:
            r5 = r4
            r0 = 6
            goto Lf
        L35:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            com.facebook.ads.redexgen.X.6m r0 = r7.A07
            r0.A0B = r4
            r7.A2D()
            if (r9 <= 0) goto L42
            r0 = 5
            goto Lf
        L42:
            r0 = 11
            goto Lf
        L45:
            if (r9 != 0) goto L49
            r0 = 3
            goto Lf
        L49:
            r0 = 4
            goto Lf
        L4b:
            if (r6 <= r2) goto L50
            r0 = 8
            goto Lf
        L50:
            r0 = 10
            goto Lf
        L53:
            int r3 = r5 * r2
            r0 = 9
            goto Lf
        L58:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            com.facebook.ads.redexgen.X.6s r1 = r7.A04
            int r0 = -r3
            r1.A0J(r0)
            com.facebook.ads.redexgen.X.6m r0 = r7.A07
            r0.A04 = r3
            r0 = 3
            goto Lf
        L66:
            r3 = r9
            r0 = 9
            goto Lf
        L6a:
            r5 = -1
            r0 = 6
            goto Lf
        L6d:
            r0 = 3
            goto Lf
        L6f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A02(int, com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x004a, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A03(int r8, com.facebook.ads.redexgen.X.C7O r9, com.facebook.ads.redexgen.X.C7W r10, boolean r11) {
        /*
            r7 = this;
            r5 = r7
            r6 = 0
            r0 = 0
            r4 = 0
            r3 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.6s r1 = r5.A04
            int r2 = r1.A07()
            int r2 = r2 - r8
            if (r2 <= 0) goto L48
            r1 = 2
        L10:
            switch(r1) {
                case 2: goto L22;
                case 3: goto L36;
                case 4: goto L14;
                case 5: goto L4a;
                case 6: goto L1f;
                case 7: goto L45;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.6i r5 = (com.facebook.ads.redexgen.X.C01636i) r5
            com.facebook.ads.redexgen.X.6s r1 = r5.A04
            r1.A0J(r0)
            int r6 = r0 + r4
            r1 = 5
            goto L10
        L1f:
            r6 = r4
            r1 = 5
            goto L10
        L22:
            com.facebook.ads.redexgen.X.6i r5 = (com.facebook.ads.redexgen.X.C01636i) r5
            com.facebook.ads.redexgen.X.7O r9 = (com.facebook.ads.redexgen.X.C7O) r9
            com.facebook.ads.redexgen.X.7W r10 = (com.facebook.ads.redexgen.X.C7W) r10
            int r1 = -r2
            int r1 = r5.A02(r1, r9, r10)
            int r4 = -r1
            int r3 = r8 + r4
            if (r11 == 0) goto L34
            r1 = 3
            goto L10
        L34:
            r1 = 6
            goto L10
        L36:
            com.facebook.ads.redexgen.X.6i r5 = (com.facebook.ads.redexgen.X.C01636i) r5
            com.facebook.ads.redexgen.X.6s r0 = r5.A04
            int r0 = r0.A07()
            int r0 = r0 - r3
            if (r0 <= 0) goto L43
            r1 = 4
            goto L10
        L43:
            r1 = 6
            goto L10
        L45:
            r6 = 0
            r1 = 5
            goto L10
        L48:
            r1 = 7
            goto L10
        L4a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A03(int, com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W, boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x004c, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A04(int r8, com.facebook.ads.redexgen.X.C7O r9, com.facebook.ads.redexgen.X.C7W r10, boolean r11) {
        /*
            r7 = this;
            r4 = r7
            r1 = 0
            r6 = 0
            r5 = 0
            r3 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.6s r0 = r4.A04
            int r0 = r0.A0A()
            int r2 = r8 - r0
            if (r2 <= 0) goto L4a
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L18;
                case 3: goto L37;
                case 4: goto L2b;
                case 5: goto L4c;
                case 6: goto L15;
                case 7: goto L47;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            r1 = r5
            r0 = 5
            goto L11
        L18:
            com.facebook.ads.redexgen.X.6i r4 = (com.facebook.ads.redexgen.X.C01636i) r4
            com.facebook.ads.redexgen.X.7O r9 = (com.facebook.ads.redexgen.X.C7O) r9
            com.facebook.ads.redexgen.X.7W r10 = (com.facebook.ads.redexgen.X.C7W) r10
            int r0 = r4.A02(r2, r9, r10)
            int r5 = -r0
            int r3 = r8 + r5
            if (r11 == 0) goto L29
            r0 = 3
            goto L11
        L29:
            r0 = 6
            goto L11
        L2b:
            com.facebook.ads.redexgen.X.6i r4 = (com.facebook.ads.redexgen.X.C01636i) r4
            com.facebook.ads.redexgen.X.6s r1 = r4.A04
            int r0 = -r6
            r1.A0J(r0)
            int r1 = r5 - r6
            r0 = 5
            goto L11
        L37:
            com.facebook.ads.redexgen.X.6i r4 = (com.facebook.ads.redexgen.X.C01636i) r4
            com.facebook.ads.redexgen.X.6s r0 = r4.A04
            int r0 = r0.A0A()
            int r6 = r3 - r0
            if (r6 <= 0) goto L45
            r0 = 4
            goto L11
        L45:
            r0 = 6
            goto L11
        L47:
            r1 = 0
            r0 = 5
            goto L11
        L4a:
            r0 = 7
            goto L11
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A04(int, com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W, boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x0123, code lost:            return r3 - r10.A00;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int A05(com.facebook.ads.redexgen.X.C7O r9, com.facebook.ads.redexgen.X.C01676m r10, com.facebook.ads.redexgen.X.C7W r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A05(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.6m, com.facebook.ads.redexgen.X.7W, boolean):int");
    }

    private int A06(C7W c7w) {
        if (A0W() == 0) {
            return 0;
        }
        A2D();
        return C01837d.A00(c7w, this.A04, A0P(!this.A0B, true), A0O(this.A0B ? false : true, true), this, this.A0B);
    }

    private int A08(C7W c7w) {
        if (A0W() == 0) {
            return 0;
        }
        A2D();
        return C01837d.A02(c7w, this.A04, A0P(!this.A0B, true), A0O(this.A0B ? false : true, true), this, this.A0B, this.A05);
    }

    private int A09(C7W c7w) {
        if (A0W() == 0) {
            return 0;
        }
        A2D();
        return C01837d.A01(c7w, this.A04, A0P(!this.A0B, true), A0O(this.A0B ? false : true, true), this, this.A0B);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int A0A(com.facebook.ads.redexgen.X.C7W r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r4.A06()
            if (r0 == 0) goto L1a
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1c;
                case 4: goto L17;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.6s r0 = r2.A04
            int r1 = r0.A0B()
            r0 = 3
            goto L9
        L17:
            r1 = 0
            r0 = 3
            goto L9
        L1a:
            r0 = 4
            goto L9
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0A(com.facebook.ads.redexgen.X.7W):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:            return r2.A0t(r1);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View A0B() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A05
            if (r0 == 0) goto L18
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1a;
                case 4: goto Le;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r1 = 0
            r0 = 3
            goto L7
        Le:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            int r0 = r2.A0W()
            int r1 = r0 + (-1)
            r0 = 3
            goto L7
        L18:
            r0 = 4
            goto L7
        L1a:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            android.view.View r0 = r2.A0t(r1)
            android.view.View r0 = (android.view.View) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0B():android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:            return r2.A0t(r1);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View A0C() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A05
            if (r0 == 0) goto L18
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1a;
                case 4: goto L15;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            int r0 = r2.A0W()
            int r1 = r0 + (-1)
            r0 = 3
            goto L7
        L15:
            r1 = 0
            r0 = 3
            goto L7
        L18:
            r0 = 4
            goto L7
        L1a:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            android.view.View r0 = r2.A0t(r1)
            android.view.View r0 = (android.view.View) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0C():android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x007c, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.view.View A0D(int r8, int r9) {
        /*
            r7 = this;
            r6 = r7
            r5 = 0
            r4 = 0
            r3 = 0
            r2 = 0
            r6.A2D()
            if (r9 <= r8) goto L75
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L28;
                case 3: goto L2b;
                case 4: goto L31;
                case 5: goto L78;
                case 6: goto Lf;
                case 7: goto L43;
                case 8: goto L4a;
                case 9: goto L56;
                case 10: goto L60;
                case 11: goto L39;
                case 12: goto L67;
                case 13: goto L6f;
                case 14: goto L72;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.6i r6 = (com.facebook.ads.redexgen.X.C01636i) r6
            com.facebook.ads.redexgen.X.6s r1 = r6.A04
            android.view.View r0 = r6.A0t(r8)
            int r1 = r1.A0F(r0)
            com.facebook.ads.redexgen.X.6s r0 = r6.A04
            int r0 = r0.A0A()
            if (r1 >= r0) goto L25
            r0 = 7
            goto Lb
        L25:
            r0 = 10
            goto Lb
        L28:
            r4 = 1
            r0 = 3
            goto Lb
        L2b:
            if (r4 != 0) goto L2f
            r0 = 4
            goto Lb
        L2f:
            r0 = 6
            goto Lb
        L31:
            com.facebook.ads.redexgen.X.6i r6 = (com.facebook.ads.redexgen.X.C01636i) r6
            android.view.View r2 = r6.A0t(r8)
            r0 = 5
            goto Lb
        L39:
            com.facebook.ads.redexgen.X.6i r6 = (com.facebook.ads.redexgen.X.C01636i) r6
            com.facebook.ads.redexgen.X.7i r0 = r6.A05
            android.view.View r2 = r0.A00(r8, r9, r3, r5)
            r0 = 5
            goto Lb
        L43:
            r3 = 16644(0x4104, float:2.3323E-41)
            r5 = 16388(0x4004, float:2.2964E-41)
            r0 = 8
            goto Lb
        L4a:
            com.facebook.ads.redexgen.X.6i r6 = (com.facebook.ads.redexgen.X.C01636i) r6
            int r0 = r6.A00
            if (r0 != 0) goto L53
            r0 = 9
            goto Lb
        L53:
            r0 = 11
            goto Lb
        L56:
            com.facebook.ads.redexgen.X.6i r6 = (com.facebook.ads.redexgen.X.C01636i) r6
            com.facebook.ads.redexgen.X.7i r0 = r6.A04
            android.view.View r2 = r0.A00(r8, r9, r3, r5)
            r0 = 5
            goto Lb
        L60:
            r3 = 4161(0x1041, float:5.831E-42)
            r5 = 4097(0x1001, float:5.741E-42)
            r0 = 8
            goto Lb
        L67:
            if (r9 >= r8) goto L6c
            r0 = 13
            goto Lb
        L6c:
            r0 = 14
            goto Lb
        L6f:
            r4 = -1
            r0 = 3
            goto Lb
        L72:
            r4 = 0
            r0 = 3
            goto Lb
        L75:
            r0 = 12
            goto Lb
        L78:
            android.view.View r2 = (android.view.View) r2
            android.view.View r2 = (android.view.View) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0D(int, int):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0047, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.view.View A0E(int r6, int r7, boolean r8, boolean r9) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r2 = 0
            r4.A2D()
            r1 = 0
            if (r8 == 0) goto L40
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L2e;
                case 3: goto L28;
                case 4: goto L24;
                case 5: goto L19;
                case 6: goto Lf;
                case 7: goto L43;
                case 8: goto L32;
                case 9: goto L3c;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.6i r4 = (com.facebook.ads.redexgen.X.C01636i) r4
            com.facebook.ads.redexgen.X.7i r0 = r4.A04
            android.view.View r3 = r0.A00(r6, r7, r2, r1)
            r0 = 7
            goto Lb
        L19:
            com.facebook.ads.redexgen.X.6i r4 = (com.facebook.ads.redexgen.X.C01636i) r4
            int r0 = r4.A00
            if (r0 != 0) goto L21
            r0 = 6
            goto Lb
        L21:
            r0 = 8
            goto Lb
        L24:
            r1 = 320(0x140, float:4.48E-43)
            r0 = 5
            goto Lb
        L28:
            if (r9 == 0) goto L2c
            r0 = 4
            goto Lb
        L2c:
            r0 = 5
            goto Lb
        L2e:
            r2 = 24579(0x6003, float:3.4443E-41)
            r0 = 3
            goto Lb
        L32:
            com.facebook.ads.redexgen.X.6i r4 = (com.facebook.ads.redexgen.X.C01636i) r4
            com.facebook.ads.redexgen.X.7i r0 = r4.A05
            android.view.View r3 = r0.A00(r6, r7, r2, r1)
            r0 = 7
            goto Lb
        L3c:
            r2 = 320(0x140, float:4.48E-43)
            r0 = 3
            goto Lb
        L40:
            r0 = 9
            goto Lb
        L43:
            android.view.View r3 = (android.view.View) r3
            android.view.View r3 = (android.view.View) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0E(int, int, boolean, boolean):android.view.View");
    }

    private View A0F(C7O c7o, C7W c7w) {
        return A0D(0, A0W());
    }

    private View A0G(C7O c7o, C7W c7w) {
        return A2C(c7o, c7w, 0, A0W(), c7w.A03());
    }

    private View A0H(C7O c7o, C7W c7w) {
        return A0D(A0W() - 1, -1);
    }

    private View A0J(C7O c7o, C7W c7w) {
        return A2C(c7o, c7w, A0W() - 1, -1, c7w.A03());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View A0K(com.facebook.ads.redexgen.X.C7O r4, com.facebook.ads.redexgen.X.C7W r5) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A05
            if (r0 == 0) goto L23
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L25;
                case 4: goto L17;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.7W r5 = (com.facebook.ads.redexgen.X.C7W) r5
            android.view.View r1 = r2.A0F(r4, r5)
            r0 = 3
            goto L7
        L17:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.7W r5 = (com.facebook.ads.redexgen.X.C7W) r5
            android.view.View r1 = r2.A0H(r4, r5)
            r0 = 3
            goto L7
        L23:
            r0 = 4
            goto L7
        L25:
            android.view.View r1 = (android.view.View) r1
            android.view.View r1 = (android.view.View) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0K(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View A0L(com.facebook.ads.redexgen.X.C7O r4, com.facebook.ads.redexgen.X.C7W r5) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A05
            if (r0 == 0) goto L23
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L25;
                case 4: goto L17;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.7W r5 = (com.facebook.ads.redexgen.X.C7W) r5
            android.view.View r1 = r2.A0H(r4, r5)
            r0 = 3
            goto L7
        L17:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.7W r5 = (com.facebook.ads.redexgen.X.C7W) r5
            android.view.View r1 = r2.A0F(r4, r5)
            r0 = 3
            goto L7
        L23:
            r0 = 4
            goto L7
        L25:
            android.view.View r1 = (android.view.View) r1
            android.view.View r1 = (android.view.View) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0L(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View A0M(com.facebook.ads.redexgen.X.C7O r4, com.facebook.ads.redexgen.X.C7W r5) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A05
            if (r0 == 0) goto L23
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L25;
                case 4: goto L17;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.7W r5 = (com.facebook.ads.redexgen.X.C7W) r5
            android.view.View r1 = r2.A0G(r4, r5)
            r0 = 3
            goto L7
        L17:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.7W r5 = (com.facebook.ads.redexgen.X.C7W) r5
            android.view.View r1 = r2.A0J(r4, r5)
            r0 = 3
            goto L7
        L23:
            r0 = 4
            goto L7
        L25:
            android.view.View r1 = (android.view.View) r1
            android.view.View r1 = (android.view.View) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0M(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View A0N(com.facebook.ads.redexgen.X.C7O r4, com.facebook.ads.redexgen.X.C7W r5) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A05
            if (r0 == 0) goto L23
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L25;
                case 4: goto L17;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.7W r5 = (com.facebook.ads.redexgen.X.C7W) r5
            android.view.View r1 = r2.A0J(r4, r5)
            r0 = 3
            goto L7
        L17:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.7W r5 = (com.facebook.ads.redexgen.X.C7W) r5
            android.view.View r1 = r2.A0G(r4, r5)
            r0 = 3
            goto L7
        L23:
            r0 = 4
            goto L7
        L25:
            android.view.View r1 = (android.view.View) r1
            android.view.View r1 = (android.view.View) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0N(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View A0O(boolean r4, boolean r5) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A05
            if (r0 == 0) goto L27
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L29;
                case 4: goto L18;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            r1 = 0
            int r0 = r2.A0W()
            android.view.View r1 = r2.A0E(r1, r0, r4, r5)
            r0 = 3
            goto L7
        L18:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            int r0 = r2.A0W()
            int r1 = r0 + (-1)
            r0 = -1
            android.view.View r1 = r2.A0E(r1, r0, r4, r5)
            r0 = 3
            goto L7
        L27:
            r0 = 4
            goto L7
        L29:
            android.view.View r1 = (android.view.View) r1
            android.view.View r1 = (android.view.View) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0O(boolean, boolean):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View A0P(boolean r4, boolean r5) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A05
            if (r0 == 0) goto L27
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L29;
                case 4: goto L1a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            int r0 = r2.A0W()
            int r1 = r0 + (-1)
            r0 = -1
            android.view.View r1 = r2.A0E(r1, r0, r4, r5)
            r0 = 3
            goto L7
        L1a:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            r1 = 0
            int r0 = r2.A0W()
            android.view.View r1 = r2.A0E(r1, r0, r4, r5)
            r0 = 3
            goto L7
        L27:
            r0 = 4
            goto L7
        L29:
            android.view.View r1 = (android.view.View) r1
            android.view.View r1 = (android.view.View) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0P(boolean, boolean):android.view.View");
    }

    private final C01676m A0Q() {
        return new C01676m();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0035, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0S() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 1
            int r0 = r2.A00
            if (r0 == r1) goto L33
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L27;
                case 3: goto L1f;
                case 4: goto L35;
                case 5: goto L15;
                case 6: goto Lc;
                case 7: goto L12;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            r2.A05 = r1
            r0 = 4
            goto L8
        L12:
            r1 = 0
            r0 = 6
            goto L8
        L15:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            boolean r0 = r2.A0A
            if (r0 != 0) goto L1d
            r0 = 6
            goto L8
        L1d:
            r0 = 7
            goto L8
        L1f:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            boolean r0 = r2.A0A
            r2.A05 = r0
            r0 = 4
            goto L8
        L27:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            boolean r0 = r2.A2J()
            if (r0 != 0) goto L31
            r0 = 3
            goto L8
        L31:
            r0 = 5
            goto L8
        L33:
            r0 = 3
            goto L8
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0S():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:            r1 = r5;        r2.A03 = r4;        r1.A07.A01 = r6;        r1.A07.A05 = 1;        r1.A07.A06 = r7;        r1.A07.A07 = Integer.MIN_VALUE;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0U(int r6, int r7) {
        /*
            r5 = this;
            r4 = 0
            r0 = 0
            r0 = 0
            r3 = 1
            com.facebook.ads.redexgen.X.6m r1 = r5.A07
            com.facebook.ads.redexgen.X.6s r0 = r5.A04
            int r0 = r0.A07()
            int r0 = r0 - r7
            r1.A00 = r0
            com.facebook.ads.redexgen.X.6m r2 = r5.A07
            boolean r0 = r5.A05
            if (r0 == 0) goto L20
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
            r4 = -1
            r0 = 3
            goto L16
        L1d:
            r4 = r3
            r0 = 3
            goto L16
        L20:
            r0 = 4
            goto L16
        L22:
            r1 = r5
            com.facebook.ads.redexgen.X.6i r1 = (com.facebook.ads.redexgen.X.C01636i) r1
            com.facebook.ads.redexgen.X.6m r2 = (com.facebook.ads.redexgen.X.C01676m) r2
            r2.A03 = r4
            com.facebook.ads.redexgen.X.6m r0 = r1.A07
            r0.A01 = r6
            com.facebook.ads.redexgen.X.6m r0 = r1.A07
            r0.A05 = r3
            com.facebook.ads.redexgen.X.6m r0 = r1.A07
            r0.A06 = r7
            com.facebook.ads.redexgen.X.6m r1 = r1.A07
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1.A07 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0U(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:            r1 = r5;        r2.A03 = r4;        r1.A07.A05 = -1;        r1.A07.A06 = r7;        r1.A07.A07 = Integer.MIN_VALUE;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0V(int r6, int r7) {
        /*
            r5 = this;
            r4 = 0
            r0 = 0
            r0 = 0
            r3 = -1
            com.facebook.ads.redexgen.X.6m r1 = r5.A07
            com.facebook.ads.redexgen.X.6s r0 = r5.A04
            int r0 = r0.A0A()
            int r0 = r7 - r0
            r1.A00 = r0
            com.facebook.ads.redexgen.X.6m r0 = r5.A07
            r0.A01 = r6
            com.facebook.ads.redexgen.X.6m r2 = r5.A07
            boolean r0 = r5.A05
            if (r0 == 0) goto L25
            r0 = 2
        L1b:
            switch(r0) {
                case 2: goto L1f;
                case 3: goto L27;
                case 4: goto L22;
                default: goto L1e;
            }
        L1e:
            goto L1b
        L1f:
            r4 = 1
            r0 = 3
            goto L1b
        L22:
            r4 = r3
            r0 = 3
            goto L1b
        L25:
            r0 = 4
            goto L1b
        L27:
            r1 = r5
            com.facebook.ads.redexgen.X.6i r1 = (com.facebook.ads.redexgen.X.C01636i) r1
            com.facebook.ads.redexgen.X.6m r2 = (com.facebook.ads.redexgen.X.C01676m) r2
            r2.A03 = r4
            com.facebook.ads.redexgen.X.6m r0 = r1.A07
            r0.A05 = r3
            com.facebook.ads.redexgen.X.6m r0 = r1.A07
            r0.A06 = r7
            com.facebook.ads.redexgen.X.6m r1 = r1.A07
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1.A07 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0V(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e4, code lost:            r8.A07.A07 = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ea, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0W(int r11, int r12, boolean r13, com.facebook.ads.redexgen.X.C7W r14) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0W(int, int, boolean, com.facebook.ads.redexgen.X.7W):void");
    }

    private void A0X(C01656k c01656k) {
        A0U(c01656k.A01, c01656k.A00);
    }

    private void A0Y(C01656k c01656k) {
        A0V(c01656k.A01, c01656k.A00);
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x00a8, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0Z(com.facebook.ads.redexgen.X.C7O r9, int r10) {
        /*
            r8 = this;
            r7 = r8
            r6 = 0
            r5 = 0
            r4 = 0
            r0 = 0
            r3 = 0
            r1 = 0
            int r2 = r7.A0W()
            if (r10 >= 0) goto La5
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto La8;
                case 3: goto L40;
                case 4: goto L3d;
                case 5: goto L25;
                case 6: goto L12;
                case 7: goto L2b;
                case 8: goto L52;
                case 9: goto L66;
                case 10: goto L5c;
                case 11: goto L6a;
                case 12: goto L71;
                case 13: goto L85;
                case 14: goto L99;
                case 15: goto L61;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            android.view.View r4 = r7.A0t(r3)
            com.facebook.ads.redexgen.X.6s r0 = r7.A04
            int r0 = r0.A0F(r4)
            if (r0 < r1) goto L22
            r0 = 7
            goto Le
        L22:
            r0 = 8
            goto Le
        L25:
            if (r3 >= r2) goto L29
            r0 = 6
            goto Le
        L29:
            r0 = 2
            goto Le
        L2b:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            android.view.View r4 = (android.view.View) r4
            com.facebook.ads.redexgen.X.6s r0 = r7.A04
            int r0 = r0.A0H(r4)
            if (r0 >= r1) goto L3a
            r0 = 8
            goto Le
        L3a:
            r0 = 9
            goto Le
        L3d:
            r3 = 0
            r0 = 5
            goto Le
        L40:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            com.facebook.ads.redexgen.X.6s r0 = r7.A04
            int r1 = r0.A06()
            int r1 = r1 - r10
            boolean r0 = r7.A05
            if (r0 == 0) goto L4f
            r0 = 4
            goto Le
        L4f:
            r0 = 10
            goto Le
        L52:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            com.facebook.ads.redexgen.X.7O r9 = (com.facebook.ads.redexgen.X.C7O) r9
            r0 = 0
            r7.A0b(r9, r0, r3)
            r0 = 2
            goto Le
        L5c:
            int r5 = r2 + (-1)
            r0 = 11
            goto Le
        L61:
            int r5 = r5 + (-1)
            r0 = 11
            goto Le
        L66:
            int r3 = r3 + 1
            r0 = 5
            goto Le
        L6a:
            if (r5 < 0) goto L6f
            r0 = 12
            goto Le
        L6f:
            r0 = 2
            goto Le
        L71:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            android.view.View r6 = r7.A0t(r5)
            com.facebook.ads.redexgen.X.6s r0 = r7.A04
            int r0 = r0.A0F(r6)
            if (r0 < r1) goto L82
            r0 = 13
            goto Le
        L82:
            r0 = 14
            goto Le
        L85:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            android.view.View r6 = (android.view.View) r6
            com.facebook.ads.redexgen.X.6s r0 = r7.A04
            int r0 = r0.A0H(r6)
            if (r0 >= r1) goto L95
            r0 = 14
            goto Le
        L95:
            r0 = 15
            goto Le
        L99:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            com.facebook.ads.redexgen.X.7O r9 = (com.facebook.ads.redexgen.X.C7O) r9
            int r0 = r2 + (-1)
            r7.A0b(r9, r0, r5)
            r0 = 2
            goto Le
        La5:
            r0 = 3
            goto Le
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0Z(com.facebook.ads.redexgen.X.7O, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x00a2, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0a(com.facebook.ads.redexgen.X.C7O r9, int r10) {
        /*
            r8 = this;
            r7 = r8
            r6 = 0
            r5 = 0
            r4 = 0
            r3 = 0
            r2 = 0
            r1 = 0
            if (r10 >= 0) goto L9f
            r0 = 2
        La:
            switch(r0) {
                case 2: goto La2;
                case 3: goto L2b;
                case 4: goto L27;
                case 5: goto L21;
                case 6: goto Le;
                case 7: goto L46;
                case 8: goto L5c;
                case 9: goto L3b;
                case 10: goto L58;
                case 11: goto L3f;
                case 12: goto L67;
                case 13: goto L7b;
                case 14: goto L8e;
                case 15: goto L99;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            android.view.View r4 = r7.A0t(r2)
            com.facebook.ads.redexgen.X.6s r0 = r7.A04
            int r0 = r0.A0C(r4)
            if (r0 > r1) goto L1e
            r0 = 7
            goto La
        L1e:
            r0 = 8
            goto La
        L21:
            if (r2 < 0) goto L25
            r0 = 6
            goto La
        L25:
            r0 = 2
            goto La
        L27:
            int r2 = r3 + (-1)
            r0 = 5
            goto La
        L2b:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            r1 = r10
            int r3 = r7.A0W()
            boolean r0 = r7.A05
            if (r0 == 0) goto L38
            r0 = 4
            goto La
        L38:
            r0 = 10
            goto La
        L3b:
            int r2 = r2 + (-1)
            r0 = 5
            goto La
        L3f:
            if (r5 >= r3) goto L44
            r0 = 12
            goto La
        L44:
            r0 = 2
            goto La
        L46:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            android.view.View r4 = (android.view.View) r4
            com.facebook.ads.redexgen.X.6s r0 = r7.A04
            int r0 = r0.A0G(r4)
            if (r0 <= r1) goto L55
            r0 = 8
            goto La
        L55:
            r0 = 9
            goto La
        L58:
            r5 = 0
            r0 = 11
            goto La
        L5c:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            com.facebook.ads.redexgen.X.7O r9 = (com.facebook.ads.redexgen.X.C7O) r9
            int r0 = r3 + (-1)
            r7.A0b(r9, r0, r2)
            r0 = 2
            goto La
        L67:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            android.view.View r6 = r7.A0t(r5)
            com.facebook.ads.redexgen.X.6s r0 = r7.A04
            int r0 = r0.A0C(r6)
            if (r0 > r1) goto L78
            r0 = 13
            goto La
        L78:
            r0 = 14
            goto La
        L7b:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            android.view.View r6 = (android.view.View) r6
            com.facebook.ads.redexgen.X.6s r0 = r7.A04
            int r0 = r0.A0G(r6)
            if (r0 <= r1) goto L8a
            r0 = 14
            goto La
        L8a:
            r0 = 15
            goto La
        L8e:
            com.facebook.ads.redexgen.X.6i r7 = (com.facebook.ads.redexgen.X.C01636i) r7
            com.facebook.ads.redexgen.X.7O r9 = (com.facebook.ads.redexgen.X.C7O) r9
            r0 = 0
            r7.A0b(r9, r0, r5)
            r0 = 2
            goto La
        L99:
            int r5 = r5 + 1
            r0 = 11
            goto La
        L9f:
            r0 = 3
            goto La
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0a(com.facebook.ads.redexgen.X.7O, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x003e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0b(com.facebook.ads.redexgen.X.C7O r5, int r6, int r7) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r1 = 0
            if (r6 != r7) goto L3c
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L3e;
                case 3: goto L1f;
                case 4: goto L1b;
                case 5: goto L15;
                case 6: goto La;
                case 7: goto L25;
                case 8: goto L29;
                case 9: goto L30;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.6i r3 = (com.facebook.ads.redexgen.X.C01636i) r3
            com.facebook.ads.redexgen.X.7O r5 = (com.facebook.ads.redexgen.X.C7O) r5
            r3.A14(r1, r5)
            int r1 = r1 + (-1)
            r0 = 5
            goto L6
        L15:
            if (r1 < r6) goto L19
            r0 = 6
            goto L6
        L19:
            r0 = 2
            goto L6
        L1b:
            int r1 = r7 + (-1)
            r0 = 5
            goto L6
        L1f:
            if (r7 <= r6) goto L23
            r0 = 4
            goto L6
        L23:
            r0 = 7
            goto L6
        L25:
            r2 = r6
            r0 = 8
            goto L6
        L29:
            if (r2 <= r7) goto L2e
            r0 = 9
            goto L6
        L2e:
            r0 = 2
            goto L6
        L30:
            com.facebook.ads.redexgen.X.6i r3 = (com.facebook.ads.redexgen.X.C01636i) r3
            com.facebook.ads.redexgen.X.7O r5 = (com.facebook.ads.redexgen.X.C7O) r5
            r3.A14(r2, r5)
            int r2 = r2 + (-1)
            r0 = 8
            goto L6
        L3c:
            r0 = 3
            goto L6
        L3e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0b(com.facebook.ads.redexgen.X.7O, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x003b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0c(com.facebook.ads.redexgen.X.C7O r4, com.facebook.ads.redexgen.X.C01676m r5) {
        /*
            r3 = this;
            r2 = r3
            boolean r0 = r5.A0B
            if (r0 == 0) goto L39
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L3b;
                case 4: goto L14;
                case 5: goto L1f;
                case 6: goto L2c;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.6m r5 = (com.facebook.ads.redexgen.X.C01676m) r5
            boolean r0 = r5.A09
            if (r0 == 0) goto L12
            r0 = 3
            goto L6
        L12:
            r0 = 4
            goto L6
        L14:
            com.facebook.ads.redexgen.X.6m r5 = (com.facebook.ads.redexgen.X.C01676m) r5
            int r1 = r5.A05
            r0 = -1
            if (r1 != r0) goto L1d
            r0 = 5
            goto L6
        L1d:
            r0 = 6
            goto L6
        L1f:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.6m r5 = (com.facebook.ads.redexgen.X.C01676m) r5
            int r0 = r5.A07
            r2.A0Z(r4, r0)
            r0 = 3
            goto L6
        L2c:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.6m r5 = (com.facebook.ads.redexgen.X.C01676m) r5
            int r0 = r5.A07
            r2.A0a(r4, r0)
            r0 = 3
            goto L6
        L39:
            r0 = 3
            goto L6
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0c(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.6m):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x014b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0d(com.facebook.ads.redexgen.X.C7O r13, com.facebook.ads.redexgen.X.C7W r14, int r15, int r16) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0d(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0043, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0e(com.facebook.ads.redexgen.X.C7O r4, com.facebook.ads.redexgen.X.C7W r5, com.facebook.ads.redexgen.X.C01656k r6) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0i(r5, r6)
            if (r0 == 0) goto L41
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L43;
                case 3: goto L2f;
                case 4: goto L20;
                case 5: goto L16;
                case 6: goto Ld;
                case 7: goto L13;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.6k r6 = (com.facebook.ads.redexgen.X.C01656k) r6
            r6.A01 = r1
            r0 = 2
            goto L9
        L13:
            r1 = 0
            r0 = 6
            goto L9
        L16:
            com.facebook.ads.redexgen.X.7W r5 = (com.facebook.ads.redexgen.X.C7W) r5
            int r0 = r5.A03()
            int r1 = r0 + (-1)
            r0 = 6
            goto L9
        L20:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.6k r6 = (com.facebook.ads.redexgen.X.C01656k) r6
            r6.A02()
            boolean r0 = r2.A0C
            if (r0 == 0) goto L2d
            r0 = 5
            goto L9
        L2d:
            r0 = 7
            goto L9
        L2f:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.7W r5 = (com.facebook.ads.redexgen.X.C7W) r5
            com.facebook.ads.redexgen.X.6k r6 = (com.facebook.ads.redexgen.X.C01656k) r6
            boolean r0 = r2.A0h(r4, r5, r6)
            if (r0 != 0) goto L3f
            r0 = 4
            goto L9
        L3f:
            r0 = 2
            goto L9
        L41:
            r0 = 3
            goto L9
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0e(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W, com.facebook.ads.redexgen.X.6k):void");
    }

    private final void A0f(boolean z) {
        A22(null);
        if (z == this.A0A) {
            return;
        }
        this.A0A = z;
        A0y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0025, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0g() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.6s r0 = r2.A04
            int r0 = r0.A09()
            if (r0 != 0) goto L23
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L1d;
                case 4: goto L25;
                case 5: goto L20;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.6s r0 = r2.A04
            int r0 = r0.A06()
            if (r0 != 0) goto L1b
            r0 = 3
            goto Lb
        L1b:
            r0 = 5
            goto Lb
        L1d:
            r1 = 1
            r0 = 4
            goto Lb
        L20:
            r1 = 0
            r0 = 4
            goto Lb
        L23:
            r0 = 5
            goto Lb
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0g():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x0117, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0h(com.facebook.ads.redexgen.X.C7O r10, com.facebook.ads.redexgen.X.C7W r11, com.facebook.ads.redexgen.X.C01656k r12) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0h(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W, com.facebook.ads.redexgen.X.6k):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:203:0x020c, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0i(com.facebook.ads.redexgen.X.C7W r11, com.facebook.ads.redexgen.X.C01656k r12) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A0i(com.facebook.ads.redexgen.X.7W, com.facebook.ads.redexgen.X.6k):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int A1h(int r5, com.facebook.ads.redexgen.X.C7O r6, com.facebook.ads.redexgen.X.C7W r7) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            int r1 = r3.A00
            r0 = 1
            if (r1 != r0) goto L1b
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1d;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r2 = 0
            r0 = 3
            goto L8
        Lf:
            com.facebook.ads.redexgen.X.6i r3 = (com.facebook.ads.redexgen.X.C01636i) r3
            com.facebook.ads.redexgen.X.7O r6 = (com.facebook.ads.redexgen.X.C7O) r6
            com.facebook.ads.redexgen.X.7W r7 = (com.facebook.ads.redexgen.X.C7W) r7
            int r2 = r3.A02(r5, r6, r7)
            r0 = 3
            goto L8
        L1b:
            r0 = 4
            goto L8
        L1d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A1h(int, com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int A1i(int r4, com.facebook.ads.redexgen.X.C7O r5, com.facebook.ads.redexgen.X.C7W r6) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            int r0 = r2.A00
            if (r0 != 0) goto L1a
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1c;
                case 4: goto Le;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r1 = 0
            r0 = 3
            goto L7
        Le:
            com.facebook.ads.redexgen.X.6i r2 = (com.facebook.ads.redexgen.X.C01636i) r2
            com.facebook.ads.redexgen.X.7O r5 = (com.facebook.ads.redexgen.X.C7O) r5
            com.facebook.ads.redexgen.X.7W r6 = (com.facebook.ads.redexgen.X.C7W) r6
            int r1 = r2.A02(r4, r5, r6)
            r0 = 3
            goto L7
        L1a:
            r0 = 4
            goto L7
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A1i(int, com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W):int");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public final int A1j(C7W c7w) {
        return A06(c7w);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public final int A1k(C7W c7w) {
        return A08(c7w);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public final int A1l(C7W c7w) {
        return A09(c7w);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public final int A1m(C7W c7w) {
        return A06(c7w);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public final int A1n(C7W c7w) {
        return A08(c7w);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public final int A1o(C7W c7w) {
        return A09(c7w);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0087, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Parcelable A1p() {
        /*
            r5 = this;
            r3 = r5
            r2 = 0
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r0 = r3.A03
            if (r0 == 0) goto L81
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L6f;
                case 3: goto L83;
                case 4: goto L5d;
                case 5: goto L49;
                case 6: goto Lb;
                case 7: goto L2a;
                case 8: goto L7a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.6i r3 = (com.facebook.ads.redexgen.X.C01636i) r3
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r2 = (com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState) r2
            android.view.View r4 = r3.A0B()
            com.facebook.ads.redexgen.X.6s r0 = r3.A04
            int r1 = r0.A07()
            com.facebook.ads.redexgen.X.6s r0 = r3.A04
            int r0 = r0.A0C(r4)
            int r1 = r1 - r0
            r2.A00 = r1
            int r0 = r3.A0p(r4)
            r2.A01 = r0
            r0 = 3
            goto L7
        L2a:
            com.facebook.ads.redexgen.X.6i r3 = (com.facebook.ads.redexgen.X.C01636i) r3
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r2 = (com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState) r2
            android.view.View r1 = r3.A0C()
            int r0 = r3.A0p(r1)
            r2.A01 = r0
            com.facebook.ads.redexgen.X.6s r0 = r3.A04
            int r1 = r0.A0F(r1)
            com.facebook.ads.redexgen.X.6s r0 = r3.A04
            int r0 = r0.A0A()
            int r1 = r1 - r0
            r2.A00 = r1
            r0 = 3
            goto L7
        L49:
            com.facebook.ads.redexgen.X.6i r3 = (com.facebook.ads.redexgen.X.C01636i) r3
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r2 = (com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState) r2
            r3.A2D()
            boolean r1 = r3.A08
            boolean r0 = r3.A05
            r1 = r1 ^ r0
            r2.A02 = r1
            if (r1 == 0) goto L5b
            r0 = 6
            goto L7
        L5b:
            r0 = 7
            goto L7
        L5d:
            com.facebook.ads.redexgen.X.6i r3 = (com.facebook.ads.redexgen.X.C01636i) r3
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r2 = new com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState
            r2.<init>()
            int r0 = r3.A0W()
            if (r0 <= 0) goto L6c
            r0 = 5
            goto L7
        L6c:
            r0 = 8
            goto L7
        L6f:
            com.facebook.ads.redexgen.X.6i r3 = (com.facebook.ads.redexgen.X.C01636i) r3
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r2 = new com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r0 = r3.A03
            r2.<init>(r0)
            r0 = 3
            goto L7
        L7a:
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r2 = (com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState) r2
            r2.A00()
            r0 = 3
            goto L7
        L81:
            r0 = 4
            goto L7
        L83:
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r2 = (com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState) r2
            android.os.Parcelable r2 = (android.os.Parcelable) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A1p():android.os.Parcelable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0047, code lost:            return r3;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View A1q(int r6) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r3 = 0
            r2 = 0
            int r1 = r4.A0W()
            if (r1 != 0) goto L43
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L40;
                case 3: goto L45;
                case 4: goto L1f;
                case 5: goto L3a;
                case 6: goto Lf;
                case 7: goto L32;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.6i r4 = (com.facebook.ads.redexgen.X.C01636i) r4
            android.view.View r3 = r4.A0t(r2)
            int r0 = r4.A0p(r3)
            if (r0 == r6) goto L1d
            r0 = 7
            goto Lb
        L1d:
            r0 = 3
            goto Lb
        L1f:
            com.facebook.ads.redexgen.X.6i r4 = (com.facebook.ads.redexgen.X.C01636i) r4
            r0 = 0
            android.view.View r0 = r4.A0t(r0)
            int r0 = r4.A0p(r0)
            int r2 = r6 - r0
            if (r2 < 0) goto L30
            r0 = 5
            goto Lb
        L30:
            r0 = 7
            goto Lb
        L32:
            com.facebook.ads.redexgen.X.6i r4 = (com.facebook.ads.redexgen.X.C01636i) r4
            android.view.View r3 = super.A1q(r6)
            r0 = 3
            goto Lb
        L3a:
            if (r2 >= r1) goto L3e
            r0 = 6
            goto Lb
        L3e:
            r0 = 7
            goto Lb
        L40:
            r3 = 0
            r0 = 3
            goto Lb
        L43:
            r0 = 4
            goto Lb
        L45:
            android.view.View r3 = (android.view.View) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A1q(int):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x00b9, code lost:            return r4;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View A1r(android.view.View r10, int r11, com.facebook.ads.redexgen.X.C7O r12, com.facebook.ads.redexgen.X.C7W r13) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A1r(android.view.View, int, com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W):android.view.View");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public C01596e A1s() {
        return new C01596e(-2, -2);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public void A1t(int i) {
        this.A01 = i;
        this.A02 = Integer.MIN_VALUE;
        if (this.A03 != null) {
            this.A03.A00();
        }
        A0y();
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0051, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1u(int r6, int r7, com.facebook.ads.redexgen.X.C7W r8, com.facebook.ads.redexgen.X.C6Y r9) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r2 = 0
            r0 = 0
            r1 = 1
            int r0 = r4.A00
            if (r0 != 0) goto L4e
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L20;
                case 3: goto L23;
                case 4: goto L1a;
                case 5: goto L51;
                case 6: goto Le;
                case 7: goto L32;
                case 8: goto L36;
                case 9: goto L4a;
                case 10: goto L2f;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.6i r4 = (com.facebook.ads.redexgen.X.C01636i) r4
            r4.A2D()
            if (r2 <= 0) goto L17
            r0 = 7
            goto La
        L17:
            r0 = 9
            goto La
        L1a:
            if (r2 != 0) goto L1e
            r0 = 5
            goto La
        L1e:
            r0 = 6
            goto La
        L20:
            r2 = r6
            r0 = 3
            goto La
        L23:
            com.facebook.ads.redexgen.X.6i r4 = (com.facebook.ads.redexgen.X.C01636i) r4
            int r0 = r4.A0W()
            if (r0 == 0) goto L2d
            r0 = 4
            goto La
        L2d:
            r0 = 5
            goto La
        L2f:
            r2 = r7
            r0 = 3
            goto La
        L32:
            r3 = r1
            r0 = 8
            goto La
        L36:
            com.facebook.ads.redexgen.X.6i r4 = (com.facebook.ads.redexgen.X.C01636i) r4
            com.facebook.ads.redexgen.X.7W r8 = (com.facebook.ads.redexgen.X.C7W) r8
            com.facebook.ads.redexgen.X.6Y r9 = (com.facebook.ads.redexgen.X.C6Y) r9
            int r0 = java.lang.Math.abs(r2)
            r4.A0W(r3, r0, r1, r8)
            com.facebook.ads.redexgen.X.6m r0 = r4.A07
            r4.A2I(r8, r0, r9)
            r0 = 5
            goto La
        L4a:
            r3 = -1
            r0 = 8
            goto La
        L4e:
            r0 = 10
            goto La
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A1u(int, int, com.facebook.ads.redexgen.X.7W, com.facebook.ads.redexgen.X.6Y):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x008a, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1v(int r9, com.facebook.ads.redexgen.X.C6Y r10) {
        /*
            r8 = this;
            r6 = r8
            r0 = 0
            r0 = 0
            r7 = 0
            r5 = 0
            r4 = 0
            r3 = 0
            r2 = 0
            r1 = -1
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r0 = r6.A03
            if (r0 == 0) goto L87
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L44;
                case 3: goto L38;
                case 4: goto L31;
                case 5: goto L25;
                case 6: goto L12;
                case 7: goto L53;
                case 8: goto L1d;
                case 9: goto L5b;
                case 10: goto L6b;
                case 11: goto L6e;
                case 12: goto L7f;
                case 13: goto L29;
                case 14: goto L2d;
                case 15: goto L65;
                case 16: goto L8a;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.6i r6 = (com.facebook.ads.redexgen.X.C01636i) r6
            int r0 = r6.A06
            if (r4 >= r0) goto L1a
            r0 = 7
            goto Le
        L1a:
            r0 = 16
            goto Le
        L1d:
            if (r3 >= r9) goto L22
            r0 = 9
            goto Le
        L22:
            r0 = 16
            goto Le
        L25:
            r3 = r5
            r4 = 0
            r0 = 6
            goto Le
        L29:
            int r5 = r9 + (-1)
            r0 = 4
            goto Le
        L2d:
            r2 = 0
            r5 = r2
            r0 = 4
            goto Le
        L31:
            if (r7 == 0) goto L35
            r0 = 5
            goto Le
        L35:
            r0 = 10
            goto Le
        L38:
            com.facebook.ads.redexgen.X.6i r6 = (com.facebook.ads.redexgen.X.C01636i) r6
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r0 = r6.A03
            boolean r7 = r0.A02
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r0 = r6.A03
            int r5 = r0.A01
            r0 = 4
            goto Le
        L44:
            com.facebook.ads.redexgen.X.6i r6 = (com.facebook.ads.redexgen.X.C01636i) r6
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r0 = r6.A03
            boolean r0 = r0.A01()
            if (r0 == 0) goto L50
            r0 = 3
            goto Le
        L50:
            r0 = 11
            goto Le
        L53:
            if (r3 < 0) goto L58
            r0 = 8
            goto Le
        L58:
            r0 = 16
            goto Le
        L5b:
            com.facebook.ads.redexgen.X.6Y r10 = (com.facebook.ads.redexgen.X.C6Y) r10
            r10.A37(r3, r2)
            int r3 = r3 + r1
            int r4 = r4 + 1
            r0 = 6
            goto Le
        L65:
            com.facebook.ads.redexgen.X.6i r6 = (com.facebook.ads.redexgen.X.C01636i) r6
            int r5 = r6.A01
            r0 = 4
            goto Le
        L6b:
            r1 = 1
            r0 = 5
            goto Le
        L6e:
            com.facebook.ads.redexgen.X.6i r6 = (com.facebook.ads.redexgen.X.C01636i) r6
            r6.A0S()
            boolean r7 = r6.A05
            int r0 = r6.A01
            if (r0 != r1) goto L7c
            r0 = 12
            goto Le
        L7c:
            r0 = 15
            goto Le
        L7f:
            if (r7 == 0) goto L84
            r0 = 13
            goto Le
        L84:
            r0 = 14
            goto Le
        L87:
            r0 = 11
            goto Le
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A1v(int, com.facebook.ads.redexgen.X.6Y):void");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public final void A1w(Parcelable parcelable) {
        if (parcelable instanceof LinearLayoutManager$SavedState) {
            this.A03 = (LinearLayoutManager$SavedState) parcelable;
            A0y();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public final void A1x(AccessibilityEvent accessibilityEvent) {
        super.A1x(accessibilityEvent);
        if (A0W() > 0) {
            accessibilityEvent.setFromIndex(A28());
            accessibilityEvent.setToIndex(A29());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:328:0x03e4, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A1y(com.facebook.ads.redexgen.X.C7O r20, com.facebook.ads.redexgen.X.C7W r21) {
        /*
            Method dump skipped, instructions count: 1106
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A1y(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W):void");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public void A1z(C7W c7w) {
        super.A1z(c7w);
        this.A03 = null;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A0D.A03();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public final void A20(C01807a c01807a, C7O c7o) {
        super.A20(c01807a, c7o);
        if (this.A09) {
            A1I(c7o);
            c7o.A0P();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public void A21(C01807a c01807a, C7W c7w, int i) {
        C01706q c01706q = new C01706q(c01807a.getContext());
        c01706q.A0A(i);
        A1L(c01706q);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public final void A22(String str) {
        if (this.A03 == null) {
            super.A22(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0030, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A23() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            r1 = 1073741824(0x40000000, float:2.0)
            int r0 = r3.A0Y()
            if (r0 == r1) goto L2e
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L1c;
                case 4: goto L28;
                case 5: goto L30;
                case 6: goto L2b;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.6i r3 = (com.facebook.ads.redexgen.X.C01636i) r3
            int r0 = r3.A0i()
            if (r0 == r1) goto L1a
            r0 = 3
            goto Lc
        L1a:
            r0 = 6
            goto Lc
        L1c:
            com.facebook.ads.redexgen.X.6i r3 = (com.facebook.ads.redexgen.X.C01636i) r3
            boolean r0 = r3.A1W()
            if (r0 == 0) goto L26
            r0 = 4
            goto Lc
        L26:
            r0 = 6
            goto Lc
        L28:
            r2 = 1
            r0 = 5
            goto Lc
        L2b:
            r2 = 0
            r0 = 5
            goto Lc
        L2e:
            r0 = 6
            goto Lc
        L30:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A23():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0012, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A24() {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A00
            if (r0 != 0) goto L10
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L12;
                case 4: goto Ld;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            r1 = 1
            r0 = 3
            goto L6
        Ld:
            r1 = 0
            r0 = 3
            goto L6
        L10:
            r0 = 4
            goto L6
        L12:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A24():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    public final boolean A25() {
        return this.A00 == 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x001f, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean A26() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r0 = r3.A03
            if (r0 != 0) goto L1d
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L17;
                case 4: goto L1f;
                case 5: goto L1a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.6i r3 = (com.facebook.ads.redexgen.X.C01636i) r3
            boolean r1 = r3.A08
            boolean r0 = r3.A0C
            if (r1 != r0) goto L15
            r0 = 3
            goto L7
        L15:
            r0 = 5
            goto L7
        L17:
            r2 = 1
            r0 = 4
            goto L7
        L1a:
            r2 = 0
            r0 = 4
            goto L7
        L1d:
            r0 = 5
            goto L7
        L1f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A26():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A27() {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r3 = 0
            r2 = 0
            int r1 = r4.A0W()
            r0 = 1
            android.view.View r1 = r4.A0E(r2, r1, r0, r2)
            if (r1 != 0) goto L21
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L23;
                case 4: goto L17;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            r3 = -1
            r0 = 3
            goto L10
        L17:
            com.facebook.ads.redexgen.X.6i r4 = (com.facebook.ads.redexgen.X.C01636i) r4
            android.view.View r1 = (android.view.View) r1
            int r3 = r4.A0p(r1)
            r0 = 3
            goto L10
        L21:
            r0 = 4
            goto L10
        L23:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A27():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A28() {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r3 = 0
            r2 = 0
            int r1 = r4.A0W()
            r0 = 1
            android.view.View r1 = r4.A0E(r2, r1, r2, r0)
            if (r1 != 0) goto L21
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L23;
                case 4: goto L17;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            r3 = -1
            r0 = 3
            goto L10
        L17:
            com.facebook.ads.redexgen.X.6i r4 = (com.facebook.ads.redexgen.X.C01636i) r4
            android.view.View r1 = (android.view.View) r1
            int r3 = r4.A0p(r1)
            r0 = 3
            goto L10
        L21:
            r0 = 4
            goto L10
        L23:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A28():int");
    }

    public final int A29() {
        View A0E = A0E(A0W() - 1, -1, false, true);
        if (A0E == null) {
            return -1;
        }
        return A0p(A0E);
    }

    public final int A2A() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x00a2, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A2B(int r6) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A2B(int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x00b9, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View A2C(com.facebook.ads.redexgen.X.C7O r11, com.facebook.ads.redexgen.X.C7W r12, int r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A2C(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W, int, int, int):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A2D() {
        /*
            r2 = this;
            r1 = r2
            com.facebook.ads.redexgen.X.6m r0 = r1.A07
            if (r0 != 0) goto L2a
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L14;
                case 4: goto L1e;
                case 5: goto L2c;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.6i r1 = (com.facebook.ads.redexgen.X.C01636i) r1
            com.facebook.ads.redexgen.X.6m r0 = r1.A0Q()
            r1.A07 = r0
            r0 = 3
            goto L6
        L14:
            com.facebook.ads.redexgen.X.6i r1 = (com.facebook.ads.redexgen.X.C01636i) r1
            com.facebook.ads.redexgen.X.6s r0 = r1.A04
            if (r0 != 0) goto L1c
            r0 = 4
            goto L6
        L1c:
            r0 = 5
            goto L6
        L1e:
            com.facebook.ads.redexgen.X.6i r1 = (com.facebook.ads.redexgen.X.C01636i) r1
            int r0 = r1.A00
            com.facebook.ads.redexgen.X.6s r0 = com.facebook.ads.redexgen.X.AbstractC01726s.A02(r1, r0)
            r1.A04 = r0
            r0 = 5
            goto L6
        L2a:
            r0 = 3
            goto L6
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A2D():void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0006. Please report as an issue. */
    public final void A2E(int i) {
        C01636i c01636i = this;
        AbstractC01726s abstractC01726s = null;
        char c = i != 0 ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    c = i != 1 ? (char) 3 : (char) 4;
                case 3:
                    throw new IllegalArgumentException(A0R(0, 20, 0) + i);
                case 4:
                    c01636i = c01636i;
                    abstractC01726s = null;
                    c01636i.A22(null);
                    c = i == c01636i.A00 ? (char) 5 : (char) 6;
                case 5:
                    return;
                case 6:
                    c01636i = c01636i;
                    c01636i.A00 = i;
                    c01636i.A04 = abstractC01726s;
                    c01636i.A0y();
                    c = 5;
            }
        }
    }

    public final void A2F(int i, int i2) {
        this.A01 = i;
        this.A02 = i2;
        if (this.A03 != null) {
            this.A03.A00();
        }
        A0y();
    }

    public void A2G(C7O c7o, C7W c7w, C01656k c01656k, int i) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:157:0x01bd, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A2H(com.facebook.ads.redexgen.X.C7O r24, com.facebook.ads.redexgen.X.C7W r25, com.facebook.ads.redexgen.X.C01676m r26, com.facebook.ads.redexgen.X.C01666l r27) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A2H(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W, com.facebook.ads.redexgen.X.6m, com.facebook.ads.redexgen.X.6l):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A2I(com.facebook.ads.redexgen.X.C7W r4, com.facebook.ads.redexgen.X.C01676m r5, com.facebook.ads.redexgen.X.C6Y r6) {
        /*
            r3 = this;
            r0 = 0
            int r2 = r5.A01
            if (r2 < 0) goto L26
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L16;
                case 4: goto L28;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7W r4 = (com.facebook.ads.redexgen.X.C7W) r4
            int r0 = r4.A03()
            if (r2 >= r0) goto L14
            r0 = 3
            goto L6
        L14:
            r0 = 4
            goto L6
        L16:
            com.facebook.ads.redexgen.X.6m r5 = (com.facebook.ads.redexgen.X.C01676m) r5
            com.facebook.ads.redexgen.X.6Y r6 = (com.facebook.ads.redexgen.X.C6Y) r6
            r1 = 0
            int r0 = r5.A07
            int r0 = java.lang.Math.max(r1, r0)
            r6.A37(r2, r0)
            r0 = 4
            goto L6
        L26:
            r0 = 4
            goto L6
        L28:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A2I(com.facebook.ads.redexgen.X.7W, com.facebook.ads.redexgen.X.6m, com.facebook.ads.redexgen.X.6Y):void");
    }

    public final boolean A2J() {
        return A0a() == 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0060, code lost:            return r3;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC01626h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.PointF A3i(int r8) {
        /*
            r7 = this;
            r5 = r7
            r4 = 0
            r3 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r6 = 1
            r2 = 0
            r0 = 0
            int r0 = r5.A0W()
            if (r0 != 0) goto L5c
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L48;
                case 3: goto L5e;
                case 4: goto L17;
                case 5: goto L14;
                case 6: goto L28;
                case 7: goto L4b;
                case 8: goto L33;
                case 9: goto L4f;
                case 10: goto L58;
                case 11: goto L3f;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            r2 = r6
            r0 = 6
            goto L10
        L17:
            com.facebook.ads.redexgen.X.6i r5 = (com.facebook.ads.redexgen.X.C01636i) r5
            r2 = 0
            android.view.View r0 = r5.A0t(r2)
            int r0 = r5.A0p(r0)
            if (r8 >= r0) goto L26
            r0 = 5
            goto L10
        L26:
            r0 = 6
            goto L10
        L28:
            com.facebook.ads.redexgen.X.6i r5 = (com.facebook.ads.redexgen.X.C01636i) r5
            boolean r0 = r5.A05
            if (r2 == r0) goto L30
            r0 = 7
            goto L10
        L30:
            r0 = 10
            goto L10
        L33:
            com.facebook.ads.redexgen.X.6i r5 = (com.facebook.ads.redexgen.X.C01636i) r5
            int r0 = r5.A00
            if (r0 != 0) goto L3c
            r0 = 9
            goto L10
        L3c:
            r0 = 11
            goto L10
        L3f:
            r1 = 0
            android.graphics.PointF r3 = new android.graphics.PointF
            float r0 = (float) r4
            r3.<init>(r1, r0)
            r0 = 3
            goto L10
        L48:
            r3 = 0
            r0 = 3
            goto L10
        L4b:
            r4 = -1
            r0 = 8
            goto L10
        L4f:
            r1 = 0
            android.graphics.PointF r3 = new android.graphics.PointF
            float r0 = (float) r4
            r3.<init>(r0, r1)
            r0 = 3
            goto L10
        L58:
            r4 = r6
            r0 = 8
            goto L10
        L5c:
            r0 = 4
            goto L10
        L5e:
            android.graphics.PointF r3 = (android.graphics.PointF) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01636i.A3i(int):android.graphics.PointF");
    }
}
