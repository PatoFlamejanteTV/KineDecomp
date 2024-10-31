package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.0Y, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C0Y {
    public static byte[] A00;

    static {
        A06();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0Y.A00
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
            int r0 = r0 + (-113)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0Y.A04(int, int, int):java.lang.String");
    }

    public static void A06() {
        A00 = new byte[]{67, 70, 73, 66, 23, 12, 12};
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0033, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(android.graphics.BitmapFactory.Options r6, int r7, int r8) {
        /*
            r5 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r4 = 0
            int r3 = r6.outHeight
            int r2 = r6.outWidth
            r1 = 1
            if (r3 > r8) goto L31
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L2b;
                case 3: goto L25;
                case 4: goto L1d;
                case 5: goto L15;
                case 6: goto L11;
                case 7: goto L33;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            int r1 = r1 * 2
            r0 = 4
            goto Ld
        L15:
            int r0 = r5 / r1
            if (r0 < r7) goto L1b
            r0 = 6
            goto Ld
        L1b:
            r0 = 7
            goto Ld
        L1d:
            int r0 = r4 / r1
            if (r0 < r8) goto L23
            r0 = 5
            goto Ld
        L23:
            r0 = 7
            goto Ld
        L25:
            int r4 = r3 / 2
            int r5 = r2 / 2
            r0 = 4
            goto Ld
        L2b:
            if (r2 <= r7) goto L2f
            r0 = 3
            goto Ld
        L2f:
            r0 = 7
            goto Ld
        L31:
            r0 = 3
            goto Ld
        L33:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0Y.A00(android.graphics.BitmapFactory$Options, int, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap A01(java.io.InputStream r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = 0
            r4 = 0
            r3 = 0
            r0 = 0
            r2 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 19
            if (r1 >= r0) goto L58
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L5a;
                case 4: goto L18;
                case 5: goto L3d;
                case 6: goto L50;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            java.io.InputStream r6 = (java.io.InputStream) r6
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r6)
            r0 = 3
            goto Lc
        L18:
            java.io.InputStream r6 = (java.io.InputStream) r6
            r2 = 0
            com.facebook.ads.redexgen.X.0Z r3 = new com.facebook.ads.redexgen.X.0Z
            r3.<init>(r6)
            r0 = 8192(0x2000, float:1.148E-41)
            r3.mark(r0)
            android.graphics.BitmapFactory$Options r5 = new android.graphics.BitmapFactory$Options
            r5.<init>()
            r0 = 1
            r5.inJustDecodeBounds = r0
            android.graphics.BitmapFactory.decodeStream(r3, r2, r5)
            r3.reset()
            boolean r0 = r3.A00()
            if (r0 != 0) goto L3b
            r0 = 5
            goto Lc
        L3b:
            r0 = 6
            goto Lc
        L3d:
            com.facebook.ads.redexgen.X.0Z r3 = (com.facebook.ads.redexgen.X.C0Z) r3
            android.graphics.BitmapFactory$Options r5 = (android.graphics.BitmapFactory.Options) r5
            int r0 = A00(r5, r7, r8)
            r5.inSampleSize = r0
            r0 = 0
            r5.inJustDecodeBounds = r0
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r3, r2, r5)
            r0 = 3
            goto Lc
        L50:
            com.facebook.ads.redexgen.X.0Z r3 = (com.facebook.ads.redexgen.X.C0Z) r3
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r3)
            r0 = 3
            goto Lc
        L58:
            r0 = 4
            goto Lc
        L5a:
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0Y.A01(java.io.InputStream, int, int):android.graphics.Bitmap");
    }

    @SuppressLint({"CatchGeneralException"})
    public static Bitmap A02(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = A00(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    @SuppressLint({"CatchGeneralException"})
    @Nullable
    public static Bitmap A03(String str, int i, int i2, boolean z) throws IOException {
        Bitmap decodeStream;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(new File(str));
            try {
                if (i > 0 && i2 > 0) {
                    if (z) {
                        decodeStream = A01(fileInputStream2, i, i2);
                        A07(fileInputStream2);
                    } else {
                        decodeStream = A02(str, i, i2);
                        A07(fileInputStream2);
                    }
                } else {
                    decodeStream = BitmapFactory.decodeStream(fileInputStream2);
                    A07(fileInputStream2);
                }
                return decodeStream;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                A07(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A05(@android.support.annotation.Nullable java.io.File r4) {
        /*
            r1 = 0
            if (r4 == 0) goto L2c
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L2e;
                case 4: goto L29;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            java.io.File r4 = (java.io.File) r4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 0
            r1 = 7
            r0 = 108(0x6c, float:1.51E-43)
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.StringBuilder r1 = r3.append(r0)
            java.lang.String r0 = r4.getPath()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = r0.toString()
            r0 = 3
            goto L4
        L29:
            r1 = 0
            r0 = 3
            goto L4
        L2c:
            r0 = 4
            goto L4
        L2e:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0Y.A05(java.io.File):java.lang.String");
    }

    public static void A07(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }
}
