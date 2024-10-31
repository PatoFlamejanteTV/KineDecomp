package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;

@zzgr
/* loaded from: classes.dex */
public final class zzic {
    private static final ExecutorService zzIr = Executors.newFixedThreadPool(10, zzay("Default"));
    private static final ExecutorService zzIs = Executors.newFixedThreadPool(5, zzay("Loader"));

    public static zziq<Void> zza(int i, Runnable runnable) {
        return i == 1 ? zza(zzIs, new dp(runnable)) : zza(zzIr, new dq(runnable));
    }

    public static zziq<Void> zza(Runnable runnable) {
        return zza(0, runnable);
    }

    public static <T> zziq<T> zza(Callable<T> callable) {
        return zza(zzIr, callable);
    }

    public static <T> zziq<T> zza(ExecutorService executorService, Callable<T> callable) {
        zzin zzinVar = new zzin();
        try {
            zzinVar.zzd(new ds(zzinVar, executorService.submit(new dr(zzinVar, callable))));
        } catch (RejectedExecutionException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Thread execution is rejected.", e);
            zzinVar.cancel(true);
        }
        return zzinVar;
    }

    private static ThreadFactory zzay(String str) {
        return new dt(str);
    }
}
