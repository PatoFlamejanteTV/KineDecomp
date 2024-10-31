package com.fasterxml.jackson.core.io;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.dumpapp.Framer;

/* compiled from: NumberOutput.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a */
    private static int f9776a = 1000000;

    /* renamed from: b */
    private static int f9777b = 1000000000;

    /* renamed from: c */
    private static long f9778c = 1000000000;

    /* renamed from: d */
    private static long f9779d = -2147483648L;

    /* renamed from: e */
    private static long f9780e = 2147483647L;

    /* renamed from: f */
    static final String f9781f = String.valueOf(Integer.MIN_VALUE);

    /* renamed from: g */
    static final String f9782g = String.valueOf(Long.MIN_VALUE);

    /* renamed from: h */
    private static final int[] f9783h = new int[1000];
    private static final String[] i;
    private static final String[] j;

    static {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 10) {
            int i4 = i3;
            int i5 = 0;
            while (i5 < 10) {
                int i6 = i4;
                int i7 = 0;
                while (i7 < 10) {
                    f9783h[i6] = ((i2 + 48) << 16) | ((i5 + 48) << 8) | (i7 + 48);
                    i7++;
                    i6++;
                }
                i5++;
                i4 = i6;
            }
            i2++;
            i3 = i4;
        }
        i = new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        j = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    public static int a(int i2, char[] cArr, int i3) {
        int i4;
        if (i2 < 0) {
            if (i2 == Integer.MIN_VALUE) {
                return a(cArr, i3);
            }
            cArr[i3] = '-';
            i2 = -i2;
            i3++;
        }
        if (i2 < f9776a) {
            if (i2 >= 1000) {
                int i5 = i2 / 1000;
                return b(i2 - (i5 * 1000), cArr, c(i5, cArr, i3));
            }
            if (i2 < 10) {
                cArr[i3] = (char) (i2 + 48);
                return i3 + 1;
            }
            return c(i2, cArr, i3);
        }
        int i6 = f9777b;
        if (i2 >= i6) {
            int i7 = i2 - i6;
            if (i7 >= i6) {
                i7 -= i6;
                i4 = i3 + 1;
                cArr[i3] = '2';
            } else {
                i4 = i3 + 1;
                cArr[i3] = '1';
            }
            return d(i7, cArr, i4);
        }
        int i8 = i2 / 1000;
        int i9 = i8 / 1000;
        return b(i2 - (i8 * 1000), cArr, b(i8 - (i9 * 1000), cArr, c(i9, cArr, i3)));
    }

    private static int b(int i2, char[] cArr, int i3) {
        int i4 = f9783h[i2];
        int i5 = i3 + 1;
        cArr[i3] = (char) (i4 >> 16);
        int i6 = i5 + 1;
        cArr[i5] = (char) ((i4 >> 8) & 127);
        int i7 = i6 + 1;
        cArr[i6] = (char) (i4 & 127);
        return i7;
    }

    private static int c(int i2, char[] cArr, int i3) {
        int i4;
        int i5 = f9783h[i2];
        if (i2 > 9) {
            if (i2 > 99) {
                i4 = i3 + 1;
                cArr[i3] = (char) (i5 >> 16);
            } else {
                i4 = i3;
            }
            i3 = i4 + 1;
            cArr[i4] = (char) ((i5 >> 8) & 127);
        }
        int i6 = i3 + 1;
        cArr[i3] = (char) (i5 & 127);
        return i6;
    }

    private static int d(int i2, char[] cArr, int i3) {
        int i4 = i2 / 1000;
        int i5 = i2 - (i4 * 1000);
        int i6 = i4 / 1000;
        int[] iArr = f9783h;
        int i7 = iArr[i6];
        int i8 = i3 + 1;
        cArr[i3] = (char) (i7 >> 16);
        int i9 = i8 + 1;
        cArr[i8] = (char) ((i7 >> 8) & 127);
        int i10 = i9 + 1;
        cArr[i9] = (char) (i7 & 127);
        int i11 = iArr[i4 - (i6 * 1000)];
        int i12 = i10 + 1;
        cArr[i10] = (char) (i11 >> 16);
        int i13 = i12 + 1;
        cArr[i12] = (char) ((i11 >> 8) & 127);
        int i14 = i13 + 1;
        cArr[i13] = (char) (i11 & 127);
        int i15 = iArr[i5];
        int i16 = i14 + 1;
        cArr[i14] = (char) (i15 >> 16);
        int i17 = i16 + 1;
        cArr[i16] = (char) ((i15 >> 8) & 127);
        int i18 = i17 + 1;
        cArr[i17] = (char) (i15 & 127);
        return i18;
    }

    private static int e(int i2, char[] cArr, int i3) {
        if (i2 < f9776a) {
            if (i2 < 1000) {
                return c(i2, cArr, i3);
            }
            int i4 = i2 / 1000;
            return a(cArr, i3, i4, i2 - (i4 * 1000));
        }
        int i5 = i2 / 1000;
        int i6 = i2 - (i5 * 1000);
        int i7 = i5 / 1000;
        int i8 = i5 - (i7 * 1000);
        int c2 = c(i7, cArr, i3);
        int[] iArr = f9783h;
        int i9 = iArr[i8];
        int i10 = c2 + 1;
        cArr[c2] = (char) (i9 >> 16);
        int i11 = i10 + 1;
        cArr[i10] = (char) ((i9 >> 8) & 127);
        int i12 = i11 + 1;
        cArr[i11] = (char) (i9 & 127);
        int i13 = iArr[i6];
        int i14 = i12 + 1;
        cArr[i12] = (char) (i13 >> 16);
        int i15 = i14 + 1;
        cArr[i14] = (char) ((i13 >> 8) & 127);
        int i16 = i15 + 1;
        cArr[i15] = (char) (i13 & 127);
        return i16;
    }

    private static int b(int i2, byte[] bArr, int i3) {
        int i4 = f9783h[i2];
        int i5 = i3 + 1;
        bArr[i3] = (byte) (i4 >> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i4 >> 8);
        int i7 = i6 + 1;
        bArr[i6] = (byte) i4;
        return i7;
    }

    private static int c(int i2, byte[] bArr, int i3) {
        int i4;
        int i5 = f9783h[i2];
        if (i2 > 9) {
            if (i2 > 99) {
                i4 = i3 + 1;
                bArr[i3] = (byte) (i5 >> 16);
            } else {
                i4 = i3;
            }
            i3 = i4 + 1;
            bArr[i4] = (byte) (i5 >> 8);
        }
        int i6 = i3 + 1;
        bArr[i3] = (byte) i5;
        return i6;
    }

    private static int b(char[] cArr, int i2) {
        int length = f9782g.length();
        f9782g.getChars(0, length, cArr, i2);
        return i2 + length;
    }

    private static int b(byte[] bArr, int i2) {
        int length = f9782g.length();
        int i3 = 0;
        while (i3 < length) {
            bArr[i2] = (byte) f9782g.charAt(i3);
            i3++;
            i2++;
        }
        return i2;
    }

    private static int d(int i2, byte[] bArr, int i3) {
        int i4 = i2 / 1000;
        int i5 = i2 - (i4 * 1000);
        int i6 = i4 / 1000;
        int i7 = i4 - (i6 * 1000);
        int[] iArr = f9783h;
        int i8 = iArr[i6];
        int i9 = i3 + 1;
        bArr[i3] = (byte) (i8 >> 16);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i8 >> 8);
        int i11 = i10 + 1;
        bArr[i10] = (byte) i8;
        int i12 = iArr[i7];
        int i13 = i11 + 1;
        bArr[i11] = (byte) (i12 >> 16);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (i12 >> 8);
        int i15 = i14 + 1;
        bArr[i14] = (byte) i12;
        int i16 = iArr[i5];
        int i17 = i15 + 1;
        bArr[i15] = (byte) (i16 >> 16);
        int i18 = i17 + 1;
        bArr[i17] = (byte) (i16 >> 8);
        int i19 = i18 + 1;
        bArr[i18] = (byte) i16;
        return i19;
    }

    private static int e(int i2, byte[] bArr, int i3) {
        if (i2 < f9776a) {
            if (i2 < 1000) {
                return c(i2, bArr, i3);
            }
            int i4 = i2 / 1000;
            return a(bArr, i3, i4, i2 - (i4 * 1000));
        }
        int i5 = i2 / 1000;
        int i6 = i2 - (i5 * 1000);
        int i7 = i5 / 1000;
        int i8 = i5 - (i7 * 1000);
        int c2 = c(i7, bArr, i3);
        int[] iArr = f9783h;
        int i9 = iArr[i8];
        int i10 = c2 + 1;
        bArr[c2] = (byte) (i9 >> 16);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i9 >> 8);
        int i12 = i11 + 1;
        bArr[i11] = (byte) i9;
        int i13 = iArr[i6];
        int i14 = i12 + 1;
        bArr[i12] = (byte) (i13 >> 16);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i13 >> 8);
        int i16 = i15 + 1;
        bArr[i15] = (byte) i13;
        return i16;
    }

    public static int a(int i2, byte[] bArr, int i3) {
        int i4;
        if (i2 < 0) {
            if (i2 == Integer.MIN_VALUE) {
                return a(bArr, i3);
            }
            bArr[i3] = Framer.STDIN_FRAME_PREFIX;
            i2 = -i2;
            i3++;
        }
        if (i2 < f9776a) {
            if (i2 >= 1000) {
                int i5 = i2 / 1000;
                return b(i2 - (i5 * 1000), bArr, c(i5, bArr, i3));
            }
            if (i2 < 10) {
                int i6 = i3 + 1;
                bArr[i3] = (byte) (i2 + 48);
                return i6;
            }
            return c(i2, bArr, i3);
        }
        int i7 = f9777b;
        if (i2 >= i7) {
            int i8 = i2 - i7;
            if (i8 >= i7) {
                i8 -= i7;
                i4 = i3 + 1;
                bArr[i3] = Framer.STDERR_FRAME_PREFIX;
            } else {
                i4 = i3 + 1;
                bArr[i3] = Framer.STDOUT_FRAME_PREFIX;
            }
            return d(i8, bArr, i4);
        }
        int i9 = i2 / 1000;
        int i10 = i9 / 1000;
        return b(i2 - (i9 * 1000), bArr, b(i9 - (i10 * 1000), bArr, c(i10, bArr, i3)));
    }

    public static int a(long j2, char[] cArr, int i2) {
        int d2;
        if (j2 < 0) {
            if (j2 > f9779d) {
                return a((int) j2, cArr, i2);
            }
            if (j2 == Long.MIN_VALUE) {
                return b(cArr, i2);
            }
            cArr[i2] = '-';
            j2 = -j2;
            i2++;
        } else if (j2 <= f9780e) {
            return a((int) j2, cArr, i2);
        }
        long j3 = f9778c;
        long j4 = j2 / j3;
        long j5 = j2 - (j4 * j3);
        if (j4 < j3) {
            d2 = e((int) j4, cArr, i2);
        } else {
            long j6 = j4 / j3;
            int c2 = c((int) j6, cArr, i2);
            d2 = d((int) (j4 - (j3 * j6)), cArr, c2);
        }
        return d((int) j5, cArr, d2);
    }

    public static int a(long j2, byte[] bArr, int i2) {
        int d2;
        if (j2 < 0) {
            if (j2 > f9779d) {
                return a((int) j2, bArr, i2);
            }
            if (j2 == Long.MIN_VALUE) {
                return b(bArr, i2);
            }
            bArr[i2] = Framer.STDIN_FRAME_PREFIX;
            j2 = -j2;
            i2++;
        } else if (j2 <= f9780e) {
            return a((int) j2, bArr, i2);
        }
        long j3 = f9778c;
        long j4 = j2 / j3;
        long j5 = j2 - (j4 * j3);
        if (j4 < j3) {
            d2 = e((int) j4, bArr, i2);
        } else {
            long j6 = j4 / j3;
            int c2 = c((int) j6, bArr, i2);
            d2 = d((int) (j4 - (j3 * j6)), bArr, c2);
        }
        return d((int) j5, bArr, d2);
    }

    private static int a(char[] cArr, int i2, int i3, int i4) {
        int i5 = f9783h[i3];
        if (i3 > 9) {
            if (i3 > 99) {
                cArr[i2] = (char) (i5 >> 16);
                i2++;
            }
            cArr[i2] = (char) ((i5 >> 8) & 127);
            i2++;
        }
        int i6 = i2 + 1;
        cArr[i2] = (char) (i5 & 127);
        int i7 = f9783h[i4];
        int i8 = i6 + 1;
        cArr[i6] = (char) (i7 >> 16);
        int i9 = i8 + 1;
        cArr[i8] = (char) ((i7 >> 8) & 127);
        int i10 = i9 + 1;
        cArr[i9] = (char) (i7 & 127);
        return i10;
    }

    private static int a(byte[] bArr, int i2, int i3, int i4) {
        int i5 = f9783h[i3];
        if (i3 > 9) {
            if (i3 > 99) {
                bArr[i2] = (byte) (i5 >> 16);
                i2++;
            }
            bArr[i2] = (byte) (i5 >> 8);
            i2++;
        }
        int i6 = i2 + 1;
        bArr[i2] = (byte) i5;
        int i7 = f9783h[i4];
        int i8 = i6 + 1;
        bArr[i6] = (byte) (i7 >> 16);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i7 >> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) i7;
        return i10;
    }

    private static int a(char[] cArr, int i2) {
        int length = f9781f.length();
        f9781f.getChars(0, length, cArr, i2);
        return i2 + length;
    }

    private static int a(byte[] bArr, int i2) {
        int length = f9781f.length();
        int i3 = 0;
        while (i3 < length) {
            bArr[i2] = (byte) f9781f.charAt(i3);
            i3++;
            i2++;
        }
        return i2;
    }
}
