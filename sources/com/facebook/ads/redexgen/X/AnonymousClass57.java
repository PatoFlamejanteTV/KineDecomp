package com.facebook.ads.redexgen.X;

import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.WindowInsets;

@RequiresApi(21)
/* renamed from: com.facebook.ads.redexgen.X.57, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class AnonymousClass57 extends AnonymousClass55 {
    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public final C5Y A08(View view, C5Y c5y) {
        WindowInsets windowInsets = (WindowInsets) C5Y.A01(c5y);
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        if (dispatchApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(dispatchApplyWindowInsets);
        }
        return C5Y.A00(windowInsets);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public final C5Y A09(View view, C5Y c5y) {
        WindowInsets windowInsets = (WindowInsets) C5Y.A01(c5y);
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (onApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(onApplyWindowInsets);
        }
        return C5Y.A00(windowInsets);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public final void A0B(View view) {
        view.stopNestedScroll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0E(android.view.View r3, final com.facebook.ads.redexgen.X.InterfaceC01194m r4) {
        /*
            r2 = this;
            r1 = r2
            if (r4 != 0) goto L20
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L22;
                case 4: goto L10;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            android.view.View r3 = (android.view.View) r3
            r0 = 0
            r3.setOnApplyWindowInsetsListener(r0)
            r0 = 3
            goto L4
        L10:
            com.facebook.ads.redexgen.X.57 r1 = (com.facebook.ads.redexgen.X.AnonymousClass57) r1
            android.view.View r3 = (android.view.View) r3
            com.facebook.ads.redexgen.X.4m r4 = (com.facebook.ads.redexgen.X.InterfaceC01194m) r4
            com.facebook.ads.redexgen.X.56 r0 = new com.facebook.ads.redexgen.X.56
            r0.<init>()
            r3.setOnApplyWindowInsetsListener(r0)
            r0 = 3
            goto L4
        L20:
            r0 = 4
            goto L4
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass57.A0E(android.view.View, com.facebook.ads.redexgen.X.4m):void");
    }
}
