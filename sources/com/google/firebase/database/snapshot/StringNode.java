package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class StringNode extends LeafNode<StringNode> {

    /* renamed from: c, reason: collision with root package name */
    private final String f17221c;

    public StringNode(String str, Node node) {
        super(node);
        this.f17221c = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StringNode)) {
            return false;
        }
        StringNode stringNode = (StringNode) obj;
        return this.f17221c.equals(stringNode.f17221c) && this.f17208a.equals(stringNode.f17208a);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return this.f17221c;
    }

    public int hashCode() {
        return this.f17221c.hashCode() + this.f17208a.hashCode();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String a(Node.HashVersion hashVersion) {
        int i = g.f17228a[hashVersion.ordinal()];
        if (i == 1) {
            return b(hashVersion) + "string:" + this.f17221c;
        }
        if (i == 2) {
            return b(hashVersion) + "string:" + Utilities.c(this.f17221c);
        }
        throw new IllegalArgumentException("Invalid hash version for string node: " + hashVersion);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public StringNode a(Node node) {
        return new StringNode(this.f17221c, node);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected LeafNode.LeafType a() {
        return LeafNode.LeafType.String;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.database.snapshot.LeafNode
    public int a(StringNode stringNode) {
        return this.f17221c.compareTo(stringNode.f17221c);
    }
}
