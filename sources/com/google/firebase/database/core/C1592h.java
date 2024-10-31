package com.google.firebase.database.core;

import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.utilities.Tree;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1592h implements Tree.TreeVisitor<List<Repo.a>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Repo f16978a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1592h(Repo repo) {
        this.f16978a = repo;
    }

    @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
    public void a(Tree<List<Repo.a>> tree) {
        this.f16978a.c((Tree<List<Repo.a>>) tree);
    }
}
