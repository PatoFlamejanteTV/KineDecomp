package com.google.android.gms.internal.clearcut;

import java.util.ListIterator;

/* loaded from: classes2.dex */
final class Ja implements ListIterator<String> {

    /* renamed from: a */
    private ListIterator<String> f12784a;

    /* renamed from: b */
    private final /* synthetic */ int f12785b;

    /* renamed from: c */
    private final /* synthetic */ zzfa f12786c;

    public Ja(zzfa zzfaVar, int i) {
        zzcx zzcxVar;
        this.f12786c = zzfaVar;
        this.f12785b = i;
        zzcxVar = this.f12786c.zzpb;
        this.f12784a = zzcxVar.listIterator(this.f12785b);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f12784a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f12784a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f12784a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f12784a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f12784a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f12784a.previousIndex();
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
