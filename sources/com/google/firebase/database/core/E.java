package com.google.firebase.database.core;

import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class E implements Callable<List<? extends Event>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EventRegistration f16852a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SyncTree f16853b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(SyncTree syncTree, EventRegistration eventRegistration) {
        this.f16853b = syncTree;
        this.f16852a = eventRegistration;
    }

    @Override // java.util.concurrent.Callable
    public List<? extends Event> call() {
        ImmutableTree immutableTree;
        ImmutableTree immutableTree2;
        PersistenceManager persistenceManager;
        PersistenceManager persistenceManager2;
        CacheNode a2;
        ImmutableTree immutableTree3;
        Node a3;
        WriteTree writeTree;
        Tag a4;
        Map map;
        Map map2;
        PersistenceManager persistenceManager3;
        ImmutableTree immutableTree4;
        QuerySpec a5 = this.f16852a.a();
        Path c2 = a5.c();
        immutableTree = this.f16853b.f16934a;
        Path path = c2;
        Node node = null;
        boolean z = false;
        while (true) {
            boolean z2 = true;
            if (immutableTree.isEmpty()) {
                break;
            }
            SyncPoint syncPoint = (SyncPoint) immutableTree.getValue();
            if (syncPoint != null) {
                if (node == null) {
                    node = syncPoint.a(path);
                }
                if (!z && !syncPoint.c()) {
                    z2 = false;
                }
                z = z2;
            }
            immutableTree = immutableTree.d(path.isEmpty() ? ChildKey.a("") : path.f());
            path = path.g();
        }
        immutableTree2 = this.f16853b.f16934a;
        SyncPoint syncPoint2 = (SyncPoint) immutableTree2.c(c2);
        if (syncPoint2 == null) {
            persistenceManager3 = this.f16853b.f16940g;
            syncPoint2 = new SyncPoint(persistenceManager3);
            SyncTree syncTree = this.f16853b;
            immutableTree4 = syncTree.f16934a;
            syncTree.f16934a = immutableTree4.a(c2, (Path) syncPoint2);
        } else {
            z = z || syncPoint2.c();
            if (node == null) {
                node = syncPoint2.a(Path.e());
            }
        }
        persistenceManager = this.f16853b.f16940g;
        persistenceManager.b(a5);
        if (node == null) {
            persistenceManager2 = this.f16853b.f16940g;
            a2 = persistenceManager2.a(a5);
            if (!a2.d()) {
                Node e2 = EmptyNode.e();
                immutableTree3 = this.f16853b.f16934a;
                Iterator it = immutableTree3.f(c2).d().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    SyncPoint syncPoint3 = (SyncPoint) ((ImmutableTree) entry.getValue()).getValue();
                    if (syncPoint3 != null && (a3 = syncPoint3.a(Path.e())) != null) {
                        e2 = e2.a((ChildKey) entry.getKey(), a3);
                    }
                }
                for (NamedNode namedNode : a2.b()) {
                    if (!e2.b(namedNode.c())) {
                        e2 = e2.a(namedNode.c(), namedNode.d());
                    }
                }
                a2 = new CacheNode(IndexedNode.a(e2, a5.a()), false, false);
            }
        } else {
            a2 = new CacheNode(IndexedNode.a(node, a5.a()), true, false);
        }
        boolean a6 = syncPoint2.a(a5);
        if (!a6 && !a5.e()) {
            a4 = this.f16853b.a();
            map = this.f16853b.f16937d;
            map.put(a5, a4);
            map2 = this.f16853b.f16936c;
            map2.put(a4, a5);
        }
        writeTree = this.f16853b.f16935b;
        List<DataEvent> a7 = syncPoint2.a(this.f16852a, writeTree.a(c2), a2);
        if (!a6 && !z) {
            this.f16853b.a(a5, syncPoint2.b(a5));
        }
        return a7;
    }
}
