package com.facebook.ads.redexgen.X;

import java.io.Writer;

/* renamed from: com.facebook.ads.redexgen.X.Js, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0502Js extends Writer {
    public int A00;
    public char[] A01 = new char[1024];
    public final InterfaceC0497Jn A02;

    public C0502Js(InterfaceC0497Jn interfaceC0497Jn) {
        this.A02 = interfaceC0497Jn;
    }

    private void A00() {
        this.A02.A7r(new String(this.A01, 0, this.A00));
        this.A00 = 0;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        flush();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        if (this.A00 > 0) {
            A00();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0049, code lost:            return;     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void write(char[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r3 = r7
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L3d;
                case 4: goto L30;
                case 5: goto L15;
                case 6: goto L8;
                case 7: goto L1c;
                case 8: goto L49;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            int r3 = r3 + 1
            r0 = 2
            goto L4
        Lc:
            int r0 = r7 + r8
            if (r3 >= r0) goto L12
            r0 = 3
            goto L4
        L12:
            r0 = 8
            goto L4
        L15:
            com.facebook.ads.redexgen.X.Js r4 = (com.facebook.ads.redexgen.X.C0502Js) r4
            r4.A00()
            r0 = 6
            goto L4
        L1c:
            com.facebook.ads.redexgen.X.Js r4 = (com.facebook.ads.redexgen.X.C0502Js) r4
            char[] r6 = (char[]) r6
            char[] r2 = r4.A01
            int r1 = r4.A00
            char r0 = r6[r3]
            r2[r1] = r0
            int r0 = r4.A00
            int r0 = r0 + 1
            r4.A00 = r0
            r0 = 6
            goto L4
        L30:
            com.facebook.ads.redexgen.X.Js r4 = (com.facebook.ads.redexgen.X.C0502Js) r4
            int r1 = r4.A00
            char[] r0 = r4.A01
            int r0 = r0.length
            if (r1 != r0) goto L3b
            r0 = 5
            goto L4
        L3b:
            r0 = 7
            goto L4
        L3d:
            char[] r6 = (char[]) r6
            char r1 = r6[r3]
            r0 = 10
            if (r1 == r0) goto L47
            r0 = 4
            goto L4
        L47:
            r0 = 5
            goto L4
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0502Js.write(char[], int, int):void");
    }
}
