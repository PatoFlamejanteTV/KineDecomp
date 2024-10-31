package com.google.firebase.database.core;

import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class WriteTreeRef {

    /* renamed from: a, reason: collision with root package name */
    private final Path f16961a;

    /* renamed from: b, reason: collision with root package name */
    private final WriteTree f16962b;

    public WriteTreeRef(Path path, WriteTree writeTree) {
        this.f16961a = path;
        this.f16962b = writeTree;
    }

    public Node a(Node node) {
        return a(node, Collections.emptyList());
    }

    public Node b(Node node) {
        return this.f16962b.a(this.f16961a, node);
    }

    public Node a(Node node, List<Long> list) {
        return a(node, list, false);
    }

    public Node a(Node node, List<Long> list, boolean z) {
        return this.f16962b.a(this.f16961a, node, list, z);
    }

    public Node a(Path path, Node node, Node node2) {
        return this.f16962b.a(this.f16961a, path, node, node2);
    }

    public Node a(Path path) {
        return this.f16962b.b(this.f16961a.e(path));
    }

    public NamedNode a(Node node, NamedNode namedNode, boolean z, Index index) {
        return this.f16962b.a(this.f16961a, node, namedNode, z, index);
    }

    public Node a(ChildKey childKey, CacheNode cacheNode) {
        return this.f16962b.a(this.f16961a, childKey, cacheNode);
    }

    public WriteTreeRef a(ChildKey childKey) {
        return new WriteTreeRef(this.f16961a.d(childKey), this.f16962b);
    }
}
