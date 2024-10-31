package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.2h, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00622h extends C2I implements Serializable {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 2751287062553772011L;

    static {
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C00622h.A00
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
            r0 = r0 ^ 3
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00622h.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A00 = new byte[]{99, 116, 102, 112, 99, 117, 116, 117, 78, 103, 120, 117, 116, 126};
    }

    public C00622h(List<C2L> list) {
        super(list);
    }

    public static C00622h A01(JSONObject jSONObject) {
        C2L mAdInfo = C2L.A00(jSONObject);
        mAdInfo.A0J(true);
        mAdInfo.A0I(jSONObject);
        ArrayList arrayList = new ArrayList();
        arrayList.add(mAdInfo);
        C00622h c00622h = new C00622h(arrayList);
        c00622h.A0d(jSONObject);
        c00622h.A0b(A02(0, 14, 18));
        return c00622h;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.C2I
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0H() {
        /*
            r2 = this;
            r1 = 0
            com.facebook.ads.redexgen.X.2L r0 = r2.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            com.facebook.ads.redexgen.X.2e r0 = r0.A05()
            if (r0 == 0) goto L1a
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L1c;
                case 4: goto L17;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            r1 = 1
            r0 = 3
            goto L10
        L17:
            r1 = 0
            r0 = 3
            goto L10
        L1a:
            r0 = 4
            goto L10
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00622h.A0H():int");
    }

    @Override // com.facebook.ads.redexgen.X.C2I
    public final int A0I() {
        return A0L().A0D().A04();
    }
}
