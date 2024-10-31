package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
/* loaded from: classes2.dex */
public class LLRBRedValueNode<K, V> extends LLRBValueNode<K, V> {
    public LLRBRedValueNode(K k, V v) {
        super(k, v, LLRBEmptyNode.f(), LLRBEmptyNode.f());
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
        return new LLRBRedValueNode(k, v, lLRBNode, lLRBNode2);
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean b() {
        return true;
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    protected LLRBNode.Color f() {
        return LLRBNode.Color.RED;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public int size() {
        return a().size() + 1 + c().size();
    }

    public LLRBRedValueNode(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        super(k, v, lLRBNode, lLRBNode2);
    }
}
