package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network.dex */
public final class HH extends C02017w implements DefaultMediaViewVideoRendererApi {
    public static byte[] A0F;
    public static final String A0G;
    public MediaViewVideoRenderer A00;
    public C0362Ec A01;

    @Nullable
    public HF A02;

    @Nullable
    public C0538Lc A04;
    public M6 A05;
    public K6 A06;
    public AnonymousClass29 A07;
    public FP A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final H6 A0C = new H7(this);
    public final AtomicBoolean A0D = new AtomicBoolean(false);
    public final AtomicBoolean A0E = new AtomicBoolean(false);
    public EnumC0447Hk A03 = EnumC0447Hk.A02;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A06(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.HH.A0F
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
            r0 = r0 ^ 24
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HH.A06(int, int, int):java.lang.String");
    }

    public static void A0E() {
        A0F = new byte[]{92, 116, 117, 120, 112, 71, 120, 116, 102, 71, 120, 117, 116, 126, 49, 120, 98, 49, Byte.MAX_VALUE, 100, 125, 125, 42, 49, 100, Byte.MAX_VALUE, 112, 115, 125, 116, 49, 101, 126, 49, 119, 120, Byte.MAX_VALUE, 117, 49, 120, 101, 63, 100, 67, 91, 76, 65, 68, 73, 13, 95, 72, 67, 73, 72, 95, 72, 95, 13, 78, 69, 68, 65, 73, 13, 78, 66, 67, 75, 68, 74, 3, 44, 23, 24, 27, 21, 28, 89, 13, 22, 89, 31, 16, 23, 29, 89, 52, 28, 29, 16, 24, 47, 16, 28, 14, 47, 16, 29, 28, 22, 89, 26, 17, 16, 21, 29, 87};
    }

    static {
        A0E();
        A0G = HH.class.getSimpleName();
    }

    private H8 A01(MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        return new H9(this, mediaViewVideoRendererApi);
    }

    private H8 A02(MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        return new HA(this, mediaViewVideoRendererApi);
    }

    private AnonymousClass29 A04() {
        return new HE(this);
    }

    private FP A05() {
        return new FP(this.A00, 50, true, this.A07, this.A01);
    }

    private void A09() {
        if (this.A04 != null) {
            ((QF) this.A04.getVideoView()).setViewImplInflationListener(this.A0C);
        }
    }

    private void A0A() {
        if (this.A04 != null) {
            this.A04.getVideoView().setOnTouchListener(new HD(this));
        }
    }

