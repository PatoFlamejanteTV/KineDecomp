package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.ads.DefaultMediaViewVideoRenderer;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.internal.api.AdComponentView;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdComponentViewParentApi;
import com.facebook.ads.internal.api.AdViewConstructorParams;
import com.facebook.ads.internal.api.MediaViewApi;
import com.facebook.ads.internal.api.Repairable;

/* renamed from: com.facebook.ads.redexgen.X.8j, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02148j extends C02017w implements MediaViewApi, Repairable, InterfaceC02138i {
    public static byte[] A0D;
    public static final String A0E;
    public View A00;
    public ImageView A01;
    public MediaView A02;

    @Nullable
    public MediaViewListener A03;
    public MediaViewVideoRenderer A04;
    public C01807a A05;
    public AdComponentViewParentApi A06;
    public C0362Ec A07;
    public L7 A08;
    public NO A09;

    @Nullable
    public PU A0A;
    public boolean A0B;
    public boolean A0C;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C02148j.A0D
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
            r0 = r0 ^ 29
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02148j.A02(int, int, int):java.lang.String");
    }

    public static void A05() {
        A0D = new byte[]{60, 56, 59, 15, 30, 19, 31, 20, 25, 31, 52, 31, 14, 13, 21, 8, 17, 115, 87, 91, 93, 95, 26, 72, 95, 84, 94, 95, 72, 95, 72, 26, 87, 79, 73, 78, 26, 88, 95, 26, 73, 95, 78, 26, 88, 95, 92, 85, 72, 95, 26, 84, 91, 78, 83, 76, 95, 123, 94, 20, 23, 53, 38, 59, 33, 39, 49, 56, 116, 38, 49, 58, 48, 49, 38, 49, 38, 116, 57, 33, 39, 32, 116, 54, 49, 116, 39, 49, 32, 116, 54, 49, 50, 59, 38, 49, 116, 58, 53, 32, 61, 34, 49, 21, 48, 122, 122, 85, 64, 93, 66, 81, 20, 117, 80, 20, 125, 87, 91, 90, 20, 93, 71, 20, 90, 65, 88, 88, 26, 88, Byte.MAX_VALUE, 103, 112, 125, 120, 117, 49, 71, 120, 116, 102, 49, 114, 126, Byte.MAX_VALUE, 98, 101, 99, 100, 114, 101, 126, 99, 49, 97, 112, 99, 112, 124, 98, 49, 101, 104, 97, 116, 63, 108, 115, 126, Byte.MAX_VALUE, 117, 79, 104, 118, 39, 36, 53, 44, 76, 104, 100, 98, 96, 37, 119, 96, 107, 97, 96, 119, 96, 119, 37, 104, 112, 118, 113, 37, 103, 96, 37, 118, 96, 113, 37, 103, 96, 99, 106, 119, 96, 37, 107, 100, 113, 108, 115, 96, 71, 100, 107, 107, 96, 119, 68, 97, 43, 124, 67, 78, 79, 69, 10, 88, 79, 68, 78, 79, 88, 79, 88, 10, 71, 95, 89, 94, 10, 72, 79, 10, 89, 79, 94, 10, 72, 79, 76, 69, 88, 79, 10, 68, 75, 94, 67, 92, 79, 107, 78, 4};
    }

    static {
        A05();
        A0E = MediaView.class.getSimpleName();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000a. Please report as an issue. */
    private void A03() {
        C02148j c02148j = this;
        char c = c02148j.A0C ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalStateException(A02(60, 46, 73));
                case 3:
                    c02148j = c02148j;
                    c = c02148j.A05 != null ? (char) 4 : (char) 5;
                case 4:
                    c02148j = c02148j;
                    KE.A0L(c02148j.A08);
                    c = 5;
                case 5:
                    C02148j c02148j2 = c02148j;
                    float f = KE.A01;
                    int round = Math.round(4.0f * f);
                    int round2 = Math.round(12.0f * f);
                    c02148j2.A08.setChildSpacing(round);
                    c02148j2.A08.setPadding(0, round2, 0, round2);
                    c02148j2.A08.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    c02148j2.A02.addView(c02148j2.A08, layoutParams);
                    return;
            }
        }
    }

    private void A04() {
        EnumC0489Je.A04(this.A02, EnumC0489Je.A0A);
        EnumC0489Je.A04(this.A09, EnumC0489Je.A0A);
        EnumC0489Je.A04(this.A04, EnumC0489Je.A0A);
        EnumC0489Je.A04(this.A05, EnumC0489Je.A0A);
    }

    private final void A06(View view, ViewGroup.LayoutParams layoutParams) {
        A01(false);
        this.A02.addView(view, layoutParams);
        A01(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b0, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A07(android.view.View r8, com.facebook.ads.redexgen.X.HX r9) {
        /*
            r7 = this;
            r6 = r7
            r5 = 0
            r4 = 0
            r0 = 0
            r0 = 0
            r3 = 17
            r2 = -1
            com.facebook.ads.redexgen.X.PU r0 = r6.A0A
            if (r0 == 0) goto Lad
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L45;
                case 3: goto L39;
                case 4: goto Lb0;
                case 5: goto L25;
                case 6: goto L11;
                case 7: goto L50;
                case 8: goto L82;
                case 9: goto L9a;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.8j r6 = (com.facebook.ads.redexgen.X.C02148j) r6
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.redexgen.X.Ec r0 = r6.A07
            com.facebook.ads.redexgen.X.PU r0 = com.facebook.ads.redexgen.X.PT.A01(r0, r4)
            r6.A0A = r0
            com.facebook.ads.redexgen.X.PU r0 = r6.A0A
            if (r0 == 0) goto L23
            r0 = 7
            goto Ld
        L23:
            r0 = 4
            goto Ld
        L25:
            com.facebook.ads.redexgen.X.8j r6 = (com.facebook.ads.redexgen.X.C02148j) r6
            com.facebook.ads.redexgen.X.HX r9 = (com.facebook.ads.redexgen.X.HX) r9
            java.lang.String r4 = r9.A14()
            com.facebook.ads.MediaView r0 = r6.A02
            android.content.Context r0 = r0.getContext()
            if (r0 == 0) goto L37
            r0 = 6
            goto Ld
        L37:
            r0 = 4
            goto Ld
        L39:
            com.facebook.ads.redexgen.X.HX r9 = (com.facebook.ads.redexgen.X.HX) r9
            boolean r0 = r9.A1T()
            if (r0 != 0) goto L43
            r0 = 4
            goto Ld
        L43:
            r0 = 5
            goto Ld
        L45:
            com.facebook.ads.redexgen.X.8j r6 = (com.facebook.ads.redexgen.X.C02148j) r6
            com.facebook.ads.MediaView r1 = r6.A02
            com.facebook.ads.redexgen.X.PU r0 = r6.A0A
            r1.removeView(r0)
            r0 = 3
            goto Ld
        L50:
            android.view.View r8 = (android.view.View) r8
            android.widget.RelativeLayout$LayoutParams r5 = new android.widget.RelativeLayout$LayoutParams
            r5.<init>(r2, r2)
            r1 = 5
            int r0 = r8.getId()
            r5.addRule(r1, r0)
            r1 = 7
            int r0 = r8.getId()
            r5.addRule(r1, r0)
            r1 = 6
            int r0 = r8.getId()
            r5.addRule(r1, r0)
            r1 = 8
            int r0 = r8.getId()
            r5.addRule(r1, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L7f
            r0 = 8
            goto Ld
        L7f:
            r0 = 9
            goto Ld
        L82:
            android.view.View r8 = (android.view.View) r8
            android.widget.RelativeLayout$LayoutParams r5 = (android.widget.RelativeLayout.LayoutParams) r5
            r1 = 16
            int r0 = r8.getId()
            r5.addRule(r1, r0)
            int r0 = r8.getId()
            r5.addRule(r3, r0)
            r0 = 9
            goto Ld
        L9a:
            com.facebook.ads.redexgen.X.8j r6 = (com.facebook.ads.redexgen.X.C02148j) r6
            android.widget.RelativeLayout$LayoutParams r5 = (android.widget.RelativeLayout.LayoutParams) r5
            com.facebook.ads.redexgen.X.PU r0 = r6.A0A
            r6.A06(r0, r5)
            com.facebook.ads.internal.api.AdComponentViewParentApi r1 = r6.A06
            com.facebook.ads.redexgen.X.PU r0 = r6.A0A
            r1.bringChildToFront(r0)
            r0 = 4
            goto Ld
        Lad:
            r0 = 3
            goto Ld
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02148j.A07(android.view.View, com.facebook.ads.redexgen.X.HX):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0008. Please report as an issue. */
    private void A08(ImageView imageView) {
        C02148j c02148j = this;
        char c = c02148j.A0C ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalStateException(A02(178, 49, 24));
                case 3:
                    c02148j = c02148j;
                    c = c02148j.A01 != null ? (char) 4 : (char) 5;
                case 4:
                    c02148j = c02148j;
                    KE.A0L(c02148j.A01);
                    c = 5;
                case 5:
                    C02148j c02148j2 = c02148j;
                    ImageView imageView2 = imageView;
                    imageView2.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    c02148j2.A02.addView(imageView2, layoutParams);
                    imageView2.setId(KE.A00());
                    c02148j2.A01 = imageView2;
                    return;
            }
        }
    }

    @TargetApi(21)
    private final void A09(C0362Ec c0362Ec, AttributeSet attributeSet, int i, int i2, MediaView mediaView) {
        this.A02 = mediaView;
        A08(new ImageView(c0362Ec, attributeSet, i, i2));
        A0E(new NO(c0362Ec, attributeSet, i, i2));
        this.A08 = new L7(c0362Ec, attributeSet, i);
        A03();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(c0362Ec, attributeSet, i, i2));
        A04();
    }

    private final void A0A(C0362Ec c0362Ec, AttributeSet attributeSet, int i, MediaView mediaView) {
        this.A02 = mediaView;
        A08(new ImageView(c0362Ec, attributeSet, i));
        A0E(new NO(c0362Ec, attributeSet, i));
        this.A08 = new L7(c0362Ec, attributeSet, i);
        A03();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(c0362Ec, attributeSet, i));
        A04();
    }

    private final void A0B(C0362Ec c0362Ec, AttributeSet attributeSet, MediaView mediaView) {
        this.A02 = mediaView;
        A08(new ImageView(c0362Ec, attributeSet));
        A0E(new NO(c0362Ec, attributeSet));
        this.A08 = new L7(c0362Ec, attributeSet);
        A03();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(c0362Ec, attributeSet));
        A04();
    }

    private final void A0C(C0362Ec c0362Ec, MediaView mediaView) {
        this.A02 = mediaView;
        A08(new ImageView(c0362Ec));
        A0E(new NO(c0362Ec));
        this.A08 = new L7(c0362Ec);
        A03();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(c0362Ec));
        A04();
    }

    private void A0D(final HX hx, boolean z, HY hy) {
        NR A04 = new NR(this.A01, this.A07).A04();
        if (z) {
            A04.A06(new C2B() { // from class: com.facebook.ads.redexgen.X.8c
                @Override // com.facebook.ads.redexgen.X.C2B
                public final void A6h(boolean z2) {
                    hx.A1S(z2, true);
                }
            });
        }
        A04.A07(hy.getUrl());
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0008. Please report as an issue. */
    private void A0E(NO no) {
        C02148j c02148j = this;
        char c = c02148j.A0C ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalStateException(A02(17, 43, 39));
                case 3:
                    c02148j = c02148j;
                    c = c02148j.A09 != null ? (char) 4 : (char) 5;
                case 4:
                    c02148j = c02148j;
                    c02148j.A02.removeView(c02148j.A09);
                    c = 5;
                case 5:
                    C02148j c02148j2 = c02148j;
                    NO no2 = no;
                    no2.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    c02148j2.A02.addView(no2, layoutParams);
                    c02148j2.A09 = no2;
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0048, code lost:            return r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0F(com.facebook.ads.NativeAd r5) {
        /*
            r4 = this;
            r3 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r1 = 0
            com.facebook.ads.internal.api.NativeAdApi r1 = r5.getNativeAdApi()
            com.facebook.ads.redexgen.X.90 r1 = (com.facebook.ads.redexgen.X.AnonymousClass90) r1
            java.util.List r2 = r1.A03()
            if (r2 != 0) goto L46
            r1 = 2
        L12:
            switch(r1) {
                case 2: goto L3d;
                case 3: goto L48;
                case 4: goto L35;
                case 5: goto L28;
                case 6: goto L16;
                case 7: goto L40;
                case 8: goto L43;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r1 = r3.next()
            com.facebook.ads.NativeAd r1 = (com.facebook.ads.NativeAd) r1
            com.facebook.ads.NativeAdBase$Image r1 = r1.getAdCoverImage()
            if (r1 != 0) goto L26
            r1 = 7
            goto L12
        L26:
            r1 = 5
            goto L12
        L28:
            java.util.Iterator r3 = (java.util.Iterator) r3
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L32
            r1 = 6
            goto L12
        L32:
            r1 = 8
            goto L12
        L35:
            java.util.List r2 = (java.util.List) r2
            java.util.Iterator r3 = r2.iterator()
            r1 = 5
            goto L12
        L3d:
            r0 = 0
            r1 = 3
            goto L12
        L40:
            r0 = 0
            r1 = 3
            goto L12
        L43:
            r0 = 1
            r1 = 3
            goto L12
        L46:
            r1 = 4
            goto L12
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02148j.A0F(com.facebook.ads.NativeAd):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002a, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0G(com.facebook.ads.NativeAd r4) {
        /*
            r3 = this;
            r2 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 14
            if (r1 < r0) goto L28
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L22;
                case 4: goto L2a;
                case 5: goto L25;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.NativeAd r4 = (com.facebook.ads.NativeAd) r4
            com.facebook.ads.internal.api.NativeAdApi r0 = r4.getNativeAdApi()
            com.facebook.ads.redexgen.X.90 r0 = (com.facebook.ads.redexgen.X.AnonymousClass90) r0
            java.lang.String r0 = r0.A02()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L20
            r0 = 3
            goto L8
        L20:
            r0 = 5
            goto L8
        L22:
            r2 = 1
            r0 = 4
            goto L8
        L25:
            r2 = 0
            r0 = 4
            goto L8
        L28:
            r0 = 5
            goto L8
        L2a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02148j.A0G(com.facebook.ads.NativeAd):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x029c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0H(com.facebook.ads.NativeAd r13) {
        /*
            Method dump skipped, instructions count: 712
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02148j.A0H(com.facebook.ads.NativeAd):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0143, code lost:            r10 = r10;        r10.A07(r10.A01, r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0I(com.facebook.ads.internal.api.NativeAdBaseApi r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02148j.A0I(com.facebook.ads.internal.api.NativeAdBaseApi, boolean):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02138i
    public final C0362Ec A4E() {
        return this.A07;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x004c, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C02017w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void bringChildToFront(android.view.View r4) {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.7a r0 = r2.A05
            if (r4 == r0) goto L4a
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L3e;
                case 3: goto L32;
                case 4: goto L26;
                case 5: goto L15;
                case 6: goto La;
                case 7: goto L4c;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            com.facebook.ads.internal.api.AdComponentViewParentApi r1 = r2.A06
            com.facebook.ads.redexgen.X.PU r0 = r2.A0A
            r1.bringChildToFront(r0)
            r0 = 7
            goto L6
        L15:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            android.view.View r4 = (android.view.View) r4
            com.facebook.ads.internal.api.AdComponentViewParentApi r0 = r2.A06
            r0.bringChildToFront(r4)
            com.facebook.ads.redexgen.X.PU r0 = r2.A0A
            if (r0 == 0) goto L24
            r0 = 6
            goto L6
        L24:
            r0 = 7
            goto L6
        L26:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            android.view.View r4 = (android.view.View) r4
            android.widget.ImageView r0 = r2.A01
            if (r4 != r0) goto L30
            r0 = 5
            goto L6
        L30:
            r0 = 7
            goto L6
        L32:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            android.view.View r4 = (android.view.View) r4
            com.facebook.ads.redexgen.X.NO r0 = r2.A09
            if (r4 == r0) goto L3c
            r0 = 4
            goto L6
        L3c:
            r0 = 5
            goto L6
        L3e:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            android.view.View r4 = (android.view.View) r4
            com.facebook.ads.MediaViewVideoRenderer r0 = r2.A04
            if (r4 == r0) goto L48
            r0 = 3
            goto L6
        L48:
            r0 = 5
            goto L6
        L4a:
            r0 = 5
            goto L6
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02148j.bringChildToFront(android.view.View):void");
    }

    public final void destroy() {
        this.A04.pause(false);
        this.A04.getMediaViewVideoRendererApi().destroy();
    }

    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    public final View getAdContentsView() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0057, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getMediaHeight() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.NO r0 = r2.A09
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L55
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L36;
                case 3: goto L57;
                case 4: goto L1e;
                case 5: goto L2c;
                case 6: goto Lf;
                case 7: goto L40;
                case 8: goto L52;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            com.facebook.ads.MediaViewVideoRenderer r0 = r2.A04
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L1b
            r0 = 7
            goto Lb
        L1b:
            r0 = 8
            goto Lb
        L1e:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            com.facebook.ads.MediaView r0 = r2.A02
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L2a
            r0 = 5
            goto Lb
        L2a:
            r0 = 6
            goto Lb
        L2c:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            com.facebook.ads.MediaView r0 = r2.A02
            int r1 = r0.getHeight()
            r0 = 3
            goto Lb
        L36:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            com.facebook.ads.redexgen.X.NO r0 = r2.A09
            int r1 = r0.getImageHeight()
            r0 = 3
            goto Lb
        L40:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            com.facebook.ads.MediaViewVideoRenderer r0 = r2.A04
            com.facebook.ads.internal.api.MediaViewVideoRendererApi r0 = r0.getMediaViewVideoRendererApi()
            android.view.View r0 = r0.getVideoView()
            int r1 = r0.getHeight()
            r0 = 3
            goto Lb
        L52:
            r1 = 0
            r0 = 3
            goto Lb
        L55:
            r0 = 4
            goto Lb
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02148j.getMediaHeight():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0057, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getMediaWidth() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.NO r0 = r2.A09
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L55
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L36;
                case 3: goto L57;
                case 4: goto L28;
                case 5: goto L1e;
                case 6: goto Lf;
                case 7: goto L40;
                case 8: goto L52;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            com.facebook.ads.MediaViewVideoRenderer r0 = r2.A04
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L1b
            r0 = 7
            goto Lb
        L1b:
            r0 = 8
            goto Lb
        L1e:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            com.facebook.ads.MediaView r0 = r2.A02
            int r1 = r0.getWidth()
            r0 = 3
            goto Lb
        L28:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            com.facebook.ads.MediaView r0 = r2.A02
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L34
            r0 = 5
            goto Lb
        L34:
            r0 = 6
            goto Lb
        L36:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            com.facebook.ads.redexgen.X.NO r0 = r2.A09
            int r1 = r0.getImageWidth()
            r0 = 3
            goto Lb
        L40:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            com.facebook.ads.MediaViewVideoRenderer r0 = r2.A04
            com.facebook.ads.internal.api.MediaViewVideoRendererApi r0 = r0.getMediaViewVideoRendererApi()
            android.view.View r0 = r0.getVideoView()
            int r1 = r0.getWidth()
            r0 = 3
            goto Lb
        L52:
            r1 = 0
            r0 = 3
            goto Lb
        L55:
            r0 = 4
            goto Lb
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02148j.getMediaWidth():int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public final void initialize(AdViewConstructorParams adViewConstructorParams, MediaView mediaView) {
        char c;
        MediaView mediaView2 = mediaView;
        C02148j c02148j = this;
        Context context = adViewConstructorParams.getContext();
        c02148j.A07 = C8N.A02(context);
        c02148j.A07.A0B(c02148j);
        switch (adViewConstructorParams.getInitializationType()) {
            case 0:
                c = 6;
                break;
            case 1:
                c = 5;
                break;
            case 2:
                c = 4;
                break;
            case 3:
                c = 3;
                break;
            default:
                c = 2;
                break;
        }
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalArgumentException(A02(129, 37, 12));
                case 3:
                    c02148j = c02148j;
                    adViewConstructorParams = adViewConstructorParams;
                    mediaView2 = mediaView2;
                    c02148j.A09(c02148j.A07, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleAttr(), adViewConstructorParams.getDefStyleRes(), mediaView2);
                    c = 7;
                case 4:
                    c02148j = c02148j;
                    adViewConstructorParams = adViewConstructorParams;
                    mediaView2 = mediaView2;
                    c02148j.A0A(c02148j.A07, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleAttr(), mediaView2);
                    c = 7;
                case 5:
                    c02148j = c02148j;
                    adViewConstructorParams = adViewConstructorParams;
                    mediaView2 = mediaView2;
                    c02148j.A0B(c02148j.A07, adViewConstructorParams.getAttributeSet(), mediaView2);
                    c = 7;
                case 6:
                    c02148j = c02148j;
                    mediaView2 = mediaView2;
                    c02148j.A0C(c02148j.A07, mediaView2);
                    c = 7;
                case 7:
                    c02148j.A01(true);
                    return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C02017w
    public final void onAttachedToView(AdComponentView adComponentView, AdComponentViewParentApi adComponentViewParentApi) {
        super.onAttachedToView(adComponentView, adComponentViewParentApi);
        this.A06 = adComponentViewParentApi;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void repair(java.lang.Throwable r6) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            com.facebook.ads.MediaView r0 = r4.A02
            int r3 = r0.getWidth()
            com.facebook.ads.MediaView r0 = r4.A02
            int r2 = r0.getHeight()
            if (r3 <= 0) goto L4a
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L1c;
                case 4: goto L4c;
                case 5: goto L3f;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            if (r2 <= 0) goto L1a
            r0 = 3
            goto L12
        L1a:
            r0 = 5
            goto L12
        L1c:
            com.facebook.ads.redexgen.X.8j r4 = (com.facebook.ads.redexgen.X.C02148j) r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            com.facebook.ads.MediaView r0 = r4.A02
            r0.repair(r6)
            com.facebook.ads.MediaView r0 = r4.A02
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            r0.width = r3
            com.facebook.ads.MediaView r0 = r4.A02
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            r0.height = r2
            com.facebook.ads.MediaView r1 = r4.A02
            r0 = -3355444(0xffffffffffcccccc, float:NaN)
            r1.setBackgroundColor(r0)
            r0 = 4
            goto L12
        L3f:
            com.facebook.ads.redexgen.X.8j r4 = (com.facebook.ads.redexgen.X.C02148j) r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            com.facebook.ads.MediaView r0 = r4.A02
            r0.repair(r6)
            r0 = 4
            goto L12
        L4a:
            r0 = 5
            goto L12
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02148j.repair(java.lang.Throwable):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setListener(final com.facebook.ads.MediaViewListener r4) {
        /*
            r3 = this;
            r2 = r3
            r2.A03 = r4
            if (r4 != 0) goto L30
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L32;
                case 4: goto L1a;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            com.facebook.ads.MediaViewVideoRenderer r0 = r2.A04
            com.facebook.ads.internal.api.MediaViewVideoRendererApi r1 = r0.getMediaViewVideoRendererApi()
            com.facebook.ads.redexgen.X.8y r1 = (com.facebook.ads.redexgen.X.C02298y) r1
            r0 = 0
            r1.A07(r0)
            r0 = 3
            goto L6
        L1a:
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            com.facebook.ads.MediaViewListener r4 = (com.facebook.ads.MediaViewListener) r4
            com.facebook.ads.MediaViewVideoRenderer r0 = r2.A04
            com.facebook.ads.internal.api.MediaViewVideoRendererApi r1 = r0.getMediaViewVideoRendererApi()
            com.facebook.ads.redexgen.X.8y r1 = (com.facebook.ads.redexgen.X.C02298y) r1
            com.facebook.ads.redexgen.X.8h r0 = new com.facebook.ads.redexgen.X.8h
            r0.<init>()
            r1.A07(r0)
            r0 = 3
            goto L6
        L30:
            r0 = 4
            goto L6
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02148j.setListener(com.facebook.ads.MediaViewListener):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0009. Please report as an issue. */
    public final void setVideoRenderer(MediaViewVideoRenderer mediaViewVideoRenderer) {
        C02148j c02148j = this;
        boolean z = false;
        char c = c02148j.A0C ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalStateException(A02(227, 43, 55));
                case 3:
                    c02148j = c02148j;
                    c = c02148j.A04 != null ? (char) 4 : (char) 5;
                case 4:
                    c02148j = c02148j;
                    c02148j.A02.removeView(c02148j.A04);
                    c02148j.A04.getMediaViewVideoRendererApi().destroy();
                    c = 5;
                case 5:
                    c02148j = c02148j;
                    mediaViewVideoRenderer = mediaViewVideoRenderer;
                    ((C02298y) mediaViewVideoRenderer.getMediaViewVideoRendererApi()).A05(c02148j.A07.A05());
                    mediaViewVideoRenderer.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    ((C02148j) c02148j.A02.getMediaViewApi()).A06(mediaViewVideoRenderer, layoutParams);
                    c02148j.A04 = mediaViewVideoRenderer;
                    c = !(c02148j.A04 instanceof DefaultMediaViewVideoRenderer) ? (char) 6 : '\b';
                case 6:
                    z = true;
                    c = 7;
                case 7:
                    c02148j.A0B = z;
                    mediaViewVideoRenderer.setId(KE.A00());
                    return;
                case '\b':
                    z = false;
                    c = 7;
            }
        }
    }
}
