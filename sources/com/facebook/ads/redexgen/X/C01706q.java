package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* renamed from: com.facebook.ads.redexgen.X.6q, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C01706q extends AbstractC01696p {
    public static byte[] A06;
    public PointF A02;
    public final float A03;
    public final LinearInterpolator A05 = new LinearInterpolator();
    public final DecelerateInterpolator A04 = new DecelerateInterpolator();
    public int A00 = 0;
    public int A01 = 0;

    static {
        A06();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C01706q.A06
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
            int r0 = r0 + (-34)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01706q.A04(int, int, int):java.lang.String");
    }

    public static void A06() {
        A06 = new byte[]{-54, -59, -72, -57, 119, -57, -55, -68, -67, -68, -55, -68, -59, -70, -68, 119, -54, -65, -58, -52, -61, -69, 119, -71, -68, 119, -58, -59, -68, 119, -58, -67, 119, -53, -65, -68, 119, -70, -58, -59, -54, -53, -72, -59, -53, -54, 119, -69, -68, -67, -64, -59, -68, -69, 119, -64, -59, 119, -86, -60, -58, -58, -53, -65, -86, -70, -55, -58, -61, -61, -68, -55, -125, 119, -54, -53, -72, -55, -53, -64, -59, -66, 119, -50, -64, -53, -65, 119, -86, -91, -104, -89, -74, -64, -35, -30, -39, -43, -26, -57, -31, -29, -29, -24, -36, -57, -41, -26, -29, -32, -32, -39, -26, -66, -44, -38, -123, -40, -51, -44, -38, -47, -55, -123, -44, -37, -54, -41, -41, -50, -55, -54, -123, -56, -44, -46, -43, -38, -39, -54, -72, -56, -41, -44, -47, -47, -69, -54, -56, -39, -44, -41, -85, -44, -41, -75, -44, -40, -50, -39, -50, -44, -45, -123, -36, -51, -54, -45, -123, -39, -51, -54, -123, -79, -58, -34, -44, -38, -39, -78, -58, -45, -58, -52, -54, -41, -123, -55, -44, -54, -40, -123, -45, -44, -39, -123, -50, -46, -43, -47, -54, -46, -54, -45, -39, -123};
    }

    public C01706q(Context context) {
        this.A03 = A0J(context.getResources().getDisplayMetrics());
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0035, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int A00() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            r1 = 0
            android.graphics.PointF r0 = r3.A02
            if (r0 == 0) goto L33
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L21;
                case 3: goto L1e;
                case 4: goto L35;
                case 5: goto L10;
                case 6: goto Ld;
                case 7: goto L30;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r2 = 1
            r0 = 4
            goto L9
        L10:
            com.facebook.ads.redexgen.X.6q r3 = (com.facebook.ads.redexgen.X.C01706q) r3
            android.graphics.PointF r0 = r3.A02
            float r0 = r0.y
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L1c
            r0 = 6
            goto L9
        L1c:
            r0 = 7
            goto L9
        L1e:
            r2 = 0
            r0 = 4
            goto L9
        L21:
            com.facebook.ads.redexgen.X.6q r3 = (com.facebook.ads.redexgen.X.C01706q) r3
            r1 = 0
            android.graphics.PointF r0 = r3.A02
            float r0 = r0.y
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L2e
            r0 = 3
            goto L9
        L2e:
            r0 = 5
            goto L9
        L30:
            r2 = -1
            r0 = 4
            goto L9
        L33:
            r0 = 3
            goto L9
        L35:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01706q.A00():int");
    }

    private int A01(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int A03(android.view.View r10, int r11) {
        /*
            r9 = this;
            r3 = r9
            r0 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.6g r2 = r3.A08()
            if (r2 == 0) goto L4b
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1a;
                case 4: goto L4d;
                case 5: goto L1d;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            boolean r0 = r2.A25()
            if (r0 != 0) goto L18
            r0 = 3
            goto La
        L18:
            r0 = 5
            goto La
        L1a:
            r1 = 0
            r0 = 4
            goto La
        L1d:
            com.facebook.ads.redexgen.X.6q r3 = (com.facebook.ads.redexgen.X.C01706q) r3
            android.view.View r10 = (android.view.View) r10
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            android.view.ViewGroup$LayoutParams r1 = r10.getLayoutParams()
            com.facebook.ads.redexgen.X.6e r1 = (com.facebook.ads.redexgen.X.C01596e) r1
            int r4 = r2.A0o(r10)
            int r0 = r1.topMargin
            int r4 = r4 - r0
            int r5 = r2.A0j(r10)
            int r0 = r1.bottomMargin
            int r5 = r5 + r0
            int r6 = r2.A0g()
            int r7 = r2.A0X()
            int r0 = r2.A0d()
            int r7 = r7 - r0
            r8 = r11
            int r1 = r3.A0N(r4, r5, r6, r7, r8)
            r0 = 4
            goto La
        L4b:
            r0 = 3
            goto La
        L4d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01706q.A03(android.view.View, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A07(com.facebook.ads.redexgen.X.C7U r10) {
        /*
            r9 = this;
            r5 = r9
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r8 = 1176256512(0x461c4000, float:10000.0)
            r7 = 0
            r6 = 1067030938(0x3f99999a, float:1.2)
            int r0 = r5.A07()
            android.graphics.PointF r4 = r5.A0P(r0)
            if (r4 == 0) goto L75
            r0 = 2
        L17:
            switch(r0) {
                case 2: goto L1b;
                case 3: goto L28;
                case 4: goto L34;
                case 5: goto L77;
                case 6: goto L44;
                default: goto L1a;
            }
        L1a:
            goto L17
        L1b:
            android.graphics.PointF r4 = (android.graphics.PointF) r4
            r7 = 0
            float r0 = r4.x
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 != 0) goto L26
            r0 = 3
            goto L17
        L26:
            r0 = 6
            goto L17
        L28:
            android.graphics.PointF r4 = (android.graphics.PointF) r4
            float r0 = r4.y
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 != 0) goto L32
            r0 = 4
            goto L17
        L32:
            r0 = 6
            goto L17
        L34:
            com.facebook.ads.redexgen.X.6q r5 = (com.facebook.ads.redexgen.X.C01706q) r5
            com.facebook.ads.redexgen.X.7U r10 = (com.facebook.ads.redexgen.X.C7U) r10
            int r0 = r5.A07()
            r10.A03(r0)
            r5.A09()
            r0 = 5
            goto L17
        L44:
            com.facebook.ads.redexgen.X.6q r5 = (com.facebook.ads.redexgen.X.C01706q) r5
            com.facebook.ads.redexgen.X.7U r10 = (com.facebook.ads.redexgen.X.C7U) r10
            android.graphics.PointF r4 = (android.graphics.PointF) r4
            r5.A0B(r4)
            r5.A02 = r4
            float r0 = r4.x
            float r0 = r0 * r8
            int r0 = (int) r0
            r5.A00 = r0
            float r0 = r4.y
            float r0 = r0 * r8
            int r0 = (int) r0
            r5.A01 = r0
            r0 = 10000(0x2710, float:1.4013E-41)
            int r1 = r5.A0L(r0)
            int r0 = r5.A00
            float r0 = (float) r0
            float r0 = r0 * r6
            int r3 = (int) r0
            int r0 = r5.A01
            float r0 = (float) r0
            float r0 = r0 * r6
            int r2 = (int) r0
            float r0 = (float) r1
            float r0 = r0 * r6
            int r1 = (int) r0
            android.view.animation.LinearInterpolator r0 = r5.A05
            r10.A04(r3, r2, r1, r0)
            r0 = 5
            goto L17
        L75:
            r0 = 4
            goto L17
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01706q.A07(com.facebook.ads.redexgen.X.7U):void");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01696p
    public final void A0G() {
        this.A01 = 0;
        this.A00 = 0;
        this.A02 = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0042, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC01696p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0H(int r3, int r4, com.facebook.ads.redexgen.X.C7W r5, com.facebook.ads.redexgen.X.C7U r6) {
        /*
            r2 = this;
            r1 = r2
            int r0 = r1.A06()
            if (r0 != 0) goto L40
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L42;
                case 4: goto L13;
                case 5: goto L2d;
                case 6: goto L37;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.6q r1 = (com.facebook.ads.redexgen.X.C01706q) r1
            r1.A09()
            r0 = 3
            goto L8
        L13:
            com.facebook.ads.redexgen.X.6q r1 = (com.facebook.ads.redexgen.X.C01706q) r1
            int r0 = r1.A00
            int r0 = r1.A01(r0, r3)
            r1.A00 = r0
            int r0 = r1.A01
            int r0 = r1.A01(r0, r4)
            r1.A01 = r0
            int r0 = r1.A00
            if (r0 != 0) goto L2b
            r0 = 5
            goto L8
        L2b:
            r0 = 3
            goto L8
        L2d:
            com.facebook.ads.redexgen.X.6q r1 = (com.facebook.ads.redexgen.X.C01706q) r1
            int r0 = r1.A01
            if (r0 != 0) goto L35
            r0 = 6
            goto L8
        L35:
            r0 = 3
            goto L8
        L37:
            com.facebook.ads.redexgen.X.6q r1 = (com.facebook.ads.redexgen.X.C01706q) r1
            com.facebook.ads.redexgen.X.7U r6 = (com.facebook.ads.redexgen.X.C7U) r6
            r1.A07(r6)
            r0 = 3
            goto L8
        L40:
            r0 = 4
            goto L8
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01706q.A0H(int, int, com.facebook.ads.redexgen.X.7W, com.facebook.ads.redexgen.X.7U):void");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01696p
    public void A0I(View view, C7W c7w, C7U c7u) {
        int A0O = A0O(view, A0K());
        int A03 = A03(view, A00());
        int A0M = A0M((int) Math.sqrt((A0O * A0O) + (A03 * A03)));
        if (A0M > 0) {
            c7u.A04(-A0O, -A03, A0M, this.A04);
        }
    }

    public float A0J(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0035, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int A0K() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            r1 = 0
            android.graphics.PointF r0 = r3.A02
            if (r0 == 0) goto L33
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L24;
                case 3: goto L21;
                case 4: goto L35;
                case 5: goto L10;
                case 6: goto Ld;
                case 7: goto L1e;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r2 = 1
            r0 = 4
            goto L9
        L10:
            com.facebook.ads.redexgen.X.6q r3 = (com.facebook.ads.redexgen.X.C01706q) r3
            android.graphics.PointF r0 = r3.A02
            float r0 = r0.x
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L1c
            r0 = 6
            goto L9
        L1c:
            r0 = 7
            goto L9
        L1e:
            r2 = -1
            r0 = 4
            goto L9
        L21:
            r2 = 0
            r0 = 4
            goto L9
        L24:
            com.facebook.ads.redexgen.X.6q r3 = (com.facebook.ads.redexgen.X.C01706q) r3
            r1 = 0
            android.graphics.PointF r0 = r3.A02
            float r0 = r0.x
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L31
            r0 = 3
            goto L9
        L31:
            r0 = 5
            goto L9
        L33:
            r0 = 3
            goto L9
        L35:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01706q.A0K():int");
    }

    public int A0L(int i) {
        return (int) Math.ceil(Math.abs(i) * this.A03);
    }

    public final int A0M(int i) {
        return (int) Math.ceil(A0L(i) / 0.3356d);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0006. Please report as an issue. */
    public final int A0N(int dtStart, int i, int i2, int i3, int i4) {
        char c;
        int i5 = 0;
        int i6 = 0;
        switch (i4) {
            case -1:
                c = '\b';
                break;
            case 0:
                c = 3;
                break;
            case 1:
                c = 7;
                break;
            default:
                c = 2;
                break;
        }
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalArgumentException(A04(0, 93, 53));
                case 3:
                    i6 = i2 - dtStart;
                    c = i6 <= 0 ? (char) 4 : '\t';
                case 4:
                    i5 = i3 - i;
                    c = i5 < 0 ? (char) 5 : (char) 6;
                case 5:
                    i6 = i5;
                    c = '\t';
                case 6:
                    i6 = 0;
                    c = '\t';
                case 7:
                    i6 = i3 - i;
                    c = '\t';
                case '\b':
                    i6 = i2 - dtStart;
                    c = '\t';
                case '\t':
                    return i6;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int A0O(android.view.View r10, int r11) {
        /*
            r9 = this;
            r3 = r9
            r0 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.6g r2 = r3.A08()
            if (r2 == 0) goto L4b
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1a;
                case 4: goto L4d;
                case 5: goto L1d;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            boolean r0 = r2.A24()
            if (r0 != 0) goto L18
            r0 = 3
            goto La
        L18:
            r0 = 5
            goto La
        L1a:
            r1 = 0
            r0 = 4
            goto La
        L1d:
            com.facebook.ads.redexgen.X.6q r3 = (com.facebook.ads.redexgen.X.C01706q) r3
            android.view.View r10 = (android.view.View) r10
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            android.view.ViewGroup$LayoutParams r1 = r10.getLayoutParams()
            com.facebook.ads.redexgen.X.6e r1 = (com.facebook.ads.redexgen.X.C01596e) r1
            int r4 = r2.A0k(r10)
            int r0 = r1.leftMargin
            int r4 = r4 - r0
            int r5 = r2.A0n(r10)
            int r0 = r1.rightMargin
            int r5 = r5 + r0
            int r6 = r2.A0e()
            int r7 = r2.A0h()
            int r0 = r2.A0f()
            int r7 = r7 - r0
            r8 = r11
            int r1 = r3.A0N(r4, r5, r6, r7, r8)
            r0 = 4
            goto La
        L4b:
            r0 = 3
            goto La
        L4d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01706q.A0O(android.view.View, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.PointF A0P(int r7) {
        /*
            r6 = this;
            r1 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.6g r5 = r6.A08()
            boolean r0 = r5 instanceof com.facebook.ads.redexgen.X.InterfaceC01626h
            if (r0 == 0) goto L4b
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L4d;
                case 4: goto L1a;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.6g r5 = (com.facebook.ads.redexgen.X.AbstractC01616g) r5
            r0 = r5
            com.facebook.ads.redexgen.X.6h r0 = (com.facebook.ads.redexgen.X.InterfaceC01626h) r0
            android.graphics.PointF r1 = r0.A3i(r7)
            r0 = 3
            goto Lb
        L1a:
            r2 = 93
            r1 = 20
            r0 = 82
            java.lang.String r4 = A04(r2, r1, r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 113(0x71, float:1.58E-43)
            r1 = 93
            r0 = 67
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.StringBuilder r1 = r3.append(r0)
            java.lang.Class<com.facebook.ads.redexgen.X.6h> r0 = com.facebook.ads.redexgen.X.InterfaceC01626h.class
            java.lang.String r0 = r0.getCanonicalName()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r4, r0)
            r1 = 0
            r0 = 3
            goto Lb
        L4b:
            r0 = 4
            goto Lb
        L4d:
            android.graphics.PointF r1 = (android.graphics.PointF) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01706q.A0P(int):android.graphics.PointF");
    }
}
