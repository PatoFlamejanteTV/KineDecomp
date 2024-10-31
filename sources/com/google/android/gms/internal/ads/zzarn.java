package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzuo;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.util.List;

@zzark
/* loaded from: classes2.dex */
public final class zzarn extends zzaxv implements zzasa {
    private final Context mContext;

    @VisibleForTesting
    private zzakr zzdmn;

    @VisibleForTesting
    private zzasi zzdnh;

    @VisibleForTesting
    private zzasm zzdsl;
    private Runnable zzdsm;
    private final Object zzdsn = new Object();
    private final zzarm zzdvp;
    private final zzasj zzdvq;
    private final zzum zzdvr;
    private final zzur zzdvs;

    @VisibleForTesting
    private boolean zzdvt;

    @VisibleForTesting
    private zzazb zzdvu;

    public zzarn(Context context, zzasj zzasjVar, zzarm zzarmVar, zzur zzurVar) {
        this.zzdvp = zzarmVar;
        this.mContext = context;
        this.zzdvq = zzasjVar;
        this.zzdvs = zzurVar;
        this.zzdvr = new zzum(this.zzdvs);
        this.zzdvr.zza(new zzun(this) { // from class: com.google.android.gms.internal.ads.yc

            /* renamed from: a, reason: collision with root package name */
            private final zzarn f12680a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12680a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzun
            public final void zza(zzvp zzvpVar) {
                this.f12680a.zzc(zzvpVar);
            }
        });
        final zzvq zzvqVar = new zzvq();
        zzvqVar.zzchy = Integer.valueOf(this.zzdvq.zzbsp.zzeou);
        zzvqVar.zzchz = Integer.valueOf(this.zzdvq.zzbsp.zzeov);
        zzvqVar.zzcia = Integer.valueOf(this.zzdvq.zzbsp.zzeow ? 0 : 2);
        this.zzdvr.zza(new zzun(zzvqVar) { // from class: com.google.android.gms.internal.ads.zc

            /* renamed from: a, reason: collision with root package name */
            private final zzvq f12698a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12698a = zzvqVar;
            }

            @Override // com.google.android.gms.internal.ads.zzun
            public final void zza(zzvp zzvpVar) {
                zzvpVar.zzchu.zzchf = this.f12698a;
            }
        });
        if (this.zzdvq.zzdwh != null) {
            this.zzdvr.zza(new zzun(this) { // from class: com.google.android.gms.internal.ads.Ac

                /* renamed from: a, reason: collision with root package name */
                private final zzarn f11371a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f11371a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzun
                public final void zza(zzvp zzvpVar) {
                    this.f11371a.zzb(zzvpVar);
                }
            });
        }
        zzwf zzwfVar = this.zzdvq.zzbst;
        if (zzwfVar.zzckl && "interstitial_mb".equals(zzwfVar.zzckk)) {
            this.zzdvr.zza(Bc.f11399a);
        } else if (zzwfVar.zzckl && "reward_mb".equals(zzwfVar.zzckk)) {
            this.zzdvr.zza(Cc.f11438a);
        } else if (!zzwfVar.zzckn && !zzwfVar.zzckl) {
            this.zzdvr.zza(Dc.f11458a);
        } else {
            this.zzdvr.zza(Ec.f11484a);
        }
        this.zzdvr.zza(zzuo.zza.zzb.AD_REQUEST);
    }

    private final void zzd(int i, String str) {
        if (i != 3 && i != -1) {
            zzbbd.zzeo(str);
        } else {
            zzbbd.zzen(str);
        }
        zzasm zzasmVar = this.zzdsl;
        if (zzasmVar == null) {
            this.zzdsl = new zzasm(i);
        } else {
            this.zzdsl = new zzasm(i, zzasmVar.zzdlx);
        }
        zzasi zzasiVar = this.zzdnh;
        if (zzasiVar == null) {
            zzasiVar = new zzasi(this.zzdvq, -1L, null, null, null, null);
        }
        zzasm zzasmVar2 = this.zzdsl;
        this.zzdvp.zza(new zzaxg(zzasiVar, zzasmVar2, this.zzdmn, null, i, -1L, zzasmVar2.zzdyh, null, this.zzdvr, null));
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
        synchronized (this.zzdsn) {
            if (this.zzdvu != null) {
                this.zzdvu.cancel();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b9  */
    @Override // com.google.android.gms.internal.ads.zzasa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.ads.zzasm r14) {
        /*
            Method dump skipped, instructions count: 549
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzarn.zza(com.google.android.gms.internal.ads.zzasm):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzvp zzvpVar) {
        zzvpVar.zzchu.zzchc = this.zzdvq.zzdwh.packageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzvp zzvpVar) {
        zzvpVar.zzchp = this.zzdvq.zzdws;
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        String string;
        zzbbd.zzdn("AdLoaderBackgroundTask started.");
        this.zzdsm = new Runnable(this) { // from class: com.google.android.gms.internal.ads.Fc

            /* renamed from: a, reason: collision with root package name */
            private final zzarn f11525a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11525a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f11525a.zzwh();
            }
        };
        zzayh.zzelc.postDelayed(this.zzdsm, ((Long) zzwu.zzpz().zzd(zzaan.zzcte)).longValue());
        long c2 = com.google.android.gms.ads.internal.zzbv.l().c();
        Bundle bundle = this.zzdvq.zzdwg.extras;
        if (bundle != null && (string = bundle.getString("_ad")) != null) {
            this.zzdnh = new zzasi(this.zzdvq, c2, null, null, null, null);
            zza(zzatv.zza(this.mContext, this.zzdnh, string));
        } else {
            final zzbcr zzbcrVar = new zzbcr();
            zzayf.zzc(new Runnable(this, zzbcrVar) { // from class: com.google.android.gms.internal.ads.Gc

                /* renamed from: a, reason: collision with root package name */
                private final zzarn f11542a;

                /* renamed from: b, reason: collision with root package name */
                private final zzbcn f11543b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f11542a = this;
                    this.f11543b = zzbcrVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f11542a.zza(this.f11543b);
                }
            });
            this.zzdnh = new zzasi(this.zzdvq, c2, com.google.android.gms.ads.internal.zzbv.E().zzx(this.mContext), com.google.android.gms.ads.internal.zzbv.E().zzy(this.mContext), com.google.android.gms.ads.internal.zzbv.E().zzz(this.mContext), com.google.android.gms.ads.internal.zzbv.E().zzaa(this.mContext));
            zzbcrVar.zzo(this.zzdnh);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzwh() {
        synchronized (this.zzdsn) {
            this.zzdvt = true;
            if (this.zzdvu != null) {
                onStop();
            }
            zzd(2, "Timed out waiting for ad response.");
        }
    }

    @VisibleForTesting
    private final zzwf zza(zzasi zzasiVar) throws zzarx {
        zzakr zzakrVar;
        List<Integer> list;
        zzasi zzasiVar2 = this.zzdnh;
        if (((zzasiVar2 == null || (list = zzasiVar2.zzbtn) == null || list.size() <= 1) ? false : true) && (zzakrVar = this.zzdmn) != null && !zzakrVar.zzdmi) {
            return null;
        }
        if (this.zzdsl.zzcko) {
            for (zzwf zzwfVar : zzasiVar.zzbst.zzckm) {
                if (zzwfVar.zzcko) {
                    return new zzwf(zzwfVar, zzasiVar.zzbst.zzckm);
                }
            }
        }
        String str = this.zzdsl.zzdyg;
        if (str != null) {
            String[] split = str.split(FragmentC2201x.f23219a);
            if (split.length != 2) {
                String valueOf = String.valueOf(this.zzdsl.zzdyg);
                throw new zzarx(valueOf.length() != 0 ? "Invalid ad size format from the ad response: ".concat(valueOf) : new String("Invalid ad size format from the ad response: "), 0);
            }
            try {
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                for (zzwf zzwfVar2 : zzasiVar.zzbst.zzckm) {
                    float f2 = this.mContext.getResources().getDisplayMetrics().density;
                    int i = zzwfVar2.width;
                    if (i == -1) {
                        i = (int) (zzwfVar2.widthPixels / f2);
                    }
                    int i2 = zzwfVar2.height;
                    if (i2 == -2) {
                        i2 = (int) (zzwfVar2.heightPixels / f2);
                    }
                    if (parseInt == i && parseInt2 == i2 && !zzwfVar2.zzcko) {
                        return new zzwf(zzwfVar2, zzasiVar.zzbst.zzckm);
                    }
                }
                String valueOf2 = String.valueOf(this.zzdsl.zzdyg);
                throw new zzarx(valueOf2.length() != 0 ? "The ad size from the ad response was not one of the requested sizes: ".concat(valueOf2) : new String("The ad size from the ad response was not one of the requested sizes: "), 0);
            } catch (NumberFormatException unused) {
                String valueOf3 = String.valueOf(this.zzdsl.zzdyg);
                throw new zzarx(valueOf3.length() != 0 ? "Invalid ad size number from the ad response: ".concat(valueOf3) : new String("Invalid ad size number from the ad response: "), 0);
            }
        }
        throw new zzarx("The ad response must specify one of the supported ad sizes.", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbcn zzbcnVar) {
        zzazb zzasgVar;
        synchronized (this.zzdsn) {
            if (this.zzdvt) {
                zzbbd.zzeo("Request task was already canceled");
                return;
            }
            zzbbi zzbbiVar = this.zzdvq.zzbsp;
            Context context = this.mContext;
            if (new Hc(context).a(zzbbiVar)) {
                zzbbd.zzdn("Fetching ad response from local ad request service.");
                zzasgVar = new zzasf(context, zzbcnVar, this);
                zzasgVar.zzwa();
            } else {
                zzbbd.zzdn("Fetching ad response from remote ad request service.");
                zzwu.zzpv();
                if (!zzbat.zzc(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzbbd.zzeo("Failed to connect to remote ad request service.");
                    zzasgVar = null;
                } else {
                    zzasgVar = new zzasg(context, zzbbiVar, zzbcnVar, this);
                }
            }
            this.zzdvu = zzasgVar;
            if (this.zzdvu == null) {
                zzd(0, "Could not start the ad request service.");
                zzayh.zzelc.removeCallbacks(this.zzdsm);
            }
        }
    }
}
