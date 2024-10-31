package com.google.firebase.database.core;

import com.google.firebase.database.core.operation.ListenComplete;
import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class O implements Callable<List<? extends Event>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Tag f16893a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SyncTree f16894b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(SyncTree syncTree, Tag tag) {
        this.f16894b = syncTree;
        this.f16893a = tag;
    }

    @Override // java.util.concurrent.Callable
    public List<? extends Event> call() {
        QuerySpec b2;
        PersistenceManager persistenceManager;
        List<? extends Event> a2;
        b2 = this.f16894b.b(this.f16893a);
        if (b2 != null) {
            persistenceManager = this.f16894b.f16940g;
            persistenceManager.d(b2);
            a2 = this.f16894b.a(b2, new ListenComplete(OperationSource.a(b2.b()), Path.e()));
            return a2;
        }
        return Collections.emptyList();
    }
}
