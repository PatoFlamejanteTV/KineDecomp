package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public class zzto extends zztn {
    protected final byte[] zzbtx;

    public zzto(byte[] bArr) {
        if (bArr != null) {
            this.zzbtx = bArr;
            return;
        }
        throw new NullPointerException();
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzte) || size() != ((zzte) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof zzto) {
            zzto zztoVar = (zzto) obj;
            int zzuf = zzuf();
            int zzuf2 = zztoVar.zzuf();
            if (zzuf == 0 || zzuf2 == 0 || zzuf == zzuf2) {
                return zza(zztoVar, 0, size());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public int size() {
        return this.zzbtx.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public final void zza(zztd zztdVar) throws IOException {
        zztdVar.zza(this.zzbtx, zzug(), size());
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public byte zzam(int i) {
        return this.zzbtx[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public byte zzan(int i) {
        return this.zzbtx[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public final zzte zzb(int i, int i2) {
        int zzb = zzte.zzb(0, i2, size());
        if (zzb == 0) {
            return zzte.zzbtq;
        }
        return new zztj(this.zzbtx, zzug(), zzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public final boolean zzue() {
        int zzug = zzug();
        return zb.a(this.zzbtx, zzug, size() + zzug);
    }

    protected int zzug() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    protected final String zza(Charset charset) {
        return new String(this.zzbtx, zzug(), size(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zztn
    final boolean zza(zzte zzteVar, int i, int i2) {
        if (i2 <= zzteVar.size()) {
            if (i2 <= zzteVar.size()) {
                if (zzteVar instanceof zzto) {
                    zzto zztoVar = (zzto) zzteVar;
                    byte[] bArr = this.zzbtx;
                    byte[] bArr2 = zztoVar.zzbtx;
                    int zzug = zzug() + i2;
                    int zzug2 = zzug();
                    int zzug3 = zztoVar.zzug();
                    while (zzug2 < zzug) {
                        if (bArr[zzug2] != bArr2[zzug3]) {
                            return false;
                        }
                        zzug2++;
                        zzug3++;
                    }
                    return true;
                }
                return zzteVar.zzb(0, i2).equals(zzb(0, i2));
            }
            int size = zzteVar.size();
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

    @Override // com.google.android.gms.internal.measurement.zzte
    protected final int zza(int i, int i2, int i3) {
        return zzuq.zza(i, this.zzbtx, zzug(), i3);
    }
}
