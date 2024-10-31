package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    private final transient a<K, V>[] f2753a;
    private final transient a<K, V>[] b;
    private final transient int c;
    private final transient int d;

    /* loaded from: classes.dex */
    public interface a<K, V> extends Map.Entry<K, V> {
        @Nullable
        a<K, V> next();
    }

    public RegularImmutableMap(Map.Entry<?, ?>... entryArr) {
        int length = entryArr.length;
        this.f2753a = b(length);
        int a2 = a(length);
        this.b = b(a2);
        this.c = a2 - 1;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Map.Entry<?, ?> entry = entryArr[i];
            Object key = entry.getKey();
            int hashCode = key.hashCode();
            int i3 = i2 + hashCode;
            int a3 = this.c & ab.a(hashCode);
            a<K, V> aVar = this.b[a3];
            a<K, V> a4 = a(key, entry.getValue(), aVar);
            this.b[a3] = a4;
            this.f2753a[i] = a4;
            for (a<K, V> aVar2 = aVar; aVar2 != null; aVar2 = aVar2.next()) {
                Preconditions.a(!key.equals(aVar2.getKey()), "duplicate key: %s", key);
            }
            i++;
            i2 = i3;
        }
        this.d = i2;
    }

    private static int a(int i) {
        int highestOneBit = Integer.highestOneBit(i);
        if (i / highestOneBit > 1.2d) {
            int i2 = highestOneBit << 1;
            Preconditions.a(i2 > 0, "table too large: %s", Integer.valueOf(i));
            return i2;
        }
        return highestOneBit;
    }

    private a<K, V>[] b(int i) {
        return new a[i];
    }

    private static <K, V> a<K, V> a(K k, V v, @Nullable a<K, V> aVar) {
        return aVar == null ? new TerminalEntry(k, v) : new NonTerminalEntry(k, v, aVar);
    }

    @Immutable
    /* loaded from: classes2.dex */
    public static final class NonTerminalEntry<K, V> extends ImmutableEntry<K, V> implements a<K, V> {
        final a<K, V> next;

        NonTerminalEntry(K k, V v, a<K, V> aVar) {
            super(k, v);
            this.next = aVar;
        }

        @Override // com.google.common.collect.RegularImmutableMap.a
        public a<K, V> next() {
            return this.next;
        }
    }

    @Immutable
    /* loaded from: classes.dex */
    public static final class TerminalEntry<K, V> extends ImmutableEntry<K, V> implements a<K, V> {
        TerminalEntry(K k, V v) {
            super(k, v);
        }

        @Override // com.google.common.collect.RegularImmutableMap.a
        @Nullable
        public a<K, V> next() {
            return null;
        }
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        for (a<K, V> aVar = this.b[ab.a(obj.hashCode()) & this.c]; aVar != null; aVar = aVar.next()) {
            if (obj.equals(aVar.getKey())) {
                return aVar.getValue();
            }
        }
        return null;
    }

    @Override // java.util.Map
    public int size() {
        return this.f2753a.length;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        for (a<K, V> aVar : this.f2753a) {
            if (aVar.getValue().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet();
    }

    /* loaded from: classes2.dex */
    private class EntrySet extends ImmutableMapEntrySet<K, V> {
        private EntrySet() {
        }

        /* synthetic */ EntrySet(RegularImmutableMap regularImmutableMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.ImmutableMapEntrySet
        ImmutableMap<K, V> map() {
            return RegularImmutableMap.this;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        @Override // com.google.common.collect.ImmutableCollection
        ImmutableList<Map.Entry<K, V>> createAsList() {
            return new RegularImmutableAsList(this, RegularImmutableMap.this.f2753a);
        }
    }

    /* renamed from: com.google.common.collect.RegularImmutableMap$1 */
    /* loaded from: classes2.dex */
    class AnonymousClass1 extends ImmutableMapKeySet<K, V> {
        AnonymousClass1(ImmutableSet immutableSet, int i) {
            super(immutableSet, i);
        }

        @Override // com.google.common.collect.ImmutableMapKeySet
        ImmutableMap<K, V> map() {
            return RegularImmutableMap.this;
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet<K, V>(entrySet(), this.d) { // from class: com.google.common.collect.RegularImmutableMap.1
            AnonymousClass1(ImmutableSet immutableSet, int i) {
                super(immutableSet, i);
            }

            @Override // com.google.common.collect.ImmutableMapKeySet
            ImmutableMap<K, V> map() {
                return RegularImmutableMap.this;
            }
        };
    }

    @Override // com.google.common.collect.ImmutableMap
    public String toString() {
        StringBuilder append = Collections2.a(size()).append('{');
        Collections2.f2661a.a(append, this.f2753a);
        return append.append('}').toString();
    }
}
