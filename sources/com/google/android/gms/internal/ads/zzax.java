package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class zzax implements zzaz {
    private static Logger zzcm = Logger.getLogger(zzax.class.getName());
    private ThreadLocal<ByteBuffer> zzcn = new C1107ud(this);

    @Override // com.google.android.gms.internal.ads.zzaz
    public final zzbc zza(zzbwa zzbwaVar, zzbd zzbdVar) throws IOException {
        int read;
        long size;
        long position = zzbwaVar.position();
        this.zzcn.get().rewind().limit(8);
        do {
            read = zzbwaVar.read(this.zzcn.get());
            if (read == 8) {
                this.zzcn.get().rewind();
                long zza = zzbb.zza(this.zzcn.get());
                byte[] bArr = null;
                if (zza < 8 && zza > 1) {
                    Logger logger = zzcm;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(zza);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                String zzf = zzbb.zzf(this.zzcn.get());
                if (zza == 1) {
                    this.zzcn.get().limit(16);
                    zzbwaVar.read(this.zzcn.get());
                    this.zzcn.get().position(8);
                    size = zzbb.zzc(this.zzcn.get()) - 16;
                } else {
                    size = zza == 0 ? zzbwaVar.size() - zzbwaVar.position() : zza - 8;
                }
                if ("uuid".equals(zzf)) {
                    this.zzcn.get().limit(this.zzcn.get().limit() + 16);
                    zzbwaVar.read(this.zzcn.get());
                    bArr = new byte[16];
                    for (int position2 = this.zzcn.get().position() - 16; position2 < this.zzcn.get().position(); position2++) {
                        bArr[position2 - (this.zzcn.get().position() - 16)] = this.zzcn.get().get(position2);
                    }
                    size -= 16;
                }
                long j = size;
                zzbc zza2 = zza(zzf, bArr, zzbdVar instanceof zzbc ? ((zzbc) zzbdVar).getType() : "");
                zza2.zza(zzbdVar);
                this.zzcn.get().rewind();
                zza2.zza(zzbwaVar, this.zzcn.get(), j, this);
                return zza2;
            }
        } while (read >= 0);
        zzbwaVar.zzaw(position);
        throw new EOFException();
    }

    public abstract zzbc zza(String str, byte[] bArr, String str2);
}
