package com.google.firebase.database.core;

import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.core.SyncTree;
import com.google.firebase.database.core.view.QuerySpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class w implements SyncTree.ListenProvider {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Repo f17158a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Repo repo) {
        this.f17158a = repo;
    }

    @Override // com.google.firebase.database.core.SyncTree.ListenProvider
    public void a(QuerySpec querySpec, Tag tag, ListenHashProvider listenHashProvider, SyncTree.CompletionListener completionListener) {
        PersistentConnection persistentConnection;
        persistentConnection = this.f17158a.f16905c;
        persistentConnection.a(querySpec.c().a(), querySpec.b().h(), listenHashProvider, tag != null ? Long.valueOf(tag.a()) : null, new v(this, completionListener));
    }

    @Override // com.google.firebase.database.core.SyncTree.ListenProvider
    public void a(QuerySpec querySpec, Tag tag) {
        PersistentConnection persistentConnection;
        persistentConnection = this.f17158a.f16905c;
        persistentConnection.a(querySpec.c().a(), querySpec.b().h());
    }
}
