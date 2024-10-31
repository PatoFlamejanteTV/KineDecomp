package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class LongNode extends LeafNode<LongNode> {

    /* renamed from: c, reason: collision with root package name */
    private final long f17210c;

    public LongNode(Long l, Node node) {
        super(node);
        this.f17210c = l.longValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LongNode)) {
            return false;
        }
        LongNode longNode = (LongNode) obj;
        return this.f17210c == longNode.f17210c && this.f17208a.equals(longNode.f17208a);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return Long.valueOf(this.f17210c);
    }

    public int hashCode() {
        long j = this.f17210c;
        return ((int) (j ^ (j >>> 32))) + this.f17208a.hashCode();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String a(Node.HashVersion hashVersion) {
        return (b(hashVersion) + "number:") + Utilities.a(this.f17210c);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public LongNode a(Node node) {
        return new LongNode(Long.valueOf(this.f17210c), node);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected LeafNode.LeafType a() {
        return LeafNode.LeafType.Number;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.database.snapshot.LeafNode
    public int a(LongNode longNode) {
        return Utilities.a(this.f17210c, longNode.f17210c);
    }
}
