package com.fasterxml.jackson.core.c;

import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: UTF8StreamJsonParser.java */
/* loaded from: classes.dex */
public class j extends com.fasterxml.jackson.core.b.b {
    private static final int[] N = com.fasterxml.jackson.core.io.a.g();
    protected static final int[] O = com.fasterxml.jackson.core.io.a.e();
    protected static final int P = JsonParser.Feature.ALLOW_TRAILING_COMMA.getMask();
    protected com.fasterxml.jackson.core.c Q;
    protected final com.fasterxml.jackson.core.d.a R;
    protected int[] S;
    protected boolean T;
    private int U;
    protected int V;
    protected int W;
    protected int X;
    protected InputStream Y;
    protected byte[] Z;
    protected boolean aa;

    public j(com.fasterxml.jackson.core.io.c cVar, int i, InputStream inputStream, com.fasterxml.jackson.core.c cVar2, com.fasterxml.jackson.core.d.a aVar, byte[] bArr, int i2, int i3, boolean z) {
        super(cVar, i);
        this.S = new int[16];
        this.Y = inputStream;
        this.Q = cVar2;
        this.R = aVar;
        this.Z = bArr;
        this.p = i2;
        this.q = i3;
        this.t = i2;
        this.r = -i2;
        this.aa = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0051, code lost:            return r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int Aa() throws java.io.IOException {
        /*
            r3 = this;
        L0:
            int r0 = r3.p
            int r1 = r3.q
            if (r0 < r1) goto L2e
            boolean r0 = r3.ga()
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
            byte[] r0 = r3.Z
            int r1 = r3.p
            int r2 = r1 + 1
            r3.p = r2
            r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 32
            if (r0 <= r1) goto L52
            r1 = 47
            if (r0 != r1) goto L46
            r3.va()
            goto L0
        L46:
            r1 = 35
            if (r0 != r1) goto L51
            boolean r1 = r3.Da()
            if (r1 == 0) goto L51
            goto L0
        L51:
            return r0
        L52:
            if (r0 == r1) goto L0
            r1 = 10
            if (r0 != r1) goto L63
            int r0 = r3.s
            int r0 = r0 + 1
            r3.s = r0
            int r0 = r3.p
            r3.t = r0
            goto L0
        L63:
            r1 = 13
            if (r0 != r1) goto L6b
            r3.na()
            goto L0
        L6b:
            r1 = 9
            if (r0 != r1) goto L70
            goto L0
        L70:
            r3.c(r0)
            r0 = 0
            goto L76
        L75:
            throw r0
        L76:
            goto L75
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.j.Aa():int");
    }

    private final int Ba() throws IOException {
        if (this.p >= this.q && !ga()) {
            return T();
        }
        byte[] bArr = this.Z;
        int i = this.p;
        this.p = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 > 32) {
            if (i2 != 47 && i2 != 35) {
                return i2;
            }
            this.p--;
            return Ca();
        }
        if (i2 != 32) {
            if (i2 == 10) {
                this.s++;
                this.t = this.p;
            } else if (i2 == 13) {
                na();
            } else if (i2 != 9) {
                c(i2);
                throw null;
            }
        }
        while (true) {
            int i3 = this.p;
            if (i3 < this.q) {
                byte[] bArr2 = this.Z;
                this.p = i3 + 1;
                int i4 = bArr2[i3] & 255;
                if (i4 > 32) {
                    if (i4 != 47 && i4 != 35) {
                        return i4;
                    }
                    this.p--;
                    return Ca();
                }
                if (i4 != 32) {
                    if (i4 == 10) {
                        this.s++;
                        this.t = this.p;
                    } else if (i4 == 13) {
                        na();
                    } else if (i4 != 9) {
                        c(i4);
                        throw null;
                    }
                }
            } else {
                return Ca();
            }
        }
    }

    private final int Ca() throws IOException {
        int i;
        while (true) {
            if (this.p >= this.q && !ga()) {
                return T();
            }
            byte[] bArr = this.Z;
            int i2 = this.p;
            this.p = i2 + 1;
            i = bArr[i2] & 255;
            if (i > 32) {
                if (i == 47) {
                    va();
                } else if (i != 35 || !Da()) {
                    break;
                }
            } else if (i == 32) {
                continue;
            } else if (i == 10) {
                this.s++;
                this.t = this.p;
            } else if (i == 13) {
                na();
            } else if (i != 9) {
                c(i);
                throw null;
            }
        }
        return i;
    }

    private final boolean Da() throws IOException {
        if (!a(JsonParser.Feature.ALLOW_YAML_COMMENTS)) {
            return false;
        }
        wa();
        return true;
    }

    private final void Ea() {
        this.v = this.s;
        int i = this.p;
        this.u = this.r + i;
        this.w = i - this.t;
    }

    private final void Fa() {
        this.W = this.s;
        int i = this.p;
        this.V = i;
        this.X = i - this.t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:            if (r0 == 48) goto L16;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:            if (r5.p < r5.q) goto L20;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:            if (ga() == false) goto L34;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:            r0 = r5.Z;        r3 = r5.p;        r0 = r0[r3] & 255;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:            if (r0 < 48) goto L32;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:            if (r0 <= 57) goto L24;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:            r5.p = r3 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:            if (r0 == 48) goto L36;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:            return 48;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004f, code lost:            return r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int Ga() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.p
            int r1 = r5.q
            r2 = 48
            if (r0 < r1) goto Lf
            boolean r0 = r5.ga()
            if (r0 != 0) goto Lf
            return r2
        Lf:
            byte[] r0 = r5.Z
            int r1 = r5.p
            r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 < r2) goto L57
            r1 = 57
            if (r0 <= r1) goto L1e
            goto L57
        L1e:
            com.fasterxml.jackson.core.JsonParser$Feature r3 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS
            boolean r3 = r5.a(r3)
            if (r3 == 0) goto L50
            int r3 = r5.p
            int r3 = r3 + 1
            r5.p = r3
            if (r0 != r2) goto L4f
        L2e:
            int r3 = r5.p
            int r4 = r5.q
            if (r3 < r4) goto L3a
            boolean r3 = r5.ga()
            if (r3 == 0) goto L4f
        L3a:
            byte[] r0 = r5.Z
            int r3 = r5.p
            r0 = r0[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 < r2) goto L4e
            if (r0 <= r1) goto L47
            goto L4e
        L47:
            int r3 = r3 + 1
            r5.p = r3
            if (r0 == r2) goto L2e
            goto L4f
        L4e:
            return r2
        L4f:
            return r0
        L50:
            java.lang.String r0 = "Leading zeroes not allowed"
            r5.g(r0)
            r0 = 0
            throw r0
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.j.Ga():int");
    }

    private int Ha() throws IOException {
        if (this.p >= this.q) {
            ha();
        }
        byte[] bArr = this.Z;
        int i = this.p;
        this.p = i + 1;
        return bArr[i] & 255;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:            if (r3 == 46) goto L30;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:            if (r3 == 101) goto L30;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:            if (r3 != 69) goto L25;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:            r6.p--;        r6.z.b(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:            if (r6.x.f() == false) goto L28;     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:            r7 = r6.Z;        r8 = r6.p;        r6.p = r8 + 1;        w(r7[r8] & 255);     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:            return a(r9, r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:            return a(r1, r2, r3, r9, r5);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.fasterxml.jackson.core.JsonToken a(char[] r7, int r8, boolean r9, int r10) throws java.io.IOException {
        /*
            r6 = this;
            r1 = r7
            r2 = r8
            r5 = r10
        L3:
            int r7 = r6.p
            int r8 = r6.q
            if (r7 < r8) goto L19
            boolean r7 = r6.ga()
            if (r7 != 0) goto L19
            com.fasterxml.jackson.core.util.e r7 = r6.z
            r7.b(r2)
            com.fasterxml.jackson.core.JsonToken r7 = r6.a(r9, r5)
            return r7
        L19:
            byte[] r7 = r6.Z
            int r8 = r6.p
            int r10 = r8 + 1
            r6.p = r10
            r7 = r7[r8]
            r3 = r7 & 255(0xff, float:3.57E-43)
            r7 = 57
            if (r3 > r7) goto L42
            r7 = 48
            if (r3 >= r7) goto L2e
            goto L42
        L2e:
            int r7 = r1.length
            if (r2 < r7) goto L39
            com.fasterxml.jackson.core.util.e r7 = r6.z
            char[] r7 = r7.g()
            r2 = 0
            r1 = r7
        L39:
            int r7 = r2 + 1
            char r8 = (char) r3
            r1[r2] = r8
            int r5 = r5 + 1
            r2 = r7
            goto L3
        L42:
            r7 = 46
            if (r3 == r7) goto L76
            r7 = 101(0x65, float:1.42E-43)
            if (r3 == r7) goto L76
            r7 = 69
            if (r3 != r7) goto L4f
            goto L76
        L4f:
            int r7 = r6.p
            int r7 = r7 + (-1)
            r6.p = r7
            com.fasterxml.jackson.core.util.e r7 = r6.z
            r7.b(r2)
            com.fasterxml.jackson.core.c.d r7 = r6.x
            boolean r7 = r7.f()
            if (r7 == 0) goto L71
            byte[] r7 = r6.Z
            int r8 = r6.p
            int r10 = r8 + 1
            r6.p = r10
            r7 = r7[r8]
            r7 = r7 & 255(0xff, float:3.57E-43)
            r6.w(r7)
        L71:
            com.fasterxml.jackson.core.JsonToken r7 = r6.a(r9, r5)
            return r7
        L76:
            r0 = r6
            r4 = r9
            com.fasterxml.jackson.core.JsonToken r7 = r0.a(r1, r2, r3, r4, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.j.a(char[], int, boolean, int):com.fasterxml.jackson.core.JsonToken");
    }

    private static final int c(int i, int i2) {
        return i2 == 4 ? i : i | ((-1) << (i2 << 3));
    }

    private final String c(int i, int i2, int i3) throws IOException {
        return a(this.S, 0, i, i2, i3);
    }

    private final String d(int i, int i2) throws JsonParseException {
        int c2 = c(i, i2);
        String d2 = this.R.d(c2);
        if (d2 != null) {
            return d2;
        }
        int[] iArr = this.S;
        iArr[0] = c2;
        return a(iArr, 1, i2);
    }

    private final JsonToken p(int i) throws JsonParseException {
        if (i == 125) {
            ra();
            JsonToken jsonToken = JsonToken.END_OBJECT;
            this.m = jsonToken;
            return jsonToken;
        }
        qa();
        JsonToken jsonToken2 = JsonToken.END_ARRAY;
        this.m = jsonToken2;
        return jsonToken2;
    }

    private final int q(int i) throws IOException {
        if (this.p >= this.q) {
            ha();
        }
        byte[] bArr = this.Z;
        int i2 = this.p;
        this.p = i2 + 1;
        byte b2 = bArr[i2];
        if ((b2 & 192) == 128) {
            return ((i & 31) << 6) | (b2 & 63);
        }
        a(b2 & 255, this.p);
        throw null;
    }

    private final void qa() throws JsonParseException {
        Ea();
        if (this.x.d()) {
            this.x = this.x.h();
        } else {
            a(93, '}');
            throw null;
        }
    }

    private final int r(int i) throws IOException {
        if (this.p >= this.q) {
            ha();
        }
        int i2 = i & 15;
        byte[] bArr = this.Z;
        int i3 = this.p;
        this.p = i3 + 1;
        byte b2 = bArr[i3];
        if ((b2 & 192) == 128) {
            int i4 = (i2 << 6) | (b2 & 63);
            if (this.p >= this.q) {
                ha();
            }
            byte[] bArr2 = this.Z;
            int i5 = this.p;
            this.p = i5 + 1;
            byte b3 = bArr2[i5];
            if ((b3 & 192) == 128) {
                return (i4 << 6) | (b3 & 63);
            }
            a(b3 & 255, this.p);
            throw null;
        }
        a(b2 & 255, this.p);
        throw null;
    }

    private final void ra() throws JsonParseException {
        Ea();
        if (this.x.e()) {
            this.x = this.x.h();
        } else {
            a(125, ']');
            throw null;
        }
    }

    private final int s(int i) throws IOException {
        int i2 = i & 15;
        byte[] bArr = this.Z;
        int i3 = this.p;
        this.p = i3 + 1;
        byte b2 = bArr[i3];
        if ((b2 & 192) == 128) {
            int i4 = (i2 << 6) | (b2 & 63);
            int i5 = this.p;
            this.p = i5 + 1;
            byte b3 = bArr[i5];
            if ((b3 & 192) == 128) {
                return (i4 << 6) | (b3 & 63);
            }
            a(b3 & 255, this.p);
            throw null;
        }
        a(b2 & 255, this.p);
        throw null;
    }

    private final JsonToken sa() {
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

    private final int t(int i) throws IOException {
        if (this.p >= this.q) {
            ha();
        }
        byte[] bArr = this.Z;
        int i2 = this.p;
        this.p = i2 + 1;
        byte b2 = bArr[i2];
        if ((b2 & 192) == 128) {
            int i3 = ((i & 7) << 6) | (b2 & 63);
            if (this.p >= this.q) {
                ha();
            }
            byte[] bArr2 = this.Z;
            int i4 = this.p;
            this.p = i4 + 1;
            byte b3 = bArr2[i4];
            if ((b3 & 192) == 128) {
                int i5 = (i3 << 6) | (b3 & 63);
                if (this.p >= this.q) {
                    ha();
                }
                byte[] bArr3 = this.Z;
                int i6 = this.p;
                this.p = i6 + 1;
                byte b4 = bArr3[i6];
                if ((b4 & 192) == 128) {
                    return ((i5 << 6) | (b4 & 63)) - 65536;
                }
                a(b4 & 255, this.p);
                throw null;
            }
            a(b3 & 255, this.p);
            throw null;
        }
        a(b2 & 255, this.p);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0043, code lost:            a(" in a comment", (com.fasterxml.jackson.core.JsonToken) null);     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0048, code lost:            throw null;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void ta() throws java.io.IOException {
        /*
            r5 = this;
            int[] r0 = com.fasterxml.jackson.core.io.a.d()
        L4:
            int r1 = r5.p
            int r2 = r5.q
            r3 = 0
            if (r1 < r2) goto L11
            boolean r1 = r5.ga()
            if (r1 == 0) goto L43
        L11:
            byte[] r1 = r5.Z
            int r2 = r5.p
            int r4 = r2 + 1
            r5.p = r4
            r1 = r1[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = r0[r1]
            if (r2 == 0) goto L4
            r4 = 2
            if (r2 == r4) goto L73
            r4 = 3
            if (r2 == r4) goto L6f
            r4 = 4
            if (r2 == r4) goto L6b
            r4 = 10
            if (r2 == r4) goto L60
            r4 = 13
            if (r2 == r4) goto L5c
            r4 = 42
            if (r2 != r4) goto L58
            int r1 = r5.p
            int r2 = r5.q
            if (r1 < r2) goto L49
            boolean r1 = r5.ga()
            if (r1 == 0) goto L43
            goto L49
        L43:
            java.lang.String r0 = " in a comment"
            r5.a(r0, r3)
            throw r3
        L49:
            byte[] r1 = r5.Z
            int r2 = r5.p
            r1 = r1[r2]
            r3 = 47
            if (r1 != r3) goto L4
            int r2 = r2 + 1
            r5.p = r2
            return
        L58:
            r5.l(r1)
            throw r3
        L5c:
            r5.na()
            goto L4
        L60:
            int r1 = r5.s
            int r1 = r1 + 1
            r5.s = r1
            int r1 = r5.p
            r5.t = r1
            goto L4
        L6b:
            r5.v(r1)
            goto L4
        L6f:
            r5.ya()
            goto L4
        L73:
            r5.xa()
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.j.ta():void");
    }

    private final JsonToken u(int i) throws IOException {
        if (i == 34) {
            this.T = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this.m = jsonToken;
            return jsonToken;
        }
        if (i == 45) {
            JsonToken ma = ma();
            this.m = ma;
            return ma;
        }
        if (i == 91) {
            this.x = this.x.a(this.v, this.w);
            JsonToken jsonToken2 = JsonToken.START_ARRAY;
            this.m = jsonToken2;
            return jsonToken2;
        }
        if (i == 102) {
            ia();
            JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
            this.m = jsonToken3;
            return jsonToken3;
        }
        if (i == 110) {
            ja();
            JsonToken jsonToken4 = JsonToken.VALUE_NULL;
            this.m = jsonToken4;
            return jsonToken4;
        }
        if (i == 116) {
            ka();
            JsonToken jsonToken5 = JsonToken.VALUE_TRUE;
            this.m = jsonToken5;
            return jsonToken5;
        }
        if (i != 123) {
            switch (i) {
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
                    JsonToken k = k(i);
                    this.m = k;
                    return k;
                default:
                    JsonToken i2 = i(i);
                    this.m = i2;
                    return i2;
            }
        }
        this.x = this.x.b(this.v, this.w);
        JsonToken jsonToken6 = JsonToken.START_OBJECT;
        this.m = jsonToken6;
        return jsonToken6;
    }

    private final int ua() throws IOException {
        int i = this.p;
        if (i + 4 >= this.q) {
            return a(false);
        }
        byte[] bArr = this.Z;
        byte b2 = bArr[i];
        if (b2 == 58) {
            int i2 = i + 1;
            this.p = i2;
            byte b3 = bArr[i2];
            if (b3 > 32) {
                if (b3 != 47 && b3 != 35) {
                    this.p++;
                    return b3;
                }
                return a(true);
            }
            if (b3 == 32 || b3 == 9) {
                byte[] bArr2 = this.Z;
                int i3 = this.p + 1;
                this.p = i3;
                byte b4 = bArr2[i3];
                if (b4 > 32) {
                    if (b4 != 47 && b4 != 35) {
                        this.p++;
                        return b4;
                    }
                    return a(true);
                }
            }
            return a(true);
        }
        if (b2 == 32 || b2 == 9) {
            byte[] bArr3 = this.Z;
            int i4 = this.p + 1;
            this.p = i4;
            b2 = bArr3[i4];
        }
        if (b2 == 58) {
            byte[] bArr4 = this.Z;
            int i5 = this.p + 1;
            this.p = i5;
            byte b5 = bArr4[i5];
            if (b5 > 32) {
                if (b5 != 47 && b5 != 35) {
                    this.p++;
                    return b5;
                }
                return a(true);
            }
            if (b5 == 32 || b5 == 9) {
                byte[] bArr5 = this.Z;
                int i6 = this.p + 1;
                this.p = i6;
                byte b6 = bArr5[i6];
                if (b6 > 32) {
                    if (b6 != 47 && b6 != 35) {
                        this.p++;
                        return b6;
                    }
                    return a(true);
                }
            }
            return a(true);
        }
        return a(false);
    }

    private final void v(int i) throws IOException {
        if (this.p >= this.q) {
            ha();
        }
        byte[] bArr = this.Z;
        int i2 = this.p;
        this.p = i2 + 1;
        byte b2 = bArr[i2];
        if ((b2 & 192) == 128) {
            if (this.p >= this.q) {
                ha();
            }
            byte[] bArr2 = this.Z;
            int i3 = this.p;
            this.p = i3 + 1;
            byte b3 = bArr2[i3];
            if ((b3 & 192) == 128) {
                if (this.p >= this.q) {
                    ha();
                }
                byte[] bArr3 = this.Z;
                int i4 = this.p;
                this.p = i4 + 1;
                byte b4 = bArr3[i4];
                if ((b4 & 192) == 128) {
                    return;
                }
                a(b4 & 255, this.p);
                throw null;
            }
            a(b3 & 255, this.p);
            throw null;
        }
        a(b2 & 255, this.p);
        throw null;
    }

    private final void va() throws IOException {
        if (a(JsonParser.Feature.ALLOW_COMMENTS)) {
            if (this.p >= this.q && !ga()) {
                a(" in a comment", (JsonToken) null);
                throw null;
            }
            byte[] bArr = this.Z;
            int i = this.p;
            this.p = i + 1;
            int i2 = bArr[i] & 255;
            if (i2 == 47) {
                wa();
                return;
            } else if (i2 == 42) {
                ta();
                return;
            } else {
                b(i2, "was expecting either '*' or '/' for a comment");
                throw null;
            }
        }
        b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        throw null;
    }

    private final void w(int i) throws IOException {
        this.p++;
        if (i != 9) {
            if (i == 10) {
                this.s++;
                this.t = this.p;
            } else if (i == 13) {
                na();
            } else {
                if (i == 32) {
                    return;
                }
                b(i);
                throw null;
            }
        }
    }

    private final void wa() throws IOException {
        int[] d2 = com.fasterxml.jackson.core.io.a.d();
        while (true) {
            if (this.p >= this.q && !ga()) {
                return;
            }
            byte[] bArr = this.Z;
            int i = this.p;
            this.p = i + 1;
            int i2 = bArr[i] & 255;
            int i3 = d2[i2];
            if (i3 != 0) {
                if (i3 == 2) {
                    xa();
                } else if (i3 == 3) {
                    ya();
                } else if (i3 == 4) {
                    v(i2);
                } else if (i3 == 10) {
                    this.s++;
                    this.t = this.p;
                    return;
                } else if (i3 == 13) {
                    na();
                    return;
                } else if (i3 != 42 && i3 < 0) {
                    l(i2);
                    throw null;
                }
            }
        }
    }

    private final void xa() throws IOException {
        if (this.p >= this.q) {
            ha();
        }
        byte[] bArr = this.Z;
        int i = this.p;
        this.p = i + 1;
        byte b2 = bArr[i];
        if ((b2 & 192) == 128) {
            return;
        }
        a(b2 & 255, this.p);
        throw null;
    }

    private final void ya() throws IOException {
        if (this.p >= this.q) {
            ha();
        }
        byte[] bArr = this.Z;
        int i = this.p;
        this.p = i + 1;
        byte b2 = bArr[i];
        if ((b2 & 192) == 128) {
            if (this.p >= this.q) {
                ha();
            }
            byte[] bArr2 = this.Z;
            int i2 = this.p;
            this.p = i2 + 1;
            byte b3 = bArr2[i2];
            if ((b3 & 192) == 128) {
                return;
            }
            a(b3 & 255, this.p);
            throw null;
        }
        a(b2 & 255, this.p);
        throw null;
    }

    private final int za() throws IOException {
        while (true) {
            int i = this.p;
            if (i < this.q) {
                byte[] bArr = this.Z;
                this.p = i + 1;
                int i2 = bArr[i] & 255;
                if (i2 > 32) {
                    if (i2 != 47 && i2 != 35) {
                        return i2;
                    }
                    this.p--;
                    return Aa();
                }
                if (i2 != 32) {
                    if (i2 == 10) {
                        this.s++;
                        this.t = this.p;
                    } else if (i2 == 13) {
                        na();
                    } else if (i2 != 9) {
                        c(i2);
                        throw null;
                    }
                }
            } else {
                return Aa();
            }
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String A() throws IOException {
        JsonToken jsonToken = this.m;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this.T) {
                this.T = false;
                return ea();
            }
            return this.z.d();
        }
        return b(jsonToken);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken L() throws IOException {
        JsonToken ma;
        if (this.m == JsonToken.FIELD_NAME) {
            return sa();
        }
        this.D = 0;
        if (this.T) {
            oa();
        }
        int Ba = Ba();
        if (Ba < 0) {
            close();
            this.m = null;
            return null;
        }
        this.C = null;
        if (Ba == 93) {
            qa();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            this.m = jsonToken;
            return jsonToken;
        }
        if (Ba == 125) {
            ra();
            JsonToken jsonToken2 = JsonToken.END_OBJECT;
            this.m = jsonToken2;
            return jsonToken2;
        }
        if (this.x.i()) {
            if (Ba == 44) {
                Ba = za();
                if ((this.f9672a & P) != 0 && (Ba == 93 || Ba == 125)) {
                    return p(Ba);
                }
            } else {
                b(Ba, "was expecting comma to separate " + this.x.g() + " entries");
                throw null;
            }
        }
        if (!this.x.e()) {
            Ea();
            return u(Ba);
        }
        Fa();
        this.x.a(j(Ba));
        this.m = JsonToken.FIELD_NAME;
        int ua = ua();
        Ea();
        if (ua == 34) {
            this.T = true;
            this.y = JsonToken.VALUE_STRING;
            return this.m;
        }
        if (ua == 45) {
            ma = ma();
        } else if (ua == 91) {
            ma = JsonToken.START_ARRAY;
        } else if (ua == 102) {
            ia();
            ma = JsonToken.VALUE_FALSE;
        } else if (ua == 110) {
            ja();
            ma = JsonToken.VALUE_NULL;
        } else if (ua == 116) {
            ka();
            ma = JsonToken.VALUE_TRUE;
        } else if (ua != 123) {
            switch (ua) {
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
                    ma = k(ua);
                    break;
                default:
                    ma = i(ua);
                    break;
            }
        } else {
            ma = JsonToken.START_OBJECT;
        }
        this.y = ma;
        return this.m;
    }

    @Override // com.fasterxml.jackson.core.b.b
    protected void S() throws IOException {
        if (this.Y != null) {
            if (this.n.h() || a(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this.Y.close();
            }
            this.Y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.b.b
    public void W() throws IOException {
        byte[] bArr;
        super.W();
        this.R.e();
        if (!this.aa || (bArr = this.Z) == null) {
            return;
        }
        this.Z = com.fasterxml.jackson.core.b.c.f9683c;
        this.n.a(bArr);
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

    protected char da() throws IOException {
        if (this.p >= this.q && !ga()) {
            a(" in character escape sequence", JsonToken.VALUE_STRING);
            throw null;
        }
        byte[] bArr = this.Z;
        int i = this.p;
        this.p = i + 1;
        byte b2 = bArr[i];
        if (b2 == 34 || b2 == 47 || b2 == 92) {
            return (char) b2;
        }
        if (b2 == 98) {
            return '\b';
        }
        if (b2 == 102) {
            return '\f';
        }
        if (b2 == 110) {
            return '\n';
        }
        if (b2 == 114) {
            return '\r';
        }
        if (b2 == 116) {
            return '\t';
        }
        if (b2 != 117) {
            char e2 = (char) e((int) b2);
            a(e2);
            return e2;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            if (this.p >= this.q && !ga()) {
                a(" in character escape sequence", JsonToken.VALUE_STRING);
                throw null;
            }
            byte[] bArr2 = this.Z;
            int i4 = this.p;
            this.p = i4 + 1;
            byte b3 = bArr2[i4];
            int a2 = com.fasterxml.jackson.core.io.a.a(b3);
            if (a2 < 0) {
                b(b3, "expected a hex-digit for character escape sequence");
                throw null;
            }
            i2 = (i2 << 4) | a2;
        }
        return (char) i2;
    }

    protected int e(int i) throws IOException {
        int i2;
        char c2;
        int i3 = i & 255;
        if (i3 <= 127) {
            return i3;
        }
        if ((i3 & 224) == 192) {
            i2 = i3 & 31;
            c2 = 1;
        } else if ((i3 & 240) == 224) {
            i2 = i3 & 15;
            c2 = 2;
        } else {
            if ((i3 & 248) != 240) {
                m(i3 & 255);
                throw null;
            }
            i2 = i3 & 7;
            c2 = 3;
        }
        int Ha = Ha();
        if ((Ha & 192) != 128) {
            n(Ha & 255);
            throw null;
        }
        int i4 = (i2 << 6) | (Ha & 63);
        if (c2 <= 1) {
            return i4;
        }
        int Ha2 = Ha();
        if ((Ha2 & 192) != 128) {
            n(Ha2 & 255);
            throw null;
        }
        int i5 = (i4 << 6) | (Ha2 & 63);
        if (c2 <= 2) {
            return i5;
        }
        int Ha3 = Ha();
        if ((Ha3 & 192) == 128) {
            return (i5 << 6) | (Ha3 & 63);
        }
        n(Ha3 & 255);
        throw null;
    }

    protected String ea() throws IOException {
        int i = this.p;
        if (i >= this.q) {
            ha();
            i = this.p;
        }
        int i2 = 0;
        char[] e2 = this.z.e();
        int[] iArr = N;
        int min = Math.min(this.q, e2.length + i);
        byte[] bArr = this.Z;
        while (true) {
            if (i >= min) {
                break;
            }
            int i3 = bArr[i] & 255;
            if (iArr[i3] == 0) {
                i++;
                e2[i2] = (char) i3;
                i2++;
            } else if (i3 == 34) {
                this.p = i + 1;
                return this.z.a(i2);
            }
        }
        this.p = i;
        a(e2, i2);
        return this.z.d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:            if (r6 != 39) goto L23;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:            r5 = r1[r6];     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:            if (r5 == 1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:            if (r5 == 2) goto L44;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:            if (r5 == 3) goto L40;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:            if (r5 == 4) goto L36;     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006b, code lost:            r5 = t(r6);        r6 = r4 + 1;        r0[r4] = (char) (55296 | (r5 >> 10));     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:            if (r6 < r0.length) goto L39;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:            r0 = r9.z.g();        r6 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:            r5 = 56320 | (r5 & 1023);        r4 = r6;     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a8, code lost:            if (r4 < r0.length) goto L49;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00aa, code lost:            r0 = r9.z.g();        r4 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b1, code lost:            r0[r4] = (char) r5;        r4 = r4 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x005f, code lost:            if (r6 >= 32) goto L34;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0061, code lost:            c(r6, "string value");     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0066, code lost:            l(r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006a, code lost:            throw null;     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0092, code lost:            if ((r9.q - r9.p) < 2) goto L43;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0094, code lost:            r5 = s(r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0099, code lost:            r5 = r(r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009e, code lost:            r5 = q(r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a3, code lost:            r5 = da();     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0047, code lost:            r9.z.b(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x004e, code lost:            return com.fasterxml.jackson.core.JsonToken.VALUE_STRING;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.fasterxml.jackson.core.JsonToken fa() throws java.io.IOException {
        /*
            r9 = this;
            com.fasterxml.jackson.core.util.e r0 = r9.z
            char[] r0 = r0.e()
            int[] r1 = com.fasterxml.jackson.core.c.j.N
            byte[] r2 = r9.Z
            r3 = 0
            r4 = 0
        Lc:
            int r5 = r9.p
            int r6 = r9.q
            if (r5 < r6) goto L15
            r9.ha()
        L15:
            int r5 = r0.length
            if (r4 < r5) goto L1f
            com.fasterxml.jackson.core.util.e r0 = r9.z
            char[] r0 = r0.g()
            r4 = 0
        L1f:
            int r5 = r9.q
            int r6 = r9.p
            int r7 = r0.length
            int r7 = r7 - r4
            int r6 = r6 + r7
            if (r6 >= r5) goto L29
            r5 = r6
        L29:
            int r6 = r9.p
            if (r6 >= r5) goto Lc
            int r7 = r6 + 1
            r9.p = r7
            r6 = r2[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r7 = 39
            if (r6 == r7) goto L45
            r8 = r1[r6]
            if (r8 == 0) goto L3e
            goto L45
        L3e:
            int r7 = r4 + 1
            char r6 = (char) r6
            r0[r4] = r6
            r4 = r7
            goto L29
        L45:
            if (r6 != r7) goto L4f
            com.fasterxml.jackson.core.util.e r0 = r9.z
            r0.b(r4)
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING
            return r0
        L4f:
            r5 = r1[r6]
            r7 = 1
            if (r5 == r7) goto La3
            r7 = 2
            if (r5 == r7) goto L9e
            r8 = 3
            if (r5 == r8) goto L8d
            r7 = 4
            if (r5 == r7) goto L6b
            r0 = 32
            if (r6 >= r0) goto L66
            java.lang.String r0 = "string value"
            r9.c(r6, r0)
        L66:
            r9.l(r6)
            r0 = 0
            throw r0
        L6b:
            int r5 = r9.t(r6)
            int r6 = r4 + 1
            r7 = 55296(0xd800, float:7.7486E-41)
            int r8 = r5 >> 10
            r7 = r7 | r8
            char r7 = (char) r7
            r0[r4] = r7
            int r4 = r0.length
            if (r6 < r4) goto L84
            com.fasterxml.jackson.core.util.e r0 = r9.z
            char[] r0 = r0.g()
            r6 = 0
        L84:
            r4 = 56320(0xdc00, float:7.8921E-41)
            r5 = r5 & 1023(0x3ff, float:1.434E-42)
            r4 = r4 | r5
            r5 = r4
            r4 = r6
            goto La7
        L8d:
            int r5 = r9.q
            int r8 = r9.p
            int r5 = r5 - r8
            if (r5 < r7) goto L99
            int r5 = r9.s(r6)
            goto La7
        L99:
            int r5 = r9.r(r6)
            goto La7
        L9e:
            int r5 = r9.q(r6)
            goto La7
        La3:
            char r5 = r9.da()
        La7:
            int r6 = r0.length
            if (r4 < r6) goto Lb1
            com.fasterxml.jackson.core.util.e r0 = r9.z
            char[] r0 = r0.g()
            r4 = 0
        Lb1:
            int r6 = r4 + 1
            char r5 = (char) r5
            r0[r4] = r5
            r4 = r6
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.j.fa():com.fasterxml.jackson.core.JsonToken");
    }

    protected final boolean ga() throws IOException {
        byte[] bArr;
        int length;
        int i = this.q;
        this.r += i;
        this.t -= i;
        this.V -= i;
        InputStream inputStream = this.Y;
        if (inputStream == null || (length = (bArr = this.Z).length) == 0) {
            return false;
        }
        int read = inputStream.read(bArr, 0, length);
        if (read > 0) {
            this.p = 0;
            this.q = read;
            return true;
        }
        S();
        if (read == 0) {
            throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.Z.length + " bytes");
        }
        return false;
    }

    protected String h(int i) throws IOException {
        if (i == 39 && a(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return la();
        }
        if (a(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            int[] h2 = com.fasterxml.jackson.core.io.a.h();
            if (h2[i] == 0) {
                int[] iArr = this.S;
                int i2 = 0;
                int i3 = i;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    if (i2 < 4) {
                        i2++;
                        i5 = (i5 << 8) | i3;
                    } else {
                        if (i4 >= iArr.length) {
                            iArr = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                            this.S = iArr;
                        }
                        iArr[i4] = i5;
                        i4++;
                        i5 = i3;
                        i2 = 1;
                    }
                    if (this.p >= this.q && !ga()) {
                        a(" in field name", JsonToken.FIELD_NAME);
                        throw null;
                    }
                    byte[] bArr = this.Z;
                    int i6 = this.p;
                    i3 = bArr[i6] & 255;
                    if (h2[i3] != 0) {
                        if (i2 > 0) {
                            if (i4 >= iArr.length) {
                                int[] a2 = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                                this.S = a2;
                                iArr = a2;
                            }
                            iArr[i4] = i5;
                            i4++;
                        }
                        String b2 = this.R.b(iArr, i4);
                        return b2 == null ? a(iArr, i4, i2) : b2;
                    }
                    this.p = i6 + 1;
                }
            } else {
                b(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
                throw null;
            }
        } else {
            b((char) e(i), "was expecting double-quote to start field name");
            throw null;
        }
    }

    protected void ha() throws IOException {
        if (ga()) {
            return;
        }
        O();
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:            if (r4 != 44) goto L51;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0054, code lost:            if (a(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_MISSING_VALUES) == false) goto L33;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:            r3.p--;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005d, code lost:            return com.fasterxml.jackson.core.JsonToken.VALUE_NULL;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004b, code lost:            if (r3.x.d() == false) goto L51;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.fasterxml.jackson.core.JsonToken i(int r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 39
            r1 = 0
            if (r4 == r0) goto L98
            r0 = 73
            r2 = 1
            if (r4 == r0) goto L7e
            r0 = 78
            if (r4 == r0) goto L64
            r0 = 93
            if (r4 == r0) goto L45
            r0 = 125(0x7d, float:1.75E-43)
            if (r4 == r0) goto L5e
            r0 = 43
            if (r4 == r0) goto L20
            r0 = 44
            if (r4 == r0) goto L4e
            goto La5
        L20:
            int r4 = r3.p
            int r0 = r3.q
            if (r4 < r0) goto L33
            boolean r4 = r3.ga()
            if (r4 == 0) goto L2d
            goto L33
        L2d:
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT
            r3.a(r4)
            throw r1
        L33:
            byte[] r4 = r3.Z
            int r0 = r3.p
            int r1 = r0 + 1
            r3.p = r1
            r4 = r4[r0]
            r4 = r4 & 255(0xff, float:3.57E-43)
            r0 = 0
            com.fasterxml.jackson.core.JsonToken r4 = r3.a(r4, r0)
            return r4
        L45:
            com.fasterxml.jackson.core.c.d r0 = r3.x
            boolean r0 = r0.d()
            if (r0 != 0) goto L4e
            goto La5
        L4e:
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_MISSING_VALUES
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto L5e
            int r4 = r3.p
            int r4 = r4 - r2
            r3.p = r4
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            return r4
        L5e:
            java.lang.String r0 = "expected a value"
            r3.b(r4, r0)
            throw r1
        L64:
            java.lang.String r4 = "NaN"
            r3.a(r4, r2)
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto L78
            r0 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            com.fasterxml.jackson.core.JsonToken r4 = r3.a(r4, r0)
            return r4
        L78:
            java.lang.String r4 = "Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r3.f(r4)
            throw r1
        L7e:
            java.lang.String r4 = "Infinity"
            r3.a(r4, r2)
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto L92
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            com.fasterxml.jackson.core.JsonToken r4 = r3.a(r4, r0)
            return r4
        L92:
            java.lang.String r4 = "Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r3.f(r4)
            throw r1
        L98:
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto La5
            com.fasterxml.jackson.core.JsonToken r4 = r3.fa()
            return r4
        La5:
            boolean r0 = java.lang.Character.isJavaIdentifierStart(r4)
            if (r0 == 0) goto Lc3
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
        Lc3:
            java.lang.String r0 = "expected a valid value (number, String, array, object, 'true', 'false' or 'null')"
            r3.b(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.j.i(int):com.fasterxml.jackson.core.JsonToken");
    }

    protected final void ia() throws IOException {
        int i;
        int i2 = this.p;
        if (i2 + 4 < this.q) {
            byte[] bArr = this.Z;
            int i3 = i2 + 1;
            if (bArr[i2] == 97) {
                int i4 = i3 + 1;
                if (bArr[i3] == 108) {
                    int i5 = i4 + 1;
                    if (bArr[i4] == 115) {
                        int i6 = i5 + 1;
                        if (bArr[i5] == 101 && ((i = bArr[i6] & 255) < 48 || i == 93 || i == 125)) {
                            this.p = i6;
                            return;
                        }
                    }
                }
            }
        }
        b("false", 1);
    }

    protected final String j(int i) throws IOException {
        if (i != 34) {
            return h(i);
        }
        int i2 = this.p;
        if (i2 + 13 > this.q) {
            return pa();
        }
        byte[] bArr = this.Z;
        int[] iArr = O;
        this.p = i2 + 1;
        int i3 = bArr[i2] & 255;
        if (iArr[i3] != 0) {
            return i3 == 34 ? "" : c(0, i3, 0);
        }
        int i4 = this.p;
        this.p = i4 + 1;
        int i5 = bArr[i4] & 255;
        if (iArr[i5] != 0) {
            if (i5 == 34) {
                return d(i3, 1);
            }
            return c(i3, i5, 1);
        }
        int i6 = (i3 << 8) | i5;
        int i7 = this.p;
        this.p = i7 + 1;
        int i8 = bArr[i7] & 255;
        if (iArr[i8] != 0) {
            if (i8 == 34) {
                return d(i6, 2);
            }
            return c(i6, i8, 2);
        }
        int i9 = (i6 << 8) | i8;
        int i10 = this.p;
        this.p = i10 + 1;
        int i11 = bArr[i10] & 255;
        if (iArr[i11] != 0) {
            if (i11 == 34) {
                return d(i9, 3);
            }
            return c(i9, i11, 3);
        }
        int i12 = (i9 << 8) | i11;
        int i13 = this.p;
        this.p = i13 + 1;
        int i14 = bArr[i13] & 255;
        if (iArr[i14] == 0) {
            this.U = i12;
            return o(i14);
        }
        if (i14 == 34) {
            return d(i12, 4);
        }
        return c(i12, i14, 4);
    }

    protected final void ja() throws IOException {
        int i;
        int i2 = this.p;
        if (i2 + 3 < this.q) {
            byte[] bArr = this.Z;
            int i3 = i2 + 1;
            if (bArr[i2] == 117) {
                int i4 = i3 + 1;
                if (bArr[i3] == 108) {
                    int i5 = i4 + 1;
                    if (bArr[i4] == 108 && ((i = bArr[i5] & 255) < 48 || i == 93 || i == 125)) {
                        this.p = i5;
                        return;
                    }
                }
            }
        }
        b("null", 1);
    }

    protected JsonToken k(int i) throws IOException {
        int i2;
        char[] e2 = this.z.e();
        if (i == 48) {
            i = Ga();
        }
        e2[0] = (char) i;
        int min = Math.min(this.q, (this.p + e2.length) - 1);
        int i3 = 1;
        int i4 = 1;
        while (true) {
            int i5 = this.p;
            if (i5 >= min) {
                return a(e2, i3, false, i4);
            }
            byte[] bArr = this.Z;
            this.p = i5 + 1;
            i2 = bArr[i5] & 255;
            if (i2 < 48 || i2 > 57) {
                break;
            }
            i4++;
            e2[i3] = (char) i2;
            i3++;
        }
        if (i2 != 46 && i2 != 101 && i2 != 69) {
            this.p--;
            this.z.b(i3);
            if (this.x.f()) {
                w(i2);
            }
            return a(false, i4);
        }
        return a(e2, i3, i2, false, i4);
    }

    protected final void ka() throws IOException {
        int i;
        int i2 = this.p;
        if (i2 + 3 < this.q) {
            byte[] bArr = this.Z;
            int i3 = i2 + 1;
            if (bArr[i2] == 114) {
                int i4 = i3 + 1;
                if (bArr[i3] == 117) {
                    int i5 = i4 + 1;
                    if (bArr[i4] == 101 && ((i = bArr[i5] & 255) < 48 || i == 93 || i == 125)) {
                        this.p = i5;
                        return;
                    }
                }
            }
        }
        b(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
    }

    protected void l(int i) throws JsonParseException {
        if (i < 32) {
            c(i);
            throw null;
        }
        m(i);
        throw null;
    }

    protected String la() throws IOException {
        int i;
        if (this.p >= this.q && !ga()) {
            a(": was expecting closing ''' for field name", JsonToken.FIELD_NAME);
            throw null;
        }
        byte[] bArr = this.Z;
        int i2 = this.p;
        this.p = i2 + 1;
        int i3 = bArr[i2] & 255;
        if (i3 == 39) {
            return "";
        }
        int[] iArr = this.S;
        int[] iArr2 = O;
        int[] iArr3 = iArr;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 != 39) {
            if (iArr2[i3] != 0 && i3 != 34) {
                if (i3 != 92) {
                    c(i3, "name");
                } else {
                    i3 = da();
                }
                if (i3 > 127) {
                    if (i4 >= 4) {
                        if (i5 >= iArr3.length) {
                            iArr3 = com.fasterxml.jackson.core.b.b.a(iArr3, iArr3.length);
                            this.S = iArr3;
                        }
                        iArr3[i5] = i6;
                        i5++;
                        i4 = 0;
                        i6 = 0;
                    }
                    if (i3 < 2048) {
                        i6 = (i6 << 8) | (i3 >> 6) | 192;
                        i4++;
                    } else {
                        int i7 = (i6 << 8) | (i3 >> 12) | 224;
                        int i8 = i4 + 1;
                        if (i8 >= 4) {
                            if (i5 >= iArr3.length) {
                                int[] a2 = com.fasterxml.jackson.core.b.b.a(iArr3, iArr3.length);
                                this.S = a2;
                                iArr3 = a2;
                            }
                            iArr3[i5] = i7;
                            i5++;
                            i8 = 0;
                            i7 = 0;
                        }
                        i6 = (i7 << 8) | ((i3 >> 6) & 63) | 128;
                        i4 = i8 + 1;
                    }
                    i3 = (i3 & 63) | 128;
                }
            }
            if (i4 < 4) {
                i4++;
                i6 = i3 | (i6 << 8);
            } else {
                if (i5 >= iArr3.length) {
                    iArr3 = com.fasterxml.jackson.core.b.b.a(iArr3, iArr3.length);
                    this.S = iArr3;
                }
                iArr3[i5] = i6;
                i6 = i3;
                i5++;
                i4 = 1;
            }
            if (this.p >= this.q && !ga()) {
                a(" in field name", JsonToken.FIELD_NAME);
                throw null;
            }
            byte[] bArr2 = this.Z;
            int i9 = this.p;
            this.p = i9 + 1;
            i3 = bArr2[i9] & 255;
        }
        if (i4 > 0) {
            if (i5 >= iArr3.length) {
                int[] a3 = com.fasterxml.jackson.core.b.b.a(iArr3, iArr3.length);
                this.S = a3;
                iArr3 = a3;
            }
            i = i5 + 1;
            iArr3[i5] = c(i6, i4);
        } else {
            i = i5;
        }
        String b2 = this.R.b(iArr3, i);
        return b2 == null ? a(iArr3, i, i4) : b2;
    }

    protected void m(int i) throws JsonParseException {
        f("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
        throw null;
    }

    protected JsonToken ma() throws IOException {
        int i;
        char[] e2 = this.z.e();
        e2[0] = '-';
        if (this.p >= this.q) {
            ha();
        }
        byte[] bArr = this.Z;
        int i2 = this.p;
        this.p = i2 + 1;
        int i3 = bArr[i2] & 255;
        if (i3 <= 48) {
            if (i3 != 48) {
                return a(i3, true);
            }
            i3 = Ga();
        } else if (i3 > 57) {
            return a(i3, true);
        }
        int i4 = 2;
        e2[1] = (char) i3;
        int min = Math.min(this.q, (this.p + e2.length) - 2);
        int i5 = 1;
        while (true) {
            int i6 = this.p;
            if (i6 >= min) {
                return a(e2, i4, true, i5);
            }
            byte[] bArr2 = this.Z;
            this.p = i6 + 1;
            i = bArr2[i6] & 255;
            if (i < 48 || i > 57) {
                break;
            }
            i5++;
            e2[i4] = (char) i;
            i4++;
        }
        if (i != 46 && i != 101 && i != 69) {
            this.p--;
            this.z.b(i4);
            if (this.x.f()) {
                w(i);
            }
            return a(true, i5);
        }
        return a(e2, i4, i, true, i5);
    }

    protected void n(int i) throws JsonParseException {
        f("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
        throw null;
    }

    protected final void na() throws IOException {
        if (this.p < this.q || ga()) {
            byte[] bArr = this.Z;
            int i = this.p;
            if (bArr[i] == 10) {
                this.p = i + 1;
            }
        }
        this.s++;
        this.t = this.p;
    }

    protected final String o(int i) throws IOException {
        byte[] bArr = this.Z;
        int[] iArr = O;
        int i2 = this.p;
        this.p = i2 + 1;
        int i3 = bArr[i2] & 255;
        if (iArr[i3] != 0) {
            if (i3 == 34) {
                return b(this.U, i, 1);
            }
            return b(this.U, i, i3, 1);
        }
        int i4 = (i << 8) | i3;
        int i5 = this.p;
        this.p = i5 + 1;
        int i6 = bArr[i5] & 255;
        if (iArr[i6] != 0) {
            if (i6 == 34) {
                return b(this.U, i4, 2);
            }
            return b(this.U, i4, i6, 2);
        }
        int i7 = (i4 << 8) | i6;
        int i8 = this.p;
        this.p = i8 + 1;
        int i9 = bArr[i8] & 255;
        if (iArr[i9] != 0) {
            if (i9 == 34) {
                return b(this.U, i7, 3);
            }
            return b(this.U, i7, i9, 3);
        }
        int i10 = (i7 << 8) | i9;
        int i11 = this.p;
        this.p = i11 + 1;
        int i12 = bArr[i11] & 255;
        if (iArr[i12] == 0) {
            return b(i12, i10);
        }
        if (i12 == 34) {
            return b(this.U, i10, 4);
        }
        return b(this.U, i10, i12, 4);
    }

    protected void oa() throws IOException {
        this.T = false;
        int[] iArr = N;
        byte[] bArr = this.Z;
        while (true) {
            int i = this.p;
            int i2 = this.q;
            if (i >= i2) {
                ha();
                i = this.p;
                i2 = this.q;
            }
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    int i4 = bArr[i] & 255;
                    if (iArr[i4] != 0) {
                        this.p = i3;
                        if (i4 == 34) {
                            return;
                        }
                        int i5 = iArr[i4];
                        if (i5 == 1) {
                            da();
                        } else if (i5 == 2) {
                            xa();
                        } else if (i5 == 3) {
                            ya();
                        } else if (i5 == 4) {
                            v(i4);
                        } else if (i4 < 32) {
                            c(i4, "string value");
                        } else {
                            l(i4);
                            throw null;
                        }
                    } else {
                        i = i3;
                    }
                } else {
                    this.p = i;
                    break;
                }
            }
        }
    }

    protected String pa() throws IOException {
        if (this.p >= this.q && !ga()) {
            a(": was expecting closing '\"' for name", JsonToken.FIELD_NAME);
            throw null;
        }
        byte[] bArr = this.Z;
        int i = this.p;
        this.p = i + 1;
        int i2 = bArr[i] & 255;
        return i2 == 34 ? "" : a(this.S, 0, 0, i2, 0);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation c() {
        return new JsonLocation(U(), this.r + this.p, -1L, this.s, (this.p - this.t) + 1);
    }

    protected final String b(int i, int i2) throws IOException {
        byte[] bArr = this.Z;
        int[] iArr = O;
        int i3 = this.p;
        this.p = i3 + 1;
        int i4 = bArr[i3] & 255;
        if (iArr[i4] != 0) {
            if (i4 == 34) {
                return a(this.U, i2, i, 1);
            }
            return a(this.U, i2, i, i4, 1);
        }
        int i5 = (i << 8) | i4;
        int i6 = this.p;
        this.p = i6 + 1;
        int i7 = bArr[i6] & 255;
        if (iArr[i7] != 0) {
            if (i7 == 34) {
                return a(this.U, i2, i5, 2);
            }
            return a(this.U, i2, i5, i7, 2);
        }
        int i8 = (i5 << 8) | i7;
        int i9 = this.p;
        this.p = i9 + 1;
        int i10 = bArr[i9] & 255;
        if (iArr[i10] != 0) {
            if (i10 == 34) {
                return a(this.U, i2, i8, 3);
            }
            return a(this.U, i2, i8, i10, 3);
        }
        int i11 = (i8 << 8) | i10;
        int i12 = this.p;
        this.p = i12 + 1;
        int i13 = bArr[i12] & 255;
        if (iArr[i13] == 0) {
            return a(i13, i2, i11);
        }
        if (i13 == 34) {
            return a(this.U, i2, i11, 4);
        }
        return a(this.U, i2, i11, i13, 4);
    }

    private final JsonToken a(char[] cArr, int i, int i2, boolean z, int i3) throws IOException {
        char[] cArr2;
        int i4;
        int i5;
        boolean z2;
        int i6 = i2;
        int i7 = 0;
        if (i6 == 46) {
            cArr2 = cArr;
            int i8 = i;
            if (i8 >= cArr2.length) {
                cArr2 = this.z.g();
                i8 = 0;
            }
            i4 = i8 + 1;
            cArr2[i8] = (char) i6;
            int i9 = i6;
            int i10 = 0;
            while (true) {
                if (this.p >= this.q && !ga()) {
                    z2 = true;
                    break;
                }
                byte[] bArr = this.Z;
                int i11 = this.p;
                this.p = i11 + 1;
                i9 = bArr[i11] & 255;
                if (i9 < 48 || i9 > 57) {
                    break;
                }
                i10++;
                if (i4 >= cArr2.length) {
                    cArr2 = this.z.g();
                    i4 = 0;
                }
                cArr2[i4] = (char) i9;
                i4++;
            }
            z2 = false;
            if (i10 == 0) {
                d(i9, "Decimal point not followed by a digit");
                throw null;
            }
            int i12 = i9;
            i5 = i10;
            i6 = i12;
        } else {
            cArr2 = cArr;
            i4 = i;
            i5 = 0;
            z2 = false;
        }
        if (i6 == 101 || i6 == 69) {
            if (i4 >= cArr2.length) {
                cArr2 = this.z.g();
                i4 = 0;
            }
            int i13 = i4 + 1;
            cArr2[i4] = (char) i6;
            if (this.p >= this.q) {
                ha();
            }
            byte[] bArr2 = this.Z;
            int i14 = this.p;
            this.p = i14 + 1;
            i6 = bArr2[i14] & 255;
            if (i6 == 45 || i6 == 43) {
                if (i13 >= cArr2.length) {
                    cArr2 = this.z.g();
                    i13 = 0;
                }
                int i15 = i13 + 1;
                cArr2[i13] = (char) i6;
                if (this.p >= this.q) {
                    ha();
                }
                byte[] bArr3 = this.Z;
                int i16 = this.p;
                this.p = i16 + 1;
                i6 = bArr3[i16] & 255;
                i13 = i15;
            }
            char[] cArr3 = cArr2;
            int i17 = 0;
            while (i6 >= 48 && i6 <= 57) {
                i17++;
                if (i13 >= cArr3.length) {
                    cArr3 = this.z.g();
                    i13 = 0;
                }
                int i18 = i13 + 1;
                cArr3[i13] = (char) i6;
                if (this.p >= this.q && !ga()) {
                    i7 = i17;
                    i4 = i18;
                    z2 = true;
                    break;
                }
                byte[] bArr4 = this.Z;
                int i19 = this.p;
                this.p = i19 + 1;
                i6 = bArr4[i19] & 255;
                i13 = i18;
            }
            i7 = i17;
            i4 = i13;
            if (i7 == 0) {
                d(i6, "Exponent indicator not followed by a digit");
                throw null;
            }
        }
        if (!z2) {
            this.p--;
            if (this.x.f()) {
                w(i6);
            }
        }
        this.z.b(i4);
        return b(z, i3, i5, i7);
    }

    private final String b(int i, int i2, int i3, int i4) throws IOException {
        int[] iArr = this.S;
        iArr[0] = i;
        return a(iArr, 1, i2, i3, i4);
    }

    protected void h(String str) throws IOException {
        a(str, "'null', 'true', 'false' or NaN");
        throw null;
    }

    private final String b(int i, int i2, int i3) throws JsonParseException {
        int c2 = c(i2, i3);
        String b2 = this.R.b(i, c2);
        if (b2 != null) {
            return b2;
        }
        int[] iArr = this.S;
        iArr[0] = i;
        iArr[1] = c2;
        return a(iArr, 2, i3);
    }

    private final void b(String str, int i) throws IOException {
        int i2;
        int length = str.length();
        do {
            if ((this.p < this.q || ga()) && this.Z[this.p] == str.charAt(i)) {
                this.p++;
                i++;
            } else {
                h(str.substring(0, i));
                throw null;
            }
        } while (i < length);
        if ((this.p < this.q || ga()) && (i2 = this.Z[this.p] & 255) >= 48 && i2 != 93 && i2 != 125) {
            a(str, i, i2);
        }
    }

    protected final String a(int i, int i2, int i3) throws IOException {
        int[] iArr = this.S;
        iArr[0] = this.U;
        iArr[1] = i2;
        iArr[2] = i3;
        byte[] bArr = this.Z;
        int[] iArr2 = O;
        int i4 = i;
        int i5 = 3;
        while (true) {
            int i6 = this.p;
            if (i6 + 4 <= this.q) {
                this.p = i6 + 1;
                int i7 = bArr[i6] & 255;
                if (iArr2[i7] != 0) {
                    if (i7 == 34) {
                        return a(this.S, i5, i4, 1);
                    }
                    return a(this.S, i5, i4, i7, 1);
                }
                int i8 = (i4 << 8) | i7;
                int i9 = this.p;
                this.p = i9 + 1;
                int i10 = bArr[i9] & 255;
                if (iArr2[i10] != 0) {
                    if (i10 == 34) {
                        return a(this.S, i5, i8, 2);
                    }
                    return a(this.S, i5, i8, i10, 2);
                }
                int i11 = (i8 << 8) | i10;
                int i12 = this.p;
                this.p = i12 + 1;
                int i13 = bArr[i12] & 255;
                if (iArr2[i13] != 0) {
                    if (i13 == 34) {
                        return a(this.S, i5, i11, 3);
                    }
                    return a(this.S, i5, i11, i13, 3);
                }
                int i14 = (i11 << 8) | i13;
                int i15 = this.p;
                this.p = i15 + 1;
                i4 = bArr[i15] & 255;
                if (iArr2[i4] != 0) {
                    if (i4 == 34) {
                        return a(this.S, i5, i14, 4);
                    }
                    return a(this.S, i5, i14, i4, 4);
                }
                int[] iArr3 = this.S;
                if (i5 >= iArr3.length) {
                    this.S = com.fasterxml.jackson.core.b.b.a(iArr3, i5);
                }
                this.S[i5] = i14;
                i5++;
            } else {
                return a(this.S, i5, 0, i4, 0);
            }
        }
    }

    private final String a(int i, int i2, int i3, int i4, int i5) throws IOException {
        int[] iArr = this.S;
        iArr[0] = i;
        iArr[1] = i2;
        return a(iArr, 2, i3, i4, i5);
    }

    protected final String a(int[] iArr, int i, int i2, int i3, int i4) throws IOException {
        int[] iArr2 = O;
        while (true) {
            if (iArr2[i3] != 0) {
                if (i3 == 34) {
                    if (i4 > 0) {
                        if (i >= iArr.length) {
                            iArr = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                            this.S = iArr;
                        }
                        iArr[i] = c(i2, i4);
                        i++;
                    }
                    String b2 = this.R.b(iArr, i);
                    return b2 == null ? a(iArr, i, i4) : b2;
                }
                if (i3 != 92) {
                    c(i3, "name");
                } else {
                    i3 = da();
                }
                if (i3 > 127) {
                    if (i4 >= 4) {
                        if (i >= iArr.length) {
                            iArr = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                            this.S = iArr;
                        }
                        iArr[i] = i2;
                        i++;
                        i2 = 0;
                        i4 = 0;
                    }
                    if (i3 < 2048) {
                        i2 = (i2 << 8) | (i3 >> 6) | 192;
                        i4++;
                    } else {
                        int i5 = (i2 << 8) | (i3 >> 12) | 224;
                        int i6 = i4 + 1;
                        if (i6 >= 4) {
                            if (i >= iArr.length) {
                                iArr = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                                this.S = iArr;
                            }
                            iArr[i] = i5;
                            i++;
                            i5 = 0;
                            i6 = 0;
                        }
                        i2 = (i5 << 8) | ((i3 >> 6) & 63) | 128;
                        i4 = i6 + 1;
                    }
                    i3 = (i3 & 63) | 128;
                }
            }
            if (i4 < 4) {
                i4++;
                i2 = (i2 << 8) | i3;
            } else {
                if (i >= iArr.length) {
                    iArr = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                    this.S = iArr;
                }
                iArr[i] = i2;
                i2 = i3;
                i++;
                i4 = 1;
            }
            if (this.p >= this.q && !ga()) {
                a(" in field name", JsonToken.FIELD_NAME);
                throw null;
            }
            byte[] bArr = this.Z;
            int i7 = this.p;
            this.p = i7 + 1;
            i3 = bArr[i7] & 255;
        }
    }

    private final String a(int i, int i2, int i3, int i4) throws JsonParseException {
        int c2 = c(i3, i4);
        String b2 = this.R.b(i, i2, c2);
        if (b2 != null) {
            return b2;
        }
        int[] iArr = this.S;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = c(c2, i4);
        return a(iArr, 3, i4);
    }

    private final String a(int[] iArr, int i, int i2, int i3) throws JsonParseException {
        if (i >= iArr.length) {
            iArr = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
            this.S = iArr;
        }
        int i4 = i + 1;
        iArr[i] = c(i2, i3);
        String b2 = this.R.b(iArr, i4);
        return b2 == null ? a(iArr, i4, i3) : b2;
    }

    private final String a(int[] iArr, int i, int i2) throws JsonParseException {
        int i3;
        int i4;
        int i5;
        int i6 = ((i << 2) - 4) + i2;
        if (i2 < 4) {
            int i7 = i - 1;
            i3 = iArr[i7];
            iArr[i7] = i3 << ((4 - i2) << 3);
        } else {
            i3 = 0;
        }
        char[] e2 = this.z.e();
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            int i10 = (iArr[i8 >> 2] >> ((3 - (i8 & 3)) << 3)) & 255;
            i8++;
            if (i10 > 127) {
                if ((i10 & 224) == 192) {
                    i4 = i10 & 31;
                    i5 = 1;
                } else if ((i10 & 240) == 224) {
                    i4 = i10 & 15;
                    i5 = 2;
                } else {
                    if ((i10 & 248) != 240) {
                        m(i10);
                        throw null;
                    }
                    i4 = i10 & 7;
                    i5 = 3;
                }
                if (i8 + i5 <= i6) {
                    int i11 = iArr[i8 >> 2] >> ((3 - (i8 & 3)) << 3);
                    i8++;
                    if ((i11 & 192) != 128) {
                        n(i11);
                        throw null;
                    }
                    int i12 = (i4 << 6) | (i11 & 63);
                    if (i5 > 1) {
                        int i13 = iArr[i8 >> 2] >> ((3 - (i8 & 3)) << 3);
                        i8++;
                        if ((i13 & 192) != 128) {
                            n(i13);
                            throw null;
                        }
                        int i14 = (i13 & 63) | (i12 << 6);
                        if (i5 > 2) {
                            int i15 = iArr[i8 >> 2] >> ((3 - (i8 & 3)) << 3);
                            i8++;
                            if ((i15 & 192) != 128) {
                                n(i15 & 255);
                                throw null;
                            }
                            i12 = (i14 << 6) | (i15 & 63);
                        } else {
                            i12 = i14;
                        }
                    }
                    if (i5 > 2) {
                        int i16 = i12 - 65536;
                        if (i9 >= e2.length) {
                            e2 = this.z.f();
                        }
                        e2[i9] = (char) ((i16 >> 10) + 55296);
                        i10 = (i16 & 1023) | 56320;
                        i9++;
                    } else {
                        i10 = i12;
                    }
                } else {
                    a(" in field name", JsonToken.FIELD_NAME);
                    throw null;
                }
            }
            if (i9 >= e2.length) {
                e2 = this.z.f();
            }
            e2[i9] = (char) i10;
            i9++;
        }
        String str = new String(e2, 0, i9);
        if (i2 < 4) {
            iArr[i - 1] = i3;
        }
        return this.R.a(str, iArr, i);
    }

    private final void a(char[] cArr, int i) throws IOException {
        int[] iArr = N;
        byte[] bArr = this.Z;
        while (true) {
            int i2 = this.p;
            if (i2 >= this.q) {
                ha();
                i2 = this.p;
            }
            if (i >= cArr.length) {
                cArr = this.z.g();
                i = 0;
            }
            int min = Math.min(this.q, (cArr.length - i) + i2);
            while (true) {
                if (i2 < min) {
                    int i3 = i2 + 1;
                    int i4 = bArr[i2] & 255;
                    if (iArr[i4] != 0) {
                        this.p = i3;
                        if (i4 == 34) {
                            this.z.b(i);
                            return;
                        }
                        int i5 = iArr[i4];
                        if (i5 == 1) {
                            i4 = da();
                        } else if (i5 == 2) {
                            i4 = q(i4);
                        } else if (i5 != 3) {
                            if (i5 == 4) {
                                int t = t(i4);
                                int i6 = i + 1;
                                cArr[i] = (char) (55296 | (t >> 10));
                                if (i6 >= cArr.length) {
                                    cArr = this.z.g();
                                    i6 = 0;
                                }
                                i4 = (t & 1023) | 56320;
                                i = i6;
                            } else if (i4 < 32) {
                                c(i4, "string value");
                            } else {
                                l(i4);
                                throw null;
                            }
                        } else if (this.q - this.p >= 2) {
                            i4 = s(i4);
                        } else {
                            i4 = r(i4);
                        }
                        if (i >= cArr.length) {
                            cArr = this.z.g();
                            i = 0;
                        }
                        cArr[i] = (char) i4;
                        i++;
                    } else {
                        cArr[i] = (char) i4;
                        i2 = i3;
                        i++;
                    }
                } else {
                    this.p = i2;
                    break;
                }
            }
        }
    }

    protected JsonToken a(int i, boolean z) throws IOException {
        String str;
        if (i == 73) {
            if (this.p >= this.q && !ga()) {
                a(JsonToken.VALUE_NUMBER_FLOAT);
                throw null;
            }
            byte[] bArr = this.Z;
            int i2 = this.p;
            this.p = i2 + 1;
            i = bArr[i2];
            if (i == 78) {
                str = z ? "-INF" : "+INF";
            } else if (i == 110) {
                str = z ? "-Infinity" : "+Infinity";
            }
            a(str, 3);
            if (a(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                return a(str, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            a("Non-standard token '%s': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow", (Object) str);
            throw null;
        }
        d(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
        throw null;
    }

    protected final void a(String str, int i) throws IOException {
        int length = str.length();
        if (this.p + length >= this.q) {
            b(str, i);
            return;
        }
        while (this.Z[this.p] == str.charAt(i)) {
            this.p++;
            i++;
            if (i >= length) {
                int i2 = this.Z[this.p] & 255;
                if (i2 < 48 || i2 == 93 || i2 == 125) {
                    return;
                }
                a(str, i, i2);
                return;
            }
        }
        h(str.substring(0, i));
        throw null;
    }

    private final void a(String str, int i, int i2) throws IOException {
        if (Character.isJavaIdentifierPart((char) e(i2))) {
            h(str.substring(0, i));
            throw null;
        }
    }

    private final int a(boolean z) throws IOException {
        while (true) {
            if (this.p >= this.q && !ga()) {
                a(" within/between " + this.x.g() + " entries", (JsonToken) null);
                throw null;
            }
            byte[] bArr = this.Z;
            int i = this.p;
            this.p = i + 1;
            int i2 = bArr[i] & 255;
            if (i2 > 32) {
                if (i2 == 47) {
                    va();
                } else if (i2 != 35 || !Da()) {
                    if (z) {
                        return i2;
                    }
                    if (i2 != 58) {
                        b(i2, "was expecting a colon to separate field name and value");
                        throw null;
                    }
                    z = true;
                }
            } else if (i2 == 32) {
                continue;
            } else if (i2 == 10) {
                this.s++;
                this.t = this.p;
            } else if (i2 == 13) {
                na();
            } else if (i2 != 9) {
                c(i2);
                throw null;
            }
        }
    }

    protected void a(String str, String str2) throws IOException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.p >= this.q && !ga()) {
                break;
            }
            byte[] bArr = this.Z;
            int i = this.p;
            this.p = i + 1;
            char e2 = (char) e(bArr[i]);
            if (!Character.isJavaIdentifierPart(e2)) {
                break;
            }
            sb.append(e2);
            if (sb.length() >= 256) {
                sb.append("...");
                break;
            }
        }
        a("Unrecognized token '%s': was expecting %s", sb, str2);
        throw null;
    }

    protected void a(int i, int i2) throws JsonParseException {
        this.p = i2;
        n(i);
        throw null;
    }
}
