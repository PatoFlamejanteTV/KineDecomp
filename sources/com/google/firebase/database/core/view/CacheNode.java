package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class CacheNode {

    /* renamed from: a */
    private final IndexedNode f17098a;

    /* renamed from: b */
    private final boolean f17099b;

    /* renamed from: c */
    private final boolean f17100c;

    public CacheNode(IndexedNode indexedNode, boolean z, boolean z2) {
        this.f17098a = indexedNode;
        this.f17099b = z;
        this.f17100c = z2;
    }

    public boolean a(Path path) {
        if (path.isEmpty()) {
            return d() && !this.f17100c;
        }
        return a(path.f());
    }

    public Node b() {
        return this.f17098a.e();
    }

    public boolean c() {
        return this.f17100c;
    }

    public boolean d() {
        return this.f17099b;
    }

    public boolean a(ChildKey childKey) {
        return (d() && !this.f17100c) || this.f17098a.e().b(childKey);
    }

    public IndexedNode a() {
        return this.f17098a;
    }
}
