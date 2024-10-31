package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

@zzark
/* loaded from: classes2.dex */
public final class zzbgw extends zzyq {
    private boolean zzcng;
    private boolean zzcnh;
    private zzys zzdnv;
    private final zzbdz zzerw;
    private final boolean zzfai;
    private final boolean zzfaj;
    private boolean zzfak;
    private float zzfam;
    private float zzfan;
    private float zzfao;
    private int zzxe;
    private final Object lock = new Object();
    private boolean zzfal = true;

    public zzbgw(zzbdz zzbdzVar, float f2, boolean z, boolean z2) {
        this.zzerw = zzbdzVar;
        this.zzfam = f2;
        this.zzfai = z;
        this.zzfaj = z2;
    }

    private final void zzf(String str, Map<String, String> map) {
        final HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        zzbcg.zzepo.execute(new Runnable(this, hashMap) { // from class: com.google.android.gms.internal.ads.Of

            /* renamed from: a, reason: collision with root package name */
            private final zzbgw f11733a;

            /* renamed from: b, reason: collision with root package name */
            private final Map f11734b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11733a = this;
                this.f11734b = hashMap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f11733a.zzo(this.f11734b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final float getAspectRatio() {
        float f2;
        synchronized (this.lock) {
            f2 = this.zzfao;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int getPlaybackState() {
        int i;
        synchronized (this.lock) {
            i = this.zzxe;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final boolean isClickToExpandEnabled() {
        boolean z;
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.lock) {
            if (!isCustomControlsEnabled) {
                try {
                    z = this.zzcnh && this.zzfaj;
                } finally {
                }
            }
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzfai && this.zzcng;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final boolean isMuted() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzfal;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final void mute(boolean z) {
        zzf(z ? "mute" : "unmute", null);
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final void pause() {
        zzf("pause", null);
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final void play() {
        zzf("play", null);
    }

    public final void zza(boolean z, boolean z2, boolean z3) {
        synchronized (this.lock) {
            this.zzcng = z2;
            this.zzcnh = z3;
        }
        zzf("initialState", CollectionUtils.a("muteStart", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO, "customControlsRequested", z2 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO, "clickToExpandRequested", z3 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO));
    }

    public final void zzaew() {
        boolean z;
        int i;
        synchronized (this.lock) {
            z = this.zzfal;
            i = this.zzxe;
            this.zzxe = 3;
        }
        zza(i, 3, z, z);
    }

    public final void zzb(zzzw zzzwVar) {
        zza(zzzwVar.zzcnf, zzzwVar.zzcng, zzzwVar.zzcnh);
    }

    public final void zze(float f2) {
        synchronized (this.lock) {
            this.zzfan = f2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Map map) {
        this.zzerw.zza("pubVideoCmd", (Map<String, ?>) map);
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final float zzqf() {
        float f2;
        synchronized (this.lock) {
            f2 = this.zzfam;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final float zzqg() {
        float f2;
        synchronized (this.lock) {
            f2 = this.zzfan;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final zzys zzqh() throws RemoteException {
        zzys zzysVar;
        synchronized (this.lock) {
            zzysVar = this.zzdnv;
        }
        return zzysVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(int i, int i2, boolean z, boolean z2) {
        synchronized (this.lock) {
            boolean z3 = i != i2;
            boolean z4 = !this.zzfak && i2 == 1;
            boolean z5 = z3 && i2 == 1;
            boolean z6 = z3 && i2 == 2;
            boolean z7 = z3 && i2 == 3;
            boolean z8 = z != z2;
            this.zzfak = this.zzfak || z4;
            if (this.zzdnv == null) {
                return;
            }
            if (z4) {
                try {
                    this.zzdnv.onVideoStart();
                } catch (RemoteException e2) {
                    zzbbd.zzc("Unable to call onVideoStart()", e2);
                }
            }
            if (z5) {
                try {
                    this.zzdnv.onVideoPlay();
                } catch (RemoteException e3) {
                    zzbbd.zzc("Unable to call onVideoPlay()", e3);
                }
            }
            if (z6) {
                try {
                    this.zzdnv.onVideoPause();
                } catch (RemoteException e4) {
                    zzbbd.zzc("Unable to call onVideoPause()", e4);
                }
            }
            if (z7) {
                try {
                    this.zzdnv.onVideoEnd();
                } catch (RemoteException e5) {
                    zzbbd.zzc("Unable to call onVideoEnd()", e5);
                }
                this.zzerw.zzacc();
            }
            if (z8) {
                try {
                    this.zzdnv.onVideoMute(z2);
                } catch (RemoteException e6) {
                    zzbbd.zzc("Unable to call onVideoMute()", e6);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final void zza(zzys zzysVar) {
        synchronized (this.lock) {
            this.zzdnv = zzysVar;
        }
    }

    public final void zza(float f2, float f3, int i, boolean z, float f4) {
        boolean z2;
        int i2;
        synchronized (this.lock) {
            this.zzfam = f3;
            this.zzfan = f2;
            z2 = this.zzfal;
            this.zzfal = z;
            i2 = this.zzxe;
            this.zzxe = i;
            float f5 = this.zzfao;
            this.zzfao = f4;
            if (Math.abs(this.zzfao - f5) > 1.0E-4f) {
                this.zzerw.getView().invalidate();
            }
        }
        zza(i2, i, z2, z);
    }

    private final void zza(final int i, final int i2, final boolean z, final boolean z2) {
        zzbcg.zzepo.execute(new Runnable(this, i, i2, z, z2) { // from class: com.google.android.gms.internal.ads.Pf

            /* renamed from: a, reason: collision with root package name */
            private final zzbgw f11749a;

            /* renamed from: b, reason: collision with root package name */
            private final int f11750b;

            /* renamed from: c, reason: collision with root package name */
            private final int f11751c;

            /* renamed from: d, reason: collision with root package name */
            private final boolean f11752d;

            /* renamed from: e, reason: collision with root package name */
            private final boolean f11753e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11749a = this;
                this.f11750b = i;
                this.f11751c = i2;
                this.f11752d = z;
                this.f11753e = z2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f11749a.zzb(this.f11750b, this.f11751c, this.f11752d, this.f11753e);
            }
        });
    }
}
