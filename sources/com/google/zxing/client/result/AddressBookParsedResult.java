package com.google.zxing.client.result;

/* loaded from: classes2.dex */
public final class AddressBookParsedResult extends ParsedResult {

    /* renamed from: a */
    private final String[] f18995a;

    /* renamed from: b */
    private final String[] f18996b;

    /* renamed from: c */
    private final String f18997c;

    /* renamed from: d */
    private final String[] f18998d;

    /* renamed from: e */
    private final String[] f18999e;

    /* renamed from: f */
    private final String f19000f;

    /* renamed from: g */
    private final String f19001g;

    /* renamed from: h */
    private final String[] f19002h;
    private final String i;
    private final String j;
    private final String k;
    private final String[] l;
    private final String[] m;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.a(this.f18995a, sb);
        ParsedResult.a(this.f18996b, sb);
        ParsedResult.a(this.f18997c, sb);
        ParsedResult.a(this.k, sb);
        ParsedResult.a(this.i, sb);
        ParsedResult.a(this.f19002h, sb);
        ParsedResult.a(this.f18998d, sb);
        ParsedResult.a(this.f18999e, sb);
        ParsedResult.a(this.f19000f, sb);
        ParsedResult.a(this.l, sb);
        ParsedResult.a(this.j, sb);
        ParsedResult.a(this.m, sb);
        ParsedResult.a(this.f19001g, sb);
        return sb.toString();
    }
}
