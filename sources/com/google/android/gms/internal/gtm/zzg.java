package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzg {

    /* loaded from: classes2.dex */
    public static final class zza extends zzuq<zza> {
        public static final zzur<zzl, zza> zzpx = zzur.zza(11, zza.class, 810);
        private static final zza[] zzpy = new zza[0];
        public int[] zzpz;
        public int[] zzqa;
        public int[] zzqb;
        private int zzqc;
        public int[] zzqd;
        public int zzqe;
        private int zzqf;

        public zza() {
            int[] iArr = zzuz.zzbcw;
            this.zzpz = iArr;
            this.zzqa = iArr;
            this.zzqb = iArr;
            this.zzqc = 0;
            this.zzqd = iArr;
            this.zzqe = 0;
            this.zzqf = 0;
            this.zzbhb = null;
            this.zzbhl = -1;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (!zzuu.equals(this.zzpz, zzaVar.zzpz) || !zzuu.equals(this.zzqa, zzaVar.zzqa) || !zzuu.equals(this.zzqb, zzaVar.zzqb) || this.zzqc != zzaVar.zzqc || !zzuu.equals(this.zzqd, zzaVar.zzqd) || this.zzqe != zzaVar.zzqe || this.zzqf != zzaVar.zzqf) {
                return false;
            }
            zzus zzusVar = this.zzbhb;
            if (zzusVar != null && !zzusVar.isEmpty()) {
                return this.zzbhb.equals(zzaVar.zzbhb);
            }
            zzus zzusVar2 = zzaVar.zzbhb;
            return zzusVar2 == null || zzusVar2.isEmpty();
        }

        public final int hashCode() {
            int hashCode = (((((((((((((((zza.class.getName().hashCode() + 527) * 31) + zzuu.hashCode(this.zzpz)) * 31) + zzuu.hashCode(this.zzqa)) * 31) + zzuu.hashCode(this.zzqb)) * 31) + this.zzqc) * 31) + zzuu.hashCode(this.zzqd)) * 31) + this.zzqe) * 31) + this.zzqf) * 31;
            zzus zzusVar = this.zzbhb;
            return hashCode + ((zzusVar == null || zzusVar.isEmpty()) ? 0 : this.zzbhb.hashCode());
        }

        @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
        public final void zza(zzuo zzuoVar) throws IOException {
            int[] iArr = this.zzpz;
            int i = 0;
            if (iArr != null && iArr.length > 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.zzpz;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    zzuoVar.zze(1, iArr2[i2]);
                    i2++;
                }
            }
            int[] iArr3 = this.zzqa;
            if (iArr3 != null && iArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    int[] iArr4 = this.zzqa;
                    if (i3 >= iArr4.length) {
                        break;
                    }
                    zzuoVar.zze(2, iArr4[i3]);
                    i3++;
                }
            }
            int[] iArr5 = this.zzqb;
            if (iArr5 != null && iArr5.length > 0) {
                int i4 = 0;
                while (true) {
                    int[] iArr6 = this.zzqb;
                    if (i4 >= iArr6.length) {
                        break;
                    }
                    zzuoVar.zze(3, iArr6[i4]);
                    i4++;
                }
            }
            int i5 = this.zzqc;
            if (i5 != 0) {
                zzuoVar.zze(4, i5);
            }
            int[] iArr7 = this.zzqd;
            if (iArr7 != null && iArr7.length > 0) {
                while (true) {
                    int[] iArr8 = this.zzqd;
                    if (i >= iArr8.length) {
                        break;
                    }
                    zzuoVar.zze(5, iArr8[i]);
                    i++;
                }
            }
            int i6 = this.zzqe;
            if (i6 != 0) {
                zzuoVar.zze(6, i6);
            }
            int i7 = this.zzqf;
            if (i7 != 0) {
                zzuoVar.zze(7, i7);
            }
            super.zza(zzuoVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
        public final int zzy() {
            int[] iArr;
            int[] iArr2;
            int[] iArr3;
            int[] iArr4;
            int zzy = super.zzy();
            int[] iArr5 = this.zzpz;
            int i = 0;
            if (iArr5 != null && iArr5.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    iArr4 = this.zzpz;
                    if (i2 >= iArr4.length) {
                        break;
                    }
                    i3 += zzuo.zzbc(iArr4[i2]);
                    i2++;
                }
                zzy = zzy + i3 + (iArr4.length * 1);
            }
            int[] iArr6 = this.zzqa;
            if (iArr6 != null && iArr6.length > 0) {
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    iArr3 = this.zzqa;
                    if (i4 >= iArr3.length) {
                        break;
                    }
                    i5 += zzuo.zzbc(iArr3[i4]);
                    i4++;
                }
                zzy = zzy + i5 + (iArr3.length * 1);
            }
            int[] iArr7 = this.zzqb;
            if (iArr7 != null && iArr7.length > 0) {
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    iArr2 = this.zzqb;
                    if (i6 >= iArr2.length) {
                        break;
                    }
                    i7 += zzuo.zzbc(iArr2[i6]);
                    i6++;
                }
                zzy = zzy + i7 + (iArr2.length * 1);
            }
            int i8 = this.zzqc;
            if (i8 != 0) {
                zzy += zzuo.zzi(4, i8);
            }
            int[] iArr8 = this.zzqd;
            if (iArr8 != null && iArr8.length > 0) {
                int i9 = 0;
                while (true) {
                    iArr = this.zzqd;
                    if (i >= iArr.length) {
                        break;
                    }
                    i9 += zzuo.zzbc(iArr[i]);
                    i++;
                }
                zzy = zzy + i9 + (iArr.length * 1);
            }
            int i10 = this.zzqe;
            if (i10 != 0) {
                zzy += zzuo.zzi(6, i10);
            }
            int i11 = this.zzqf;
            return i11 != 0 ? zzy + zzuo.zzi(7, i11) : zzy;
        }

        @Override // com.google.android.gms.internal.gtm.zzuw
        public final /* synthetic */ zzuw zza(zzun zzunVar) throws IOException {
            while (true) {
                int zzni = zzunVar.zzni();
                switch (zzni) {
                    case 0:
                        return this;
                    case 8:
                        int zzb = zzuz.zzb(zzunVar, 8);
                        int[] iArr = this.zzpz;
                        int length = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[zzb + length];
                        if (length != 0) {
                            System.arraycopy(this.zzpz, 0, iArr2, 0, length);
                        }
                        while (length < iArr2.length - 1) {
                            iArr2[length] = zzunVar.zzoa();
                            zzunVar.zzni();
                            length++;
                        }
                        iArr2[length] = zzunVar.zzoa();
                        this.zzpz = iArr2;
                        break;
                    case 10:
                        int zzaq = zzunVar.zzaq(zzunVar.zzoa());
                        int position = zzunVar.getPosition();
                        int i = 0;
                        while (zzunVar.zzrv() > 0) {
                            zzunVar.zzoa();
                            i++;
                        }
                        zzunVar.zzbz(position);
                        int[] iArr3 = this.zzpz;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzpz, 0, iArr4, 0, length2);
                        }
                        while (length2 < iArr4.length) {
                            iArr4[length2] = zzunVar.zzoa();
                            length2++;
                        }
                        this.zzpz = iArr4;
                        zzunVar.zzar(zzaq);
                        break;
                    case 16:
                        int zzb2 = zzuz.zzb(zzunVar, 16);
                        int[] iArr5 = this.zzqa;
                        int length3 = iArr5 == null ? 0 : iArr5.length;
                        int[] iArr6 = new int[zzb2 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzqa, 0, iArr6, 0, length3);
                        }
                        while (length3 < iArr6.length - 1) {
                            iArr6[length3] = zzunVar.zzoa();
                            zzunVar.zzni();
                            length3++;
                        }
                        iArr6[length3] = zzunVar.zzoa();
                        this.zzqa = iArr6;
                        break;
                    case 18:
                        int zzaq2 = zzunVar.zzaq(zzunVar.zzoa());
                        int position2 = zzunVar.getPosition();
                        int i2 = 0;
                        while (zzunVar.zzrv() > 0) {
                            zzunVar.zzoa();
                            i2++;
                        }
                        zzunVar.zzbz(position2);
                        int[] iArr7 = this.zzqa;
                        int length4 = iArr7 == null ? 0 : iArr7.length;
                        int[] iArr8 = new int[i2 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zzqa, 0, iArr8, 0, length4);
                        }
                        while (length4 < iArr8.length) {
                            iArr8[length4] = zzunVar.zzoa();
                            length4++;
                        }
                        this.zzqa = iArr8;
                        zzunVar.zzar(zzaq2);
                        break;
                    case 24:
                        int zzb3 = zzuz.zzb(zzunVar, 24);
                        int[] iArr9 = this.zzqb;
                        int length5 = iArr9 == null ? 0 : iArr9.length;
                        int[] iArr10 = new int[zzb3 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zzqb, 0, iArr10, 0, length5);
                        }
                        while (length5 < iArr10.length - 1) {
                            iArr10[length5] = zzunVar.zzoa();
                            zzunVar.zzni();
                            length5++;
                        }
                        iArr10[length5] = zzunVar.zzoa();
                        this.zzqb = iArr10;
                        break;
                    case 26:
                        int zzaq3 = zzunVar.zzaq(zzunVar.zzoa());
                        int position3 = zzunVar.getPosition();
                        int i3 = 0;
                        while (zzunVar.zzrv() > 0) {
                            zzunVar.zzoa();
                            i3++;
                        }
                        zzunVar.zzbz(position3);
                        int[] iArr11 = this.zzqb;
                        int length6 = iArr11 == null ? 0 : iArr11.length;
                        int[] iArr12 = new int[i3 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zzqb, 0, iArr12, 0, length6);
                        }
                        while (length6 < iArr12.length) {
                            iArr12[length6] = zzunVar.zzoa();
                            length6++;
                        }
                        this.zzqb = iArr12;
                        zzunVar.zzar(zzaq3);
                        break;
                    case 32:
                        this.zzqc = zzunVar.zzoa();
                        break;
                    case 40:
                        int zzb4 = zzuz.zzb(zzunVar, 40);
                        int[] iArr13 = this.zzqd;
                        int length7 = iArr13 == null ? 0 : iArr13.length;
                        int[] iArr14 = new int[zzb4 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.zzqd, 0, iArr14, 0, length7);
                        }
                        while (length7 < iArr14.length - 1) {
                            iArr14[length7] = zzunVar.zzoa();
                            zzunVar.zzni();
                            length7++;
                        }
                        iArr14[length7] = zzunVar.zzoa();
                        this.zzqd = iArr14;
                        break;
                    case 42:
                        int zzaq4 = zzunVar.zzaq(zzunVar.zzoa());
                        int position4 = zzunVar.getPosition();
                        int i4 = 0;
                        while (zzunVar.zzrv() > 0) {
                            zzunVar.zzoa();
                            i4++;
                        }
                        zzunVar.zzbz(position4);
                        int[] iArr15 = this.zzqd;
                        int length8 = iArr15 == null ? 0 : iArr15.length;
                        int[] iArr16 = new int[i4 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.zzqd, 0, iArr16, 0, length8);
                        }
                        while (length8 < iArr16.length) {
                            iArr16[length8] = zzunVar.zzoa();
                            length8++;
                        }
                        this.zzqd = iArr16;
                        zzunVar.zzar(zzaq4);
                        break;
                    case 48:
                        this.zzqe = zzunVar.zzoa();
                        break;
                    case 56:
                        this.zzqf = zzunVar.zzoa();
                        break;
                    default:
                        if (!super.zza(zzunVar, zzni)) {
                            return this;
                        }
                        break;
                }
            }
        }
    }
}
