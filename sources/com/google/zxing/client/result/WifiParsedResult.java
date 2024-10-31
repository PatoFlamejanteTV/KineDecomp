package com.google.zxing.client.result;

/* loaded from: classes2.dex */
public final class WifiParsedResult extends ParsedResult {

    /* renamed from: a */
    private final String f19061a;

    /* renamed from: b */
    private final String f19062b;

    /* renamed from: c */
    private final String f19063c;

    /* renamed from: d */
    private final boolean f19064d;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(80);
        ParsedResult.a(this.f19061a, sb);
        ParsedResult.a(this.f19062b, sb);
        ParsedResult.a(this.f19063c, sb);
        ParsedResult.a(Boolean.toString(this.f19064d), sb);
        return sb.toString();
    }
}
