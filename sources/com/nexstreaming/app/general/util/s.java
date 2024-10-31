package com.nexstreaming.app.general.util;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IterUtil.java */
/* loaded from: classes2.dex */
public class s<T> implements Iterator<T> {

    /* renamed from: a */
    private int f19882a = 0;

    /* renamed from: b */
    final /* synthetic */ Iterator f19883b;

    /* renamed from: c */
    final /* synthetic */ Iterator f19884c;

    public s(Iterator it, Iterator it2) {
        this.f19883b = it;
        this.f19884c = it2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f19882a == 0) {
            return this.f19883b.hasNext();
        }
        return this.f19884c.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.f19882a == 0 && !this.f19883b.hasNext()) {
            this.f19882a = 1;
        }
        if (this.f19882a == 0) {
            return (T) this.f19883b.next();
        }
        return (T) this.f19884c.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.f19882a == 0) {
            this.f19883b.remove();
        } else {
            this.f19884c.remove();
        }
    }
}
