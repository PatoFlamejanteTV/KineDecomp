package com.fasterxml.jackson.core.c;

import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: UTF8DataInputJsonParser.java */
/* loaded from: classes.dex */
public class h extends com.fasterxml.jackson.core.b.b {
    private static final int[] N = com.fasterxml.jackson.core.io.a.g();
    protected static final int[] O = com.fasterxml.jackson.core.io.a.e();
    protected com.fasterxml.jackson.core.c P;
    protected final com.fasterxml.jackson.core.d.a Q;
    protected int[] R;
    protected boolean S;
    private int T;
    protected DataInput U;
    protected int V;

    public h(com.fasterxml.jackson.core.io.c cVar, int i, DataInput dataInput, com.fasterxml.jackson.core.c cVar2, com.fasterxml.jackson.core.d.a aVar, int i2) {
        super(cVar, i);
        this.R = new int[16];
        this.V = -1;
        this.P = cVar2;
        this.Q = aVar;
        this.U = dataInput;
        this.V = i2;
    }

    private final JsonToken a(char[] cArr, int i, int i2, boolean z, int i3) throws IOException {
        int i4;
        int i5;
        int readUnsignedByte;
        if (i2 == 46) {
            cArr[i] = (char) i2;
            char[] cArr2 = cArr;
            i++;
            int i6 = 0;
            while (true) {
                readUnsignedByte = this.U.readUnsignedByte();
                if (readUnsignedByte < 48 || readUnsignedByte > 57) {
                    break;
                }
                i6++;
                if (i >= cArr2.length) {
                    cArr2 = this.z.g();
                    i = 0;
                }
                cArr2[i] = (char) readUnsignedByte;
                i++;
            }
            if (i6 == 0) {
                d(readUnsignedByte, "Decimal point not followed by a digit");
                throw null;
            }
            i4 = i6;
            cArr = cArr2;
            i2 = readUnsignedByte;
        } else {
            i4 = 0;
        }
        if (i2 == 101 || i2 == 69) {
            if (i >= cArr.length) {
                cArr = this.z.g();
                i = 0;
            }
            int i7 = i + 1;
            cArr[i] = (char) i2;
            int readUnsignedByte2 = this.U.readUnsignedByte();
            if (readUnsignedByte2 == 45 || readUnsignedByte2 == 43) {
                if (i7 >= cArr.length) {
                    cArr = this.z.g();
                    i7 = 0;
                }
                cArr[i7] = (char) readUnsignedByte2;
                readUnsignedByte2 = this.U.readUnsignedByte();
                i7++;
            }
            i2 = readUnsignedByte2;
            char[] cArr3 = cArr;
            i5 = 0;
            while (i2 <= 57 && i2 >= 48) {
                i5++;
                if (i7 >= cArr3.length) {
                    cArr3 = this.z.g();
                    i7 = 0;
                }
                cArr3[i7] = (char) i2;
                i2 = this.U.readUnsignedByte();
                i7++;
            }
            if (i5 == 0) {
                d(i2, "Exponent indicator not followed by a digit");
                throw null;
            }
            i = i7;
        } else {
            i5 = 0;
        }
        this.V = i2;
        if (this.x.f()) {
            va();
        }
        this.z.b(i);
        return b(z, i3, i4, i5);
    }

    private static final int c(int i, int i2) {
        return i2 == 4 ? i : i | ((-1) << (i2 << 3));
    }

    private final String c(int i, int i2, int i3) throws IOException {
        return a(this.R, 0, i, i2, i3);
    }

    private String ia() throws IOException {
        char[] e2 = this.z.e();
        int[] iArr = N;
        int length = e2.length;
        int i = 0;
        while (true) {
            int readUnsignedByte = this.U.readUnsignedByte();
            if (iArr[readUnsignedByte] != 0) {
                if (readUnsignedByte == 34) {
                    return this.z.a(i);
                }
                a(e2, i, readUnsignedByte);
                return this.z.d();
            }
            int i2 = i + 1;
            e2[i] = (char) readUnsignedByte;
            if (i2 >= length) {
                a(e2, i2, this.U.readUnsignedByte());
                return this.z.d();
            }
            i = i2;
        }
    }

