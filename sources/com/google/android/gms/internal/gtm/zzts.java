package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzts {
    private static final zzts zzbem = new zzts(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzavs;
    private int zzbal;
    private Object[] zzbcz;
    private int[] zzben;

    private zzts() {
        this(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzts zza(zzts zztsVar, zzts zztsVar2) {
        int i = zztsVar.count + zztsVar2.count;
        int[] copyOf = Arrays.copyOf(zztsVar.zzben, i);
        System.arraycopy(zztsVar2.zzben, 0, copyOf, zztsVar.count, zztsVar2.count);
        Object[] copyOf2 = Arrays.copyOf(zztsVar.zzbcz, i);
        System.arraycopy(zztsVar2.zzbcz, 0, copyOf2, zztsVar.count, zztsVar2.count);
        return new zzts(i, copyOf, copyOf2, true);
    }

    public static zzts zzrj() {
        return zzbem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzts zzrk() {
        return new zzts();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzts)) {
            return false;
        }
        zzts zztsVar = (zzts) obj;
        int i = this.count;
        if (i == zztsVar.count) {
            int[] iArr = this.zzben;
            int[] iArr2 = zztsVar.zzben;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                }
                if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                Object[] objArr = this.zzbcz;
                Object[] objArr2 = zztsVar.zzbcz;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    }
                    if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    }
                    i4++;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzben;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzbcz;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzb(Cb cb) throws IOException {
        if (this.count == 0) {
            return;
        }
        if (cb.a() == zzrc.zze.zzbbc) {
            for (int i = 0; i < this.count; i++) {
                zzb(this.zzben[i], this.zzbcz[i], cb);
            }
            return;
        }
        for (int i2 = this.count - 1; i2 >= 0; i2--) {
            zzb(this.zzben[i2], this.zzbcz[i2], cb);
        }
    }

    public final void zzmi() {
        this.zzavs = false;
    }

    public final int zzpe() {
        int zze;
        int i = this.zzbal;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            int i4 = this.zzben[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                zze = zzqj.zze(i5, ((Long) this.zzbcz[i3]).longValue());
            } else if (i6 == 1) {
                zze = zzqj.zzg(i5, ((Long) this.zzbcz[i3]).longValue());
            } else if (i6 == 2) {
                zze = zzqj.zzc(i5, (zzps) this.zzbcz[i3]);
            } else if (i6 == 3) {
                zze = (zzqj.zzbb(i5) << 1) + ((zzts) this.zzbcz[i3]).zzpe();
            } else if (i6 == 5) {
                zze = zzqj.zzl(i5, ((Integer) this.zzbcz[i3]).intValue());
            } else {
                throw new IllegalStateException(zzrk.zzpt());
            }
            i2 += zze;
        }
        this.zzbal = i2;
        return i2;
    }

    public final int zzrl() {
        int i = this.zzbal;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzqj.zzd(this.zzben[i3] >>> 3, (zzps) this.zzbcz[i3]);
        }
        this.zzbal = i2;
        return i2;
    }

    private zzts(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzbal = -1;
        this.count = i;
        this.zzben = iArr;
        this.zzbcz = objArr;
        this.zzavs = z;
    }

    private static void zzb(int i, Object obj, Cb cb) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            cb.e(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            cb.a(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            cb.a(i2, (zzps) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 == 5) {
                cb.d(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzrk.zzpt());
        }
        if (cb.a() == zzrc.zze.zzbbc) {
            cb.a(i2);
            ((zzts) obj).zzb(cb);
            cb.b(i2);
        } else {
            cb.b(i2);
            ((zzts) obj).zzb(cb);
            cb.a(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Cb cb) throws IOException {
        if (cb.a() == zzrc.zze.zzbbd) {
            for (int i = this.count - 1; i >= 0; i--) {
                cb.zza(this.zzben[i] >>> 3, this.zzbcz[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            cb.zza(this.zzben[i2] >>> 3, this.zzbcz[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            Qa.a(sb, i, String.valueOf(this.zzben[i2] >>> 3), this.zzbcz[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(int i, Object obj) {
        if (this.zzavs) {
            int i2 = this.count;
            if (i2 == this.zzben.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzben = Arrays.copyOf(this.zzben, i3);
                this.zzbcz = Arrays.copyOf(this.zzbcz, i3);
            }
            int[] iArr = this.zzben;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzbcz[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
