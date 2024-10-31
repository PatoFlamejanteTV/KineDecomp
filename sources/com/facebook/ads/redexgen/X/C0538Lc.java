package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import java.util.UUID;

/* renamed from: com.facebook.ads.redexgen.X.Lc, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0538Lc extends C0537Lb {
    public static byte[] A0E;
    public static final String A0F;

    @Nullable
    public Uri A00;

    @Nullable
    public NativeAd A01;
    public InterfaceC0422Gl A02;

    @Nullable
    public InterfaceC02118g A03;

    @Nullable
    public QA A04;

    @Nullable
    public String A05;

    @Nullable
    public String A06;

    @Nullable
    public String A07;
    public final AnonymousClass28 A08;
    public final C0362Ec A09;
    public final AbstractC02238s A0A;
    public final AbstractC02198o A0B;
    public final AbstractC02178m A0C;
    public final String A0D;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0A(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0538Lc.A0E
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
            int r0 = r0 - r4
            int r0 = r0 + (-14)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0538Lc.A0A(int, int, int):java.lang.String");
    }

    public static void A0C() {
        A0E = new byte[]{-67, -80, -85, -84, -74, -90, -69, -80, -76, -84, -90, -73, -74, -77, -77, -80, -75, -82, -90, -80, -75, -69, -84, -71, -67, -88, -77, -110, -80, -67, 118, -61, 111, -62, -61, -80, -63, -61, 111, -112, -60, -77, -72, -76, -67, -78, -76, -99, -76, -61, -58, -66, -63, -70, -112, -78, -61, -72, -59, -72, -61, -56, 125, 111, -100, -80, -70, -76, 111, -62, -60, -63, -76, 111, -61, -73, -80, -61, 111, -72, -61, 118, -62, 111, -72, -67, 111, -56, -66, -60, -63, 111, -112, -67, -77, -63, -66, -72, -77, -100, -80, -67, -72, -75, -76, -62, -61, 125, -57, -68, -69, 111, -75, -72, -69, -76, 125, -59, -63, -64, -12, -29, -24, -28, -19, -30, -28, -51, -28, -13, -10, -18, -15, -22, -68, -55, -70, -68, -66, -49, -60, -47, -60, -49, -44, -28, -41, -45, -27, -62, -25, -34, -45, -71, -84, -89, -88, -78, -113, -78, -86, -86, -88, -75, -28, -43, -26, -25, -35, -30, -37, -52, -12, -14, -13, -97, -14, -28, -13, -43, -24, -29, -28, -18, -44, -47, -56, -97, -18, -15, -97, -14, -28, -13, -43, -24, -29, -28, -18, -52, -49, -61, -97, -27, -24, -15, -14, -13, -68, -28, -30, -29, -113, -30, -44, -29, -78, -37, -40, -44, -35, -29, -61, -34, -38, -44, -35, -113, -43, -40, -31, -30, -29, -70, -68, -81, -82, -81, -80, -77, -72, -81, -82, -103, -68, -77, -81, -72, -66, -85, -66, -77, -71, -72, -107, -81, -61, -90, -97, -102, -94, -90, -106, 122, -107, -59, -72, -77, -76, -66, -100, -97, -109, -114, -127, 124, 125, -121, 109, 106, 100, -52, -7, -7, -10, -7, -63, -89, -124, -126, 116, 93, 112, -125, 120, -123, 116, 82, -125, 112, 81, -124, -125, -125, 126, 125, -35, -26, -29, -33, -24, -18, -50, -23, -27, -33, -24, -36, -49, -54, -53, -43, -71, -53, -53, -47, -70, -49, -45, -53};
    }

    static {
        A0C();
        A0F = C0538Lc.class.getSimpleName();
    }

    public C0538Lc(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A0D = UUID.randomUUID().toString();
        this.A0C = new LV(this);
        this.A0B = new LW(this);
        this.A0A = new LX(this);
        this.A08 = new AnonymousClass28(this, c0362Ec);
        this.A09 = c0362Ec;
        A0B();
    }

    public C0538Lc(C0362Ec c0362Ec, AttributeSet attributeSet) {
        super(c0362Ec, attributeSet);
        this.A0D = UUID.randomUUID().toString();
        this.A0C = new LV(this);
        this.A0B = new LW(this);
        this.A0A = new LX(this);
        this.A08 = new AnonymousClass28(this, c0362Ec);
        this.A09 = c0362Ec;
        A0B();
    }

    public C0538Lc(C0362Ec c0362Ec, AttributeSet attributeSet, int i) {
        super(c0362Ec, attributeSet, i);
        this.A0D = UUID.randomUUID().toString();
        this.A0C = new LV(this);
        this.A0B = new LW(this);
        this.A0A = new LX(this);
        this.A08 = new AnonymousClass28(this, c0362Ec);
        this.A09 = c0362Ec;
        A0B();
    }

    private void A0B() {
        getEventBus().A03(this.A0C, this.A0B, this.A0A);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0116, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0F(android.content.Intent r7) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0538Lc.A0F(android.content.Intent):void");
    }

    private void A0G(String str) {
        C0511Kb.A06(this.A09, A0A(164, 7, 102), C0512Kc.A1X, new C0514Ke(AdErrorType.PARSER_FAILURE.getDefaultErrorMessage(), A0A(281, 7, 121) + str));
        if (AdInternalSettings.isDebugBuild()) {
            Log.w(A0F, str);
        }
    }

    public final void A0c() {
        if (this.A01 != null) {
            this.A01.onCtaBroadcast();
        }
    }

    public final void A0d() {
        AdActivityIntent A04 = JI.A04(this.A09);
        A0F(A04);
        try {
            A0U(false);
            setVisibility(8);
            JI.A09(this.A09, A04);
        } catch (Exception e) {
            C0511Kb.A06(this.A09, A0A(134, 11, 77), C0512Kc.A05, new C0514Ke(e));
            Log.e(A0A(117, 17, 113), A0A(27, 90, 65), e);
        }
    }

    @Nullable
    public InterfaceC02118g getListener() {
        return this.A03;
    }

    public String getUniqueId() {
        return this.A0D;
    }

    @Override // com.facebook.ads.redexgen.X.C0537Lb, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A08.A02();
    }

    @Override // com.facebook.ads.redexgen.X.C0537Lb, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.A08.A03();
        super.onDetachedFromWindow();
    }

    public void setAdEventManager(InterfaceC0422Gl interfaceC0422Gl) {
        this.A02 = interfaceC0422Gl;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0034, code lost:            r3.A04 = r2;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0038, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setClientToken(@android.support.annotation.Nullable java.lang.String r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.QA r0 = r3.A04
            if (r0 == 0) goto L32
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L14;
                case 4: goto L23;
                case 5: goto L34;
                case 6: goto L20;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.Lc r3 = (com.facebook.ads.redexgen.X.C0538Lc) r3
            com.facebook.ads.redexgen.X.QA r0 = r3.A04
            r0.A0R()
            r0 = 3
            goto L7
        L14:
            com.facebook.ads.redexgen.X.Lc r3 = (com.facebook.ads.redexgen.X.C0538Lc) r3
            java.lang.String r5 = (java.lang.String) r5
            r3.A05 = r5
            if (r5 == 0) goto L1e
            r0 = 4
            goto L7
        L1e:
            r0 = 6
            goto L7
        L20:
            r2 = 0
            r0 = 5
            goto L7
        L23:
            com.facebook.ads.redexgen.X.Lc r3 = (com.facebook.ads.redexgen.X.C0538Lc) r3
            java.lang.String r5 = (java.lang.String) r5
            com.facebook.ads.redexgen.X.QA r2 = new com.facebook.ads.redexgen.X.QA
            com.facebook.ads.redexgen.X.Ec r1 = r3.A09
            com.facebook.ads.redexgen.X.Gl r0 = r3.A02
            r2.<init>(r1, r0, r3, r5)
            r0 = 5
            goto L7
        L32:
            r0 = 3
            goto L7
        L34:
            com.facebook.ads.redexgen.X.Lc r3 = (com.facebook.ads.redexgen.X.C0538Lc) r3
            r3.A04 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0538Lc.setClientToken(java.lang.String):void");
    }

    public void setEnableBackgroundVideo(boolean z) {
        super.A0D.setBackgroundPlaybackEnabled(z);
    }

    public void setListener(@Nullable InterfaceC02118g interfaceC02118g) {
        this.A03 = interfaceC02118g;
    }

    public void setNativeAd(@Nullable NativeAd nativeAd) {
        this.A01 = nativeAd;
    }

    public void setVideoCTA(@Nullable String str) {
        this.A06 = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C0537Lb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setVideoMPD(@android.support.annotation.Nullable java.lang.String r5) {
        /*
            r4 = this;
            r3 = r4
            if (r5 == 0) goto L2e
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L1d;
                case 4: goto L30;
                case 5: goto L12;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.Lc r3 = (com.facebook.ads.redexgen.X.C0538Lc) r3
            com.facebook.ads.redexgen.X.QA r0 = r3.A04
            if (r0 != 0) goto L10
            r0 = 3
            goto L4
        L10:
            r0 = 5
            goto L4
        L12:
            com.facebook.ads.redexgen.X.Lc r3 = (com.facebook.ads.redexgen.X.C0538Lc) r3
            java.lang.String r5 = (java.lang.String) r5
            r3.A07 = r5
            super.setVideoMPD(r5)
            r0 = 4
            goto L4
        L1d:
            com.facebook.ads.redexgen.X.Lc r3 = (com.facebook.ads.redexgen.X.C0538Lc) r3
            r2 = 208(0xd0, float:2.91E-43)
            r1 = 25
            r0 = 97
            java.lang.String r0 = A0A(r2, r1, r0)
            r3.A0G(r0)
            r0 = 4
            goto L4
        L2e:
            r0 = 5
            goto L4
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0538Lc.setVideoMPD(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C0537Lb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setVideoURI(@android.support.annotation.Nullable android.net.Uri r5) {
        /*
            r4 = this;
            r3 = r4
            if (r5 == 0) goto L2e
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L12;
                case 4: goto L30;
                case 5: goto L23;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.Lc r3 = (com.facebook.ads.redexgen.X.C0538Lc) r3
            com.facebook.ads.redexgen.X.QA r0 = r3.A04
            if (r0 != 0) goto L10
            r0 = 3
            goto L4
        L10:
            r0 = 5
            goto L4
        L12:
            com.facebook.ads.redexgen.X.Lc r3 = (com.facebook.ads.redexgen.X.C0538Lc) r3
            r2 = 208(0xd0, float:2.91E-43)
            r1 = 25
            r0 = 97
            java.lang.String r0 = A0A(r2, r1, r0)
            r3.A0G(r0)
            r0 = 4
            goto L4
        L23:
            com.facebook.ads.redexgen.X.Lc r3 = (com.facebook.ads.redexgen.X.C0538Lc) r3
            android.net.Uri r5 = (android.net.Uri) r5
            r3.A00 = r5
            super.setVideoURI(r5)
            r0 = 4
            goto L4
        L2e:
            r0 = 5
            goto L4
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0538Lc.setVideoURI(android.net.Uri):void");
    }
}
