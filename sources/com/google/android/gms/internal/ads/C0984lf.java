package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

@zzark
/* renamed from: com.google.android.gms.internal.ads.lf */
/* loaded from: classes2.dex */
final class C0984lf implements zzov {

    /* renamed from: a */
    private final zzov f12295a;

    /* renamed from: b */
    private final long f12296b;

    /* renamed from: c */
    private final zzov f12297c;

    /* renamed from: d */
    private long f12298d;

    /* renamed from: e */
    private Uri f12299e;

    public C0984lf(zzov zzovVar, int i, zzov zzovVar2) {
        this.f12295a = zzovVar;
        this.f12296b = i;
        this.f12297c = zzovVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final void close() throws IOException {
        this.f12295a.close();
        this.f12297c.close();
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final Uri getUri() {
        return this.f12299e;
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.f12298d;
        long j2 = this.f12296b;
        if (j < j2) {
            i3 = this.f12295a.read(bArr, i, (int) Math.min(i2, j2 - j));
            this.f12298d += i3;
        } else {
            i3 = 0;
        }
        if (this.f12298d < this.f12296b) {
            return i3;
        }
        int read = this.f12297c.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.f12298d += read;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final long zza(zzoz zzozVar) throws IOException {
        zzoz zzozVar2;
        zzoz zzozVar3;
        this.f12299e = zzozVar.uri;
        long j = zzozVar.zzaha;
        long j2 = this.f12296b;
        if (j >= j2) {
            zzozVar2 = null;
        } else {
            long j3 = zzozVar.zzcc;
            zzozVar2 = new zzoz(zzozVar.uri, j, j3 != -1 ? Math.min(j3, j2 - j) : j2 - j, null);
        }
        long j4 = zzozVar.zzcc;
        if (j4 == -1 || zzozVar.zzaha + j4 > this.f12296b) {
            long max = Math.max(this.f12296b, zzozVar.zzaha);
            long j5 = zzozVar.zzcc;
            zzozVar3 = new zzoz(zzozVar.uri, max, j5 != -1 ? Math.min(j5, (zzozVar.zzaha + j5) - this.f12296b) : -1L, null);
        } else {
            zzozVar3 = null;
        }
        long zza = zzozVar2 != null ? this.f12295a.zza(zzozVar2) : 0L;
        long zza2 = zzozVar3 != null ? this.f12297c.zza(zzozVar3) : 0L;
        this.f12298d = zzozVar.zzaha;
        if (zza == -1 || zza2 == -1) {
            return -1L;
        }
        return zza + zza2;
    }
}
