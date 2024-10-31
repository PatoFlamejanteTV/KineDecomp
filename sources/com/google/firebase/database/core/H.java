package com.google.firebase.database.core;

import com.google.firebase.database.collection.LLRBNode;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class H extends LLRBNode.NodeVisitor<ChildKey, ImmutableTree<SyncPoint>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Node f16862a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ WriteTreeRef f16863b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Operation f16864c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f16865d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SyncTree f16866e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(SyncTree syncTree, Node node, WriteTreeRef writeTreeRef, Operation operation, List list) {
        this.f16866e = syncTree;
        this.f16862a = node;
        this.f16863b = writeTreeRef;
        this.f16864c = operation;
        this.f16865d = list;
    }

    @Override // com.google.firebase.database.collection.LLRBNode.NodeVisitor
    public void a(ChildKey childKey, ImmutableTree<SyncPoint> immutableTree) {
        List a2;
        Node node = this.f16862a;
        Node a3 = node != null ? node.a(childKey) : null;
        WriteTreeRef a4 = this.f16863b.a(childKey);
        Operation a5 = this.f16864c.a(childKey);
        if (a5 != null) {
            List list = this.f16865d;
            a2 = this.f16866e.a(a5, (ImmutableTree<SyncPoint>) immutableTree, a3, a4);
            list.addAll(a2);
        }
    }
}
