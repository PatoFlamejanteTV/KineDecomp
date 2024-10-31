package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zztl {
    final long value;
    final String zzbzf;
    final int zzbzg;

    public zztl(long j, String str, int i) {
        this.value = j;
        this.zzbzf = str;
        this.zzbzg = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zztl)) {
            zztl zztlVar = (zztl) obj;
            if (zztlVar.value == this.value && zztlVar.zzbzg == this.zzbzg) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
