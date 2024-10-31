package com.google.firebase.database.android;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.ImmutableTree;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class h implements ImmutableTree.TreeVisitor<Void, Integer> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImmutableTree f16679a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SqlPersistenceStorageEngine f16680b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SqlPersistenceStorageEngine sqlPersistenceStorageEngine, ImmutableTree immutableTree) {
        this.f16680b = sqlPersistenceStorageEngine;
        this.f16679a = immutableTree;
    }

    @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
    public Integer a(Path path, Void r2, Integer num) {
        return Integer.valueOf(this.f16679a.c(path) == null ? num.intValue() + 1 : num.intValue());
    }
}
