package com.google.android.gms.ads.search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzyz;

@zzark
/* loaded from: classes.dex */
public final class SearchAdView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private final zzyz f10312a;

    public final AdListener getAdListener() {
        return this.f10312a.getAdListener();
    }

    public final AdSize getAdSize() {
        return this.f10312a.getAdSize();
    }

    public final String getAdUnitId() {
        return this.f10312a.getAdUnitId();
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
        this.f10312a.setAdListener(adListener);
    }

    public final void setAdSize(AdSize adSize) {
        this.f10312a.setAdSizes(adSize);
    }

    public final void setAdUnitId(String str) {
        this.f10312a.setAdUnitId(str);
    }
}
