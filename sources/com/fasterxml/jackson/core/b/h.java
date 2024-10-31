package com.fasterxml.jackson.core.b;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: UTF8StreamJsonParser.java */
/* loaded from: classes.dex */
public final class h extends com.fasterxml.jackson.core.a.b {
    private static final int[] S = com.fasterxml.jackson.core.io.b.b();
    private static final int[] T = com.fasterxml.jackson.core.io.b.a();
    protected com.fasterxml.jackson.core.c L;
    protected final com.fasterxml.jackson.core.c.a M;
    protected int[] N;
    protected boolean O;
    protected InputStream P;
    protected byte[] Q;
    protected boolean R;
    private int U;

    public h(com.fasterxml.jackson.core.io.c cVar, int i, InputStream inputStream, com.fasterxml.jackson.core.c cVar2, com.fasterxml.jackson.core.c.a aVar, byte[] bArr, int i2, int i3, boolean z) {
        super(cVar, i);
        this.N = new int[16];
        this.O = false;
        this.P = inputStream;
        this.L = cVar2;
        this.M = aVar;
        this.Q = bArr;
        this.d = i2;
        this.e = i3;
        this.R = z;
    }

    @Override // com.fasterxml.jackson.core.a.b
    protected boolean p() throws IOException {
        this.f += this.e;
        this.h -= this.e;
        if (this.P == null) {
            return false;
        }
        int read = this.P.read(this.Q, 0, this.Q.length);
        if (read > 0) {
            this.d = 0;
            this.e = read;
            return true;
        }
        r();
        if (read == 0) {
            throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.Q.length + " bytes");
        }
        return false;
    }

    @Override // com.fasterxml.jackson.core.a.b
    protected void r() throws IOException {
        if (this.P != null) {
            if (this.b.c() || a(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this.P.close();
            }
            this.P = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.a.b
    public void s() throws IOException {
        byte[] bArr;
        super.s();
        if (this.R && (bArr = this.Q) != null) {
            this.Q = null;
            this.b.a(bArr);
        }
    }

    @Override // com.fasterxml.jackson.core.a.c, com.fasterxml.jackson.core.JsonParser
    public String f() throws IOException, JsonParseException {
        if (this.K != JsonToken.VALUE_STRING) {
            return a(this.K);
        }
        if (this.O) {
            this.O = false;
            q();
        }
        return this.n.f();
    }

    protected String a(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (jsonToken) {
            case FIELD_NAME:
                return this.l.h();
            case VALUE_STRING:
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                return this.n.f();
            default:
                return jsonToken.asString();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fasterxml.jackson.core.a.c, com.fasterxml.jackson.core.JsonParser
    public JsonToken a() throws IOException, JsonParseException {
        JsonToken d;
        this.A = 0;
        if (this.K == JsonToken.FIELD_NAME) {
            return L();
        }
        if (this.O) {
            H();
        }
        int O = O();
        if (O < 0) {
            close();
            this.K = null;
            return null;
        }
        this.i = (this.f + this.d) - 1;
        this.j = this.g;
        this.k = (this.d - this.h) - 1;
        this.r = null;
        if (O == 93) {
            if (!this.l.a()) {
                a(O, '}');
            }
            this.l = this.l.i();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            this.K = jsonToken;
            return jsonToken;
        }
        if (O == 125) {
            if (!this.l.c()) {
                a(O, ']');
            }
            this.l = this.l.i();
            JsonToken jsonToken2 = JsonToken.END_OBJECT;
            this.K = jsonToken2;
            return jsonToken2;
        }
        if (this.l.j()) {
            if (O != 44) {
                b(O, "was expecting comma to separate " + this.l.d() + " entries");
            }
            O = N();
        }
        if (!this.l.c()) {
            return m(O);
        }
        this.l.a(e(O).a());
        this.K = JsonToken.FIELD_NAME;
        int N = N();
        if (N != 58) {
            b(N, "was expecting a colon to separate field name and value");
        }
        int N2 = N();
        if (N2 == 34) {
            this.O = true;
            this.m = JsonToken.VALUE_STRING;
            return this.K;
        }
        switch (N2) {
            case 45:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                d = d(N2);
                break;
            case 91:
                d = JsonToken.START_ARRAY;
                break;
            case 93:
            case 125:
                b(N2, "expected a value");
                a(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
                d = JsonToken.VALUE_TRUE;
                break;
            case 102:
                a("false", 1);
                d = JsonToken.VALUE_FALSE;
                break;
            case 110:
                a("null", 1);
                d = JsonToken.VALUE_NULL;
                break;
            case 116:
                a(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
                d = JsonToken.VALUE_TRUE;
                break;
            case 123:
                d = JsonToken.START_OBJECT;
                break;
            default:
                d = h(N2);
                break;
        }
        this.m = d;
        return this.K;
    }

    private JsonToken m(int i) throws IOException, JsonParseException {
        if (i == 34) {
            this.O = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this.K = jsonToken;
            return jsonToken;
        }
        switch (i) {
            case 45:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                JsonToken d = d(i);
                this.K = d;
                return d;
            case 91:
                this.l = this.l.a(this.j, this.k);
                JsonToken jsonToken2 = JsonToken.START_ARRAY;
                this.K = jsonToken2;
                return jsonToken2;
            case 93:
            case 125:
                b(i, "expected a value");
                break;
            case 102:
                a("false", 1);
                JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
                this.K = jsonToken3;
                return jsonToken3;
            case 110:
                a("null", 1);
                JsonToken jsonToken4 = JsonToken.VALUE_NULL;
                this.K = jsonToken4;
                return jsonToken4;
            case 116:
                break;
            case 123:
                this.l = this.l.b(this.j, this.k);
                JsonToken jsonToken5 = JsonToken.START_OBJECT;
                this.K = jsonToken5;
                return jsonToken5;
            default:
                JsonToken h = h(i);
                this.K = h;
                return h;
        }
        a(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
        JsonToken jsonToken6 = JsonToken.VALUE_TRUE;
        this.K = jsonToken6;
        return jsonToken6;
    }

    private JsonToken L() {
        this.p = false;
        JsonToken jsonToken = this.m;
        this.m = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            this.l = this.l.a(this.j, this.k);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this.l = this.l.b(this.j, this.k);
        }
        this.K = jsonToken;
        return jsonToken;
    }

    @Override // com.fasterxml.jackson.core.a.b, com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.M.b();
    }

    protected JsonToken d(int i) throws IOException, JsonParseException {
        int i2;
        int i3;
        int i4 = 1;
        char[] k = this.n.k();
        boolean z = i == 45;
        if (z) {
            k[0] = '-';
            if (this.d >= this.e) {
                o();
            }
            byte[] bArr = this.Q;
            int i5 = this.d;
            this.d = i5 + 1;
            i3 = bArr[i5] & 255;
            if (i3 < 48 || i3 > 57) {
                return a(i3, true);
            }
            i2 = 1;
        } else {
            i2 = 0;
            i3 = i;
        }
        if (i3 == 48) {
            i3 = M();
        }
        int i6 = i2 + 1;
        k[i2] = (char) i3;
        int length = this.d + k.length;
        if (length > this.e) {
            length = this.e;
        }
        while (this.d < length) {
            byte[] bArr2 = this.Q;
            int i7 = this.d;
            this.d = i7 + 1;
            int i8 = bArr2[i7] & 255;
            if (i8 >= 48 && i8 <= 57) {
                i4++;
                k[i6] = (char) i8;
                i6++;
            } else {
                if (i8 == 46 || i8 == 101 || i8 == 69) {
                    return a(k, i6, i8, z, i4);
                }
                this.d--;
                this.n.a(i6);
                return a(z, i4);
            }
        }
        return a(k, i6, z, i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002f, code lost:            if (r3 == 46) goto L19;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:            if (r3 == 101) goto L19;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:            if (r3 != 69) goto L24;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:            r6.d--;        r6.n.a(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:            return a(r9, r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:            return a(r1, r2, r3, r9, r5);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.fasterxml.jackson.core.JsonToken a(char[] r7, int r8, boolean r9, int r10) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r6 = this;
            r5 = r10
            r2 = r8
            r1 = r7
        L3:
            int r0 = r6.d
            int r3 = r6.e
            if (r0 < r3) goto L19
            boolean r0 = r6.p()
            if (r0 != 0) goto L19
            com.fasterxml.jackson.core.util.b r0 = r6.n
            r0.a(r2)
            com.fasterxml.jackson.core.JsonToken r0 = r6.a(r9, r5)
        L18:
            return r0
        L19:
            byte[] r0 = r6.Q
            int r3 = r6.d
            int r4 = r3 + 1
            r6.d = r4
            r0 = r0[r3]
            r3 = r0 & 255(0xff, float:3.57E-43)
            r0 = 57
            if (r3 > r0) goto L2d
            r0 = 48
            if (r3 >= r0) goto L40
        L2d:
            r0 = 46
            if (r3 == r0) goto L39
            r0 = 101(0x65, float:1.42E-43)
            if (r3 == r0) goto L39
            r0 = 69
            if (r3 != r0) goto L53
        L39:
            r0 = r6
            r4 = r9
            com.fasterxml.jackson.core.JsonToken r0 = r0.a(r1, r2, r3, r4, r5)
            goto L18
        L40:
            int r0 = r1.length
            if (r2 < r0) goto L63
            com.fasterxml.jackson.core.util.b r0 = r6.n
            char[] r1 = r0.m()
            r2 = 0
            r0 = r2
        L4b:
            int r2 = r0 + 1
            char r3 = (char) r3
            r1[r0] = r3
            int r5 = r5 + 1
            goto L3
        L53:
            int r0 = r6.d
            int r0 = r0 + (-1)
            r6.d = r0
            com.fasterxml.jackson.core.util.b r0 = r6.n
            r0.a(r2)
            com.fasterxml.jackson.core.JsonToken r0 = r6.a(r9, r5)
            goto L18
        L63:
            r0 = r2
            goto L4b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.b.h.a(char[], int, boolean, int):com.fasterxml.jackson.core.JsonToken");
    }

    private int M() throws IOException, JsonParseException {
        if (this.d >= this.e && !p()) {
            return 48;
        }
        int i = this.Q[this.d] & 255;
        if (i < 48 || i > 57) {
            return 48;
        }
        if (!a(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            b("Leading zeroes not allowed");
        }
        this.d++;
        if (i != 48) {
            return i;
        }
        do {
            if (this.d < this.e || p()) {
                i = this.Q[this.d] & 255;
                if (i < 48 || i > 57) {
                    return 48;
                }
                this.d++;
            } else {
                return i;
            }
        } while (i == 48);
        return i;
    }

    private JsonToken a(char[] cArr, int i, int i2, boolean z, int i3) throws IOException, JsonParseException {
        int i4;
        char[] cArr2;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int i10;
        int i11 = 0;
        boolean z3 = false;
        if (i2 != 46) {
            i4 = 0;
            cArr2 = cArr;
            i5 = i;
        } else {
            int i12 = i + 1;
            cArr[i] = (char) i2;
            while (true) {
                if (this.d >= this.e && !p()) {
                    z3 = true;
                    break;
                }
                byte[] bArr = this.Q;
                int i13 = this.d;
                this.d = i13 + 1;
                i2 = bArr[i13] & 255;
                if (i2 < 48 || i2 > 57) {
                    break;
                }
                i11++;
                if (i12 >= cArr.length) {
                    cArr = this.n.m();
                    i12 = 0;
                }
                int i14 = i12;
                i12 = i14 + 1;
                cArr[i14] = (char) i2;
            }
            if (i11 == 0) {
                a(i2, "Decimal point not followed by a digit");
            }
            i4 = i11;
            i5 = i12;
            cArr2 = cArr;
        }
        if (i2 != 101 && i2 != 69) {
            z2 = z3;
            i9 = i5;
            i10 = 0;
        } else {
            if (i5 >= cArr2.length) {
                cArr2 = this.n.m();
                i5 = 0;
            }
            int i15 = i5 + 1;
            cArr2[i5] = (char) i2;
            if (this.d >= this.e) {
                o();
            }
            byte[] bArr2 = this.Q;
            int i16 = this.d;
            this.d = i16 + 1;
            int i17 = bArr2[i16] & 255;
            if (i17 != 45 && i17 != 43) {
                i7 = i15;
                i8 = 0;
            } else {
                if (i15 >= cArr2.length) {
                    cArr2 = this.n.m();
                    i6 = 0;
                } else {
                    i6 = i15;
                }
                int i18 = i6 + 1;
                cArr2[i6] = (char) i17;
                if (this.d >= this.e) {
                    o();
                }
                byte[] bArr3 = this.Q;
                int i19 = this.d;
                this.d = i19 + 1;
                i17 = bArr3[i19] & 255;
                i7 = i18;
                i8 = 0;
            }
            while (i17 <= 57 && i17 >= 48) {
                i8++;
                if (i7 >= cArr2.length) {
                    cArr2 = this.n.m();
                    i7 = 0;
                }
                int i20 = i7 + 1;
                cArr2[i7] = (char) i17;
                if (this.d >= this.e && !p()) {
                    i10 = i8;
                    z2 = true;
                    i9 = i20;
                    break;
                }
                byte[] bArr4 = this.Q;
                int i21 = this.d;
                this.d = i21 + 1;
                i17 = bArr4[i21] & 255;
                i7 = i20;
            }
            z2 = z3;
            int i22 = i8;
            i9 = i7;
            i10 = i22;
            if (i10 == 0) {
                a(i17, "Exponent indicator not followed by a digit");
            }
        }
        if (!z2) {
            this.d--;
        }
        this.n.a(i9);
        return b(z, i3, i4, i10);
    }

    protected com.fasterxml.jackson.core.c.c e(int i) throws IOException, JsonParseException {
        if (i != 34) {
            return g(i);
        }
        if (this.d + 9 > this.e) {
            return F();
        }
        byte[] bArr = this.Q;
        int[] iArr = T;
        int i2 = this.d;
        this.d = i2 + 1;
        int i3 = bArr[i2] & 255;
        if (iArr[i3] == 0) {
            int i4 = this.d;
            this.d = i4 + 1;
            int i5 = bArr[i4] & 255;
            if (iArr[i5] == 0) {
                int i6 = (i3 << 8) | i5;
                int i7 = this.d;
                this.d = i7 + 1;
                int i8 = bArr[i7] & 255;
                if (iArr[i8] == 0) {
                    int i9 = (i6 << 8) | i8;
                    int i10 = this.d;
                    this.d = i10 + 1;
                    int i11 = bArr[i10] & 255;
                    if (iArr[i11] == 0) {
                        int i12 = (i9 << 8) | i11;
                        int i13 = this.d;
                        this.d = i13 + 1;
                        int i14 = bArr[i13] & 255;
                        if (iArr[i14] == 0) {
                            this.U = i12;
                            return a(i14, iArr);
                        }
                        if (i14 == 34) {
                            return b(i12, 4);
                        }
                        return a(i12, i14, 4);
                    }
                    if (i11 == 34) {
                        return b(i9, 3);
                    }
                    return a(i9, i11, 3);
                }
                if (i8 == 34) {
                    return b(i6, 2);
                }
                return a(i6, i8, 2);
            }
            if (i5 == 34) {
                return b(i3, 1);
            }
            return a(i3, i5, 1);
        }
        if (i3 == 34) {
            return com.fasterxml.jackson.core.c.a.d();
        }
        return a(0, i3, 0);
    }

    protected com.fasterxml.jackson.core.c.c a(int i, int[] iArr) throws IOException, JsonParseException {
        byte[] bArr = this.Q;
        int i2 = this.d;
        this.d = i2 + 1;
        int i3 = bArr[i2] & 255;
        if (iArr[i3] != 0) {
            if (i3 == 34) {
                return b(this.U, i, 1);
            }
            return a(this.U, i, i3, 1);
        }
        int i4 = i3 | (i << 8);
        byte[] bArr2 = this.Q;
        int i5 = this.d;
        this.d = i5 + 1;
        int i6 = bArr2[i5] & 255;
        if (iArr[i6] != 0) {
            if (i6 == 34) {
                return b(this.U, i4, 2);
            }
            return a(this.U, i4, i6, 2);
        }
        int i7 = (i4 << 8) | i6;
        byte[] bArr3 = this.Q;
        int i8 = this.d;
        this.d = i8 + 1;
        int i9 = bArr3[i8] & 255;
        if (iArr[i9] != 0) {
            if (i9 == 34) {
                return b(this.U, i7, 3);
            }
            return a(this.U, i7, i9, 3);
        }
        int i10 = (i7 << 8) | i9;
        byte[] bArr4 = this.Q;
        int i11 = this.d;
        this.d = i11 + 1;
        int i12 = bArr4[i11] & 255;
        if (iArr[i12] != 0) {
            if (i12 == 34) {
                return b(this.U, i10, 4);
            }
            return a(this.U, i10, i12, 4);
        }
        this.N[0] = this.U;
        this.N[1] = i10;
        return f(i12);
    }

    protected com.fasterxml.jackson.core.c.c f(int i) throws IOException, JsonParseException {
        int[] iArr = T;
        int i2 = 2;
        int i3 = i;
        while (this.e - this.d >= 4) {
            byte[] bArr = this.Q;
            int i4 = this.d;
            this.d = i4 + 1;
            int i5 = bArr[i4] & 255;
            if (iArr[i5] != 0) {
                if (i5 == 34) {
                    return a(this.N, i2, i3, 1);
                }
                return a(this.N, i2, i3, i5, 1);
            }
            int i6 = (i3 << 8) | i5;
            byte[] bArr2 = this.Q;
            int i7 = this.d;
            this.d = i7 + 1;
            int i8 = bArr2[i7] & 255;
            if (iArr[i8] != 0) {
                if (i8 == 34) {
                    return a(this.N, i2, i6, 2);
                }
                return a(this.N, i2, i6, i8, 2);
            }
            int i9 = (i6 << 8) | i8;
            byte[] bArr3 = this.Q;
            int i10 = this.d;
            this.d = i10 + 1;
            int i11 = bArr3[i10] & 255;
            if (iArr[i11] != 0) {
                if (i11 == 34) {
                    return a(this.N, i2, i9, 3);
                }
                return a(this.N, i2, i9, i11, 3);
            }
            int i12 = (i9 << 8) | i11;
            byte[] bArr4 = this.Q;
            int i13 = this.d;
            this.d = i13 + 1;
            i3 = bArr4[i13] & 255;
            if (iArr[i3] != 0) {
                if (i3 == 34) {
                    return a(this.N, i2, i12, 4);
                }
                return a(this.N, i2, i12, i3, 4);
            }
            if (i2 >= this.N.length) {
                this.N = a(this.N, i2);
            }
            this.N[i2] = i12;
            i2++;
        }
        return a(this.N, i2, 0, i3, 0);
    }

    protected com.fasterxml.jackson.core.c.c F() throws IOException, JsonParseException {
        if (this.d >= this.e && !p()) {
            c(": was expecting closing '\"' for name");
        }
        byte[] bArr = this.Q;
        int i = this.d;
        this.d = i + 1;
        int i2 = bArr[i] & 255;
        return i2 == 34 ? com.fasterxml.jackson.core.c.a.d() : a(this.N, 0, 0, i2, 0);
    }

    private com.fasterxml.jackson.core.c.c a(int i, int i2, int i3) throws IOException, JsonParseException {
        return a(this.N, 0, i, i2, i3);
    }

    private com.fasterxml.jackson.core.c.c a(int i, int i2, int i3, int i4) throws IOException, JsonParseException {
        this.N[0] = i;
        return a(this.N, 1, i2, i3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.fasterxml.jackson.core.c.c a(int[] r10, int r11, int r12, int r13, int r14) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.b.h.a(int[], int, int, int, int):com.fasterxml.jackson.core.c.c");
    }

    protected com.fasterxml.jackson.core.c.c g(int i) throws IOException, JsonParseException {
        int[] iArr;
        int i2;
        int i3;
        int i4;
        if (i == 39 && a(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return G();
        }
        if (!a(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            b(i, "was expecting double-quote to start field name");
        }
        int[] d = com.fasterxml.jackson.core.io.b.d();
        if (d[i] != 0) {
            b(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = i;
        int i8 = 0;
        int[] iArr2 = this.N;
        while (true) {
            if (i5 < 4) {
                int i9 = i5 + 1;
                i3 = i7 | (i6 << 8);
                i4 = i8;
                iArr = iArr2;
                i2 = i9;
            } else {
                if (i8 >= iArr2.length) {
                    iArr2 = a(iArr2, iArr2.length);
                    this.N = iArr2;
                }
                int i10 = i8 + 1;
                iArr2[i8] = i6;
                iArr = iArr2;
                i2 = 1;
                i3 = i7;
                i4 = i10;
            }
            if (this.d >= this.e && !p()) {
                c(" in field name");
            }
            int i11 = this.Q[this.d] & 255;
            if (d[i11] != 0) {
                break;
            }
            this.d++;
            i6 = i3;
            i5 = i2;
            iArr2 = iArr;
            i8 = i4;
            i7 = i11;
        }
        if (i2 > 0) {
            if (i4 >= iArr.length) {
                iArr = a(iArr, iArr.length);
                this.N = iArr;
            }
            iArr[i4] = i3;
            i4++;
        }
        com.fasterxml.jackson.core.c.c a2 = this.M.a(iArr, i4);
        return a2 == null ? a(iArr, i4, i2) : a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.fasterxml.jackson.core.c.c G() throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.b.h.G():com.fasterxml.jackson.core.c.c");
    }

    private com.fasterxml.jackson.core.c.c b(int i, int i2) throws JsonParseException {
        com.fasterxml.jackson.core.c.c b = this.M.b(i);
        if (b == null) {
            this.N[0] = i;
            return a(this.N, 1, i2);
        }
        return b;
    }

    private com.fasterxml.jackson.core.c.c b(int i, int i2, int i3) throws JsonParseException {
        com.fasterxml.jackson.core.c.c a2 = this.M.a(i, i2);
        if (a2 == null) {
            this.N[0] = i;
            this.N[1] = i2;
            return a(this.N, 2, i3);
        }
        return a2;
    }

    private com.fasterxml.jackson.core.c.c a(int[] iArr, int i, int i2, int i3) throws JsonParseException {
        if (i >= iArr.length) {
            iArr = a(iArr, iArr.length);
            this.N = iArr;
        }
        int i4 = i + 1;
        iArr[i] = i2;
        com.fasterxml.jackson.core.c.c a2 = this.M.a(iArr, i4);
        if (a2 == null) {
            return a(iArr, i4, i3);
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.fasterxml.jackson.core.c.c a(int[] r12, int r13, int r14) throws com.fasterxml.jackson.core.JsonParseException {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.b.h.a(int[], int, int):com.fasterxml.jackson.core.c.c");
    }

    @Override // com.fasterxml.jackson.core.a.b
    protected void q() throws IOException, JsonParseException {
        int i = this.d;
        if (i >= this.e) {
            o();
            i = this.d;
        }
        char[] k = this.n.k();
        int[] iArr = S;
        int min = Math.min(this.e, k.length + i);
        byte[] bArr = this.Q;
        int i2 = i;
        int i3 = 0;
        while (true) {
            if (i2 >= min) {
                break;
            }
            int i4 = bArr[i2] & 255;
            if (iArr[i4] != 0) {
                if (i4 == 34) {
                    this.d = i2 + 1;
                    this.n.a(i3);
                    return;
                }
            } else {
                k[i3] = (char) i4;
                i3++;
                i2++;
            }
        }
        this.d = i2;
        a(k, i3);
    }

    private void a(char[] cArr, int i) throws IOException, JsonParseException {
        int i2;
        int[] iArr = S;
        byte[] bArr = this.Q;
        while (true) {
            int i3 = this.d;
            if (i3 >= this.e) {
                o();
                i3 = this.d;
            }
            if (i >= cArr.length) {
                cArr = this.n.m();
                i = 0;
            }
            int min = Math.min(this.e, (cArr.length - i) + i3);
            while (true) {
                if (i3 < min) {
                    int i4 = i3 + 1;
                    int i5 = bArr[i3] & 255;
                    if (iArr[i5] != 0) {
                        this.d = i4;
                        if (i5 != 34) {
                            switch (iArr[i5]) {
                                case 1:
                                    i5 = B();
                                    break;
                                case 2:
                                    i5 = n(i5);
                                    break;
                                case 3:
                                    if (this.e - this.d >= 2) {
                                        i5 = p(i5);
                                        break;
                                    } else {
                                        i5 = o(i5);
                                        break;
                                    }
                                case 4:
                                    int q = q(i5);
                                    int i6 = i + 1;
                                    cArr[i] = (char) (55296 | (q >> 10));
                                    if (i6 >= cArr.length) {
                                        cArr = this.n.m();
                                        i6 = 0;
                                    }
                                    i = i6;
                                    i5 = (q & 1023) | 56320;
                                    break;
                                default:
                                    if (i5 < 32) {
                                        c(i5, "string value");
                                        break;
                                    } else {
                                        j(i5);
                                        break;
                                    }
                            }
                            if (i >= cArr.length) {
                                cArr = this.n.m();
                                i2 = 0;
                            } else {
                                i2 = i;
                            }
                            i = i2 + 1;
                            cArr[i2] = (char) i5;
                        } else {
                            this.n.a(i);
                            return;
                        }
                    } else {
                        cArr[i] = (char) i5;
                        i3 = i4;
                        i++;
                    }
                } else {
                    this.d = i3;
                }
            }
        }
    }

    protected void H() throws IOException, JsonParseException {
        this.O = false;
        int[] iArr = S;
        byte[] bArr = this.Q;
        while (true) {
            int i = this.d;
            int i2 = this.e;
            if (i >= i2) {
                o();
                i = this.d;
                i2 = this.e;
            }
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    int i4 = bArr[i] & 255;
                    if (iArr[i4] != 0) {
                        this.d = i3;
                        if (i4 != 34) {
                            switch (iArr[i4]) {
                                case 1:
                                    B();
                                    break;
                                case 2:
                                    r(i4);
                                    break;
                                case 3:
                                    s(i4);
                                    break;
                                case 4:
                                    t(i4);
                                    break;
                                default:
                                    if (i4 < 32) {
                                        c(i4, "string value");
                                        break;
                                    } else {
                                        j(i4);
                                        break;
                                    }
                            }
                        } else {
                            return;
                        }
                    } else {
                        i = i3;
                    }
                } else {
                    this.d = i;
                }
            }
        }
    }

    protected JsonToken h(int i) throws IOException, JsonParseException {
        switch (i) {
            case 39:
                if (a(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
                    return I();
                }
                break;
            case 43:
                if (this.d >= this.e && !p()) {
                    D();
                }
                byte[] bArr = this.Q;
                int i2 = this.d;
                this.d = i2 + 1;
                return a(bArr[i2] & 255, false);
            case 78:
                a("NaN", 1);
                if (a(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    return a("NaN", Double.NaN);
                }
                d("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                break;
        }
        b(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    protected JsonToken I() throws IOException, JsonParseException {
        int i;
        int i2;
        char[] k = this.n.k();
        int[] iArr = S;
        byte[] bArr = this.Q;
        int i3 = 0;
        while (true) {
            if (this.d >= this.e) {
                o();
            }
            if (i3 >= k.length) {
                k = this.n.m();
                i3 = 0;
            }
            int i4 = this.e;
            int length = this.d + (k.length - i3);
            if (length >= i4) {
                length = i4;
            }
            while (this.d < length) {
                int i5 = this.d;
                this.d = i5 + 1;
                int i6 = bArr[i5] & 255;
                if (i6 != 39 && iArr[i6] == 0) {
                    k[i3] = (char) i6;
                    i3++;
                } else if (i6 != 39) {
                    switch (iArr[i6]) {
                        case 1:
                            if (i6 != 34) {
                                i = B();
                                break;
                            }
                            break;
                        case 2:
                            i = n(i6);
                            break;
                        case 3:
                            if (this.e - this.d >= 2) {
                                i = p(i6);
                                break;
                            } else {
                                i = o(i6);
                                break;
                            }
                        case 4:
                            int q = q(i6);
                            int i7 = i3 + 1;
                            k[i3] = (char) (55296 | (q >> 10));
                            if (i7 >= k.length) {
                                k = this.n.m();
                                i3 = 0;
                            } else {
                                i3 = i7;
                            }
                            i = 56320 | (q & 1023);
                            break;
                        default:
                            if (i6 < 32) {
                                c(i6, "string value");
                            }
                            j(i6);
                            break;
                    }
                    i = i6;
                    if (i3 >= k.length) {
                        k = this.n.m();
                        i2 = 0;
                    } else {
                        i2 = i3;
                    }
                    i3 = i2 + 1;
                    k[i2] = (char) i;
                } else {
                    this.n.a(i3);
                    return JsonToken.VALUE_STRING;
                }
            }
        }
    }

    protected JsonToken a(int i, boolean z) throws IOException, JsonParseException {
        if (i == 73) {
            if (this.d >= this.e && !p()) {
                D();
            }
            byte[] bArr = this.Q;
            int i2 = this.d;
            this.d = i2 + 1;
            i = bArr[i2];
            if (i == 78) {
                String str = z ? "-INF" : "+INF";
                a(str, 3);
                if (a(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    return a(str, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                }
                d("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            } else if (i == 110) {
                String str2 = z ? "-Infinity" : "+Infinity";
                a(str2, 3);
                if (a(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    return a(str2, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                }
                d("Non-standard token '" + str2 + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
        }
        a(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    protected void a(String str, int i) throws IOException, JsonParseException {
        int i2;
        int length = str.length();
        do {
            if (this.d >= this.e && !p()) {
                c(" in a value");
            }
            if (this.Q[this.d] != str.charAt(i)) {
                a(str.substring(0, i), "'null', 'true', 'false' or NaN");
            }
            this.d++;
            i++;
        } while (i < length);
        if ((this.d < this.e || p()) && (i2 = this.Q[this.d] & 255) >= 48 && i2 != 93 && i2 != 125 && Character.isJavaIdentifierPart((char) i(i2))) {
            this.d++;
            a(str.substring(0, i), "'null', 'true', 'false' or NaN");
        }
    }

    protected void a(String str, String str2) throws IOException, JsonParseException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.d >= this.e && !p()) {
                break;
            }
            byte[] bArr = this.Q;
            int i = this.d;
            this.d = i + 1;
            char i2 = (char) i(bArr[i]);
            if (!Character.isJavaIdentifierPart(i2)) {
                break;
            } else {
                sb.append(i2);
            }
        }
        d("Unrecognized token '" + sb.toString() + "': was expecting " + str2);
    }

    private int N() throws IOException, JsonParseException {
        while (true) {
            if (this.d < this.e || p()) {
                byte[] bArr = this.Q;
                int i = this.d;
                this.d = i + 1;
                int i2 = bArr[i] & 255;
                if (i2 > 32) {
                    if (i2 != 47) {
                        return i2;
                    }
                    P();
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        K();
                    } else if (i2 == 13) {
                        J();
                    } else if (i2 != 9) {
                        b(i2);
                    }
                }
            } else {
                throw a("Unexpected end-of-input within/between " + this.l.d() + " entries");
            }
        }
    }

    private int O() throws IOException, JsonParseException {
        while (true) {
            if (this.d < this.e || p()) {
                byte[] bArr = this.Q;
                int i = this.d;
                this.d = i + 1;
                int i2 = bArr[i] & 255;
                if (i2 > 32) {
                    if (i2 == 47) {
                        P();
                    } else {
                        return i2;
                    }
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        K();
                    } else if (i2 == 13) {
                        J();
                    } else if (i2 != 9) {
                        b(i2);
                    }
                }
            } else {
                t();
                return -1;
            }
        }
    }

    private void P() throws IOException, JsonParseException {
        if (!a(JsonParser.Feature.ALLOW_COMMENTS)) {
            b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.d >= this.e && !p()) {
            c(" in a comment");
        }
        byte[] bArr = this.Q;
        int i = this.d;
        this.d = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 == 47) {
            R();
        } else if (i2 == 42) {
            Q();
        } else {
            b(i2, "was expecting either '*' or '/' for a comment");
        }
    }

    private void Q() throws IOException, JsonParseException {
        int[] e = com.fasterxml.jackson.core.io.b.e();
        while (true) {
            if (this.d < this.e || p()) {
                byte[] bArr = this.Q;
                int i = this.d;
                this.d = i + 1;
                int i2 = bArr[i] & 255;
                int i3 = e[i2];
                if (i3 != 0) {
                    switch (i3) {
                        case 2:
                            r(i2);
                            break;
                        case 3:
                            s(i2);
                            break;
                        case 4:
                            t(i2);
                            break;
                        case 10:
                            K();
                            break;
                        case 13:
                            J();
                            break;
                        case 42:
                            if (this.d >= this.e && !p()) {
                                break;
                            } else if (this.Q[this.d] != 47) {
                                break;
                            } else {
                                this.d++;
                                return;
                            }
                        default:
                            j(i2);
                            break;
                    }
                }
            }
        }
        c(" in a comment");
    }

    private void R() throws IOException, JsonParseException {
        int[] e = com.fasterxml.jackson.core.io.b.e();
        while (true) {
            if (this.d < this.e || p()) {
                byte[] bArr = this.Q;
                int i = this.d;
                this.d = i + 1;
                int i2 = bArr[i] & 255;
                int i3 = e[i2];
                if (i3 != 0) {
                    switch (i3) {
                        case 2:
                            r(i2);
                            break;
                        case 3:
                            s(i2);
                            break;
                        case 4:
                            t(i2);
                            break;
                        case 10:
                            K();
                            return;
                        case 13:
                            J();
                            return;
                        case 42:
                            break;
                        default:
                            j(i2);
                            break;
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // com.fasterxml.jackson.core.a.b
    protected char B() throws IOException, JsonParseException {
        if (this.d >= this.e && !p()) {
            c(" in character escape sequence");
        }
        byte[] bArr = this.Q;
        int i = this.d;
        this.d = i + 1;
        byte b = bArr[i];
        switch (b) {
            case 34:
            case 47:
            case 92:
                return (char) b;
            case 98:
                return '\b';
            case 102:
                return '\f';
            case 110:
                return '\n';
            case 114:
                return '\r';
            case 116:
                return '\t';
            case 117:
                int i2 = 0;
                for (int i3 = 0; i3 < 4; i3++) {
                    if (this.d >= this.e && !p()) {
                        c(" in character escape sequence");
                    }
                    byte[] bArr2 = this.Q;
                    int i4 = this.d;
                    this.d = i4 + 1;
                    byte b2 = bArr2[i4];
                    int a2 = com.fasterxml.jackson.core.io.b.a(b2);
                    if (a2 < 0) {
                        b(b2, "expected a hex-digit for character escape sequence");
                    }
                    i2 = (i2 << 4) | a2;
                }
                return (char) i2;
            default:
                return a((char) i(b));
        }
    }

    protected int i(int i) throws IOException, JsonParseException {
        char c;
        if (i < 0) {
            if ((i & 224) == 192) {
                i &= 31;
                c = 1;
            } else if ((i & 240) == 224) {
                i &= 15;
                c = 2;
            } else if ((i & 248) == 240) {
                i &= 7;
                c = 3;
            } else {
                k(i & 255);
                c = 1;
            }
            int S2 = S();
            if ((S2 & 192) != 128) {
                l(S2 & 255);
            }
            int i2 = (i << 6) | (S2 & 63);
            if (c > 1) {
                int S3 = S();
                if ((S3 & 192) != 128) {
                    l(S3 & 255);
                }
                int i3 = (i2 << 6) | (S3 & 63);
                if (c > 2) {
                    int S4 = S();
                    if ((S4 & 192) != 128) {
                        l(S4 & 255);
                    }
                    return (i3 << 6) | (S4 & 63);
                }
                return i3;
            }
            return i2;
        }
        return i;
    }

    private int n(int i) throws IOException, JsonParseException {
        if (this.d >= this.e) {
            o();
        }
        byte[] bArr = this.Q;
        int i2 = this.d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            a(b & 255, this.d);
        }
        return (b & 63) | ((i & 31) << 6);
    }

    private int o(int i) throws IOException, JsonParseException {
        if (this.d >= this.e) {
            o();
        }
        int i2 = i & 15;
        byte[] bArr = this.Q;
        int i3 = this.d;
        this.d = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            a(b & 255, this.d);
        }
        int i4 = (i2 << 6) | (b & 63);
        if (this.d >= this.e) {
            o();
        }
        byte[] bArr2 = this.Q;
        int i5 = this.d;
        this.d = i5 + 1;
        byte b2 = bArr2[i5];
        if ((b2 & 192) != 128) {
            a(b2 & 255, this.d);
        }
        return (i4 << 6) | (b2 & 63);
    }

    private int p(int i) throws IOException, JsonParseException {
        int i2 = i & 15;
        byte[] bArr = this.Q;
        int i3 = this.d;
        this.d = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            a(b & 255, this.d);
        }
        int i4 = (i2 << 6) | (b & 63);
        byte[] bArr2 = this.Q;
        int i5 = this.d;
        this.d = i5 + 1;
        byte b2 = bArr2[i5];
        if ((b2 & 192) != 128) {
            a(b2 & 255, this.d);
        }
        return (i4 << 6) | (b2 & 63);
    }

    private int q(int i) throws IOException, JsonParseException {
        if (this.d >= this.e) {
            o();
        }
        byte[] bArr = this.Q;
        int i2 = this.d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            a(b & 255, this.d);
        }
        int i3 = (b & 63) | ((i & 7) << 6);
        if (this.d >= this.e) {
            o();
        }
        byte[] bArr2 = this.Q;
        int i4 = this.d;
        this.d = i4 + 1;
        byte b2 = bArr2[i4];
        if ((b2 & 192) != 128) {
            a(b2 & 255, this.d);
        }
        int i5 = (i3 << 6) | (b2 & 63);
        if (this.d >= this.e) {
            o();
        }
        byte[] bArr3 = this.Q;
        int i6 = this.d;
        this.d = i6 + 1;
        byte b3 = bArr3[i6];
        if ((b3 & 192) != 128) {
            a(b3 & 255, this.d);
        }
        return ((i5 << 6) | (b3 & 63)) - NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    }

    private void r(int i) throws IOException, JsonParseException {
        if (this.d >= this.e) {
            o();
        }
        byte[] bArr = this.Q;
        int i2 = this.d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            a(b & 255, this.d);
        }
    }

    private void s(int i) throws IOException, JsonParseException {
        if (this.d >= this.e) {
            o();
        }
        byte[] bArr = this.Q;
        int i2 = this.d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            a(b & 255, this.d);
        }
        if (this.d >= this.e) {
            o();
        }
        byte[] bArr2 = this.Q;
        int i3 = this.d;
        this.d = i3 + 1;
        byte b2 = bArr2[i3];
        if ((b2 & 192) != 128) {
            a(b2 & 255, this.d);
        }
    }

    private void t(int i) throws IOException, JsonParseException {
        if (this.d >= this.e) {
            o();
        }
        byte[] bArr = this.Q;
        int i2 = this.d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            a(b & 255, this.d);
        }
        if (this.d >= this.e) {
            o();
        }
        byte[] bArr2 = this.Q;
        int i3 = this.d;
        this.d = i3 + 1;
        byte b2 = bArr2[i3];
        if ((b2 & 192) != 128) {
            a(b2 & 255, this.d);
        }
        if (this.d >= this.e) {
            o();
        }
        byte[] bArr3 = this.Q;
        int i4 = this.d;
        this.d = i4 + 1;
        byte b3 = bArr3[i4];
        if ((b3 & 192) != 128) {
            a(b3 & 255, this.d);
        }
    }

    protected void J() throws IOException {
        if ((this.d < this.e || p()) && this.Q[this.d] == 10) {
            this.d++;
        }
        this.g++;
        this.h = this.d;
    }

    protected void K() throws IOException {
        this.g++;
        this.h = this.d;
    }

    private int S() throws IOException, JsonParseException {
        if (this.d >= this.e) {
            o();
        }
        byte[] bArr = this.Q;
        int i = this.d;
        this.d = i + 1;
        return bArr[i] & 255;
    }

    protected void j(int i) throws JsonParseException {
        if (i < 32) {
            b(i);
        }
        k(i);
    }

    protected void k(int i) throws JsonParseException {
        d("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    protected void l(int i) throws JsonParseException {
        d("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    protected void a(int i, int i2) throws JsonParseException {
        this.d = i2;
        l(i);
    }

    public static int[] a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        int[] iArr2 = new int[length + i];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }
}
