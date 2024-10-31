package com.google.common.net;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;

/* compiled from: MediaType.java */
/* loaded from: classes2.dex */
public class b implements Function<String, String> {

    /* renamed from: a */
    final /* synthetic */ MediaType f16037a;

    public b(MediaType mediaType) {
        this.f16037a = mediaType;
    }

    @Override // com.google.common.base.Function
    /* renamed from: a */
    public String apply(String str) {
        CharMatcher charMatcher;
        String b2;
        charMatcher = MediaType.f16022b;
        if (charMatcher.c(str)) {
            return str;
        }
        b2 = MediaType.b(str);
        return b2;
    }
}
