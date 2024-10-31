package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class CompoundHash {

    /* renamed from: a, reason: collision with root package name */
    private final List<Path> f17189a;

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f17190b;

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface SplitStrategy {
        boolean a(a aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: d, reason: collision with root package name */
        private int f17194d;

        /* renamed from: h, reason: collision with root package name */
        private final SplitStrategy f17198h;

        /* renamed from: a, reason: collision with root package name */
        private StringBuilder f17191a = null;

        /* renamed from: b, reason: collision with root package name */
        private Stack<ChildKey> f17192b = new Stack<>();

        /* renamed from: c, reason: collision with root package name */
        private int f17193c = -1;

        /* renamed from: e, reason: collision with root package name */
        private boolean f17195e = true;

        /* renamed from: f, reason: collision with root package name */
        private final List<Path> f17196f = new ArrayList();

        /* renamed from: g, reason: collision with root package name */
        private final List<String> f17197g = new ArrayList();

        public a(SplitStrategy splitStrategy) {
            this.f17198h = splitStrategy;
        }

        private void e() {
            Utilities.a(a(), "Can't end range without starting a range!");
            for (int i = 0; i < this.f17194d; i++) {
                this.f17191a.append(")");
            }
            this.f17191a.append(")");
            Path a2 = a(this.f17193c);
            this.f17197g.add(Utilities.b(this.f17191a.toString()));
            this.f17196f.add(a2);
            this.f17191a = null;
        }

        private void f() {
            if (a()) {
                return;
            }
            this.f17191a = new StringBuilder();
            this.f17191a.append("(");
            Iterator<ChildKey> it = a(this.f17194d).iterator();
            while (it.hasNext()) {
                a(this.f17191a, it.next());
                this.f17191a.append(":(");
            }
            this.f17195e = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            Utilities.a(this.f17194d == 0, "Can't finish hashing in the middle processing a child");
            if (a()) {
                e();
            }
            this.f17197g.add("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            this.f17194d--;
            if (a()) {
                this.f17191a.append(")");
            }
            this.f17195e = true;
        }

        public int b() {
            return this.f17191a.length();
        }

        public Path c() {
            return a(this.f17194d);
        }

        public boolean a() {
            return this.f17191a != null;
        }

        private Path a(int i) {
            ChildKey[] childKeyArr = new ChildKey[i];
            for (int i2 = 0; i2 < i; i2++) {
                childKeyArr[i2] = this.f17192b.get(i2);
            }
            return new Path(childKeyArr);
        }

        private void a(StringBuilder sb, ChildKey childKey) {
            sb.append(Utilities.c(childKey.a()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(LeafNode<?> leafNode) {
            f();
            this.f17193c = this.f17194d;
            this.f17191a.append(leafNode.a(Node.HashVersion.V2));
            this.f17195e = true;
            if (this.f17198h.a(this)) {
                e();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ChildKey childKey) {
            f();
            if (this.f17195e) {
                this.f17191a.append(",");
            }
            a(this.f17191a, childKey);
            this.f17191a.append(":(");
            if (this.f17194d == this.f17192b.size()) {
                this.f17192b.add(childKey);
            } else {
                this.f17192b.set(this.f17194d, childKey);
            }
            this.f17194d++;
            this.f17195e = false;
        }
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    private static class b implements SplitStrategy {

        /* renamed from: a, reason: collision with root package name */
        private final long f17199a;

        public b(Node node) {
            this.f17199a = Math.max(512L, (long) Math.sqrt(NodeSizeEstimator.a(node) * 100));
        }

        @Override // com.google.firebase.database.snapshot.CompoundHash.SplitStrategy
        public boolean a(a aVar) {
            return ((long) aVar.b()) > this.f17199a && (aVar.c().isEmpty() || !aVar.c().d().equals(ChildKey.f()));
        }
    }

    private CompoundHash(List<Path> list, List<String> list2) {
        if (list.size() == list2.size() - 1) {
            this.f17189a = list;
            this.f17190b = list2;
            return;
        }
        throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
    }

    public List<Path> b() {
        return Collections.unmodifiableList(this.f17189a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Node node, a aVar) {
        if (node.b()) {
            aVar.a((LeafNode<?>) node);
            return;
        }
        if (!node.isEmpty()) {
            if (node instanceof ChildrenNode) {
                ((ChildrenNode) node).a((ChildrenNode.ChildVisitor) new d(aVar), true);
                return;
            }
            throw new IllegalStateException("Expected children node, but got: " + node);
        }
        throw new IllegalArgumentException("Can't calculate hash on empty node!");
    }

    public List<String> a() {
        return Collections.unmodifiableList(this.f17190b);
    }

    public static CompoundHash a(Node node) {
        return a(node, new b(node));
    }

    public static CompoundHash a(Node node, SplitStrategy splitStrategy) {
        if (node.isEmpty()) {
            return new CompoundHash(Collections.emptyList(), Collections.singletonList(""));
        }
        a aVar = new a(splitStrategy);
        b(node, aVar);
        aVar.g();
        return new CompoundHash(aVar.f17196f, aVar.f17197g);
    }
}
