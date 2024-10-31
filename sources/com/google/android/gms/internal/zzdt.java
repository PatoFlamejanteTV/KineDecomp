package com.google.android.gms.internal;

@zzgr
/* loaded from: classes.dex */
public class zzdt extends zzhz {
    final zziz zzoM;
    final zzdv zzxY;
    private final String zzxZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdt(zziz zzizVar, zzdv zzdvVar, String str) {
        this.zzoM = zzizVar;
        this.zzxY = zzdvVar;
        this.zzxZ = str;
        com.google.android.gms.ads.internal.zzp.r().zza(this);
    }

    @Override // com.google.android.gms.internal.zzhz
    public void onStop() {
        this.zzxY.abort();
    }

    @Override // com.google.android.gms.internal.zzhz
    public void zzbn() {
        try {
            this.zzxY.zzab(this.zzxZ);
        } finally {
            zzid.zzIE.post(new av(this));
        }
    }
}
