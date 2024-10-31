package com.google.zxing.client.result;

/* loaded from: classes2.dex */
public final class VINParsedResult extends ParsedResult {

    /* renamed from: a */
    private final String f19052a;

    /* renamed from: b */
    private final String f19053b;

    /* renamed from: c */
    private final String f19054c;

    /* renamed from: d */
    private final String f19055d;

    /* renamed from: e */
    private final int f19056e;

    /* renamed from: f */
    private final char f19057f;

    /* renamed from: g */
    private final String f19058g;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(50);
        sb.append(this.f19052a);
        sb.append(' ');
        sb.append(this.f19053b);
        sb.append(' ');
        sb.append(this.f19054c);
        sb.append('\n');
        String str = this.f19055d;
        if (str != null) {
            sb.append(str);
            sb.append(' ');
        }
        sb.append(this.f19056e);
        sb.append(' ');
        sb.append(this.f19057f);
        sb.append(' ');
        sb.append(this.f19058g);
        sb.append('\n');
        return sb.toString();
    }
}
