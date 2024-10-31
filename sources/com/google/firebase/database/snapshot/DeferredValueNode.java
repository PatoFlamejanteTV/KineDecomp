package com.google.firebase.database.snapshot;

import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class DeferredValueNode extends LeafNode<DeferredValueNode> {

    /* renamed from: c */
    private Map<Object, Object> f17200c;

    public DeferredValueNode(Map<Object, Object> map, Node node) {
        super(node);
        this.f17200c = map;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int a(DeferredValueNode deferredValueNode) {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DeferredValueNode)) {
            return false;
        }
        DeferredValueNode deferredValueNode = (DeferredValueNode) obj;
        return this.f17200c.equals(deferredValueNode.f17200c) && this.f17208a.equals(deferredValueNode.f17208a);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return this.f17200c;
    }

    public int hashCode() {
        return this.f17200c.hashCode() + this.f17208a.hashCode();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String a(Node.HashVersion hashVersion) {
        return b(hashVersion) + "deferredValue:" + this.f17200c;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public DeferredValueNode a(Node node) {
        return new DeferredValueNode(this.f17200c, node);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected LeafNode.LeafType a() {
        return LeafNode.LeafType.DeferredValue;
    }
}
