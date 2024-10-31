package com.google.firebase.database.core;

import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.utilities.Tree;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1599o implements Tree.TreeVisitor<List<Repo.a>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f16994a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Repo f16995b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1599o(Repo repo, List list) {
        this.f16995b = repo;
        this.f16994a = list;
    }

    @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
    public void a(Tree<List<Repo.a>> tree) {
        this.f16995b.a((List<Repo.a>) this.f16994a, (Tree<List<Repo.a>>) tree);
    }
}
