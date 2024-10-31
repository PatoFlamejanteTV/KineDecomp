package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    private RemovalNotification(@Nullable K k, @Nullable V v, RemovalCause removalCause) {
        super(k, v);
        Preconditions.a(removalCause);
        this.cause = removalCause;
    }

    public static <K, V> RemovalNotification<K, V> create(@Nullable K k, @Nullable V v, RemovalCause removalCause) {
        return new RemovalNotification<>(k, v, removalCause);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}