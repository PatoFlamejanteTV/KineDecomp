package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class PathIndex extends Index {

    /* renamed from: a, reason: collision with root package name */
    private final Path f17216a;

    public PathIndex(Path path) {
        if (path.size() == 1 && path.f().i()) {
            throw new IllegalArgumentException("Can't create PathIndex with '.priority' as key. Please use PriorityIndex instead!");
        }
        this.f17216a = path;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public boolean a(Node node) {
        return !node.a(this.f17216a).isEmpty();
    }

    @Override // com.google.firebase.database.snapshot.Index
    public NamedNode b() {
        return new NamedNode(ChildKey.d(), EmptyNode.e().a(this.f17216a, Node.f17215c));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && PathIndex.class == obj.getClass() && this.f17216a.equals(((PathIndex) obj).f17216a);
    }

    public int hashCode() {
        return this.f17216a.hashCode();
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(NamedNode namedNode, NamedNode namedNode2) {
        int compareTo = namedNode.d().a(this.f17216a).compareTo(namedNode2.d().a(this.f17216a));
        return compareTo == 0 ? namedNode.c().compareTo(namedNode2.c()) : compareTo;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public NamedNode a(ChildKey childKey, Node node) {
        return new NamedNode(childKey, EmptyNode.e().a(this.f17216a, node));
    }

    @Override // com.google.firebase.database.snapshot.Index
    public String a() {
        return this.f17216a.h();
    }
}
