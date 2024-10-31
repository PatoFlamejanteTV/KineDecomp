package com.google.android.gms.internal;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.internal.zzag;
import java.io.IOException;

/* loaded from: classes.dex */
public interface zzaf {

    /* loaded from: classes.dex */
    public static final class zza extends zzry<zza> {
        public int level;
        public int zzhN;
        public int zzhO;

        public zza() {
            zzA();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.level == zzaVar.level && this.zzhN == zzaVar.zzhN && this.zzhO == zzaVar.zzhO) {
                return (this.zzbik == null || this.zzbik.isEmpty()) ? zzaVar.zzbik == null || zzaVar.zzbik.isEmpty() : this.zzbik.equals(zzaVar.zzbik);
            }
            return false;
        }

        public int hashCode() {
            return ((this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + this.level) * 31) + this.zzhN) * 31) + this.zzhO) * 31);
        }

        public zza zzA() {
            this.level = 1;
            this.zzhN = 0;
            this.zzhO = 0;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public int zzB() {
            int zzB = super.zzB();
            if (this.level != 1) {
                zzB += zzrx.zzA(1, this.level);
            }
            if (this.zzhN != 0) {
                zzB += zzrx.zzA(2, this.zzhN);
            }
            return this.zzhO != 0 ? zzB + zzrx.zzA(3, this.zzhO) : zzB;
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrw zzrwVar) throws IOException {
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
                                this.level = zzFr;
                                break;
                        }
                    case 16:
                        this.zzhN = zzrwVar.zzFr();
                        break;
                    case 24:
                        this.zzhO = zzrwVar.zzFr();
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

        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            if (this.level != 1) {
                zzrxVar.zzy(1, this.level);
            }
            if (this.zzhN != 0) {
                zzrxVar.zzy(2, this.zzhN);
            }
            if (this.zzhO != 0) {
                zzrxVar.zzy(3, this.zzhO);
            }
            super.zza(zzrxVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzry<zzb> {
        private static volatile zzb[] zzhP;
        public int name;
        public int[] zzhQ;
        public int zzhR;
        public boolean zzhS;
        public boolean zzhT;

        public zzb() {
            zzD();
        }

        public static zzb[] zzC() {
            if (zzhP == null) {
                synchronized (zzsc.zzbiu) {
                    if (zzhP == null) {
                        zzhP = new zzb[0];
                    }
                }
            }
            return zzhP;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (zzsc.equals(this.zzhQ, zzbVar.zzhQ) && this.zzhR == zzbVar.zzhR && this.name == zzbVar.name && this.zzhS == zzbVar.zzhS && this.zzhT == zzbVar.zzhT) {
                return (this.zzbik == null || this.zzbik.isEmpty()) ? zzbVar.zzbik == null || zzbVar.zzbik.isEmpty() : this.zzbik.equals(zzbVar.zzbik);
            }
            return false;
        }

        public int hashCode() {
            return ((this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode()) + (((((this.zzhS ? 1231 : 1237) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzsc.hashCode(this.zzhQ)) * 31) + this.zzhR) * 31) + this.name) * 31)) * 31) + (this.zzhT ? 1231 : 1237)) * 31);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public int zzB() {
            int i;
            int i2 = 0;
            int zzB = super.zzB();
            if (this.zzhT) {
                zzB += zzrx.zzc(1, this.zzhT);
            }
            int zzA = zzrx.zzA(2, this.zzhR) + zzB;
            if (this.zzhQ == null || this.zzhQ.length <= 0) {
                i = zzA;
            } else {
                for (int i3 = 0; i3 < this.zzhQ.length; i3++) {
                    i2 += zzrx.zzlJ(this.zzhQ[i3]);
                }
                i = zzA + i2 + (this.zzhQ.length * 1);
            }
            if (this.name != 0) {
                i += zzrx.zzA(4, this.name);
            }
            return this.zzhS ? i + zzrx.zzc(6, this.zzhS) : i;
        }

        public zzb zzD() {
            this.zzhQ = zzsh.zzbix;
            this.zzhR = 0;
            this.name = 0;
            this.zzhS = false;
            this.zzhT = false;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            if (this.zzhT) {
                zzrxVar.zzb(1, this.zzhT);
            }
            zzrxVar.zzy(2, this.zzhR);
            if (this.zzhQ != null && this.zzhQ.length > 0) {
                for (int i = 0; i < this.zzhQ.length; i++) {
                    zzrxVar.zzy(3, this.zzhQ[i]);
                }
            }
            if (this.name != 0) {
                zzrxVar.zzy(4, this.name);
            }
            if (this.zzhS) {
                zzrxVar.zzb(6, this.zzhS);
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 8:
                        this.zzhT = zzrwVar.zzFs();
                        break;
                    case 16:
                        this.zzhR = zzrwVar.zzFr();
                        break;
                    case 24:
                        int zzc = zzsh.zzc(zzrwVar, 24);
                        int length = this.zzhQ == null ? 0 : this.zzhQ.length;
                        int[] iArr = new int[zzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzhQ, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length++;
                        }
                        iArr[length] = zzrwVar.zzFr();
                        this.zzhQ = iArr;
                        break;
                    case 26:
                        int zzlC = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position = zzrwVar.getPosition();
                        int i = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i++;
                        }
                        zzrwVar.zzlE(position);
                        int length2 = this.zzhQ == null ? 0 : this.zzhQ.length;
                        int[] iArr2 = new int[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzhQ, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzrwVar.zzFr();
                            length2++;
                        }
                        this.zzhQ = iArr2;
                        zzrwVar.zzlD(zzlC);
                        break;
                    case 32:
                        this.name = zzrwVar.zzFr();
                        break;
                    case 48:
                        this.zzhS = zzrwVar.zzFs();
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

    /* loaded from: classes.dex */
    public static final class zzc extends zzry<zzc> {
        private static volatile zzc[] zzhU;
        public String key;
        public long zzhV;
        public long zzhW;
        public boolean zzhX;
        public long zzhY;

        public zzc() {
            zzF();
        }

        public static zzc[] zzE() {
            if (zzhU == null) {
                synchronized (zzsc.zzbiu) {
                    if (zzhU == null) {
                        zzhU = new zzc[0];
                    }
                }
            }
            return zzhU;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) obj;
            if (this.key == null) {
                if (zzcVar.key != null) {
                    return false;
                }
            } else if (!this.key.equals(zzcVar.key)) {
                return false;
            }
            if (this.zzhV == zzcVar.zzhV && this.zzhW == zzcVar.zzhW && this.zzhX == zzcVar.zzhX && this.zzhY == zzcVar.zzhY) {
                return (this.zzbik == null || this.zzbik.isEmpty()) ? zzcVar.zzbik == null || zzcVar.zzbik.isEmpty() : this.zzbik.equals(zzcVar.zzbik);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzhX ? 1231 : 1237) + (((((((this.key == null ? 0 : this.key.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + ((int) (this.zzhV ^ (this.zzhV >>> 32)))) * 31) + ((int) (this.zzhW ^ (this.zzhW >>> 32)))) * 31)) * 31) + ((int) (this.zzhY ^ (this.zzhY >>> 32)))) * 31;
            if (this.zzbik != null && !this.zzbik.isEmpty()) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public int zzB() {
            int zzB = super.zzB();
            if (!this.key.equals("")) {
                zzB += zzrx.zzn(1, this.key);
            }
            if (this.zzhV != 0) {
                zzB += zzrx.zzd(2, this.zzhV);
            }
            if (this.zzhW != 2147483647L) {
                zzB += zzrx.zzd(3, this.zzhW);
            }
            if (this.zzhX) {
                zzB += zzrx.zzc(4, this.zzhX);
            }
            return this.zzhY != 0 ? zzB + zzrx.zzd(5, this.zzhY) : zzB;
        }

        public zzc zzF() {
            this.key = "";
            this.zzhV = 0L;
            this.zzhW = 2147483647L;
            this.zzhX = false;
            this.zzhY = 0L;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            if (!this.key.equals("")) {
                zzrxVar.zzb(1, this.key);
            }
            if (this.zzhV != 0) {
                zzrxVar.zzb(2, this.zzhV);
            }
            if (this.zzhW != 2147483647L) {
                zzrxVar.zzb(3, this.zzhW);
            }
            if (this.zzhX) {
                zzrxVar.zzb(4, this.zzhX);
            }
            if (this.zzhY != 0) {
                zzrxVar.zzb(5, this.zzhY);
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        this.key = zzrwVar.readString();
                        break;
                    case 16:
                        this.zzhV = zzrwVar.zzFq();
                        break;
                    case 24:
                        this.zzhW = zzrwVar.zzFq();
                        break;
                    case 32:
                        this.zzhX = zzrwVar.zzFs();
                        break;
                    case 40:
                        this.zzhY = zzrwVar.zzFq();
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

    /* loaded from: classes.dex */
    public static final class zzd extends zzry<zzd> {
        public zzag.zza[] zzhZ;
        public zzag.zza[] zzia;
        public zzc[] zzib;

        public zzd() {
            zzG();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) obj;
            if (zzsc.equals(this.zzhZ, zzdVar.zzhZ) && zzsc.equals(this.zzia, zzdVar.zzia) && zzsc.equals(this.zzib, zzdVar.zzib)) {
                return (this.zzbik == null || this.zzbik.isEmpty()) ? zzdVar.zzbik == null || zzdVar.zzbik.isEmpty() : this.zzbik.equals(zzdVar.zzbik);
            }
            return false;
        }

        public int hashCode() {
            return ((this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzsc.hashCode(this.zzhZ)) * 31) + zzsc.hashCode(this.zzia)) * 31) + zzsc.hashCode(this.zzib)) * 31);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzhZ != null && this.zzhZ.length > 0) {
                int i = zzB;
                for (int i2 = 0; i2 < this.zzhZ.length; i2++) {
                    zzag.zza zzaVar = this.zzhZ[i2];
                    if (zzaVar != null) {
                        i += zzrx.zzc(1, zzaVar);
                    }
                }
                zzB = i;
            }
            if (this.zzia != null && this.zzia.length > 0) {
                int i3 = zzB;
                for (int i4 = 0; i4 < this.zzia.length; i4++) {
                    zzag.zza zzaVar2 = this.zzia[i4];
                    if (zzaVar2 != null) {
                        i3 += zzrx.zzc(2, zzaVar2);
                    }
                }
                zzB = i3;
            }
            if (this.zzib != null && this.zzib.length > 0) {
                for (int i5 = 0; i5 < this.zzib.length; i5++) {
                    zzc zzcVar = this.zzib[i5];
                    if (zzcVar != null) {
                        zzB += zzrx.zzc(3, zzcVar);
                    }
                }
            }
            return zzB;
        }

        public zzd zzG() {
            this.zzhZ = zzag.zza.zzQ();
            this.zzia = zzag.zza.zzQ();
            this.zzib = zzc.zzE();
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            if (this.zzhZ != null && this.zzhZ.length > 0) {
                for (int i = 0; i < this.zzhZ.length; i++) {
                    zzag.zza zzaVar = this.zzhZ[i];
                    if (zzaVar != null) {
                        zzrxVar.zza(1, zzaVar);
                    }
                }
            }
            if (this.zzia != null && this.zzia.length > 0) {
                for (int i2 = 0; i2 < this.zzia.length; i2++) {
                    zzag.zza zzaVar2 = this.zzia[i2];
                    if (zzaVar2 != null) {
                        zzrxVar.zza(2, zzaVar2);
                    }
                }
            }
            if (this.zzib != null && this.zzib.length > 0) {
                for (int i3 = 0; i3 < this.zzib.length; i3++) {
                    zzc zzcVar = this.zzib[i3];
                    if (zzcVar != null) {
                        zzrxVar.zza(3, zzcVar);
                    }
                }
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zze, reason: merged with bridge method [inline-methods] */
        public zzd zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsh.zzc(zzrwVar, 10);
                        int length = this.zzhZ == null ? 0 : this.zzhZ.length;
                        zzag.zza[] zzaVarArr = new zzag.zza[zzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzhZ, 0, zzaVarArr, 0, length);
                        }
                        while (length < zzaVarArr.length - 1) {
                            zzaVarArr[length] = new zzag.zza();
                            zzrwVar.zza(zzaVarArr[length]);
                            zzrwVar.zzFo();
                            length++;
                        }
                        zzaVarArr[length] = new zzag.zza();
                        zzrwVar.zza(zzaVarArr[length]);
                        this.zzhZ = zzaVarArr;
                        break;
                    case 18:
                        int zzc2 = zzsh.zzc(zzrwVar, 18);
                        int length2 = this.zzia == null ? 0 : this.zzia.length;
                        zzag.zza[] zzaVarArr2 = new zzag.zza[zzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzia, 0, zzaVarArr2, 0, length2);
                        }
                        while (length2 < zzaVarArr2.length - 1) {
                            zzaVarArr2[length2] = new zzag.zza();
                            zzrwVar.zza(zzaVarArr2[length2]);
                            zzrwVar.zzFo();
                            length2++;
                        }
                        zzaVarArr2[length2] = new zzag.zza();
                        zzrwVar.zza(zzaVarArr2[length2]);
                        this.zzia = zzaVarArr2;
                        break;
                    case 26:
                        int zzc3 = zzsh.zzc(zzrwVar, 26);
                        int length3 = this.zzib == null ? 0 : this.zzib.length;
                        zzc[] zzcVarArr = new zzc[zzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzib, 0, zzcVarArr, 0, length3);
                        }
                        while (length3 < zzcVarArr.length - 1) {
                            zzcVarArr[length3] = new zzc();
                            zzrwVar.zza(zzcVarArr[length3]);
                            zzrwVar.zzFo();
                            length3++;
                        }
                        zzcVarArr[length3] = new zzc();
                        zzrwVar.zza(zzcVarArr[length3]);
                        this.zzib = zzcVarArr;
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

    /* loaded from: classes.dex */
    public static final class zze extends zzry<zze> {
        private static volatile zze[] zzic;
        public int key;
        public int value;

        public zze() {
            zzI();
        }

        public static zze[] zzH() {
            if (zzic == null) {
                synchronized (zzsc.zzbiu) {
                    if (zzic == null) {
                        zzic = new zze[0];
                    }
                }
            }
            return zzic;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zzeVar = (zze) obj;
            if (this.key == zzeVar.key && this.value == zzeVar.value) {
                return (this.zzbik == null || this.zzbik.isEmpty()) ? zzeVar.zzbik == null || zzeVar.zzbik.isEmpty() : this.zzbik.equals(zzeVar.zzbik);
            }
            return false;
        }

        public int hashCode() {
            return ((this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + this.key) * 31) + this.value) * 31);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public int zzB() {
            return super.zzB() + zzrx.zzA(1, this.key) + zzrx.zzA(2, this.value);
        }

        public zze zzI() {
            this.key = 0;
            this.value = 0;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            zzrxVar.zzy(1, this.key);
            zzrxVar.zzy(2, this.value);
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
        public zze zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 8:
                        this.key = zzrwVar.zzFr();
                        break;
                    case 16:
                        this.value = zzrwVar.zzFr();
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

    /* loaded from: classes.dex */
    public static final class zzf extends zzry<zzf> {
        public String version;
        public String[] zzid;
        public String[] zzie;
        public zzag.zza[] zzif;
        public zze[] zzig;
        public zzb[] zzih;
        public zzb[] zzii;
        public zzb[] zzij;
        public zzg[] zzik;
        public String zzil;
        public String zzim;
        public String zzin;
        public zza zzio;
        public float zzip;
        public boolean zziq;
        public String[] zzir;
        public int zzis;

        public zzf() {
            zzJ();
        }

        public static zzf zzc(byte[] bArr) throws zzsd {
            return (zzf) zzse.zza(new zzf(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzfVar = (zzf) obj;
            if (!zzsc.equals(this.zzid, zzfVar.zzid) || !zzsc.equals(this.zzie, zzfVar.zzie) || !zzsc.equals(this.zzif, zzfVar.zzif) || !zzsc.equals(this.zzig, zzfVar.zzig) || !zzsc.equals(this.zzih, zzfVar.zzih) || !zzsc.equals(this.zzii, zzfVar.zzii) || !zzsc.equals(this.zzij, zzfVar.zzij) || !zzsc.equals(this.zzik, zzfVar.zzik)) {
                return false;
            }
            if (this.zzil == null) {
                if (zzfVar.zzil != null) {
                    return false;
                }
            } else if (!this.zzil.equals(zzfVar.zzil)) {
                return false;
            }
            if (this.zzim == null) {
                if (zzfVar.zzim != null) {
                    return false;
                }
            } else if (!this.zzim.equals(zzfVar.zzim)) {
                return false;
            }
            if (this.zzin == null) {
                if (zzfVar.zzin != null) {
                    return false;
                }
            } else if (!this.zzin.equals(zzfVar.zzin)) {
                return false;
            }
            if (this.version == null) {
                if (zzfVar.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzfVar.version)) {
                return false;
            }
            if (this.zzio == null) {
                if (zzfVar.zzio != null) {
                    return false;
                }
            } else if (!this.zzio.equals(zzfVar.zzio)) {
                return false;
            }
            if (Float.floatToIntBits(this.zzip) == Float.floatToIntBits(zzfVar.zzip) && this.zziq == zzfVar.zziq && zzsc.equals(this.zzir, zzfVar.zzir) && this.zzis == zzfVar.zzis) {
                return (this.zzbik == null || this.zzbik.isEmpty()) ? zzfVar.zzbik == null || zzfVar.zzbik.isEmpty() : this.zzbik.equals(zzfVar.zzbik);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.zziq ? 1231 : 1237) + (((((this.zzio == null ? 0 : this.zzio.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.zzin == null ? 0 : this.zzin.hashCode()) + (((this.zzim == null ? 0 : this.zzim.hashCode()) + (((this.zzil == null ? 0 : this.zzil.hashCode()) + ((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzsc.hashCode(this.zzid)) * 31) + zzsc.hashCode(this.zzie)) * 31) + zzsc.hashCode(this.zzif)) * 31) + zzsc.hashCode(this.zzig)) * 31) + zzsc.hashCode(this.zzih)) * 31) + zzsc.hashCode(this.zzii)) * 31) + zzsc.hashCode(this.zzij)) * 31) + zzsc.hashCode(this.zzik)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.zzip)) * 31)) * 31) + zzsc.hashCode(this.zzir)) * 31) + this.zzis) * 31;
            if (this.zzbik != null && !this.zzbik.isEmpty()) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public int zzB() {
            int i;
            int zzB = super.zzB();
            if (this.zzie == null || this.zzie.length <= 0) {
                i = zzB;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < this.zzie.length; i4++) {
                    String str = this.zzie[i4];
                    if (str != null) {
                        i3++;
                        i2 += zzrx.zzfA(str);
                    }
                }
                i = zzB + i2 + (i3 * 1);
            }
            if (this.zzif != null && this.zzif.length > 0) {
                int i5 = i;
                for (int i6 = 0; i6 < this.zzif.length; i6++) {
                    zzag.zza zzaVar = this.zzif[i6];
                    if (zzaVar != null) {
                        i5 += zzrx.zzc(2, zzaVar);
                    }
                }
                i = i5;
            }
            if (this.zzig != null && this.zzig.length > 0) {
                int i7 = i;
                for (int i8 = 0; i8 < this.zzig.length; i8++) {
                    zze zzeVar = this.zzig[i8];
                    if (zzeVar != null) {
                        i7 += zzrx.zzc(3, zzeVar);
                    }
                }
                i = i7;
            }
            if (this.zzih != null && this.zzih.length > 0) {
                int i9 = i;
                for (int i10 = 0; i10 < this.zzih.length; i10++) {
                    zzb zzbVar = this.zzih[i10];
                    if (zzbVar != null) {
                        i9 += zzrx.zzc(4, zzbVar);
                    }
                }
                i = i9;
            }
            if (this.zzii != null && this.zzii.length > 0) {
                int i11 = i;
                for (int i12 = 0; i12 < this.zzii.length; i12++) {
                    zzb zzbVar2 = this.zzii[i12];
                    if (zzbVar2 != null) {
                        i11 += zzrx.zzc(5, zzbVar2);
                    }
                }
                i = i11;
            }
            if (this.zzij != null && this.zzij.length > 0) {
                int i13 = i;
                for (int i14 = 0; i14 < this.zzij.length; i14++) {
                    zzb zzbVar3 = this.zzij[i14];
                    if (zzbVar3 != null) {
                        i13 += zzrx.zzc(6, zzbVar3);
                    }
                }
                i = i13;
            }
            if (this.zzik != null && this.zzik.length > 0) {
                int i15 = i;
                for (int i16 = 0; i16 < this.zzik.length; i16++) {
                    zzg zzgVar = this.zzik[i16];
                    if (zzgVar != null) {
                        i15 += zzrx.zzc(7, zzgVar);
                    }
                }
                i = i15;
            }
            if (!this.zzil.equals("")) {
                i += zzrx.zzn(9, this.zzil);
            }
            if (!this.zzim.equals("")) {
                i += zzrx.zzn(10, this.zzim);
            }
            if (!this.zzin.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                i += zzrx.zzn(12, this.zzin);
            }
            if (!this.version.equals("")) {
                i += zzrx.zzn(13, this.version);
            }
            if (this.zzio != null) {
                i += zzrx.zzc(14, this.zzio);
            }
            if (Float.floatToIntBits(this.zzip) != Float.floatToIntBits(0.0f)) {
                i += zzrx.zzc(15, this.zzip);
            }
            if (this.zzir != null && this.zzir.length > 0) {
                int i17 = 0;
                int i18 = 0;
                for (int i19 = 0; i19 < this.zzir.length; i19++) {
                    String str2 = this.zzir[i19];
                    if (str2 != null) {
                        i18++;
                        i17 += zzrx.zzfA(str2);
                    }
                }
                i = i + i17 + (i18 * 2);
            }
            if (this.zzis != 0) {
                i += zzrx.zzA(17, this.zzis);
            }
            if (this.zziq) {
                i += zzrx.zzc(18, this.zziq);
            }
            if (this.zzid == null || this.zzid.length <= 0) {
                return i;
            }
            int i20 = 0;
            int i21 = 0;
            for (int i22 = 0; i22 < this.zzid.length; i22++) {
                String str3 = this.zzid[i22];
                if (str3 != null) {
                    i21++;
                    i20 += zzrx.zzfA(str3);
                }
            }
            return i + i20 + (i21 * 2);
        }

        public zzf zzJ() {
            this.zzid = zzsh.zzbiC;
            this.zzie = zzsh.zzbiC;
            this.zzif = zzag.zza.zzQ();
            this.zzig = zze.zzH();
            this.zzih = zzb.zzC();
            this.zzii = zzb.zzC();
            this.zzij = zzb.zzC();
            this.zzik = zzg.zzK();
            this.zzil = "";
            this.zzim = "";
            this.zzin = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            this.version = "";
            this.zzio = null;
            this.zzip = 0.0f;
            this.zziq = false;
            this.zzir = zzsh.zzbiC;
            this.zzis = 0;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            if (this.zzie != null && this.zzie.length > 0) {
                for (int i = 0; i < this.zzie.length; i++) {
                    String str = this.zzie[i];
                    if (str != null) {
                        zzrxVar.zzb(1, str);
                    }
                }
            }
            if (this.zzif != null && this.zzif.length > 0) {
                for (int i2 = 0; i2 < this.zzif.length; i2++) {
                    zzag.zza zzaVar = this.zzif[i2];
                    if (zzaVar != null) {
                        zzrxVar.zza(2, zzaVar);
                    }
                }
            }
            if (this.zzig != null && this.zzig.length > 0) {
                for (int i3 = 0; i3 < this.zzig.length; i3++) {
                    zze zzeVar = this.zzig[i3];
                    if (zzeVar != null) {
                        zzrxVar.zza(3, zzeVar);
                    }
                }
            }
            if (this.zzih != null && this.zzih.length > 0) {
                for (int i4 = 0; i4 < this.zzih.length; i4++) {
                    zzb zzbVar = this.zzih[i4];
                    if (zzbVar != null) {
                        zzrxVar.zza(4, zzbVar);
                    }
                }
            }
            if (this.zzii != null && this.zzii.length > 0) {
                for (int i5 = 0; i5 < this.zzii.length; i5++) {
                    zzb zzbVar2 = this.zzii[i5];
                    if (zzbVar2 != null) {
                        zzrxVar.zza(5, zzbVar2);
                    }
                }
            }
            if (this.zzij != null && this.zzij.length > 0) {
                for (int i6 = 0; i6 < this.zzij.length; i6++) {
                    zzb zzbVar3 = this.zzij[i6];
                    if (zzbVar3 != null) {
                        zzrxVar.zza(6, zzbVar3);
                    }
                }
            }
            if (this.zzik != null && this.zzik.length > 0) {
                for (int i7 = 0; i7 < this.zzik.length; i7++) {
                    zzg zzgVar = this.zzik[i7];
                    if (zzgVar != null) {
                        zzrxVar.zza(7, zzgVar);
                    }
                }
            }
            if (!this.zzil.equals("")) {
                zzrxVar.zzb(9, this.zzil);
            }
            if (!this.zzim.equals("")) {
                zzrxVar.zzb(10, this.zzim);
            }
            if (!this.zzin.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                zzrxVar.zzb(12, this.zzin);
            }
            if (!this.version.equals("")) {
                zzrxVar.zzb(13, this.version);
            }
            if (this.zzio != null) {
                zzrxVar.zza(14, this.zzio);
            }
            if (Float.floatToIntBits(this.zzip) != Float.floatToIntBits(0.0f)) {
                zzrxVar.zzb(15, this.zzip);
            }
            if (this.zzir != null && this.zzir.length > 0) {
                for (int i8 = 0; i8 < this.zzir.length; i8++) {
                    String str2 = this.zzir[i8];
                    if (str2 != null) {
                        zzrxVar.zzb(16, str2);
                    }
                }
            }
            if (this.zzis != 0) {
                zzrxVar.zzy(17, this.zzis);
            }
            if (this.zziq) {
                zzrxVar.zzb(18, this.zziq);
            }
            if (this.zzid != null && this.zzid.length > 0) {
                for (int i9 = 0; i9 < this.zzid.length; i9++) {
                    String str3 = this.zzid[i9];
                    if (str3 != null) {
                        zzrxVar.zzb(19, str3);
                    }
                }
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public zzf zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsh.zzc(zzrwVar, 10);
                        int length = this.zzie == null ? 0 : this.zzie.length;
                        String[] strArr = new String[zzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzie, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzrwVar.readString();
                            zzrwVar.zzFo();
                            length++;
                        }
                        strArr[length] = zzrwVar.readString();
                        this.zzie = strArr;
                        break;
                    case 18:
                        int zzc2 = zzsh.zzc(zzrwVar, 18);
                        int length2 = this.zzif == null ? 0 : this.zzif.length;
                        zzag.zza[] zzaVarArr = new zzag.zza[zzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzif, 0, zzaVarArr, 0, length2);
                        }
                        while (length2 < zzaVarArr.length - 1) {
                            zzaVarArr[length2] = new zzag.zza();
                            zzrwVar.zza(zzaVarArr[length2]);
                            zzrwVar.zzFo();
                            length2++;
                        }
                        zzaVarArr[length2] = new zzag.zza();
                        zzrwVar.zza(zzaVarArr[length2]);
                        this.zzif = zzaVarArr;
                        break;
                    case 26:
                        int zzc3 = zzsh.zzc(zzrwVar, 26);
                        int length3 = this.zzig == null ? 0 : this.zzig.length;
                        zze[] zzeVarArr = new zze[zzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzig, 0, zzeVarArr, 0, length3);
                        }
                        while (length3 < zzeVarArr.length - 1) {
                            zzeVarArr[length3] = new zze();
                            zzrwVar.zza(zzeVarArr[length3]);
                            zzrwVar.zzFo();
                            length3++;
                        }
                        zzeVarArr[length3] = new zze();
                        zzrwVar.zza(zzeVarArr[length3]);
                        this.zzig = zzeVarArr;
                        break;
                    case 34:
                        int zzc4 = zzsh.zzc(zzrwVar, 34);
                        int length4 = this.zzih == null ? 0 : this.zzih.length;
                        zzb[] zzbVarArr = new zzb[zzc4 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zzih, 0, zzbVarArr, 0, length4);
                        }
                        while (length4 < zzbVarArr.length - 1) {
                            zzbVarArr[length4] = new zzb();
                            zzrwVar.zza(zzbVarArr[length4]);
                            zzrwVar.zzFo();
                            length4++;
                        }
                        zzbVarArr[length4] = new zzb();
                        zzrwVar.zza(zzbVarArr[length4]);
                        this.zzih = zzbVarArr;
                        break;
                    case 42:
                        int zzc5 = zzsh.zzc(zzrwVar, 42);
                        int length5 = this.zzii == null ? 0 : this.zzii.length;
                        zzb[] zzbVarArr2 = new zzb[zzc5 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zzii, 0, zzbVarArr2, 0, length5);
                        }
                        while (length5 < zzbVarArr2.length - 1) {
                            zzbVarArr2[length5] = new zzb();
                            zzrwVar.zza(zzbVarArr2[length5]);
                            zzrwVar.zzFo();
                            length5++;
                        }
                        zzbVarArr2[length5] = new zzb();
                        zzrwVar.zza(zzbVarArr2[length5]);
                        this.zzii = zzbVarArr2;
                        break;
                    case 50:
                        int zzc6 = zzsh.zzc(zzrwVar, 50);
                        int length6 = this.zzij == null ? 0 : this.zzij.length;
                        zzb[] zzbVarArr3 = new zzb[zzc6 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zzij, 0, zzbVarArr3, 0, length6);
                        }
                        while (length6 < zzbVarArr3.length - 1) {
                            zzbVarArr3[length6] = new zzb();
                            zzrwVar.zza(zzbVarArr3[length6]);
                            zzrwVar.zzFo();
                            length6++;
                        }
                        zzbVarArr3[length6] = new zzb();
                        zzrwVar.zza(zzbVarArr3[length6]);
                        this.zzij = zzbVarArr3;
                        break;
                    case 58:
                        int zzc7 = zzsh.zzc(zzrwVar, 58);
                        int length7 = this.zzik == null ? 0 : this.zzik.length;
                        zzg[] zzgVarArr = new zzg[zzc7 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.zzik, 0, zzgVarArr, 0, length7);
                        }
                        while (length7 < zzgVarArr.length - 1) {
                            zzgVarArr[length7] = new zzg();
                            zzrwVar.zza(zzgVarArr[length7]);
                            zzrwVar.zzFo();
                            length7++;
                        }
                        zzgVarArr[length7] = new zzg();
                        zzrwVar.zza(zzgVarArr[length7]);
                        this.zzik = zzgVarArr;
                        break;
                    case 74:
                        this.zzil = zzrwVar.readString();
                        break;
                    case 82:
                        this.zzim = zzrwVar.readString();
                        break;
                    case 98:
                        this.zzin = zzrwVar.readString();
                        break;
                    case 106:
                        this.version = zzrwVar.readString();
                        break;
                    case 114:
                        if (this.zzio == null) {
                            this.zzio = new zza();
                        }
                        zzrwVar.zza(this.zzio);
                        break;
                    case 125:
                        this.zzip = zzrwVar.readFloat();
                        break;
                    case 130:
                        int zzc8 = zzsh.zzc(zzrwVar, 130);
                        int length8 = this.zzir == null ? 0 : this.zzir.length;
                        String[] strArr2 = new String[zzc8 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.zzir, 0, strArr2, 0, length8);
                        }
                        while (length8 < strArr2.length - 1) {
                            strArr2[length8] = zzrwVar.readString();
                            zzrwVar.zzFo();
                            length8++;
                        }
                        strArr2[length8] = zzrwVar.readString();
                        this.zzir = strArr2;
                        break;
                    case 136:
                        this.zzis = zzrwVar.zzFr();
                        break;
                    case 144:
                        this.zziq = zzrwVar.zzFs();
                        break;
                    case 154:
                        int zzc9 = zzsh.zzc(zzrwVar, 154);
                        int length9 = this.zzid == null ? 0 : this.zzid.length;
                        String[] strArr3 = new String[zzc9 + length9];
                        if (length9 != 0) {
                            System.arraycopy(this.zzid, 0, strArr3, 0, length9);
                        }
                        while (length9 < strArr3.length - 1) {
                            strArr3[length9] = zzrwVar.readString();
                            zzrwVar.zzFo();
                            length9++;
                        }
                        strArr3[length9] = zzrwVar.readString();
                        this.zzid = strArr3;
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

    /* loaded from: classes.dex */
    public static final class zzg extends zzry<zzg> {
        private static volatile zzg[] zzit;
        public int[] zziA;
        public int[] zziB;
        public int[] zziC;
        public int[] zziD;
        public int[] zziu;
        public int[] zziv;
        public int[] zziw;
        public int[] zzix;
        public int[] zziy;
        public int[] zziz;

        public zzg() {
            zzL();
        }

        public static zzg[] zzK() {
            if (zzit == null) {
                synchronized (zzsc.zzbiu) {
                    if (zzit == null) {
                        zzit = new zzg[0];
                    }
                }
            }
            return zzit;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg zzgVar = (zzg) obj;
            if (zzsc.equals(this.zziu, zzgVar.zziu) && zzsc.equals(this.zziv, zzgVar.zziv) && zzsc.equals(this.zziw, zzgVar.zziw) && zzsc.equals(this.zzix, zzgVar.zzix) && zzsc.equals(this.zziy, zzgVar.zziy) && zzsc.equals(this.zziz, zzgVar.zziz) && zzsc.equals(this.zziA, zzgVar.zziA) && zzsc.equals(this.zziB, zzgVar.zziB) && zzsc.equals(this.zziC, zzgVar.zziC) && zzsc.equals(this.zziD, zzgVar.zziD)) {
                return (this.zzbik == null || this.zzbik.isEmpty()) ? zzgVar.zzbik == null || zzgVar.zzbik.isEmpty() : this.zzbik.equals(zzgVar.zzbik);
            }
            return false;
        }

        public int hashCode() {
            return ((this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode()) + ((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzsc.hashCode(this.zziu)) * 31) + zzsc.hashCode(this.zziv)) * 31) + zzsc.hashCode(this.zziw)) * 31) + zzsc.hashCode(this.zzix)) * 31) + zzsc.hashCode(this.zziy)) * 31) + zzsc.hashCode(this.zziz)) * 31) + zzsc.hashCode(this.zziA)) * 31) + zzsc.hashCode(this.zziB)) * 31) + zzsc.hashCode(this.zziC)) * 31) + zzsc.hashCode(this.zziD)) * 31);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public int zzB() {
            int i;
            int zzB = super.zzB();
            if (this.zziu == null || this.zziu.length <= 0) {
                i = zzB;
            } else {
                int i2 = 0;
                for (int i3 = 0; i3 < this.zziu.length; i3++) {
                    i2 += zzrx.zzlJ(this.zziu[i3]);
                }
                i = zzB + i2 + (this.zziu.length * 1);
            }
            if (this.zziv != null && this.zziv.length > 0) {
                int i4 = 0;
                for (int i5 = 0; i5 < this.zziv.length; i5++) {
                    i4 += zzrx.zzlJ(this.zziv[i5]);
                }
                i = i + i4 + (this.zziv.length * 1);
            }
            if (this.zziw != null && this.zziw.length > 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < this.zziw.length; i7++) {
                    i6 += zzrx.zzlJ(this.zziw[i7]);
                }
                i = i + i6 + (this.zziw.length * 1);
            }
            if (this.zzix != null && this.zzix.length > 0) {
                int i8 = 0;
                for (int i9 = 0; i9 < this.zzix.length; i9++) {
                    i8 += zzrx.zzlJ(this.zzix[i9]);
                }
                i = i + i8 + (this.zzix.length * 1);
            }
            if (this.zziy != null && this.zziy.length > 0) {
                int i10 = 0;
                for (int i11 = 0; i11 < this.zziy.length; i11++) {
                    i10 += zzrx.zzlJ(this.zziy[i11]);
                }
                i = i + i10 + (this.zziy.length * 1);
            }
            if (this.zziz != null && this.zziz.length > 0) {
                int i12 = 0;
                for (int i13 = 0; i13 < this.zziz.length; i13++) {
                    i12 += zzrx.zzlJ(this.zziz[i13]);
                }
                i = i + i12 + (this.zziz.length * 1);
            }
            if (this.zziA != null && this.zziA.length > 0) {
                int i14 = 0;
                for (int i15 = 0; i15 < this.zziA.length; i15++) {
                    i14 += zzrx.zzlJ(this.zziA[i15]);
                }
                i = i + i14 + (this.zziA.length * 1);
            }
            if (this.zziB != null && this.zziB.length > 0) {
                int i16 = 0;
                for (int i17 = 0; i17 < this.zziB.length; i17++) {
                    i16 += zzrx.zzlJ(this.zziB[i17]);
                }
                i = i + i16 + (this.zziB.length * 1);
            }
            if (this.zziC != null && this.zziC.length > 0) {
                int i18 = 0;
                for (int i19 = 0; i19 < this.zziC.length; i19++) {
                    i18 += zzrx.zzlJ(this.zziC[i19]);
                }
                i = i + i18 + (this.zziC.length * 1);
            }
            if (this.zziD == null || this.zziD.length <= 0) {
                return i;
            }
            int i20 = 0;
            for (int i21 = 0; i21 < this.zziD.length; i21++) {
                i20 += zzrx.zzlJ(this.zziD[i21]);
            }
            return i + i20 + (this.zziD.length * 1);
        }

        public zzg zzL() {
            this.zziu = zzsh.zzbix;
            this.zziv = zzsh.zzbix;
            this.zziw = zzsh.zzbix;
            this.zzix = zzsh.zzbix;
            this.zziy = zzsh.zzbix;
            this.zziz = zzsh.zzbix;
            this.zziA = zzsh.zzbix;
            this.zziB = zzsh.zzbix;
            this.zziC = zzsh.zzbix;
            this.zziD = zzsh.zzbix;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            if (this.zziu != null && this.zziu.length > 0) {
                for (int i = 0; i < this.zziu.length; i++) {
                    zzrxVar.zzy(1, this.zziu[i]);
                }
            }
            if (this.zziv != null && this.zziv.length > 0) {
                for (int i2 = 0; i2 < this.zziv.length; i2++) {
                    zzrxVar.zzy(2, this.zziv[i2]);
                }
            }
            if (this.zziw != null && this.zziw.length > 0) {
                for (int i3 = 0; i3 < this.zziw.length; i3++) {
                    zzrxVar.zzy(3, this.zziw[i3]);
                }
            }
            if (this.zzix != null && this.zzix.length > 0) {
                for (int i4 = 0; i4 < this.zzix.length; i4++) {
                    zzrxVar.zzy(4, this.zzix[i4]);
                }
            }
            if (this.zziy != null && this.zziy.length > 0) {
                for (int i5 = 0; i5 < this.zziy.length; i5++) {
                    zzrxVar.zzy(5, this.zziy[i5]);
                }
            }
            if (this.zziz != null && this.zziz.length > 0) {
                for (int i6 = 0; i6 < this.zziz.length; i6++) {
                    zzrxVar.zzy(6, this.zziz[i6]);
                }
            }
            if (this.zziA != null && this.zziA.length > 0) {
                for (int i7 = 0; i7 < this.zziA.length; i7++) {
                    zzrxVar.zzy(7, this.zziA[i7]);
                }
            }
            if (this.zziB != null && this.zziB.length > 0) {
                for (int i8 = 0; i8 < this.zziB.length; i8++) {
                    zzrxVar.zzy(8, this.zziB[i8]);
                }
            }
            if (this.zziC != null && this.zziC.length > 0) {
                for (int i9 = 0; i9 < this.zziC.length; i9++) {
                    zzrxVar.zzy(9, this.zziC[i9]);
                }
            }
            if (this.zziD != null && this.zziD.length > 0) {
                for (int i10 = 0; i10 < this.zziD.length; i10++) {
                    zzrxVar.zzy(10, this.zziD[i10]);
                }
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
        public zzg zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzsh.zzc(zzrwVar, 8);
                        int length = this.zziu == null ? 0 : this.zziu.length;
                        int[] iArr = new int[zzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zziu, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length++;
                        }
                        iArr[length] = zzrwVar.zzFr();
                        this.zziu = iArr;
                        break;
                    case 10:
                        int zzlC = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position = zzrwVar.getPosition();
                        int i = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i++;
                        }
                        zzrwVar.zzlE(position);
                        int length2 = this.zziu == null ? 0 : this.zziu.length;
                        int[] iArr2 = new int[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zziu, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzrwVar.zzFr();
                            length2++;
                        }
                        this.zziu = iArr2;
                        zzrwVar.zzlD(zzlC);
                        break;
                    case 16:
                        int zzc2 = zzsh.zzc(zzrwVar, 16);
                        int length3 = this.zziv == null ? 0 : this.zziv.length;
                        int[] iArr3 = new int[zzc2 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zziv, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length3++;
                        }
                        iArr3[length3] = zzrwVar.zzFr();
                        this.zziv = iArr3;
                        break;
                    case 18:
                        int zzlC2 = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position2 = zzrwVar.getPosition();
                        int i2 = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i2++;
                        }
                        zzrwVar.zzlE(position2);
                        int length4 = this.zziv == null ? 0 : this.zziv.length;
                        int[] iArr4 = new int[i2 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zziv, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzrwVar.zzFr();
                            length4++;
                        }
                        this.zziv = iArr4;
                        zzrwVar.zzlD(zzlC2);
                        break;
                    case 24:
                        int zzc3 = zzsh.zzc(zzrwVar, 24);
                        int length5 = this.zziw == null ? 0 : this.zziw.length;
                        int[] iArr5 = new int[zzc3 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zziw, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length5++;
                        }
                        iArr5[length5] = zzrwVar.zzFr();
                        this.zziw = iArr5;
                        break;
                    case 26:
                        int zzlC3 = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position3 = zzrwVar.getPosition();
                        int i3 = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i3++;
                        }
                        zzrwVar.zzlE(position3);
                        int length6 = this.zziw == null ? 0 : this.zziw.length;
                        int[] iArr6 = new int[i3 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zziw, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzrwVar.zzFr();
                            length6++;
                        }
                        this.zziw = iArr6;
                        zzrwVar.zzlD(zzlC3);
                        break;
                    case 32:
                        int zzc4 = zzsh.zzc(zzrwVar, 32);
                        int length7 = this.zzix == null ? 0 : this.zzix.length;
                        int[] iArr7 = new int[zzc4 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.zzix, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length7++;
                        }
                        iArr7[length7] = zzrwVar.zzFr();
                        this.zzix = iArr7;
                        break;
                    case 34:
                        int zzlC4 = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position4 = zzrwVar.getPosition();
                        int i4 = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i4++;
                        }
                        zzrwVar.zzlE(position4);
                        int length8 = this.zzix == null ? 0 : this.zzix.length;
                        int[] iArr8 = new int[i4 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.zzix, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzrwVar.zzFr();
                            length8++;
                        }
                        this.zzix = iArr8;
                        zzrwVar.zzlD(zzlC4);
                        break;
                    case 40:
                        int zzc5 = zzsh.zzc(zzrwVar, 40);
                        int length9 = this.zziy == null ? 0 : this.zziy.length;
                        int[] iArr9 = new int[zzc5 + length9];
                        if (length9 != 0) {
                            System.arraycopy(this.zziy, 0, iArr9, 0, length9);
                        }
                        while (length9 < iArr9.length - 1) {
                            iArr9[length9] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length9++;
                        }
                        iArr9[length9] = zzrwVar.zzFr();
                        this.zziy = iArr9;
                        break;
                    case 42:
                        int zzlC5 = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position5 = zzrwVar.getPosition();
                        int i5 = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i5++;
                        }
                        zzrwVar.zzlE(position5);
                        int length10 = this.zziy == null ? 0 : this.zziy.length;
                        int[] iArr10 = new int[i5 + length10];
                        if (length10 != 0) {
                            System.arraycopy(this.zziy, 0, iArr10, 0, length10);
                        }
                        while (length10 < iArr10.length) {
                            iArr10[length10] = zzrwVar.zzFr();
                            length10++;
                        }
                        this.zziy = iArr10;
                        zzrwVar.zzlD(zzlC5);
                        break;
                    case 48:
                        int zzc6 = zzsh.zzc(zzrwVar, 48);
                        int length11 = this.zziz == null ? 0 : this.zziz.length;
                        int[] iArr11 = new int[zzc6 + length11];
                        if (length11 != 0) {
                            System.arraycopy(this.zziz, 0, iArr11, 0, length11);
                        }
                        while (length11 < iArr11.length - 1) {
                            iArr11[length11] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length11++;
                        }
                        iArr11[length11] = zzrwVar.zzFr();
                        this.zziz = iArr11;
                        break;
                    case 50:
                        int zzlC6 = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position6 = zzrwVar.getPosition();
                        int i6 = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i6++;
                        }
                        zzrwVar.zzlE(position6);
                        int length12 = this.zziz == null ? 0 : this.zziz.length;
                        int[] iArr12 = new int[i6 + length12];
                        if (length12 != 0) {
                            System.arraycopy(this.zziz, 0, iArr12, 0, length12);
                        }
                        while (length12 < iArr12.length) {
                            iArr12[length12] = zzrwVar.zzFr();
                            length12++;
                        }
                        this.zziz = iArr12;
                        zzrwVar.zzlD(zzlC6);
                        break;
                    case 56:
                        int zzc7 = zzsh.zzc(zzrwVar, 56);
                        int length13 = this.zziA == null ? 0 : this.zziA.length;
                        int[] iArr13 = new int[zzc7 + length13];
                        if (length13 != 0) {
                            System.arraycopy(this.zziA, 0, iArr13, 0, length13);
                        }
                        while (length13 < iArr13.length - 1) {
                            iArr13[length13] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length13++;
                        }
                        iArr13[length13] = zzrwVar.zzFr();
                        this.zziA = iArr13;
                        break;
                    case 58:
                        int zzlC7 = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position7 = zzrwVar.getPosition();
                        int i7 = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i7++;
                        }
                        zzrwVar.zzlE(position7);
                        int length14 = this.zziA == null ? 0 : this.zziA.length;
                        int[] iArr14 = new int[i7 + length14];
                        if (length14 != 0) {
                            System.arraycopy(this.zziA, 0, iArr14, 0, length14);
                        }
                        while (length14 < iArr14.length) {
                            iArr14[length14] = zzrwVar.zzFr();
                            length14++;
                        }
                        this.zziA = iArr14;
                        zzrwVar.zzlD(zzlC7);
                        break;
                    case 64:
                        int zzc8 = zzsh.zzc(zzrwVar, 64);
                        int length15 = this.zziB == null ? 0 : this.zziB.length;
                        int[] iArr15 = new int[zzc8 + length15];
                        if (length15 != 0) {
                            System.arraycopy(this.zziB, 0, iArr15, 0, length15);
                        }
                        while (length15 < iArr15.length - 1) {
                            iArr15[length15] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length15++;
                        }
                        iArr15[length15] = zzrwVar.zzFr();
                        this.zziB = iArr15;
                        break;
                    case 66:
                        int zzlC8 = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position8 = zzrwVar.getPosition();
                        int i8 = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i8++;
                        }
                        zzrwVar.zzlE(position8);
                        int length16 = this.zziB == null ? 0 : this.zziB.length;
                        int[] iArr16 = new int[i8 + length16];
                        if (length16 != 0) {
                            System.arraycopy(this.zziB, 0, iArr16, 0, length16);
                        }
                        while (length16 < iArr16.length) {
                            iArr16[length16] = zzrwVar.zzFr();
                            length16++;
                        }
                        this.zziB = iArr16;
                        zzrwVar.zzlD(zzlC8);
                        break;
                    case 72:
                        int zzc9 = zzsh.zzc(zzrwVar, 72);
                        int length17 = this.zziC == null ? 0 : this.zziC.length;
                        int[] iArr17 = new int[zzc9 + length17];
                        if (length17 != 0) {
                            System.arraycopy(this.zziC, 0, iArr17, 0, length17);
                        }
                        while (length17 < iArr17.length - 1) {
                            iArr17[length17] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length17++;
                        }
                        iArr17[length17] = zzrwVar.zzFr();
                        this.zziC = iArr17;
                        break;
                    case 74:
                        int zzlC9 = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position9 = zzrwVar.getPosition();
                        int i9 = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i9++;
                        }
                        zzrwVar.zzlE(position9);
                        int length18 = this.zziC == null ? 0 : this.zziC.length;
                        int[] iArr18 = new int[i9 + length18];
                        if (length18 != 0) {
                            System.arraycopy(this.zziC, 0, iArr18, 0, length18);
                        }
                        while (length18 < iArr18.length) {
                            iArr18[length18] = zzrwVar.zzFr();
                            length18++;
                        }
                        this.zziC = iArr18;
                        zzrwVar.zzlD(zzlC9);
                        break;
                    case 80:
                        int zzc10 = zzsh.zzc(zzrwVar, 80);
                        int length19 = this.zziD == null ? 0 : this.zziD.length;
                        int[] iArr19 = new int[zzc10 + length19];
                        if (length19 != 0) {
                            System.arraycopy(this.zziD, 0, iArr19, 0, length19);
                        }
                        while (length19 < iArr19.length - 1) {
                            iArr19[length19] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length19++;
                        }
                        iArr19[length19] = zzrwVar.zzFr();
                        this.zziD = iArr19;
                        break;
                    case 82:
                        int zzlC10 = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position10 = zzrwVar.getPosition();
                        int i10 = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i10++;
                        }
                        zzrwVar.zzlE(position10);
                        int length20 = this.zziD == null ? 0 : this.zziD.length;
                        int[] iArr20 = new int[i10 + length20];
                        if (length20 != 0) {
                            System.arraycopy(this.zziD, 0, iArr20, 0, length20);
                        }
                        while (length20 < iArr20.length) {
                            iArr20[length20] = zzrwVar.zzFr();
                            length20++;
                        }
                        this.zziD = iArr20;
                        zzrwVar.zzlD(zzlC10);
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

    /* loaded from: classes.dex */
    public static final class zzh extends zzry<zzh> {
        public static final zzrz<zzag.zza, zzh> zziE = zzrz.zza(11, zzh.class, 810);
        private static final zzh[] zziF = new zzh[0];
        public int[] zziG;
        public int[] zziH;
        public int[] zziI;
        public int zziJ;
        public int[] zziK;
        public int zziL;
        public int zziM;

        public zzh() {
            zzM();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzh)) {
                return false;
            }
            zzh zzhVar = (zzh) obj;
            if (zzsc.equals(this.zziG, zzhVar.zziG) && zzsc.equals(this.zziH, zzhVar.zziH) && zzsc.equals(this.zziI, zzhVar.zziI) && this.zziJ == zzhVar.zziJ && zzsc.equals(this.zziK, zzhVar.zziK) && this.zziL == zzhVar.zziL && this.zziM == zzhVar.zziM) {
                return (this.zzbik == null || this.zzbik.isEmpty()) ? zzhVar.zzbik == null || zzhVar.zzbik.isEmpty() : this.zzbik.equals(zzhVar.zzbik);
            }
            return false;
        }

        public int hashCode() {
            return ((this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode()) + ((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzsc.hashCode(this.zziG)) * 31) + zzsc.hashCode(this.zziH)) * 31) + zzsc.hashCode(this.zziI)) * 31) + this.zziJ) * 31) + zzsc.hashCode(this.zziK)) * 31) + this.zziL) * 31) + this.zziM) * 31);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public int zzB() {
            int i;
            int zzB = super.zzB();
            if (this.zziG == null || this.zziG.length <= 0) {
                i = zzB;
            } else {
                int i2 = 0;
                for (int i3 = 0; i3 < this.zziG.length; i3++) {
                    i2 += zzrx.zzlJ(this.zziG[i3]);
                }
                i = zzB + i2 + (this.zziG.length * 1);
            }
            if (this.zziH != null && this.zziH.length > 0) {
                int i4 = 0;
                for (int i5 = 0; i5 < this.zziH.length; i5++) {
                    i4 += zzrx.zzlJ(this.zziH[i5]);
                }
                i = i + i4 + (this.zziH.length * 1);
            }
            if (this.zziI != null && this.zziI.length > 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < this.zziI.length; i7++) {
                    i6 += zzrx.zzlJ(this.zziI[i7]);
                }
                i = i + i6 + (this.zziI.length * 1);
            }
            if (this.zziJ != 0) {
                i += zzrx.zzA(4, this.zziJ);
            }
            if (this.zziK != null && this.zziK.length > 0) {
                int i8 = 0;
                for (int i9 = 0; i9 < this.zziK.length; i9++) {
                    i8 += zzrx.zzlJ(this.zziK[i9]);
                }
                i = i + i8 + (this.zziK.length * 1);
            }
            if (this.zziL != 0) {
                i += zzrx.zzA(6, this.zziL);
            }
            return this.zziM != 0 ? i + zzrx.zzA(7, this.zziM) : i;
        }

        public zzh zzM() {
            this.zziG = zzsh.zzbix;
            this.zziH = zzsh.zzbix;
            this.zziI = zzsh.zzbix;
            this.zziJ = 0;
            this.zziK = zzsh.zzbix;
            this.zziL = 0;
            this.zziM = 0;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            if (this.zziG != null && this.zziG.length > 0) {
                for (int i = 0; i < this.zziG.length; i++) {
                    zzrxVar.zzy(1, this.zziG[i]);
                }
            }
            if (this.zziH != null && this.zziH.length > 0) {
                for (int i2 = 0; i2 < this.zziH.length; i2++) {
                    zzrxVar.zzy(2, this.zziH[i2]);
                }
            }
            if (this.zziI != null && this.zziI.length > 0) {
                for (int i3 = 0; i3 < this.zziI.length; i3++) {
                    zzrxVar.zzy(3, this.zziI[i3]);
                }
            }
            if (this.zziJ != 0) {
                zzrxVar.zzy(4, this.zziJ);
            }
            if (this.zziK != null && this.zziK.length > 0) {
                for (int i4 = 0; i4 < this.zziK.length; i4++) {
                    zzrxVar.zzy(5, this.zziK[i4]);
                }
            }
            if (this.zziL != 0) {
                zzrxVar.zzy(6, this.zziL);
            }
            if (this.zziM != 0) {
                zzrxVar.zzy(7, this.zziM);
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
        public zzh zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzsh.zzc(zzrwVar, 8);
                        int length = this.zziG == null ? 0 : this.zziG.length;
                        int[] iArr = new int[zzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zziG, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length++;
                        }
                        iArr[length] = zzrwVar.zzFr();
                        this.zziG = iArr;
                        break;
                    case 10:
                        int zzlC = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position = zzrwVar.getPosition();
                        int i = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i++;
                        }
                        zzrwVar.zzlE(position);
                        int length2 = this.zziG == null ? 0 : this.zziG.length;
                        int[] iArr2 = new int[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zziG, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzrwVar.zzFr();
                            length2++;
                        }
                        this.zziG = iArr2;
                        zzrwVar.zzlD(zzlC);
                        break;
                    case 16:
                        int zzc2 = zzsh.zzc(zzrwVar, 16);
                        int length3 = this.zziH == null ? 0 : this.zziH.length;
                        int[] iArr3 = new int[zzc2 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zziH, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length3++;
                        }
                        iArr3[length3] = zzrwVar.zzFr();
                        this.zziH = iArr3;
                        break;
                    case 18:
                        int zzlC2 = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position2 = zzrwVar.getPosition();
                        int i2 = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i2++;
                        }
                        zzrwVar.zzlE(position2);
                        int length4 = this.zziH == null ? 0 : this.zziH.length;
                        int[] iArr4 = new int[i2 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zziH, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzrwVar.zzFr();
                            length4++;
                        }
                        this.zziH = iArr4;
                        zzrwVar.zzlD(zzlC2);
                        break;
                    case 24:
                        int zzc3 = zzsh.zzc(zzrwVar, 24);
                        int length5 = this.zziI == null ? 0 : this.zziI.length;
                        int[] iArr5 = new int[zzc3 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zziI, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length5++;
                        }
                        iArr5[length5] = zzrwVar.zzFr();
                        this.zziI = iArr5;
                        break;
                    case 26:
                        int zzlC3 = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position3 = zzrwVar.getPosition();
                        int i3 = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i3++;
                        }
                        zzrwVar.zzlE(position3);
                        int length6 = this.zziI == null ? 0 : this.zziI.length;
                        int[] iArr6 = new int[i3 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zziI, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzrwVar.zzFr();
                            length6++;
                        }
                        this.zziI = iArr6;
                        zzrwVar.zzlD(zzlC3);
                        break;
                    case 32:
                        this.zziJ = zzrwVar.zzFr();
                        break;
                    case 40:
                        int zzc4 = zzsh.zzc(zzrwVar, 40);
                        int length7 = this.zziK == null ? 0 : this.zziK.length;
                        int[] iArr7 = new int[zzc4 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.zziK, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzrwVar.zzFr();
                            zzrwVar.zzFo();
                            length7++;
                        }
                        iArr7[length7] = zzrwVar.zzFr();
                        this.zziK = iArr7;
                        break;
                    case 42:
                        int zzlC4 = zzrwVar.zzlC(zzrwVar.zzFv());
                        int position4 = zzrwVar.getPosition();
                        int i4 = 0;
                        while (zzrwVar.zzFA() > 0) {
                            zzrwVar.zzFr();
                            i4++;
                        }
                        zzrwVar.zzlE(position4);
                        int length8 = this.zziK == null ? 0 : this.zziK.length;
                        int[] iArr8 = new int[i4 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.zziK, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzrwVar.zzFr();
                            length8++;
                        }
                        this.zziK = iArr8;
                        zzrwVar.zzlD(zzlC4);
                        break;
                    case 48:
                        this.zziL = zzrwVar.zzFr();
                        break;
                    case 56:
                        this.zziM = zzrwVar.zzFr();
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

    /* loaded from: classes.dex */
    public static final class zzi extends zzry<zzi> {
        private static volatile zzi[] zziN;
        public String name;
        public zzag.zza zziO;
        public zzd zziP;

        public zzi() {
            zzO();
        }

        public static zzi[] zzN() {
            if (zziN == null) {
                synchronized (zzsc.zzbiu) {
                    if (zziN == null) {
                        zziN = new zzi[0];
                    }
                }
            }
            return zziN;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzi)) {
                return false;
            }
            zzi zziVar = (zzi) obj;
            if (this.name == null) {
                if (zziVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zziVar.name)) {
                return false;
            }
            if (this.zziO == null) {
                if (zziVar.zziO != null) {
                    return false;
                }
            } else if (!this.zziO.equals(zziVar.zziO)) {
                return false;
            }
            if (this.zziP == null) {
                if (zziVar.zziP != null) {
                    return false;
                }
            } else if (!this.zziP.equals(zziVar.zziP)) {
                return false;
            }
            return (this.zzbik == null || this.zzbik.isEmpty()) ? zziVar.zzbik == null || zziVar.zzbik.isEmpty() : this.zzbik.equals(zziVar.zzbik);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zziP == null ? 0 : this.zziP.hashCode()) + (((this.zziO == null ? 0 : this.zziO.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.zzbik != null && !this.zzbik.isEmpty()) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public int zzB() {
            int zzB = super.zzB();
            if (!this.name.equals("")) {
                zzB += zzrx.zzn(1, this.name);
            }
            if (this.zziO != null) {
                zzB += zzrx.zzc(2, this.zziO);
            }
            return this.zziP != null ? zzB + zzrx.zzc(3, this.zziP) : zzB;
        }

        public zzi zzO() {
            this.name = "";
            this.zziO = null;
            this.zziP = null;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            if (!this.name.equals("")) {
                zzrxVar.zzb(1, this.name);
            }
            if (this.zziO != null) {
                zzrxVar.zza(2, this.zziO);
            }
            if (this.zziP != null) {
                zzrxVar.zza(3, this.zziP);
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
        public zzi zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzrwVar.readString();
                        break;
                    case 18:
                        if (this.zziO == null) {
                            this.zziO = new zzag.zza();
                        }
                        zzrwVar.zza(this.zziO);
                        break;
                    case 26:
                        if (this.zziP == null) {
                            this.zziP = new zzd();
                        }
                        zzrwVar.zza(this.zziP);
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

    /* loaded from: classes.dex */
    public static final class zzj extends zzry<zzj> {
        public zzi[] zziQ;
        public zzf zziR;
        public String zziS;

        public zzj() {
            zzP();
        }

        public static zzj zzd(byte[] bArr) throws zzsd {
            return (zzj) zzse.zza(new zzj(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzj)) {
                return false;
            }
            zzj zzjVar = (zzj) obj;
            if (!zzsc.equals(this.zziQ, zzjVar.zziQ)) {
                return false;
            }
            if (this.zziR == null) {
                if (zzjVar.zziR != null) {
                    return false;
                }
            } else if (!this.zziR.equals(zzjVar.zziR)) {
                return false;
            }
            if (this.zziS == null) {
                if (zzjVar.zziS != null) {
                    return false;
                }
            } else if (!this.zziS.equals(zzjVar.zziS)) {
                return false;
            }
            return (this.zzbik == null || this.zzbik.isEmpty()) ? zzjVar.zzbik == null || zzjVar.zzbik.isEmpty() : this.zzbik.equals(zzjVar.zzbik);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zziS == null ? 0 : this.zziS.hashCode()) + (((this.zziR == null ? 0 : this.zziR.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzsc.hashCode(this.zziQ)) * 31)) * 31)) * 31;
            if (this.zzbik != null && !this.zzbik.isEmpty()) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public int zzB() {
            int zzB = super.zzB();
            if (this.zziQ != null && this.zziQ.length > 0) {
                for (int i = 0; i < this.zziQ.length; i++) {
                    zzi zziVar = this.zziQ[i];
                    if (zziVar != null) {
                        zzB += zzrx.zzc(1, zziVar);
                    }
                }
            }
            if (this.zziR != null) {
                zzB += zzrx.zzc(2, this.zziR);
            }
            return !this.zziS.equals("") ? zzB + zzrx.zzn(3, this.zziS) : zzB;
        }

        public zzj zzP() {
            this.zziQ = zzi.zzN();
            this.zziR = null;
            this.zziS = "";
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            if (this.zziQ != null && this.zziQ.length > 0) {
                for (int i = 0; i < this.zziQ.length; i++) {
                    zzi zziVar = this.zziQ[i];
                    if (zziVar != null) {
                        zzrxVar.zza(1, zziVar);
                    }
                }
            }
            if (this.zziR != null) {
                zzrxVar.zza(2, this.zziR);
            }
            if (!this.zziS.equals("")) {
                zzrxVar.zzb(3, this.zziS);
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzk, reason: merged with bridge method [inline-methods] */
        public zzj zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsh.zzc(zzrwVar, 10);
                        int length = this.zziQ == null ? 0 : this.zziQ.length;
                        zzi[] zziVarArr = new zzi[zzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zziQ, 0, zziVarArr, 0, length);
                        }
                        while (length < zziVarArr.length - 1) {
                            zziVarArr[length] = new zzi();
                            zzrwVar.zza(zziVarArr[length]);
                            zzrwVar.zzFo();
                            length++;
                        }
                        zziVarArr[length] = new zzi();
                        zzrwVar.zza(zziVarArr[length]);
                        this.zziQ = zziVarArr;
                        break;
                    case 18:
                        if (this.zziR == null) {
                            this.zziR = new zzf();
                        }
                        zzrwVar.zza(this.zziR);
                        break;
                    case 26:
                        this.zziS = zzrwVar.readString();
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
