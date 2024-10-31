package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public interface ListeningExecutorService extends ExecutorService {
    <T> ListenableFuture<T> a(Callable<T> callable);
}
