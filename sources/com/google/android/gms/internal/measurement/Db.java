package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class Db extends Bb {
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b9, code lost:            return -1;     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0061, code lost:            return -1;     */
    @Override // com.google.android.gms.internal.measurement.Bb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int a(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.Db.a(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.measurement.Bb
    public final String b(byte[] bArr, int i, int i2) throws zzuv {
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
                byte a2 = xb.a(bArr, i);
                d4 = Ab.d(a2);
                if (!d4) {
                    break;
                }
                i++;
                Ab.b(a2, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte a3 = xb.a(bArr, i);
                d2 = Ab.d(a3);
                if (d2) {
                    int i7 = i5 + 1;
                    Ab.b(a3, cArr, i5);
                    while (i6 < i3) {
                        byte a4 = xb.a(bArr, i6);
                        d3 = Ab.d(a4);
                        if (!d3) {
                            break;
                        }
                        i6++;
                        Ab.b(a4, cArr, i7);
                        i7++;
                    }
                    i = i6;
                    i5 = i7;
                } else {
                    e2 = Ab.e(a3);
                    if (!e2) {
                        f2 = Ab.f(a3);
                        if (f2) {
                            if (i6 < i3 - 1) {
                                int i8 = i6 + 1;
                                Ab.b(a3, xb.a(bArr, i6), xb.a(bArr, i8), cArr, i5);
                                i = i8 + 1;
                                i5++;
                            } else {
                                throw zzuv.zzwx();
                            }
                        } else if (i6 < i3 - 2) {
                            int i9 = i6 + 1;
                            byte a5 = xb.a(bArr, i6);
                            int i10 = i9 + 1;
                            Ab.b(a3, a5, xb.a(bArr, i9), xb.a(bArr, i10), cArr, i5);
                            i = i10 + 1;
                            i5 = i5 + 1 + 1;
                        } else {
                            throw zzuv.zzwx();
                        }
                    } else if (i6 < i3) {
                        Ab.b(a3, xb.a(bArr, i6), cArr, i5);
                        i = i6 + 1;
                        i5++;
                    } else {
                        throw zzuv.zzwx();
                    }
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.google.android.gms.internal.measurement.Bb
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
            xb.a(bArr, j4, (byte) charAt);
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
                    xb.a(bArr, j4, (byte) ((charAt3 >>> 6) | 960));
                    xb.a(bArr, j6, (byte) ((charAt3 & '?') | 128));
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
                                    xb.a(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                    long j8 = j7 + 1;
                                    xb.a(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j9 = j8 + 1;
                                    xb.a(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j3 = 1;
                                    j2 = j9 + 1;
                                    xb.a(bArr, j9, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new zzxp(i4 - 1, length);
                        }
                        if (55296 <= charAt3 && charAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                            throw new zzxp(i4, length);
                        }
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j4);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    long j10 = j4 + j;
                    xb.a(bArr, j4, (byte) ((charAt3 >>> '\f') | 480));
                    long j11 = j10 + j;
                    xb.a(bArr, j10, (byte) (((charAt3 >>> 6) & 63) | 128));
                    xb.a(bArr, j11, (byte) ((charAt3 & '?') | 128));
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
                xb.a(bArr, j4, (byte) charAt3);
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

    @Override // com.google.android.gms.internal.measurement.Bb
    public final void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        char c2;
        long j;
        int i;
        char charAt;
        long a2 = xb.a(byteBuffer);
        long position = byteBuffer.position() + a2;
        long limit = byteBuffer.limit() + a2;
        int length = charSequence.length();
        if (length > limit - position) {
            char charAt2 = charSequence.charAt(length - 1);
            int limit2 = byteBuffer.limit();
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(limit2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i2 = 0;
        while (true) {
            c2 = 128;
            if (i2 >= length || (charAt = charSequence.charAt(i2)) >= 128) {
                break;
            }
            xb.a(position, (byte) charAt);
            i2++;
            position = 1 + position;
        }
        if (i2 == length) {
            byteBuffer.position((int) (position - a2));
            return;
        }
        while (i2 < length) {
            char charAt3 = charSequence.charAt(i2);
            if (charAt3 < c2 && position < limit) {
                xb.a(position, (byte) charAt3);
                position++;
                j = a2;
            } else if (charAt3 >= 2048 || position > limit - 2) {
                j = a2;
                if ((charAt3 >= 55296 && 57343 >= charAt3) || position > limit - 3) {
                    if (position <= limit - 4) {
                        int i3 = i2 + 1;
                        if (i3 != length) {
                            char charAt4 = charSequence.charAt(i3);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                long j2 = position + 1;
                                xb.a(position, (byte) ((codePoint >>> 18) | 240));
                                long j3 = j2 + 1;
                                xb.a(j2, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j4 = j3 + 1;
                                xb.a(j3, (byte) (((codePoint >>> 6) & 63) | 128));
                                long j5 = j4 + 1;
                                xb.a(j4, (byte) ((codePoint & 63) | 128));
                                i2 = i3;
                                position = j5;
                            }
                        } else {
                            i3 = i2;
                        }
                        throw new zzxp(i3 - 1, length);
                    }
                    if (55296 <= charAt3 && charAt3 <= 57343 && ((i = i2 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i)))) {
                        throw new zzxp(i2, length);
                    }
                    StringBuilder sb2 = new StringBuilder(46);
                    sb2.append("Failed writing ");
                    sb2.append(charAt3);
                    sb2.append(" at index ");
                    sb2.append(position);
                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                }
                long j6 = position + 1;
                xb.a(position, (byte) ((charAt3 >>> '\f') | 480));
                long j7 = j6 + 1;
                xb.a(j6, (byte) (((charAt3 >>> 6) & 63) | 128));
                xb.a(j7, (byte) ((charAt3 & '?') | 128));
                position = j7 + 1;
            } else {
                j = a2;
                long j8 = position + 1;
                xb.a(position, (byte) ((charAt3 >>> 6) | 960));
                xb.a(j8, (byte) ((charAt3 & '?') | 128));
                position = j8 + 1;
            }
            i2++;
            a2 = j;
            c2 = 128;
        }
        byteBuffer.position((int) (position - a2));
    }

    private static int a(byte[] bArr, int i, long j, int i2) {
        int b2;
        int b3;
        int b4;
        if (i2 == 0) {
            b2 = zb.b(i);
            return b2;
        }
        if (i2 == 1) {
            b3 = zb.b(i, xb.a(bArr, j));
            return b3;
        }
        if (i2 == 2) {
            b4 = zb.b(i, xb.a(bArr, j), xb.a(bArr, j + 1));
            return b4;
        }
        throw new AssertionError();
    }
}