    private void A0B() {
        if (this.A04 != null) {
            ((QF) this.A04.getVideoView()).setViewImplInflationListener(null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x005f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0C() {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.MediaViewVideoRenderer r0 = r2.A00
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L5d
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L42;
                case 3: goto L34;
                case 4: goto L2b;
                case 5: goto L5f;
                case 6: goto Le;
                case 7: goto L19;
                case 8: goto L4c;
                case 9: goto L54;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.HH r2 = (com.facebook.ads.redexgen.X.HH) r2
            com.facebook.ads.redexgen.X.Lc r0 = r2.A04
            if (r0 == 0) goto L16
            r0 = 7
            goto La
        L16:
            r0 = 9
            goto La
        L19:
            com.facebook.ads.redexgen.X.HH r2 = (com.facebook.ads.redexgen.X.HH) r2
            com.facebook.ads.redexgen.X.Lc r0 = r2.A04
            com.facebook.ads.redexgen.X.FR r1 = r0.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A05
            if (r1 != r0) goto L28
            r0 = 8
            goto La
        L28:
            r0 = 9
            goto La
        L2b:
            com.facebook.ads.redexgen.X.HH r2 = (com.facebook.ads.redexgen.X.HH) r2
            com.facebook.ads.redexgen.X.FP r0 = r2.A08
            r0.A0V()
            r0 = 5
            goto La
        L34:
            com.facebook.ads.redexgen.X.HH r2 = (com.facebook.ads.redexgen.X.HH) r2
            com.facebook.ads.MediaViewVideoRenderer r0 = r2.A00
            boolean r0 = r0.hasWindowFocus()
            if (r0 == 0) goto L40
            r0 = 4
            goto La
        L40:
            r0 = 6
            goto La
        L42:
            com.facebook.ads.redexgen.X.HH r2 = (com.facebook.ads.redexgen.X.HH) r2
            boolean r0 = r2.A09
            if (r0 == 0) goto L4a
            r0 = 3
            goto La
        L4a:
            r0 = 6
            goto La
        L4c:
            com.facebook.ads.redexgen.X.HH r2 = (com.facebook.ads.redexgen.X.HH) r2
            r0 = 1
            r2.A0B = r0
            r0 = 9
            goto La
        L54:
            com.facebook.ads.redexgen.X.HH r2 = (com.facebook.ads.redexgen.X.HH) r2
            com.facebook.ads.redexgen.X.FP r0 = r2.A08
            r0.A0W()
            r0 = 5
            goto La
        L5d:
            r0 = 6
            goto La
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HH.A0C():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D() {
        this.A03 = EnumC0447Hk.A02;
        A0B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:            r2 = r4;        r5 = r5;        r1.setImage(r3, new com.facebook.ads.redexgen.X.HB(r2));        r2.A03 = r5.A12();        r2.A06.setPlayAccessibilityLabel(r5.A16());        r2.A06.setPauseAccessibilityLabel(r5.A15());        r2.A08.A0V();     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0I(com.facebook.ads.redexgen.X.HX r5, @android.support.annotation.Nullable com.facebook.ads.redexgen.X.HF r6) {
        /*
            r4 = this;
            r0 = 0
            r3 = 0
            r0 = 0
            r4.A0A = r0
            r4.A0B = r0
            r4.A02 = r6
            r4.A09()
            com.facebook.ads.redexgen.X.M6 r1 = r4.A05
            if (r5 == 0) goto L30
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L15;
                case 3: goto L21;
                case 4: goto L32;
                case 5: goto L2d;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            com.facebook.ads.redexgen.X.HX r5 = (com.facebook.ads.redexgen.X.HX) r5
            com.facebook.ads.redexgen.X.HY r0 = r5.getAdCoverImage()
            if (r0 == 0) goto L1f
            r0 = 3
            goto L11
        L1f:
            r0 = 5
            goto L11
        L21:
            com.facebook.ads.redexgen.X.HX r5 = (com.facebook.ads.redexgen.X.HX) r5
            com.facebook.ads.redexgen.X.HY r0 = r5.getAdCoverImage()
            java.lang.String r3 = r0.getUrl()
            r0 = 4
            goto L11
        L2d:
            r3 = 0
            r0 = 4
            goto L11
        L30:
            r0 = 5
            goto L11
        L32:
            r2 = r4
            com.facebook.ads.redexgen.X.HH r2 = (com.facebook.ads.redexgen.X.HH) r2
            com.facebook.ads.redexgen.X.HX r5 = (com.facebook.ads.redexgen.X.HX) r5
            com.facebook.ads.redexgen.X.M6 r1 = (com.facebook.ads.redexgen.X.M6) r1
            com.facebook.ads.redexgen.X.HB r0 = new com.facebook.ads.redexgen.X.HB
            r0.<init>(r2)
            r1.setImage(r3, r0)
            com.facebook.ads.redexgen.X.Hk r0 = r5.A12()
            r2.A03 = r0
            com.facebook.ads.redexgen.X.K6 r1 = r2.A06
            java.lang.String r0 = r5.A16()
            r1.setPlayAccessibilityLabel(r0)
            com.facebook.ads.redexgen.X.K6 r1 = r2.A06
            java.lang.String r0 = r5.A15()
            r1.setPauseAccessibilityLabel(r0)
            com.facebook.ads.redexgen.X.FP r0 = r2.A08
            r0.A0V()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HH.A0I(com.facebook.ads.redexgen.X.HX, com.facebook.ads.redexgen.X.HF):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0J(com.facebook.ads.redexgen.X.QH r6) {
        /*
            r5 = this;
            r4 = r5
            com.facebook.ads.redexgen.X.Lc r0 = r4.A04
            if (r0 == 0) goto L2f
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L31;
                case 4: goto L15;
                case 5: goto L1f;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.HH r4 = (com.facebook.ads.redexgen.X.HH) r4
            com.facebook.ads.redexgen.X.QH r6 = (com.facebook.ads.redexgen.X.QH) r6
            com.facebook.ads.redexgen.X.Lc r0 = r4.A04
            r0.A0Q(r6)
            r0 = 3
            goto L6
        L15:
            boolean r0 = com.facebook.ads.internal.settings.AdInternalSettings.isDebugBuild()
            if (r0 == 0) goto L1d
            r0 = 5
            goto L6
        L1d:
            r0 = 3
            goto L6
        L1f:
            java.lang.String r3 = com.facebook.ads.redexgen.X.HH.A0G
            r2 = 0
            r1 = 42
            r0 = 9
            java.lang.String r0 = A06(r2, r1, r0)
            android.util.Log.e(r3, r0)
            r0 = 3
            goto L6
        L2f:
            r0 = 4
            goto L6
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HH.A0J(com.facebook.ads.redexgen.X.QH):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0039, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean A0K() {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r2 = 0
            com.facebook.ads.redexgen.X.Lc r0 = r3.A04
            if (r0 == 0) goto L37
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L39;
                case 4: goto L1c;
                case 5: goto L28;
                case 6: goto L34;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.HH r3 = (com.facebook.ads.redexgen.X.HH) r3
            com.facebook.ads.redexgen.X.Lc r0 = r3.A04
            com.facebook.ads.redexgen.X.FR r1 = r0.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A06
            if (r1 != r0) goto L1a
            r0 = 3
            goto L8
        L1a:
            r0 = 4
            goto L8
        L1c:
            com.facebook.ads.redexgen.X.HH r3 = (com.facebook.ads.redexgen.X.HH) r3
            com.facebook.ads.redexgen.X.Hk r1 = r3.A03
            com.facebook.ads.redexgen.X.Hk r0 = com.facebook.ads.redexgen.X.EnumC0447Hk.A04
            if (r1 == r0) goto L26
            r0 = 5
            goto L8
        L26:
            r0 = 6
            goto L8
        L28:
            com.facebook.ads.redexgen.X.HH r3 = (com.facebook.ads.redexgen.X.HH) r3
            com.facebook.ads.redexgen.X.Hk r1 = r3.A03
            com.facebook.ads.redexgen.X.Hk r0 = com.facebook.ads.redexgen.X.EnumC0447Hk.A02
            if (r1 != r0) goto L32
            r0 = 6
            goto L8
        L32:
            r0 = 3
            goto L8
        L34:
            r2 = 1
            r0 = 3
            goto L8
        L37:
            r0 = 3
            goto L8
        L39:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HH.A0K():boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0015. Please report as an issue. */
    public final void initialize(Context context, MediaViewVideoRenderer mediaViewVideoRenderer, MediaViewVideoRendererApi mediaViewVideoRendererApi, int i) {
        char c;
        HH hh = this;
        View view = null;
        H8 h8 = null;
        int i2 = 0;
        ((C02017w) mediaViewVideoRendererApi.getAdComponentViewApi()).A00(hh);
        switch (i) {
            case 0:
                c = 4;
                break;
            case 1:
                c = 3;
                break;
            default:
                c = 2;
                break;
        }
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalArgumentException(A06(42, 30, 53));
                case 3:
                    hh = hh;
                    mediaViewVideoRendererApi = mediaViewVideoRendererApi;
                    h8 = hh.A01(mediaViewVideoRendererApi);
                    c = 5;
                case 4:
                    hh = hh;
                    mediaViewVideoRendererApi = mediaViewVideoRendererApi;
                    h8 = hh.A02(mediaViewVideoRendererApi);
                    c = 5;
                case 5:
                    hh = hh;
                    context = context;
                    mediaViewVideoRenderer = mediaViewVideoRenderer;
                    mediaViewVideoRendererApi = mediaViewVideoRendererApi;
                    h8 = h8;
                    ((C02298y) mediaViewVideoRendererApi).A06(h8);
                    hh.A01 = C8N.A02(context);
                    hh.A00 = mediaViewVideoRenderer;
                    hh.A05 = new M6(hh.A01);
                    hh.A07 = hh.A04();
                    hh.A08 = hh.A05();
                    float f = KE.A01;
                    int i3 = (int) (2.0f * f);
                    int i4 = (int) (25.0f * f);
                    hh.A06 = new K6(hh.A01);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(9);
                    layoutParams.addRule(12);
                    hh.A06.setPadding(i3, i4, i4, i3);
                    hh.A06.setLayoutParams(layoutParams);
                    i2 = 0;
                    c = 6;
                case 6:
                    hh = hh;
                    c = i2 < hh.A00.getChildCount() ? (char) 7 : '\t';
                case 7:
                    hh = hh;
                    view = hh.A00.getChildAt(0);
                    c = view instanceof C0538Lc ? '\b' : (char) 14;
                case '\b':
                    hh = hh;
                    view = view;
                    hh.A04 = (C0538Lc) view;
                    c = '\t';
                case '\t':
                    hh = hh;
                    c = hh.A04 == null ? '\n' : '\r';
                case '\n':
                    c = AdInternalSettings.isDebugBuild() ? (char) 11 : '\f';
                case 11:
                    Log.e(A0G, A06(72, 36, 97));
                    c = '\f';
                case '\f':
                    HH hh2 = hh;
                    hh2.A08.A0X(0);
                    hh2.A08.A0Y(250);
                    h8.A8H();
                    return;
                case '\r':
                    hh = hh;
                    hh.A04.A0S(hh.A05);
                    hh.A04.A0S(hh.A06);
                    c = '\f';
                case 14:
                    i2++;
                    c = 6;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C02017w
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A09 = true;
        A0C();
    }

    @Override // com.facebook.ads.redexgen.X.C02017w
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A09 = false;
        A0C();
    }

    public final void onPrepared() {
        this.A00.setOnTouchListener(new HC(this));
        A0A();
    }

    @Override // com.facebook.ads.redexgen.X.C02017w
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        A0C();
    }

    @Override // com.facebook.ads.redexgen.X.C02017w
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        A0C();
    }
}
