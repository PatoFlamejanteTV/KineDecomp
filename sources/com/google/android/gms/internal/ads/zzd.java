package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public final class zzd extends Thread {
    private static final boolean DEBUG = zzaf.DEBUG;
    private final BlockingQueue<zzr<?>> zzh;
    private final BlockingQueue<zzr<?>> zzi;
    private final zzb zzj;
    private final zzaa zzk;
    private volatile boolean zzl = false;
    private final Tj zzm = new Tj(this);

    public zzd(BlockingQueue<zzr<?>> blockingQueue, BlockingQueue<zzr<?>> blockingQueue2, zzb zzbVar, zzaa zzaaVar) {
        this.zzh = blockingQueue;
        this.zzi = blockingQueue2;
        this.zzj = zzbVar;
        this.zzk = zzaaVar;
    }

    private final void processRequest() throws InterruptedException {
        boolean b2;
        boolean b3;
        boolean b4;
        zzr<?> take = this.zzh.take();
        take.zzb("cache-queue-take");
        take.isCanceled();
        zzc zza = this.zzj.zza(take.zzf());
        if (zza == null) {
            take.zzb("cache-miss");
            b4 = this.zzm.b(take);
            if (b4) {
                return;
            }
            this.zzi.put(take);
            return;
        }
        if (zza.zzb()) {
            take.zzb("cache-hit-expired");
            take.zza(zza);
            b3 = this.zzm.b(take);
            if (b3) {
                return;
            }
            this.zzi.put(take);
            return;
        }
        take.zzb("cache-hit");
        zzx<?> zza2 = take.zza(new zzp(zza.data, zza.zzf));
        take.zzb("cache-hit-parsed");
        if (zza.zze < System.currentTimeMillis()) {
            take.zzb("cache-hit-refresh-needed");
            take.zza(zza);
            zza2.zzbi = true;
            b2 = this.zzm.b(take);
            if (!b2) {
                this.zzk.zza(take, zza2, new Rj(this, take));
                return;
            }
        }
        this.zzk.zzb(take, zza2);
    }

    public final void quit() {
        this.zzl = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (DEBUG) {
            zzaf.v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzj.zza();
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zzl) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaf.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
