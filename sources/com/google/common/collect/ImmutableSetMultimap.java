package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.cs;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private final transient ImmutableSortedSet<V> f2701a;
    private transient ImmutableSetMultimap<V, K> b;
    private transient ImmutableSet<Map.Entry<K, V>> c;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ ImmutableCollection get(Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v) {
        Builder builder = builder();
        builder.b(k, v);
        return builder.b();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2) {
        Builder builder = builder();
        builder.b(k, v);
        builder.b(k2, v2);
        return builder.b();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        Builder builder = builder();
        builder.b(k, v);
        builder.b(k2, v2);
        builder.b(k3, v3);
        return builder.b();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Builder builder = builder();
        builder.b(k, v);
        builder.b(k2, v2);
        builder.b(k3, v3);
        builder.b(k4, v4);
        return builder.b();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Builder builder = builder();
        builder.b(k, v);
        builder.b(k2, v2);
        builder.b(k3, v3);
        builder.b(k4, v4);
        builder.b(k5, v5);
        return builder.b();
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class BuilderMultimap<K, V> extends AbstractMultimap<K, V> {
        private static final long serialVersionUID = 0;

        BuilderMultimap() {
            super(new LinkedHashMap());
        }

        @Override // com.google.common.collect.AbstractMultimap
        Collection<V> createCollection() {
            return Sets.b();
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        public Builder() {
            this.f2695a = new BuilderMultimap();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Builder<K, V> b(K k, V v) {
            this.f2695a.put(Preconditions.a(k), Preconditions.a(v));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImmutableSetMultimap<K, V> b() {
            if (this.b != null) {
                BuilderMultimap builderMultimap = new BuilderMultimap();
                ArrayList<Map.Entry> a2 = Lists.a(this.f2695a.asMap().entrySet());
                Collections.sort(a2, Ordering.from(this.b).onResultOf(new ah(this)));
                for (Map.Entry entry : a2) {
                    builderMultimap.putAll(entry.getKey(), (Iterable) entry.getValue());
                }
                this.f2695a = builderMultimap;
            }
            return ImmutableSetMultimap.a(this.f2695a, this.c);
        }
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        return a(multimap, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> ImmutableSetMultimap<K, V> a(Multimap<? extends K, ? extends V> multimap, Comparator<? super V> comparator) {
        Preconditions.a(multimap);
        if (multimap.isEmpty() && comparator == null) {
            return of();
        }
        if (multimap instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) multimap;
            if (!immutableSetMultimap.isPartialView()) {
                return immutableSetMultimap;
            }
        }
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int i = 0;
        Iterator<Map.Entry<? extends K, Collection<? extends V>>> it = multimap.asMap().entrySet().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                Map.Entry<? extends K, Collection<? extends V>> next = it.next();
                K key = next.getKey();
                Collection<? extends V> value = next.getValue();
                ImmutableSet copyOf = comparator == null ? ImmutableSet.copyOf((Collection) value) : ImmutableSortedSet.copyOf((Comparator) comparator, (Collection) value);
                if (copyOf.isEmpty()) {
                    i = i2;
                } else {
                    builder.b(key, copyOf);
                    i = copyOf.size() + i2;
                }
            } else {
                return new ImmutableSetMultimap<>(builder.b(), i2, comparator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i, @Nullable Comparator<? super V> comparator) {
        super(immutableMap, i);
        this.f2701a = comparator == null ? null : ImmutableSortedSet.emptySet(comparator);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public ImmutableSet<V> get(@Nullable K k) {
        ImmutableSet<V> immutableSet = (ImmutableSet) this.map.get(k);
        if (immutableSet == null) {
            if (this.f2701a != null) {
                return this.f2701a;
            }
            return ImmutableSet.of();
        }
        return immutableSet;
    }

    @Override // com.google.common.collect.ImmutableMultimap
    @Beta
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.b;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<V, K> a2 = a();
        this.b = a2;
        return a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> a() {
        Builder builder = builder();
        Iterator it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.b(entry.getValue(), entry.getKey());
        }
        ImmutableSetMultimap<V, K> b = builder.b();
        b.b = this;
        return b;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public ImmutableSet<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public ImmutableSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.c;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> copyOf = ImmutableSet.copyOf((Collection) super.entries());
        this.c = copyOf;
        return copyOf;
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        cs.a(this, objectOutputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Invalid key count " + readInt);
        }
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int i = 0;
        for (int i2 = 0; i2 < readInt; i2++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            if (readInt2 <= 0) {
                throw new InvalidObjectException("Invalid value count " + readInt2);
            }
            Object[] objArr = new Object[readInt2];
            for (int i3 = 0; i3 < readInt2; i3++) {
                objArr[i3] = objectInputStream.readObject();
            }
            ImmutableSet copyOf = ImmutableSet.copyOf(objArr);
            if (copyOf.size() != objArr.length) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + readObject);
            }
            builder.b(readObject, copyOf);
            i += readInt2;
        }
        try {
            ImmutableMultimap.a.f2696a.a((cs.a<ImmutableMultimap>) this, (Object) builder.b());
            ImmutableMultimap.a.b.a((cs.a<ImmutableMultimap>) this, i);
        } catch (IllegalArgumentException e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }
}
