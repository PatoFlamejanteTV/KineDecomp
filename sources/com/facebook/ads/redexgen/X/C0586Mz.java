package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;

/* renamed from: com.facebook.ads.redexgen.X.Mz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0586Mz extends ViewGroup {
    public static final int A01 = (int) (8.0f * KE.A01);
    public int A00;

    public C0586Mz(C0362Ec c0362Ec) {
        super(c0362Ec);
        setMotionEventSplittingEnabled(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:            return;     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        /*
            r9 = this;
            r6 = r9
            r8 = 0
            r7 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r5 = 0
            int r13 = r13 - r11
            int r4 = r6.getPaddingLeft()
            int r3 = r6.getPaddingTop()
            r2 = 0
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L23;
                case 4: goto L39;
                case 5: goto L44;
                case 6: goto L55;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            com.facebook.ads.redexgen.X.Mz r6 = (com.facebook.ads.redexgen.X.C0586Mz) r6
            int r0 = r6.getChildCount()
            if (r2 >= r0) goto L21
            r0 = 3
            goto L13
        L21:
            r0 = 6
            goto L13
        L23:
            com.facebook.ads.redexgen.X.Mz r6 = (com.facebook.ads.redexgen.X.C0586Mz) r6
            android.view.View r5 = r6.getChildAt(r2)
            int r7 = r5.getMeasuredWidth()
            int r8 = r5.getMeasuredHeight()
            int r0 = r4 + r7
            if (r0 <= r13) goto L37
            r0 = 4
            goto L13
        L37:
            r0 = 5
            goto L13
        L39:
            com.facebook.ads.redexgen.X.Mz r6 = (com.facebook.ads.redexgen.X.C0586Mz) r6
            int r4 = r6.getPaddingLeft()
            int r0 = r6.A00
            int r3 = r3 + r0
            r0 = 5
            goto L13
        L44:
            android.view.View r5 = (android.view.View) r5
            int r1 = r4 + r7
            int r0 = r3 + r8
            r5.layout(r4, r3, r1, r0)
            int r0 = com.facebook.ads.redexgen.X.C0586Mz.A01
            int r0 = r0 + r7
            int r4 = r4 + r0
            int r2 = r2 + 1
            r0 = 2
            goto L13
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0586Mz.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x008a, code lost:            r6 = r6;        r6.A00 = r3;        r1 = r6.A00 * r9;        r0 = com.facebook.ads.redexgen.X.C0586Mz.A01;        r6.setMeasuredDimension(r5, r1 + r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0097, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r12, int r13) {
        /*
            r11 = this;
            r6 = r11
            r10 = 0
            r9 = 0
            r0 = 0
            r8 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            int r5 = android.view.View.MeasureSpec.getSize(r12)
            int r0 = r6.getPaddingLeft()
            int r5 = r5 - r0
            int r0 = r6.getPaddingRight()
            int r5 = r5 - r0
            int r1 = android.view.View.MeasureSpec.getSize(r13)
            int r0 = r6.getPaddingTop()
            int r1 = r1 - r0
            int r0 = r6.getPaddingBottom()
            int r1 = r1 - r0
            int r4 = r6.getPaddingLeft()
            r3 = 0
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r7)
            int r0 = r6.getChildCount()
            if (r0 <= 0) goto L87
            r0 = 2
        L37:
            switch(r0) {
                case 2: goto L79;
                case 3: goto L76;
                case 4: goto L69;
                case 5: goto L45;
                case 6: goto L3b;
                case 7: goto L7c;
                case 8: goto L84;
                case 9: goto L8a;
                default: goto L3a;
            }
        L3a:
            goto L37
        L3b:
            com.facebook.ads.redexgen.X.Mz r6 = (com.facebook.ads.redexgen.X.C0586Mz) r6
            int r9 = r9 + 1
            int r4 = r6.getPaddingLeft()
            r0 = 7
            goto L37
        L45:
            com.facebook.ads.redexgen.X.Mz r6 = (com.facebook.ads.redexgen.X.C0586Mz) r6
            android.view.View r1 = r6.getChildAt(r8)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r7)
            r1.measure(r0, r2)
            int r10 = r1.getMeasuredWidth()
            int r1 = r1.getMeasuredHeight()
            int r0 = com.facebook.ads.redexgen.X.C0586Mz.A01
            int r1 = r1 + r0
            int r3 = java.lang.Math.max(r3, r1)
            int r0 = r4 + r10
            if (r0 <= r5) goto L67
            r0 = 6
            goto L37
        L67:
            r0 = 7
            goto L37
        L69:
            com.facebook.ads.redexgen.X.Mz r6 = (com.facebook.ads.redexgen.X.C0586Mz) r6
            int r0 = r6.getChildCount()
            if (r8 >= r0) goto L73
            r0 = 5
            goto L37
        L73:
            r0 = 9
            goto L37
        L76:
            r8 = 0
            r0 = 4
            goto L37
        L79:
            r9 = 1
            r0 = 3
            goto L37
        L7c:
            int r0 = com.facebook.ads.redexgen.X.C0586Mz.A01
            int r0 = r0 + r10
            int r4 = r4 + r0
            int r8 = r8 + 1
            r0 = 4
            goto L37
        L84:
            r9 = 0
            r0 = 3
            goto L37
        L87:
            r0 = 8
            goto L37
        L8a:
            com.facebook.ads.redexgen.X.Mz r6 = (com.facebook.ads.redexgen.X.C0586Mz) r6
            r6.A00 = r3
            int r1 = r6.A00
            int r1 = r1 * r9
            int r0 = com.facebook.ads.redexgen.X.C0586Mz.A01
            int r1 = r1 + r0
            r6.setMeasuredDimension(r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0586Mz.onMeasure(int, int):void");
    }
}
