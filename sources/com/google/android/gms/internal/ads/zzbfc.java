package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

@zzark
/* loaded from: classes2.dex */
public final class zzbfc {
    private long zzcs;

    public final long zzl(ByteBuffer byteBuffer) {
        zzbf zzbfVar;
        zzbe zzbeVar;
        long j = this.zzcs;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.flip();
            Iterator<zzbc> it = new zzba(new C0998mf(duplicate), C1012nf.f12354a).zzaqh().iterator();
            while (true) {
                zzbfVar = null;
                if (!it.hasNext()) {
                    zzbeVar = null;
                    break;
                }
                zzbc next = it.next();
                if (next instanceof zzbe) {
                    zzbeVar = (zzbe) next;
                    break;
                }
            }
            Iterator<zzbc> it2 = zzbeVar.zzaqh().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzbc next2 = it2.next();
                if (next2 instanceof zzbf) {
                    zzbfVar = (zzbf) next2;
                    break;
                }
            }
            this.zzcs = (zzbfVar.getDuration() * 1000) / zzbfVar.zzs();
            return this.zzcs;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
