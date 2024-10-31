package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public interface zzbcf extends ExecutorService {
    /* renamed from: zza */
    <T> zzbcb<T> submit(Callable<T> callable);

    /* renamed from: zze */
    zzbcb<?> submit(Runnable runnable);
}
