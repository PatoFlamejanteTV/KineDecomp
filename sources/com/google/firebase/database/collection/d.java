package com.google.firebase.database.collection;

import com.google.firebase.database.collection.RBTreeSortedMap;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
/* loaded from: classes2.dex */
public class d implements Iterator<RBTreeSortedMap.a.b> {

    /* renamed from: a */
    private int f16721a;

    /* renamed from: b */
    final /* synthetic */ RBTreeSortedMap.a.C0093a f16722b;

    public d(RBTreeSortedMap.a.C0093a c0093a) {
        int i;
        this.f16722b = c0093a;
        i = this.f16722b.f16712b;
        this.f16721a = i - 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16721a >= 0;
    }

    @Override // java.util.Iterator
    public void remove() {
    }

    @Override // java.util.Iterator
    public RBTreeSortedMap.a.b next() {
        long j;
        j = this.f16722b.f16711a;
        long j2 = j & (1 << this.f16721a);
        RBTreeSortedMap.a.b bVar = new RBTreeSortedMap.a.b();
        bVar.f16713a = j2 == 0;
        bVar.f16714b = (int) Math.pow(2.0d, this.f16721a);
        this.f16721a--;
        return bVar;
    }
}
