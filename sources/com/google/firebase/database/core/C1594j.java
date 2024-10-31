package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.connection.RequestResultCallback;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.OffsetClock;
import com.google.firebase.database.core.utilities.Tree;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1594j implements RequestResultCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Path f16982a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f16983b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Repo f16984c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Repo f16985d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1594j(Repo repo, Path path, List list, Repo repo2) {
        this.f16985d = repo;
        this.f16982a = path;
        this.f16983b = list;
        this.f16984c = repo2;
    }

    @Override // com.google.firebase.database.connection.RequestResultCallback
    public void a(String str, String str2) {
        DatabaseError b2;
        Tree tree;
        SyncTree syncTree;
        OffsetClock offsetClock;
        Node node;
        b2 = Repo.b(str, str2);
        this.f16985d.a("Transaction", this.f16982a, b2);
        ArrayList arrayList = new ArrayList();
        if (b2 == null) {
            ArrayList arrayList2 = new ArrayList();
            for (Repo.a aVar : this.f16983b) {
                aVar.f16914d = Repo.TransactionStatus.COMPLETED;
                syncTree = this.f16985d.p;
                long j = aVar.i;
                offsetClock = this.f16985d.f16904b;
                arrayList.addAll(syncTree.a(j, false, false, (Clock) offsetClock));
                node = aVar.l;
                arrayList2.add(new RunnableC1593i(this, aVar, InternalHelpers.a(InternalHelpers.a(this.f16984c, aVar.f16911a), IndexedNode.b(node))));
                Repo repo = this.f16985d;
                repo.b(new ValueEventRegistration(repo, aVar.f16913c, QuerySpec.a(aVar.f16911a)));
            }
            Repo repo2 = this.f16985d;
            tree = repo2.f16908f;
            repo2.b((Tree<List<Repo.a>>) tree.a(this.f16982a));
            this.f16985d.e();
            this.f16984c.a((List<? extends Event>) arrayList);
            for (int i = 0; i < arrayList2.size(); i++) {
                this.f16985d.a((Runnable) arrayList2.get(i));
            }
            return;
        }
        if (b2.a() == -1) {
            for (Repo.a aVar2 : this.f16983b) {
                if (aVar2.f16914d == Repo.TransactionStatus.SENT_NEEDS_ABORT) {
                    aVar2.f16914d = Repo.TransactionStatus.NEEDS_ABORT;
                } else {
                    aVar2.f16914d = Repo.TransactionStatus.RUN;
                }
            }
        } else {
            for (Repo.a aVar3 : this.f16983b) {
                aVar3.f16914d = Repo.TransactionStatus.NEEDS_ABORT;
                aVar3.f16918h = b2;
            }
        }
        this.f16985d.b(this.f16982a);
    }
}
