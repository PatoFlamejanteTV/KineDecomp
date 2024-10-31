package com.fasterxml.jackson.core.io;

/* compiled from: JsonStringEncoder.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    private static final char[] f9764a = a.b();

    /* renamed from: b */
    private static final byte[] f9765b = a.a();

    /* renamed from: c */
    protected com.fasterxml.jackson.core.util.e f9766c;

    /* renamed from: d */
    protected com.fasterxml.jackson.core.util.c f9767d;

    /* renamed from: e */
    protected final char[] f9768e = new char[6];

    public d() {
        char[] cArr = this.f9768e;
        cArr[0] = '\\';
        cArr[2] = '0';
        cArr[3] = '0';
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00f8, code lost:            return r12.f9767d.b(r7);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] a(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.d.a(java.lang.String):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:            r8 = r1 + 1;        r1 = r12.charAt(r1);        r9 = r2[r1];     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:            if (r9 >= 0) goto L51;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:            r1 = b(r1, r11.f9768e);     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:            r9 = r7 + r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:            if (r9 <= r6.length) goto L58;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:            r9 = r6.length - r7;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:            if (r9 <= 0) goto L57;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:            java.lang.System.arraycopy(r11.f9768e, 0, r6, r7, r9);     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:            r6 = r0.g();        r1 = r1 - r9;        java.lang.System.arraycopy(r11.f9768e, r9, r6, 0, r1);        r7 = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:            java.lang.System.arraycopy(r11.f9768e, 0, r6, r7, r1);        r7 = r9;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:            r1 = a(r9, r11.f9768e);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public char[] b(java.lang.String r12) {
        /*
            r11 = this;
            com.fasterxml.jackson.core.util.e r0 = r11.f9766c
            if (r0 != 0) goto Lc
            com.fasterxml.jackson.core.util.e r0 = new com.fasterxml.jackson.core.util.e
            r1 = 0
            r0.<init>(r1)
            r11.f9766c = r0
        Lc:
            char[] r1 = r0.e()
            int[] r2 = com.fasterxml.jackson.core.io.a.c()
            int r3 = r2.length
            int r4 = r12.length()
            r5 = 0
            r6 = r1
            r1 = 0
            r7 = 0
        L1d:
            if (r1 >= r4) goto L76
        L1f:
            char r8 = r12.charAt(r1)
            if (r8 >= r3) goto L62
            r9 = r2[r8]
            if (r9 == 0) goto L62
            int r8 = r1 + 1
            char r1 = r12.charAt(r1)
            r9 = r2[r1]
            if (r9 >= 0) goto L3a
            char[] r9 = r11.f9768e
            int r1 = r11.b(r1, r9)
            goto L40
        L3a:
            char[] r1 = r11.f9768e
            int r1 = r11.a(r9, r1)
        L40:
            int r9 = r7 + r1
            int r10 = r6.length
            if (r9 <= r10) goto L5a
            int r9 = r6.length
            int r9 = r9 - r7
            if (r9 <= 0) goto L4e
            char[] r10 = r11.f9768e
            java.lang.System.arraycopy(r10, r5, r6, r7, r9)
        L4e:
            char[] r6 = r0.g()
            int r1 = r1 - r9
            char[] r7 = r11.f9768e
            java.lang.System.arraycopy(r7, r9, r6, r5, r1)
            r7 = r1
            goto L60
        L5a:
            char[] r10 = r11.f9768e
            java.lang.System.arraycopy(r10, r5, r6, r7, r1)
            r7 = r9
        L60:
            r1 = r8
            goto L1d
        L62:
            int r9 = r6.length
            if (r7 < r9) goto L6a
            char[] r6 = r0.g()
            r7 = 0
        L6a:
            int r9 = r7 + 1
            r6[r7] = r8
            int r1 = r1 + 1
            if (r1 < r4) goto L74
            r7 = r9
            goto L76
        L74:
            r7 = r9
            goto L1f
        L76:
            r0.b(r7)
            char[] r12 = r0.a()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.d.b(java.lang.String):char[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x010a, code lost:            return r11.f9767d.b(r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:            if (r6 < r5.length) goto L95;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:            r5 = r0.a();        r6 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:            r8 = r3 + 1;        r3 = r12.charAt(r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:            if (r3 > 127) goto L99;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:            r6 = a(r3, r7[r3], r0, r6);        r5 = r0.b();     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:            if (r3 > 2047) goto L102;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:            r5[r6] = (byte) ((r3 >> 6) | 192);        r3 = (r3 & '?') | 128;        r6 = r6 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f5, code lost:            if (r6 < r5.length) goto L132;     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f7, code lost:            r5 = r0.a();        r6 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fc, code lost:            r5[r6] = (byte) r3;        r6 = r6 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0074, code lost:            if (r3 < 55296) goto L125;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:            if (r3 <= 57343) goto L107;     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007f, code lost:            if (r3 > 56319) goto L139;     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0081, code lost:            if (r8 >= r2) goto L135;     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0083, code lost:            r7 = r8 + 1;        r3 = a(r3, r12.charAt(r8));     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0090, code lost:            if (r3 > 1114111) goto L136;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0092, code lost:            r8 = r6 + 1;        r5[r6] = (byte) ((r3 >> 18) | 240);     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009c, code lost:            if (r8 < r5.length) goto L115;     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009e, code lost:            r5 = r0.a();        r8 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a3, code lost:            r6 = r8 + 1;        r5[r8] = (byte) (((r3 >> 12) & 63) | 128);     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00af, code lost:            if (r6 < r5.length) goto L118;     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b1, code lost:            r5 = r0.a();        r6 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b6, code lost:            r5[r6] = (byte) (((r3 >> 6) & 63) | 128);        r3 = (r3 & 63) | 128;        r6 = r6 + 1;        r8 = r7;     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c8, code lost:            a(r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00cb, code lost:            throw null;     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cc, code lost:            a(r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00cf, code lost:            throw null;     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d0, code lost:            a(r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d3, code lost:            throw null;     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d4, code lost:            r7 = r6 + 1;        r5[r6] = (byte) ((r3 >> '\f') | 224);     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00de, code lost:            if (r7 < r5.length) goto L128;     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e0, code lost:            r5 = r0.a();        r7 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e5, code lost:            r6 = r7 + 1;        r5[r7] = (byte) (((r3 >> 6) & 63) | 128);        r3 = (r3 & '?') | 128;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] c(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.d.c(java.lang.String):byte[]");
    }

    private int b(int i, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = f9764a;
        cArr[4] = cArr2[i >> 4];
        cArr[5] = cArr2[i & 15];
        return 6;
    }

    private int a(int i, char[] cArr) {
        cArr[1] = (char) i;
        return 2;
    }

    private int a(int i, int i2, com.fasterxml.jackson.core.util.c cVar, int i3) {
        cVar.c(i3);
        cVar.a(92);
        if (i2 < 0) {
            cVar.a(117);
            if (i > 255) {
                int i4 = i >> 8;
                cVar.a(f9765b[i4 >> 4]);
                cVar.a(f9765b[i4 & 15]);
                i &= 255;
            } else {
                cVar.a(48);
                cVar.a(48);
            }
            cVar.a(f9765b[i >> 4]);
            cVar.a(f9765b[i & 15]);
        } else {
            cVar.a((byte) i2);
        }
        return cVar.c();
    }

    private static int a(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return ((i - 55296) << 10) + 65536 + (i2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
    }

    private static void a(int i) {
        throw new IllegalArgumentException(i.c(i));
    }
}
