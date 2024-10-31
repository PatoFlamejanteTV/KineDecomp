package com.fasterxml.jackson.core.c;

import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.Reader;

/* compiled from: ReaderBasedJsonParser.java */
/* loaded from: classes.dex */
public class g extends com.fasterxml.jackson.core.b.b {
    protected static final int N = JsonParser.Feature.ALLOW_TRAILING_COMMA.getMask();
    protected static final int[] O = com.fasterxml.jackson.core.io.a.e();
    protected Reader P;
    protected char[] Q;
    protected boolean R;
    protected com.fasterxml.jackson.core.c S;
    protected final com.fasterxml.jackson.core.d.b T;
    protected final int U;
    protected boolean V;
    protected long W;
    protected int X;
    protected int Y;

    public g(com.fasterxml.jackson.core.io.c cVar, int i, Reader reader, com.fasterxml.jackson.core.c cVar2, com.fasterxml.jackson.core.d.b bVar, char[] cArr, int i2, int i3, boolean z) {
        super(cVar, i);
        this.P = reader;
        this.Q = cArr;
        this.p = i2;
        this.q = i3;
        this.S = cVar2;
        this.T = bVar;
        this.U = bVar.b();
        this.R = z;
    }

    private final void Aa() {
        int i = this.p;
        this.W = i;
        this.X = this.s;
        this.Y = i - this.t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:            if (r0 == '0') goto L16;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:            if (r5.p < r5.q) goto L20;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:            if (ha() == false) goto L33;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:            r0 = r5.Q;        r3 = r5.p;        r0 = r0[r3];     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:            if (r0 < '0') goto L35;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:            if (r0 <= '9') goto L24;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:            r5.p = r3 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:            if (r0 == '0') goto L36;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:            return '0';     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:            return r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private char Ba() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.p
            int r1 = r5.q
            r2 = 48
            if (r0 < r1) goto Lf
            boolean r0 = r5.ha()
            if (r0 != 0) goto Lf
            return r2
        Lf:
            char[] r0 = r5.Q
            int r1 = r5.p
            char r0 = r0[r1]
            if (r0 < r2) goto L53
            r1 = 57
            if (r0 <= r1) goto L1c
            goto L53
        L1c:
            com.fasterxml.jackson.core.JsonParser$Feature r3 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS
            boolean r3 = r5.a(r3)
            if (r3 == 0) goto L4c
            int r3 = r5.p
            int r3 = r3 + 1
            r5.p = r3
            if (r0 != r2) goto L4b
        L2c:
            int r3 = r5.p
            int r4 = r5.q
            if (r3 < r4) goto L38
            boolean r3 = r5.ha()
            if (r3 == 0) goto L4b
        L38:
            char[] r0 = r5.Q
            int r3 = r5.p
            char r0 = r0[r3]
            if (r0 < r2) goto L4a
            if (r0 <= r1) goto L43
            goto L4a
        L43:
            int r3 = r3 + 1
            r5.p = r3
            if (r0 == r2) goto L2c
            goto L4b
        L4a:
            return r2
        L4b:
            return r0
        L4c:
            java.lang.String r0 = "Leading zeroes not allowed"
            r5.g(r0)
            r0 = 0
            throw r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.g.Ba():char");
    }

