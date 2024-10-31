package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

/* loaded from: classes2.dex */
final class vb implements ListIterator<String> {

    /* renamed from: a */
    private ListIterator<String> f13539a;

    /* renamed from: b */
    private final /* synthetic */ int f13540b;

    /* renamed from: c */
    private final /* synthetic */ zzxg f13541c;

    public vb(zzxg zzxgVar, int i) {
        zzve zzveVar;
        this.f13541c = zzxgVar;
        this.f13540b = i;
        zzveVar = this.f13541c.zzcch;
        this.f13539a = zzveVar.listIterator(this.f13540b);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f13539a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f13539a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f13539a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f13539a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f13539a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f13539a.previousIndex();
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
