package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Collection;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final RegularImmutableMultiset<Object> EMPTY = new RegularImmutableMultiset<>(ImmutableList.of());

    /* renamed from: c, reason: collision with root package name */
    private final transient Multisets.ImmutableEntry<E>[] f15652c;

    /* renamed from: d, reason: collision with root package name */
    private final transient Multisets.ImmutableEntry<E>[] f15653d;

    /* renamed from: e, reason: collision with root package name */
    private final transient int f15654e;

    /* renamed from: f, reason: collision with root package name */
    private final transient int f15655f;

    /* renamed from: g, reason: collision with root package name */
    @LazyInit
    private transient ImmutableSet<E> f15656g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class ElementSet extends ImmutableSet.Indexed<E> {
        private ElementSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        @Override // com.google.common.collect.ImmutableSet.Indexed
        E get(int i) {
            return (E) RegularImmutableMultiset.this.f15652c[i].getElement();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableMultiset.this.f15652c.length;
        }
    }

    /* loaded from: classes2.dex */
    private static final class NonTerminalEntry<E> extends Multisets.ImmutableEntry<E> {
        private final Multisets.ImmutableEntry<E> nextInBucket;

        NonTerminalEntry(E e2, int i, Multisets.ImmutableEntry<E> immutableEntry) {
            super(e2, i);
            this.nextInBucket = immutableEntry;
        }

        @Override // com.google.common.collect.Multisets.ImmutableEntry
        public Multisets.ImmutableEntry<E> nextInBucket() {
            return this.nextInBucket;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableMultiset(Collection<? extends Multiset.Entry<? extends E>> collection) {
        Multisets.ImmutableEntry<E> nonTerminalEntry;
        int size = collection.size();
        Multisets.ImmutableEntry<E>[] immutableEntryArr = new Multisets.ImmutableEntry[size];
        if (size == 0) {
            this.f15652c = immutableEntryArr;
            this.f15653d = null;
            this.f15654e = 0;
            this.f15655f = 0;
            this.f15656g = ImmutableSet.of();
            return;
        }
        int a2 = Q.a(size, 1.0d);
        int i = a2 - 1;
        Multisets.ImmutableEntry<E>[] immutableEntryArr2 = new Multisets.ImmutableEntry[a2];
        long j = 0;
        int i2 = 0;
        int i3 = 0;
        for (Multiset.Entry<? extends E> entry : collection) {
            E element = entry.getElement();
            Preconditions.a(element);
            int count = entry.getCount();
            int hashCode = element.hashCode();
            int a3 = Q.a(hashCode) & i;
            Multisets.ImmutableEntry<E> immutableEntry = immutableEntryArr2[a3];
            if (immutableEntry == null) {
                nonTerminalEntry = (entry instanceof Multisets.ImmutableEntry) && !(entry instanceof NonTerminalEntry) ? (Multisets.ImmutableEntry) entry : new Multisets.ImmutableEntry<>(element, count);
            } else {
                nonTerminalEntry = new NonTerminalEntry<>(element, count, immutableEntry);
            }
            i2 += hashCode ^ count;
            immutableEntryArr[i3] = nonTerminalEntry;
            immutableEntryArr2[a3] = nonTerminalEntry;
            j += count;
            i3++;
        }
        this.f15652c = immutableEntryArr;
        this.f15653d = immutableEntryArr2;
        this.f15654e = Ints.b(j);
        this.f15655f = i2;
    }

    @Override // com.google.common.collect.Multiset
    public int count(@Nullable Object obj) {
        Multisets.ImmutableEntry<E>[] immutableEntryArr = this.f15653d;
        if (obj != null && immutableEntryArr != null) {
            for (Multisets.ImmutableEntry<E> immutableEntry = immutableEntryArr[Q.a(obj) & (immutableEntryArr.length - 1)]; immutableEntry != null; immutableEntry = immutableEntry.nextInBucket()) {
                if (Objects.a(obj, immutableEntry.getElement())) {
                    return immutableEntry.getCount();
                }
            }
        }
        return 0;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    Multiset.Entry<E> getEntry(int i) {
        return this.f15652c[i];
    }

    @Override // com.google.common.collect.ImmutableMultiset, java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return this.f15655f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f15654e;
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.f15656g;
        if (immutableSet != null) {
            return immutableSet;
        }
        ElementSet elementSet = new ElementSet();
        this.f15656g = elementSet;
        return elementSet;
    }
}
