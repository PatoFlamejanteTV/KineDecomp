package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zztj extends zzto {
    private final int zzbtu;
    private final int zzbtv;

    public zztj(byte[] bArr, int i, int i2) {
        super(bArr);
        zzte.zzb(i, i + i2, bArr.length);
        this.zzbtu = i;
        this.zzbtv = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzto, com.google.android.gms.internal.measurement.zzte
    public final int size() {
        return this.zzbtv;
    }

    @Override // com.google.android.gms.internal.measurement.zzto, com.google.android.gms.internal.measurement.zzte
    public final byte zzam(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzbtx[this.zzbtu + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzto, com.google.android.gms.internal.measurement.zzte
    public final byte zzan(int i) {
        return this.zzbtx[this.zzbtu + i];
    }

    @Override // com.google.android.gms.internal.measurement.zzto
    protected final int zzug() {
        return this.zzbtu;
    }
}
