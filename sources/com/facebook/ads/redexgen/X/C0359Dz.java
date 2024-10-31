package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.List;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Dz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0359Dz<T> extends AbstractC0351Dr<List<T>> {
    public static byte[] A02;
    public final E8 A00;
    public final List<T> A01;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0359Dz.A02
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
            r0 = r0 ^ 90
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0359Dz.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{62};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dz != com.facebook.ads.internal.botdetection.signals.model.signal_value.ListSignalValueType<T> */
    public C0359Dz(long j, @Nullable E7 e7, List<T> signalValue, E8 e8) {
        super(j, e7, signalValue, E8.A08);
        this.A01 = signalValue;
        this.A00 = e8;
        if (!A04()) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000f. Please report as an issue. */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dz != com.facebook.ads.internal.botdetection.signals.model.signal_value.ListSignalValueType<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private int A00(T t) {
        char c;
        int i = 0;
        switch (this.A00) {
            case A06:
                c = 4;
                break;
            case A0C:
                c = 5;
                break;
            case A03:
                c = 3;
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
                    t = (T) t;
                    i = ((InterfaceC0292Bk) t).A8O();
                    c = 6;
                case 4:
                    i = 4;
                    c = 6;
                case 5:
                    t = t;
                    i = ((String) t).length();
                    c = 6;
                case 6:
                    return i;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:            return r2;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dz != com.facebook.ads.internal.botdetection.signals.model.signal_value.ListSignalValueType<T> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A04() {
        /*
            r3 = this;
            r2 = 0
            int[] r1 = com.facebook.ads.redexgen.X.C0358Dy.A00
            com.facebook.ads.redexgen.X.E8 r0 = r3.A00
            int r0 = r0.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L19;
                case 2: goto L1b;
                case 3: goto L1d;
                default: goto Le;
            }
        Le:
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L13;
                case 3: goto L1f;
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
            r0 = 4
            goto Lf
        L1f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0359Dz.A04():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0055, code lost:            return r2;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dz != com.facebook.ads.internal.botdetection.signals.model.signal_value.ListSignalValueType<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A06() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r2 = 0
            r0 = 0
            r1 = 0
            java.lang.Object r0 = r4.A07()
            if (r0 == 0) goto L53
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L3e;
                case 3: goto L2b;
                case 4: goto L55;
                case 5: goto L1d;
                case 6: goto L10;
                case 7: goto L2f;
                case 8: goto L50;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            java.util.Iterator r3 = (java.util.Iterator) r3
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L1a
            r0 = 7
            goto Lc
        L1a:
            r0 = 8
            goto Lc
        L1d:
            com.facebook.ads.redexgen.X.Dz r4 = (com.facebook.ads.redexgen.X.C0359Dz) r4
            java.lang.Object r0 = r4.A07()
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r3 = r0.iterator()
            r0 = 6
            goto Lc
        L2b:
            r1 = 0
            r2 = r1
            r0 = 4
            goto Lc
        L2f:
            com.facebook.ads.redexgen.X.Dz r4 = (com.facebook.ads.redexgen.X.C0359Dz) r4
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r0 = r3.next()
            int r0 = r4.A00(r0)
            int r1 = r1 + r0
            r0 = 6
            goto Lc
        L3e:
            com.facebook.ads.redexgen.X.Dz r4 = (com.facebook.ads.redexgen.X.C0359Dz) r4
            java.lang.Object r0 = r4.A07()
            java.util.List r0 = (java.util.List) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L4e
            r0 = 3
            goto Lc
        L4e:
            r0 = 5
            goto Lc
        L50:
            r2 = r1
            r0 = 4
            goto Lc
        L53:
            r0 = 3
            goto Lc
        L55:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0359Dz.A06():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0056, code lost:            r7 = r7;        r7.put(A01(0, 1, 18), r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:            return r7;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dz != com.facebook.ads.internal.botdetection.signals.model.signal_value.ListSignalValueType<T> */
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
            org.json.JSONArray r3 = new org.json.JSONArray
            r3.<init>()
            java.util.List<T> r0 = r5.A01
            java.util.Iterator r2 = r0.iterator()
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L20;
                case 4: goto L3d;
                case 5: goto L4d;
                case 6: goto L56;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            java.util.Iterator r2 = (java.util.Iterator) r2
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L1e
            r0 = 3
            goto L10
        L1e:
            r0 = 6
            goto L10
        L20:
            com.facebook.ads.redexgen.X.Dz r5 = (com.facebook.ads.redexgen.X.C0359Dz) r5
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r2.next()
            int[] r1 = com.facebook.ads.redexgen.X.C0358Dy.A00
            com.facebook.ads.redexgen.X.E8 r0 = r5.A00
            int r0 = r0.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L37;
                case 2: goto L39;
                case 3: goto L3b;
                default: goto L35;
            }
        L35:
            r0 = 2
            goto L10
        L37:
            r0 = 5
            goto L10
        L39:
            r0 = 5
            goto L10
        L3b:
            r0 = 4
            goto L10
        L3d:
            org.json.JSONArray r3 = (org.json.JSONArray) r3
            java.lang.Object r4 = (java.lang.Object) r4
            r0 = r4
            com.facebook.ads.redexgen.X.Bk r0 = (com.facebook.ads.redexgen.X.InterfaceC0292Bk) r0
            org.json.JSONObject r0 = r0.A8R()
            r3.put(r0)
            r0 = 2
            goto L10
        L4d:
            org.json.JSONArray r3 = (org.json.JSONArray) r3
            java.lang.Object r4 = (java.lang.Object) r4
            r3.put(r4)
            r0 = 2
            goto L10
        L56:
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            org.json.JSONArray r3 = (org.json.JSONArray) r3
            r2 = 0
            r1 = 1
            r0 = 18
            java.lang.String r0 = A01(r2, r1, r0)
            r7.put(r0, r3)
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0359Dz.A08(org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x00d5, code lost:            return r8;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<java.util.List<T>> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dz != com.facebook.ads.internal.botdetection.signals.model.signal_value.ListSignalValueType<T> */
    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0A(com.facebook.ads.redexgen.X.AbstractC0351Dr<java.util.List<T>> r12) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0359Dz.A0A(com.facebook.ads.redexgen.X.Dr):boolean");
    }
}
