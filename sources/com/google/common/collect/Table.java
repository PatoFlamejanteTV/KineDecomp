package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public interface Table<R, C, V> {

    /* loaded from: classes2.dex */
    public interface Cell<R, C, V> {
        @Nullable
        C getColumnKey();

        @Nullable
        R getRowKey();

        @Nullable
        V getValue();
    }

    Set<Cell<R, C, V>> cellSet();

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    boolean equals(@Nullable Object obj);

    int hashCode();

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();
}
