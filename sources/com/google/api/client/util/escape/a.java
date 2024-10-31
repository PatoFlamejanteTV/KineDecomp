package com.google.api.client.util.escape;

/* compiled from: Platform.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<char[]> f2553a = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char[] a() {
        return f2553a.get();
    }
}
