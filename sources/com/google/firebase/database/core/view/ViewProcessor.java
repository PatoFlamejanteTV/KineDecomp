package com.google.firebase.database.core.view;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.view.filter.ChildChangeAccumulator;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.KeyIndex;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class ViewProcessor {

    /* renamed from: a, reason: collision with root package name */
    private static NodeFilter.CompleteChildSource f17136a = new d();

    /* renamed from: b, reason: collision with root package name */
    private final NodeFilter f17137b;

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class ProcessorResult {

        /* renamed from: a, reason: collision with root package name */
        public final ViewCache f17138a;

        /* renamed from: b, reason: collision with root package name */
        public final List<Change> f17139b;

        public ProcessorResult(ViewCache viewCache, List<Change> list) {
            this.f17138a = viewCache;
            this.f17139b = list;
        }
    }

    public ViewProcessor(NodeFilter nodeFilter) {
        this.f17137b = nodeFilter;
    }

    private ViewCache b(ViewCache viewCache, Path path, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        CacheNode d2 = viewCache.d();
        return a(viewCache.b(d2.a(), d2.d() || path.isEmpty(), d2.c()), path, writeTreeRef, f17136a, childChangeAccumulator);
    }

    public ProcessorResult a(ViewCache viewCache, Operation operation, WriteTreeRef writeTreeRef, Node node) {
        ViewCache a2;
        ChildChangeAccumulator childChangeAccumulator = new ChildChangeAccumulator();
        int i = e.f17147a[operation.c().ordinal()];
        if (i == 1) {
            Overwrite overwrite = (Overwrite) operation;
            if (overwrite.b().c()) {
                a2 = a(viewCache, overwrite.a(), overwrite.d(), writeTreeRef, node, childChangeAccumulator);
            } else {
                a2 = a(viewCache, overwrite.a(), overwrite.d(), writeTreeRef, node, overwrite.b().d() || (viewCache.d().c() && !overwrite.a().isEmpty()), childChangeAccumulator);
            }
        } else if (i == 2) {
            Merge merge = (Merge) operation;
            if (merge.b().c()) {
                a2 = a(viewCache, merge.a(), merge.d(), writeTreeRef, node, childChangeAccumulator);
            } else {
                a2 = a(viewCache, merge.a(), merge.d(), writeTreeRef, node, merge.b().d() || viewCache.d().c(), childChangeAccumulator);
            }
        } else if (i == 3) {
            AckUserWrite ackUserWrite = (AckUserWrite) operation;
            if (!ackUserWrite.e()) {
                a2 = a(viewCache, ackUserWrite.a(), ackUserWrite.d(), writeTreeRef, node, childChangeAccumulator);
            } else {
                a2 = a(viewCache, ackUserWrite.a(), writeTreeRef, node, childChangeAccumulator);
            }
        } else if (i == 4) {
            a2 = b(viewCache, operation.a(), writeTreeRef, node, childChangeAccumulator);
        } else {
            throw new AssertionError("Unknown operation: " + operation.c());
        }
        ArrayList arrayList = new ArrayList(childChangeAccumulator.a());
        a(viewCache, a2, arrayList);
        return new ProcessorResult(a2, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class a implements NodeFilter.CompleteChildSource {

        /* renamed from: a, reason: collision with root package name */
        private final WriteTreeRef f17140a;

        /* renamed from: b, reason: collision with root package name */
        private final ViewCache f17141b;

        /* renamed from: c, reason: collision with root package name */
        private final Node f17142c;

        public a(WriteTreeRef writeTreeRef, ViewCache viewCache, Node node) {
            this.f17140a = writeTreeRef;
            this.f17141b = viewCache;
            this.f17142c = node;
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public Node a(ChildKey childKey) {
            CacheNode d2;
            CacheNode c2 = this.f17141b.c();
            if (c2.a(childKey)) {
                return c2.b().a(childKey);
            }
            Node node = this.f17142c;
            if (node != null) {
                d2 = new CacheNode(IndexedNode.a(node, KeyIndex.d()), true, false);
            } else {
                d2 = this.f17141b.d();
            }
            return this.f17140a.a(childKey, d2);
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public NamedNode a(Index index, NamedNode namedNode, boolean z) {
            Node node = this.f17142c;
            if (node == null) {
                node = this.f17141b.b();
            }
            return this.f17140a.a(node, namedNode, z, index);
        }
    }

    private void a(ViewCache viewCache, ViewCache viewCache2, List<Change> list) {
        CacheNode c2 = viewCache2.c();
        if (c2.d()) {
            boolean z = c2.b().b() || c2.b().isEmpty();
            if (list.isEmpty() && viewCache.c().d() && ((!z || c2.b().equals(viewCache.a())) && c2.b().getPriority().equals(viewCache.a().getPriority()))) {
                return;
            }
            list.add(Change.a(c2.a()));
        }
    }

    private ViewCache a(ViewCache viewCache, Path path, WriteTreeRef writeTreeRef, NodeFilter.CompleteChildSource completeChildSource, ChildChangeAccumulator childChangeAccumulator) {
        Node a2;
        IndexedNode a3;
        Node a4;
        CacheNode c2 = viewCache.c();
        if (writeTreeRef.a(path) != null) {
            return viewCache;
        }
        if (path.isEmpty()) {
            if (viewCache.d().c()) {
                Node b2 = viewCache.b();
                if (!(b2 instanceof ChildrenNode)) {
                    b2 = EmptyNode.e();
                }
                a4 = writeTreeRef.b(b2);
            } else {
                a4 = writeTreeRef.a(viewCache.b());
            }
            a3 = this.f17137b.a(viewCache.c().a(), IndexedNode.a(a4, this.f17137b.getIndex()), childChangeAccumulator);
        } else {
            ChildKey f2 = path.f();
            if (f2.i()) {
                Node a5 = writeTreeRef.a(path, c2.b(), viewCache.d().b());
                if (a5 != null) {
                    a3 = this.f17137b.a(c2.a(), a5);
                } else {
                    a3 = c2.a();
                }
            } else {
                Path g2 = path.g();
                if (c2.a(f2)) {
                    Node a6 = writeTreeRef.a(path, c2.b(), viewCache.d().b());
                    if (a6 != null) {
                        a2 = c2.b().a(f2).a(g2, a6);
                    } else {
                        a2 = c2.b().a(f2);
                    }
                } else {
                    a2 = writeTreeRef.a(f2, viewCache.d());
                }
                Node node = a2;
                if (node != null) {
                    a3 = this.f17137b.a(c2.a(), f2, node, g2, completeChildSource, childChangeAccumulator);
                } else {
                    a3 = c2.a();
                }
            }
        }
        return viewCache.a(a3, c2.d() || path.isEmpty(), this.f17137b.b());
    }

    private ViewCache a(ViewCache viewCache, Path path, Node node, WriteTreeRef writeTreeRef, Node node2, boolean z, ChildChangeAccumulator childChangeAccumulator) {
        IndexedNode a2;
        CacheNode d2 = viewCache.d();
        NodeFilter a3 = z ? this.f17137b : this.f17137b.a();
        boolean z2 = true;
        if (path.isEmpty()) {
            a2 = a3.a(d2.a(), IndexedNode.a(node, a3.getIndex()), null);
        } else if (a3.b() && !d2.c()) {
            ChildKey f2 = path.f();
            a2 = a3.a(d2.a(), d2.a().b(f2, d2.b().a(f2).a(path.g(), node)), null);
        } else {
            ChildKey f3 = path.f();
            if (!d2.a(path) && path.size() > 1) {
                return viewCache;
            }
            Path g2 = path.g();
            Node a4 = d2.b().a(f3).a(g2, node);
            if (f3.i()) {
                a2 = a3.a(d2.a(), a4);
            } else {
                a2 = a3.a(d2.a(), f3, a4, g2, f17136a, null);
            }
            if (!d2.d() && !path.isEmpty()) {
                z2 = false;
            }
            ViewCache b2 = viewCache.b(a2, z2, a3.b());
            return a(b2, path, writeTreeRef, new a(writeTreeRef, b2, node2), childChangeAccumulator);
        }
        if (!d2.d()) {
            z2 = false;
        }
        ViewCache b22 = viewCache.b(a2, z2, a3.b());
        return a(b22, path, writeTreeRef, new a(writeTreeRef, b22, node2), childChangeAccumulator);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.firebase.database.core.view.ViewCache a(com.google.firebase.database.core.view.ViewCache r9, com.google.firebase.database.core.Path r10, com.google.firebase.database.snapshot.Node r11, com.google.firebase.database.core.WriteTreeRef r12, com.google.firebase.database.snapshot.Node r13, com.google.firebase.database.core.view.filter.ChildChangeAccumulator r14) {
        /*
            r8 = this;
            com.google.firebase.database.core.view.CacheNode r0 = r9.c()
            com.google.firebase.database.core.view.ViewProcessor$a r6 = new com.google.firebase.database.core.view.ViewProcessor$a
            r6.<init>(r12, r9, r13)
            boolean r12 = r10.isEmpty()
            if (r12 == 0) goto L34
            com.google.firebase.database.core.view.filter.NodeFilter r10 = r8.f17137b
            com.google.firebase.database.snapshot.Index r10 = r10.getIndex()
            com.google.firebase.database.snapshot.IndexedNode r10 = com.google.firebase.database.snapshot.IndexedNode.a(r11, r10)
            com.google.firebase.database.core.view.filter.NodeFilter r11 = r8.f17137b
            com.google.firebase.database.core.view.CacheNode r12 = r9.c()
            com.google.firebase.database.snapshot.IndexedNode r12 = r12.a()
            com.google.firebase.database.snapshot.IndexedNode r10 = r11.a(r12, r10, r14)
            r11 = 1
            com.google.firebase.database.core.view.filter.NodeFilter r12 = r8.f17137b
            boolean r12 = r12.b()
            com.google.firebase.database.core.view.ViewCache r9 = r9.a(r10, r11, r12)
            goto Lb6
        L34:
            com.google.firebase.database.snapshot.ChildKey r3 = r10.f()
            boolean r12 = r3.i()
            if (r12 == 0) goto L59
            com.google.firebase.database.core.view.filter.NodeFilter r10 = r8.f17137b
            com.google.firebase.database.core.view.CacheNode r12 = r9.c()
            com.google.firebase.database.snapshot.IndexedNode r12 = r12.a()
            com.google.firebase.database.snapshot.IndexedNode r10 = r10.a(r12, r11)
            boolean r11 = r0.d()
            boolean r12 = r0.c()
            com.google.firebase.database.core.view.ViewCache r9 = r9.a(r10, r11, r12)
            goto Lb6
        L59:
            com.google.firebase.database.core.Path r5 = r10.g()
            com.google.firebase.database.snapshot.Node r10 = r0.b()
            com.google.firebase.database.snapshot.Node r10 = r10.a(r3)
            boolean r12 = r5.isEmpty()
            if (r12 == 0) goto L6d
        L6b:
            r4 = r11
            goto L97
        L6d:
            com.google.firebase.database.snapshot.Node r12 = r6.a(r3)
            if (r12 == 0) goto L92
            com.google.firebase.database.snapshot.ChildKey r13 = r5.d()
            boolean r13 = r13.i()
            if (r13 == 0) goto L8d
            com.google.firebase.database.core.Path r13 = r5.getParent()
            com.google.firebase.database.snapshot.Node r13 = r12.a(r13)
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L8d
            r4 = r12
            goto L97
        L8d:
            com.google.firebase.database.snapshot.Node r11 = r12.a(r5, r11)
            goto L6b
        L92:
            com.google.firebase.database.snapshot.EmptyNode r11 = com.google.firebase.database.snapshot.EmptyNode.e()
            goto L6b
        L97:
            boolean r10 = r10.equals(r4)
            if (r10 != 0) goto Lb6
            com.google.firebase.database.core.view.filter.NodeFilter r1 = r8.f17137b
            com.google.firebase.database.snapshot.IndexedNode r2 = r0.a()
            r7 = r14
            com.google.firebase.database.snapshot.IndexedNode r10 = r1.a(r2, r3, r4, r5, r6, r7)
            boolean r11 = r0.d()
            com.google.firebase.database.core.view.filter.NodeFilter r12 = r8.f17137b
            boolean r12 = r12.b()
            com.google.firebase.database.core.view.ViewCache r9 = r9.a(r10, r11, r12)
        Lb6:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.view.ViewProcessor.a(com.google.firebase.database.core.view.ViewCache, com.google.firebase.database.core.Path, com.google.firebase.database.snapshot.Node, com.google.firebase.database.core.WriteTreeRef, com.google.firebase.database.snapshot.Node, com.google.firebase.database.core.view.filter.ChildChangeAccumulator):com.google.firebase.database.core.view.ViewCache");
    }

    private static boolean a(ViewCache viewCache, ChildKey childKey) {
        return viewCache.c().a(childKey);
    }

    private ViewCache a(ViewCache viewCache, Path path, CompoundWrite compoundWrite, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        Iterator<Map.Entry<Path, Node>> it = compoundWrite.iterator();
        ViewCache viewCache2 = viewCache;
        while (it.hasNext()) {
            Map.Entry<Path, Node> next = it.next();
            Path e2 = path.e(next.getKey());
            if (a(viewCache, e2.f())) {
                viewCache2 = a(viewCache2, e2, next.getValue(), writeTreeRef, node, childChangeAccumulator);
            }
        }
        Iterator<Map.Entry<Path, Node>> it2 = compoundWrite.iterator();
        ViewCache viewCache3 = viewCache2;
        while (it2.hasNext()) {
            Map.Entry<Path, Node> next2 = it2.next();
            Path e3 = path.e(next2.getKey());
            if (!a(viewCache, e3.f())) {
                viewCache3 = a(viewCache3, e3, next2.getValue(), writeTreeRef, node, childChangeAccumulator);
            }
        }
        return viewCache3;
    }

    private ViewCache a(ViewCache viewCache, Path path, CompoundWrite compoundWrite, WriteTreeRef writeTreeRef, Node node, boolean z, ChildChangeAccumulator childChangeAccumulator) {
        if (viewCache.d().b().isEmpty() && !viewCache.d().d()) {
            return viewCache;
        }
        CompoundWrite a2 = path.isEmpty() ? compoundWrite : CompoundWrite.d().a(path, compoundWrite);
        Node b2 = viewCache.d().b();
        Map<ChildKey, CompoundWrite> a3 = a2.a();
        ViewCache viewCache2 = viewCache;
        for (Map.Entry<ChildKey, CompoundWrite> entry : a3.entrySet()) {
            ChildKey key = entry.getKey();
            if (b2.b(key)) {
                viewCache2 = a(viewCache2, new Path(key), entry.getValue().b(b2.a(key)), writeTreeRef, node, z, childChangeAccumulator);
            }
        }
        ViewCache viewCache3 = viewCache2;
        for (Map.Entry<ChildKey, CompoundWrite> entry2 : a3.entrySet()) {
            ChildKey key2 = entry2.getKey();
            boolean z2 = !viewCache.d().a(key2) && entry2.getValue().f() == null;
            if (!b2.b(key2) && !z2) {
                viewCache3 = a(viewCache3, new Path(key2), entry2.getValue().b(b2.a(key2)), writeTreeRef, node, z, childChangeAccumulator);
            }
        }
        return viewCache3;
    }

    private ViewCache a(ViewCache viewCache, Path path, ImmutableTree<Boolean> immutableTree, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        if (writeTreeRef.a(path) != null) {
            return viewCache;
        }
        boolean c2 = viewCache.d().c();
        CacheNode d2 = viewCache.d();
        if (immutableTree.getValue() != null) {
            if ((path.isEmpty() && d2.d()) || d2.a(path)) {
                return a(viewCache, path, d2.b().a(path), writeTreeRef, node, c2, childChangeAccumulator);
            }
            if (!path.isEmpty()) {
                return viewCache;
            }
            CompoundWrite d3 = CompoundWrite.d();
            CompoundWrite compoundWrite = d3;
            for (NamedNode namedNode : d2.b()) {
                compoundWrite = compoundWrite.b(namedNode.c(), namedNode.d());
            }
            return a(viewCache, path, compoundWrite, writeTreeRef, node, c2, childChangeAccumulator);
        }
        CompoundWrite d4 = CompoundWrite.d();
        Iterator<Map.Entry<Path, Boolean>> it = immutableTree.iterator();
        CompoundWrite compoundWrite2 = d4;
        while (it.hasNext()) {
            Path key = it.next().getKey();
            Path e2 = path.e(key);
            if (d2.a(e2)) {
                compoundWrite2 = compoundWrite2.b(key, d2.b().a(e2));
            }
        }
        return a(viewCache, path, compoundWrite2, writeTreeRef, node, c2, childChangeAccumulator);
    }

    public ViewCache a(ViewCache viewCache, Path path, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        Node b2;
        if (writeTreeRef.a(path) != null) {
            return viewCache;
        }
        a aVar = new a(writeTreeRef, viewCache, node);
        IndexedNode a2 = viewCache.c().a();
        if (!path.isEmpty() && !path.f().i()) {
            ChildKey f2 = path.f();
            Node a3 = writeTreeRef.a(f2, viewCache.d());
            if (a3 == null && viewCache.d().a(f2)) {
                a3 = a2.e().a(f2);
            }
            Node node2 = a3;
            if (node2 != null) {
                a2 = this.f17137b.a(a2, f2, node2, path.g(), aVar, childChangeAccumulator);
            } else if (node2 == null && viewCache.c().b().b(f2)) {
                a2 = this.f17137b.a(a2, f2, EmptyNode.e(), path.g(), aVar, childChangeAccumulator);
            }
            if (a2.e().isEmpty() && viewCache.d().d()) {
                Node a4 = writeTreeRef.a(viewCache.b());
                if (a4.b()) {
                    a2 = this.f17137b.a(a2, IndexedNode.a(a4, this.f17137b.getIndex()), childChangeAccumulator);
                }
            }
        } else {
            if (viewCache.d().d()) {
                b2 = writeTreeRef.a(viewCache.b());
            } else {
                b2 = writeTreeRef.b(viewCache.d().b());
            }
            a2 = this.f17137b.a(a2, IndexedNode.a(b2, this.f17137b.getIndex()), childChangeAccumulator);
        }
        return viewCache.a(a2, viewCache.d().d() || writeTreeRef.a(Path.e()) != null, this.f17137b.b());
    }
}
