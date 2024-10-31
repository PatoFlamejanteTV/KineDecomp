package com.facebook.share;

import com.facebook.internal.Mutable;
import java.util.Iterator;

/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
class i implements Iterator<Integer> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Mutable f344a;
    final /* synthetic */ int b;
    final /* synthetic */ h c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, Mutable mutable, int i) {
        this.c = hVar;
        this.f344a = mutable;
        this.b = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Iterator
    public boolean hasNext() {
        return ((Integer) this.f344a.value).intValue() < this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Integer] */
    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer next() {
        Integer num = (Integer) this.f344a.value;
        Mutable mutable = this.f344a;
        mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() + 1);
        return num;
    }

    @Override // java.util.Iterator
    public void remove() {
    }
}
