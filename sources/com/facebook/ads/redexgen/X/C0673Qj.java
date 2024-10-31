package com.facebook.ads.redexgen.X;

import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* renamed from: com.facebook.ads.redexgen.X.Qj, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0673Qj extends RelativeLayout {
    public ImageView A00;
    public TextView A01;
    public boolean A02;
    public final DisplayMetrics A03;
    public final C0362Ec A04;
    public final String A05;
    public final String A06;
    public final String A07;

    public C0673Qj(C0362Ec c0362Ec, String str, String str2, float[] fArr, String str3) {
        super(c0362Ec);
        this.A02 = false;
        this.A04 = c0362Ec;
        this.A06 = str;
        this.A05 = str2;
        this.A07 = str3;
        this.A03 = c0362Ec.getResources().getDisplayMetrics();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setAlpha(178);
        gradientDrawable.setCornerRadii(new float[]{fArr[0] * this.A03.density, fArr[0] * this.A03.density, fArr[1] * this.A03.density, fArr[1] * this.A03.density, fArr[2] * this.A03.density, fArr[2] * this.A03.density, fArr[3] * this.A03.density, fArr[3] * this.A03.density});
        KE.A0T(this, gradientDrawable);
        A08();
        A04();
        A05();
        setMinimumWidth(Math.round(20.0f * this.A03.density));
        setMinimumHeight(Math.round(18.0f * this.A03.density));
    }

    private void A04() {
        this.A00 = new ImageView(this.A04);
        this.A00.setImageBitmap(KN.A00(KM.IC_AD_CHOICES));
        addView(this.A00);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(this.A03.density * 16.0f), Math.round(this.A03.density * 16.0f));
        layoutParams.addRule(9);
        layoutParams.addRule(15, -1);
        layoutParams.setMargins(Math.round(4.0f * this.A03.density), Math.round(this.A03.density * 2.0f), Math.round(this.A03.density * 2.0f), Math.round(this.A03.density * 2.0f));
        this.A00.setLayoutParams(layoutParams);
    }

    private void A05() {
        this.A01 = new TextView(getContext());
        addView(this.A01);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = 0;
        layoutParams.leftMargin = (int) (20.0f * this.A03.density);
        layoutParams.addRule(9);
        layoutParams.addRule(15, -1);
        this.A01.setLayoutParams(layoutParams);
        this.A01.setSingleLine();
        this.A01.setText(this.A06);
        this.A01.setTextSize(10.0f);
        this.A01.setTextColor(-4341303);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06() {
        Paint p = new Paint();
        p.setTextSize(this.A01.getTextSize());
        int targetWidth = Math.round(p.measureText(this.A06) + (4.0f * this.A03.density));
        int width = getWidth();
        int startWidth = width - targetWidth;
        C0671Qh c0671Qh = new C0671Qh(this, width, startWidth);
        c0671Qh.setAnimationListener(new AnimationAnimationListenerC0672Qi(this));
        c0671Qh.setDuration(300L);
        c0671Qh.setFillAfter(true);
        startAnimation(c0671Qh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        Paint paint = new Paint();
        paint.setTextSize(this.A01.getTextSize());
        int textWidth = Math.round(paint.measureText(this.A06) + (4.0f * this.A03.density));
        int startWidth = getWidth();
        int targetWidth = textWidth + startWidth;
        this.A02 = true;
        C0668Qe c0668Qe = new C0668Qe(this, startWidth, targetWidth);
        c0668Qe.setAnimationListener(new AnimationAnimationListenerC0670Qg(this));
        c0668Qe.setDuration(300L);
        c0668Qe.setFillAfter(true);
        startAnimation(c0668Qe);
    }

    private void A08() {
        setOnTouchListener(new ViewOnTouchListenerC0667Qd(this));
    }
}
