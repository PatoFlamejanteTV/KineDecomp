package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzma {
    public static final zzma zzazi = new zzma(new zzlz[0]);
    public final int length;
    private int zzaac;
    private final zzlz[] zzazj;

    public zzma(zzlz... zzlzVarArr) {
        this.zzazj = zzlzVarArr;
        this.length = zzlzVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzma.class == obj.getClass()) {
            zzma zzmaVar = (zzma) obj;
            if (this.length == zzmaVar.length && Arrays.equals(this.zzazj, zzmaVar.zzazj)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzaac == 0) {
            this.zzaac = Arrays.hashCode(this.zzazj);
        }
        return this.zzaac;
    }

    public final int zza(zzlz zzlzVar) {
        for (int i = 0; i < this.length; i++) {
            if (this.zzazj[i] == zzlzVar) {
                return i;
            }
        }
        return -1;
    }

    public final zzlz zzau(int i) {
        return this.zzazj[i];
    }
}
