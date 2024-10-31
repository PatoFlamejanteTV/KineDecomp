package com.google.zxing.common;

import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class StringUtils {

    /* renamed from: a */
    private static final String f19076a = Charset.defaultCharset().name();

    /* renamed from: b */
    private static final boolean f19077b;

    static {
        f19077b = "SJIS".equalsIgnoreCase(f19076a) || "EUC_JP".equalsIgnoreCase(f19076a);
    }

    private StringUtils() {
    }
}
