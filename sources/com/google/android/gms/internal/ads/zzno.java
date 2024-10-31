package com.google.android.gms.internal.ads;

import android.net.Uri;

/* loaded from: classes2.dex */
public final class zzno {
    private int zzaac;
    public final long zzbdk;
    private final String zzbdl;
    public final long zzcc;

    public zzno(String str, long j, long j2) {
        this.zzbdl = str == null ? "" : str;
        this.zzbdk = j;
        this.zzcc = j2;
    }

    private final String zzz(String str) {
        return zzqd.zzc(str, this.zzbdl);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzno.class == obj.getClass()) {
            zzno zznoVar = (zzno) obj;
            if (this.zzbdk == zznoVar.zzbdk && this.zzcc == zznoVar.zzcc && this.zzbdl.equals(zznoVar.zzbdl)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzaac == 0) {
            this.zzaac = ((((((int) this.zzbdk) + 527) * 31) + ((int) this.zzcc)) * 31) + this.zzbdl.hashCode();
        }
        return this.zzaac;
    }

    public final zzno zza(zzno zznoVar, String str) {
        String zzz = zzz(str);
        if (zznoVar != null && zzz.equals(zznoVar.zzz(str))) {
            long j = this.zzcc;
            if (j != -1) {
                long j2 = this.zzbdk;
                if (j2 + j == zznoVar.zzbdk) {
                    long j3 = zznoVar.zzcc;
                    return new zzno(zzz, j2, j3 != -1 ? j + j3 : -1L);
                }
            }
            long j4 = zznoVar.zzcc;
            if (j4 != -1) {
                long j5 = zznoVar.zzbdk;
                if (j5 + j4 == this.zzbdk) {
                    long j6 = this.zzcc;
                    return new zzno(zzz, j5, j6 != -1 ? j4 + j6 : -1L);
                }
            }
        }
        return null;
    }

    public final Uri zzy(String str) {
        return Uri.parse(zzqd.zzc(str, this.zzbdl));
    }
}
