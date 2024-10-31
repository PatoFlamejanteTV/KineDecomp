package com.google.firebase.database.collection;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
/* loaded from: classes2.dex */
public interface LLRBNode<K, V> {

    /* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
    /* loaded from: classes2.dex */
    public enum Color {
        RED,
        BLACK
    }

    /* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
    /* loaded from: classes2.dex */
    public static abstract class NodeVisitor<K, V> implements ShortCircuitingNodeVisitor<K, V> {
        public abstract void a(K k, V v);
    }

    /* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface ShortCircuitingNodeVisitor<K, V> {
    }

    LLRBNode<K, V> a();

    LLRBNode<K, V> a(K k, V v, Color color, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2);

    LLRBNode<K, V> a(K k, V v, Comparator<K> comparator);

    LLRBNode<K, V> a(K k, Comparator<K> comparator);

    void a(NodeVisitor<K, V> nodeVisitor);

    boolean b();

    LLRBNode<K, V> c();

    LLRBNode<K, V> d();

    LLRBNode<K, V> e();

    K getKey();

    V getValue();

    boolean isEmpty();

    int size();
}
