package com.google.firebase.database.core;

import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.Node;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class D implements Callable<List<? extends Event>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Tag f16848a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Path f16849b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Map f16850c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ SyncTree f16851d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(SyncTree syncTree, Tag tag, Path path, Map map) {
        this.f16851d = syncTree;
        this.f16848a = tag;
        this.f16849b = path;
        this.f16850c = map;
    }

    @Override // java.util.concurrent.Callable
    public List<? extends Event> call() {
        QuerySpec b2;
        PersistenceManager persistenceManager;
        List<? extends Event> a2;
        b2 = this.f16851d.b(this.f16848a);
        if (b2 != null) {
            Path a3 = Path.a(b2.c(), this.f16849b);
            CompoundWrite a4 = CompoundWrite.a((Map<Path, Node>) this.f16850c);
            persistenceManager = this.f16851d.f16940g;
            persistenceManager.b(this.f16849b, a4);
            a2 = this.f16851d.a(b2, new Merge(OperationSource.a(b2.b()), a3, a4));
            return a2;
        }
        return Collections.emptyList();
    }
}
