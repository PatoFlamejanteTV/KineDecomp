package com.google.common.base;

import java.util.Iterator;

/* compiled from: Optional.java */
/* loaded from: classes2.dex */
class h<T> extends AbstractIterator<T> {

    /* renamed from: c */
    private final Iterator<? extends Optional<? extends T>> f15133c;

    /* renamed from: d */
    final /* synthetic */ i f15134d;

    public h(i iVar) {
        this.f15134d = iVar;
        Iterator<? extends Optional<? extends T>> it = this.f15134d.f15135a.iterator();
        Preconditions.a(it);
        this.f15133c = it;
    }

    @Override // com.google.common.base.AbstractIterator
    protected T b() {
        while (this.f15133c.hasNext()) {
            Optional<? extends T> next = this.f15133c.next();
            if (next.isPresent()) {
                return next.get();
            }
        }
        return c();
    }
}
