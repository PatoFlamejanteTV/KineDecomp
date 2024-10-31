package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzij {
    public final int zzahg = 1;
    public final byte[] zzahh;

    public zzij(int i, byte[] bArr) {
        this.zzahh = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzij.class == obj.getClass()) {
            zzij zzijVar = (zzij) obj;
            if (this.zzahg == zzijVar.zzahg && Arrays.equals(this.zzahh, zzijVar.zzahh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zzahg * 31) + Arrays.hashCode(this.zzahh);
    }
}
