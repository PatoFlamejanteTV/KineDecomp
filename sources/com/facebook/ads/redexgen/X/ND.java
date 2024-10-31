package com.facebook.ads.redexgen.X;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: assets/audience_network.dex */
public abstract class ND extends WebView {
    public static byte[] A02;
    public static final String A03;
    public boolean A00;
    public final C0362Ec A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.ND.A02
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
            int r0 = r0 + (-72)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ND.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{-4, 23, 31, 34, 27, 26, -42, 42, 37, -42, 31, 36, 31, 42, 31, 23, 34, 31, 48, 27, -42, -7, 37, 37, 33, 31, 27, 3, 23, 36, 23, 29, 27, 40, -28};
    }

    static {
        A02();
        A03 = ND.class.getSimpleName();
    }

    public ND(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A01 = c0362Ec;
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0056, code lost:            r2 = r2;        r2.setHorizontalScrollBarEnabled(r3);        r2.setHorizontalScrollbarOverlay(r3);        r2.setVerticalScrollBarEnabled(r3);        r2.setVerticalScrollbarOverlay(r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:            if (android.os.Build.VERSION.SDK_INT < 21) goto L43;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006a, code lost:            android.webkit.CookieManager.getInstance().setAcceptThirdPartyCookies(r2, true);     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0073, code lost:            android.util.Log.w(com.facebook.ads.redexgen.X.ND.A03, A00(0, 35, 110));     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0081, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01() {
        /*
            r5 = this;
            r2 = r5
            r0 = 0
            r0 = 0
            r4 = 1
            r3 = 0
            android.webkit.WebChromeClient r0 = r2.A09()
            r2.setWebChromeClient(r0)
            android.webkit.WebViewClient r0 = r2.A0A()
            r2.setWebViewClient(r0)
            com.facebook.ads.redexgen.X.NN.A04(r2)
            android.webkit.WebSettings r0 = r2.getSettings()
            r0.setJavaScriptEnabled(r4)
            android.webkit.WebSettings r0 = r2.getSettings()
            r0.setDomStorageEnabled(r4)
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 17
            if (r1 < r0) goto L54
            r0 = 2
        L2b:
            switch(r0) {
                case 2: goto L48;
                case 3: goto L3e;
                case 4: goto L34;
                case 5: goto L2f;
                case 6: goto L56;
                default: goto L2e;
            }
        L2e:
            goto L2b
        L2f:
            setWebContentsDebuggingEnabled(r4)
            r0 = 6
            goto L2b
        L34:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 19
            if (r1 < r0) goto L3c
            r0 = 5
            goto L2b
        L3c:
            r0 = 6
            goto L2b
        L3e:
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            if (r0 == 0) goto L46
            r0 = 4
            goto L2b
        L46:
            r0 = 6
            goto L2b
        L48:
            com.facebook.ads.redexgen.X.ND r2 = (com.facebook.ads.redexgen.X.ND) r2
            r3 = 0
            android.webkit.WebSettings r0 = r2.getSettings()
            r0.setMediaPlaybackRequiresUserGesture(r3)
            r0 = 3
            goto L2b
        L54:
            r0 = 3
            goto L2b
        L56:
            com.facebook.ads.redexgen.X.ND r2 = (com.facebook.ads.redexgen.X.ND) r2
            r2.setHorizontalScrollBarEnabled(r3)
            r2.setHorizontalScrollbarOverlay(r3)
            r2.setVerticalScrollBarEnabled(r3)
            r2.setVerticalScrollbarOverlay(r3)
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r1 < r0) goto L81
            android.webkit.CookieManager r1 = android.webkit.CookieManager.getInstance()     // Catch: java.lang.Exception -> L73
            r0 = 1
            r1.setAcceptThirdPartyCookies(r2, r0)     // Catch: java.lang.Exception -> L73
            goto L81
        L73:
            java.lang.String r3 = com.facebook.ads.redexgen.X.ND.A03
            r2 = 0
            r1 = 35
            r0 = 110(0x6e, float:1.54E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            android.util.Log.w(r3, r0)
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ND.A01():void");
    }

    public final boolean A03() {
        return this.A00;
    }

    public WebChromeClient A09() {
        return new WebChromeClient();
    }

    public WebViewClient A0A() {
        return new WebViewClient();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.A00 = true;
        super.destroy();
    }

    public C0362Ec getAdContextWrapper() {
        return this.A01;
    }
}
