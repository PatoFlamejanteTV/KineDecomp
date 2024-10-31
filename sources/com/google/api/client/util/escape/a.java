package com.google.api.client.util.escape;

/* compiled from: Platform.java */
/* loaded from: classes2.dex */
class a extends ThreadLocal<char[]> {
    @Override // java.lang.ThreadLocal
    public char[] initialValue() {
        return new char[1024];
    }
}
