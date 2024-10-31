package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public class LinkedListMultimap<K, V> implements ListMultimap<K, V>, Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private transient c<K, V> f2712a;
    private transient c<K, V> b;
    private transient Multiset<K> c;
    private transient Map<K, c<K, V>> d;
    private transient Map<K, c<K, V>> e;
    private transient Set<K> f;
    private transient Multiset<K> g;
    private transient List<V> h;
    private transient List<Map.Entry<K, V>> i;
    private transient Map<K, Collection<V>> j;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((LinkedListMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f2715a;
        V b;
        c<K, V> c;
        c<K, V> d;
        c<K, V> e;
        c<K, V> f;

        c(@Nullable K k, @Nullable V v) {
            this.f2715a = k;
            this.b = v;
        }

        public String toString() {
            return this.f2715a + "=" + this.b;
        }
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i) {
        return new LinkedListMultimap<>(i);
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<>(multimap);
    }

    LinkedListMultimap() {
        this.c = LinkedHashMultiset.create();
        this.d = Maps.a();
        this.e = Maps.a();
    }

    private LinkedListMultimap(int i) {
        this.c = LinkedHashMultiset.create(i);
        this.d = Maps.a(i);
        this.e = Maps.a(i);
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c<K, V> a(@Nullable K k, @Nullable V v, @Nullable c<K, V> cVar) {
        c<K, V> cVar2 = new c<>(k, v);
        if (this.f2712a == null) {
            this.b = cVar2;
            this.f2712a = cVar2;
            this.d.put(k, cVar2);
            this.e.put(k, cVar2);
        } else if (cVar == null) {
            this.b.c = cVar2;
            cVar2.d = this.b;
            c<K, V> cVar3 = this.e.get(k);
            if (cVar3 == null) {
                this.d.put(k, cVar2);
            } else {
                cVar3.e = cVar2;
                cVar2.f = cVar3;
            }
            this.e.put(k, cVar2);
            this.b = cVar2;
        } else {
            cVar2.d = cVar.d;
            cVar2.f = cVar.f;
            cVar2.c = cVar;
            cVar2.e = cVar;
            if (cVar.f == null) {
                this.d.put(k, cVar2);
            } else {
                cVar.f.e = cVar2;
            }
            if (cVar.d == null) {
                this.f2712a = cVar2;
            } else {
                cVar.d.c = cVar2;
            }
            cVar.d = cVar2;
            cVar.f = cVar2;
        }
        this.c.add(k);
        return cVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c<K, V> cVar) {
        if (cVar.d != null) {
            cVar.d.c = cVar.c;
        } else {
            this.f2712a = cVar.c;
        }
        if (cVar.c != null) {
            cVar.c.d = cVar.d;
        } else {
            this.b = cVar.d;
        }
        if (cVar.f != null) {
            cVar.f.e = cVar.e;
        } else if (cVar.e != null) {
            this.d.put(cVar.f2715a, cVar.e);
        } else {
            this.d.remove(cVar.f2715a);
        }
        if (cVar.e != null) {
            cVar.e.f = cVar.f;
        } else if (cVar.f != null) {
            this.e.put(cVar.f2715a, cVar.f);
        } else {
            this.e.remove(cVar.f2715a);
        }
        this.c.remove(cVar.f2715a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable Object obj) {
        e eVar = new e(obj);
        while (eVar.hasNext()) {
            eVar.next();
            eVar.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@Nullable Object obj) {
        if (obj == null) {
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements ListIterator<c<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        int f2716a;
        c<K, V> b;
        c<K, V> c;
        c<K, V> d;

        d() {
            this.b = LinkedListMultimap.this.f2712a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(int i) {
            int size = LinkedListMultimap.this.size();
            Preconditions.b(i, size);
            if (i >= size / 2) {
                this.d = LinkedListMultimap.this.b;
                this.f2716a = size;
                while (true) {
                    int i2 = i + 1;
                    if (i >= size) {
                        break;
                    }
                    previous();
                    i = i2;
                }
            } else {
                this.b = LinkedListMultimap.this.f2712a;
                while (true) {
                    int i3 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i3;
                }
            }
            this.c = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.b != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c<K, V> next() {
            LinkedListMultimap.b((Object) this.b);
            c<K, V> cVar = this.b;
            this.c = cVar;
            this.d = cVar;
            this.b = this.b.c;
            this.f2716a++;
            return this.c;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            Preconditions.b(this.c != null);
            if (this.c != this.b) {
                this.d = this.c.d;
                this.f2716a--;
            } else {
                this.b = this.c.c;
            }
            LinkedListMultimap.this.a((c) this.c);
            this.c = null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.d != null;
        }

        @Override // java.util.ListIterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c<K, V> previous() {
            LinkedListMultimap.b((Object) this.d);
            c<K, V> cVar = this.d;
            this.c = cVar;
            this.b = cVar;
            this.d = this.d.d;
            this.f2716a--;
            return this.c;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f2716a;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f2716a - 1;
        }

        @Override // java.util.ListIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(c<K, V> cVar) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void add(c<K, V> cVar) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(V v) {
            Preconditions.b(this.c != null);
            this.c.b = v;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Iterator<K> {

        /* renamed from: a, reason: collision with root package name */
        final Set<K> f2713a;
        c<K, V> b;
        c<K, V> c;

        private a() {
            this.f2713a = Sets.a(LinkedListMultimap.this.keySet().size());
            this.b = LinkedListMultimap.this.f2712a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(LinkedListMultimap linkedListMultimap, av avVar) {
            this();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b != null;
        }

        @Override // java.util.Iterator
        public K next() {
            LinkedListMultimap.b((Object) this.b);
            this.c = this.b;
            this.f2713a.add(this.c.f2715a);
            do {
                this.b = this.b.c;
                if (this.b == null) {
                    break;
                }
            } while (!this.f2713a.add(this.b.f2715a));
            return this.c.f2715a;
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.b(this.c != null);
            LinkedListMultimap.this.a(this.c.f2715a);
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements ListIterator<V> {

        /* renamed from: a, reason: collision with root package name */
        final Object f2717a;
        int b;
        c<K, V> c;
        c<K, V> d;
        c<K, V> e;

        e(Object obj) {
            this.f2717a = obj;
            this.c = (c) LinkedListMultimap.this.d.get(obj);
        }

        public e(Object obj, @Nullable int i) {
            int count = LinkedListMultimap.this.c.count(obj);
            Preconditions.b(i, count);
            if (i >= count / 2) {
                this.e = (c) LinkedListMultimap.this.e.get(obj);
                this.b = count;
                while (true) {
                    int i2 = i + 1;
                    if (i >= count) {
                        break;
                    }
                    previous();
                    i = i2;
                }
            } else {
                this.c = (c) LinkedListMultimap.this.d.get(obj);
                while (true) {
                    int i3 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i3;
                }
            }
            this.f2717a = obj;
            this.d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.c != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            LinkedListMultimap.b((Object) this.c);
            c<K, V> cVar = this.c;
            this.d = cVar;
            this.e = cVar;
            this.c = this.c.e;
            this.b++;
            return this.d.b;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.e != null;
        }

        @Override // java.util.ListIterator
        public V previous() {
            LinkedListMultimap.b((Object) this.e);
            c<K, V> cVar = this.e;
            this.d = cVar;
            this.c = cVar;
            this.e = this.e.f;
            this.b--;
            return this.d.b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            Preconditions.b(this.d != null);
            if (this.d != this.c) {
                this.e = this.d.f;
                this.b--;
            } else {
                this.c = this.d.e;
            }
            LinkedListMultimap.this.a((c) this.d);
            this.d = null;
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            Preconditions.b(this.d != null);
            this.d.b = v;
        }

        @Override // java.util.ListIterator
        public void add(V v) {
            this.e = LinkedListMultimap.this.a(this.f2717a, v, this.c);
            this.b++;
            this.d = null;
        }
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.c.size();
    }

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        return this.f2712a == null;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@Nullable Object obj) {
        return this.d.containsKey(obj);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsValue(@Nullable Object obj) {
        d dVar = new d();
        while (dVar.hasNext()) {
            if (Objects.a(dVar.next().b, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsEntry(@Nullable Object obj, @Nullable Object obj2) {
        e eVar = new e(obj);
        while (eVar.hasNext()) {
            if (Objects.a(eVar.next(), obj2)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.Multimap
    public boolean put(@Nullable K k, @Nullable V v) {
        a(k, v, null);
        return true;
    }

    @Override // com.google.common.collect.Multimap
    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        e eVar = new e(obj);
        while (eVar.hasNext()) {
            if (Objects.a(eVar.next(), obj2)) {
                eVar.remove();
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.Multimap
    public boolean putAll(@Nullable K k, Iterable<? extends V> iterable) {
        boolean z = false;
        Iterator<? extends V> it = iterable.iterator();
        while (it.hasNext()) {
            z |= put(k, it.next());
        }
        return z;
    }

    @Override // com.google.common.collect.Multimap
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        boolean z = false;
        Iterator<Map.Entry<? extends K, ? extends V>> it = multimap.entries().iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                Map.Entry<? extends K, ? extends V> next = it.next();
                z = put(next.getKey(), next.getValue()) | z2;
            } else {
                return z2;
            }
        }
    }

    @Override // com.google.common.collect.Multimap
    public List<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable) {
        List<V> c2 = c(k);
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
        return c2;
    }

    private List<V> c(@Nullable Object obj) {
        return Collections.unmodifiableList(Lists.a(new e(obj)));
    }

    @Override // com.google.common.collect.Multimap
    public List<V> removeAll(@Nullable Object obj) {
        List<V> c2 = c(obj);
        a(obj);
        return c2;
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        this.f2712a = null;
        this.b = null;
        this.c.clear();
        this.d.clear();
        this.e.clear();
    }

    @Override // com.google.common.collect.Multimap
    public List<V> get(@Nullable K k) {
        return new av(this, k);
    }

    @Override // com.google.common.collect.Multimap
    public Set<K> keySet() {
        Set<K> set = this.f;
        if (set == null) {
            aw awVar = new aw(this);
            this.f = awVar;
            return awVar;
        }
        return set;
    }

    @Override // com.google.common.collect.Multimap
    public Multiset<K> keys() {
        Multiset<K> multiset = this.g;
        if (multiset == null) {
            b bVar = new b(this, null);
            this.g = bVar;
            return bVar;
        }
        return multiset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends l<K> {
        private b() {
        }

        /* synthetic */ b(LinkedListMultimap linkedListMultimap, av avVar) {
            this();
        }

        @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
        public int size() {
            return LinkedListMultimap.this.c.size();
        }

        @Override // com.google.common.collect.l, com.google.common.collect.Multiset
        public int count(Object obj) {
            return LinkedListMultimap.this.c.count(obj);
        }

        @Override // com.google.common.collect.l
        Iterator<Multiset.Entry<K>> entryIterator() {
            return new bf(this, new a(LinkedListMultimap.this, null));
        }

        @Override // com.google.common.collect.l
        int distinctElements() {
            return elementSet().size();
        }

        @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new bh(this, new d());
        }

        @Override // com.google.common.collect.l, com.google.common.collect.Multiset
        public int remove(@Nullable Object obj, int i) {
            Preconditions.a(i >= 0);
            int count = count(obj);
            e eVar = new e(obj);
            while (true) {
                int i2 = i - 1;
                if (i <= 0 || !eVar.hasNext()) {
                    break;
                }
                eVar.next();
                eVar.remove();
                i = i2;
            }
            return count;
        }

        @Override // com.google.common.collect.l, com.google.common.collect.Multiset
        public Set<K> elementSet() {
            return LinkedListMultimap.this.keySet();
        }

        @Override // com.google.common.collect.l, java.util.Collection
        public boolean equals(@Nullable Object obj) {
            return LinkedListMultimap.this.c.equals(obj);
        }

        @Override // com.google.common.collect.l, java.util.Collection
        public int hashCode() {
            return LinkedListMultimap.this.c.hashCode();
        }

        @Override // com.google.common.collect.l, java.util.AbstractCollection
        public String toString() {
            return LinkedListMultimap.this.c.toString();
        }
    }

    @Override // com.google.common.collect.Multimap
    public List<V> values() {
        List<V> list = this.h;
        if (list == null) {
            ax axVar = new ax(this);
            this.h = axVar;
            return axVar;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> Map.Entry<K, V> b(c<K, V> cVar) {
        return new az(cVar);
    }

    @Override // com.google.common.collect.Multimap
    public List<Map.Entry<K, V>> entries() {
        List<Map.Entry<K, V>> list = this.i;
        if (list == null) {
            ba baVar = new ba(this);
            this.i = baVar;
            return baVar;
        }
        return list;
    }

    @Override // com.google.common.collect.Multimap
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.j;
        if (map == null) {
            bc bcVar = new bc(this);
            this.j = bcVar;
            return bcVar;
        }
        return map;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Multimap) {
            return asMap().equals(((Multimap) obj).asMap());
        }
        return false;
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    public String toString() {
        return asMap().toString();
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

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.c = LinkedHashMultiset.create();
        this.d = Maps.a();
        this.e = Maps.a();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }
}
