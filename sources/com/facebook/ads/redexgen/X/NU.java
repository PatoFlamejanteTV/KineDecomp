package com.facebook.ads.redexgen.X;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: assets/audience_network.dex */
public final class NU extends LinearLayout {
    public static final int A03 = (int) (KE.A01 * 16.0f);
    public static final int A04 = (int) (KE.A01 * 8.0f);
    public final ImageView A00;
    public final TextView A01;
    public final K2 A02;

    public NU(C0362Ec c0362Ec) {
        super(c0362Ec);
        setOrientation(0);
        this.A00 = new ImageView(c0362Ec);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A03, A03);
        layoutParams.rightMargin = A04;
        layoutParams.gravity = 16;
        this.A01 = new TextView(c0362Ec);
        KE.A0Y(this.A01, false, 14);
        addView(this.A00, layoutParams);
        addView(this.A01, new LinearLayout.LayoutParams(-1, -2));
        this.A02 = new K2(-13158601);
        this.A02.A01(A04, A04, A04, A04);
        KE.A0T(this, this.A02);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.A02.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
    }

    public void setHighlightColor(int i) {
        this.A00.setColorFilter(i);
        this.A01.setTextColor(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setIcon(@android.support.annotation.Nullable com.facebook.ads.redexgen.X.KM r4) {
        /*
            r3 = this;
            r2 = r3
            if (r4 != 0) goto L20
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L22;
                case 4: goto L11;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.NU r2 = (com.facebook.ads.redexgen.X.NU) r2
            android.widget.ImageView r0 = r2.A00
            com.facebook.ads.redexgen.X.KE.A0J(r0)
            r0 = 3
            goto L4
        L11:
            com.facebook.ads.redexgen.X.NU r2 = (com.facebook.ads.redexgen.X.NU) r2
            com.facebook.ads.redexgen.X.KM r4 = (com.facebook.ads.redexgen.X.KM) r4
            android.widget.ImageView r1 = r2.A00
            android.graphics.Bitmap r0 = com.facebook.ads.redexgen.X.KN.A00(r4)
            r1.setImageBitmap(r0)
            r0 = 3
            goto L4
        L20:
            r0 = 4
            goto L4
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NU.setIcon(com.facebook.ads.redexgen.X.KM):void");
    }

    public void setText(String str) {
        this.A01.setText(str);
    }
}
