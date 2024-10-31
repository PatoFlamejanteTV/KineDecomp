package com.facebook.ads.redexgen.X;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.facebook.ads.redexgen.X.Od, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0615Od extends WebViewClient {
    public final /* synthetic */ C0616Oe A00;

    public C0615Od(C0616Oe c0616Oe) {
        this.A00 = c0616Oe;
    }

    public /* synthetic */ C0615Od(C0616Oe c0616Oe, OW ow) {
        this(c0616Oe);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        C0432Gv c0432Gv;
        c0432Gv = this.A00.A09;
        c0432Gv.A02(EnumC0431Gu.A0Q, null);
        this.A00.A0N();
        this.A00.A03 = true;
        this.A00.A0E();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:            r1 = r4.A00.A0F;        r1.A04(com.facebook.ads.redexgen.X.C0512Kc.A0r, r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:            return;     */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onReceivedError(android.webkit.WebView r5, android.webkit.WebResourceRequest r6, android.webkit.WebResourceError r7) {
        /*
            r4 = this;
            r3 = 0
            super.onReceivedError(r5, r6, r7)
            com.facebook.ads.redexgen.X.Oe r0 = r4.A00
            r0.A0N()
            com.facebook.ads.redexgen.X.Oe r0 = r4.A00
            com.facebook.ads.redexgen.X.Gv r2 = com.facebook.ads.redexgen.X.C0616Oe.A03(r0)
            com.facebook.ads.redexgen.X.Gu r1 = com.facebook.ads.redexgen.X.EnumC0431Gu.A0P
            r0 = 0
            r2.A02(r1, r0)
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r1 < r0) goto L30
            r0 = 2
        L1c:
            switch(r0) {
                case 2: goto L20;
                case 3: goto L32;
                case 4: goto L2c;
                default: goto L1f;
            }
        L1f:
            goto L1c
        L20:
            android.webkit.WebResourceError r7 = (android.webkit.WebResourceError) r7
            java.lang.CharSequence r0 = r7.getDescription()
            java.lang.String r3 = r0.toString()
            r0 = 3
            goto L1c
        L2c:
            java.lang.String r3 = ""
            r0 = 3
            goto L1c
        L30:
            r0 = 4
            goto L1c
        L32:
            r0 = r4
            com.facebook.ads.redexgen.X.Od r0 = (com.facebook.ads.redexgen.X.C0615Od) r0
            java.lang.String r3 = (java.lang.String) r3
            com.facebook.ads.redexgen.X.Oe r0 = r0.A00
            com.facebook.ads.redexgen.X.OV r1 = com.facebook.ads.redexgen.X.C0616Oe.A07(r0)
            int r0 = com.facebook.ads.redexgen.X.C0512Kc.A0r
            r1.A04(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0615Od.onReceivedError(android.webkit.WebView, android.webkit.WebResourceRequest, android.webkit.WebResourceError):void");
    }
}
