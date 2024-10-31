package com.google.zxing.client.result;

import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class URIParsedResult extends ParsedResult {

    /* renamed from: a */
    private static final Pattern f19043a = Pattern.compile(":/*([^/@]+)@[^/]+");

    /* renamed from: b */
    private final String f19044b;

    /* renamed from: c */
    private final String f19045c;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        ParsedResult.a(this.f19045c, sb);
        ParsedResult.a(this.f19044b, sb);
        return sb.toString();
    }
}
