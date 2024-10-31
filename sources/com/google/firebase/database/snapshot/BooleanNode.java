package com.google.firebase.database.snapshot;

import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class BooleanNode extends LeafNode<BooleanNode> {

    /* renamed from: c */
    private final boolean f17177c;

    public BooleanNode(Boolean bool, Node node) {
        super(node);
        this.f17177c = bool.booleanValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BooleanNode)) {
            return false;
        }
        BooleanNode booleanNode = (BooleanNode) obj;
        return this.f17177c == booleanNode.f17177c && this.f17208a.equals(booleanNode.f17208a);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return Boolean.valueOf(this.f17177c);
    }

    public int hashCode() {
        boolean z = this.f17177c;
        return (z ? 1 : 0) + this.f17208a.hashCode();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String a(Node.HashVersion hashVersion) {
        return b(hashVersion) + "boolean:" + this.f17177c;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public BooleanNode a(Node node) {
        return new BooleanNode(Boolean.valueOf(this.f17177c), node);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected LeafNode.LeafType a() {
        return LeafNode.LeafType.Boolean;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int a(BooleanNode booleanNode) {
        boolean z = this.f17177c;
        if (z == booleanNode.f17177c) {
            return 0;
        }
        return z ? 1 : -1;
    }
}
