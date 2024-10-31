package com.google.common.escape;

/* compiled from: Platform.java */
/* loaded from: classes2.dex */
class d extends ThreadLocal<char[]> {
    @Override // java.lang.ThreadLocal
    public char[] initialValue() {
        return new char[1024];
    }
}
