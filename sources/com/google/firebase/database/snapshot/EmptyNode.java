package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.Node;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class EmptyNode extends ChildrenNode implements Node {

    /* renamed from: e */
    private static final EmptyNode f17202e = new EmptyNode();

    private EmptyNode() {
    }

    public static EmptyNode e() {
        return f17202e;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public EmptyNode a(Node node) {
        return this;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public Node a(Path path) {
        return this;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public Node a(ChildKey childKey) {
        return this;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public Object a(boolean z) {
        return null;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public String a(Node.HashVersion hashVersion) {
        return "";
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, java.lang.Comparable
    /* renamed from: b */
    public int compareTo(Node node) {
        return node.isEmpty() ? 0 : -1;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public boolean b() {
        return false;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public boolean b(ChildKey childKey) {
        return false;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public ChildKey c(ChildKey childKey) {
        return null;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public Iterator<NamedNode> c() {
        return Collections.emptyList().iterator();
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public boolean equals(Object obj) {
        if (obj instanceof EmptyNode) {
            return true;
        }
        if (obj instanceof Node) {
            Node node = (Node) obj;
            if (node.isEmpty() && getPriority().equals(node.getPriority())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public int getChildCount() {
        return 0;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public String getHash() {
        return "";
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public Node getPriority() {
        return this;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return null;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public int hashCode() {
        return 0;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public boolean isEmpty() {
        return true;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, java.lang.Iterable
    public Iterator<NamedNode> iterator() {
        return Collections.emptyList().iterator();
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public String toString() {
        return "<Empty Node>";
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public Node a(ChildKey childKey, Node node) {
        return (node.isEmpty() || childKey.i()) ? this : new ChildrenNode().a(childKey, node);
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode, com.google.firebase.database.snapshot.Node
    public Node a(Path path, Node node) {
        if (path.isEmpty()) {
            return node;
        }
        ChildKey f2 = path.f();
        return a(f2, a(f2).a(path.g(), node));
    }
}
