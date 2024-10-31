package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmallCharMatcher.java */
@GwtCompatible
/* loaded from: classes2.dex */
public final class v extends CharMatcher {
    final long p;
    private final boolean q;
    private final char[] r;
    private final boolean s;

    private v(char[] cArr, long j, boolean z, boolean z2, String str) {
        super(str);
        this.r = cArr;
        this.p = j;
        this.s = z;
        this.q = z2;
    }

    private boolean a(int i) {
        return 1 == ((this.p >> i) & 1);
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher b() {
        return this;
    }

    @VisibleForTesting
    static char[] a(int i, char[] cArr, boolean z) {
        char[] cArr2 = new char[i];
        for (char c : cArr) {
            int i2 = c % i;
            if (i2 < 0) {
                i2 += i;
            }
            if (cArr2[i2] != 0 && !z) {
                return null;
            }
            if (z) {
                while (cArr2[i2] != 0) {
                    i2 = (i2 + 1) % i;
                }
            }
            cArr2[i2] = c;
        }
        return cArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CharMatcher a(char[] cArr, String str) {
        boolean z;
        char[] cArr2;
        long j = 0;
        int length = cArr.length;
        boolean z2 = cArr[0] == 0;
        int length2 = cArr.length;
        int i = 0;
        while (i < length2) {
            long j2 = (1 << cArr[i]) | j;
            i++;
            j = j2;
        }
        char[] cArr3 = null;
        for (int i2 = length; i2 < 128; i2++) {
            cArr3 = a(i2, cArr, false);
            if (cArr3 != null) {
                break;
            }
        }
        if (cArr3 == null) {
            cArr2 = a(128, cArr, true);
            z = true;
        } else {
            char[] cArr4 = cArr3;
            z = false;
            cArr2 = cArr4;
        }
        return new v(cArr2, j, z2, z, str);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(char c) {
        if (c == 0) {
            return this.s;
        }
        if (!a((int) c)) {
            return false;
        }
        int length = c % this.r.length;
        if (length < 0) {
            length += this.r.length;
        }
        while (this.r[length] != 0) {
            if (this.r[length] == c) {
                return true;
            }
            if (!this.q) {
                return false;
            }
            length = (length + 1) % this.r.length;
        }
        return false;
    }
}
