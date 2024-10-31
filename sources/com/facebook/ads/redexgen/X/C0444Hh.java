package com.facebook.ads.redexgen.X;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.internal.api.NativeAdViewAttributesApi;

/* renamed from: com.facebook.ads.redexgen.X.Hh, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0444Hh implements NativeAdViewAttributesApi {
    public static final int A08 = (int) (KE.A01 * 4.0f);
    public static final int A07 = (int) (KE.A01 * 1.0f);
    public Typeface A06 = Typeface.create(Typeface.SANS_SERIF, 0);
    public int A00 = -1;
    public int A04 = -14868183;
    public int A05 = -10393744;
    public int A01 = -1;
    public int A03 = -12420889;
    public int A02 = this.A03;

    public final int A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01;
    }

    public final int A02() {
        return this.A02;
    }

    public final int A03() {
        return this.A03;
    }

    public final int A04(float f) {
        return C4G.A02((this.A01 & (-16777216)) | ((this.A01 ^ (-1)) & 16777215), this.A01, f);
    }

    public final void A05(TextView textView) {
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(this.A06, 1);
        textView.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.A01);
        gradientDrawable.setCornerRadius(A08);
        gradientDrawable.setStroke(A07, this.A02);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(this.A03);
        gradientDrawable2.setCornerRadius(A08);
        gradientDrawable2.setStroke(A07, this.A02);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        KE.A0T(textView, stateListDrawable);
        textView.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{this.A01, this.A03}));
    }

    public final void A06(TextView textView) {
        textView.setTextColor(this.A05);
        textView.setTextSize(14.0f);
        textView.setTypeface(this.A06);
        textView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void A07(TextView textView) {
        textView.setTextColor(this.A04);
        textView.setTextSize(16.0f);
        textView.setTypeface(this.A06, 1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void A08(TextView textView) {
        textView.setTextColor(this.A04);
        textView.setTextSize(16.0f);
        textView.setTypeface(this.A06, 1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void A09(AdOptionsView adOptionsView, int i) {
        adOptionsView.setIconColor(this.A04);
        adOptionsView.setIconSizeDp(i);
    }

    public final void setBackgroundColor(int i) {
        this.A00 = i;
    }

    public final void setCTABackgroundColor(int i) {
        this.A01 = i;
    }

    public final void setCTABorderColor(int i) {
        this.A02 = i;
    }

    public final void setCTATextColor(int i) {
        this.A03 = i;
    }

    public final void setPrimaryTextColor(int i) {
        this.A04 = i;
    }

    public final void setSecondaryTextColor(int i) {
        this.A05 = i;
    }

    public final void setTypeface(Typeface typeface) {
        this.A06 = typeface;
    }
}
