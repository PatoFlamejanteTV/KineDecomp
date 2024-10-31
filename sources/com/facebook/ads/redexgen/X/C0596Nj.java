package com.facebook.ads.redexgen.X;

import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.Nj, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0596Nj extends RelativeLayout {
    public static final int A04 = (int) (4.0f * KE.A01);
    public static final float[] A05 = {A04, A04, A04, A04, A04, A04, A04, A04};
    public boolean A00;
    public float[] A01;
    public final Path A02;
    public final RectF A03;

    public C0596Nj(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A01 = A05;
        this.A00 = false;
        this.A02 = new Path();
        this.A03 = new RectF();
        KE.A0P(this, 0);
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    private float[] getRadiiForCircularImage() {
        int min = Math.min(getWidth(), getHeight()) / 2;
        return new float[]{min, min, min, min, min, min, min, min};
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:            r5 = r5;        r7 = r7;        r5.A02.addRoundRect(r5.A03, r4, android.graphics.Path.Direction.CW);        r7.clipPath(r5.A02);        super.onDraw(r7);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDraw(android.graphics.Canvas r7) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r3 = 0
            android.graphics.RectF r2 = r5.A03
            int r0 = r5.getWidth()
            float r1 = (float) r0
            int r0 = r5.getHeight()
            float r0 = (float) r0
            r2.set(r3, r3, r1, r0)
            android.graphics.Path r0 = r5.A02
            r0.reset()
            boolean r0 = r5.A00
            if (r0 == 0) goto L2e
            r0 = 2
        L1c:
            switch(r0) {
                case 2: goto L20;
                case 3: goto L30;
                case 4: goto L28;
                default: goto L1f;
            }
        L1f:
            goto L1c
        L20:
            com.facebook.ads.redexgen.X.Nj r5 = (com.facebook.ads.redexgen.X.C0596Nj) r5
            float[] r4 = r5.getRadiiForCircularImage()
            r0 = 3
            goto L1c
        L28:
            com.facebook.ads.redexgen.X.Nj r5 = (com.facebook.ads.redexgen.X.C0596Nj) r5
            float[] r4 = r5.A01
            r0 = 3
            goto L1c
        L2e:
            r0 = 4
            goto L1c
        L30:
            com.facebook.ads.redexgen.X.Nj r5 = (com.facebook.ads.redexgen.X.C0596Nj) r5
            android.graphics.Canvas r7 = (android.graphics.Canvas) r7
            float[] r4 = (float[]) r4
            android.graphics.Path r2 = r5.A02
            android.graphics.RectF r1 = r5.A03
            android.graphics.Path$Direction r0 = android.graphics.Path.Direction.CW
            r2.addRoundRect(r1, r4, r0)
            android.graphics.Path r0 = r5.A02
            r7.clipPath(r0)
            super.onDraw(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0596Nj.onDraw(android.graphics.Canvas):void");
    }

    public void setFullCircleCorners(boolean z) {
        this.A00 = z;
    }

    public void setRadius(int i) {
        int i2 = (int) (i * KE.A01);
        this.A01 = new float[]{i2, i2, i2, i2, i2, i2, i2, i2};
    }

    public void setRadius(float[] fArr) {
        this.A01 = fArr;
    }
}
