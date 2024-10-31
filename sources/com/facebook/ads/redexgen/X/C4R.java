package com.facebook.ads.redexgen.X;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* renamed from: com.facebook.ads.redexgen.X.4R, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C4R<K, V> implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
    public static byte[] A04;
    public int A00;
    public final /* synthetic */ C4I A03;
    public boolean A02 = false;
    public int A01 = -1;

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C4R.A04
            int r0 = r2 + r3
            byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            if (r1 >= r0) goto L17
            r0 = 3
            goto Lc
        L17:
            r0 = 4
            goto Lc
        L19:
            byte[] r2 = (byte[]) r2
            r0 = r2[r1]
            r0 = r0 ^ r4
            r0 = r0 ^ 26
            byte r0 = (byte) r0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L27:
            byte[] r2 = (byte[]) r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4R.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A04 = new byte[]{76, 110, 82, 83, 73, 26, 89, 85, 84, 78, 91, 83, 84, 95, 72, 26, 94, 85, 95, 73, 26, 84, 85, 78, 26, 73, 79, 74, 74, 85, 72, 78, 26, 72, 95, 78, 91, 83, 84, 83, 84, 93, 26, 119, 91, 74, 20, Byte.MAX_VALUE, 84, 78, 72, 67, 26, 85, 88, 80, 95, 89, 78, 73};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4R != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    public C4R(C4I c4i) {
        this.A03 = c4i;
        this.A00 = c4i.A04() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4R != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Iterator
    /* renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final Map.Entry<K, V> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.A01++;
        this.A02 = true;
        return this;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000b. Please report as an issue. */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4R != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        C4R<K, V> c4r = this;
        Map.Entry entry = null;
        int i = 1;
        boolean z = 0;
        char c = !c4r.A02 ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalStateException(A00(1, 59, 32));
                case 3:
                    obj = obj;
                    c = !(obj instanceof Map.Entry) ? (char) 4 : (char) 5;
                case 4:
                    return z;
                case 5:
                    c4r = c4r;
                    obj = obj;
                    z = 0;
                    z = 0;
                    entry = (Map.Entry) obj;
                    c = C4M.A04(entry.getKey(), c4r.A03.A07(c4r.A01, 0)) ? (char) 6 : '\b';
                case 6:
                    c4r = c4r;
                    entry = entry;
                    c = C4M.A04(entry.getValue(), c4r.A03.A07(c4r.A01, i)) ? (char) 7 : '\b';
                case 7:
                    z = i;
                    c = 4;
                case '\b':
                    i = z ? 1 : 0;
                    c = 7;
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4R != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Map.Entry
    public final K getKey() {
        if (!this.A02) {
            throw new IllegalStateException(A00(1, 59, 32));
        }
        return (K) this.A03.A07(this.A01, 0);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4R != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Map.Entry
    public final V getValue() {
        if (!this.A02) {
            throw new IllegalStateException(A00(1, 59, 32));
        }
        return (V) this.A03.A07(this.A01, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r2;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4R != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean hasNext() {
        /*
            r3 = this;
            r2 = 0
            int r1 = r3.A01
            int r0 = r3.A00
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4R.hasNext():boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000b. Please report as an issue. */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4R != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Map.Entry
    public final int hashCode() {
        C4R<K, V> c4r = this;
        Object value = null;
        Object obj = null;
        int i = 0;
        int i2 = 0;
        char c = !c4r.A02 ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalStateException(A00(1, 59, 32));
                case 3:
                    c4r = c4r;
                    i2 = 0;
                    value = c4r.A03.A07(c4r.A01, 0);
                    obj = c4r.A03.A07(c4r.A01, 1);
                    c = value == null ? (char) 4 : '\b';
                case 4:
                    i = i2;
                    c = 5;
                case 5:
                    obj = obj;
                    c = obj == null ? (char) 6 : (char) 7;
                case 6:
                    return i2 ^ i;
                case 7:
                    obj = obj;
                    i2 = obj.hashCode();
                    c = 6;
                case '\b':
                    value = value;
                    i = value.hashCode();
                    c = 5;
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4R != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Iterator
    public final void remove() {
        if (!this.A02) {
            throw new IllegalStateException();
        }
        this.A03.A0E(this.A01);
        this.A01--;
        this.A00--;
        this.A02 = false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4R != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        if (!this.A02) {
            throw new IllegalStateException(A00(1, 59, 32));
        }
        return (V) this.A03.A08(this.A01, v);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4R != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    public final String toString() {
        return getKey() + A00(0, 1, 107) + getValue();
    }
}
