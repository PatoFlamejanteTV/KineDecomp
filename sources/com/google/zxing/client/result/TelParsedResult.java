package com.google.zxing.client.result;

/* loaded from: classes2.dex */
public final class TelParsedResult extends ParsedResult {

    /* renamed from: a */
    private final String f19040a;

    /* renamed from: b */
    private final String f19041b;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        ParsedResult.a(this.f19040a, sb);
        ParsedResult.a(this.f19041b, sb);
        return sb.toString();
    }
}
