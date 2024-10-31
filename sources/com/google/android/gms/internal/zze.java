package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class zze implements zzn {
    private final Executor zzs;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private final zzk b;
        private final zzm c;
        private final Runnable d;

        public a(zzk zzkVar, zzm zzmVar, Runnable runnable) {
            this.b = zzkVar;
            this.c = zzmVar;
            this.d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b.isCanceled()) {
                this.b.zzd("canceled-at-delivery");
                return;
            }
            if (this.c.isSuccess()) {
                this.b.zza((zzk) this.c.result);
            } else {
                this.b.zzc(this.c.zzah);
            }
            if (this.c.zzai) {
                this.b.zzc("intermediate-response");
            } else {
                this.b.zzd("done");
            }
            if (this.d != null) {
                this.d.run();
            }
        }
    }

    public zze(Handler handler) {
        this.zzs = new bq(this, handler);
    }

    @Override // com.google.android.gms.internal.zzn
    public void zza(zzk<?> zzkVar, zzm<?> zzmVar) {
        zza(zzkVar, zzmVar, null);
    }

    @Override // com.google.android.gms.internal.zzn
    public void zza(zzk<?> zzkVar, zzm<?> zzmVar, Runnable runnable) {
        zzkVar.zzv();
        zzkVar.zzc("post-response");
        this.zzs.execute(new a(zzkVar, zzmVar, runnable));
    }

    @Override // com.google.android.gms.internal.zzn
    public void zza(zzk<?> zzkVar, zzr zzrVar) {
        zzkVar.zzc("post-error");
        this.zzs.execute(new a(zzkVar, zzm.zzd(zzrVar), null));
    }
}
