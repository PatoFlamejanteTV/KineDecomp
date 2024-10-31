package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzacp;
import com.google.android.gms.internal.ads.zzafc;
import com.google.android.gms.internal.ads.zzafd;
import com.google.android.gms.internal.ads.zzafe;
import com.google.android.gms.internal.ads.zzaff;
import com.google.android.gms.internal.ads.zzafi;
import com.google.android.gms.internal.ads.zzalf;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzvx;
import com.google.android.gms.internal.ads.zzwe;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzxd;
import com.google.android.gms.internal.ads.zzxg;
import com.google.android.gms.internal.ads.zzyx;

/* loaded from: classes.dex */
public class AdLoader {

    /* renamed from: a, reason: collision with root package name */
    private final zzwe f9925a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f9926b;

    /* renamed from: c, reason: collision with root package name */
    private final zzxd f9927c;

    AdLoader(Context context, zzxd zzxdVar) {
        this(context, zzxdVar, zzwe.zzckj);
    }

    private final void a(zzyx zzyxVar) {
        try {
            this.f9927c.zzd(zzwe.zza(this.f9926b, zzyxVar));
        } catch (RemoteException e2) {
            zzbbd.zzb("Failed to load ad.", e2);
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final Context f9928a;

        /* renamed from: b, reason: collision with root package name */
        private final zzxg f9929b;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Context context, String str) {
            this(context, zzwu.zzpw().zzb(context, str, new zzalf()));
            Preconditions.a(context, "context cannot be null");
        }

        @Deprecated
        public Builder a(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.f9929b.zza(new zzafd(onContentAdLoadedListener));
            } catch (RemoteException e2) {
                zzbbd.zzc("Failed to add content ad listener", e2);
            }
            return this;
        }

        @Deprecated
        public Builder a(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.f9929b.zza(new zzafc(onAppInstallAdLoadedListener));
            } catch (RemoteException e2) {
                zzbbd.zzc("Failed to add app install ad listener", e2);
            }
            return this;
        }

        private Builder(Context context, zzxg zzxgVar) {
            this.f9928a = context;
            this.f9929b = zzxgVar;
        }

        public Builder a(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.f9929b.zza(new zzafi(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e2) {
                zzbbd.zzc("Failed to add google native ad listener", e2);
            }
            return this;
        }

        public Builder a(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            try {
                this.f9929b.zza(str, new zzaff(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new zzafe(onCustomClickListener));
            } catch (RemoteException e2) {
                zzbbd.zzc("Failed to add custom template ad listener", e2);
            }
            return this;
        }

        public Builder a(AdListener adListener) {
            try {
                this.f9929b.zzb(new zzvx(adListener));
            } catch (RemoteException e2) {
                zzbbd.zzc("Failed to set AdListener.", e2);
            }
            return this;
        }

        public Builder a(NativeAdOptions nativeAdOptions) {
            try {
                this.f9929b.zza(new zzacp(nativeAdOptions));
            } catch (RemoteException e2) {
                zzbbd.zzc("Failed to specify native ad options", e2);
            }
            return this;
        }

        public AdLoader a() {
            try {
                return new AdLoader(this.f9928a, this.f9929b.zzkd());
            } catch (RemoteException e2) {
                zzbbd.zzb("Failed to build AdLoader.", e2);
                return null;
            }
        }
    }

    private AdLoader(Context context, zzxd zzxdVar, zzwe zzweVar) {
        this.f9926b = context;
        this.f9927c = zzxdVar;
        this.f9925a = zzweVar;
    }

    public void a(AdRequest adRequest) {
        a(adRequest.a());
    }
}
