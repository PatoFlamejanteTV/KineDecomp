package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.6s, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC01726s {
    public static byte[] A03;
    public int A00;
    public final Rect A01;
    public final AbstractC01616g A02;

    static {
        A04();
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
            byte[] r1 = com.facebook.ads.redexgen.X.AbstractC01726s.A03
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
            int r0 = r0 + (-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01726s.A03(int, int, int):java.lang.String");
    }

    public static void A04() {
        A03 = new byte[]{-106, -101, -93, -114, -103, -106, -111, 77, -100, -97, -106, -110, -101, -95, -114, -95, -106, -100, -101};
    }

    public abstract int A06();

    public abstract int A07();

    public abstract int A08();

    public abstract int A09();

    public abstract int A0A();

    public abstract int A0B();

    public abstract int A0C(View view);

    public abstract int A0D(View view);

    public abstract int A0E(View view);

    public abstract int A0F(View view);

    public abstract int A0G(View view);

    public abstract int A0H(View view);

    public abstract void A0J(int i);

    public AbstractC01726s(AbstractC01616g abstractC01616g) {
        this.A00 = Integer.MIN_VALUE;
        this.A01 = new Rect();
        this.A02 = abstractC01616g;
    }

    public static AbstractC01726s A00(final AbstractC01616g abstractC01616g) {
        return new AbstractC01726s(abstractC01616g) { // from class: com.facebook.ads.redexgen.X.6t
            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A06() {
                return this.A02.A0h();
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A07() {
                return this.A02.A0h() - this.A02.A0f();
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A08() {
                return this.A02.A0f();
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A09() {
                return this.A02.A0i();
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0A() {
                return this.A02.A0e();
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0B() {
                return (this.A02.A0h() - this.A02.A0e()) - this.A02.A0f();
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0C(View view) {
                return this.A02.A0n(view) + ((C01596e) view.getLayoutParams()).rightMargin;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0D(View view) {
                C01596e c01596e = (C01596e) view.getLayoutParams();
                return this.A02.A0m(view) + c01596e.leftMargin + c01596e.rightMargin;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0E(View view) {
                C01596e c01596e = (C01596e) view.getLayoutParams();
                return this.A02.A0l(view) + c01596e.topMargin + c01596e.bottomMargin;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0F(View view) {
                return this.A02.A0k(view) - ((C01596e) view.getLayoutParams()).leftMargin;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0G(View view) {
                this.A02.A1E(view, true, this.A01);
                return this.A01.right;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0H(View view) {
                this.A02.A1E(view, true, this.A01);
                return this.A01.left;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final void A0J(int i) {
                this.A02.A0z(i);
            }
        };
    }

    public static AbstractC01726s A01(final AbstractC01616g abstractC01616g) {
        return new AbstractC01726s(abstractC01616g) { // from class: com.facebook.ads.redexgen.X.6u
            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A06() {
                return this.A02.A0X();
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A07() {
                return this.A02.A0X() - this.A02.A0d();
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A08() {
                return this.A02.A0d();
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A09() {
                return this.A02.A0Y();
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0A() {
                return this.A02.A0g();
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0B() {
                return (this.A02.A0X() - this.A02.A0g()) - this.A02.A0d();
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0C(View view) {
                return this.A02.A0j(view) + ((C01596e) view.getLayoutParams()).bottomMargin;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0D(View view) {
                C01596e c01596e = (C01596e) view.getLayoutParams();
                return this.A02.A0l(view) + c01596e.topMargin + c01596e.bottomMargin;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0E(View view) {
                C01596e c01596e = (C01596e) view.getLayoutParams();
                return this.A02.A0m(view) + c01596e.leftMargin + c01596e.rightMargin;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0F(View view) {
                return this.A02.A0o(view) - ((C01596e) view.getLayoutParams()).topMargin;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0G(View view) {
                this.A02.A1E(view, true, this.A01);
                return this.A01.bottom;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final int A0H(View view) {
                this.A02.A1E(view, true, this.A01);
                return this.A01.top;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01726s
            public final void A0J(int i) {
                this.A02.A10(i);
            }
        };
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0005. Please report as an issue. */
    public static AbstractC01726s A02(AbstractC01616g abstractC01616g, int i) {
        char c;
        AbstractC01726s abstractC01726s = null;
        switch (i) {
            case 0:
                c = 4;
                break;
            case 1:
                c = 3;
                break;
            default:
                c = 2;
                break;
        }
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalArgumentException(A03(0, 19, 2));
                case 3:
                    abstractC01616g = abstractC01616g;
                    abstractC01726s = A01(abstractC01616g);
                    c = 5;
                case 4:
                    abstractC01616g = abstractC01616g;
                    abstractC01726s = A00(abstractC01616g);
                    c = 5;
                case 5:
                    return abstractC01726s;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A05() {
        /*
            r4 = this;
            r3 = r4
            r1 = 0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r0 = r3.A00
            if (r2 != r0) goto L1b
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1d;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.6s r3 = (com.facebook.ads.redexgen.X.AbstractC01726s) r3
            int r1 = r3.A0B()
            int r0 = r3.A00
            int r1 = r1 - r0
            r0 = 3
            goto L9
        L1b:
            r0 = 4
            goto L9
        L1d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01726s.A05():int");
    }

    public final void A0I() {
        this.A00 = A0B();
    }
}
