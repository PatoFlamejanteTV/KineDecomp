package com.google.android.gms.internal.ads;

import com.google.protos.datapol.SemanticAnnotations;

/* loaded from: classes2.dex */
public final class zzh implements zzab {
    private int zzr;
    private int zzs;
    private final int zzt;
    private final float zzu;

    public zzh() {
        this(SemanticAnnotations.SemanticType.ST_AVOCADO_ID_VALUE, 1, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzab
    public final void zza(zzae zzaeVar) throws zzae {
        this.zzs++;
        int i = this.zzr;
        this.zzr = i + ((int) (i * this.zzu));
        if (!(this.zzs <= this.zzt)) {
            throw zzaeVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzab
    public final int zzc() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzab
    public final int zzd() {
        return this.zzs;
    }

    private zzh(int i, int i2, float f2) {
        this.zzr = SemanticAnnotations.SemanticType.ST_AVOCADO_ID_VALUE;
        this.zzt = 1;
        this.zzu = 1.0f;
    }
}
