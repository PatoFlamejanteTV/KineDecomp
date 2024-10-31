package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzkt {
    private final Handler handler;
    private final zzks zzavv;
    private final long zzavw;

    public zzkt(Handler handler, zzks zzksVar) {
        this(handler, zzksVar, 0L);
    }

    public final long zzx(long j) {
        long zzf = zzfe.zzf(j);
        if (zzf == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.zzavw + zzf;
    }

    public final void zza(zzoz zzozVar, int i, long j) {
        zzb(zzozVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j);
    }

    public final void zzb(zzoz zzozVar, int i, int i2, zzfs zzfsVar, int i3, Object obj, long j, long j2, long j3) {
        if (this.zzavv != null) {
            this.handler.post(new RunnableC0962jl(this, zzozVar, i, i2, zzfsVar, i3, obj, j, j2, j3));
        }
    }

    public final void zzc(zzoz zzozVar, int i, int i2, zzfs zzfsVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        if (this.zzavv != null) {
            this.handler.post(new RunnableC0976kl(this, zzozVar, i, i2, zzfsVar, i3, obj, j, j2, j3, j4, j5));
        }
    }

    public final void zzd(zzoz zzozVar, int i, int i2, zzfs zzfsVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        if (this.zzavv != null) {
            this.handler.post(new RunnableC0990ll(this, zzozVar, i, i2, zzfsVar, i3, obj, j, j2, j3, j4, j5));
        }
    }

    public final zzkt zzw(long j) {
        return new zzkt(this.handler, this.zzavv, j);
    }

    private zzkt(Handler handler, zzks zzksVar, long j) {
        Handler handler2;
        if (zzksVar != null) {
            zzpo.checkNotNull(handler);
            handler2 = handler;
        } else {
            handler2 = null;
        }
        this.handler = handler2;
        this.zzavv = zzksVar;
        this.zzavw = j;
    }

    public final void zza(zzoz zzozVar, int i, long j, long j2, long j3) {
        zzc(zzozVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
    }

    public final void zza(zzoz zzozVar, int i, long j, long j2, long j3, IOException iOException, boolean z) {
        zzb(zzozVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
    }

    public final void zzb(zzoz zzozVar, int i, long j, long j2, long j3) {
        zzd(zzozVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
    }

    public final void zzb(zzoz zzozVar, int i, int i2, zzfs zzfsVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
        if (this.zzavv != null) {
            this.handler.post(new RunnableC1004ml(this, zzozVar, i, i2, zzfsVar, i3, obj, j, j2, j3, j4, j5, iOException, z));
        }
    }

    public final void zzb(int i, zzfs zzfsVar, int i2, Object obj, long j) {
        if (this.zzavv != null) {
            this.handler.post(new RunnableC1018nl(this, i, zzfsVar, i2, obj, j));
        }
    }
}
