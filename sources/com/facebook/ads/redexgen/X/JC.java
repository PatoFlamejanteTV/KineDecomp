package com.facebook.ads.redexgen.X;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: assets/audience_network.dex */
public final class JC implements Map<String, String> {
    public static byte[] A01;
    public Map<String, String> A00 = new HashMap();

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
            byte[] r1 = com.facebook.ads.redexgen.X.JC.A01
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
            r0 = r0 ^ 96
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JC.A00(int, int, int):java.lang.String");
    }

    public static void A03() {
        A01 = new byte[]{94, 15, 118, 119, 101, 14, 27};
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

    public final JC A04(String str, String str2) {
        this.A00.put(str, str2);
        return this;
    }

    public final JC A05(Map<? extends String, ? extends String> arg) {
        putAll(arg);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0081, code lost:            return r4.toString();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A06() {
        /*
            r8 = this;
            r7 = r8
            r6 = 0
            r0 = 0
            r5 = 0
            r0 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.util.Map<java.lang.String, java.lang.String> r0 = r7.A00
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r3 = r0.iterator()
        L14:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L76
            r0 = 3
        L1b:
            switch(r0) {
                case 3: goto L4d;
                case 4: goto L3e;
                case 5: goto L1f;
                case 6: goto L1e;
                case 7: goto L61;
                case 8: goto L1e;
                case 9: goto L1e;
                case 10: goto L1e;
                case 11: goto L79;
                default: goto L1e;
            }
        L1e:
            goto L1b
        L1f:
            com.facebook.ads.redexgen.X.JC r7 = (com.facebook.ads.redexgen.X.JC) r7
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            java.lang.String r6 = (java.lang.String) r6
            r4.append(r6)
            java.util.Map<java.lang.String, java.lang.String> r0 = r7.A00
            java.lang.Object r5 = r0.get(r6)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L14
            r2 = 0
            r1 = 1
            r0 = 3
            java.lang.String r0 = A00(r2, r1, r0)
            r4.append(r0)
            r0 = 7
            goto L1b
        L3e:
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            r2 = 1
            r1 = 1
            r0 = 73
            java.lang.String r0 = A00(r2, r1, r0)
            r4.append(r0)
            r0 = 5
            goto L1b
        L4d:
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r6 = r3.next()
            java.lang.String r6 = (java.lang.String) r6
            int r0 = r4.length()
            if (r0 <= 0) goto L5f
            r0 = 4
            goto L1b
        L5f:
            r0 = 5
            goto L1b
        L61:
            r2 = 2
            r1 = 5
            r0 = 67
            java.lang.String r0 = A00(r2, r1, r0)     // Catch: java.io.UnsupportedEncodingException -> L71
            java.lang.String r0 = java.net.URLEncoder.encode(r5, r0)     // Catch: java.io.UnsupportedEncodingException -> L71
            r4.append(r0)     // Catch: java.io.UnsupportedEncodingException -> L71
            goto L14
        L71:
            r0 = move-exception
            r0.printStackTrace()
            goto L14
        L76:
            r0 = 11
            goto L1b
        L79:
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            java.lang.String r0 = r4.toString()
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JC.A06():java.lang.String");
    }

    @Override // java.util.Map
    /* renamed from: A07, reason: merged with bridge method [inline-methods] */
    public final String put(String str, String str2) {
        return this.A00.put(str, str2);
    }

    public final byte[] A08() {
        byte[] bArr = null;
        try {
            bArr = A06().getBytes(A00(2, 5, 67));
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
