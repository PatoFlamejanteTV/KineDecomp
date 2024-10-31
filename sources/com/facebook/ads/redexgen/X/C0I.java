package com.facebook.ads.redexgen.X;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.0I, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C0I {
    public static byte[] A00;

    static {
        A02();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0I.A00
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
            r0 = r0 ^ 47
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0I.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{58, 13, 13, 16, 13, 95, 13, 26, 28, 13, 26, 30, 11, 26, 95, 5, 26, 13, 16, 82, 12, 22, 5, 26, 95, 25, 22, 19, 26, 95, 53, 24, 3, 20, 18, 5, 30, 3, 8, 81, 84, 2, 81, 18, 16, 31, 86, 5, 81, 19, 20, 81, 18, 3, 20, 16, 5, 20, 21, 83, 26, 0, 83, 29, 28, 7, 83, 23, 26, 1, 22, 16, 7, 28, 1, 10, 82, 22, 57, 60, 53, 112, 27, 44, 44, 49, 44, 126, 45, 59, 42, 126, 50, 63, 45, 42, 126, 51, 49, 58, 55, 56, 55, 59, 58, 126, 58, 63, 42, 59, 126, 42, 49, 126, 64, 69, 86};
    }

    public static List<File> A01(File file) {
        List<File> result = new LinkedList<>();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            List<File> result2 = Arrays.asList(listFiles);
            Collections.sort(result2, new C0H());
            return result2;
        }
        return result;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0009. Please report as an issue. */
    public static void A03(File file) throws IOException {
        long j = 0;
        char c = file.exists() ? (char) 2 : (char) 5;
        while (true) {
            switch (c) {
                case 2:
                    file = file;
                    j = System.currentTimeMillis();
                    c = !file.setLastModified(j) ? (char) 3 : (char) 5;
                case 3:
                    file = file;
                    A04(file);
                    c = file.lastModified() < j ? (char) 4 : (char) 5;
                case 4:
                    throw new IOException(A00(82, 32, 113) + file);
                case 5:
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A04(java.io.File r8) throws java.io.IOException {
        /*
            r0 = 0
            r0 = 0
            r6 = 1
            long r4 = r8.length()
            r1 = 0
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 != 0) goto L42
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L15;
                case 3: goto L44;
                case 4: goto L1c;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            java.io.File r8 = (java.io.File) r8
            A05(r8)
            r0 = 3
            goto L11
        L1c:
            java.io.File r8 = (java.io.File) r8
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile
            r2 = 114(0x72, float:1.6E-43)
            r1 = 3
            r0 = 29
            java.lang.String r0 = A00(r2, r1, r0)
            r3.<init>(r8, r0)
            long r0 = r4 - r6
            r3.seek(r0)
            byte r2 = r3.readByte()
            long r0 = r4 - r6
            r3.seek(r0)
            r3.write(r2)
            r3.close()
            r0 = 3
            goto L11
        L42:
            r0 = 4
            goto L11
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0I.A04(java.io.File):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0007. Please report as an issue. */
    public static void A05(File file) throws IOException {
        char c = file.delete() ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    file = file;
                    c = !file.createNewFile() ? (char) 3 : (char) 4;
                case 3:
                    throw new IOException(A00(0, 30, 80) + file);
                case 4:
                    return;
            }
        }
    }

    public static synchronized void A06(File file) throws IOException {
        synchronized (C0I.class) {
            if (file.exists()) {
                if (!file.isDirectory()) {
                    throw new IOException(A00(77, 5, 127) + file + A00(59, 18, 92));
                }
            } else if (!file.mkdirs()) {
                throw new IOException(String.format(Locale.US, A00(30, 29, 94), file.getAbsolutePath()));
            }
        }
    }
}
