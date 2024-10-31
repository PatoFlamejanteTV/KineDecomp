package com.google.firebase.database.core;

import com.google.firebase.database.core.SparseSnapshotTree;
import com.google.firebase.database.snapshot.Node;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class A implements SparseSnapshotTree.SparseSnapshotTreeVisitor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SparseSnapshotTree f16824a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f16825b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(SparseSnapshotTree sparseSnapshotTree, Map map) {
        this.f16824a = sparseSnapshotTree;
        this.f16825b = map;
    }

    @Override // com.google.firebase.database.core.SparseSnapshotTree.SparseSnapshotTreeVisitor
    public void a(Path path, Node node) {
        this.f16824a.a(path, ServerValues.a(node, (Map<String, Object>) this.f16825b));
    }
}
