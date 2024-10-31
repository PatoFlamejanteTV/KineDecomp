package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: com.facebook.ads.redexgen.X.No, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0601No extends LinearLayout {
    public boolean A00;
    public final TextView A01;
    public final TextView A02;
    public final TextView A03;
    public static final float A04 = Resources.getSystem().getDisplayMetrics().density;
    public static final int A06 = (int) (6.0f * A04);
    public static final int A05 = (int) (8.0f * A04);

    public C0601No(C0362Ec c0362Ec, C2T c2t, boolean z, int i, int i2, int i3) {
        super(c0362Ec);
        this.A00 = false;
        setOrientation(1);
        this.A03 = new TextView(c0362Ec);
        KE.A0Y(this.A03, true, i);
        this.A03.setTextColor(c2t.A06(z));
        this.A03.setEllipsize(TextUtils.TruncateAt.END);
        this.A03.setLineSpacing(A06, 1.0f);
        this.A02 = new TextView(c0362Ec);
        this.A02.setTextColor(c2t.A04(z));
        this.A01 = new TextView(c0362Ec);
        KE.A0Y(this.A01, false, i2);
        this.A01.setTextColor(c2t.A05(z));
        this.A01.setEllipsize(TextUtils.TruncateAt.END);
        this.A01.setLineSpacing(A06, 1.0f);
        addView(this.A03, new LinearLayout.LayoutParams(-1, -2));
        addView(this.A02, new LinearLayout.LayoutParams(-1, -2));
        this.A02.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, i3, 0, 0);
        addView(this.A01, layoutParams);
    }

    public C0601No(C0362Ec c0362Ec, C2T c2t, boolean z, boolean z2, boolean z3) {
        this(c0362Ec, c2t, z, z2 ? 18 : 22, z2 ? 14 : 16, z3 ? A05 / 2 : A05);
    }

    /* JADX WARN: Code restructure failed: missing block: B:152:0x010f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A00(java.lang.String r18, java.lang.String r19, @android.support.annotation.Nullable java.lang.String r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0601No.A00(java.lang.String, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    public TextView getDescriptionTextView() {
        return this.A01;
    }

    public TextView getTitleTextView() {
        return this.A03;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x005c, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onConfigurationChanged(android.content.res.Configuration r9) {
        /*
            r8 = this;
            r7 = r8
            r6 = 0
            r5 = 0
            r4 = 0
            r3 = 0
            r2 = 0
            super.onConfigurationChanged(r9)
            boolean r0 = r7.A00
            if (r0 == 0) goto L59
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L37;
                case 3: goto L31;
                case 4: goto L22;
                case 5: goto L2d;
                case 6: goto L12;
                case 7: goto L43;
                case 8: goto L48;
                case 9: goto L5c;
                case 10: goto L50;
                case 11: goto L55;
                case 12: goto L34;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.No r7 = (com.facebook.ads.redexgen.X.C0601No) r7
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextSize(r5)
            android.widget.TextView r4 = r7.A01
            if (r3 == 0) goto L1f
            r0 = 7
            goto Le
        L1f:
            r0 = 10
            goto Le
        L22:
            com.facebook.ads.redexgen.X.No r7 = (com.facebook.ads.redexgen.X.C0601No) r7
            android.widget.TextView r2 = r7.A03
            if (r3 == 0) goto L2a
            r0 = 5
            goto Le
        L2a:
            r0 = 11
            goto Le
        L2d:
            r5 = 1099956224(0x41900000, float:18.0)
            r0 = 6
            goto Le
        L31:
            r3 = 1
            r0 = 4
            goto Le
        L34:
            r3 = 0
            r0 = 4
            goto Le
        L37:
            android.content.res.Configuration r9 = (android.content.res.Configuration) r9
            int r1 = r9.orientation
            r0 = 2
            if (r1 != r0) goto L40
            r0 = 3
            goto Le
        L40:
            r0 = 12
            goto Le
        L43:
            r6 = 1096810496(0x41600000, float:14.0)
            r0 = 8
            goto Le
        L48:
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setTextSize(r6)
            r0 = 9
            goto Le
        L50:
            r6 = 1098907648(0x41800000, float:16.0)
            r0 = 8
            goto Le
        L55:
            r5 = 1102053376(0x41b00000, float:22.0)
            r0 = 6
            goto Le
        L59:
            r0 = 9
            goto Le
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0601No.onConfigurationChanged(android.content.res.Configuration):void");
    }

    public void setAlignment(int i) {
        this.A03.setGravity(i);
        this.A01.setGravity(i);
    }

    public void setUseNewLandscapeEndCard(boolean z) {
        this.A00 = z;
    }
}
