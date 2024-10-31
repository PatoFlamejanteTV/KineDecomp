package com.google.api.client.util;

import java.io.IOException;

/* loaded from: classes.dex */
public interface BackOff {

    /* renamed from: a, reason: collision with root package name */
    public static final BackOff f2527a = new a();
    public static final BackOff b = new b();

    void a() throws IOException;

    long b() throws IOException;
}
