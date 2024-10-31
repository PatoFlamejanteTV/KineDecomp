package com.google.firebase.database.core;

import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.view.Event;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class J implements Callable<List<? extends Event>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f16874a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Path f16875b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ CompoundWrite f16876c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f16877d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ CompoundWrite f16878e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ SyncTree f16879f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(SyncTree syncTree, boolean z, Path path, CompoundWrite compoundWrite, long j, CompoundWrite compoundWrite2) {
        this.f16879f = syncTree;
        this.f16874a = z;
        this.f16875b = path;
        this.f16876c = compoundWrite;
        this.f16877d = j;
        this.f16878e = compoundWrite2;
    }

    @Override // java.util.concurrent.Callable
    public List<? extends Event> call() throws Exception {
        WriteTree writeTree;
        List<? extends Event> a2;
        PersistenceManager persistenceManager;
        if (this.f16874a) {
            persistenceManager = this.f16879f.f16940g;
            persistenceManager.a(this.f16875b, this.f16876c, this.f16877d);
        }
        writeTree = this.f16879f.f16935b;
        writeTree.a(this.f16875b, this.f16878e, Long.valueOf(this.f16877d));
        a2 = this.f16879f.a(new Merge(OperationSource.f17002a, this.f16875b, this.f16878e));
        return a2;
    }
}
