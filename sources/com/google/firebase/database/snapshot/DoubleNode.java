package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class DoubleNode extends LeafNode<DoubleNode> {

    /* renamed from: c, reason: collision with root package name */
    private final Double f17201c;

    public DoubleNode(Double d2, Node node) {
        super(node);
        this.f17201c = d2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DoubleNode)) {
            return false;
        }
        DoubleNode doubleNode = (DoubleNode) obj;
        return this.f17201c.equals(doubleNode.f17201c) && this.f17208a.equals(doubleNode.f17208a);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return this.f17201c;
    }

    public int hashCode() {
        return this.f17201c.hashCode() + this.f17208a.hashCode();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String a(Node.HashVersion hashVersion) {
        return (b(hashVersion) + "number:") + Utilities.a(this.f17201c.doubleValue());
    }

    @Override // com.google.firebase.database.snapshot.Node
    public DoubleNode a(Node node) {
        return new DoubleNode(this.f17201c, node);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected LeafNode.LeafType a() {
        return LeafNode.LeafType.Number;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.database.snapshot.LeafNode
    public int a(DoubleNode doubleNode) {
        return this.f17201c.compareTo(doubleNode.f17201c);
    }
}
