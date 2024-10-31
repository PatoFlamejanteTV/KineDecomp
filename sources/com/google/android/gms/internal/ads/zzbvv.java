package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class zzbvv implements zzbc {
    private static zzbwg zzco = zzbwg.zzk(zzbvv.class);
    private String type;
    private long zzapb;
    private zzbd zzgcf;
    private ByteBuffer zzgci;
    private long zzgcj;
    private zzbwa zzgcl;
    private long zzgck = -1;
    private ByteBuffer zzgcm = null;
    private boolean zzgch = true;
    boolean zzgcg = true;

    public zzbvv(String str) {
        this.type = str;
    }

    private final synchronized void zzaqf() {
        if (!this.zzgch) {
            try {
                zzbwg zzbwgVar = zzco;
                String valueOf = String.valueOf(this.type);
                zzbwgVar.zzge(valueOf.length() != 0 ? "mem mapping ".concat(valueOf) : new String("mem mapping "));
                this.zzgci = this.zzgcl.zzk(this.zzgcj, this.zzgck);
                this.zzgch = true;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbc
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzbc
    public final void zza(zzbwa zzbwaVar, ByteBuffer byteBuffer, long j, zzaz zzazVar) throws IOException {
        this.zzgcj = zzbwaVar.position();
        this.zzapb = this.zzgcj - byteBuffer.remaining();
        this.zzgck = j;
        this.zzgcl = zzbwaVar;
        zzbwaVar.zzaw(zzbwaVar.position() + j);
        this.zzgch = false;
        this.zzgcg = false;
        zzaqg();
    }

    public final synchronized void zzaqg() {
        zzaqf();
        zzbwg zzbwgVar = zzco;
        String valueOf = String.valueOf(this.type);
        zzbwgVar.zzge(valueOf.length() != 0 ? "parsing details of ".concat(valueOf) : new String("parsing details of "));
        if (this.zzgci != null) {
            ByteBuffer byteBuffer = this.zzgci;
            this.zzgcg = true;
            byteBuffer.rewind();
            zzg(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zzgcm = byteBuffer.slice();
            }
            this.zzgci = null;
        }
    }

    protected abstract void zzg(ByteBuffer byteBuffer);

    @Override // com.google.android.gms.internal.ads.zzbc
    public final void zza(zzbd zzbdVar) {
        this.zzgcf = zzbdVar;
    }
}