    private final char Ca() throws IOException {
        char c2;
        int i = this.p;
        if (i >= this.q || ((c2 = this.Q[i]) >= '0' && c2 <= '9')) {
            return Ba();
        }
        return '0';
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r8v0 ??, r8v1 ??, r8v20 ??, r8v13 ??, r8v7 ??, r8v5 ??, r8v11 ??, r8v9 ??, r8v3 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0070 -> B:30:0x0050). Please report as a decompilation issue!!! */
    private final com.fasterxml.jackson.core.JsonToken a(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r8v0 ??, r8v1 ??, r8v20 ??, r8v13 ??, r8v7 ??, r8v5 ??, r8v11 ??, r8v9 ??, r8v3 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v0 ??
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

    private void j(int i) throws JsonParseException {
        if (i == 93) {
            za();
            if (this.x.d()) {
                this.x = this.x.h();
                this.m = JsonToken.END_ARRAY;
            } else {
                a(i, '}');
                throw null;
            }
        }
        if (i == 125) {
            za();
            if (this.x.e()) {
                this.x = this.x.h();
                this.m = JsonToken.END_OBJECT;
            } else {
                a(i, ']');
                throw null;
            }
        }
    }

    private final int k(int i) throws IOException {
        if (i != 44) {
            b(i, "was expecting comma to separate " + this.x.g() + " entries");
            throw null;
        }
        while (true) {
            int i2 = this.p;
            if (i2 < this.q) {
                char[] cArr = this.Q;
                this.p = i2 + 1;
                char c2 = cArr[i2];
                if (c2 > ' ') {
                    if (c2 != '/' && c2 != '#') {
                        return c2;
                    }
                    this.p--;
                    return ra();
                }
                if (c2 < ' ') {
                    if (c2 == '\n') {
                        this.s++;
                        this.t = this.p;
                    } else if (c2 == '\r') {
                        la();
                    } else if (c2 != '\t') {
                        c(c2);
                        throw null;
                    }
                }
            } else {
                return ra();
            }
        }
    }

    private final void l(int i) throws IOException {
        this.p++;
        if (i != 9) {
            if (i == 10) {
                this.s++;
                this.t = this.p;
            } else if (i == 13) {
                la();
            } else {
                if (i == 32) {
                    return;
                }
                b(i);
                throw null;
            }
        }
    }

    private final void na() throws IOException {
        int i;
        char c2;
        int i2 = this.p;
        if (i2 + 4 < this.q) {
            char[] cArr = this.Q;
            if (cArr[i2] == 'a') {
                int i3 = i2 + 1;
                if (cArr[i3] == 'l') {
                    int i4 = i3 + 1;
                    if (cArr[i4] == 's') {
                        int i5 = i4 + 1;
                        if (cArr[i5] == 'e' && ((c2 = cArr[(i = i5 + 1)]) < '0' || c2 == ']' || c2 == '}')) {
                            this.p = i;
                            return;
                        }
                    }
                }
            }
        }
        a("false", 1);
    }

    private final void oa() throws IOException {
        int i;
        char c2;
        int i2 = this.p;
        if (i2 + 3 < this.q) {
            char[] cArr = this.Q;
            if (cArr[i2] == 'u') {
                int i3 = i2 + 1;
                if (cArr[i3] == 'l') {
                    int i4 = i3 + 1;
                    if (cArr[i4] == 'l' && ((c2 = cArr[(i = i4 + 1)]) < '0' || c2 == ']' || c2 == '}')) {
                        this.p = i;
                        return;
                    }
                }
            }
        }
        a("null", 1);
    }

    private final void pa() throws IOException {
        int i;
        char c2;
        int i2 = this.p;
        if (i2 + 3 < this.q) {
            char[] cArr = this.Q;
            if (cArr[i2] == 'r') {
                int i3 = i2 + 1;
                if (cArr[i3] == 'u') {
                    int i4 = i3 + 1;
                    if (cArr[i4] == 'e' && ((c2 = cArr[(i = i4 + 1)]) < '0' || c2 == ']' || c2 == '}')) {
                        this.p = i;
                        return;
                    }
                }
            }
        }
        a(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
    }

    private final JsonToken qa() {
        this.B = false;
        JsonToken jsonToken = this.y;
        this.y = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            this.x = this.x.a(this.v, this.w);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this.x = this.x.b(this.v, this.w);
        }
        this.m = jsonToken;
        return jsonToken;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x004f, code lost:            return r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int ra() throws java.io.IOException {
        /*
            r3 = this;
        L0:
            int r0 = r3.p
            int r1 = r3.q
            if (r0 < r1) goto L2e
            boolean r0 = r3.ha()
            if (r0 == 0) goto Ld
            goto L2e
        Ld:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected end-of-input within/between "
            r0.append(r1)
            com.fasterxml.jackson.core.c.d r1 = r3.x
            java.lang.String r1 = r1.g()
            r0.append(r1)
            java.lang.String r1 = " entries"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.fasterxml.jackson.core.JsonParseException r0 = r3.e(r0)
            throw r0
        L2e:
            char[] r0 = r3.Q
            int r1 = r3.p
            int r2 = r1 + 1
            r3.p = r2
            char r0 = r0[r1]
            r1 = 32
            if (r0 <= r1) goto L50
            r1 = 47
            if (r0 != r1) goto L44
            r3.ua()
            goto L0
        L44:
            r1 = 35
            if (r0 != r1) goto L4f
            boolean r1 = r3.ya()
            if (r1 == 0) goto L4f
            goto L0
        L4f:
            return r0
        L50:
            if (r0 >= r1) goto L0
            r1 = 10
            if (r0 != r1) goto L61
            int r0 = r3.s
            int r0 = r0 + 1
            r3.s = r0
            int r0 = r3.p
            r3.t = r0
            goto L0
        L61:
            r1 = 13
            if (r0 != r1) goto L69
            r3.la()
            goto L0
        L69:
            r1 = 9
            if (r0 != r1) goto L6e
            goto L0
        L6e:
            r3.c(r0)
            r0 = 0
            goto L74
        L73:
            throw r0
        L74:
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.g.ra():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002a, code lost:            a(" in a comment", (com.fasterxml.jackson.core.JsonToken) null);     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002f, code lost:            throw null;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void sa() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            int r0 = r4.p
            int r1 = r4.q
            r2 = 0
            if (r0 < r1) goto Ld
            boolean r0 = r4.ha()
            if (r0 == 0) goto L2a
        Ld:
            char[] r0 = r4.Q
            int r1 = r4.p
            int r3 = r1 + 1
            r4.p = r3
            char r0 = r0[r1]
            r1 = 42
            if (r0 > r1) goto L0
            if (r0 != r1) goto L3f
            int r0 = r4.p
            int r1 = r4.q
            if (r0 < r1) goto L30
            boolean r0 = r4.ha()
            if (r0 == 0) goto L2a
            goto L30
        L2a:
            java.lang.String r0 = " in a comment"
            r4.a(r0, r2)
            throw r2
        L30:
            char[] r0 = r4.Q
            int r1 = r4.p
            char r0 = r0[r1]
            r2 = 47
            if (r0 != r2) goto L0
            int r1 = r1 + 1
            r4.p = r1
            return
        L3f:
            r1 = 32
            if (r0 >= r1) goto L0
            r1 = 10
            if (r0 != r1) goto L52
            int r0 = r4.s
            int r0 = r0 + 1
            r4.s = r0
            int r0 = r4.p
            r4.t = r0
            goto L0
        L52:
            r1 = 13
            if (r0 != r1) goto L5a
            r4.la()
            goto L0
        L5a:
            r1 = 9
            if (r0 != r1) goto L5f
            goto L0
        L5f:
            r4.c(r0)
            goto L64
        L63:
            throw r2
        L64:
            goto L63
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.g.sa():void");
    }

    private final int ta() throws IOException {
        int i = this.p;
        if (i + 4 >= this.q) {
            return a(false);
        }
        char[] cArr = this.Q;
        char c2 = cArr[i];
        if (c2 == ':') {
            int i2 = i + 1;
            this.p = i2;
            char c3 = cArr[i2];
            if (c3 > ' ') {
                if (c3 != '/' && c3 != '#') {
                    this.p++;
                    return c3;
                }
                return a(true);
            }
            if (c3 == ' ' || c3 == '\t') {
                char[] cArr2 = this.Q;
                int i3 = this.p + 1;
                this.p = i3;
                char c4 = cArr2[i3];
                if (c4 > ' ') {
                    if (c4 != '/' && c4 != '#') {
                        this.p++;
                        return c4;
                    }
                    return a(true);
                }
            }
            return a(true);
        }
        if (c2 == ' ' || c2 == '\t') {
            char[] cArr3 = this.Q;
            int i4 = this.p + 1;
            this.p = i4;
            c2 = cArr3[i4];
        }
        if (c2 == ':') {
            char[] cArr4 = this.Q;
            int i5 = this.p + 1;
            this.p = i5;
            char c5 = cArr4[i5];
            if (c5 > ' ') {
                if (c5 != '/' && c5 != '#') {
                    this.p++;
                    return c5;
                }
                return a(true);
            }
            if (c5 == ' ' || c5 == '\t') {
                char[] cArr5 = this.Q;
                int i6 = this.p + 1;
                this.p = i6;
                char c6 = cArr5[i6];
                if (c6 > ' ') {
                    if (c6 != '/' && c6 != '#') {
                        this.p++;
                        return c6;
                    }
                    return a(true);
                }
            }
            return a(true);
        }
        return a(false);
    }

    private void ua() throws IOException {
        if (a(JsonParser.Feature.ALLOW_COMMENTS)) {
            if (this.p >= this.q && !ha()) {
                a(" in a comment", (JsonToken) null);
                throw null;
            }
            char[] cArr = this.Q;
            int i = this.p;
            this.p = i + 1;
            char c2 = cArr[i];
            if (c2 == '/') {
                va();
                return;
            } else if (c2 == '*') {
                sa();
                return;
            } else {
                b(c2, "was expecting either '*' or '/' for a comment");
                throw null;
            }
        }
        b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        throw null;
    }

    private void va() throws IOException {
        while (true) {
            if (this.p >= this.q && !ha()) {
                return;
            }
            char[] cArr = this.Q;
            int i = this.p;
            this.p = i + 1;
            char c2 = cArr[i];
            if (c2 < ' ') {
                if (c2 == '\n') {
                    this.s++;
                    this.t = this.p;
                    return;
                } else if (c2 == '\r') {
                    la();
                    return;
                } else if (c2 != '\t') {
                    c(c2);
                    throw null;
                }
            }
        }
    }

    private final int wa() throws IOException {
        if (this.p >= this.q && !ha()) {
            return T();
        }
        char[] cArr = this.Q;
        int i = this.p;
        this.p = i + 1;
        char c2 = cArr[i];
        if (c2 > ' ') {
            if (c2 != '/' && c2 != '#') {
                return c2;
            }
            this.p--;
            return xa();
        }
        if (c2 != ' ') {
            if (c2 == '\n') {
                this.s++;
                this.t = this.p;
            } else if (c2 == '\r') {
                la();
            } else if (c2 != '\t') {
                c(c2);
                throw null;
            }
        }
        while (true) {
            int i2 = this.p;
            if (i2 < this.q) {
                char[] cArr2 = this.Q;
                this.p = i2 + 1;
                char c3 = cArr2[i2];
                if (c3 > ' ') {
                    if (c3 != '/' && c3 != '#') {
                        return c3;
                    }
                    this.p--;
                    return xa();
                }
                if (c3 != ' ') {
                    if (c3 == '\n') {
                        this.s++;
                        this.t = this.p;
                    } else if (c3 == '\r') {
                        la();
                    } else if (c3 != '\t') {
                        c(c3);
                        throw null;
                    }
                }
            } else {
                return xa();
            }
        }
    }

    private int xa() throws IOException {
        char c2;
        while (true) {
            if (this.p >= this.q && !ha()) {
                return T();
            }
            char[] cArr = this.Q;
            int i = this.p;
            this.p = i + 1;
            c2 = cArr[i];
            if (c2 > ' ') {
                if (c2 == '/') {
                    ua();
                } else if (c2 != '#' || !ya()) {
                    break;
                }
            } else if (c2 == ' ') {
                continue;
            } else if (c2 == '\n') {
                this.s++;
                this.t = this.p;
            } else if (c2 == '\r') {
                la();
            } else if (c2 != '\t') {
                c(c2);
                throw null;
            }
        }
        return c2;
    }

    private boolean ya() throws IOException {
        if (!a(JsonParser.Feature.ALLOW_YAML_COMMENTS)) {
            return false;
        }
        va();
        return true;
    }

    private final void za() {
        int i = this.p;
        this.u = this.r + i;
        this.v = this.s;
        this.w = i - this.t;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final String A() throws IOException {
        JsonToken jsonToken = this.m;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this.V) {
                this.V = false;
                ea();
            }
            return this.z.d();
        }
        return b(jsonToken);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final JsonToken L() throws IOException {
        JsonToken jsonToken;
        if (this.m == JsonToken.FIELD_NAME) {
            return qa();
        }
        this.D = 0;
        if (this.V) {
            ma();
        }
        int wa = wa();
        if (wa < 0) {
            close();
            this.m = null;
            return null;
        }
        this.C = null;
        if (wa != 93 && wa != 125) {
            if (this.x.i()) {
                wa = k(wa);
                if ((this.f9672a & N) != 0 && (wa == 93 || wa == 125)) {
                    j(wa);
                    return this.m;
                }
            }
            boolean e2 = this.x.e();
            if (e2) {
                Aa();
                this.x.a(wa == 34 ? ja() : e(wa));
                this.m = JsonToken.FIELD_NAME;
                wa = ta();
            }
            za();
            if (wa == 34) {
                this.V = true;
                jsonToken = JsonToken.VALUE_STRING;
            } else if (wa == 45) {
                jsonToken = ka();
            } else if (wa == 91) {
                if (!e2) {
                    this.x = this.x.a(this.v, this.w);
                }
                jsonToken = JsonToken.START_ARRAY;
            } else if (wa == 102) {
                na();
                jsonToken = JsonToken.VALUE_FALSE;
            } else if (wa == 110) {
                oa();
                jsonToken = JsonToken.VALUE_NULL;
            } else if (wa == 116) {
                pa();
                jsonToken = JsonToken.VALUE_TRUE;
            } else if (wa == 123) {
                if (!e2) {
                    this.x = this.x.b(this.v, this.w);
                }
                jsonToken = JsonToken.START_OBJECT;
            } else if (wa != 125) {
                switch (wa) {
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
                        jsonToken = i(wa);
                        break;
                    default:
                        jsonToken = h(wa);
                        break;
                }
            } else {
                b(wa, "expected a value");
                throw null;
            }
            if (e2) {
                this.y = jsonToken;
                return this.m;
            }
            this.m = jsonToken;
            return jsonToken;
        }
        j(wa);
        return this.m;
    }

    @Override // com.fasterxml.jackson.core.b.b
    protected void S() throws IOException {
        if (this.P != null) {
            if (this.n.h() || a(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this.P.close();
            }
            this.P = null;
        }
    }

    @Override // com.fasterxml.jackson.core.b.b
    protected void W() throws IOException {
        char[] cArr;
        super.W();
        this.T.d();
        if (!this.R || (cArr = this.Q) == null) {
            return;
        }
        this.Q = null;
        this.n.c(cArr);
    }

    protected char b(String str, JsonToken jsonToken) throws IOException {
        if (this.p >= this.q && !ha()) {
            a(str, jsonToken);
            throw null;
        }
        char[] cArr = this.Q;
        int i = this.p;
        this.p = i + 1;
        return cArr[i];
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation c() {
        return new JsonLocation(U(), -1L, this.p + this.r, this.s, (this.p - this.t) + 1);
    }

    protected char da() throws IOException {
        if (this.p >= this.q && !ha()) {
            a(" in character escape sequence", JsonToken.VALUE_STRING);
            throw null;
        }
        char[] cArr = this.Q;
        int i = this.p;
        this.p = i + 1;
        char c2 = cArr[i];
        if (c2 == '\"' || c2 == '/' || c2 == '\\') {
            return c2;
        }
        if (c2 == 'b') {
            return '\b';
        }
        if (c2 == 'f') {
            return '\f';
        }
        if (c2 == 'n') {
            return '\n';
        }
        if (c2 == 'r') {
            return '\r';
        }
        if (c2 == 't') {
            return '\t';
        }
        if (c2 != 'u') {
            a(c2);
            return c2;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            if (this.p >= this.q && !ha()) {
                a(" in character escape sequence", JsonToken.VALUE_STRING);
                throw null;
            }
            char[] cArr2 = this.Q;
            int i4 = this.p;
            this.p = i4 + 1;
            char c3 = cArr2[i4];
            int a2 = com.fasterxml.jackson.core.io.a.a(c3);
            if (a2 < 0) {
                b(c3, "expected a hex-digit for character escape sequence");
                throw null;
            }
            i2 = (i2 << 4) | a2;
        }
        return (char) i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:            if (r9 < r4) goto L20;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:            r5 = r8.Q;        r6 = r5[r9];     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:            if (r6 >= r2) goto L26;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:            if (r0[r6] == 0) goto L30;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:            r1 = (r1 * 33) + r6;        r9 = r9 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:            if (r9 < r4) goto L42;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:            r0 = r8.p - 1;        r8.p = r9;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004f, code lost:            return r8.T.a(r5, r0, r9 - r0, r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0055, code lost:            if (java.lang.Character.isJavaIdentifierPart(r6) != false) goto L30;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:            r0 = r8.p - 1;        r8.p = r9;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:            return r8.T.a(r8.Q, r0, r9 - r0, r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006d, code lost:            r2 = r8.p - 1;        r8.p = r9;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0076, code lost:            return a(r2, r1, r0);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String e(int r9) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 39
            if (r9 != r0) goto L11
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES
            boolean r0 = r8.a(r0)
            if (r0 == 0) goto L11
            java.lang.String r9 = r8.ia()
            return r9
        L11:
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES
            boolean r0 = r8.a(r0)
            r1 = 0
            if (r0 == 0) goto L7d
            int[] r0 = com.fasterxml.jackson.core.io.a.f()
            int r2 = r0.length
            r3 = 1
            if (r9 >= r2) goto L2a
            r4 = r0[r9]
            if (r4 != 0) goto L28
            r4 = 1
            goto L2f
        L28:
            r4 = 0
            goto L2f
        L2a:
            char r4 = (char) r9
            boolean r4 = java.lang.Character.isJavaIdentifierPart(r4)
        L2f:
            if (r4 == 0) goto L77
            int r9 = r8.p
            int r1 = r8.U
            int r4 = r8.q
            if (r9 >= r4) goto L6d
        L39:
            char[] r5 = r8.Q
            char r6 = r5[r9]
            if (r6 >= r2) goto L50
            r7 = r0[r6]
            if (r7 == 0) goto L66
            int r0 = r8.p
            int r0 = r0 - r3
            r8.p = r9
            com.fasterxml.jackson.core.d.b r2 = r8.T
            int r9 = r9 - r0
            java.lang.String r9 = r2.a(r5, r0, r9, r1)
            return r9
        L50:
            char r5 = (char) r6
            boolean r5 = java.lang.Character.isJavaIdentifierPart(r5)
            if (r5 != 0) goto L66
            int r0 = r8.p
            int r0 = r0 - r3
            r8.p = r9
            com.fasterxml.jackson.core.d.b r2 = r8.T
            char[] r3 = r8.Q
            int r9 = r9 - r0
            java.lang.String r9 = r2.a(r3, r0, r9, r1)
            return r9
        L66:
            int r1 = r1 * 33
            int r1 = r1 + r6
            int r9 = r9 + 1
            if (r9 < r4) goto L39
        L6d:
            int r2 = r8.p
            int r2 = r2 - r3
            r8.p = r9
            java.lang.String r9 = r8.a(r2, r1, r0)
            return r9
        L77:
            java.lang.String r0 = "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name"
            r8.b(r9, r0)
            throw r1
        L7d:
            java.lang.String r0 = "was expecting double-quote to start field name"
            r8.b(r9, r0)
            goto L84
        L83:
            throw r1
        L84:
            goto L83
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.g.e(int):java.lang.String");
    }

    protected final void ea() throws IOException {
        int i = this.p;
        int i2 = this.q;
        if (i < i2) {
            int[] iArr = O;
            int length = iArr.length;
            while (true) {
                char[] cArr = this.Q;
                char c2 = cArr[i];
                if (c2 >= length || iArr[c2] == 0) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                } else if (c2 == '\"') {
                    com.fasterxml.jackson.core.util.e eVar = this.z;
                    int i3 = this.p;
                    eVar.c(cArr, i3, i - i3);
                    this.p = i + 1;
                    return;
                }
            }
        }
        com.fasterxml.jackson.core.util.e eVar2 = this.z;
        char[] cArr2 = this.Q;
        int i4 = this.p;
        eVar2.b(cArr2, i4, i - i4);
        this.p = i;
        fa();
    }

    protected void fa() throws IOException {
        char[] i = this.z.i();
        int j = this.z.j();
        int[] iArr = O;
        int length = iArr.length;
        while (true) {
            if (this.p >= this.q && !ha()) {
                a(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
                throw null;
            }
            char[] cArr = this.Q;
            int i2 = this.p;
            this.p = i2 + 1;
            char c2 = cArr[i2];
            if (c2 < length && iArr[c2] != 0) {
                if (c2 == '\"') {
                    this.z.b(j);
                    return;
                } else if (c2 == '\\') {
                    c2 = da();
                } else if (c2 < ' ') {
                    c(c2, "string value");
                }
            }
            if (j >= i.length) {
                i = this.z.g();
                j = 0;
            }
            i[j] = c2;
            j++;
        }
    }

    protected JsonToken ga() throws IOException {
        char[] e2 = this.z.e();
        int j = this.z.j();
        while (true) {
            if (this.p >= this.q && !ha()) {
                a(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
                throw null;
            }
            char[] cArr = this.Q;
            int i = this.p;
            this.p = i + 1;
            char c2 = cArr[i];
            if (c2 <= '\\') {
                if (c2 == '\\') {
                    c2 = da();
                } else if (c2 <= '\'') {
                    if (c2 == '\'') {
                        this.z.b(j);
                        return JsonToken.VALUE_STRING;
                    }
                    if (c2 < ' ') {
                        c(c2, "string value");
                    }
                }
            }
            if (j >= e2.length) {
                e2 = this.z.g();
                j = 0;
            }
            e2[j] = c2;
            j++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:            if (r4 != 44) goto L47;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:            if (a(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_MISSING_VALUES) == false) goto L47;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0050, code lost:            r3.p--;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:            return com.fasterxml.jackson.core.JsonToken.VALUE_NULL;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0045, code lost:            if (r3.x.d() == false) goto L47;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.fasterxml.jackson.core.JsonToken h(int r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 39
            r1 = 0
            if (r4 == r0) goto L8c
            r0 = 73
            r2 = 1
            if (r4 == r0) goto L72
            r0 = 78
            if (r4 == r0) goto L58
            r0 = 93
            if (r4 == r0) goto L3f
            r0 = 43
            if (r4 == r0) goto L1c
            r0 = 44
            if (r4 == r0) goto L48
            goto L99
        L1c:
            int r4 = r3.p
            int r0 = r3.q
            if (r4 < r0) goto L2f
            boolean r4 = r3.ha()
            if (r4 == 0) goto L29
            goto L2f
        L29:
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT
            r3.a(r4)
            throw r1
        L2f:
            char[] r4 = r3.Q
            int r0 = r3.p
            int r1 = r0 + 1
            r3.p = r1
            char r4 = r4[r0]
            r0 = 0
            com.fasterxml.jackson.core.JsonToken r4 = r3.a(r4, r0)
            return r4
        L3f:
            com.fasterxml.jackson.core.c.d r0 = r3.x
            boolean r0 = r0.d()
            if (r0 != 0) goto L48
            goto L99
        L48:
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_MISSING_VALUES
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto L99
            int r4 = r3.p
            int r4 = r4 - r2
            r3.p = r4
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            return r4
        L58:
            java.lang.String r4 = "NaN"
            r3.a(r4, r2)
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto L6c
            r0 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            com.fasterxml.jackson.core.JsonToken r4 = r3.a(r4, r0)
            return r4
        L6c:
            java.lang.String r4 = "Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r3.f(r4)
            throw r1
        L72:
            java.lang.String r4 = "Infinity"
            r3.a(r4, r2)
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto L86
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            com.fasterxml.jackson.core.JsonToken r4 = r3.a(r4, r0)
            return r4
        L86:
            java.lang.String r4 = "Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r3.f(r4)
            throw r1
        L8c:
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto L99
            com.fasterxml.jackson.core.JsonToken r4 = r3.ga()
            return r4
        L99:
            boolean r0 = java.lang.Character.isJavaIdentifierStart(r4)
            if (r0 == 0) goto Lb7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = ""
            r0.append(r2)
            char r4 = (char) r4
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "('true', 'false' or 'null')"
            r3.a(r4, r0)
            throw r1
        Lb7:
            java.lang.String r0 = "expected a valid value (number, String, array, object, 'true', 'false' or 'null')"
            r3.b(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.g.h(int):com.fasterxml.jackson.core.JsonToken");
    }

    protected boolean ha() throws IOException {
        int i = this.q;
        long j = i;
        this.r += j;
        this.t -= i;
        this.W -= j;
        Reader reader = this.P;
        if (reader != null) {
            char[] cArr = this.Q;
            int read = reader.read(cArr, 0, cArr.length);
            if (read > 0) {
                this.p = 0;
                this.q = read;
                return true;
            }
            S();
            if (read == 0) {
                throw new IOException("Reader returned 0 characters when trying to read " + this.q);
            }
        }
        return false;
    }

    @Deprecated
    protected char i(String str) throws IOException {
        return b(str, (JsonToken) null);
    }

    protected String ia() throws IOException {
        int i = this.p;
        int i2 = this.U;
        int i3 = this.q;
        if (i < i3) {
            int[] iArr = O;
            int length = iArr.length;
            do {
                char[] cArr = this.Q;
                char c2 = cArr[i];
                if (c2 == '\'') {
                    int i4 = this.p;
                    this.p = i + 1;
                    return this.T.a(cArr, i4, i - i4, i2);
                }
                if (c2 < length && iArr[c2] != 0) {
                    break;
                }
                i2 = (i2 * 33) + c2;
                i++;
            } while (i < i3);
        }
        int i5 = this.p;
        this.p = i;
        return a(i5, i2, 39);
    }

    protected final String ja() throws IOException {
        int i = this.p;
        int i2 = this.U;
        int[] iArr = O;
        while (true) {
            if (i >= this.q) {
                break;
            }
            char[] cArr = this.Q;
            char c2 = cArr[i];
            if (c2 >= iArr.length || iArr[c2] == 0) {
                i2 = (i2 * 33) + c2;
                i++;
            } else if (c2 == '\"') {
                int i3 = this.p;
                this.p = i + 1;
                return this.T.a(cArr, i3, i - i3, i2);
            }
        }
        int i4 = this.p;
        this.p = i;
        return a(i4, i2, 34);
    }

    protected final JsonToken ka() throws IOException {
        int i = this.p;
        int i2 = i - 1;
        int i3 = this.q;
        if (i >= i3) {
            return b(true, i2);
        }
        int i4 = i + 1;
        char c2 = this.Q[i];
        if (c2 > '9' || c2 < '0') {
            this.p = i4;
            return a((int) c2, true);
        }
        if (c2 == '0') {
            return b(true, i2);
        }
        int i5 = 1;
        while (i4 < i3) {
            int i6 = i4 + 1;
            char c3 = this.Q[i4];
            if (c3 < '0' || c3 > '9') {
                if (c3 != '.' && c3 != 'e' && c3 != 'E') {
                    int i7 = i6 - 1;
                    this.p = i7;
                    if (this.x.f()) {
                        l(c3);
                    }
                    this.z.c(this.Q, i2, i7 - i2);
                    return a(true, i5);
                }
                this.p = i6;
                return a(c3, i2, i6, true, i5);
            }
            i5++;
            i4 = i6;
        }
        return b(true, i2);
    }

    protected final void la() throws IOException {
        if (this.p < this.q || ha()) {
            char[] cArr = this.Q;
            int i = this.p;
            if (cArr[i] == '\n') {
                this.p = i + 1;
            }
        }
        this.s++;
        this.t = this.p;
    }

    protected final void ma() throws IOException {
        this.V = false;
        int i = this.p;
        int i2 = this.q;
        char[] cArr = this.Q;
        while (true) {
            if (i >= i2) {
                this.p = i;
                if (ha()) {
                    i = this.p;
                    i2 = this.q;
                } else {
                    a(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
                    throw null;
                }
            }
            int i3 = i + 1;
            char c2 = cArr[i];
            if (c2 <= '\\') {
                if (c2 == '\\') {
                    this.p = i3;
                    da();
                    i = this.p;
                    i2 = this.q;
                } else if (c2 <= '\"') {
                    if (c2 == '\"') {
                        this.p = i3;
                        return;
                    } else if (c2 < ' ') {
                        this.p = i3;
                        c(c2, "string value");
                    }
                }
            }
            i = i3;
        }
    }

    protected final JsonToken i(int i) throws IOException {
        int i2 = this.p;
        int i3 = i2 - 1;
        int i4 = this.q;
        if (i == 48) {
            return b(false, i3);
        }
        int i5 = 1;
        while (i2 < i4) {
            int i6 = i2 + 1;
            char c2 = this.Q[i2];
            if (c2 < '0' || c2 > '9') {
                if (c2 != '.' && c2 != 'e' && c2 != 'E') {
                    int i7 = i6 - 1;
                    this.p = i7;
                    if (this.x.f()) {
                        l(c2);
                    }
                    this.z.c(this.Q, i3, i7 - i3);
                    return a(false, i5);
                }
                this.p = i6;
                return a(c2, i3, i6, false, i5);
            }
            i5++;
            i2 = i6;
        }
        this.p = i3;
        return b(false, i3);
    }

    protected final String b(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        int id = jsonToken.id();
        if (id == 5) {
            return this.x.b();
        }
        if (id != 6 && id != 7 && id != 8) {
            return jsonToken.asString();
        }
        return this.z.d();
    }

    private final JsonToken b(boolean z, int i) throws IOException {
        int i2;
        char b2;
        boolean z2;
        int i3;
        char i4;
        char i5;
        int i6;
        this.p = z ? i + 1 : i;
        char[] e2 = this.z.e();
        int i7 = 0;
        if (z) {
            e2[0] = '-';
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i8 = this.p;
        if (i8 < this.q) {
            char[] cArr = this.Q;
            this.p = i8 + 1;
            b2 = cArr[i8];
        } else {
            b2 = b("No digit following minus sign", JsonToken.VALUE_NUMBER_INT);
        }
        if (b2 == '0') {
            b2 = Ca();
        }
        char[] cArr2 = e2;
        int i9 = 0;
        while (b2 >= '0' && b2 <= '9') {
            i9++;
            if (i2 >= cArr2.length) {
                cArr2 = this.z.g();
                i2 = 0;
            }
            int i10 = i2 + 1;
            cArr2[i2] = b2;
            if (this.p >= this.q && !ha()) {
                i2 = i10;
                b2 = 0;
                z2 = true;
                break;
            }
            char[] cArr3 = this.Q;
            int i11 = this.p;
            this.p = i11 + 1;
            b2 = cArr3[i11];
            i2 = i10;
        }
        z2 = false;
        if (i9 == 0) {
            return a(b2, z);
        }
        if (b2 == '.') {
            if (i2 >= cArr2.length) {
                cArr2 = this.z.g();
                i2 = 0;
            }
            int i12 = i2 + 1;
            cArr2[i2] = b2;
            int i13 = 0;
            while (true) {
                if (this.p >= this.q && !ha()) {
                    z2 = true;
                    break;
                }
                char[] cArr4 = this.Q;
                int i14 = this.p;
                this.p = i14 + 1;
                b2 = cArr4[i14];
                if (b2 < '0' || b2 > '9') {
                    break;
                }
                i13++;
                if (i12 >= cArr2.length) {
                    cArr2 = this.z.g();
                    i12 = 0;
                }
                cArr2[i12] = b2;
                i12++;
            }
            if (i13 == 0) {
                d(b2, "Decimal point not followed by a digit");
                throw null;
            }
            int i15 = i12;
            i3 = i13;
            i2 = i15;
        } else {
            i3 = 0;
        }
        if (b2 == 'e' || b2 == 'E') {
            if (i2 >= cArr2.length) {
                cArr2 = this.z.g();
                i2 = 0;
            }
            int i16 = i2 + 1;
            cArr2[i2] = b2;
            int i17 = this.p;
            if (i17 < this.q) {
                char[] cArr5 = this.Q;
                this.p = i17 + 1;
                i4 = cArr5[i17];
            } else {
                i4 = i("expected a digit for number exponent");
            }
            if (i4 == '-' || i4 == '+') {
                if (i16 >= cArr2.length) {
                    cArr2 = this.z.g();
                    i16 = 0;
                }
                int i18 = i16 + 1;
                cArr2[i16] = i4;
                int i19 = this.p;
                if (i19 < this.q) {
                    char[] cArr6 = this.Q;
                    this.p = i19 + 1;
                    i5 = cArr6[i19];
                } else {
                    i5 = i("expected a digit for number exponent");
                }
                b2 = i5;
                i6 = i18;
            } else {
                b2 = i4;
                i6 = i16;
            }
            int i20 = 0;
            while (b2 <= '9' && b2 >= '0') {
                i20++;
                if (i6 >= cArr2.length) {
                    cArr2 = this.z.g();
                    i6 = 0;
                }
                i2 = i6 + 1;
                cArr2[i6] = b2;
                if (this.p >= this.q && !ha()) {
                    i7 = i20;
                    z2 = true;
                    break;
                }
                char[] cArr7 = this.Q;
                int i21 = this.p;
                this.p = i21 + 1;
                b2 = cArr7[i21];
                i6 = i2;
            }
            i2 = i6;
            i7 = i20;
            if (i7 == 0) {
                d(b2, "Exponent indicator not followed by a digit");
                throw null;
            }
        }
        if (!z2) {
            this.p--;
            if (this.x.f()) {
                l(b2);
            }
        }
        this.z.b(i2);
        return a(z, i9, i3, i7);
    }

    public g(com.fasterxml.jackson.core.io.c cVar, int i, Reader reader, com.fasterxml.jackson.core.c cVar2, com.fasterxml.jackson.core.d.b bVar) {
        super(cVar, i);
        this.P = reader;
        this.Q = cVar.c();
        this.p = 0;
        this.q = 0;
        this.S = cVar2;
        this.T = bVar;
        this.U = bVar.b();
        this.R = true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v4 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    protected com.fasterxml.jackson.core.JsonToken a(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v4 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
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

    protected void h(String str) throws IOException {
        a(str, "'null', 'true', 'false' or NaN");
        throw null;
    }

    private String a(int i, int i2, int i3) throws IOException {
        this.z.c(this.Q, i, this.p - i);
        char[] i4 = this.z.i();
        int j = this.z.j();
        while (true) {
            if (this.p >= this.q && !ha()) {
                a(" in field name", JsonToken.FIELD_NAME);
                throw null;
            }
            char[] cArr = this.Q;
            int i5 = this.p;
            this.p = i5 + 1;
            char c2 = cArr[i5];
            if (c2 <= '\\') {
                if (c2 == '\\') {
                    c2 = da();
                } else if (c2 <= i3) {
                    if (c2 == i3) {
                        this.z.b(j);
                        com.fasterxml.jackson.core.util.e eVar = this.z;
                        return this.T.a(eVar.k(), eVar.l(), eVar.o(), i2);
                    }
                    if (c2 < ' ') {
                        c(c2, "name");
                    }
                }
            }
            i2 = (i2 * 33) + c2;
            int i6 = j + 1;
            i4[j] = c2;
            if (i6 >= i4.length) {
                i4 = this.z.g();
                j = 0;
            } else {
                j = i6;
            }
        }
    }

    private final void b(String str, int i) throws IOException {
        char c2;
        int length = str.length();
        do {
            if ((this.p < this.q || ha()) && this.Q[this.p] == str.charAt(i)) {
                this.p++;
                i++;
            } else {
                h(str.substring(0, i));
                throw null;
            }
        } while (i < length);
        if ((this.p < this.q || ha()) && (c2 = this.Q[this.p]) >= '0' && c2 != ']' && c2 != '}') {
            a(str, i, c2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(int r5, int r6, int[] r7) throws java.io.IOException {
        /*
            r4 = this;
            com.fasterxml.jackson.core.util.e r0 = r4.z
            char[] r1 = r4.Q
            int r2 = r4.p
            int r2 = r2 - r5
            r0.c(r1, r5, r2)
            com.fasterxml.jackson.core.util.e r5 = r4.z
            char[] r5 = r5.i()
            com.fasterxml.jackson.core.util.e r0 = r4.z
            int r0 = r0.j()
            int r1 = r7.length
        L17:
            int r2 = r4.p
            int r3 = r4.q
            if (r2 < r3) goto L24
            boolean r2 = r4.ha()
            if (r2 != 0) goto L24
            goto L37
        L24:
            char[] r2 = r4.Q
            int r3 = r4.p
            char r2 = r2[r3]
            if (r2 > r1) goto L31
            r3 = r7[r2]
            if (r3 == 0) goto L51
            goto L37
        L31:
            boolean r3 = java.lang.Character.isJavaIdentifierPart(r2)
            if (r3 != 0) goto L51
        L37:
            com.fasterxml.jackson.core.util.e r5 = r4.z
            r5.b(r0)
            com.fasterxml.jackson.core.util.e r5 = r4.z
            char[] r7 = r5.k()
            int r0 = r5.l()
            int r5 = r5.o()
            com.fasterxml.jackson.core.d.b r1 = r4.T
            java.lang.String r5 = r1.a(r7, r0, r5, r6)
            return r5
        L51:
            int r3 = r4.p
            int r3 = r3 + 1
            r4.p = r3
            int r6 = r6 * 33
            int r6 = r6 + r2
            int r3 = r0 + 1
            r5[r0] = r2
            int r0 = r5.length
            if (r3 < r0) goto L69
            com.fasterxml.jackson.core.util.e r5 = r4.z
            char[] r5 = r5.g()
            r0 = 0
            goto L17
        L69:
            r0 = r3
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.g.a(int, int, int[]):java.lang.String");
    }

    private final int a(boolean z) throws IOException {
        while (true) {
            if (this.p >= this.q && !ha()) {
                a(" within/between " + this.x.g() + " entries", (JsonToken) null);
                throw null;
            }
            char[] cArr = this.Q;
            int i = this.p;
            this.p = i + 1;
            char c2 = cArr[i];
            if (c2 > ' ') {
                if (c2 == '/') {
                    ua();
                } else if (c2 != '#' || !ya()) {
                    if (z) {
                        return c2;
                    }
                    if (c2 != ':') {
                        b(c2, "was expecting a colon to separate field name and value");
                        throw null;
                    }
                    z = true;
                }
            } else if (c2 >= ' ') {
                continue;
            } else if (c2 == '\n') {
                this.s++;
                this.t = this.p;
            } else if (c2 == '\r') {
                la();
            } else if (c2 != '\t') {
                c(c2);
                throw null;
            }
        }
    }

    protected final void a(String str, int i) throws IOException {
        int length = str.length();
        if (this.p + length >= this.q) {
            b(str, i);
            return;
        }
        while (this.Q[this.p] == str.charAt(i)) {
            this.p++;
            i++;
            if (i >= length) {
                char c2 = this.Q[this.p];
                if (c2 < '0' || c2 == ']' || c2 == '}') {
                    return;
                }
                a(str, i, c2);
                return;
            }
        }
        h(str.substring(0, i));
        throw null;
    }

    private final void a(String str, int i, int i2) throws IOException {
        if (Character.isJavaIdentifierPart((char) i2)) {
            h(str.substring(0, i));
            throw null;
        }
    }

    protected void a(String str, String str2) throws IOException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.p >= this.q && !ha()) {
                break;
            }
            char c2 = this.Q[this.p];
            if (!Character.isJavaIdentifierPart(c2)) {
                break;
            }
            this.p++;
            sb.append(c2);
            if (sb.length() >= 256) {
                sb.append("...");
                break;
            }
        }
        a("Unrecognized token '%s': was expecting %s", sb, str2);
        throw null;
    }
}
