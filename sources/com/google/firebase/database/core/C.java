package com.google.firebase.database.core;

import com.google.firebase.database.core.SparseSnapshotTree;
import com.google.firebase.database.snapshot.ChildKey;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class C implements SparseSnapshotTree.SparseSnapshotChildVisitor {

    /* renamed from: a */
    final /* synthetic */ Path f16828a;

    /* renamed from: b */
    final /* synthetic */ SparseSnapshotTree.SparseSnapshotTreeVisitor f16829b;

    /* renamed from: c */
    final /* synthetic */ SparseSnapshotTree f16830c;

    public C(SparseSnapshotTree sparseSnapshotTree, Path path, SparseSnapshotTree.SparseSnapshotTreeVisitor sparseSnapshotTreeVisitor) {
        this.f16830c = sparseSnapshotTree;
        this.f16828a = path;
        this.f16829b = sparseSnapshotTreeVisitor;
    }

    @Override // com.google.firebase.database.core.SparseSnapshotTree.SparseSnapshotChildVisitor
    public void a(ChildKey childKey, SparseSnapshotTree sparseSnapshotTree) {
        sparseSnapshotTree.a(this.f16828a.d(childKey), this.f16829b);
    }
}
