package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.HashMap;
import javax.annotation.Nullable;

/* loaded from: assets/audience_network.dex */
public final class E2<K, V> extends AbstractC0351Dr<HashMap<K, BI>> {
    public static byte[] A02;
    public final E8 A00;
    public final HashMap<K, BI> A01;

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.E2.A02
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
            int r0 = r0 - r4
            int r0 = r0 + (-80)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.E2.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{65};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.E2 != com.facebook.ads.internal.botdetection.signals.model.signal_value.MapSignalValueType<K, V> */
    public E2(long j, @Nullable E7 e7, HashMap<K, BI> hashMap, E8 e8) {
        super(j, e7, hashMap, E8.A0A);
        this.A01 = hashMap;
        this.A00 = e8;
        if (!A04()) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000f. Please report as an issue. */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.E2 != com.facebook.ads.internal.botdetection.signals.model.signal_value.MapSignalValueType<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private int A00(K k) {
        char c;
        int i = 0;
        switch (E1.A00[this.A00.ordinal()]) {
            case 1:
                c = 3;
                break;
            case 2:
                c = 4;
                break;
            default:
                c = 2;
                break;
        }
        while (true) {
            switch (c) {
                case 2:
                    throw new UnsupportedOperationException();
                case 3:
                    i = 4;
                    c = 5;
                case 4:
                    k = k;
                    i = ((String) k).length();
                    c = 5;
                case 5:
                    return i;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:            return r2;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.E2 != com.facebook.ads.internal.botdetection.signals.model.signal_value.MapSignalValueType<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A04() {
        /*
            r3 = this;
            r2 = 0
            int[] r1 = com.facebook.ads.redexgen.X.E1.A00
            com.facebook.ads.redexgen.X.E8 r0 = r3.A00
            int r0 = r0.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L19;
                case 2: goto L1b;
                default: goto Le;
            }
        Le:
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L13;
                case 3: goto L1d;
                case 4: goto L16;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            r2 = 0
            r0 = 3
            goto Lf
        L16:
            r2 = 1
            r0 = 3
            goto Lf
        L19:
            r0 = 4
            goto Lf
        L1b:
            r0 = 4
            goto Lf
        L1d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.E2.A04():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x006a, code lost:            return r3;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.E2 != com.facebook.ads.internal.botdetection.signals.model.signal_value.MapSignalValueType<K, V> */
    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A06() {
        /*
            r6 = this;
            r4 = r6
            r5 = 0
            r3 = 0
            r0 = 0
            r2 = 0
            java.lang.Object r0 = r4.A07()
            if (r0 == 0) goto L68
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L53;
                case 3: goto L4f;
                case 4: goto L6a;
                case 5: goto L1d;
                case 6: goto L10;
                case 7: goto L2f;
                case 8: goto L65;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            java.util.Iterator r5 = (java.util.Iterator) r5
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L1a
            r0 = 7
            goto Lc
        L1a:
            r0 = 8
            goto Lc
        L1d:
            com.facebook.ads.redexgen.X.E2 r4 = (com.facebook.ads.redexgen.X.E2) r4
            java.lang.Object r0 = r4.A07()
            java.util.HashMap r0 = (java.util.HashMap) r0
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r5 = r0.iterator()
            r0 = 6
            goto Lc
        L2f:
            com.facebook.ads.redexgen.X.E2 r4 = (com.facebook.ads.redexgen.X.E2) r4
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r1 = r5.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r0 = r1.getKey()
            int r0 = r4.A00(r0)
            int r2 = r2 + r0
            java.lang.Object r0 = r1.getValue()
            com.facebook.ads.redexgen.X.BI r0 = (com.facebook.ads.redexgen.X.BI) r0
            int r0 = r0.A8O()
            int r2 = r2 + r0
            r0 = 6
            goto Lc
        L4f:
            r2 = 0
            r3 = r2
            r0 = 4
            goto Lc
        L53:
            com.facebook.ads.redexgen.X.E2 r4 = (com.facebook.ads.redexgen.X.E2) r4
            java.lang.Object r0 = r4.A07()
            java.util.HashMap r0 = (java.util.HashMap) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L63
            r0 = 3
            goto Lc
        L63:
            r0 = 5
            goto Lc
        L65:
            r3 = r2
            r0 = 4
            goto Lc
        L68:
            r0 = 3
            goto Lc
        L6a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.E2.A06():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:            r7 = r7;        r7.put(A01(0, 1, 123), r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:            return r7;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.E2 != com.facebook.ads.internal.botdetection.signals.model.signal_value.MapSignalValueType<K, V> */
    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject A08(org.json.JSONObject r7) throws org.json.JSONException {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r0 = 0
            r0 = 0
            r2 = 0
            java.util.HashMap<K, com.facebook.ads.redexgen.X.BI> r0 = r5.A01
            java.util.Set r0 = r0.keySet()
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.util.Iterator r1 = r0.iterator()
            r0 = 2
        L15:
            switch(r0) {
                case 2: goto L19;
                case 3: goto L25;
                case 4: goto L3b;
                case 5: goto L46;
                default: goto L18;
            }
        L18:
            goto L15
        L19:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L23
            r0 = 3
            goto L15
        L23:
            r0 = 5
            goto L15
        L25:
            com.facebook.ads.redexgen.X.E2 r5 = (com.facebook.ads.redexgen.X.E2) r5
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r2 = r1.next()
            java.util.HashMap<K, com.facebook.ads.redexgen.X.BI> r0 = r5.A01
            java.lang.Object r4 = r0.get(r2)
            com.facebook.ads.redexgen.X.BI r4 = (com.facebook.ads.redexgen.X.BI) r4
            if (r4 == 0) goto L39
            r0 = 4
            goto L15
        L39:
            r0 = 2
            goto L15
        L3b:
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            java.lang.Object r2 = (java.lang.Object) r2
            com.facebook.ads.redexgen.X.BI r4 = (com.facebook.ads.redexgen.X.BI) r4
            r4.A8S(r2, r3)
            r0 = 2
            goto L15
        L46:
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            r2 = 0
            r1 = 1
            r0 = 123(0x7b, float:1.72E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            r7.put(r0, r3)
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.E2.A08(org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x014c, code lost:            return r11;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<java.util.HashMap<K, com.facebook.ads.internal.botdetection.signals.model.signal_value.IMapSignalValueDef>> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.E2 != com.facebook.ads.internal.botdetection.signals.model.signal_value.MapSignalValueType<K, V> */
    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    @android.annotation.SuppressLint({"Nullable Dereference"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0A(com.facebook.ads.redexgen.X.AbstractC0351Dr<java.util.HashMap<K, com.facebook.ads.redexgen.X.BI>> r15) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.E2.A0A(com.facebook.ads.redexgen.X.Dr):boolean");
    }
}
