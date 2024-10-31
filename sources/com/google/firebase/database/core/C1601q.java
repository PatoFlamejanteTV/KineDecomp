package com.google.firebase.database.core;

import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.utilities.Tree;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1601q implements Tree.TreeVisitor<List<Repo.a>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f17041a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Repo f17042b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1601q(Repo repo, int i) {
        this.f17042b = repo;
        this.f17041a = i;
    }

    @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
    public void a(Tree<List<Repo.a>> tree) {
        this.f17042b.a((Tree<List<Repo.a>>) tree, this.f17041a);
    }
}
