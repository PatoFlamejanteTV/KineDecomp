package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Op, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0627Op extends AbstractRunnableC00351g {
    public final /* synthetic */ C0629Or A00;

    public C0627Op(C0629Or c0629Or) {
        this.A00 = c0629Or;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        AbstractC0604Nr abstractC0604Nr;
        int closeButtonStyle;
        AtomicBoolean atomicBoolean;
        AbstractC0604Nr abstractC0604Nr2;
        abstractC0604Nr = this.A00.A00;
        if (abstractC0604Nr != null) {
            abstractC0604Nr2 = this.A00.A00;
            abstractC0604Nr2.A0X();
        }
        FullScreenAdToolbar fullScreenAdToolbar = this.A00.A08;
        closeButtonStyle = this.A00.getCloseButtonStyle();
        fullScreenAdToolbar.setToolbarActionMode(closeButtonStyle);
        atomicBoolean = this.A00.A04;
        atomicBoolean.set(true);
    }
}
