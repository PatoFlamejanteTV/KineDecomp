package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {

    /* renamed from: b */
    private final char[][] f15879b;

    /* renamed from: c */
    private final int f15880c;

    /* renamed from: d */
    private final int f15881d;

    /* renamed from: e */
    private final int f15882e;

    /* renamed from: f */
    private final char f15883f;

    /* renamed from: g */
    private final char f15884g;

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public final String a(String str) {
        Preconditions.a(str);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < this.f15880c && this.f15879b[charAt] != null) || charAt > this.f15884g || charAt < this.f15883f) {
                return a(str, i);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected final int b(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if ((charAt < this.f15880c && this.f15879b[charAt] != null) || charAt > this.f15884g || charAt < this.f15883f) {
                break;
            }
            i++;
        }
        return i;
    }

    protected abstract char[] b(int i);

    @Override // com.google.common.escape.UnicodeEscaper
    protected final char[] a(int i) {
        char[] cArr;
        if (i < this.f15880c && (cArr = this.f15879b[i]) != null) {
            return cArr;
        }
        if (i < this.f15881d || i > this.f15882e) {
            return b(i);
        }
        return null;
    }
}
