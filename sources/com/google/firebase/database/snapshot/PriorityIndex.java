package com.google.firebase.database.snapshot;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class PriorityIndex extends Index {

    /* renamed from: a, reason: collision with root package name */
    private static final PriorityIndex f17217a = new PriorityIndex();

    private PriorityIndex() {
    }

    public static PriorityIndex d() {
        return f17217a;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(NamedNode namedNode, NamedNode namedNode2) {
        return NodeUtilities.a(namedNode.c(), namedNode.d().getPriority(), namedNode2.c(), namedNode2.d().getPriority());
    }

    @Override // com.google.firebase.database.snapshot.Index
    public NamedNode b() {
        return a(ChildKey.d(), Node.f17215c);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return obj instanceof PriorityIndex;
    }

    public int hashCode() {
        return 3155577;
    }

    public String toString() {
        return "PriorityIndex";
    }

    @Override // com.google.firebase.database.snapshot.Index
    public boolean a(Node node) {
        return !node.getPriority().isEmpty();
    }

    @Override // com.google.firebase.database.snapshot.Index
    public NamedNode a(ChildKey childKey, Node node) {
        return new NamedNode(childKey, new StringNode("[PRIORITY-POST]", node));
    }

    @Override // com.google.firebase.database.snapshot.Index
    public String a() {
        throw new IllegalArgumentException("Can't get query definition on priority index!");
    }
}
