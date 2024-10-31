package com.google.android.gms.internal.firebase_auth;

import java.util.ListIterator;

/* loaded from: classes2.dex */
final class Ha implements ListIterator<String> {

    /* renamed from: a */
    private ListIterator<String> f12966a;

    /* renamed from: b */
    private final /* synthetic */ int f12967b;

    /* renamed from: c */
    private final /* synthetic */ zzit f12968c;

    public Ha(zzit zzitVar, int i) {
        zzgl zzglVar;
        this.f12968c = zzitVar;
        this.f12967b = i;
        zzglVar = this.f12968c.zzabr;
        this.f12966a = zzglVar.listIterator(this.f12967b);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f12966a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f12966a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f12966a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f12966a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f12966a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f12966a.previousIndex();
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
