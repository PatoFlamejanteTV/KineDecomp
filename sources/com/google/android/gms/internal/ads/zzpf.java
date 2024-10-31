package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class zzpf implements zzpk {
    private IOException zzbci;
    private final ExecutorService zzbgv;
    private Pl<? extends zzpi> zzbgw;

    public zzpf(String str) {
        this.zzbgv = zzqe.zzah(str);
    }

    public final boolean isLoading() {
        return this.zzbgw != null;
    }

    public final <T extends zzpi> long zza(T t, zzpg<T> zzpgVar, int i) {
        Looper myLooper = Looper.myLooper();
        zzpo.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new Pl(this, myLooper, t, zzpgVar, i, elapsedRealtime).a(0L);
        return elapsedRealtime;
    }

    public final void zzbi(int i) throws IOException {
        IOException iOException = this.zzbci;
        if (iOException == null) {
            Pl<? extends zzpi> pl = this.zzbgw;
            if (pl != null) {
                pl.a(pl.f11773c);
                return;
            }
            return;
        }
        throw iOException;
    }

    @Override // com.google.android.gms.internal.ads.zzpk
    public final void zzev() throws IOException {
        IOException iOException = this.zzbci;
        if (iOException == null) {
            Pl<? extends zzpi> pl = this.zzbgw;
            if (pl != null) {
                pl.a(pl.f11773c);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void zzgy() {
        this.zzbgw.a(false);
    }

    public final void zza(Runnable runnable) {
        Pl<? extends zzpi> pl = this.zzbgw;
        if (pl != null) {
            pl.a(true);
        }
        if (runnable != null) {
            this.zzbgv.execute(runnable);
        }
        this.zzbgv.shutdown();
    }
}
