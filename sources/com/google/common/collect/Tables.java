package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Table;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Tables {

    /* renamed from: a, reason: collision with root package name */
    private static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> f2780a = new di();

    private Tables() {
    }

    public static <R, C, V> Table.Cell<R, C, V> a(@Nullable R r, @Nullable C c, @Nullable V v) {
        return new ImmutableCell(r, c, v);
    }

    /* loaded from: classes2.dex */
    static final class ImmutableCell<R, C, V> extends a<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final C columnKey;
        private final R rowKey;
        private final V value;

        ImmutableCell(@Nullable R r, @Nullable C c, @Nullable V v) {
            this.rowKey = r;
            this.columnKey = c;
            this.value = v;
        }

        @Override // com.google.common.collect.Table.Cell
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // com.google.common.collect.Table.Cell
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // com.google.common.collect.Table.Cell
        public V getValue() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    static abstract class a<R, C, V> implements Table.Cell<R, C, V> {
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            return Objects.a(getRowKey(), cell.getRowKey()) && Objects.a(getColumnKey(), cell.getColumnKey()) && Objects.a(getValue(), cell.getValue());
        }

        public int hashCode() {
            return Objects.a(getRowKey(), getColumnKey(), getValue());
        }

        public String toString() {
            return "(" + getRowKey() + "," + getColumnKey() + ")=" + getValue();
        }
    }
}
