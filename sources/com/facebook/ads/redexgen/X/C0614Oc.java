package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

/* renamed from: com.facebook.ads.redexgen.X.Oc, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0614Oc extends ND {
    public final /* synthetic */ C0616Oe A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0614Oc(C0616Oe c0616Oe, C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A00 = c0616Oe;
    }

    @Override // com.facebook.ads.redexgen.X.ND
    public final WebChromeClient A09() {
        return new C0613Ob(this.A00, null);
    }

    @Override // com.facebook.ads.redexgen.X.ND
    public final WebViewClient A0A() {
        return new C0615Od(this.A00, null);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        K5 k5;
        k5 = this.A00.A0B;
        k5.A06(motionEvent, this, this);
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }
}
