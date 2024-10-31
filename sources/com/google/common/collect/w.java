package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [K] */
/* compiled from: ImmutableMap.java */
/* loaded from: classes2.dex */
public class W<K> extends UnmodifiableIterator<K> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnmodifiableIterator f15748a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ImmutableMap f15749b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public W(ImmutableMap immutableMap, UnmodifiableIterator unmodifiableIterator) {
        this.f15749b = immutableMap;
        this.f15748a = unmodifiableIterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15748a.hasNext();
    }

    @Override // java.util.Iterator
    public K next() {
        return (K) ((Map.Entry) this.f15748a.next()).getKey();
    }
}
