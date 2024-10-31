package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ImmutableTable<R, C, V> implements Table<R, C, V> {

    /* loaded from: classes2.dex */
    public static final class Builder<R, C, V> {

        /* renamed from: a, reason: collision with root package name */
        private final List<Table.Cell<R, C, V>> f2705a = Lists.a();
    }

    @Override // com.google.common.collect.Table
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableMap<R, V> column(C c);

    @Override // com.google.common.collect.Table
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableSet<Table.Cell<R, C, V>> cellSet();

    @Override // com.google.common.collect.Table
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableMap<C, V> row(R r);

    @Override // com.google.common.collect.Table
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableSet<C> columnKeySet();

    @Override // com.google.common.collect.Table
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.common.collect.Table
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableSet<R> rowKeySet();

    @Override // com.google.common.collect.Table
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    ImmutableTable() {
    }

    @Override // com.google.common.collect.Table
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public final V put(R r, C c, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public final void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public final V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Table) {
            return cellSet().equals(((Table) obj).cellSet());
        }
        return false;
    }

    public int hashCode() {
        return cellSet().hashCode();
    }

    public String toString() {
        return rowMap().toString();
    }
}
