package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzoo {
    public final int length;
    private int zzaac;
    private final zzom[] zzbfi;

    public zzoo(zzom... zzomVarArr) {
        this.zzbfi = zzomVarArr;
        this.length = zzomVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzoo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbfi, ((zzoo) obj).zzbfi);
    }

    public final int hashCode() {
        if (this.zzaac == 0) {
            this.zzaac = Arrays.hashCode(this.zzbfi) + 527;
        }
        return this.zzaac;
    }

    public final zzom zzbe(int i) {
        return this.zzbfi[i];
    }

    public final zzom[] zzgp() {
        return (zzom[]) this.zzbfi.clone();
    }
}
