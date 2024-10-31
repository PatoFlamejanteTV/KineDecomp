package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class zzbqd extends zzbqc {
    protected final byte[] zzflp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbqd(byte[] bArr) {
        if (bArr != null) {
            this.zzflp = bArr;
            return;
        }
        throw new NullPointerException();
    }

    @Override // com.google.android.gms.internal.ads.zzbpu
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbpu) || size() != ((zzbpu) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof zzbqd) {
            zzbqd zzbqdVar = (zzbqd) obj;
            int zzakq = zzakq();
            int zzakq2 = zzbqdVar.zzakq();
            if (zzakq == 0 || zzakq2 == 0 || zzakq == zzakq2) {
                return zza(zzbqdVar, 0, size());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbpu
    public int size() {
        return this.zzflp.length;
    }

    @Override // com.google.android.gms.internal.ads.zzbpu
    protected void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzflp, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzbpu
    public final boolean zzako() {
        int zzakr = zzakr();
        return Ri.a(this.zzflp, zzakr, size() + zzakr);
    }

    @Override // com.google.android.gms.internal.ads.zzbpu
    public final zzbqf zzakp() {
        return zzbqf.zzb(this.zzflp, zzakr(), size(), true);
    }

    protected int zzakr() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbpu
    public byte zzem(int i) {
        return this.zzflp[i];
    }

    @Override // com.google.android.gms.internal.ads.zzbpu
    protected final int zzf(int i, int i2, int i3) {
        return zzbrf.zza(i, this.zzflp, zzakr(), i3);
    }

    @Override // com.google.android.gms.internal.ads.zzbpu
    public final zzbpu zzt(int i, int i2) {
        int zzg = zzbpu.zzg(0, i2, size());
        if (zzg == 0) {
            return zzbpu.zzfli;
        }
        return new zzbpy(this.zzflp, zzakr(), zzg);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzbpu
    public final void zza(zzbpt zzbptVar) throws IOException {
        zzbptVar.zzh(this.zzflp, zzakr(), size());
    }

    @Override // com.google.android.gms.internal.ads.zzbpu
    protected final String zza(Charset charset) {
        return new String(this.zzflp, zzakr(), size(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzbqc
    final boolean zza(zzbpu zzbpuVar, int i, int i2) {
        if (i2 <= zzbpuVar.size()) {
            if (i2 <= zzbpuVar.size()) {
                if (zzbpuVar instanceof zzbqd) {
                    zzbqd zzbqdVar = (zzbqd) zzbpuVar;
                    byte[] bArr = this.zzflp;
                    byte[] bArr2 = zzbqdVar.zzflp;
                    int zzakr = zzakr() + i2;
                    int zzakr2 = zzakr();
                    int zzakr3 = zzbqdVar.zzakr();
                    while (zzakr2 < zzakr) {
                        if (bArr[zzakr2] != bArr2[zzakr3]) {
                            return false;
                        }
                        zzakr2++;
                        zzakr3++;
                    }
                    return true;
                }
                return zzbpuVar.zzt(0, i2).equals(zzt(0, i2));
            }
            int size = zzbpuVar.size();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: 0, ");
            sb.append(i2);
            sb.append(", ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int size2 = size();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i2);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }
}
