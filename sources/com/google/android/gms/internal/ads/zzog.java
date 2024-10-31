package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzog extends zzoj {
    private static final int[] zzbem = new int[0];
    private final zzon zzben;
    private final AtomicReference<zzoh> zzbeo;

    public zzog() {
        this(null);
    }

    private static int zze(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    private static boolean zze(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x017c, code lost:            if (r10 <= r15) goto L80;     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ae  */
    @Override // com.google.android.gms.internal.ads.zzoj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.google.android.gms.internal.ads.zzom[] zza(com.google.android.gms.internal.ads.zzga[] r36, com.google.android.gms.internal.ads.zzma[] r37, int[][][] r38) throws com.google.android.gms.internal.ads.zzff {
        /*
            Method dump skipped, instructions count: 1107
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzog.zza(com.google.android.gms.internal.ads.zzga[], com.google.android.gms.internal.ads.zzma[], int[][][]):com.google.android.gms.internal.ads.zzom[]");
    }

    private zzog(zzon zzonVar) {
        this.zzben = null;
        this.zzbeo = new AtomicReference<>(new zzoh());
    }

    private static boolean zza(zzfs zzfsVar, String str) {
        return str != null && TextUtils.equals(str, zzqe.zzai(zzfsVar.zzaaa));
    }
}
