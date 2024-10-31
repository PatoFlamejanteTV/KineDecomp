package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzbtv {
    private static final zzbtv zzftx = new zzbtv(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzfla;
    private int zzfpv;
    private Object[] zzfsj;
    private int[] zzfty;

    private zzbtv() {
        this(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbtv zza(zzbtv zzbtvVar, zzbtv zzbtvVar2) {
        int i = zzbtvVar.count + zzbtvVar2.count;
        int[] copyOf = Arrays.copyOf(zzbtvVar.zzfty, i);
        System.arraycopy(zzbtvVar2.zzfty, 0, copyOf, zzbtvVar.count, zzbtvVar2.count);
        Object[] copyOf2 = Arrays.copyOf(zzbtvVar.zzfsj, i);
        System.arraycopy(zzbtvVar2.zzfsj, 0, copyOf2, zzbtvVar.count, zzbtvVar2.count);
        return new zzbtv(i, copyOf, copyOf2, true);
    }

    public static zzbtv zzaoz() {
        return zzftx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbtv zzapa() {
        return new zzbtv();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzbtv)) {
            return false;
        }
        zzbtv zzbtvVar = (zzbtv) obj;
        int i = this.count;
        if (i == zzbtvVar.count) {
            int[] iArr = this.zzfty;
            int[] iArr2 = zzbtvVar.zzfty;
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
                Object[] objArr = this.zzfsj;
                Object[] objArr2 = zzbtvVar.zzfsj;
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
        int[] iArr = this.zzfty;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzfsj;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzakj() {
        this.zzfla = false;
    }

    public final int zzamj() {
        int zzn;
        int i = this.zzfpv;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            int i4 = this.zzfty[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                zzn = zzbqk.zzn(i5, ((Long) this.zzfsj[i3]).longValue());
            } else if (i6 == 1) {
                zzn = zzbqk.zzp(i5, ((Long) this.zzfsj[i3]).longValue());
            } else if (i6 == 2) {
                zzn = zzbqk.zzc(i5, (zzbpu) this.zzfsj[i3]);
            } else if (i6 == 3) {
                zzn = (zzbqk.zzfd(i5) << 1) + ((zzbtv) this.zzfsj[i3]).zzamj();
            } else if (i6 == 5) {
                zzn = zzbqk.zzac(i5, ((Integer) this.zzfsj[i3]).intValue());
            } else {
                throw new IllegalStateException(zzbrl.zzanh());
            }
            i2 += zzn;
        }
        this.zzfpv = i2;
        return i2;
    }

    public final int zzapb() {
        int i = this.zzfpv;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzbqk.zzd(this.zzfty[i3] >>> 3, (zzbpu) this.zzfsj[i3]);
        }
        this.zzfpv = i2;
        return i2;
    }

    public final void zzb(Xi xi) throws IOException {
        if (this.count == 0) {
            return;
        }
        if (xi.a() == zzbrd.zze.zzfqm) {
            for (int i = 0; i < this.count; i++) {
                zzb(this.zzfty[i], this.zzfsj[i], xi);
            }
            return;
        }
        for (int i2 = this.count - 1; i2 >= 0; i2--) {
            zzb(this.zzfty[i2], this.zzfsj[i2], xi);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(int i, Object obj) {
        if (this.zzfla) {
            int i2 = this.count;
            if (i2 == this.zzfty.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzfty = Arrays.copyOf(this.zzfty, i3);
                this.zzfsj = Arrays.copyOf(this.zzfsj, i3);
            }
            int[] iArr = this.zzfty;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzfsj[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    private zzbtv(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzfpv = -1;
        this.count = i;
        this.zzfty = iArr;
        this.zzfsj = objArr;
        this.zzfla = z;
    }

    private static void zzb(int i, Object obj, Xi xi) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            xi.d(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            xi.f(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            xi.a(i2, (zzbpu) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 == 5) {
                xi.e(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzbrl.zzanh());
        }
        if (xi.a() == zzbrd.zze.zzfqm) {
            xi.a(i2);
            ((zzbtv) obj).zzb(xi);
            xi.b(i2);
        } else {
            xi.b(i2);
            ((zzbtv) obj).zzb(xi);
            xi.a(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Xi xi) throws IOException {
        if (xi.a() == zzbrd.zze.zzfqn) {
            for (int i = this.count - 1; i >= 0; i--) {
                xi.a(this.zzfty[i] >>> 3, this.zzfsj[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            xi.a(this.zzfty[i2] >>> 3, this.zzfsj[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            C0959ji.a(sb, i, String.valueOf(this.zzfty[i2] >>> 3), this.zzfsj[i2]);
        }
    }
}
