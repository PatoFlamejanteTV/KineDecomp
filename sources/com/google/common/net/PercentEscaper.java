package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class PercentEscaper extends UnicodeEscaper {

    /* renamed from: b */
    private static final char[] f16029b = {'+'};

    /* renamed from: c */
    private static final char[] f16030c = "0123456789ABCDEF".toCharArray();

    /* renamed from: d */
    private final boolean f16031d;

    /* renamed from: e */
    private final boolean[] f16032e;

    public PercentEscaper(String str, boolean z) {
        Preconditions.a(str);
        if (!str.matches(".*[0-9A-Za-z].*")) {
            String str2 = str + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            if (z && str2.contains(" ")) {
                throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
            }
            this.f16031d = z;
            this.f16032e = b(str2);
            return;
        }
        throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    }

    private static boolean[] b(String str) {
        char[] charArray = str.toCharArray();
        int i = -1;
        for (char c2 : charArray) {
            i = Math.max((int) c2, i);
        }
        boolean[] zArr = new boolean[i + 1];
        for (char c3 : charArray) {
            zArr[c3] = true;
        }
        return zArr;
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public String a(String str) {
        Preconditions.a(str);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            boolean[] zArr = this.f16032e;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return a(str, i);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected char[] a(int i) {
        boolean[] zArr = this.f16032e;
        if (i < zArr.length && zArr[i]) {
            return null;
        }
        if (i == 32 && this.f16031d) {
            return f16029b;
        }
        if (i <= 127) {
            char[] cArr = f16030c;
            return new char[]{'%', cArr[i >>> 4], cArr[i & 15]};
        }
        if (i <= 2047) {
            char[] cArr2 = f16030c;
            char[] cArr3 = {'%', cArr2[(r14 >>> 4) | 12], cArr2[r14 & 15], '%', cArr2[(r14 & 3) | 8], cArr2[i & 15]};
            int i2 = i >>> 4;
            int i3 = i2 >>> 2;
            return cArr3;
        }
        if (i <= 65535) {
            char[] cArr4 = f16030c;
            char[] cArr5 = {'%', 'E', cArr4[r14 >>> 2], '%', cArr4[(r14 & 3) | 8], cArr4[r14 & 15], '%', cArr4[(r14 & 3) | 8], cArr4[i & 15]};
            int i4 = i >>> 4;
            int i5 = i4 >>> 2;
            int i6 = i5 >>> 4;
            return cArr5;
        }
        if (i <= 1114111) {
            char[] cArr6 = f16030c;
            char[] cArr7 = {'%', 'F', cArr6[(r14 >>> 2) & 7], '%', cArr6[(r14 & 3) | 8], cArr6[r14 & 15], '%', cArr6[(r14 & 3) | 8], cArr6[r14 & 15], '%', cArr6[(r14 & 3) | 8], cArr6[i & 15]};
            int i7 = i >>> 4;
            int i8 = i7 >>> 2;
            int i9 = i8 >>> 4;
            int i10 = i9 >>> 2;
            int i11 = i10 >>> 4;
            return cArr7;
        }
        throw new IllegalArgumentException("Invalid unicode character value " + i);
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected int b(CharSequence charSequence, int i, int i2) {
        Preconditions.a(charSequence);
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            boolean[] zArr = this.f16032e;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i++;
        }
        return i;
    }
}
