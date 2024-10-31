package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zznm {
    public final String value;
    public final String zzbdi;
    private final String zzze;

    public zznm(String str, String str2, String str3) {
        this.zzbdi = str;
        this.value = str2;
        this.zzze = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznm.class == obj.getClass()) {
            zznm zznmVar = (zznm) obj;
            if (zzqe.zza(this.zzbdi, zznmVar.zzbdi) && zzqe.zza(this.value, zznmVar.value) && zzqe.zza(this.zzze, zznmVar.zzze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzbdi;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.zzze;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }
}
