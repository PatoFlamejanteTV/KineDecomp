package com.google.api.client.util;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface BackOff {

    /* renamed from: a */
    public static final BackOff f14908a = new a();

    /* renamed from: b */
    public static final BackOff f14909b = new b();

    long a() throws IOException;

    void reset() throws IOException;
}
