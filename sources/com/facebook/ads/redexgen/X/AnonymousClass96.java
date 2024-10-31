package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.internal.api.NativeAdsManagerApi;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.96, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass96 implements NativeAdsManagerApi {
    public static byte[] A0A;
    public static final String A0B;
    public NativeAdsManager.Listener A01;
    public C3N A02;
    public String A03;
    public final int A06;
    public final C0362Ec A07;
    public final String A08;
    public final List<NativeAd> A09;
    public int A00 = -1;
    public boolean A04 = false;
    public boolean A05 = false;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass96.A0A
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
            r0 = r0 ^ 77
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass96.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A0A = new byte[]{76, 107, 99, 102, 111, 110, 42, 126, 101, 42, 99, 100, 99, 126, 99, 107, 102, 99, 112, 111, 42, 73, 101, 101, 97, 99, 111, 71, 107, 100, 107, 109, 111, 120, 36};
    }

    static {
        A01();
        A0B = NativeAdsManager.class.getSimpleName();
    }

    @SuppressLint({"CatchGeneralException"})
    public AnonymousClass96(Context context, String str, int i) {
        this.A07 = C8N.A02(context);
        this.A08 = str;
        this.A06 = Math.max(i, 0);
        this.A09 = new ArrayList(i);
        try {
            CookieManager.getInstance();
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(context);
            }
        } catch (Exception e) {
            Log.w(A0B, A00(0, 35, 71), e);
        }
    }

    public final NativeAdsManager.Listener A02() {
        return this.A01;
    }

    public final C3N A03() {
        return this.A02;
    }

    public final void A04() {
        this.A09.clear();
    }

    public final void A05(int i) {
        this.A00 = i;
    }

    public final void A06(NativeAd nativeAd) {
        this.A09.add(nativeAd);
    }

    public final void A07(boolean z) {
        this.A04 = z;
    }

    public final void disableAutoRefresh() {
        this.A05 = true;
        if (this.A02 != null) {
            this.A02.A06();
        }
    }

    public final int getUniqueNativeAdCount() {
        return this.A09.size();
    }

    public final boolean isLoaded() {
        return this.A04;
    }

    public final void loadAds() {
        loadAds(NativeAdBase.MediaCacheFlag.ALL);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:            r3 = r3;        r3.A02.A09(r3.A03);        r3.A02.A08(new com.facebook.ads.redexgen.X.C9A(r3, r3.A07, r11));        r3.A02.A07();     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void loadAds(com.facebook.ads.NativeAdBase.MediaCacheFlag r11) {
        /*
            r10 = this;
            r3 = r10
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Hx r7 = com.facebook.ads.redexgen.X.EnumC0458Hx.A06
            int r9 = r3.A06
            com.facebook.ads.redexgen.X.3N r0 = r3.A02
            if (r0 == 0) goto L31
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L28;
                case 4: goto L33;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.96 r3 = (com.facebook.ads.redexgen.X.AnonymousClass96) r3
            com.facebook.ads.redexgen.X.Hx r7 = (com.facebook.ads.redexgen.X.EnumC0458Hx) r7
            com.facebook.ads.redexgen.X.3N r4 = new com.facebook.ads.redexgen.X.3N
            com.facebook.ads.redexgen.X.Ec r5 = r3.A07
            java.lang.String r6 = r3.A08
            r8 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            r3.A02 = r4
            boolean r0 = r3.A05
            if (r0 == 0) goto L26
            r0 = 3
            goto Lc
        L26:
            r0 = 4
            goto Lc
        L28:
            com.facebook.ads.redexgen.X.96 r3 = (com.facebook.ads.redexgen.X.AnonymousClass96) r3
            com.facebook.ads.redexgen.X.3N r0 = r3.A02
            r0.A06()
            r0 = 4
            goto Lc
        L31:
            r0 = 2
            goto Lc
        L33:
            com.facebook.ads.redexgen.X.96 r3 = (com.facebook.ads.redexgen.X.AnonymousClass96) r3
            com.facebook.ads.NativeAdBase$MediaCacheFlag r11 = (com.facebook.ads.NativeAdBase.MediaCacheFlag) r11
            com.facebook.ads.redexgen.X.3N r1 = r3.A02
            java.lang.String r0 = r3.A03
            r1.A09(r0)
            com.facebook.ads.redexgen.X.3N r2 = r3.A02
            com.facebook.ads.redexgen.X.9A r1 = new com.facebook.ads.redexgen.X.9A
            com.facebook.ads.redexgen.X.Ec r0 = r3.A07
            r1.<init>(r3, r0, r11)
            r2.A08(r1)
            com.facebook.ads.redexgen.X.3N r0 = r3.A02
            r0.A07()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass96.loadAds(com.facebook.ads.NativeAdBase$MediaCacheFlag):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.NativeAd nextNativeAd() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            java.util.List<com.facebook.ads.NativeAd> r0 = r4.A09
            int r0 = r0.size()
            if (r0 != 0) goto L44
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L46;
                case 4: goto L12;
                case 5: goto L36;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            r3 = 0
            r0 = 3
            goto Lb
        L12:
            com.facebook.ads.redexgen.X.96 r4 = (com.facebook.ads.redexgen.X.AnonymousClass96) r4
            int r2 = r4.A00
            int r0 = r2 + 1
            r4.A00 = r0
            java.util.List<com.facebook.ads.NativeAd> r1 = r4.A09
            java.util.List<com.facebook.ads.NativeAd> r0 = r4.A09
            int r0 = r0.size()
            int r0 = r2 % r0
            java.lang.Object r3 = r1.get(r0)
            com.facebook.ads.NativeAd r3 = (com.facebook.ads.NativeAd) r3
            java.util.List<com.facebook.ads.NativeAd> r0 = r4.A09
            int r0 = r0.size()
            if (r2 < r0) goto L34
            r0 = 5
            goto Lb
        L34:
            r0 = 3
            goto Lb
        L36:
            com.facebook.ads.redexgen.X.96 r4 = (com.facebook.ads.redexgen.X.AnonymousClass96) r4
            com.facebook.ads.NativeAd r3 = (com.facebook.ads.NativeAd) r3
            com.facebook.ads.NativeAd r1 = new com.facebook.ads.NativeAd
            com.facebook.ads.redexgen.X.Ec r0 = r4.A07
            r1.<init>(r0, r3)
            r3 = r1
            r0 = 3
            goto Lb
        L44:
            r0 = 4
            goto Lb
        L46:
            com.facebook.ads.NativeAd r3 = (com.facebook.ads.NativeAd) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass96.nextNativeAd():com.facebook.ads.NativeAd");
    }

    public final void setExtraHints(String str) {
        this.A03 = str;
    }

    public final void setListener(NativeAdsManager.Listener listener) {
        this.A01 = listener;
    }
}
