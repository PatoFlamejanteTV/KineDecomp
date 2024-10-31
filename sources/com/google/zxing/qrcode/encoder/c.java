package com.google.zxing.qrcode.encoder;

/* compiled from: MaskUtil.java */
/* loaded from: classes2.dex */
final class c {
    public static int a(ByteMatrix byteMatrix) {
        return a(byteMatrix, true) + a(byteMatrix, false);
    }

    public static int b(ByteMatrix byteMatrix) {
        byte[][] a2 = byteMatrix.a();
        int c2 = byteMatrix.c();
        int b2 = byteMatrix.b();
        int i = 0;
        int i2 = 0;
        while (i < b2 - 1) {
            int i3 = i2;
            int i4 = 0;
            while (i4 < c2 - 1) {
                byte b3 = a2[i][i4];
                int i5 = i4 + 1;
                if (b3 == a2[i][i5]) {
                    int i6 = i + 1;
                    if (b3 == a2[i6][i4] && b3 == a2[i6][i5]) {
                        i3++;
                    }
                }
                i4 = i5;
            }
            i++;
            i2 = i3;
        }
        return i2 * 3;
    }

    public static int c(ByteMatrix byteMatrix) {
        byte[][] a2 = byteMatrix.a();
        int c2 = byteMatrix.c();
        int b2 = byteMatrix.b();
        int i = 0;
        int i2 = 0;
        while (i < b2) {
            int i3 = i2;
            for (int i4 = 0; i4 < c2; i4++) {
                byte[] bArr = a2[i];
                int i5 = i4 + 6;
                if (i5 < c2 && bArr[i4] == 1 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 1 && bArr[i4 + 3] == 1 && bArr[i4 + 4] == 1 && bArr[i4 + 5] == 0 && bArr[i5] == 1 && (a(bArr, i4 - 4, i4) || a(bArr, i4 + 7, i4 + 11))) {
                    i3++;
                }
                int i6 = i + 6;
                if (i6 < b2 && a2[i][i4] == 1 && a2[i + 1][i4] == 0 && a2[i + 2][i4] == 1 && a2[i + 3][i4] == 1 && a2[i + 4][i4] == 1 && a2[i + 5][i4] == 0 && a2[i6][i4] == 1 && (a(a2, i4, i - 4, i) || a(a2, i4, i + 7, i + 11))) {
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        return i2 * 40;
    }

    public static int d(ByteMatrix byteMatrix) {
        byte[][] a2 = byteMatrix.a();
        int c2 = byteMatrix.c();
        int b2 = byteMatrix.b();
        int i = 0;
        int i2 = 0;
        while (i < b2) {
            byte[] bArr = a2[i];
            int i3 = i2;
            for (int i4 = 0; i4 < c2; i4++) {
                if (bArr[i4] == 1) {
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        int b3 = byteMatrix.b() * byteMatrix.c();
        return ((Math.abs((i2 << 1) - b3) * 10) / b3) * 10;
    }

    private static boolean a(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, bArr.length);
        for (int max = Math.max(i, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(byte[][] bArr, int i, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max][i] == 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0001. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0043 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L3e;
                case 1: goto L3f;
                case 2: goto L3b;
                case 3: goto L37;
                case 4: goto L32;
                case 5: goto L2a;
                case 6: goto L21;
                case 7: goto L18;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid mask pattern: "
            r3.<init>(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L18:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L28
        L21:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L28:
            r1 = r1 & r0
            goto L41
        L2a:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L41
        L32:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L3e
        L37:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L41
        L3b:
            int r1 = r2 % 3
            goto L41
        L3e:
            int r3 = r3 + r2
        L3f:
            r1 = r3 & 1
        L41:
            if (r1 != 0) goto L44
            return r0
        L44:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.c.a(int, int, int):boolean");
    }

    private static int a(ByteMatrix byteMatrix, boolean z) {
        int b2 = z ? byteMatrix.b() : byteMatrix.c();
        int c2 = z ? byteMatrix.c() : byteMatrix.b();
        byte[][] a2 = byteMatrix.a();
        int i = 0;
        for (int i2 = 0; i2 < b2; i2++) {
            int i3 = i;
            int i4 = 0;
            byte b3 = -1;
            for (int i5 = 0; i5 < c2; i5++) {
                byte b4 = z ? a2[i2][i5] : a2[i5][i2];
                if (b4 == b3) {
                    i4++;
                } else {
                    if (i4 >= 5) {
                        i3 += (i4 - 5) + 3;
                    }
                    i4 = 1;
                    b3 = b4;
                }
            }
            if (i4 >= 5) {
                i3 += (i4 - 5) + 3;
            }
            i = i3;
        }
        return i;
    }
}