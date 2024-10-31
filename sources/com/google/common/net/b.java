package com.google.common.net;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;

/* compiled from: MediaType.java */
/* loaded from: classes2.dex */
class b implements Function<String, String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaType f2928a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MediaType mediaType) {
        this.f2928a = mediaType;
    }

    @Override // com.google.common.base.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String apply(String str) {
        CharMatcher charMatcher;
        String b;
        charMatcher = MediaType.am;
        if (charMatcher.c(str)) {
            return str;
        }
        b = MediaType.b(str);
        return b;
    }
}
