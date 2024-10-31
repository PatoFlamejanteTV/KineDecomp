package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
/* loaded from: classes2.dex */
public class LLRBBlackValueNode<K, V> extends LLRBValueNode<K, V> {

    /* renamed from: e */
    private int f16698e;

    public LLRBBlackValueNode(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        super(k, v, lLRBNode, lLRBNode2);
        this.f16698e = -1;
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    public void a(LLRBNode<K, V> lLRBNode) {
        if (this.f16698e == -1) {
            super.a(lLRBNode);
            return;
        }
        throw new IllegalStateException("Can't set left after using size");
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean b() {
        return false;
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    protected LLRBNode.Color f() {
        return LLRBNode.Color.BLACK;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public int size() {
        if (this.f16698e == -1) {
            this.f16698e = a().size() + 1 + c().size();
        }
        return this.f16698e;
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    protected LLRBValueNode<K, V> a(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        if (k == null) {
            k = getKey();
        }
        if (v == null) {
            v = getValue();
        }
        if (lLRBNode == null) {
            lLRBNode = a();
        }
        if (lLRBNode2 == null) {
            lLRBNode2 = c();
        }
        return new LLRBBlackValueNode(k, v, lLRBNode, lLRBNode2);
    }
}
