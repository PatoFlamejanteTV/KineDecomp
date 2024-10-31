package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.internal.api.AdComponentView;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdComponentViewParentApi;

/* renamed from: com.facebook.ads.redexgen.X.7w, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C02017w implements AdComponentViewApi {
    public AdComponentView A00;
    public AdComponentViewParentApi A01;
    public AdComponentViewParentApi A02;
    public boolean A03;

    public final void A00(AdComponentViewApi adComponentViewApi) {
        this.A02 = adComponentViewApi;
        this.A02.onAttachedToView(this.A00, this.A01);
    }

    public final void A01(boolean z) {
        this.A03 = z;
    }

    public final void addView(View view) {
        if (!this.A03) {
            this.A02.addView(view);
        }
    }

    public final void addView(View view, int i) {
        if (!this.A03) {
            this.A02.addView(view, i);
        }
    }

    public final void addView(View view, int i, int i2) {
        if (!this.A03) {
            this.A02.addView(view, i, i2);
        }
    }

    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        this.A02.addView(view, i, layoutParams);
    }

    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.A03) {
            this.A02.addView(view, layoutParams);
        }
    }

    public void bringChildToFront(View view) {
        this.A02.bringChildToFront(view);
    }

    public void onAttachedToView(AdComponentView adComponentView, AdComponentViewParentApi adComponentViewParentApi) {
        this.A01 = adComponentViewParentApi;
        this.A00 = adComponentView;
        this.A02 = adComponentViewParentApi;
    }

    public void onAttachedToWindow() {
        this.A02.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.A02.onDetachedFromWindow();
    }

    public void onMeasure(int i, int i2) {
        this.A02.onMeasure(i, i2);
    }

    public void onVisibilityChanged(View view, int i) {
        this.A02.onVisibilityChanged(view, i);
    }

    public void onWindowFocusChanged(boolean z) {
        this.A02.onWindowFocusChanged(z);
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        this.A02.setLayoutParams(layoutParams);
    }

    public final void setMeasuredDimension(int i, int i2) {
        this.A02.setMeasuredDimension(i, i2);
    }
}
