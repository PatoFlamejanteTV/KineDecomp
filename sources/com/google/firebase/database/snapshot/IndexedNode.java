package com.google.firebase.database.snapshot;

import com.google.android.gms.common.internal.Objects;
import com.google.firebase.database.collection.ImmutableSortedSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class IndexedNode implements Iterable<NamedNode> {

    /* renamed from: a */
    private static final ImmutableSortedSet<NamedNode> f17203a = new ImmutableSortedSet<>(Collections.emptyList(), null);

    /* renamed from: b */
    private final Node f17204b;

    /* renamed from: c */
    private ImmutableSortedSet<NamedNode> f17205c;

    /* renamed from: d */
    private final Index f17206d;

    private IndexedNode(Node node, Index index) {
        this.f17206d = index;
        this.f17204b = node;
        this.f17205c = null;
    }

    public static IndexedNode a(Node node, Index index) {
        return new IndexedNode(node, index);
    }

    public static IndexedNode b(Node node) {
        return new IndexedNode(node, PriorityIndex.d());
    }

    private void f() {
        if (this.f17205c == null) {
            if (this.f17206d.equals(KeyIndex.d())) {
                this.f17205c = f17203a;
                return;
            }
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (NamedNode namedNode : this.f17204b) {
                z = z || this.f17206d.a(namedNode.d());
                arrayList.add(new NamedNode(namedNode.c(), namedNode.d()));
            }
            if (z) {
                this.f17205c = new ImmutableSortedSet<>(arrayList, this.f17206d);
            } else {
                this.f17205c = f17203a;
            }
        }
    }

    public Iterator<NamedNode> c() {
        f();
        if (Objects.a(this.f17205c, f17203a)) {
            return this.f17204b.c();
        }
        return this.f17205c.c();
    }

    public NamedNode d() {
        if (!(this.f17204b instanceof ChildrenNode)) {
            return null;
        }
        f();
        if (Objects.a(this.f17205c, f17203a)) {
            ChildKey d2 = ((ChildrenNode) this.f17204b).d();
            return new NamedNode(d2, this.f17204b.a(d2));
        }
        return this.f17205c.a();
    }

    public Node e() {
        return this.f17204b;
    }

    @Override // java.lang.Iterable
    public Iterator<NamedNode> iterator() {
        f();
        if (Objects.a(this.f17205c, f17203a)) {
            return this.f17204b.iterator();
        }
        return this.f17205c.iterator();
    }

    public IndexedNode a(Node node) {
        return new IndexedNode(this.f17204b.a(node), this.f17206d, this.f17205c);
    }

    public IndexedNode b(ChildKey childKey, Node node) {
        Node a2 = this.f17204b.a(childKey, node);
        if (Objects.a(this.f17205c, f17203a) && !this.f17206d.a(node)) {
            return new IndexedNode(a2, this.f17206d, f17203a);
        }
        ImmutableSortedSet<NamedNode> immutableSortedSet = this.f17205c;
        if (immutableSortedSet != null && !Objects.a(immutableSortedSet, f17203a)) {
            ImmutableSortedSet<NamedNode> remove = this.f17205c.remove(new NamedNode(childKey, this.f17204b.a(childKey)));
            if (!node.isEmpty()) {
                remove = remove.b(new NamedNode(childKey, node));
            }
            return new IndexedNode(a2, this.f17206d, remove);
        }
        return new IndexedNode(a2, this.f17206d, null);
    }

    public NamedNode a() {
        if (!(this.f17204b instanceof ChildrenNode)) {
            return null;
        }
        f();
        if (Objects.a(this.f17205c, f17203a)) {
            ChildKey a2 = ((ChildrenNode) this.f17204b).a();
            return new NamedNode(a2, this.f17204b.a(a2));
        }
        return this.f17205c.d();
    }

    private IndexedNode(Node node, Index index, ImmutableSortedSet<NamedNode> immutableSortedSet) {
        this.f17206d = index;
        this.f17204b = node;
        this.f17205c = immutableSortedSet;
    }

    public ChildKey a(ChildKey childKey, Node node, Index index) {
        if (!this.f17206d.equals(KeyIndex.d()) && !this.f17206d.equals(index)) {
            throw new IllegalArgumentException("Index not available in IndexedNode!");
        }
        f();
        if (Objects.a(this.f17205c, f17203a)) {
            return this.f17204b.c(childKey);
        }
        NamedNode a2 = this.f17205c.a(new NamedNode(childKey, node));
        if (a2 != null) {
            return a2.c();
        }
        return null;
    }
}
