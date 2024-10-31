package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public abstract class LeafNode<T extends LeafNode> implements Node {

    /* renamed from: a */
    protected final Node f17208a;

    /* renamed from: b */
    private String f17209b;

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public enum LeafType {
        DeferredValue,
        Boolean,
        Number,
        String
    }

    public LeafNode(Node node) {
        this.f17208a = node;
    }

    protected abstract int a(T t);

    protected abstract LeafType a();

    @Override // com.google.firebase.database.snapshot.Node
    public Node a(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        if (path.f().i()) {
            return this.f17208a;
        }
        return EmptyNode.e();
    }

    public String b(Node.HashVersion hashVersion) {
        int i = e.f17227a[hashVersion.ordinal()];
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("Unknown hash version: " + hashVersion);
        }
        if (this.f17208a.isEmpty()) {
            return "";
        }
        return "priority:" + this.f17208a.a(hashVersion) + ":";
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean b() {
        return true;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean b(ChildKey childKey) {
        return false;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public ChildKey c(ChildKey childKey) {
        return null;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Iterator<NamedNode> c() {
        return Collections.emptyList().iterator();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public int getChildCount() {
        return 0;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHash() {
        if (this.f17209b == null) {
            this.f17209b = Utilities.b(a(Node.HashVersion.V1));
        }
        return this.f17209b;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node getPriority() {
        return this.f17208a;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<NamedNode> iterator() {
        return Collections.emptyList().iterator();
    }

    public String toString() {
        String obj = a(true).toString();
        if (obj.length() <= 100) {
            return obj;
        }
        return obj.substring(0, 100) + "...";
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node a(Path path, Node node) {
        ChildKey f2 = path.f();
        return f2 == null ? node : (!node.isEmpty() || f2.i()) ? a(f2, EmptyNode.e().a(path.g(), node)) : this;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(Node node) {
        if (node.isEmpty()) {
            return 1;
        }
        if (node instanceof ChildrenNode) {
            return -1;
        }
        if ((this instanceof LongNode) && (node instanceof DoubleNode)) {
            return a((LongNode) this, (DoubleNode) node);
        }
        if ((this instanceof DoubleNode) && (node instanceof LongNode)) {
            return a((LongNode) node, (DoubleNode) this) * (-1);
        }
        return b((LeafNode<?>) node);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node a(ChildKey childKey) {
        if (childKey.i()) {
            return this.f17208a;
        }
        return EmptyNode.e();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object a(boolean z) {
        if (z && !this.f17208a.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put(".value", getValue());
            hashMap.put(".priority", this.f17208a.getValue());
            return hashMap;
        }
        return getValue();
    }

    protected int b(LeafNode<?> leafNode) {
        LeafType a2 = a();
        LeafType a3 = leafNode.a();
        if (a2.equals(a3)) {
            return a((LeafNode<T>) leafNode);
        }
        return a2.compareTo(a3);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node a(ChildKey childKey, Node node) {
        if (childKey.i()) {
            return a(node);
        }
        return node.isEmpty() ? this : EmptyNode.e().a(childKey, node).a(this.f17208a);
    }

    private static int a(LongNode longNode, DoubleNode doubleNode) {
        return Double.valueOf(((Long) longNode.getValue()).longValue()).compareTo((Double) doubleNode.getValue());
    }
}
