package com.google.common.collect;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterables.java */
/* renamed from: com.google.common.collect.ia */
/* loaded from: classes2.dex */
public class C1514ia<T> extends FluentIterable<T> {

    /* renamed from: b */
    final /* synthetic */ List f15801b;

    /* renamed from: c */
    final /* synthetic */ int f15802c;

    public C1514ia(List list, int i) {
        this.f15801b = list;
        this.f15802c = i;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        int min = Math.min(this.f15801b.size(), this.f15802c);
        List list = this.f15801b;
        return list.subList(min, list.size()).iterator();
    }
}
