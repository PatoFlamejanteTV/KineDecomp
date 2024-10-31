package com.facebook.ads.redexgen.X;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: com.facebook.ads.redexgen.X.Mp, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0576Mp extends LinearLayout {
    public final ImageView A00;
    public final LinearLayout A01;
    public final TextView A02;
    public static final int A05 = (int) (8.0f * KE.A01);
    public static final int A06 = (int) (14.5d * KE.A01);
    public static final int A04 = (int) (20.0f * KE.A01);
    public static final LinearLayout.LayoutParams A03 = new LinearLayout.LayoutParams(-1, -2);

    public C0576Mp(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A00 = new ImageView(c0362Ec);
        this.A00.setColorFilter(-10459280);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A04, A04);
        layoutParams.gravity = 16;
        this.A00.setLayoutParams(layoutParams);
        this.A01 = new LinearLayout(c0362Ec);
        this.A01.setOrientation(1);
        this.A01.setPadding(A05 * 2, 0, 0, 0);
        this.A01.setLayoutParams(A03);
        this.A02 = new TextView(c0362Ec);
        KE.A0Y(this.A02, true, 16);
        this.A02.setTextColor(-14934495);
        this.A01.addView(this.A02, A03);
        setOrientation(0);
        addView(this.A00);
        addView(this.A01);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setInfo(com.facebook.ads.redexgen.X.KM r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            android.widget.ImageView r1 = r4.A00
            android.graphics.Bitmap r0 = com.facebook.ads.redexgen.X.KN.A00(r6)
            r1.setImageBitmap(r0)
            android.widget.TextView r0 = r4.A02
            r0.setText(r7)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L54
            r0 = 2
        L18:
            switch(r0) {
                case 2: goto L1c;
                case 3: goto L56;
                case 4: goto L48;
                default: goto L1b;
            }
        L1b:
            goto L18
        L1c:
            com.facebook.ads.redexgen.X.Mp r4 = (com.facebook.ads.redexgen.X.C0576Mp) r4
            java.lang.String r8 = (java.lang.String) r8
            r3 = 0
            android.widget.TextView r2 = new android.widget.TextView
            android.content.Context r0 = r4.getContext()
            r2.<init>(r0)
            r0 = 14
            com.facebook.ads.redexgen.X.KE.A0Y(r2, r3, r0)
            r0 = -10459280(0xffffffffff606770, float:-2.9828415E38)
            r2.setTextColor(r0)
            r2.setText(r8)
            android.widget.LinearLayout r1 = r4.A01
            android.widget.LinearLayout$LayoutParams r0 = com.facebook.ads.redexgen.X.C0576Mp.A03
            r1.addView(r2, r0)
            int r1 = com.facebook.ads.redexgen.X.C0576Mp.A05
            int r0 = com.facebook.ads.redexgen.X.C0576Mp.A05
            r4.setPadding(r3, r1, r3, r0)
            r0 = 3
            goto L18
        L48:
            com.facebook.ads.redexgen.X.Mp r4 = (com.facebook.ads.redexgen.X.C0576Mp) r4
            r2 = 0
            int r1 = com.facebook.ads.redexgen.X.C0576Mp.A06
            int r0 = com.facebook.ads.redexgen.X.C0576Mp.A06
            r4.setPadding(r2, r1, r2, r0)
            r0 = 3
            goto L18
        L54:
            r0 = 4
            goto L18
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0576Mp.setInfo(com.facebook.ads.redexgen.X.KM, java.lang.String, java.lang.String):void");
    }
}
