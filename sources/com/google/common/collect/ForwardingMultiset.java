package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public abstract Multiset<E> delegate();

    @Override // com.google.common.collect.Multiset
    public int count(Object obj) {
        return delegate().count(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int add(E e, int i) {
        return delegate().add(e, i);
    }

    @Override // com.google.common.collect.Multiset
    public int remove(Object obj, int i) {
        return delegate().remove(obj, i);
    }

    @Override // com.google.common.collect.Multiset
    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    @Override // com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Collection
    public boolean equals(@Nullable Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.Multiset
    public int setCount(E e, int i) {
        return delegate().setCount(e, i);
    }

    @Override // com.google.common.collect.Multiset
    public boolean setCount(E e, int i, int i2) {
        return delegate().setCount(e, i, i2);
    }

    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    protected boolean standardContains(@Nullable Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    protected void standardClear() {
        Iterator<Multiset.Entry<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Beta
    protected int a(@Nullable Object obj) {
        for (Multiset.Entry<E> entry : entrySet()) {
            if (Objects.a(entry.getElement(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    @Beta
    protected boolean b(E e) {
        add(e, 1);
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    protected boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.a((Multiset) this, (Collection) collection);
    }

    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    protected boolean standardRemove(Object obj) {
        return remove(obj, 1) > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    public boolean standardRemoveAll(Collection<?> collection) {
        return Multisets.b(this, collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    public boolean standardRetainAll(Collection<?> collection) {
        return Multisets.c(this, collection);
    }

    @Beta
    protected int a(E e, int i) {
        return Multisets.a(this, e, i);
    }

    @Beta
    protected boolean a(E e, int i, int i2) {
        return Multisets.a(this, e, i, i2);
    }

    @Beta
    /* loaded from: classes2.dex */
    protected class StandardElementSet extends Multisets.b<E> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ForwardingMultiset f2681a;

        @Override // com.google.common.collect.Multisets.b
        Multiset<E> a() {
            return this.f2681a;
        }
    }

    @Beta
    protected Iterator<E> d() {
        return Multisets.a((Multiset) this);
    }

    @Beta
    protected int e() {
        return Multisets.b((Multiset<?>) this);
    }

    @Beta
    protected boolean c(@Nullable Object obj) {
        return Multisets.a(this, obj);
    }

    @Beta
    protected int f() {
        return entrySet().hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    public String standardToString() {
        return entrySet().toString();
    }
}
