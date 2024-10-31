package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.lang.Exception;

@Beta
/* loaded from: classes2.dex */
public abstract class ForwardingCheckedFuture<V, X extends Exception> extends ForwardingListenableFuture<V> implements CheckedFuture<V, X> {

    @Beta
    /* loaded from: classes2.dex */
    public static abstract class SimpleForwardingCheckedFuture<V, X extends Exception> extends ForwardingCheckedFuture<V, X> {
    }
}
