package com.google.android.gms.internal;

import java.io.IOException;

/* loaded from: classes.dex */
public interface zzpk {

    /* loaded from: classes.dex */
    public static final class zza extends zzse {
        private static volatile zza[] zzaOC;
        public Integer count;
        public String name;
        public zzb[] zzaOD;
        public Long zzaOE;
        public Long zzaOF;

        public zza() {
            zzAy();
        }

        public static zza[] zzAx() {
            if (zzaOC == null) {
                synchronized (zzsc.zzbiu) {
                    if (zzaOC == null) {
                        zzaOC = new zza[0];
                    }
                }
            }
            return zzaOC;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (!zzsc.equals(this.zzaOD, zzaVar.zzaOD)) {
                return false;
            }
            if (this.name == null) {
                if (zzaVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzaVar.name)) {
                return false;
            }
            if (this.zzaOE == null) {
                if (zzaVar.zzaOE != null) {
                    return false;
                }
            } else if (!this.zzaOE.equals(zzaVar.zzaOE)) {
                return false;
            }
            if (this.zzaOF == null) {
                if (zzaVar.zzaOF != null) {
                    return false;
                }
            } else if (!this.zzaOF.equals(zzaVar.zzaOF)) {
                return false;
            }
            return this.count == null ? zzaVar.count == null : this.count.equals(zzaVar.count);
        }

