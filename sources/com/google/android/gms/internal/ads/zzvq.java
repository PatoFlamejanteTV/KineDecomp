package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzvq extends zzbut<zzvq> {
    public Integer zzchy = null;
    public Integer zzchz = null;
    public Integer zzcia = null;

    public zzvq() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        Integer num = this.zzchy;
        if (num != null) {
            zzburVar.zzv(1, num.intValue());
        }
        Integer num2 = this.zzchz;
        if (num2 != null) {
            zzburVar.zzv(2, num2.intValue());
        }
        Integer num3 = this.zzcia;
        if (num3 != null) {
            zzburVar.zzv(3, num3.intValue());
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        Integer num = this.zzchy;
        if (num != null) {
            zzt += zzbur.zzz(1, num.intValue());
        }
        Integer num2 = this.zzchz;
        if (num2 != null) {
            zzt += zzbur.zzz(2, num2.intValue());
        }
        Integer num3 = this.zzcia;
        return num3 != null ? zzt + zzbur.zzz(3, num3.intValue()) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 8) {
                this.zzchy = Integer.valueOf(zzbuqVar.zzalm());
            } else if (zzaku == 16) {
                this.zzchz = Integer.valueOf(zzbuqVar.zzalm());
            } else if (zzaku != 24) {
                if (!super.zza(zzbuqVar, zzaku)) {
                    return this;
                }
            } else {
                this.zzcia = Integer.valueOf(zzbuqVar.zzalm());
            }
        }
    }
}
