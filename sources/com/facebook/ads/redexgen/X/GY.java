package com.facebook.ads.redexgen.X;

import com.facebook.ads.redexgen.X.C1S;
import com.facebook.ads.redexgen.X.GX;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* loaded from: assets/audience_network.dex */
public final class GY<T extends C1S, E extends GX> {
    public final Map<Class<E>, List<WeakReference<T>>> A00 = new HashMap();
    public final Queue<E> A01 = new ArrayDeque();

    /* JADX WARN: Code restructure failed: missing block: B:59:0x007c, code lost:            return;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.GY != com.facebook.ads.internal.events.EventBus<T extends com.facebook.ads.redexgen.X.1S, E extends com.facebook.ads.redexgen.X.GX> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A00(E r6) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r1 = 0
            r2 = 0
            java.util.Map<java.lang.Class<E extends com.facebook.ads.redexgen.X.GX>, java.util.List<java.lang.ref.WeakReference<T extends com.facebook.ads.redexgen.X.1S>>> r0 = r4.A00
            if (r0 != 0) goto L7a
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L7c;
                case 3: goto L40;
                case 4: goto L2f;
                case 5: goto L22;
                case 6: goto Ld;
                case 7: goto L56;
                case 8: goto L6b;
                case 9: goto L19;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            java.util.Iterator r3 = (java.util.Iterator) r3
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L17
            r0 = 7
            goto L9
        L17:
            r0 = 2
            goto L9
        L19:
            com.facebook.ads.redexgen.X.GX r6 = (com.facebook.ads.redexgen.X.GX) r6
            com.facebook.ads.redexgen.X.1S r2 = (com.facebook.ads.redexgen.X.C1S) r2
            r2.A03(r6)
            r0 = 6
            goto L9
        L22:
            java.util.List r1 = (java.util.List) r1
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r1)
            java.util.Iterator r3 = r0.iterator()
            r0 = 6
            goto L9
        L2f:
            com.facebook.ads.redexgen.X.GY r4 = (com.facebook.ads.redexgen.X.GY) r4
            java.util.List r1 = (java.util.List) r1
            r4.A01(r1)
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L3e
            r0 = 5
            goto L9
        L3e:
            r0 = 2
            goto L9
        L40:
            com.facebook.ads.redexgen.X.GY r4 = (com.facebook.ads.redexgen.X.GY) r4
            com.facebook.ads.redexgen.X.GX r6 = (com.facebook.ads.redexgen.X.GX) r6
            java.util.Map<java.lang.Class<E extends com.facebook.ads.redexgen.X.GX>, java.util.List<java.lang.ref.WeakReference<T extends com.facebook.ads.redexgen.X.1S>>> r1 = r4.A00
            java.lang.Class r0 = r6.getClass()
            java.lang.Object r1 = r1.get(r0)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L54
            r0 = 4
            goto L9
        L54:
            r0 = 2
            goto L9
        L56:
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r0 = r3.next()
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            java.lang.Object r2 = r0.get()
            com.facebook.ads.redexgen.X.1S r2 = (com.facebook.ads.redexgen.X.C1S) r2
            if (r2 == 0) goto L69
            r0 = 8
            goto L9
        L69:
            r0 = 6
            goto L9
        L6b:
            com.facebook.ads.redexgen.X.GX r6 = (com.facebook.ads.redexgen.X.GX) r6
            com.facebook.ads.redexgen.X.1S r2 = (com.facebook.ads.redexgen.X.C1S) r2
            boolean r0 = r2.A00(r6)
            if (r0 == 0) goto L78
            r0 = 9
            goto L9
        L78:
            r0 = 6
            goto L9
        L7a:
            r0 = 3
            goto L9
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GY.A00(com.facebook.ads.redexgen.X.GX):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x005d, code lost:            return;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.GY != com.facebook.ads.internal.events.EventBus<T extends com.facebook.ads.redexgen.X.1S, E extends com.facebook.ads.redexgen.X.GX> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01(java.util.List<java.lang.ref.WeakReference<T>> r6) {
        /*
            r5 = this;
            r4 = 0
            r3 = 0
            r2 = 0
            r1 = 0
            if (r6 == 0) goto L5a
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L39;
                case 3: goto L2d;
                case 4: goto L1b;
                case 5: goto Lf;
                case 6: goto Lb;
                case 7: goto L3d;
                case 8: goto L48;
                case 9: goto L50;
                case 10: goto L5d;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            int r1 = r1 + 1
            r0 = 3
            goto L7
        Lf:
            java.util.List r6 = (java.util.List) r6
            java.lang.ref.WeakReference r4 = (java.lang.ref.WeakReference) r4
            int r0 = r3 + 1
            r6.set(r3, r4)
            r3 = r0
            r0 = 6
            goto L7
        L1b:
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r4 = r6.get(r1)
            java.lang.ref.WeakReference r4 = (java.lang.ref.WeakReference) r4
            java.lang.Object r0 = r4.get()
            if (r0 == 0) goto L2b
            r0 = 5
            goto L7
        L2b:
            r0 = 6
            goto L7
        L2d:
            java.util.List r6 = (java.util.List) r6
            int r0 = r6.size()
            if (r1 >= r0) goto L37
            r0 = 4
            goto L7
        L37:
            r0 = 7
            goto L7
        L39:
            r3 = 0
            r1 = 0
            r0 = 3
            goto L7
        L3d:
            java.util.List r6 = (java.util.List) r6
            int r0 = r6.size()
            int r2 = r0 + (-1)
            r0 = 8
            goto L7
        L48:
            if (r2 < r3) goto L4d
            r0 = 9
            goto L7
        L4d:
            r0 = 10
            goto L7
        L50:
            java.util.List r6 = (java.util.List) r6
            r6.remove(r2)
            int r2 = r2 + (-1)
            r0 = 8
            goto L7
        L5a:
            r0 = 10
            goto L7
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GY.A01(java.util.List):void");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.GY != com.facebook.ads.internal.events.EventBus<T extends com.facebook.ads.redexgen.X.1S, E extends com.facebook.ads.redexgen.X.GX> */
    public final synchronized void A02(E e) {
        if (this.A01.isEmpty()) {
            this.A01.add(e);
            while (!this.A01.isEmpty()) {
                E event = this.A01.peek();
                A00(event);
                this.A01.remove();
            }
        } else {
            this.A01.add(e);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.GY != com.facebook.ads.internal.events.EventBus<T extends com.facebook.ads.redexgen.X.1S, E extends com.facebook.ads.redexgen.X.GX> */
    public final synchronized void A03(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                A05(t);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.GY != com.facebook.ads.internal.events.EventBus<T extends com.facebook.ads.redexgen.X.1S, E extends com.facebook.ads.redexgen.X.GX> */
    public final synchronized void A04(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                A06(t);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:            r4 = r3.add(new java.lang.ref.WeakReference<>(r6));     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.GY != com.facebook.ads.internal.events.EventBus<T extends com.facebook.ads.redexgen.X.1S, E extends com.facebook.ads.redexgen.X.GX> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean A05(T r6) {
        /*
            r5 = this;
            r4 = 0
            monitor-enter(r5)
            if (r6 != 0) goto L6
        L4:
            monitor-exit(r5)
            return r4
        L6:
            java.lang.Class r2 = r6.A01()     // Catch: java.lang.Throwable -> L48
            java.util.Map<java.lang.Class<E extends com.facebook.ads.redexgen.X.GX>, java.util.List<java.lang.ref.WeakReference<T extends com.facebook.ads.redexgen.X.1S>>> r0 = r5.A00     // Catch: java.lang.Throwable -> L48
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L48
            if (r0 != 0) goto L1c
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L48
            r1.<init>()     // Catch: java.lang.Throwable -> L48
            java.util.Map<java.lang.Class<E extends com.facebook.ads.redexgen.X.GX>, java.util.List<java.lang.ref.WeakReference<T extends com.facebook.ads.redexgen.X.1S>>> r0 = r5.A00     // Catch: java.lang.Throwable -> L48
            r0.put(r2, r1)     // Catch: java.lang.Throwable -> L48
        L1c:
            java.util.Map<java.lang.Class<E extends com.facebook.ads.redexgen.X.GX>, java.util.List<java.lang.ref.WeakReference<T extends com.facebook.ads.redexgen.X.1S>>> r0 = r5.A00     // Catch: java.lang.Throwable -> L48
            java.lang.Object r3 = r0.get(r2)     // Catch: java.lang.Throwable -> L48
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> L48
            r5.A01(r3)     // Catch: java.lang.Throwable -> L48
            r2 = 0
            int r1 = r3.size()     // Catch: java.lang.Throwable -> L48
        L2c:
            if (r2 >= r1) goto L3e
            java.lang.Object r0 = r3.get(r2)     // Catch: java.lang.Throwable -> L48
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch: java.lang.Throwable -> L48
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L48
            if (r0 != r6) goto L3b
            goto L4
        L3b:
            int r2 = r2 + 1
            goto L2c
        L3e:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch: java.lang.Throwable -> L48
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L48
            boolean r4 = r3.add(r0)     // Catch: java.lang.Throwable -> L48
            goto L4
        L48:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GY.A05(com.facebook.ads.redexgen.X.1S):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:            r3.get(r2).clear();     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:            r4 = true;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.GY != com.facebook.ads.internal.events.EventBus<T extends com.facebook.ads.redexgen.X.1S, E extends com.facebook.ads.redexgen.X.GX> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean A06(@android.support.annotation.Nullable T r6) {
        /*
            r5 = this;
            r4 = 0
            monitor-enter(r5)
            if (r6 != 0) goto L6
        L4:
            monitor-exit(r5)
            return r4
        L6:
            java.util.Map<java.lang.Class<E extends com.facebook.ads.redexgen.X.GX>, java.util.List<java.lang.ref.WeakReference<T extends com.facebook.ads.redexgen.X.1S>>> r1 = r5.A00     // Catch: java.lang.Throwable -> L37
            java.lang.Class r0 = r6.A01()     // Catch: java.lang.Throwable -> L37
            java.lang.Object r3 = r1.get(r0)     // Catch: java.lang.Throwable -> L37
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> L37
            if (r3 != 0) goto L15
            goto L4
        L15:
            r2 = 0
            int r1 = r3.size()     // Catch: java.lang.Throwable -> L37
        L1a:
            if (r2 >= r1) goto L4
            java.lang.Object r0 = r3.get(r2)     // Catch: java.lang.Throwable -> L37
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch: java.lang.Throwable -> L37
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L37
            if (r0 != r6) goto L32
            java.lang.Object r0 = r3.get(r2)     // Catch: java.lang.Throwable -> L37
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch: java.lang.Throwable -> L37
            r0.clear()     // Catch: java.lang.Throwable -> L37
            goto L35
        L32:
            int r2 = r2 + 1
            goto L1a
        L35:
            r4 = 1
            goto L4
        L37:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GY.A06(com.facebook.ads.redexgen.X.1S):boolean");
    }
}
