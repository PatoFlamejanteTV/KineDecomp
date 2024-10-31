package com.google.firebase.database.snapshot;

import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.CompoundHash;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class d extends ChildrenNode.ChildVisitor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CompoundHash.a f17226a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CompoundHash.a aVar) {
        this.f17226a = aVar;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode.ChildVisitor
    public void a(ChildKey childKey, Node node) {
        this.f17226a.a(childKey);
        CompoundHash.b(node, this.f17226a);
        this.f17226a.d();
    }
}
