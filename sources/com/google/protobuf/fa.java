package com.google.protobuf;

import java.util.ListIterator;

/* compiled from: UnmodifiableLazyStringList.java */
/* loaded from: classes2.dex */
class fa implements ListIterator<String> {

    /* renamed from: a */
    ListIterator<String> f18776a;

    /* renamed from: b */
    final /* synthetic */ int f18777b;

    /* renamed from: c */
    final /* synthetic */ UnmodifiableLazyStringList f18778c;

    public fa(UnmodifiableLazyStringList unmodifiableLazyStringList, int i) {
        LazyStringList lazyStringList;
        this.f18778c = unmodifiableLazyStringList;
        this.f18777b = i;
        lazyStringList = this.f18778c.f18729a;
        this.f18776a = lazyStringList.listIterator(this.f18777b);
    }

    public void a(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public /* bridge */ /* synthetic */ void add(String str) {
        a(str);
        throw null;
    }

    public void b(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.f18776a.hasNext();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.f18776a.hasPrevious();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.f18776a.nextIndex();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.f18776a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public /* bridge */ /* synthetic */ void set(String str) {
        b(str);
        throw null;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public String next() {
        return this.f18776a.next();
    }

    @Override // java.util.ListIterator
    public String previous() {
        return this.f18776a.previous();
    }
}
