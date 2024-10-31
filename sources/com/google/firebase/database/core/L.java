package com.google.firebase.database.core;

import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.Node;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class L implements Callable<List<? extends Event>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Path f16885a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Node f16886b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SyncTree f16887c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(SyncTree syncTree, Path path, Node node) {
        this.f16887c = syncTree;
        this.f16885a = path;
        this.f16886b = node;
    }

    @Override // java.util.concurrent.Callable
    public List<? extends Event> call() {
        PersistenceManager persistenceManager;
        List<? extends Event> a2;
        persistenceManager = this.f16887c.f16940g;
        persistenceManager.a(QuerySpec.a(this.f16885a), this.f16886b);
        a2 = this.f16887c.a(new Overwrite(OperationSource.f17003b, this.f16885a, this.f16886b));
        return a2;
    }
}
