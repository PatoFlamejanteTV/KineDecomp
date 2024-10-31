package com.google.android.gms.internal.ads;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.appevents.AppEventsConstants;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@zzark
/* loaded from: classes2.dex */
public final class zzayf {
    public static final zzbcf zzeky = zzbcg.zza(new ThreadPoolExecutor(2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 10, TimeUnit.SECONDS, new SynchronousQueue(), zzdw("Default")));
    public static final zzbcf zzekz;
    public static final ScheduledExecutorService zzela;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzdw("Loader"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        zzekz = zzbcg.zza(threadPoolExecutor);
        zzela = new ScheduledThreadPoolExecutor(3, zzdw(AppEventsConstants.EVENT_NAME_SCHEDULE));
    }

    public static <T> zzbcb<T> zza(Callable<T> callable) {
        return zzeky.submit(callable);
    }

    public static zzbcb<?> zzc(Runnable runnable) {
        return zzeky.submit(runnable);
    }

    private static ThreadFactory zzdw(String str) {
        return new ThreadFactoryC1149xd(str);
    }
}
