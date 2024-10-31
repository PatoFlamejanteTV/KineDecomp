package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ArrayBasedCharEscaper extends CharEscaper {

    /* renamed from: b */
    private final char[][] f15873b;

    /* renamed from: c */
    private final int f15874c;

    /* renamed from: d */
    private final char f15875d;

    /* renamed from: e */
    private final char f15876e;

    public ArrayBasedCharEscaper(Map<Character, String> map, char c2, char c3) {
        this(ArrayBasedEscaperMap.a(map), c2, c3);
    }

    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
    public final String a(String str) {
        Preconditions.a(str);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < this.f15874c && this.f15873b[charAt] != null) || charAt > this.f15876e || charAt < this.f15875d) {
                return a(str, i);
            }
        }
        return str;
    }

    protected abstract char[] b(char c2);

    protected ArrayBasedCharEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, char c2, char c3) {
        Preconditions.a(arrayBasedEscaperMap);
        this.f15873b = arrayBasedEscaperMap.a();
        this.f15874c = this.f15873b.length;
        if (c3 < c2) {
            c3 = 0;
            c2 = 65535;
        }
        this.f15875d = c2;
        this.f15876e = c3;
    }

    @Override // com.google.common.escape.CharEscaper
    protected final char[] a(char c2) {
        char[] cArr;
        if (c2 < this.f15874c && (cArr = this.f15873b[c2]) != null) {
            return cArr;
        }
        if (c2 < this.f15875d || c2 > this.f15876e) {
            return b(c2);
        }
        return null;
    }
}
