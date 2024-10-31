package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.io.IOException;

/* loaded from: classes.dex */
public interface zzqz {

    /* loaded from: classes.dex */
    public static final class zza extends zzry<zza> {
        public long zzbai;
        public zzaf.zzj zzbaj;
        public zzaf.zzf zziR;

        public zza() {
            zzDY();
        }

        public static zza zzw(byte[] bArr) throws zzsd {
            return (zza) zzse.zza(new zza(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.zzbai != zzaVar.zzbai) {
                return false;
            }
            if (this.zziR == null) {
                if (zzaVar.zziR != null) {
                    return false;
                }
            } else if (!this.zziR.equals(zzaVar.zziR)) {
                return false;
            }
            if (this.zzbaj == null) {
                if (zzaVar.zzbaj != null) {
                    return false;
                }
            } else if (!this.zzbaj.equals(zzaVar.zzbaj)) {
                return false;
            }
            return (this.zzbik == null || this.zzbik.isEmpty()) ? zzaVar.zzbik == null || zzaVar.zzbik.isEmpty() : this.zzbik.equals(zzaVar.zzbik);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbaj == null ? 0 : this.zzbaj.hashCode()) + (((this.zziR == null ? 0 : this.zziR.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzbai ^ (this.zzbai >>> 32)))) * 31)) * 31)) * 31;
            if (this.zzbik != null && !this.zzbik.isEmpty()) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public int zzB() {
            int zzB = super.zzB() + zzrx.zzd(1, this.zzbai);
            if (this.zziR != null) {
                zzB += zzrx.zzc(2, this.zziR);
            }
            return this.zzbaj != null ? zzB + zzrx.zzc(3, this.zzbaj) : zzB;
        }

        public zza zzDY() {
            this.zzbai = 0L;
            this.zziR = null;
            this.zzbaj = null;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
        public void zza(zzrx zzrxVar) throws IOException {
            zzrxVar.zzb(1, this.zzbai);
            if (this.zziR != null) {
                zzrxVar.zza(2, this.zziR);
            }
            if (this.zzbaj != null) {
                zzrxVar.zza(3, this.zzbaj);
            }
            super.zza(zzrxVar);
        }

        @Override // com.google.android.gms.internal.zzse
        /* renamed from: zzz, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrw zzrwVar) throws IOException {
            while (true) {
                int zzFo = zzrwVar.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 8:
                        this.zzbai = zzrwVar.zzFq();
                        break;
                    case 18:
                        if (this.zziR == null) {
                            this.zziR = new zzaf.zzf();
                        }
                        zzrwVar.zza(this.zziR);
                        break;
                    case 26:
                        if (this.zzbaj == null) {
                            this.zzbaj = new zzaf.zzj();
                        }
                        zzrwVar.zza(this.zzbaj);
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
