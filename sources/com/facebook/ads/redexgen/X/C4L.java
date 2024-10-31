package com.facebook.ads.redexgen.X;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: com.facebook.ads.redexgen.X.4L, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C4L<K, V> extends C4K<K, V> implements Map<K, V> {
    public C4I<K, V> A00;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4L != com.facebook.ads.internal.androidx.support.v4.util.ArrayMap<K, V> */
    private C4I<K, V> A00() {
        if (this.A00 == null) {
            this.A00 = new C4I<K, V>() { // from class: com.facebook.ads.redexgen.X.4J
                @Override // com.facebook.ads.redexgen.X.C4I
                public final int A04() {
                    return ((C4K) C4L.this).A00;
                }

                @Override // com.facebook.ads.redexgen.X.C4I
                public final int A05(Object obj) {
                    return C4L.this.A08(obj);
                }

                @Override // com.facebook.ads.redexgen.X.C4I
                public final int A06(Object obj) {
                    return C4L.this.A07(obj);
                }

                @Override // com.facebook.ads.redexgen.X.C4I
                public final Object A07(int i, int i2) {
                    return C4L.this.A02[(i << 1) + i2];
                }

                @Override // com.facebook.ads.redexgen.X.C4I
                public final V A08(int i, V v) {
                    V value = C4L.this.A0C(i, v);
                    return value;
                }

                @Override // com.facebook.ads.redexgen.X.C4I
                public final Map<K, V> A0A() {
                    return C4L.this;
                }

                @Override // com.facebook.ads.redexgen.X.C4I
                public final void A0D() {
                    C4L.this.clear();
                }

                @Override // com.facebook.ads.redexgen.X.C4I
                public final void A0E(int i) {
                    C4L.this.A0A(i);
                }

                @Override // com.facebook.ads.redexgen.X.C4I
                public final void A0F(K k, V v) {
                    C4L.this.put(k, v);
                }
            };
        }
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4L != com.facebook.ads.internal.androidx.support.v4.util.ArrayMap<K, V> */
    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return A00().A0B();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4L != com.facebook.ads.internal.androidx.support.v4.util.ArrayMap<K, V> */
    @Override // java.util.Map
    public final Set<K> keySet() {
        return A00().A0C();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:            return;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4L != com.facebook.ads.internal.androidx.support.v4.util.ArrayMap<K, V> */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void putAll(java.util.Map<? extends K, ? extends V> r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            int r1 = r3.A00
            int r0 = r5.size()
            int r1 = r1 + r0
            r3.A0D(r1)
            java.util.Set r0 = r5.entrySet()
            java.util.Iterator r2 = r0.iterator()
            r0 = 2
        L15:
            switch(r0) {
                case 2: goto L19;
                case 3: goto L25;
                case 4: goto L3c;
                default: goto L18;
            }
        L18:
            goto L15
        L19:
            java.util.Iterator r2 = (java.util.Iterator) r2
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L23
            r0 = 3
            goto L15
        L23:
            r0 = 4
            goto L15
        L25:
            com.facebook.ads.redexgen.X.4L r3 = (com.facebook.ads.redexgen.X.C4L) r3
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r0 = r2.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.Object r0 = r0.getValue()
            r3.put(r1, r0)
            r0 = 2
            goto L15
        L3c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4L.putAll(java.util.Map):void");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4L != com.facebook.ads.internal.androidx.support.v4.util.ArrayMap<K, V> */
    @Override // java.util.Map
    public final Collection<V> values() {
        return A00().A09();
    }
}
