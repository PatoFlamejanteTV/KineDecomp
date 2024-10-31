package com.google.firebase.database.snapshot;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class ChildrenNode implements Node {

    /* renamed from: a, reason: collision with root package name */
    public static Comparator<ChildKey> f17184a = new b();

    /* renamed from: b, reason: collision with root package name */
    private final ImmutableSortedMap<ChildKey, Node> f17185b;

    /* renamed from: c, reason: collision with root package name */
    private final Node f17186c;

    /* renamed from: d, reason: collision with root package name */
    private String f17187d;

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static abstract class ChildVisitor extends LLRBNode.NodeVisitor<ChildKey, Node> {
        /* JADX WARN: Can't rename method to resolve collision */
        public abstract void a(ChildKey childKey, Node node);

        @Override // com.google.firebase.database.collection.LLRBNode.NodeVisitor
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ChildKey childKey, Node node) {
            a(childKey, node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class a implements Iterator<NamedNode> {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<Map.Entry<ChildKey, Node>> f17188a;

        public a(Iterator<Map.Entry<ChildKey, Node>> it) {
            this.f17188a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f17188a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f17188a.remove();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public NamedNode next() {
            Map.Entry<ChildKey, Node> next = this.f17188a.next();
            return new NamedNode(next.getKey(), next.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ChildrenNode() {
        this.f17187d = null;
        this.f17185b = ImmutableSortedMap.Builder.a((Comparator) f17184a);
        this.f17186c = PriorityUtilities.a();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object a(boolean z) {
        Integer d2;
        if (isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<ChildKey, Node>> it = this.f17185b.iterator();
        int i = 0;
        boolean z2 = true;
        int i2 = 0;
        while (it.hasNext()) {
            Map.Entry<ChildKey, Node> next = it.next();
            String a2 = next.getKey().a();
            hashMap.put(a2, next.getValue().a(z));
            i++;
            if (z2) {
                if ((a2.length() > 1 && a2.charAt(0) == '0') || (d2 = Utilities.d(a2)) == null || d2.intValue() < 0) {
                    z2 = false;
                } else if (d2.intValue() > i2) {
                    i2 = d2.intValue();
                }
            }
        }
        if (!z && z2 && i2 < i * 2) {
            ArrayList arrayList = new ArrayList(i2 + 1);
            for (int i3 = 0; i3 <= i2; i3++) {
                arrayList.add(hashMap.get("" + i3));
            }
            return arrayList;
        }
        if (z && !this.f17186c.isEmpty()) {
            hashMap.put(".priority", this.f17186c.getValue());
        }
        return hashMap;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean b() {
        return false;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean b(ChildKey childKey) {
        return !a(childKey).isEmpty();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public ChildKey c(ChildKey childKey) {
        return this.f17185b.c(childKey);
    }

    public ChildKey d() {
        return this.f17185b.d();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChildrenNode)) {
            return false;
        }
        ChildrenNode childrenNode = (ChildrenNode) obj;
        if (!getPriority().equals(childrenNode.getPriority()) || this.f17185b.size() != childrenNode.f17185b.size()) {
            return false;
        }
        Iterator<Map.Entry<ChildKey, Node>> it = this.f17185b.iterator();
        Iterator<Map.Entry<ChildKey, Node>> it2 = childrenNode.f17185b.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<ChildKey, Node> next = it.next();
            Map.Entry<ChildKey, Node> next2 = it2.next();
            if (!next.getKey().equals(next2.getKey()) || !next.getValue().equals(next2.getValue())) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            throw new IllegalStateException("Something went wrong internally.");
        }
        return true;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public int getChildCount() {
        return this.f17185b.size();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHash() {
        if (this.f17187d == null) {
            String a2 = a(Node.HashVersion.V1);
            this.f17187d = a2.isEmpty() ? "" : Utilities.b(a2);
        }
        return this.f17187d;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node getPriority() {
        return this.f17186c;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return a(false);
    }

    public int hashCode() {
        Iterator<NamedNode> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            NamedNode next = it.next();
            i = (((i * 31) + next.c().hashCode()) * 17) + next.d().hashCode();
        }
        return i;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean isEmpty() {
        return this.f17185b.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<NamedNode> iterator() {
        return new a(this.f17185b.iterator());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b(sb, 0);
        return sb.toString();
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Node node) {
        if (isEmpty()) {
            return node.isEmpty() ? 0 : -1;
        }
        if (node.b() || node.isEmpty()) {
            return 1;
        }
        return node == Node.f17215c ? -1 : 0;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Iterator<NamedNode> c() {
        return new a(this.f17185b.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ChildrenNode(ImmutableSortedMap<ChildKey, Node> immutableSortedMap, Node node) {
        this.f17187d = null;
        if (immutableSortedMap.isEmpty() && !node.isEmpty()) {
            throw new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
        }
        this.f17186c = node;
        this.f17185b = immutableSortedMap;
    }

    private void b(StringBuilder sb, int i) {
        if (this.f17185b.isEmpty() && this.f17186c.isEmpty()) {
            sb.append("{ }");
            return;
        }
        sb.append("{\n");
        Iterator<Map.Entry<ChildKey, Node>> it = this.f17185b.iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, Node> next = it.next();
            int i2 = i + 2;
            a(sb, i2);
            sb.append(next.getKey().a());
            sb.append("=");
            if (next.getValue() instanceof ChildrenNode) {
                ((ChildrenNode) next.getValue()).b(sb, i2);
            } else {
                sb.append(next.getValue().toString());
            }
            sb.append("\n");
        }
        if (!this.f17186c.isEmpty()) {
            a(sb, i + 2);
            sb.append(".priority=");
            sb.append(this.f17186c.toString());
            sb.append("\n");
        }
        a(sb, i);
        sb.append("}");
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String a(Node.HashVersion hashVersion) {
        boolean z;
        if (hashVersion == Node.HashVersion.V1) {
            StringBuilder sb = new StringBuilder();
            if (!this.f17186c.isEmpty()) {
                sb.append("priority:");
                sb.append(this.f17186c.a(Node.HashVersion.V1));
                sb.append(":");
            }
            ArrayList<NamedNode> arrayList = new ArrayList();
            Iterator<NamedNode> it = iterator();
            loop0: while (true) {
                while (it.hasNext()) {
                    NamedNode next = it.next();
                    arrayList.add(next);
                    z = z || !next.d().getPriority().isEmpty();
                }
            }
            if (z) {
                Collections.sort(arrayList, PriorityIndex.d());
            }
            for (NamedNode namedNode : arrayList) {
                String hash = namedNode.d().getHash();
                if (!hash.equals("")) {
                    sb.append(":");
                    sb.append(namedNode.c().a());
                    sb.append(":");
                    sb.append(hash);
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Hashes on children nodes only supported for V1");
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node a(Node node) {
        if (this.f17185b.isEmpty()) {
            return EmptyNode.e();
        }
        return new ChildrenNode(this.f17185b, node);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node a(ChildKey childKey) {
        if (childKey.i() && !this.f17186c.isEmpty()) {
            return this.f17186c;
        }
        if (this.f17185b.a((ImmutableSortedMap<ChildKey, Node>) childKey)) {
            return this.f17185b.b(childKey);
        }
        return EmptyNode.e();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node a(Path path) {
        ChildKey f2 = path.f();
        return f2 == null ? this : a(f2).a(path.g());
    }

    public void a(ChildVisitor childVisitor) {
        a(childVisitor, false);
    }

    public void a(ChildVisitor childVisitor, boolean z) {
        if (z && !getPriority().isEmpty()) {
            this.f17185b.a(new c(this, childVisitor));
        } else {
            this.f17185b.a(childVisitor);
        }
    }

    public ChildKey a() {
        return this.f17185b.e();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node a(Path path, Node node) {
        ChildKey f2 = path.f();
        if (f2 == null) {
            return node;
        }
        if (f2.i()) {
            return a(node);
        }
        return a(f2, a(f2).a(path.g(), node));
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Node a(ChildKey childKey, Node node) {
        if (childKey.i()) {
            return a(node);
        }
        ImmutableSortedMap<ChildKey, Node> immutableSortedMap = this.f17185b;
        if (immutableSortedMap.a((ImmutableSortedMap<ChildKey, Node>) childKey)) {
            immutableSortedMap = immutableSortedMap.remove(childKey);
        }
        if (!node.isEmpty()) {
            immutableSortedMap = immutableSortedMap.a(childKey, node);
        }
        if (immutableSortedMap.isEmpty()) {
            return EmptyNode.e();
        }
        return new ChildrenNode(immutableSortedMap, this.f17186c);
    }

    private static void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(" ");
        }
    }
}
