package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzxe {
    private static final zzxe zzccf = new zzxe(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzbtl;
    private int zzbye;
    private Object[] zzcar;
    private int[] zzccg;

    private zzxe() {
        this(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzxe zza(zzxe zzxeVar, zzxe zzxeVar2) {
        int i = zzxeVar.count + zzxeVar2.count;
        int[] copyOf = Arrays.copyOf(zzxeVar.zzccg, i);
        System.arraycopy(zzxeVar2.zzccg, 0, copyOf, zzxeVar.count, zzxeVar2.count);
        Object[] copyOf2 = Arrays.copyOf(zzxeVar.zzcar, i);
        System.arraycopy(zzxeVar2.zzcar, 0, copyOf2, zzxeVar.count, zzxeVar2.count);
        return new zzxe(i, copyOf, copyOf2, true);
    }

    public static zzxe zzyl() {
        return zzccf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzxe zzym() {
        return new zzxe();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzxe)) {
            return false;
        }
        zzxe zzxeVar = (zzxe) obj;
        int i = this.count;
        if (i == zzxeVar.count) {
            int[] iArr = this.zzccg;
            int[] iArr2 = zzxeVar.zzccg;
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
                Object[] objArr = this.zzcar;
                Object[] objArr2 = zzxeVar.zzcar;
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
        int[] iArr = this.zzccg;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzcar;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzb(Fb fb) throws IOException {
        if (this.count == 0) {
            return;
        }
        if (fb.a() == zzuo.zze.zzbyv) {
            for (int i = 0; i < this.count; i++) {
                zzb(this.zzccg[i], this.zzcar[i], fb);
            }
            return;
        }
        for (int i2 = this.count - 1; i2 >= 0; i2--) {
            zzb(this.zzccg[i2], this.zzcar[i2], fb);
        }
    }

    public final void zzsw() {
        this.zzbtl = false;
    }

    public final int zzvx() {
        int zze;
        int i = this.zzbye;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            int i4 = this.zzccg[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                zze = zztv.zze(i5, ((Long) this.zzcar[i3]).longValue());
            } else if (i6 == 1) {
                zze = zztv.zzg(i5, ((Long) this.zzcar[i3]).longValue());
            } else if (i6 == 2) {
                zze = zztv.zzc(i5, (zzte) this.zzcar[i3]);
            } else if (i6 == 3) {
                zze = (zztv.zzbd(i5) << 1) + ((zzxe) this.zzcar[i3]).zzvx();
            } else if (i6 == 5) {
                zze = zztv.zzk(i5, ((Integer) this.zzcar[i3]).intValue());
            } else {
                throw new IllegalStateException(zzuv.zzwu());
            }
            i2 += zze;
        }
        this.zzbye = i2;
        return i2;
    }

    public final int zzyn() {
        int i = this.zzbye;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zztv.zzd(this.zzccg[i3] >>> 3, (zzte) this.zzcar[i3]);
        }
        this.zzbye = i2;
        return i2;
    }

    private zzxe(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzbye = -1;
        this.count = i;
        this.zzccg = iArr;
        this.zzcar = objArr;
        this.zzbtl = z;
    }

    private static void zzb(int i, Object obj, Fb fb) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            fb.e(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            fb.a(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            fb.a(i2, (zzte) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 == 5) {
                fb.b(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzuv.zzwu());
        }
        if (fb.a() == zzuo.zze.zzbyv) {
            fb.a(i2);
            ((zzxe) obj).zzb(fb);
            fb.zzbn(i2);
        } else {
            fb.zzbn(i2);
            ((zzxe) obj).zzb(fb);
            fb.a(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Fb fb) throws IOException {
        if (fb.a() == zzuo.zze.zzbyw) {
            for (int i = this.count - 1; i >= 0; i--) {
                fb.zza(this.zzccg[i] >>> 3, this.zzcar[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            fb.zza(this.zzccg[i2] >>> 3, this.zzcar[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            Sa.a(sb, i, String.valueOf(this.zzccg[i2] >>> 3), this.zzcar[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(int i, Object obj) {
        if (this.zzbtl) {
            int i2 = this.count;
            if (i2 == this.zzccg.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzccg = Arrays.copyOf(this.zzccg, i3);
                this.zzcar = Arrays.copyOf(this.zzcar, i3);
            }
            int[] iArr = this.zzccg;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzcar[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
