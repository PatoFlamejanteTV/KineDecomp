package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* loaded from: assets/audience_network.dex */
public final class NO extends FrameLayout {
    public int A00;
    public int A01;
    public final ImageView A02;
    public final ImageView A03;

    public NO(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A03 = new ImageView(c0362Ec);
        this.A02 = new ImageView(c0362Ec);
        A00();
    }

    public NO(C0362Ec c0362Ec, AttributeSet attributeSet) {
        super(c0362Ec, attributeSet);
        this.A03 = new ImageView(c0362Ec, attributeSet);
        this.A02 = new ImageView(c0362Ec, attributeSet);
        A00();
    }

    public NO(C0362Ec c0362Ec, AttributeSet attributeSet, int i) {
        super(c0362Ec, attributeSet, i);
        this.A03 = new ImageView(c0362Ec, attributeSet, i);
        this.A02 = new ImageView(c0362Ec, attributeSet, i);
        A00();
    }

    @TargetApi(21)
    public NO(C0362Ec c0362Ec, AttributeSet attributeSet, int i, int i2) {
        super(c0362Ec, attributeSet, i, i2);
        this.A03 = new ImageView(c0362Ec, attributeSet, i, i2);
        this.A02 = new ImageView(c0362Ec, attributeSet, i, i2);
        A00();
    }

    private void A00() {
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
        addView(this.A03, new FrameLayout.LayoutParams(-2, -2));
        EnumC0489Je.A04(this.A03, EnumC0489Je.A0A);
        setId(KE.A00());
    }

    public ImageView getBodyImageView() {
        return this.A03;
    }

    public int getImageHeight() {
        return this.A00;
    }

    public int getImageWidth() {
        return this.A01;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006c, code lost:            return;     */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onLayout(boolean r15, int r16, int r17, int r18, int r19) {
        /*
            r14 = this;
            r8 = r14
            int r0 = r8.A01
            if (r0 <= 0) goto L6a
            r0 = 2
        L6:
            r10 = r16
            r11 = r17
            r13 = r19
            r12 = r18
            switch(r0) {
                case 2: goto L12;
                case 3: goto L1c;
                case 4: goto L6c;
                case 5: goto L24;
                default: goto L11;
            }
        L11:
            goto L6
        L12:
            com.facebook.ads.redexgen.X.NO r8 = (com.facebook.ads.redexgen.X.NO) r8
            int r0 = r8.A00
            if (r0 > 0) goto L1a
            r0 = 3
            goto L6
        L1a:
            r0 = 5
            goto L6
        L1c:
            com.facebook.ads.redexgen.X.NO r8 = (com.facebook.ads.redexgen.X.NO) r8
            r9 = r15
            super.onLayout(r9, r10, r11, r12, r13)
            r0 = 4
            goto L6
        L24:
            com.facebook.ads.redexgen.X.NO r8 = (com.facebook.ads.redexgen.X.NO) r8
            int r4 = r12 - r10
            int r3 = r13 - r11
            float r2 = (float) r4
            int r0 = r8.A01
            float r0 = (float) r0
            float r2 = r2 / r0
            float r1 = (float) r3
            int r0 = r8.A00
            float r0 = (float) r0
            float r1 = r1 / r0
            float r2 = java.lang.Math.min(r2, r1)
            int r0 = r8.A01
            float r0 = (float) r0
            float r0 = r0 * r2
            int r1 = (int) r0
            int r0 = r8.A00
            float r0 = (float) r0
            float r0 = r0 * r2
            int r7 = (int) r0
            android.widget.ImageView r0 = r8.A02
            r0.layout(r10, r11, r12, r13)
            int r0 = r4 / 2
            int r6 = r10 + r0
            int r0 = r3 / 2
            int r5 = r11 + r0
            android.widget.ImageView r4 = r8.A03
            int r0 = r1 / 2
            int r3 = r6 - r0
            int r0 = r7 / 2
            int r2 = r5 - r0
            int r1 = r1 / 2
            int r1 = r1 + r6
            int r0 = r7 / 2
            int r0 = r0 + r5
            r4.layout(r3, r2, r1, r0)
            android.widget.ImageView r1 = r8.A02
            r0 = 0
            r1.setVisibility(r0)
            r0 = 4
            goto L6
        L6a:
            r0 = 3
            goto L6
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NO.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setImage(@android.support.annotation.Nullable android.graphics.Bitmap r5, @android.support.annotation.Nullable android.graphics.Bitmap r6) {
        /*
            r4 = this;
            r3 = r4
            if (r6 == 0) goto L57
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L2d;
                case 3: goto L45;
                case 4: goto L12;
                case 5: goto L59;
                case 6: goto L4d;
                case 7: goto L8;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.NO r3 = (com.facebook.ads.redexgen.X.NO) r3
            android.widget.ImageView r1 = r3.A02
            r0 = 0
            com.facebook.ads.redexgen.X.KE.A0P(r1, r0)
            r0 = 3
            goto L4
        L12:
            com.facebook.ads.redexgen.X.NO r3 = (com.facebook.ads.redexgen.X.NO) r3
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            int r0 = r5.getWidth()
            r3.A01 = r0
            int r0 = r5.getHeight()
            r3.A00 = r0
            android.widget.ImageView r1 = r3.A03
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r5)
            r1.setImageBitmap(r0)
            r0 = 5
            goto L4
        L2d:
            com.facebook.ads.redexgen.X.NO r3 = (com.facebook.ads.redexgen.X.NO) r3
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            android.widget.ImageView r2 = r3.A02
            android.graphics.drawable.BitmapDrawable r1 = new android.graphics.drawable.BitmapDrawable
            android.content.Context r0 = r3.getContext()
            android.content.res.Resources r0 = r0.getResources()
            r1.<init>(r0, r6)
            com.facebook.ads.redexgen.X.KE.A0T(r2, r1)
            r0 = 3
            goto L4
        L45:
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            if (r5 == 0) goto L4b
            r0 = 4
            goto L4
        L4b:
            r0 = 6
            goto L4
        L4d:
            com.facebook.ads.redexgen.X.NO r3 = (com.facebook.ads.redexgen.X.NO) r3
            android.widget.ImageView r1 = r3.A03
            r0 = 0
            r1.setImageDrawable(r0)
            r0 = 5
            goto L4
        L57:
            r0 = 7
            goto L4
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NO.setImage(android.graphics.Bitmap, android.graphics.Bitmap):void");
    }
}
