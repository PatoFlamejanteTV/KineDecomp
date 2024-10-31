package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.facebook.ads.redexgen.X.2y, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C00792y extends WebViewClient {
    public boolean A00 = false;
    public final C00592e A01;
    public final InterfaceC00411m A02;
    public final boolean A03;

    public C00792y(C00592e c00592e, InterfaceC00411m interfaceC00411m, boolean z) {
        this.A01 = c00592e;
        this.A02 = interfaceC00411m;
        this.A03 = z;
    }

    private void A00() {
        if (this.A02 != null) {
            this.A02.A7J();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A01(android.webkit.WebResourceError r4) {
        /*
            r3 = this;
            r2 = r3
            boolean r0 = r2.A03
            if (r0 == 0) goto L1c
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L1e;
                case 4: goto L15;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.2y r2 = (com.facebook.ads.redexgen.X.C00792y) r2
            com.facebook.ads.redexgen.X.1m r1 = r2.A02
            com.facebook.ads.AdError r0 = com.facebook.ads.AdError.CACHE_ERROR
            r1.A7I(r0)
            r0 = 3
            goto L6
        L15:
            com.facebook.ads.redexgen.X.2y r2 = (com.facebook.ads.redexgen.X.C00792y) r2
            r2.A00()
            r0 = 3
            goto L6
        L1c:
            r0 = 4
            goto L6
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00792y.A01(android.webkit.WebResourceError):void");
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        this.A00 = true;
        A00();
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        new Handler().postDelayed(new AbstractRunnableC00351g() { // from class: com.facebook.ads.redexgen.X.2x
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
            public final void A05() {
                if (C00792y.this.A00) {
                    return;
                }
                C00792y.this.A01(null);
            }
        }, this.A01.A08());
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.A00 = true;
        A01(webResourceError);
    }
}
