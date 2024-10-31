package com.facebook.ads.redexgen.X;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.0S, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C0S implements C0O {
    public static byte[] A03;
    public File A00;
    public RandomAccessFile A01;
    public final C0F A02;

    static {
        A01();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0S.A03
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0S.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A03 = new byte[]{66, 117, 117, 104, 117, 39, 117, 98, 102, 99, 110, 105, 96, 39, 107, 98, 105, 96, 115, 111, 39, 104, 97, 39, 97, 110, 107, 98, 39, 82, 101, 101, 120, 101, 55, 101, 114, 121, 118, 122, 126, 121, 112, 55, 113, 126, 123, 114, 55, 19, 85, 92, 65, 19, 80, 92, 94, 67, 95, 86, 71, 90, 92, 93, 18, 9, 12, 115, 68, 68, 89, 68, 22, 67, 69, 95, 88, 81, 22, 80, 95, 90, 83, 22, 58, 112, 123, 99, 122, 120, 123, 117, 112, 5, 50, 50, 47, 50, 96, 33, 48, 48, 37, 46, 36, 96, 35, 33, 35, 40, 37, 122, 96, 35, 33, 35, 40, 37, 96, 38, 41, 44, 37, 96, 46, 111, 125, 46, 106, 103, 125, 109, 46, 109, 111, 109, 102, 107, 31, 61, 50, 123, 40, 124, 63, 48, 57, 61, 50, 124, 58, 53, 48, 57, 82, 105, 94, 94, 67, 94, 12, 91, 94, 69, 88, 69, 66, 75, 12, 9, 72, 12, 78, 85, 88, 73, 95, 12, 88, 67, 12, 9, 95, 12, 74, 94, 67, 65, 12, 78, 89, 74, 74, 73, 94, 12, 91, 69, 88, 68, 12, 95, 69, 86, 73, 12, 9, 72, 77, 122, 122, 103, 122, 40, 107, 100, 103, 123, 97, 102, 111, 40, 110, 97, 100, 109, 40, 32, 116, 111, 32, 123, 50, 40, 123, 56, 52, 54, 43, 55, 62, 47, 62, 63, 122, 92, 107, 107, 118, 107, 57, 118, 105, 124, 119, 112, 119, 126, 57};
    }

    public C0S(File directory, C0F c0f) throws C0W {
        try {
            if (c0f == null) {
                throw new NullPointerException();
            }
            this.A02 = c0f;
            C0I.A06(directory.getParentFile());
            boolean exists = directory.exists();
            this.A00 = exists ? directory : new File(directory.getParentFile(), directory.getName() + A00(84, 9, 116));
            this.A01 = new RandomAccessFile(this.A00, exists ? A00(154, 1, 64) : A00(65, 2, 27));
        } catch (IOException e) {
            throw new C0W(A00(67, 17, 86) + directory + A00(124, 14, 110), e);
        }
    }

    private boolean A02(File file) {
        return file.getName().endsWith(A00(84, 9, 116));
    }

    public final synchronized int A03() throws C0W {
        try {
        } catch (IOException e) {
            throw new C0W(A00(0, 29, 103) + this.A00, e);
        }
        return (int) this.A01.length();
    }

    public final File A04() {
        return this.A00;
    }

    public final synchronized void A05() throws C0W {
        try {
            this.A01.setLength(0L);
        } catch (IOException e) {
            throw new C0W(A00(138, 16, 60), e);
        }
    }

    public final synchronized void A06() throws C0W {
        try {
            this.A01.close();
            this.A02.A8T(this.A00);
        } catch (IOException e) {
            throw new C0W(A00(208, 19, 104) + this.A00, e);
        }
    }

    public final synchronized void A07() throws C0W {
        if (!A09()) {
            A06();
            File file = new File(this.A00.getParentFile(), this.A00.getName().substring(0, this.A00.getName().length() - A00(84, 9, 116).length()));
            if (!this.A00.renameTo(file)) {
                StringBuilder sb = new StringBuilder();
                String fileName = A00(29, 20, 119);
                StringBuilder append = sb.append(fileName).append(this.A00);
                String fileName2 = A00(227, 4, 96);
                StringBuilder append2 = append.append(fileName2).append(file);
                String fileName3 = A00(49, 16, 83);
                throw new C0W(append2.append(fileName3).toString());
            }
            this.A00 = file;
            try {
                File file2 = this.A00;
                String fileName4 = A00(154, 1, 64);
                this.A01 = new RandomAccessFile(file2, fileName4);
            } catch (IOException e) {
                throw new C0W(A00(245, 14, 121) + this.A00 + A00(124, 14, 110), e);
            }
        }
    }

    public final synchronized void A08(byte[] bArr, int i) throws C0W {
        try {
            if (A09()) {
                throw new C0W(A00(93, 31, 32) + this.A00 + A00(231, 14, 59));
            }
            this.A01.seek(A03());
            this.A01.write(bArr, 0, i);
        } catch (IOException e) {
            throw new C0W(String.format(Locale.US, A00(155, 53, 76), Integer.valueOf(i), this.A01, Integer.valueOf(bArr.length)), e);
        }
    }

    public final synchronized boolean A09() {
        return !A02(this.A00);
    }
}
