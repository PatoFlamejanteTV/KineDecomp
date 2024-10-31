package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: com.facebook.ads.redexgen.X.Mc, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0564Mc extends LinearLayout {
    public boolean A00;
    public final ImageView A01;
    public final TextView A02;
    public static final int A04 = (int) (KE.A01 * 16.0f);
    public static final int A05 = (int) (KE.A01 * 12.0f);
    public static final int A06 = (int) (KE.A01 * 12.0f);
    public static final int A03 = (int) (KE.A01 * 16.0f);

    public C0564Mc(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A00 = false;
        setOrientation(0);
        setPadding(A04, A05, A04, A05);
        this.A01 = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A03, A03);
        layoutParams.gravity = 17;
        this.A02 = new TextView(getContext());
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        addView(this.A01, layoutParams);
        addView(this.A02, layoutParams2);
        A00();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:            r6 = r6;        r6.A02.setTextColor(r4);        r6.A01.setColorFilter(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0055, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A00() {
        /*
            r7 = this;
            r6 = r7
            r5 = 0
            r4 = 0
            r0 = 0
            r0 = 0
            r3 = 0
            android.graphics.drawable.GradientDrawable r2 = new android.graphics.drawable.GradientDrawable
            r2.<init>()
            r2.setShape(r3)
            boolean r0 = r6.A00
            if (r0 == 0) goto L47
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L3d;
                case 3: goto L1f;
                case 4: goto L1c;
                case 5: goto L49;
                case 6: goto L17;
                case 7: goto L42;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            r4 = -10459280(0xffffffffff606770, float:-2.9828415E38)
            r0 = 5
            goto L13
        L1c:
            r4 = -1
            r0 = 5
            goto L13
        L1f:
            com.facebook.ads.redexgen.X.Mc r6 = (com.facebook.ads.redexgen.X.C0564Mc) r6
            android.graphics.drawable.GradientDrawable r2 = (android.graphics.drawable.GradientDrawable) r2
            r2.setColor(r5)
            r0 = 1112014848(0x42480000, float:50.0)
            r2.setCornerRadius(r0)
            com.facebook.ads.redexgen.X.KE.A0T(r6, r2)
            android.widget.TextView r1 = r6.A02
            r0 = 14
            com.facebook.ads.redexgen.X.KE.A0Y(r1, r3, r0)
            boolean r0 = r6.A00
            if (r0 == 0) goto L3b
            r0 = 4
            goto L13
        L3b:
            r0 = 6
            goto L13
        L3d:
            r5 = -13272859(0xffffffffff3578e5, float:-2.4121799E38)
            r0 = 3
            goto L13
        L42:
            r5 = -1315344(0xffffffffffebedf0, float:NaN)
            r0 = 3
            goto L13
        L47:
            r0 = 7
            goto L13
        L49:
            com.facebook.ads.redexgen.X.Mc r6 = (com.facebook.ads.redexgen.X.C0564Mc) r6
            android.widget.TextView r0 = r6.A02
            r0.setTextColor(r4)
            android.widget.ImageView r0 = r6.A01
            r0.setColorFilter(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0564Mc.A00():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0012, code lost:            setSelected(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0018, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A01() {
        /*
            r2 = this;
            r1 = 0
            boolean r0 = r2.A00
            if (r0 != 0) goto L10
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L12;
                case 4: goto Ld;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            r1 = 1
            r0 = 3
            goto L6
        Ld:
            r1 = 0
            r0 = 3
            goto L6
        L10:
            r0 = 4
            goto L6
        L12:
            r0 = r2
            com.facebook.ads.redexgen.X.Mc r0 = (com.facebook.ads.redexgen.X.C0564Mc) r0
            r0.setSelected(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0564Mc.A01():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:            r3.A00();     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setData(java.lang.String r5, @android.support.annotation.Nullable com.facebook.ads.redexgen.X.KM r6) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            android.widget.TextView r0 = r3.A02
            r0.setText(r5)
            if (r6 == 0) goto L3c
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L3e;
                case 4: goto L2b;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.Mc r3 = (com.facebook.ads.redexgen.X.C0564Mc) r3
            com.facebook.ads.redexgen.X.KM r6 = (com.facebook.ads.redexgen.X.KM) r6
            r2 = 0
            android.widget.ImageView r1 = r3.A01
            android.graphics.Bitmap r0 = com.facebook.ads.redexgen.X.KN.A00(r6)
            r1.setImageBitmap(r0)
            android.widget.ImageView r0 = r3.A01
            r0.setVisibility(r2)
            android.widget.TextView r1 = r3.A02
            int r0 = com.facebook.ads.redexgen.X.C0564Mc.A06
            r1.setPadding(r0, r2, r2, r2)
            r0 = 3
            goto Lb
        L2b:
            com.facebook.ads.redexgen.X.Mc r3 = (com.facebook.ads.redexgen.X.C0564Mc) r3
            r2 = 0
            android.widget.ImageView r1 = r3.A01
            r0 = 8
            r1.setVisibility(r0)
            android.widget.TextView r0 = r3.A02
            r0.setPadding(r2, r2, r2, r2)
            r0 = 3
            goto Lb
        L3c:
            r0 = 4
            goto Lb
        L3e:
            com.facebook.ads.redexgen.X.Mc r3 = (com.facebook.ads.redexgen.X.C0564Mc) r3
            r3.A00()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0564Mc.setData(java.lang.String, com.facebook.ads.redexgen.X.KM):void");
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.A00 = z;
        A00();
    }
}
