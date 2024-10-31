package com.google.common.base;

import com.google.common.base.Splitter;

/* compiled from: Splitter.java */
/* loaded from: classes2.dex */
public class p extends Splitter.a {

    /* renamed from: h */
    final /* synthetic */ q f15145h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(q qVar, Splitter splitter, CharSequence charSequence) {
        super(splitter, charSequence);
        this.f15145h = qVar;
    }

    @Override // com.google.common.base.Splitter.a
    public int a(int i) {
        return i + this.f15145h.f15146a.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:            r6 = r6 + 1;     */
    @Override // com.google.common.base.Splitter.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int b(int r6) {
        /*
            r5 = this;
            com.google.common.base.q r0 = r5.f15145h
            java.lang.String r0 = r0.f15146a
            int r0 = r0.length()
            java.lang.CharSequence r1 = r5.f15113c
            int r1 = r1.length()
            int r1 = r1 - r0
        Lf:
            if (r6 > r1) goto L2d
            r2 = 0
        L12:
            if (r2 >= r0) goto L2c
            java.lang.CharSequence r3 = r5.f15113c
            int r4 = r2 + r6
            char r3 = r3.charAt(r4)
            com.google.common.base.q r4 = r5.f15145h
            java.lang.String r4 = r4.f15146a
            char r4 = r4.charAt(r2)
            if (r3 == r4) goto L29
            int r6 = r6 + 1
            goto Lf
        L29:
            int r2 = r2 + 1
            goto L12
        L2c:
            return r6
        L2d:
            r6 = -1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.p.b(int):int");
    }
}
