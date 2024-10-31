package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.StandardTable;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [R, V] */
/* compiled from: StandardTable.java */
/* loaded from: classes2.dex */
class da<R, V> implements Predicate<Map.Entry<R, V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Collection f2856a;
    final /* synthetic */ StandardTable.c.d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(StandardTable.c.d dVar, Collection collection) {
        this.b = dVar;
        this.f2856a = collection;
    }

    @Override // com.google.common.base.Predicate
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean apply(Map.Entry<R, V> entry) {
        return this.f2856a.contains(entry.getValue());
    }
}
