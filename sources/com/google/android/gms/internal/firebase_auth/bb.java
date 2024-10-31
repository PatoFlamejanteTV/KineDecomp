package com.google.android.gms.internal.firebase_auth;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class bb<E> extends zzae<E> {

    /* renamed from: a */
    private final int f13016a;

    /* renamed from: b */
    private int f13017b;

    public bb(int i, int i2) {
        zzv.zzb(i2, i);
        this.f13016a = i;
        this.f13017b = i2;
    }

    protected abstract E a(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f13017b < this.f13016a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f13017b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i = this.f13017b;
            this.f13017b = i + 1;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f13017b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i = this.f13017b - 1;
            this.f13017b = i;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f13017b - 1;
    }
}
