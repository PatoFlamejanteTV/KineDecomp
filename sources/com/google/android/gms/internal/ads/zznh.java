package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zznh {
    private long zzaze;
    public final zzmf zzbat;
    public zznp zzbck;
    public zznd zzbcl;
    private int zzbcm;

    public zznh(long j, zznp zznpVar, boolean z, boolean z2) {
        zzhz zzjiVar;
        this.zzaze = j;
        this.zzbck = zznpVar;
        String str = zznpVar.zzaad.zzzi;
        if (zzpt.zzad(str) || "application/ttml+xml".equals(str)) {
            this.zzbat = null;
        } else {
            if ("application/x-rawcc".equals(str)) {
                zzjiVar = new zzjw(zznpVar.zzaad);
            } else {
                if (str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm")) {
                    zzjiVar = new zzip(1);
                } else {
                    int i = z ? 4 : 0;
                    zzjiVar = new zzji(z2 ? i | 8 : i);
                }
            }
            this.zzbat = new zzmf(zzjiVar, zznpVar.zzaad);
        }
        this.zzbcl = zznpVar.zzgj();
    }

    public final void zza(long j, zznp zznpVar) throws zzkz {
        int zzai;
        zznd zzgj = this.zzbck.zzgj();
        zznd zzgj2 = zznpVar.zzgj();
        this.zzaze = j;
        this.zzbck = zznpVar;
        if (zzgj == null) {
            return;
        }
        this.zzbcl = zzgj2;
        if (zzgj.zzge() && (zzai = zzgj.zzai(this.zzaze)) != 0) {
            int zzgd = (zzgj.zzgd() + zzai) - 1;
            long zzaw = zzgj.zzaw(zzgd) + zzgj.zze(zzgd, this.zzaze);
            int zzgd2 = zzgj2.zzgd();
            long zzaw2 = zzgj2.zzaw(zzgd2);
            if (zzaw == zzaw2) {
                this.zzbcm += (zzgd + 1) - zzgd2;
            } else {
                if (zzaw >= zzaw2) {
                    this.zzbcm += zzgj.zzf(zzaw2, this.zzaze) - zzgd2;
                    return;
                }
                throw new zzkz();
            }
        }
    }

    public final int zzaj(long j) {
        return this.zzbcl.zzf(j, this.zzaze) + this.zzbcm;
    }

    public final zzno zzax(int i) {
        return this.zzbcl.zzax(i - this.zzbcm);
    }

    public final long zzay(int i) {
        return this.zzbcl.zzaw(i - this.zzbcm);
    }

    public final long zzaz(int i) {
        return zzay(i) + this.zzbcl.zze(i - this.zzbcm, this.zzaze);
    }

    public final int zzgd() {
        return this.zzbcl.zzgd() + this.zzbcm;
    }

    public final int zzgg() {
        return this.zzbcl.zzai(this.zzaze);
    }
}
