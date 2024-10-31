package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* loaded from: classes2.dex */
public class zzco {
    private static final ConditionVariable zzqp = new ConditionVariable();
    protected static volatile zzur zzqq = null;
    private static volatile Random zzqs = null;
    private zzdl zzqo;
    protected volatile Boolean zzqr;

    public zzco(zzdl zzdlVar) {
        this.zzqo = zzdlVar;
        zzdlVar.zzac().execute(new Bj(this));
    }

    public static int zzy() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ThreadLocalRandom.current().nextInt();
            }
            return zzz().nextInt();
        } catch (RuntimeException unused) {
            return zzz().nextInt();
        }
    }

    private static Random zzz() {
        if (zzqs == null) {
            synchronized (zzco.class) {
                if (zzqs == null) {
                    zzqs = new Random();
                }
            }
        }
        return zzqs;
    }

    public final void zza(int i, int i2, long j) throws IOException {
        try {
            zzqp.block();
            if (!this.zzqr.booleanValue() || zzqq == null) {
                return;
            }
            zzbh zzbhVar = new zzbh();
            zzbhVar.zzdh = this.zzqo.zzsp.getPackageName();
            zzbhVar.zzdi = Long.valueOf(j);
            zzuv zzg = zzqq.zzg(zzbuz.zzb(zzbhVar));
            zzg.zzby(i2);
            zzg.zzbz(i);
            zzg.zzbd();
        } catch (Exception unused) {
        }
    }
}
