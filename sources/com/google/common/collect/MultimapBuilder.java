package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class MultimapBuilder<K0, V0> {

    /* loaded from: classes2.dex */
    public static final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        public ArrayListSupplier(int i) {
            C1555x.a(i, "expectedValuesPerKey");
            this.expectedValuesPerKey = i;
        }

        @Override // com.google.common.base.Supplier
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    /* loaded from: classes2.dex */
    public static final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        public LinkedHashSetSupplier(int i) {
            C1555x.a(i, "expectedValuesPerKey");
            this.expectedValuesPerKey = i;
        }

        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return Sets.b(this.expectedValuesPerKey);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public ListMultimapBuilder() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> ListMultimap<K, V> b();
    }

    /* loaded from: classes2.dex */
    public static abstract class MultimapBuilderWithKeys<K0> {
        public ListMultimapBuilder<K0, Object> a() {
            return a(2);
        }

        public SetMultimapBuilder<K0, Object> b(int i) {
            C1555x.a(i, "expectedValuesPerKey");
            return new Va(this, i);
        }

        public abstract <K extends K0, V> Map<K, Collection<V>> b();

        public SetMultimapBuilder<K0, Object> c() {
            return b(2);
        }

        public ListMultimapBuilder<K0, Object> a(int i) {
            C1555x.a(i, "expectedValuesPerKey");
            return new Ua(this, i);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public SetMultimapBuilder() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> SetMultimap<K, V> b();
    }

    /* loaded from: classes2.dex */
    public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
        SortedSetMultimapBuilder() {
        }

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder
        public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> b();
    }

    /* synthetic */ MultimapBuilder(Sa sa) {
        this();
    }

    public static MultimapBuilderWithKeys<Object> a() {
        return a(8);
    }

    private MultimapBuilder() {
    }

    public static MultimapBuilderWithKeys<Object> a(int i) {
        C1555x.a(i, "expectedKeys");
        return new Ta(i);
    }
}
