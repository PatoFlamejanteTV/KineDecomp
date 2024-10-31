package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* renamed from: com.facebook.ads.redexgen.X.45, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass45 {
    public static byte[] A03;

    @Nullable
    public C0432Gv A00;
    public final List<String> A02 = new ArrayList();
    public final List<String> A01 = new ArrayList();

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
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass45.A03
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
            int r0 = r0 + (-57)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass45.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A03 = new byte[]{-58, -19, -31, -18, -31, -25, -27, -33, -31, -28, -33, -16, -14, -27, -26, -27, -14, -27, -18, -29, -27, -13, 41, 39, 25, 38, 19, 30, 35, 41, 38, 34, 25, 45, -49, -64, -47, -73, -71, -59, -73, -63, -73, -53, -67, -67, -63, -58, -65, -73, -52, -64, -63, -53, -81, -80, -99, -82, -80, -85, -84, -80, -91, -85, -86, -81, -101, -81, -95, -88, -95, -97, -80, -95, -96, 9, 15, 24, 14};
    }

    public AnonymousClass45() {
    }

    public AnonymousClass45(C0432Gv c0432Gv) {
        this.A00 = c0432Gv;
    }

    public final Map<String, String> A02() {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(22, 12, 123), new JSONArray((Collection) this.A02).toString());
        hashMap.put(A00(59, 16, 3), new JSONArray((Collection) this.A01).toString());
        return hashMap;
    }

    public final void A03() {
        this.A02.clear();
        this.A01.clear();
    }

    public final void A04() {
        this.A02.add(A00(1, 21, 71));
        if (this.A00 != null) {
            this.A00.A02(EnumC0431Gu.A0A, null);
        }
    }

    public final void A05() {
        this.A02.add(A00(54, 5, 3));
    }

    public final void A06() {
        this.A02.add(A00(34, 20, 31));
        if (this.A00 != null) {
            this.A00.A02(EnumC0431Gu.A0B, null);
        }
    }

    public final void A07(int i) {
        this.A01.add(String.valueOf(i));
    }

    public final void A08(AnonymousClass44 anonymousClass44) {
        this.A02.add(anonymousClass44.A02() + A00(75, 4, 113));
        if (this.A00 != null) {
            this.A00.A02(EnumC0431Gu.A08, null);
        }
    }

    public final void A09(AnonymousClass44 anonymousClass44, int i) {
        this.A02.add(anonymousClass44.A02() + A00(0, 1, 46) + i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0025, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0A() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            java.util.List<java.lang.String> r0 = r2.A02
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L23
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L1d;
                case 4: goto L25;
                case 5: goto L20;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.45 r2 = (com.facebook.ads.redexgen.X.AnonymousClass45) r2
            java.util.List<java.lang.String> r0 = r2.A01
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L1b
            r0 = 3
            goto Lb
        L1b:
            r0 = 5
            goto Lb
        L1d:
            r1 = 1
            r0 = 4
            goto Lb
        L20:
            r1 = 0
            r0 = 4
            goto Lb
        L23:
            r0 = 3
            goto Lb
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass45.A0A():boolean");
    }
}
