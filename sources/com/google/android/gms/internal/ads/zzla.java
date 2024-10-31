package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzla implements zzlw {
    private final zzlw[] zzawm;

    public zzla(zzlw[] zzlwVarArr) {
        this.zzawm = zzlwVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzlw
    public final long zzeu() {
        long j = Long.MAX_VALUE;
        for (zzlw zzlwVar : this.zzawm) {
            long zzeu = zzlwVar.zzeu();
            if (zzeu != Long.MIN_VALUE) {
                j = Math.min(j, zzeu);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzlw
    public final boolean zzy(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long zzeu = zzeu();
            if (zzeu == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zzlw zzlwVar : this.zzawm) {
                if (zzlwVar.zzeu() == zzeu) {
                    z |= zzlwVar.zzy(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
