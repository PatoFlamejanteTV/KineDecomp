package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
/* loaded from: classes2.dex */
public class RBTreeSortedMap<K, V> extends ImmutableSortedMap<K, V> {

    /* renamed from: a */
    private LLRBNode<K, V> f16704a;

    /* renamed from: b */
    private Comparator<K> f16705b;

    /* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
    /* loaded from: classes2.dex */
    public static class a<A, B, C> {

        /* renamed from: a */
        private final List<A> f16706a;

        /* renamed from: b */
        private final Map<B, C> f16707b;

        /* renamed from: c */
        private final ImmutableSortedMap.Builder.KeyTranslator<A, B> f16708c;

        /* renamed from: d */
        private LLRBValueNode<A, C> f16709d;

        /* renamed from: e */
        private LLRBValueNode<A, C> f16710e;

        /* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
        /* renamed from: com.google.firebase.database.collection.RBTreeSortedMap$a$a */
        /* loaded from: classes2.dex */
        public static class C0093a implements Iterable<b> {

            /* renamed from: a */
            private long f16711a;

            /* renamed from: b */
            private final int f16712b;

            public C0093a(int i) {
                int i2 = i + 1;
                this.f16712b = (int) Math.floor(Math.log(i2) / Math.log(2.0d));
                this.f16711a = (((long) Math.pow(2.0d, this.f16712b)) - 1) & i2;
            }

            @Override // java.lang.Iterable
            public Iterator<b> iterator() {
                return new d(this);
            }
        }

        /* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
        /* loaded from: classes2.dex */
        public static class b {

            /* renamed from: a */
            public boolean f16713a;

            /* renamed from: b */
            public int f16714b;
        }

        private a(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator) {
            this.f16706a = list;
            this.f16707b = map;
            this.f16708c = keyTranslator;
        }

        private C a(A a2) {
            return this.f16707b.get(this.f16708c.a(a2));
        }

        private LLRBNode<A, C> a(int i, int i2) {
            if (i2 == 0) {
                return LLRBEmptyNode.f();
            }
            if (i2 == 1) {
                A a2 = this.f16706a.get(i);
                return new LLRBBlackValueNode(a2, a(a2), null, null);
            }
            int i3 = i2 / 2;
            int i4 = i + i3;
            LLRBNode<A, C> a3 = a(i, i3);
            LLRBNode<A, C> a4 = a(i4 + 1, i3);
            A a5 = this.f16706a.get(i4);
            return new LLRBBlackValueNode(a5, a(a5), a3, a4);
        }

        private void a(LLRBNode.Color color, int i, int i2) {
            LLRBValueNode<A, C> lLRBBlackValueNode;
            LLRBNode<A, C> a2 = a(i2 + 1, i - 1);
            A a3 = this.f16706a.get(i2);
            if (color == LLRBNode.Color.RED) {
                lLRBBlackValueNode = new LLRBRedValueNode<>(a3, a(a3), null, a2);
            } else {
                lLRBBlackValueNode = new LLRBBlackValueNode<>(a3, a(a3), null, a2);
            }
            if (this.f16709d == null) {
                this.f16709d = lLRBBlackValueNode;
                this.f16710e = lLRBBlackValueNode;
            } else {
                this.f16710e.a(lLRBBlackValueNode);
                this.f16710e = lLRBBlackValueNode;
            }
        }

        public static <A, B, C> RBTreeSortedMap<A, C> a(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
            a aVar = new a(list, map, keyTranslator);
            Collections.sort(list, comparator);
            Iterator<b> it = new C0093a(list.size()).iterator();
            int size = list.size();
            while (it.hasNext()) {
                b next = it.next();
                int i = next.f16714b;
                size -= i;
                if (next.f16713a) {
                    aVar.a(LLRBNode.Color.BLACK, i, size);
                } else {
                    aVar.a(LLRBNode.Color.BLACK, i, size);
                    int i2 = next.f16714b;
                    size -= i2;
                    aVar.a(LLRBNode.Color.RED, i2, size);
                }
            }
            LLRBNode lLRBNode = aVar.f16709d;
            if (lLRBNode == null) {
                lLRBNode = LLRBEmptyNode.f();
            }
            return new RBTreeSortedMap<>(lLRBNode, comparator);
        }
    }

    /* synthetic */ RBTreeSortedMap(LLRBNode lLRBNode, Comparator comparator, c cVar) {
        this(lLRBNode, comparator);
    }

    private LLRBNode<K, V> d(K k) {
        LLRBNode<K, V> lLRBNode = this.f16704a;
        while (!lLRBNode.isEmpty()) {
            int compare = this.f16705b.compare(k, lLRBNode.getKey());
            if (compare < 0) {
                lLRBNode = lLRBNode.a();
            } else {
                if (compare == 0) {
                    return lLRBNode;
                }
                lLRBNode = lLRBNode.c();
            }
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean a(K k) {
        return d(k) != null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public V b(K k) {
        LLRBNode<K, V> d2 = d(k);
        if (d2 != null) {
            return d2.getValue();
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> c() {
        return new ImmutableSortedMapIterator(this.f16704a, null, this.f16705b, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K e() {
        return this.f16704a.d().getKey();
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean isEmpty() {
        return this.f16704a.isEmpty();
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new ImmutableSortedMapIterator(this.f16704a, null, this.f16705b, false);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> remove(K k) {
        return !a((RBTreeSortedMap<K, V>) k) ? this : new RBTreeSortedMap(this.f16704a.a(k, this.f16705b).a(null, null, LLRBNode.Color.BLACK, null, null), this.f16705b);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int size() {
        return this.f16704a.size();
    }

    private RBTreeSortedMap(LLRBNode<K, V> lLRBNode, Comparator<K> comparator) {
        this.f16704a = lLRBNode;
        this.f16705b = comparator;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> a(K k, V v) {
        return new RBTreeSortedMap(this.f16704a.a(k, v, this.f16705b).a(null, null, LLRBNode.Color.BLACK, null, null), this.f16705b);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K c(K k) {
        LLRBNode<K, V> lLRBNode = this.f16704a;
        LLRBNode<K, V> lLRBNode2 = null;
        while (!lLRBNode.isEmpty()) {
            int compare = this.f16705b.compare(k, lLRBNode.getKey());
            if (compare == 0) {
                if (lLRBNode.a().isEmpty()) {
                    if (lLRBNode2 != null) {
                        return lLRBNode2.getKey();
                    }
                    return null;
                }
                LLRBNode<K, V> a2 = lLRBNode.a();
                while (!a2.c().isEmpty()) {
                    a2 = a2.c();
                }
                return a2.getKey();
            }
            if (compare < 0) {
                lLRBNode = lLRBNode.a();
            } else {
                lLRBNode2 = lLRBNode;
                lLRBNode = lLRBNode.c();
            }
        }
        throw new IllegalArgumentException("Couldn't find predecessor key of non-present key: " + k);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public void a(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        this.f16704a.a(nodeVisitor);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Comparator<K> a() {
        return this.f16705b;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K d() {
        return this.f16704a.e().getKey();
    }

    public static <A, B, C> RBTreeSortedMap<A, C> a(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
        return a.a(list, map, keyTranslator, comparator);
    }

    public static <A, B> RBTreeSortedMap<A, B> a(Map<A, B> map, Comparator<A> comparator) {
        return a.a(new ArrayList(map.keySet()), map, ImmutableSortedMap.Builder.a(), comparator);
    }
}
