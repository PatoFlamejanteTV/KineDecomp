package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class zzbvx extends zzbvv implements zzbc {
    private int flags;
    private int version;

    public zzbvx(String str) {
        super(str);
    }

    public final int getVersion() {
        if (!this.zzgcg) {
            zzaqg();
        }
        return this.version;
    }

    public final long zzp(ByteBuffer byteBuffer) {
        this.version = zzbb.zza(byteBuffer.get());
        this.flags = (zzbb.zzb(byteBuffer) << 8) + 0 + zzbb.zza(byteBuffer.get());
        return 4L;
    }
}
