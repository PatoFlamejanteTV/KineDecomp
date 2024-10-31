package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzz;

/* loaded from: classes.dex */
public final class PublisherAdView extends ViewGroup {

    /* renamed from: a */
    private final zzz f522a;

    public AdListener getAdListener() {
        return this.f522a.b();
    }

    public AdSize getAdSize() {
        return this.f522a.c();
    }

    public AdSize[] getAdSizes() {
        return this.f522a.d();
    }

    public String getAdUnitId() {
        return this.f522a.e();
    }

    public AppEventListener getAppEventListener() {
        return this.f522a.f();
    }

    public String getMediationAdapterClassName() {
        return this.f522a.k();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f522a.h();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = getAdSize();
            if (adSize != null) {
                Context context = getContext();
                i3 = adSize.b(context);
                i4 = adSize.a(context);
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i3 = childAt.getMeasuredWidth();
            i4 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i3, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i2));
    }

    public void setAdListener(AdListener adListener) {
        this.f522a.a(adListener);
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.f522a.b(adSizeArr);
    }

    public void setAdUnitId(String str) {
        this.f522a.a(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.f522a.a(appEventListener);
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.f522a.a(z);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f522a.a(onCustomRenderedAdLoadedListener);
    }
}
