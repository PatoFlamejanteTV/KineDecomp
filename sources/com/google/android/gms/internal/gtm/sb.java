package com.google.android.gms.internal.gtm;

import java.util.ListIterator;

/* loaded from: classes2.dex */
final class sb implements ListIterator<String> {

    /* renamed from: a */
    private ListIterator<String> f13294a;

    /* renamed from: b */
    private final /* synthetic */ int f13295b;

    /* renamed from: c */
    private final /* synthetic */ zztu f13296c;

    public sb(zztu zztuVar, int i) {
        zzrt zzrtVar;
        this.f13296c = zztuVar;
        this.f13295b = i;
        zzrtVar = this.f13296c.zzbeo;
        this.f13294a = zzrtVar.listIterator(this.f13295b);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f13294a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f13294a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f13294a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f13294a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f13294a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f13294a.previousIndex();
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
