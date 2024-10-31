package com.facebook.ads.redexgen.X;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.facebook.ads.redexgen.X.7V, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C7V implements Map<String, String> {
    public static byte[] A01;
    public Map<String, String> A00;

    static {
        A04();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C7V.A01
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
            int r0 = r0 + (-124)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7V.A00(int, int, int):java.lang.String");
    }

    public static void A04() {
        A01 = new byte[]{4, -50, 64, 63, 49, 24, 35};
    }

    public C7V() {
        this.A00 = new HashMap();
    }

    public C7V(Map<String, String> map) {
        this.A00 = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Map
    /* renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final String get(Object obj) {
        return this.A00.get(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Map
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final String remove(Object obj) {
        return this.A00.remove(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Map
    /* renamed from: A03, reason: merged with bridge method [inline-methods] */
    public final String put(String str, String str2) {
        return this.A00.put(str, str2);
    }

    public final C7V A05(Map<? extends String, ? extends String> arg) {
        putAll(arg);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a2, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A06() {
        /*
            r9 = this;
            r6 = r9
            r7 = 0
            r5 = 0
            r8 = 0
            r4 = 0
            r3 = 0
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.A00
            if (r0 != 0) goto L9b
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L24;
                case 3: goto L9e;
                case 4: goto L74;
                case 5: goto Le;
                case 6: goto Lf;
                case 7: goto L2e;
                case 8: goto L53;
                case 9: goto Le;
                case 10: goto L3e;
                case 11: goto Le;
                case 12: goto Le;
                case 13: goto Le;
                case 14: goto L92;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            java.lang.StringBuilder r5 = (java.lang.StringBuilder) r5
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r4 = r8.next()
            java.lang.String r4 = (java.lang.String) r4
            int r0 = r5.length()
            if (r0 <= 0) goto L21
            r0 = 7
            goto Lb
        L21:
            r0 = 8
            goto Lb
        L24:
            r2 = 1
            r1 = 0
            r0 = 113(0x71, float:1.58E-43)
            java.lang.String r3 = A00(r2, r1, r0)
            r0 = 3
            goto Lb
        L2e:
            java.lang.StringBuilder r5 = (java.lang.StringBuilder) r5
            r2 = 1
            r1 = 1
            r0 = 44
            java.lang.String r0 = A00(r2, r1, r0)
            r5.append(r0)
            r0 = 8
            goto Lb
        L3e:
            r2 = 2
            r1 = 5
            r0 = 111(0x6f, float:1.56E-43)
            java.lang.String r0 = A00(r2, r1, r0)     // Catch: java.io.UnsupportedEncodingException -> L4e
            java.lang.String r0 = java.net.URLEncoder.encode(r7, r0)     // Catch: java.io.UnsupportedEncodingException -> L4e
            r5.append(r0)     // Catch: java.io.UnsupportedEncodingException -> L4e
            goto L85
        L4e:
            r0 = move-exception
            r0.printStackTrace()
            goto L85
        L53:
            com.facebook.ads.redexgen.X.7V r6 = (com.facebook.ads.redexgen.X.C7V) r6
            java.lang.StringBuilder r5 = (java.lang.StringBuilder) r5
            java.lang.String r4 = (java.lang.String) r4
            r5.append(r4)
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.A00
            java.lang.Object r7 = r0.get(r4)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L85
            r2 = 0
            r1 = 1
            r0 = 75
            java.lang.String r0 = A00(r2, r1, r0)
            r5.append(r0)
            r0 = 10
            goto Lb
        L74:
            com.facebook.ads.redexgen.X.7V r6 = (com.facebook.ads.redexgen.X.C7V) r6
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.A00
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r8 = r0.iterator()
        L85:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L8e
            r0 = 6
            goto Lb
        L8e:
            r0 = 14
            goto Lb
        L92:
            java.lang.StringBuilder r5 = (java.lang.StringBuilder) r5
            java.lang.String r3 = r5.toString()
            r0 = 3
            goto Lb
        L9b:
            r0 = 4
            goto Lb
        L9e:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7V.A06():java.lang.String");
    }

    public final byte[] A07() {
        byte[] bArr = null;
        try {
            bArr = A06().getBytes(A00(2, 5, 111));
            return bArr;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return bArr;
        }
    }

    @Override // java.util.Map
    public final void clear() {
        this.A00.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.A00.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.A00.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, String>> entrySet() {
        return this.A00.entrySet();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.A00.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.A00.keySet();
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends String> map) {
        Map<? extends String, ? extends String> arg = this.A00;
        arg.putAll(map);
    }

    @Override // java.util.Map
    public final int size() {
        return this.A00.size();
    }

    @Override // java.util.Map
    public final Collection<String> values() {
        return this.A00.values();
    }
}
