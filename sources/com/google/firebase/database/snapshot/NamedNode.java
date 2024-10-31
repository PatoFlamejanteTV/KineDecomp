package com.google.firebase.database.snapshot;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class NamedNode {

    /* renamed from: a, reason: collision with root package name */
    private static final NamedNode f17211a = new NamedNode(ChildKey.e(), EmptyNode.e());

    /* renamed from: b, reason: collision with root package name */
    private static final NamedNode f17212b = new NamedNode(ChildKey.d(), Node.f17215c);

    /* renamed from: c, reason: collision with root package name */
    private final ChildKey f17213c;

    /* renamed from: d, reason: collision with root package name */
    private final Node f17214d;

    public NamedNode(ChildKey childKey, Node node) {
        this.f17213c = childKey;
        this.f17214d = node;
    }

    public static NamedNode a() {
        return f17212b;
    }

    public static NamedNode b() {
        return f17211a;
    }

    public ChildKey c() {
        return this.f17213c;
    }

    public Node d() {
        return this.f17214d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NamedNode.class != obj.getClass()) {
            return false;
        }
        NamedNode namedNode = (NamedNode) obj;
        return this.f17213c.equals(namedNode.f17213c) && this.f17214d.equals(namedNode.f17214d);
    }

    public int hashCode() {
        return (this.f17213c.hashCode() * 31) + this.f17214d.hashCode();
    }

    public String toString() {
        return "NamedNode{name=" + this.f17213c + ", node=" + this.f17214d + '}';
    }
}
