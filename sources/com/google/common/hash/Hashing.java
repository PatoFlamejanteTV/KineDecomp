package com.google.common.hash;

import com.google.common.annotations.Beta;

@Beta
/* loaded from: classes2.dex */
public final class Hashing {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2905a = (int) System.currentTimeMillis();
    private static final HashFunction b = a(f2905a);
    private static final HashFunction c = b(f2905a);
    private static final Murmur3_32HashFunction d = new Murmur3_32HashFunction(0);
    private static final Murmur3_128HashFunction e = new Murmur3_128HashFunction(0);
    private static final HashFunction f = new b("MD5");
    private static final HashFunction g = new b("SHA-1");
    private static final HashFunction h = new b("SHA-256");
    private static final HashFunction i = new b("SHA-512");

    private Hashing() {
    }

    public static HashFunction a(int i2) {
        return new Murmur3_32HashFunction(i2);
    }

    public static HashFunction b(int i2) {
        return new Murmur3_128HashFunction(i2);
    }

    public static HashFunction a() {
        return e;
    }
}
