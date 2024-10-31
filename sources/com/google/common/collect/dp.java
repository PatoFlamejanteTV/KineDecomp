package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: TreeMultiset.java */
/* loaded from: classes2.dex */
class dp<E> implements Iterator<Multiset.Entry<E>> {

    /* renamed from: a, reason: collision with root package name */
    TreeMultiset.a<E> f2868a;
    Multiset.Entry<E> b;
    final /* synthetic */ TreeMultiset c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(TreeMultiset treeMultiset) {
        TreeMultiset.a<E> a2;
        this.c = treeMultiset;
        a2 = this.c.a();
        this.f2868a = a2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        GeneralRange generalRange;
        if (this.f2868a == null) {
            return false;
        }
        generalRange = this.c.b;
        if (generalRange.tooHigh(this.f2868a.getElement())) {
            this.f2868a = null;
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
            a2 = this.c.a(this.f2868a);
            this.b = a2;
            TreeMultiset.a aVar2 = ((TreeMultiset.a) this.f2868a).i;
            aVar = this.c.c;
            if (aVar2 == aVar) {
                this.f2868a = null;
            } else {
                this.f2868a = ((TreeMultiset.a) this.f2868a).i;
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
