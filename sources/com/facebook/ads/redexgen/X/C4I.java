package com.facebook.ads.redexgen.X;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.facebook.ads.redexgen.X.4I, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C4I<K, V> {

    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/4I<TK;TV;>.EntrySet; */
    public C4P A00;

    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/4I<TK;TV;>.KeySet; */
    public C4Q A01;

    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/4I<TK;TV;>.ValuesCollection; */
    public C4S A02;

    public abstract int A04();

    public abstract int A05(Object obj);

    public abstract int A06(Object obj);

    public abstract Object A07(int i, int i2);

    public abstract V A08(int i, V v);

    public abstract Map<K, V> A0A();

    public abstract void A0D();

    public abstract void A0E(int i);

    public abstract void A0F(K k, V v);

    /* JADX WARN: Code restructure failed: missing block: B:29:0x002f, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <K, V> boolean A00(java.util.Map<K, V> r3, java.util.Collection<?> r4) {
        /*
            r2 = 0
            r0 = 0
            java.util.Iterator r1 = r4.iterator()
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L17;
                case 4: goto L29;
                case 5: goto L2f;
                case 6: goto L2c;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L15
            r0 = 3
            goto L7
        L15:
            r0 = 6
            goto L7
        L17:
            java.util.Map r3 = (java.util.Map) r3
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r0 = r1.next()
            boolean r0 = r3.containsKey(r0)
            if (r0 != 0) goto L27
            r0 = 4
            goto L7
        L27:
            r0 = 2
            goto L7
        L29:
            r2 = 0
            r0 = 5
            goto L7
        L2c:
            r2 = 1
            r0 = 5
            goto L7
        L2f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4I.A00(java.util.Map, java.util.Collection):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x003b, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <K, V> boolean A01(java.util.Map<K, V> r4, java.util.Collection<?> r5) {
        /*
            r0 = 0
            r0 = 0
            r3 = 0
            int r2 = r4.size()
            java.util.Iterator r1 = r5.iterator()
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L2c;
                case 3: goto L1f;
                case 4: goto L13;
                case 5: goto L10;
                case 6: goto L3b;
                case 7: goto L38;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            r3 = 1
            r0 = 6
            goto Lc
        L13:
            java.util.Map r4 = (java.util.Map) r4
            int r0 = r4.size()
            if (r2 == r0) goto L1d
            r0 = 5
            goto Lc
        L1d:
            r0 = 7
            goto Lc
        L1f:
            java.util.Map r4 = (java.util.Map) r4
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r0 = r1.next()
            r4.remove(r0)
            r0 = 2
            goto Lc
        L2c:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L36
            r0 = 3
            goto Lc
        L36:
            r0 = 4
            goto Lc
        L38:
            r3 = 0
            r0 = 6
            goto Lc
        L3b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4I.A01(java.util.Map, java.util.Collection):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x004c, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <K, V> boolean A02(java.util.Map<K, V> r4, java.util.Collection<?> r5) {
        /*
            r3 = 0
            r0 = 0
            r0 = 0
            int r2 = r4.size()
            java.util.Set r0 = r4.keySet()
            java.util.Iterator r1 = r0.iterator()
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L3d;
                case 3: goto L2b;
                case 4: goto L24;
                case 5: goto L17;
                case 6: goto L14;
                case 7: goto L4c;
                case 8: goto L49;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            r3 = 1
            r0 = 7
            goto L10
        L17:
            java.util.Map r4 = (java.util.Map) r4
            int r0 = r4.size()
            if (r2 == r0) goto L21
            r0 = 6
            goto L10
        L21:
            r0 = 8
            goto L10
        L24:
            java.util.Iterator r1 = (java.util.Iterator) r1
            r1.remove()
            r0 = 2
            goto L10
        L2b:
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r0 = r1.next()
            boolean r0 = r5.contains(r0)
            if (r0 != 0) goto L3b
            r0 = 4
            goto L10
        L3b:
            r0 = 2
            goto L10
        L3d:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L47
            r0 = 3
            goto L10
        L47:
            r0 = 5
            goto L10
        L49:
            r3 = 0
            r0 = 7
            goto L10
        L4c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4I.A02(java.util.Map, java.util.Collection):boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0009. Please report as an issue. */
    public static <T> boolean A03(Set<T> set, Object obj) {
        Set set2 = null;
        boolean z = true;
        boolean z2 = false;
        char c = set == obj ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    return z;
                case 4:
                    obj = obj;
                    if (obj instanceof Set) {
                        set2 = (Set) obj;
                        c = 6;
                    } else {
                        return z2;
                    }
                case 6:
                    try {
                        set = set;
                        c = set.size() == set2.size() ? '\t' : (char) 11;
                    } catch (ClassCastException | NullPointerException unused) {
                        return z2;
                    }
                case '\t':
                    set = set;
                    set2 = set2;
                    c = set.containsAll(set2) ? '\f' : (char) 11;
                case 11:
                    z2 = false;
                    z = false;
                    c = '\f';
                case '\f':
                    return z;
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4I != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    public final Collection<V> A09() {
        if (this.A02 == null) {
            this.A02 = new Collection<V>() { // from class: com.facebook.ads.redexgen.X.4S
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean add(V v) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean addAll(Collection<? extends V> collection) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final void clear() {
                    C4I.this.A0D();
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:            return r1;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean contains(java.lang.Object r3) {
                    /*
                        r2 = this;
                        r1 = 0
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        int r0 = r0.A06(r3)
                        if (r0 < 0) goto L14
                        r0 = 2
                    La:
                        switch(r0) {
                            case 2: goto Le;
                            case 3: goto L16;
                            case 4: goto L11;
                            default: goto Ld;
                        }
                    Ld:
                        goto La
                    Le:
                        r1 = 1
                        r0 = 3
                        goto La
                    L11:
                        r1 = 0
                        r0 = 3
                        goto La
                    L14:
                        r0 = 4
                        goto La
                    L16:
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4S.contains(java.lang.Object):boolean");
                }

                /* JADX WARN: Code restructure failed: missing block: B:29:0x0030, code lost:            return r2;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean containsAll(java.util.Collection<?> r5) {
                    /*
                        r4 = this;
                        r3 = r4
                        r2 = 0
                        r0 = 0
                        java.util.Iterator r1 = r5.iterator()
                        r0 = 2
                    L8:
                        switch(r0) {
                            case 2: goto Lc;
                            case 3: goto L18;
                            case 4: goto L2a;
                            case 5: goto L30;
                            case 6: goto L2d;
                            default: goto Lb;
                        }
                    Lb:
                        goto L8
                    Lc:
                        java.util.Iterator r1 = (java.util.Iterator) r1
                        boolean r0 = r1.hasNext()
                        if (r0 == 0) goto L16
                        r0 = 3
                        goto L8
                    L16:
                        r0 = 6
                        goto L8
                    L18:
                        com.facebook.ads.redexgen.X.4S r3 = (com.facebook.ads.redexgen.X.C4S) r3
                        java.util.Iterator r1 = (java.util.Iterator) r1
                        java.lang.Object r0 = r1.next()
                        boolean r0 = r3.contains(r0)
                        if (r0 != 0) goto L28
                        r0 = 4
                        goto L8
                    L28:
                        r0 = 2
                        goto L8
                    L2a:
                        r2 = 0
                        r0 = 5
                        goto L8
                    L2d:
                        r2 = 1
                        r0 = 5
                        goto L8
                    L30:
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4S.containsAll(java.util.Collection):boolean");
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:            return r1;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean isEmpty() {
                    /*
                        r2 = this;
                        r1 = 0
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        int r0 = r0.A04()
                        if (r0 != 0) goto L14
                        r0 = 2
                    La:
                        switch(r0) {
                            case 2: goto Le;
                            case 3: goto L16;
                            case 4: goto L11;
                            default: goto Ld;
                        }
                    Ld:
                        goto La
                    Le:
                        r1 = 1
                        r0 = 3
                        goto La
                    L11:
                        r1 = 0
                        r0 = 3
                        goto La
                    L14:
                        r0 = 4
                        goto La
                    L16:
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4S.isEmpty():boolean");
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection, java.lang.Iterable
                public final Iterator<V> iterator() {
                    return new C4O(C4I.this, 1);
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:            return r2;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean remove(java.lang.Object r5) {
                    /*
                        r4 = this;
                        r3 = r4
                        r2 = 0
                        r0 = 0
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        int r1 = r0.A06(r5)
                        if (r1 < 0) goto L1d
                        r0 = 2
                    Lc:
                        switch(r0) {
                            case 2: goto L10;
                            case 3: goto L1f;
                            case 4: goto L1a;
                            default: goto Lf;
                        }
                    Lf:
                        goto Lc
                    L10:
                        com.facebook.ads.redexgen.X.4S r3 = (com.facebook.ads.redexgen.X.C4S) r3
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        r0.A0E(r1)
                        r2 = 1
                        r0 = 3
                        goto Lc
                    L1a:
                        r2 = 0
                        r0 = 3
                        goto Lc
                    L1d:
                        r0 = 4
                        goto Lc
                    L1f:
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4S.remove(java.lang.Object):boolean");
                }

                /* JADX WARN: Code restructure failed: missing block: B:28:0x003e, code lost:            return r3;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean removeAll(java.util.Collection<?> r7) {
                    /*
                        r6 = this;
                        r5 = r6
                        r0 = 0
                        r0 = 0
                        r0 = 0
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        int r4 = r0.A04()
                        r3 = 0
                        r2 = 0
                        r0 = 2
                    Ld:
                        switch(r0) {
                            case 2: goto L11;
                            case 3: goto L17;
                            case 4: goto L2c;
                            case 5: goto L3a;
                            case 6: goto L3e;
                            default: goto L10;
                        }
                    L10:
                        goto Ld
                    L11:
                        if (r2 >= r4) goto L15
                        r0 = 3
                        goto Ld
                    L15:
                        r0 = 6
                        goto Ld
                    L17:
                        com.facebook.ads.redexgen.X.4S r5 = (com.facebook.ads.redexgen.X.C4S) r5
                        java.util.Collection r7 = (java.util.Collection) r7
                        com.facebook.ads.redexgen.X.4I r1 = com.facebook.ads.redexgen.X.C4I.this
                        r0 = 1
                        java.lang.Object r0 = r1.A07(r2, r0)
                        boolean r0 = r7.contains(r0)
                        if (r0 == 0) goto L2a
                        r0 = 4
                        goto Ld
                    L2a:
                        r0 = 5
                        goto Ld
                    L2c:
                        com.facebook.ads.redexgen.X.4S r5 = (com.facebook.ads.redexgen.X.C4S) r5
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        r0.A0E(r2)
                        int r2 = r2 + (-1)
                        int r4 = r4 + (-1)
                        r3 = 1
                        r0 = 5
                        goto Ld
                    L3a:
                        int r2 = r2 + 1
                        r0 = 2
                        goto Ld
                    L3e:
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4S.removeAll(java.util.Collection):boolean");
                }

                /* JADX WARN: Code restructure failed: missing block: B:28:0x003e, code lost:            return r3;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean retainAll(java.util.Collection<?> r7) {
                    /*
                        r6 = this;
                        r5 = r6
                        r0 = 0
                        r0 = 0
                        r0 = 0
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        int r4 = r0.A04()
                        r3 = 0
                        r2 = 0
                        r0 = 2
                    Ld:
                        switch(r0) {
                            case 2: goto L11;
                            case 3: goto L17;
                            case 4: goto L2c;
                            case 5: goto L3a;
                            case 6: goto L3e;
                            default: goto L10;
                        }
                    L10:
                        goto Ld
                    L11:
                        if (r2 >= r4) goto L15
                        r0 = 3
                        goto Ld
                    L15:
                        r0 = 6
                        goto Ld
                    L17:
                        com.facebook.ads.redexgen.X.4S r5 = (com.facebook.ads.redexgen.X.C4S) r5
                        java.util.Collection r7 = (java.util.Collection) r7
                        com.facebook.ads.redexgen.X.4I r1 = com.facebook.ads.redexgen.X.C4I.this
                        r0 = 1
                        java.lang.Object r0 = r1.A07(r2, r0)
                        boolean r0 = r7.contains(r0)
                        if (r0 != 0) goto L2a
                        r0 = 4
                        goto Ld
                    L2a:
                        r0 = 5
                        goto Ld
                    L2c:
                        com.facebook.ads.redexgen.X.4S r5 = (com.facebook.ads.redexgen.X.C4S) r5
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        r0.A0E(r2)
                        int r2 = r2 + (-1)
                        int r4 = r4 + (-1)
                        r3 = 1
                        r0 = 5
                        goto Ld
                    L3a:
                        int r2 = r2 + 1
                        r0 = 2
                        goto Ld
                    L3e:
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4S.retainAll(java.util.Collection):boolean");
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final int size() {
                    return C4I.this.A04();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final Object[] toArray() {
                    return C4I.this.A0G(1);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final <T> T[] toArray(T[] tArr) {
                    return (T[]) C4I.this.A0H(tArr, 1);
                }
            };
        }
        return this.A02;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4I != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    public final Set<Map.Entry<K, V>> A0B() {
        if (this.A00 == null) {
            this.A00 = new Set<Map.Entry<K, V>>() { // from class: com.facebook.ads.redexgen.X.4P
                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                /* renamed from: A00, reason: merged with bridge method [inline-methods] */
                public final boolean add(Map.Entry<K, V> entry) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Code restructure failed: missing block: B:32:0x004c, code lost:            return r5;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean addAll(java.util.Collection<? extends java.util.Map.Entry<K, V>> r8) {
                    /*
                        r7 = this;
                        r6 = r7
                        r5 = 0
                        r0 = 0
                        r0 = 0
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        int r4 = r0.A04()
                        java.util.Iterator r3 = r8.iterator()
                        r0 = 2
                    Lf:
                        switch(r0) {
                            case 2: goto L3d;
                            case 3: goto L24;
                            case 4: goto L16;
                            case 5: goto L13;
                            case 6: goto L4c;
                            case 7: goto L49;
                            default: goto L12;
                        }
                    L12:
                        goto Lf
                    L13:
                        r5 = 1
                        r0 = 6
                        goto Lf
                    L16:
                        com.facebook.ads.redexgen.X.4P r6 = (com.facebook.ads.redexgen.X.C4P) r6
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        int r0 = r0.A04()
                        if (r4 == r0) goto L22
                        r0 = 5
                        goto Lf
                    L22:
                        r0 = 7
                        goto Lf
                    L24:
                        com.facebook.ads.redexgen.X.4P r6 = (com.facebook.ads.redexgen.X.C4P) r6
                        java.util.Iterator r3 = (java.util.Iterator) r3
                        java.lang.Object r0 = r3.next()
                        java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                        com.facebook.ads.redexgen.X.4I r2 = com.facebook.ads.redexgen.X.C4I.this
                        java.lang.Object r1 = r0.getKey()
                        java.lang.Object r0 = r0.getValue()
                        r2.A0F(r1, r0)
                        r0 = 2
                        goto Lf
                    L3d:
                        java.util.Iterator r3 = (java.util.Iterator) r3
                        boolean r0 = r3.hasNext()
                        if (r0 == 0) goto L47
                        r0 = 3
                        goto Lf
                    L47:
                        r0 = 4
                        goto Lf
                    L49:
                        r5 = 0
                        r0 = 6
                        goto Lf
                    L4c:
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4P.addAll(java.util.Collection):boolean");
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final void clear() {
                    C4I.this.A0D();
                }

                /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:            return r2;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean contains(java.lang.Object r7) {
                    /*
                        r6 = this;
                        r5 = r6
                        r4 = 0
                        r3 = 0
                        r0 = 0
                        r2 = 0
                        boolean r0 = r7 instanceof java.util.Map.Entry
                        if (r0 != 0) goto L3a
                        r0 = 2
                    La:
                        switch(r0) {
                            case 2: goto L3c;
                            case 3: goto Le;
                            case 4: goto L25;
                            default: goto Ld;
                        }
                    Ld:
                        goto La
                    Le:
                        com.facebook.ads.redexgen.X.4P r5 = (com.facebook.ads.redexgen.X.C4P) r5
                        java.lang.Object r7 = (java.lang.Object) r7
                        r4 = r7
                        java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                        com.facebook.ads.redexgen.X.4I r1 = com.facebook.ads.redexgen.X.C4I.this
                        java.lang.Object r0 = r4.getKey()
                        int r3 = r1.A05(r0)
                        if (r3 < 0) goto L23
                        r0 = 4
                        goto La
                    L23:
                        r0 = 2
                        goto La
                    L25:
                        com.facebook.ads.redexgen.X.4P r5 = (com.facebook.ads.redexgen.X.C4P) r5
                        java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                        com.facebook.ads.redexgen.X.4I r1 = com.facebook.ads.redexgen.X.C4I.this
                        r0 = 1
                        java.lang.Object r1 = r1.A07(r3, r0)
                        java.lang.Object r0 = r4.getValue()
                        boolean r2 = com.facebook.ads.redexgen.X.C4M.A04(r1, r0)
                        r0 = 2
                        goto La
                    L3a:
                        r0 = 3
                        goto La
                    L3c:
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4P.contains(java.lang.Object):boolean");
                }

                /* JADX WARN: Code restructure failed: missing block: B:29:0x0030, code lost:            return r2;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean containsAll(java.util.Collection<?> r5) {
                    /*
                        r4 = this;
                        r3 = r4
                        r2 = 0
                        r0 = 0
                        java.util.Iterator r1 = r5.iterator()
                        r0 = 2
                    L8:
                        switch(r0) {
                            case 2: goto Lc;
                            case 3: goto L18;
                            case 4: goto L2a;
                            case 5: goto L30;
                            case 6: goto L2d;
                            default: goto Lb;
                        }
                    Lb:
                        goto L8
                    Lc:
                        java.util.Iterator r1 = (java.util.Iterator) r1
                        boolean r0 = r1.hasNext()
                        if (r0 == 0) goto L16
                        r0 = 3
                        goto L8
                    L16:
                        r0 = 6
                        goto L8
                    L18:
                        com.facebook.ads.redexgen.X.4P r3 = (com.facebook.ads.redexgen.X.C4P) r3
                        java.util.Iterator r1 = (java.util.Iterator) r1
                        java.lang.Object r0 = r1.next()
                        boolean r0 = r3.contains(r0)
                        if (r0 != 0) goto L28
                        r0 = 4
                        goto L8
                    L28:
                        r0 = 2
                        goto L8
                    L2a:
                        r2 = 0
                        r0 = 5
                        goto L8
                    L2d:
                        r2 = 1
                        r0 = 5
                        goto L8
                    L30:
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4P.containsAll(java.util.Collection):boolean");
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean equals(Object obj) {
                    return C4I.A03(this, obj);
                }

                /* JADX WARN: Code restructure failed: missing block: B:46:0x005a, code lost:            return r4;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final int hashCode() {
                    /*
                        r9 = this;
                        r6 = r9
                        r7 = 0
                        r8 = 0
                        r0 = 0
                        r0 = 0
                        r2 = 0
                        r0 = 0
                        r0 = 0
                        r5 = 0
                        r4 = 0
                        com.facebook.ads.redexgen.X.4I r1 = com.facebook.ads.redexgen.X.C4I.this
                        int r1 = r1.A04()
                        int r3 = r1 + (-1)
                        r1 = 2
                    L13:
                        switch(r1) {
                            case 2: goto L26;
                            case 3: goto L2d;
                            case 4: goto L23;
                            case 5: goto L1a;
                            case 6: goto L17;
                            case 7: goto L4b;
                            case 8: goto L43;
                            case 9: goto L52;
                            case 10: goto L5a;
                            default: goto L16;
                        }
                    L16:
                        goto L13
                    L17:
                        r8 = r5
                        r1 = 7
                        goto L13
                    L1a:
                        java.lang.Object r2 = (java.lang.Object) r2
                        if (r2 != 0) goto L20
                        r1 = 6
                        goto L13
                    L20:
                        r1 = 8
                        goto L13
                    L23:
                        r0 = r5
                        r1 = 5
                        goto L13
                    L26:
                        if (r3 < 0) goto L2a
                        r1 = 3
                        goto L13
                    L2a:
                        r1 = 10
                        goto L13
                    L2d:
                        com.facebook.ads.redexgen.X.4P r6 = (com.facebook.ads.redexgen.X.C4P) r6
                        com.facebook.ads.redexgen.X.4I r1 = com.facebook.ads.redexgen.X.C4I.this
                        java.lang.Object r7 = r1.A07(r3, r5)
                        com.facebook.ads.redexgen.X.4I r2 = com.facebook.ads.redexgen.X.C4I.this
                        r1 = 1
                        java.lang.Object r2 = r2.A07(r3, r1)
                        if (r7 != 0) goto L40
                        r1 = 4
                        goto L13
                    L40:
                        r1 = 9
                        goto L13
                    L43:
                        java.lang.Object r2 = (java.lang.Object) r2
                        int r8 = r2.hashCode()
                        r1 = 7
                        goto L13
                    L4b:
                        r1 = r8 ^ r0
                        int r4 = r4 + r1
                        int r3 = r3 + (-1)
                        r1 = 2
                        goto L13
                    L52:
                        java.lang.Object r7 = (java.lang.Object) r7
                        int r0 = r7.hashCode()
                        r1 = 5
                        goto L13
                    L5a:
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4P.hashCode():int");
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:            return r1;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean isEmpty() {
                    /*
                        r2 = this;
                        r1 = 0
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        int r0 = r0.A04()
                        if (r0 != 0) goto L14
                        r0 = 2
                    La:
                        switch(r0) {
                            case 2: goto Le;
                            case 3: goto L16;
                            case 4: goto L11;
                            default: goto Ld;
                        }
                    Ld:
                        goto La
                    Le:
                        r1 = 1
                        r0 = 3
                        goto La
                    L11:
                        r1 = 0
                        r0 = 3
                        goto La
                    L14:
                        r0 = 4
                        goto La
                    L16:
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4P.isEmpty():boolean");
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection, java.lang.Iterable
                public final Iterator<Map.Entry<K, V>> iterator() {
                    return new C4R(C4I.this);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean remove(Object obj) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean removeAll(Collection<?> collection) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean retainAll(Collection<?> collection) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final int size() {
                    return C4I.this.A04();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final Object[] toArray() {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4P != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final <T> T[] toArray(T[] tArr) {
                    throw new UnsupportedOperationException();
                }
            };
        }
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4I != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    public final Set<K> A0C() {
        if (this.A01 == null) {
            this.A01 = new Set<K>() { // from class: com.facebook.ads.redexgen.X.4Q
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean add(K k) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean addAll(Collection<? extends K> collection) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final void clear() {
                    C4I.this.A0D();
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:            return r1;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean contains(java.lang.Object r3) {
                    /*
                        r2 = this;
                        r1 = 0
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        int r0 = r0.A05(r3)
                        if (r0 < 0) goto L14
                        r0 = 2
                    La:
                        switch(r0) {
                            case 2: goto Le;
                            case 3: goto L16;
                            case 4: goto L11;
                            default: goto Ld;
                        }
                    Ld:
                        goto La
                    Le:
                        r1 = 1
                        r0 = 3
                        goto La
                    L11:
                        r1 = 0
                        r0 = 3
                        goto La
                    L14:
                        r0 = 4
                        goto La
                    L16:
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4Q.contains(java.lang.Object):boolean");
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean containsAll(Collection<?> collection) {
                    return C4I.A00(C4I.this.A0A(), collection);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean equals(Object obj) {
                    return C4I.A03(this, obj);
                }

                /* JADX WARN: Code restructure failed: missing block: B:31:0x0039, code lost:            return r2;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final int hashCode() {
                    /*
                        r7 = this;
                        r6 = r7
                        r0 = 0
                        r5 = 0
                        r0 = 0
                        r0 = 0
                        r4 = 0
                        r3 = 0
                        r2 = 0
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        int r0 = r0.A04()
                        int r1 = r0 + (-1)
                        r0 = 2
                    L11:
                        switch(r0) {
                            case 2: goto L33;
                            case 3: goto L25;
                            case 4: goto L22;
                            case 5: goto L1d;
                            case 6: goto L15;
                            case 7: goto L39;
                            default: goto L14;
                        }
                    L14:
                        goto L11
                    L15:
                        java.lang.Object r4 = (java.lang.Object) r4
                        int r5 = r4.hashCode()
                        r0 = 5
                        goto L11
                    L1d:
                        int r2 = r2 + r5
                        int r1 = r1 + (-1)
                        r0 = 2
                        goto L11
                    L22:
                        r5 = r3
                        r0 = 5
                        goto L11
                    L25:
                        com.facebook.ads.redexgen.X.4Q r6 = (com.facebook.ads.redexgen.X.C4Q) r6
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        java.lang.Object r4 = r0.A07(r1, r3)
                        if (r4 != 0) goto L31
                        r0 = 4
                        goto L11
                    L31:
                        r0 = 6
                        goto L11
                    L33:
                        if (r1 < 0) goto L37
                        r0 = 3
                        goto L11
                    L37:
                        r0 = 7
                        goto L11
                    L39:
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4Q.hashCode():int");
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:            return r1;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean isEmpty() {
                    /*
                        r2 = this;
                        r1 = 0
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        int r0 = r0.A04()
                        if (r0 != 0) goto L14
                        r0 = 2
                    La:
                        switch(r0) {
                            case 2: goto Le;
                            case 3: goto L16;
                            case 4: goto L11;
                            default: goto Ld;
                        }
                    Ld:
                        goto La
                    Le:
                        r1 = 1
                        r0 = 3
                        goto La
                    L11:
                        r1 = 0
                        r0 = 3
                        goto La
                    L14:
                        r0 = 4
                        goto La
                    L16:
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4Q.isEmpty():boolean");
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection, java.lang.Iterable
                public final Iterator<K> iterator() {
                    return new C4O(C4I.this, 0);
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:            return r2;     */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean remove(java.lang.Object r5) {
                    /*
                        r4 = this;
                        r3 = r4
                        r2 = 0
                        r0 = 0
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        int r1 = r0.A05(r5)
                        if (r1 < 0) goto L1d
                        r0 = 2
                    Lc:
                        switch(r0) {
                            case 2: goto L10;
                            case 3: goto L1f;
                            case 4: goto L1a;
                            default: goto Lf;
                        }
                    Lf:
                        goto Lc
                    L10:
                        com.facebook.ads.redexgen.X.4Q r3 = (com.facebook.ads.redexgen.X.C4Q) r3
                        com.facebook.ads.redexgen.X.4I r0 = com.facebook.ads.redexgen.X.C4I.this
                        r0.A0E(r1)
                        r2 = 1
                        r0 = 3
                        goto Lc
                    L1a:
                        r2 = 0
                        r0 = 3
                        goto Lc
                    L1d:
                        r0 = 4
                        goto Lc
                    L1f:
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4Q.remove(java.lang.Object):boolean");
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean removeAll(Collection<?> collection) {
                    return C4I.A01(C4I.this.A0A(), collection);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean retainAll(Collection<?> collection) {
                    return C4I.A02(C4I.this.A0A(), collection);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final int size() {
                    return C4I.this.A04();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final Object[] toArray() {
                    return C4I.this.A0G(0);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4Q != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final <T> T[] toArray(T[] tArr) {
                    return (T[]) C4I.this.A0H(tArr, 0);
                }
            };
        }
        return this.A01;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:            return r2;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4I != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object[] A0G(int r6) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            r0 = 0
            int r3 = r4.A04()
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L16;
                case 4: goto L24;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            if (r1 >= r3) goto L14
            r0 = 3
            goto Lc
        L14:
            r0 = 4
            goto Lc
        L16:
            com.facebook.ads.redexgen.X.4I r4 = (com.facebook.ads.redexgen.X.C4I) r4
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            java.lang.Object r0 = r4.A07(r1, r6)
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L24:
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4I.A0G(int):java.lang.Object[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0052, code lost:            return (T[]) r5;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4I != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> T[] A0H(T[] r5, int r6) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            int r1 = r3.A04()
            int r0 = r5.length
            if (r0 >= r1) goto L4c
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L30;
                case 3: goto L2d;
                case 4: goto L27;
                case 5: goto L19;
                case 6: goto Lf;
                case 7: goto L44;
                case 8: goto L4e;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            int r0 = r5.length
            if (r0 <= r1) goto L16
            r0 = 7
            goto Lb
        L16:
            r0 = 8
            goto Lb
        L19:
            com.facebook.ads.redexgen.X.4I r3 = (com.facebook.ads.redexgen.X.C4I) r3
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            java.lang.Object r0 = r3.A07(r2, r6)
            r5[r2] = r0
            int r2 = r2 + 1
            r0 = 4
            goto Lb
        L27:
            if (r2 >= r1) goto L2b
            r0 = 5
            goto Lb
        L2b:
            r0 = 6
            goto Lb
        L2d:
            r2 = 0
            r0 = 4
            goto Lb
        L30:
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            java.lang.Class r0 = r5.getClass()
            java.lang.Class r0 = r0.getComponentType()
            java.lang.Object r5 = java.lang.reflect.Array.newInstance(r0, r1)
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            r0 = 3
            goto Lb
        L44:
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            r0 = 0
            r5[r1] = r0
            r0 = 8
            goto Lb
        L4c:
            r0 = 3
            goto Lb
        L4e:
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4I.A0H(java.lang.Object[], int):java.lang.Object[]");
    }
}
