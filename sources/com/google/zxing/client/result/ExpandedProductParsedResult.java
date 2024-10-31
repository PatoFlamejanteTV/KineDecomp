package com.google.zxing.client.result;

import java.util.Map;

/* loaded from: classes2.dex */
public final class ExpandedProductParsedResult extends ParsedResult {

    /* renamed from: a */
    private final String f19018a;

    /* renamed from: b */
    private final String f19019b;

    /* renamed from: c */
    private final String f19020c;

    /* renamed from: d */
    private final String f19021d;

    /* renamed from: e */
    private final String f19022e;

    /* renamed from: f */
    private final String f19023f;

    /* renamed from: g */
    private final String f19024g;

    /* renamed from: h */
    private final String f19025h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final Map<String, String> n;

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExpandedProductParsedResult)) {
            return false;
        }
        ExpandedProductParsedResult expandedProductParsedResult = (ExpandedProductParsedResult) obj;
        return a(this.f19019b, expandedProductParsedResult.f19019b) && a(this.f19020c, expandedProductParsedResult.f19020c) && a(this.f19021d, expandedProductParsedResult.f19021d) && a(this.f19022e, expandedProductParsedResult.f19022e) && a(this.f19023f, expandedProductParsedResult.f19023f) && a(this.f19024g, expandedProductParsedResult.f19024g) && a(this.f19025h, expandedProductParsedResult.f19025h) && a(this.i, expandedProductParsedResult.i) && a(this.j, expandedProductParsedResult.j) && a(this.k, expandedProductParsedResult.k) && a(this.l, expandedProductParsedResult.l) && a(this.m, expandedProductParsedResult.m) && a(this.n, expandedProductParsedResult.n);
    }

    public int hashCode() {
        return ((((((((((((a(this.f19019b) ^ 0) ^ a(this.f19020c)) ^ a(this.f19021d)) ^ a(this.f19022e)) ^ a(this.f19023f)) ^ a(this.f19024g)) ^ a(this.f19025h)) ^ a(this.i)) ^ a(this.j)) ^ a(this.k)) ^ a(this.l)) ^ a(this.m)) ^ a(this.n);
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        return String.valueOf(this.f19018a);
    }
}
