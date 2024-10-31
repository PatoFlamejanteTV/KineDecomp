package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.api.AdNativeComponentView;

/* loaded from: assets/audience_network.dex */
public final class L8 extends AdNativeComponentView {
    public static final int A01 = (int) (1.0f * KE.A01);
    public final ImageView A00;

    public L8(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A00 = new MB(c0362Ec);
        this.A00.setScaleType(ImageView.ScaleType.CENTER_CROP);
        EnumC0489Je.A04(this.A00, EnumC0489Je.A0A);
        addView(this.A00, new ViewGroup.LayoutParams(-1, -1));
        KE.A0P(this.A00, -2130706433);
        setPadding(A01, A01, A01, A01);
    }

    public View getAdContentsView() {
        return this.A00;
    }

    public ImageView getImageCardView() {
        return this.A00;
    }
}
