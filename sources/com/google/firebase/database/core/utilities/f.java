package com.google.firebase.database.core.utilities;

import com.google.firebase.database.core.utilities.Tree;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class f<T> implements Tree.TreeVisitor<T> {

    /* renamed from: a */
    final /* synthetic */ Tree.TreeVisitor f17090a;

    /* renamed from: b */
    final /* synthetic */ boolean f17091b;

    /* renamed from: c */
    final /* synthetic */ Tree f17092c;

    public f(Tree tree, Tree.TreeVisitor treeVisitor, boolean z) {
        this.f17092c = tree;
        this.f17090a = treeVisitor;
        this.f17091b = z;
    }

    @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
    public void a(Tree<T> tree) {
        tree.a(this.f17090a, true, this.f17091b);
    }
}
