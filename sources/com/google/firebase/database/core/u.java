package com.google.firebase.database.core;

import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.core.SyncTree;
import com.google.firebase.database.core.view.QuerySpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class u implements SyncTree.ListenProvider {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Repo f17050a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Repo repo) {
        this.f17050a = repo;
    }

    @Override // com.google.firebase.database.core.SyncTree.ListenProvider
    public void a(QuerySpec querySpec, Tag tag) {
    }

    @Override // com.google.firebase.database.core.SyncTree.ListenProvider
    public void a(QuerySpec querySpec, Tag tag, ListenHashProvider listenHashProvider, SyncTree.CompletionListener completionListener) {
        this.f17050a.b(new RunnableC1603t(this, querySpec, completionListener));
    }
}
