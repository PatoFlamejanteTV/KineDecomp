package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* loaded from: classes2.dex */
final class Ni implements ListIterator<String> {

    /* renamed from: a */
    private ListIterator<String> f11715a;

    /* renamed from: b */
    private final /* synthetic */ int f11716b;

    /* renamed from: c */
    private final /* synthetic */ zzbtx f11717c;

    public Ni(zzbtx zzbtxVar, int i) {
        zzbru zzbruVar;
        this.f11717c = zzbtxVar;
        this.f11716b = i;
        zzbruVar = this.f11717c.zzftz;
        this.f11715a = zzbruVar.listIterator(this.f11716b);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f11715a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f11715a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f11715a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f11715a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f11715a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f11715a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
