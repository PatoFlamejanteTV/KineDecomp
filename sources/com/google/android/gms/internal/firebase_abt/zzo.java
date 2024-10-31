package com.google.android.gms.internal.firebase_abt;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzo extends zzd<zzo> {
    public String zzaq = "";
    public String zzar = "";
    public long zzas = 0;
    public String zzat = "";
    public long zzau = 0;
    public long zzav = 0;
    private String zzaw = "";
    private String zzax = "";
    private String zzay = "";
    private String zzaz = "";
    private String zzba = "";
    public int zzc = 0;
    public zzn[] zzbb = zzn.zzo();

    public zzo() {
        this.zzs = null;
        this.zzab = -1;
    }

    @Override // com.google.android.gms.internal.firebase_abt.zzj
    public final /* synthetic */ zzj zza(zza zzaVar) throws IOException {
        while (true) {
            int zzd = zzaVar.zzd();
            switch (zzd) {
                case 0:
                    return this;
                case 10:
                    this.zzaq = zzaVar.readString();
                    break;
                case 18:
                    this.zzar = zzaVar.readString();
                    break;
                case 24:
                    this.zzas = zzaVar.zze();
                    break;
                case 34:
                    this.zzat = zzaVar.readString();
                    break;
                case 40:
                    this.zzau = zzaVar.zze();
                    break;
                case 48:
                    this.zzav = zzaVar.zze();
                    break;
                case 58:
                    this.zzaw = zzaVar.readString();
                    break;
                case 66:
                    this.zzax = zzaVar.readString();
                    break;
                case 74:
                    this.zzay = zzaVar.readString();
                    break;
                case 82:
                    this.zzaz = zzaVar.readString();
                    break;
                case 90:
                    this.zzba = zzaVar.readString();
                    break;
                case 96:
                    this.zzc = zzaVar.zzf();
                    break;
                case 106:
                    int zzb = zzm.zzb(zzaVar, 106);
                    zzn[] zznVarArr = this.zzbb;
                    int length = zznVarArr == null ? 0 : zznVarArr.length;
                    zzn[] zznVarArr2 = new zzn[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzbb, 0, zznVarArr2, 0, length);
                    }
                    while (length < zznVarArr2.length - 1) {
                        zznVarArr2[length] = new zzn();
                        zzaVar.zza(zznVarArr2[length]);
                        zzaVar.zzd();
                        length++;
                    }
                    zznVarArr2[length] = new zzn();
                    zzaVar.zza(zznVarArr2[length]);
                    this.zzbb = zznVarArr2;
                    break;
                default:
                    if (!super.zza(zzaVar, zzd)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
