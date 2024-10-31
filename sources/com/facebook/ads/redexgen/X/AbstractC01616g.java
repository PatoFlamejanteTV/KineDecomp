package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

/* renamed from: com.facebook.ads.redexgen.X.6g, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC01616g {
    public static byte[] A0I;
    public int A00;
    public C6J A01;

    @Nullable
    public AbstractC01696p A02;
    public C01807a A03;
    public boolean A08;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public final C7F A0G = new C7F() { // from class: com.facebook.ads.redexgen.X.7G
        @Override // com.facebook.ads.redexgen.X.C7F
        public final View A4P(int i) {
            return AbstractC01616g.this.A0t(i);
        }

        @Override // com.facebook.ads.redexgen.X.C7F
        public final int A4R(View view) {
            return AbstractC01616g.this.A0n(view) + ((C01596e) view.getLayoutParams()).rightMargin;
        }

        @Override // com.facebook.ads.redexgen.X.C7F
        public final int A4S(View view) {
            return AbstractC01616g.this.A0k(view) - ((C01596e) view.getLayoutParams()).leftMargin;
        }

        @Override // com.facebook.ads.redexgen.X.C7F
        public final int A4n() {
            return AbstractC01616g.this.A0h() - AbstractC01616g.this.A0f();
        }

        @Override // com.facebook.ads.redexgen.X.C7F
        public final int A4o() {
            return AbstractC01616g.this.A0e();
        }
    };
    public final C7F A0H = new C7F() { // from class: com.facebook.ads.redexgen.X.7H
        @Override // com.facebook.ads.redexgen.X.C7F
        public final View A4P(int i) {
            return AbstractC01616g.this.A0t(i);
        }

        @Override // com.facebook.ads.redexgen.X.C7F
        public final int A4R(View view) {
            return AbstractC01616g.this.A0j(view) + ((C01596e) view.getLayoutParams()).bottomMargin;
        }

        @Override // com.facebook.ads.redexgen.X.C7F
        public final int A4S(View view) {
            return AbstractC01616g.this.A0o(view) - ((C01596e) view.getLayoutParams()).topMargin;
        }

        @Override // com.facebook.ads.redexgen.X.C7F
        public final int A4n() {
            return AbstractC01616g.this.A0X() - AbstractC01616g.this.A0d();
        }

        @Override // com.facebook.ads.redexgen.X.C7F
        public final int A4o() {
            return AbstractC01616g.this.A0g();
        }
    };
    public C01887i A04 = new C01887i(this.A0G);
    public C01887i A05 = new C01887i(this.A0H);
    public boolean A09 = false;
    public boolean A07 = false;
    public boolean A06 = false;
    public boolean A0F = true;
    public boolean A0E = true;

    static {
        A08();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A07(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AbstractC01616g.A0I
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
            int r0 = r0 + (-76)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A07(int, int, int):java.lang.String");
    }

    public static void A08() {
        A0I = new byte[]{-38, -3, -3, -2, -3, -71, -17, 2, -2, 16, -71, 1, -6, 12, -71, -21, -2, -4, 18, -4, 5, -2, 11, -17, 2, -2, 16, -71, -6, 12, -71, 9, -6, 11, -2, 7, 13, -71, -5, 14, 13, -71, 15, 2, -2, 16, -71, 2, 12, -71, 7, 8, 13, -71, -6, -71, 11, -2, -6, 5, -71, -4, 1, 2, 5, -3, -57, -71, -18, 7, -1, 2, 5, 13, -2, 11, -2, -3, -71, 2, 7, -3, -2, 17, -45, 26, 48, 54, -31, 46, 54, 52, 53, -31, 48, 55, 38, 51, 51, 42, 37, 38, -31, 48, 47, 13, 34, 58, 48, 54, 53, 4, 41, 42, 45, 37, 51, 38, 47, -23, 19, 38, 36, 58, 36, 45, 38, 51, -31, 51, 38, 36, 58, 36, 45, 38, 51, -19, -31, 20, 53, 34, 53, 38, -31, 52, 53, 34, 53, 38, -22, -31, -77, -55, -49, 122, -57, -49, -51, -50, 122, -55, -48, -65, -52, -52, -61, -66, -65, 122, -51, -57, -55, -55, -50, -62, -83, -67, -52, -55, -58, -58, -82, -55, -86, -55, -51, -61, -50, -61, -55, -56, 122, -50, -55, 122, -51, -49, -54, -54, -55, -52, -50, 122, -51, -57, -55, -55, -50, -62, 122, -51, -67, -52, -55, -58, -58, -61, -56, -63, -44, -14, -1, -1, 0, 5, -79, -2, 0, 7, -10, -79, -14, -79, -12, -7, -6, -3, -11, -79, -9, 3, 0, -2, -79, -1, 0, -1, -66, -10, 9, -6, 4, 5, -6, -1, -8, -79, -6, -1, -11, -10, 9, -53, -89, -70, -72, -50, -72, -63, -70, -57, -85, -66, -70, -52};
    }

    public abstract C01596e A1s();

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(int r1, int r2, int r3) {
        /*
            r0 = 0
            int r0 = android.view.View.MeasureSpec.getMode(r1)
            int r1 = android.view.View.MeasureSpec.getSize(r1)
            switch(r0) {
                case -2147483648: goto L21;
                case 1073741824: goto L23;
                default: goto Lc;
            }
        Lc:
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L25;
                case 4: goto L17;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            int r1 = java.lang.Math.max(r2, r3)
            r0 = 3
            goto Ld
        L17:
            int r0 = java.lang.Math.max(r2, r3)
            int r1 = java.lang.Math.min(r1, r0)
            r0 = 3
            goto Ld
        L21:
            r0 = 4
            goto Ld
        L23:
            r0 = 3
            goto Ld
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A00(int, int, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x008b, code lost:            return android.view.View.MeasureSpec.makeMeasureSpec(r2, r1);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A01(int r6, int r7, int r8, int r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A01(int, int, int, int, boolean):int");
    }

    private final int A02(View view) {
        return ((C01596e) view.getLayoutParams()).A03.bottom;
    }

    private final int A03(View view) {
        return ((C01596e) view.getLayoutParams()).A03.left;
    }

    private final int A04(View view) {
        return ((C01596e) view.getLayoutParams()).A03.right;
    }

    private final int A05(View view) {
        return ((C01596e) view.getLayoutParams()).A03.top;
    }

    private final int A06(C7O c7o, C7W c7w) {
        return 0;
    }

    private final void A09(int i) {
        A0C(i, A0t(i));
    }

    private final void A0A(int i) {
        if (A0t(i) != null) {
            this.A01.A0D(i);
        }
    }

    private final void A0B(int i, int i2) {
        View A0t = A0t(i);
        if (A0t == null) {
            throw new IllegalArgumentException(A07(220, 44, 69) + i + this.A03.toString());
        }
        A09(i);
        A0E(A0t, i2);
    }

    private void A0C(int i, View view) {
        this.A01.A0C(i);
    }

    private final void A0D(View view) {
        this.A01.A0F(view);
    }

    private final void A0E(View view, int i) {
        A0F(view, i, (C01596e) view.getLayoutParams());
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:            r1.A01.A0H(r4, r5, r6, r2.A0c());     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0F(android.view.View r4, int r5, com.facebook.ads.redexgen.X.C01596e r6) {
        /*
            r3 = this;
            r1 = r3
            r0 = 0
            com.facebook.ads.redexgen.X.7Z r2 = com.facebook.ads.redexgen.X.C01807a.A05(r4)
            boolean r0 = r2.A0c()
            if (r0 == 0) goto L2b
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L2d;
                case 4: goto L1e;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.6g r1 = (com.facebook.ads.redexgen.X.AbstractC01616g) r1
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            com.facebook.ads.redexgen.X.7a r0 = r1.A03
            com.facebook.ads.redexgen.X.7k r0 = r0.A0t
            r0.A09(r2)
            r0 = 3
            goto Ld
        L1e:
            com.facebook.ads.redexgen.X.6g r1 = (com.facebook.ads.redexgen.X.AbstractC01616g) r1
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            com.facebook.ads.redexgen.X.7a r0 = r1.A03
            com.facebook.ads.redexgen.X.7k r0 = r0.A0t
            r0.A0A(r2)
            r0 = 3
            goto Ld
        L2b:
            r0 = 4
            goto Ld
        L2d:
            com.facebook.ads.redexgen.X.6g r1 = (com.facebook.ads.redexgen.X.AbstractC01616g) r1
            android.view.View r4 = (android.view.View) r4
            com.facebook.ads.redexgen.X.6e r6 = (com.facebook.ads.redexgen.X.C01596e) r6
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            com.facebook.ads.redexgen.X.6J r1 = r1.A01
            boolean r0 = r2.A0c()
            r1.A0H(r4, r5, r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0F(android.view.View, int, com.facebook.ads.redexgen.X.6e):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000f. Please report as an issue. */
    private void A0G(View view, int i, boolean z) {
        AbstractC01616g abstractC01616g = this;
        int i2 = 0;
        C01596e c01596e = null;
        boolean z2 = false;
        C7Z A05 = C01807a.A05(view);
        char c = !z ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    A05 = A05;
                    c = A05.A0c() ? (char) 3 : (char) 23;
                case 3:
                    abstractC01616g = abstractC01616g;
                    A05 = A05;
                    abstractC01616g.A03.A0t.A09(A05);
                    c = 4;
                case 4:
                    view = view;
                    A05 = A05;
                    c01596e = (C01596e) view.getLayoutParams();
                    c = !A05.A0i() ? (char) 5 : (char) 6;
                case 5:
                    A05 = A05;
                    c = A05.A0d() ? (char) 6 : '\r';
                case 6:
                    A05 = A05;
                    c = A05.A0d() ? (char) 7 : '\f';
                case 7:
                    A05 = A05;
                    A05.A0S();
                    c = '\b';
                case '\b':
                    abstractC01616g = abstractC01616g;
                    view = view;
                    z2 = false;
                    abstractC01616g.A01.A0H(view, i, view.getLayoutParams(), false);
                    c = '\t';
                case '\t':
                    c01596e = c01596e;
                    c = c01596e.A02 ? '\n' : (char) 11;
                case '\n':
                    A05 = A05;
                    c01596e = c01596e;
                    A05.A0H.invalidate();
                    c01596e.A02 = z2;
                    c = 11;
                case 11:
                    return;
                case '\f':
                    A05 = A05;
                    A05.A0O();
                    c = '\b';
                case '\r':
                    abstractC01616g = abstractC01616g;
                    view = view;
                    c = view.getParent() == abstractC01616g.A03 ? (char) 14 : (char) 20;
                case 14:
                    abstractC01616g = abstractC01616g;
                    view = view;
                    i2 = abstractC01616g.A01.A07(view);
                    c = i == -1 ? (char) 15 : (char) 16;
                case 15:
                    abstractC01616g = abstractC01616g;
                    i = abstractC01616g.A01.A05();
                    c = 16;
                case 16:
                    c = i2 == -1 ? (char) 17 : (char) 18;
                case 17:
                    AbstractC01616g abstractC01616g2 = abstractC01616g;
                    throw new IllegalStateException(A07(0, 85, 77) + abstractC01616g2.A03.indexOfChild(view) + abstractC01616g2.A03.A17());
                case 18:
                    c = i2 != i ? (char) 19 : '\t';
                case 19:
                    abstractC01616g = abstractC01616g;
                    abstractC01616g.A03.A06.A0B(i2, i);
                    c = '\t';
                case 20:
                    abstractC01616g = abstractC01616g;
                    view = view;
                    c01596e = c01596e;
                    z2 = false;
                    abstractC01616g.A01.A0I(view, i, false);
                    c01596e.A01 = true;
                    c = abstractC01616g.A02 != null ? (char) 21 : '\t';
                case 21:
                    abstractC01616g = abstractC01616g;
                    c = abstractC01616g.A02.A0F() ? (char) 22 : '\t';
                case 22:
                    abstractC01616g = abstractC01616g;
                    view = view;
                    abstractC01616g.A02.A0C(view);
                    c = '\t';
                case 23:
                    abstractC01616g = abstractC01616g;
                    A05 = A05;
                    abstractC01616g.A03.A0t.A0A(A05);
                    c = 4;
            }
        }
    }

    private final void A0H(View view, Rect rect) {
        C01807a.A0e(view, rect);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0060, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0J(com.facebook.ads.redexgen.X.C7O r4, int r5, android.view.View r6) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            com.facebook.ads.redexgen.X.7Z r1 = com.facebook.ads.redexgen.X.C01807a.A05(r6)
            boolean r0 = r1.A0h()
            if (r0 == 0) goto L5e
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L60;
                case 3: goto L3b;
                case 4: goto L2f;
                case 5: goto L1f;
                case 6: goto L11;
                case 7: goto L47;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            com.facebook.ads.redexgen.X.7Z r1 = (com.facebook.ads.redexgen.X.C7Z) r1
            r2.A0A(r5)
            r4.A0b(r1)
            r0 = 2
            goto Ld
        L1f:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            com.facebook.ads.redexgen.X.2E r0 = r0.A04
            boolean r0 = r0.A0A()
            if (r0 != 0) goto L2d
            r0 = 6
            goto Ld
        L2d:
            r0 = 7
            goto Ld
        L2f:
            com.facebook.ads.redexgen.X.7Z r1 = (com.facebook.ads.redexgen.X.C7Z) r1
            boolean r0 = r1.A0c()
            if (r0 != 0) goto L39
            r0 = 5
            goto Ld
        L39:
            r0 = 7
            goto Ld
        L3b:
            com.facebook.ads.redexgen.X.7Z r1 = (com.facebook.ads.redexgen.X.C7Z) r1
            boolean r0 = r1.A0b()
            if (r0 == 0) goto L45
            r0 = 4
            goto Ld
        L45:
            r0 = 7
            goto Ld
        L47:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            android.view.View r6 = (android.view.View) r6
            com.facebook.ads.redexgen.X.7Z r1 = (com.facebook.ads.redexgen.X.C7Z) r1
            r2.A09(r5)
            r4.A0W(r6)
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            com.facebook.ads.redexgen.X.7k r0 = r0.A0t
            r0.A0C(r1)
            r0 = 2
            goto Ld
        L5e:
            r0 = 3
            goto Ld
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0J(com.facebook.ads.redexgen.X.7O, int, android.view.View):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x007c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0K(com.facebook.ads.redexgen.X.C7O r5, com.facebook.ads.redexgen.X.C7W r6, android.view.accessibility.AccessibilityEvent r7) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            r2 = -1
            r1 = 1
            com.facebook.ads.redexgen.X.7a r0 = r3.A03
            if (r0 == 0) goto L7a
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L4c;
                case 3: goto L7c;
                case 4: goto L2c;
                case 5: goto L1d;
                case 6: goto Le;
                case 7: goto L54;
                case 8: goto L64;
                case 9: goto L3b;
                case 10: goto L76;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            com.facebook.ads.redexgen.X.7a r0 = r3.A03
            boolean r0 = r0.canScrollHorizontally(r2)
            if (r0 != 0) goto L1a
            r0 = 7
            goto La
        L1a:
            r0 = 8
            goto La
        L1d:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            com.facebook.ads.redexgen.X.7a r0 = r3.A03
            boolean r0 = r0.canScrollVertically(r2)
            if (r0 != 0) goto L29
            r0 = 6
            goto La
        L29:
            r0 = 8
            goto La
        L2c:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            com.facebook.ads.redexgen.X.7a r0 = r3.A03
            boolean r0 = r0.canScrollVertically(r1)
            if (r0 != 0) goto L38
            r0 = 5
            goto La
        L38:
            r0 = 8
            goto La
        L3b:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            android.view.accessibility.AccessibilityEvent r7 = (android.view.accessibility.AccessibilityEvent) r7
            com.facebook.ads.redexgen.X.7a r0 = r3.A03
            com.facebook.ads.redexgen.X.2E r0 = r0.A04
            int r0 = r0.A0C()
            r7.setItemCount(r0)
            r0 = 3
            goto La
        L4c:
            android.view.accessibility.AccessibilityEvent r7 = (android.view.accessibility.AccessibilityEvent) r7
            if (r7 != 0) goto L52
            r0 = 3
            goto La
        L52:
            r0 = 4
            goto La
        L54:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            com.facebook.ads.redexgen.X.7a r0 = r3.A03
            boolean r0 = r0.canScrollHorizontally(r1)
            if (r0 == 0) goto L61
            r0 = 8
            goto La
        L61:
            r0 = 10
            goto La
        L64:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            android.view.accessibility.AccessibilityEvent r7 = (android.view.accessibility.AccessibilityEvent) r7
            r7.setScrollable(r1)
            com.facebook.ads.redexgen.X.7a r0 = r3.A03
            com.facebook.ads.redexgen.X.2E r0 = r0.A04
            if (r0 == 0) goto L74
            r0 = 9
            goto La
        L74:
            r0 = 3
            goto La
        L76:
            r1 = 0
            r0 = 8
            goto La
        L7a:
            r0 = 3
            goto La
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0K(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W, android.view.accessibility.AccessibilityEvent):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0056, code lost:            r4 = r4;        r6 = r6;        r7 = r7;        r8.A0P(com.facebook.ads.redexgen.X.C01435n.A00(r4.A0r(r6, r7), r4.A0q(r6, r7), r4.A0P(r6, r7), r4.A06(r6, r7)));     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0075, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0L(com.facebook.ads.redexgen.X.C7O r6, com.facebook.ads.redexgen.X.C7W r7, com.facebook.ads.redexgen.X.C5q r8) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            r2 = -1
            r1 = 1
            com.facebook.ads.redexgen.X.7a r0 = r4.A03
            boolean r0 = r0.canScrollVertically(r2)
            if (r0 != 0) goto L54
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L46;
                case 3: goto L3a;
                case 4: goto L2c;
                case 5: goto L1e;
                case 6: goto L12;
                case 7: goto L56;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.5q r8 = (com.facebook.ads.redexgen.X.C5q) r8
            r0 = 4096(0x1000, float:5.74E-42)
            r8.A0N(r0)
            r8.A0R(r1)
            r0 = 7
            goto Le
        L1e:
            com.facebook.ads.redexgen.X.6g r4 = (com.facebook.ads.redexgen.X.AbstractC01616g) r4
            com.facebook.ads.redexgen.X.7a r0 = r4.A03
            boolean r0 = r0.canScrollHorizontally(r1)
            if (r0 == 0) goto L2a
            r0 = 6
            goto Le
        L2a:
            r0 = 7
            goto Le
        L2c:
            com.facebook.ads.redexgen.X.6g r4 = (com.facebook.ads.redexgen.X.AbstractC01616g) r4
            com.facebook.ads.redexgen.X.7a r0 = r4.A03
            boolean r0 = r0.canScrollVertically(r1)
            if (r0 != 0) goto L38
            r0 = 5
            goto Le
        L38:
            r0 = 6
            goto Le
        L3a:
            com.facebook.ads.redexgen.X.5q r8 = (com.facebook.ads.redexgen.X.C5q) r8
            r0 = 8192(0x2000, float:1.148E-41)
            r8.A0N(r0)
            r8.A0R(r1)
            r0 = 4
            goto Le
        L46:
            com.facebook.ads.redexgen.X.6g r4 = (com.facebook.ads.redexgen.X.AbstractC01616g) r4
            com.facebook.ads.redexgen.X.7a r0 = r4.A03
            boolean r0 = r0.canScrollHorizontally(r2)
            if (r0 == 0) goto L52
            r0 = 3
            goto Le
        L52:
            r0 = 4
            goto Le
        L54:
            r0 = 3
            goto Le
        L56:
            com.facebook.ads.redexgen.X.6g r4 = (com.facebook.ads.redexgen.X.AbstractC01616g) r4
            com.facebook.ads.redexgen.X.7O r6 = (com.facebook.ads.redexgen.X.C7O) r6
            com.facebook.ads.redexgen.X.7W r7 = (com.facebook.ads.redexgen.X.C7W) r7
            com.facebook.ads.redexgen.X.5q r8 = (com.facebook.ads.redexgen.X.C5q) r8
            int r3 = r4.A0r(r6, r7)
            int r2 = r4.A0q(r6, r7)
            boolean r1 = r4.A0P(r6, r7)
            int r0 = r4.A06(r6, r7)
            com.facebook.ads.redexgen.X.5n r0 = com.facebook.ads.redexgen.X.C01435n.A00(r3, r2, r1, r0)
            r8.A0P(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0L(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W, com.facebook.ads.redexgen.X.5q):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0M(AbstractC01696p abstractC01696p) {
        if (this.A02 == abstractC01696p) {
            this.A02 = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0N() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.6p r0 = r2.A02
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
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.6p r0 = r2.A02
            boolean r0 = r0.A0F()
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
            r0 = 5
            goto L7
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0N():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0043, code lost:            return r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0O(int r4, int r5, int r6) {
        /*
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 1
            r1 = 0
            int r3 = android.view.View.MeasureSpec.getMode(r5)
            int r2 = android.view.View.MeasureSpec.getSize(r5)
            if (r6 <= 0) goto L41
            r1 = 2
        L11:
            switch(r1) {
                case 2: goto L2a;
                case 3: goto L27;
                case 4: goto L43;
                case 5: goto L1b;
                case 6: goto L15;
                case 7: goto L30;
                case 8: goto L18;
                case 9: goto L3a;
                case 10: goto L37;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            r0 = 0
            r1 = 4
            goto L11
        L18:
            r0 = 0
            r1 = 4
            goto L11
        L1b:
            switch(r3) {
                case -2147483648: goto L20;
                case 0: goto L25;
                case 1073741824: goto L23;
                default: goto L1e;
            }
        L1e:
            r1 = 6
            goto L11
        L20:
            r1 = 9
            goto L11
        L23:
            r1 = 7
            goto L11
        L25:
            r1 = 4
            goto L11
        L27:
            r0 = 0
            r1 = 4
            goto L11
        L2a:
            if (r4 == r6) goto L2e
            r1 = 3
            goto L11
        L2e:
            r1 = 5
            goto L11
        L30:
            if (r2 == r4) goto L35
            r1 = 8
            goto L11
        L35:
            r1 = 4
            goto L11
        L37:
            r0 = 0
            r1 = 4
            goto L11
        L3a:
            if (r2 >= r4) goto L3f
            r1 = 10
            goto L11
        L3f:
            r1 = 4
            goto L11
        L41:
            r1 = 5
            goto L11
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0O(int, int, int):boolean");
    }

    private final boolean A0P(C7O c7o, C7W c7w) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x00c6, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0Q(com.facebook.ads.redexgen.X.C7O r8, com.facebook.ads.redexgen.X.C7W r9, int r10, android.os.Bundle r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0Q(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W, int, android.os.Bundle):boolean");
    }

    private final boolean A0R(C7O c7o, C7W c7w, View view, int i, Bundle bundle) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0067, code lost:            return r7;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0S(com.facebook.ads.redexgen.X.C01807a r10, int r11, int r12) {
        /*
            r9 = this;
            r6 = r9
            r5 = 0
            r1 = 0
            r0 = 0
            r0 = 0
            r4 = 0
            r8 = 0
            r7 = 0
            android.view.View r3 = r10.getFocusedChild()
            if (r3 != 0) goto L65
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L67;
                case 3: goto L34;
                case 4: goto L29;
                case 5: goto L1e;
                case 6: goto L13;
                case 7: goto L62;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            android.graphics.Rect r8 = (android.graphics.Rect) r8
            int r0 = r8.bottom
            int r0 = r0 - r12
            if (r0 <= r5) goto L1c
            r0 = 7
            goto Lf
        L1c:
            r0 = 2
            goto Lf
        L1e:
            android.graphics.Rect r8 = (android.graphics.Rect) r8
            int r0 = r8.top
            int r0 = r0 - r12
            if (r0 >= r1) goto L27
            r0 = 6
            goto Lf
        L27:
            r0 = 2
            goto Lf
        L29:
            android.graphics.Rect r8 = (android.graphics.Rect) r8
            int r0 = r8.right
            int r0 = r0 - r11
            if (r0 <= r4) goto L32
            r0 = 5
            goto Lf
        L32:
            r0 = 2
            goto Lf
        L34:
            com.facebook.ads.redexgen.X.6g r6 = (com.facebook.ads.redexgen.X.AbstractC01616g) r6
            android.view.View r3 = (android.view.View) r3
            int r4 = r6.A0e()
            int r5 = r6.A0g()
            int r2 = r6.A0h()
            int r0 = r6.A0f()
            int r2 = r2 - r0
            int r1 = r6.A0X()
            int r0 = r6.A0d()
            int r1 = r1 - r0
            com.facebook.ads.redexgen.X.7a r0 = r6.A03
            android.graphics.Rect r8 = r0.A0p
            r6.A0H(r3, r8)
            int r0 = r8.left
            int r0 = r0 - r11
            if (r0 >= r2) goto L60
            r0 = 4
            goto Lf
        L60:
            r0 = 2
            goto Lf
        L62:
            r7 = 1
            r0 = 2
            goto Lf
        L65:
            r0 = 3
            goto Lf
        L67:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0S(com.facebook.ads.redexgen.X.7a, int, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0020, code lost:            return r1;     */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0T(com.facebook.ads.redexgen.X.C01807a r3, android.view.View r4, android.view.View r5) {
        /*
            r2 = this;
            r1 = 0
            boolean r0 = r2.A0N()
            if (r0 != 0) goto L1e
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L18;
                case 4: goto L20;
                case 5: goto L1b;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            boolean r0 = r3.A1j()
            if (r0 == 0) goto L16
            r0 = 3
            goto L8
        L16:
            r0 = 5
            goto L8
        L18:
            r1 = 1
            r0 = 4
            goto L8
        L1b:
            r1 = 0
            r0 = 4
            goto L8
        L1e:
            r0 = 3
            goto L8
        L20:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0T(com.facebook.ads.redexgen.X.7a, android.view.View, android.view.View):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b0, code lost:            r5 = r5;        r5[0] = r15;        r5[1] = r14;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ba, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int[] A0U(com.facebook.ads.redexgen.X.C01807a r17, android.view.View r18, android.graphics.Rect r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0U(com.facebook.ads.redexgen.X.7a, android.view.View, android.graphics.Rect, boolean):int[]");
    }

    public final int A0V() {
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0W() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.6J r0 = r2.A01
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
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.6J r0 = r2.A01
            int r1 = r0.A05()
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
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0W():int");
    }

    public final int A0X() {
        return this.A0A;
    }

    public final int A0Y() {
        return this.A0B;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x002a, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0Z() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.7a r0 = r3.A03
            if (r0 == 0) goto L28
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L1b;
                case 3: goto L15;
                case 4: goto Lf;
                case 5: goto L2a;
                case 6: goto Lc;
                case 7: goto L25;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r2 = 0
            r0 = 5
            goto L8
        Lf:
            int r2 = r1.A0C()
            r0 = 5
            goto L8
        L15:
            if (r1 == 0) goto L19
            r0 = 4
            goto L8
        L19:
            r0 = 6
            goto L8
        L1b:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            com.facebook.ads.redexgen.X.7a r0 = r3.A03
            com.facebook.ads.redexgen.X.2E r1 = r0.getAdapter()
            r0 = 3
            goto L8
        L25:
            r1 = 0
            r0 = 3
            goto L8
        L28:
            r0 = 7
            goto L8
        L2a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0Z():int");
    }

    public final int A0a() {
        return C5B.A01(this.A03);
    }

    public final int A0b() {
        return C5B.A02(this.A03);
    }

    public final int A0c() {
        return C5B.A03(this.A03);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0d() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
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
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            int r1 = r0.getPaddingBottom()
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
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0d():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0e() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
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
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            int r1 = r0.getPaddingLeft()
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
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0e():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0f() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
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
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            int r1 = r0.getPaddingRight()
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
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0f():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0g() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
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
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            int r1 = r0.getPaddingTop()
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
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0g():int");
    }

    public final int A0h() {
        return this.A0C;
    }

    public final int A0i() {
        return this.A0D;
    }

    public final int A0j(View view) {
        return view.getBottom() + A02(view);
    }

    public final int A0k(View view) {
        return view.getLeft() - A03(view);
    }

    public final int A0l(View view) {
        Rect rect = ((C01596e) view.getLayoutParams()).A03;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public final int A0m(View view) {
        Rect rect = ((C01596e) view.getLayoutParams()).A03;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public final int A0n(View view) {
        return view.getRight() + A04(view);
    }

    public final int A0o(View view) {
        return view.getTop() - A05(view);
    }

    public final int A0p(View view) {
        return ((C01596e) view.getLayoutParams()).A00();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0032, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int A0q(com.facebook.ads.redexgen.X.C7O r4, com.facebook.ads.redexgen.X.C7W r5) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 1
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            if (r0 == 0) goto L30
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L32;
                case 4: goto L18;
                case 5: goto L24;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            com.facebook.ads.redexgen.X.2E r0 = r0.A04
            if (r0 != 0) goto L16
            r0 = 3
            goto L8
        L16:
            r0 = 4
            goto L8
        L18:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            boolean r0 = r2.A24()
            if (r0 == 0) goto L22
            r0 = 5
            goto L8
        L22:
            r0 = 3
            goto L8
        L24:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            com.facebook.ads.redexgen.X.2E r0 = r0.A04
            int r1 = r0.A0C()
            r0 = 3
            goto L8
        L30:
            r0 = 3
            goto L8
        L32:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0q(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0032, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int A0r(com.facebook.ads.redexgen.X.C7O r4, com.facebook.ads.redexgen.X.C7W r5) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 1
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            if (r0 == 0) goto L30
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L32;
                case 4: goto L18;
                case 5: goto L24;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            com.facebook.ads.redexgen.X.2E r0 = r0.A04
            if (r0 != 0) goto L16
            r0 = 3
            goto L8
        L16:
            r0 = 4
            goto L8
        L18:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            boolean r0 = r2.A25()
            if (r0 == 0) goto L22
            r0 = 5
            goto L8
        L22:
            r0 = 3
            goto L8
        L24:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            com.facebook.ads.redexgen.X.2E r0 = r0.A04
            int r1 = r0.A0C()
            r0 = 3
            goto L8
        L30:
            r0 = 3
            goto L8
        L32:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0r(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0035, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View A0s() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            if (r0 != 0) goto L31
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L33;
                case 4: goto L10;
                case 5: goto L1e;
                case 6: goto L2e;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            android.view.View r1 = r0.getFocusedChild()
            if (r1 == 0) goto L1c
            r0 = 5
            goto L9
        L1c:
            r0 = 6
            goto L9
        L1e:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            android.view.View r1 = (android.view.View) r1
            com.facebook.ads.redexgen.X.6J r0 = r2.A01
            boolean r0 = r0.A0K(r1)
            if (r0 == 0) goto L2c
            r0 = 6
            goto L9
        L2c:
            r0 = 3
            goto L9
        L2e:
            r1 = 0
            r0 = 3
            goto L9
        L31:
            r0 = 4
            goto L9
        L33:
            android.view.View r1 = (android.view.View) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0s():android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001c, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View A0t(int r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.6J r0 = r2.A01
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
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.6J r0 = r2.A01
            android.view.View r1 = r0.A09(r4)
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
            android.view.View r1 = (android.view.View) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0t(int):android.view.View");
    }

    public final View A0u(View view, int i) {
        return null;
    }

    public C01596e A0v(Context context, AttributeSet attributeSet) {
        return new C01596e(context, attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.facebook.ads.redexgen.X.C01596e A0w(android.view.ViewGroup.LayoutParams r3) {
        /*
            r2 = this;
            r1 = 0
            boolean r0 = r3 instanceof com.facebook.ads.redexgen.X.C01596e
            if (r0 == 0) goto L35
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L37;
                case 4: goto L16;
                case 5: goto L20;
                case 6: goto L2c;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            com.facebook.ads.redexgen.X.6e r1 = new com.facebook.ads.redexgen.X.6e
            r0 = r3
            com.facebook.ads.redexgen.X.6e r0 = (com.facebook.ads.redexgen.X.C01596e) r0
            r1.<init>(r0)
            r0 = 3
            goto L6
        L16:
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            boolean r0 = r3 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r0 == 0) goto L1e
            r0 = 5
            goto L6
        L1e:
            r0 = 6
            goto L6
        L20:
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            com.facebook.ads.redexgen.X.6e r1 = new com.facebook.ads.redexgen.X.6e
            r0 = r3
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            r1.<init>(r0)
            r0 = 3
            goto L6
        L2c:
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            com.facebook.ads.redexgen.X.6e r1 = new com.facebook.ads.redexgen.X.6e
            r1.<init>(r3)
            r0 = 3
            goto L6
        L35:
            r0 = 4
            goto L6
        L37:
            com.facebook.ads.redexgen.X.6e r1 = (com.facebook.ads.redexgen.X.C01596e) r1
            com.facebook.ads.redexgen.X.6e r1 = (com.facebook.ads.redexgen.X.C01596e) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A0w(android.view.ViewGroup$LayoutParams):com.facebook.ads.redexgen.X.6e");
    }

    public final void A0x() {
        if (this.A02 != null) {
            this.A02.A09();
        }
    }

    public final void A0y() {
        if (this.A03 != null) {
            this.A03.requestLayout();
        }
    }

    public final void A0z(int i) {
        if (this.A03 != null) {
            this.A03.A1I(i);
        }
    }

    public final void A10(int i) {
        if (this.A03 != null) {
            this.A03.A1J(i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x004d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A11(int r4, int r5) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            int r0 = android.view.View.MeasureSpec.getSize(r4)
            r2.A0C = r0
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            r2.A0D = r0
            int r0 = r2.A0D
            if (r0 != 0) goto L4b
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L43;
                case 3: goto L3c;
                case 4: goto L26;
                case 5: goto L1e;
                case 6: goto L18;
                case 7: goto L4d;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            r2.A0A = r1
            r0 = 7
            goto L14
        L1e:
            boolean r0 = com.facebook.ads.redexgen.X.C01807a.A1A
            if (r0 != 0) goto L24
            r0 = 6
            goto L14
        L24:
            r0 = 7
            goto L14
        L26:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            int r0 = android.view.View.MeasureSpec.getSize(r5)
            r2.A0A = r0
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            r2.A0B = r0
            int r0 = r2.A0B
            if (r0 != 0) goto L3a
            r0 = 5
            goto L14
        L3a:
            r0 = 7
            goto L14
        L3c:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            r1 = 0
            r2.A0C = r1
            r0 = 4
            goto L14
        L43:
            boolean r0 = com.facebook.ads.redexgen.X.C01807a.A1A
            if (r0 != 0) goto L49
            r0 = 3
            goto L14
        L49:
            r0 = 4
            goto L14
        L4b:
            r0 = 4
            goto L14
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A11(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x00a1, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A12(int r11, int r12) {
        /*
            r10 = this;
            r8 = r10
            r7 = 0
            r6 = 0
            r5 = 0
            r4 = 0
            r3 = 0
            r0 = 0
            r2 = 0
            int r1 = r8.A0W()
            if (r1 != 0) goto L9e
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L29;
                case 3: goto La1;
                case 4: goto L45;
                case 5: goto L3e;
                case 6: goto L13;
                case 7: goto L59;
                case 8: goto L79;
                case 9: goto L85;
                case 10: goto L90;
                case 11: goto L60;
                case 12: goto L32;
                case 13: goto L52;
                case 14: goto L8c;
                case 15: goto L67;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.6g r8 = (com.facebook.ads.redexgen.X.AbstractC01616g) r8
            android.view.View r9 = r8.A0t(r3)
            com.facebook.ads.redexgen.X.7a r0 = r8.A03
            android.graphics.Rect r4 = r0.A0p
            r8.A0H(r9, r4)
            int r0 = r4.left
            if (r0 >= r2) goto L26
            r0 = 7
            goto Lf
        L26:
            r0 = 8
            goto Lf
        L29:
            com.facebook.ads.redexgen.X.6g r8 = (com.facebook.ads.redexgen.X.AbstractC01616g) r8
            com.facebook.ads.redexgen.X.7a r0 = r8.A03
            r0.A1P(r11, r12)
            r0 = 3
            goto Lf
        L32:
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            int r0 = r4.bottom
            if (r0 <= r7) goto L3b
            r0 = 13
            goto Lf
        L3b:
            r0 = 14
            goto Lf
        L3e:
            if (r3 >= r1) goto L42
            r0 = 6
            goto Lf
        L42:
            r0 = 15
            goto Lf
        L45:
            r2 = 2147483647(0x7fffffff, float:NaN)
            r6 = 2147483647(0x7fffffff, float:NaN)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r0 = 5
            goto Lf
        L52:
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            int r7 = r4.bottom
            r0 = 14
            goto Lf
        L59:
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            int r2 = r4.left
            r0 = 8
            goto Lf
        L60:
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            int r6 = r4.top
            r0 = 12
            goto Lf
        L67:
            com.facebook.ads.redexgen.X.6g r8 = (com.facebook.ads.redexgen.X.AbstractC01616g) r8
            com.facebook.ads.redexgen.X.7a r0 = r8.A03
            android.graphics.Rect r0 = r0.A0p
            r0.set(r2, r6, r5, r7)
            com.facebook.ads.redexgen.X.7a r0 = r8.A03
            android.graphics.Rect r0 = r0.A0p
            r8.A15(r0, r11, r12)
            r0 = 3
            goto Lf
        L79:
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            int r0 = r4.right
            if (r0 <= r5) goto L82
            r0 = 9
            goto Lf
        L82:
            r0 = 10
            goto Lf
        L85:
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            int r5 = r4.right
            r0 = 10
            goto Lf
        L8c:
            int r3 = r3 + 1
            r0 = 5
            goto Lf
        L90:
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            int r0 = r4.top
            if (r0 >= r6) goto L9a
            r0 = 11
            goto Lf
        L9a:
            r0 = 12
            goto Lf
        L9e:
            r0 = 4
            goto Lf
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A12(int, int):void");
    }

    public final void A13(int i, int i2) {
        this.A03.setMeasuredDimension(i, i2);
    }

    public final void A14(int i, C7O c7o) {
        View A0t = A0t(i);
        A0A(i);
        c7o.A0X(A0t);
    }

    public void A15(Rect rect, int usedWidth, int width) {
        A13(A00(usedWidth, rect.width() + A0e() + A0f(), A0c()), A00(width, rect.height() + A0g() + A0d(), A0b()));
    }

    public final void A16(View view) {
        A18(view, -1);
    }

    public final void A17(View view) {
        A19(view, -1);
    }

    public final void A18(View view, int i) {
        A0G(view, i, true);
    }

    public final void A19(View view, int i) {
        A0G(view, i, false);
    }

    public final void A1A(View view, int i, int i2) {
        C01596e c01596e = (C01596e) view.getLayoutParams();
        Rect A13 = this.A03.A13(view);
        int i3 = i + A13.left + A13.right;
        int widthSpec = i2 + A13.top + A13.bottom;
        int A01 = A01(A0h(), A0i(), A0e() + A0f() + c01596e.leftMargin + c01596e.rightMargin + i3, c01596e.width, A24());
        int A012 = A01(A0X(), A0Y(), A0g() + A0d() + c01596e.topMargin + c01596e.bottomMargin + widthSpec, c01596e.height, A25());
        if (A1a(view, A01, A012, c01596e)) {
            view.measure(A01, A012);
        }
    }

    public final void A1B(View view, int i, int i2, int i3, int i4) {
        C01596e c01596e = (C01596e) view.getLayoutParams();
        Rect rect = c01596e.A03;
        view.layout(rect.left + i + c01596e.leftMargin, rect.top + i2 + c01596e.topMargin, (i3 - rect.right) - c01596e.rightMargin, (i4 - rect.bottom) - c01596e.bottomMargin);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1C(android.view.View r5, com.facebook.ads.redexgen.X.C5q r6) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            com.facebook.ads.redexgen.X.7Z r2 = com.facebook.ads.redexgen.X.C01807a.A05(r5)
            if (r2 == 0) goto L3e
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L19;
                case 4: goto L2b;
                case 5: goto L40;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            boolean r0 = r2.A0c()
            if (r0 != 0) goto L17
            r0 = 3
            goto L9
        L17:
            r0 = 5
            goto L9
        L19:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            com.facebook.ads.redexgen.X.6J r1 = r3.A01
            android.view.View r0 = r2.A0H
            boolean r0 = r1.A0K(r0)
            if (r0 != 0) goto L29
            r0 = 4
            goto L9
        L29:
            r0 = 5
            goto L9
        L2b:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            android.view.View r5 = (android.view.View) r5
            com.facebook.ads.redexgen.X.5q r6 = (com.facebook.ads.redexgen.X.C5q) r6
            com.facebook.ads.redexgen.X.7a r0 = r3.A03
            com.facebook.ads.redexgen.X.7O r1 = r0.A0r
            com.facebook.ads.redexgen.X.7a r0 = r3.A03
            com.facebook.ads.redexgen.X.7W r0 = r0.A0s
            r3.A1K(r1, r0, r5, r6)
            r0 = 5
            goto L9
        L3e:
            r0 = 5
            goto L9
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A1C(android.view.View, com.facebook.ads.redexgen.X.5q):void");
    }

    public final void A1D(View view, C7O c7o) {
        A0D(view);
        c7o.A0X(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x009e, code lost:            r9 = r9;        r11.offset(r9.getLeft(), r9.getTop());     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ad, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1E(android.view.View r9, boolean r10, android.graphics.Rect r11) {
        /*
            r8 = this;
            r4 = r8
            r0 = 0
            r6 = 0
            r0 = 0
            if (r10 == 0) goto L9a
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L62;
                case 3: goto L58;
                case 4: goto L4c;
                case 5: goto L40;
                case 6: goto Lb;
                case 7: goto L9e;
                case 8: goto L87;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.6g r4 = (com.facebook.ads.redexgen.X.AbstractC01616g) r4
            android.graphics.Rect r11 = (android.graphics.Rect) r11
            android.graphics.Matrix r6 = (android.graphics.Matrix) r6
            com.facebook.ads.redexgen.X.7a r0 = r4.A03
            android.graphics.RectF r5 = r0.A0q
            r5.set(r11)
            r6.mapRect(r5)
            float r0 = r5.left
            double r0 = (double) r0
            double r0 = java.lang.Math.floor(r0)
            int r3 = (int) r0
            float r0 = r5.top
            double r0 = (double) r0
            double r0 = java.lang.Math.floor(r0)
            int r2 = (int) r0
            float r0 = r5.right
            double r0 = (double) r0
            double r0 = java.lang.Math.ceil(r0)
            int r7 = (int) r0
            float r0 = r5.bottom
            double r0 = (double) r0
            double r0 = java.lang.Math.ceil(r0)
            int r5 = (int) r0
            r11.set(r3, r2, r7, r5)
            r0 = 7
            goto L7
        L40:
            android.graphics.Matrix r6 = (android.graphics.Matrix) r6
            boolean r0 = r6.isIdentity()
            if (r0 != 0) goto L4a
            r0 = 6
            goto L7
        L4a:
            r0 = 7
            goto L7
        L4c:
            android.view.View r9 = (android.view.View) r9
            android.graphics.Matrix r6 = r9.getMatrix()
            if (r6 == 0) goto L56
            r0 = 5
            goto L7
        L56:
            r0 = 7
            goto L7
        L58:
            com.facebook.ads.redexgen.X.6g r4 = (com.facebook.ads.redexgen.X.AbstractC01616g) r4
            com.facebook.ads.redexgen.X.7a r0 = r4.A03
            if (r0 == 0) goto L60
            r0 = 4
            goto L7
        L60:
            r0 = 7
            goto L7
        L62:
            android.view.View r9 = (android.view.View) r9
            android.graphics.Rect r11 = (android.graphics.Rect) r11
            android.view.ViewGroup$LayoutParams r0 = r9.getLayoutParams()
            com.facebook.ads.redexgen.X.6e r0 = (com.facebook.ads.redexgen.X.C01596e) r0
            android.graphics.Rect r7 = r0.A03
            int r0 = r7.left
            int r5 = -r0
            int r0 = r7.top
            int r3 = -r0
            int r2 = r9.getWidth()
            int r0 = r7.right
            int r2 = r2 + r0
            int r1 = r9.getHeight()
            int r0 = r7.bottom
            int r1 = r1 + r0
            r11.set(r5, r3, r2, r1)
            r0 = 3
            goto L7
        L87:
            android.view.View r9 = (android.view.View) r9
            android.graphics.Rect r11 = (android.graphics.Rect) r11
            r2 = 0
            int r1 = r9.getWidth()
            int r0 = r9.getHeight()
            r11.set(r2, r2, r1, r0)
            r0 = 3
            goto L7
        L9a:
            r0 = 8
            goto L7
        L9e:
            android.view.View r9 = (android.view.View) r9
            android.graphics.Rect r11 = (android.graphics.Rect) r11
            int r1 = r9.getLeft()
            int r0 = r9.getTop()
            r11.offset(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A1E(android.view.View, boolean, android.graphics.Rect):void");
    }

    public final void A1F(C5q c5q) {
        A0L(this.A03.A0r, this.A03.A0s, c5q);
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x008d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1G(com.facebook.ads.redexgen.X.C7O r8) {
        /*
            r7 = this;
            r5 = r7
            r0 = 0
            r0 = 0
            r0 = 0
            r4 = 0
            r3 = 0
            r2 = 0
            int r6 = r8.A0E()
            int r1 = r6 + (-1)
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L5d;
                case 3: goto L30;
                case 4: goto L2c;
                case 5: goto L1d;
                case 6: goto L12;
                case 7: goto L64;
                case 8: goto L72;
                case 9: goto L44;
                case 10: goto L80;
                case 11: goto L53;
                case 12: goto L8d;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.6g r5 = (com.facebook.ads.redexgen.X.AbstractC01616g) r5
            android.view.View r3 = (android.view.View) r3
            com.facebook.ads.redexgen.X.7a r0 = r5.A03
            r0.removeDetachedView(r3, r2)
            r0 = 7
            goto Le
        L1d:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            r4.A0Z(r2)
            boolean r0 = r4.A0e()
            if (r0 == 0) goto L2a
            r0 = 6
            goto Le
        L2a:
            r0 = 7
            goto Le
        L2c:
            int r1 = r1 + (-1)
            r0 = 2
            goto Le
        L30:
            com.facebook.ads.redexgen.X.7O r8 = (com.facebook.ads.redexgen.X.C7O) r8
            android.view.View r3 = r8.A0F(r1)
            com.facebook.ads.redexgen.X.7Z r4 = com.facebook.ads.redexgen.X.C01807a.A05(r3)
            boolean r0 = r4.A0h()
            if (r0 == 0) goto L42
            r0 = 4
            goto Le
        L42:
            r0 = 5
            goto Le
        L44:
            com.facebook.ads.redexgen.X.7O r8 = (com.facebook.ads.redexgen.X.C7O) r8
            android.view.View r3 = (android.view.View) r3
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            r0 = 1
            r4.A0Z(r0)
            r8.A0V(r3)
            r0 = 4
            goto Le
        L53:
            com.facebook.ads.redexgen.X.6g r5 = (com.facebook.ads.redexgen.X.AbstractC01616g) r5
            com.facebook.ads.redexgen.X.7a r0 = r5.A03
            r0.invalidate()
            r0 = 12
            goto Le
        L5d:
            if (r1 < 0) goto L61
            r0 = 3
            goto Le
        L61:
            r0 = 10
            goto Le
        L64:
            com.facebook.ads.redexgen.X.6g r5 = (com.facebook.ads.redexgen.X.AbstractC01616g) r5
            com.facebook.ads.redexgen.X.7a r0 = r5.A03
            com.facebook.ads.redexgen.X.6U r0 = r0.A05
            if (r0 == 0) goto L6f
            r0 = 8
            goto Le
        L6f:
            r0 = 9
            goto Le
        L72:
            com.facebook.ads.redexgen.X.6g r5 = (com.facebook.ads.redexgen.X.AbstractC01616g) r5
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            com.facebook.ads.redexgen.X.7a r0 = r5.A03
            com.facebook.ads.redexgen.X.6U r0 = r0.A05
            r0.A0I(r4)
            r0 = 9
            goto Le
        L80:
            com.facebook.ads.redexgen.X.7O r8 = (com.facebook.ads.redexgen.X.C7O) r8
            r8.A0L()
            if (r6 <= 0) goto L8a
            r0 = 11
            goto Le
        L8a:
            r0 = 12
            goto Le
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A1G(com.facebook.ads.redexgen.X.7O):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1H(com.facebook.ads.redexgen.X.C7O r4) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            int r0 = r2.A0W()
            int r1 = r0 + (-1)
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L13;
                case 4: goto L22;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            if (r1 < 0) goto L11
            r0 = 3
            goto L9
        L11:
            r0 = 4
            goto L9
        L13:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            android.view.View r0 = r2.A0t(r1)
            r2.A0J(r4, r1, r0)
            int r1 = r1 + (-1)
            r0 = 2
            goto L9
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A1H(com.facebook.ads.redexgen.X.7O):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0034, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1I(com.facebook.ads.redexgen.X.C7O r4) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            int r0 = r2.A0W()
            int r1 = r0 + (-1)
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L13;
                case 4: goto L27;
                case 5: goto L30;
                case 6: goto L34;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            if (r1 < 0) goto L11
            r0 = 3
            goto L9
        L11:
            r0 = 6
            goto L9
        L13:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            android.view.View r0 = r2.A0t(r1)
            com.facebook.ads.redexgen.X.7Z r0 = com.facebook.ads.redexgen.X.C01807a.A05(r0)
            boolean r0 = r0.A0h()
            if (r0 != 0) goto L25
            r0 = 4
            goto L9
        L25:
            r0 = 5
            goto L9
        L27:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7O r4 = (com.facebook.ads.redexgen.X.C7O) r4
            r2.A14(r1, r4)
            r0 = 5
            goto L9
        L30:
            int r1 = r1 + (-1)
            r0 = 2
            goto L9
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A1I(com.facebook.ads.redexgen.X.7O):void");
    }

    public void A1J(C7O c7o, C7W c7w, int i, int i2) {
        this.A03.A1P(i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x003a, code lost:            r0 = com.facebook.ads.redexgen.X.C01445o.A00(r2, 1, r4, 1, false, false);        r12.A0Q(r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A1K(com.facebook.ads.redexgen.X.C7O r9, com.facebook.ads.redexgen.X.C7W r10, android.view.View r11, com.facebook.ads.redexgen.X.C5q r12) {
        /*
            r8 = this;
            r1 = r8
            r4 = 0
            r0 = 0
            r0 = 0
            r2 = 0
            r3 = 1
            r0 = 0
            boolean r0 = r1.A25()
            if (r0 == 0) goto L38
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L2b;
                case 3: goto L1f;
                case 4: goto L15;
                case 5: goto L3a;
                case 6: goto L12;
                case 7: goto L35;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            r4 = 0
            r0 = 5
            goto Le
        L15:
            com.facebook.ads.redexgen.X.6g r1 = (com.facebook.ads.redexgen.X.AbstractC01616g) r1
            android.view.View r11 = (android.view.View) r11
            int r4 = r1.A0p(r11)
            r0 = 5
            goto Le
        L1f:
            com.facebook.ads.redexgen.X.6g r1 = (com.facebook.ads.redexgen.X.AbstractC01616g) r1
            boolean r0 = r1.A24()
            if (r0 == 0) goto L29
            r0 = 4
            goto Le
        L29:
            r0 = 6
            goto Le
        L2b:
            com.facebook.ads.redexgen.X.6g r1 = (com.facebook.ads.redexgen.X.AbstractC01616g) r1
            android.view.View r11 = (android.view.View) r11
            int r2 = r1.A0p(r11)
            r0 = 3
            goto Le
        L35:
            r2 = 0
            r0 = 3
            goto Le
        L38:
            r0 = 7
            goto Le
        L3a:
            com.facebook.ads.redexgen.X.5q r12 = (com.facebook.ads.redexgen.X.C5q) r12
            r6 = 0
            r5 = r3
            r7 = r6
            com.facebook.ads.redexgen.X.5o r0 = com.facebook.ads.redexgen.X.C01445o.A00(r2, r3, r4, r5, r6, r7)
            r12.A0Q(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A1K(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W, android.view.View, com.facebook.ads.redexgen.X.5q):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x002f, code lost:            r2 = r2;        r2.A02 = r4;        r2.A02.A0D(r2.A03, r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1L(com.facebook.ads.redexgen.X.AbstractC01696p r4) {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.6p r0 = r2.A02
            if (r0 == 0) goto L2d
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L16;
                case 4: goto L24;
                case 5: goto L2f;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.6p r4 = (com.facebook.ads.redexgen.X.AbstractC01696p) r4
            com.facebook.ads.redexgen.X.6p r0 = r2.A02
            if (r4 == r0) goto L14
            r0 = 3
            goto L6
        L14:
            r0 = 5
            goto L6
        L16:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.6p r0 = r2.A02
            boolean r0 = r0.A0F()
            if (r0 == 0) goto L22
            r0 = 4
            goto L6
        L22:
            r0 = 5
            goto L6
        L24:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.6p r0 = r2.A02
            r0.A09()
            r0 = 5
            goto L6
        L2d:
            r0 = 5
            goto L6
        L2f:
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.6p r4 = (com.facebook.ads.redexgen.X.AbstractC01696p) r4
            r2.A02 = r4
            com.facebook.ads.redexgen.X.6p r1 = r2.A02
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            r1.A0D(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A1L(com.facebook.ads.redexgen.X.6p):void");
    }

    public void A1M(C01807a c01807a) {
    }

    public final void A1N(C01807a c01807a) {
        this.A07 = true;
    }

    public final void A1O(C01807a c01807a) {
        A11(View.MeasureSpec.makeMeasureSpec(c01807a.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(c01807a.getHeight(), 1073741824));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:            r3 = r3;        r3.A0D = 1073741824;        r3.A0B = 1073741824;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1P(com.facebook.ads.redexgen.X.C01807a r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r2 = 1073741824(0x40000000, float:2.0)
            r0 = 0
            if (r5 != 0) goto L35
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L37;
                case 4: goto L1d;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            r1 = 0
            r0 = 0
            r3.A03 = r0
            r3.A01 = r0
            r3.A0C = r1
            r3.A0A = r1
            r0 = 3
            goto Lb
        L1d:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            r3.A03 = r5
            com.facebook.ads.redexgen.X.6J r0 = r5.A01
            r3.A01 = r0
            int r0 = r5.getWidth()
            r3.A0C = r0
            int r0 = r5.getHeight()
            r3.A0A = r0
            r0 = 3
            goto Lb
        L35:
            r0 = 4
            goto Lb
        L37:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            r3.A0D = r2
            r3.A0B = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A1P(com.facebook.ads.redexgen.X.7a):void");
    }

    public void A1Q(C01807a c01807a, int i, int i2) {
    }

    public void A1R(C01807a c01807a, int i, int i2) {
    }

    public void A1S(C01807a c01807a, int i, int i2, int i3) {
    }

    public void A1T(C01807a c01807a, int i, int i2, Object obj) {
    }

    public final void A1U(C01807a c01807a, C7O c7o) {
        this.A07 = false;
        A20(c01807a, c7o);
    }

    public final void A1V(boolean z) {
        this.A06 = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x003c, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A1W() {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r3 = 0
            r0 = 0
            r0 = 0
            int r2 = r5.A0W()
            r1 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L32;
                case 3: goto L1c;
                case 4: goto L12;
                case 5: goto Lf;
                case 6: goto L3c;
                case 7: goto L2e;
                case 8: goto L39;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            r3 = 1
            r0 = 6
            goto Lb
        L12:
            android.view.ViewGroup$LayoutParams r4 = (android.view.ViewGroup.LayoutParams) r4
            int r0 = r4.height
            if (r0 >= 0) goto L1a
            r0 = 5
            goto Lb
        L1a:
            r0 = 7
            goto Lb
        L1c:
            com.facebook.ads.redexgen.X.6g r5 = (com.facebook.ads.redexgen.X.AbstractC01616g) r5
            android.view.View r0 = r5.A0t(r1)
            android.view.ViewGroup$LayoutParams r4 = r0.getLayoutParams()
            int r0 = r4.width
            if (r0 >= 0) goto L2c
            r0 = 4
            goto Lb
        L2c:
            r0 = 7
            goto Lb
        L2e:
            int r1 = r1 + 1
            r0 = 2
            goto Lb
        L32:
            if (r1 >= r2) goto L36
            r0 = 3
            goto Lb
        L36:
            r0 = 8
            goto Lb
        L39:
            r3 = 0
            r0 = 6
            goto Lb
        L3c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A1W():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x001f, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A1X() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            if (r0 == 0) goto L1d
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
            com.facebook.ads.redexgen.X.6g r2 = (com.facebook.ads.redexgen.X.AbstractC01616g) r2
            com.facebook.ads.redexgen.X.7a r0 = r2.A03
            boolean r0 = r0.A0B
            if (r0 == 0) goto L15
            r0 = 3
            goto L7
        L15:
            r0 = 5
            goto L7
        L17:
            r1 = 1
            r0 = 4
            goto L7
        L1a:
            r1 = 0
            r0 = 4
            goto L7
        L1d:
            r0 = 5
            goto L7
        L1f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A1X():boolean");
    }

    public final boolean A1Y() {
        return this.A0E;
    }

    public final boolean A1Z(int i, Bundle bundle) {
        return A0Q(this.A03.A0r, this.A03.A0s, i, bundle);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0047, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A1a(android.view.View r5, int r6, int r7, com.facebook.ads.redexgen.X.C01596e r8) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            boolean r0 = r5.isLayoutRequested()
            if (r0 != 0) goto L45
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L2e;
                case 4: goto L1a;
                case 5: goto L17;
                case 6: goto L47;
                case 7: goto L42;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            boolean r0 = r3.A0F
            if (r0 == 0) goto L15
            r0 = 3
            goto L9
        L15:
            r0 = 5
            goto L9
        L17:
            r2 = 1
            r0 = 6
            goto L9
        L1a:
            android.view.View r5 = (android.view.View) r5
            com.facebook.ads.redexgen.X.6e r8 = (com.facebook.ads.redexgen.X.C01596e) r8
            int r1 = r5.getHeight()
            int r0 = r8.height
            boolean r0 = A0O(r1, r7, r0)
            if (r0 != 0) goto L2c
            r0 = 5
            goto L9
        L2c:
            r0 = 7
            goto L9
        L2e:
            android.view.View r5 = (android.view.View) r5
            com.facebook.ads.redexgen.X.6e r8 = (com.facebook.ads.redexgen.X.C01596e) r8
            int r1 = r5.getWidth()
            int r0 = r8.width
            boolean r0 = A0O(r1, r6, r0)
            if (r0 == 0) goto L40
            r0 = 4
            goto L9
        L40:
            r0 = 5
            goto L9
        L42:
            r2 = 0
            r0 = 6
            goto L9
        L45:
            r0 = 5
            goto L9
        L47:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A1a(android.view.View, int, int, com.facebook.ads.redexgen.X.6e):boolean");
    }

    public final boolean A1b(View view, int i, Bundle bundle) {
        return A0R(this.A03.A0r, this.A03.A0s, view, i, bundle);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0010, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean A1c(com.facebook.ads.redexgen.X.C01596e r3) {
        /*
            r2 = this;
            r1 = 0
            if (r3 == 0) goto Le
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L10;
                case 4: goto Lb;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            r1 = 1
            r0 = 3
            goto L4
        Lb:
            r1 = 0
            r0 = 3
            goto L4
        Le:
            r0 = 4
            goto L4
        L10:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A1c(com.facebook.ads.redexgen.X.6e):boolean");
    }

    public final boolean A1d(C01807a c01807a, View view, Rect rect, boolean z) {
        return A1e(c01807a, view, rect, z, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x004d, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A1e(com.facebook.ads.redexgen.X.C01807a r7, android.view.View r8, android.graphics.Rect r9, boolean r10, boolean r11) {
        /*
            r6 = this;
            r5 = r6
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r4 = 1
            r3 = 0
            int[] r0 = r5.A0U(r7, r8, r9, r10)
            r2 = r0[r3]
            r1 = r0[r4]
            if (r11 == 0) goto L4b
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L31;
                case 3: goto L2b;
                case 4: goto L24;
                case 5: goto L1d;
                case 6: goto L16;
                case 7: goto L40;
                case 8: goto L4d;
                case 9: goto L44;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            r7.scrollBy(r2, r1)
            r0 = 7
            goto L12
        L1d:
            if (r10 == 0) goto L21
            r0 = 6
            goto L12
        L21:
            r0 = 9
            goto L12
        L24:
            if (r1 == 0) goto L28
            r0 = 5
            goto L12
        L28:
            r0 = 8
            goto L12
        L2b:
            if (r2 != 0) goto L2f
            r0 = 4
            goto L12
        L2f:
            r0 = 5
            goto L12
        L31:
            com.facebook.ads.redexgen.X.6g r5 = (com.facebook.ads.redexgen.X.AbstractC01616g) r5
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            boolean r0 = r5.A0S(r7, r2, r1)
            if (r0 == 0) goto L3d
            r0 = 3
            goto L12
        L3d:
            r0 = 8
            goto L12
        L40:
            r3 = r4
            r0 = 8
            goto L12
        L44:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            r7.A1T(r2, r1)
            r0 = 7
            goto L12
        L4b:
            r0 = 3
            goto L12
        L4d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A1e(com.facebook.ads.redexgen.X.7a, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public final boolean A1f(C01807a c01807a, C7W c7w, View view, View view2) {
        return A0T(c01807a, view, view2);
    }

    public final boolean A1g(C01807a c01807a, ArrayList<View> arrayList, int i, int i2) {
        return false;
    }

    public int A1h(int i, C7O c7o, C7W c7w) {
        return 0;
    }

    public int A1i(int i, C7O c7o, C7W c7w) {
        return 0;
    }

    public int A1j(C7W c7w) {
        return 0;
    }

    public int A1k(C7W c7w) {
        return 0;
    }

    public int A1l(C7W c7w) {
        return 0;
    }

    public int A1m(C7W c7w) {
        return 0;
    }

    public int A1n(C7W c7w) {
        return 0;
    }

    public int A1o(C7W c7w) {
        return 0;
    }

    public Parcelable A1p() {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0067, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View A1q(int r7) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r3 = 0
            r0 = 0
            r0 = 0
            int r2 = r5.A0W()
            r1 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L33;
                case 3: goto L23;
                case 4: goto L1f;
                case 5: goto L1b;
                case 6: goto Lf;
                case 7: goto L39;
                case 8: goto L46;
                case 9: goto L58;
                case 10: goto L65;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r0 = r3.A0I()
            if (r0 != r7) goto L19
            r0 = 7
            goto Lb
        L19:
            r0 = 4
            goto Lb
        L1b:
            r4 = 0
            r0 = 10
            goto Lb
        L1f:
            int r1 = r1 + 1
            r0 = 2
            goto Lb
        L23:
            com.facebook.ads.redexgen.X.6g r5 = (com.facebook.ads.redexgen.X.AbstractC01616g) r5
            android.view.View r4 = r5.A0t(r1)
            com.facebook.ads.redexgen.X.7Z r3 = com.facebook.ads.redexgen.X.C01807a.A05(r4)
            if (r3 != 0) goto L31
            r0 = 4
            goto Lb
        L31:
            r0 = 6
            goto Lb
        L33:
            if (r1 >= r2) goto L37
            r0 = 3
            goto Lb
        L37:
            r0 = 5
            goto Lb
        L39:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            boolean r0 = r3.A0h()
            if (r0 != 0) goto L44
            r0 = 8
            goto Lb
        L44:
            r0 = 4
            goto Lb
        L46:
            com.facebook.ads.redexgen.X.6g r5 = (com.facebook.ads.redexgen.X.AbstractC01616g) r5
            com.facebook.ads.redexgen.X.7a r0 = r5.A03
            com.facebook.ads.redexgen.X.7W r0 = r0.A0s
            boolean r0 = r0.A07()
            if (r0 != 0) goto L55
            r0 = 9
            goto Lb
        L55:
            r0 = 10
            goto Lb
        L58:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            boolean r0 = r3.A0c()
            if (r0 != 0) goto L63
            r0 = 10
            goto Lb
        L63:
            r0 = 4
            goto Lb
        L65:
            android.view.View r4 = (android.view.View) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01616g.A1q(int):android.view.View");
    }

    @Nullable
    public View A1r(View view, int i, C7O c7o, C7W c7w) {
        return null;
    }

    public void A1t(int i) {
    }

    public void A1u(int i, int i2, C7W c7w, C6Y c6y) {
    }

    public void A1v(int i, C6Y c6y) {
    }

    public void A1w(Parcelable parcelable) {
    }

    public void A1x(AccessibilityEvent accessibilityEvent) {
        A0K(this.A03.A0r, this.A03.A0s, accessibilityEvent);
    }

    public void A1y(C7O c7o, C7W c7w) {
        Log.e(A07(264, 12, 9), A07(85, 67, 117));
    }

    public void A1z(C7W c7w) {
    }

    @CallSuper
    public void A20(C01807a c01807a, C7O c7o) {
    }

    public void A21(C01807a c01807a, C7W c7w, int i) {
        Log.e(A07(264, 12, 9), A07(152, 68, 14));
    }

    public void A22(String str) {
        if (this.A03 != null) {
            this.A03.A1e(str);
        }
    }

    public boolean A23() {
        return false;
    }

    public boolean A24() {
        return false;
    }

    public boolean A25() {
        return false;
    }

    public boolean A26() {
        return false;
    }
}
