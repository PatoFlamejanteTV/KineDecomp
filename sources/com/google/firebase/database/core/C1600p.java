package com.google.firebase.database.core;

import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.utilities.Tree;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1600p implements Tree.TreeFilter<List<Repo.a>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f17009a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Repo f17010b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1600p(Repo repo, int i) {
        this.f17010b = repo;
        this.f17009a = i;
    }

    @Override // com.google.firebase.database.core.utilities.Tree.TreeFilter
    public boolean a(Tree<List<Repo.a>> tree) {
        this.f17010b.a((Tree<List<Repo.a>>) tree, this.f17009a);
        return false;
    }
}
