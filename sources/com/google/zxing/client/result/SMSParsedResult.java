package com.google.zxing.client.result;

/* loaded from: classes2.dex */
public final class SMSParsedResult extends ParsedResult {

    /* renamed from: a */
    private final String[] f19037a;

    /* renamed from: b */
    private final String f19038b;

    /* renamed from: c */
    private final String f19039c;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.a(this.f19037a, sb);
        ParsedResult.a(this.f19038b, sb);
        ParsedResult.a(this.f19039c, sb);
        return sb.toString();
    }
}
