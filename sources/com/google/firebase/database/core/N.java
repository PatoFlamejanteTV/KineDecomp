package com.google.firebase.database.core;

import com.google.firebase.database.core.operation.ListenComplete;
import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class N implements Callable<List<? extends Event>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Path f16891a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SyncTree f16892b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(SyncTree syncTree, Path path) {
        this.f16892b = syncTree;
        this.f16891a = path;
    }

    @Override // java.util.concurrent.Callable
    public List<? extends Event> call() {
        PersistenceManager persistenceManager;
        List<? extends Event> a2;
        persistenceManager = this.f16892b.f16940g;
        persistenceManager.d(QuerySpec.a(this.f16891a));
        a2 = this.f16892b.a(new ListenComplete(OperationSource.f17003b, this.f16891a));
        return a2;
    }
}
