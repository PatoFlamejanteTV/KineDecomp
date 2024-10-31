package com.google.android.gms.common.providers;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

@KeepForSdk
/* loaded from: classes.dex */
public class PooledExecutorsProvider {

    /* renamed from: a */
    private static PooledExecutorFactory f11189a;

    /* loaded from: classes.dex */
    public interface PooledExecutorFactory {
        @KeepForSdk
        ScheduledExecutorService a();
    }

    private PooledExecutorsProvider() {
    }

    @KeepForSdk
    public static synchronized PooledExecutorFactory a() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (f11189a == null) {
                f11189a = new a();
            }
            pooledExecutorFactory = f11189a;
        }
        return pooledExecutorFactory;
    }
}
