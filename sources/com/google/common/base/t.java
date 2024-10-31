package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Platform.java */
@GwtCompatible
/* loaded from: classes2.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<char[]> f2593a = new u();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a() {
        return System.nanoTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CharMatcher a(CharMatcher charMatcher) {
        return charMatcher.d();
    }
}
