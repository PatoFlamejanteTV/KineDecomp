package com.google.android.gms.internal.firebase_auth;

/* loaded from: classes2.dex */
public final class La {

    /* renamed from: a */
    private static final Na f12984a;

    static {
        Na oa;
        if ((Ja.b() && Ja.c()) && !C1246e.a()) {
            oa = new Pa();
        } else {
            oa = new Oa();
        }
        f12984a = oa;
    }

    public static boolean a(byte[] bArr) {
        return f12984a.a(bArr, 0, bArr.length);
    }

    public static int b(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static int b(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int b(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static String b(byte[] bArr, int i, int i2) throws zzgc {
        return f12984a.b(bArr, i, i2);
    }

    public static int d(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return b(b2);
        }
        if (i3 == 1) {
            return b(b2, bArr[i]);
        }
        if (i3 == 2) {
            return b(b2, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    public static boolean a(byte[] bArr, int i, int i2) {
        return f12984a.a(bArr, i, i2);
    }

    public static int a(int i, byte[] bArr, int i2, int i3) {
        return f12984a.a(i, bArr, i2, i3);
    }

    public static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new zzjc(i2, length2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = i3 + 4294967296L;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f12984a.a(charSequence, bArr, i, i2);
    }
}
