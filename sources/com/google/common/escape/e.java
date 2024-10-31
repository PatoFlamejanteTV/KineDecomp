package com.google.common.escape;

/* compiled from: Platform.java */
/* loaded from: classes2.dex */
final class e {

    /* renamed from: a */
    private static final ThreadLocal<char[]> f15896a = new d();

    public static char[] a() {
        return f15896a.get();
    }
}
