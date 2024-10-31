package com.google.android.gms.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;

/* loaded from: classes.dex */
public final class AdView extends ViewGroup {

    /* renamed from: a */
    private final zzz f517a;

    public AdView(Context context) {
        super(context);
        this.f517a = new zzz(this);
    }

    public void a() {
        this.f517a.a();
    }

    public void a(AdRequest adRequest) {
        this.f517a.a(adRequest.a());
    }

    public void b() {
        this.f517a.i();
    }

    public void c() {
        this.f517a.j();
    }

    public AdListener getAdListener() {
        return this.f517a.b();
    }

    public AdSize getAdSize() {
        return this.f517a.c();
    }

    public String getAdUnitId() {
        return this.f517a.e();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.f517a.g();
    }

    public String getMediationAdapterClassName() {
        return this.f517a.k();
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

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(AdListener adListener) {
        this.f517a.a(adListener);
        if (adListener != 0 && (adListener instanceof com.google.android.gms.ads.internal.client.zza)) {
            this.f517a.a((com.google.android.gms.ads.internal.client.zza) adListener);
        } else if (adListener == 0) {
            this.f517a.a((com.google.android.gms.ads.internal.client.zza) null);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.f517a.a(adSize);
    }

    public void setAdUnitId(String str) {
        this.f517a.a(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.f517a.a(inAppPurchaseListener);
    }
}
