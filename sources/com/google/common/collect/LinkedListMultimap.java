package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multimaps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class LinkedListMultimap<K, V> extends AbstractC1519k<K, V> implements ListMultimap<K, V>, Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    private transient c<K, V> f15502f;

    /* renamed from: g */
    private transient c<K, V> f15503g;

    /* renamed from: h */
    private transient Map<K, b<K, V>> f15504h;
    private transient int i;
    private transient int j;

    /* loaded from: classes2.dex */
    public static class b<K, V> {

        /* renamed from: a */
        c<K, V> f15510a;

        /* renamed from: b */
        c<K, V> f15511b;

        /* renamed from: c */
        int f15512c;

        b(c<K, V> cVar) {
            this.f15510a = cVar;
            this.f15511b = cVar;
            cVar.f15518f = null;
            cVar.f15517e = null;
            this.f15512c = 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c<K, V> extends AbstractC1513i<K, V> {

        /* renamed from: a */
        final K f15513a;

        /* renamed from: b */
        V f15514b;

        /* renamed from: c */
        c<K, V> f15515c;

        /* renamed from: d */
        c<K, V> f15516d;

        /* renamed from: e */
        c<K, V> f15517e;

        /* renamed from: f */
        c<K, V> f15518f;

        c(@Nullable K k, @Nullable V v) {
            this.f15513a = k;
            this.f15514b = v;
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public K getKey() {
            return this.f15513a;
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public V getValue() {
            return this.f15514b;
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public V setValue(@Nullable V v) {
            V v2 = this.f15514b;
            this.f15514b = v;
            return v2;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ListIterator<Map.Entry<K, V>> {

        /* renamed from: a */
        int f15519a;

        /* renamed from: b */
        c<K, V> f15520b;

        /* renamed from: c */
        c<K, V> f15521c;

        /* renamed from: d */
        c<K, V> f15522d;

        /* renamed from: e */
        int f15523e;

        public d(int i) {
            this.f15523e = LinkedListMultimap.this.j;
            int size = LinkedListMultimap.this.size();
            Preconditions.b(i, size);
            if (i >= size / 2) {
                this.f15522d = LinkedListMultimap.this.f15503g;
                this.f15519a = size;
                while (true) {
                    int i2 = i + 1;
                    if (i >= size) {
                        break;
                    }
                    previous();
                    i = i2;
                }
            } else {
                this.f15520b = LinkedListMultimap.this.f15502f;
                while (true) {
                    int i3 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i3;
                }
            }
            this.f15521c = null;
        }

        private void a() {
            if (LinkedListMultimap.this.j != this.f15523e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            a((Map.Entry) obj);
            throw null;
        }

        public void b(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f15520b != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            a();
            return this.f15522d != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f15519a;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f15519a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            a();
            C1555x.a(this.f15521c != null);
            c<K, V> cVar = this.f15521c;
            if (cVar != this.f15520b) {
                this.f15522d = cVar.f15516d;
                this.f15519a--;
            } else {
                this.f15520b = cVar.f15515c;
            }
            LinkedListMultimap.this.a((c) this.f15521c);
            this.f15521c = null;
            this.f15523e = LinkedListMultimap.this.j;
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            b((Map.Entry) obj);
            throw null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @CanIgnoreReturnValue
        public c<K, V> next() {
            a();
            LinkedListMultimap.a((Object) this.f15520b);
            c<K, V> cVar = this.f15520b;
            this.f15521c = cVar;
            this.f15522d = cVar;
            this.f15520b = cVar.f15515c;
            this.f15519a++;
            return this.f15521c;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        public c<K, V> previous() {
            a();
            LinkedListMultimap.a((Object) this.f15522d);
            c<K, V> cVar = this.f15522d;
            this.f15521c = cVar;
            this.f15520b = cVar;
            this.f15522d = cVar.f15516d;
            this.f15519a--;
            return this.f15521c;
        }

        public void a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public void a(V v) {
            Preconditions.b(this.f15521c != null);
            this.f15521c.f15514b = v;
        }
    }

    LinkedListMultimap() {
        this.f15504h = Maps.c();
    }

    @CanIgnoreReturnValue
    public c<K, V> a(@Nullable K k, @Nullable V v, @Nullable c<K, V> cVar) {
        c<K, V> cVar2 = new c<>(k, v);
        if (this.f15502f == null) {
            this.f15503g = cVar2;
            this.f15502f = cVar2;
            this.f15504h.put(k, new b<>(cVar2));
            this.j++;
        } else if (cVar == null) {
            c<K, V> cVar3 = this.f15503g;
            cVar3.f15515c = cVar2;
            cVar2.f15516d = cVar3;
            this.f15503g = cVar2;
            b<K, V> bVar = this.f15504h.get(k);
            if (bVar == null) {
                this.f15504h.put(k, new b<>(cVar2));
                this.j++;
            } else {
                bVar.f15512c++;
                c<K, V> cVar4 = bVar.f15511b;
                cVar4.f15517e = cVar2;
                cVar2.f15518f = cVar4;
                bVar.f15511b = cVar2;
            }
        } else {
            this.f15504h.get(k).f15512c++;
            cVar2.f15516d = cVar.f15516d;
            cVar2.f15518f = cVar.f15518f;
            cVar2.f15515c = cVar;
            cVar2.f15517e = cVar;
            c<K, V> cVar5 = cVar.f15518f;
            if (cVar5 == null) {
                this.f15504h.get(k).f15510a = cVar2;
            } else {
                cVar5.f15517e = cVar2;
            }
            c<K, V> cVar6 = cVar.f15516d;
            if (cVar6 == null) {
                this.f15502f = cVar2;
            } else {
                cVar6.f15515c = cVar2;
            }
            cVar.f15516d = cVar2;
            cVar.f15518f = cVar2;
        }
        this.i++;
        return cVar2;
    }

    private List<V> b(@Nullable Object obj) {
        return Collections.unmodifiableList(Lists.a(new e(obj)));
    }

    public void c(@Nullable Object obj) {
        Iterators.b(new e(obj));
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f15504h = Maps.d();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        this.f15502f = null;
        this.f15503g = null;
        this.f15504h.clear();
        this.i = 0;
        this.j++;
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@Nullable Object obj) {
        return this.f15504h.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC1519k
    public boolean containsValue(@Nullable Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.AbstractC1519k
    Map<K, Collection<V>> createAsMap() {
        return new Multimaps.a(this);
    }

    @Override // com.google.common.collect.AbstractC1519k
    Set<K> createKeySet() {
        return new C1556xa(this);
    }

    @Override // com.google.common.collect.AbstractC1519k
    Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((LinkedListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public boolean isEmpty() {
        return this.f15502f == null;
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean put(@Nullable K k, @Nullable V v) {
        a(k, v, null);
        return true;
    }

    @Override // com.google.common.collect.AbstractC1519k
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractC1519k
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.i;
    }

    @Override // com.google.common.collect.AbstractC1519k
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i) {
        return new LinkedListMultimap<>(i);
    }

    @Override // com.google.common.collect.AbstractC1519k
    public List<Map.Entry<K, V>> createEntries() {
        return new C1554wa(this);
    }

    @Override // com.google.common.collect.AbstractC1519k
    public List<V> createValues() {
        return new C1560za(this);
    }

    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.common.collect.Multimap
    public List<V> get(@Nullable K k) {
        return new C1552va(this, k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractC1519k, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public List<V> removeAll(@Nullable Object obj) {
        List<V> b2 = b(obj);
        c(obj);
        return b2;
    }

    @Override // com.google.common.collect.AbstractC1519k
    @CanIgnoreReturnValue
    public List<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable) {
        List<V> b2 = b(k);
        e eVar = new e(k);
        Iterator<? extends V> it = iterable.iterator();
        while (eVar.hasNext() && it.hasNext()) {
            eVar.next();
            eVar.set(it.next());
        }
        while (eVar.hasNext()) {
            eVar.next();
            eVar.remove();
        }
        while (it.hasNext()) {
            eVar.add(it.next());
        }
        return b2;
    }

    @Override // com.google.common.collect.AbstractC1519k
    public List<V> values() {
        return (List) super.values();
    }

    private LinkedListMultimap(int i) {
        this.f15504h = new HashMap(i);
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<>(multimap);
    }

    /* loaded from: classes2.dex */
    public class a implements Iterator<K> {

        /* renamed from: a */
        final Set<K> f15505a;

        /* renamed from: b */
        c<K, V> f15506b;

        /* renamed from: c */
        c<K, V> f15507c;

        /* renamed from: d */
        int f15508d;

        private a() {
            this.f15505a = Sets.a(LinkedListMultimap.this.keySet().size());
            this.f15506b = LinkedListMultimap.this.f15502f;
            this.f15508d = LinkedListMultimap.this.j;
        }

        private void b() {
            if (LinkedListMultimap.this.j != this.f15508d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f15506b != null;
        }

        @Override // java.util.Iterator
        public K next() {
            c<K, V> cVar;
            b();
            LinkedListMultimap.a((Object) this.f15506b);
            this.f15507c = this.f15506b;
            this.f15505a.add(this.f15507c.f15513a);
            do {
                this.f15506b = this.f15506b.f15515c;
                cVar = this.f15506b;
                if (cVar == null) {
                    break;
                }
            } while (!this.f15505a.add(cVar.f15513a));
            return this.f15507c.f15513a;
        }

        @Override // java.util.Iterator
        public void remove() {
            b();
            C1555x.a(this.f15507c != null);
            LinkedListMultimap.this.c(this.f15507c.f15513a);
            this.f15507c = null;
            this.f15508d = LinkedListMultimap.this.j;
        }

        public /* synthetic */ a(LinkedListMultimap linkedListMultimap, C1552va c1552va) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements ListIterator<V> {

        /* renamed from: a */
        final Object f15525a;

        /* renamed from: b */
        int f15526b;

        /* renamed from: c */
        c<K, V> f15527c;

        /* renamed from: d */
        c<K, V> f15528d;

        /* renamed from: e */
        c<K, V> f15529e;

        e(@Nullable Object obj) {
            this.f15525a = obj;
            b bVar = (b) LinkedListMultimap.this.f15504h.get(obj);
            this.f15527c = bVar == null ? null : bVar.f15510a;
        }

        @Override // java.util.ListIterator
        public void add(V v) {
            this.f15529e = LinkedListMultimap.this.a(this.f15525a, v, this.f15527c);
            this.f15526b++;
            this.f15528d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f15527c != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f15529e != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @CanIgnoreReturnValue
        public V next() {
            LinkedListMultimap.a((Object) this.f15527c);
            c<K, V> cVar = this.f15527c;
            this.f15528d = cVar;
            this.f15529e = cVar;
            this.f15527c = cVar.f15517e;
            this.f15526b++;
            return this.f15528d.f15514b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f15526b;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        public V previous() {
            LinkedListMultimap.a((Object) this.f15529e);
            c<K, V> cVar = this.f15529e;
            this.f15528d = cVar;
            this.f15527c = cVar;
            this.f15529e = cVar.f15518f;
            this.f15526b--;
            return this.f15528d.f15514b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f15526b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            C1555x.a(this.f15528d != null);
            c<K, V> cVar = this.f15528d;
            if (cVar != this.f15527c) {
                this.f15529e = cVar.f15518f;
                this.f15526b--;
            } else {
                this.f15527c = cVar.f15517e;
            }
            LinkedListMultimap.this.a((c) this.f15528d);
            this.f15528d = null;
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            Preconditions.b(this.f15528d != null);
            this.f15528d.f15514b = v;
        }

        public e(@Nullable Object obj, int i) {
            b bVar = (b) LinkedListMultimap.this.f15504h.get(obj);
            int i2 = bVar == null ? 0 : bVar.f15512c;
            Preconditions.b(i, i2);
            if (i >= i2 / 2) {
                this.f15529e = bVar == null ? null : bVar.f15511b;
                this.f15526b = i2;
                while (true) {
                    int i3 = i + 1;
                    if (i >= i2) {
                        break;
                    }
                    previous();
                    i = i3;
                }
            } else {
                this.f15527c = bVar == null ? null : bVar.f15510a;
                while (true) {
                    int i4 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i4;
                }
            }
            this.f15525a = obj;
            this.f15528d = null;
        }
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }

    public void a(c<K, V> cVar) {
        c<K, V> cVar2 = cVar.f15516d;
        if (cVar2 != null) {
            cVar2.f15515c = cVar.f15515c;
        } else {
            this.f15502f = cVar.f15515c;
        }
        c<K, V> cVar3 = cVar.f15515c;
        if (cVar3 != null) {
            cVar3.f15516d = cVar.f15516d;
        } else {
            this.f15503g = cVar.f15516d;
        }
        if (cVar.f15518f == null && cVar.f15517e == null) {
            this.f15504h.remove(cVar.f15513a).f15512c = 0;
            this.j++;
        } else {
            b<K, V> bVar = this.f15504h.get(cVar.f15513a);
            bVar.f15512c--;
            c<K, V> cVar4 = cVar.f15518f;
            if (cVar4 == null) {
                bVar.f15510a = cVar.f15517e;
            } else {
                cVar4.f15517e = cVar.f15517e;
            }
            c<K, V> cVar5 = cVar.f15517e;
            if (cVar5 == null) {
                bVar.f15511b = cVar.f15518f;
            } else {
                cVar5.f15518f = cVar.f15518f;
            }
        }
        this.i--;
    }

    public static void a(@Nullable Object obj) {
        if (obj == null) {
            throw new NoSuchElementException();
        }
    }
}
