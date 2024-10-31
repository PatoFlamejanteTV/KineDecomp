package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
/* loaded from: classes2.dex */
public abstract class ImmutableSortedMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a */
        private static final KeyTranslator f16693a = b.a();

        /* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
        /* loaded from: classes2.dex */
        public interface KeyTranslator<C, D> {
            D a(C c2);
        }

        public static <K, V> ImmutableSortedMap<K, V> a(Comparator<K> comparator) {
            return new ArraySortedMap(comparator);
        }

        public static /* synthetic */ Object a(Object obj) {
            return obj;
        }

        public static <A> KeyTranslator<A, A> a() {
            return f16693a;
        }

        public static <A, B> ImmutableSortedMap<A, B> a(Map<A, B> map, Comparator<A> comparator) {
            if (map.size() < 25) {
                return ArraySortedMap.a((Map) map, (Comparator) comparator);
            }
            return RBTreeSortedMap.a((Map) map, (Comparator) comparator);
        }

        public static <A, B, C> ImmutableSortedMap<A, C> a(List<A> list, Map<B, C> map, KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
            if (list.size() < 25) {
                return ArraySortedMap.a(list, map, keyTranslator, comparator);
            }
            return RBTreeSortedMap.a(list, map, keyTranslator, comparator);
        }
    }

    public abstract ImmutableSortedMap<K, V> a(K k, V v);

    public abstract Comparator<K> a();

    public abstract void a(LLRBNode.NodeVisitor<K, V> nodeVisitor);

    public abstract boolean a(K k);

    public abstract V b(K k);

    public abstract K c(K k);

    public abstract Iterator<Map.Entry<K, V>> c();

    public abstract K d();

    public abstract K e();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImmutableSortedMap)) {
            return false;
        }
        ImmutableSortedMap immutableSortedMap = (ImmutableSortedMap) obj;
        if (!a().equals(immutableSortedMap.a()) || size() != immutableSortedMap.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = immutableSortedMap.iterator();
        while (it.hasNext()) {
            if (!it.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int hashCode = a().hashCode();
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            hashCode = (hashCode * 31) + it.next().hashCode();
        }
        return hashCode;
    }

    public abstract boolean isEmpty();

    @Override // java.lang.Iterable
    public abstract Iterator<Map.Entry<K, V>> iterator();

    public abstract ImmutableSortedMap<K, V> remove(K k);

    public abstract int size();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        Iterator<Map.Entry<K, V>> it = iterator();
        boolean z = true;
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append("(");
            sb.append(next.getKey());
            sb.append("=>");
            sb.append(next.getValue());
            sb.append(")");
        }
        sb.append("};");
        return sb.toString();
    }
}
