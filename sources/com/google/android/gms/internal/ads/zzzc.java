package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzark
/* loaded from: classes2.dex */
public final class zzzc {
    private static final Object lock = new Object();
    private static zzzc zzcmu;
    private zzyc zzcmv;
    private RewardedVideoAd zzcmw;

    private zzzc() {
    }

    public static zzzc zzqq() {
        zzzc zzzcVar;
        synchronized (lock) {
            if (zzcmu == null) {
                zzcmu = new zzzc();
            }
            zzzcVar = zzcmu;
        }
        return zzzcVar;
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        synchronized (lock) {
            if (this.zzcmw != null) {
                return this.zzcmw;
            }
            this.zzcmw = new zzavj(context, new tn(zzwu.zzpw(), context, new zzalf()).a(context, false));
            return this.zzcmw;
        }
    }

    public final void openDebugMenu(Context context, String str) {
        Preconditions.b(this.zzcmv != null, "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.zzcmv.zzb(ObjectWrapper.a(context), str);
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to open debug menu.", e2);
        }
    }

    public final void registerRtbAdapter(Class<? extends zzbit> cls) {
        try {
            this.zzcmv.zzau(cls.getCanonicalName());
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to register RtbAdapter", e2);
        }
    }

    public final void setAppMuted(boolean z) {
        Preconditions.b(this.zzcmv != null, "MobileAds.initialize() must be called prior to setting app muted state.");
        try {
            this.zzcmv.setAppMuted(z);
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to set app mute state.", e2);
        }
    }

    public final void setAppVolume(float f2) {
        Preconditions.a(0.0f <= f2 && f2 <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        Preconditions.b(this.zzcmv != null, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzcmv.setAppVolume(f2);
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to set app volume.", e2);
        }
    }

    public final void zza(final Context context, String str, zzzf zzzfVar) {
        synchronized (lock) {
            if (this.zzcmv != null) {
                return;
            }
            if (context != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("measurementEnabled", false);
                    zzakm.zza(context, str, bundle);
                    this.zzcmv = new qn(zzwu.zzpw(), context).a(context, false);
                    this.zzcmv.zza();
                    this.zzcmv.zza(new zzalf());
                    if (str != null) {
                        this.zzcmv.zza(str, ObjectWrapper.a(new Runnable(this, context) { // from class: com.google.android.gms.internal.ads.wn

                            /* renamed from: a, reason: collision with root package name */
                            private final zzzc f12646a;

                            /* renamed from: b, reason: collision with root package name */
                            private final Context f12647b;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f12646a = this;
                                this.f12647b = context;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f12646a.getRewardedVideoAdInstance(this.f12647b);
                            }
                        }));
                    }
                } catch (RemoteException e2) {
                    zzbbd.zzc("MobileAdsSettingManager initialization failed", e2);
                }
                return;
            }
            throw new IllegalArgumentException("Context cannot be null.");
        }
    }

    public final float zzkj() {
        zzyc zzycVar = this.zzcmv;
        if (zzycVar == null) {
            return 1.0f;
        }
        try {
            return zzycVar.zzkj();
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to get app volume.", e2);
            return 1.0f;
        }
    }

    public final boolean zzkk() {
        zzyc zzycVar = this.zzcmv;
        if (zzycVar == null) {
            return false;
        }
        try {
            return zzycVar.zzkk();
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to get app mute state.", e2);
            return false;
        }
    }

    public final String zzkl() {
        try {
            this.zzcmv.zzkl();
            return "";
        } catch (RemoteException e2) {
            zzbbd.zzb("Unable to get version string.", e2);
            return "";
        }
    }
}
