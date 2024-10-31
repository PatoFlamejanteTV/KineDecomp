package com.google.firebase.database.core;

import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.snapshot.Node;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class I implements Callable<List<? extends Event>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f16867a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Path f16868b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Node f16869c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f16870d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Node f16871e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f16872f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ SyncTree f16873g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(SyncTree syncTree, boolean z, Path path, Node node, long j, Node node2, boolean z2) {
        this.f16873g = syncTree;
        this.f16867a = z;
        this.f16868b = path;
        this.f16869c = node;
        this.f16870d = j;
        this.f16871e = node2;
        this.f16872f = z2;
    }

    @Override // java.util.concurrent.Callable
    public List<? extends Event> call() {
        WriteTree writeTree;
        List<? extends Event> a2;
        PersistenceManager persistenceManager;
        if (this.f16867a) {
            persistenceManager = this.f16873g.f16940g;
            persistenceManager.a(this.f16868b, this.f16869c, this.f16870d);
        }
        writeTree = this.f16873g.f16935b;
        writeTree.a(this.f16868b, this.f16871e, Long.valueOf(this.f16870d), this.f16872f);
        if (!this.f16872f) {
            return Collections.emptyList();
        }
        a2 = this.f16873g.a(new Overwrite(OperationSource.f17002a, this.f16868b, this.f16871e));
        return a2;
    }
}
