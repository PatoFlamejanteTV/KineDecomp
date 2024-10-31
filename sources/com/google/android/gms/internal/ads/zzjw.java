package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzjw implements zzhz {
    private static final int zzatm = zzqe.zzam("RCC\u0001");
    private int version;
    private final zzfs zzaad;
    private int zzajn;
    private zzii zzasj;
    private long zzato;
    private int zzatp;
    private final zzpx zzatn = new zzpx(9);
    private int zzaqe = 0;

    public zzjw(zzfs zzfsVar) {
        this.zzaad = zzfsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zza(zzib zzibVar) {
        zzibVar.zza(new zzih(-9223372036854775807L));
        this.zzasj = zzibVar.zzb(0, 3);
        zzibVar.zzdy();
        this.zzasj.zzf(this.zzaad);
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zzc(long j, long j2) {
        this.zzaqe = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final boolean zza(zzia zziaVar) throws IOException, InterruptedException {
        this.zzatn.reset();
        zziaVar.zza(this.zzatn.data, 0, 8);
        return this.zzatn.readInt() == zzatm;
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final int zza(zzia zziaVar, zzif zzifVar) throws IOException, InterruptedException {
        while (true) {
            int i = this.zzaqe;
            boolean z = false;
            boolean z2 = true;
            if (i == 0) {
                this.zzatn.reset();
                if (zziaVar.zza(this.zzatn.data, 0, 8, true)) {
                    if (this.zzatn.readInt() == zzatm) {
                        this.version = this.zzatn.readUnsignedByte();
                        z = true;
                    } else {
                        throw new IOException("Input not RawCC");
                    }
                }
                if (!z) {
                    return -1;
                }
                this.zzaqe = 1;
            } else {
                if (i != 1) {
                    if (i == 2) {
                        while (this.zzatp > 0) {
                            this.zzatn.reset();
                            zziaVar.readFully(this.zzatn.data, 0, 3);
                            this.zzasj.zza(this.zzatn, 3);
                            this.zzajn += 3;
                            this.zzatp--;
                        }
                        int i2 = this.zzajn;
                        if (i2 > 0) {
                            this.zzasj.zza(this.zzato, 1, i2, 0, null);
                        }
                        this.zzaqe = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                }
                this.zzatn.reset();
                int i3 = this.version;
                if (i3 == 0) {
                    if (zziaVar.zza(this.zzatn.data, 0, 5, true)) {
                        this.zzato = (this.zzatn.zzhd() * 1000) / 45;
                        this.zzatp = this.zzatn.readUnsignedByte();
                        this.zzajn = 0;
                    }
                    z2 = false;
                } else if (i3 == 1) {
                    if (zziaVar.zza(this.zzatn.data, 0, 9, true)) {
                        this.zzato = this.zzatn.readLong();
                        this.zzatp = this.zzatn.readUnsignedByte();
                        this.zzajn = 0;
                    }
                    z2 = false;
                } else {
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("Unsupported version number: ");
                    sb.append(i3);
                    throw new zzfx(sb.toString());
                }
                if (z2) {
                    this.zzaqe = 2;
                } else {
                    this.zzaqe = 0;
                    return -1;
                }
            }
        }
    }
}
