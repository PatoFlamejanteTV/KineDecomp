package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Sets {
    private Sets() {
    }

    /* loaded from: classes2.dex */
    static abstract class a<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return Sets.a((Set<?>) this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) Preconditions.a(collection));
        }
    }

    public static <E> HashSet<E> a() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> a(int i) {
        return new HashSet<>(Maps.b(i));
    }

    public static <E> LinkedHashSet<E> b() {
        return new LinkedHashSet<>();
    }

    /* loaded from: classes2.dex */
    public static abstract class SetView<E> extends AbstractSet<E> {
        private SetView() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001a, code lost:            if (r4.containsAll(r5) != false) goto L13;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.util.Set<?> r4, @javax.annotation.Nullable java.lang.Object r5) {
        /*
            r0 = 1
            r1 = 0
            if (r4 != r5) goto L6
            r1 = r0
        L5:
            return r1
        L6:
            boolean r2 = r5 instanceof java.util.Set
            if (r2 == 0) goto L5
            java.util.Set r5 = (java.util.Set) r5
            int r2 = r4.size()     // Catch: java.lang.ClassCastException -> L20 java.lang.NullPointerException -> L22
            int r3 = r5.size()     // Catch: java.lang.ClassCastException -> L20 java.lang.NullPointerException -> L22
            if (r2 != r3) goto L1e
            boolean r2 = r4.containsAll(r5)     // Catch: java.lang.ClassCastException -> L20 java.lang.NullPointerException -> L22
            if (r2 == 0) goto L1e
        L1c:
            r1 = r0
            goto L5
        L1e:
            r0 = r1
            goto L1c
        L20:
            r0 = move-exception
            goto L5
        L22:
            r0 = move-exception
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Sets.a(java.util.Set, java.lang.Object):boolean");
    }

    static boolean a(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Set<?> set, Collection<?> collection) {
        Preconditions.a(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        if ((collection instanceof Set) && collection.size() > set.size()) {
            Iterator<?> it = set.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    z = true;
                    it.remove();
                }
            }
            return z;
        }
        return a(set, collection.iterator());
    }
}
