package com.google.zxing.client.result;

/* loaded from: classes2.dex */
public final class EmailAddressParsedResult extends ParsedResult {

    /* renamed from: a */
    private final String[] f19011a;

    /* renamed from: b */
    private final String[] f19012b;

    /* renamed from: c */
    private final String[] f19013c;

    /* renamed from: d */
    private final String f19014d;

    /* renamed from: e */
    private final String f19015e;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        ParsedResult.a(this.f19011a, sb);
        ParsedResult.a(this.f19012b, sb);
        ParsedResult.a(this.f19013c, sb);
        ParsedResult.a(this.f19014d, sb);
        ParsedResult.a(this.f19015e, sb);
        return sb.toString();
    }
}
