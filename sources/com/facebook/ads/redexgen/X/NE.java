package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

@TargetApi(19)
/* loaded from: assets/audience_network.dex */
public final class NE extends ND {
    public static byte[] A07;
    public static final String A08;
    public static final Set<String> A09;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public N8 A04;
    public InterfaceC0528Ks A05;
    public final C0362Ec A06;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.NE.A07
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
            r0 = r0 ^ 38
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NE.A02(int, int, int):java.lang.String");
    }

    public static void A06() {
        A07 = new byte[]{40, 52, 52, 48, 51, 106, 118, 118, 114, 57, 50, 37, 50, 32, 48, 33, 58, 35, 39, 105};
    }

    static {
        A06();
        A08 = NE.class.getSimpleName();
        A09 = new HashSet(2);
        A09.add(A02(5, 4, 36));
        A09.add(A02(0, 5, 102));
    }

    public NE(C0362Ec c0362Ec, InterfaceC0528Ks interfaceC0528Ks) {
        super(c0362Ec);
        this.A02 = -1L;
        this.A00 = -1L;
        this.A03 = -1L;
        this.A01 = -1L;
        this.A05 = interfaceC0528Ks;
        this.A06 = c0362Ec;
        setWebChromeClient(A09());
        setWebViewClient(A0A());
        A05();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0034, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A04() {
        /*
            r6 = this;
            r5 = r6
            r0 = 0
            r3 = -1
            long r1 = r5.A00
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L32
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L1c;
                case 4: goto L28;
                case 5: goto L34;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.NE r5 = (com.facebook.ads.redexgen.X.NE) r5
            long r1 = r5.A03
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L1a
            r0 = 3
            goto Lc
        L1a:
            r0 = 5
            goto Lc
        L1c:
            com.facebook.ads.redexgen.X.NE r5 = (com.facebook.ads.redexgen.X.NE) r5
            long r1 = r5.A01
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L26
            r0 = 4
            goto Lc
        L26:
            r0 = 5
            goto Lc
        L28:
            com.facebook.ads.redexgen.X.NE r5 = (com.facebook.ads.redexgen.X.NE) r5
            com.facebook.ads.redexgen.X.N8 r1 = r5.A04
            r0 = 0
            r1.A05(r0)
            r0 = 5
            goto Lc
        L32:
            r0 = 5
            goto Lc
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NE.A04():void");
    }

    private void A05() {
        WebSettings settings = getSettings();
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccess(false);
        this.A04 = new N8(this);
    }

    @Override // com.facebook.ads.redexgen.X.ND
    public final WebChromeClient A09() {
        return new NB(new WeakReference(this.A05), new WeakReference(this.A04));
    }

    @Override // com.facebook.ads.redexgen.X.ND
    public final WebViewClient A0A() {
        return new NC(new WeakReference(this.A05), new WeakReference(this.A06));
    }

    public final void A0B(long j) {
        if (this.A00 < 0) {
            this.A00 = j;
        }
        A04();
    }

    public final void A0C(long j) {
        if (this.A01 < 0) {
            this.A01 = j;
        }
        A04();
    }

    public final void A0D(long j) {
        if (this.A02 < 0) {
            this.A02 = j;
        }
    }

    public final void A0E(String str) {
        try {
            evaluateJavascript(str, null);
        } catch (IllegalStateException unused) {
            loadUrl(A02(9, 11, 117) + str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.ND, android.webkit.WebView
    public final void destroy() {
        this.A05 = null;
        NN.A03(this);
        super.destroy();
    }

    public long getDomContentLoadedMs() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getFirstUrl() {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r2 = 0
            android.webkit.WebBackForwardList r1 = r3.copyBackForwardList()
            int r0 = r1.getSize()
            if (r0 <= 0) goto L27
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L29;
                case 4: goto L1f;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            android.webkit.WebBackForwardList r1 = (android.webkit.WebBackForwardList) r1
            r0 = 0
            android.webkit.WebHistoryItem r0 = r1.getItemAtIndex(r0)
            java.lang.String r2 = r0.getUrl()
            r0 = 3
            goto Le
        L1f:
            com.facebook.ads.redexgen.X.NE r3 = (com.facebook.ads.redexgen.X.NE) r3
            java.lang.String r2 = r3.getUrl()
            r0 = 3
            goto Le
        L27:
            r0 = 4
            goto Le
        L29:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = (java.lang.String) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NE.getFirstUrl():java.lang.String");
    }

    public long getLoadFinishMs() {
        return this.A01;
    }

    public long getResponseEndMs() {
        return this.A02;
    }

    public long getScrollReadyMs() {
        return this.A03;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:            return;     */
    @Override // android.webkit.WebView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDraw(android.graphics.Canvas r7) {
        /*
            r6 = this;
            r5 = r6
            super.onDraw(r7)
            long r3 = r5.A03
            r1 = 0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L2e
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L21;
                case 4: goto L30;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.NE r5 = (com.facebook.ads.redexgen.X.NE) r5
            int r1 = r5.computeVerticalScrollRange()
            int r0 = r5.getHeight()
            if (r1 <= r0) goto L1f
            r0 = 3
            goto Ld
        L1f:
            r0 = 4
            goto Ld
        L21:
            com.facebook.ads.redexgen.X.NE r5 = (com.facebook.ads.redexgen.X.NE) r5
            long r0 = java.lang.System.currentTimeMillis()
            r5.A03 = r0
            r5.A04()
            r0 = 4
            goto Ld
        L2e:
            r0 = 4
            goto Ld
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NE.onDraw(android.graphics.Canvas):void");
    }
}
