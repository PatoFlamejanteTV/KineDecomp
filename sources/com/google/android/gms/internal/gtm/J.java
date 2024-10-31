package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
final class J extends zzam implements zzbp<zzcy> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcy f13160a;

    public J(zzap zzapVar) {
        super(zzapVar);
        this.f13160a = new zzcy();
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zza(String str, boolean z) {
        if ("ga_autoActivityTracking".equals(str)) {
            this.f13160a.zzacp = z ? 1 : 0;
        } else if ("ga_anonymizeIp".equals(str)) {
            this.f13160a.zzacq = z ? 1 : 0;
        } else if ("ga_reportUncaughtExceptions".equals(str)) {
            this.f13160a.zzacr = z ? 1 : 0;
        } else {
            zzd("bool configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzb(String str, String str2) {
        this.f13160a.zzacs.put(str, str2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzc(String str, String str2) {
        if ("ga_trackingId".equals(str)) {
            this.f13160a.zzacm = str2;
            return;
        }
        if ("ga_sampleFrequency".equals(str)) {
            try {
                this.f13160a.zzacn = Double.parseDouble(str2);
                return;
            } catch (NumberFormatException e2) {
                zzc("Error parsing ga_sampleFrequency value", str2, e2);
                return;
            }
        }
        zzd("string configuration name not recognized", str);
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final /* synthetic */ zzcy zzel() {
        return this.f13160a;
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzb(String str, int i) {
        if ("ga_sessionTimeout".equals(str)) {
            this.f13160a.zzaco = i;
        } else {
            zzd("int configuration name not recognized", str);
        }
    }
}
