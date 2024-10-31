package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: assets/audience_network.dex */
public final class ME extends LinearLayout {
    public static final int A05 = (int) (10.0f * KE.A01);
    public static final int A06 = (int) (44.0f * KE.A01);
    public int A00;
    public final C0590Nd A01;
    public final FrameLayout A02;
    public final ImageView A03;
    public final TextView A04;

    public ME(C0362Ec c0362Ec, int i) {
        super(c0362Ec);
        this.A03 = new ImageView(c0362Ec);
        this.A03.setPadding(A05, A05, A05, A05);
        this.A01 = new C0590Nd(c0362Ec);
        this.A01.setProgress(0.0f);
        this.A01.setPadding(A05, A05, A05, A05);
        this.A04 = new TextView(c0362Ec);
        setOrientation(0);
        this.A02 = new FrameLayout(c0362Ec);
        this.A00 = i;
        A00();
    }

    private void A00() {
        setToolbarActionMode(this.A00);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(A06, A06);
        KE.A0Y(this.A04, true, 16);
        this.A04.setTextColor(-1);
        this.A04.setVisibility(8);
        this.A02.addView(this.A03, layoutParams2);
        this.A02.addView(this.A01, layoutParams2);
        addView(this.A02, layoutParams);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        addView(this.A04, layoutParams3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A01() {
        /*
            r2 = this;
            r1 = 0
            android.widget.TextView r0 = r2.A04
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L1c
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L1e;
                case 4: goto L19;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            r1 = 1
            r0 = 3
            goto L12
        L19:
            r1 = 0
            r0 = 3
            goto L12
        L1c:
            r0 = 4
            goto L12
        L1e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ME.A01():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x001f, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A02() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            int r1 = r3.A00
            r0 = 2
            if (r1 == r0) goto L1d
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L17;
                case 4: goto L1f;
                case 5: goto L1a;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.ME r3 = (com.facebook.ads.redexgen.X.ME) r3
            int r1 = r3.A00
            r0 = 4
            if (r1 == r0) goto L15
            r0 = 3
            goto L8
        L15:
            r0 = 5
            goto L8
        L17:
            r2 = 1
            r0 = 4
            goto L8
        L1a:
            r2 = 0
            r0 = 4
            goto L8
        L1d:
            r0 = 5
            goto L8
        L1f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ME.A02():boolean");
    }

    public void setActionClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setColors(int i) {
        this.A01.A02(C4G.A01(i, 77), i);
        this.A03.setColorFilter(i);
    }

    public void setInitialUnskippableSeconds(int i) {
        if (i > 0) {
            setToolbarActionMode(2);
        }
    }

    public void setProgress(float f) {
        this.A01.setProgressWithAnimation(f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x006e, code lost:            r7 = r7;        r7.A03.setImageBitmap(com.facebook.ads.redexgen.X.KN.A00(r4));        com.facebook.ads.redexgen.X.KE.A0I(1002, r7.A03);     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0082, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setToolbarActionMode(int r10) {
        /*
            r9 = this;
            r7 = r9
            r0 = 0
            r0 = 0
            r8 = 0
            r1 = 0
            r2 = 0
            r1 = 0
            r1 = 0
            r1 = 0
            r6 = 2
            r1 = 0
            r5 = 8
            r7.A00 = r10
            com.facebook.ads.redexgen.X.KM r4 = com.facebook.ads.redexgen.X.KM.CROSS
            com.facebook.ads.redexgen.X.Nd r3 = r7.A01
            if (r10 != r6) goto L6b
            r1 = 2
        L16:
            switch(r1) {
                case 2: goto L1a;
                case 3: goto L3d;
                case 4: goto L3a;
                case 5: goto L1d;
                case 6: goto L6e;
                case 7: goto L4d;
                case 8: goto L51;
                case 9: goto L55;
                case 10: goto L5c;
                case 11: goto L68;
                case 12: goto L59;
                default: goto L19;
            }
        L19:
            goto L16
        L1a:
            r2 = 0
            r1 = 3
            goto L16
        L1d:
            com.facebook.ads.redexgen.X.ME r7 = (com.facebook.ads.redexgen.X.ME) r7
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r1 = 0
            r8.setVisibility(r0)
            r7.setVisibility(r1)
            switch(r10) {
                case 0: goto L36;
                case 1: goto L30;
                case 2: goto L38;
                case 3: goto L33;
                case 4: goto L2d;
                default: goto L2b;
            }
        L2b:
            r1 = 6
            goto L16
        L2d:
            r1 = 10
            goto L16
        L30:
            r1 = 9
            goto L16
        L33:
            r1 = 8
            goto L16
        L36:
            r1 = 7
            goto L16
        L38:
            r1 = 6
            goto L16
        L3a:
            r0 = r5
            r1 = 5
            goto L16
        L3d:
            com.facebook.ads.redexgen.X.ME r7 = (com.facebook.ads.redexgen.X.ME) r7
            com.facebook.ads.redexgen.X.Nd r3 = (com.facebook.ads.redexgen.X.C0590Nd) r3
            r3.setVisibility(r2)
            android.widget.ImageView r8 = r7.A03
            if (r10 != r6) goto L4a
            r1 = 4
            goto L16
        L4a:
            r1 = 11
            goto L16
        L4d:
            com.facebook.ads.redexgen.X.KM r4 = com.facebook.ads.redexgen.X.KM.CROSS
            r1 = 6
            goto L16
        L51:
            com.facebook.ads.redexgen.X.KM r4 = com.facebook.ads.redexgen.X.KM.MINIMIZE_ARROW
            r1 = 6
            goto L16
        L55:
            com.facebook.ads.redexgen.X.KM r4 = com.facebook.ads.redexgen.X.KM.SKIP_ARROW
            r1 = 6
            goto L16
        L59:
            r2 = r5
            r1 = 3
            goto L16
        L5c:
            com.facebook.ads.redexgen.X.ME r7 = (com.facebook.ads.redexgen.X.ME) r7
            android.widget.ImageView r1 = r7.A03
            r1.setVisibility(r5)
            r7.setVisibility(r5)
            r1 = 6
            goto L16
        L68:
            r0 = 0
            r1 = 5
            goto L16
        L6b:
            r1 = 12
            goto L16
        L6e:
            com.facebook.ads.redexgen.X.ME r7 = (com.facebook.ads.redexgen.X.ME) r7
            com.facebook.ads.redexgen.X.KM r4 = (com.facebook.ads.redexgen.X.KM) r4
            android.widget.ImageView r1 = r7.A03
            android.graphics.Bitmap r0 = com.facebook.ads.redexgen.X.KN.A00(r4)
            r1.setImageBitmap(r0)
            r1 = 1002(0x3ea, float:1.404E-42)
            android.widget.ImageView r0 = r7.A03
            com.facebook.ads.redexgen.X.KE.A0I(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ME.setToolbarActionMode(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:            r1.setVisibility(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setToolbarMessage(java.lang.String r4) {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            android.widget.TextView r0 = r3.A04
            r0.setText(r4)
            android.widget.TextView r1 = r3.A04
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L1b
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L1d;
                case 4: goto L18;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            r2 = 8
            r0 = 3
            goto L10
        L18:
            r2 = 0
            r0 = 3
            goto L10
        L1b:
            r0 = 4
            goto L10
        L1d:
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ME.setToolbarMessage(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0013, code lost:            r1.setVisibility(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0018, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setToolbarMessageEnabled(boolean r4) {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            android.widget.TextView r1 = r3.A04
            if (r4 == 0) goto L11
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L13;
                case 4: goto Le;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r2 = 0
            r0 = 3
            goto L7
        Le:
            r2 = 4
            r0 = 3
            goto L7
        L11:
            r0 = 4
            goto L7
        L13:
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ME.setToolbarMessageEnabled(boolean):void");
    }
}
