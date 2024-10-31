package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
/* loaded from: classes2.dex */
public class ImmutableSortedSet<T> implements Iterable<T> {

    /* renamed from: a */
    private final ImmutableSortedMap<T, Void> f16696a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
    /* loaded from: classes2.dex */
    public static class a<T> implements Iterator<T> {

        /* renamed from: a */
        final Iterator<Map.Entry<T, Void>> f16697a;

        public a(Iterator<Map.Entry<T, Void>> it) {
            this.f16697a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16697a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f16697a.next().getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f16697a.remove();
        }
    }

    public ImmutableSortedSet(List<T> list, Comparator<T> comparator) {
        this.f16696a = ImmutableSortedMap.Builder.a(list, Collections.emptyMap(), ImmutableSortedMap.Builder.a(), comparator);
    }

    public T a() {
        return this.f16696a.d();
    }

    public ImmutableSortedSet<T> b(T t) {
        return new ImmutableSortedSet<>(this.f16696a.a(t, null));
    }

    public Iterator<T> c() {
        return new a(this.f16696a.c());
    }

    public T d() {
        return this.f16696a.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImmutableSortedSet) {
            return this.f16696a.equals(((ImmutableSortedSet) obj).f16696a);
        }
        return false;
    }

    public int hashCode() {
        return this.f16696a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.f16696a.iterator());
    }

    public ImmutableSortedSet<T> remove(T t) {
        ImmutableSortedMap<T, Void> remove = this.f16696a.remove(t);
        return remove == this.f16696a ? this : new ImmutableSortedSet<>(remove);
    }

    public T a(T t) {
        return this.f16696a.c(t);
    }

    private ImmutableSortedSet(ImmutableSortedMap<T, Void> immutableSortedMap) {
        this.f16696a = immutableSortedMap;
    }
}
