package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzadf;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzwu;

/* loaded from: classes.dex */
public final class UnifiedNativeAdView extends FrameLayout {

    /* renamed from: a */
    private final FrameLayout f9977a;

    /* renamed from: b */
    private final zzadf f9978b;

    public UnifiedNativeAdView(Context context) {
        super(context);
        this.f9977a = a(context);
        this.f9978b = a();
    }

    private final void a(String str, View view) {
        try {
            this.f9978b.zzb(str, ObjectWrapper.a(view));
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to call setAssetView on delegate", e2);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f9977a);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.f9977a;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public final AdChoicesView getAdChoicesView() {
        View a2 = a("3011");
        if (a2 instanceof AdChoicesView) {
            return (AdChoicesView) a2;
        }
        return null;
    }

    public final View getAdvertiserView() {
        return a("3005");
    }

    public final View getBodyView() {
        return a("3004");
    }

    public final View getCallToActionView() {
        return a("3002");
    }

    public final View getHeadlineView() {
        return a("3001");
    }

    public final View getIconView() {
        return a("3003");
    }

    public final View getImageView() {
        return a("3008");
    }

    public final MediaView getMediaView() {
        View a2 = a("3010");
        if (a2 instanceof MediaView) {
            return (MediaView) a2;
        }
        if (a2 == null) {
            return null;
        }
        zzbbd.zzdn("View is not an instance of MediaView");
        return null;
    }

    public final View getPriceView() {
        return a("3007");
    }

    public final View getStarRatingView() {
        return a("3009");
    }

    public final View getStoreView() {
        return a("3006");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzadf zzadfVar = this.f9978b;
        if (zzadfVar != null) {
            try {
                zzadfVar.zzb(ObjectWrapper.a(view), i);
            } catch (RemoteException e2) {
                zzbbd.zzb("Unable to call onVisibilityChanged on delegate", e2);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f9977a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.f9977a == view) {
            return;
        }
        super.removeView(view);
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        a("3011", adChoicesView);
    }

    public final void setAdvertiserView(View view) {
        a("3005", view);
    }

    public final void setBodyView(View view) {
        a("3004", view);
    }

    public final void setCallToActionView(View view) {
        a("3002", view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.f9978b.zzc(ObjectWrapper.a(view));
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to call setClickConfirmingView on delegate", e2);
        }
    }

    public final void setHeadlineView(View view) {
        a("3001", view);
    }

    public final void setIconView(View view) {
        a("3003", view);
    }

    public final void setImageView(View view) {
        a("3008", view);
    }

    public final void setMediaView(MediaView mediaView) {
        a("3010", mediaView);
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        try {
            this.f9978b.zza((IObjectWrapper) unifiedNativeAd.zzhy());
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to call setNativeAd on delegate", e2);
        }
    }

    public final void setPriceView(View view) {
        a("3007", view);
    }

    public final void setStarRatingView(View view) {
        a("3009", view);
    }

    public final void setStoreView(View view) {
        a("3006", view);
    }

    private final View a(String str) {
        try {
            IObjectWrapper zzbm = this.f9978b.zzbm(str);
            if (zzbm != null) {
                return (View) ObjectWrapper.a(zzbm);
            }
            return null;
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to call getAssetView on delegate", e2);
            return null;
        }
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9977a = a(context);
        this.f9978b = a();
    }

    private final FrameLayout a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9977a = a(context);
        this.f9978b = a();
    }

    private final zzadf a() {
        Preconditions.a(this.f9977a, "createDelegate must be called after overlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzwu.zzpw().zza(this.f9977a.getContext(), this, this.f9977a);
    }

    @TargetApi(21)
    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f9977a = a(context);
        this.f9978b = a();
    }
}
