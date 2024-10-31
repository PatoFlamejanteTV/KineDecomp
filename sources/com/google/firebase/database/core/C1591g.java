package com.google.firebase.database.core;

import com.google.firebase.database.core.SparseSnapshotTree;
import com.google.firebase.database.snapshot.Node;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1591g implements SparseSnapshotTree.SparseSnapshotTreeVisitor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f16976a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Repo f16977b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1591g(Repo repo, List list) {
        this.f16977b = repo;
        this.f16976a = list;
    }

    @Override // com.google.firebase.database.core.SparseSnapshotTree.SparseSnapshotTreeVisitor
    public void a(Path path, Node node) {
        SyncTree syncTree;
        Path a2;
        List list = this.f16976a;
        syncTree = this.f16977b.p;
        list.addAll(syncTree.a(path, node));
        a2 = this.f16977b.a(path, -9);
        this.f16977b.b(a2);
    }
}
