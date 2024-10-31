package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbp extends zzbut<zzbp> {
    public byte[] data = null;
    public byte[] zzhm = null;
    public byte[] zzhn = null;
    public byte[] zzho = null;

    public zzbp() {
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        byte[] bArr = this.data;
        if (bArr != null) {
            zzburVar.zza(1, bArr);
        }
        byte[] bArr2 = this.zzhm;
        if (bArr2 != null) {
            zzburVar.zza(2, bArr2);
        }
        byte[] bArr3 = this.zzhn;
        if (bArr3 != null) {
            zzburVar.zza(3, bArr3);
        }
        byte[] bArr4 = this.zzho;
        if (bArr4 != null) {
            zzburVar.zza(4, bArr4);
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        byte[] bArr = this.data;
        if (bArr != null) {
            zzt += zzbur.zzb(1, bArr);
        }
        byte[] bArr2 = this.zzhm;
        if (bArr2 != null) {
            zzt += zzbur.zzb(2, bArr2);
        }
        byte[] bArr3 = this.zzhn;
        if (bArr3 != null) {
            zzt += zzbur.zzb(3, bArr3);
        }
        byte[] bArr4 = this.zzho;
        return bArr4 != null ? zzt + zzbur.zzb(4, bArr4) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 10) {
                this.data = zzbuqVar.readBytes();
            } else if (zzaku == 18) {
                this.zzhm = zzbuqVar.readBytes();
            } else if (zzaku == 26) {
                this.zzhn = zzbuqVar.readBytes();
            } else if (zzaku != 34) {
                if (!super.zza(zzbuqVar, zzaku)) {
                    return this;
                }
            } else {
                this.zzho = zzbuqVar.readBytes();
            }
        }
    }
}
