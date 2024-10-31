package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfx extends zzyc<zzfx> {
    public long[] zzayn;
    public long[] zzayo;
    public zzfs[] zzayp;
    public zzfy[] zzayq;

    public zzfx() {
        long[] jArr = zzyl.zzcfi;
        this.zzayn = jArr;
        this.zzayo = jArr;
        this.zzayp = zzfs.zzmy();
        this.zzayq = zzfy.zznc();
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfx)) {
            return false;
        }
        zzfx zzfxVar = (zzfx) obj;
        if (!zzyg.equals(this.zzayn, zzfxVar.zzayn) || !zzyg.equals(this.zzayo, zzfxVar.zzayo) || !zzyg.equals(this.zzayp, zzfxVar.zzayp) || !zzyg.equals(this.zzayq, zzfxVar.zzayq)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfxVar.zzcet);
        }
        zzye zzyeVar2 = zzfxVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (((((((((zzfx.class.getName().hashCode() + 527) * 31) + zzyg.hashCode(this.zzayn)) * 31) + zzyg.hashCode(this.zzayo)) * 31) + zzyg.hashCode(this.zzayp)) * 31) + zzyg.hashCode(this.zzayq)) * 31;
        zzye zzyeVar = this.zzcet;
        return hashCode + ((zzyeVar == null || zzyeVar.isEmpty()) ? 0 : this.zzcet.hashCode());
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        long[] jArr = this.zzayn;
        int i = 0;
        if (jArr != null && jArr.length > 0) {
            int i2 = 0;
            while (true) {
                long[] jArr2 = this.zzayn;
                if (i2 >= jArr2.length) {
                    break;
                }
                zzyaVar.zza(1, jArr2[i2]);
                i2++;
            }
        }
        long[] jArr3 = this.zzayo;
        if (jArr3 != null && jArr3.length > 0) {
            int i3 = 0;
            while (true) {
                long[] jArr4 = this.zzayo;
                if (i3 >= jArr4.length) {
                    break;
                }
                zzyaVar.zza(2, jArr4[i3]);
                i3++;
            }
        }
        zzfs[] zzfsVarArr = this.zzayp;
        if (zzfsVarArr != null && zzfsVarArr.length > 0) {
            int i4 = 0;
            while (true) {
                zzfs[] zzfsVarArr2 = this.zzayp;
                if (i4 >= zzfsVarArr2.length) {
                    break;
                }
                zzfs zzfsVar = zzfsVarArr2[i4];
                if (zzfsVar != null) {
                    zzyaVar.zza(3, zzfsVar);
                }
                i4++;
            }
        }
        zzfy[] zzfyVarArr = this.zzayq;
        if (zzfyVarArr != null && zzfyVarArr.length > 0) {
            while (true) {
                zzfy[] zzfyVarArr2 = this.zzayq;
                if (i >= zzfyVarArr2.length) {
                    break;
                }
                zzfy zzfyVar = zzfyVarArr2[i];
                if (zzfyVar != null) {
                    zzyaVar.zza(4, zzfyVar);
                }
                i++;
            }
        }
        super.zza(zzyaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final int zzf() {
        long[] jArr;
        long[] jArr2;
        int zzf = super.zzf();
        long[] jArr3 = this.zzayn;
        int i = 0;
        if (jArr3 != null && jArr3.length > 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                jArr2 = this.zzayn;
                if (i2 >= jArr2.length) {
                    break;
                }
                i3 += zzya.zzbg(jArr2[i2]);
                i2++;
            }
            zzf = zzf + i3 + (jArr2.length * 1);
        }
        long[] jArr4 = this.zzayo;
        if (jArr4 != null && jArr4.length > 0) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                jArr = this.zzayo;
                if (i4 >= jArr.length) {
                    break;
                }
                i5 += zzya.zzbg(jArr[i4]);
                i4++;
            }
            zzf = zzf + i5 + (jArr.length * 1);
        }
        zzfs[] zzfsVarArr = this.zzayp;
        if (zzfsVarArr != null && zzfsVarArr.length > 0) {
            int i6 = zzf;
            int i7 = 0;
            while (true) {
                zzfs[] zzfsVarArr2 = this.zzayp;
                if (i7 >= zzfsVarArr2.length) {
                    break;
                }
                zzfs zzfsVar = zzfsVarArr2[i7];
                if (zzfsVar != null) {
                    i6 += zzya.zzb(3, zzfsVar);
                }
                i7++;
            }
            zzf = i6;
        }
        zzfy[] zzfyVarArr = this.zzayq;
        if (zzfyVarArr != null && zzfyVarArr.length > 0) {
            while (true) {
                zzfy[] zzfyVarArr2 = this.zzayq;
                if (i >= zzfyVarArr2.length) {
                    break;
                }
                zzfy zzfyVar = zzfyVarArr2[i];
                if (zzfyVar != null) {
                    zzf += zzya.zzb(4, zzfyVar);
                }
                i++;
            }
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                int zzb = zzyl.zzb(zzxzVar, 8);
                long[] jArr = this.zzayn;
                int length = jArr == null ? 0 : jArr.length;
                long[] jArr2 = new long[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzayn, 0, jArr2, 0, length);
                }
                while (length < jArr2.length - 1) {
                    jArr2[length] = zzxzVar.zzvc();
                    zzxzVar.zzuj();
                    length++;
                }
                jArr2[length] = zzxzVar.zzvc();
                this.zzayn = jArr2;
            } else if (zzuj == 10) {
                int zzas = zzxzVar.zzas(zzxzVar.zzvb());
                int position = zzxzVar.getPosition();
                int i = 0;
                while (zzxzVar.zzyy() > 0) {
                    zzxzVar.zzvc();
                    i++;
                }
                zzxzVar.zzcb(position);
                long[] jArr3 = this.zzayn;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                long[] jArr4 = new long[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.zzayn, 0, jArr4, 0, length2);
                }
                while (length2 < jArr4.length) {
                    jArr4[length2] = zzxzVar.zzvc();
                    length2++;
                }
                this.zzayn = jArr4;
                zzxzVar.zzat(zzas);
            } else if (zzuj == 16) {
                int zzb2 = zzyl.zzb(zzxzVar, 16);
                long[] jArr5 = this.zzayo;
                int length3 = jArr5 == null ? 0 : jArr5.length;
                long[] jArr6 = new long[zzb2 + length3];
                if (length3 != 0) {
                    System.arraycopy(this.zzayo, 0, jArr6, 0, length3);
                }
                while (length3 < jArr6.length - 1) {
                    jArr6[length3] = zzxzVar.zzvc();
                    zzxzVar.zzuj();
                    length3++;
                }
                jArr6[length3] = zzxzVar.zzvc();
                this.zzayo = jArr6;
            } else if (zzuj == 18) {
                int zzas2 = zzxzVar.zzas(zzxzVar.zzvb());
                int position2 = zzxzVar.getPosition();
                int i2 = 0;
                while (zzxzVar.zzyy() > 0) {
                    zzxzVar.zzvc();
                    i2++;
                }
                zzxzVar.zzcb(position2);
                long[] jArr7 = this.zzayo;
                int length4 = jArr7 == null ? 0 : jArr7.length;
                long[] jArr8 = new long[i2 + length4];
                if (length4 != 0) {
                    System.arraycopy(this.zzayo, 0, jArr8, 0, length4);
                }
                while (length4 < jArr8.length) {
                    jArr8[length4] = zzxzVar.zzvc();
                    length4++;
                }
                this.zzayo = jArr8;
                zzxzVar.zzat(zzas2);
            } else if (zzuj == 26) {
                int zzb3 = zzyl.zzb(zzxzVar, 26);
                zzfs[] zzfsVarArr = this.zzayp;
                int length5 = zzfsVarArr == null ? 0 : zzfsVarArr.length;
                zzfs[] zzfsVarArr2 = new zzfs[zzb3 + length5];
                if (length5 != 0) {
                    System.arraycopy(this.zzayp, 0, zzfsVarArr2, 0, length5);
                }
                while (length5 < zzfsVarArr2.length - 1) {
                    zzfsVarArr2[length5] = new zzfs();
                    zzxzVar.zza(zzfsVarArr2[length5]);
                    zzxzVar.zzuj();
                    length5++;
                }
                zzfsVarArr2[length5] = new zzfs();
                zzxzVar.zza(zzfsVarArr2[length5]);
                this.zzayp = zzfsVarArr2;
            } else if (zzuj != 34) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                int zzb4 = zzyl.zzb(zzxzVar, 34);
                zzfy[] zzfyVarArr = this.zzayq;
                int length6 = zzfyVarArr == null ? 0 : zzfyVarArr.length;
                zzfy[] zzfyVarArr2 = new zzfy[zzb4 + length6];
                if (length6 != 0) {
                    System.arraycopy(this.zzayq, 0, zzfyVarArr2, 0, length6);
                }
                while (length6 < zzfyVarArr2.length - 1) {
                    zzfyVarArr2[length6] = new zzfy();
                    zzxzVar.zza(zzfyVarArr2[length6]);
                    zzxzVar.zzuj();
                    length6++;
                }
                zzfyVarArr2[length6] = new zzfy();
                zzxzVar.zza(zzfyVarArr2[length6]);
                this.zzayq = zzfyVarArr2;
            }
        }
    }
}
