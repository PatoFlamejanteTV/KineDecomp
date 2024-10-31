package com.google.firebase.database.android;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.snapshot.Node;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class i implements ImmutableTree.TreeVisitor<Void, Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImmutableTree f16681a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f16682b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Path f16683c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Node f16684d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SqlPersistenceStorageEngine f16685e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SqlPersistenceStorageEngine sqlPersistenceStorageEngine, ImmutableTree immutableTree, List list, Path path, Node node) {
        this.f16685e = sqlPersistenceStorageEngine;
        this.f16681a = immutableTree;
        this.f16682b = list;
        this.f16683c = path;
        this.f16684d = node;
    }

    @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
    public Void a(Path path, Void r4, Void r5) {
        if (this.f16681a.c(path) != null) {
            return null;
        }
        this.f16682b.add(new Pair(this.f16683c.e(path), this.f16684d.a(path)));
        return null;
    }
}
