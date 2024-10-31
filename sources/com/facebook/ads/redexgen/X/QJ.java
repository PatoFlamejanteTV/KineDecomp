package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: assets/audience_network.dex */
public abstract class QJ extends RelativeLayout implements QI {

    @Nullable
    public C0537Lb A00;

    public QJ(C0362Ec c0362Ec) {
        super(c0362Ec);
    }

    public QJ(C0362Ec c0362Ec, AttributeSet attributeSet, int i) {
        super(c0362Ec, attributeSet, i);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void A09() {
    }

    public void A0A() {
    }

    @Override // com.facebook.ads.redexgen.X.QI
    public final void A5M(C0537Lb c0537Lb) {
        this.A00 = c0537Lb;
        A09();
    }

    @Override // com.facebook.ads.redexgen.X.QI
    public final void A8U(C0537Lb c0537Lb) {
        A0A();
        this.A00 = null;
    }

    @Nullable
    public C0537Lb getVideoView() {
        return this.A00;
    }
}
