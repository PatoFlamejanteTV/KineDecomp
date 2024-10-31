package com.google.firebase.database.snapshot;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class KeyIndex extends Index {

    /* renamed from: a, reason: collision with root package name */
    private static final KeyIndex f17207a = new KeyIndex();

    private KeyIndex() {
    }

    public static KeyIndex d() {
        return f17207a;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public NamedNode a(ChildKey childKey, Node node) {
        return new NamedNode(ChildKey.a((String) node.getValue()), EmptyNode.e());
    }

    @Override // com.google.firebase.database.snapshot.Index
    public String a() {
        return ".key";
    }

    @Override // com.google.firebase.database.snapshot.Index
    public boolean a(Node node) {
        return true;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public NamedNode b() {
        return NamedNode.a();
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return obj instanceof KeyIndex;
    }

    public int hashCode() {
        return 37;
    }

    public String toString() {
        return "KeyIndex";
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(NamedNode namedNode, NamedNode namedNode2) {
        return namedNode.c().compareTo(namedNode2.c());
    }
}
