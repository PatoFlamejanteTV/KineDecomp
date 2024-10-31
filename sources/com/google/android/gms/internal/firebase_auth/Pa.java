package com.google.android.gms.internal.firebase_auth;

/* loaded from: classes2.dex */
final class Pa extends Na {
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0061, code lost:            if (com.google.android.gms.internal.firebase_auth.Ja.a(r25, r8) > (-65)) goto L174;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:            if (com.google.android.gms.internal.firebase_auth.Ja.a(r25, r8) > (-65)) goto L158;     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0103, code lost:            return -1;     */
    @Override // com.google.android.gms.internal.firebase_auth.Na
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(int r24, byte[] r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.Pa.a(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.firebase_auth.Na
    public final String b(byte[] bArr, int i, int i2) throws zzgc {
        boolean d2;
        boolean d3;
        boolean e2;
        boolean f2;
        boolean d4;
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte a2 = Ja.a(bArr, i);
                d4 = Ma.d(a2);
                if (!d4) {
                    break;
                }
                i++;
                Ma.b(a2, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte a3 = Ja.a(bArr, i);
                d2 = Ma.d(a3);
                if (d2) {
                    int i7 = i5 + 1;
                    Ma.b(a3, cArr, i5);
                    while (i6 < i3) {
                        byte a4 = Ja.a(bArr, i6);
                        d3 = Ma.d(a4);
                        if (!d3) {
                            break;
                        }
                        i6++;
                        Ma.b(a4, cArr, i7);
                        i7++;
                    }
                    i = i6;
                    i5 = i7;
                } else {
                    e2 = Ma.e(a3);
                    if (!e2) {
                        f2 = Ma.f(a3);
                        if (f2) {
                            if (i6 < i3 - 1) {
                                int i8 = i6 + 1;
                                Ma.b(a3, Ja.a(bArr, i6), Ja.a(bArr, i8), cArr, i5);
                                i = i8 + 1;
                                i5++;
                            } else {
                                throw zzgc.zzhy();
                            }
                        } else if (i6 < i3 - 2) {
                            int i9 = i6 + 1;
                            byte a5 = Ja.a(bArr, i6);
                            int i10 = i9 + 1;
                            Ma.b(a3, a5, Ja.a(bArr, i9), Ja.a(bArr, i10), cArr, i5);
                            i = i10 + 1;
                            i5 = i5 + 1 + 1;
                        } else {
                            throw zzgc.zzhy();
                        }
                    } else if (i6 < i3) {
                        Ma.b(a3, Ja.a(bArr, i6), cArr, i5);
                        i = i6 + 1;
                        i5++;
                    } else {
                        throw zzgc.zzhy();
                    }
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.google.android.gms.internal.firebase_auth.Na
    public final int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c2;
        long j;
        long j2;
        long j3;
        int i3;
        char charAt;
        long j4 = i;
        long j5 = i2 + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            c2 = 128;
            j = 1;
            if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            Ja.a(bArr, j4, (byte) charAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char charAt3 = charSequence.charAt(i4);
            if (charAt3 >= c2 || j4 >= j5) {
                if (charAt3 < 2048 && j4 <= j5 - 2) {
                    long j6 = j4 + j;
                    Ja.a(bArr, j4, (byte) ((charAt3 >>> 6) | 960));
                    Ja.a(bArr, j6, (byte) ((charAt3 & '?') | 128));
                    j2 = j6 + j;
                    j3 = j;
                } else {
                    if ((charAt3 >= 55296 && 57343 >= charAt3) || j4 > j5 - 3) {
                        if (j4 <= j5 - 4) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char charAt4 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(charAt3, charAt4)) {
                                    int codePoint = Character.toCodePoint(charAt3, charAt4);
                                    long j7 = j4 + 1;
                                    Ja.a(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                    long j8 = j7 + 1;
                                    Ja.a(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j9 = j8 + 1;
                                    Ja.a(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j3 = 1;
                                    j2 = j9 + 1;
                                    Ja.a(bArr, j9, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new zzjc(i4 - 1, length);
                        }
                        if (55296 <= charAt3 && charAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                            throw new zzjc(i4, length);
                        }
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j4);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    long j10 = j4 + j;
                    Ja.a(bArr, j4, (byte) ((charAt3 >>> '\f') | 480));
                    long j11 = j10 + j;
                    Ja.a(bArr, j10, (byte) (((charAt3 >>> 6) & 63) | 128));
                    Ja.a(bArr, j11, (byte) ((charAt3 & '?') | 128));
                    j2 = j11 + 1;
                    j3 = 1;
                }
                i4++;
                c2 = 128;
                long j12 = j3;
                j4 = j2;
                j = j12;
            } else {
                long j13 = j4 + j;
                Ja.a(bArr, j4, (byte) charAt3);
                j3 = j;
                j2 = j13;
            }
            i4++;
            c2 = 128;
            long j122 = j3;
            j4 = j2;
            j = j122;
        }
        return (int) j4;
    }

    private static int a(byte[] bArr, int i, long j, int i2) {
        int b2;
        int b3;
        int b4;
        if (i2 == 0) {
            b2 = La.b(i);
            return b2;
        }
        if (i2 == 1) {
            b3 = La.b(i, Ja.a(bArr, j));
            return b3;
        }
        if (i2 == 2) {
            b4 = La.b(i, Ja.a(bArr, j), Ja.a(bArr, j + 1));
            return b4;
        }
        throw new AssertionError();
    }
}
