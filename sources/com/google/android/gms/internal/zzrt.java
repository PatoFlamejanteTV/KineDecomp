package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzrt extends zzry<zzrt> {
    public zza[] zzbhB;

    /* loaded from: classes.dex */
    public static final class zza extends zzry<zza> {
        private static volatile zza[] zzbhC;
        public String name;
        public C0038zza zzbhD;

        /* renamed from: com.google.android.gms.internal.zzrt$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0038zza extends zzry<C0038zza> {
            private static volatile C0038zza[] zzbhE;
            public int type;
            public C0039zza zzbhF;

            /* renamed from: com.google.android.gms.internal.zzrt$zza$zza$zza, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0039zza extends zzry<C0039zza> {
                public byte[] zzbhG;
                public String zzbhH;
                public double zzbhI;
                public float zzbhJ;
                public long zzbhK;
                public int zzbhL;
                public int zzbhM;
                public boolean zzbhN;
                public zza[] zzbhO;
                public C0038zza[] zzbhP;
                public String[] zzbhQ;
                public long[] zzbhR;
                public float[] zzbhS;
                public long zzbhT;

                public C0039zza() {
                    zzFm();
                }

                public boolean equals(Object obj) {
                    if (obj == this) {
                        return true;
                    }
                    if (!(obj instanceof C0039zza)) {
                        return false;
                    }
                    C0039zza c0039zza = (C0039zza) obj;
                    if (!Arrays.equals(this.zzbhG, c0039zza.zzbhG)) {
                        return false;
                    }
                    if (this.zzbhH == null) {
                        if (c0039zza.zzbhH != null) {
                            return false;
                        }
                    } else if (!this.zzbhH.equals(c0039zza.zzbhH)) {
                        return false;
                    }
                    if (Double.doubleToLongBits(this.zzbhI) == Double.doubleToLongBits(c0039zza.zzbhI) && Float.floatToIntBits(this.zzbhJ) == Float.floatToIntBits(c0039zza.zzbhJ) && this.zzbhK == c0039zza.zzbhK && this.zzbhL == c0039zza.zzbhL && this.zzbhM == c0039zza.zzbhM && this.zzbhN == c0039zza.zzbhN && zzsc.equals(this.zzbhO, c0039zza.zzbhO) && zzsc.equals(this.zzbhP, c0039zza.zzbhP) && zzsc.equals(this.zzbhQ, c0039zza.zzbhQ) && zzsc.equals(this.zzbhR, c0039zza.zzbhR) && zzsc.equals(this.zzbhS, c0039zza.zzbhS) && this.zzbhT == c0039zza.zzbhT) {
                        return (this.zzbik == null || this.zzbik.isEmpty()) ? c0039zza.zzbik == null || c0039zza.zzbik.isEmpty() : this.zzbik.equals(c0039zza.zzbik);
                    }
                    return false;
                }

                public int hashCode() {
                    int i = 0;
                    int hashCode = (this.zzbhH == null ? 0 : this.zzbhH.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.zzbhG)) * 31);
                    long doubleToLongBits = Double.doubleToLongBits(this.zzbhI);
                    int floatToIntBits = ((((((((((((((this.zzbhN ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.zzbhJ)) * 31) + ((int) (this.zzbhK ^ (this.zzbhK >>> 32)))) * 31) + this.zzbhL) * 31) + this.zzbhM) * 31)) * 31) + zzsc.hashCode(this.zzbhO)) * 31) + zzsc.hashCode(this.zzbhP)) * 31) + zzsc.hashCode(this.zzbhQ)) * 31) + zzsc.hashCode(this.zzbhR)) * 31) + zzsc.hashCode(this.zzbhS)) * 31) + ((int) (this.zzbhT ^ (this.zzbhT >>> 32)))) * 31;
                    if (this.zzbik != null && !this.zzbik.isEmpty()) {
                        i = this.zzbik.hashCode();
                    }
                    return floatToIntBits + i;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
                public int zzB() {
                    int zzB = super.zzB();
                    if (!Arrays.equals(this.zzbhG, zzsh.zzbiE)) {
                        zzB += zzrx.zzb(1, this.zzbhG);
                    }
                    if (!this.zzbhH.equals("")) {
                        zzB += zzrx.zzn(2, this.zzbhH);
                    }
                    if (Double.doubleToLongBits(this.zzbhI) != Double.doubleToLongBits(0.0d)) {
                        zzB += zzrx.zzb(3, this.zzbhI);
                    }
                    if (Float.floatToIntBits(this.zzbhJ) != Float.floatToIntBits(0.0f)) {
                        zzB += zzrx.zzc(4, this.zzbhJ);
                    }
                    if (this.zzbhK != 0) {
                        zzB += zzrx.zzd(5, this.zzbhK);
                    }
                    if (this.zzbhL != 0) {
                        zzB += zzrx.zzA(6, this.zzbhL);
                    }
                    if (this.zzbhM != 0) {
                        zzB += zzrx.zzB(7, this.zzbhM);
                    }
                    if (this.zzbhN) {
                        zzB += zzrx.zzc(8, this.zzbhN);
                    }
                    if (this.zzbhO != null && this.zzbhO.length > 0) {
                        int i = zzB;
                        for (int i2 = 0; i2 < this.zzbhO.length; i2++) {
                            zza zzaVar = this.zzbhO[i2];
                            if (zzaVar != null) {
                                i += zzrx.zzc(9, zzaVar);
                            }
                        }
                        zzB = i;
                    }
                    if (this.zzbhP != null && this.zzbhP.length > 0) {
                        int i3 = zzB;
                        for (int i4 = 0; i4 < this.zzbhP.length; i4++) {
                            C0038zza c0038zza = this.zzbhP[i4];
                            if (c0038zza != null) {
                                i3 += zzrx.zzc(10, c0038zza);
                            }
                        }
                        zzB = i3;
                    }
                    if (this.zzbhQ != null && this.zzbhQ.length > 0) {
                        int i5 = 0;
                        int i6 = 0;
                        for (int i7 = 0; i7 < this.zzbhQ.length; i7++) {
                            String str = this.zzbhQ[i7];
                            if (str != null) {
                                i6++;
                                i5 += zzrx.zzfA(str);
                            }
                        }
                        zzB = zzB + i5 + (i6 * 1);
                    }
                    if (this.zzbhR != null && this.zzbhR.length > 0) {
                        int i8 = 0;
                        for (int i9 = 0; i9 < this.zzbhR.length; i9++) {
                            i8 += zzrx.zzaa(this.zzbhR[i9]);
                        }
                        zzB = zzB + i8 + (this.zzbhR.length * 1);
                    }
                    if (this.zzbhT != 0) {
                        zzB += zzrx.zzd(13, this.zzbhT);
                    }
                    return (this.zzbhS == null || this.zzbhS.length <= 0) ? zzB : zzB + (this.zzbhS.length * 4) + (this.zzbhS.length * 1);
                }

                @Override // com.google.android.gms.internal.zzse
                /* renamed from: zzD, reason: merged with bridge method [inline-methods] */
                public C0039zza zzb(zzrw zzrwVar) throws IOException {
                    while (true) {
                        int zzFo = zzrwVar.zzFo();
                        switch (zzFo) {
                            case 0:
                                break;
                            case 10:
                                this.zzbhG = zzrwVar.readBytes();
                                break;
                            case 18:
                                this.zzbhH = zzrwVar.readString();
                                break;
                            case 25:
                                this.zzbhI = zzrwVar.readDouble();
                                break;
                            case 37:
                                this.zzbhJ = zzrwVar.readFloat();
                                break;
                            case 40:
                                this.zzbhK = zzrwVar.zzFq();
                                break;
                            case 48:
                                this.zzbhL = zzrwVar.zzFr();
                                break;
                            case 56:
                                this.zzbhM = zzrwVar.zzFt();
                                break;
                            case 64:
                                this.zzbhN = zzrwVar.zzFs();
                                break;
                            case 74:
                                int zzc = zzsh.zzc(zzrwVar, 74);
                                int length = this.zzbhO == null ? 0 : this.zzbhO.length;
                                zza[] zzaVarArr = new zza[zzc + length];
                                if (length != 0) {
                                    System.arraycopy(this.zzbhO, 0, zzaVarArr, 0, length);
                                }
                                while (length < zzaVarArr.length - 1) {
                                    zzaVarArr[length] = new zza();
                                    zzrwVar.zza(zzaVarArr[length]);
                                    zzrwVar.zzFo();
                                    length++;
                                }
                                zzaVarArr[length] = new zza();
                                zzrwVar.zza(zzaVarArr[length]);
                                this.zzbhO = zzaVarArr;
                                break;
                            case 82:
                                int zzc2 = zzsh.zzc(zzrwVar, 82);
                                int length2 = this.zzbhP == null ? 0 : this.zzbhP.length;
                                C0038zza[] c0038zzaArr = new C0038zza[zzc2 + length2];
                                if (length2 != 0) {
                                    System.arraycopy(this.zzbhP, 0, c0038zzaArr, 0, length2);
                                }
                                while (length2 < c0038zzaArr.length - 1) {
                                    c0038zzaArr[length2] = new C0038zza();
                                    zzrwVar.zza(c0038zzaArr[length2]);
                                    zzrwVar.zzFo();
                                    length2++;
                                }
                                c0038zzaArr[length2] = new C0038zza();
                                zzrwVar.zza(c0038zzaArr[length2]);
                                this.zzbhP = c0038zzaArr;
                                break;
                            case 90:
                                int zzc3 = zzsh.zzc(zzrwVar, 90);
                                int length3 = this.zzbhQ == null ? 0 : this.zzbhQ.length;
                                String[] strArr = new String[zzc3 + length3];
                                if (length3 != 0) {
                                    System.arraycopy(this.zzbhQ, 0, strArr, 0, length3);
                                }
                                while (length3 < strArr.length - 1) {
                                    strArr[length3] = zzrwVar.readString();
                                    zzrwVar.zzFo();
                                    length3++;
                                }
                                strArr[length3] = zzrwVar.readString();
                                this.zzbhQ = strArr;
                                break;
                            case 96:
                                int zzc4 = zzsh.zzc(zzrwVar, 96);
                                int length4 = this.zzbhR == null ? 0 : this.zzbhR.length;
                                long[] jArr = new long[zzc4 + length4];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzbhR, 0, jArr, 0, length4);
                                }
                                while (length4 < jArr.length - 1) {
                                    jArr[length4] = zzrwVar.zzFq();
                                    zzrwVar.zzFo();
                                    length4++;
                                }
                                jArr[length4] = zzrwVar.zzFq();
                                this.zzbhR = jArr;
                                break;
                            case 98:
                                int zzlC = zzrwVar.zzlC(zzrwVar.zzFv());
                                int position = zzrwVar.getPosition();
                                int i = 0;
                                while (zzrwVar.zzFA() > 0) {
                                    zzrwVar.zzFq();
                                    i++;
                                }
                                zzrwVar.zzlE(position);
                                int length5 = this.zzbhR == null ? 0 : this.zzbhR.length;
                                long[] jArr2 = new long[i + length5];
                                if (length5 != 0) {
                                    System.arraycopy(this.zzbhR, 0, jArr2, 0, length5);
                                }
                                while (length5 < jArr2.length) {
                                    jArr2[length5] = zzrwVar.zzFq();
                                    length5++;
                                }
                                this.zzbhR = jArr2;
                                zzrwVar.zzlD(zzlC);
                                break;
                            case 104:
                                this.zzbhT = zzrwVar.zzFq();
                                break;
                            case 114:
                                int zzFv = zzrwVar.zzFv();
                                int zzlC2 = zzrwVar.zzlC(zzFv);
                                int i2 = zzFv / 4;
                                int length6 = this.zzbhS == null ? 0 : this.zzbhS.length;
                                float[] fArr = new float[i2 + length6];
                                if (length6 != 0) {
                                    System.arraycopy(this.zzbhS, 0, fArr, 0, length6);
                                }
                                while (length6 < fArr.length) {
                                    fArr[length6] = zzrwVar.readFloat();
                                    length6++;
                                }
                                this.zzbhS = fArr;
                                zzrwVar.zzlD(zzlC2);
                                break;
                            case 117:
                                int zzc5 = zzsh.zzc(zzrwVar, 117);
                                int length7 = this.zzbhS == null ? 0 : this.zzbhS.length;
                                float[] fArr2 = new float[zzc5 + length7];
                                if (length7 != 0) {
                                    System.arraycopy(this.zzbhS, 0, fArr2, 0, length7);
                                }
                                while (length7 < fArr2.length - 1) {
                                    fArr2[length7] = zzrwVar.readFloat();
                                    zzrwVar.zzFo();
                                    length7++;
                                }
                                fArr2[length7] = zzrwVar.readFloat();
                                this.zzbhS = fArr2;
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

                public C0039zza zzFm() {
                    this.zzbhG = zzsh.zzbiE;
                    this.zzbhH = "";
                    this.zzbhI = 0.0d;
                    this.zzbhJ = 0.0f;
                    this.zzbhK = 0L;
                    this.zzbhL = 0;
                    this.zzbhM = 0;
                    this.zzbhN = false;
                    this.zzbhO = zza.zzFi();
                    this.zzbhP = C0038zza.zzFk();
                    this.zzbhQ = zzsh.zzbiC;
                    this.zzbhR = zzsh.zzbiy;
                    this.zzbhS = zzsh.zzbiz;
                    this.zzbhT = 0L;
                    this.zzbik = null;
                    this.zzbiv = -1;
                    return this;
                }

                @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
                public void zza(zzrx zzrxVar) throws IOException {
                    if (!Arrays.equals(this.zzbhG, zzsh.zzbiE)) {
                        zzrxVar.zza(1, this.zzbhG);
                    }
                    if (!this.zzbhH.equals("")) {
                        zzrxVar.zzb(2, this.zzbhH);
                    }
                    if (Double.doubleToLongBits(this.zzbhI) != Double.doubleToLongBits(0.0d)) {
                        zzrxVar.zza(3, this.zzbhI);
                    }
                    if (Float.floatToIntBits(this.zzbhJ) != Float.floatToIntBits(0.0f)) {
                        zzrxVar.zzb(4, this.zzbhJ);
                    }
                    if (this.zzbhK != 0) {
                        zzrxVar.zzb(5, this.zzbhK);
                    }
                    if (this.zzbhL != 0) {
                        zzrxVar.zzy(6, this.zzbhL);
                    }
                    if (this.zzbhM != 0) {
                        zzrxVar.zzz(7, this.zzbhM);
                    }
                    if (this.zzbhN) {
                        zzrxVar.zzb(8, this.zzbhN);
                    }
                    if (this.zzbhO != null && this.zzbhO.length > 0) {
                        for (int i = 0; i < this.zzbhO.length; i++) {
                            zza zzaVar = this.zzbhO[i];
                            if (zzaVar != null) {
                                zzrxVar.zza(9, zzaVar);
                            }
                        }
                    }
                    if (this.zzbhP != null && this.zzbhP.length > 0) {
                        for (int i2 = 0; i2 < this.zzbhP.length; i2++) {
                            C0038zza c0038zza = this.zzbhP[i2];
                            if (c0038zza != null) {
                                zzrxVar.zza(10, c0038zza);
                            }
                        }
                    }
                    if (this.zzbhQ != null && this.zzbhQ.length > 0) {
                        for (int i3 = 0; i3 < this.zzbhQ.length; i3++) {
                            String str = this.zzbhQ[i3];
                            if (str != null) {
                                zzrxVar.zzb(11, str);
                            }
                        }
                    }
                    if (this.zzbhR != null && this.zzbhR.length > 0) {
                        for (int i4 = 0; i4 < this.zzbhR.length; i4++) {
                            zzrxVar.zzb(12, this.zzbhR[i4]);
                        }
                    }
                    if (this.zzbhT != 0) {
                        zzrxVar.zzb(13, this.zzbhT);
                    }
                    if (this.zzbhS != null && this.zzbhS.length > 0) {
                        for (int i5 = 0; i5 < this.zzbhS.length; i5++) {
                            zzrxVar.zzb(14, this.zzbhS[i5]);
                        }
                    }
                    super.zza(zzrxVar);
                }
            }

            public C0038zza() {
                zzFl();
            }

            public static C0038zza[] zzFk() {
                if (zzbhE == null) {
                    synchronized (zzsc.zzbiu) {
                        if (zzbhE == null) {
                            zzbhE = new C0038zza[0];
                        }
                    }
                }
                return zzbhE;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof C0038zza)) {
                    return false;
                }
                C0038zza c0038zza = (C0038zza) obj;
                if (this.type != c0038zza.type) {
                    return false;
                }
                if (this.zzbhF == null) {
                    if (c0038zza.zzbhF != null) {
                        return false;
                    }
                } else if (!this.zzbhF.equals(c0038zza.zzbhF)) {
                    return false;
                }
                return (this.zzbik == null || this.zzbik.isEmpty()) ? c0038zza.zzbik == null || c0038zza.zzbik.isEmpty() : this.zzbik.equals(c0038zza.zzbik);
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((this.zzbhF == null ? 0 : this.zzbhF.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31)) * 31;
                if (this.zzbik != null && !this.zzbik.isEmpty()) {
                    i = this.zzbik.hashCode();
                }
                return hashCode + i;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
            public int zzB() {
                int zzB = super.zzB() + zzrx.zzA(1, this.type);
                return this.zzbhF != null ? zzB + zzrx.zzc(2, this.zzbhF) : zzB;
            }

            @Override // com.google.android.gms.internal.zzse
            /* renamed from: zzC, reason: merged with bridge method [inline-methods] */
            public C0038zza zzb(zzrw zzrwVar) throws IOException {
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
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                    this.type = zzFr;
                                    break;
                            }
                        case 18:
                            if (this.zzbhF == null) {
                                this.zzbhF = new C0039zza();
                            }
                            zzrwVar.zza(this.zzbhF);
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

            public C0038zza zzFl() {
                this.type = 1;
                this.zzbhF = null;
                this.zzbik = null;
                this.zzbiv = -1;
                return this;
            }

            @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
            public void zza(zzrx zzrxVar) throws IOException {
                zzrxVar.zzy(1, this.type);
                if (this.zzbhF != null) {
                    zzrxVar.zza(2, this.zzbhF);
                }
                super.zza(zzrxVar);
            }
        }

        public zza() {
            zzFj();
        }

        public static zza[] zzFi() {
            if (zzbhC == null) {
                synchronized (zzsc.zzbiu) {
                    if (zzbhC == null) {
                        zzbhC = new zza[0];
                    }
                }
            }
            return zzbhC;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.name == null) {
                if (zzaVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzaVar.name)) {
                return false;
            }
            if (this.zzbhD == null) {
                if (zzaVar.zzbhD != null) {
                    return false;
                }
            } else if (!this.zzbhD.equals(zzaVar.zzbhD)) {
                return false;
            }
            return (this.zzbik == null || this.zzbik.isEmpty()) ? zzaVar.zzbik == null || zzaVar.zzbik.isEmpty() : this.zzbik.equals(zzaVar.zzbik);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbhD == null ? 0 : this.zzbhD.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.zzbik != null && !this.zzbik.isEmpty()) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public int zzB() {
            int zzB = super.zzB() + zzrx.zzn(1, this.name);
            return this.zzbhD != null ? zzB + zzrx.zzc(2, this.zzbhD) : zzB;
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzB, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzrwVar.readString();
                        break;
                    case 18:
                        if (this.zzbhD == null) {
                            this.zzbhD = new C0038zza();
                        }
                        zzrwVar.zza(this.zzbhD);
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

        public zza zzFj() {
            this.name = "";
            this.zzbhD = null;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            zzrxVar.zzb(1, this.name);
            if (this.zzbhD != null) {
                zzrxVar.zza(2, this.zzbhD);
            }
            super.zza(zzrxVar);
        }
    }

    public zzrt() {
        zzFh();
    }

    public static zzrt zzy(byte[] bArr) throws zzsd {
        return (zzrt) zzse.zza(new zzrt(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzrt)) {
            return false;
        }
        zzrt zzrtVar = (zzrt) obj;
        if (zzsc.equals(this.zzbhB, zzrtVar.zzbhB)) {
            return (this.zzbik == null || this.zzbik.isEmpty()) ? zzrtVar.zzbik == null || zzrtVar.zzbik.isEmpty() : this.zzbik.equals(zzrtVar.zzbik);
        }
        return false;
    }

    public int hashCode() {
        return ((this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzsc.hashCode(this.zzbhB)) * 31);
    }

    @Override // com.google.android.gms.internal.zzse
    /* renamed from: zzA, reason: merged with bridge method [inline-methods] */
    public zzrt zzb(zzrw zzrwVar) throws IOException {
        while (true) {
            int zzFo = zzrwVar.zzFo();
            switch (zzFo) {
                case 0:
                    break;
                case 10:
                    int zzc = zzsh.zzc(zzrwVar, 10);
                    int length = this.zzbhB == null ? 0 : this.zzbhB.length;
                    zza[] zzaVarArr = new zza[zzc + length];
                    if (length != 0) {
                        System.arraycopy(this.zzbhB, 0, zzaVarArr, 0, length);
                    }
                    while (length < zzaVarArr.length - 1) {
                        zzaVarArr[length] = new zza();
                        zzrwVar.zza(zzaVarArr[length]);
                        zzrwVar.zzFo();
                        length++;
                    }
                    zzaVarArr[length] = new zza();
                    zzrwVar.zza(zzaVarArr[length]);
                    this.zzbhB = zzaVarArr;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
    public int zzB() {
        int zzB = super.zzB();
        if (this.zzbhB != null && this.zzbhB.length > 0) {
            for (int i = 0; i < this.zzbhB.length; i++) {
                zza zzaVar = this.zzbhB[i];
                if (zzaVar != null) {
                    zzB += zzrx.zzc(1, zzaVar);
                }
            }
        }
        return zzB;
    }

    public zzrt zzFh() {
        this.zzbhB = zza.zzFi();
        this.zzbik = null;
        this.zzbiv = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
    public void zza(zzrx zzrxVar) throws IOException {
        if (this.zzbhB != null && this.zzbhB.length > 0) {
            for (int i = 0; i < this.zzbhB.length; i++) {
                zza zzaVar = this.zzbhB[i];
                if (zzaVar != null) {
                    zzrxVar.zza(1, zzaVar);
                }
            }
        }
        super.zza(zzrxVar);
    }
}