        public int hashCode() {
            return (((this.zzaOF == null ? 0 : this.zzaOF.hashCode()) + (((this.zzaOE == null ? 0 : this.zzaOE.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzsc.hashCode(this.zzaOD)) * 31)) * 31)) * 31)) * 31) + (this.count != null ? this.count.hashCode() : 0);
        }

        public zza zzAy() {
            this.zzaOD = zzb.zzAz();
            this.name = null;
            this.zzaOE = null;
            this.zzaOF = null;
            this.count = null;
            this.zzbiv = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzse
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzaOD != null && this.zzaOD.length > 0) {
                for (int i = 0; i < this.zzaOD.length; i++) {
                    zzb zzbVar = this.zzaOD[i];
                    if (zzbVar != null) {
                        zzB += zzrx.zzc(1, zzbVar);
                    }
                }
            }
            if (this.name != null) {
                zzB += zzrx.zzn(2, this.name);
            }
            if (this.zzaOE != null) {
                zzB += zzrx.zzd(3, this.zzaOE.longValue());
            }
            if (this.zzaOF != null) {
                zzB += zzrx.zzd(4, this.zzaOF.longValue());
            }
            return this.count != null ? zzB + zzrx.zzA(5, this.count.intValue()) : zzB;
        }

        @Override // com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            if (this.zzaOD != null && this.zzaOD.length > 0) {
                for (int i = 0; i < this.zzaOD.length; i++) {
                    zzb zzbVar = this.zzaOD[i];
                    if (zzbVar != null) {
                        zzrxVar.zza(1, zzbVar);
                    }
                }
            }
            if (this.name != null) {
                zzrxVar.zzb(2, this.name);
            }
            if (this.zzaOE != null) {
                zzrxVar.zzb(3, this.zzaOE.longValue());
            }
            if (this.zzaOF != null) {
                zzrxVar.zzb(4, this.zzaOF.longValue());
            }
            if (this.count != null) {
                zzrxVar.zzy(5, this.count.intValue());
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzu, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsh.zzc(zzrwVar, 10);
                        int length = this.zzaOD == null ? 0 : this.zzaOD.length;
                        zzb[] zzbVarArr = new zzb[zzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzaOD, 0, zzbVarArr, 0, length);
                        }
                        while (length < zzbVarArr.length - 1) {
                            zzbVarArr[length] = new zzb();
                            zzrwVar.zza(zzbVarArr[length]);
                            zzrwVar.zzFo();
                            length++;
                        }
                        zzbVarArr[length] = new zzb();
                        zzrwVar.zza(zzbVarArr[length]);
                        this.zzaOD = zzbVarArr;
                        break;
                    case 18:
                        this.name = zzrwVar.readString();
                        break;
                    case 24:
                        this.zzaOE = Long.valueOf(zzrwVar.zzFq());
                        break;
                    case 32:
                        this.zzaOF = Long.valueOf(zzrwVar.zzFq());
                        break;
                    case 40:
                        this.count = Integer.valueOf(zzrwVar.zzFr());
                        break;
                    default:
                        if (!zzsh.zzb(zzrwVar, zzFo)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzse {
        private static volatile zzb[] zzaOG;
        public String name;
        public Float zzaOB;
        public Long zzaOH;
        public String zzagS;

        public zzb() {
            zzAA();
        }

        public static zzb[] zzAz() {
            if (zzaOG == null) {
                synchronized (zzsc.zzbiu) {
                    if (zzaOG == null) {
                        zzaOG = new zzb[0];
                    }
                }
            }
            return zzaOG;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (this.name == null) {
                if (zzbVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzbVar.name)) {
                return false;
            }
            if (this.zzagS == null) {
                if (zzbVar.zzagS != null) {
                    return false;
                }
            } else if (!this.zzagS.equals(zzbVar.zzagS)) {
                return false;
            }
            if (this.zzaOH == null) {
                if (zzbVar.zzaOH != null) {
                    return false;
                }
            } else if (!this.zzaOH.equals(zzbVar.zzaOH)) {
                return false;
            }
            return this.zzaOB == null ? zzbVar.zzaOB == null : this.zzaOB.equals(zzbVar.zzaOB);
        }

        public int hashCode() {
            return (((this.zzaOH == null ? 0 : this.zzaOH.hashCode()) + (((this.zzagS == null ? 0 : this.zzagS.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + (this.zzaOB != null ? this.zzaOB.hashCode() : 0);
        }

        public zzb zzAA() {
            this.name = null;
            this.zzagS = null;
            this.zzaOH = null;
            this.zzaOB = null;
            this.zzbiv = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzse
        public int zzB() {
            int zzB = super.zzB();
            if (this.name != null) {
                zzB += zzrx.zzn(1, this.name);
            }
            if (this.zzagS != null) {
                zzB += zzrx.zzn(2, this.zzagS);
            }
            if (this.zzaOH != null) {
                zzB += zzrx.zzd(3, this.zzaOH.longValue());
            }
            return this.zzaOB != null ? zzB + zzrx.zzc(4, this.zzaOB.floatValue()) : zzB;
        }

        @Override // com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            if (this.name != null) {
                zzrxVar.zzb(1, this.name);
            }
            if (this.zzagS != null) {
                zzrxVar.zzb(2, this.zzagS);
            }
            if (this.zzaOH != null) {
                zzrxVar.zzb(3, this.zzaOH.longValue());
            }
            if (this.zzaOB != null) {
                zzrxVar.zzb(4, this.zzaOB.floatValue());
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzv, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzrwVar.readString();
                        break;
                    case 18:
                        this.zzagS = zzrwVar.readString();
                        break;
                    case 24:
                        this.zzaOH = Long.valueOf(zzrwVar.zzFq());
                        break;
                    case 37:
                        this.zzaOB = Float.valueOf(zzrwVar.readFloat());
                        break;
                    default:
                        if (!zzsh.zzb(zzrwVar, zzFo)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzc extends zzse {
        public zzd[] zzaOI;

        public zzc() {
            zzAB();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof zzc) && zzsc.equals(this.zzaOI, ((zzc) obj).zzaOI);
        }

        public int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + zzsc.hashCode(this.zzaOI);
        }

        public zzc zzAB() {
            this.zzaOI = zzd.zzAC();
            this.zzbiv = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzse
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzaOI != null && this.zzaOI.length > 0) {
                for (int i = 0; i < this.zzaOI.length; i++) {
                    zzd zzdVar = this.zzaOI[i];
                    if (zzdVar != null) {
                        zzB += zzrx.zzc(1, zzdVar);
                    }
                }
            }
            return zzB;
        }

        @Override // com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            if (this.zzaOI != null && this.zzaOI.length > 0) {
                for (int i = 0; i < this.zzaOI.length; i++) {
                    zzd zzdVar = this.zzaOI[i];
                    if (zzdVar != null) {
                        zzrxVar.zza(1, zzdVar);
                    }
                }
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzw, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsh.zzc(zzrwVar, 10);
                        int length = this.zzaOI == null ? 0 : this.zzaOI.length;
                        zzd[] zzdVarArr = new zzd[zzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzaOI, 0, zzdVarArr, 0, length);
                        }
                        while (length < zzdVarArr.length - 1) {
                            zzdVarArr[length] = new zzd();
                            zzrwVar.zza(zzdVarArr[length]);
                            zzrwVar.zzFo();
                            length++;
                        }
                        zzdVarArr[length] = new zzd();
                        zzrwVar.zza(zzdVarArr[length]);
                        this.zzaOI = zzdVarArr;
                        break;
                    default:
                        if (!zzsh.zzb(zzrwVar, zzFo)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzd extends zzse {
        private static volatile zzd[] zzaOJ;
        public String zzaDC;
        public String zzaLP;
        public String zzaLQ;
        public Integer zzaOK;
        public zza[] zzaOL;
        public zze[] zzaOM;
        public Long zzaON;
        public Long zzaOO;
        public Long zzaOP;
        public Long zzaOQ;
        public Long zzaOR;
        public String zzaOS;
        public String zzaOT;
        public String zzaOU;
        public String zzaOV;
        public Integer zzaOW;
        public String zzaOX;
        public Long zzaOY;
        public Long zzaOZ;
        public String zzaPa;
        public Boolean zzaPb;
        public String zzaPc;
        public Long zzaPd;
        public Integer zzaPe;
        public String zzaPf;
        public Boolean zzaPg;

        public zzd() {
            zzAD();
        }

        public static zzd[] zzAC() {
            if (zzaOJ == null) {
                synchronized (zzsc.zzbiu) {
                    if (zzaOJ == null) {
                        zzaOJ = new zzd[0];
                    }
                }
            }
            return zzaOJ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) obj;
            if (this.zzaOK == null) {
                if (zzdVar.zzaOK != null) {
                    return false;
                }
            } else if (!this.zzaOK.equals(zzdVar.zzaOK)) {
                return false;
            }
            if (zzsc.equals(this.zzaOL, zzdVar.zzaOL) && zzsc.equals(this.zzaOM, zzdVar.zzaOM)) {
                if (this.zzaON == null) {
                    if (zzdVar.zzaON != null) {
                        return false;
                    }
                } else if (!this.zzaON.equals(zzdVar.zzaON)) {
                    return false;
                }
                if (this.zzaOO == null) {
                    if (zzdVar.zzaOO != null) {
                        return false;
                    }
                } else if (!this.zzaOO.equals(zzdVar.zzaOO)) {
                    return false;
                }
                if (this.zzaOP == null) {
                    if (zzdVar.zzaOP != null) {
                        return false;
                    }
                } else if (!this.zzaOP.equals(zzdVar.zzaOP)) {
                    return false;
                }
                if (this.zzaOQ == null) {
                    if (zzdVar.zzaOQ != null) {
                        return false;
                    }
                } else if (!this.zzaOQ.equals(zzdVar.zzaOQ)) {
                    return false;
                }
                if (this.zzaOR == null) {
                    if (zzdVar.zzaOR != null) {
                        return false;
                    }
                } else if (!this.zzaOR.equals(zzdVar.zzaOR)) {
                    return false;
                }
                if (this.zzaOS == null) {
                    if (zzdVar.zzaOS != null) {
                        return false;
                    }
                } else if (!this.zzaOS.equals(zzdVar.zzaOS)) {
                    return false;
                }
                if (this.zzaOT == null) {
                    if (zzdVar.zzaOT != null) {
                        return false;
                    }
                } else if (!this.zzaOT.equals(zzdVar.zzaOT)) {
                    return false;
                }
                if (this.zzaOU == null) {
                    if (zzdVar.zzaOU != null) {
                        return false;
                    }
                } else if (!this.zzaOU.equals(zzdVar.zzaOU)) {
                    return false;
                }
                if (this.zzaOV == null) {
                    if (zzdVar.zzaOV != null) {
                        return false;
                    }
                } else if (!this.zzaOV.equals(zzdVar.zzaOV)) {
                    return false;
                }
                if (this.zzaOW == null) {
                    if (zzdVar.zzaOW != null) {
                        return false;
                    }
                } else if (!this.zzaOW.equals(zzdVar.zzaOW)) {
                    return false;
                }
                if (this.zzaLQ == null) {
                    if (zzdVar.zzaLQ != null) {
                        return false;
                    }
                } else if (!this.zzaLQ.equals(zzdVar.zzaLQ)) {
                    return false;
                }
                if (this.zzaOX == null) {
                    if (zzdVar.zzaOX != null) {
                        return false;
                    }
                } else if (!this.zzaOX.equals(zzdVar.zzaOX)) {
                    return false;
                }
                if (this.zzaDC == null) {
                    if (zzdVar.zzaDC != null) {
                        return false;
                    }
                } else if (!this.zzaDC.equals(zzdVar.zzaDC)) {
                    return false;
                }
                if (this.zzaOY == null) {
                    if (zzdVar.zzaOY != null) {
                        return false;
                    }
                } else if (!this.zzaOY.equals(zzdVar.zzaOY)) {
                    return false;
                }
                if (this.zzaOZ == null) {
                    if (zzdVar.zzaOZ != null) {
                        return false;
                    }
                } else if (!this.zzaOZ.equals(zzdVar.zzaOZ)) {
                    return false;
                }
                if (this.zzaPa == null) {
                    if (zzdVar.zzaPa != null) {
                        return false;
                    }
                } else if (!this.zzaPa.equals(zzdVar.zzaPa)) {
                    return false;
                }
                if (this.zzaPb == null) {
                    if (zzdVar.zzaPb != null) {
                        return false;
                    }
                } else if (!this.zzaPb.equals(zzdVar.zzaPb)) {
                    return false;
                }
                if (this.zzaPc == null) {
                    if (zzdVar.zzaPc != null) {
                        return false;
                    }
                } else if (!this.zzaPc.equals(zzdVar.zzaPc)) {
                    return false;
                }
                if (this.zzaPd == null) {
                    if (zzdVar.zzaPd != null) {
                        return false;
                    }
                } else if (!this.zzaPd.equals(zzdVar.zzaPd)) {
                    return false;
                }
                if (this.zzaPe == null) {
                    if (zzdVar.zzaPe != null) {
                        return false;
                    }
                } else if (!this.zzaPe.equals(zzdVar.zzaPe)) {
                    return false;
                }
                if (this.zzaPf == null) {
                    if (zzdVar.zzaPf != null) {
                        return false;
                    }
                } else if (!this.zzaPf.equals(zzdVar.zzaPf)) {
                    return false;
                }
                if (this.zzaLP == null) {
                    if (zzdVar.zzaLP != null) {
                        return false;
                    }
                } else if (!this.zzaLP.equals(zzdVar.zzaLP)) {
                    return false;
                }
                return this.zzaPg == null ? zzdVar.zzaPg == null : this.zzaPg.equals(zzdVar.zzaPg);
            }
            return false;
        }

        public int hashCode() {
            return (((this.zzaLP == null ? 0 : this.zzaLP.hashCode()) + (((this.zzaPf == null ? 0 : this.zzaPf.hashCode()) + (((this.zzaPe == null ? 0 : this.zzaPe.hashCode()) + (((this.zzaPd == null ? 0 : this.zzaPd.hashCode()) + (((this.zzaPc == null ? 0 : this.zzaPc.hashCode()) + (((this.zzaPb == null ? 0 : this.zzaPb.hashCode()) + (((this.zzaPa == null ? 0 : this.zzaPa.hashCode()) + (((this.zzaOZ == null ? 0 : this.zzaOZ.hashCode()) + (((this.zzaOY == null ? 0 : this.zzaOY.hashCode()) + (((this.zzaDC == null ? 0 : this.zzaDC.hashCode()) + (((this.zzaOX == null ? 0 : this.zzaOX.hashCode()) + (((this.zzaLQ == null ? 0 : this.zzaLQ.hashCode()) + (((this.zzaOW == null ? 0 : this.zzaOW.hashCode()) + (((this.zzaOV == null ? 0 : this.zzaOV.hashCode()) + (((this.zzaOU == null ? 0 : this.zzaOU.hashCode()) + (((this.zzaOT == null ? 0 : this.zzaOT.hashCode()) + (((this.zzaOS == null ? 0 : this.zzaOS.hashCode()) + (((this.zzaOR == null ? 0 : this.zzaOR.hashCode()) + (((this.zzaOQ == null ? 0 : this.zzaOQ.hashCode()) + (((this.zzaOP == null ? 0 : this.zzaOP.hashCode()) + (((this.zzaOO == null ? 0 : this.zzaOO.hashCode()) + (((this.zzaON == null ? 0 : this.zzaON.hashCode()) + (((((((this.zzaOK == null ? 0 : this.zzaOK.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzsc.hashCode(this.zzaOL)) * 31) + zzsc.hashCode(this.zzaOM)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (this.zzaPg != null ? this.zzaPg.hashCode() : 0);
        }

        public zzd zzAD() {
            this.zzaOK = null;
            this.zzaOL = zza.zzAx();
            this.zzaOM = zze.zzAE();
            this.zzaON = null;
            this.zzaOO = null;
            this.zzaOP = null;
            this.zzaOQ = null;
            this.zzaOR = null;
            this.zzaOS = null;
            this.zzaOT = null;
            this.zzaOU = null;
            this.zzaOV = null;
            this.zzaOW = null;
            this.zzaLQ = null;
            this.zzaOX = null;
            this.zzaDC = null;
            this.zzaOY = null;
            this.zzaOZ = null;
            this.zzaPa = null;
            this.zzaPb = null;
            this.zzaPc = null;
            this.zzaPd = null;
            this.zzaPe = null;
            this.zzaPf = null;
            this.zzaLP = null;
            this.zzaPg = null;
            this.zzbiv = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzse
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzaOK != null) {
                zzB += zzrx.zzA(1, this.zzaOK.intValue());
            }
            if (this.zzaOL != null && this.zzaOL.length > 0) {
                int i = zzB;
                for (int i2 = 0; i2 < this.zzaOL.length; i2++) {
                    zza zzaVar = this.zzaOL[i2];
                    if (zzaVar != null) {
                        i += zzrx.zzc(2, zzaVar);
                    }
                }
                zzB = i;
            }
            if (this.zzaOM != null && this.zzaOM.length > 0) {
                for (int i3 = 0; i3 < this.zzaOM.length; i3++) {
                    zze zzeVar = this.zzaOM[i3];
                    if (zzeVar != null) {
                        zzB += zzrx.zzc(3, zzeVar);
                    }
                }
            }
            if (this.zzaON != null) {
                zzB += zzrx.zzd(4, this.zzaON.longValue());
            }
            if (this.zzaOO != null) {
                zzB += zzrx.zzd(5, this.zzaOO.longValue());
            }
            if (this.zzaOP != null) {
                zzB += zzrx.zzd(6, this.zzaOP.longValue());
            }
            if (this.zzaOR != null) {
                zzB += zzrx.zzd(7, this.zzaOR.longValue());
            }
            if (this.zzaOS != null) {
                zzB += zzrx.zzn(8, this.zzaOS);
            }
            if (this.zzaOT != null) {
                zzB += zzrx.zzn(9, this.zzaOT);
            }
            if (this.zzaOU != null) {
                zzB += zzrx.zzn(10, this.zzaOU);
            }
            if (this.zzaOV != null) {
                zzB += zzrx.zzn(11, this.zzaOV);
            }
            if (this.zzaOW != null) {
                zzB += zzrx.zzA(12, this.zzaOW.intValue());
            }
            if (this.zzaLQ != null) {
                zzB += zzrx.zzn(13, this.zzaLQ);
            }
            if (this.zzaOX != null) {
                zzB += zzrx.zzn(14, this.zzaOX);
            }
            if (this.zzaDC != null) {
                zzB += zzrx.zzn(16, this.zzaDC);
            }
            if (this.zzaOY != null) {
                zzB += zzrx.zzd(17, this.zzaOY.longValue());
            }
            if (this.zzaOZ != null) {
                zzB += zzrx.zzd(18, this.zzaOZ.longValue());
            }
            if (this.zzaPa != null) {
                zzB += zzrx.zzn(19, this.zzaPa);
            }
            if (this.zzaPb != null) {
                zzB += zzrx.zzc(20, this.zzaPb.booleanValue());
            }
            if (this.zzaPc != null) {
                zzB += zzrx.zzn(21, this.zzaPc);
            }
            if (this.zzaPd != null) {
                zzB += zzrx.zzd(22, this.zzaPd.longValue());
            }
            if (this.zzaPe != null) {
                zzB += zzrx.zzA(23, this.zzaPe.intValue());
            }
            if (this.zzaPf != null) {
                zzB += zzrx.zzn(24, this.zzaPf);
            }
            if (this.zzaLP != null) {
                zzB += zzrx.zzn(25, this.zzaLP);
            }
            if (this.zzaOQ != null) {
                zzB += zzrx.zzd(26, this.zzaOQ.longValue());
            }
            return this.zzaPg != null ? zzB + zzrx.zzc(28, this.zzaPg.booleanValue()) : zzB;
        }

        @Override // com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            if (this.zzaOK != null) {
                zzrxVar.zzy(1, this.zzaOK.intValue());
            }
            if (this.zzaOL != null && this.zzaOL.length > 0) {
                for (int i = 0; i < this.zzaOL.length; i++) {
                    zza zzaVar = this.zzaOL[i];
                    if (zzaVar != null) {
                        zzrxVar.zza(2, zzaVar);
                    }
                }
            }
            if (this.zzaOM != null && this.zzaOM.length > 0) {
                for (int i2 = 0; i2 < this.zzaOM.length; i2++) {
                    zze zzeVar = this.zzaOM[i2];
                    if (zzeVar != null) {
                        zzrxVar.zza(3, zzeVar);
                    }
                }
            }
            if (this.zzaON != null) {
                zzrxVar.zzb(4, this.zzaON.longValue());
            }
            if (this.zzaOO != null) {
                zzrxVar.zzb(5, this.zzaOO.longValue());
            }
            if (this.zzaOP != null) {
                zzrxVar.zzb(6, this.zzaOP.longValue());
            }
            if (this.zzaOR != null) {
                zzrxVar.zzb(7, this.zzaOR.longValue());
            }
            if (this.zzaOS != null) {
                zzrxVar.zzb(8, this.zzaOS);
            }
            if (this.zzaOT != null) {
                zzrxVar.zzb(9, this.zzaOT);
            }
            if (this.zzaOU != null) {
                zzrxVar.zzb(10, this.zzaOU);
            }
            if (this.zzaOV != null) {
                zzrxVar.zzb(11, this.zzaOV);
            }
            if (this.zzaOW != null) {
                zzrxVar.zzy(12, this.zzaOW.intValue());
            }
            if (this.zzaLQ != null) {
                zzrxVar.zzb(13, this.zzaLQ);
            }
            if (this.zzaOX != null) {
                zzrxVar.zzb(14, this.zzaOX);
            }
            if (this.zzaDC != null) {
                zzrxVar.zzb(16, this.zzaDC);
            }
            if (this.zzaOY != null) {
                zzrxVar.zzb(17, this.zzaOY.longValue());
            }
            if (this.zzaOZ != null) {
                zzrxVar.zzb(18, this.zzaOZ.longValue());
            }
            if (this.zzaPa != null) {
                zzrxVar.zzb(19, this.zzaPa);
            }
            if (this.zzaPb != null) {
                zzrxVar.zzb(20, this.zzaPb.booleanValue());
            }
            if (this.zzaPc != null) {
                zzrxVar.zzb(21, this.zzaPc);
            }
            if (this.zzaPd != null) {
                zzrxVar.zzb(22, this.zzaPd.longValue());
            }
            if (this.zzaPe != null) {
                zzrxVar.zzy(23, this.zzaPe.intValue());
            }
            if (this.zzaPf != null) {
                zzrxVar.zzb(24, this.zzaPf);
            }
            if (this.zzaLP != null) {
                zzrxVar.zzb(25, this.zzaLP);
            }
            if (this.zzaOQ != null) {
                zzrxVar.zzb(26, this.zzaOQ.longValue());
            }
            if (this.zzaPg != null) {
                zzrxVar.zzb(28, this.zzaPg.booleanValue());
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzx, reason: merged with bridge method [inline-methods] */
        public zzd zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 8:
                        this.zzaOK = Integer.valueOf(zzrwVar.zzFr());
                        break;
                    case 18:
                        int zzc = zzsh.zzc(zzrwVar, 18);
                        int length = this.zzaOL == null ? 0 : this.zzaOL.length;
                        zza[] zzaVarArr = new zza[zzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzaOL, 0, zzaVarArr, 0, length);
                        }
                        while (length < zzaVarArr.length - 1) {
                            zzaVarArr[length] = new zza();
                            zzrwVar.zza(zzaVarArr[length]);
                            zzrwVar.zzFo();
                            length++;
                        }
                        zzaVarArr[length] = new zza();
                        zzrwVar.zza(zzaVarArr[length]);
                        this.zzaOL = zzaVarArr;
                        break;
                    case 26:
                        int zzc2 = zzsh.zzc(zzrwVar, 26);
                        int length2 = this.zzaOM == null ? 0 : this.zzaOM.length;
                        zze[] zzeVarArr = new zze[zzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzaOM, 0, zzeVarArr, 0, length2);
                        }
                        while (length2 < zzeVarArr.length - 1) {
                            zzeVarArr[length2] = new zze();
                            zzrwVar.zza(zzeVarArr[length2]);
                            zzrwVar.zzFo();
                            length2++;
                        }
                        zzeVarArr[length2] = new zze();
                        zzrwVar.zza(zzeVarArr[length2]);
                        this.zzaOM = zzeVarArr;
                        break;
                    case 32:
                        this.zzaON = Long.valueOf(zzrwVar.zzFq());
                        break;
                    case 40:
                        this.zzaOO = Long.valueOf(zzrwVar.zzFq());
                        break;
                    case 48:
                        this.zzaOP = Long.valueOf(zzrwVar.zzFq());
                        break;
                    case 56:
                        this.zzaOR = Long.valueOf(zzrwVar.zzFq());
                        break;
                    case 66:
                        this.zzaOS = zzrwVar.readString();
                        break;
                    case 74:
                        this.zzaOT = zzrwVar.readString();
                        break;
                    case 82:
                        this.zzaOU = zzrwVar.readString();
                        break;
                    case 90:
                        this.zzaOV = zzrwVar.readString();
                        break;
                    case 96:
                        this.zzaOW = Integer.valueOf(zzrwVar.zzFr());
                        break;
                    case 106:
                        this.zzaLQ = zzrwVar.readString();
                        break;
                    case 114:
                        this.zzaOX = zzrwVar.readString();
                        break;
                    case 130:
                        this.zzaDC = zzrwVar.readString();
                        break;
                    case 136:
                        this.zzaOY = Long.valueOf(zzrwVar.zzFq());
                        break;
                    case 144:
                        this.zzaOZ = Long.valueOf(zzrwVar.zzFq());
                        break;
                    case 154:
                        this.zzaPa = zzrwVar.readString();
                        break;
                    case 160:
                        this.zzaPb = Boolean.valueOf(zzrwVar.zzFs());
                        break;
                    case 170:
                        this.zzaPc = zzrwVar.readString();
                        break;
                    case 176:
                        this.zzaPd = Long.valueOf(zzrwVar.zzFq());
                        break;
                    case 184:
                        this.zzaPe = Integer.valueOf(zzrwVar.zzFr());
                        break;
                    case 194:
                        this.zzaPf = zzrwVar.readString();
                        break;
                    case 202:
                        this.zzaLP = zzrwVar.readString();
                        break;
                    case 208:
                        this.zzaOQ = Long.valueOf(zzrwVar.zzFq());
                        break;
                    case 224:
                        this.zzaPg = Boolean.valueOf(zzrwVar.zzFs());
                        break;
                    default:
                        if (!zzsh.zzb(zzrwVar, zzFo)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class zze extends zzse {
        private static volatile zze[] zzaPh;
        public String name;
        public Float zzaOB;
        public Long zzaOH;
        public Long zzaPi;
        public String zzagS;

        public zze() {
            zzAF();
        }

        public static zze[] zzAE() {
            if (zzaPh == null) {
                synchronized (zzsc.zzbiu) {
                    if (zzaPh == null) {
                        zzaPh = new zze[0];
                    }
                }
            }
            return zzaPh;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zzeVar = (zze) obj;
            if (this.zzaPi == null) {
                if (zzeVar.zzaPi != null) {
                    return false;
                }
            } else if (!this.zzaPi.equals(zzeVar.zzaPi)) {
                return false;
            }
            if (this.name == null) {
                if (zzeVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzeVar.name)) {
                return false;
            }
            if (this.zzagS == null) {
                if (zzeVar.zzagS != null) {
                    return false;
                }
            } else if (!this.zzagS.equals(zzeVar.zzagS)) {
                return false;
            }
            if (this.zzaOH == null) {
                if (zzeVar.zzaOH != null) {
                    return false;
                }
            } else if (!this.zzaOH.equals(zzeVar.zzaOH)) {
                return false;
            }
            return this.zzaOB == null ? zzeVar.zzaOB == null : this.zzaOB.equals(zzeVar.zzaOB);
        }

        public int hashCode() {
            return (((this.zzaOH == null ? 0 : this.zzaOH.hashCode()) + (((this.zzagS == null ? 0 : this.zzagS.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.zzaPi == null ? 0 : this.zzaPi.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31) + (this.zzaOB != null ? this.zzaOB.hashCode() : 0);
        }

        public zze zzAF() {
            this.zzaPi = null;
            this.name = null;
            this.zzagS = null;
            this.zzaOH = null;
            this.zzaOB = null;
            this.zzbiv = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzse
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzaPi != null) {
                zzB += zzrx.zzd(1, this.zzaPi.longValue());
            }
            if (this.name != null) {
                zzB += zzrx.zzn(2, this.name);
            }
            if (this.zzagS != null) {
                zzB += zzrx.zzn(3, this.zzagS);
            }
            if (this.zzaOH != null) {
                zzB += zzrx.zzd(4, this.zzaOH.longValue());
            }
            return this.zzaOB != null ? zzB + zzrx.zzc(5, this.zzaOB.floatValue()) : zzB;
        }

        @Override // com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            if (this.zzaPi != null) {
                zzrxVar.zzb(1, this.zzaPi.longValue());
            }
            if (this.name != null) {
                zzrxVar.zzb(2, this.name);
            }
            if (this.zzagS != null) {
                zzrxVar.zzb(3, this.zzagS);
            }
            if (this.zzaOH != null) {
                zzrxVar.zzb(4, this.zzaOH.longValue());
            }
            if (this.zzaOB != null) {
                zzrxVar.zzb(5, this.zzaOB.floatValue());
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzy, reason: merged with bridge method [inline-methods] */
        public zze zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 8:
                        this.zzaPi = Long.valueOf(zzrwVar.zzFq());
                        break;
                    case 18:
                        this.name = zzrwVar.readString();
                        break;
                    case 26:
                        this.zzagS = zzrwVar.readString();
                        break;
                    case 32:
                        this.zzaOH = Long.valueOf(zzrwVar.zzFq());
                        break;
                    case 45:
                        this.zzaOB = Float.valueOf(zzrwVar.readFloat());
                        break;
                    default:
                        if (!zzsh.zzb(zzrwVar, zzFo)) {
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
