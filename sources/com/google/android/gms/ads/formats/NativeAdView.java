package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzco;

/* loaded from: classes.dex */
public abstract class NativeAdView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f525a;
    private final zzco b;

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(String str) {
        try {
            zzd zzW = this.b.zzW(str);
            if (zzW != null) {
                return (View) zze.a(zzW);
            }
        } catch (RemoteException e) {
            zzb.b("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, View view) {
        try {
            this.b.zza(str, zze.a(view));
        } catch (RemoteException e) {
            zzb.b("Unable to call setAssetView on delegate", e);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f525a);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.f525a != view) {
            super.bringChildToFront(this.f525a);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f525a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f525a == view) {
            return;
        }
        super.removeView(view);
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.b.zzb((zzd) nativeAd.zzaH());
        } catch (RemoteException e) {
            zzb.b("Unable to call setNativeAd on delegate", e);
        }
    }
}
