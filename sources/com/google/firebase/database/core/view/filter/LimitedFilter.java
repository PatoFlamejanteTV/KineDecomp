package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class LimitedFilter implements NodeFilter {

    /* renamed from: a, reason: collision with root package name */
    private final RangedFilter f17150a;

    /* renamed from: b, reason: collision with root package name */
    private final Index f17151b;

    /* renamed from: c, reason: collision with root package name */
    private final int f17152c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f17153d;

    public LimitedFilter(QueryParams queryParams) {
        this.f17150a = new RangedFilter(queryParams);
        this.f17151b = queryParams.a();
        this.f17152c = queryParams.f();
        this.f17153d = !queryParams.m();
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode a(IndexedNode indexedNode, ChildKey childKey, Node node, Path path, NodeFilter.CompleteChildSource completeChildSource, ChildChangeAccumulator childChangeAccumulator) {
        if (!this.f17150a.a(new NamedNode(childKey, node))) {
            node = EmptyNode.e();
        }
        Node node2 = node;
        if (indexedNode.e().a(childKey).equals(node2)) {
            return indexedNode;
        }
        if (indexedNode.e().getChildCount() < this.f17152c) {
            return this.f17150a.a().a(indexedNode, childKey, node2, path, completeChildSource, childChangeAccumulator);
        }
        return a(indexedNode, childKey, node2, completeChildSource, childChangeAccumulator);
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode a(IndexedNode indexedNode, Node node) {
        return indexedNode;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public boolean b() {
        return true;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public Index getIndex() {
        return this.f17151b;
    }

    private IndexedNode a(IndexedNode indexedNode, ChildKey childKey, Node node, NodeFilter.CompleteChildSource completeChildSource, ChildChangeAccumulator childChangeAccumulator) {
        NamedNode namedNode = new NamedNode(childKey, node);
        NamedNode a2 = this.f17153d ? indexedNode.a() : indexedNode.d();
        boolean a3 = this.f17150a.a(namedNode);
        if (indexedNode.e().b(childKey)) {
            Node a4 = indexedNode.e().a(childKey);
            NamedNode a5 = completeChildSource.a(this.f17151b, a2, this.f17153d);
            while (a5 != null && (a5.c().equals(childKey) || indexedNode.e().b(a5.c()))) {
                a5 = completeChildSource.a(this.f17151b, a5, this.f17153d);
            }
            if (a3 && !node.isEmpty() && (a5 == null ? 1 : this.f17151b.a(a5, namedNode, this.f17153d)) >= 0) {
                if (childChangeAccumulator != null) {
                    childChangeAccumulator.a(Change.a(childKey, node, a4));
                }
                return indexedNode.b(childKey, node);
            }
            if (childChangeAccumulator != null) {
                childChangeAccumulator.a(Change.b(childKey, a4));
            }
            IndexedNode b2 = indexedNode.b(childKey, EmptyNode.e());
            if (!(a5 != null && this.f17150a.a(a5))) {
                return b2;
            }
            if (childChangeAccumulator != null) {
                childChangeAccumulator.a(Change.a(a5.c(), a5.d()));
            }
            return b2.b(a5.c(), a5.d());
        }
        if (node.isEmpty() || !a3 || this.f17151b.a(a2, namedNode, this.f17153d) < 0) {
            return indexedNode;
        }
        if (childChangeAccumulator != null) {
            childChangeAccumulator.a(Change.b(a2.c(), a2.d()));
            childChangeAccumulator.a(Change.a(childKey, node));
        }
        return indexedNode.b(childKey, node).b(a2.c(), EmptyNode.e());
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode a(IndexedNode indexedNode, IndexedNode indexedNode2, ChildChangeAccumulator childChangeAccumulator) {
        IndexedNode a2;
        Iterator<NamedNode> it;
        NamedNode d2;
        NamedNode c2;
        int i;
        if (!indexedNode2.e().b() && !indexedNode2.e().isEmpty()) {
            a2 = indexedNode2.a(PriorityUtilities.a());
            if (this.f17153d) {
                it = indexedNode2.c();
                d2 = this.f17150a.c();
                c2 = this.f17150a.d();
                i = -1;
            } else {
                it = indexedNode2.iterator();
                d2 = this.f17150a.d();
                c2 = this.f17150a.c();
                i = 1;
            }
            boolean z = false;
            int i2 = 0;
            while (it.hasNext()) {
                NamedNode next = it.next();
                if (!z && this.f17151b.compare(d2, next) * i <= 0) {
                    z = true;
                }
                if (z && i2 < this.f17152c && this.f17151b.compare(next, c2) * i <= 0) {
                    i2++;
                } else {
                    a2 = a2.b(next.c(), EmptyNode.e());
                }
            }
        } else {
            a2 = IndexedNode.a(EmptyNode.e(), this.f17151b);
        }
        return this.f17150a.a().a(indexedNode, a2, childChangeAccumulator);
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public NodeFilter a() {
        return this.f17150a.a();
    }
}
