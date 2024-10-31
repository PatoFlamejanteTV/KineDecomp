package com.google.firebase.database.core;

import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.Node;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class P implements Callable<List<? extends Event>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Tag f16895a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Path f16896b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Node f16897c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ SyncTree f16898d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(SyncTree syncTree, Tag tag, Path path, Node node) {
        this.f16898d = syncTree;
        this.f16895a = tag;
        this.f16896b = path;
        this.f16897c = node;
    }

    @Override // java.util.concurrent.Callable
    public List<? extends Event> call() {
        QuerySpec b2;
        PersistenceManager persistenceManager;
        List<? extends Event> a2;
        b2 = this.f16898d.b(this.f16895a);
        if (b2 != null) {
            Path a3 = Path.a(b2.c(), this.f16896b);
            QuerySpec a4 = a3.isEmpty() ? b2 : QuerySpec.a(this.f16896b);
            persistenceManager = this.f16898d.f16940g;
            persistenceManager.a(a4, this.f16897c);
            a2 = this.f16898d.a(b2, new Overwrite(OperationSource.a(b2.b()), a3, this.f16897c));
            return a2;
        }
        return Collections.emptyList();
    }
}
