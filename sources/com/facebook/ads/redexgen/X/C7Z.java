package com.facebook.ads.redexgen.X;

import android.support.annotation.VisibleForTesting;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.7Z, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C7Z {
    public static byte[] A0I;
    public static final List<Object> A0J;
    public C01807a A08;
    public WeakReference<C01807a> A09;
    public int A0C;
    public final View A0H;
    public int A03 = -1;
    public int A01 = -1;
    public long A05 = -1;
    public int A00 = -1;
    public int A04 = -1;
    public C7Z A06 = null;
    public C7Z A07 = null;
    public List<Object> A0A = null;
    public List<Object> A0B = null;
    public int A0D = 0;
    public C7O A0F = null;
    public boolean A0G = false;
    public int A0E = 0;

    @VisibleForTesting
    public int A02 = -1;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C7Z.A0I
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
            int r0 = r0 + (-57)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A02(int, int, int):java.lang.String");
    }

    public static void A04() {
        A0I = new byte[]{-84, -1, -17, -2, -19, -4, -84, -63, 22, 15, 5, 6, 7, 10, 15, 6, 5, -63, 2, 5, 2, 17, 21, 6, 19, -63, 17, 16, 20, 10, 21, 10, 16, 15, -73, 7, 6, 10, 0, 11, 0, 6, 5, -44, 20, -80, 4, -3, 0, -44, -11, 4, -15, -13, -8, -11, -12, 105, -73, -72, 105, -71, -86, -69, -82, -73, -67, -12, -4, 1, -6, 7, 0, -2, -20, -4, 11, -6, 9, -10, -118, 101, 89, -88, -91, -99, -119, -88, -84, 118, 102, -69, -76, -88, -75, -69, -76, -86, -83, -95, -15, -51, -15, -16, -12, -69, -54, 31, 26, 14, 11, 30, 15, -86, -67, -71, -53, -89, -16, -18, -11, -10, -7, -20, -21, 119, -59, -58, -53, 119, -55, -68, -70, -48, -70, -61, -72, -71, -61, -68, Byte.MAX_VALUE, 18, 29, 14, 22, -1, 18, 14, 32, -55, 22, 10, 34, -55, 23, 24, 29, -55, 11, 14, -55, 23, 30, 21, 21, -83, -73, -106, -87, -89, -67, -89, -80, -91, -90, -80, -87, 100, -88, -87, -89, -74, -87, -79, -87, -78, -72, -87, -88, 100, -90, -87, -80, -77, -69, 100, 116, 126, 100, -71, -78, -79, -91, -72, -89, -84, -87, -88, 100, -76, -91, -83, -74, 100, -77, -86, 100, -73, -87, -72, -115, -73, -106, -87, -89, -67, -91, -90, -80, -87, 108, 109, 100, -89, -91, -80, -80, -73, 100, -86, -77, -74, 100, -119, -46, -41, -33, -54, -43, -46, -51, -92, -10, -23, -15, -13, -6, -23, -24, -11, 8, 4, 22, -25, 14, 11, 3, 4, 17, 26, -59, -53, -34, -34, -53, -51, -46, -49, -50, -67, -51, -36, -53, -38, -57, -85, -12, -17, -56};
    }

    static {
        A04();
        A0J = Collections.EMPTY_LIST;
    }

    public C7Z(View view) {
        if (view == null) {
            throw new IllegalArgumentException(A02(141, 24, 112));
        }
        this.A0H = view;
    }

    private void A03() {
        if (this.A0A == null) {
            this.A0A = new ArrayList();
            this.A0B = Collections.unmodifiableList(this.A0A);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(C01807a c01807a) {
        this.A0E = C5B.A00(this.A0H);
        c01807a.A1q(this, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(C01807a c01807a) {
        c01807a.A1q(this, this.A0E);
        this.A0E = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0023, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean A09() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            int r0 = r2.A0C
            r0 = r0 & 16
            if (r0 != 0) goto L21
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1b;
                case 4: goto L23;
                case 5: goto L1e;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            android.view.View r0 = r2.A0H
            boolean r0 = com.facebook.ads.redexgen.X.C5B.A0F(r0)
            if (r0 == 0) goto L19
            r0 = 3
            goto L9
        L19:
            r0 = 5
            goto L9
        L1b:
            r1 = 1
            r0 = 4
            goto L9
        L1e:
            r1 = 0
            r0 = 4
            goto L9
        L21:
            r0 = 5
            goto L9
        L23:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A09():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean A0A() {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A0C
            r0 = r0 & 16
            if (r0 == 0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 1
            r0 = 3
            goto L8
        Lf:
            r1 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0A():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0B() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            int r0 = r2.A0C
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 != 0) goto L1f
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L19;
                case 4: goto L21;
                case 5: goto L1c;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            boolean r0 = r2.A0b()
            if (r0 == 0) goto L17
            r0 = 3
            goto L9
        L17:
            r0 = 5
            goto L9
        L19:
            r1 = 1
            r0 = 4
            goto L9
        L1c:
            r1 = 0
            r0 = 4
            goto L9
        L1f:
            r0 = 3
            goto L9
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0B():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0G() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.7a r0 = r2.A08
            if (r0 != 0) goto L18
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
            r1 = -1
            r0 = 3
            goto L7
        Le:
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            com.facebook.ads.redexgen.X.7a r0 = r2.A08
            int r1 = r0.A12(r2)
            r0 = 3
            goto L7
        L18:
            r0 = 4
            goto L7
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0G():int");
    }

    public final int A0H() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0I() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            int r1 = r3.A04
            r0 = -1
            if (r1 != r0) goto L18
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1a;
                case 4: goto L12;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r2 = r3.A03
            r0 = 3
            goto L8
        L12:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r2 = r3.A04
            r0 = 3
            goto L8
        L18:
            r0 = 4
            goto L8
        L1a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0I():int");
    }

    public final int A0J() {
        return this.A01;
    }

    public final long A0K() {
        return this.A05;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0039, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<java.lang.Object> A0L() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            int r0 = r2.A0C
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 != 0) goto L33
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L21;
                case 4: goto L17;
                case 5: goto L35;
                case 6: goto L1b;
                case 7: goto L2f;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            java.util.List<java.lang.Object> r0 = r2.A0A
            if (r0 == 0) goto L15
            r0 = 3
            goto L9
        L15:
            r0 = 4
            goto L9
        L17:
            java.util.List<java.lang.Object> r1 = com.facebook.ads.redexgen.X.C7Z.A0J
            r0 = 5
            goto L9
        L1b:
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            java.util.List<java.lang.Object> r1 = r2.A0B
            r0 = 5
            goto L9
        L21:
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            java.util.List<java.lang.Object> r0 = r2.A0A
            int r0 = r0.size()
            if (r0 != 0) goto L2d
            r0 = 4
            goto L9
        L2d:
            r0 = 6
            goto L9
        L2f:
            java.util.List<java.lang.Object> r1 = com.facebook.ads.redexgen.X.C7Z.A0J
            r0 = 5
            goto L9
        L33:
            r0 = 7
            goto L9
        L35:
            java.util.List r1 = (java.util.List) r1
            java.util.List r1 = (java.util.List) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0L():java.util.List");
    }

    public final void A0M() {
        this.A01 = -1;
        this.A04 = -1;
    }

    public final void A0N() {
        if (this.A0A != null) {
            this.A0A.clear();
        }
        this.A0C &= -1025;
    }

    public final void A0O() {
        this.A0C &= -33;
    }

    public final void A0P() {
        this.A0C &= -257;
    }

    public final void A0Q() {
        this.A0C = 0;
        this.A03 = -1;
        this.A01 = -1;
        this.A05 = -1L;
        this.A04 = -1;
        this.A0D = 0;
        this.A06 = null;
        this.A07 = null;
        A0N();
        this.A0E = 0;
        this.A02 = -1;
        C01807a.A0i(this);
    }

    public final void A0R() {
        if (this.A01 == -1) {
            this.A01 = this.A03;
        }
    }

    public final void A0S() {
        this.A0F.A0c(this);
    }

    public final void A0T(int i) {
        this.A0C |= i;
    }

    public final void A0U(int i, int i2) {
        this.A0C = (this.A0C & (i2 ^ (-1))) | (i & i2);
    }

    public final void A0V(int i, int i2, boolean z) {
        A0T(8);
        A0W(i2, z);
        this.A03 = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x005c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0W(int r5, boolean r6) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r2 = -1
            int r0 = r3.A01
            if (r0 != r2) goto L5a
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L2d;
                case 3: goto L23;
                case 4: goto L1b;
                case 5: goto Lc;
                case 6: goto L12;
                case 7: goto L35;
                case 8: goto L4a;
                case 9: goto L5c;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            if (r6 == 0) goto L10
            r0 = 6
            goto L8
        L10:
            r0 = 7
            goto L8
        L12:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r0 = r3.A04
            int r0 = r0 + r5
            r3.A04 = r0
            r0 = 7
            goto L8
        L1b:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r0 = r3.A03
            r3.A04 = r0
            r0 = 5
            goto L8
        L23:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r0 = r3.A04
            if (r0 != r2) goto L2b
            r0 = 4
            goto L8
        L2b:
            r0 = 5
            goto L8
        L2d:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r0 = r3.A03
            r3.A01 = r0
            r0 = 3
            goto L8
        L35:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r0 = r3.A03
            int r0 = r0 + r5
            r3.A03 = r0
            android.view.View r0 = r3.A0H
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 == 0) goto L47
            r0 = 8
            goto L8
        L47:
            r0 = 9
            goto L8
        L4a:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            android.view.View r0 = r3.A0H
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            com.facebook.ads.redexgen.X.6e r1 = (com.facebook.ads.redexgen.X.C01596e) r1
            r0 = 1
            r1.A01 = r0
            r0 = 9
            goto L8
        L5a:
            r0 = 3
            goto L8
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0W(int, boolean):void");
    }

    public final void A0X(C7O c7o, boolean z) {
        this.A0F = c7o;
        this.A0G = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0Y(java.lang.Object r3) {
        /*
            r2 = this;
            r1 = r2
            if (r3 != 0) goto L2b
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L2d;
                case 4: goto L11;
                case 5: goto L1d;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.7Z r1 = (com.facebook.ads.redexgen.X.C7Z) r1
            r0 = 1024(0x400, float:1.435E-42)
            r1.A0T(r0)
            r0 = 3
            goto L4
        L11:
            com.facebook.ads.redexgen.X.7Z r1 = (com.facebook.ads.redexgen.X.C7Z) r1
            int r0 = r1.A0C
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 != 0) goto L1b
            r0 = 5
            goto L4
        L1b:
            r0 = 3
            goto L4
        L1d:
            com.facebook.ads.redexgen.X.7Z r1 = (com.facebook.ads.redexgen.X.C7Z) r1
            java.lang.Object r3 = (java.lang.Object) r3
            r1.A03()
            java.util.List<java.lang.Object> r0 = r1.A0A
            r0.add(r3)
            r0 = 3
            goto L4
        L2b:
            r0 = 4
            goto L4
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0Y(java.lang.Object):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0092, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0Z(boolean r8) {
        /*
            r7 = this;
            r4 = r7
            r6 = 0
            if (r8 == 0) goto L8e
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L69;
                case 3: goto L9;
                case 4: goto L31;
                case 5: goto L92;
                case 6: goto L1f;
                case 7: goto L71;
                case 8: goto L15;
                case 9: goto L7e;
                case 10: goto L26;
                case 11: goto L5f;
                case 12: goto L85;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            r4.A0D = r6
            int r0 = r4.A0D
            if (r0 >= 0) goto L13
            r0 = 4
            goto L5
        L13:
            r0 = 6
            goto L5
        L15:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            int r0 = r4.A0C
            r0 = r0 | 16
            r4.A0C = r0
            r0 = 5
            goto L5
        L1f:
            if (r8 != 0) goto L23
            r0 = 7
            goto L5
        L23:
            r0 = 9
            goto L5
        L26:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            int r0 = r4.A0D
            if (r0 != 0) goto L2f
            r0 = 11
            goto L5
        L2f:
            r0 = 5
            goto L5
        L31:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            r0 = 0
            r4.A0D = r0
            r2 = 113(0x71, float:1.58E-43)
            r1 = 4
            r0 = 27
            java.lang.String r5 = A02(r2, r1, r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 165(0xa5, float:2.31E-43)
            r1 = 78
            r0 = 11
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r5, r0)
            r0 = 5
            goto L5
        L5f:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            int r0 = r4.A0C
            r0 = r0 & (-17)
            r4.A0C = r0
            r0 = 5
            goto L5
        L69:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            int r0 = r4.A0D
            int r6 = r0 + (-1)
            r0 = 3
            goto L5
        L71:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            int r1 = r4.A0D
            r0 = 1
            if (r1 != r0) goto L7b
            r0 = 8
            goto L5
        L7b:
            r0 = 9
            goto L5
        L7e:
            if (r8 == 0) goto L83
            r0 = 10
            goto L5
        L83:
            r0 = 5
            goto L5
        L85:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            int r0 = r4.A0D
            int r6 = r0 + 1
            r0 = 3
            goto L5
        L8e:
            r0 = 12
            goto L5
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0Z(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0a() {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A0C
            r0 = r0 & 1
            if (r0 == 0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 1
            r0 = 3
            goto L8
        Lf:
            r1 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0a():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0b() {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A0C
            r0 = r0 & 4
            if (r0 == 0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 1
            r0 = 3
            goto L8
        Lf:
            r1 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0b():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0c() {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A0C
            r0 = r0 & 8
            if (r0 == 0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 1
            r0 = 3
            goto L8
        Lf:
            r1 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0c():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0012, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0d() {
        /*
            r2 = this;
            r1 = 0
            com.facebook.ads.redexgen.X.7O r0 = r2.A0F
            if (r0 == 0) goto L10
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0d():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0e() {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A0C
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 1
            r0 = 3
            goto L8
        Lf:
            r1 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0e():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0f() {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A0C
            r0 = r0 & 2
            if (r0 == 0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 1
            r0 = 3
            goto L8
        Lf:
            r1 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0f():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0g() {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A0C
            r0 = r0 & 2
            if (r0 == 0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 1
            r0 = 3
            goto L8
        Lf:
            r1 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0g():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0h() {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A0C
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 1
            r0 = 3
            goto L8
        Lf:
            r1 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0h():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0i() {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A0C
            r0 = r0 & 32
            if (r0 == 0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 1
            r0 = 3
            goto L8
        Lf:
            r1 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0i():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0023, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0j() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            int r0 = r2.A0C
            r0 = r0 & 16
            if (r0 != 0) goto L21
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1e;
                case 4: goto L23;
                case 5: goto L1b;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            android.view.View r0 = r2.A0H
            boolean r0 = com.facebook.ads.redexgen.X.C5B.A0F(r0)
            if (r0 != 0) goto L19
            r0 = 3
            goto L9
        L19:
            r0 = 5
            goto L9
        L1b:
            r1 = 0
            r0 = 4
            goto L9
        L1e:
            r1 = 1
            r0 = 4
            goto L9
        L21:
            r0 = 5
            goto L9
        L23:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0j():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0013, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0k(int r3) {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A0C
            r0 = r0 & r3
            if (r0 == 0) goto L11
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L13;
                case 4: goto Le;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r1 = 1
            r0 = 3
            goto L7
        Le:
            r1 = 0
            r0 = 3
            goto L7
        L11:
            r0 = 4
            goto L7
        L13:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.A0k(int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x0216, code lost:            r3 = r3;        r3.append(A02(44, 1, 94));     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x022a, code lost:            return r3.toString();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Z.toString():java.lang.String");
    }
}
