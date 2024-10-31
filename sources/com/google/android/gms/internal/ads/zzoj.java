package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class zzoj extends zzop {
    private zzok zzbfc;
    private final SparseArray<Map<zzma, zzol>> zzbfa = new SparseArray<>();
    private final SparseBooleanArray zzbfb = new SparseBooleanArray();
    private int zzaak = 0;

    @Override // com.google.android.gms.internal.ads.zzop
    public final zzor zza(zzga[] zzgaVarArr, zzma zzmaVar) throws zzff {
        int[] iArr;
        int[] iArr2 = new int[zzgaVarArr.length + 1];
        zzlz[][] zzlzVarArr = new zzlz[zzgaVarArr.length + 1];
        int[][][] iArr3 = new int[zzgaVarArr.length + 1][];
        for (int i = 0; i < zzlzVarArr.length; i++) {
            int i2 = zzmaVar.length;
            zzlzVarArr[i] = new zzlz[i2];
            iArr3[i] = new int[i2];
        }
        int[] iArr4 = new int[zzgaVarArr.length];
        for (int i3 = 0; i3 < iArr4.length; i3++) {
            iArr4[i3] = zzgaVarArr[i3].zzbl();
        }
        for (int i4 = 0; i4 < zzmaVar.length; i4++) {
            zzlz zzau = zzmaVar.zzau(i4);
            int length = zzgaVarArr.length;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i5 >= zzgaVarArr.length) {
                    i5 = length;
                    break;
                }
                zzga zzgaVar = zzgaVarArr[i5];
                int i7 = length;
                int i8 = i6;
                for (int i9 = 0; i9 < zzau.length; i9++) {
                    int zzb = zzgaVar.zzb(zzau.zzat(i9)) & 3;
                    if (zzb > i8) {
                        if (zzb == 3) {
                            break;
                        }
                        i7 = i5;
                        i8 = zzb;
                    }
                }
                i5++;
                i6 = i8;
                length = i7;
            }
            if (i5 == zzgaVarArr.length) {
                iArr = new int[zzau.length];
            } else {
                zzga zzgaVar2 = zzgaVarArr[i5];
                int[] iArr5 = new int[zzau.length];
                for (int i10 = 0; i10 < zzau.length; i10++) {
                    iArr5[i10] = zzgaVar2.zzb(zzau.zzat(i10));
                }
                iArr = iArr5;
            }
            int i11 = iArr2[i5];
            zzlzVarArr[i5][i11] = zzau;
            iArr3[i5][i11] = iArr;
            iArr2[i5] = iArr2[i5] + 1;
        }
        zzma[] zzmaVarArr = new zzma[zzgaVarArr.length];
        int[] iArr6 = new int[zzgaVarArr.length];
        for (int i12 = 0; i12 < zzgaVarArr.length; i12++) {
            int i13 = iArr2[i12];
            zzmaVarArr[i12] = new zzma((zzlz[]) Arrays.copyOf(zzlzVarArr[i12], i13));
            iArr3[i12] = (int[][]) Arrays.copyOf(iArr3[i12], i13);
            iArr6[i12] = zzgaVarArr[i12].getTrackType();
        }
        zzma zzmaVar2 = new zzma((zzlz[]) Arrays.copyOf(zzlzVarArr[zzgaVarArr.length], iArr2[zzgaVarArr.length]));
        zzom[] zza = zza(zzgaVarArr, zzmaVarArr, iArr3);
        int i14 = 0;
        while (true) {
            if (i14 < zzgaVarArr.length) {
                if (this.zzbfb.get(i14)) {
                    zza[i14] = null;
                } else {
                    zzma zzmaVar3 = zzmaVarArr[i14];
                    Map<zzma, zzol> map = this.zzbfa.get(i14);
                    if ((map != null ? map.get(zzmaVar3) : null) != null) {
                        throw new NoSuchMethodError();
                    }
                }
                i14++;
            } else {
                zzok zzokVar = new zzok(iArr6, zzmaVarArr, iArr4, iArr3, zzmaVar2);
                zzgb[] zzgbVarArr = new zzgb[zzgaVarArr.length];
                for (int i15 = 0; i15 < zzgaVarArr.length; i15++) {
                    zzgbVarArr[i15] = zza[i15] != null ? zzgb.zzaaj : null;
                }
                return new zzor(zzmaVar, new zzoo(zza), zzokVar, zzgbVarArr);
            }
        }
    }

    protected abstract zzom[] zza(zzga[] zzgaVarArr, zzma[] zzmaVarArr, int[][][] iArr) throws zzff;

    @Override // com.google.android.gms.internal.ads.zzop
    public final void zzd(Object obj) {
        this.zzbfc = (zzok) obj;
    }

    public final void zzf(int i, boolean z) {
        if (this.zzbfb.get(i) == z) {
            return;
        }
        this.zzbfb.put(i, z);
        invalidate();
    }
}
