package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class RangeMerge {

    /* renamed from: a, reason: collision with root package name */
    private final Path f17218a;

    /* renamed from: b, reason: collision with root package name */
    private final Path f17219b;

    /* renamed from: c, reason: collision with root package name */
    private final Node f17220c;

    public RangeMerge(com.google.firebase.database.connection.RangeMerge rangeMerge) {
        List<String> a2 = rangeMerge.a();
        this.f17218a = a2 != null ? new Path(a2) : null;
        List<String> b2 = rangeMerge.b();
        this.f17219b = b2 != null ? new Path(b2) : null;
        this.f17220c = NodeUtilities.a(rangeMerge.c());
    }

    public Node a(Node node) {
        return a(Path.e(), node, this.f17220c);
    }

    public String toString() {
        return "RangeMerge{optExclusiveStart=" + this.f17218a + ", optInclusiveEnd=" + this.f17219b + ", snap=" + this.f17220c + '}';
    }

    private Node a(Path path, Node node, Node node2) {
        Path path2 = this.f17218a;
        int compareTo = path2 == null ? 1 : path.compareTo(path2);
        Path path3 = this.f17219b;
        int compareTo2 = path3 == null ? -1 : path.compareTo(path3);
        Path path4 = this.f17218a;
        boolean z = false;
        boolean z2 = path4 != null && path.g(path4);
        Path path5 = this.f17219b;
        if (path5 != null && path.g(path5)) {
            z = true;
        }
        if (compareTo > 0 && compareTo2 < 0 && !z) {
            return node2;
        }
        if (compareTo > 0 && z && node2.b()) {
            return node2;
        }
        if (compareTo > 0 && compareTo2 == 0) {
            return node.b() ? EmptyNode.e() : node;
        }
        if (!z2 && !z) {
            return node;
        }
        HashSet hashSet = new HashSet();
        Iterator<NamedNode> it = node.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().c());
        }
        Iterator<NamedNode> it2 = node2.iterator();
        while (it2.hasNext()) {
            hashSet.add(it2.next().c());
        }
        ArrayList<ChildKey> arrayList = new ArrayList(hashSet.size() + 1);
        arrayList.addAll(hashSet);
        if (!node2.getPriority().isEmpty() || !node.getPriority().isEmpty()) {
            arrayList.add(ChildKey.f());
        }
        Node node3 = node;
        for (ChildKey childKey : arrayList) {
            Node a2 = node.a(childKey);
            Node a3 = a(path.d(childKey), node.a(childKey), node2.a(childKey));
            if (a3 != a2) {
                node3 = node3.a(childKey, a3);
            }
        }
        return node3;
    }
}
