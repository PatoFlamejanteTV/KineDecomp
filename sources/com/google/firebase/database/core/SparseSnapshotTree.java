package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class SparseSnapshotTree {

    /* renamed from: a */
    private Node f16930a = null;

    /* renamed from: b */
    private Map<ChildKey, SparseSnapshotTree> f16931b = null;

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface SparseSnapshotChildVisitor {
        void a(ChildKey childKey, SparseSnapshotTree sparseSnapshotTree);
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface SparseSnapshotTreeVisitor {
        void a(Path path, Node node);
    }

    public void a(Path path, Node node) {
        if (path.isEmpty()) {
            this.f16930a = node;
            this.f16931b = null;
            return;
        }
        Node node2 = this.f16930a;
        if (node2 != null) {
            this.f16930a = node2.a(path, node);
            return;
        }
        if (this.f16931b == null) {
            this.f16931b = new HashMap();
        }
        ChildKey f2 = path.f();
        if (!this.f16931b.containsKey(f2)) {
            this.f16931b.put(f2, new SparseSnapshotTree());
        }
        this.f16931b.get(f2).a(path.g(), node);
    }

    public void a(Path path, SparseSnapshotTreeVisitor sparseSnapshotTreeVisitor) {
        Node node = this.f16930a;
        if (node != null) {
            sparseSnapshotTreeVisitor.a(path, node);
        } else {
            a(new C(this, path, sparseSnapshotTreeVisitor));
        }
    }

    public void a(SparseSnapshotChildVisitor sparseSnapshotChildVisitor) {
        Map<ChildKey, SparseSnapshotTree> map = this.f16931b;
        if (map != null) {
            for (Map.Entry<ChildKey, SparseSnapshotTree> entry : map.entrySet()) {
                sparseSnapshotChildVisitor.a(entry.getKey(), entry.getValue());
            }
        }
    }
}
