package com.google.android.gms.internal.firebase_auth;

/* loaded from: classes2.dex */
final class Oa extends Na {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:            if (r13[r14] > (-65)) goto L132;     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x007e, code lost:            if (r13[r14] > (-65)) goto L169;     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0043, code lost:            if (r13[r14] > (-65)) goto L148;     */
    @Override // com.google.android.gms.internal.firebase_auth.Na
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(int r12, byte[] r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.Oa.a(int, byte[], int, int):int");
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
                byte b2 = bArr[i];
                d4 = Ma.d(b2);
                if (!d4) {
                    break;
                }
                i++;
                Ma.b(b2, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte b3 = bArr[i];
                d2 = Ma.d(b3);
                if (d2) {
                    int i7 = i5 + 1;
                    Ma.b(b3, cArr, i5);
                    while (i6 < i3) {
                        byte b4 = bArr[i6];
                        d3 = Ma.d(b4);
                        if (!d3) {
                            break;
                        }
                        i6++;
                        Ma.b(b4, cArr, i7);
                        i7++;
                    }
                    i = i6;
                    i5 = i7;
                } else {
                    e2 = Ma.e(b3);
                    if (!e2) {
                        f2 = Ma.f(b3);
                        if (f2) {
                            if (i6 < i3 - 1) {
                                int i8 = i6 + 1;
                                Ma.b(b3, bArr[i6], bArr[i8], cArr, i5);
                                i = i8 + 1;
                                i5++;
                            } else {
                                throw zzgc.zzhy();
                            }
                        } else if (i6 < i3 - 2) {
                            int i9 = i6 + 1;
                            byte b5 = bArr[i6];
                            int i10 = i9 + 1;
                            Ma.b(b3, b5, bArr[i9], bArr[i10], cArr, i5);
                            i = i10 + 1;
                            i5 = i5 + 1 + 1;
                        } else {
                            throw zzgc.zzhy();
                        }
                    } else if (i6 < i3) {
                        Ma.b(b3, bArr[i6], cArr, i5);
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

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:            return r10 + r0;     */
    @Override // com.google.android.gms.internal.firebase_auth.Na
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.Oa.a(java.lang.CharSequence, byte[], int, int):int");
    }
}
