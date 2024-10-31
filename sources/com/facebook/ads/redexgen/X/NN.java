package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: assets/audience_network.dex */
public final class NN {
    public static byte[] A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.NN.A00
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
            r0 = r0 ^ 70
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NN.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{122, 108, 125, 68, 96, 113, 108, 109, 74, 102, 103, 125, 108, 103, 125, 68, 102, 109, 108, 85, 73, 73, 77, 78, 7, 18, 18, 74, 74, 74, 19, 24, 78, 19, 91, 92, 94, 88, 95, 82, 82, 86, 19, 94, 82, 80, Byte.MAX_VALUE, 99, 99, 103, 100, 45, 56, 56, 96, 96, 96, 57, 113, 118, 116, 114, 117, 120, 120, 124, 57, 116, 120, 122, 56, 103, 100, 105, 115, 114, 60, 100, 106, 103, 104, 109};
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00() {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r4 = com.facebook.ads.internal.settings.AdInternalSettings.getUrlPrefix()
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L37
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L39;
                case 4: goto L1d;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            r2 = 46
            r1 = 25
            r0 = 81
            java.lang.String r1 = A01(r2, r1, r0)
            r0 = 3
            goto Ld
        L1d:
            java.lang.String r4 = (java.lang.String) r4
            java.util.Locale r3 = java.util.Locale.US
            r2 = 19
            r1 = 27
            r0 = 123(0x7b, float:1.72E-43)
            java.lang.String r2 = A01(r2, r1, r0)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r0 = 0
            r1[r0] = r4
            java.lang.String r1 = java.lang.String.format(r3, r2, r1)
            r0 = 3
            goto Ld
        L37:
            r0 = 4
            goto Ld
        L39:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NN.A00():java.lang.String");
    }

    public static void A03(WebView webView) {
        webView.loadUrl(A01(71, 11, 64));
        webView.clearCache(true);
    }

    @TargetApi(21)
    public static void A04(WebView webView) {
        WebSettings settings = webView.getSettings();
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        } else {
            try {
                WebSettings.class.getMethod(A01(0, 19, 79), new Class[0]).invoke(settings, 0);
            } catch (Exception unused) {
            }
        }
    }
}
