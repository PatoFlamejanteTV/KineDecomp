package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.Map;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    abstract ImmutableMap<K, V> map();

    @Override // java.util.Collection
    public int size() {
        return map().size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<V> iterator() {
        return Maps.a((UnmodifiableIterator) map().entrySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return map().containsValue(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    /* renamed from: com.google.common.collect.ImmutableMapValues$1 */
    /* loaded from: classes2.dex */
    class AnonymousClass1 extends ImmutableAsList<V> {
        final /* synthetic */ ImmutableList val$entryList;

        AnonymousClass1(ImmutableList immutableList) {
            r2 = immutableList;
        }

        @Override // java.util.List
        public V get(int i) {
            return (V) ((Map.Entry) r2.get(i)).getValue();
        }

        @Override // com.google.common.collect.ImmutableAsList
        ImmutableCollection<V> delegateCollection() {
            return ImmutableMapValues.this;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    ImmutableList<V> createAsList() {
        return new ImmutableAsList<V>() { // from class: com.google.common.collect.ImmutableMapValues.1
            final /* synthetic */ ImmutableList val$entryList;

            AnonymousClass1(ImmutableList immutableList) {
                r2 = immutableList;
            }

            @Override // java.util.List
            public V get(int i) {
                return (V) ((Map.Entry) r2.get(i)).getValue();
            }

            @Override // com.google.common.collect.ImmutableAsList
            ImmutableCollection<V> delegateCollection() {
                return ImmutableMapValues.this;
            }
        };
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    Object writeReplace() {
        return new SerializedForm(map());
    }

    @GwtIncompatible
    /* loaded from: classes2.dex */
    private static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<?, V> map;

        SerializedForm(ImmutableMap<?, V> immutableMap) {
            this.map = immutableMap;
        }

        Object readResolve() {
            return this.map.values();
        }
    }
}
