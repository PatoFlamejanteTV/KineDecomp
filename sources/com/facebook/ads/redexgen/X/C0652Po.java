package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import java.util.ArrayList;

/* renamed from: com.facebook.ads.redexgen.X.Po, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0652Po extends FrameLayout implements InterfaceC0650Pm {

    @Nullable
    public TextView A00;

    @Nullable
    public TextView A01;

    @Nullable
    public TextView A02;

    @Nullable
    public TextView A03;
    public final MediaView A04;
    public final NativeAd A05;
    public final C0654Pq A06;
    public final ArrayList<View> A07;
    public static final int A0D = (int) (KE.A01 * 6.0f);
    public static final int A0C = (int) (KE.A01 * 8.0f);
    public static final int A0B = (int) (KE.A01 * 12.0f);
    public static final int A09 = (int) (KE.A01 * 350.0f);
    public static final int A08 = (int) (KE.A01 * 250.0f);
    public static final int A0A = (int) (KE.A01 * 175.0f);

    public C0652Po(C0362Ec c0362Ec, NativeAd nativeAd, C0444Hh c0444Hh, EnumC0445Hi enumC0445Hi, M4 m4, MediaView mediaView, AdOptionsView adOptionsView) {
        super(c0362Ec);
        this.A07 = new ArrayList<>();
        this.A05 = nativeAd;
        this.A04 = mediaView;
        this.A06 = new C0654Pq(c0362Ec, this.A05, c0444Hh, m4, adOptionsView);
        this.A06.setPadding(A0B, A0B, A0B, A0D);
        addView(this.A06, new FrameLayout.LayoutParams(-1, -2));
        if (enumC0445Hi == EnumC0445Hi.A09 || enumC0445Hi == EnumC0445Hi.A0B) {
            A07(c0444Hh);
        }
        addView((View) this.A04, (ViewGroup.LayoutParams) new FrameLayout.LayoutParams(-1, -2));
        if (enumC0445Hi != EnumC0445Hi.A0B || this.A05.getAdCreativeType() != NativeAd.AdCreativeType.CAROUSEL) {
            A06(c0444Hh);
            A04(c0444Hh);
            A05(c0444Hh);
        }
        this.A07.add(m4);
        this.A07.add(mediaView);
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x00b9, code lost:            r3 = r3;     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00ca, code lost:            return ((((r3.getMeasuredHeight() - r3.A06.getMeasuredHeight()) - r2) - r6) - r5) - r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A00() {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0652Po.A00():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x003d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 1
            android.widget.TextView r0 = r2.A03
            if (r0 == 0) goto L3b
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L32;
                case 3: goto L28;
                case 4: goto L1f;
                case 5: goto L15;
                case 6: goto Lc;
                case 7: goto L3d;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Po r2 = (com.facebook.ads.redexgen.X.C0652Po) r2
            android.widget.TextView r0 = r2.A00
            r0.setLines(r1)
            r0 = 7
            goto L8
        L15:
            com.facebook.ads.redexgen.X.Po r2 = (com.facebook.ads.redexgen.X.C0652Po) r2
            android.widget.TextView r0 = r2.A00
            if (r0 == 0) goto L1d
            r0 = 6
            goto L8
        L1d:
            r0 = 7
            goto L8
        L1f:
            com.facebook.ads.redexgen.X.Po r2 = (com.facebook.ads.redexgen.X.C0652Po) r2
            android.widget.TextView r0 = r2.A02
            r0.setLines(r1)
            r0 = 5
            goto L8
        L28:
            com.facebook.ads.redexgen.X.Po r2 = (com.facebook.ads.redexgen.X.C0652Po) r2
            android.widget.TextView r0 = r2.A02
            if (r0 == 0) goto L30
            r0 = 4
            goto L8
        L30:
            r0 = 5
            goto L8
        L32:
            com.facebook.ads.redexgen.X.Po r2 = (com.facebook.ads.redexgen.X.C0652Po) r2
            android.widget.TextView r0 = r2.A03
            r0.setLines(r1)
            r0 = 3
            goto L8
        L3b:
            r0 = 3
            goto L8
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0652Po.A01():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x004d, code lost:            com.facebook.ads.redexgen.X.KE.A0Q(r7, r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0052, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02(int r10) {
        /*
            r9 = this;
            r8 = r9
            r0 = 0
            r7 = 0
            r6 = 0
            r5 = 0
            r0 = 0
            r0 = 0
            r4 = 0
            r3 = 8
            r2 = 0
            com.facebook.ads.MediaView r1 = r8.A04
            int r0 = com.facebook.ads.redexgen.X.C0652Po.A0A
            if (r10 <= r0) goto L4a
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L3d;
                case 3: goto L2b;
                case 4: goto L27;
                case 5: goto L16;
                case 6: goto L4d;
                case 7: goto L41;
                case 8: goto L44;
                case 9: goto L47;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            com.facebook.ads.redexgen.X.Po r8 = (com.facebook.ads.redexgen.X.C0652Po) r8
            android.widget.TextView r5 = (android.widget.TextView) r5
            com.facebook.ads.redexgen.X.KE.A0Q(r5, r6)
            android.widget.TextView r7 = r8.A00
            int r0 = com.facebook.ads.redexgen.X.C0652Po.A08
            if (r10 <= r0) goto L25
            r0 = 6
            goto L12
        L25:
            r0 = 7
            goto L12
        L27:
            r2 = 0
            r6 = r2
            r0 = 5
            goto L12
        L2b:
            com.facebook.ads.redexgen.X.Po r8 = (com.facebook.ads.redexgen.X.C0652Po) r8
            com.facebook.ads.MediaView r1 = (com.facebook.ads.MediaView) r1
            com.facebook.ads.redexgen.X.KE.A0Q(r1, r4)
            android.widget.TextView r5 = r8.A03
            int r0 = com.facebook.ads.redexgen.X.C0652Po.A09
            if (r10 <= r0) goto L3a
            r0 = 4
            goto L12
        L3a:
            r0 = 8
            goto L12
        L3d:
            r2 = 0
            r4 = r2
            r0 = 3
            goto L12
        L41:
            r2 = r3
            r0 = 6
            goto L12
        L44:
            r6 = r3
            r0 = 5
            goto L12
        L47:
            r4 = r3
            r0 = 3
            goto L12
        L4a:
            r0 = 9
            goto L12
        L4d:
            android.widget.TextView r7 = (android.widget.TextView) r7
            com.facebook.ads.redexgen.X.KE.A0Q(r7, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0652Po.A02(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0050, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A03(int r6, int r7, android.widget.TextView... r8) {
        /*
            r5 = 0
            r0 = 0
            r0 = 0
            int r4 = r8.length
            r3 = 0
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L4a;
                case 3: goto L40;
                case 4: goto L34;
                case 5: goto Le;
                case 6: goto La;
                case 7: goto L50;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            int r3 = r3 + 1
            r0 = 2
            goto L6
        Le:
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r2 = com.facebook.ads.redexgen.X.KE.A05(r5, r7)
            int r0 = r2 + 1
            r5.setLines(r0)
            int r1 = r5.getMeasuredHeight()
            int r0 = r5.getLineHeight()
            int r0 = r0 * r2
            int r1 = r1 + r0
            r0 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            r5.measure(r6, r0)
            int r0 = r5.getLineHeight()
            int r0 = r0 * r2
            int r7 = r7 - r0
            r0 = 6
            goto L6
        L34:
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r0 = r5.getVisibility()
            if (r0 != 0) goto L3e
            r0 = 5
            goto L6
        L3e:
            r0 = 6
            goto L6
        L40:
            android.widget.TextView[] r8 = (android.widget.TextView[]) r8
            r5 = r8[r3]
            if (r5 == 0) goto L48
            r0 = 4
            goto L6
        L48:
            r0 = 6
            goto L6
        L4a:
            if (r3 >= r4) goto L4e
            r0 = 3
            goto L6
        L4e:
            r0 = 7
            goto L6
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0652Po.A03(int, int, android.widget.TextView[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A04(com.facebook.ads.redexgen.X.C0444Hh r6) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            com.facebook.ads.NativeAd r0 = r4.A05
            java.lang.String r0 = r0.getAdBodyText()
            if (r0 == 0) goto L5d
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L26;
                case 4: goto L5f;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.Po r4 = (com.facebook.ads.redexgen.X.C0652Po) r4
            com.facebook.ads.NativeAd r0 = r4.A05
            java.lang.String r0 = r0.getAdBodyText()
            java.lang.String r0 = r0.trim()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L24
            r0 = 3
            goto Lc
        L24:
            r0 = 4
            goto Lc
        L26:
            com.facebook.ads.redexgen.X.Po r4 = (com.facebook.ads.redexgen.X.C0652Po) r4
            com.facebook.ads.redexgen.X.Hh r6 = (com.facebook.ads.redexgen.X.C0444Hh) r6
            r3 = 0
            android.widget.TextView r1 = new android.widget.TextView
            android.content.Context r0 = r4.getContext()
            r1.<init>(r0)
            r4.A00 = r1
            android.widget.TextView r0 = r4.A00
            r6.A06(r0)
            android.widget.TextView r1 = r4.A00
            com.facebook.ads.NativeAd r0 = r4.A05
            java.lang.String r0 = r0.getAdBodyText()
            r1.setText(r0)
            android.widget.TextView r2 = r4.A00
            int r1 = com.facebook.ads.redexgen.X.C0652Po.A0B
            int r0 = com.facebook.ads.redexgen.X.C0652Po.A0B
            r2.setPadding(r1, r3, r0, r3)
            android.widget.TextView r3 = r4.A00
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r1 = -1
            r0 = -2
            r2.<init>(r1, r0)
            r4.addView(r3, r2)
            r0 = 4
            goto Lc
        L5d:
            r0 = 4
            goto Lc
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0652Po.A04(com.facebook.ads.redexgen.X.Hh):void");
    }

    private void A05(C0444Hh c0444Hh) {
        if (this.A05.hasCallToAction()) {
            this.A01 = new TextView(getContext());
            KE.A0N(this.A01);
            c0444Hh.A05(this.A01);
            this.A01.setText(this.A05.getAdCallToAction());
            this.A01.setPadding(A0C, A0C, A0C, A0C);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(A0C, 0, A0C, 0);
            addView(this.A01, layoutParams);
            this.A07.add(this.A01);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06(com.facebook.ads.redexgen.X.C0444Hh r7) {
        /*
            r6 = this;
            r5 = r6
            com.facebook.ads.NativeAd r0 = r5.A05
            java.lang.String r0 = r0.getAdHeadline()
            if (r0 == 0) goto L5d
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L24;
                case 4: goto L5f;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.Po r5 = (com.facebook.ads.redexgen.X.C0652Po) r5
            com.facebook.ads.NativeAd r0 = r5.A05
            java.lang.String r0 = r0.getAdHeadline()
            java.lang.String r0 = r0.trim()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L22
            r0 = 3
            goto La
        L22:
            r0 = 4
            goto La
        L24:
            com.facebook.ads.redexgen.X.Po r5 = (com.facebook.ads.redexgen.X.C0652Po) r5
            com.facebook.ads.redexgen.X.Hh r7 = (com.facebook.ads.redexgen.X.C0444Hh) r7
            android.widget.TextView r1 = new android.widget.TextView
            android.content.Context r0 = r5.getContext()
            r1.<init>(r0)
            r5.A02 = r1
            android.widget.TextView r0 = r5.A02
            r7.A07(r0)
            android.widget.TextView r1 = r5.A02
            com.facebook.ads.NativeAd r0 = r5.A05
            java.lang.String r0 = r0.getAdHeadline()
            r1.setText(r0)
            android.widget.TextView r4 = r5.A02
            int r3 = com.facebook.ads.redexgen.X.C0652Po.A0B
            int r2 = com.facebook.ads.redexgen.X.C0652Po.A0C
            int r1 = com.facebook.ads.redexgen.X.C0652Po.A0B
            r0 = 0
            r4.setPadding(r3, r2, r1, r0)
            android.widget.TextView r3 = r5.A02
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r1 = -1
            r0 = -2
            r2.<init>(r1, r0)
            r5.addView(r3, r2)
            r0 = 4
            goto La
        L5d:
            r0 = 4
            goto La
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0652Po.A06(com.facebook.ads.redexgen.X.Hh):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A07(com.facebook.ads.redexgen.X.C0444Hh r7) {
        /*
            r6 = this;
            r5 = r6
            com.facebook.ads.NativeAd r0 = r5.A05
            java.lang.String r0 = r0.getAdLinkDescription()
            if (r0 == 0) goto L5d
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L24;
                case 4: goto L5f;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.Po r5 = (com.facebook.ads.redexgen.X.C0652Po) r5
            com.facebook.ads.NativeAd r0 = r5.A05
            java.lang.String r0 = r0.getAdLinkDescription()
            java.lang.String r0 = r0.trim()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L22
            r0 = 3
            goto La
        L22:
            r0 = 4
            goto La
        L24:
            com.facebook.ads.redexgen.X.Po r5 = (com.facebook.ads.redexgen.X.C0652Po) r5
            com.facebook.ads.redexgen.X.Hh r7 = (com.facebook.ads.redexgen.X.C0444Hh) r7
            android.widget.TextView r1 = new android.widget.TextView
            android.content.Context r0 = r5.getContext()
            r1.<init>(r0)
            r5.A03 = r1
            android.widget.TextView r0 = r5.A03
            r7.A06(r0)
            android.widget.TextView r1 = r5.A03
            com.facebook.ads.NativeAd r0 = r5.A05
            java.lang.String r0 = r0.getAdLinkDescription()
            r1.setText(r0)
            android.widget.TextView r4 = r5.A03
            int r3 = com.facebook.ads.redexgen.X.C0652Po.A0B
            r2 = 0
            int r1 = com.facebook.ads.redexgen.X.C0652Po.A0B
            int r0 = com.facebook.ads.redexgen.X.C0652Po.A0C
            r4.setPadding(r3, r2, r1, r0)
            android.widget.TextView r3 = r5.A03
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r1 = -1
            r0 = -2
            r2.<init>(r1, r0)
            r5.addView(r3, r2)
            r0 = 4
            goto La
        L5d:
            r0 = 4
            goto La
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0652Po.A07(com.facebook.ads.redexgen.X.Hh):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0650Pm
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0650Pm
    public ArrayList<View> getViewsForInteraction() {
        return this.A07;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d4, code lost:            return;     */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0652Po.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:            return;     */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            r2 = r7
            r4 = 0
            r0 = 0
            int r0 = android.view.View.MeasureSpec.getSize(r9)
            r2.A02(r0)
            r2.A01()
            super.onMeasure(r8, r9)
            int r3 = r2.A00()
            com.facebook.ads.MediaView r0 = r2.A04
            int r0 = r0.getMediaWidth()
            if (r0 == 0) goto L80
            r0 = 2
        L1d:
            switch(r0) {
                case 2: goto L52;
                case 3: goto L4f;
                case 4: goto L3c;
                case 5: goto L21;
                case 6: goto L82;
                case 7: goto L60;
                default: goto L20;
            }
        L20:
            goto L1d
        L21:
            com.facebook.ads.redexgen.X.Po r2 = (com.facebook.ads.redexgen.X.C0652Po) r2
            int r6 = r3 - r4
            r0 = 3
            android.widget.TextView[] r5 = new android.widget.TextView[r0]
            r1 = 0
            android.widget.TextView r0 = r2.A02
            r5[r1] = r0
            r1 = 1
            android.widget.TextView r0 = r2.A00
            r5[r1] = r0
            r1 = 2
            android.widget.TextView r0 = r2.A03
            r5[r1] = r0
            A03(r8, r6, r5)
            r0 = 6
            goto L1d
        L3c:
            com.facebook.ads.redexgen.X.Po r2 = (com.facebook.ads.redexgen.X.C0652Po) r2
            com.facebook.ads.MediaView r1 = r2.A04
            r0 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r0)
            r1.measure(r8, r0)
            if (r4 >= r3) goto L4d
            r0 = 5
            goto L1d
        L4d:
            r0 = 6
            goto L1d
        L4f:
            r4 = r3
            r0 = 4
            goto L1d
        L52:
            com.facebook.ads.redexgen.X.Po r2 = (com.facebook.ads.redexgen.X.C0652Po) r2
            com.facebook.ads.MediaView r0 = r2.A04
            int r0 = r0.getMediaHeight()
            if (r0 != 0) goto L5e
            r0 = 3
            goto L1d
        L5e:
            r0 = 7
            goto L1d
        L60:
            com.facebook.ads.redexgen.X.Po r2 = (com.facebook.ads.redexgen.X.C0652Po) r2
            com.facebook.ads.MediaView r0 = r2.A04
            int r0 = r0.getMediaHeight()
            float r1 = (float) r0
            com.facebook.ads.MediaView r0 = r2.A04
            int r0 = r0.getMediaWidth()
            float r0 = (float) r0
            float r1 = r1 / r0
            com.facebook.ads.MediaView r0 = r2.A04
            int r0 = r0.getMeasuredWidth()
            float r0 = (float) r0
            float r0 = r0 * r1
            int r0 = (int) r0
            int r4 = java.lang.Math.min(r0, r3)
            r0 = 4
            goto L1d
        L80:
            r0 = 3
            goto L1d
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0652Po.onMeasure(int, int):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0650Pm
    public final void unregisterView() {
        this.A05.unregisterView();
    }
}
