package com.google.firebase.database.core;

import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.snapshot.Node;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class M implements Callable<List<? extends Event>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f16888a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Path f16889b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SyncTree f16890c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(SyncTree syncTree, Map map, Path path) {
        this.f16890c = syncTree;
        this.f16888a = map;
        this.f16889b = path;
    }

    @Override // java.util.concurrent.Callable
    public List<? extends Event> call() {
        PersistenceManager persistenceManager;
        List<? extends Event> a2;
        CompoundWrite a3 = CompoundWrite.a((Map<Path, Node>) this.f16888a);
        persistenceManager = this.f16890c.f16940g;
        persistenceManager.b(this.f16889b, a3);
        a2 = this.f16890c.a(new Merge(OperationSource.f17003b, this.f16889b, a3));
        return a2;
    }
}
