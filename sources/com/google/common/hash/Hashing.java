package com.google.common.hash;

import com.google.common.annotations.Beta;

@Beta
/* loaded from: classes2.dex */
public final class Hashing {

    /* renamed from: a */
    private static final int f15940a = (int) System.currentTimeMillis();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        static final HashFunction f15941a = new Murmur3_128HashFunction(0);

        /* renamed from: b */
        static final HashFunction f15942b = Hashing.a(Hashing.f15940a);
    }

    private Hashing() {
    }

    public static HashFunction b() {
        return a.f15941a;
    }

    public static HashFunction a(int i) {
        return new Murmur3_128HashFunction(i);
    }
}
