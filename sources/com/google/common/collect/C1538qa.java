package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterators.java */
/* renamed from: com.google.common.collect.qa */
/* loaded from: classes2.dex */
public class C1538qa<T> extends AbstractIterator<T> {

    /* renamed from: c */
    final /* synthetic */ Iterator f15831c;

    /* renamed from: d */
    final /* synthetic */ Predicate f15832d;

    public C1538qa(Iterator it, Predicate predicate) {
        this.f15831c = it;
        this.f15832d = predicate;
    }

    @Override // com.google.common.collect.AbstractIterator
    protected T b() {
        while (this.f15831c.hasNext()) {
            T t = (T) this.f15831c.next();
            if (this.f15832d.apply(t)) {
                return t;
            }
        }
        return c();
    }
}
