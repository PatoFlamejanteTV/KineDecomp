package com.google.firebase.database.core.utilities;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.StandardComparator;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class ImmutableTree<T> implements Iterable<Map.Entry<Path, T>> {

    /* renamed from: a */
    private static final ImmutableSortedMap f17053a = ImmutableSortedMap.Builder.a((Comparator) StandardComparator.a(ChildKey.class));

    /* renamed from: b */
    private static final ImmutableTree f17054b = new ImmutableTree(null, f17053a);

    /* renamed from: c */
    private final T f17055c;

    /* renamed from: d */
    private final ImmutableSortedMap<ChildKey, ImmutableTree<T>> f17056d;

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface TreeVisitor<T, R> {
        R a(Path path, T t, R r);
    }

    public ImmutableTree(T t, ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap) {
        this.f17055c = t;
        this.f17056d = immutableSortedMap;
    }

    public static <V> ImmutableTree<V> a() {
        return f17054b;
    }

    public Path b(Path path) {
        return a(path, (Predicate) Predicate.f17063a);
    }

    public T c(Path path, Predicate<? super T> predicate) {
        T t = this.f17055c;
        if (t != null && predicate.evaluate(t)) {
            return this.f17055c;
        }
        Iterator<ChildKey> it = path.iterator();
        ImmutableTree<T> immutableTree = this;
        while (it.hasNext()) {
            immutableTree = immutableTree.f17056d.b(it.next());
            if (immutableTree == null) {
                return null;
            }
            T t2 = immutableTree.f17055c;
            if (t2 != null && predicate.evaluate(t2)) {
                return immutableTree.f17055c;
            }
        }
        return null;
    }

    public ImmutableSortedMap<ChildKey, ImmutableTree<T>> d() {
        return this.f17056d;
    }

    public ImmutableTree<T> e(Path path) {
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> a2;
        if (path.isEmpty()) {
            if (this.f17056d.isEmpty()) {
                return a();
            }
            return new ImmutableTree<>(null, this.f17056d);
        }
        ChildKey f2 = path.f();
        ImmutableTree<T> b2 = this.f17056d.b(f2);
        if (b2 == null) {
            return this;
        }
        ImmutableTree<T> e2 = b2.e(path.g());
        if (e2.isEmpty()) {
            a2 = this.f17056d.remove(f2);
        } else {
            a2 = this.f17056d.a(f2, e2);
        }
        if (this.f17055c == null && a2.isEmpty()) {
            return a();
        }
        return new ImmutableTree<>(this.f17055c, a2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ImmutableTree.class != obj.getClass()) {
            return false;
        }
        ImmutableTree immutableTree = (ImmutableTree) obj;
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap = this.f17056d;
        if (immutableSortedMap == null ? immutableTree.f17056d != null : !immutableSortedMap.equals(immutableTree.f17056d)) {
            return false;
        }
        T t = this.f17055c;
        return t == null ? immutableTree.f17055c == null : t.equals(immutableTree.f17055c);
    }

    public ImmutableTree<T> f(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        ImmutableTree<T> b2 = this.f17056d.b(path.f());
        if (b2 != null) {
            return b2.f(path.g());
        }
        return a();
    }

    public T getValue() {
        return this.f17055c;
    }

    public int hashCode() {
        T t = this.f17055c;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap = this.f17056d;
        return hashCode + (immutableSortedMap != null ? immutableSortedMap.hashCode() : 0);
    }

    public boolean isEmpty() {
        return this.f17055c == null && this.f17056d.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<Path, T>> iterator() {
        ArrayList arrayList = new ArrayList();
        a(new d(this, arrayList));
        return arrayList.iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableTree { value=");
        sb.append(getValue());
        sb.append(", children={");
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.f17056d.iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<T>> next = it.next();
            sb.append(next.getKey().a());
            sb.append("=");
            sb.append(next.getValue());
        }
        sb.append("} }");
        return sb.toString();
    }

    public Path a(Path path, Predicate<? super T> predicate) {
        ChildKey f2;
        ImmutableTree<T> b2;
        Path a2;
        T t = this.f17055c;
        if (t != null && predicate.evaluate(t)) {
            return Path.e();
        }
        if (path.isEmpty() || (b2 = this.f17056d.b((f2 = path.f()))) == null || (a2 = b2.a(path.g(), (Predicate) predicate)) == null) {
            return null;
        }
        return new Path(f2).e(a2);
    }

    public T b(Path path, Predicate<? super T> predicate) {
        T t = this.f17055c;
        T t2 = (t == null || !predicate.evaluate(t)) ? null : this.f17055c;
        Iterator<ChildKey> it = path.iterator();
        ImmutableTree<T> immutableTree = this;
        while (it.hasNext()) {
            immutableTree = immutableTree.f17056d.b(it.next());
            if (immutableTree == null) {
                return t2;
            }
            T t3 = immutableTree.f17055c;
            if (t3 != null && predicate.evaluate(t3)) {
                t2 = immutableTree.f17055c;
            }
        }
        return t2;
    }

    public T d(Path path) {
        return b(path, Predicate.f17063a);
    }

    public ImmutableTree<T> d(ChildKey childKey) {
        ImmutableTree<T> b2 = this.f17056d.b(childKey);
        return b2 != null ? b2 : a();
    }

    public ImmutableTree(T t) {
        this(t, f17053a);
    }

    public T c(Path path) {
        if (path.isEmpty()) {
            return this.f17055c;
        }
        ImmutableTree<T> b2 = this.f17056d.b(path.f());
        if (b2 != null) {
            return b2.c(path.g());
        }
        return null;
    }

    public boolean a(Predicate<? super T> predicate) {
        T t = this.f17055c;
        if (t != null && predicate.evaluate(t)) {
            return true;
        }
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.f17056d.iterator();
        while (it.hasNext()) {
            if (it.next().getValue().a(predicate)) {
                return true;
            }
        }
        return false;
    }

    public ImmutableTree<T> a(Path path, T t) {
        if (path.isEmpty()) {
            return new ImmutableTree<>(t, this.f17056d);
        }
        ChildKey f2 = path.f();
        ImmutableTree<T> b2 = this.f17056d.b(f2);
        if (b2 == null) {
            b2 = a();
        }
        return new ImmutableTree<>(this.f17055c, this.f17056d.a(f2, b2.a(path.g(), (Path) t)));
    }

    public Collection<T> e() {
        ArrayList arrayList = new ArrayList();
        a(new c(this, arrayList));
        return arrayList;
    }

    public ImmutableTree<T> a(Path path, ImmutableTree<T> immutableTree) {
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> a2;
        if (path.isEmpty()) {
            return immutableTree;
        }
        ChildKey f2 = path.f();
        ImmutableTree<T> b2 = this.f17056d.b(f2);
        if (b2 == null) {
            b2 = a();
        }
        ImmutableTree<T> a3 = b2.a(path.g(), (ImmutableTree) immutableTree);
        if (a3.isEmpty()) {
            a2 = this.f17056d.remove(f2);
        } else {
            a2 = this.f17056d.a(f2, a3);
        }
        return new ImmutableTree<>(this.f17055c, a2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(TreeVisitor<T, Void> treeVisitor) {
        a(Path.e(), treeVisitor, null);
    }

    public <R> R a(R r, TreeVisitor<? super T, R> treeVisitor) {
        return (R) a(Path.e(), treeVisitor, r);
    }

    private <R> R a(Path path, TreeVisitor<? super T, R> treeVisitor, R r) {
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.f17056d.iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<T>> next = it.next();
            r = (R) next.getValue().a(path.d(next.getKey()), treeVisitor, r);
        }
        Object obj = this.f17055c;
        return obj != null ? treeVisitor.a(path, obj, r) : r;
    }
}
