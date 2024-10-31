package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.widget.ImageView;

/* loaded from: assets/audience_network.dex */
public final class M5 extends M4 {

    @Nullable
    public ImageView.ScaleType A00;

    public M5(C0362Ec c0362Ec) {
        super(c0362Ec);
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x008e, code lost:            return;     */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            r0 = 0
            r3 = 1073741824(0x40000000, float:2.0)
            int r2 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getSize(r6)
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            if (r0 != r3) goto L8c
            r0 = 2
        L15:
            switch(r0) {
                case 2: goto L3e;
                case 3: goto L2c;
                case 4: goto L22;
                case 5: goto L19;
                case 6: goto L8e;
                case 7: goto L48;
                case 8: goto L63;
                case 9: goto L6b;
                case 10: goto L37;
                case 11: goto L72;
                case 12: goto L54;
                case 13: goto L5c;
                case 14: goto L7e;
                case 15: goto L85;
                default: goto L18;
            }
        L18:
            goto L15
        L19:
            com.facebook.ads.redexgen.X.M5 r4 = (com.facebook.ads.redexgen.X.M5) r4
            android.widget.ImageView$ScaleType r0 = r4.A00
            super.setScaleType(r0)
            r0 = 6
            goto L15
        L22:
            com.facebook.ads.redexgen.X.M5 r4 = (com.facebook.ads.redexgen.X.M5) r4
            android.widget.ImageView$ScaleType r0 = r4.A00
            if (r0 == 0) goto L2a
            r0 = 5
            goto L15
        L2a:
            r0 = 6
            goto L15
        L2c:
            com.facebook.ads.redexgen.X.M5 r4 = (com.facebook.ads.redexgen.X.M5) r4
            int r0 = java.lang.Math.min(r1, r2)
            r4.setMeasuredDimension(r0, r0)
            r0 = 4
            goto L15
        L37:
            com.facebook.ads.redexgen.X.M5 r4 = (com.facebook.ads.redexgen.X.M5) r4
            r4.setMeasuredDimension(r1, r1)
            r0 = 4
            goto L15
        L3e:
            int r0 = android.view.View.MeasureSpec.getMode(r7)
            if (r0 != r3) goto L46
            r0 = 3
            goto L15
        L46:
            r0 = 7
            goto L15
        L48:
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            if (r0 != r3) goto L51
            r0 = 8
            goto L15
        L51:
            r0 = 11
            goto L15
        L54:
            if (r1 <= 0) goto L59
            r0 = 13
            goto L15
        L59:
            r0 = 14
            goto L15
        L5c:
            int r2 = java.lang.Math.min(r1, r2)
            r0 = 14
            goto L15
        L63:
            if (r2 <= 0) goto L68
            r0 = 9
            goto L15
        L68:
            r0 = 10
            goto L15
        L6b:
            int r1 = java.lang.Math.min(r1, r2)
            r0 = 10
            goto L15
        L72:
            int r0 = android.view.View.MeasureSpec.getMode(r7)
            if (r0 != r3) goto L7b
            r0 = 12
            goto L15
        L7b:
            r0 = 15
            goto L15
        L7e:
            com.facebook.ads.redexgen.X.M5 r4 = (com.facebook.ads.redexgen.X.M5) r4
            r4.setMeasuredDimension(r2, r2)
            r0 = 4
            goto L15
        L85:
            com.facebook.ads.redexgen.X.M5 r4 = (com.facebook.ads.redexgen.X.M5) r4
            super.onMeasure(r6, r7)
            r0 = 4
            goto L15
        L8c:
            r0 = 7
            goto L15
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M5.onMeasure(int, int):void");
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        this.A00 = scaleType;
    }
}
