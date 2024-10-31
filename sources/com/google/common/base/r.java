package com.google.common.base;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Optional.java */
/* loaded from: classes2.dex */
final class r<T> implements Iterable<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterable f2591a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Iterable iterable) {
        this.f2591a = iterable;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new s(this);
    }
}
