package com.fasterxml.jackson.core.b;

import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.Reader;

/* compiled from: ReaderBasedJsonParser.java */
/* loaded from: classes.dex */
public final class f extends com.fasterxml.jackson.core.a.b {
    protected Reader L;
    protected char[] M;
    protected com.fasterxml.jackson.core.c N;
    protected final com.fasterxml.jackson.core.c.b O;
    protected final int P;
    protected boolean Q;

    public f(com.fasterxml.jackson.core.io.c cVar, int i, Reader reader, com.fasterxml.jackson.core.c cVar2, com.fasterxml.jackson.core.c.b bVar) {
        super(cVar, i);
        this.Q = false;
        this.L = reader;
        this.M = cVar.g();
        this.N = cVar2;
        this.O = bVar;
        this.P = bVar.e();
    }

    @Override // com.fasterxml.jackson.core.a.b
    protected boolean p() throws IOException {
        this.f += this.e;
        this.h -= this.e;
        if (this.L == null) {
            return false;
        }
        int read = this.L.read(this.M, 0, this.M.length);
        if (read > 0) {
            this.d = 0;
            this.e = read;
            return true;
        }
        r();
        if (read == 0) {
            throw new IOException("Reader returned 0 characters when trying to read " + this.e);
        }
        return false;
    }

    protected char e(String str) throws IOException, JsonParseException {
        if (this.d >= this.e && !p()) {
            c(str);
        }
        char[] cArr = this.M;
        int i = this.d;
        this.d = i + 1;
        return cArr[i];
    }

