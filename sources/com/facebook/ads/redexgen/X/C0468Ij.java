package com.facebook.ads.redexgen.X;

import android.widget.RelativeLayout;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Ij, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0468Ij extends QJ {
    public final int A00;
    public final C1S<QT> A01;
    public final C0469Ik A02;
    public final String A03;
    public final String A04;
    public final AtomicBoolean A05;

    public C0468Ij(C0362Ec c0362Ec, int i, String str, String str2) {
        super(c0362Ec);
        this.A01 = new JT(this);
        this.A00 = i;
        this.A03 = str;
        this.A04 = str2;
        this.A05 = new AtomicBoolean(false);
        this.A02 = new C0469Ik(c0362Ec);
        this.A02.setText(this.A03 + ' ' + i);
        addView(this.A02, new RelativeLayout.LayoutParams(-2, -2));
    }

    @Override // com.facebook.ads.redexgen.X.QJ
    public final void A09() {
        super.A09();
        if (getVideoView() != null) {
            getVideoView().getEventBus().A05(this.A01);
        }
        this.A02.setOnClickListener(new JD(this));
    }

    @Override // com.facebook.ads.redexgen.X.QJ
    public final void A0A() {
        if (getVideoView() != null) {
            this.A02.setOnClickListener(null);
            getVideoView().getEventBus().A06(this.A01);
        }
        super.A0A();
    }
}
