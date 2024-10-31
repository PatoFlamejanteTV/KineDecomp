package com.google.android.gms.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzyz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    protected final zzyz f9953a;

    public a(Context context, int i) {
        super(context);
        this.f9953a = new zzyz(this, i);
    }

    public void a() {
        this.f9953a.destroy();
    }

    public void b() {
        this.f9953a.pause();
    }

    public void c() {
        this.f9953a.resume();
    }

    public AdListener getAdListener() {
        return this.f9953a.getAdListener();
    }

    public AdSize getAdSize() {
        return this.f9953a.getAdSize();
    }

    public String getAdUnitId() {
        return this.f9953a.getAdUnitId();
    }

    public String getMediationAdapterClassName() {
        return this.f9953a.getMediationAdapterClassName();
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

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(AdListener adListener) {
        this.f9953a.setAdListener(adListener);
        if (adListener == 0) {
            this.f9953a.zza((zzvt) null);
            this.f9953a.setAppEventListener(null);
            return;
        }
        if (adListener instanceof zzvt) {
            this.f9953a.zza((zzvt) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.f9953a.setAppEventListener((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.f9953a.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.f9953a.setAdUnitId(str);
    }

    public void a(AdRequest adRequest) {
        this.f9953a.zza(adRequest.a());
    }
}
