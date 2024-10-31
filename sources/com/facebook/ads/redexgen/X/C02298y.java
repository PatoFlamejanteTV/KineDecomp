package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.NativeAd;
import com.facebook.ads.VideoAutoplayBehavior;
import com.facebook.ads.VideoStartReason;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdViewConstructorParams;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;

/* renamed from: com.facebook.ads.redexgen.X.8y, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02298y implements MediaViewVideoRendererApi {
    public static byte[] A0G;
    public static final String A0H;
    public MediaViewVideoRenderer A00;
    public VideoAutoplayBehavior A01;
    public C0362Ec A03;

    @Nullable
    public H8 A04;
    public C0538Lc A05;
    public boolean A06;
    public boolean A07;

    @Nullable
    public NativeAd A08;
    public final AbstractC02158k A0D = new AbstractC02158k() { // from class: com.facebook.ads.redexgen.X.8l
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C1S
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(QS qs) {
            MediaViewVideoRenderer mediaViewVideoRenderer;
            mediaViewVideoRenderer = C02298y.this.A00;
            mediaViewVideoRenderer.onPrepared();
        }
    };
    public final AbstractC02178m A0C = new AbstractC02178m() { // from class: com.facebook.ads.redexgen.X.8n
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C1S
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(QR qr) {
            MediaViewVideoRenderer mediaViewVideoRenderer;
            if (C02298y.this.A08 != null) {
                HX.A0J(C02298y.this.A08.getInternalNativeAd()).A1S(true, true);
            }
            mediaViewVideoRenderer = C02298y.this.A00;
            mediaViewVideoRenderer.onPlayed();
        }
    };
    public final AbstractC02198o A0B = new AbstractC02198o() { // from class: com.facebook.ads.redexgen.X.8p
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C1S
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(QQ qq) {
            MediaViewVideoRenderer mediaViewVideoRenderer;
            mediaViewVideoRenderer = C02298y.this.A00;
            mediaViewVideoRenderer.onPaused();
        }
    };
    public final AbstractC02218q A0E = new AbstractC02218q() { // from class: com.facebook.ads.redexgen.X.8r
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C1S
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(QU qu) {
            MediaViewVideoRenderer mediaViewVideoRenderer;
            mediaViewVideoRenderer = C02298y.this.A00;
            mediaViewVideoRenderer.onSeek();
        }
    };
    public final AbstractC02238s A09 = new AbstractC02238s() { // from class: com.facebook.ads.redexgen.X.8t
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C1S
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(QM qm) {
            MediaViewVideoRenderer mediaViewVideoRenderer;
            mediaViewVideoRenderer = C02298y.this.A00;
            mediaViewVideoRenderer.onCompleted();
        }
    };
    public final AbstractC02258u A0F = new AbstractC02258u() { // from class: com.facebook.ads.redexgen.X.8v
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C1S
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(QZ qz) {
            MediaViewVideoRenderer mediaViewVideoRenderer;
            mediaViewVideoRenderer = C02298y.this.A00;
            mediaViewVideoRenderer.onVolumeChanged();
        }
    };
    public final AbstractC02278w A0A = new AbstractC02278w() { // from class: com.facebook.ads.redexgen.X.8x
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C1S
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(QN qn) {
            MediaViewVideoRenderer mediaViewVideoRenderer;
            if (C02298y.this.A08 != null) {
                HX.A0J(C02298y.this.A08.getInternalNativeAd()).A1S(false, true);
            }
            mediaViewVideoRenderer = C02298y.this.A00;
            mediaViewVideoRenderer.onError();
        }
    };
    public C02017w A02 = new C02017w();

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C02298y.A0G
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
            int r0 = r0 + (-30)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02298y.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A0G = new byte[]{-68, -31, -23, -44, -33, -36, -41, -109, -55, -36, -40, -22, -109, -42, -30, -31, -26, -25, -27, -24, -42, -25, -30, -27, -109, -29, -44, -27, -44, -32, -26, -109, -25, -20, -29, -40, -95, -38, -33, -23, -37, -28, -35, -41, -35, -37, -55, -37, -37, -31, -106, -39, -41, -30, -30, -37, -38, -106, -19, -33, -22, -34, -27, -21, -22, -106, -37, -28, -35, -41, -35, -37, -55, -37, -37, -31, -92, 118, -120, -120, -114, -116, -111, -118, 67, -112, -104, -106, -105, 67, -123, -120, 67, -109, -107, -120, -122, -120, -121, -120, -121, 67, -123, -100, 67, -124, 67, -122, -124, -113, -113, 67, -105, -110, 67, -120, -111, -118, -124, -118, -120, 118, -120, -120, -114, 79, 67, -124, -111, -121, 67, -119, -110, -113, -113, -110, -102, -120, -121, 67, -123, -100, 67, -124, 67, -122, -124, -113, -113, 67, -105, -110, 67, -121, -116, -106, -120, -111, -118, -124, -118, -120, 118, -120, -120, -114, 81, -28, -19, -26, -32, -26, -28, -46, -28, -28, -22, -97, -30, -32, -21, -21, -28, -29, -97, -10, -24, -13, -25, -18, -12, -13, -97, -29, -24, -14, -28, -19, -26, -32, -26, -28, -46, -28, -28, -22, -83};
    }

    static {
        A02();
        A0H = MediaViewVideoRenderer.class.getSimpleName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03() {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            r3 = 0
            r2 = 0
            com.facebook.ads.MediaViewVideoRenderer r0 = r4.A00
            r0.pause(r3)
            com.facebook.ads.redexgen.X.Lc r0 = r4.A05
            r0.setClientToken(r2)
            com.facebook.ads.redexgen.X.Lc r0 = r4.A05
            r0.setVideoMPD(r2)
            com.facebook.ads.redexgen.X.Lc r1 = r4.A05
            r0 = r2
            android.net.Uri r0 = (android.net.Uri) r0
            r1.setVideoURI(r0)
            com.facebook.ads.redexgen.X.Lc r0 = r4.A05
            r0.setVideoCTA(r2)
            com.facebook.ads.redexgen.X.Lc r0 = r4.A05
            r0.setNativeAd(r2)
            com.facebook.ads.VideoAutoplayBehavior r0 = com.facebook.ads.VideoAutoplayBehavior.DEFAULT
            r4.A01 = r0
            com.facebook.ads.NativeAd r0 = r4.A08
            if (r0 == 0) goto L59
            r0 = 2
        L2f:
            switch(r0) {
                case 2: goto L33;
                case 3: goto L44;
                case 4: goto L50;
                case 5: goto L5b;
                default: goto L32;
            }
        L32:
            goto L2f
        L33:
            com.facebook.ads.redexgen.X.8y r4 = (com.facebook.ads.redexgen.X.C02298y) r4
            com.facebook.ads.NativeAd r0 = r4.A08
            com.facebook.ads.internal.api.NativeAdBaseApi r0 = r0.getInternalNativeAd()
            com.facebook.ads.redexgen.X.HX r0 = com.facebook.ads.redexgen.X.HX.A0J(r0)
            r0.A1S(r3, r3)
            r0 = 3
            goto L2f
        L44:
            com.facebook.ads.redexgen.X.8y r4 = (com.facebook.ads.redexgen.X.C02298y) r4
            r4.A08 = r2
            com.facebook.ads.redexgen.X.H8 r0 = r4.A04
            if (r0 == 0) goto L4e
            r0 = 4
            goto L2f
        L4e:
            r0 = 5
            goto L2f
        L50:
            com.facebook.ads.redexgen.X.8y r4 = (com.facebook.ads.redexgen.X.C02298y) r4
            com.facebook.ads.redexgen.X.H8 r0 = r4.A04
            r0.A8W()
            r0 = 5
            goto L2f
        L59:
            r0 = 3
            goto L2f
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02298y.A03():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A04(com.facebook.ads.NativeAd r6) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            r4.A08 = r6
            com.facebook.ads.internal.api.NativeAdBaseApi r0 = r6.getInternalNativeAd()
            com.facebook.ads.redexgen.X.HX r0 = (com.facebook.ads.redexgen.X.HX) r0
            com.facebook.ads.redexgen.X.Ec r1 = r0.A0v()
            com.facebook.ads.redexgen.X.Ec r0 = r4.A03
            r0.A0C(r1)
            com.facebook.ads.internal.api.NativeAdApi r3 = r6.getNativeAdApi()
            com.facebook.ads.redexgen.X.90 r3 = (com.facebook.ads.redexgen.X.AnonymousClass90) r3
            com.facebook.ads.redexgen.X.Lc r1 = r4.A05
            com.facebook.ads.internal.api.NativeAdBaseApi r0 = r6.getInternalNativeAd()
            com.facebook.ads.redexgen.X.HX r0 = com.facebook.ads.redexgen.X.HX.A0J(r0)
            java.lang.String r0 = r0.A13()
            r1.setClientToken(r0)
            com.facebook.ads.redexgen.X.Lc r1 = r4.A05
            java.lang.String r0 = r3.A01()
            r1.setVideoMPD(r0)
            com.facebook.ads.redexgen.X.Lc r1 = r4.A05
            java.lang.String r0 = r3.A02()
            r1.setVideoURI(r0)
            com.facebook.ads.internal.api.NativeAdBaseApi r0 = r6.getInternalNativeAd()
            com.facebook.ads.redexgen.X.HX r0 = com.facebook.ads.redexgen.X.HX.A0J(r0)
            com.facebook.ads.redexgen.X.1i r2 = r0.A0t()
            if (r2 == 0) goto L8c
            r0 = 2
        L4c:
            switch(r0) {
                case 2: goto L50;
                case 3: goto L5f;
                case 4: goto L81;
                case 5: goto L8e;
                default: goto L4f;
            }
        L4f:
            goto L4c
        L50:
            com.facebook.ads.redexgen.X.8y r4 = (com.facebook.ads.redexgen.X.C02298y) r4
            com.facebook.ads.redexgen.X.1i r2 = (com.facebook.ads.redexgen.X.C00371i) r2
            com.facebook.ads.redexgen.X.Lc r1 = r4.A05
            int r0 = r2.A0E()
            r1.setVideoProgressReportIntervalMs(r0)
            r0 = 3
            goto L4c
        L5f:
            com.facebook.ads.redexgen.X.8y r4 = (com.facebook.ads.redexgen.X.C02298y) r4
            com.facebook.ads.NativeAd r6 = (com.facebook.ads.NativeAd) r6
            com.facebook.ads.redexgen.X.90 r3 = (com.facebook.ads.redexgen.X.AnonymousClass90) r3
            com.facebook.ads.redexgen.X.Lc r1 = r4.A05
            java.lang.String r0 = r6.getAdCallToAction()
            r1.setVideoCTA(r0)
            com.facebook.ads.redexgen.X.Lc r0 = r4.A05
            r0.setNativeAd(r6)
            com.facebook.ads.VideoAutoplayBehavior r0 = r3.getVideoAutoplayBehavior()
            r4.A01 = r0
            com.facebook.ads.redexgen.X.H8 r0 = r4.A04
            if (r0 == 0) goto L7f
            r0 = 4
            goto L4c
        L7f:
            r0 = 5
            goto L4c
        L81:
            com.facebook.ads.redexgen.X.8y r4 = (com.facebook.ads.redexgen.X.C02298y) r4
            com.facebook.ads.NativeAd r6 = (com.facebook.ads.NativeAd) r6
            com.facebook.ads.redexgen.X.H8 r0 = r4.A04
            r0.A8J(r6)
            r0 = 5
            goto L4c
        L8c:
            r0 = 3
            goto L4c
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02298y.A04(com.facebook.ads.NativeAd):void");
    }

    public final void A05(InterfaceC0422Gl interfaceC0422Gl) {
        this.A05.setAdEventManager(interfaceC0422Gl);
    }

    public final void A06(@Nullable H8 h8) {
        this.A04 = h8;
    }

    public final void A07(@Nullable InterfaceC02118g interfaceC02118g) {
        this.A05.setListener(interfaceC02118g);
    }

    public final void destroy() {
        this.A05.A0K();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void disengageSeek(com.facebook.ads.VideoStartReason r6) {
        /*
            r5 = this;
            r4 = r5
            boolean r0 = r4.A06
            if (r0 != 0) goto L40
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L42;
                case 4: goto L1b;
                case 5: goto L28;
                case 6: goto L37;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            java.lang.String r3 = com.facebook.ads.redexgen.X.C02298y.A0H
            r2 = 37
            r1 = 40
            r0 = 88
            java.lang.String r0 = A01(r2, r1, r0)
            android.util.Log.w(r3, r0)
            r0 = 3
            goto L6
        L1b:
            com.facebook.ads.redexgen.X.8y r4 = (com.facebook.ads.redexgen.X.C02298y) r4
            r0 = 0
            r4.A06 = r0
            boolean r0 = r4.A07
            if (r0 == 0) goto L26
            r0 = 5
            goto L6
        L26:
            r0 = 6
            goto L6
        L28:
            com.facebook.ads.redexgen.X.8y r4 = (com.facebook.ads.redexgen.X.C02298y) r4
            com.facebook.ads.VideoStartReason r6 = (com.facebook.ads.VideoStartReason) r6
            com.facebook.ads.redexgen.X.Lc r1 = r4.A05
            com.facebook.ads.redexgen.X.QH r0 = com.facebook.ads.redexgen.X.QH.A00(r6)
            r1.A0Q(r0)
            r0 = 6
            goto L6
        L37:
            com.facebook.ads.redexgen.X.8y r4 = (com.facebook.ads.redexgen.X.C02298y) r4
            com.facebook.ads.MediaViewVideoRenderer r0 = r4.A00
            r0.onSeekDisengaged()
            r0 = 3
            goto L6
        L40:
            r0 = 4
            goto L6
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02298y.disengageSeek(com.facebook.ads.VideoStartReason):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void engageSeek() {
        /*
            r5 = this;
            r4 = r5
            boolean r0 = r4.A06
            if (r0 == 0) goto L3b
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L3d;
                case 4: goto L1b;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            java.lang.String r3 = com.facebook.ads.redexgen.X.C02298y.A0H
            r2 = 167(0xa7, float:2.34E-43)
            r1 = 40
            r0 = 97
            java.lang.String r0 = A01(r2, r1, r0)
            android.util.Log.w(r3, r0)
            r0 = 3
            goto L6
        L1b:
            com.facebook.ads.redexgen.X.8y r4 = (com.facebook.ads.redexgen.X.C02298y) r4
            r0 = 1
            r4.A06 = r0
            com.facebook.ads.redexgen.X.FR r1 = com.facebook.ads.redexgen.X.FR.A0A
            com.facebook.ads.redexgen.X.Lc r0 = r4.A05
            com.facebook.ads.redexgen.X.FR r0 = r0.getState()
            boolean r0 = r1.equals(r0)
            r4.A07 = r0
            com.facebook.ads.redexgen.X.Lc r1 = r4.A05
            r0 = 0
            r1.A0U(r0)
            com.facebook.ads.MediaViewVideoRenderer r0 = r4.A00
            r0.onSeekEngaged()
            r0 = 3
            goto L6
        L3b:
            r0 = 4
            goto L6
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02298y.engageSeek():void");
    }

    public final AdComponentViewApi getAdComponentViewApi() {
        return this.A02;
    }

    @IntRange(from = 0)
    public final int getCurrentTimeMs() {
        return this.A05.getCurrentPositionInMillis();
    }

    @IntRange(from = 0)
    public final int getDuration() {
        return this.A05.getDuration();
    }

    public final View getVideoView() {
        return this.A05.getVideoView();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getVolume() {
        return this.A05.getVolume();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0010. Please report as an issue. */
    public final void initialize(AdViewConstructorParams adViewConstructorParams, MediaViewVideoRenderer mediaViewVideoRenderer) {
        C02298y c02298y = this;
        C0362Ec c0362Ec = null;
        c02298y.A00 = mediaViewVideoRenderer;
        Context context = adViewConstructorParams.getContext();
        char c = context instanceof C0362Ec ? (char) 2 : (char) 5;
        while (true) {
            switch (c) {
                case 2:
                    context = context;
                    c0362Ec = (C0362Ec) context;
                    c = 3;
                case 3:
                    c02298y = c02298y;
                    adViewConstructorParams = adViewConstructorParams;
                    c0362Ec = c0362Ec;
                    c02298y.A03 = c0362Ec;
                    switch (adViewConstructorParams.getInitializationType()) {
                        case 0:
                            c = '\t';
                            break;
                        case 1:
                            c = '\b';
                            break;
                        case 2:
                            c = 7;
                            break;
                        case 3:
                            c = 6;
                            break;
                        default:
                            c = 4;
                            break;
                    }
                case 4:
                    throw new IllegalArgumentException(A01(0, 37, 85));
                case 5:
                    context = context;
                    c0362Ec = C8N.A02(context);
                    c = 3;
                case 6:
                    c02298y = c02298y;
                    adViewConstructorParams = adViewConstructorParams;
                    c0362Ec = c0362Ec;
                    c02298y.A05 = new C0538Lc(c0362Ec, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleRes());
                    c = '\n';
                case 7:
                    c02298y = c02298y;
                    adViewConstructorParams = adViewConstructorParams;
                    c0362Ec = c0362Ec;
                    c02298y.A05 = new C0538Lc(c0362Ec, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleAttr());
                    c = '\n';
                case '\b':
                    c02298y = c02298y;
                    adViewConstructorParams = adViewConstructorParams;
                    c0362Ec = c0362Ec;
                    c02298y.A05 = new C0538Lc(c0362Ec, adViewConstructorParams.getAttributeSet());
                    c = '\n';
                case '\t':
                    c02298y = c02298y;
                    c0362Ec = c0362Ec;
                    c02298y.A05 = new C0538Lc(c0362Ec);
                    c = '\n';
                case '\n':
                    C02298y c02298y2 = c02298y;
                    c02298y2.A05.setEnableBackgroundVideo(mediaViewVideoRenderer.shouldAllowBackgroundPlayback());
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    c02298y2.A05.setLayoutParams(layoutParams);
                    c02298y2.A02.addView(c02298y2.A05, -1, layoutParams);
                    EnumC0489Je.A04(c02298y2.A05, EnumC0489Je.A0A);
                    c02298y2.A05.getEventBus().A03(c02298y2.A0D, c02298y2.A0C, c02298y2.A0B, c02298y2.A0E, c02298y2.A09, c02298y2.A0F, c02298y2.A0A);
                    return;
            }
        }
    }

    public final void pause(boolean z) {
        this.A05.A0U(z);
    }

    public final void play(VideoStartReason videoStartReason) {
        this.A05.A0Q(QH.A00(videoStartReason));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void seekTo(@android.support.annotation.IntRange(from = 0) int r6) {
        /*
            r5 = this;
            r4 = r5
            boolean r0 = r4.A06
            if (r0 != 0) goto L23
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L25;
                case 4: goto L1a;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            java.lang.String r3 = com.facebook.ads.redexgen.X.C02298y.A0H
            r2 = 77
            r1 = 90
            r0 = 5
            java.lang.String r0 = A01(r2, r1, r0)
            android.util.Log.w(r3, r0)
            r0 = 3
            goto L6
        L1a:
            com.facebook.ads.redexgen.X.8y r4 = (com.facebook.ads.redexgen.X.C02298y) r4
            com.facebook.ads.redexgen.X.Lc r0 = r4.A05
            r0.A0O(r6)
            r0 = 3
            goto L6
        L23:
            r0 = 4
            goto L6
        L25:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02298y.seekTo(int):void");
    }

    public final void setVolume(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.A05.setVolume(f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0039, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean shouldAutoplay() {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r2 = 0
            com.facebook.ads.redexgen.X.Lc r0 = r3.A05
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
            com.facebook.ads.redexgen.X.8y r3 = (com.facebook.ads.redexgen.X.C02298y) r3
            com.facebook.ads.redexgen.X.Lc r0 = r3.A05
            com.facebook.ads.redexgen.X.FR r1 = r0.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A06
            if (r1 != r0) goto L1a
            r0 = 3
            goto L8
        L1a:
            r0 = 4
            goto L8
        L1c:
            com.facebook.ads.redexgen.X.8y r3 = (com.facebook.ads.redexgen.X.C02298y) r3
            com.facebook.ads.VideoAutoplayBehavior r1 = r3.A01
            com.facebook.ads.VideoAutoplayBehavior r0 = com.facebook.ads.VideoAutoplayBehavior.ON
            if (r1 == r0) goto L26
            r0 = 5
            goto L8
        L26:
            r0 = 6
            goto L8
        L28:
            com.facebook.ads.redexgen.X.8y r3 = (com.facebook.ads.redexgen.X.C02298y) r3
            com.facebook.ads.VideoAutoplayBehavior r1 = r3.A01
            com.facebook.ads.VideoAutoplayBehavior r0 = com.facebook.ads.VideoAutoplayBehavior.DEFAULT
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02298y.shouldAutoplay():boolean");
    }
}
