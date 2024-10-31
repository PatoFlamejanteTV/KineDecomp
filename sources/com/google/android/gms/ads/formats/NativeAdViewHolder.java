package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbbd;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class NativeAdViewHolder {

    /* renamed from: a */
    public static WeakHashMap<View, NativeAdViewHolder> f9971a = new WeakHashMap<>();

    /* renamed from: b */
    private zzadk f9972b;

    /* renamed from: c */
    private WeakReference<View> f9973c;

    public final void a(NativeAd nativeAd) {
        a((IObjectWrapper) nativeAd.zzhy());
    }

    public final void a(UnifiedNativeAd unifiedNativeAd) {
        a((IObjectWrapper) unifiedNativeAd.zzhy());
    }

    private final void a(IObjectWrapper iObjectWrapper) {
        WeakReference<View> weakReference = this.f9973c;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            zzbbd.zzeo("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!f9971a.containsKey(view)) {
            f9971a.put(view, this);
        }
        zzadk zzadkVar = this.f9972b;
        if (zzadkVar != null) {
            try {
                zzadkVar.zza(iObjectWrapper);
            } catch (RemoteException e2) {
                zzbbd.zzb("Unable to call setNativeAd on delegate", e2);
            }
        }
    }
}
