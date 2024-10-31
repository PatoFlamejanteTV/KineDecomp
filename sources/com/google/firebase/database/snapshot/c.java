package com.google.firebase.database.snapshot;

import com.google.firebase.database.collection.LLRBNode;
import com.google.firebase.database.snapshot.ChildrenNode;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class c extends LLRBNode.NodeVisitor<ChildKey, Node> {

    /* renamed from: a, reason: collision with root package name */
    boolean f17223a = false;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ChildrenNode.ChildVisitor f17224b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ChildrenNode f17225c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChildrenNode childrenNode, ChildrenNode.ChildVisitor childVisitor) {
        this.f17225c = childrenNode;
        this.f17224b = childVisitor;
    }

    @Override // com.google.firebase.database.collection.LLRBNode.NodeVisitor
    public void a(ChildKey childKey, Node node) {
        if (!this.f17223a && childKey.compareTo(ChildKey.f()) > 0) {
            this.f17223a = true;
            this.f17224b.a(ChildKey.f(), this.f17225c.getPriority());
        }
        this.f17224b.a(childKey, node);
    }
}
