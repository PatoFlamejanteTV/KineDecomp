package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: TreeMultiset.java */
/* loaded from: classes2.dex */
class dq<E> implements Iterator<Multiset.Entry<E>> {

    /* renamed from: a, reason: collision with root package name */
    TreeMultiset.a<E> f2869a;
    Multiset.Entry<E> b;
    final /* synthetic */ TreeMultiset c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(TreeMultiset treeMultiset) {
        TreeMultiset.a<E> b;
        this.c = treeMultiset;
        b = this.c.b();
        this.f2869a = b;
        this.b = null;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        GeneralRange generalRange;
        if (this.f2869a == null) {
            return false;
        }
        generalRange = this.c.b;
        if (generalRange.tooLow(this.f2869a.getElement())) {
            this.f2869a = null;
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Multiset.Entry<E> next() {
        Multiset.Entry<E> a2;
        TreeMultiset.a aVar;
        if (hasNext()) {
            a2 = this.c.a(this.f2869a);
            this.b = a2;
            TreeMultiset.a aVar2 = ((TreeMultiset.a) this.f2869a).h;
            aVar = this.c.c;
            if (aVar2 == aVar) {
                this.f2869a = null;
            } else {
                this.f2869a = ((TreeMultiset.a) this.f2869a).h;
            }
            return a2;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        Preconditions.b(this.b != null);
        this.c.setCount(this.b.getElement(), 0);
        this.b = null;
    }
}
