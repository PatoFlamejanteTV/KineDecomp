package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProtobufArrayList.java */
/* loaded from: classes2.dex */
public final class O<E> extends AbstractC1647a<E> {

    /* renamed from: b */
    private static final O<Object> f18666b = new O<>();

    /* renamed from: c */
    private final List<E> f18667c;

    static {
        f18666b.L();
    }

    O() {
        this(new ArrayList(10));
    }

    public static <E> O<E> b() {
        return (O<E>) f18666b;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e2) {
        a();
        this.f18667c.add(i, e2);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        return this.f18667c.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        a();
        E remove = this.f18667c.remove(i);
        ((AbstractList) this).modCount++;
        return remove;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e2) {
        a();
        E e3 = this.f18667c.set(i, e2);
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f18667c.size();
    }

    private O(List<E> list) {
        this.f18667c = list;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.IntList
    /* renamed from: h */
    public O<E> h2(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f18667c);
            return new O<>(arrayList);
        }
        throw new IllegalArgumentException();
    }
}
