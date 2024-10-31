package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAd;

/* renamed from: com.facebook.ads.redexgen.X.Pq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0654Pq extends LinearLayout {
    public static final int A00 = (int) (KE.A01 * 32.0f);
    public static final int A01 = (int) (KE.A01 * 8.0f);

    public C0654Pq(C0362Ec c0362Ec, NativeAd nativeAd, C0444Hh c0444Hh, M4 m4, AdOptionsView adOptionsView) {
        super(c0362Ec);
        setOrientation(0);
        m4.setFullCircleCorners(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A00, A00);
        layoutParams.gravity = 16;
        layoutParams.setMargins(0, 0, A01, 0);
        addView(m4, layoutParams);
        TextView textView = new TextView(c0362Ec);
        c0444Hh.A08(textView);
        textView.setMaxLines(1);
        textView.setText(nativeAd.getAdvertiserName());
        TextView textView2 = new TextView(c0362Ec);
        c0444Hh.A06(textView2);
        textView2.setMaxLines(1);
        textView2.setText(nativeAd.getSponsoredTranslation());
        LinearLayout linearLayout = new LinearLayout(c0362Ec);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 16;
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        addView(linearLayout, layoutParams2);
        addView((View) adOptionsView, new LinearLayout.LayoutParams(-2, -2));
    }
}
