package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class SnapshotHolder {

    /* renamed from: a */
    private Node f16929a;

    public SnapshotHolder() {
        this.f16929a = EmptyNode.e();
    }

    public Node a() {
        return this.f16929a;
    }

    public Node a(Path path) {
        return this.f16929a.a(path);
    }

    public SnapshotHolder(Node node) {
        this.f16929a = node;
    }

    public void a(Path path, Node node) {
        this.f16929a = this.f16929a.a(path, node);
    }
}
