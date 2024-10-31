package com.facebook.ads.redexgen.X;

import android.graphics.PointF;
import android.util.DisplayMetrics;

/* loaded from: assets/audience_network.dex */
public class L2 extends C01706q {
    public final /* synthetic */ L3 A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L2(L3 l3, C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A00 = l3;
    }

    @Override // com.facebook.ads.redexgen.X.C01706q
    public final float A0J(DisplayMetrics displayMetrics) {
        float f;
        f = this.A00.A00;
        return f / displayMetrics.densityDpi;
    }

    @Override // com.facebook.ads.redexgen.X.C01706q
    public final int A0K() {
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.C01706q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0O(android.view.View r10, int r11) {
        /*
            r9 = this;
            r3 = r9
            r0 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.6g r2 = r3.A08()
            boolean r0 = r2.A24()
            if (r0 != 0) goto L4a
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L4c;
                case 4: goto L15;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            r1 = 0
            r0 = 3
            goto Le
        L15:
            com.facebook.ads.redexgen.X.L2 r3 = (com.facebook.ads.redexgen.X.L2) r3
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
            com.facebook.ads.redexgen.X.L3 r0 = r3.A00
            int r0 = com.facebook.ads.redexgen.X.L3.A03(r0)
            int r1 = r1 + r0
            r0 = 3
            goto Le
        L4a:
            r0 = 4
            goto Le
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.L2.A0O(android.view.View, int):int");
    }

    @Override // com.facebook.ads.redexgen.X.C01706q
    public final PointF A0P(int i) {
        return this.A00.A3i(i);
    }
}
