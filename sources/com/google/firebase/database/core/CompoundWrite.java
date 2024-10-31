package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class CompoundWrite implements Iterable<Map.Entry<Path, Node>> {

    /* renamed from: a, reason: collision with root package name */
    private static final CompoundWrite f16834a = new CompoundWrite(new ImmutableTree(null));

    /* renamed from: b, reason: collision with root package name */
    private final ImmutableTree<Node> f16835b;

    private CompoundWrite(ImmutableTree<Node> immutableTree) {
        this.f16835b = immutableTree;
    }

    public static CompoundWrite a(Map<Path, Node> map) {
        ImmutableTree a2 = ImmutableTree.a();
        for (Map.Entry<Path, Node> entry : map.entrySet()) {
            a2 = a2.a(entry.getKey(), new ImmutableTree(entry.getValue()));
        }
        return new CompoundWrite(a2);
    }

    public static CompoundWrite b(Map<String, Object> map) {
        ImmutableTree a2 = ImmutableTree.a();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            a2 = a2.a(new Path(entry.getKey()), new ImmutableTree(NodeUtilities.a(entry.getValue())));
        }
        return new CompoundWrite(a2);
    }

    public static CompoundWrite d() {
        return f16834a;
    }

    public Node c(Path path) {
        Path b2 = this.f16835b.b(path);
        if (b2 != null) {
            return this.f16835b.c(b2).a(Path.a(b2, path));
        }
        return null;
    }

    public CompoundWrite e(Path path) {
        if (path.isEmpty()) {
            return f16834a;
        }
        return new CompoundWrite(this.f16835b.a(path, ImmutableTree.a()));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != CompoundWrite.class) {
            return false;
        }
        return ((CompoundWrite) obj).a(true).equals(a(true));
    }

    public Node f() {
        return this.f16835b.getValue();
    }

    public int hashCode() {
        return a(true).hashCode();
    }

    public boolean isEmpty() {
        return this.f16835b.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<Path, Node>> iterator() {
        return this.f16835b.iterator();
    }

    public String toString() {
        return "CompoundWrite{" + a(true).toString() + "}";
    }

    public boolean d(Path path) {
        return c(path) != null;
    }

    public CompoundWrite a(Path path, CompoundWrite compoundWrite) {
        return (CompoundWrite) compoundWrite.f16835b.a((ImmutableTree<Node>) this, (ImmutableTree.TreeVisitor<? super Node, ImmutableTree<Node>>) new C1586b(this, path));
    }

    public List<NamedNode> e() {
        ArrayList arrayList = new ArrayList();
        if (this.f16835b.getValue() != null) {
            for (NamedNode namedNode : this.f16835b.getValue()) {
                arrayList.add(new NamedNode(namedNode.c(), namedNode.d()));
            }
        } else {
            Iterator<Map.Entry<ChildKey, ImmutableTree<Node>>> it = this.f16835b.d().iterator();
            while (it.hasNext()) {
                Map.Entry<ChildKey, ImmutableTree<Node>> next = it.next();
                ImmutableTree<Node> value = next.getValue();
                if (value.getValue() != null) {
                    arrayList.add(new NamedNode(next.getKey(), value.getValue()));
                }
            }
        }
        return arrayList;
    }

    public Map<ChildKey, CompoundWrite> a() {
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<ChildKey, ImmutableTree<Node>>> it = this.f16835b.d().iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<Node>> next = it.next();
            hashMap.put(next.getKey(), new CompoundWrite(next.getValue()));
        }
        return hashMap;
    }

    public CompoundWrite b(Path path, Node node) {
        if (path.isEmpty()) {
            return new CompoundWrite(new ImmutableTree(node));
        }
        Path b2 = this.f16835b.b(path);
        if (b2 != null) {
            Path a2 = Path.a(b2, path);
            Node c2 = this.f16835b.c(b2);
            ChildKey d2 = a2.d();
            if (d2 != null && d2.i() && c2.a(a2.getParent()).isEmpty()) {
                return this;
            }
            return new CompoundWrite(this.f16835b.a(b2, (Path) c2.a(a2, node)));
        }
        return new CompoundWrite(this.f16835b.a(path, new ImmutableTree<>(node)));
    }

    private Node a(Path path, ImmutableTree<Node> immutableTree, Node node) {
        if (immutableTree.getValue() != null) {
            return node.a(path, immutableTree.getValue());
        }
        Node node2 = null;
        Iterator<Map.Entry<ChildKey, ImmutableTree<Node>>> it = immutableTree.d().iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<Node>> next = it.next();
            ImmutableTree<Node> value = next.getValue();
            ChildKey key = next.getKey();
            if (key.i()) {
                node2 = value.getValue();
            } else {
                node = a(path.d(key), value, node);
            }
        }
        return (node.a(path).isEmpty() || node2 == null) ? node : node.a(path.d(ChildKey.f()), node2);
    }

    public Map<String, Object> a(boolean z) {
        HashMap hashMap = new HashMap();
        this.f16835b.a(new C1587c(this, hashMap, z));
        return hashMap;
    }

    public CompoundWrite b(ChildKey childKey, Node node) {
        return b(new Path(childKey), node);
    }

    public CompoundWrite b(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        Node c2 = c(path);
        if (c2 != null) {
            return new CompoundWrite(new ImmutableTree(c2));
        }
        return new CompoundWrite(this.f16835b.f(path));
    }

    public Node b(Node node) {
        return a(Path.e(), this.f16835b, node);
    }
}