    @Override // com.fasterxml.jackson.core.a.b
    protected void r() throws IOException {
        if (this.L != null) {
            if (this.b.c() || a(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this.L.close();
            }
            this.L = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.a.b
    public void s() throws IOException {
        super.s();
        char[] cArr = this.M;
        if (cArr != null) {
            this.M = null;
            this.b.a(cArr);
        }
    }

    @Override // com.fasterxml.jackson.core.a.c, com.fasterxml.jackson.core.JsonParser
    public String f() throws IOException, JsonParseException {
        JsonToken jsonToken = this.K;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return a(jsonToken);
        }
        if (this.Q) {
            this.Q = false;
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
        if (this.Q) {
            I();
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
        boolean c = this.l.c();
        if (c) {
            this.l.a(e(O));
            this.K = JsonToken.FIELD_NAME;
            int N = N();
            if (N != 58) {
                b(N, "was expecting a colon to separate field name and value");
            }
            O = N();
        }
        switch (O) {
            case 34:
                this.Q = true;
                d = JsonToken.VALUE_STRING;
                break;
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
                d = d(O);
                break;
            case 91:
                if (!c) {
                    this.l = this.l.a(this.j, this.k);
                }
                d = JsonToken.START_ARRAY;
                break;
            case 93:
            case 125:
                b(O, "expected a value");
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
                if (!c) {
                    this.l = this.l.b(this.j, this.k);
                }
                d = JsonToken.START_OBJECT;
                break;
            default:
                d = g(O);
                break;
        }
        if (c) {
            this.m = d;
            return this.K;
        }
        this.K = d;
        return d;
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
        this.O.b();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r14v0 ??, r14v1 ??, r14v2 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    protected com.fasterxml.jackson.core.JsonToken d(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r14v0 ??, r14v1 ??, r14v2 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r14v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */

    private JsonToken a(boolean z) throws IOException, JsonParseException {
        int i;
        char e;
        boolean z2;
        int i2;
        int i3;
        char c;
        char[] cArr;
        int i4;
        char c2;
        char[] cArr2;
        int i5;
        boolean z3;
        char e2;
        int i6;
        char e3;
        char c3;
        int i7;
        int i8;
        int i9;
        boolean z4;
        boolean z5;
        int i10;
        int i11 = 0;
        char[] k = this.n.k();
        if (z) {
            k[0] = '-';
            i = 1;
        } else {
            i = 0;
        }
        if (this.d < this.e) {
            char[] cArr3 = this.M;
            int i12 = this.d;
            this.d = i12 + 1;
            e = cArr3[i12];
        } else {
            e = e("No digit following minus sign");
        }
        if (e == '0') {
            e = M();
        }
        int i13 = 0;
        char c4 = e;
        char[] cArr4 = k;
        char c5 = c4;
        while (c5 >= '0' && c5 <= '9') {
            i13++;
            if (i >= cArr4.length) {
                cArr4 = this.n.m();
                i = 0;
            }
            int i14 = i + 1;
            cArr4[i] = c5;
            if (this.d >= this.e && !p()) {
                z2 = true;
                c = 0;
                i2 = i13;
                cArr = cArr4;
                i3 = i14;
                break;
            }
            char[] cArr5 = this.M;
            int i15 = this.d;
            this.d = i15 + 1;
            c5 = cArr5[i15];
            i = i14;
        }
        z2 = false;
        i2 = i13;
        i3 = i;
        c = c5;
        cArr = cArr4;
        if (i2 == 0) {
            b("Missing integer part (next char " + c(c) + ")");
        }
        if (c == '.') {
            int i16 = i3 + 1;
            cArr[i3] = c;
            char[] cArr6 = cArr;
            int i17 = i16;
            char c6 = c;
            int i18 = 0;
            while (true) {
                if (this.d >= this.e && !p()) {
                    c2 = c6;
                    z5 = true;
                    break;
                }
                char[] cArr7 = this.M;
                int i19 = this.d;
                this.d = i19 + 1;
                c6 = cArr7[i19];
                if (c6 < '0') {
                    c2 = c6;
                    z5 = z2;
                    break;
                }
                if (c6 > '9') {
                    c2 = c6;
                    z5 = z2;
                    break;
                }
                i18++;
                if (i17 >= cArr6.length) {
                    cArr6 = this.n.m();
                    i10 = 0;
                } else {
                    i10 = i17;
                }
                i17 = i10 + 1;
                cArr6[i10] = c6;
            }
            if (i18 == 0) {
                a(c2, "Decimal point not followed by a digit");
            }
            i4 = i18;
            i5 = i17;
            boolean z6 = z5;
            cArr2 = cArr6;
            z3 = z6;
        } else {
            i4 = 0;
            c2 = c;
            cArr2 = cArr;
            i5 = i3;
            z3 = z2;
        }
        if (c2 == 'e' || c2 == 'E') {
            if (i5 >= cArr2.length) {
                cArr2 = this.n.m();
                i5 = 0;
            }
            int i20 = i5 + 1;
            cArr2[i5] = c2;
            if (this.d < this.e) {
                char[] cArr8 = this.M;
                int i21 = this.d;
                this.d = i21 + 1;
                e2 = cArr8[i21];
            } else {
                e2 = e("expected a digit for number exponent");
            }
            if (e2 == '-' || e2 == '+') {
                if (i20 >= cArr2.length) {
                    cArr2 = this.n.m();
                    i6 = 0;
                } else {
                    i6 = i20;
                }
                int i22 = i6 + 1;
                cArr2[i6] = e2;
                if (this.d < this.e) {
                    char[] cArr9 = this.M;
                    int i23 = this.d;
                    this.d = i23 + 1;
                    e3 = cArr9[i23];
                } else {
                    e3 = e("expected a digit for number exponent");
                }
                c3 = e3;
                i7 = i22;
                i8 = 0;
            } else {
                c3 = e2;
                i7 = i20;
                i8 = 0;
            }
            while (c3 <= '9' && c3 >= '0') {
                i8++;
                if (i7 >= cArr2.length) {
                    cArr2 = this.n.m();
                    i7 = 0;
                }
                int i24 = i7 + 1;
                cArr2[i7] = c3;
                if (this.d >= this.e && !p()) {
                    i11 = i8;
                    z4 = true;
                    i9 = i24;
                    break;
                }
                char[] cArr10 = this.M;
                int i25 = this.d;
                this.d = i25 + 1;
                c3 = cArr10[i25];
                i7 = i24;
            }
            i11 = i8;
            i9 = i7;
            z4 = z3;
            if (i11 == 0) {
                a(c3, "Exponent indicator not followed by a digit");
            }
        } else {
            i9 = i5;
            z4 = z3;
        }
        if (!z4) {
            this.d--;
        }
        this.n.a(i9);
        return a(z, i2, i4, i11);
    }

    private char M() throws IOException, JsonParseException {
        if (this.d >= this.e && !p()) {
            return '0';
        }
        char c = this.M[this.d];
        if (c < '0' || c > '9') {
            return '0';
        }
        if (!a(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            b("Leading zeroes not allowed");
        }
        this.d++;
        if (c != '0') {
            return c;
        }
        do {
            if (this.d < this.e || p()) {
                c = this.M[this.d];
                if (c < '0' || c > '9') {
                    return '0';
                }
                this.d++;
            } else {
                return c;
            }
        } while (c == '0');
        return c;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v2 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    protected com.fasterxml.jackson.core.JsonToken a(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v2 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r9v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */

    protected String e(int i) throws IOException, JsonParseException {
        if (i != 34) {
            return f(i);
        }
        int i2 = this.d;
        int i3 = this.P;
        int i4 = this.e;
        if (i2 < i4) {
            int[] a2 = com.fasterxml.jackson.core.io.b.a();
            int length = a2.length;
            while (true) {
                char c = this.M[i2];
                if (c < length && a2[c] != 0) {
                    if (c == '\"') {
                        int i5 = this.d;
                        this.d = i2 + 1;
                        return this.O.a(this.M, i5, i2 - i5, i3);
                    }
                } else {
                    i3 = (i3 * 33) + c;
                    i2++;
                    if (i2 >= i4) {
                        break;
                    }
                }
            }
        }
        int i6 = this.d;
        this.d = i2;
        return a(i6, i3, 34);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(int r7, int r8, int r9) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r6 = this;
            r5 = 92
            com.fasterxml.jackson.core.util.b r0 = r6.n
            char[] r1 = r6.M
            int r2 = r6.d
            int r2 = r2 - r7
            r0.a(r1, r7, r2)
            com.fasterxml.jackson.core.util.b r0 = r6.n
            char[] r1 = r0.j()
            com.fasterxml.jackson.core.util.b r0 = r6.n
            int r0 = r0.l()
        L18:
            int r2 = r6.d
            int r3 = r6.e
            if (r2 < r3) goto L41
            boolean r2 = r6.p()
            if (r2 != 0) goto L41
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ": was expecting closing '"
            java.lang.StringBuilder r2 = r2.append(r3)
            char r3 = (char) r9
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "' for name"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r6.c(r2)
        L41:
            char[] r2 = r6.M
            int r3 = r6.d
            int r4 = r3 + 1
            r6.d = r4
            char r3 = r2[r3]
            if (r3 > r5) goto L8d
            if (r3 != r5) goto L66
            char r2 = r6.B()
        L53:
            int r4 = r8 * 33
            int r8 = r4 + r3
            int r3 = r0 + 1
            r1[r0] = r2
            int r0 = r1.length
            if (r3 < r0) goto L8f
            com.fasterxml.jackson.core.util.b r0 = r6.n
            char[] r1 = r0.m()
            r0 = 0
            goto L18
        L66:
            if (r3 > r9) goto L8d
            if (r3 != r9) goto L84
            com.fasterxml.jackson.core.util.b r1 = r6.n
            r1.a(r0)
            com.fasterxml.jackson.core.util.b r0 = r6.n
            char[] r1 = r0.e()
            int r2 = r0.d()
            int r0 = r0.c()
            com.fasterxml.jackson.core.c.b r3 = r6.O
            java.lang.String r0 = r3.a(r1, r2, r0, r8)
            return r0
        L84:
            r2 = 32
            if (r3 >= r2) goto L8d
            java.lang.String r2 = "name"
            r6.c(r3, r2)
        L8d:
            r2 = r3
            goto L53
        L8f:
            r0 = r3
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.b.f.a(int, int, int):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:            if (r1 < r4) goto L24;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:            r5 = r7.M[r1];     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:            if (r5 >= r3) goto L31;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:            if (r2[r5] == 0) goto L34;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:            r0 = (r0 * 33) + r5;        r1 = r1 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:            if (r1 < r4) goto L40;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004b, code lost:            r2 = r7.d - 1;        r7.d = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:            return r7.O.a(r7.M, r2, r1 - r2, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:            if (java.lang.Character.isJavaIdentifierPart(r5) != false) goto L34;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006a, code lost:            r2 = r7.d - 1;        r7.d = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:            return r7.O.a(r7.M, r2, r1 - r2, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0081, code lost:            r3 = r7.d - 1;        r7.d = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:            return a(r3, r0, r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String f(int r8) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r7 = this;
            r0 = 39
            if (r8 != r0) goto L11
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES
            boolean r0 = r7.a(r0)
            if (r0 == 0) goto L11
            java.lang.String r0 = r7.F()
        L10:
            return r0
        L11:
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES
            boolean r0 = r7.a(r0)
            if (r0 != 0) goto L1e
            java.lang.String r0 = "was expecting double-quote to start field name"
            r7.b(r8, r0)
        L1e:
            int[] r2 = com.fasterxml.jackson.core.io.b.c()
            int r3 = r2.length
            if (r8 >= r3) goto L5d
            r0 = r2[r8]
            if (r0 != 0) goto L5b
            r0 = 48
            if (r8 < r0) goto L31
            r0 = 57
            if (r8 <= r0) goto L5b
        L31:
            r0 = 1
        L32:
            if (r0 != 0) goto L39
            java.lang.String r0 = "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name"
            r7.b(r8, r0)
        L39:
            int r1 = r7.d
            int r0 = r7.P
            int r4 = r7.e
            if (r1 >= r4) goto L81
        L41:
            char[] r5 = r7.M
            char r5 = r5[r1]
            if (r5 >= r3) goto L63
            r6 = r2[r5]
            if (r6 == 0) goto L7a
            int r2 = r7.d
            int r2 = r2 + (-1)
            r7.d = r1
            com.fasterxml.jackson.core.c.b r3 = r7.O
            char[] r4 = r7.M
            int r1 = r1 - r2
            java.lang.String r0 = r3.a(r4, r2, r1, r0)
            goto L10
        L5b:
            r0 = 0
            goto L32
        L5d:
            char r0 = (char) r8
            boolean r0 = java.lang.Character.isJavaIdentifierPart(r0)
            goto L32
        L63:
            char r6 = (char) r5
            boolean r6 = java.lang.Character.isJavaIdentifierPart(r6)
            if (r6 != 0) goto L7a
            int r2 = r7.d
            int r2 = r2 + (-1)
            r7.d = r1
            com.fasterxml.jackson.core.c.b r3 = r7.O
            char[] r4 = r7.M
            int r1 = r1 - r2
            java.lang.String r0 = r3.a(r4, r2, r1, r0)
            goto L10
        L7a:
            int r0 = r0 * 33
            int r0 = r0 + r5
            int r1 = r1 + 1
            if (r1 < r4) goto L41
        L81:
            int r3 = r7.d
            int r3 = r3 + (-1)
            r7.d = r1
            java.lang.String r0 = r7.a(r3, r0, r2)
            goto L10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.b.f.f(int):java.lang.String");
    }

    protected String F() throws IOException, JsonParseException {
        int i = this.d;
        int i2 = this.P;
        int i3 = this.e;
        if (i < i3) {
            int[] a2 = com.fasterxml.jackson.core.io.b.a();
            int length = a2.length;
            do {
                char c = this.M[i];
                if (c == '\'') {
                    int i4 = this.d;
                    this.d = i + 1;
                    return this.O.a(this.M, i4, i - i4, i2);
                }
                if (c < length && a2[c] != 0) {
                    break;
                }
                i2 = (i2 * 33) + c;
                i++;
            } while (i < i3);
        }
        int i5 = this.d;
        this.d = i;
        return a(i5, i2, 39);
    }

    protected JsonToken g(int i) throws IOException, JsonParseException {
        switch (i) {
            case 39:
                if (a(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
                    return G();
                }
                break;
            case 43:
                if (this.d >= this.e && !p()) {
                    D();
                }
                char[] cArr = this.M;
                int i2 = this.d;
                this.d = i2 + 1;
                return a((int) cArr[i2], false);
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

    protected JsonToken G() throws IOException, JsonParseException {
        char[] k = this.n.k();
        int l = this.n.l();
        while (true) {
            if (this.d >= this.e && !p()) {
                c(": was expecting closing quote for a string value");
            }
            char[] cArr = this.M;
            int i = this.d;
            this.d = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    c = B();
                } else if (c <= '\'') {
                    if (c != '\'') {
                        if (c < ' ') {
                            c(c, "string value");
                        }
                    } else {
                        this.n.a(l);
                        return JsonToken.VALUE_STRING;
                    }
                }
            }
            if (l >= k.length) {
                k = this.n.m();
                l = 0;
            }
            int i2 = l;
            l = i2 + 1;
            k[i2] = c;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(int r6, int r7, int[] r8) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r5 = this;
            com.fasterxml.jackson.core.util.b r0 = r5.n
            char[] r1 = r5.M
            int r2 = r5.d
            int r2 = r2 - r6
            r0.a(r1, r6, r2)
            com.fasterxml.jackson.core.util.b r0 = r5.n
            char[] r1 = r0.j()
            com.fasterxml.jackson.core.util.b r0 = r5.n
            int r0 = r0.l()
            int r3 = r8.length
        L17:
            int r2 = r5.d
            int r4 = r5.e
            if (r2 < r4) goto L3d
            boolean r2 = r5.p()
            if (r2 != 0) goto L3d
        L23:
            com.fasterxml.jackson.core.util.b r1 = r5.n
            r1.a(r0)
            com.fasterxml.jackson.core.util.b r0 = r5.n
            char[] r1 = r0.e()
            int r2 = r0.d()
            int r0 = r0.c()
            com.fasterxml.jackson.core.c.b r3 = r5.O
            java.lang.String r0 = r3.a(r1, r2, r0, r7)
            return r0
        L3d:
            char[] r2 = r5.M
            int r4 = r5.d
            char r4 = r2[r4]
            if (r4 > r3) goto L62
            r2 = r8[r4]
            if (r2 != 0) goto L23
        L49:
            int r2 = r5.d
            int r2 = r2 + 1
            r5.d = r2
            int r2 = r7 * 33
            int r7 = r2 + r4
            int r2 = r0 + 1
            r1[r0] = r4
            int r0 = r1.length
            if (r2 < r0) goto L69
            com.fasterxml.jackson.core.util.b r0 = r5.n
            char[] r1 = r0.m()
            r0 = 0
            goto L17
        L62:
            boolean r2 = java.lang.Character.isJavaIdentifierPart(r4)
            if (r2 != 0) goto L49
            goto L23
        L69:
            r0 = r2
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.b.f.a(int, int, int[]):java.lang.String");
    }

    @Override // com.fasterxml.jackson.core.a.b
    protected void q() throws IOException, JsonParseException {
        int i = this.d;
        int i2 = this.e;
        if (i < i2) {
            int[] a2 = com.fasterxml.jackson.core.io.b.a();
            int length = a2.length;
            while (true) {
                char c = this.M[i];
                if (c < length && a2[c] != 0) {
                    if (c == '\"') {
                        this.n.a(this.M, this.d, i - this.d);
                        this.d = i + 1;
                        return;
                    }
                } else {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                }
            }
        }
        this.n.b(this.M, this.d, i - this.d);
        this.d = i;
        H();
    }

    protected void H() throws IOException, JsonParseException {
        char[] j = this.n.j();
        int l = this.n.l();
        while (true) {
            if (this.d >= this.e && !p()) {
                c(": was expecting closing quote for a string value");
            }
            char[] cArr = this.M;
            int i = this.d;
            this.d = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    c = B();
                } else if (c <= '\"') {
                    if (c != '\"') {
                        if (c < ' ') {
                            c(c, "string value");
                        }
                    } else {
                        this.n.a(l);
                        return;
                    }
                }
            }
            if (l >= j.length) {
                j = this.n.m();
                l = 0;
            }
            int i2 = l;
            l = i2 + 1;
            j[i2] = c;
        }
    }

    protected void I() throws IOException, JsonParseException {
        this.Q = false;
        int i = this.d;
        int i2 = this.e;
        char[] cArr = this.M;
        while (true) {
            if (i >= i2) {
                this.d = i;
                if (!p()) {
                    c(": was expecting closing quote for a string value");
                }
                i = this.d;
                i2 = this.e;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    this.d = i3;
                    B();
                    i = this.d;
                    i2 = this.e;
                } else if (c <= '\"') {
                    if (c == '\"') {
                        this.d = i3;
                        return;
                    } else if (c < ' ') {
                        this.d = i3;
                        c(c, "string value");
                    }
                }
            }
            i = i3;
        }
    }

    protected void J() throws IOException {
        if ((this.d < this.e || p()) && this.M[this.d] == '\n') {
            this.d++;
        }
        this.g++;
        this.h = this.d;
    }

    protected void K() throws IOException {
        this.g++;
        this.h = this.d;
    }

    private int N() throws IOException, JsonParseException {
        while (true) {
            if (this.d < this.e || p()) {
                char[] cArr = this.M;
                int i = this.d;
                this.d = i + 1;
                char c = cArr[i];
                if (c > ' ') {
                    if (c != '/') {
                        return c;
                    }
                    P();
                } else if (c != ' ') {
                    if (c == '\n') {
                        K();
                    } else if (c == '\r') {
                        J();
                    } else if (c != '\t') {
                        b(c);
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
                char[] cArr = this.M;
                int i = this.d;
                this.d = i + 1;
                char c = cArr[i];
                if (c > ' ') {
                    if (c != '/') {
                        return c;
                    }
                    P();
                } else if (c != ' ') {
                    if (c == '\n') {
                        K();
                    } else if (c == '\r') {
                        J();
                    } else if (c != '\t') {
                        b(c);
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
        char[] cArr = this.M;
        int i = this.d;
        this.d = i + 1;
        char c = cArr[i];
        if (c == '/') {
            R();
        } else if (c == '*') {
            Q();
        } else {
            b(c, "was expecting either '*' or '/' for a comment");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0028, code lost:            c(" in a comment");     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Q() throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r4 = this;
            r3 = 42
        L2:
            int r0 = r4.d
            int r1 = r4.e
            if (r0 < r1) goto Le
            boolean r0 = r4.p()
            if (r0 == 0) goto L28
        Le:
            char[] r0 = r4.M
            int r1 = r4.d
            int r2 = r1 + 1
            r4.d = r2
            char r0 = r0[r1]
            if (r0 > r3) goto L2
            if (r0 != r3) goto L3f
            int r0 = r4.d
            int r1 = r4.e
            if (r0 < r1) goto L2e
            boolean r0 = r4.p()
            if (r0 != 0) goto L2e
        L28:
            java.lang.String r0 = " in a comment"
            r4.c(r0)
        L2d:
            return
        L2e:
            char[] r0 = r4.M
            int r1 = r4.d
            char r0 = r0[r1]
            r1 = 47
            if (r0 != r1) goto L2
            int r0 = r4.d
            int r0 = r0 + 1
            r4.d = r0
            goto L2d
        L3f:
            r1 = 32
            if (r0 >= r1) goto L2
            r1 = 10
            if (r0 != r1) goto L4b
            r4.K()
            goto L2
        L4b:
            r1 = 13
            if (r0 != r1) goto L53
            r4.J()
            goto L2
        L53:
            r1 = 9
            if (r0 == r1) goto L2
            r4.b(r0)
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.b.f.Q():void");
    }

    private void R() throws IOException, JsonParseException {
        while (true) {
            if (this.d < this.e || p()) {
                char[] cArr = this.M;
                int i = this.d;
                this.d = i + 1;
                char c = cArr[i];
                if (c < ' ') {
                    if (c == '\n') {
                        K();
                        return;
                    } else if (c == '\r') {
                        J();
                        return;
                    } else if (c != '\t') {
                        b(c);
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // com.fasterxml.jackson.core.a.b
    protected char B() throws IOException, JsonParseException {
        int i = 0;
        if (this.d >= this.e && !p()) {
            c(" in character escape sequence");
        }
        char[] cArr = this.M;
        int i2 = this.d;
        this.d = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\"':
            case '/':
            case '\\':
                return c;
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                for (int i3 = 0; i3 < 4; i3++) {
                    if (this.d >= this.e && !p()) {
                        c(" in character escape sequence");
                    }
                    char[] cArr2 = this.M;
                    int i4 = this.d;
                    this.d = i4 + 1;
                    char c2 = cArr2[i4];
                    int a2 = com.fasterxml.jackson.core.io.b.a(c2);
                    if (a2 < 0) {
                        b(c2, "expected a hex-digit for character escape sequence");
                    }
                    i = (i << 4) | a2;
                }
                return (char) i;
            default:
                return a(c);
        }
    }

    protected void a(String str, int i) throws IOException, JsonParseException {
        char c;
        int length = str.length();
        do {
            if (this.d >= this.e && !p()) {
                D();
            }
            if (this.M[this.d] != str.charAt(i)) {
                a(str.substring(0, i), "'null', 'true', 'false' or NaN");
            }
            this.d++;
            i++;
        } while (i < length);
        if ((this.d < this.e || p()) && (c = this.M[this.d]) >= '0' && c != ']' && c != '}' && Character.isJavaIdentifierPart(c)) {
            a(str.substring(0, i), "'null', 'true', 'false' or NaN");
        }
    }

    protected void a(String str, String str2) throws IOException, JsonParseException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.d >= this.e && !p()) {
                break;
            }
            char c = this.M[this.d];
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            this.d++;
            sb.append(c);
        }
        d("Unrecognized token '" + sb.toString() + "': was expecting ");
    }
}
