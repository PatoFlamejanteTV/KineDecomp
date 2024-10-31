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

@Deprecated
/* loaded from: classes.dex */
public class NativeAdView extends FrameLayout {

    /* renamed from: a */
    private final FrameLayout f9969a;

    /* renamed from: b */
    private final zzadf f9970b;

    public NativeAdView(Context context) {
        super(context);
        this.f9969a = a(context);
        this.f9970b = b();
    }

    private final zzadf b() {
        Preconditions.a(this.f9969a, "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzwu.zzpw().zza(this.f9969a.getContext(), this, this.f9969a);
    }

    public final void a(String str, View view) {
        try {
            this.f9970b.zzb(str, ObjectWrapper.a(view));
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to call setAssetView on delegate", e2);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f9969a);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.f9969a;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public AdChoicesView getAdChoicesView() {
        View a2 = a(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (a2 instanceof AdChoicesView) {
            return (AdChoicesView) a2;
        }
        return null;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzadf zzadfVar = this.f9970b;
        if (zzadfVar != null) {
            try {
                zzadfVar.zzb(ObjectWrapper.a(view), i);
            } catch (RemoteException e2) {
                zzbbd.zzb("Unable to call onVisibilityChanged on delegate", e2);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f9969a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f9969a == view) {
            return;
        }
        super.removeView(view);
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        a(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.f9970b.zza((IObjectWrapper) nativeAd.zzhy());
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to call setNativeAd on delegate", e2);
        }
    }

    public final View a(String str) {
        try {
            IObjectWrapper zzbm = this.f9970b.zzbm(str);
            if (zzbm != null) {
                return (View) ObjectWrapper.a(zzbm);
            }
            return null;
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to call getAssetView on delegate", e2);
            return null;
        }
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9969a = a(context);
        this.f9970b = b();
    }

    public void a() {
        try {
            this.f9970b.destroy();
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to destroy native ad view", e2);
        }
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9969a = a(context);
        this.f9970b = b();
    }

    private final FrameLayout a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f9969a = a(context);
        this.f9970b = b();
    }
}
