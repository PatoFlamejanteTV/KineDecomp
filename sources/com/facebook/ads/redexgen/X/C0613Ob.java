package com.facebook.ads.redexgen.X;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

/* renamed from: com.facebook.ads.redexgen.X.Ob, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0613Ob extends WebChromeClient {
    public final /* synthetic */ C0616Oe A00;

    public C0613Ob(C0616Oe c0616Oe) {
        this.A00 = c0616Oe;
    }

    public /* synthetic */ C0613Ob(C0616Oe c0616Oe, OW ow) {
        this(c0616Oe);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        C0432Gv c0432Gv;
        OV ov;
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
            c0432Gv = this.A00.A09;
            c0432Gv.A02(EnumC0431Gu.A0M, null);
            ov = this.A00.A0F;
            ov.A04(C0512Kc.A0p, consoleMessage.message());
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
