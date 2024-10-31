package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: TreeMultiset.java */
/* loaded from: classes2.dex */
class Hb<E> implements Iterator<Multiset.Entry<E>> {

    /* renamed from: a, reason: collision with root package name */
    TreeMultiset.a<E> f15411a;

    /* renamed from: b, reason: collision with root package name */
    Multiset.Entry<E> f15412b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ TreeMultiset f15413c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hb(TreeMultiset treeMultiset) {
        TreeMultiset.a<E> b2;
        this.f15413c = treeMultiset;
        b2 = this.f15413c.b();
        this.f15411a = b2;
        this.f15412b = null;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        GeneralRange generalRange;
        if (this.f15411a == null) {
            return false;
        }
        generalRange = this.f15413c.f15709e;
        if (!generalRange.tooLow(this.f15411a.getElement())) {
            return true;
        }
        this.f15411a = null;
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        C1555x.a(this.f15412b != null);
        this.f15413c.setCount(this.f15412b.getElement(), 0);
        this.f15412b = null;
    }

    @Override // java.util.Iterator
    public Multiset.Entry<E> next() {
        Multiset.Entry<E> a2;
        TreeMultiset.a aVar;
        if (hasNext()) {
            a2 = this.f15413c.a(this.f15411a);
            this.f15412b = a2;
            TreeMultiset.a aVar2 = ((TreeMultiset.a) this.f15411a).f15718h;
            aVar = this.f15413c.f15710f;
            if (aVar2 != aVar) {
                this.f15411a = ((TreeMultiset.a) this.f15411a).f15718h;
            } else {
                this.f15411a = null;
            }
            return a2;
        }
        throw new NoSuchElementException();
    }
}
