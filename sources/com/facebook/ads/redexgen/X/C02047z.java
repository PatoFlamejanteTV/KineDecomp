package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.7z, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02047z implements AdViewApi {
    public static byte[] A0D;
    public long A00;

    @Nullable
    public View A01;

    @Nullable
    public AdListener A02;

    @Nullable
    public AnonymousClass36 A03;
    public NQ A04;

    @Nullable
    public String A05;

    @Nullable
    public String A06;
    public final DisplayMetrics A07;
    public final AdView A08;
    public final AdViewParentApi A09;
    public final C0364Ee A0A;
    public final EnumC0457Hw A0B;
    public final String A0C;

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C02047z.A0D
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
            r0 = r0 ^ 126(0x7e, float:1.77E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02047z.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A0D = new byte[]{116, 119, 121, 124, 89, 124, 89, 11, 81, 88, 10, 12, 10, 12, 5, 38, 41, 41, 34, 53, 103, 38, 35, 103, 35, 34, 52, 51, 53, 40, 62, 34, 35, 32, 2, 13, 13, 12, 23, 67, 5, 10, 13, 7, 67, 2, 67, 23, 6, 14, 19, 15, 2, 23, 6, 67, 23, 11, 2, 23, 67, 15, 12, 2, 7, 67, 1, 10, 7, 67, 68, 70, 16, 68, 28, 25, 46, 20, 7, 24, 81, 82, 92, 89, 124, 89, 123, 79, 82, 80, Byte.MAX_VALUE, 84, 89, 39, 116, 37, 37, 119, 33, 39, 114, 49, 48, 38, 33, 39, 58, 44, 119, 112, 117, 116, 114, 32, 32, 39, 106, 73, 70, 70, 77, 90, 8, 73, 76, 8, 68, 71, 73, 76, 8, 90, 77, 89, 93, 77, 91, 92, 77, 76, 87, 5, 7, 2, 5, 81, 5, 87};
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    public C02047z(Context context, String str, AdSize adSize, AdViewParentApi adViewParentApi, AdView adView) {
        this.A00 = -1L;
        if (adSize == null || adSize == AdSize.INTERSTITIAL) {
            throw new IllegalArgumentException(A01(74, 6, 3));
        }
        this.A07 = adView.getContext().getResources().getDisplayMetrics();
        this.A0B = EnumC0457Hw.A02(adSize);
        this.A0C = str;
        this.A09 = adViewParentApi;
        this.A08 = adView;
        this.A0A = C8N.A06(context);
        this.A0A.A08().A2g(AdPlacementType.BANNER.toString());
        AnonymousClass31 anonymousClass31 = new AnonymousClass31(str, C0460Hz.A02(this.A0B), AdPlacementType.BANNER, EnumC0457Hw.A02(adSize), 1);
        anonymousClass31.A05(this.A05);
        anonymousClass31.A06(this.A06);
        this.A03 = new AnonymousClass36(this.A0A, anonymousClass31);
        this.A03.A0E(new C8I(this));
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    public C02047z(Context context, String str, String str2, AdViewParentApi adViewParentApi, AdView adView) throws C0454Hs {
        this(context, str, A00(str2), adViewParentApi, adView);
        this.A0A.A08().A3N();
    }

    public static AdSize A00(String str) throws C0454Hs {
        EnumC0458Hx A00 = I2.A00(str);
        if (A00 == null) {
            throw new C0454Hs(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A01(33, 41, 29), str));
        }
        I2.A03(A00);
        return C0460Hz.A00(A00);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:            r2.A0A.A0E().A2b();     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A03(@android.support.annotation.Nullable java.lang.String r4) {
        /*
            r3 = this;
            r2 = r3
            long r0 = java.lang.System.currentTimeMillis()
            r2.A00 = r0
            if (r4 != 0) goto L3d
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1b;
                case 4: goto L25;
                case 5: goto L3f;
                case 6: goto L30;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.7z r2 = (com.facebook.ads.redexgen.X.C02047z) r2
            com.facebook.ads.redexgen.X.Ee r0 = r2.A0A
            com.facebook.ads.redexgen.X.0d r0 = r0.A08()
            r0.A2d()
            r0 = 3
            goto La
        L1b:
            com.facebook.ads.redexgen.X.7z r2 = (com.facebook.ads.redexgen.X.C02047z) r2
            com.facebook.ads.redexgen.X.36 r0 = r2.A03
            if (r0 == 0) goto L23
            r0 = 4
            goto La
        L23:
            r0 = 5
            goto La
        L25:
            com.facebook.ads.redexgen.X.7z r2 = (com.facebook.ads.redexgen.X.C02047z) r2
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.redexgen.X.36 r0 = r2.A03
            r0.A0G(r4)
            r0 = 5
            goto La
        L30:
            com.facebook.ads.redexgen.X.7z r2 = (com.facebook.ads.redexgen.X.C02047z) r2
            com.facebook.ads.redexgen.X.Ee r0 = r2.A0A
            com.facebook.ads.redexgen.X.0d r0 = r0.A08()
            r0.A2c()
            r0 = 3
            goto La
        L3d:
            r0 = 6
            goto La
        L3f:
            com.facebook.ads.redexgen.X.7z r2 = (com.facebook.ads.redexgen.X.C02047z) r2
            com.facebook.ads.redexgen.X.Ee r0 = r2.A0A
            com.facebook.ads.redexgen.X.0d r0 = r0.A08()
            r0.A2b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02047z.A03(java.lang.String):void");
    }

    public final long A04() {
        return this.A00;
    }

    public final DisplayMetrics A05() {
        return this.A07;
    }

    @Nullable
    public final AdListener A06() {
        return this.A02;
    }

    public final AdView A07() {
        return this.A08;
    }

    @Nullable
    public final AnonymousClass36 A08() {
        return this.A03;
    }

    public final C0364Ee A09() {
        return this.A0A;
    }

    public final EnumC0457Hw A0A() {
        return this.A0B;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0052, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0B(android.widget.RelativeLayout r8, android.view.View r9) {
        /*
            r7 = this;
            r5 = r7
            r6 = 0
            r4 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ee r0 = r5.A0A
            com.facebook.ads.redexgen.X.0d r3 = r0.A08()
            java.lang.String r0 = r5.A06
            if (r0 == 0) goto L50
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L3d;
                case 3: goto L2e;
                case 4: goto L40;
                case 5: goto L13;
                case 6: goto L52;
                case 7: goto L2b;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            android.view.View r9 = (android.view.View) r9
            com.facebook.ads.redexgen.X.PU r6 = (com.facebook.ads.redexgen.X.PU) r6
            android.view.ViewGroup$LayoutParams r0 = r9.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            int r1 = r0.width
            int r0 = r0.height
            r2.<init>(r1, r0)
            r8.addView(r6, r2)
            r0 = 6
            goto Lf
        L2b:
            r4 = 0
            r0 = 3
            goto Lf
        L2e:
            com.facebook.ads.redexgen.X.7z r5 = (com.facebook.ads.redexgen.X.C02047z) r5
            com.facebook.ads.redexgen.X.0d r3 = (com.facebook.ads.redexgen.X.InterfaceC00060d) r3
            r3.A3a(r4)
            java.lang.String r0 = r5.A06
            if (r0 == 0) goto L3b
            r0 = 4
            goto Lf
        L3b:
            r0 = 6
            goto Lf
        L3d:
            r4 = 1
            r0 = 3
            goto Lf
        L40:
            com.facebook.ads.redexgen.X.7z r5 = (com.facebook.ads.redexgen.X.C02047z) r5
            com.facebook.ads.redexgen.X.Ee r1 = r5.A0A
            java.lang.String r0 = r5.A06
            com.facebook.ads.redexgen.X.PU r6 = com.facebook.ads.redexgen.X.PT.A01(r1, r0)
            if (r6 == 0) goto L4e
            r0 = 5
            goto Lf
        L4e:
            r0 = 6
            goto Lf
        L50:
            r0 = 7
            goto Lf
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02047z.A0B(android.widget.RelativeLayout, android.view.View):void");
    }

    public final void A0C(NQ nq) {
        this.A04 = nq;
    }

    public final AdView.AdViewLoadConfigBuilder buildLoadAdConfig() {
        return new H3(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x008c, code lost:            r3 = r3;        r3.A08.removeAllViews();        r3.A01 = r2;        r3.A02 = r2;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0097, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void destroy() {
        /*
            r7 = this;
            r3 = r7
            r0 = 0
            r2 = 0
            r4 = 101(0x65, float:1.42E-43)
            r1 = 7
            r0 = 43
            java.lang.String r6 = A01(r4, r1, r0)
            r4 = 14
            r1 = 19
            r0 = 57
            java.lang.String r5 = A01(r4, r1, r0)
            r4 = 6
            r1 = 8
            r0 = 22
            java.lang.String r0 = A01(r4, r1, r0)
            com.facebook.ads.redexgen.X.I5.A05(r6, r5, r0)
            com.facebook.ads.redexgen.X.Ee r0 = r3.A0A
            com.facebook.ads.redexgen.X.0d r0 = r0.A08()
            r0.A2h()
            com.facebook.ads.redexgen.X.36 r0 = r3.A03
            if (r0 == 0) goto L8a
            r0 = 2
        L30:
            switch(r0) {
                case 2: goto L62;
                case 3: goto L6f;
                case 4: goto L47;
                case 5: goto L34;
                case 6: goto L52;
                case 7: goto L7a;
                case 8: goto L8c;
                default: goto L33;
            }
        L33:
            goto L30
        L34:
            com.facebook.ads.redexgen.X.7z r3 = (com.facebook.ads.redexgen.X.C02047z) r3
            com.facebook.ads.AdView r0 = r3.A08
            android.content.Context r0 = r0.getContext()
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0d(r0)
            if (r0 == 0) goto L44
            r0 = 6
            goto L30
        L44:
            r0 = 8
            goto L30
        L47:
            com.facebook.ads.redexgen.X.7z r3 = (com.facebook.ads.redexgen.X.C02047z) r3
            com.facebook.ads.redexgen.X.NQ r0 = r3.A04
            if (r0 == 0) goto L4f
            r0 = 5
            goto L30
        L4f:
            r0 = 8
            goto L30
        L52:
            com.facebook.ads.redexgen.X.7z r3 = (com.facebook.ads.redexgen.X.C02047z) r3
            com.facebook.ads.redexgen.X.NQ r0 = r3.A04
            r0.A07()
            android.view.View r0 = r3.A01
            if (r0 == 0) goto L5f
            r0 = 7
            goto L30
        L5f:
            r0 = 8
            goto L30
        L62:
            com.facebook.ads.redexgen.X.7z r3 = (com.facebook.ads.redexgen.X.C02047z) r3
            r2 = 0
            com.facebook.ads.redexgen.X.36 r1 = r3.A03
            r0 = 1
            r1.A0I(r0)
            r3.A03 = r2
            r0 = 3
            goto L30
        L6f:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 18
            if (r1 < r0) goto L77
            r0 = 4
            goto L30
        L77:
            r0 = 8
            goto L30
        L7a:
            com.facebook.ads.redexgen.X.7z r3 = (com.facebook.ads.redexgen.X.C02047z) r3
            android.view.View r0 = r3.A01
            android.view.ViewOverlay r1 = r0.getOverlay()
            com.facebook.ads.redexgen.X.NQ r0 = r3.A04
            r1.remove(r0)
            r0 = 8
            goto L30
        L8a:
            r0 = 3
            goto L30
        L8c:
            com.facebook.ads.redexgen.X.7z r3 = (com.facebook.ads.redexgen.X.C02047z) r3
            com.facebook.ads.AdView r0 = r3.A08
            r0.removeAllViews()
            r3.A01 = r2
            r3.A02 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02047z.destroy():void");
    }

    public final String getPlacementId() {
        return this.A0C;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isAdInvalidated() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.36 r0 = r2.A03
            if (r0 == 0) goto L1f
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L19;
                case 4: goto L21;
                case 5: goto L1c;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.7z r2 = (com.facebook.ads.redexgen.X.C02047z) r2
            com.facebook.ads.redexgen.X.36 r0 = r2.A03
            boolean r0 = r0.A0J()
            if (r0 == 0) goto L17
            r0 = 3
            goto L7
        L17:
            r0 = 5
            goto L7
        L19:
            r1 = 1
            r0 = 4
            goto L7
        L1c:
            r1 = 0
            r0 = 4
            goto L7
        L1f:
            r0 = 3
            goto L7
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02047z.isAdInvalidated():boolean");
    }

    public final void loadAd() {
        I5.A05(A01(0, 6, 102), A01(116, 24, 86), A01(140, 8, 24));
        A03(null);
    }

    public final void loadAd(AdView.AdViewLoadConfig adViewLoadConfig) {
        I5.A05(A01(0, 6, 102), A01(116, 24, 86), A01(108, 8, 58));
        A03(((H3) adViewLoadConfig).A00());
    }

    @Deprecated
    public final void loadAdFromBid(String str) {
        I5.A05(A01(80, 13, 67), A01(116, 24, 86), A01(93, 8, 111));
        A03(str);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        this.A09.onConfigurationChanged(configuration);
        if (this.A01 != null) {
            C0460Hz.A03(this.A07, this.A01, this.A0B);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0017, code lost:            r1.A2Z(r2);        r3.A02 = r4;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setAdListener(@android.support.annotation.Nullable com.facebook.ads.AdListener r4) {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ee r0 = r3.A0A
            com.facebook.ads.redexgen.X.0d r1 = r0.A08()
            if (r4 == 0) goto L15
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L17;
                case 4: goto L12;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            r2 = 1
            r0 = 3
            goto Lb
        L12:
            r2 = 0
            r0 = 3
            goto Lb
        L15:
            r0 = 4
            goto Lb
        L17:
            r0 = r3
            com.facebook.ads.redexgen.X.7z r0 = (com.facebook.ads.redexgen.X.C02047z) r0
            com.facebook.ads.AdListener r4 = (com.facebook.ads.AdListener) r4
            com.facebook.ads.redexgen.X.0d r1 = (com.facebook.ads.redexgen.X.InterfaceC00060d) r1
            r1.A2Z(r2)
            r0.A02 = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02047z.setAdListener(com.facebook.ads.AdListener):void");
    }

    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        this.A05 = extraHints.getHints();
        this.A06 = extraHints.getMediationData();
    }
}
