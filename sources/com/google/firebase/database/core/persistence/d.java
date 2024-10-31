package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.ImmutableTree;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class d<T> implements ImmutableTree.TreeVisitor<Boolean, T> {

    /* renamed from: a */
    final /* synthetic */ ImmutableTree.TreeVisitor f17037a;

    /* renamed from: b */
    final /* synthetic */ PruneForest f17038b;

    public d(PruneForest pruneForest, ImmutableTree.TreeVisitor treeVisitor) {
        this.f17038b = pruneForest;
        this.f17037a = treeVisitor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
    public /* bridge */ /* synthetic */ Object a(Path path, Boolean bool, Object obj) {
        return a2(path, bool, (Boolean) obj);
    }

    /* renamed from: a */
    public T a2(Path path, Boolean bool, T t) {
        return !bool.booleanValue() ? (T) this.f17037a.a(path, null, t) : t;
    }
}
