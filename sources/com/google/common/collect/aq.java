package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Iterators.java */
/* loaded from: classes2.dex */
final class aq<T> extends AbstractIterator<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterator f2800a;
    final /* synthetic */ Predicate b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(Iterator it, Predicate predicate) {
        this.f2800a = it;
        this.b = predicate;
    }

    @Override // com.google.common.collect.AbstractIterator
    protected T a() {
        while (this.f2800a.hasNext()) {
            T t = (T) this.f2800a.next();
            if (this.b.apply(t)) {
                return t;
            }
        }
        return b();
    }
}
