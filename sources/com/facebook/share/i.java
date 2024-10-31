package com.facebook.share;

import com.facebook.internal.Mutable;
import java.util.Iterator;

/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
class i implements Iterator<Integer> {

    /* renamed from: a */
    final /* synthetic */ Mutable f9495a;

    /* renamed from: b */
    final /* synthetic */ int f9496b;

    /* renamed from: c */
    final /* synthetic */ j f9497c;

    public i(j jVar, Mutable mutable, int i) {
        this.f9497c = jVar;
        this.f9495a = mutable;
        this.f9496b = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Iterator
    public boolean hasNext() {
        return ((Integer) this.f9495a.value).intValue() < this.f9496b;
    }

    @Override // java.util.Iterator
    public void remove() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Integer] */
    @Override // java.util.Iterator
    public Integer next() {
        Mutable mutable = this.f9495a;
        T t = mutable.value;
        Integer num = (Integer) t;
        mutable.value = Integer.valueOf(((Integer) t).intValue() + 1);
        return num;
    }
}
