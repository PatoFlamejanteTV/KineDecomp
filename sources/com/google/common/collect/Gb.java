package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: TreeMultiset.java */
/* loaded from: classes2.dex */
class Gb<E> implements Iterator<Multiset.Entry<E>> {

    /* renamed from: a, reason: collision with root package name */
    TreeMultiset.a<E> f15389a;

    /* renamed from: b, reason: collision with root package name */
    Multiset.Entry<E> f15390b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ TreeMultiset f15391c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gb(TreeMultiset treeMultiset) {
        TreeMultiset.a<E> a2;
        this.f15391c = treeMultiset;
        a2 = this.f15391c.a();
        this.f15389a = a2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        GeneralRange generalRange;
        if (this.f15389a == null) {
            return false;
        }
        generalRange = this.f15391c.f15709e;
        if (!generalRange.tooHigh(this.f15389a.getElement())) {
            return true;
        }
        this.f15389a = null;
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        C1555x.a(this.f15390b != null);
        this.f15391c.setCount(this.f15390b.getElement(), 0);
        this.f15390b = null;
    }

    @Override // java.util.Iterator
    public Multiset.Entry<E> next() {
        Multiset.Entry<E> a2;
        TreeMultiset.a aVar;
        if (hasNext()) {
            a2 = this.f15391c.a(this.f15389a);
            this.f15390b = a2;
            TreeMultiset.a aVar2 = ((TreeMultiset.a) this.f15389a).i;
            aVar = this.f15391c.f15710f;
            if (aVar2 != aVar) {
                this.f15389a = ((TreeMultiset.a) this.f15389a).i;
            } else {
                this.f15389a = null;
            }
            return a2;
        }
        throw new NoSuchElementException();
    }
}
