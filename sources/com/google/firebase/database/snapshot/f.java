package com.google.firebase.database.snapshot;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class f extends ChildrenNode {
    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public Node a(ChildKey childKey) {
        if (childKey.i()) {
            getPriority();
            return this;
        }
        return EmptyNode.e();
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, java.lang.Comparable
    /* renamed from: b */
    public int compareTo(Node node) {
        return node == this ? 0 : 1;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public boolean b(ChildKey childKey) {
        return false;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public Node getPriority() {
        return this;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public String toString() {
        return "<Max Node>";
    }
}
