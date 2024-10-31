package com.google.api.client.util;

/* loaded from: classes.dex */
public final class Joiner {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.api.client.repackaged.com.google.common.base.Joiner f2539a;

    public static Joiner a(char c) {
        return new Joiner(com.google.api.client.repackaged.com.google.common.base.Joiner.a(c));
    }

    private Joiner(com.google.api.client.repackaged.com.google.common.base.Joiner joiner) {
        this.f2539a = joiner;
    }

    public final String a(Iterable<?> iterable) {
        return this.f2539a.a(iterable);
    }
}
