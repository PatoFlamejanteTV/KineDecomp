package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzxl;
import com.google.android.gms.internal.ads.zzyz;

/* loaded from: classes.dex */
public final class PublisherAdView extends ViewGroup {

    /* renamed from: a */
    private final zzyz f9956a;

    public PublisherAdView(Context context) {
        super(context);
        this.f9956a = new zzyz(this);
    }

    public final boolean a(zzxl zzxlVar) {
        return this.f9956a.zza(zzxlVar);
    }

    public final AdListener getAdListener() {
        return this.f9956a.getAdListener();
    }

    public final AdSize getAdSize() {
        return this.f9956a.getAdSize();
    }

    public final AdSize[] getAdSizes() {
        return this.f9956a.getAdSizes();
    }

    public final String getAdUnitId() {
        return this.f9956a.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.f9956a.getAppEventListener();
    }

    public final String getMediationAdapterClassName() {
        return this.f9956a.getMediationAdapterClassName();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f9956a.getOnCustomRenderedAdLoadedListener();
    }

    public final VideoController getVideoController() {
        return this.f9956a.getVideoController();
    }

    public final VideoOptions getVideoOptions() {
        return this.f9956a.getVideoOptions();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
    protected final void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        } else {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e2) {
                zzbbd.zzb("Unable to retrieve ad size.", e2);
            }
            if (adSize != null) {
                Context context = getContext();
                int b2 = adSize.b(context);
                i3 = adSize.a(context);
                i4 = b2;
            } else {
                i3 = 0;
            }
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public final void setAdListener(AdListener adListener) {
        this.f9956a.setAdListener(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr != null && adSizeArr.length > 0) {
            this.f9956a.zza(adSizeArr);
            return;
        }
        throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
    }

    public final void setAdUnitId(String str) {
        this.f9956a.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.f9956a.setAppEventListener(appEventListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.f9956a.setCorrelator(correlator);
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.f9956a.setManualImpressionsEnabled(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f9956a.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.f9956a.setVideoOptions(videoOptions);
    }
}
