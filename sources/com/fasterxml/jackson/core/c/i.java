package com.fasterxml.jackson.core.c;

import android.support.v4.internal.view.SupportMenu;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: UTF8JsonGenerator.java */
/* loaded from: classes.dex */
public class i extends c {
    private static final byte[] o = com.fasterxml.jackson.core.io.a.a();
    private static final byte[] p = {110, 117, 108, 108};
    private static final byte[] q = {116, 114, 117, 101};
    private static final byte[] r = {102, 97, 108, 115, 101};
    protected boolean A;
    protected final OutputStream s;
    protected byte t;
    protected byte[] u;
    protected int v;
    protected final int w;
    protected final int x;
    protected char[] y;
    protected final int z;

    public i(com.fasterxml.jackson.core.io.c cVar, int i, com.fasterxml.jackson.core.c cVar2, OutputStream outputStream) {
        super(cVar, i, cVar2);
        this.t = (byte) 34;
        this.s = outputStream;
        this.A = true;
        this.u = cVar.d();
        this.w = this.u.length;
        this.x = this.w >> 3;
        this.y = cVar.a();
        this.z = this.y.length;
        if (a(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            b(127);
        }
    }

    private final void L() throws IOException {
        if (this.v + 4 >= this.w) {
            z();
        }
        System.arraycopy(p, 0, this.u, this.v, 4);
        this.v += 4;
    }

    private final void b(char[] cArr, int i, int i2) throws IOException {
        if (this.v + ((i2 - i) * 6) > this.w) {
            z();
        }
        int i3 = this.v;
        byte[] bArr = this.u;
        int[] iArr = this.j;
        int i4 = this.k;
        if (i4 <= 0) {
            i4 = SupportMenu.USER_MASK;
        }
        CharacterEscapes characterEscapes = this.l;
        while (i < i2) {
            int i5 = i + 1;
            char c2 = cArr[i];
            if (c2 <= 127) {
                if (iArr[c2] == 0) {
                    bArr[i3] = (byte) c2;
                    i = i5;
                    i3++;
                } else {
                    int i6 = iArr[c2];
                    if (i6 > 0) {
                        int i7 = i3 + 1;
                        bArr[i3] = 92;
                        i3 = i7 + 1;
                        bArr[i7] = (byte) i6;
                    } else if (i6 == -2) {
                        com.fasterxml.jackson.core.e escapeSequence = characterEscapes.getEscapeSequence(c2);
                        if (escapeSequence != null) {
                            i3 = a(bArr, i3, escapeSequence, i2 - i5);
                        } else {
                            e("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(c2) + ", although was supposed to have one");
                            throw null;
                        }
                    } else {
                        i3 = d(c2, i3);
                    }
                }
            } else if (c2 > i4) {
                i3 = d(c2, i3);
            } else {
                com.fasterxml.jackson.core.e escapeSequence2 = characterEscapes.getEscapeSequence(c2);
                if (escapeSequence2 != null) {
                    i3 = a(bArr, i3, escapeSequence2, i2 - i5);
                } else if (c2 <= 2047) {
                    int i8 = i3 + 1;
                    bArr[i3] = (byte) ((c2 >> 6) | 192);
                    i3 = i8 + 1;
                    bArr[i8] = (byte) ((c2 & '?') | 128);
                } else {
                    i3 = c(c2, i3);
                }
            }
            i = i5;
        }
        this.v = i3;
    }

    private void c(char[] cArr, int i, int i2) throws IOException {
        while (i < i2) {
            do {
                char c2 = cArr[i];
                if (c2 > 127) {
                    int i3 = i + 1;
                    char c3 = cArr[i];
                    if (c3 < 2048) {
                        byte[] bArr = this.u;
                        int i4 = this.v;
                        this.v = i4 + 1;
                        bArr[i4] = (byte) ((c3 >> 6) | 192);
                        int i5 = this.v;
                        this.v = i5 + 1;
                        bArr[i5] = (byte) ((c3 & '?') | 128);
                        i = i3;
                    } else {
                        i = a(c3, cArr, i3, i2);
                    }
                } else {
                    byte[] bArr2 = this.u;
                    int i6 = this.v;
                    this.v = i6 + 1;
                    bArr2[i6] = (byte) c2;
                    i++;
                }
            } while (i < i2);
            return;
        }
    }

    private final void d(char[] cArr, int i, int i2) throws IOException {
        int i3 = this.w;
        byte[] bArr = this.u;
        int i4 = i2 + i;
        while (i < i4) {
            do {
                char c2 = cArr[i];
                if (c2 >= 128) {
                    if (this.v + 3 >= this.w) {
                        z();
                    }
                    int i5 = i + 1;
                    char c3 = cArr[i];
                    if (c3 < 2048) {
                        int i6 = this.v;
                        this.v = i6 + 1;
                        bArr[i6] = (byte) ((c3 >> 6) | 192);
                        int i7 = this.v;
                        this.v = i7 + 1;
                        bArr[i7] = (byte) ((c3 & '?') | 128);
                        i = i5;
                    } else {
                        i = a(c3, cArr, i5, i4);
                    }
                } else {
                    if (this.v >= i3) {
                        z();
                    }
                    int i8 = this.v;
                    this.v = i8 + 1;
                    bArr[i8] = (byte) c2;
                    i++;
                }
            } while (i < i4);
            return;
        }
    }

    private final void e(char[] cArr, int i, int i2) throws IOException {
        int i3 = i2 + i;
        int i4 = this.v;
        byte[] bArr = this.u;
        int[] iArr = this.j;
        while (i < i3) {
            char c2 = cArr[i];
            if (c2 > 127 || iArr[c2] != 0) {
                break;
            }
            bArr[i4] = (byte) c2;
            i++;
            i4++;
        }
        this.v = i4;
        if (i < i3) {
            if (this.l != null) {
                b(cArr, i, i3);
            } else if (this.k == 0) {
                f(cArr, i, i3);
            } else {
                g(cArr, i, i3);
            }
        }
    }

    private final void l(String str) throws IOException {
        if (this.v >= this.w) {
            z();
        }
        byte[] bArr = this.u;
        int i = this.v;
        this.v = i + 1;
        bArr[i] = this.t;
        g(str);
        if (this.v >= this.w) {
            z();
        }
        byte[] bArr2 = this.u;
        int i2 = this.v;
        this.v = i2 + 1;
        bArr2[i2] = this.t;
    }

    protected void A() {
        byte[] bArr = this.u;
        if (bArr != null && this.A) {
            this.u = null;
            this.i.b(bArr);
        }
        char[] cArr = this.y;
        if (cArr != null) {
            this.y = null;
            this.i.a(cArr);
        }
    }

    public void a(String str, int i, int i2) throws IOException {
        char c2;
        char[] cArr = this.y;
        int length = cArr.length;
        if (i2 <= length) {
            str.getChars(i, i + i2, cArr, 0);
            a(cArr, 0, i2);
            return;
        }
        int i3 = this.w;
        int min = Math.min(length, (i3 >> 2) + (i3 >> 4));
        int i4 = min * 3;
        while (i2 > 0) {
            int min2 = Math.min(min, i2);
            str.getChars(i, i + min2, cArr, 0);
            if (this.v + i4 > this.w) {
                z();
            }
            if (min2 > 1 && (c2 = cArr[min2 - 1]) >= 55296 && c2 <= 56319) {
                min2--;
            }
            c(cArr, 0, min2);
            i += min2;
            i2 -= min2;
        }
    }

    @Override // com.fasterxml.jackson.core.b.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.u != null && a(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
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
        this.v = 0;
        if (this.s != null) {
            if (!this.i.h() && !a(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                if (a(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                    this.s.flush();
                }
            } else {
                this.s.close();
            }
        }
        A();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void f(String str) throws IOException {
        if (this.f9671a != null) {
            k(str);
            return;
        }
        int a2 = this.f9681f.a(str);
        if (a2 != 4) {
            if (a2 == 1) {
                if (this.v >= this.w) {
                    z();
                }
                byte[] bArr = this.u;
                int i = this.v;
                this.v = i + 1;
                bArr[i] = 44;
            }
            if (this.n) {
                a(str, false);
                return;
            }
            int length = str.length();
            if (length > this.z) {
                a(str, true);
                return;
            }
            if (this.v >= this.w) {
                z();
            }
            byte[] bArr2 = this.u;
            int i2 = this.v;
            this.v = i2 + 1;
            bArr2[i2] = this.t;
            if (length <= this.x) {
                if (this.v + length > this.w) {
                    z();
                }
                c(str, 0, length);
            } else {
                f(str, 0, length);
            }
            if (this.v >= this.w) {
                z();
            }
            byte[] bArr3 = this.u;
            int i3 = this.v;
            this.v = i3 + 1;
            bArr3[i3] = this.t;
            return;
        }
        e("Can not write a field name, expecting a value");
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
        z();
        if (this.s == null || !a(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        this.s.flush();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void g(String str) throws IOException {
        int length = str.length();
        char[] cArr = this.y;
        if (length <= cArr.length) {
            str.getChars(0, length, cArr, 0);
            a(cArr, 0, length);
        } else {
            a(str, 0, length);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void h(String str) throws IOException {
        j("write a string");
        if (str == null) {
            L();
            return;
        }
        int length = str.length();
        if (length > this.x) {
            a(str, true);
            return;
        }
        if (this.v + length >= this.w) {
            z();
        }
        byte[] bArr = this.u;
        int i = this.v;
        this.v = i + 1;
        bArr[i] = this.t;
        c(str, 0, length);
        if (this.v >= this.w) {
            z();
        }
        byte[] bArr2 = this.u;
        int i2 = this.v;
        this.v = i2 + 1;
        bArr2[i2] = this.t;
    }

    protected final void j(String str) throws IOException {
        byte b2;
        int k = this.f9681f.k();
        if (this.f9671a != null) {
            a(str, k);
            return;
        }
        if (k == 1) {
            b2 = 44;
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
                    byte[] asUnquotedUTF8 = eVar.asUnquotedUTF8();
                    if (asUnquotedUTF8.length > 0) {
                        a(asUnquotedUTF8);
                        return;
                    }
                    return;
                }
                return;
            }
            b2 = 58;
        }
        if (this.v >= this.w) {
            z();
        }
        byte[] bArr = this.u;
        int i = this.v;
        this.v = i + 1;
        bArr[i] = b2;
    }

    protected final void k(String str) throws IOException {
        int a2 = this.f9681f.a(str);
        if (a2 != 4) {
            if (a2 == 1) {
                this.f9671a.writeObjectEntrySeparator(this);
            } else {
                this.f9671a.beforeObjectEntries(this);
            }
            if (this.n) {
                a(str, false);
                return;
            }
            int length = str.length();
            if (length > this.z) {
                a(str, true);
                return;
            }
            if (this.v >= this.w) {
                z();
            }
            byte[] bArr = this.u;
            int i = this.v;
            this.v = i + 1;
            bArr[i] = this.t;
            str.getChars(0, length, this.y, 0);
            if (length <= this.x) {
                if (this.v + length > this.w) {
                    z();
                }
                e(this.y, 0, length);
            } else {
                h(this.y, 0, length);
            }
            if (this.v >= this.w) {
                z();
            }
            byte[] bArr2 = this.u;
            int i2 = this.v;
            this.v = i2 + 1;
            bArr2[i2] = this.t;
            return;
        }
        e("Can not write a field name, expecting a value");
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void r() throws IOException {
        if (this.f9681f.d()) {
            com.fasterxml.jackson.core.d dVar = this.f9671a;
            if (dVar != null) {
                dVar.writeEndArray(this, this.f9681f.c());
            } else {
                if (this.v >= this.w) {
                    z();
                }
                byte[] bArr = this.u;
                int i = this.v;
                this.v = i + 1;
                bArr[i] = 93;
            }
            this.f9681f = this.f9681f.h();
            return;
        }
        e("Current context not Array but " + this.f9681f.g());
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void s() throws IOException {
        if (this.f9681f.e()) {
            com.fasterxml.jackson.core.d dVar = this.f9671a;
            if (dVar != null) {
                dVar.writeEndObject(this, this.f9681f.c());
            } else {
                if (this.v >= this.w) {
                    z();
                }
                byte[] bArr = this.u;
                int i = this.v;
                this.v = i + 1;
                bArr[i] = 125;
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
        L();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void v() throws IOException {
        j("start an array");
        this.f9681f = this.f9681f.i();
        com.fasterxml.jackson.core.d dVar = this.f9671a;
        if (dVar != null) {
            dVar.writeStartArray(this);
            return;
        }
        if (this.v >= this.w) {
            z();
        }
        byte[] bArr = this.u;
        int i = this.v;
        this.v = i + 1;
        bArr[i] = 91;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void w() throws IOException {
        j("start an object");
        this.f9681f = this.f9681f.j();
        com.fasterxml.jackson.core.d dVar = this.f9671a;
        if (dVar != null) {
            dVar.writeStartObject(this);
            return;
        }
        if (this.v >= this.w) {
            z();
        }
        byte[] bArr = this.u;
        int i = this.v;
        this.v = i + 1;
        bArr[i] = 123;
    }

    protected final void z() throws IOException {
        int i = this.v;
        if (i > 0) {
            this.v = 0;
            this.s.write(this.u, 0, i);
        }
    }

    private final void c(int i) throws IOException {
        if (this.v + 13 >= this.w) {
            z();
        }
        byte[] bArr = this.u;
        int i2 = this.v;
        this.v = i2 + 1;
        bArr[i2] = this.t;
        this.v = com.fasterxml.jackson.core.io.g.a(i, bArr, this.v);
        byte[] bArr2 = this.u;
        int i3 = this.v;
        this.v = i3 + 1;
        bArr2[i3] = this.t;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void g(long j) throws IOException {
        j("write a number");
        if (this.f9680e) {
            h(j);
            return;
        }
        if (this.v + 21 >= this.w) {
            z();
        }
        this.v = com.fasterxml.jackson.core.io.g.a(j, this.u, this.v);
    }

    private final void c(String str, int i, int i2) throws IOException {
        int i3 = i2 + i;
        int i4 = this.v;
        byte[] bArr = this.u;
        int[] iArr = this.j;
        while (i < i3) {
            char charAt = str.charAt(i);
            if (charAt > 127 || iArr[charAt] != 0) {
                break;
            }
            bArr[i4] = (byte) charAt;
            i++;
            i4++;
        }
        this.v = i4;
        if (i < i3) {
            if (this.l != null) {
                b(str, i, i3);
            } else if (this.k == 0) {
                d(str, i, i3);
            } else {
                e(str, i, i3);
            }
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(com.fasterxml.jackson.core.e eVar) throws IOException {
        byte[] asUnquotedUTF8 = eVar.asUnquotedUTF8();
        if (asUnquotedUTF8.length > 0) {
            a(asUnquotedUTF8);
        }
    }

    private final void d(String str, int i, int i2) throws IOException {
        if (this.v + ((i2 - i) * 6) > this.w) {
            z();
        }
        int i3 = this.v;
        byte[] bArr = this.u;
        int[] iArr = this.j;
        while (i < i2) {
            int i4 = i + 1;
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                if (iArr[charAt] == 0) {
                    bArr[i3] = (byte) charAt;
                    i = i4;
                    i3++;
                } else {
                    int i5 = iArr[charAt];
                    if (i5 > 0) {
                        int i6 = i3 + 1;
                        bArr[i3] = 92;
                        i3 = i6 + 1;
                        bArr[i6] = (byte) i5;
                    } else {
                        i3 = d(charAt, i3);
                    }
                }
            } else if (charAt <= 2047) {
                int i7 = i3 + 1;
                bArr[i3] = (byte) ((charAt >> 6) | 192);
                i3 = i7 + 1;
                bArr[i7] = (byte) ((charAt & '?') | 128);
            } else {
                i3 = c(charAt, i3);
            }
            i = i4;
        }
        this.v = i3;
    }

    private final void e(String str, int i, int i2) throws IOException {
        if (this.v + ((i2 - i) * 6) > this.w) {
            z();
        }
        int i3 = this.v;
        byte[] bArr = this.u;
        int[] iArr = this.j;
        int i4 = this.k;
        while (i < i2) {
            int i5 = i + 1;
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                if (iArr[charAt] == 0) {
                    bArr[i3] = (byte) charAt;
                    i = i5;
                    i3++;
                } else {
                    int i6 = iArr[charAt];
                    if (i6 > 0) {
                        int i7 = i3 + 1;
                        bArr[i3] = 92;
                        i3 = i7 + 1;
                        bArr[i7] = (byte) i6;
                    } else {
                        i3 = d(charAt, i3);
                    }
                }
            } else if (charAt > i4) {
                i3 = d(charAt, i3);
            } else if (charAt <= 2047) {
                int i8 = i3 + 1;
                bArr[i3] = (byte) ((charAt >> 6) | 192);
                i3 = i8 + 1;
                bArr[i8] = (byte) ((charAt & '?') | 128);
            } else {
                i3 = c(charAt, i3);
            }
            i = i5;
        }
        this.v = i3;
    }

    private final void g(char[] cArr, int i, int i2) throws IOException {
        if (this.v + ((i2 - i) * 6) > this.w) {
            z();
        }
        int i3 = this.v;
        byte[] bArr = this.u;
        int[] iArr = this.j;
        int i4 = this.k;
        while (i < i2) {
            int i5 = i + 1;
            char c2 = cArr[i];
            if (c2 <= 127) {
                if (iArr[c2] == 0) {
                    bArr[i3] = (byte) c2;
                    i = i5;
                    i3++;
                } else {
                    int i6 = iArr[c2];
                    if (i6 > 0) {
                        int i7 = i3 + 1;
                        bArr[i3] = 92;
                        i3 = i7 + 1;
                        bArr[i7] = (byte) i6;
                    } else {
                        i3 = d(c2, i3);
                    }
                }
            } else if (c2 > i4) {
                i3 = d(c2, i3);
            } else if (c2 <= 2047) {
                int i8 = i3 + 1;
                bArr[i3] = (byte) ((c2 >> 6) | 192);
                i3 = i8 + 1;
                bArr[i8] = (byte) ((c2 & '?') | 128);
            } else {
                i3 = c(c2, i3);
            }
            i = i5;
        }
        this.v = i3;
    }

    private final void h(long j) throws IOException {
        if (this.v + 23 >= this.w) {
            z();
        }
        byte[] bArr = this.u;
        int i = this.v;
        this.v = i + 1;
        bArr[i] = this.t;
        this.v = com.fasterxml.jackson.core.io.g.a(j, bArr, this.v);
        byte[] bArr2 = this.u;
        int i2 = this.v;
        this.v = i2 + 1;
        bArr2[i2] = this.t;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void a(char[] cArr, int i, int i2) throws IOException {
        int i3 = i2 + i2 + i2;
        int i4 = this.v + i3;
        int i5 = this.w;
        if (i4 > i5) {
            if (i5 < i3) {
                d(cArr, i, i2);
                return;
            }
            z();
        }
        int i6 = i2 + i;
        while (i < i6) {
            do {
                char c2 = cArr[i];
                if (c2 > 127) {
                    int i7 = i + 1;
                    char c3 = cArr[i];
                    if (c3 < 2048) {
                        byte[] bArr = this.u;
                        int i8 = this.v;
                        this.v = i8 + 1;
                        bArr[i8] = (byte) ((c3 >> 6) | 192);
                        int i9 = this.v;
                        this.v = i9 + 1;
                        bArr[i9] = (byte) ((c3 & '?') | 128);
                        i = i7;
                    } else {
                        i = a(c3, cArr, i7, i6);
                    }
                } else {
                    byte[] bArr2 = this.u;
                    int i10 = this.v;
                    this.v = i10 + 1;
                    bArr2[i10] = (byte) c2;
                    i++;
                }
            } while (i < i6);
            return;
        }
    }

    private final void h(char[] cArr, int i, int i2) throws IOException {
        do {
            int min = Math.min(this.x, i2);
            if (this.v + min > this.w) {
                z();
            }
            e(cArr, i, min);
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    private final int c(int i, int i2) throws IOException {
        byte[] bArr = this.u;
        if (i >= 55296 && i <= 57343) {
            int i3 = i2 + 1;
            bArr[i2] = 92;
            int i4 = i3 + 1;
            bArr[i3] = 117;
            int i5 = i4 + 1;
            byte[] bArr2 = o;
            bArr[i4] = bArr2[(i >> 12) & 15];
            int i6 = i5 + 1;
            bArr[i5] = bArr2[(i >> 8) & 15];
            int i7 = i6 + 1;
            bArr[i6] = bArr2[(i >> 4) & 15];
            int i8 = i7 + 1;
            bArr[i7] = bArr2[i & 15];
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

    private final void f(String str, int i, int i2) throws IOException {
        do {
            int min = Math.min(this.x, i2);
            if (this.v + min > this.w) {
                z();
            }
            c(str, i, min);
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(char c2) throws IOException {
        if (this.v + 3 >= this.w) {
            z();
        }
        byte[] bArr = this.u;
        if (c2 <= 127) {
            int i = this.v;
            this.v = i + 1;
            bArr[i] = (byte) c2;
        } else {
            if (c2 < 2048) {
                int i2 = this.v;
                this.v = i2 + 1;
                bArr[i2] = (byte) ((c2 >> 6) | 192);
                int i3 = this.v;
                this.v = i3 + 1;
                bArr[i3] = (byte) ((c2 & '?') | 128);
                return;
            }
            a(c2, (char[]) null, 0, 0);
        }
    }

    private final void b(String str, int i, int i2) throws IOException {
        if (this.v + ((i2 - i) * 6) > this.w) {
            z();
        }
        int i3 = this.v;
        byte[] bArr = this.u;
        int[] iArr = this.j;
        int i4 = this.k;
        if (i4 <= 0) {
            i4 = SupportMenu.USER_MASK;
        }
        CharacterEscapes characterEscapes = this.l;
        while (i < i2) {
            int i5 = i + 1;
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                if (iArr[charAt] == 0) {
                    bArr[i3] = (byte) charAt;
                    i = i5;
                    i3++;
                } else {
                    int i6 = iArr[charAt];
                    if (i6 > 0) {
                        int i7 = i3 + 1;
                        bArr[i3] = 92;
                        i3 = i7 + 1;
                        bArr[i7] = (byte) i6;
                    } else if (i6 == -2) {
                        com.fasterxml.jackson.core.e escapeSequence = characterEscapes.getEscapeSequence(charAt);
                        if (escapeSequence != null) {
                            i3 = a(bArr, i3, escapeSequence, i2 - i5);
                        } else {
                            e("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(charAt) + ", although was supposed to have one");
                            throw null;
                        }
                    } else {
                        i3 = d(charAt, i3);
                    }
                }
            } else if (charAt > i4) {
                i3 = d(charAt, i3);
            } else {
                com.fasterxml.jackson.core.e escapeSequence2 = characterEscapes.getEscapeSequence(charAt);
                if (escapeSequence2 != null) {
                    i3 = a(bArr, i3, escapeSequence2, i2 - i5);
                } else if (charAt <= 2047) {
                    int i8 = i3 + 1;
                    bArr[i3] = (byte) ((charAt >> 6) | 192);
                    i3 = i8 + 1;
                    bArr[i8] = (byte) ((charAt & '?') | 128);
                } else {
                    i3 = c(charAt, i3);
                }
            }
            i = i5;
        }
        this.v = i3;
    }

    private final void f(char[] cArr, int i, int i2) throws IOException {
        if (this.v + ((i2 - i) * 6) > this.w) {
            z();
        }
        int i3 = this.v;
        byte[] bArr = this.u;
        int[] iArr = this.j;
        while (i < i2) {
            int i4 = i + 1;
            char c2 = cArr[i];
            if (c2 <= 127) {
                if (iArr[c2] == 0) {
                    bArr[i3] = (byte) c2;
                    i = i4;
                    i3++;
                } else {
                    int i5 = iArr[c2];
                    if (i5 > 0) {
                        int i6 = i3 + 1;
                        bArr[i3] = 92;
                        i3 = i6 + 1;
                        bArr[i6] = (byte) i5;
                    } else {
                        i3 = d(c2, i3);
                    }
                }
            } else if (c2 <= 2047) {
                int i7 = i3 + 1;
                bArr[i3] = (byte) ((c2 >> 6) | 192);
                i3 = i7 + 1;
                bArr[i7] = (byte) ((c2 & '?') | 128);
            } else {
                i3 = c(c2, i3);
            }
            i = i4;
        }
        this.v = i3;
    }

    private int d(int i, int i2) throws IOException {
        int i3;
        byte[] bArr = this.u;
        int i4 = i2 + 1;
        bArr[i2] = 92;
        int i5 = i4 + 1;
        bArr[i4] = 117;
        if (i > 255) {
            int i6 = 255 & (i >> 8);
            int i7 = i5 + 1;
            byte[] bArr2 = o;
            bArr[i5] = bArr2[i6 >> 4];
            i3 = i7 + 1;
            bArr[i7] = bArr2[i6 & 15];
            i &= 255;
        } else {
            int i8 = i5 + 1;
            bArr[i5] = 48;
            i3 = i8 + 1;
            bArr[i8] = 48;
        }
        int i9 = i3 + 1;
        byte[] bArr3 = o;
        bArr[i3] = bArr3[i >> 4];
        int i10 = i9 + 1;
        bArr[i9] = bArr3[i & 15];
        return i10;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(int i) throws IOException {
        j("write a number");
        if (this.v + 11 >= this.w) {
            z();
        }
        if (this.f9680e) {
            c(i);
        } else {
            this.v = com.fasterxml.jackson.core.io.g.a(i, this.u, this.v);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(BigInteger bigInteger) throws IOException {
        j("write a number");
        if (bigInteger == null) {
            L();
        } else if (this.f9680e) {
            l(bigInteger.toString());
        } else {
            g(bigInteger.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(double d2) throws IOException {
        if (!this.f9680e && ((!Double.isNaN(d2) && !Double.isInfinite(d2)) || !JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS.enabledIn(this.f9679d))) {
            j("write a number");
            g(String.valueOf(d2));
        } else {
            h(String.valueOf(d2));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(float f2) throws IOException {
        if (!this.f9680e && ((!Float.isNaN(f2) && !Float.isInfinite(f2)) || !JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS.enabledIn(this.f9679d))) {
            j("write a number");
            g(String.valueOf(f2));
        } else {
            h(String.valueOf(f2));
        }
    }

    protected final void b(int i, int i2) throws IOException {
        int a2 = a(i, i2);
        if (this.v + 4 > this.w) {
            z();
        }
        byte[] bArr = this.u;
        int i3 = this.v;
        this.v = i3 + 1;
        bArr[i3] = (byte) ((a2 >> 18) | 240);
        int i4 = this.v;
        this.v = i4 + 1;
        bArr[i4] = (byte) (((a2 >> 12) & 63) | 128);
        int i5 = this.v;
        this.v = i5 + 1;
        bArr[i5] = (byte) (((a2 >> 6) & 63) | 128);
        int i6 = this.v;
        this.v = i6 + 1;
        bArr[i6] = (byte) ((a2 & 63) | 128);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(BigDecimal bigDecimal) throws IOException {
        j("write a number");
        if (bigDecimal == null) {
            L();
        } else if (this.f9680e) {
            l(b(bigDecimal));
        } else {
            g(b(bigDecimal));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void a(boolean z) throws IOException {
        j("write a boolean value");
        if (this.v + 5 >= this.w) {
            z();
        }
        byte[] bArr = z ? q : r;
        int length = bArr.length;
        System.arraycopy(bArr, 0, this.u, this.v, length);
        this.v += length;
    }

    private final void a(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.v + length > this.w) {
            z();
            if (length > 512) {
                this.s.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this.u, this.v, length);
        this.v += length;
    }

    private final void a(String str, boolean z) throws IOException {
        if (z) {
            if (this.v >= this.w) {
                z();
            }
            byte[] bArr = this.u;
            int i = this.v;
            this.v = i + 1;
            bArr[i] = this.t;
        }
        int length = str.length();
        int i2 = 0;
        while (length > 0) {
            int min = Math.min(this.x, length);
            if (this.v + min > this.w) {
                z();
            }
            c(str, i2, min);
            i2 += min;
            length -= min;
        }
        if (z) {
            if (this.v >= this.w) {
                z();
            }
            byte[] bArr2 = this.u;
            int i3 = this.v;
            this.v = i3 + 1;
            bArr2[i3] = this.t;
        }
    }

    private final int a(byte[] bArr, int i, com.fasterxml.jackson.core.e eVar, int i2) throws IOException, JsonGenerationException {
        byte[] asUnquotedUTF8 = eVar.asUnquotedUTF8();
        int length = asUnquotedUTF8.length;
        if (length > 6) {
            return a(bArr, i, this.w, asUnquotedUTF8, i2);
        }
        System.arraycopy(asUnquotedUTF8, 0, bArr, i, length);
        return i + length;
    }

    private final int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException, JsonGenerationException {
        int length = bArr2.length;
        if (i + length > i2) {
            this.v = i;
            z();
            int i4 = this.v;
            if (length > bArr.length) {
                this.s.write(bArr2, 0, length);
                return i4;
            }
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i = i4 + length;
        }
        if ((i3 * 6) + i <= i2) {
            return i;
        }
        z();
        return this.v;
    }

    private final int a(int i, char[] cArr, int i2, int i3) throws IOException {
        if (i >= 55296 && i <= 57343) {
            if (i2 >= i3 || cArr == null) {
                e(String.format("Split surrogate on writeRaw() input (last character): first character 0x%4x", Integer.valueOf(i)));
                throw null;
            }
            b(i, cArr[i2]);
            return i2 + 1;
        }
        byte[] bArr = this.u;
        int i4 = this.v;
        this.v = i4 + 1;
        bArr[i4] = (byte) ((i >> 12) | 224);
        int i5 = this.v;
        this.v = i5 + 1;
        bArr[i5] = (byte) (((i >> 6) & 63) | 128);
        int i6 = this.v;
        this.v = i6 + 1;
        bArr[i6] = (byte) ((i & 63) | 128);
        return i2;
    }
}
