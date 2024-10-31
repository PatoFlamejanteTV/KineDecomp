package com.squareup.okhttp;

import java.util.ArrayDeque;
import java.util.Deque;

/* compiled from: Dispatcher.java */
/* loaded from: classes3.dex */
public final class s {

    /* renamed from: a */
    private int f25530a = 64;

    /* renamed from: b */
    private int f25531b = 5;

    /* renamed from: c */
    private final Deque<Object> f25532c = new ArrayDeque();

    /* renamed from: d */
    private final Deque<Object> f25533d = new ArrayDeque();

    /* renamed from: e */
    private final Deque<C2383i> f25534e = new ArrayDeque();

    public synchronized void a(C2383i c2383i) {
        this.f25534e.add(c2383i);
    }

    public synchronized void b(C2383i c2383i) {
        if (!this.f25534e.remove(c2383i)) {
            throw new AssertionError("Call wasn't in-flight!");
        }
    }
}
