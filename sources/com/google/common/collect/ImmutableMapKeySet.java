package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ImmutableMapKeySet<K, V> extends TransformedImmutableSet<Map.Entry<K, V>, K> {
    abstract ImmutableMap<K, V> map();

    public ImmutableMapKeySet(ImmutableSet<Map.Entry<K, V>> immutableSet) {
        super(immutableSet);
    }

    public ImmutableMapKeySet(ImmutableSet<Map.Entry<K, V>> immutableSet, int i) {
        super(immutableSet, i);
    }

    @Override // com.google.common.collect.TransformedImmutableSet
    public K transform(Map.Entry<K, V> entry) {
        return entry.getKey();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean contains(@Nullable Object obj) {
        return map().containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    /* renamed from: com.google.common.collect.ImmutableMapKeySet$1 */
    /* loaded from: classes2.dex */
    class AnonymousClass1 extends ImmutableAsList<K> {
        final /* synthetic */ ImmutableList val$entryList;

        AnonymousClass1(ImmutableList immutableList) {
            r2 = immutableList;
        }

        @Override // java.util.List
        public K get(int i) {
            return (K) ((Map.Entry) r2.get(i)).getKey();
        }

        @Override // com.google.common.collect.ImmutableAsList
        ImmutableCollection<K> delegateCollection() {
            return ImmutableMapKeySet.this;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    ImmutableList<K> createAsList() {
        return new ImmutableAsList<K>() { // from class: com.google.common.collect.ImmutableMapKeySet.1
            final /* synthetic */ ImmutableList val$entryList;

            AnonymousClass1(ImmutableList immutableList) {
                r2 = immutableList;
            }

            @Override // java.util.List
            public K get(int i) {
                return (K) ((Map.Entry) r2.get(i)).getKey();
            }

            @Override // com.google.common.collect.ImmutableAsList
            ImmutableCollection<K> delegateCollection() {
                return ImmutableMapKeySet.this;
            }
        };
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    Object writeReplace() {
        return new KeySetSerializedForm(map());
    }

    @GwtIncompatible
    /* loaded from: classes2.dex */
    private static class KeySetSerializedForm<K> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<K, ?> map;

        KeySetSerializedForm(ImmutableMap<K, ?> immutableMap) {
            this.map = immutableMap;
        }

        Object readResolve() {
            return this.map.keySet();
        }
    }
}
