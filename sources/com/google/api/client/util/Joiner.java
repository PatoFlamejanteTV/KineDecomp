package com.google.api.client.util;

/* loaded from: classes2.dex */
public final class Joiner {

    /* renamed from: a */
    private final com.google.common.base.Joiner f14958a;

    private Joiner(com.google.common.base.Joiner joiner) {
        this.f14958a = joiner;
    }

    public static Joiner a(char c2) {
        return new Joiner(com.google.common.base.Joiner.a(c2));
    }

    public final String a(Iterable<?> iterable) {
        return this.f14958a.a(iterable);
    }
}
