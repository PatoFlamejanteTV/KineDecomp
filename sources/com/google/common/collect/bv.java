package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
final class bv<V> extends UnmodifiableIterator<V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnmodifiableIterator f2828a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(UnmodifiableIterator unmodifiableIterator) {
        this.f2828a = unmodifiableIterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2828a.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        return (V) ((Map.Entry) this.f2828a.next()).getValue();
    }
}
