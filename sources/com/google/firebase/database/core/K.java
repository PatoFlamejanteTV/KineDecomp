package com.google.firebase.database.core;

import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.snapshot.Node;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class K implements Callable<List<? extends Event>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f16880a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f16881b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f16882c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Clock f16883d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SyncTree f16884e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(SyncTree syncTree, boolean z, long j, boolean z2, Clock clock) {
        this.f16884e = syncTree;
        this.f16880a = z;
        this.f16881b = j;
        this.f16882c = z2;
        this.f16883d = clock;
    }

    @Override // java.util.concurrent.Callable
    public List<? extends Event> call() {
        WriteTree writeTree;
        WriteTree writeTree2;
        List<? extends Event> a2;
        PersistenceManager persistenceManager;
        PersistenceManager persistenceManager2;
        PersistenceManager persistenceManager3;
        if (this.f16880a) {
            persistenceManager3 = this.f16884e.f16940g;
            persistenceManager3.a(this.f16881b);
        }
        writeTree = this.f16884e.f16935b;
        UserWriteRecord a3 = writeTree.a(this.f16881b);
        writeTree2 = this.f16884e.f16935b;
        boolean b2 = writeTree2.b(this.f16881b);
        if (a3.f() && !this.f16882c) {
            Map<String, Object> a4 = ServerValues.a(this.f16883d);
            if (a3.e()) {
                Node a5 = ServerValues.a(a3.b(), a4);
                persistenceManager2 = this.f16884e.f16940g;
                persistenceManager2.a(a3.c(), a5);
            } else {
                CompoundWrite a6 = ServerValues.a(a3.a(), a4);
                persistenceManager = this.f16884e.f16940g;
                persistenceManager.a(a3.c(), a6);
            }
        }
        if (!b2) {
            return Collections.emptyList();
        }
        ImmutableTree a7 = ImmutableTree.a();
        if (a3.e()) {
            a7 = a7.a(Path.e(), (Path) true);
        } else {
            Iterator<Map.Entry<Path, Node>> it = a3.a().iterator();
            while (it.hasNext()) {
                a7 = a7.a(it.next().getKey(), (Path) true);
            }
        }
        a2 = this.f16884e.a(new AckUserWrite(a3.c(), a7, this.f16882c));
        return a2;
    }
}
