package com.facebook.ads.redexgen.X;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

/* loaded from: assets/audience_network.dex */
public class NB extends WebChromeClient {
    public final WeakReference<InterfaceC0528Ks> A00;
    public final WeakReference<N8> A01;

    public NB(WeakReference<InterfaceC0528Ks> weakReference, WeakReference<N8> weakReference2) {
        this.A00 = weakReference;
        this.A01 = weakReference2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:            return true;     */
    @Override // android.webkit.WebChromeClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onConsoleMessage(android.webkit.ConsoleMessage r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            java.lang.String r2 = r5.message()
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L3e
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L1f;
                case 4: goto L2d;
                case 5: goto L40;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            android.webkit.ConsoleMessage r5 = (android.webkit.ConsoleMessage) r5
            android.webkit.ConsoleMessage$MessageLevel r1 = r5.messageLevel()
            android.webkit.ConsoleMessage$MessageLevel r0 = android.webkit.ConsoleMessage.MessageLevel.LOG
            if (r1 != r0) goto L1d
            r0 = 3
            goto Ld
        L1d:
            r0 = 5
            goto Ld
        L1f:
            com.facebook.ads.redexgen.X.NB r3 = (com.facebook.ads.redexgen.X.NB) r3
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.N8> r0 = r3.A01
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L2b
            r0 = 4
            goto Ld
        L2b:
            r0 = 5
            goto Ld
        L2d:
            com.facebook.ads.redexgen.X.NB r3 = (com.facebook.ads.redexgen.X.NB) r3
            java.lang.String r2 = (java.lang.String) r2
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.N8> r0 = r3.A01
            java.lang.Object r0 = r0.get()
            com.facebook.ads.redexgen.X.N8 r0 = (com.facebook.ads.redexgen.X.N8) r0
            r0.A04(r2)
            r0 = 5
            goto Ld
        L3e:
            r0 = 5
            goto Ld
        L40:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NB.onConsoleMessage(android.webkit.ConsoleMessage):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:            return;     */
    @Override // android.webkit.WebChromeClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onProgressChanged(android.webkit.WebView r3, int r4) {
        /*
            r2 = this;
            r1 = r2
            super.onProgressChanged(r3, r4)
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.N8> r0 = r1.A01
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L3d
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L20;
                case 4: goto L2e;
                case 5: goto L3f;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.NB r1 = (com.facebook.ads.redexgen.X.NB) r1
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.N8> r0 = r1.A01
            java.lang.Object r0 = r0.get()
            com.facebook.ads.redexgen.X.N8 r0 = (com.facebook.ads.redexgen.X.N8) r0
            r0.A03()
            r0 = 3
            goto Ld
        L20:
            com.facebook.ads.redexgen.X.NB r1 = (com.facebook.ads.redexgen.X.NB) r1
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.Ks> r0 = r1.A00
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L2c
            r0 = 4
            goto Ld
        L2c:
            r0 = 5
            goto Ld
        L2e:
            com.facebook.ads.redexgen.X.NB r1 = (com.facebook.ads.redexgen.X.NB) r1
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.Ks> r0 = r1.A00
            java.lang.Object r0 = r0.get()
            com.facebook.ads.redexgen.X.Ks r0 = (com.facebook.ads.redexgen.X.InterfaceC0528Ks) r0
            r0.A7L(r4)
            r0 = 5
            goto Ld
        L3d:
            r0 = 3
            goto Ld
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NB.onProgressChanged(android.webkit.WebView, int):void");
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.A00.get() != null) {
            this.A00.get().A7N(str);
        }
    }
}
