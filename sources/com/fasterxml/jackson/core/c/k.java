package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: WriterBasedJsonGenerator.java */
/* loaded from: classes.dex */
public class k extends c {
    protected static final char[] o = com.fasterxml.jackson.core.io.a.b();
    protected final Writer p;
    protected char q;
    protected char[] r;
    protected int s;
    protected int t;
    protected int u;
    protected char[] v;
    protected com.fasterxml.jackson.core.e w;
    protected char[] x;

    public k(com.fasterxml.jackson.core.io.c cVar, int i, com.fasterxml.jackson.core.c cVar2, Writer writer) {
        super(cVar, i, cVar2);
        this.q = '\"';
        this.p = writer;
        this.r = cVar.a();
        this.u = this.r.length;
    }

    private char[] L() {
        char[] cArr = {'\\', 0, '\\', 'u', '0', '0', 0, 0, '\\', 'u'};
        this.v = cArr;
        return cArr;
    }

    private final void M() throws IOException {
        if (this.t + 4 >= this.u) {
            z();
        }
        int i = this.t;
        char[] cArr = this.r;
        cArr[i] = 'n';
        int i2 = i + 1;
        cArr[i2] = 'u';
        int i3 = i2 + 1;
        cArr[i3] = 'l';
        int i4 = i3 + 1;
        cArr[i4] = 'l';
        this.t = i4 + 1;
    }

    private void c(int i) throws IOException {
        if (this.t + 13 >= this.u) {
            z();
        }
        char[] cArr = this.r;
        int i2 = this.t;
        this.t = i2 + 1;
        cArr[i2] = this.q;
        this.t = com.fasterxml.jackson.core.io.g.a(i, cArr, this.t);
        char[] cArr2 = this.r;
        int i3 = this.t;
        this.t = i3 + 1;
        cArr2[i3] = this.q;
    }

