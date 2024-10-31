package com.google.firebase.database.core.view;

import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class ViewCache {

    /* renamed from: a */
    private final CacheNode f17134a;

    /* renamed from: b */
    private final CacheNode f17135b;

    public ViewCache(CacheNode cacheNode, CacheNode cacheNode2) {
        this.f17134a = cacheNode;
        this.f17135b = cacheNode2;
    }

    public ViewCache a(IndexedNode indexedNode, boolean z, boolean z2) {
        return new ViewCache(new CacheNode(indexedNode, z, z2), this.f17135b);
    }

    public ViewCache b(IndexedNode indexedNode, boolean z, boolean z2) {
        return new ViewCache(this.f17134a, new CacheNode(indexedNode, z, z2));
    }

    public CacheNode c() {
        return this.f17134a;
    }

    public CacheNode d() {
        return this.f17135b;
    }

    public Node a() {
        if (this.f17134a.d()) {
            return this.f17134a.b();
        }
        return null;
    }

    public Node b() {
        if (this.f17135b.d()) {
            return this.f17135b.b();
        }
        return null;
    }
}
