package com.google.common.escape;

import com.google.common.base.Preconditions;

/* compiled from: Escapers.java */
/* loaded from: classes2.dex */
class b extends CharEscaper {
    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
    public String a(String str) {
        Preconditions.a(str);
        return str;
    }

    @Override // com.google.common.escape.CharEscaper
    protected char[] a(char c2) {
        return null;
    }
}
