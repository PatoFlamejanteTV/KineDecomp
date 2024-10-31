package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: assets/audience_network.dex */
public final class MW extends RelativeLayout {
    public final int A00;
    public final int A01;
    public final C0362Ec A02;
    public final MX A03;
    public final boolean A04;
    public static final int A08 = (int) (KE.A01 * 16.0f);
    public static final int A09 = (int) (8.0f * KE.A01);
    public static final int A0C = (int) (44.0f * KE.A01);
    public static final int A07 = (int) (10.0f * KE.A01);
    public static final int A06 = A08 - A07;
    public static final int A0D = (int) (75.0f * KE.A01);
    public static final int A0A = (int) (25.0f * KE.A01);
    public static final int A0E = (int) (45.0f * KE.A01);
    public static final int A0B = (int) (15.0f * KE.A01);
    public static final int A05 = (int) (KE.A01 * 16.0f);

    public MW(MV mv) {
        super(MV.A01(mv));
        this.A02 = MV.A01(mv);
        this.A03 = MV.A03(mv);
        this.A01 = MV.A09(mv) ? A0D : A0E;
        this.A00 = MV.A09(mv) ? A0A : A0B;
        this.A04 = MV.A0A(mv);
        setClickable(true);
        View A01 = A01(mv);
        View A00 = A00(mv);
        View footerView = getFooterView();
        KE.A0N(A01);
        KE.A0N(A00);
        KE.A0N(footerView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        layoutParams2.addRule(3, A01.getId());
        layoutParams2.addRule(2, footerView.getId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(12);
        layoutParams3.setMargins(A08, 0, A08, A08);
        addView(A01, layoutParams);
        addView(A00, layoutParams2);
        addView(footerView, layoutParams3);
        footerView.setVisibility(MV.A0B(mv) ? 0 : 8);
    }

    public /* synthetic */ MW(MV mv, MT mt) {
        this(mv);
    }

    private View A00(MV mv) {
        ImageView imageView = new ImageView(getContext());
        imageView.setPadding(this.A00, this.A00, this.A00, this.A00);
        imageView.setImageBitmap(KN.A00(MV.A02(mv)));
        imageView.setColorFilter(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.A01, this.A01);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(MV.A00(mv));
        KE.A0T(imageView, gradientDrawable);
        layoutParams.gravity = 17;
        layoutParams.setMargins(A08, 0, A08, A08);
        TextView textView = new TextView(getContext());
        KE.A0Y(textView, true, 20);
        textView.setTextColor(-14934495);
        textView.setText(MV.A04(mv));
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(A08, 0, A08, A08);
        TextView textView2 = new TextView(getContext());
        KE.A0Y(textView2, false, 16);
        textView2.setTextColor(-10459280);
        textView2.setText(MV.A05(mv));
        textView2.setGravity(17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(A08, 0, A08, A08);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        linearLayout.addView(textView2, layoutParams3);
        if (MV.A08(mv)) {
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(17);
            if (!TextUtils.isEmpty(MV.A06(mv))) {
                M4 m4 = new M4(this.A02);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(A0E, A0E);
                layoutParams4.setMargins(0, 0, A09, 0);
                m4.setFullCircleCorners(true);
                new NR(m4, this.A02).A05(A0E, A0E).A07(MV.A06(mv));
                linearLayout2.addView(m4, layoutParams4);
            }
            C0564Mc c0564Mc = new C0564Mc(this.A02);
            c0564Mc.setData(MV.A07(mv), KM.CHECKMARK);
            c0564Mc.setSelected(true);
            linearLayout2.addView(c0564Mc, new LinearLayout.LayoutParams(-2, -2));
            linearLayout.addView(linearLayout2);
        }
        return linearLayout;
    }

    private View A01(MV mv) {
        LinearLayout headerView = new LinearLayout(getContext());
        headerView.setOrientation(0);
        if (MV.A0C(mv)) {
            ImageView imageView = new ImageView(getContext());
            imageView.setPadding(A07, A07, A07, A07);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageBitmap(KN.A00(KM.CROSS));
            imageView.setOnClickListener(new MT(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A0C, A0C);
            layoutParams.setMargins(A06, A06, A06, A06);
            headerView.addView(imageView, layoutParams);
        }
        return headerView;
    }

    private View getFooterView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(KN.A00(KM.SETTINGS));
        imageView.setColorFilter(-13272859);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A05, A05);
        layoutParams.gravity = 17;
        TextView textView = new TextView(getContext());
        KE.A0Y(textView, false, 16);
        textView.setTextColor(-13272859);
        textView.setPadding(A09, A09, A09, A09);
        textView.setText(AnonymousClass43.A0D(this.A02.A00()));
        LinearLayout.LayoutParams settingsIconParams = new LinearLayout.LayoutParams(-2, -2);
        settingsIconParams.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setOnClickListener(new MU(this));
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, settingsIconParams);
        return linearLayout;
    }
}
