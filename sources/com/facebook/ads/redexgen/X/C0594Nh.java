package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* renamed from: com.facebook.ads.redexgen.X.Nh, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0594Nh extends NW {
    public static byte[] A0G;
    public static final int A0H;
    public static final int A0I;
    public static final int A0J;
    public static final int A0K;
    public static final int A0L;
    public static final int A0M;
    public static final int A0N;
    public static final int A0O;
    public int A00;
    public int A01;
    public LinearLayout A02;
    public TextView A03;
    public TextView A04;
    public TextView A05;
    public C2S A06;
    public C2U A07;
    public C0597Nk A08;
    public boolean A09;
    public boolean A0A;
    public final LinearLayout A0B;
    public final RelativeLayout A0C;
    public final RelativeLayout A0D;
    public final TextView A0E;
    public final C0362Ec A0F;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0594Nh.A0G
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
            r0 = r0 ^ 121(0x79, float:1.7E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0594Nh.A00(int, int, int):java.lang.String");
    }

    public static void A07() {
        A0G = new byte[]{74, 45};
    }

    static {
        A07();
        A0N = C4G.A01(-1, 77);
        A0K = (int) (12.0f * KE.A01);
        A0L = (int) (8.0f * KE.A01);
        A0H = (int) (26.0f * KE.A01);
        A0J = (int) (144.0f * KE.A01);
        A0I = (int) (48.0f * KE.A01);
        A0M = (int) (16.0f * KE.A01);
        A0O = (int) (14.0f * KE.A01);
    }

    public C0594Nh(C0362Ec c0362Ec, int i, boolean z, C2T c2t, String str, InterfaceC0422Gl interfaceC0422Gl, AnonymousClass81 anonymousClass81, FP fp, K5 k5) {
        this(c0362Ec, i, z, c2t, str, interfaceC0422Gl, anonymousClass81, fp, k5, false);
    }

    public C0594Nh(C0362Ec c0362Ec, int i, boolean z, C2T c2t, String str, InterfaceC0422Gl interfaceC0422Gl, AnonymousClass81 anonymousClass81, FP fp, K5 k5, boolean z2) {
        super(c0362Ec, i, c2t, str, interfaceC0422Gl, anonymousClass81, fp, k5);
        this.A0A = false;
        this.A00 = 0;
        this.A01 = 0;
        this.A0F = c0362Ec;
        this.A09 = z2;
        super.A04.setFullCircleCorners(z);
        setPadding(A0K, A0K, A0K, A0H);
        this.A0C = new RelativeLayout(getContext());
        this.A05 = new TextView(getContext());
        this.A02 = new LinearLayout(getContext());
        this.A08 = new C0597Nk(this.A0F, A0O, 5, A0N, -1);
        this.A0D = new RelativeLayout(getContext());
        this.A0B = new LinearLayout(getContext());
        this.A04 = new TextView(getContext());
        this.A03 = new TextView(getContext());
        super.A01.addView(this.A0C);
        super.A01.addView(this.A0B);
        this.A0E = new TextView(getContext());
        KE.A0M(this);
        A05();
    }

    private void A01() {
        super.A03.setLayoutParams(new LinearLayout.LayoutParams(-1, A0I));
        super.A03.setPadding(0, 0, 0, 0);
    }

    private void A02() {
        this.A0B.setOrientation(1);
        this.A0B.setPadding(0, 0, 0, A0K);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.A0C.getId());
        this.A0B.setLayoutParams(layoutParams);
        this.A0B.removeAllViews();
        this.A03.setMaxLines(2);
        this.A03.setEllipsize(TextUtils.TruncateAt.END);
        this.A03.setGravity(16);
        this.A03.setTextColor(-1);
        KE.A0Y(this.A03, false, 16);
        this.A0B.addView(this.A03, new LinearLayout.LayoutParams(-1, -2));
    }

    private void A03() {
        this.A0C.removeAllViews();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = A0K;
        this.A0C.setLayoutParams(layoutParams);
        KE.A0N(this.A0C);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(super.A00, super.A00);
        layoutParams2.addRule(15);
        layoutParams2.addRule(9);
        this.A0C.addView(super.A04, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = A0L;
        layoutParams3.addRule(1, super.A04.getId());
        layoutParams3.addRule(15);
        this.A0C.addView(this.A0D, layoutParams3);
        this.A0D.removeAllViews();
        KE.A0N(this.A05);
        this.A05.setLayoutParams(NW.A05);
        this.A05.setTextColor(-1);
        KE.A0Y(this.A05, true, 18);
        this.A0D.addView(this.A05);
        this.A02.setOrientation(0);
        this.A02.setGravity(16);
        RelativeLayout.LayoutParams iconAndMetaDataContainerParams = new RelativeLayout.LayoutParams(-2, A0M);
        iconAndMetaDataContainerParams.topMargin = A0L / 2;
        iconAndMetaDataContainerParams.addRule(3, this.A05.getId());
        this.A0D.addView(this.A02, iconAndMetaDataContainerParams);
        this.A02.removeAllViews();
        this.A08.setGravity(16);
        this.A02.addView(this.A08, new LinearLayout.LayoutParams(-2, -1));
        this.A04.setTextColor(-1);
        this.A04.setGravity(16);
        this.A04.setIncludeFontPadding(false);
        KE.A0Y(this.A04, false, 14);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams4.leftMargin = A0L;
        this.A02.addView(this.A04, layoutParams4);
    }

    private void A04() {
        this.A0E.setMaxLines(1);
        this.A0E.setEllipsize(TextUtils.TruncateAt.END);
        this.A0E.setGravity(17);
        this.A0E.setTextColor(-1);
        this.A0E.setAllCaps(true);
        KE.A0Y(this.A0E, false, 12);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = A0K;
        this.A0E.setLayoutParams(layoutParams);
    }

    private void A05() {
        removeAllViews();
        super.A01.setLayoutParams(NW.A05);
        A03();
        A02();
        A01();
        A04();
        A06();
        KE.A0L(super.A01);
        KE.A0L(super.A03);
        KE.A0L(this.A0E);
        addView(super.A01);
        addView(super.A03);
        addView(this.A0E);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00eb, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06() {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0594Nh.A06():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0118, code lost:            r9.bringToFront();     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x011d, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.NW
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A08(int r12) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0594Nh.A08(int):void");
    }

    @Override // com.facebook.ads.redexgen.X.NW
    public final void A09(boolean z) {
        this.A0A = z;
    }

    public final int A0A(int i) {
        return this.A00 + this.A01 + A0L;
    }

    public final void A0B() {
        KE.A0J(this.A0E);
    }

    public final void A0C() {
        if (!TextUtils.isEmpty(this.A0E.getText().toString())) {
            KE.A0O(this.A0E);
        }
    }

    public final View getExpandableLayout() {
        return this.A0B;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.A00 == 0) {
            this.A00 = this.A03.getHeight();
            this.A01 = this.A0E.getHeight();
        }
    }

    @Override // com.facebook.ads.redexgen.X.NW
    public void setInfo(C2S c2s, C2U c2u, String str, String str2, @Nullable NZ nz) {
        super.setInfo(c2s, c2u, str, str2, nz);
        this.A06 = c2s;
        this.A07 = c2u;
        A06();
    }
}
