package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzir {
    private static final zzir zzabp = new zzir(0, new int[0], new Object[0], false);
    private int count;
    private int[] zzabq;
    private boolean zzsh;
    private int zzwz;
    private Object[] zzzm;

    private zzir() {
        this(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzir zza(zzir zzirVar, zzir zzirVar2) {
        int i = zzirVar.count + zzirVar2.count;
        int[] copyOf = Arrays.copyOf(zzirVar.zzabq, i);
        System.arraycopy(zzirVar2.zzabq, 0, copyOf, zzirVar.count, zzirVar2.count);
        Object[] copyOf2 = Arrays.copyOf(zzirVar.zzzm, i);
        System.arraycopy(zzirVar2.zzzm, 0, copyOf2, zzirVar.count, zzirVar2.count);
        return new zzir(i, copyOf, copyOf2, true);
    }

    public static zzir zzjp() {
        return zzabp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzir zzjq() {
        return new zzir();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzir)) {
            return false;
        }
        zzir zzirVar = (zzir) obj;
        int i = this.count;
        if (i == zzirVar.count) {
            int[] iArr = this.zzabq;
            int[] iArr2 = zzirVar.zzabq;
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
                Object[] objArr = this.zzzm;
                Object[] objArr2 = zzirVar.zzzm;
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
        int[] iArr = this.zzabq;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzzm;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzb(Ra ra) throws IOException {
        if (this.count == 0) {
            return;
        }
        if (ra.zzgl() == zzft.zze.zzxq) {
            for (int i = 0; i < this.count; i++) {
                zzb(this.zzabq[i], this.zzzm[i], ra);
            }
            return;
        }
        for (int i2 = this.count - 1; i2 >= 0; i2--) {
            zzb(this.zzabq[i2], this.zzzm[i2], ra);
        }
    }

    public final void zzev() {
        this.zzsh = false;
    }

    public final int zzgw() {
        int zze;
        int i = this.zzwz;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            int i4 = this.zzabq[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                zze = zzfa.zze(i5, ((Long) this.zzzm[i3]).longValue());
            } else if (i6 == 1) {
                zze = zzfa.zzg(i5, ((Long) this.zzzm[i3]).longValue());
            } else if (i6 == 2) {
                zze = zzfa.zzc(i5, (zzeh) this.zzzm[i3]);
            } else if (i6 == 3) {
                zze = (zzfa.zzag(i5) << 1) + ((zzir) this.zzzm[i3]).zzgw();
            } else if (i6 == 5) {
                zze = zzfa.zzn(i5, ((Integer) this.zzzm[i3]).intValue());
            } else {
                throw new IllegalStateException(zzgc.zzhv());
            }
            i2 += zze;
        }
        this.zzwz = i2;
        return i2;
    }

    public final int zzjr() {
        int i = this.zzwz;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzfa.zzd(this.zzabq[i3] >>> 3, (zzeh) this.zzzm[i3]);
        }
        this.zzwz = i2;
        return i2;
    }

    private zzir(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzwz = -1;
        this.count = i;
        this.zzabq = iArr;
        this.zzzm = objArr;
        this.zzsh = z;
    }

    private static void zzb(int i, Object obj, Ra ra) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ra.e(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            ra.a(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            ra.a(i2, (zzeh) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 == 5) {
                ra.g(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzgc.zzhv());
        }
        if (ra.zzgl() == zzft.zze.zzxq) {
            ra.b(i2);
            ((zzir) obj).zzb(ra);
            ra.a(i2);
        } else {
            ra.a(i2);
            ((zzir) obj).zzb(ra);
            ra.b(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Ra ra) throws IOException {
        if (ra.zzgl() == zzft.zze.zzxr) {
            for (int i = this.count - 1; i >= 0; i--) {
                ra.zza(this.zzabq[i] >>> 3, this.zzzm[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            ra.zza(this.zzabq[i2] >>> 3, this.zzzm[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            Y.a(sb, i, String.valueOf(this.zzabq[i2] >>> 3), this.zzzm[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(int i, Object obj) {
        if (this.zzsh) {
            int i2 = this.count;
            if (i2 == this.zzabq.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzabq = Arrays.copyOf(this.zzabq, i3);
                this.zzzm = Arrays.copyOf(this.zzzm, i3);
            }
            int[] iArr = this.zzabq;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzzm[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
