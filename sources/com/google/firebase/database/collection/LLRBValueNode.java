package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;
import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
/* loaded from: classes2.dex */
public abstract class LLRBValueNode<K, V> implements LLRBNode<K, V> {

    /* renamed from: a */
    private final K f16700a;

    /* renamed from: b */
    private final V f16701b;

    /* renamed from: c */
    private LLRBNode<K, V> f16702c;

    /* renamed from: d */
    private final LLRBNode<K, V> f16703d;

    public LLRBValueNode(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        this.f16700a = k;
        this.f16701b = v;
        this.f16702c = lLRBNode == null ? LLRBEmptyNode.f() : lLRBNode;
        this.f16703d = lLRBNode2 == null ? LLRBEmptyNode.f() : lLRBNode2;
    }

    private static LLRBNode.Color b(LLRBNode lLRBNode) {
        return lLRBNode.b() ? LLRBNode.Color.BLACK : LLRBNode.Color.RED;
    }

    private LLRBValueNode<K, V> g() {
        LLRBNode<K, V> lLRBNode = this.f16702c;
        LLRBNode<K, V> a2 = lLRBNode.a(null, null, b(lLRBNode), null, null);
        LLRBNode<K, V> lLRBNode2 = this.f16703d;
        return a((LLRBValueNode<K, V>) null, (K) null, b(this), (LLRBNode<LLRBValueNode<K, V>, K>) a2, (LLRBNode<LLRBValueNode<K, V>, K>) lLRBNode2.a(null, null, b(lLRBNode2), null, null));
    }

    private LLRBValueNode<K, V> h() {
        LLRBValueNode<K, V> l = (!this.f16703d.b() || this.f16702c.b()) ? this : l();
        if (l.f16702c.b() && ((LLRBValueNode) l.f16702c).f16702c.b()) {
            l = l.m();
        }
        return (l.f16702c.b() && l.f16703d.b()) ? l.g() : l;
    }

    private LLRBValueNode<K, V> i() {
        LLRBValueNode<K, V> g2 = g();
        return g2.c().a().b() ? g2.a(null, null, null, ((LLRBValueNode) g2.c()).m()).l().g() : g2;
    }

    private LLRBValueNode<K, V> j() {
        LLRBValueNode<K, V> g2 = g();
        return g2.a().a().b() ? g2.m().g() : g2;
    }

    private LLRBNode<K, V> k() {
        if (this.f16702c.isEmpty()) {
            return LLRBEmptyNode.f();
        }
        LLRBValueNode<K, V> i = (a().b() || a().a().b()) ? this : i();
        return i.a(null, null, ((LLRBValueNode) i.f16702c).k(), null).h();
    }

    private LLRBValueNode<K, V> l() {
        return (LLRBValueNode) this.f16703d.a(null, null, f(), a((LLRBValueNode<K, V>) null, (K) null, LLRBNode.Color.RED, (LLRBNode<LLRBValueNode<K, V>, K>) null, (LLRBNode<LLRBValueNode<K, V>, K>) ((LLRBValueNode) this.f16703d).f16702c), null);
    }

    private LLRBValueNode<K, V> m() {
        return (LLRBValueNode) this.f16702c.a(null, null, f(), null, a((LLRBValueNode<K, V>) null, (K) null, LLRBNode.Color.RED, (LLRBNode<LLRBValueNode<K, V>, K>) ((LLRBValueNode) this.f16702c).f16703d, (LLRBNode<LLRBValueNode<K, V>, K>) null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.database.collection.LLRBNode
    public /* bridge */ /* synthetic */ LLRBNode a(Object obj, Object obj2, LLRBNode.Color color, LLRBNode lLRBNode, LLRBNode lLRBNode2) {
        return a((LLRBValueNode<K, V>) obj, obj2, color, (LLRBNode<LLRBValueNode<K, V>, Object>) lLRBNode, (LLRBNode<LLRBValueNode<K, V>, Object>) lLRBNode2);
    }

    protected abstract LLRBValueNode<K, V> a(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2);

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> c() {
        return this.f16703d;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> d() {
        return this.f16702c.isEmpty() ? this : this.f16702c.d();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> e() {
        return this.f16703d.isEmpty() ? this : this.f16703d.e();
    }

    protected abstract LLRBNode.Color f();

    @Override // com.google.firebase.database.collection.LLRBNode
    public K getKey() {
        return this.f16700a;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public V getValue() {
        return this.f16701b;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> a() {
        return this.f16702c;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBValueNode<K, V> a(K k, V v, LLRBNode.Color color, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        if (k == null) {
            k = this.f16700a;
        }
        if (v == null) {
            v = this.f16701b;
        }
        if (lLRBNode == null) {
            lLRBNode = this.f16702c;
        }
        if (lLRBNode2 == null) {
            lLRBNode2 = this.f16703d;
        }
        if (color == LLRBNode.Color.RED) {
            return new LLRBRedValueNode(k, v, lLRBNode, lLRBNode2);
        }
        return new LLRBBlackValueNode(k, v, lLRBNode, lLRBNode2);
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> a(K k, V v, Comparator<K> comparator) {
        LLRBValueNode<K, V> a2;
        int compare = comparator.compare(k, this.f16700a);
        if (compare < 0) {
            a2 = a(null, null, this.f16702c.a(k, v, comparator), null);
        } else if (compare == 0) {
            a2 = a(k, v, null, null);
        } else {
            a2 = a(null, null, null, this.f16703d.a(k, v, comparator));
        }
        return a2.h();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> a(K k, Comparator<K> comparator) {
        LLRBValueNode<K, V> a2;
        if (comparator.compare(k, this.f16700a) < 0) {
            LLRBValueNode<K, V> i = (this.f16702c.isEmpty() || this.f16702c.b() || ((LLRBValueNode) this.f16702c).f16702c.b()) ? this : i();
            a2 = i.a(null, null, i.f16702c.a(k, comparator), null);
        } else {
            LLRBValueNode<K, V> m = this.f16702c.b() ? m() : this;
            if (!m.f16703d.isEmpty() && !m.f16703d.b() && !((LLRBValueNode) m.f16703d).f16702c.b()) {
                m = m.j();
            }
            if (comparator.compare(k, m.f16700a) == 0) {
                if (m.f16703d.isEmpty()) {
                    return LLRBEmptyNode.f();
                }
                LLRBNode<K, V> d2 = m.f16703d.d();
                m = m.a(d2.getKey(), d2.getValue(), null, ((LLRBValueNode) m.f16703d).k());
            }
            a2 = m.a(null, null, null, m.f16703d.a(k, comparator));
        }
        return a2.h();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public void a(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        this.f16702c.a(nodeVisitor);
        nodeVisitor.a(this.f16700a, this.f16701b);
        this.f16703d.a(nodeVisitor);
    }

    public void a(LLRBNode<K, V> lLRBNode) {
        this.f16702c = lLRBNode;
    }
}
