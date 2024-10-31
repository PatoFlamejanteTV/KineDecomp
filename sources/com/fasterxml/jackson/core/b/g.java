package com.fasterxml.jackson.core.b;

import com.facebook.internal.NativeProtocol;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: UTF8JsonGenerator.java */
/* loaded from: classes.dex */
public class g extends c {
    static final byte[] m = com.fasterxml.jackson.core.io.b.h();
    private static final byte[] v = {110, 117, 108, 108};
    private static final byte[] w = {116, 114, 117, 101};
    private static final byte[] x = {102, 97, 108, 115, 101};
    protected final OutputStream n;
    protected byte[] o;
    protected int p;
    protected final int q;
    protected final int r;
    protected char[] s;
    protected final int t;
    protected boolean u;

    public g(com.fasterxml.jackson.core.io.c cVar, int i, com.fasterxml.jackson.core.c cVar2, OutputStream outputStream) {
        super(cVar, i, cVar2);
        this.p = 0;
        this.n = outputStream;
        this.u = true;
        this.o = cVar.f();
        this.q = this.o.length;
        this.r = this.q >> 3;
        this.s = cVar.h();
        this.t = this.s.length;
        if (a(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            a(127);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void a(String str) throws IOException, JsonGenerationException {
        int a2 = this.e.a(str);
        if (a2 == 4) {
            e("Can not write a field name, expecting a value");
        }
        if (this.f416a != null) {
            a(str, a2 == 1);
            return;
        }
        if (a2 == 1) {
            if (this.p >= this.q) {
                k();
            }
            byte[] bArr = this.o;
            int i = this.p;
            this.p = i + 1;
            bArr[i] = 44;
        }
        f(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void c() throws IOException, JsonGenerationException {
        d("start an array");
        this.e = this.e.h();
        if (this.f416a != null) {
            this.f416a.writeStartArray(this);
            return;
        }
        if (this.p >= this.q) {
            k();
        }
        byte[] bArr = this.o;
        int i = this.p;
        this.p = i + 1;
        bArr[i] = 91;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void d() throws IOException, JsonGenerationException {
        if (!this.e.a()) {
            e("Current context not an ARRAY but " + this.e.d());
        }
        if (this.f416a != null) {
            this.f416a.writeEndArray(this, this.e.e());
        } else {
            if (this.p >= this.q) {
                k();
            }
            byte[] bArr = this.o;
            int i = this.p;
            this.p = i + 1;
            bArr[i] = 93;
        }
        this.e = this.e.j();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void e() throws IOException, JsonGenerationException {
        d("start an object");
        this.e = this.e.i();
        if (this.f416a != null) {
            this.f416a.writeStartObject(this);
            return;
        }
        if (this.p >= this.q) {
            k();
        }
        byte[] bArr = this.o;
        int i = this.p;
        this.p = i + 1;
        bArr[i] = 123;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void f() throws IOException, JsonGenerationException {
        if (!this.e.c()) {
            e("Current context not an object but " + this.e.d());
        }
        if (this.f416a != null) {
            this.f416a.writeEndObject(this, this.e.e());
        } else {
            if (this.p >= this.q) {
                k();
            }
            byte[] bArr = this.o;
            int i = this.p;
            this.p = i + 1;
            bArr[i] = 125;
        }
        this.e = this.e.j();
    }

    protected final void f(String str) throws IOException, JsonGenerationException {
        if (!a(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            h(str);
            return;
        }
        if (this.p >= this.q) {
            k();
        }
        byte[] bArr = this.o;
        int i = this.p;
        this.p = i + 1;
        bArr[i] = 34;
        int length = str.length();
        if (length <= this.t) {
            str.getChars(0, length, this.s, 0);
            if (length <= this.r) {
                if (this.p + length > this.q) {
                    k();
                }
                e(this.s, 0, length);
            } else {
                d(this.s, 0, length);
            }
        } else {
            h(str);
        }
        if (this.p >= this.q) {
            k();
        }
        byte[] bArr2 = this.o;
        int i2 = this.p;
        this.p = i2 + 1;
        bArr2[i2] = 34;
    }

    protected final void a(String str, boolean z) throws IOException, JsonGenerationException {
        if (z) {
            this.f416a.writeObjectEntrySeparator(this);
        } else {
            this.f416a.beforeObjectEntries(this);
        }
        if (a(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            if (this.p >= this.q) {
                k();
            }
            byte[] bArr = this.o;
            int i = this.p;
            this.p = i + 1;
            bArr[i] = 34;
            int length = str.length();
            if (length <= this.t) {
                str.getChars(0, length, this.s, 0);
                if (length <= this.r) {
                    if (this.p + length > this.q) {
                        k();
                    }
                    e(this.s, 0, length);
                } else {
                    d(this.s, 0, length);
                }
            } else {
                h(str);
            }
            if (this.p >= this.q) {
                k();
            }
            byte[] bArr2 = this.o;
            int i2 = this.p;
            this.p = i2 + 1;
            bArr2[i2] = 34;
            return;
        }
        h(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void b(String str) throws IOException, JsonGenerationException {
        d("write text value");
        if (str == null) {
            l();
            return;
        }
        int length = str.length();
        if (length > this.t) {
            g(str);
            return;
        }
        str.getChars(0, length, this.s, 0);
        if (length > this.r) {
            b(this.s, 0, length);
            return;
        }
        if (this.p + length >= this.q) {
            k();
        }
        byte[] bArr = this.o;
        int i = this.p;
        this.p = i + 1;
        bArr[i] = 34;
        e(this.s, 0, length);
        if (this.p >= this.q) {
            k();
        }
        byte[] bArr2 = this.o;
        int i2 = this.p;
        this.p = i2 + 1;
        bArr2[i2] = 34;
    }

    private void g(String str) throws IOException, JsonGenerationException {
        if (this.p >= this.q) {
            k();
        }
        byte[] bArr = this.o;
        int i = this.p;
        this.p = i + 1;
        bArr[i] = 34;
        h(str);
        if (this.p >= this.q) {
            k();
        }
        byte[] bArr2 = this.o;
        int i2 = this.p;
        this.p = i2 + 1;
        bArr2[i2] = 34;
    }

    private void b(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        if (this.p >= this.q) {
            k();
        }
        byte[] bArr = this.o;
        int i3 = this.p;
        this.p = i3 + 1;
        bArr[i3] = 34;
        d(this.s, 0, i2);
        if (this.p >= this.q) {
            k();
        }
        byte[] bArr2 = this.o;
        int i4 = this.p;
        this.p = i4 + 1;
        bArr2[i4] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void c(String str) throws IOException, JsonGenerationException {
        int length = str.length();
        int i = 0;
        while (length > 0) {
            char[] cArr = this.s;
            int length2 = cArr.length;
            if (length < length2) {
                length2 = length;
            }
            str.getChars(i, i + length2, cArr, 0);
            a(cArr, 0, length2);
            i += length2;
            length -= length2;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void b(com.fasterxml.jackson.core.e eVar) throws IOException, JsonGenerationException {
        byte[] asUnquotedUTF8 = eVar.asUnquotedUTF8();
        if (asUnquotedUTF8.length > 0) {
            a(asUnquotedUTF8);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void a(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        int i3 = i2 + i2 + i2;
        if (this.p + i3 > this.q) {
            if (this.q < i3) {
                c(cArr, i, i2);
                return;
            }
            k();
        }
        int i4 = i2 + i;
        int i5 = i;
        while (i5 < i4) {
            do {
                char c = cArr[i5];
                if (c <= 127) {
                    byte[] bArr = this.o;
                    int i6 = this.p;
                    this.p = i6 + 1;
                    bArr[i6] = (byte) c;
                    i5++;
                } else {
                    int i7 = i5 + 1;
                    char c2 = cArr[i5];
                    if (c2 < 2048) {
                        byte[] bArr2 = this.o;
                        int i8 = this.p;
                        this.p = i8 + 1;
                        bArr2[i8] = (byte) ((c2 >> 6) | 192);
                        byte[] bArr3 = this.o;
                        int i9 = this.p;
                        this.p = i9 + 1;
                        bArr3[i9] = (byte) ((c2 & '?') | 128);
                    } else {
                        a(c2, cArr, i7, i4);
                    }
                    i5 = i7;
                }
            } while (i5 < i4);
            return;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(char c) throws IOException, JsonGenerationException {
        if (this.p + 3 >= this.q) {
            k();
        }
        byte[] bArr = this.o;
        if (c <= 127) {
            int i = this.p;
            this.p = i + 1;
            bArr[i] = (byte) c;
        } else {
            if (c < 2048) {
                int i2 = this.p;
                this.p = i2 + 1;
                bArr[i2] = (byte) ((c >> 6) | 192);
                int i3 = this.p;
                this.p = i3 + 1;
                bArr[i3] = (byte) ((c & '?') | 128);
                return;
            }
            a(c, (char[]) null, 0, 0);
        }
    }

    private final void c(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        int i3 = this.q;
        byte[] bArr = this.o;
        int i4 = i;
        while (i4 < i2) {
            do {
                char c = cArr[i4];
                if (c < 128) {
                    if (this.p >= i3) {
                        k();
                    }
                    int i5 = this.p;
                    this.p = i5 + 1;
                    bArr[i5] = (byte) c;
                    i4++;
                } else {
                    if (this.p + 3 >= this.q) {
                        k();
                    }
                    int i6 = i4 + 1;
                    char c2 = cArr[i4];
                    if (c2 < 2048) {
                        int i7 = this.p;
                        this.p = i7 + 1;
                        bArr[i7] = (byte) ((c2 >> 6) | 192);
                        int i8 = this.p;
                        this.p = i8 + 1;
                        bArr[i8] = (byte) ((c2 & '?') | 128);
                    } else {
                        a(c2, cArr, i6, i2);
                    }
                    i4 = i6;
                }
            } while (i4 < i2);
            return;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void b(int i) throws IOException, JsonGenerationException {
        d("write number");
        if (this.p + 11 >= this.q) {
            k();
        }
        if (this.d) {
            c(i);
        } else {
            this.p = com.fasterxml.jackson.core.io.g.a(i, this.o, this.p);
        }
    }

    private void c(int i) throws IOException {
        if (this.p + 13 >= this.q) {
            k();
        }
        byte[] bArr = this.o;
        int i2 = this.p;
        this.p = i2 + 1;
        bArr[i2] = 34;
        this.p = com.fasterxml.jackson.core.io.g.a(i, this.o, this.p);
        byte[] bArr2 = this.o;
        int i3 = this.p;
        this.p = i3 + 1;
        bArr2[i3] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(long j) throws IOException, JsonGenerationException {
        d("write number");
        if (this.d) {
            b(j);
            return;
        }
        if (this.p + 21 >= this.q) {
            k();
        }
        this.p = com.fasterxml.jackson.core.io.g.a(j, this.o, this.p);
    }

    private void b(long j) throws IOException {
        if (this.p + 23 >= this.q) {
            k();
        }
        byte[] bArr = this.o;
        int i = this.p;
        this.p = i + 1;
        bArr[i] = 34;
        this.p = com.fasterxml.jackson.core.io.g.a(j, this.o, this.p);
        byte[] bArr2 = this.o;
        int i2 = this.p;
        this.p = i2 + 1;
        bArr2[i2] = 34;
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
        if (this.p >= this.q) {
            k();
        }
        byte[] bArr = this.o;
        int i = this.p;
        this.p = i + 1;
        bArr[i] = 34;
        c(obj.toString());
        if (this.p >= this.q) {
            k();
        }
        byte[] bArr2 = this.o;
        int i2 = this.p;
        this.p = i2 + 1;
        bArr2[i2] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(boolean z) throws IOException, JsonGenerationException {
        d("write boolean value");
        if (this.p + 5 >= this.q) {
            k();
        }
        byte[] bArr = z ? w : x;
        int length = bArr.length;
        System.arraycopy(bArr, 0, this.o, this.p, length);
        this.p += length;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void g() throws IOException, JsonGenerationException {
        d("write null value");
        l();
    }

    @Override // com.fasterxml.jackson.core.a.a
    protected final void d(String str) throws IOException, JsonGenerationException {
        byte b;
        int k = this.e.k();
        if (k == 5) {
            e("Can not " + str + ", expecting field name");
        }
        if (this.f416a == null) {
            switch (k) {
                case 1:
                    b = 44;
                    break;
                case 2:
                    b = 58;
                    break;
                case 3:
                    if (this.l != null) {
                        byte[] asUnquotedUTF8 = this.l.asUnquotedUTF8();
                        if (asUnquotedUTF8.length > 0) {
                            a(asUnquotedUTF8);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (this.p >= this.q) {
                k();
            }
            this.o[this.p] = b;
            this.p++;
            return;
        }
        a(str, k);
    }

    protected final void a(String str, int i) throws IOException, JsonGenerationException {
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
    public final void flush() throws IOException {
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
        byte[] bArr = this.o;
        if (bArr != null && this.u) {
            this.o = null;
            this.h.b(bArr);
        }
        char[] cArr = this.s;
        if (cArr != null) {
            this.s = null;
            this.h.b(cArr);
        }
    }

    private final void a(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.p + length > this.q) {
            k();
            if (length > 512) {
                this.n.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this.o, this.p, length);
        this.p = length + this.p;
    }

    private final void h(String str) throws IOException, JsonGenerationException {
        int length = str.length();
        char[] cArr = this.s;
        int i = length;
        int i2 = 0;
        while (i > 0) {
            int min = Math.min(this.r, i);
            str.getChars(i2, i2 + min, cArr, 0);
            if (this.p + min > this.q) {
                k();
            }
            e(cArr, 0, min);
            i2 += min;
            i -= min;
        }
    }

    private final void d(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        do {
            int min = Math.min(this.r, i2);
            if (this.p + min > this.q) {
                k();
            }
            e(cArr, i, min);
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    private final void e(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        int i3 = i2 + i;
        int i4 = this.p;
        byte[] bArr = this.o;
        int[] iArr = this.i;
        while (i < i3) {
            char c = cArr[i];
            if (c > 127 || iArr[c] != 0) {
                break;
            }
            bArr[i4] = (byte) c;
            i++;
            i4++;
        }
        this.p = i4;
        if (i < i3) {
            if (this.k != null) {
                h(cArr, i, i3);
            } else if (this.j == 0) {
                f(cArr, i, i3);
            } else {
                g(cArr, i, i3);
            }
        }
    }

    private final void f(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        if (this.p + ((i2 - i) * 6) > this.q) {
            k();
        }
        int i3 = this.p;
        byte[] bArr = this.o;
        int[] iArr = this.i;
        while (i < i2) {
            int i4 = i + 1;
            char c = cArr[i];
            if (c <= 127) {
                if (iArr[c] == 0) {
                    bArr[i3] = (byte) c;
                    i3++;
                    i = i4;
                } else {
                    int i5 = iArr[c];
                    if (i5 > 0) {
                        int i6 = i3 + 1;
                        bArr[i3] = 92;
                        i3 = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else {
                        i3 = d(c, i3);
                        i = i4;
                    }
                }
            } else {
                if (c <= 2047) {
                    int i7 = i3 + 1;
                    bArr[i3] = (byte) ((c >> 6) | 192);
                    i3 = i7 + 1;
                    bArr[i7] = (byte) ((c & '?') | 128);
                } else {
                    i3 = c(c, i3);
                }
                i = i4;
            }
        }
        this.p = i3;
    }

    private final void g(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        if (this.p + ((i2 - i) * 6) > this.q) {
            k();
        }
        int i3 = this.p;
        byte[] bArr = this.o;
        int[] iArr = this.i;
        int i4 = this.j;
        while (i < i2) {
            int i5 = i + 1;
            char c = cArr[i];
            if (c <= 127) {
                if (iArr[c] == 0) {
                    bArr[i3] = (byte) c;
                    i3++;
                    i = i5;
                } else {
                    int i6 = iArr[c];
                    if (i6 > 0) {
                        int i7 = i3 + 1;
                        bArr[i3] = 92;
                        i3 = i7 + 1;
                        bArr[i7] = (byte) i6;
                        i = i5;
                    } else {
                        i3 = d(c, i3);
                        i = i5;
                    }
                }
            } else if (c > i4) {
                i3 = d(c, i3);
                i = i5;
            } else {
                if (c <= 2047) {
                    int i8 = i3 + 1;
                    bArr[i3] = (byte) ((c >> 6) | 192);
                    i3 = i8 + 1;
                    bArr[i8] = (byte) ((c & '?') | 128);
                } else {
                    i3 = c(c, i3);
                }
                i = i5;
            }
        }
        this.p = i3;
    }

    private void h(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        if (this.p + ((i2 - i) * 6) > this.q) {
            k();
        }
        int i3 = this.p;
        byte[] bArr = this.o;
        int[] iArr = this.i;
        int i4 = this.j <= 0 ? 65535 : this.j;
        CharacterEscapes characterEscapes = this.k;
        while (i < i2) {
            int i5 = i + 1;
            char c = cArr[i];
            if (c <= 127) {
                if (iArr[c] == 0) {
                    bArr[i3] = (byte) c;
                    i3++;
                    i = i5;
                } else {
                    int i6 = iArr[c];
                    if (i6 > 0) {
                        int i7 = i3 + 1;
                        bArr[i3] = 92;
                        i3 = i7 + 1;
                        bArr[i7] = (byte) i6;
                        i = i5;
                    } else if (i6 == -2) {
                        com.fasterxml.jackson.core.e escapeSequence = characterEscapes.getEscapeSequence(c);
                        if (escapeSequence == null) {
                            e("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(c) + ", although was supposed to have one");
                        }
                        i3 = a(bArr, i3, escapeSequence, i2 - i5);
                        i = i5;
                    } else {
                        i3 = d(c, i3);
                        i = i5;
                    }
                }
            } else if (c > i4) {
                i3 = d(c, i3);
                i = i5;
            } else {
                com.fasterxml.jackson.core.e escapeSequence2 = characterEscapes.getEscapeSequence(c);
                if (escapeSequence2 != null) {
                    i3 = a(bArr, i3, escapeSequence2, i2 - i5);
                    i = i5;
                } else {
                    if (c <= 2047) {
                        int i8 = i3 + 1;
                        bArr[i3] = (byte) ((c >> 6) | 192);
                        i3 = i8 + 1;
                        bArr[i8] = (byte) ((c & '?') | 128);
                    } else {
                        i3 = c(c, i3);
                    }
                    i = i5;
                }
            }
        }
        this.p = i3;
    }

    private int a(byte[] bArr, int i, com.fasterxml.jackson.core.e eVar, int i2) throws IOException, JsonGenerationException {
        byte[] asUnquotedUTF8 = eVar.asUnquotedUTF8();
        int length = asUnquotedUTF8.length;
        if (length > 6) {
            return a(bArr, i, this.q, asUnquotedUTF8, i2);
        }
        System.arraycopy(asUnquotedUTF8, 0, bArr, i, length);
        return length + i;
    }

    private int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException, JsonGenerationException {
        int i4;
        int length = bArr2.length;
        if (i + length > i2) {
            this.p = i;
            k();
            int i5 = this.p;
            if (length > bArr.length) {
                this.n.write(bArr2, 0, length);
                return i5;
            }
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i4 = i5 + length;
        } else {
            i4 = i;
        }
        if ((i3 * 6) + i4 > i2) {
            k();
            return this.p;
        }
        return i4;
    }

    private int a(int i, char[] cArr, int i2, int i3) throws IOException {
        if (i >= 55296 && i <= 57343) {
            if (i2 >= i3) {
                e("Split surrogate on writeRaw() input (last character)");
            }
            a(i, cArr[i2]);
            return i2 + 1;
        }
        byte[] bArr = this.o;
        int i4 = this.p;
        this.p = i4 + 1;
        bArr[i4] = (byte) ((i >> 12) | 224);
        int i5 = this.p;
        this.p = i5 + 1;
        bArr[i5] = (byte) (((i >> 6) & 63) | 128);
        int i6 = this.p;
        this.p = i6 + 1;
        bArr[i6] = (byte) ((i & 63) | 128);
        return i2;
    }

    protected final void a(int i, int i2) throws IOException {
        int b = b(i, i2);
        if (this.p + 4 > this.q) {
            k();
        }
        byte[] bArr = this.o;
        int i3 = this.p;
        this.p = i3 + 1;
        bArr[i3] = (byte) ((b >> 18) | 240);
        int i4 = this.p;
        this.p = i4 + 1;
        bArr[i4] = (byte) (((b >> 12) & 63) | 128);
        int i5 = this.p;
        this.p = i5 + 1;
        bArr[i5] = (byte) (((b >> 6) & 63) | 128);
        int i6 = this.p;
        this.p = i6 + 1;
        bArr[i6] = (byte) ((b & 63) | 128);
    }

    private int c(int i, int i2) throws IOException {
        byte[] bArr = this.o;
        if (i >= 55296 && i <= 57343) {
            int i3 = i2 + 1;
            bArr[i2] = 92;
            int i4 = i3 + 1;
            bArr[i3] = 117;
            int i5 = i4 + 1;
            bArr[i4] = m[(i >> 12) & 15];
            int i6 = i5 + 1;
            bArr[i5] = m[(i >> 8) & 15];
            int i7 = i6 + 1;
            bArr[i6] = m[(i >> 4) & 15];
            int i8 = i7 + 1;
            bArr[i7] = m[i & 15];
            return i8;
        }
        int i9 = i2 + 1;
        bArr[i2] = (byte) ((i >> 12) | 224);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (((i >> 6) & 63) | 128);
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((i & 63) | 128);
        return i11;
    }

    protected final int b(int i, int i2) throws IOException {
        if (i2 < 56320 || i2 > 57343) {
            e("Incomplete surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2));
        }
        return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + ((i - 55296) << 10) + (i2 - 56320);
    }

    private void l() throws IOException {
        if (this.p + 4 >= this.q) {
            k();
        }
        System.arraycopy(v, 0, this.o, this.p, 4);
        this.p += 4;
    }

    private int d(int i, int i2) throws IOException {
        int i3;
        byte[] bArr = this.o;
        int i4 = i2 + 1;
        bArr[i2] = 92;
        int i5 = i4 + 1;
        bArr[i4] = 117;
        if (i > 255) {
            int i6 = (i >> 8) & 255;
            int i7 = i5 + 1;
            bArr[i5] = m[i6 >> 4];
            i3 = i7 + 1;
            bArr[i7] = m[i6 & 15];
            i &= 255;
        } else {
            int i8 = i5 + 1;
            bArr[i5] = 48;
            i3 = i8 + 1;
            bArr[i8] = 48;
        }
        int i9 = i3 + 1;
        bArr[i3] = m[i >> 4];
        int i10 = i9 + 1;
        bArr[i9] = m[i & 15];
        return i10;
    }

    protected final void k() throws IOException {
        int i = this.p;
        if (i > 0) {
            this.p = 0;
            this.n.write(this.o, 0, i);
        }
    }
}
