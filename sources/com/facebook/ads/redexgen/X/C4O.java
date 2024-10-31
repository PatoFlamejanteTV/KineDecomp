package com.facebook.ads.redexgen.X;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.facebook.ads.redexgen.X.4O, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C4O<T> implements Iterator<T> {
    public int A00;
    public int A01;
    public boolean A02 = false;
    public final int A03;
    public final /* synthetic */ C4I A04;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4O != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ArrayIterator<T> */
    public C4O(C4I c4i, int i) {
        this.A04 = c4i;
        this.A03 = i;
        this.A01 = c4i.A04();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r2;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4O != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ArrayIterator<T> */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean hasNext() {
        /*
            r3 = this;
            r2 = 0
            int r1 = r3.A00
            int r0 = r3.A01
            if (r1 >= r0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r2 = 1
            r0 = 3
            goto L8
        Lf:
            r2 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4O.hasNext():boolean");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4O != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ArrayIterator<T> */
    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T t = (T) this.A04.A07(this.A00, this.A03);
        this.A00++;
        this.A02 = true;
        return t;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4O != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ArrayIterator<T> */
    @Override // java.util.Iterator
    public final void remove() {
        if (!this.A02) {
            throw new IllegalStateException();
        }
        this.A00--;
        this.A01--;
        this.A02 = false;
        this.A04.A0E(this.A00);
    }
}
