package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public final class zzn extends Thread {
    private final zzm zzaa;
    private final zzb zzj;
    private final zzaa zzk;
    private volatile boolean zzl = false;
    private final BlockingQueue<zzr<?>> zzz;

    public zzn(BlockingQueue<zzr<?>> blockingQueue, zzm zzmVar, zzb zzbVar, zzaa zzaaVar) {
        this.zzz = blockingQueue;
        this.zzaa = zzmVar;
        this.zzj = zzbVar;
        this.zzk = zzaaVar;
    }

    private final void processRequest() throws InterruptedException {
        zzr<?> take = this.zzz.take();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            take.zzb("network-queue-take");
            take.isCanceled();
            TrafficStats.setThreadStatsTag(take.zze());
            zzp zzc = this.zzaa.zzc(take);
            take.zzb("network-http-complete");
            if (zzc.zzac && take.zzm()) {
                take.zzc("not-modified");
                take.zzn();
                return;
            }
            zzx<?> zza = take.zza(zzc);
            take.zzb("network-parse-complete");
            if (take.zzi() && zza.zzbg != null) {
                this.zzj.zza(take.zzf(), zza.zzbg);
                take.zzb("network-cache-written");
            }
            take.zzl();
            this.zzk.zzb(take, zza);
            take.zza(zza);
        } catch (zzae e2) {
            e2.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzk.zza(take, e2);
            take.zzn();
        } catch (Exception e3) {
            zzaf.zza(e3, "Unhandled exception %s", e3.toString());
            zzae zzaeVar = new zzae(e3);
            zzaeVar.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzk.zza(take, zzaeVar);
            take.zzn();
        }
    }

    public final void quit() {
        this.zzl = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zzl) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaf.e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
