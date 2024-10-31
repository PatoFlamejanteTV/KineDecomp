package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzlz {
    public final int length;
    private int zzaac;
    private final zzfs[] zzayc;

    public zzlz(zzfs... zzfsVarArr) {
        zzpo.checkState(zzfsVarArr.length > 0);
        this.zzayc = zzfsVarArr;
        this.length = zzfsVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlz.class == obj.getClass()) {
            zzlz zzlzVar = (zzlz) obj;
            if (this.length == zzlzVar.length && Arrays.equals(this.zzayc, zzlzVar.zzayc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzaac == 0) {
            this.zzaac = Arrays.hashCode(this.zzayc) + 527;
        }
        return this.zzaac;
    }

    public final zzfs zzat(int i) {
        return this.zzayc[i];
    }

    public final int zzi(zzfs zzfsVar) {
        int i = 0;
        while (true) {
            zzfs[] zzfsVarArr = this.zzayc;
            if (i >= zzfsVarArr.length) {
                return -1;
            }
            if (zzfsVar == zzfsVarArr[i]) {
                return i;
            }
            i++;
        }
    }
}
