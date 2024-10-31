package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.core.SyncTree;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.view.View;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class F implements Callable<List<Event>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ QuerySpec f16857a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ EventRegistration f16858b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ DatabaseError f16859c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ SyncTree f16860d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(SyncTree syncTree, QuerySpec querySpec, EventRegistration eventRegistration, DatabaseError databaseError) {
        this.f16860d = syncTree;
        this.f16857a = querySpec;
        this.f16858b = eventRegistration;
        this.f16859c = databaseError;
    }

    @Override // java.util.concurrent.Callable
    public List<Event> call() {
        ImmutableTree immutableTree;
        boolean z;
        ImmutableTree immutableTree2;
        SyncTree.ListenProvider listenProvider;
        QuerySpec a2;
        SyncTree.ListenProvider listenProvider2;
        QuerySpec a3;
        ImmutableTree immutableTree3;
        List<View> a4;
        SyncTree.ListenProvider listenProvider3;
        QuerySpec a5;
        Tag tag;
        PersistenceManager persistenceManager;
        ImmutableTree immutableTree4;
        Path c2 = this.f16857a.c();
        immutableTree = this.f16860d.f16934a;
        SyncPoint syncPoint = (SyncPoint) immutableTree.c(c2);
        List<Event> arrayList = new ArrayList<>();
        if (syncPoint != null && (this.f16857a.d() || syncPoint.a(this.f16857a))) {
            Pair<List<QuerySpec>, List<Event>> a6 = syncPoint.a(this.f16857a, this.f16858b, this.f16859c);
            if (syncPoint.d()) {
                SyncTree syncTree = this.f16860d;
                immutableTree4 = syncTree.f16934a;
                syncTree.f16934a = immutableTree4.e(c2);
            }
            List<QuerySpec> a7 = a6.a();
            arrayList = a6.b();
            loop0: while (true) {
                for (QuerySpec querySpec : a7) {
                    persistenceManager = this.f16860d.f16940g;
                    persistenceManager.c(this.f16857a);
                    z = z || querySpec.e();
                }
            }
            immutableTree2 = this.f16860d.f16934a;
            boolean z2 = immutableTree2.getValue() != null && ((SyncPoint) immutableTree2.getValue()).c();
            Iterator<ChildKey> it = c2.iterator();
            while (it.hasNext()) {
                immutableTree2 = immutableTree2.d(it.next());
                z2 = z2 || (immutableTree2.getValue() != null && ((SyncPoint) immutableTree2.getValue()).c());
                if (z2 || immutableTree2.isEmpty()) {
                    break;
                }
            }
            if (z && !z2) {
                immutableTree3 = this.f16860d.f16934a;
                ImmutableTree f2 = immutableTree3.f(c2);
                if (!f2.isEmpty()) {
                    a4 = this.f16860d.a((ImmutableTree<SyncPoint>) f2);
                    for (View view : a4) {
                        SyncTree.a aVar = new SyncTree.a(view);
                        QuerySpec b2 = view.b();
                        listenProvider3 = this.f16860d.f16939f;
                        a5 = this.f16860d.a(b2);
                        tag = aVar.f16943b;
                        listenProvider3.a(a5, tag, aVar, aVar);
                    }
                }
            }
            if (!z2 && !a7.isEmpty() && this.f16859c == null) {
                if (z) {
                    listenProvider2 = this.f16860d.f16939f;
                    a3 = this.f16860d.a(this.f16857a);
                    listenProvider2.a(a3, null);
                } else {
                    for (QuerySpec querySpec2 : a7) {
                        Tag b3 = this.f16860d.b(querySpec2);
                        listenProvider = this.f16860d.f16939f;
                        a2 = this.f16860d.a(querySpec2);
                        listenProvider.a(a2, b3);
                    }
                }
            }
            this.f16860d.a((List<QuerySpec>) a7);
        }
        return arrayList;
    }
}
