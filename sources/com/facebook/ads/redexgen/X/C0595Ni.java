package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Ni, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0595Ni extends LinearLayout {
    public int A00;
    public List<GradientDrawable> A01;
    public final int A02;
    public final int A03;
    public final int A04;

    public C0595Ni(C0362Ec c0362Ec, C2T c2t, int dotSize) {
        super(c0362Ec);
        this.A00 = -1;
        setOrientation(0);
        setGravity(17);
        float f = KE.A01;
        int i = (int) (8.0f * f);
        int i2 = (int) (6.0f * f);
        this.A02 = (int) (1.0f * f);
        this.A04 = c2t.A04(false);
        this.A03 = C4G.A01(this.A04, 128);
        this.A01 = new ArrayList();
        for (int i3 = 0; i3 < dotSize; i3++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setSize(i, i);
            gradientDrawable.setStroke(this.A02, 0);
            ImageView imageView = new ImageView(c0362Ec);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, i2, 0);
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(gradientDrawable);
            this.A01.add(gradientDrawable);
            addView(imageView);
        }
        A00(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0063, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A00(int r7) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r3 = 0
            r2 = 0
            int r0 = r5.A00
            if (r0 != r7) goto L61
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L63;
                case 3: goto L2a;
                case 4: goto L1c;
                case 5: goto L15;
                case 6: goto Ld;
                case 7: goto L31;
                case 8: goto L5a;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.Ni r5 = (com.facebook.ads.redexgen.X.C0595Ni) r5
            int r4 = r5.A04
            int r2 = r5.A04
            r0 = 7
            goto L9
        L15:
            if (r3 != r7) goto L19
            r0 = 6
            goto L9
        L19:
            r0 = 8
            goto L9
        L1c:
            com.facebook.ads.redexgen.X.Ni r5 = (com.facebook.ads.redexgen.X.C0595Ni) r5
            java.util.List<android.graphics.drawable.GradientDrawable> r0 = r5.A01
            int r0 = r0.size()
            if (r3 >= r0) goto L28
            r0 = 5
            goto L9
        L28:
            r0 = 2
            goto L9
        L2a:
            com.facebook.ads.redexgen.X.Ni r5 = (com.facebook.ads.redexgen.X.C0595Ni) r5
            r5.A00 = r7
            r3 = 0
            r0 = 4
            goto L9
        L31:
            com.facebook.ads.redexgen.X.Ni r5 = (com.facebook.ads.redexgen.X.C0595Ni) r5
            java.util.List<android.graphics.drawable.GradientDrawable> r0 = r5.A01
            java.lang.Object r1 = r0.get(r3)
            android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1
            int r0 = r5.A02
            r1.setStroke(r0, r2)
            java.util.List<android.graphics.drawable.GradientDrawable> r0 = r5.A01
            java.lang.Object r0 = r0.get(r3)
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            r0.setColor(r4)
            java.util.List<android.graphics.drawable.GradientDrawable> r0 = r5.A01
            java.lang.Object r0 = r0.get(r3)
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            r0.invalidateSelf()
            int r3 = r3 + 1
            r0 = 4
            goto L9
        L5a:
            com.facebook.ads.redexgen.X.Ni r5 = (com.facebook.ads.redexgen.X.C0595Ni) r5
            int r4 = r5.A03
            r2 = 0
            r0 = 7
            goto L9
        L61:
            r0 = 3
            goto L9
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0595Ni.A00(int):void");
    }
}
