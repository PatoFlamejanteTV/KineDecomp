package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.cs;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private transient ImmutableListMultimap<V, K> f2691a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ ImmutableCollection get(Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ List get(Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ List replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v) {
        Builder builder = builder();
        builder.b(k, v);
        return builder.b();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2) {
        Builder builder = builder();
        builder.b(k, v);
        builder.b(k2, v2);
        return builder.b();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        Builder builder = builder();
        builder.b(k, v);
        builder.b(k2, v2);
        builder.b(k3, v3);
        return builder.b();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Builder builder = builder();
        builder.b(k, v);
        builder.b(k2, v2);
        builder.b(k3, v3);
        builder.b(k4, v4);
        return builder.b();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
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

    /* loaded from: classes2.dex */
    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Builder<K, V> b(K k, V v) {
            super.b(k, v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImmutableListMultimap<K, V> b() {
            return (ImmutableListMultimap) super.b();
        }
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        if (multimap.isEmpty()) {
            return of();
        }
        if (multimap instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) multimap;
            if (!immutableListMultimap.isPartialView()) {
                return immutableListMultimap;
            }
        }
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int i = 0;
        Iterator<Map.Entry<? extends K, Collection<? extends V>>> it = multimap.asMap().entrySet().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                Map.Entry<? extends K, Collection<? extends V>> next = it.next();
                ImmutableList copyOf = ImmutableList.copyOf((Collection) next.getValue());
                if (copyOf.isEmpty()) {
                    i = i2;
                } else {
                    builder.b(next.getKey(), copyOf);
                    i = copyOf.size() + i2;
                }
            } else {
                return new ImmutableListMultimap<>(builder.b(), i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i) {
        super(immutableMap, i);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public ImmutableList<V> get(@Nullable K k) {
        ImmutableList<V> immutableList = (ImmutableList) this.map.get(k);
        return immutableList == null ? ImmutableList.of() : immutableList;
    }

    @Override // com.google.common.collect.ImmutableMultimap
    @Beta
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.f2691a;
        if (immutableListMultimap != null) {
            return immutableListMultimap;
        }
        ImmutableListMultimap<V, K> a2 = a();
        this.f2691a = a2;
        return a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> a() {
        Builder builder = builder();
        Iterator it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.b(entry.getValue(), entry.getKey());
        }
        ImmutableListMultimap<V, K> b = builder.b();
        b.f2691a = this;
        return b;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public ImmutableList<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public ImmutableList<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
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
            builder.b(readObject, ImmutableList.copyOf(objArr));
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
