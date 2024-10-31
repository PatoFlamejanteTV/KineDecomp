package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;
import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
/* loaded from: classes2.dex */
public class LLRBEmptyNode<K, V> implements LLRBNode<K, V> {

    /* renamed from: a */
    private static final LLRBEmptyNode f16699a = new LLRBEmptyNode();

    private LLRBEmptyNode() {
    }

    public static <K, V> LLRBEmptyNode<K, V> f() {
        return f16699a;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> a() {
        return this;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> a(K k, V v, LLRBNode.Color color, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        return this;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> a(K k, V v, Comparator<K> comparator) {
        return new LLRBRedValueNode(k, v);
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> a(K k, Comparator<K> comparator) {
        return this;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public void a(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean b() {
        return false;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> c() {
        return this;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> d() {
        return this;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> e() {
        return this;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public K getKey() {
        return null;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public V getValue() {
        return null;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean isEmpty() {
        return true;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public int size() {
        return 0;
    }
}
