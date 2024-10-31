package com.fasterxml.jackson.core.b;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: WriterBasedJsonGenerator.java */
/* loaded from: classes.dex */
public final class i extends c {
    protected static final char[] m = com.fasterxml.jackson.core.io.b.g();
    protected final Writer n;
    protected char[] o;
    protected int p;
    protected int q;
    protected int r;
    protected char[] s;
    protected com.fasterxml.jackson.core.e t;

    public i(com.fasterxml.jackson.core.io.c cVar, int i, com.fasterxml.jackson.core.c cVar2, Writer writer) {
        super(cVar, i, cVar2);
        this.p = 0;
        this.q = 0;
        this.n = writer;
        this.o = cVar.h();
        this.r = this.o.length;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(String str) throws IOException, JsonGenerationException {
        int a2 = this.e.a(str);
        if (a2 == 4) {
            e("Can not write a field name, expecting a value");
        }
        a(str, a2 == 1);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void c() throws IOException, JsonGenerationException {
        d("start an array");
        this.e = this.e.h();
        if (this.f416a != null) {
            this.f416a.writeStartArray(this);
            return;
        }
        if (this.q >= this.r) {
            k();
        }
        char[] cArr = this.o;
        int i = this.q;
        this.q = i + 1;
        cArr[i] = '[';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void d() throws IOException, JsonGenerationException {
        if (!this.e.a()) {
            e("Current context not an ARRAY but " + this.e.d());
        }
        if (this.f416a != null) {
            this.f416a.writeEndArray(this, this.e.e());
        } else {
            if (this.q >= this.r) {
                k();
            }
            char[] cArr = this.o;
            int i = this.q;
            this.q = i + 1;
            cArr[i] = ']';
        }
        this.e = this.e.j();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void e() throws IOException, JsonGenerationException {
        d("start an object");
        this.e = this.e.i();
        if (this.f416a != null) {
            this.f416a.writeStartObject(this);
            return;
        }
        if (this.q >= this.r) {
            k();
        }
        char[] cArr = this.o;
        int i = this.q;
        this.q = i + 1;
        cArr[i] = '{';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void f() throws IOException, JsonGenerationException {
        if (!this.e.c()) {
            e("Current context not an object but " + this.e.d());
        }
        if (this.f416a != null) {
            this.f416a.writeEndObject(this, this.e.e());
        } else {
            if (this.q >= this.r) {
                k();
            }
            char[] cArr = this.o;
            int i = this.q;
            this.q = i + 1;
            cArr[i] = '}';
        }
        this.e = this.e.j();
    }

    protected void a(String str, boolean z) throws IOException, JsonGenerationException {
        if (this.f416a != null) {
            b(str, z);
            return;
        }
        if (this.q + 1 >= this.r) {
            k();
        }
        if (z) {
            char[] cArr = this.o;
            int i = this.q;
            this.q = i + 1;
            cArr[i] = ',';
        }
        if (!a(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            g(str);
            return;
        }
        char[] cArr2 = this.o;
        int i2 = this.q;
        this.q = i2 + 1;
        cArr2[i2] = '\"';
        g(str);
        if (this.q >= this.r) {
            k();
        }
        char[] cArr3 = this.o;
        int i3 = this.q;
        this.q = i3 + 1;
        cArr3[i3] = '\"';
    }

    protected void b(String str, boolean z) throws IOException, JsonGenerationException {
        if (z) {
            this.f416a.writeObjectEntrySeparator(this);
        } else {
            this.f416a.beforeObjectEntries(this);
        }
        if (a(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            if (this.q >= this.r) {
                k();
            }
            char[] cArr = this.o;
            int i = this.q;
            this.q = i + 1;
            cArr[i] = '\"';
            g(str);
            if (this.q >= this.r) {
                k();
            }
            char[] cArr2 = this.o;
            int i2 = this.q;
            this.q = i2 + 1;
            cArr2[i2] = '\"';
            return;
        }
        g(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void b(String str) throws IOException, JsonGenerationException {
        d("write text value");
        if (str == null) {
            l();
            return;
        }
        if (this.q >= this.r) {
            k();
        }
        char[] cArr = this.o;
        int i = this.q;
        this.q = i + 1;
        cArr[i] = '\"';
        g(str);
        if (this.q >= this.r) {
            k();
        }
        char[] cArr2 = this.o;
        int i2 = this.q;
        this.q = i2 + 1;
        cArr2[i2] = '\"';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void c(String str) throws IOException, JsonGenerationException {
        int length = str.length();
        int i = this.r - this.q;
        if (i == 0) {
            k();
            i = this.r - this.q;
        }
        if (i >= length) {
            str.getChars(0, length, this.o, this.q);
            this.q += length;
        } else {
            f(str);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void b(com.fasterxml.jackson.core.e eVar) throws IOException, JsonGenerationException {
        c(eVar.getValue());
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        if (i2 < 32) {
            if (i2 > this.r - this.q) {
                k();
            }
            System.arraycopy(cArr, i, this.o, this.q, i2);
            this.q += i2;
            return;
        }
        k();
        this.n.write(cArr, i, i2);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(char c) throws IOException, JsonGenerationException {
        if (this.q >= this.r) {
            k();
        }
        char[] cArr = this.o;
        int i = this.q;
        this.q = i + 1;
        cArr[i] = c;
    }

    private void f(String str) throws IOException, JsonGenerationException {
        int i = this.r - this.q;
        str.getChars(0, i, this.o, this.q);
        this.q += i;
        k();
        int length = str.length() - i;
        while (length > this.r) {
            int i2 = this.r;
            str.getChars(i, i + i2, this.o, 0);
            this.p = 0;
            this.q = i2;
            k();
            i += i2;
            length -= i2;
        }
        str.getChars(i, i + length, this.o, 0);
        this.p = 0;
        this.q = length;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void b(int i) throws IOException, JsonGenerationException {
        d("write number");
        if (this.d) {
            c(i);
            return;
        }
        if (this.q + 11 >= this.r) {
            k();
        }
        this.q = com.fasterxml.jackson.core.io.g.a(i, this.o, this.q);
    }

    private void c(int i) throws IOException {
        if (this.q + 13 >= this.r) {
            k();
        }
        char[] cArr = this.o;
        int i2 = this.q;
        this.q = i2 + 1;
        cArr[i2] = '\"';
        this.q = com.fasterxml.jackson.core.io.g.a(i, this.o, this.q);
        char[] cArr2 = this.o;
        int i3 = this.q;
        this.q = i3 + 1;
        cArr2[i3] = '\"';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(long j) throws IOException, JsonGenerationException {
        d("write number");
        if (this.d) {
            b(j);
            return;
        }
        if (this.q + 21 >= this.r) {
            k();
        }
        this.q = com.fasterxml.jackson.core.io.g.a(j, this.o, this.q);
    }

    private void b(long j) throws IOException {
        if (this.q + 23 >= this.r) {
            k();
        }
        char[] cArr = this.o;
        int i = this.q;
        this.q = i + 1;
        cArr[i] = '\"';
        this.q = com.fasterxml.jackson.core.io.g.a(j, this.o, this.q);
        char[] cArr2 = this.o;
        int i2 = this.q;
        this.q = i2 + 1;
        cArr2[i2] = '\"';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(BigInteger bigInteger) throws IOException, JsonGenerationException {
        d("write number");
        if (bigInteger == null) {
            l();
        } else if (this.d) {
            a((Object) bigInteger);
        } else {
            c(bigInteger.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(double d) throws IOException, JsonGenerationException {
        if (this.d || ((Double.isNaN(d) || Double.isInfinite(d)) && a(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            b(String.valueOf(d));
        } else {
            d("write number");
            c(String.valueOf(d));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(float f) throws IOException, JsonGenerationException {
        if (this.d || ((Float.isNaN(f) || Float.isInfinite(f)) && a(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            b(String.valueOf(f));
        } else {
            d("write number");
            c(String.valueOf(f));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(BigDecimal bigDecimal) throws IOException, JsonGenerationException {
        d("write number");
        if (bigDecimal == null) {
            l();
        } else if (this.d) {
            a((Object) bigDecimal);
        } else {
            c(bigDecimal.toString());
        }
    }

    private void a(Object obj) throws IOException {
        if (this.q >= this.r) {
            k();
        }
        char[] cArr = this.o;
        int i = this.q;
        this.q = i + 1;
        cArr[i] = '\"';
        c(obj.toString());
        if (this.q >= this.r) {
            k();
        }
        char[] cArr2 = this.o;
        int i2 = this.q;
        this.q = i2 + 1;
        cArr2[i2] = '\"';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(boolean z) throws IOException, JsonGenerationException {
        int i;
        d("write boolean value");
        if (this.q + 5 >= this.r) {
            k();
        }
        int i2 = this.q;
        char[] cArr = this.o;
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
        this.q = i + 1;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void g() throws IOException, JsonGenerationException {
        d("write null value");
        l();
    }

    @Override // com.fasterxml.jackson.core.a.a
    protected void d(String str) throws IOException, JsonGenerationException {
        char c;
        int k = this.e.k();
        if (k == 5) {
            e("Can not " + str + ", expecting field name");
        }
        if (this.f416a == null) {
            switch (k) {
                case 1:
                    c = ',';
                    break;
                case 2:
                    c = ':';
                    break;
                case 3:
                    if (this.l != null) {
                        c(this.l.getValue());
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (this.q >= this.r) {
                k();
            }
            this.o[this.q] = c;
            this.q++;
            return;
        }
        a(str, k);
    }

    protected void a(String str, int i) throws IOException, JsonGenerationException {
        switch (i) {
            case 0:
                if (this.e.a()) {
                    this.f416a.beforeArrayValues(this);
                    return;
                } else {
                    if (this.e.c()) {
                        this.f416a.beforeObjectEntries(this);
                        return;
                    }
                    return;
                }
            case 1:
                this.f416a.writeArrayValueSeparator(this);
                return;
            case 2:
                this.f416a.writeObjectFieldValueSeparator(this);
                return;
            case 3:
                this.f416a.writeRootValueSeparator(this);
                return;
            default:
                j();
                return;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
        k();
        if (this.n != null && a(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this.n.flush();
        }
    }

    @Override // com.fasterxml.jackson.core.a.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.o != null && a(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                e h = h();
                if (h.a()) {
                    d();
                } else if (!h.c()) {
                    break;
                } else {
                    f();
                }
            }
        }
        k();
        if (this.n != null) {
            if (this.h.c() || a(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                this.n.close();
            } else if (a(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                this.n.flush();
            }
        }
        i();
    }

    @Override // com.fasterxml.jackson.core.a.a
    protected void i() {
        char[] cArr = this.o;
        if (cArr != null) {
            this.o = null;
            this.h.b(cArr);
        }
    }

    private void g(String str) throws IOException, JsonGenerationException {
        int length = str.length();
        if (length > this.r) {
            h(str);
            return;
        }
        if (this.q + length > this.r) {
            k();
        }
        str.getChars(0, length, this.o, this.q);
        if (this.k != null) {
            f(length);
        } else if (this.j != 0) {
            a(length, this.j);
        } else {
            d(length);
        }
    }

    private void d(int i) throws IOException, JsonGenerationException {
        int i2;
        int i3 = this.q + i;
        int[] iArr = this.i;
        int length = iArr.length;
        while (this.q < i3) {
            do {
                char c = this.o[this.q];
                if (c >= length || iArr[c] == 0) {
                    i2 = this.q + 1;
                    this.q = i2;
                } else {
                    int i4 = this.q - this.p;
                    if (i4 > 0) {
                        this.n.write(this.o, this.p, i4);
                    }
                    char[] cArr = this.o;
                    int i5 = this.q;
                    this.q = i5 + 1;
                    char c2 = cArr[i5];
                    a(c2, iArr[c2]);
                }
            } while (i2 < i3);
            return;
        }
    }

    private void h(String str) throws IOException, JsonGenerationException {
        k();
        int length = str.length();
        int i = 0;
        do {
            int i2 = this.r;
            if (i + i2 > length) {
                i2 = length - i;
            }
            str.getChars(i, i + i2, this.o, 0);
            if (this.k != null) {
                g(i2);
            } else if (this.j != 0) {
                b(i2, this.j);
            } else {
                e(i2);
            }
            i += i2;
        } while (i < length);
    }

    private void e(int i) throws IOException, JsonGenerationException {
        char c;
        int[] iArr = this.i;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            do {
                c = this.o[i2];
                if (c < length && iArr[c] != 0) {
                    break;
                } else {
                    i2++;
                }
            } while (i2 < i);
            int i4 = i2 - i3;
            if (i4 > 0) {
                this.n.write(this.o, i3, i4);
                if (i2 >= i) {
                    return;
                }
            }
            int i5 = i2 + 1;
            i3 = a(this.o, i5, i, c, iArr[c]);
            i2 = i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r10, int r11) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r9 = this;
            int r0 = r9.q
            int r1 = r0 + r10
            int[] r2 = r9.i
            int r0 = r2.length
            int r3 = r11 + 1
            int r3 = java.lang.Math.min(r0, r3)
        Ld:
            int r0 = r9.q
            if (r0 >= r1) goto L43
        L11:
            char[] r0 = r9.o
            int r4 = r9.q
            char r4 = r0[r4]
            if (r4 >= r3) goto L37
            r0 = r2[r4]
            if (r0 == 0) goto L3b
        L1d:
            int r5 = r9.q
            int r6 = r9.p
            int r5 = r5 - r6
            if (r5 <= 0) goto L2d
            java.io.Writer r6 = r9.n
            char[] r7 = r9.o
            int r8 = r9.p
            r6.write(r7, r8, r5)
        L2d:
            int r5 = r9.q
            int r5 = r5 + 1
            r9.q = r5
            r9.a(r4, r0)
            goto Ld
        L37:
            if (r4 <= r11) goto L3b
            r0 = -1
            goto L1d
        L3b:
            int r0 = r9.q
            int r0 = r0 + 1
            r9.q = r0
            if (r0 < r1) goto L11
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.b.i.a(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[LOOP:1: B:3:0x000e->B:22:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r10, int r11) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r9 = this;
            r0 = 0
            int[] r6 = r9.i
            int r1 = r6.length
            int r2 = r11 + 1
            int r7 = java.lang.Math.min(r1, r2)
            r2 = r0
            r1 = r0
        Lc:
            if (r1 >= r10) goto L25
        Le:
            char[] r3 = r9.o
            char r4 = r3[r1]
            if (r4 >= r7) goto L26
            r5 = r6[r4]
            if (r5 == 0) goto L2a
        L18:
            int r0 = r1 - r2
            if (r0 <= 0) goto L31
            java.io.Writer r3 = r9.n
            char[] r8 = r9.o
            r3.write(r8, r2, r0)
            if (r1 < r10) goto L31
        L25:
            return
        L26:
            if (r4 <= r11) goto L2b
            r5 = -1
            goto L18
        L2a:
            r0 = r5
        L2b:
            int r1 = r1 + 1
            if (r1 < r10) goto Le
            r5 = r0
            goto L18
        L31:
            int r2 = r1 + 1
            char[] r1 = r9.o
            r0 = r9
            r3 = r10
            int r0 = r0.a(r1, r2, r3, r4, r5)
            r1 = r2
            r2 = r0
            r0 = r5
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.b.i.b(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0037 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f(int r12) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r11 = this;
            int r0 = r11.q
            int r2 = r0 + r12
            int[] r3 = r11.i
            int r0 = r11.j
            r1 = 1
            if (r0 >= r1) goto L41
            r0 = 65535(0xffff, float:9.1834E-41)
        Le:
            int r1 = r3.length
            int r4 = r0 + 1
            int r4 = java.lang.Math.min(r1, r4)
            com.fasterxml.jackson.core.io.CharacterEscapes r5 = r11.k
        L17:
            int r1 = r11.q
            if (r1 >= r2) goto L5a
        L1b:
            char[] r1 = r11.o
            int r6 = r11.q
            char r6 = r1[r6]
            if (r6 >= r4) goto L44
            r1 = r3[r6]
            if (r1 == 0) goto L52
        L27:
            int r7 = r11.q
            int r8 = r11.p
            int r7 = r7 - r8
            if (r7 <= 0) goto L37
            java.io.Writer r8 = r11.n
            char[] r9 = r11.o
            int r10 = r11.p
            r8.write(r9, r10, r7)
        L37:
            int r7 = r11.q
            int r7 = r7 + 1
            r11.q = r7
            r11.a(r6, r1)
            goto L17
        L41:
            int r0 = r11.j
            goto Le
        L44:
            if (r6 <= r0) goto L48
            r1 = -1
            goto L27
        L48:
            com.fasterxml.jackson.core.e r1 = r5.getEscapeSequence(r6)
            r11.t = r1
            if (r1 == 0) goto L52
            r1 = -2
            goto L27
        L52:
            int r1 = r11.q
            int r1 = r1 + 1
            r11.q = r1
            if (r1 < r2) goto L1b
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.b.i.f(int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[LOOP:1: B:6:0x0019->B:25:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g(int r12) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r11 = this;
            r1 = 0
            int[] r7 = r11.i
            int r0 = r11.j
            r2 = 1
            if (r0 >= r2) goto L31
            r0 = 65535(0xffff, float:9.1834E-41)
            r6 = r0
        Lc:
            int r0 = r7.length
            int r2 = r6 + 1
            int r8 = java.lang.Math.min(r0, r2)
            com.fasterxml.jackson.core.io.CharacterEscapes r9 = r11.k
            r2 = r1
            r0 = r1
        L17:
            if (r1 >= r12) goto L30
        L19:
            char[] r3 = r11.o
            char r4 = r3[r1]
            if (r4 >= r8) goto L35
            r5 = r7[r4]
            if (r5 == 0) goto L43
        L23:
            int r0 = r1 - r2
            if (r0 <= 0) goto L4a
            java.io.Writer r3 = r11.n
            char[] r10 = r11.o
            r3.write(r10, r2, r0)
            if (r1 < r12) goto L4a
        L30:
            return
        L31:
            int r0 = r11.j
            r6 = r0
            goto Lc
        L35:
            if (r4 <= r6) goto L39
            r5 = -1
            goto L23
        L39:
            com.fasterxml.jackson.core.e r3 = r9.getEscapeSequence(r4)
            r11.t = r3
            if (r3 == 0) goto L44
            r5 = -2
            goto L23
        L43:
            r0 = r5
        L44:
            int r1 = r1 + 1
            if (r1 < r12) goto L19
            r5 = r0
            goto L23
        L4a:
            int r2 = r1 + 1
            char[] r1 = r11.o
            r0 = r11
            r3 = r12
            int r0 = r0.a(r1, r2, r3, r4, r5)
            r1 = r2
            r2 = r0
            r0 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.b.i.g(int):void");
    }

    private void l() throws IOException {
        if (this.q + 4 >= this.r) {
            k();
        }
        int i = this.q;
        char[] cArr = this.o;
        cArr[i] = 'n';
        int i2 = i + 1;
        cArr[i2] = 'u';
        int i3 = i2 + 1;
        cArr[i3] = 'l';
        int i4 = i3 + 1;
        cArr[i4] = 'l';
        this.q = i4 + 1;
    }

    private void a(char c, int i) throws IOException, JsonGenerationException {
        String value;
        int i2;
        if (i >= 0) {
            if (this.q >= 2) {
                int i3 = this.q - 2;
                this.p = i3;
                this.o[i3] = '\\';
                this.o[i3 + 1] = (char) i;
                return;
            }
            char[] cArr = this.s;
            if (cArr == null) {
                cArr = m();
            }
            this.p = this.q;
            cArr[1] = (char) i;
            this.n.write(cArr, 0, 2);
            return;
        }
        if (i != -2) {
            if (this.q >= 6) {
                char[] cArr2 = this.o;
                int i4 = this.q - 6;
                this.p = i4;
                cArr2[i4] = '\\';
                int i5 = i4 + 1;
                cArr2[i5] = 'u';
                if (c > 255) {
                    int i6 = (c >> '\b') & 255;
                    int i7 = i5 + 1;
                    cArr2[i7] = m[i6 >> 4];
                    i2 = i7 + 1;
                    cArr2[i2] = m[i6 & 15];
                    c = (char) (c & 255);
                } else {
                    int i8 = i5 + 1;
                    cArr2[i8] = '0';
                    i2 = i8 + 1;
                    cArr2[i2] = '0';
                }
                int i9 = i2 + 1;
                cArr2[i9] = m[c >> 4];
                cArr2[i9 + 1] = m[c & 15];
                return;
            }
            char[] cArr3 = this.s;
            if (cArr3 == null) {
                cArr3 = m();
            }
            this.p = this.q;
            if (c > 255) {
                int i10 = (c >> '\b') & 255;
                int i11 = c & 255;
                cArr3[10] = m[i10 >> 4];
                cArr3[11] = m[i10 & 15];
                cArr3[12] = m[i11 >> 4];
                cArr3[13] = m[i11 & 15];
                this.n.write(cArr3, 8, 6);
                return;
            }
            cArr3[6] = m[c >> 4];
            cArr3[7] = m[c & 15];
            this.n.write(cArr3, 2, 6);
            return;
        }
        if (this.t == null) {
            value = this.k.getEscapeSequence(c).getValue();
        } else {
            value = this.t.getValue();
            this.t = null;
        }
        int length = value.length();
        if (this.q >= length) {
            int i12 = this.q - length;
            this.p = i12;
            value.getChars(0, length, this.o, i12);
        } else {
            this.p = this.q;
            this.n.write(value);
        }
    }

    private int a(char[] cArr, int i, int i2, char c, int i3) throws IOException, JsonGenerationException {
        String value;
        int i4;
        if (i3 >= 0) {
            if (i > 1 && i < i2) {
                int i5 = i - 2;
                cArr[i5] = '\\';
                cArr[i5 + 1] = (char) i3;
                return i5;
            }
            char[] cArr2 = this.s;
            if (cArr2 == null) {
                cArr2 = m();
            }
            cArr2[1] = (char) i3;
            this.n.write(cArr2, 0, 2);
            return i;
        }
        if (i3 != -2) {
            if (i > 5 && i < i2) {
                int i6 = i - 6;
                int i7 = i6 + 1;
                cArr[i6] = '\\';
                int i8 = i7 + 1;
                cArr[i7] = 'u';
                if (c > 255) {
                    int i9 = (c >> '\b') & 255;
                    int i10 = i8 + 1;
                    cArr[i8] = m[i9 >> 4];
                    i4 = i10 + 1;
                    cArr[i10] = m[i9 & 15];
                    c = (char) (c & 255);
                } else {
                    int i11 = i8 + 1;
                    cArr[i8] = '0';
                    i4 = i11 + 1;
                    cArr[i11] = '0';
                }
                int i12 = i4 + 1;
                cArr[i4] = m[c >> 4];
                cArr[i12] = m[c & 15];
                return i12 - 5;
            }
            char[] cArr3 = this.s;
            if (cArr3 == null) {
                cArr3 = m();
            }
            this.p = this.q;
            if (c > 255) {
                int i13 = (c >> '\b') & 255;
                int i14 = c & 255;
                cArr3[10] = m[i13 >> 4];
                cArr3[11] = m[i13 & 15];
                cArr3[12] = m[i14 >> 4];
                cArr3[13] = m[i14 & 15];
                this.n.write(cArr3, 8, 6);
                return i;
            }
            cArr3[6] = m[c >> 4];
            cArr3[7] = m[c & 15];
            this.n.write(cArr3, 2, 6);
            return i;
        }
        if (this.t == null) {
            value = this.k.getEscapeSequence(c).getValue();
        } else {
            value = this.t.getValue();
            this.t = null;
        }
        int length = value.length();
        if (i >= length && i < i2) {
            int i15 = i - length;
            value.getChars(0, length, cArr, i15);
            return i15;
        }
        this.n.write(value);
        return i;
    }

    private char[] m() {
        char[] cArr = {'\\', 0, '\\', 'u', '0', '0', 0, 0, '\\', 'u'};
        this.s = cArr;
        return cArr;
    }

    protected void k() throws IOException {
        int i = this.q - this.p;
        if (i > 0) {
            int i2 = this.p;
            this.p = 0;
            this.q = 0;
            this.n.write(this.o, i2, i);
        }
    }
}
