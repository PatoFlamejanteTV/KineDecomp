package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class zzbvw extends zzbvy implements zzbc {
    private String type;
    private long zzapb;
    private zzbd zzgcf;
    private boolean zzgcn;

    public zzbvw(String str) {
        this.type = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbc
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzbc
    public final void zza(zzbd zzbdVar) {
        this.zzgcf = zzbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbc
    public final void zza(zzbwa zzbwaVar, ByteBuffer byteBuffer, long j, zzaz zzazVar) throws IOException {
        this.zzapb = zzbwaVar.position() - byteBuffer.remaining();
        this.zzgcn = byteBuffer.remaining() == 16;
        zza(zzbwaVar, j, zzazVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final void zza(zzbwa zzbwaVar, long j, zzaz zzazVar) throws IOException {
        this.zzgcl = zzbwaVar;
        this.zzgcr = zzbwaVar.position();
        this.zzayz = this.zzgcr - ((this.zzgcn || 8 + j >= 4294967296L) ? 16 : 8);
        zzbwaVar.zzaw(zzbwaVar.position() + j);
        this.zzaop = zzbwaVar.position();
        this.zzgcp = zzazVar;
    }
}
