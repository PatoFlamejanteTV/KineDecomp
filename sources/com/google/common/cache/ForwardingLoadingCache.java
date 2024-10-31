package com.google.common.cache;

import com.google.common.annotations.Beta;

@Beta
/* loaded from: classes2.dex */
public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {

    @Beta
    /* loaded from: classes2.dex */
    public static abstract class SimpleForwardingLoadingCache<K, V> extends ForwardingLoadingCache<K, V> {
    }

    protected ForwardingLoadingCache() {
    }
}
