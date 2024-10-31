package com.google.firebase.database.snapshot;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class ValueIndex extends Index {

    /* renamed from: a, reason: collision with root package name */
    private static final ValueIndex f17222a = new ValueIndex();

    private ValueIndex() {
    }

    public static ValueIndex d() {
        return f17222a;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public NamedNode a(ChildKey childKey, Node node) {
        return new NamedNode(childKey, node);
    }

    @Override // com.google.firebase.database.snapshot.Index
    public String a() {
        return ".value";
    }

    @Override // com.google.firebase.database.snapshot.Index
    public boolean a(Node node) {
        return true;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public NamedNode b() {
        return new NamedNode(ChildKey.d(), Node.f17215c);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return obj instanceof ValueIndex;
    }

    public int hashCode() {
        return 4;
    }

    public String toString() {
        return "ValueIndex";
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(NamedNode namedNode, NamedNode namedNode2) {
        int compareTo = namedNode.d().compareTo(namedNode2.d());
        return compareTo == 0 ? namedNode.c().compareTo(namedNode2.c()) : compareTo;
    }
}