    private final int ja() throws IOException {
        int readUnsignedByte = this.U.readUnsignedByte();
        if (readUnsignedByte < 48 || readUnsignedByte > 57) {
            return readUnsignedByte;
        }
        if (!a(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            g("Leading zeroes not allowed");
            throw null;
        }
        while (readUnsignedByte == 48) {
            readUnsignedByte = this.U.readUnsignedByte();
        }
        return readUnsignedByte;
    }

    private final JsonToken ka() {
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

    private final void la() throws IOException {
        int[] d2 = com.fasterxml.jackson.core.io.a.d();
        int readUnsignedByte = this.U.readUnsignedByte();
        while (true) {
            int i = d2[readUnsignedByte];
            if (i != 0) {
                if (i == 2) {
                    pa();
                } else if (i == 3) {
                    qa();
                } else if (i == 4) {
                    ra();
                } else if (i == 10 || i == 13) {
                    this.s++;
                } else if (i == 42) {
                    readUnsignedByte = this.U.readUnsignedByte();
                    if (readUnsignedByte == 47) {
                        return;
                    }
                } else {
                    l(readUnsignedByte);
                    throw null;
                }
            }
            readUnsignedByte = this.U.readUnsignedByte();
        }
    }

    private final int ma() throws IOException {
        int i = this.V;
        if (i < 0) {
            i = this.U.readUnsignedByte();
        } else {
            this.V = -1;
        }
        if (i == 58) {
            int readUnsignedByte = this.U.readUnsignedByte();
            if (readUnsignedByte > 32) {
                return (readUnsignedByte == 47 || readUnsignedByte == 35) ? b(readUnsignedByte, true) : readUnsignedByte;
            }
            if ((readUnsignedByte == 32 || readUnsignedByte == 9) && (readUnsignedByte = this.U.readUnsignedByte()) > 32) {
                return (readUnsignedByte == 47 || readUnsignedByte == 35) ? b(readUnsignedByte, true) : readUnsignedByte;
            }
            return b(readUnsignedByte, true);
        }
        if (i == 32 || i == 9) {
            i = this.U.readUnsignedByte();
        }
        if (i == 58) {
            int readUnsignedByte2 = this.U.readUnsignedByte();
            if (readUnsignedByte2 > 32) {
                return (readUnsignedByte2 == 47 || readUnsignedByte2 == 35) ? b(readUnsignedByte2, true) : readUnsignedByte2;
            }
            if ((readUnsignedByte2 == 32 || readUnsignedByte2 == 9) && (readUnsignedByte2 = this.U.readUnsignedByte()) > 32) {
                return (readUnsignedByte2 == 47 || readUnsignedByte2 == 35) ? b(readUnsignedByte2, true) : readUnsignedByte2;
            }
            return b(readUnsignedByte2, true);
        }
        return b(i, false);
    }

    private void n(int i) throws JsonParseException {
        if (i == 93) {
            if (this.x.d()) {
                this.x = this.x.h();
                this.m = JsonToken.END_ARRAY;
            } else {
                a(i, '}');
                throw null;
            }
        }
        if (i == 125) {
            if (this.x.e()) {
                this.x = this.x.h();
                this.m = JsonToken.END_OBJECT;
            } else {
                a(i, ']');
                throw null;
            }
        }
    }

    private final void na() throws IOException {
        if (a(JsonParser.Feature.ALLOW_COMMENTS)) {
            int readUnsignedByte = this.U.readUnsignedByte();
            if (readUnsignedByte == 47) {
                oa();
                return;
            } else if (readUnsignedByte == 42) {
                la();
                return;
            } else {
                b(readUnsignedByte, "was expecting either '*' or '/' for a comment");
                throw null;
            }
        }
        b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        throw null;
    }

    private final int o(int i) throws IOException {
        int readUnsignedByte = this.U.readUnsignedByte();
        if ((readUnsignedByte & 192) == 128) {
            return ((i & 31) << 6) | (readUnsignedByte & 63);
        }
        t(readUnsignedByte & 255);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x002b, code lost:            r4.s++;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0031, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void oa() throws java.io.IOException {
        /*
            r4 = this;
            int[] r0 = com.fasterxml.jackson.core.io.a.d()
        L4:
            java.io.DataInput r1 = r4.U
            int r1 = r1.readUnsignedByte()
            r2 = r0[r1]
            if (r2 == 0) goto L4
            r3 = 2
            if (r2 == r3) goto L3a
            r3 = 3
            if (r2 == r3) goto L36
            r3 = 4
            if (r2 == r3) goto L32
            r3 = 10
            if (r2 == r3) goto L2b
            r3 = 13
            if (r2 == r3) goto L2b
            r3 = 42
            if (r2 == r3) goto L4
            if (r2 < 0) goto L26
            goto L4
        L26:
            r4.l(r1)
            r0 = 0
            throw r0
        L2b:
            int r0 = r4.s
            int r0 = r0 + 1
            r4.s = r0
            return
        L32:
            r4.ra()
            goto L4
        L36:
            r4.qa()
            goto L4
        L3a:
            r4.pa()
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.h.oa():void");
    }

    private final int p(int i) throws IOException {
        int i2 = i & 15;
        int readUnsignedByte = this.U.readUnsignedByte();
        if ((readUnsignedByte & 192) == 128) {
            int i3 = (i2 << 6) | (readUnsignedByte & 63);
            int readUnsignedByte2 = this.U.readUnsignedByte();
            if ((readUnsignedByte2 & 192) == 128) {
                return (i3 << 6) | (readUnsignedByte2 & 63);
            }
            t(readUnsignedByte2 & 255);
            throw null;
        }
        t(readUnsignedByte & 255);
        throw null;
    }

    private final void pa() throws IOException {
        int readUnsignedByte = this.U.readUnsignedByte();
        if ((readUnsignedByte & 192) == 128) {
            return;
        }
        t(readUnsignedByte & 255);
        throw null;
    }

    private final int q(int i) throws IOException {
        int readUnsignedByte = this.U.readUnsignedByte();
        if ((readUnsignedByte & 192) == 128) {
            int i2 = ((i & 7) << 6) | (readUnsignedByte & 63);
            int readUnsignedByte2 = this.U.readUnsignedByte();
            if ((readUnsignedByte2 & 192) == 128) {
                int i3 = (i2 << 6) | (readUnsignedByte2 & 63);
                int readUnsignedByte3 = this.U.readUnsignedByte();
                if ((readUnsignedByte3 & 192) == 128) {
                    return ((i3 << 6) | (readUnsignedByte3 & 63)) - 65536;
                }
                t(readUnsignedByte3 & 255);
                throw null;
            }
            t(readUnsignedByte2 & 255);
            throw null;
        }
        t(readUnsignedByte & 255);
        throw null;
    }

    private final void qa() throws IOException {
        int readUnsignedByte = this.U.readUnsignedByte();
        if ((readUnsignedByte & 192) == 128) {
            int readUnsignedByte2 = this.U.readUnsignedByte();
            if ((readUnsignedByte2 & 192) == 128) {
                return;
            }
            t(readUnsignedByte2 & 255);
            throw null;
        }
        t(readUnsignedByte & 255);
        throw null;
    }

    private final JsonToken r(int i) throws IOException {
        if (i == 34) {
            this.S = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this.m = jsonToken;
            return jsonToken;
        }
        if (i == 45) {
            JsonToken ga = ga();
            this.m = ga;
            return ga;
        }
        if (i == 91) {
            this.x = this.x.a(this.v, this.w);
            JsonToken jsonToken2 = JsonToken.START_ARRAY;
            this.m = jsonToken2;
            return jsonToken2;
        }
        if (i == 102) {
            a("false", 1);
            JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
            this.m = jsonToken3;
            return jsonToken3;
        }
        if (i == 110) {
            a("null", 1);
            JsonToken jsonToken4 = JsonToken.VALUE_NULL;
            this.m = jsonToken4;
            return jsonToken4;
        }
        if (i == 116) {
            a(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
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

    private final void ra() throws IOException {
        int readUnsignedByte = this.U.readUnsignedByte();
        if ((readUnsignedByte & 192) == 128) {
            int readUnsignedByte2 = this.U.readUnsignedByte();
            if ((readUnsignedByte2 & 192) == 128) {
                int readUnsignedByte3 = this.U.readUnsignedByte();
                if ((readUnsignedByte3 & 192) == 128) {
                    return;
                }
                t(readUnsignedByte3 & 255);
                throw null;
            }
            t(readUnsignedByte2 & 255);
            throw null;
        }
        t(readUnsignedByte & 255);
        throw null;
    }

    private final String s(int i) throws IOException {
        int[] iArr = O;
        int readUnsignedByte = this.U.readUnsignedByte();
        if (iArr[readUnsignedByte] != 0) {
            if (readUnsignedByte == 34) {
                return b(this.T, i, 1);
            }
            return b(this.T, i, readUnsignedByte, 1);
        }
        int i2 = (i << 8) | readUnsignedByte;
        int readUnsignedByte2 = this.U.readUnsignedByte();
        if (iArr[readUnsignedByte2] != 0) {
            if (readUnsignedByte2 == 34) {
                return b(this.T, i2, 2);
            }
            return b(this.T, i2, readUnsignedByte2, 2);
        }
        int i3 = (i2 << 8) | readUnsignedByte2;
        int readUnsignedByte3 = this.U.readUnsignedByte();
        if (iArr[readUnsignedByte3] != 0) {
            if (readUnsignedByte3 == 34) {
                return b(this.T, i3, 3);
            }
            return b(this.T, i3, readUnsignedByte3, 3);
        }
        int i4 = (i3 << 8) | readUnsignedByte3;
        int readUnsignedByte4 = this.U.readUnsignedByte();
        if (iArr[readUnsignedByte4] == 0) {
            return a(readUnsignedByte4, i4);
        }
        if (readUnsignedByte4 == 34) {
            return b(this.T, i4, 4);
        }
        return b(this.T, i4, readUnsignedByte4, 4);
    }

    private final int sa() throws IOException {
        int i = this.V;
        if (i < 0) {
            i = this.U.readUnsignedByte();
        } else {
            this.V = -1;
        }
        while (i <= 32) {
            if (i == 13 || i == 10) {
                this.s++;
            }
            i = this.U.readUnsignedByte();
        }
        return (i == 47 || i == 35) ? u(i) : i;
    }

    private void t(int i) throws JsonParseException {
        f("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
        throw null;
    }

    private final int ta() throws IOException {
        int i = this.V;
        if (i < 0) {
            try {
                i = this.U.readUnsignedByte();
            } catch (EOFException unused) {
                return T();
            }
        } else {
            this.V = -1;
        }
        while (i <= 32) {
            if (i == 13 || i == 10) {
                this.s++;
            }
            try {
                i = this.U.readUnsignedByte();
            } catch (EOFException unused2) {
                return T();
            }
        }
        return (i == 47 || i == 35) ? u(i) : i;
    }

    private final int u(int i) throws IOException {
        while (true) {
            if (i > 32) {
                if (i == 47) {
                    na();
                } else if (i != 35 || !ua()) {
                    break;
                }
            } else if (i == 13 || i == 10) {
                this.s++;
            }
            i = this.U.readUnsignedByte();
        }
        return i;
    }

    private final boolean ua() throws IOException {
        if (!a(JsonParser.Feature.ALLOW_YAML_COMMENTS)) {
            return false;
        }
        oa();
        return true;
    }

    private final void va() throws IOException {
        int i = this.V;
        if (i <= 32) {
            this.V = -1;
            if (i == 13 || i == 10) {
                this.s++;
                return;
            }
            return;
        }
        b(i);
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String A() throws IOException {
        JsonToken jsonToken = this.m;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this.S) {
                this.S = false;
                return ia();
            }
            return this.z.d();
        }
        return b(jsonToken);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken L() throws IOException {
        JsonToken ga;
        if (this.o) {
            return null;
        }
        if (this.m == JsonToken.FIELD_NAME) {
            return ka();
        }
        this.D = 0;
        if (this.S) {
            ha();
        }
        int ta = ta();
        if (ta < 0) {
            close();
            this.m = null;
            return null;
        }
        this.C = null;
        this.v = this.s;
        if (ta != 93 && ta != 125) {
            if (this.x.i()) {
                if (ta == 44) {
                    ta = sa();
                    if (JsonParser.Feature.ALLOW_TRAILING_COMMA.enabledIn(this.f9672a) && (ta == 93 || ta == 125)) {
                        n(ta);
                        return this.m;
                    }
                } else {
                    b(ta, "was expecting comma to separate " + this.x.g() + " entries");
                    throw null;
                }
            }
            if (!this.x.e()) {
                return r(ta);
            }
            this.x.a(j(ta));
            this.m = JsonToken.FIELD_NAME;
            int ma = ma();
            if (ma == 34) {
                this.S = true;
                this.y = JsonToken.VALUE_STRING;
                return this.m;
            }
            if (ma == 45) {
                ga = ga();
            } else if (ma == 91) {
                ga = JsonToken.START_ARRAY;
            } else if (ma == 102) {
                a("false", 1);
                ga = JsonToken.VALUE_FALSE;
            } else if (ma == 110) {
                a("null", 1);
                ga = JsonToken.VALUE_NULL;
            } else if (ma == 116) {
                a(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
                ga = JsonToken.VALUE_TRUE;
            } else if (ma != 123) {
                switch (ma) {
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
                        ga = k(ma);
                        break;
                    default:
                        ga = i(ma);
                        break;
                }
            } else {
                ga = JsonToken.START_OBJECT;
            }
            this.y = ga;
            return this.m;
        }
        n(ta);
        return this.m;
    }

    @Override // com.fasterxml.jackson.core.b.b
    protected void S() throws IOException {
    }

    @Override // com.fasterxml.jackson.core.b.b
    protected void W() throws IOException {
        super.W();
        this.Q.e();
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
        int readUnsignedByte = this.U.readUnsignedByte();
        if (readUnsignedByte == 34 || readUnsignedByte == 47 || readUnsignedByte == 92) {
            return (char) readUnsignedByte;
        }
        if (readUnsignedByte == 98) {
            return '\b';
        }
        if (readUnsignedByte == 102) {
            return '\f';
        }
        if (readUnsignedByte == 110) {
            return '\n';
        }
        if (readUnsignedByte == 114) {
            return '\r';
        }
        if (readUnsignedByte == 116) {
            return '\t';
        }
        if (readUnsignedByte != 117) {
            char e2 = (char) e(readUnsignedByte);
            a(e2);
            return e2;
        }
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int readUnsignedByte2 = this.U.readUnsignedByte();
            int a2 = com.fasterxml.jackson.core.io.a.a(readUnsignedByte2);
            if (a2 < 0) {
                b(readUnsignedByte2, "expected a hex-digit for character escape sequence");
                throw null;
            }
            i = (i << 4) | a2;
        }
        return (char) i;
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
        int readUnsignedByte = this.U.readUnsignedByte();
        if ((readUnsignedByte & 192) != 128) {
            t(readUnsignedByte & 255);
            throw null;
        }
        int i4 = (i2 << 6) | (readUnsignedByte & 63);
        if (c2 <= 1) {
            return i4;
        }
        int readUnsignedByte2 = this.U.readUnsignedByte();
        if ((readUnsignedByte2 & 192) != 128) {
            t(readUnsignedByte2 & 255);
            throw null;
        }
        int i5 = (i4 << 6) | (readUnsignedByte2 & 63);
        if (c2 <= 2) {
            return i5;
        }
        int readUnsignedByte3 = this.U.readUnsignedByte();
        if ((readUnsignedByte3 & 192) == 128) {
            return (i5 << 6) | (readUnsignedByte3 & 63);
        }
        t(readUnsignedByte3 & 255);
        throw null;
    }

    protected JsonToken ea() throws IOException {
        int da;
        char[] e2 = this.z.e();
        int[] iArr = N;
        int i = 0;
        while (true) {
            int length = e2.length;
            if (i >= e2.length) {
                e2 = this.z.g();
                length = e2.length;
                i = 0;
            }
            while (true) {
                int readUnsignedByte = this.U.readUnsignedByte();
                if (readUnsignedByte == 39) {
                    this.z.b(i);
                    return JsonToken.VALUE_STRING;
                }
                if (iArr[readUnsignedByte] != 0) {
                    int i2 = iArr[readUnsignedByte];
                    if (i2 == 1) {
                        da = da();
                    } else if (i2 == 2) {
                        da = o(readUnsignedByte);
                    } else if (i2 == 3) {
                        da = p(readUnsignedByte);
                    } else {
                        if (i2 != 4) {
                            if (readUnsignedByte < 32) {
                                c(readUnsignedByte, "string value");
                            }
                            l(readUnsignedByte);
                            throw null;
                        }
                        int q = q(readUnsignedByte);
                        int i3 = i + 1;
                        e2[i] = (char) (55296 | (q >> 10));
                        if (i3 >= e2.length) {
                            e2 = this.z.g();
                            i3 = 0;
                        }
                        da = 56320 | (q & 1023);
                        i = i3;
                    }
                    if (i >= e2.length) {
                        e2 = this.z.g();
                        i = 0;
                    }
                    e2[i] = (char) da;
                    i++;
                } else {
                    int i4 = i + 1;
                    e2[i] = (char) readUnsignedByte;
                    if (i4 >= length) {
                        i = i4;
                        break;
                    }
                    i = i4;
                }
            }
        }
    }

    protected String fa() throws IOException {
        int i;
        int readUnsignedByte = this.U.readUnsignedByte();
        if (readUnsignedByte == 39) {
            return "";
        }
        int[] iArr = this.R;
        int[] iArr2 = O;
        int[] iArr3 = iArr;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (readUnsignedByte != 39) {
            if (readUnsignedByte != 34 && iArr2[readUnsignedByte] != 0) {
                if (readUnsignedByte != 92) {
                    c(readUnsignedByte, "name");
                } else {
                    readUnsignedByte = da();
                }
                if (readUnsignedByte > 127) {
                    if (i2 >= 4) {
                        if (i3 >= iArr3.length) {
                            iArr3 = b(iArr3, iArr3.length);
                            this.R = iArr3;
                        }
                        iArr3[i3] = i4;
                        i3++;
                        i2 = 0;
                        i4 = 0;
                    }
                    if (readUnsignedByte < 2048) {
                        i4 = (i4 << 8) | (readUnsignedByte >> 6) | 192;
                        i2++;
                    } else {
                        int i5 = (i4 << 8) | (readUnsignedByte >> 12) | 224;
                        int i6 = i2 + 1;
                        if (i6 >= 4) {
                            if (i3 >= iArr3.length) {
                                int[] b2 = b(iArr3, iArr3.length);
                                this.R = b2;
                                iArr3 = b2;
                            }
                            iArr3[i3] = i5;
                            i3++;
                            i6 = 0;
                            i5 = 0;
                        }
                        i4 = (i5 << 8) | ((readUnsignedByte >> 6) & 63) | 128;
                        i2 = i6 + 1;
                    }
                    readUnsignedByte = (readUnsignedByte & 63) | 128;
                }
            }
            if (i2 < 4) {
                i2++;
                i4 = readUnsignedByte | (i4 << 8);
            } else {
                if (i3 >= iArr3.length) {
                    iArr3 = b(iArr3, iArr3.length);
                    this.R = iArr3;
                }
                iArr3[i3] = i4;
                i4 = readUnsignedByte;
                i3++;
                i2 = 1;
            }
            readUnsignedByte = this.U.readUnsignedByte();
        }
        if (i2 > 0) {
            if (i3 >= iArr3.length) {
                int[] b3 = b(iArr3, iArr3.length);
                this.R = b3;
                iArr3 = b3;
            }
            i = i3 + 1;
            iArr3[i3] = c(i4, i2);
        } else {
            i = i3;
        }
        String b4 = this.Q.b(iArr3, i);
        return b4 == null ? a(iArr3, i, i2) : b4;
    }

    protected JsonToken ga() throws IOException {
        int readUnsignedByte;
        char[] e2 = this.z.e();
        e2[0] = '-';
        int readUnsignedByte2 = this.U.readUnsignedByte();
        e2[1] = (char) readUnsignedByte2;
        if (readUnsignedByte2 <= 48) {
            if (readUnsignedByte2 == 48) {
                readUnsignedByte = ja();
            } else {
                return a(readUnsignedByte2, true);
            }
        } else {
            if (readUnsignedByte2 > 57) {
                return a(readUnsignedByte2, true);
            }
            readUnsignedByte = this.U.readUnsignedByte();
        }
        int i = 2;
        int i2 = 1;
        while (readUnsignedByte <= 57 && readUnsignedByte >= 48) {
            i2++;
            e2[i] = (char) readUnsignedByte;
            readUnsignedByte = this.U.readUnsignedByte();
            i++;
        }
        if (readUnsignedByte != 46 && readUnsignedByte != 101 && readUnsignedByte != 69) {
            this.z.b(i);
            this.V = readUnsignedByte;
            if (this.x.f()) {
                va();
            }
            return a(true, i2);
        }
        return a(e2, i, readUnsignedByte, true, i2);
    }

    protected String h(int i) throws IOException {
        if (i == 39 && a(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return fa();
        }
        if (a(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            int[] h2 = com.fasterxml.jackson.core.io.a.h();
            if (h2[i] == 0) {
                int[] iArr = this.R;
                int i2 = 0;
                int i3 = i;
                int i4 = 0;
                int i5 = 0;
                do {
                    if (i2 < 4) {
                        i2++;
                        i5 = (i5 << 8) | i3;
                    } else {
                        if (i4 >= iArr.length) {
                            iArr = b(iArr, iArr.length);
                            this.R = iArr;
                        }
                        iArr[i4] = i5;
                        i4++;
                        i5 = i3;
                        i2 = 1;
                    }
                    i3 = this.U.readUnsignedByte();
                } while (h2[i3] == 0);
                this.V = i3;
                if (i2 > 0) {
                    if (i4 >= iArr.length) {
                        int[] b2 = b(iArr, iArr.length);
                        this.R = b2;
                        iArr = b2;
                    }
                    iArr[i4] = i5;
                    i4++;
                }
                String b3 = this.Q.b(iArr, i4);
                return b3 == null ? a(iArr, i4, i2) : b3;
            }
            b(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
            throw null;
        }
        b((char) e(i), "was expecting double-quote to start field name");
        throw null;
    }

    protected void ha() throws IOException {
        this.S = false;
        int[] iArr = N;
        while (true) {
            int readUnsignedByte = this.U.readUnsignedByte();
            if (iArr[readUnsignedByte] != 0) {
                if (readUnsignedByte == 34) {
                    return;
                }
                int i = iArr[readUnsignedByte];
                if (i == 1) {
                    da();
                } else if (i == 2) {
                    pa();
                } else if (i == 3) {
                    qa();
                } else if (i == 4) {
                    ra();
                } else if (readUnsignedByte < 32) {
                    c(readUnsignedByte, "string value");
                } else {
                    l(readUnsignedByte);
                    throw null;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:            if (r4 != 44) goto L44;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:            if (a(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_MISSING_VALUES) == false) goto L26;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:            r3.V = r4;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:            return com.fasterxml.jackson.core.JsonToken.VALUE_NULL;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0031, code lost:            if (r3.x.d() == false) goto L44;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.fasterxml.jackson.core.JsonToken i(int r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 39
            r1 = 0
            if (r4 == r0) goto L7b
            r0 = 73
            r2 = 1
            if (r4 == r0) goto L61
            r0 = 78
            if (r4 == r0) goto L47
            r0 = 93
            if (r4 == r0) goto L2b
            r0 = 125(0x7d, float:1.75E-43)
            if (r4 == r0) goto L41
            r0 = 43
            if (r4 == r0) goto L1f
            r0 = 44
            if (r4 == r0) goto L34
            goto L88
        L1f:
            java.io.DataInput r4 = r3.U
            int r4 = r4.readUnsignedByte()
            r0 = 0
            com.fasterxml.jackson.core.JsonToken r4 = r3.a(r4, r0)
            return r4
        L2b:
            com.fasterxml.jackson.core.c.d r0 = r3.x
            boolean r0 = r0.d()
            if (r0 != 0) goto L34
            goto L88
        L34:
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_MISSING_VALUES
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto L41
            r3.V = r4
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            return r4
        L41:
            java.lang.String r0 = "expected a value"
            r3.b(r4, r0)
            throw r1
        L47:
            java.lang.String r4 = "NaN"
            r3.a(r4, r2)
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto L5b
            r0 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            com.fasterxml.jackson.core.JsonToken r4 = r3.a(r4, r0)
            return r4
        L5b:
            java.lang.String r4 = "Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r3.f(r4)
            throw r1
        L61:
            java.lang.String r4 = "Infinity"
            r3.a(r4, r2)
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto L75
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            com.fasterxml.jackson.core.JsonToken r4 = r3.a(r4, r0)
            return r4
        L75:
            java.lang.String r4 = "Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r3.f(r4)
            throw r1
        L7b:
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto L88
            com.fasterxml.jackson.core.JsonToken r4 = r3.ea()
            return r4
        L88:
            boolean r0 = java.lang.Character.isJavaIdentifierStart(r4)
            if (r0 == 0) goto La6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = ""
            r0.append(r2)
            char r2 = (char) r4
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "('true', 'false' or 'null')"
            r3.a(r4, r0, r2)
            throw r1
        La6:
            java.lang.String r0 = "expected a valid value (number, String, array, object, 'true', 'false' or 'null')"
            r3.b(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.h.i(int):com.fasterxml.jackson.core.JsonToken");
    }

    protected final String j(int i) throws IOException {
        if (i != 34) {
            return h(i);
        }
        int[] iArr = O;
        int readUnsignedByte = this.U.readUnsignedByte();
        if (iArr[readUnsignedByte] != 0) {
            return readUnsignedByte == 34 ? "" : c(0, readUnsignedByte, 0);
        }
        int readUnsignedByte2 = this.U.readUnsignedByte();
        if (iArr[readUnsignedByte2] != 0) {
            if (readUnsignedByte2 == 34) {
                return b(readUnsignedByte, 1);
            }
            return c(readUnsignedByte, readUnsignedByte2, 1);
        }
        int i2 = (readUnsignedByte << 8) | readUnsignedByte2;
        int readUnsignedByte3 = this.U.readUnsignedByte();
        if (iArr[readUnsignedByte3] != 0) {
            if (readUnsignedByte3 == 34) {
                return b(i2, 2);
            }
            return c(i2, readUnsignedByte3, 2);
        }
        int i3 = (i2 << 8) | readUnsignedByte3;
        int readUnsignedByte4 = this.U.readUnsignedByte();
        if (iArr[readUnsignedByte4] != 0) {
            if (readUnsignedByte4 == 34) {
                return b(i3, 3);
            }
            return c(i3, readUnsignedByte4, 3);
        }
        int i4 = (i3 << 8) | readUnsignedByte4;
        int readUnsignedByte5 = this.U.readUnsignedByte();
        if (iArr[readUnsignedByte5] == 0) {
            this.T = i4;
            return s(readUnsignedByte5);
        }
        if (readUnsignedByte5 == 34) {
            return b(i4, 4);
        }
        return c(i4, readUnsignedByte5, 4);
    }

    protected JsonToken k(int i) throws IOException {
        int readUnsignedByte;
        char[] e2 = this.z.e();
        int i2 = 1;
        if (i == 48) {
            readUnsignedByte = ja();
            if (readUnsignedByte > 57 || readUnsignedByte < 48) {
                e2[0] = '0';
            } else {
                i2 = 0;
            }
        } else {
            e2[0] = (char) i;
            readUnsignedByte = this.U.readUnsignedByte();
        }
        int i3 = i2;
        int i4 = i3;
        while (readUnsignedByte <= 57 && readUnsignedByte >= 48) {
            i4++;
            e2[i3] = (char) readUnsignedByte;
            readUnsignedByte = this.U.readUnsignedByte();
            i3++;
        }
        if (readUnsignedByte != 46 && readUnsignedByte != 101 && readUnsignedByte != 69) {
            this.z.b(i3);
            if (this.x.f()) {
                va();
            } else {
                this.V = readUnsignedByte;
            }
            return a(false, i4);
        }
        return a(e2, i3, readUnsignedByte, false, i4);
    }

    protected void l(int i) throws JsonParseException {
        if (i < 32) {
            c(i);
            throw null;
        }
        m(i);
        throw null;
    }

    protected void m(int i) throws JsonParseException {
        f("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation c() {
        return new JsonLocation(U(), -1L, -1L, this.s, -1);
    }

    private final String b(int i, int i2, int i3, int i4) throws IOException {
        int[] iArr = this.R;
        iArr[0] = i;
        return a(iArr, 1, i2, i3, i4);
    }

    private final String b(int i, int i2) throws JsonParseException {
        int c2 = c(i, i2);
        String d2 = this.Q.d(c2);
        if (d2 != null) {
            return d2;
        }
        int[] iArr = this.R;
        iArr[0] = c2;
        return a(iArr, 1, i2);
    }

    protected void e(int i, String str) throws IOException {
        a(i, str, "'null', 'true', 'false' or NaN");
        throw null;
    }

    private final String b(int i, int i2, int i3) throws JsonParseException {
        int c2 = c(i2, i3);
        String b2 = this.Q.b(i, c2);
        if (b2 != null) {
            return b2;
        }
        int[] iArr = this.R;
        iArr[0] = i;
        iArr[1] = c2;
        return a(iArr, 2, i3);
    }

    private final int b(int i, boolean z) throws IOException {
        while (true) {
            if (i > 32) {
                if (i == 47) {
                    na();
                } else if (i != 35 || !ua()) {
                    if (z) {
                        return i;
                    }
                    if (i != 58) {
                        b(i, "was expecting a colon to separate field name and value");
                        throw null;
                    }
                    z = true;
                }
            } else if (i == 13 || i == 10) {
                this.s++;
            }
            i = this.U.readUnsignedByte();
        }
    }

    private static int[] b(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return Arrays.copyOf(iArr, iArr.length + i);
    }

    private final String a(int i, int i2) throws IOException {
        int[] iArr = O;
        int readUnsignedByte = this.U.readUnsignedByte();
        if (iArr[readUnsignedByte] != 0) {
            if (readUnsignedByte == 34) {
                return a(this.T, i2, i, 1);
            }
            return a(this.T, i2, i, readUnsignedByte, 1);
        }
        int i3 = (i << 8) | readUnsignedByte;
        int readUnsignedByte2 = this.U.readUnsignedByte();
        if (iArr[readUnsignedByte2] != 0) {
            if (readUnsignedByte2 == 34) {
                return a(this.T, i2, i3, 2);
            }
            return a(this.T, i2, i3, readUnsignedByte2, 2);
        }
        int i4 = (i3 << 8) | readUnsignedByte2;
        int readUnsignedByte3 = this.U.readUnsignedByte();
        if (iArr[readUnsignedByte3] != 0) {
            if (readUnsignedByte3 == 34) {
                return a(this.T, i2, i4, 3);
            }
            return a(this.T, i2, i4, readUnsignedByte3, 3);
        }
        int i5 = (i4 << 8) | readUnsignedByte3;
        int readUnsignedByte4 = this.U.readUnsignedByte();
        if (iArr[readUnsignedByte4] == 0) {
            return a(readUnsignedByte4, i2, i5);
        }
        if (readUnsignedByte4 == 34) {
            return a(this.T, i2, i5, 4);
        }
        return a(this.T, i2, i5, readUnsignedByte4, 4);
    }

    private final String a(int i, int i2, int i3) throws IOException {
        int[] iArr = this.R;
        iArr[0] = this.T;
        iArr[1] = i2;
        iArr[2] = i3;
        int[] iArr2 = O;
        int i4 = i;
        int i5 = 3;
        while (true) {
            int readUnsignedByte = this.U.readUnsignedByte();
            if (iArr2[readUnsignedByte] != 0) {
                if (readUnsignedByte == 34) {
                    return a(this.R, i5, i4, 1);
                }
                return a(this.R, i5, i4, readUnsignedByte, 1);
            }
            int i6 = (i4 << 8) | readUnsignedByte;
            int readUnsignedByte2 = this.U.readUnsignedByte();
            if (iArr2[readUnsignedByte2] != 0) {
                if (readUnsignedByte2 == 34) {
                    return a(this.R, i5, i6, 2);
                }
                return a(this.R, i5, i6, readUnsignedByte2, 2);
            }
            int i7 = (i6 << 8) | readUnsignedByte2;
            int readUnsignedByte3 = this.U.readUnsignedByte();
            if (iArr2[readUnsignedByte3] != 0) {
                if (readUnsignedByte3 == 34) {
                    return a(this.R, i5, i7, 3);
                }
                return a(this.R, i5, i7, readUnsignedByte3, 3);
            }
            int i8 = (i7 << 8) | readUnsignedByte3;
            int readUnsignedByte4 = this.U.readUnsignedByte();
            if (iArr2[readUnsignedByte4] != 0) {
                if (readUnsignedByte4 == 34) {
                    return a(this.R, i5, i8, 4);
                }
                return a(this.R, i5, i8, readUnsignedByte4, 4);
            }
            int[] iArr3 = this.R;
            if (i5 >= iArr3.length) {
                this.R = b(iArr3, i5);
            }
            this.R[i5] = i8;
            i5++;
            i4 = readUnsignedByte4;
        }
    }

    private final String a(int i, int i2, int i3, int i4, int i5) throws IOException {
        int[] iArr = this.R;
        iArr[0] = i;
        iArr[1] = i2;
        return a(iArr, 2, i3, i4, i5);
    }

    protected final String a(int[] iArr, int i, int i2, int i3, int i4) throws IOException {
        int[] iArr2 = O;
        while (true) {
            if (iArr2[i3] != 0) {
                if (i3 == 34) {
                    break;
                }
                if (i3 != 92) {
                    c(i3, "name");
                } else {
                    i3 = da();
                }
                if (i3 > 127) {
                    if (i4 >= 4) {
                        if (i >= iArr.length) {
                            iArr = b(iArr, iArr.length);
                            this.R = iArr;
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
                                iArr = b(iArr, iArr.length);
                                this.R = iArr;
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
                    iArr = b(iArr, iArr.length);
                    this.R = iArr;
                }
                iArr[i] = i2;
                i2 = i3;
                i++;
                i4 = 1;
            }
            i3 = this.U.readUnsignedByte();
        }
        if (i4 > 0) {
            if (i >= iArr.length) {
                iArr = b(iArr, iArr.length);
                this.R = iArr;
            }
            iArr[i] = c(i2, i4);
            i++;
        }
        String b2 = this.Q.b(iArr, i);
        return b2 == null ? a(iArr, i, i4) : b2;
    }

    private final String a(int i, int i2, int i3, int i4) throws JsonParseException {
        int c2 = c(i3, i4);
        String b2 = this.Q.b(i, i2, c2);
        if (b2 != null) {
            return b2;
        }
        int[] iArr = this.R;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = c(c2, i4);
        return a(iArr, 3, i4);
    }

    private final String a(int[] iArr, int i, int i2, int i3) throws JsonParseException {
        if (i >= iArr.length) {
            iArr = b(iArr, iArr.length);
            this.R = iArr;
        }
        int i4 = i + 1;
        iArr[i] = c(i2, i3);
        String b2 = this.Q.b(iArr, i4);
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
                        t(i11);
                        throw null;
                    }
                    int i12 = (i4 << 6) | (i11 & 63);
                    if (i5 > 1) {
                        int i13 = iArr[i8 >> 2] >> ((3 - (i8 & 3)) << 3);
                        i8++;
                        if ((i13 & 192) != 128) {
                            t(i13);
                            throw null;
                        }
                        int i14 = (i13 & 63) | (i12 << 6);
                        if (i5 > 2) {
                            int i15 = iArr[i8 >> 2] >> ((3 - (i8 & 3)) << 3);
                            i8++;
                            if ((i15 & 192) != 128) {
                                t(i15 & 255);
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
        return this.Q.a(str, iArr, i);
    }

    private final void a(char[] cArr, int i, int i2) throws IOException {
        int i3;
        int[] iArr = N;
        int length = cArr.length;
        while (true) {
            if (iArr[i2] == 0) {
                if (i >= length) {
                    cArr = this.z.g();
                    length = cArr.length;
                    i = 0;
                }
                i3 = i + 1;
                cArr[i] = (char) i2;
                i2 = this.U.readUnsignedByte();
            } else {
                if (i2 == 34) {
                    this.z.b(i);
                    return;
                }
                int i4 = iArr[i2];
                if (i4 == 1) {
                    i2 = da();
                } else if (i4 == 2) {
                    i2 = o(i2);
                } else if (i4 == 3) {
                    i2 = p(i2);
                } else if (i4 == 4) {
                    int q = q(i2);
                    int i5 = i + 1;
                    cArr[i] = (char) (55296 | (q >> 10));
                    if (i5 >= cArr.length) {
                        cArr = this.z.g();
                        length = cArr.length;
                        i = 0;
                    } else {
                        i = i5;
                    }
                    i2 = (q & 1023) | 56320;
                } else if (i2 < 32) {
                    c(i2, "string value");
                } else {
                    l(i2);
                    throw null;
                }
                if (i >= cArr.length) {
                    cArr = this.z.g();
                    length = cArr.length;
                    i = 0;
                }
                i3 = i + 1;
                cArr[i] = (char) i2;
                i2 = this.U.readUnsignedByte();
            }
            i = i3;
        }
    }

    protected JsonToken a(int i, boolean z) throws IOException {
        String str;
        if (i == 73) {
            i = this.U.readUnsignedByte();
            if (i == 78) {
                str = z ? "-INF" : "+INF";
            } else if (i == 110) {
                str = z ? "-Infinity" : "+Infinity";
            }
            a(str, 3);
            if (a(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                return a(str, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            f("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            throw null;
        }
        d(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
        throw null;
    }

    protected final void a(String str, int i) throws IOException {
        int length = str.length();
        do {
            int readUnsignedByte = this.U.readUnsignedByte();
            if (readUnsignedByte != str.charAt(i)) {
                e(readUnsignedByte, str.substring(0, i));
                throw null;
            }
            i++;
        } while (i < length);
        int readUnsignedByte2 = this.U.readUnsignedByte();
        if (readUnsignedByte2 >= 48 && readUnsignedByte2 != 93 && readUnsignedByte2 != 125) {
            a(str, i, readUnsignedByte2);
        }
        this.V = readUnsignedByte2;
    }

    private final void a(String str, int i, int i2) throws IOException {
        char e2 = (char) e(i2);
        if (Character.isJavaIdentifierPart(e2)) {
            e(e2, str.substring(0, i));
            throw null;
        }
    }

    protected void a(int i, String str, String str2) throws IOException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            char e2 = (char) e(i);
            if (Character.isJavaIdentifierPart(e2)) {
                sb.append(e2);
                i = this.U.readUnsignedByte();
            } else {
                f("Unrecognized token '" + sb.toString() + "': was expecting " + str2);
                throw null;
            }
        }
    }
}
