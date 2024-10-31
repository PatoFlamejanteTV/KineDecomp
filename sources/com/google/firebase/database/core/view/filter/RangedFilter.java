package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.Path;
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
public class RangedFilter implements NodeFilter {

    /* renamed from: a, reason: collision with root package name */
    private final IndexedFilter f17154a;

    /* renamed from: b, reason: collision with root package name */
    private final Index f17155b;

    /* renamed from: c, reason: collision with root package name */
    private final NamedNode f17156c;

    /* renamed from: d, reason: collision with root package name */
    private final NamedNode f17157d;

    public RangedFilter(QueryParams queryParams) {
        this.f17154a = new IndexedFilter(queryParams.a());
        this.f17155b = queryParams.a();
        this.f17156c = b(queryParams);
        this.f17157d = a(queryParams);
    }

    private static NamedNode a(QueryParams queryParams) {
        if (queryParams.i()) {
            return queryParams.a().a(queryParams.b(), queryParams.c());
        }
        return queryParams.a().b();
    }

    private static NamedNode b(QueryParams queryParams) {
        if (queryParams.k()) {
            return queryParams.a().a(queryParams.d(), queryParams.e());
        }
        return queryParams.a().c();
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode a(IndexedNode indexedNode, Node node) {
        return indexedNode;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public boolean b() {
        return true;
    }

    public NamedNode c() {
        return this.f17157d;
    }

    public NamedNode d() {
        return this.f17156c;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public Index getIndex() {
        return this.f17155b;
    }

    public boolean a(NamedNode namedNode) {
        return this.f17155b.compare(d(), namedNode) <= 0 && this.f17155b.compare(namedNode, c()) <= 0;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode a(IndexedNode indexedNode, ChildKey childKey, Node node, Path path, NodeFilter.CompleteChildSource completeChildSource, ChildChangeAccumulator childChangeAccumulator) {
        if (!a(new NamedNode(childKey, node))) {
            node = EmptyNode.e();
        }
        return this.f17154a.a(indexedNode, childKey, node, path, completeChildSource, childChangeAccumulator);
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode a(IndexedNode indexedNode, IndexedNode indexedNode2, ChildChangeAccumulator childChangeAccumulator) {
        IndexedNode indexedNode3;
        if (indexedNode2.e().b()) {
            indexedNode3 = IndexedNode.a(EmptyNode.e(), this.f17155b);
        } else {
            IndexedNode a2 = indexedNode2.a(PriorityUtilities.a());
            Iterator<NamedNode> it = indexedNode2.iterator();
            while (it.hasNext()) {
                NamedNode next = it.next();
                if (!a(next)) {
                    a2 = a2.b(next.c(), EmptyNode.e());
                }
            }
            indexedNode3 = a2;
        }
        return this.f17154a.a(indexedNode, indexedNode3, childChangeAccumulator);
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public NodeFilter a() {
        return this.f17154a;
    }
}
