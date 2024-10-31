package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.facebook.ads.redexgen.X.Jp, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0499Jp implements InterfaceC0497Jn {
    public final Collection<String> A00;

    public C0499Jp() {
        this.A00 = new ArrayList();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0497Jn
    public final void A7r(String str) {
        this.A00.add(str);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0497Jn
    public final void flush() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:            return r2.toString();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            r3 = this;
            r0 = 0
            r0 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.util.Collection<java.lang.String> r0 = r3.A00
            java.util.Iterator r1 = r0.iterator()
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L1e;
                case 4: goto L32;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L1c
            r0 = 3
            goto Le
        L1c:
            r0 = 4
            goto Le
        L1e:
            java.lang.StringBuilder r2 = (java.lang.StringBuilder) r2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r0 = r1.next()
            java.lang.String r0 = (java.lang.String) r0
            r2.append(r0)
            r0 = 10
            r2.append(r0)
            r0 = 2
            goto Le
        L32:
            java.lang.StringBuilder r2 = (java.lang.StringBuilder) r2
            java.lang.String r0 = r2.toString()
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0499Jp.toString():java.lang.String");
    }
}
