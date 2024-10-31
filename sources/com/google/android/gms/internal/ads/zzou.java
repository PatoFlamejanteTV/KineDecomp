package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzou implements zzov {
    private final byte[] data;
    private Uri uri;
    private int zzbfo;
    private int zzbfp;

    public zzou(byte[] bArr) {
        zzpo.checkNotNull(bArr);
        zzpo.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final void close() throws IOException {
        this.uri = null;
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzbfp;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.data, this.zzbfo, bArr, i, min);
        this.zzbfo += min;
        this.zzbfp -= min;
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final long zza(zzoz zzozVar) throws IOException {
        this.uri = zzozVar.uri;
        long j = zzozVar.zzaha;
        this.zzbfo = (int) j;
        long j2 = zzozVar.zzcc;
        if (j2 == -1) {
            j2 = this.data.length - j;
        }
        this.zzbfp = (int) j2;
        int i = this.zzbfp;
        if (i > 0 && this.zzbfo + i <= this.data.length) {
            return i;
        }
        int i2 = this.zzbfo;
        long j3 = zzozVar.zzcc;
        int length = this.data.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i2);
        sb.append(", ");
        sb.append(j3);
        sb.append("], length: ");
        sb.append(length);
        throw new IOException(sb.toString());
    }
}
