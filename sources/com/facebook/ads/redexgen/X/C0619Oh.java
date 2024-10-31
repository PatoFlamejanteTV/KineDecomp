package com.facebook.ads.redexgen.X;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Oh, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0619Oh {
    public static byte[] A05;
    public final OV A00;
    public final String A01;
    public final String A02;
    public final WeakReference<InterfaceC0422Gl> A03;
    public final WeakReference<C0616Oe> A04;

    static {
        A07();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0619Oh.A05
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
            int r0 = r0 + (-21)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0619Oh.A00(int, int, int):java.lang.String");
    }

    public static void A07() {
        A05 = new byte[]{-101, -82, -86, -88, -105, -107, -102, -105, -86, -105, 7, 12, 3, -8, -86, -42, -36, -45, -53, -121, -43, -42, -37, -121, -41, -56, -39, -38, -52, -121, -38, -52, -39, -35, -52, -39, -121, -44, -52, -38, -38, -56, -50, -52, -29, -9, -10, -22, -51, -25, -5, -48, -33, -40, -40, -49, -42, -55, -34, -29, -38, -49, -98, -53, -53, -56, -53, 121, -55, -70, -53, -52, -62, -57, -64, 121, -93, -84, -88, -89, 121, -62, -57, 121, -55, -56, -52, -51, -90, -66, -52, -52, -70, -64, -66, 121, -109, -97, -99, -99, -111, -98, -108};
    }

    public C0619Oh(C0616Oe c0616Oe, InterfaceC0422Gl interfaceC0422Gl, OV ov, String str, String str2) {
        this.A04 = new WeakReference<>(c0616Oe);
        this.A03 = new WeakReference<>(interfaceC0422Gl);
        this.A00 = ov;
        this.A01 = str;
        this.A02 = str2;
    }

    private void A01() {
        C0616Oe c0616Oe = this.A04.get();
        if (c0616Oe == null) {
            return;
        }
        c0616Oe.A0L();
    }

    private void A02() {
        C0616Oe c0616Oe = this.A04.get();
        if (c0616Oe == null) {
            return;
        }
        c0616Oe.A0M();
    }

    private void A03() {
        C0616Oe c0616Oe = this.A04.get();
        if (c0616Oe == null) {
            return;
        }
        c0616Oe.A0N();
    }

    private void A04() {
        C0616Oe c0616Oe = this.A04.get();
        if (c0616Oe == null) {
            return;
        }
        c0616Oe.A0P();
    }

    private void A05() {
        C0616Oe c0616Oe = this.A04.get();
        if (c0616Oe == null) {
            return;
        }
        c0616Oe.A0Q();
    }

    private void A06() {
        C0616Oe c0616Oe = this.A04.get();
        if (c0616Oe == null) {
            return;
        }
        c0616Oe.A0R();
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0088, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A08(com.facebook.ads.redexgen.X.EnumC0618Og r4, java.lang.String r5) throws org.json.JSONException {
        /*
            r3 = this;
            r2 = r3
            int[] r1 = com.facebook.ads.redexgen.X.C0617Of.A00
            int r0 = r4.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L6f;
                case 2: goto L72;
                case 3: goto L75;
                case 4: goto L78;
                case 5: goto L7b;
                case 6: goto L7e;
                case 7: goto L80;
                case 8: goto L82;
                case 9: goto L84;
                case 10: goto L86;
                default: goto Lc;
            }
        Lc:
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L88;
                case 3: goto L3e;
                case 4: goto L2d;
                case 5: goto L1f;
                case 6: goto L11;
                case 7: goto L45;
                case 8: goto L4c;
                case 9: goto L53;
                case 10: goto L5a;
                case 11: goto L37;
                case 12: goto L61;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.Oh r2 = (com.facebook.ads.redexgen.X.C0619Oh) r2
            java.lang.String r5 = (java.lang.String) r5
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r5)
            r2.A0A(r0)
            r0 = 2
            goto Ld
        L1f:
            com.facebook.ads.redexgen.X.Oh r2 = (com.facebook.ads.redexgen.X.C0619Oh) r2
            java.lang.String r5 = (java.lang.String) r5
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r5)
            r2.A0B(r0)
            r0 = 2
            goto Ld
        L2d:
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            if (r0 == 0) goto L35
            r0 = 2
            goto Ld
        L35:
            r0 = 2
            goto Ld
        L37:
            com.facebook.ads.redexgen.X.Oh r2 = (com.facebook.ads.redexgen.X.C0619Oh) r2
            r2.A05()
            r0 = 2
            goto Ld
        L3e:
            com.facebook.ads.redexgen.X.Oh r2 = (com.facebook.ads.redexgen.X.C0619Oh) r2
            r2.A04()
            r0 = 2
            goto Ld
        L45:
            com.facebook.ads.redexgen.X.Oh r2 = (com.facebook.ads.redexgen.X.C0619Oh) r2
            r2.A06()
            r0 = 2
            goto Ld
        L4c:
            com.facebook.ads.redexgen.X.Oh r2 = (com.facebook.ads.redexgen.X.C0619Oh) r2
            r2.A02()
            r0 = 2
            goto Ld
        L53:
            com.facebook.ads.redexgen.X.Oh r2 = (com.facebook.ads.redexgen.X.C0619Oh) r2
            r2.A03()
            r0 = 2
            goto Ld
        L5a:
            com.facebook.ads.redexgen.X.Oh r2 = (com.facebook.ads.redexgen.X.C0619Oh) r2
            r2.A01()
            r0 = 2
            goto Ld
        L61:
            com.facebook.ads.redexgen.X.Oh r2 = (com.facebook.ads.redexgen.X.C0619Oh) r2
            java.lang.String r5 = (java.lang.String) r5
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r5)
            r2.A09(r0)
            r0 = 2
            goto Ld
        L6f:
            r0 = 12
            goto Ld
        L72:
            r0 = 11
            goto Ld
        L75:
            r0 = 10
            goto Ld
        L78:
            r0 = 9
            goto Ld
        L7b:
            r0 = 8
            goto Ld
        L7e:
            r0 = 7
            goto Ld
        L80:
            r0 = 6
            goto Ld
        L82:
            r0 = 5
            goto Ld
        L84:
            r0 = 4
            goto Ld
        L86:
            r0 = 3
            goto Ld
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0619Oh.A08(com.facebook.ads.redexgen.X.Og, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A09(org.json.JSONObject r5) {
        /*
            r4 = this;
            r1 = 0
            r0 = 0
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.Oe> r0 = r4.A04
            java.lang.Object r3 = r0.get()
            com.facebook.ads.redexgen.X.Oe r3 = (com.facebook.ads.redexgen.X.C0616Oe) r3
            if (r3 != 0) goto L3a
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L3c;
                case 3: goto L11;
                case 4: goto L2a;
                case 5: goto L31;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            r2 = 96
            r1 = 7
            r0 = 27
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.String r1 = r5.optString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L28
            r0 = 4
            goto Ld
        L28:
            r0 = 5
            goto Ld
        L2a:
            com.facebook.ads.redexgen.X.Oe r3 = (com.facebook.ads.redexgen.X.C0616Oe) r3
            r3.A0O()
            r0 = 2
            goto Ld
        L31:
            com.facebook.ads.redexgen.X.Oe r3 = (com.facebook.ads.redexgen.X.C0616Oe) r3
            java.lang.String r1 = (java.lang.String) r1
            r3.A0S(r1)
            r0 = 2
            goto Ld
        L3a:
            r0 = 3
            goto Ld
        L3c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0619Oh.A09(org.json.JSONObject):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0A(org.json.JSONObject r6) {
        /*
            r5 = this;
            r0 = 0
            r4 = 0
            r3 = 0
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.Oe> r0 = r5.A04
            java.lang.Object r2 = r0.get()
            com.facebook.ads.redexgen.X.Oe r2 = (com.facebook.ads.redexgen.X.C0616Oe) r2
            if (r2 != 0) goto L49
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L4b;
                case 3: goto L12;
                case 4: goto L1f;
                case 5: goto L2b;
                case 6: goto L40;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            java.util.Iterator r3 = r6.keys()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r0 = 4
            goto Le
        L1f:
            java.util.Iterator r3 = (java.util.Iterator) r3
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L29
            r0 = 5
            goto Le
        L29:
            r0 = 6
            goto Le
        L2b:
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.util.HashMap r4 = (java.util.HashMap) r4
            java.lang.Object r1 = r3.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r0 = r6.optString(r1)
            r4.put(r1, r0)
            r0 = 4
            goto Le
        L40:
            com.facebook.ads.redexgen.X.Oe r2 = (com.facebook.ads.redexgen.X.C0616Oe) r2
            java.util.HashMap r4 = (java.util.HashMap) r4
            r2.A0T(r4)
            r0 = 2
            goto Le
        L49:
            r0 = 3
            goto Le
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0619Oh.A0A(org.json.JSONObject):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0B(org.json.JSONObject r6) {
        /*
            r5 = this;
            r4 = r5
            r2 = 0
            r0 = 0
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.Gl> r0 = r4.A03
            java.lang.Object r3 = r0.get()
            com.facebook.ads.redexgen.X.Gl r3 = (com.facebook.ads.redexgen.X.InterfaceC0422Gl) r3
            if (r3 != 0) goto L3f
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L41;
                case 3: goto L12;
                case 4: goto L2c;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            r2 = 51
            r1 = 11
            r0 = 85
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.String r2 = r6.optString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L2a
            r0 = 4
            goto Le
        L2a:
            r0 = 2
            goto Le
        L2c:
            com.facebook.ads.redexgen.X.Oh r4 = (com.facebook.ads.redexgen.X.C0619Oh) r4
            com.facebook.ads.redexgen.X.Gl r3 = (com.facebook.ads.redexgen.X.InterfaceC0422Gl) r3
            java.lang.String r2 = (java.lang.String) r2
            com.facebook.ads.redexgen.X.Gv r1 = new com.facebook.ads.redexgen.X.Gv
            java.lang.String r0 = r4.A02
            r1.<init>(r0, r3)
            r0 = 0
            r1.A03(r2, r0)
            r0 = 2
            goto Le
        L3f:
            r0 = 3
            goto Le
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0619Oh.A0B(org.json.JSONObject):void");
    }

    @JavascriptInterface
    public void postMessage(String str) {
        try {
            JSONObject object = new JSONObject(str);
            if (!this.A01.equals(object.optString(A00(44, 7, 109)))) {
                this.A00.A04(C0512Kc.A0o, A00(14, 30, 82));
            } else {
                A08(EnumC0618Og.A00(object.optString(A00(10, 4, 126))), object.optString(A00(0, 10, 33)));
            }
        } catch (JSONException e) {
            this.A00.A04(C0512Kc.A0q, A00(62, 34, 68) + e.getMessage());
        }
    }
}
