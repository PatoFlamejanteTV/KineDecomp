package com.google.zxing.client.result;

/* loaded from: classes2.dex */
public final class GeoParsedResult extends ParsedResult {

    /* renamed from: a */
    private final double f19026a;

    /* renamed from: b */
    private final double f19027b;

    /* renamed from: c */
    private final double f19028c;

    /* renamed from: d */
    private final String f19029d;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.f19026a);
        sb.append(", ");
        sb.append(this.f19027b);
        if (this.f19028c > 0.0d) {
            sb.append(", ");
            sb.append(this.f19028c);
            sb.append('m');
        }
        if (this.f19029d != null) {
            sb.append(" (");
            sb.append(this.f19029d);
            sb.append(')');
        }
        return sb.toString();
    }
}
