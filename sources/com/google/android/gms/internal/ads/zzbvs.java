package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbvs extends zzbut<zzbvs> {
    public Integer zzgar = null;
    public String mimeType = null;
    public byte[] zzgbs = null;

    public zzbvs() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    private final zzbvs zzg(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 8) {
                int position = zzbuqVar.getPosition();
                try {
                    int zzakx = zzbuqVar.zzakx();
                    if (zzakx >= 0 && zzakx <= 1) {
                        this.zzgar = Integer.valueOf(zzakx);
                    } else {
                        StringBuilder sb = new StringBuilder(36);
                        sb.append(zzakx);
                        sb.append(" is not a valid enum Type");
                        throw new IllegalArgumentException(sb.toString());
                        break;
                    }
                } catch (IllegalArgumentException unused) {
                    zzbuqVar.zzgc(position);
                    zza(zzbuqVar, zzaku);
                }
            } else if (zzaku == 18) {
                this.mimeType = zzbuqVar.readString();
            } else if (zzaku != 26) {
                if (!super.zza(zzbuqVar, zzaku)) {
                    return this;
                }
            } else {
                this.zzgbs = zzbuqVar.readBytes();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        Integer num = this.zzgar;
        if (num != null) {
            zzburVar.zzv(1, num.intValue());
        }
        String str = this.mimeType;
        if (str != null) {
            zzburVar.zzf(2, str);
        }
        byte[] bArr = this.zzgbs;
        if (bArr != null) {
            zzburVar.zza(3, bArr);
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        Integer num = this.zzgar;
        if (num != null) {
            zzt += zzbur.zzz(1, num.intValue());
        }
        String str = this.mimeType;
        if (str != null) {
            zzt += zzbur.zzg(2, str);
        }
        byte[] bArr = this.zzgbs;
        return bArr != null ? zzt + zzbur.zzb(3, bArr) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        zzg(zzbuqVar);
        return this;
    }
}
