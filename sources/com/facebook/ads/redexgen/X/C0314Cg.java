package com.facebook.ads.redexgen.X;

import java.net.InetAddress;
import java.util.Enumeration;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Cg, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0314Cg implements BI<String> {
    public static byte[] A01;
    public final Map<String, String> A00;

    static {
        A03();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0314Cg.A01
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
            int r0 = r0 + (-25)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0314Cg.A00(int, int, int):java.lang.String");
    }

    public static void A03() {
        A01 = new byte[]{-65, Byte.MAX_VALUE, -105, -5, -71};
    }

    public C0314Cg(Enumeration<InetAddress> enumeration) {
        this.A00 = A01(enumeration);
    }

    public /* synthetic */ C0314Cg(Enumeration enumeration, C0312Ce c0312Ce) {
        this(enumeration);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x008d, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> A01(java.util.Enumeration<java.net.InetAddress> r7) {
        /*
            r6 = 0
            r0 = 0
            r5 = 0
            r4 = 0
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L4c;
                case 3: goto L27;
                case 4: goto L37;
                case 5: goto L18;
                case 6: goto Le;
                case 7: goto L59;
                case 8: goto L6f;
                case 9: goto L41;
                case 10: goto L7f;
                case 11: goto L89;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r2 = 3
            r1 = 2
            r0 = 108(0x6c, float:1.51E-43)
            java.lang.String r6 = A00(r2, r1, r0)
            r0 = 7
            goto La
        L18:
            java.net.InetAddress r4 = (java.net.InetAddress) r4
            java.lang.String r5 = r4.getHostAddress()
            boolean r0 = r4 instanceof java.net.Inet4Address
            if (r0 == 0) goto L24
            r0 = 6
            goto La
        L24:
            r0 = 10
            goto La
        L27:
            java.util.Enumeration r7 = (java.util.Enumeration) r7
            java.lang.Object r4 = r7.nextElement()
            java.net.InetAddress r4 = (java.net.InetAddress) r4
            boolean r0 = r4 instanceof java.net.Inet4Address
            if (r0 != 0) goto L35
            r0 = 4
            goto La
        L35:
            r0 = 5
            goto La
        L37:
            java.net.InetAddress r4 = (java.net.InetAddress) r4
            boolean r0 = r4 instanceof java.net.Inet6Address
            if (r0 == 0) goto L3f
            r0 = 5
            goto La
        L3f:
            r0 = 2
            goto La
        L41:
            java.util.HashMap r3 = (java.util.HashMap) r3
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = (java.lang.String) r6
            r3.put(r6, r5)
            r0 = 2
            goto La
        L4c:
            java.util.Enumeration r7 = (java.util.Enumeration) r7
            boolean r0 = r7.hasMoreElements()
            if (r0 == 0) goto L56
            r0 = 3
            goto La
        L56:
            r0 = 11
            goto La
        L59:
            java.lang.String r5 = (java.lang.String) r5
            r2 = 2
            r1 = 1
            r0 = 89
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r5.contains(r0)
            if (r0 == 0) goto L6c
            r0 = 8
            goto La
        L6c:
            r0 = 9
            goto La
        L6f:
            java.lang.String r5 = (java.lang.String) r5
            r1 = 0
            r0 = 37
            int r0 = r5.indexOf(r0)
            java.lang.String r5 = r5.substring(r1, r0)
            r0 = 9
            goto La
        L7f:
            r2 = 0
            r1 = 2
            r0 = 48
            java.lang.String r6 = A00(r2, r1, r0)
            r0 = 7
            goto La
        L89:
            java.util.HashMap r3 = (java.util.HashMap) r3
            java.util.Map r3 = (java.util.Map) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0314Cg.A01(java.util.Enumeration):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0095, code lost:            return r8;     */
    @Override // com.facebook.ads.redexgen.X.BI
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject A8S(java.lang.String r7, org.json.JSONObject r8) throws org.json.JSONException {
        /*
            r6 = this;
            r0 = 0
            r0 = 0
            r0 = 0
            r4 = 0
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.A00
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r2 = r0.iterator()
            r5 = 0
            r0 = 2
        L15:
            switch(r0) {
                case 2: goto L63;
                case 3: goto L51;
                case 4: goto L37;
                case 5: goto L2b;
                case 6: goto L19;
                case 7: goto L70;
                case 8: goto L49;
                case 9: goto L84;
                case 10: goto L91;
                default: goto L18;
            }
        L18:
            goto L15
        L19:
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r0 = r4.getValue()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L29
            r0 = 7
            goto L15
        L29:
            r0 = 2
            goto L15
        L2b:
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r0 = r4.getValue()
            if (r0 == 0) goto L35
            r0 = 6
            goto L15
        L35:
            r0 = 2
            goto L15
        L37:
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r0 = r4.getKey()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L47
            r0 = 5
            goto L15
        L47:
            r0 = 2
            goto L15
        L49:
            if (r5 == 0) goto L4e
            r0 = 9
            goto L15
        L4e:
            r0 = 10
            goto L15
        L51:
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r2.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r0 = r4.getKey()
            if (r0 == 0) goto L61
            r0 = 4
            goto L15
        L61:
            r0 = 2
            goto L15
        L63:
            java.util.Iterator r2 = (java.util.Iterator) r2
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L6d
            r0 = 3
            goto L15
        L6d:
            r0 = 8
            goto L15
        L70:
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = 1
            java.lang.Object r1 = r4.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r4.getValue()
            r3.put(r1, r0)
            r0 = 2
            goto L15
        L84:
            java.lang.String r7 = (java.lang.String) r7
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            org.json.JSONObject r8 = r8.put(r7, r3)
            r0 = 10
            goto L15
        L91:
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0314Cg.A8S(java.lang.String, org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:146:0x0125, code lost:            return r7;     */
    @Override // com.facebook.ads.redexgen.X.BI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A5B(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0314Cg.A5B(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:            return r3;     */
    @Override // com.facebook.ads.redexgen.X.BI
    @android.annotation.SuppressLint({"BadMethodUse-java.lang.String.length"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A8O() {
        /*
            r5 = this;
            r0 = 0
            r0 = 0
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.A00
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r4 = r0.iterator()
            r3 = 0
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L1e;
                case 4: goto L3e;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            java.util.Iterator r4 = (java.util.Iterator) r4
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L1c
            r0 = 3
            goto Le
        L1c:
            r0 = 4
            goto Le
        L1e:
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r2 = r4.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r0 = r2.getKey()
            java.lang.String r0 = (java.lang.String) r0
            int r1 = r0.length()
            java.lang.Object r0 = r2.getValue()
            java.lang.String r0 = (java.lang.String) r0
            int r0 = r0.length()
            int r0 = r0 + r1
            int r3 = r3 + r0
            r0 = 2
            goto Le
        L3e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0314Cg.A8O():int");
    }
}
