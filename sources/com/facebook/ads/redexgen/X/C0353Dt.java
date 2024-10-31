package com.facebook.ads.redexgen.X;

import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Dt, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0353Dt<T> extends AbstractC0351Dr<InterfaceC0292Bk> {
    public static byte[] A00;

    static {
        A01();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0353Dt.A00
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
            int r0 = r0 + (-27)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0353Dt.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{-92};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dt != com.facebook.ads.internal.botdetection.signals.model.signal_value.CustomObjectSignalValueType<T> */
    public C0353Dt(long j, @Nullable E7 e7, InterfaceC0292Bk interfaceC0292Bk) {
        super(j, e7, interfaceC0292Bk, E8.A03);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dt != com.facebook.ads.internal.botdetection.signals.model.signal_value.CustomObjectSignalValueType<T> */
    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    public final int A06() {
        return ((InterfaceC0292Bk) A07()).A8O();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dt != com.facebook.ads.internal.botdetection.signals.model.signal_value.CustomObjectSignalValueType<T> */
    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    public final JSONObject A08(JSONObject jSONObject) throws JSONException {
        return jSONObject.put(A00(0, 1, 19), ((InterfaceC0292Bk) A07()).A8R());
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x004e, code lost:            return r1;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<com.facebook.ads.internal.botdetection.signals.model.signal_value.ICustomObjectSignalValueDef> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dt != com.facebook.ads.internal.botdetection.signals.model.signal_value.CustomObjectSignalValueType<T> */
    @Override // com.facebook.ads.redexgen.X.AbstractC0351Dr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0A(com.facebook.ads.redexgen.X.AbstractC0351Dr<com.facebook.ads.redexgen.X.InterfaceC0292Bk> r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            java.lang.Object r0 = r2.A07()
            if (r0 == 0) goto L4c
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L28;
                case 3: goto L1c;
                case 4: goto L10;
                case 5: goto Ld;
                case 6: goto L4e;
                case 7: goto L35;
                case 8: goto L38;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 1
            r0 = 6
            goto L9
        L10:
            com.facebook.ads.redexgen.X.Dr r4 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r4
            java.lang.Object r0 = r4.A07()
            if (r0 != 0) goto L1a
            r0 = 5
            goto L9
        L1a:
            r0 = 7
            goto L9
        L1c:
            com.facebook.ads.redexgen.X.Dt r2 = (com.facebook.ads.redexgen.X.C0353Dt) r2
            java.lang.Object r0 = r2.A07()
            if (r0 != 0) goto L26
            r0 = 4
            goto L9
        L26:
            r0 = 7
            goto L9
        L28:
            com.facebook.ads.redexgen.X.Dr r4 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r4
            java.lang.Object r0 = r4.A07()
            if (r0 != 0) goto L32
            r0 = 3
            goto L9
        L32:
            r0 = 8
            goto L9
        L35:
            r1 = 0
            r0 = 6
            goto L9
        L38:
            com.facebook.ads.redexgen.X.Dt r2 = (com.facebook.ads.redexgen.X.C0353Dt) r2
            com.facebook.ads.redexgen.X.Dr r4 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r4
            java.lang.Object r1 = r2.A07()
            com.facebook.ads.redexgen.X.Bk r1 = (com.facebook.ads.redexgen.X.InterfaceC0292Bk) r1
            java.lang.Object r0 = r4.A07()
            boolean r1 = r1.A5B(r0)
            r0 = 6
            goto L9
        L4c:
            r0 = 3
            goto L9
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0353Dt.A0A(com.facebook.ads.redexgen.X.Dr):boolean");
    }
}
