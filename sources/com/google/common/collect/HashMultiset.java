package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@GwtCompatible
/* loaded from: classes2.dex */
public final class HashMultiset<E> extends AbstractMapBasedMultiset<E> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.l, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ int add(Object obj, int i) {
        return super.add(obj, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.l, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ int count(Object obj) {
        return super.count(obj);
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.l, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.l, java.util.Collection
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.l, java.util.Collection
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.l, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ int remove(Object obj, int i) {
        return super.remove(obj, i);
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.l, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ int setCount(Object obj, int i) {
        return super.setCount(obj, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean setCount(Object obj, int i, int i2) {
        return super.setCount(obj, i, i2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <E> HashMultiset<E> create() {
        return new HashMultiset<>();
    }

    public static <E> HashMultiset<E> create(int i) {
        return new HashMultiset<>(i);
    }

    public static <E> HashMultiset<E> create(Iterable<? extends E> iterable) {
        HashMultiset<E> create = create(Multisets.a(iterable));
        Iterables.a((Collection) create, (Iterable) iterable);
        return create;
    }

    private HashMultiset() {
        super(new HashMap());
    }

    private HashMultiset(int i) {
        super(Maps.a(i));
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        cs.a(this, objectOutputStream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int a2 = cs.a(objectInputStream);
        setBackingMap(Maps.a(a2));
        cs.a(this, objectInputStream, a2);
    }
}
