package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.ChildKey;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.f */
/* loaded from: classes2.dex */
public class C1590f implements Iterator<ChildKey> {

    /* renamed from: a */
    int f16974a;

    /* renamed from: b */
    final /* synthetic */ Path f16975b;

    public C1590f(Path path) {
        int i;
        this.f16975b = path;
        i = this.f16975b.f16901c;
        this.f16974a = i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        int i2 = this.f16974a;
        i = this.f16975b.f16902d;
        return i2 < i;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Can't remove component from immutable Path!");
    }

    @Override // java.util.Iterator
    public ChildKey next() {
        ChildKey[] childKeyArr;
        if (hasNext()) {
            childKeyArr = this.f16975b.f16900b;
            int i = this.f16974a;
            ChildKey childKey = childKeyArr[i];
            this.f16974a = i + 1;
            return childKey;
        }
        throw new NoSuchElementException("No more elements.");
    }
}
