package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzfy {
    public static final zzfy zzaaf = new zzfy(1.0f, 1.0f);
    public final float zzaag;
    public final float zzaah;
    private final int zzaai;

    public zzfy(float f2, float f3) {
        this.zzaag = f2;
        this.zzaah = f3;
        this.zzaai = Math.round(f2 * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzfy.class == obj.getClass()) {
            zzfy zzfyVar = (zzfy) obj;
            if (this.zzaag == zzfyVar.zzaag && this.zzaah == zzfyVar.zzaah) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzaag) + 527) * 31) + Float.floatToRawIntBits(this.zzaah);
    }

    public final long zzl(long j) {
        return j * this.zzaai;
    }
}
