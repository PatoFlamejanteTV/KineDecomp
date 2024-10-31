package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;

@GwtCompatible
/* loaded from: classes2.dex */
public final class EnumMultiset<E extends Enum<E>> extends AbstractMapBasedMultiset<E> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private transient Class<E> f2677a;

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

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        Preconditions.a(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(it.next().getDeclaringClass());
        Iterables.a((Collection) enumMultiset, (Iterable) iterable);
        return enumMultiset;
    }

    private EnumMultiset(Class<E> cls) {
        super(dr.a(new EnumMap(cls)));
        this.f2677a = cls;
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f2677a);
        cs.a(this, objectOutputStream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f2677a = (Class) objectInputStream.readObject();
        setBackingMap(dr.a(new EnumMap(this.f2677a)));
        cs.a(this, objectInputStream);
    }
}
