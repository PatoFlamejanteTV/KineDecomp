package com.google.android.gms.internal;

import java.io.IOException;

/* loaded from: classes.dex */
public interface zzag {

    /* loaded from: classes.dex */
    public static final class zza extends zzry<zza> {
        private static volatile zza[] zziT;
        public int type;
        public String zziU;
        public zza[] zziV;
        public zza[] zziW;
        public zza[] zziX;
        public String zziY;
        public String zziZ;
        public long zzja;
        public boolean zzjb;
        public zza[] zzjc;
        public int[] zzjd;
        public boolean zzje;

        public zza() {
            zzR();
        }

        public static zza[] zzQ() {
            if (zziT == null) {
                synchronized (zzsc.zzbiu) {
                    if (zziT == null) {
                        zziT = new zza[0];
                    }
                }
            }
            return zziT;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.type != zzaVar.type) {
                return false;
            }
            if (this.zziU == null) {
                if (zzaVar.zziU != null) {
                    return false;
                }
            } else if (!this.zziU.equals(zzaVar.zziU)) {
                return false;
            }
            if (!zzsc.equals(this.zziV, zzaVar.zziV) || !zzsc.equals(this.zziW, zzaVar.zziW) || !zzsc.equals(this.zziX, zzaVar.zziX)) {
                return false;
            }
            if (this.zziY == null) {
                if (zzaVar.zziY != null) {
                    return false;
                }
            } else if (!this.zziY.equals(zzaVar.zziY)) {
                return false;
            }
            if (this.zziZ == null) {
                if (zzaVar.zziZ != null) {
                    return false;
                }
            } else if (!this.zziZ.equals(zzaVar.zziZ)) {
                return false;
            }
            if (this.zzja == zzaVar.zzja && this.zzjb == zzaVar.zzjb && zzsc.equals(this.zzjc, zzaVar.zzjc) && zzsc.equals(this.zzjd, zzaVar.zzjd) && this.zzje == zzaVar.zzje) {
                return (this.zzbik == null || this.zzbik.isEmpty()) ? zzaVar.zzbik == null || zzaVar.zzbik.isEmpty() : this.zzbik.equals(zzaVar.zzbik);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((((this.zzjb ? 1231 : 1237) + (((((this.zziZ == null ? 0 : this.zziZ.hashCode()) + (((this.zziY == null ? 0 : this.zziY.hashCode()) + (((((((((this.zziU == null ? 0 : this.zziU.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31)) * 31) + zzsc.hashCode(this.zziV)) * 31) + zzsc.hashCode(this.zziW)) * 31) + zzsc.hashCode(this.zziX)) * 31)) * 31)) * 31) + ((int) (this.zzja ^ (this.zzja >>> 32)))) * 31)) * 31) + zzsc.hashCode(this.zzjc)) * 31) + zzsc.hashCode(this.zzjd)) * 31) + (this.zzje ? 1231 : 1237)) * 31;
            if (this.zzbik != null && !this.zzbik.isEmpty()) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        protected int zzB() {
            int zzB = super.zzB() + zzrx.zzA(1, this.type);
            if (!this.zziU.equals("")) {
                zzB += zzrx.zzn(2, this.zziU);
            }
            if (this.zziV != null && this.zziV.length > 0) {
                int i = zzB;
                for (int i2 = 0; i2 < this.zziV.length; i2++) {
                    zza zzaVar = this.zziV[i2];
                    if (zzaVar != null) {
                        i += zzrx.zzc(3, zzaVar);
                    }
                }
                zzB = i;
            }
            if (this.zziW != null && this.zziW.length > 0) {
                int i3 = zzB;
                for (int i4 = 0; i4 < this.zziW.length; i4++) {
                    zza zzaVar2 = this.zziW[i4];
                    if (zzaVar2 != null) {
                        i3 += zzrx.zzc(4, zzaVar2);
                    }
                }
                zzB = i3;
            }
            if (this.zziX != null && this.zziX.length > 0) {
                int i5 = zzB;
                for (int i6 = 0; i6 < this.zziX.length; i6++) {
                    zza zzaVar3 = this.zziX[i6];
                    if (zzaVar3 != null) {
                        i5 += zzrx.zzc(5, zzaVar3);
                    }
                }
                zzB = i5;
            }
            if (!this.zziY.equals("")) {
                zzB += zzrx.zzn(6, this.zziY);
            }
            if (!this.zziZ.equals("")) {
                zzB += zzrx.zzn(7, this.zziZ);
            }
            if (this.zzja != 0) {
                zzB += zzrx.zzd(8, this.zzja);
            }
            if (this.zzje) {
                zzB += zzrx.zzc(9, this.zzje);
            }
            if (this.zzjd != null && this.zzjd.length > 0) {
                int i7 = 0;
                for (int i8 = 0; i8 < this.zzjd.length; i8++) {
                    i7 += zzrx.zzlJ(this.zzjd[i8]);
                }
                zzB = zzB + i7 + (this.zzjd.length * 1);
            }
            if (this.zzjc != null && this.zzjc.length > 0) {
                for (int i9 = 0; i9 < this.zzjc.length; i9++) {
                    zza zzaVar4 = this.zzjc[i9];
                    if (zzaVar4 != null) {
                        zzB += zzrx.zzc(11, zzaVar4);
                    }
                }
            }
            return this.zzjb ? zzB + zzrx.zzc(12, this.zzjb) : zzB;
        }

        public zza zzR() {
            this.type = 1;
            this.zziU = "";
            this.zziV = zzQ();
            this.zziW = zzQ();
            this.zziX = zzQ();
            this.zziY = "";
            this.zziZ = "";
            this.zzja = 0L;
            this.zzjb = false;
            this.zzjc = zzQ();
            this.zzjd = zzsh.zzbix;
            this.zzje = false;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            zzrxVar.zzy(1, this.type);
            if (!this.zziU.equals("")) {
                zzrxVar.zzb(2, this.zziU);
            }
            if (this.zziV != null && this.zziV.length > 0) {
                for (int i = 0; i < this.zziV.length; i++) {
                    zza zzaVar = this.zziV[i];
                    if (zzaVar != null) {
                        zzrxVar.zza(3, zzaVar);
                    }
                }
            }
            if (this.zziW != null && this.zziW.length > 0) {
                for (int i2 = 0; i2 < this.zziW.length; i2++) {
                    zza zzaVar2 = this.zziW[i2];
                    if (zzaVar2 != null) {
                        zzrxVar.zza(4, zzaVar2);
                    }
                }
            }
            if (this.zziX != null && this.zziX.length > 0) {
                for (int i3 = 0; i3 < this.zziX.length; i3++) {
                    zza zzaVar3 = this.zziX[i3];
                    if (zzaVar3 != null) {
                        zzrxVar.zza(5, zzaVar3);
                    }
                }
            }
            if (!this.zziY.equals("")) {
                zzrxVar.zzb(6, this.zziY);
            }
            if (!this.zziZ.equals("")) {
                zzrxVar.zzb(7, this.zziZ);
            }
            if (this.zzja != 0) {
                zzrxVar.zzb(8, this.zzja);
            }
            if (this.zzje) {
                zzrxVar.zzb(9, this.zzje);
            }
            if (this.zzjd != null && this.zzjd.length > 0) {
                for (int i4 = 0; i4 < this.zzjd.length; i4++) {
                    zzrxVar.zzy(10, this.zzjd[i4]);
                }
            }
            if (this.zzjc != null && this.zzjc.length > 0) {
                for (int i5 = 0; i5 < this.zzjc.length; i5++) {
                    zza zzaVar4 = this.zzjc[i5];
                    if (zzaVar4 != null) {
                        zzrxVar.zza(11, zzaVar4);
                    }
                }
            }
            if (this.zzjb) {
                zzrxVar.zzb(12, this.zzjb);
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzl, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrw zzrwVar) throws IOException {
            int i;
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 8:
                        int zzFr = zzrwVar.zzFr();
                        switch (zzFr) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = zzFr;
                                break;
                        }
                    case 18:
                        this.zziU = zzrwVar.readString();
                        break;
                    case 26:
                        int zzc = zzsh.zzc(zzrwVar, 26);
                        int length = this.zziV == null ? 0 : this.zziV.length;
                        zza[] zzaVarArr = new zza[zzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zziV, 0, zzaVarArr, 0, length);
                        }
                        while (length < zzaVarArr.length - 1) {
                            zzaVarArr[length] = new zza();
                            zzrwVar.zza(zzaVarArr[length]);
                            zzrwVar.zzFo();
                            length++;
                        }
                        zzaVarArr[length] = new zza();
                        zzrwVar.zza(zzaVarArr[length]);
                        this.zziV = zzaVarArr;
                        break;
                    case 34:
                        int zzc2 = zzsh.zzc(zzrwVar, 34);
                        int length2 = this.zziW == null ? 0 : this.zziW.length;
                        zza[] zzaVarArr2 = new zza[zzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zziW, 0, zzaVarArr2, 0, length2);
                        }
                        while (length2 < zzaVarArr2.length - 1) {
                            zzaVarArr2[length2] = new zza();
                            zzrwVar.zza(zzaVarArr2[length2]);
                            zzrwVar.zzFo();
                            length2++;
                        }
                        zzaVarArr2[length2] = new zza();
                        zzrwVar.zza(zzaVarArr2[length2]);
                        this.zziW = zzaVarArr2;
                        break;
                    case 42:
                        int zzc3 = zzsh.zzc(zzrwVar, 42);
                        int length3 = this.zziX == null ? 0 : this.zziX.length;
                        zza[] zzaVarArr3 = new zza[zzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zziX, 0, zzaVarArr3, 0, length3);
                        }
                        while (length3 < zzaVarArr3.length - 1) {
                            zzaVarArr3[length3] = new zza();
                            zzrwVar.zza(zzaVarArr3[length3]);
                            zzrwVar.zzFo();
                            length3++;
                        }
                        zzaVarArr3[length3] = new zza();
                        zzrwVar.zza(zzaVarArr3[length3]);
                        this.zziX = zzaVarArr3;
                        break;
                    case 50:
                        this.zziY = zzrwVar.readString();
                        break;
                    case 58:
                        this.zziZ = zzrwVar.readString();
                        break;
                    case 64:
                        this.zzja = zzrwVar.zzFq();
                        break;
                    case 72:
                        this.zzje = zzrwVar.zzFs();
                        break;
                    case 80:
                        int zzc4 = zzsh.zzc(zzrwVar, 80);
                        int[] iArr = new int[zzc4];
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < zzc4) {
                            if (i2 != 0) {
                                zzrwVar.zzFo();
                            }
                            int zzFr2 = zzrwVar.zzFr();
                            switch (zzFr2) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    i = i3 + 1;
                                    iArr[i3] = zzFr2;
                                    break;
                                default:
                                    i = i3;
                                    break;
                            }
                            i2++;
                            i3 = i;
                        }
                        if (i3 != 0) {
                            int length4 = this.zzjd == null ? 0 : this.zzjd.length;
                            if (length4 != 0 || i3 != iArr.length) {
                                int[] iArr2 = new int[length4 + i3];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzjd, 0, iArr2, 0, length4);
                                }
                                System.arraycopy(iArr, 0, iArr2, length4, i3);
                                this.zzjd = iArr2;
                                break;
                            } else {
                                this.zzjd = iArr;
                                break;
                            }
                        } else {
                            break;
                        }
                    case 82:
                        int zzlC = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position = zzrwVar.getPosition();
                        int i4 = 0;
                        while (zzrwVar.zzFA() > 0) {
                            switch (zzrwVar.zzFr()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    i4++;
                                    break;
                            }
                        }
                        if (i4 != 0) {
                            zzrwVar.zzlE(position);
                            int length5 = this.zzjd == null ? 0 : this.zzjd.length;
                            int[] iArr3 = new int[i4 + length5];
                            if (length5 != 0) {
                                System.arraycopy(this.zzjd, 0, iArr3, 0, length5);
                            }
                            while (zzrwVar.zzFA() > 0) {
                                int zzFr3 = zzrwVar.zzFr();
                                switch (zzFr3) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        iArr3[length5] = zzFr3;
                                        length5++;
                                        break;
                                }
                            }
                            this.zzjd = iArr3;
                        }
                        zzrwVar.zzlD(zzlC);
                        break;
                    case 90:
                        int zzc5 = zzsh.zzc(zzrwVar, 90);
                        int length6 = this.zzjc == null ? 0 : this.zzjc.length;
                        zza[] zzaVarArr4 = new zza[zzc5 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zzjc, 0, zzaVarArr4, 0, length6);
                        }
                        while (length6 < zzaVarArr4.length - 1) {
                            zzaVarArr4[length6] = new zza();
                            zzrwVar.zza(zzaVarArr4[length6]);
                            zzrwVar.zzFo();
                            length6++;
                        }
                        zzaVarArr4[length6] = new zza();
                        zzrwVar.zza(zzaVarArr4[length6]);
                        this.zzjc = zzaVarArr4;
                        break;
                    case 96:
                        this.zzjb = zzrwVar.zzFs();
                        break;
                    default:
                        if (!zza(zzrwVar, zzFo)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }
}
