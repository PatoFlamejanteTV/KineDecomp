package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class IndexedFilter implements NodeFilter {

    /* renamed from: a, reason: collision with root package name */
    private final Index f17149a;

    public IndexedFilter(Index index) {
        this.f17149a = index;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public NodeFilter a() {
        return this;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode a(IndexedNode indexedNode, ChildKey childKey, Node node, Path path, NodeFilter.CompleteChildSource completeChildSource, ChildChangeAccumulator childChangeAccumulator) {
        Node e2 = indexedNode.e();
        Node a2 = e2.a(childKey);
        if (a2.a(path).equals(node.a(path)) && a2.isEmpty() == node.isEmpty()) {
            return indexedNode;
        }
        if (childChangeAccumulator != null) {
            if (node.isEmpty()) {
                if (e2.b(childKey)) {
                    childChangeAccumulator.a(Change.b(childKey, a2));
                }
            } else if (a2.isEmpty()) {
                childChangeAccumulator.a(Change.a(childKey, node));
            } else {
                childChangeAccumulator.a(Change.a(childKey, node, a2));
            }
        }
        return (e2.b() && node.isEmpty()) ? indexedNode : indexedNode.b(childKey, node);
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public boolean b() {
        return false;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public Index getIndex() {
        return this.f17149a;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode a(IndexedNode indexedNode, IndexedNode indexedNode2, ChildChangeAccumulator childChangeAccumulator) {
        if (childChangeAccumulator != null) {
            for (NamedNode namedNode : indexedNode.e()) {
                if (!indexedNode2.e().b(namedNode.c())) {
                    childChangeAccumulator.a(Change.b(namedNode.c(), namedNode.d()));
                }
            }
            if (!indexedNode2.e().b()) {
                for (NamedNode namedNode2 : indexedNode2.e()) {
                    if (indexedNode.e().b(namedNode2.c())) {
                        Node a2 = indexedNode.e().a(namedNode2.c());
                        if (!a2.equals(namedNode2.d())) {
                            childChangeAccumulator.a(Change.a(namedNode2.c(), namedNode2.d(), a2));
                        }
                    } else {
                        childChangeAccumulator.a(Change.a(namedNode2.c(), namedNode2.d()));
                    }
                }
            }
        }
        return indexedNode2;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode a(IndexedNode indexedNode, Node node) {
        return indexedNode.e().isEmpty() ? indexedNode : indexedNode.a(node);
    }
}
