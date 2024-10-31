package com.facebook.ads.redexgen.X;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.6p, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC01696p {
    public static byte[] A07;
    public View A01;
    public AbstractC01616g A02;
    public C01807a A03;
    public boolean A04;
    public boolean A05;
    public int A00 = -1;
    public final C7U A06 = new C7U(0, 0);

    static {
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AbstractC01696p.A07
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01696p.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A07 = new byte[]{22, 49, 41, 62, 51, 54, 59, Byte.MAX_VALUE, 43, 62, 45, 56, 58, 43, Byte.MAX_VALUE, 47, 48, 44, 54, 43, 54, 48, 49, 118, 71, 85, 85, 67, 66, 6, 73, 80, 67, 84, 6, 82, 71, 84, 65, 67, 82, 6, 86, 73, 85, 79, 82, 79, 73, 72, 6, 81, 78, 79, 74, 67, 6, 85, 75, 73, 73, 82, 78, 6, 85, 69, 84, 73, 74, 74, 79, 72, 65, 8, 112, 71, 65, 91, 65, 78, 71, 80, 116, 75, 71, 85};
    }

    public abstract void A0G();

    public abstract void A0H(int i, int i2, C7W c7w, C7U c7u);

    public abstract void A0I(View view, C7W c7w, C7U c7u);

    private final int A00(View view) {
        return this.A03.A11(view);
    }

    private final View A01(int i) {
        return this.A03.A06.A1q(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00d1, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A04(int r7, int r8) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC01696p.A04(int, int):void");
    }

    public static /* synthetic */ void A05(AbstractC01696p abstractC01696p, int i, int i2) {
        abstractC01696p.A04(i, i2);
    }

    public final int A06() {
        return this.A03.A06.A0W();
    }

    public final int A07() {
        return this.A00;
    }

    @Nullable
    public final AbstractC01616g A08() {
        return this.A02;
    }

    public final void A09() {
        if (!this.A05) {
            return;
        }
        A0G();
        this.A03.A0s.A0F = -1;
        this.A01 = null;
        this.A00 = -1;
        this.A04 = false;
        this.A05 = false;
        this.A02.A0M(this);
        this.A02 = null;
        this.A03 = null;
    }

    public final void A0A(int i) {
        this.A00 = i;
    }

    public final void A0B(PointF pointF) {
        float sqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
        pointF.x /= sqrt;
        pointF.y /= sqrt;
    }

    public final void A0C(View view) {
        if (A00(view) == A07()) {
            this.A01 = view;
        }
    }

    public final void A0D(C01807a c01807a, AbstractC01616g abstractC01616g) {
        this.A03 = c01807a;
        this.A02 = abstractC01616g;
        if (this.A00 == -1) {
            throw new IllegalArgumentException(A02(0, 23, 65));
        }
        this.A03.A0s.A0F = this.A00;
        this.A05 = true;
        this.A04 = true;
        this.A01 = A01(A07());
        this.A03.A08.A07();
    }

    public final boolean A0E() {
        return this.A04;
    }

    public final boolean A0F() {
        return this.A05;
    }
}
