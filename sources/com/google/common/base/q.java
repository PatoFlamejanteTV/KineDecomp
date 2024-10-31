package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediumCharMatcher.java */
@GwtCompatible
/* loaded from: classes2.dex */
public final class q extends CharMatcher {
    private final char[] p;
    private final boolean q;
    private final long r;

    private q(char[] cArr, long j, boolean z, String str) {
        super(str);
        this.p = cArr;
        this.r = j;
        this.q = z;
    }

    private boolean b(int i) {
        return 1 == ((this.r >> i) & 1);
    }

    @VisibleForTesting
    static int a(int i) {
        if (i == 1) {
            return 2;
        }
        int highestOneBit = Integer.highestOneBit(i - 1);
        do {
            highestOneBit <<= 1;
        } while (highestOneBit * 0.5d < i);
        return highestOneBit;
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher b() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CharMatcher a(char[] cArr, String str) {
        long j = 0;
        int length = cArr.length;
        boolean z = cArr[0] == 0;
        for (char c : cArr) {
            j |= 1 << c;
        }
        char[] cArr2 = new char[a(length)];
        int length2 = cArr2.length - 1;
        for (char c2 : cArr) {
            int i = c2 & length2;
            while (cArr2[i] != 0) {
                i = (i + 1) & length2;
            }
            cArr2[i] = c2;
        }
        return new q(cArr2, j, z, str);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(char c) {
        if (c == 0) {
            return this.q;
        }
        if (!b((int) c)) {
            return false;
        }
        int length = this.p.length - 1;
        int i = c & length;
        int i2 = i;
        while (this.p[i2] != 0) {
            if (this.p[i2] == c) {
                return true;
            }
            i2 = (i2 + 1) & length;
            if (i2 == i) {
                return false;
            }
        }
        return false;
    }
}
