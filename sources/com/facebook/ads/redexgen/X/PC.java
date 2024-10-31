package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: assets/audience_network.dex */
public final class PC extends LinearLayout {
    public static final int A04 = (int) (KE.A01 * 32.0f);
    public static final int A05 = (int) (KE.A01 * 8.0f);
    public TextView A00;
    public TextView A01;
    public M4 A02;
    public final C0362Ec A03;

    public PC(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A03 = c0362Ec;
        A00(c0362Ec);
    }

    private final void A00(C0362Ec c0362Ec) {
        setGravity(16);
        this.A02 = new M4(c0362Ec);
        this.A02.setFullCircleCorners(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A04, A04);
        layoutParams.setMargins(0, 0, A05, 0);
        addView(this.A02, layoutParams);
        LinearLayout linearLayout = new LinearLayout(c0362Ec);
        linearLayout.setOrientation(1);
        this.A00 = new TextView(c0362Ec);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        KE.A0Y(this.A00, true, 16);
        this.A00.setEllipsize(TextUtils.TruncateAt.END);
        this.A00.setSingleLine(true);
        this.A01 = new TextView(c0362Ec);
        KE.A0Y(this.A01, false, 14);
        linearLayout.addView(this.A00);
        linearLayout.addView(this.A01);
        addView(linearLayout, layoutParams2);
    }

    public final void A01(int i, int i2) {
        this.A00.setTextColor(i);
        this.A01.setTextColor(i2);
    }

    public void setPageDetails(C00572c c00572c) {
        NR nr = new NR(this.A02, this.A03);
        nr.A05(A04, A04);
        nr.A07(c00572c.A01());
        this.A00.setText(c00572c.A02());
        this.A01.setText(c00572c.A03());
    }
}
