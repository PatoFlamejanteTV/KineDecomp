package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Gv, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0432Gv {
    public static byte[] A02;
    public final InterfaceC0422Gl A00;
    public final String A01;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0432Gv.A02
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
            int r0 = r0 + (-19)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0432Gv.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A02 = new byte[]{-28, -26, -45, -27, -22, -31, -42};
    }

    public C0432Gv(String str, InterfaceC0422Gl interfaceC0422Gl) {
        this.A01 = str;
        this.A00 = interfaceC0422Gl;
    }

    public final void A02(EnumC0431Gu enumC0431Gu, @Nullable Map<String, String> map) {
        A03(enumC0431Gu.A02(), map);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:            return;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.Map, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03(java.lang.String r5, @android.support.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            r4 = this;
            r3 = r4
            java.lang.String r0 = r3.A01
            boolean r0 = com.facebook.ads.redexgen.X.C0434Gx.A0B(r0, r5)
            if (r0 != 0) goto L37
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L39;
                case 3: goto L28;
                case 4: goto L30;
                case 5: goto Le;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.Gv r3 = (com.facebook.ads.redexgen.X.C0432Gv) r3
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = (java.lang.Object) r6
            r2 = 0
            r1 = 7
            r0 = 94
            java.lang.String r0 = A00(r2, r1, r0)
            r6.put(r0, r5)
            com.facebook.ads.redexgen.X.Gl r1 = r3.A00
            java.lang.String r0 = r3.A01
            r1.A5Y(r0, r6)
            r0 = 2
            goto La
        L28:
            java.util.Map r6 = (java.util.Map) r6
            if (r6 != 0) goto L2e
            r0 = 4
            goto La
        L2e:
            r0 = 5
            goto La
        L30:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r0 = 5
            goto La
        L37:
            r0 = 3
            goto La
        L39:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0432Gv.A03(java.lang.String, java.util.Map):void");
    }
}
