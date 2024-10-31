package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class B extends ChildrenNode.ChildVisitor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f16826a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SnapshotHolder f16827b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(Map map, SnapshotHolder snapshotHolder) {
        this.f16826a = map;
        this.f16827b = snapshotHolder;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode.ChildVisitor
    public void a(ChildKey childKey, Node node) {
        Node a2 = ServerValues.a(node, (Map<String, Object>) this.f16826a);
        if (a2 != node) {
            this.f16827b.a(new Path(childKey.a()), a2);
        }
    }
}
