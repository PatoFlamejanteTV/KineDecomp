package com.facebook.ads.redexgen.X;

import android.webkit.WebView;

/* renamed from: com.facebook.ads.redexgen.X.2w, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C00772w implements C1Z {
    public final C00592e A00;
    public final InterfaceC00411m A01;
    public final EV A02;
    public final C0362Ec A03;
    public final boolean A04;

    public C00772w(C0362Ec c0362Ec, InterfaceC00411m interfaceC00411m, EV ev, C00592e c00592e, boolean z) {
        this.A03 = c0362Ec;
        this.A01 = interfaceC00411m;
        this.A02 = ev;
        this.A00 = c00592e;
        this.A04 = z;
    }

    public /* synthetic */ C00772w(C0362Ec c0362Ec, InterfaceC00411m interfaceC00411m, EV ev, C00592e c00592e, boolean z, C00762v c00762v) {
        this(c0362Ec, interfaceC00411m, ev, c00592e, z);
    }

    private void A00() {
        WebView webView = new WebView(this.A03);
        webView.getSettings().setCacheMode(1);
        webView.setWebViewClient(new C00792y(this.A00, this.A01, this.A04));
        webView.loadUrl(this.A00.A0E());
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01(boolean r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.2e r0 = r3.A00
            com.facebook.ads.redexgen.X.2f r1 = r0.A09()
            com.facebook.ads.redexgen.X.2f r0 = com.facebook.ads.redexgen.X.EnumC00602f.A05
            if (r1 != r0) goto L46
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L48;
                case 4: goto L18;
                case 5: goto L26;
                case 6: goto L36;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.2w r3 = (com.facebook.ads.redexgen.X.C00772w) r3
            r3.A00()
            r0 = 3
            goto Ld
        L18:
            com.facebook.ads.redexgen.X.2w r3 = (com.facebook.ads.redexgen.X.C00772w) r3
            com.facebook.ads.redexgen.X.2e r0 = r3.A00
            java.lang.String r2 = r0.A0E()
            if (r5 == 0) goto L24
            r0 = 5
            goto Ld
        L24:
            r0 = 6
            goto Ld
        L26:
            com.facebook.ads.redexgen.X.2w r3 = (com.facebook.ads.redexgen.X.C00772w) r3
            com.facebook.ads.redexgen.X.EV r1 = r3.A02
            com.facebook.ads.redexgen.X.2e r0 = r3.A00
            java.lang.String r0 = r0.A0E()
            java.lang.String r2 = r1.A0K(r0)
            r0 = 6
            goto Ld
        L36:
            com.facebook.ads.redexgen.X.2w r3 = (com.facebook.ads.redexgen.X.C00772w) r3
            java.lang.String r2 = (java.lang.String) r2
            com.facebook.ads.redexgen.X.2e r0 = r3.A00
            r0.A0G(r2)
            com.facebook.ads.redexgen.X.1m r0 = r3.A01
            r0.A7J()
            r0 = 3
            goto Ld
        L46:
            r0 = 4
            goto Ld
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00772w.A01(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C1Z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A6I() {
        /*
            r3 = this;
            r2 = r3
            boolean r0 = r2.A04
            if (r0 == 0) goto L1d
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L1f;
                case 4: goto L15;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.2w r2 = (com.facebook.ads.redexgen.X.C00772w) r2
            com.facebook.ads.redexgen.X.1m r1 = r2.A01
            com.facebook.ads.AdError r0 = com.facebook.ads.AdError.CACHE_ERROR
            r1.A7I(r0)
            r0 = 3
            goto L6
        L15:
            com.facebook.ads.redexgen.X.2w r2 = (com.facebook.ads.redexgen.X.C00772w) r2
            r0 = 0
            r2.A01(r0)
            r0 = 3
            goto L6
        L1d:
            r0 = 4
            goto L6
        L1f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00772w.A6I():void");
    }

    @Override // com.facebook.ads.redexgen.X.C1Z
    public final void A6P() {
        A01(true);
    }
}
