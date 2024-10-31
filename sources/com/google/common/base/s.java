package com.google.common.base;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Optional.java */
/* loaded from: classes2.dex */
class s<T> extends AbstractIterator<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ r f2592a;
    private final Iterator<? extends Optional<? extends T>> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.f2592a = rVar;
        this.b = (Iterator) Preconditions.a(this.f2592a.f2591a.iterator());
    }

    @Override // com.google.common.base.AbstractIterator
    protected T a() {
        while (this.b.hasNext()) {
            Optional<? extends T> next = this.b.next();
            if (next.isPresent()) {
                return next.get();
            }
        }
        return b();
    }
}
