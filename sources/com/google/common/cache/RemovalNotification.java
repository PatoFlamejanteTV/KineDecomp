package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes.dex */
public final class RemovalNotification<K, V> implements Map.Entry<K, V> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final K f2623a;

    @Nullable
    private final V b;
    private final RemovalCause c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemovalNotification(@Nullable K k, @Nullable V v, RemovalCause removalCause) {
        this.f2623a = k;
        this.b = v;
        this.c = (RemovalCause) Preconditions.a(removalCause);
    }

    @Override // java.util.Map.Entry
    @Nullable
    public K getKey() {
        return this.f2623a;
    }

    @Override // java.util.Map.Entry
    @Nullable
    public V getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map.Entry
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Objects.a(getKey(), entry.getKey()) && Objects.a(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        K key = getKey();
        V value = getValue();
        return (value != null ? value.hashCode() : 0) ^ (key == null ? 0 : key.hashCode());
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
