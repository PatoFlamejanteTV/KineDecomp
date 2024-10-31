package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.Predicate;
import com.google.firebase.database.snapshot.ChildKey;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class PruneForest {

    /* renamed from: a */
    private static final Predicate<Boolean> f17019a = new b();

    /* renamed from: b */
    private static final Predicate<Boolean> f17020b = new c();

    /* renamed from: c */
    private static final ImmutableTree<Boolean> f17021c = new ImmutableTree<>(true);

    /* renamed from: d */
    private static final ImmutableTree<Boolean> f17022d = new ImmutableTree<>(false);

    /* renamed from: e */
    private final ImmutableTree<Boolean> f17023e;

    public PruneForest() {
        this.f17023e = ImmutableTree.a();
    }

    public boolean a() {
        return this.f17023e.a(f17020b);
    }

    public PruneForest b(Path path) {
        if (this.f17023e.c(path, f17019a) == null) {
            return this.f17023e.c(path, f17020b) != null ? this : new PruneForest(this.f17023e.a(path, f17021c));
        }
        throw new IllegalArgumentException("Can't prune path that was kept previously!");
    }

    public boolean c(Path path) {
        Boolean d2 = this.f17023e.d(path);
        return (d2 == null || d2.booleanValue()) ? false : true;
    }

    public boolean d(Path path) {
        Boolean d2 = this.f17023e.d(path);
        return d2 != null && d2.booleanValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PruneForest) && this.f17023e.equals(((PruneForest) obj).f17023e);
    }

    public int hashCode() {
        return this.f17023e.hashCode();
    }

    public String toString() {
        return "{PruneForest:" + this.f17023e.toString() + "}";
    }

    public PruneForest a(ChildKey childKey) {
        ImmutableTree<Boolean> d2 = this.f17023e.d(childKey);
        if (d2 == null) {
            d2 = new ImmutableTree<>(this.f17023e.getValue());
        } else if (d2.getValue() == null && this.f17023e.getValue() != null) {
            d2 = d2.a(Path.e(), (Path) this.f17023e.getValue());
        }
        return new PruneForest(d2);
    }

    private PruneForest(ImmutableTree<Boolean> immutableTree) {
        this.f17023e = immutableTree;
    }

    public <T> T a(T t, ImmutableTree.TreeVisitor<Void, T> treeVisitor) {
        return (T) this.f17023e.a((ImmutableTree<Boolean>) t, (ImmutableTree.TreeVisitor<? super Boolean, ImmutableTree<Boolean>>) new d(this, treeVisitor));
    }

    public PruneForest a(Path path) {
        return this.f17023e.c(path, f17019a) != null ? this : new PruneForest(this.f17023e.a(path, f17022d));
    }
}
