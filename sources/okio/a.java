package okio;

import java.io.UnsupportedEncodingException;

/* compiled from: Base64.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f4929a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    public static byte[] a(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        int length = str.length();
        while (length > 0) {
            char charAt = str.charAt(length - 1);
            if (charAt != '=' && charAt != '\n' && charAt != '\r' && charAt != ' ' && charAt != '\t') {
                break;
            }
            length--;
        }
        byte[] bArr = new byte[(int) ((length * 6) / 8)];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i5 < length) {
            char charAt2 = str.charAt(i5);
            if (charAt2 >= 'A' && charAt2 <= 'Z') {
                i4 = charAt2 - 'A';
            } else if (charAt2 >= 'a' && charAt2 <= 'z') {
                i4 = charAt2 - 'G';
            } else if (charAt2 >= '0' && charAt2 <= '9') {
                i4 = charAt2 + 4;
            } else if (charAt2 == '+') {
                i4 = 62;
            } else if (charAt2 == '/') {
                i4 = 63;
            } else {
                if (charAt2 == '\n' || charAt2 == '\r' || charAt2 == ' ') {
                    i = i6;
                    i2 = i7;
                    i3 = i8;
                } else {
                    if (charAt2 != '\t') {
                        return null;
                    }
                    i = i6;
                    i2 = i7;
                    i3 = i8;
                }
                i5++;
                i8 = i3;
                i7 = i2;
                i6 = i;
            }
            i = ((byte) i4) | (i6 << 6);
            i2 = i7 + 1;
            if (i2 % 4 == 0) {
                int i9 = i8 + 1;
                bArr[i8] = (byte) (i >> 16);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (i >> 8);
                i3 = i10 + 1;
                bArr[i10] = (byte) i;
            } else {
                i3 = i8;
            }
            i5++;
            i8 = i3;
            i7 = i2;
            i6 = i;
        }
        int i11 = i7 % 4;
        if (i11 == 1) {
            return null;
        }
        if (i11 == 2) {
            bArr[i8] = (byte) ((i6 << 12) >> 16);
            i8++;
        } else if (i11 == 3) {
            int i12 = i6 << 6;
            int i13 = i8 + 1;
            bArr[i8] = (byte) (i12 >> 16);
            i8 = i13 + 1;
            bArr[i13] = (byte) (i12 >> 8);
        }
        if (i8 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, 0, bArr2, 0, i8);
        return bArr2;
    }

    public static String a(byte[] bArr) {
        int i = 0;
        byte[] bArr2 = new byte[((bArr.length + 2) * 4) / 3];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            bArr2[i] = f4929a[(bArr[i2] & 255) >> 2];
            int i4 = i3 + 1;
            bArr2[i3] = f4929a[((bArr[i2] & 3) << 4) | ((bArr[i2 + 1] & 255) >> 4)];
            int i5 = i4 + 1;
            bArr2[i4] = f4929a[((bArr[i2 + 1] & 15) << 2) | ((bArr[i2 + 2] & 255) >> 6)];
            bArr2[i5] = f4929a[bArr[i2 + 2] & 63];
            i2 += 3;
            i = i5 + 1;
        }
        switch (bArr.length % 3) {
            case 1:
                int i6 = i + 1;
                bArr2[i] = f4929a[(bArr[length] & 255) >> 2];
                int i7 = i6 + 1;
                bArr2[i6] = f4929a[(bArr[length] & 3) << 4];
                int i8 = i7 + 1;
                bArr2[i7] = 61;
                i = i8 + 1;
                bArr2[i8] = 61;
                break;
            case 2:
                int i9 = i + 1;
                bArr2[i] = f4929a[(bArr[length] & 255) >> 2];
                int i10 = i9 + 1;
                bArr2[i9] = f4929a[((bArr[length] & 3) << 4) | ((bArr[length + 1] & 255) >> 4)];
                int i11 = i10 + 1;
                bArr2[i10] = f4929a[(bArr[length + 1] & 15) << 2];
                i = i11 + 1;
                bArr2[i11] = 61;
                break;
        }
        try {
            return new String(bArr2, 0, i, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
