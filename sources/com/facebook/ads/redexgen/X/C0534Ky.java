package com.facebook.ads.redexgen.X;

import android.graphics.Paint;
import android.view.View;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.Ky, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0534Ky extends View {
    public int A00;
    public Paint A01;
    public Paint A02;
    public Paint A03;
    public boolean A04;

    public C0534Ky(C0362Ec c0362Ec) {
        this(c0362Ec, 60, true);
    }

    public C0534Ky(C0362Ec c0362Ec, int i, boolean z) {
        super(c0362Ec);
        this.A00 = i;
        this.A04 = z;
        if (z) {
            this.A02 = new Paint();
            this.A02.setColor(-3355444);
            this.A02.setStyle(Paint.Style.STROKE);
            this.A02.setStrokeWidth(3.0f);
            this.A02.setAntiAlias(true);
            this.A01 = new Paint();
            this.A01.setColor(-1287371708);
            this.A01.setStyle(Paint.Style.FILL);
            this.A01.setAntiAlias(true);
            this.A03 = new Paint();
            this.A03.setColor(-1);
            this.A03.setStyle(Paint.Style.STROKE);
            this.A03.setStrokeWidth(6.0f);
            this.A03.setAntiAlias(true);
        }
    }

    public RelativeLayout.LayoutParams getDefaultLayoutParams() {
        float f = KE.A01;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (this.A00 * f), (int) (this.A00 * f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        return layoutParams;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:            super.onDraw(r9);     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDraw(android.graphics.Canvas r16) {
        /*
            r15 = this;
            r9 = r16
            r1 = r15
            boolean r0 = r1.A04
            if (r0 == 0) goto L75
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L18;
                case 4: goto L22;
                case 5: goto L2b;
                case 6: goto L77;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            android.graphics.Canvas r9 = (android.graphics.Canvas) r9
            boolean r0 = r9.isHardwareAccelerated()
            if (r0 == 0) goto L16
            r0 = 3
            goto L8
        L16:
            r0 = 5
            goto L8
        L18:
            int r2 = android.os.Build.VERSION.SDK_INT
            r0 = 17
            if (r2 >= r0) goto L20
            r0 = 4
            goto L8
        L20:
            r0 = 5
            goto L8
        L22:
            com.facebook.ads.redexgen.X.Ky r1 = (com.facebook.ads.redexgen.X.C0534Ky) r1
            r2 = 1
            r0 = 0
            r1.setLayerType(r2, r0)
            r0 = 5
            goto L8
        L2b:
            com.facebook.ads.redexgen.X.Ky r1 = (com.facebook.ads.redexgen.X.C0534Ky) r1
            android.graphics.Canvas r9 = (android.graphics.Canvas) r9
            int r2 = r9.getWidth()
            int r0 = r9.getHeight()
            int r8 = java.lang.Math.min(r2, r0)
            int r7 = r8 / 2
            int r6 = r8 / 2
            int r0 = r7 * 2
            int r5 = r0 / 3
            float r4 = (float) r7
            float r3 = (float) r6
            float r2 = (float) r5
            android.graphics.Paint r0 = r1.A02
            r9.drawCircle(r4, r3, r2, r0)
            int r0 = r5 + (-2)
            float r4 = (float) r7
            float r3 = (float) r6
            float r2 = (float) r0
            android.graphics.Paint r0 = r1.A01
            r9.drawCircle(r4, r3, r2, r0)
            int r3 = r8 / 3
            int r2 = r8 / 3
            float r10 = (float) r3
            float r11 = (float) r2
            int r0 = r3 * 2
            float r12 = (float) r0
            int r0 = r2 * 2
            float r13 = (float) r0
            android.graphics.Paint r14 = r1.A03
            r9.drawLine(r10, r11, r12, r13, r14)
            int r0 = r3 * 2
            float r10 = (float) r0
            float r11 = (float) r2
            float r12 = (float) r3
            int r0 = r2 * 2
            float r13 = (float) r0
            android.graphics.Paint r14 = r1.A03
            r9.drawLine(r10, r11, r12, r13, r14)
            r0 = 6
            goto L8
        L75:
            r0 = 6
            goto L8
        L77:
            com.facebook.ads.redexgen.X.Ky r1 = (com.facebook.ads.redexgen.X.C0534Ky) r1
            android.graphics.Canvas r9 = (android.graphics.Canvas) r9
            super.onDraw(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0534Ky.onDraw(android.graphics.Canvas):void");
    }
}
