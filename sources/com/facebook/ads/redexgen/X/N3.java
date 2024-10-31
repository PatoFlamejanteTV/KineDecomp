package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

@TargetApi(19)
/* loaded from: assets/audience_network.dex */
public final class N3 extends LinearLayout {
    public static byte[] A05;
    public static final int A06;
    public static final int A07;
    public static final Uri A08;
    public static final View.OnTouchListener A09;
    public ImageView A00;
    public ImageView A01;
    public InterfaceC0526Kq A02;
    public N9 A03;
    public String A04;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.N3.A05
            int r0 = r2 + r3
            byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            if (r1 >= r0) goto L17
            r0 = 3
            goto Lc
        L17:
            r0 = 4
            goto Lc
        L19:
            byte[] r2 = (byte[]) r2
            r0 = r2[r1]
            r0 = r0 ^ r4
            r0 = r0 ^ 123(0x7b, float:1.72E-43)
            byte r0 = (byte) r0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L27:
            byte[] r2 = (byte[]) r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.N3.A02(int, int, int):java.lang.String");
    }

    public static void A04() {
        A05 = new byte[]{9, 5, 7, 68, 11, 4, 14, 24, 5, 3, 14, 68, 9, 2, 24, 5, 7, 15, 112, 79, 90, 81, 31, 81, 94, 75, 86, 73, 90, 31, 93, 77, 80, 72, 76, 90, 77, 97, 110, 100, 114, 111, 105, 100, 46, 105, 110, 116, 101, 110, 116, 46, 97, 99, 116, 105, 111, 110, 46, 86, 73, 69, 87, 115, 112, 125, 103, 102, 40, 112, 126, 115, 124, 121, 5, 42, 41, 53, 35, 52, 40, 40, 44, 102, 115, 115, 43, 43, 43, 114, 58, 61, 63, 57, 62, 51, 51, 55, 114, 63, 51, 49};
    }

    static {
        A04();
        A06 = Color.rgb(224, 224, 224);
        A08 = Uri.parse(A02(79, 23, 39));
        A09 = new N0();
        A07 = Color.argb(34, 0, 0, 0);
    }

    public N3(C0362Ec c0362Ec) {
        super(c0362Ec);
        A05(c0362Ec);
    }

    private void A05(C0362Ec c0362Ec) {
        float f = getResources().getDisplayMetrics().density;
        int i = (int) (50.0f * f);
        int i2 = (int) (4.0f * f);
        KE.A0P(this, -1);
        setGravity(16);
        this.A00 = new ImageView(c0362Ec);
        this.A00.setContentDescription(A02(74, 5, 61));
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        this.A00.setScaleType(ImageView.ScaleType.CENTER);
        this.A00.setImageBitmap(KN.A00(KM.BROWSER_CLOSE));
        this.A00.setOnTouchListener(A09);
        this.A00.setOnClickListener(new N1(this));
        addView(this.A00, layoutParams);
        this.A03 = new N9(c0362Ec);
        LinearLayout.LayoutParams titleViewParams = new LinearLayout.LayoutParams(0, -2);
        titleViewParams.weight = 1.0f;
        this.A03.setPadding(0, i2, 0, i2);
        addView(this.A03, titleViewParams);
        this.A01 = new ImageView(c0362Ec);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i);
        this.A01.setContentDescription(A02(18, 19, 68));
        this.A01.setScaleType(ImageView.ScaleType.CENTER);
        this.A01.setOnTouchListener(A09);
        this.A01.setOnClickListener(new N2(this));
        addView(this.A01, layoutParams2);
        setupDefaultNativeBrowser(c0362Ec);
    }

    public void setListener(InterfaceC0526Kq interfaceC0526Kq) {
        this.A02 = interfaceC0526Kq;
    }

    public void setTitle(String str) {
        this.A03.setTitle(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setUrl(java.lang.String r6) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            r4.A04 = r6
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L5b
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L26;
                case 4: goto L5d;
                case 5: goto L44;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            java.lang.String r6 = (java.lang.String) r6
            r2 = 63
            r1 = 11
            r0 = 105(0x69, float:1.47E-43)
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L24
            r0 = 3
            goto Lc
        L24:
            r0 = 5
            goto Lc
        L26:
            com.facebook.ads.redexgen.X.N3 r4 = (com.facebook.ads.redexgen.X.N3) r4
            r1 = 0
            com.facebook.ads.redexgen.X.N9 r0 = r4.A03
            r0.setSubtitle(r1)
            android.widget.ImageView r1 = r4.A01
            r0 = 0
            r1.setEnabled(r0)
            android.widget.ImageView r3 = r4.A01
            android.graphics.PorterDuffColorFilter r2 = new android.graphics.PorterDuffColorFilter
            int r1 = com.facebook.ads.redexgen.X.N3.A06
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.SRC_IN
            r2.<init>(r1, r0)
            r3.setColorFilter(r2)
            r0 = 4
            goto Lc
        L44:
            com.facebook.ads.redexgen.X.N3 r4 = (com.facebook.ads.redexgen.X.N3) r4
            java.lang.String r6 = (java.lang.String) r6
            r2 = 0
            com.facebook.ads.redexgen.X.N9 r0 = r4.A03
            r0.setSubtitle(r6)
            android.widget.ImageView r1 = r4.A01
            r0 = 1
            r1.setEnabled(r0)
            android.widget.ImageView r0 = r4.A01
            r0.setColorFilter(r2)
            r0 = 4
            goto Lc
        L5b:
            r0 = 3
            goto Lc
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.N3.setUrl(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0074, code lost:            r3.A01.setImageBitmap(r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setupDefaultNativeBrowser(com.facebook.ads.redexgen.X.C0362Ec r8) {
        /*
            r7 = this;
            r3 = r7
            r0 = 0
            r5 = 0
            android.content.pm.PackageManager r6 = r8.getPackageManager()
            android.content.Intent r4 = new android.content.Intent
            r2 = 37
            r1 = 26
            r0 = 123(0x7b, float:1.72E-43)
            java.lang.String r1 = A02(r2, r1, r0)
            android.net.Uri r0 = com.facebook.ads.redexgen.X.N3.A08
            r4.<init>(r1, r0)
            r0 = 65536(0x10000, float:9.1835E-41)
            java.util.List r2 = r6.queryIntentActivities(r4, r0)
            int r0 = r2.size()
            if (r0 != 0) goto L72
            r0 = 2
        L25:
            switch(r0) {
                case 2: goto L5e;
                case 3: goto L74;
                case 4: goto L51;
                case 5: goto L29;
                case 6: goto L49;
                case 7: goto L6a;
                default: goto L28;
            }
        L28:
            goto L25
        L29:
            java.util.List r2 = (java.util.List) r2
            r4 = 0
            r1 = 18
            r0 = 17
            java.lang.String r1 = A02(r4, r1, r0)
            r0 = 0
            java.lang.Object r0 = r2.get(r0)
            android.content.pm.ResolveInfo r0 = (android.content.pm.ResolveInfo) r0
            android.content.pm.ActivityInfo r0 = r0.activityInfo
            java.lang.String r0 = r0.packageName
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L47
            r0 = 6
            goto L25
        L47:
            r0 = 7
            goto L25
        L49:
            com.facebook.ads.redexgen.X.KM r0 = com.facebook.ads.redexgen.X.KM.BROWSER_LAUNCH_CHROME
            android.graphics.Bitmap r5 = com.facebook.ads.redexgen.X.KN.A00(r0)
            r0 = 3
            goto L25
        L51:
            java.util.List r2 = (java.util.List) r2
            int r1 = r2.size()
            r0 = 1
            if (r1 != r0) goto L5c
            r0 = 5
            goto L25
        L5c:
            r0 = 7
            goto L25
        L5e:
            com.facebook.ads.redexgen.X.N3 r3 = (com.facebook.ads.redexgen.X.N3) r3
            android.widget.ImageView r1 = r3.A01
            r0 = 8
            r1.setVisibility(r0)
            r5 = 0
            r0 = 3
            goto L25
        L6a:
            com.facebook.ads.redexgen.X.KM r0 = com.facebook.ads.redexgen.X.KM.BROWSER_LAUNCH_NATIVE
            android.graphics.Bitmap r5 = com.facebook.ads.redexgen.X.KN.A00(r0)
            r0 = 3
            goto L25
        L72:
            r0 = 4
            goto L25
        L74:
            com.facebook.ads.redexgen.X.N3 r3 = (com.facebook.ads.redexgen.X.N3) r3
            android.widget.ImageView r0 = r3.A01
            r0.setImageBitmap(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.N3.setupDefaultNativeBrowser(com.facebook.ads.redexgen.X.Ec):void");
    }
}
