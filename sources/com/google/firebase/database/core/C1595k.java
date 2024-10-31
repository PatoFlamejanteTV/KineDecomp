package com.google.firebase.database.core;

import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.utilities.Tree;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1595k implements Tree.TreeVisitor<List<Repo.a>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Repo f16986a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1595k(Repo repo) {
        this.f16986a = repo;
    }

    @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
    public void a(Tree<List<Repo.a>> tree) {
        this.f16986a.b((Tree<List<Repo.a>>) tree);
    }
}
