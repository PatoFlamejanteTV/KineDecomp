package com.mixpanel.android.java_websocket.c;

import android.annotation.SuppressLint;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;

/* compiled from: Base64.java */
@SuppressLint({"Assert"})
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f2994a;
    private static final byte[] b;
    private static final byte[] c;
    private static final byte[] d;
    private static final byte[] e;
    private static final byte[] f;
    private static final byte[] g;

    static {
        f2994a = !a.class.desiredAssertionStatus();
        b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        c = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        d = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        e = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f = new byte[]{45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        g = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    private static final byte[] b(int i) {
        if ((i & 16) == 16) {
            return d;
        }
        if ((i & 32) == 32) {
            return f;
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] c(int i) {
        if ((i & 16) == 16) {
            return e;
        }
        if ((i & 32) == 32) {
            return g;
        }
        return c;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, byte[] bArr2, int i, int i2) {
        a(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:            return r8;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] a(byte[] r5, int r6, int r7, byte[] r8, int r9, int r10) {
        /*
            r4 = 61
            r0 = 0
            byte[] r3 = b(r10)
            if (r7 <= 0) goto L2c
            r1 = r5[r6]
            int r1 = r1 << 24
            int r1 = r1 >>> 8
            r2 = r1
        L10:
            r1 = 1
            if (r7 <= r1) goto L2e
            int r1 = r6 + 1
            r1 = r5[r1]
            int r1 = r1 << 24
            int r1 = r1 >>> 16
        L1b:
            r1 = r1 | r2
            r2 = 2
            if (r7 <= r2) goto L27
            int r0 = r6 + 2
            r0 = r5[r0]
            int r0 = r0 << 24
            int r0 = r0 >>> 24
        L27:
            r0 = r0 | r1
            switch(r7) {
                case 1: goto L72;
                case 2: goto L53;
                case 3: goto L30;
                default: goto L2b;
            }
        L2b:
            return r8
        L2c:
            r2 = r0
            goto L10
        L2e:
            r1 = r0
            goto L1b
        L30:
            int r1 = r0 >>> 18
            r1 = r3[r1]
            r8[r9] = r1
            int r1 = r9 + 1
            int r2 = r0 >>> 12
            r2 = r2 & 63
            r2 = r3[r2]
            r8[r1] = r2
            int r1 = r9 + 2
            int r2 = r0 >>> 6
            r2 = r2 & 63
            r2 = r3[r2]
            r8[r1] = r2
            int r1 = r9 + 3
            r0 = r0 & 63
            r0 = r3[r0]
            r8[r1] = r0
            goto L2b
        L53:
            int r1 = r0 >>> 18
            r1 = r3[r1]
            r8[r9] = r1
            int r1 = r9 + 1
            int r2 = r0 >>> 12
            r2 = r2 & 63
            r2 = r3[r2]
            r8[r1] = r2
            int r1 = r9 + 2
            int r0 = r0 >>> 6
            r0 = r0 & 63
            r0 = r3[r0]
            r8[r1] = r0
            int r0 = r9 + 3
            r8[r0] = r4
            goto L2b
        L72:
            int r1 = r0 >>> 18
            r1 = r3[r1]
            r8[r9] = r1
            int r1 = r9 + 1
            int r0 = r0 >>> 12
            r0 = r0 & 63
            r0 = r3[r0]
            r8[r1] = r0
            int r0 = r9 + 2
            r8[r0] = r4
            int r0 = r9 + 3
            r8[r0] = r4
            goto L2b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.java_websocket.c.a.a(byte[], int, int, byte[], int, int):byte[]");
    }

    public static String a(byte[] bArr) {
        String str = null;
        try {
            str = a(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (!f2994a) {
                throw new AssertionError(e2.getMessage());
            }
        }
        if (f2994a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i, int i2, int i3) throws IOException {
        byte[] b2 = b(bArr, i, i2, i3);
        try {
            return new String(b2, "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            return new String(b2);
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2, int i3) throws IOException {
        C0056a c0056a;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i2);
        }
        if (i + i2 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
        }
        if ((i3 & 2) == 0) {
            boolean z = (i3 & 8) != 0;
            int i4 = (i2 % 3 > 0 ? 4 : 0) + ((i2 / 3) * 4);
            if (z) {
                i4 += i4 / 76;
            }
            byte[] bArr2 = new byte[i4];
            int i5 = i2 - 2;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i8 < i5) {
                a(bArr, i8 + i, 3, bArr2, i7, i3);
                int i9 = i6 + 4;
                if (z && i9 >= 76) {
                    bArr2[i7 + 4] = 10;
                    i7++;
                    i9 = 0;
                }
                i7 += 4;
                i6 = i9;
                i8 += 3;
            }
            if (i8 < i2) {
                a(bArr, i8 + i, i2 - i8, bArr2, i7, i3);
                i7 += 4;
            }
            if (i7 > bArr2.length - 1) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i7];
            System.arraycopy(bArr2, 0, bArr3, 0, i7);
            return bArr3;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                c0056a = new C0056a(byteArrayOutputStream, i3 | 1);
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(c0056a);
                    try {
                        gZIPOutputStream2.write(bArr, i, i2);
                        gZIPOutputStream2.close();
                        try {
                            gZIPOutputStream2.close();
                        } catch (Exception e2) {
                        }
                        try {
                            c0056a.close();
                        } catch (Exception e3) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e4) {
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (IOException e5) {
                        e = e5;
                        gZIPOutputStream = gZIPOutputStream2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception e6) {
                            }
                            try {
                                c0056a.close();
                            } catch (Exception e7) {
                            }
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (Exception e8) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        gZIPOutputStream = gZIPOutputStream2;
                        gZIPOutputStream.close();
                        c0056a.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e9) {
                    e = e9;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e10) {
                e = e10;
                c0056a = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
            } catch (Throwable th4) {
                th = th4;
                c0056a = null;
            }
        } catch (IOException e11) {
            e = e11;
            c0056a = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            c0056a = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        }
        if (i < 0 || i + 3 >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
        }
        if (i2 < 0 || i2 + 2 >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
        }
        byte[] c2 = c(i3);
        if (bArr[i + 2] == 61) {
            bArr2[i2] = (byte) ((((c2[bArr[i]] & 255) << 18) | ((c2[bArr[i + 1]] & 255) << 12)) >>> 16);
            return 1;
        }
        if (bArr[i + 3] == 61) {
            int i4 = ((c2[bArr[i]] & 255) << 18) | ((c2[bArr[i + 1]] & 255) << 12) | ((c2[bArr[i + 2]] & 255) << 6);
            bArr2[i2] = (byte) (i4 >>> 16);
            bArr2[i2 + 1] = (byte) (i4 >>> 8);
            return 2;
        }
        int i5 = ((c2[bArr[i]] & 255) << 18) | ((c2[bArr[i + 1]] & 255) << 12) | ((c2[bArr[i + 2]] & 255) << 6) | (c2[bArr[i + 3]] & 255);
        bArr2[i2] = (byte) (i5 >> 16);
        bArr2[i2 + 1] = (byte) (i5 >> 8);
        bArr2[i2 + 2] = (byte) i5;
        return 3;
    }

    /* compiled from: Base64.java */
    /* renamed from: com.mixpanel.android.java_websocket.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0056a extends FilterOutputStream {

        /* renamed from: a, reason: collision with root package name */
        private boolean f2995a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private boolean f;
        private byte[] g;
        private boolean h;
        private int i;
        private byte[] j;

        public C0056a(OutputStream outputStream, int i) {
            super(outputStream);
            this.f = (i & 8) != 0;
            this.f2995a = (i & 1) != 0;
            this.d = this.f2995a ? 3 : 4;
            this.c = new byte[this.d];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = i;
            this.j = a.c(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.h) {
                this.out.write(i);
                return;
            }
            if (this.f2995a) {
                byte[] bArr = this.c;
                int i2 = this.b;
                this.b = i2 + 1;
                bArr[i2] = (byte) i;
                if (this.b >= this.d) {
                    this.out.write(a.b(this.g, this.c, this.d, this.i));
                    this.e += 4;
                    if (this.f && this.e >= 76) {
                        this.out.write(10);
                        this.e = 0;
                    }
                    this.b = 0;
                    return;
                }
                return;
            }
            if (this.j[i & 127] > -5) {
                byte[] bArr2 = this.c;
                int i3 = this.b;
                this.b = i3 + 1;
                bArr2[i3] = (byte) i;
                if (this.b >= this.d) {
                    this.out.write(this.g, 0, a.b(this.c, 0, this.g, 0, this.i));
                    this.b = 0;
                    return;
                }
                return;
            }
            if (this.j[i & 127] != -5) {
                throw new IOException("Invalid character in Base64 data.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.h) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        public void a() throws IOException {
            if (this.b > 0) {
                if (this.f2995a) {
                    this.out.write(a.b(this.g, this.c, this.b, this.i));
                    this.b = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a();
            super.close();
            this.c = null;
            this.out = null;
        }
    }
}