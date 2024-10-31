package com.facebook.ads.redexgen.X;

import java.util.ConcurrentModificationException;

/* renamed from: com.facebook.ads.redexgen.X.4K, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C4K<K, V> {
    public static int A03;
    public static int A04;
    public static Object[] A05;
    public static Object[] A06;
    public static byte[] A07;
    public int[] A01 = C4M.A00;
    public Object[] A02 = C4M.A02;
    public int A00 = 0;

    static {
        A04();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C4K.A07
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
            int r0 = r0 + (-73)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4K.A03(int, int, int):java.lang.String");
    }

    public static void A04() {
        A07 = new byte[]{-35, -47, -57, 19, 7, 8, 18, -65, -20, 0, 15, -56, 32, 34};
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x009c, code lost:            return r6;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int A00() {
        /*
            r7 = this;
            r4 = r7
            r3 = 0
            r0 = 0
            r6 = 0
            r5 = 0
            int r2 = r4.A00
            if (r2 != 0) goto L99
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L5c;
                case 3: goto L9c;
                case 4: goto L26;
                case 5: goto L7b;
                case 6: goto L89;
                case 7: goto L51;
                case 8: goto L6d;
                case 9: goto L41;
                case 10: goto L3e;
                case 11: goto L3a;
                case 12: goto L35;
                case 13: goto L1e;
                case 14: goto L5f;
                case 15: goto Le;
                case 16: goto L59;
                case 17: goto L8e;
                case 18: goto L94;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.4K r4 = (com.facebook.ads.redexgen.X.C4K) r4
            java.lang.Object[] r1 = r4.A02
            int r0 = r5 << 1
            r0 = r1[r0]
            if (r0 != 0) goto L1b
            r0 = 16
            goto La
        L1b:
            r0 = 17
            goto La
        L1e:
            if (r5 < 0) goto L23
            r0 = 14
            goto La
        L23:
            r0 = 18
            goto La
        L26:
            com.facebook.ads.redexgen.X.4K r4 = (com.facebook.ads.redexgen.X.C4K) r4
            int[] r1 = r4.A01
            r0 = 0
            int r6 = A02(r1, r2, r0)
            if (r6 < 0) goto L33
            r0 = 5
            goto La
        L33:
            r0 = 3
            goto La
        L35:
            int r5 = r6 + (-1)
            r0 = 13
            goto La
        L3a:
            int r3 = r3 + 1
            r0 = 7
            goto La
        L3e:
            r6 = r3
            r0 = 3
            goto La
        L41:
            com.facebook.ads.redexgen.X.4K r4 = (com.facebook.ads.redexgen.X.C4K) r4
            java.lang.Object[] r1 = r4.A02
            int r0 = r3 << 1
            r0 = r1[r0]
            if (r0 != 0) goto L4e
            r0 = 10
            goto La
        L4e:
            r0 = 11
            goto La
        L51:
            if (r3 >= r2) goto L56
            r0 = 8
            goto La
        L56:
            r0 = 12
            goto La
        L59:
            r6 = r5
            r0 = 3
            goto La
        L5c:
            r6 = -1
            r0 = 3
            goto La
        L5f:
            com.facebook.ads.redexgen.X.4K r4 = (com.facebook.ads.redexgen.X.C4K) r4
            int[] r0 = r4.A01
            r0 = r0[r5]
            if (r0 != 0) goto L6a
            r0 = 15
            goto La
        L6a:
            r0 = 18
            goto La
        L6d:
            com.facebook.ads.redexgen.X.4K r4 = (com.facebook.ads.redexgen.X.C4K) r4
            int[] r0 = r4.A01
            r0 = r0[r3]
            if (r0 != 0) goto L78
            r0 = 9
            goto La
        L78:
            r0 = 12
            goto La
        L7b:
            com.facebook.ads.redexgen.X.4K r4 = (com.facebook.ads.redexgen.X.C4K) r4
            java.lang.Object[] r1 = r4.A02
            int r0 = r6 << 1
            r0 = r1[r0]
            if (r0 == 0) goto L87
            r0 = 6
            goto La
        L87:
            r0 = 3
            goto La
        L89:
            int r3 = r6 + 1
            r0 = 7
            goto La
        L8e:
            int r5 = r5 + (-1)
            r0 = 13
            goto La
        L94:
            r6 = r3 ^ (-1)
            r0 = 3
            goto La
        L99:
            r0 = 4
            goto La
        L9c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4K.A00():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x00af, code lost:            return r5;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int A01(java.lang.Object r8, int r9) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4K.A01(java.lang.Object, int):int");
    }

    public static int A02(int[] iArr, int i, int i2) {
        try {
            return C4M.A02(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    private void A05(int i) {
        if (i == 8) {
            synchronized (C4L.class) {
                if (A06 != null) {
                    Object[] objArr = A06;
                    this.A02 = objArr;
                    A06 = (Object[]) objArr[0];
                    this.A01 = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    A04--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C4L.class) {
                if (A05 != null) {
                    Object[] objArr2 = A05;
                    this.A02 = objArr2;
                    A05 = (Object[]) objArr2[0];
                    this.A01 = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    A03--;
                    return;
                }
            }
        }
        this.A01 = new int[i];
        this.A02 = new Object[i << 1];
    }

    public static void A06(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C4L.class) {
                if (A04 < 10) {
                    objArr[0] = A06;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    A06 = objArr;
                    A04++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C4L.class) {
                if (A03 < 10) {
                    objArr[0] = A05;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    A05 = objArr;
                    A03++;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x005b, code lost:            return r4;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A07(java.lang.Object r7) {
        /*
            r6 = this;
            r5 = 0
            r4 = 0
            r0 = 0
            r0 = 0
            r3 = 0
            int r0 = r6.A00
            int r2 = r0 * 2
            java.lang.Object[] r1 = r6.A02
            if (r7 != 0) goto L58
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L3d;
                case 3: goto L36;
                case 4: goto L28;
                case 5: goto L12;
                case 6: goto L5b;
                case 7: goto L40;
                case 8: goto L44;
                case 9: goto L48;
                case 10: goto L16;
                case 11: goto L32;
                case 12: goto L50;
                case 13: goto L55;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            int r4 = r3 >> 1
            r0 = 6
            goto Le
        L16:
            java.lang.Object r7 = (java.lang.Object) r7
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            r0 = r1[r5]
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L25
            r0 = 11
            goto Le
        L25:
            r0 = 12
            goto Le
        L28:
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            r0 = r1[r3]
            if (r0 != 0) goto L30
            r0 = 5
            goto Le
        L30:
            r0 = 7
            goto Le
        L32:
            int r4 = r5 >> 1
            r0 = 6
            goto Le
        L36:
            if (r3 >= r2) goto L3a
            r0 = 4
            goto Le
        L3a:
            r0 = 13
            goto Le
        L3d:
            r3 = 1
            r0 = 3
            goto Le
        L40:
            int r3 = r3 + 2
            r0 = 3
            goto Le
        L44:
            r5 = 1
            r0 = 9
            goto Le
        L48:
            if (r5 >= r2) goto L4d
            r0 = 10
            goto Le
        L4d:
            r0 = 13
            goto Le
        L50:
            int r5 = r5 + 2
            r0 = 9
            goto Le
        L55:
            r4 = -1
            r0 = 6
            goto Le
        L58:
            r0 = 8
            goto Le
        L5b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4K.A07(java.lang.Object):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:            return r1;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A08(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            if (r4 != 0) goto L1f
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L21;
                case 4: goto L11;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.4K r2 = (com.facebook.ads.redexgen.X.C4K) r2
            int r1 = r2.A00()
            r0 = 3
            goto L5
        L11:
            com.facebook.ads.redexgen.X.4K r2 = (com.facebook.ads.redexgen.X.C4K) r2
            java.lang.Object r4 = (java.lang.Object) r4
            int r0 = r4.hashCode()
            int r1 = r2.A01(r4, r0)
            r0 = 3
            goto L5
        L1f:
            r0 = 4
            goto L5
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4K.A08(java.lang.Object):int");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final K A09(int i) {
        return (K) this.A02[i << 1];
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001b. Please report as an issue. */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final V A0A(int i) {
        C4K<K, V> c4k = this;
        int i2 = 0;
        Object[] objArr = null;
        int[] iArr = null;
        int i3 = 8;
        Object obj = c4k.A02[(i << 1) + 1];
        int i4 = c4k.A00;
        char c = i4 <= 1 ? (char) 2 : (char) 5;
        while (true) {
            switch (c) {
                case 2:
                    c4k = c4k;
                    A06(c4k.A01, c4k.A02, i4);
                    c4k.A01 = C4M.A00;
                    c4k.A02 = C4M.A02;
                    i2 = 0;
                    c = 3;
                case 3:
                    c4k = c4k;
                    c = i4 != c4k.A00 ? (char) 4 : (char) 18;
                case 4:
                    throw new ConcurrentModificationException();
                case 5:
                    c4k = c4k;
                    i2 = i4 - 1;
                    c = c4k.A01.length > i3 ? (char) 6 : (char) 15;
                case 6:
                    c4k = c4k;
                    c = c4k.A00 < c4k.A01.length / 3 ? (char) 7 : (char) 15;
                case 7:
                    c = i4 > i3 ? '\b' : '\t';
                case '\b':
                    i3 = i4 + (i4 >> 1);
                    c = '\t';
                case '\t':
                    c4k = c4k;
                    iArr = c4k.A01;
                    objArr = c4k.A02;
                    c4k.A05(i3);
                    c = i4 != c4k.A00 ? '\n' : (char) 11;
                case '\n':
                    throw new ConcurrentModificationException();
                case 11:
                    c = i > 0 ? '\f' : '\r';
                case '\f':
                    c4k = c4k;
                    iArr = iArr;
                    objArr = objArr;
                    System.arraycopy(iArr, 0, c4k.A01, 0, i);
                    System.arraycopy(objArr, 0, c4k.A02, 0, i << 1);
                    c = '\r';
                case '\r':
                    c = i < i2 ? (char) 14 : (char) 3;
                case 14:
                    c4k = c4k;
                    iArr = iArr;
                    objArr = objArr;
                    System.arraycopy(iArr, i + 1, c4k.A01, i, i2 - i);
                    System.arraycopy(objArr, (i + 1) << 1, c4k.A02, i << 1, (i2 - i) << 1);
                    c = 3;
                case 15:
                    c = i < i2 ? (char) 16 : (char) 17;
                case 16:
                    c4k = c4k;
                    System.arraycopy(c4k.A01, i + 1, c4k.A01, i, i2 - i);
                    System.arraycopy(c4k.A02, (i + 1) << 1, c4k.A02, i << 1, (i2 - i) << 1);
                    c = 17;
                case 17:
                    c4k = c4k;
                    c4k.A02[i2 << 1] = null;
                    c4k.A02[(i2 << 1) + 1] = null;
                    c = 3;
                case 18:
                    c4k.A00 = i2;
                    return (V) obj;
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final V A0B(int i) {
        return (V) this.A02[(i << 1) + 1];
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final V A0C(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = (V) this.A02[i2];
        this.A02[i2] = v;
        return v2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000e. Please report as an issue. */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final void A0D(int i) {
        C4K<K, V> c4k = this;
        int[] iArr = null;
        Object[] objArr = null;
        int i2 = c4k.A00;
        char c = c4k.A01.length < i ? (char) 2 : (char) 5;
        while (true) {
            switch (c) {
                case 2:
                    c4k = c4k;
                    iArr = c4k.A01;
                    objArr = c4k.A02;
                    c4k.A05(i);
                    c = c4k.A00 > 0 ? (char) 3 : (char) 4;
                case 3:
                    c4k = c4k;
                    iArr = iArr;
                    objArr = objArr;
                    System.arraycopy(iArr, 0, c4k.A01, 0, i2);
                    System.arraycopy(objArr, 0, c4k.A02, 0, i2 << 1);
                    c = 4;
                case 4:
                    iArr = iArr;
                    objArr = objArr;
                    A06(iArr, objArr, i2);
                    c = 5;
                case 5:
                    c4k = c4k;
                    c = c4k.A00 != i2 ? (char) 6 : (char) 7;
                case 6:
                    throw new ConcurrentModificationException();
                case 7:
                    return;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0006. Please report as an issue. */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final void clear() {
        C4K<K, V> c4k = this;
        int osize = c4k.A00 > 0 ? 2 : 3;
        while (true) {
            switch (osize) {
                case 2:
                    c4k = c4k;
                    int[] iArr = c4k.A01;
                    Object[] objArr = c4k.A02;
                    int i = c4k.A00;
                    int[] ohashes = C4M.A00;
                    c4k.A01 = ohashes;
                    c4k.A02 = C4M.A02;
                    c4k.A00 = 0;
                    A06(iArr, objArr, i);
                    osize = 3;
                case 3:
                    c4k = c4k;
                    osize = c4k.A00 > 0 ? 4 : 5;
                case 4:
                    throw new ConcurrentModificationException();
                case 5:
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean containsKey(java.lang.Object r3) {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A08(r3)
            if (r0 < 0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 1
            r0 = 3
            goto L8
        Lf:
            r1 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4K.containsKey(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r1;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean containsValue(java.lang.Object r3) {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A07(r3)
            if (r0 < 0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 1
            r0 = 3
            goto L8
        Lf:
            r1 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4K.containsValue(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:179:0x0146, code lost:            return r15;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<?, ?> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4K.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:            return (V) r1;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final V get(java.lang.Object r5) {
        /*
            r4 = this;
            r3 = r4
            r1 = 0
            r0 = 0
            int r2 = r3.A08(r5)
            if (r2 < 0) goto L1d
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1f;
                case 4: goto L1a;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.4K r3 = (com.facebook.ads.redexgen.X.C4K) r3
            java.lang.Object[] r1 = r3.A02
            int r0 = r2 << 1
            int r0 = r0 + 1
            r1 = r1[r0]
            r0 = 3
            goto La
        L1a:
            r1 = 0
            r0 = 3
            goto La
        L1d:
            r0 = 4
            goto La
        L1f:
            java.lang.Object r1 = (java.lang.Object) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4K.get(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x003f, code lost:            return r4;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int hashCode() {
        /*
            r10 = this;
            r7 = 0
            r9 = 0
            r8 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            int[] r6 = r10.A01
            java.lang.Object[] r5 = r10.A02
            r4 = 0
            r3 = 0
            r2 = 1
            int r1 = r10.A00
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L39;
                case 3: goto L2b;
                case 4: goto L28;
                case 5: goto L1f;
                case 6: goto L17;
                case 7: goto L3f;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            java.lang.Object r7 = (java.lang.Object) r7
            int r9 = r7.hashCode()
            r0 = 5
            goto L13
        L1f:
            r0 = r9 ^ r8
            int r4 = r4 + r0
            int r3 = r3 + 1
            int r2 = r2 + 2
            r0 = 2
            goto L13
        L28:
            r9 = 0
            r0 = 5
            goto L13
        L2b:
            int[] r6 = (int[]) r6
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            r7 = r5[r2]
            r8 = r6[r3]
            if (r7 != 0) goto L37
            r0 = 4
            goto L13
        L37:
            r0 = 6
            goto L13
        L39:
            if (r3 >= r1) goto L3d
            r0 = 3
            goto L13
        L3d:
            r0 = 7
            goto L13
        L3f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4K.hashCode():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0012, code lost:            return r1;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isEmpty() {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A00
            if (r0 > 0) goto L10
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L12;
                case 4: goto Ld;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            r1 = 1
            r0 = 3
            goto L6
        Ld:
            r1 = 0
            r0 = 3
            goto L6
        L10:
            r0 = 4
            goto L6
        L12:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4K.isEmpty():boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001a. Please report as an issue. */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final V put(K k, V v) {
        Object obj = v;
        Object obj2 = k;
        C4K<K, V> c4k = this;
        int i = 0;
        int i2 = 0;
        int[] iArr = null;
        int i3 = 0;
        Object[] objArr = null;
        Object obj3 = null;
        int i4 = 8;
        int i5 = c4k.A00;
        char c = obj2 == null ? (char) 2 : (char) 22;
        while (true) {
            switch (c) {
                case 2:
                    c4k = c4k;
                    i = 0;
                    i3 = c4k.A00();
                    c = 3;
                case 3:
                    c = i3 >= 0 ? (char) 4 : (char) 6;
                case 4:
                    c4k = c4k;
                    obj = obj;
                    int i6 = (i3 << 1) + 1;
                    obj3 = c4k.A02[i6];
                    c4k.A02[i6] = obj;
                    c = 5;
                case 5:
                    return (V) obj3;
                case 6:
                    c4k = c4k;
                    i2 = i3 ^ (-1);
                    c = i5 >= c4k.A01.length ? (char) 7 : (char) 16;
                case 7:
                    c = i5 >= i4 ? '\b' : (char) 11;
                case '\b':
                    i4 = i5 + (i5 >> 1);
                    c = '\t';
                case '\t':
                    c4k = c4k;
                    iArr = c4k.A01;
                    objArr = c4k.A02;
                    c4k.A05(i4);
                    c = i5 != c4k.A00 ? '\n' : '\r';
                case '\n':
                    throw new ConcurrentModificationException();
                case 11:
                    c = i5 < 4 ? '\f' : '\t';
                case '\f':
                    i4 = 4;
                    c = '\t';
                case '\r':
                    c4k = c4k;
                    c = c4k.A01.length > 0 ? (char) 14 : (char) 15;
                case 14:
                    c4k = c4k;
                    iArr = iArr;
                    objArr = objArr;
                    System.arraycopy(iArr, 0, c4k.A01, 0, iArr.length);
                    System.arraycopy(objArr, 0, c4k.A02, 0, objArr.length);
                    c = 15;
                case 15:
                    iArr = iArr;
                    objArr = objArr;
                    A06(iArr, objArr, i5);
                    c = 16;
                case 16:
                    c = i2 < i5 ? (char) 17 : (char) 18;
                case 17:
                    c4k = c4k;
                    System.arraycopy(c4k.A01, i2, c4k.A01, i2 + 1, i5 - i2);
                    System.arraycopy(c4k.A02, i2 << 1, c4k.A02, (i2 + 1) << 1, (c4k.A00 - i2) << 1);
                    c = 18;
                case 18:
                    c4k = c4k;
                    c = i5 == c4k.A00 ? (char) 19 : (char) 20;
                case 19:
                    c4k = c4k;
                    c = i2 >= c4k.A01.length ? (char) 20 : (char) 21;
                case 20:
                    throw new ConcurrentModificationException();
                case 21:
                    c4k = c4k;
                    obj2 = obj2;
                    obj = obj;
                    c4k.A01[i2] = i;
                    c4k.A02[i2 << 1] = obj2;
                    c4k.A02[(i2 << 1) + 1] = obj;
                    c4k.A00++;
                    obj3 = null;
                    c = 5;
                case 22:
                    c4k = c4k;
                    obj2 = obj2;
                    i = obj2.hashCode();
                    i3 = c4k.A01(obj2, i);
                    c = 3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:            return r2;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final V remove(java.lang.Object r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            int r1 = r3.A08(r5)
            if (r1 < 0) goto L19
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1b;
                case 4: goto L16;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.4K r3 = (com.facebook.ads.redexgen.X.C4K) r3
            java.lang.Object r2 = r3.A0A(r1)
            r0 = 3
            goto La
        L16:
            r2 = 0
            r0 = 3
            goto La
        L19:
            r0 = 4
            goto La
        L1b:
            java.lang.Object r2 = (java.lang.Object) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4K.remove(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final int size() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c5, code lost:            return r3;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4K != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4K.toString():java.lang.String");
    }
}
