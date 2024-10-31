package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzd;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzel;

/* loaded from: classes.dex */
public class AdLoader {

    /* renamed from: a */
    private final zzh f512a;
    private final Context b;
    private final zzp c;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        private final Context f513a;
        private final zzq b;

        Builder(Context context, zzq zzqVar) {
            this.f513a = context;
            this.b = zzqVar;
        }

        public Builder(Context context, String str) {
            this(context, zzd.a(context, str, new zzel()));
        }

        public Builder a(AdListener adListener) {
            try {
                this.b.a(new zzc(adListener));
            } catch (RemoteException e) {
                zzb.d("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder a(NativeAdOptions nativeAdOptions) {
            try {
                this.b.a(new NativeAdOptionsParcel(nativeAdOptions));
            } catch (RemoteException e) {
                zzb.d("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder a(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.b.a(new zzdb(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzb.d("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder a(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.b.a(new zzdc(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzb.d("Failed to add content ad listener", e);
            }
            return this;
        }

        public AdLoader a() {
            try {
                return new AdLoader(this.f513a, this.b.a());
            } catch (RemoteException e) {
                zzb.b("Failed to build AdLoader.", e);
                return null;
            }
        }
    }

    AdLoader(Context context, zzp zzpVar) {
        this(context, zzpVar, zzh.a());
    }

    AdLoader(Context context, zzp zzpVar, zzh zzhVar) {
        this.b = context;
        this.c = zzpVar;
        this.f512a = zzhVar;
    }

    private void a(zzy zzyVar) {
        try {
            this.c.a(this.f512a.a(this.b, zzyVar));
        } catch (RemoteException e) {
            zzb.b("Failed to load ad.", e);
        }
    }

    public void a(AdRequest adRequest) {
        a(adRequest.a());
    }
}