    private void d(int i) throws IOException {
        char c2;
        int[] iArr = this.j;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            do {
                c2 = this.r[i2];
                if (c2 < length && iArr[c2] != 0) {
                    break;
                } else {
                    i2++;
                }
            } while (i2 < i);
            int i4 = i2 - i3;
            if (i4 > 0) {
                this.p.write(this.r, i3, i4);
                if (i2 >= i) {
                    return;
                }
            }
            i2++;
            i3 = a(this.r, i2, i, c2, iArr[c2]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[EDGE_INSN: B:12:0x0035->B:13:0x0035 BREAK  A[LOOP:1: B:6:0x0018->B:23:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[LOOP:1: B:6:0x0018->B:23:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(int r15) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r14 = this;
            int[] r0 = r14.j
            int r1 = r14.k
            r2 = 1
            if (r1 >= r2) goto La
            r1 = 65535(0xffff, float:9.1834E-41)
        La:
            int r2 = r0.length
            int r3 = r1 + 1
            int r2 = java.lang.Math.min(r2, r3)
            com.fasterxml.jackson.core.io.CharacterEscapes r3 = r14.l
            r4 = 0
            r5 = 0
            r6 = 0
        L16:
            if (r4 >= r15) goto L50
        L18:
            char[] r7 = r14.r
            char r12 = r7[r4]
            if (r12 >= r2) goto L23
            r6 = r0[r12]
            if (r6 == 0) goto L31
            goto L35
        L23:
            if (r12 <= r1) goto L27
            r6 = -1
            goto L35
        L27:
            com.fasterxml.jackson.core.e r7 = r3.getEscapeSequence(r12)
            r14.w = r7
            if (r7 == 0) goto L31
            r6 = -2
            goto L35
        L31:
            int r4 = r4 + 1
            if (r4 < r15) goto L18
        L35:
            int r7 = r4 - r5
            if (r7 <= 0) goto L43
            java.io.Writer r8 = r14.p
            char[] r9 = r14.r
            r8.write(r9, r5, r7)
            if (r4 < r15) goto L43
            goto L50
        L43:
            int r4 = r4 + 1
            char[] r9 = r14.r
            r8 = r14
            r10 = r4
            r11 = r15
            r13 = r6
            int r5 = r8.a(r9, r10, r11, r12, r13)
            goto L16
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.k.e(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i(int r12) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r11 = this;
            int r0 = r11.t
            int r0 = r0 + r12
            int[] r12 = r11.j
            int r1 = r11.k
            r2 = 1
            if (r1 >= r2) goto Ld
            r1 = 65535(0xffff, float:9.1834E-41)
        Ld:
            int r3 = r12.length
            int r4 = r1 + 1
            int r3 = java.lang.Math.min(r3, r4)
            com.fasterxml.jackson.core.io.CharacterEscapes r4 = r11.l
        L16:
            int r5 = r11.t
            if (r5 >= r0) goto L52
        L1a:
            char[] r5 = r11.r
            int r6 = r11.t
            char r5 = r5[r6]
            if (r5 >= r3) goto L27
            r6 = r12[r5]
            if (r6 == 0) goto L4b
            goto L34
        L27:
            if (r5 <= r1) goto L2b
            r6 = -1
            goto L34
        L2b:
            com.fasterxml.jackson.core.e r6 = r4.getEscapeSequence(r5)
            r11.w = r6
            if (r6 == 0) goto L4b
            r6 = -2
        L34:
            int r7 = r11.t
            int r8 = r11.s
            int r7 = r7 - r8
            if (r7 <= 0) goto L42
            java.io.Writer r9 = r11.p
            char[] r10 = r11.r
            r9.write(r10, r8, r7)
        L42:
            int r7 = r11.t
            int r7 = r7 + r2
            r11.t = r7
            r11.a(r5, r6)
            goto L16
        L4b:
            int r5 = r11.t
            int r5 = r5 + r2
            r11.t = r5
            if (r5 < r0) goto L1a
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.k.i(int):void");
    }

    private void k(String str) throws IOException {
        z();
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = this.u;
            if (i + i2 > length) {
                i2 = length - i;
            }
            int i3 = i + i2;
            str.getChars(i, i3, this.r, 0);
            if (this.l != null) {
                e(i2);
            } else {
                int i4 = this.k;
                if (i4 != 0) {
                    b(i2, i4);
                } else {
                    d(i2);
                }
            }
            if (i3 >= length) {
                return;
            } else {
                i = i3;
            }
        }
    }

    private void l(String str) throws IOException {
        if (this.t >= this.u) {
            z();
        }
        char[] cArr = this.r;
        int i = this.t;
        this.t = i + 1;
        cArr[i] = this.q;
        g(str);
        if (this.t >= this.u) {
            z();
        }
        char[] cArr2 = this.r;
        int i2 = this.t;
        this.t = i2 + 1;
        cArr2[i2] = this.q;
    }

    private void m(String str) throws IOException {
        int length = str.length();
        int i = this.u;
        if (length > i) {
            k(str);
            return;
        }
        if (this.t + length > i) {
            z();
        }
        str.getChars(0, length, this.r, this.t);
        if (this.l != null) {
            i(length);
            return;
        }
        int i2 = this.k;
        if (i2 != 0) {
            c(length, i2);
        } else {
            h(length);
        }
    }

    private void n(String str) throws IOException {
        int i = this.u;
        int i2 = this.t;
        int i3 = i - i2;
        str.getChars(0, i3, this.r, i2);
        this.t += i3;
        z();
        int length = str.length() - i3;
        while (true) {
            int i4 = this.u;
            if (length > i4) {
                int i5 = i3 + i4;
                str.getChars(i3, i5, this.r, 0);
                this.s = 0;
                this.t = i4;
                z();
                length -= i4;
                i3 = i5;
            } else {
                str.getChars(i3, i3 + length, this.r, 0);
                this.s = 0;
                this.t = length;
                return;
            }
        }
    }

    protected void A() {
        char[] cArr = this.r;
        if (cArr != null) {
            this.r = null;
            this.i.a(cArr);
        }
        char[] cArr2 = this.x;
        if (cArr2 != null) {
            this.x = null;
            this.i.b(cArr2);
        }
    }

    protected final void a(String str, boolean z) throws IOException {
        if (this.f9671a != null) {
            b(str, z);
            return;
        }
        if (this.t + 1 >= this.u) {
            z();
        }
        if (z) {
            char[] cArr = this.r;
            int i = this.t;
            this.t = i + 1;
            cArr[i] = ',';
        }
        if (this.n) {
            m(str);
            return;
        }
        char[] cArr2 = this.r;
        int i2 = this.t;
        this.t = i2 + 1;
        cArr2[i2] = this.q;
        m(str);
        if (this.t >= this.u) {
            z();
        }
        char[] cArr3 = this.r;
        int i3 = this.t;
        this.t = i3 + 1;
        cArr3[i3] = this.q;
    }

    protected final void b(String str, boolean z) throws IOException {
        if (z) {
            this.f9671a.writeObjectEntrySeparator(this);
        } else {
            this.f9671a.beforeObjectEntries(this);
        }
        if (this.n) {
            m(str);
            return;
        }
        if (this.t >= this.u) {
            z();
        }
        char[] cArr = this.r;
        int i = this.t;
        this.t = i + 1;
        cArr[i] = this.q;
        m(str);
        if (this.t >= this.u) {
            z();
        }
        char[] cArr2 = this.r;
        int i2 = this.t;
        this.t = i2 + 1;
        cArr2[i2] = this.q;
    }

    @Override // com.fasterxml.jackson.core.b.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.r != null && a(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                com.fasterxml.jackson.core.b y = y();
                if (y.d()) {
                    r();
                } else if (!y.e()) {
                    break;
                } else {
                    s();
                }
            }
        }
        z();
        this.s = 0;
        this.t = 0;
        if (this.p != null) {
            if (!this.i.h() && !a(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                if (a(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                    this.p.flush();
                }
            } else {
                this.p.close();
            }
        }
        A();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void f(String str) throws IOException {
        int a2 = this.f9681f.a(str);
        if (a2 != 4) {
            a(str, a2 == 1);
        } else {
            e("Can not write a field name, expecting a value");
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
        z();
        if (this.p == null || !a(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        this.p.flush();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void g(String str) throws IOException {
        int length = str.length();
        int i = this.u - this.t;
        if (i == 0) {
            z();
            i = this.u - this.t;
        }
        if (i >= length) {
            str.getChars(0, length, this.r, this.t);
            this.t += length;
        } else {
            n(str);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void h(String str) throws IOException {
        j("write a string");
        if (str == null) {
            M();
            return;
        }
        if (this.t >= this.u) {
            z();
        }
        char[] cArr = this.r;
        int i = this.t;
        this.t = i + 1;
        cArr[i] = this.q;
        m(str);
        if (this.t >= this.u) {
            z();
        }
        char[] cArr2 = this.r;
        int i2 = this.t;
        this.t = i2 + 1;
        cArr2[i2] = this.q;
    }

    protected final void j(String str) throws IOException {
        char c2;
        int k = this.f9681f.k();
        if (this.f9671a != null) {
            a(str, k);
            return;
        }
        if (k == 1) {
            c2 = ',';
        } else {
            if (k != 2) {
                if (k != 3) {
                    if (k != 5) {
                        return;
                    }
                    i(str);
                    throw null;
                }
                com.fasterxml.jackson.core.e eVar = this.m;
                if (eVar != null) {
                    g(eVar.getValue());
                    return;
                }
                return;
            }
            c2 = ':';
        }
        if (this.t >= this.u) {
            z();
        }
        char[] cArr = this.r;
        int i = this.t;
        this.t = i + 1;
        cArr[i] = c2;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void r() throws IOException {
        if (this.f9681f.d()) {
            com.fasterxml.jackson.core.d dVar = this.f9671a;
            if (dVar != null) {
                dVar.writeEndArray(this, this.f9681f.c());
            } else {
                if (this.t >= this.u) {
                    z();
                }
                char[] cArr = this.r;
                int i = this.t;
                this.t = i + 1;
                cArr[i] = ']';
            }
            this.f9681f = this.f9681f.h();
            return;
        }
        e("Current context not Array but " + this.f9681f.g());
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void s() throws IOException {
        if (this.f9681f.e()) {
            com.fasterxml.jackson.core.d dVar = this.f9671a;
            if (dVar != null) {
                dVar.writeEndObject(this, this.f9681f.c());
            } else {
                if (this.t >= this.u) {
                    z();
                }
                char[] cArr = this.r;
                int i = this.t;
                this.t = i + 1;
                cArr[i] = '}';
            }
            this.f9681f = this.f9681f.h();
            return;
        }
        e("Current context not Object but " + this.f9681f.g());
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void u() throws IOException {
        j("write a null");
        M();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void v() throws IOException {
        j("start an array");
        this.f9681f = this.f9681f.i();
        com.fasterxml.jackson.core.d dVar = this.f9671a;
        if (dVar != null) {
            dVar.writeStartArray(this);
            return;
        }
        if (this.t >= this.u) {
            z();
        }
        char[] cArr = this.r;
        int i = this.t;
        this.t = i + 1;
        cArr[i] = '[';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void w() throws IOException {
        j("start an object");
        this.f9681f = this.f9681f.j();
        com.fasterxml.jackson.core.d dVar = this.f9671a;
        if (dVar != null) {
            dVar.writeStartObject(this);
            return;
        }
        if (this.t >= this.u) {
            z();
        }
        char[] cArr = this.r;
        int i = this.t;
        this.t = i + 1;
        cArr[i] = '{';
    }

    protected void z() throws IOException {
        int i = this.t;
        int i2 = this.s;
        int i3 = i - i2;
        if (i3 > 0) {
            this.s = 0;
            this.t = 0;
            this.p.write(this.r, i2, i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(int r9, int r10) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r8 = this;
            int r0 = r8.t
            int r0 = r0 + r9
            int[] r9 = r8.j
            int r1 = r9.length
            int r2 = r10 + 1
            int r1 = java.lang.Math.min(r1, r2)
        Lc:
            int r2 = r8.t
            if (r2 >= r0) goto L40
        L10:
            char[] r2 = r8.r
            int r3 = r8.t
            char r2 = r2[r3]
            if (r2 >= r1) goto L1d
            r3 = r9[r2]
            if (r3 == 0) goto L38
            goto L20
        L1d:
            if (r2 <= r10) goto L38
            r3 = -1
        L20:
            int r4 = r8.t
            int r5 = r8.s
            int r4 = r4 - r5
            if (r4 <= 0) goto L2e
            java.io.Writer r6 = r8.p
            char[] r7 = r8.r
            r6.write(r7, r5, r4)
        L2e:
            int r4 = r8.t
            int r4 = r4 + 1
            r8.t = r4
            r8.a(r2, r3)
            goto Lc
        L38:
            int r2 = r8.t
            int r2 = r2 + 1
            r8.t = r2
            if (r2 < r0) goto L10
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.k.c(int, int):void");
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void g(long j) throws IOException {
        j("write a number");
        if (this.f9680e) {
            h(j);
            return;
        }
        if (this.t + 21 >= this.u) {
            z();
        }
        this.t = com.fasterxml.jackson.core.io.g.a(j, this.r, this.t);
    }

    private void h(long j) throws IOException {
        if (this.t + 23 >= this.u) {
            z();
        }
        char[] cArr = this.r;
        int i = this.t;
        this.t = i + 1;
        cArr[i] = this.q;
        this.t = com.fasterxml.jackson.core.io.g.a(j, cArr, this.t);
        char[] cArr2 = this.r;
        int i2 = this.t;
        this.t = i2 + 1;
        cArr2[i2] = this.q;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:? A[LOOP:1: B:3:0x000e->B:20:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[EDGE_INSN: B:9:0x0021->B:10:0x0021 BREAK  A[LOOP:1: B:3:0x000e->B:20:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r13, int r14) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r12 = this;
            int[] r0 = r12.j
            int r1 = r0.length
            int r2 = r14 + 1
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 0
            r3 = 0
            r4 = 0
        Lc:
            if (r2 >= r13) goto L3c
        Le:
            char[] r5 = r12.r
            char r10 = r5[r2]
            if (r10 >= r1) goto L19
            r4 = r0[r10]
            if (r4 == 0) goto L1d
            goto L21
        L19:
            if (r10 <= r14) goto L1d
            r4 = -1
            goto L21
        L1d:
            int r2 = r2 + 1
            if (r2 < r13) goto Le
        L21:
            int r5 = r2 - r3
            if (r5 <= 0) goto L2f
            java.io.Writer r6 = r12.p
            char[] r7 = r12.r
            r6.write(r7, r3, r5)
            if (r2 < r13) goto L2f
            goto L3c
        L2f:
            int r2 = r2 + 1
            char[] r7 = r12.r
            r6 = r12
            r8 = r2
            r9 = r13
            r11 = r4
            int r3 = r6.a(r7, r8, r9, r10, r11)
            goto Lc
        L3c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.k.b(int, int):void");
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(com.fasterxml.jackson.core.e eVar) throws IOException {
        g(eVar.getValue());
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(char[] cArr, int i, int i2) throws IOException {
        if (i2 < 32) {
            if (i2 > this.u - this.t) {
                z();
            }
            System.arraycopy(cArr, i, this.r, this.t, i2);
            this.t += i2;
            return;
        }
        z();
        this.p.write(cArr, i, i2);
    }

    private void h(int i) throws IOException {
        int i2;
        int i3 = this.t + i;
        int[] iArr = this.j;
        int length = iArr.length;
        while (this.t < i3) {
            do {
                char[] cArr = this.r;
                int i4 = this.t;
                char c2 = cArr[i4];
                if (c2 < length && iArr[c2] != 0) {
                    int i5 = this.s;
                    int i6 = i4 - i5;
                    if (i6 > 0) {
                        this.p.write(cArr, i5, i6);
                    }
                    char[] cArr2 = this.r;
                    int i7 = this.t;
                    this.t = i7 + 1;
                    char c3 = cArr2[i7];
                    a(c3, iArr[c3]);
                } else {
                    i2 = this.t + 1;
                    this.t = i2;
                }
            } while (i2 < i3);
            return;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(char c2) throws IOException {
        if (this.t >= this.u) {
            z();
        }
        char[] cArr = this.r;
        int i = this.t;
        this.t = i + 1;
        cArr[i] = c2;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(int i) throws IOException {
        j("write a number");
        if (this.f9680e) {
            c(i);
            return;
        }
        if (this.t + 11 >= this.u) {
            z();
        }
        this.t = com.fasterxml.jackson.core.io.g.a(i, this.r, this.t);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(BigInteger bigInteger) throws IOException {
        j("write a number");
        if (bigInteger == null) {
            M();
        } else if (this.f9680e) {
            l(bigInteger.toString());
        } else {
            g(bigInteger.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(double d2) throws IOException {
        if (!this.f9680e && (!a(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS) || (!Double.isNaN(d2) && !Double.isInfinite(d2)))) {
            j("write a number");
            g(String.valueOf(d2));
        } else {
            h(String.valueOf(d2));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(float f2) throws IOException {
        if (!this.f9680e && (!a(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS) || (!Float.isNaN(f2) && !Float.isInfinite(f2)))) {
            j("write a number");
            g(String.valueOf(f2));
        } else {
            h(String.valueOf(f2));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(BigDecimal bigDecimal) throws IOException {
        j("write a number");
        if (bigDecimal == null) {
            M();
        } else if (this.f9680e) {
            l(b(bigDecimal));
        } else {
            g(b(bigDecimal));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(boolean z) throws IOException {
        int i;
        j("write a boolean value");
        if (this.t + 5 >= this.u) {
            z();
        }
        int i2 = this.t;
        char[] cArr = this.r;
        if (z) {
            cArr[i2] = 't';
            int i3 = i2 + 1;
            cArr[i3] = 'r';
            int i4 = i3 + 1;
            cArr[i4] = 'u';
            i = i4 + 1;
            cArr[i] = 'e';
        } else {
            cArr[i2] = 'f';
            int i5 = i2 + 1;
            cArr[i5] = 'a';
            int i6 = i5 + 1;
            cArr[i6] = 'l';
            int i7 = i6 + 1;
            cArr[i7] = 's';
            i = i7 + 1;
            cArr[i] = 'e';
        }
        this.t = i + 1;
    }

    private void a(char c2, int i) throws IOException, JsonGenerationException {
        String value;
        int i2;
        if (i >= 0) {
            int i3 = this.t;
            if (i3 >= 2) {
                int i4 = i3 - 2;
                this.s = i4;
                char[] cArr = this.r;
                cArr[i4] = '\\';
                cArr[i4 + 1] = (char) i;
                return;
            }
            char[] cArr2 = this.v;
            if (cArr2 == null) {
                cArr2 = L();
            }
            this.s = this.t;
            cArr2[1] = (char) i;
            this.p.write(cArr2, 0, 2);
            return;
        }
        if (i != -2) {
            int i5 = this.t;
            if (i5 >= 6) {
                char[] cArr3 = this.r;
                int i6 = i5 - 6;
                this.s = i6;
                cArr3[i6] = '\\';
                int i7 = i6 + 1;
                cArr3[i7] = 'u';
                if (c2 > 255) {
                    int i8 = (c2 >> '\b') & 255;
                    int i9 = i7 + 1;
                    char[] cArr4 = o;
                    cArr3[i9] = cArr4[i8 >> 4];
                    i2 = i9 + 1;
                    cArr3[i2] = cArr4[i8 & 15];
                    c2 = (char) (c2 & 255);
                } else {
                    int i10 = i7 + 1;
                    cArr3[i10] = '0';
                    i2 = i10 + 1;
                    cArr3[i2] = '0';
                }
                int i11 = i2 + 1;
                char[] cArr5 = o;
                cArr3[i11] = cArr5[c2 >> 4];
                cArr3[i11 + 1] = cArr5[c2 & 15];
                return;
            }
            char[] cArr6 = this.v;
            if (cArr6 == null) {
                cArr6 = L();
            }
            this.s = this.t;
            if (c2 > 255) {
                int i12 = (c2 >> '\b') & 255;
                int i13 = c2 & 255;
                char[] cArr7 = o;
                cArr6[10] = cArr7[i12 >> 4];
                cArr6[11] = cArr7[i12 & 15];
                cArr6[12] = cArr7[i13 >> 4];
                cArr6[13] = cArr7[i13 & 15];
                this.p.write(cArr6, 8, 6);
                return;
            }
            char[] cArr8 = o;
            cArr6[6] = cArr8[c2 >> 4];
            cArr6[7] = cArr8[c2 & 15];
            this.p.write(cArr6, 2, 6);
            return;
        }
        com.fasterxml.jackson.core.e eVar = this.w;
        if (eVar == null) {
            value = this.l.getEscapeSequence(c2).getValue();
        } else {
            value = eVar.getValue();
            this.w = null;
        }
        int length = value.length();
        int i14 = this.t;
        if (i14 >= length) {
            int i15 = i14 - length;
            this.s = i15;
            value.getChars(0, length, this.r, i15);
        } else {
            this.s = i14;
            this.p.write(value);
        }
    }

    private int a(char[] cArr, int i, int i2, char c2, int i3) throws IOException, JsonGenerationException {
        String value;
        int i4;
        if (i3 >= 0) {
            if (i > 1 && i < i2) {
                int i5 = i - 2;
                cArr[i5] = '\\';
                cArr[i5 + 1] = (char) i3;
                return i5;
            }
            char[] cArr2 = this.v;
            if (cArr2 == null) {
                cArr2 = L();
            }
            cArr2[1] = (char) i3;
            this.p.write(cArr2, 0, 2);
            return i;
        }
        if (i3 == -2) {
            com.fasterxml.jackson.core.e eVar = this.w;
            if (eVar == null) {
                value = this.l.getEscapeSequence(c2).getValue();
            } else {
                value = eVar.getValue();
                this.w = null;
            }
            int length = value.length();
            if (i >= length && i < i2) {
                int i6 = i - length;
                value.getChars(0, length, cArr, i6);
                return i6;
            }
            this.p.write(value);
            return i;
        }
        if (i > 5 && i < i2) {
            int i7 = i - 6;
            int i8 = i7 + 1;
            cArr[i7] = '\\';
            int i9 = i8 + 1;
            cArr[i8] = 'u';
            if (c2 > 255) {
                int i10 = (c2 >> '\b') & 255;
                int i11 = i9 + 1;
                char[] cArr3 = o;
                cArr[i9] = cArr3[i10 >> 4];
                i4 = i11 + 1;
                cArr[i11] = cArr3[i10 & 15];
                c2 = (char) (c2 & 255);
            } else {
                int i12 = i9 + 1;
                cArr[i9] = '0';
                i4 = i12 + 1;
                cArr[i12] = '0';
            }
            int i13 = i4 + 1;
            char[] cArr4 = o;
            cArr[i4] = cArr4[c2 >> 4];
            cArr[i13] = cArr4[c2 & 15];
            return i13 - 5;
        }
        char[] cArr5 = this.v;
        if (cArr5 == null) {
            cArr5 = L();
        }
        this.s = this.t;
        if (c2 > 255) {
            int i14 = (c2 >> '\b') & 255;
            int i15 = c2 & 255;
            char[] cArr6 = o;
            cArr5[10] = cArr6[i14 >> 4];
            cArr5[11] = cArr6[i14 & 15];
            cArr5[12] = cArr6[i15 >> 4];
            cArr5[13] = cArr6[i15 & 15];
            this.p.write(cArr5, 8, 6);
            return i;
        }
        char[] cArr7 = o;
        cArr5[6] = cArr7[c2 >> 4];
        cArr5[7] = cArr7[c2 & 15];
        this.p.write(cArr5, 2, 6);
        return i;
    }
}
