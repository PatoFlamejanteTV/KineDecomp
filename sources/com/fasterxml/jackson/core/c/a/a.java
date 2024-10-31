package com.fasterxml.jackson.core.c.a;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.c;
import com.fasterxml.jackson.core.util.e;
import com.fasterxml.jackson.core.util.g;
import java.io.IOException;

/* compiled from: NonBlockingJsonParser.java */
/* loaded from: classes.dex */
public class a extends b implements com.fasterxml.jackson.core.a.a {
    private static final int[] fa = com.fasterxml.jackson.core.io.a.g();
    protected static final int[] ga = com.fasterxml.jackson.core.io.a.e();
    protected byte[] ha;

    public a(c cVar, int i, com.fasterxml.jackson.core.d.a aVar) {
        super(cVar, i, aVar);
        this.ha = com.fasterxml.jackson.core.b.c.f9683c;
    }

    private final JsonToken A(int i) throws IOException {
        if (i <= 32 && (i = r(i)) <= 0) {
            this.Z = 13;
            return this.m;
        }
        if (i != 44) {
            if (i == 93) {
                return da();
            }
            if (i == 125) {
                return ea();
            }
            if (i == 47) {
                return w(13);
            }
            if (i == 35) {
                return p(13);
            }
            b(i, "was expecting comma to separate " + this.x.g() + " entries");
            throw null;
        }
        int i2 = this.p;
        if (i2 >= this.q) {
            this.Z = 15;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.m = jsonToken;
            return jsonToken;
        }
        int i3 = this.ha[i2];
        this.p = i2 + 1;
        if (i3 <= 32 && (i3 = r(i3)) <= 0) {
            this.Z = 15;
            return this.m;
        }
        ia();
        if (i3 == 34) {
            return wa();
        }
        if (i3 == 35) {
            return p(15);
        }
        if (i3 == 45) {
            return ta();
        }
        if (i3 != 91) {
            if (i3 != 93) {
                if (i3 == 102) {
                    return sa();
                }
                if (i3 == 110) {
                    return ua();
                }
                if (i3 == 116) {
                    return xa();
                }
                if (i3 == 123) {
                    return ha();
                }
                if (i3 != 125) {
                    switch (i3) {
                        case 47:
                            return w(15);
                        case 48:
                            return va();
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                            return m(i3);
                    }
                }
                if (a(JsonParser.Feature.ALLOW_TRAILING_COMMA)) {
                    return ea();
                }
            } else if (a(JsonParser.Feature.ALLOW_TRAILING_COMMA)) {
                return da();
            }
            return c(true, i3);
        }
        return ga();
    }

    private final String Aa() throws IOException {
        byte[] bArr = this.ha;
        int[] iArr = ga;
        int i = this.p;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        if (iArr[i3] != 0) {
            if (i3 != 34) {
                return null;
            }
            this.p = i2;
            return "";
        }
        int i4 = i2 + 1;
        int i5 = bArr[i2] & 255;
        if (iArr[i5] != 0) {
            if (i5 != 34) {
                return null;
            }
            this.p = i4;
            return a(i3, 1);
        }
        int i6 = (i3 << 8) | i5;
        int i7 = i4 + 1;
        int i8 = bArr[i4] & 255;
        if (iArr[i8] != 0) {
            if (i8 != 34) {
                return null;
            }
            this.p = i7;
            return a(i6, 2);
        }
        int i9 = (i6 << 8) | i8;
        int i10 = i7 + 1;
        int i11 = bArr[i7] & 255;
        if (iArr[i11] != 0) {
            if (i11 != 34) {
                return null;
            }
            this.p = i10;
            return a(i9, 3);
        }
        int i12 = (i9 << 8) | i11;
        int i13 = i10 + 1;
        int i14 = bArr[i10] & 255;
        if (iArr[i14] == 0) {
            this.S = i12;
            return h(i13, i14);
        }
        if (i14 != 34) {
            return null;
        }
        this.p = i13;
        return a(i12, 4);
    }

    private final JsonToken Ba() throws IOException {
        int i;
        int[] iArr = fa;
        byte[] bArr = this.ha;
        char[] h2 = this.z.h();
        int j = this.z.j();
        int i2 = this.p;
        int i3 = this.q - 5;
        while (i2 < this.q) {
            if (j >= h2.length) {
                h2 = this.z.g();
                j = 0;
            }
            int min = Math.min(this.q, (h2.length - j) + i2);
            while (true) {
                if (i2 < min) {
                    int i4 = i2 + 1;
                    int i5 = bArr[i2] & 255;
                    if (iArr[i5] != 0 && i5 != 34) {
                        if (i4 >= i3) {
                            this.p = i4;
                            this.z.b(j);
                            if (!a(i5, iArr[i5], i4 < this.q)) {
                                this.aa = 45;
                                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                                this.m = jsonToken;
                                return jsonToken;
                            }
                            h2 = this.z.h();
                            j = this.z.j();
                            i2 = this.p;
                        } else {
                            int i6 = iArr[i5];
                            if (i6 == 1) {
                                this.p = i4;
                                i5 = za();
                                i = this.p;
                            } else if (i6 == 2) {
                                i5 = g(i5, this.ha[i4]);
                                i = i4 + 1;
                            } else if (i6 == 3) {
                                byte[] bArr2 = this.ha;
                                int i7 = i4 + 1;
                                i5 = d(i5, bArr2[i4], bArr2[i7]);
                                i = i7 + 1;
                            } else if (i6 == 4) {
                                byte[] bArr3 = this.ha;
                                int i8 = i4 + 1;
                                int i9 = i8 + 1;
                                int i10 = i9 + 1;
                                int b2 = b(i5, bArr3[i4], bArr3[i8], bArr3[i9]);
                                int i11 = j + 1;
                                h2[j] = (char) (55296 | (b2 >> 10));
                                if (i11 >= h2.length) {
                                    h2 = this.z.g();
                                    i11 = 0;
                                }
                                i5 = (b2 & 1023) | 56320;
                                j = i11;
                                i = i10;
                            } else if (i5 < 32) {
                                c(i5, "string value");
                                i = i4;
                            } else {
                                h(i5);
                                throw null;
                            }
                            if (j >= h2.length) {
                                h2 = this.z.g();
                                j = 0;
                            }
                            h2[j] = (char) i5;
                            i2 = i;
                            j++;
                        }
                    } else {
                        if (i5 == 39) {
                            this.p = i4;
                            this.z.b(j);
                            JsonToken jsonToken2 = JsonToken.VALUE_STRING;
                            c(jsonToken2);
                            return jsonToken2;
                        }
                        h2[j] = (char) i5;
                        i2 = i4;
                        j++;
                    }
                }
            }
        }
        this.p = i2;
        this.Z = 45;
        this.z.b(j);
        JsonToken jsonToken3 = JsonToken.NOT_AVAILABLE;
        this.m = jsonToken3;
        return jsonToken3;
    }

    private final JsonToken Ca() throws IOException {
        int i;
        int[] iArr = fa;
        byte[] bArr = this.ha;
        char[] h2 = this.z.h();
        int j = this.z.j();
        int i2 = this.p;
        int i3 = this.q - 5;
        while (i2 < this.q) {
            if (j >= h2.length) {
                h2 = this.z.g();
                j = 0;
            }
            int min = Math.min(this.q, (h2.length - j) + i2);
            while (true) {
                if (i2 < min) {
                    int i4 = i2 + 1;
                    int i5 = bArr[i2] & 255;
                    if (iArr[i5] == 0) {
                        h2[j] = (char) i5;
                        i2 = i4;
                        j++;
                    } else {
                        if (i5 == 34) {
                            this.p = i4;
                            this.z.b(j);
                            JsonToken jsonToken = JsonToken.VALUE_STRING;
                            c(jsonToken);
                            return jsonToken;
                        }
                        if (i4 >= i3) {
                            this.p = i4;
                            this.z.b(j);
                            if (!a(i5, iArr[i5], i4 < this.q)) {
                                this.aa = 40;
                                JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
                                this.m = jsonToken2;
                                return jsonToken2;
                            }
                            h2 = this.z.h();
                            j = this.z.j();
                            i2 = this.p;
                        } else {
                            int i6 = iArr[i5];
                            if (i6 == 1) {
                                this.p = i4;
                                i5 = za();
                                i = this.p;
                            } else if (i6 == 2) {
                                i5 = g(i5, this.ha[i4]);
                                i = i4 + 1;
                            } else if (i6 == 3) {
                                byte[] bArr2 = this.ha;
                                int i7 = i4 + 1;
                                i5 = d(i5, bArr2[i4], bArr2[i7]);
                                i = i7 + 1;
                            } else if (i6 == 4) {
                                byte[] bArr3 = this.ha;
                                int i8 = i4 + 1;
                                int i9 = i8 + 1;
                                int i10 = i9 + 1;
                                int b2 = b(i5, bArr3[i4], bArr3[i8], bArr3[i9]);
                                int i11 = j + 1;
                                h2[j] = (char) (55296 | (b2 >> 10));
                                if (i11 >= h2.length) {
                                    h2 = this.z.g();
                                    i11 = 0;
                                }
                                i5 = (b2 & 1023) | 56320;
                                j = i11;
                                i = i10;
                            } else if (i5 < 32) {
                                c(i5, "string value");
                                i = i4;
                            } else {
                                h(i5);
                                throw null;
                            }
                            if (j >= h2.length) {
                                h2 = this.z.g();
                                j = 0;
                            }
                            h2[j] = (char) i5;
                            i2 = i;
                            j++;
                        }
                    }
                }
            }
        }
        this.p = i2;
        this.Z = 40;
        this.z.b(j);
        JsonToken jsonToken3 = JsonToken.NOT_AVAILABLE;
        this.m = jsonToken3;
        return jsonToken3;
    }

    private final JsonToken a(int i, boolean z) throws IOException {
        while (true) {
            int i2 = this.p;
            if (i2 >= this.q) {
                this.Z = z ? 52 : 53;
                this.T = i;
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                this.m = jsonToken;
                return jsonToken;
            }
            byte[] bArr = this.ha;
            this.p = i2 + 1;
            int i3 = bArr[i2] & 255;
            if (i3 < 32) {
                if (i3 == 10) {
                    this.s++;
                    this.t = this.p;
                } else if (i3 == 13) {
                    this.ea++;
                    this.t = this.p;
                } else if (i3 != 9) {
                    c(i3);
                    throw null;
                }
            } else if (i3 == 42) {
                z = true;
            } else if (i3 == 47 && z) {
                return s(i);
            }
            z = false;
        }
    }

    private JsonToken f(int i, int i2, int i3) throws IOException {
        int[] iArr = this.Q;
        int[] h2 = com.fasterxml.jackson.core.io.a.h();
        while (true) {
            int i4 = this.p;
            if (i4 >= this.q) {
                this.R = i;
                this.T = i2;
                this.U = i3;
                this.Z = 10;
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                this.m = jsonToken;
                return jsonToken;
            }
            int i5 = this.ha[i4] & 255;
            if (h2[i5] != 0) {
                if (i3 > 0) {
                    if (i >= iArr.length) {
                        iArr = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                        this.Q = iArr;
                    }
                    iArr[i] = i2;
                    i++;
                }
                String b2 = this.P.b(iArr, i);
                if (b2 == null) {
                    b2 = a(iArr, i, i3);
                }
                return h(b2);
            }
            this.p = i4 + 1;
            if (i3 < 4) {
                i3++;
                i2 = (i2 << 8) | i5;
            } else {
                if (i >= iArr.length) {
                    iArr = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                    this.Q = iArr;
                }
                iArr[i] = i2;
                i++;
                i2 = i5;
                i3 = 1;
            }
        }
    }

    private final JsonToken g(int i, int i2, int i3) throws IOException {
        int i4;
        int[] iArr = this.Q;
        int[] iArr2 = ga;
        while (true) {
            int i5 = this.p;
            if (i5 >= this.q) {
                this.R = i;
                this.T = i2;
                this.U = i3;
                this.Z = 7;
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                this.m = jsonToken;
                return jsonToken;
            }
            byte[] bArr = this.ha;
            this.p = i5 + 1;
            int i6 = bArr[i5] & 255;
            if (iArr2[i6] == 0) {
                if (i3 < 4) {
                    i3++;
                    i2 = (i2 << 8) | i6;
                } else {
                    if (i >= iArr.length) {
                        int[] a2 = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                        this.Q = a2;
                        iArr = a2;
                    }
                    i4 = i + 1;
                    iArr[i] = i2;
                    i = i4;
                    i2 = i6;
                    i3 = 1;
                }
            } else {
                if (i6 == 34) {
                    if (i3 > 0) {
                        if (i >= iArr.length) {
                            iArr = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                            this.Q = iArr;
                        }
                        iArr[i] = b.b(i2, i3);
                        i++;
                    } else if (i == 0) {
                        return h("");
                    }
                    String b2 = this.P.b(iArr, i);
                    if (b2 == null) {
                        b2 = a(iArr, i, i3);
                    }
                    return h(b2);
                }
                if (i6 != 92) {
                    c(i6, "name");
                } else {
                    i6 = ya();
                    if (i6 < 0) {
                        this.Z = 8;
                        this.aa = 7;
                        this.R = i;
                        this.T = i2;
                        this.U = i3;
                        JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
                        this.m = jsonToken2;
                        return jsonToken2;
                    }
                }
                if (i >= iArr.length) {
                    iArr = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                    this.Q = iArr;
                }
                if (i6 > 127) {
                    if (i3 >= 4) {
                        iArr[i] = i2;
                        i++;
                        i2 = 0;
                        i3 = 0;
                    }
                    if (i6 < 2048) {
                        i2 = (i2 << 8) | (i6 >> 6) | 192;
                        i3++;
                    } else {
                        int i7 = (i2 << 8) | (i6 >> 12) | 224;
                        int i8 = i3 + 1;
                        if (i8 >= 4) {
                            iArr[i] = i7;
                            i++;
                            i7 = 0;
                            i8 = 0;
                        }
                        i2 = (i7 << 8) | ((i6 >> 6) & 63) | 128;
                        i3 = i8 + 1;
                    }
                    i6 = (i6 & 63) | 128;
                }
                if (i3 < 4) {
                    i3++;
                    i2 = (i2 << 8) | i6;
                } else {
                    i4 = i + 1;
                    iArr[i] = i2;
                    i = i4;
                    i2 = i6;
                    i3 = 1;
                }
            }
        }
    }

    private final String h(int i, int i2) throws IOException {
        byte[] bArr = this.ha;
        int[] iArr = ga;
        int i3 = i + 1;
        int i4 = bArr[i] & 255;
        if (iArr[i4] != 0) {
            if (i4 != 34) {
                return null;
            }
            this.p = i3;
            return a(this.S, i2, 1);
        }
        int i5 = i4 | (i2 << 8);
        int i6 = i3 + 1;
        int i7 = bArr[i3] & 255;
        if (iArr[i7] != 0) {
            if (i7 != 34) {
                return null;
            }
            this.p = i6;
            return a(this.S, i5, 2);
        }
        int i8 = (i5 << 8) | i7;
        int i9 = i6 + 1;
        int i10 = bArr[i6] & 255;
        if (iArr[i10] != 0) {
            if (i10 != 34) {
                return null;
            }
            this.p = i9;
            return a(this.S, i8, 3);
        }
        int i11 = (i8 << 8) | i10;
        int i12 = i9 + 1;
        int i13 = bArr[i9] & 255;
        if (iArr[i13] == 0) {
            return h(i12, i13, i11);
        }
        if (i13 != 34) {
            return null;
        }
        this.p = i12;
        return a(this.S, i11, 4);
    }

    private final JsonToken n(int i) throws IOException {
        while (true) {
            int i2 = this.p;
            if (i2 < this.q) {
                byte[] bArr = this.ha;
                this.p = i2 + 1;
                int i3 = bArr[i2] & 255;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            this.r -= 3;
                            return t(i3);
                        }
                    } else if (i3 != 191) {
                        a("Unexpected byte 0x%02x following 0xEF 0xBB; should get 0xBF as third byte of UTF-8 BOM", Integer.valueOf(i3));
                        throw null;
                    }
                } else if (i3 != 187) {
                    a("Unexpected byte 0x%02x following 0xEF; should get 0xBB as second byte UTF-8 BOM", Integer.valueOf(i3));
                    throw null;
                }
                i++;
            } else {
                this.T = i;
                this.Z = 1;
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                this.m = jsonToken;
                return jsonToken;
            }
        }
    }

    private final JsonToken o(int i) throws IOException {
        while (true) {
            int i2 = this.p;
            if (i2 >= this.q) {
                this.Z = 54;
                this.T = i;
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                this.m = jsonToken;
                return jsonToken;
            }
            byte[] bArr = this.ha;
            this.p = i2 + 1;
            int i3 = bArr[i2] & 255;
            if (i3 < 32) {
                if (i3 == 10) {
                    this.s++;
                    this.t = this.p;
                    break;
                }
                if (i3 == 13) {
                    this.ea++;
                    this.t = this.p;
                    break;
                }
                if (i3 != 9) {
                    c(i3);
                    throw null;
                }
            }
        }
        return s(i);
    }

    private final JsonToken p(int i) throws IOException {
        if (JsonParser.Feature.ALLOW_YAML_COMMENTS.enabledIn(this.f9672a)) {
            while (true) {
                int i2 = this.p;
                if (i2 >= this.q) {
                    this.Z = 55;
                    this.T = i;
                    JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                    this.m = jsonToken;
                    return jsonToken;
                }
                byte[] bArr = this.ha;
                this.p = i2 + 1;
                int i3 = bArr[i2] & 255;
                if (i3 < 32) {
                    if (i3 == 10) {
                        this.s++;
                        this.t = this.p;
                        break;
                    }
                    if (i3 == 13) {
                        this.ea++;
                        this.t = this.p;
                        break;
                    }
                    if (i3 != 9) {
                        c(i3);
                        throw null;
                    }
                }
            }
            return s(i);
        }
        b(35, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_YAML_COMMENTS' not enabled for parser)");
        throw null;
    }

    private JsonToken q(int i) throws IOException {
        if (i != 35) {
            if (i != 39) {
                if (i == 47) {
                    return w(4);
                }
                if (i == 93) {
                    return da();
                }
            } else if (a(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
                return e(0, 0, 0);
            }
        } else if (JsonParser.Feature.ALLOW_YAML_COMMENTS.enabledIn(this.f9672a)) {
            return p(4);
        }
        if (a(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            if (com.fasterxml.jackson.core.io.a.h()[i] == 0) {
                return f(0, i, 1);
            }
            b(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
            throw null;
        }
        b((char) i, "was expecting double-quote to start field name");
        throw null;
    }

    private final int r(int i) throws IOException {
        do {
            if (i != 32) {
                if (i == 10) {
                    this.s++;
                    this.t = this.p;
                } else if (i == 13) {
                    this.ea++;
                    this.t = this.p;
                } else if (i != 9) {
                    c(i);
                    throw null;
                }
            }
            int i2 = this.p;
            if (i2 >= this.q) {
                this.m = JsonToken.NOT_AVAILABLE;
                return 0;
            }
            byte[] bArr = this.ha;
            this.p = i2 + 1;
            i = bArr[i2] & 255;
        } while (i <= 32);
        return i;
    }

    private final JsonToken s(int i) throws IOException {
        int i2 = this.p;
        if (i2 >= this.q) {
            this.Z = i;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.m = jsonToken;
            return jsonToken;
        }
        byte[] bArr = this.ha;
        this.p = i2 + 1;
        int i3 = bArr[i2] & 255;
        if (i == 4) {
            return u(i3);
        }
        if (i != 5) {
            switch (i) {
                case 12:
                    return x(i3);
                case 13:
                    return A(i3);
                case 14:
                    return z(i3);
                case 15:
                    return y(i3);
                default:
                    g.a();
                    throw null;
            }
        }
        return v(i3);
    }

    private final JsonToken t(int i) throws IOException {
        int i2 = i & 255;
        if (i2 == 239 && this.Z != 1) {
            return n(1);
        }
        while (i2 <= 32) {
            if (i2 != 32) {
                if (i2 == 10) {
                    this.s++;
                    this.t = this.p;
                } else if (i2 == 13) {
                    this.ea++;
                    this.t = this.p;
                } else if (i2 != 9) {
                    c(i2);
                    throw null;
                }
            }
            int i3 = this.p;
            if (i3 >= this.q) {
                this.Z = 3;
                if (this.o) {
                    return null;
                }
                if (this.ba) {
                    return fa();
                }
                return JsonToken.NOT_AVAILABLE;
            }
            byte[] bArr = this.ha;
            this.p = i3 + 1;
            i2 = bArr[i3] & 255;
        }
        return x(i2);
    }

    private final JsonToken u(int i) throws IOException {
        String Aa;
        if (i <= 32 && (i = r(i)) <= 0) {
            this.Z = 4;
            return this.m;
        }
        ia();
        if (i != 34) {
            if (i == 125) {
                return ea();
            }
            return q(i);
        }
        if (this.p + 13 <= this.q && (Aa = Aa()) != null) {
            return h(Aa);
        }
        return g(0, 0, 0);
    }

    private final JsonToken v(int i) throws IOException {
        String Aa;
        if (i <= 32 && (i = r(i)) <= 0) {
            this.Z = 5;
            return this.m;
        }
        if (i != 44) {
            if (i == 125) {
                return ea();
            }
            if (i == 35) {
                return p(5);
            }
            if (i == 47) {
                return w(5);
            }
            b(i, "was expecting comma to separate " + this.x.g() + " entries");
            throw null;
        }
        int i2 = this.p;
        if (i2 >= this.q) {
            this.Z = 4;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.m = jsonToken;
            return jsonToken;
        }
        int i3 = this.ha[i2];
        this.p = i2 + 1;
        if (i3 <= 32 && (i3 = r(i3)) <= 0) {
            this.Z = 4;
            return this.m;
        }
        ia();
        if (i3 != 34) {
            if (i3 == 125 && JsonParser.Feature.ALLOW_TRAILING_COMMA.enabledIn(this.f9672a)) {
                return ea();
            }
            return q(i3);
        }
        if (this.p + 13 <= this.q && (Aa = Aa()) != null) {
            return h(Aa);
        }
        return g(0, 0, 0);
    }

    private final JsonToken w(int i) throws IOException {
        if (JsonParser.Feature.ALLOW_COMMENTS.enabledIn(this.f9672a)) {
            int i2 = this.p;
            if (i2 >= this.q) {
                this.T = i;
                this.Z = 51;
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                this.m = jsonToken;
                return jsonToken;
            }
            byte[] bArr = this.ha;
            this.p = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 == 42) {
                return a(i, false);
            }
            if (b2 == 47) {
                return o(i);
            }
            b(b2 & 255, "was expecting either '*' or '/' for a comment");
            throw null;
        }
        b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        throw null;
    }

    private final JsonToken x(int i) throws IOException {
        if (i <= 32 && (i = r(i)) <= 0) {
            this.Z = 12;
            return this.m;
        }
        ia();
        if (i == 34) {
            return wa();
        }
        if (i == 35) {
            return p(12);
        }
        if (i == 45) {
            return ta();
        }
        if (i == 91) {
            return ga();
        }
        if (i == 93) {
            return da();
        }
        if (i == 102) {
            return sa();
        }
        if (i == 110) {
            return ua();
        }
        if (i == 116) {
            return xa();
        }
        if (i == 123) {
            return ha();
        }
        if (i != 125) {
            switch (i) {
                case 47:
                    return w(12);
                case 48:
                    return va();
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    return m(i);
                default:
                    return c(false, i);
            }
        }
        return ea();
    }

    private final JsonToken y(int i) throws IOException {
        if (i <= 32 && (i = r(i)) <= 0) {
            this.Z = 15;
            return this.m;
        }
        ia();
        if (i == 34) {
            return wa();
        }
        if (i == 35) {
            return p(15);
        }
        if (i == 45) {
            return ta();
        }
        if (i != 91) {
            if (i != 93) {
                if (i == 102) {
                    return sa();
                }
                if (i == 110) {
                    return ua();
                }
                if (i == 116) {
                    return xa();
                }
                if (i == 123) {
                    return ha();
                }
                if (i != 125) {
                    switch (i) {
                        case 47:
                            return w(15);
                        case 48:
                            return va();
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                            return m(i);
                    }
                }
                if (a(JsonParser.Feature.ALLOW_TRAILING_COMMA)) {
                    return ea();
                }
            } else if (a(JsonParser.Feature.ALLOW_TRAILING_COMMA)) {
                return da();
            }
            return c(true, i);
        }
        return ga();
    }

    private final int ya() throws IOException {
        if (this.q - this.p < 5) {
            return f(0, -1);
        }
        return za();
    }

    private final JsonToken z(int i) throws IOException {
        if (i <= 32 && (i = r(i)) <= 0) {
            this.Z = 14;
            return this.m;
        }
        if (i != 58) {
            if (i == 47) {
                return w(14);
            }
            if (i == 35) {
                return p(14);
            }
            b(i, "was expecting a colon to separate field name and value");
            throw null;
        }
        int i2 = this.p;
        if (i2 >= this.q) {
            this.Z = 12;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.m = jsonToken;
            return jsonToken;
        }
        int i3 = this.ha[i2];
        this.p = i2 + 1;
        if (i3 <= 32 && (i3 = r(i3)) <= 0) {
            this.Z = 12;
            return this.m;
        }
        ia();
        if (i3 == 34) {
            return wa();
        }
        if (i3 == 35) {
            return p(12);
        }
        if (i3 == 45) {
            return ta();
        }
        if (i3 == 91) {
            return ga();
        }
        if (i3 == 102) {
            return sa();
        }
        if (i3 == 110) {
            return ua();
        }
        if (i3 == 116) {
            return xa();
        }
        if (i3 != 123) {
            switch (i3) {
                case 47:
                    return w(12);
                case 48:
                    return va();
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    return m(i3);
                default:
                    return c(false, i3);
            }
        }
        return ha();
    }

    private final int za() throws IOException {
        byte[] bArr = this.ha;
        int i = this.p;
        this.p = i + 1;
        byte b2 = bArr[i];
        if (b2 == 34 || b2 == 47 || b2 == 92) {
            return (char) b2;
        }
        if (b2 == 98) {
            return 8;
        }
        if (b2 == 102) {
            return 12;
        }
        if (b2 == 110) {
            return 10;
        }
        if (b2 == 114) {
            return 13;
        }
        if (b2 == 116) {
            return 9;
        }
        if (b2 != 117) {
            char c2 = (char) b2;
            a(c2);
            return c2;
        }
        int i2 = this.p;
        this.p = i2 + 1;
        byte b3 = bArr[i2];
        int a2 = com.fasterxml.jackson.core.io.a.a(b3);
        if (a2 >= 0) {
            byte[] bArr2 = this.ha;
            int i3 = this.p;
            this.p = i3 + 1;
            b3 = bArr2[i3];
            int a3 = com.fasterxml.jackson.core.io.a.a(b3);
            if (a3 >= 0) {
                int i4 = (a2 << 4) | a3;
                byte[] bArr3 = this.ha;
                int i5 = this.p;
                this.p = i5 + 1;
                byte b4 = bArr3[i5];
                int a4 = com.fasterxml.jackson.core.io.a.a(b4);
                if (a4 >= 0) {
                    int i6 = (i4 << 4) | a4;
                    byte[] bArr4 = this.ha;
                    int i7 = this.p;
                    this.p = i7 + 1;
                    b4 = bArr4[i7];
                    int a5 = com.fasterxml.jackson.core.io.a.a(b4);
                    if (a5 >= 0) {
                        return (i6 << 4) | a5;
                    }
                }
                b3 = b4;
            }
        }
        b(b3 & 255, "expected a hex-digit for character escape sequence");
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken L() throws IOException {
        int i = this.p;
        if (i >= this.q) {
            if (this.o) {
                return null;
            }
            if (this.ba) {
                if (this.m == JsonToken.NOT_AVAILABLE) {
                    return qa();
                }
                return fa();
            }
            return JsonToken.NOT_AVAILABLE;
        }
        if (this.m == JsonToken.NOT_AVAILABLE) {
            return pa();
        }
        this.D = 0;
        this.u = this.r + i;
        this.C = null;
        byte[] bArr = this.ha;
        this.p = i + 1;
        int i2 = bArr[i] & 255;
        switch (this.X) {
            case 0:
                return t(i2);
            case 1:
                return x(i2);
            case 2:
                return u(i2);
            case 3:
                return v(i2);
            case 4:
                return z(i2);
            case 5:
                return x(i2);
            case 6:
                return A(i2);
            default:
                g.a();
                throw null;
        }
    }

    protected JsonToken b(String str, int i, JsonToken jsonToken) throws IOException {
        if (i == str.length()) {
            this.m = jsonToken;
            return jsonToken;
        }
        this.z.b(str, 0, i);
        ka();
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:            if (r3 == 44) goto L21;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:            if (a(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_MISSING_VALUES) == false) goto L33;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:            r1.p--;        r2 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL;        c(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:            return r2;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x002a, code lost:            if (r1.x.d() != false) goto L21;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.fasterxml.jackson.core.JsonToken c(boolean r2, int r3) throws java.io.IOException {
        /*
            r1 = this;
            r2 = 39
            if (r3 == r2) goto L4a
            r2 = 73
            r0 = 1
            if (r3 == r2) goto L45
            r2 = 78
            if (r3 == r2) goto L3f
            r2 = 93
            if (r3 == r2) goto L24
            r2 = 125(0x7d, float:1.75E-43)
            if (r3 == r2) goto L57
            r2 = 43
            if (r3 == r2) goto L1e
            r2 = 44
            if (r3 != r2) goto L57
            goto L2c
        L1e:
            r2 = 2
            com.fasterxml.jackson.core.JsonToken r2 = r1.d(r2, r0)
            return r2
        L24:
            com.fasterxml.jackson.core.c.d r2 = r1.x
            boolean r2 = r2.d()
            if (r2 == 0) goto L57
        L2c:
            com.fasterxml.jackson.core.JsonParser$Feature r2 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_MISSING_VALUES
            boolean r2 = r1.a(r2)
            if (r2 == 0) goto L57
            int r2 = r1.p
            int r2 = r2 - r0
            r1.p = r2
            com.fasterxml.jackson.core.JsonToken r2 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            r1.c(r2)
            return r2
        L3f:
            r2 = 0
            com.fasterxml.jackson.core.JsonToken r2 = r1.d(r2, r0)
            return r2
        L45:
            com.fasterxml.jackson.core.JsonToken r2 = r1.d(r0, r0)
            return r2
        L4a:
            com.fasterxml.jackson.core.JsonParser$Feature r2 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES
            boolean r2 = r1.a(r2)
            if (r2 == 0) goto L57
            com.fasterxml.jackson.core.JsonToken r2 = r1.ra()
            return r2
        L57:
            java.lang.String r2 = "expected a valid value (number, String, array, object, 'true', 'false' or 'null')"
            r1.b(r3, r2)
            r2 = 0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.a.a.c(boolean, int):com.fasterxml.jackson.core.JsonToken");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:            r4.Z = 50;        r4.z.b(r0, 0, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:            return ja();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.fasterxml.jackson.core.JsonToken d(int r5, int r6) throws java.io.IOException {
        /*
            r4 = this;
            java.lang.String r0 = r4.e(r5)
            int r1 = r0.length()
        L8:
            int r2 = r4.p
            int r3 = r4.q
            if (r2 < r3) goto L1b
            r4.ca = r5
            r4.T = r6
            r5 = 19
            r4.Z = r5
            com.fasterxml.jackson.core.JsonToken r5 = com.fasterxml.jackson.core.JsonToken.NOT_AVAILABLE
            r4.m = r5
            return r5
        L1b:
            byte[] r3 = r4.ha
            r2 = r3[r2]
            if (r6 != r1) goto L32
            r1 = 48
            if (r2 < r1) goto L2d
            r1 = 93
            if (r2 == r1) goto L2d
            r1 = 125(0x7d, float:1.75E-43)
            if (r2 != r1) goto L38
        L2d:
            com.fasterxml.jackson.core.JsonToken r5 = r4.k(r5)
            return r5
        L32:
            char r3 = r0.charAt(r6)
            if (r2 == r3) goto L47
        L38:
            r5 = 50
            r4.Z = r5
            com.fasterxml.jackson.core.util.e r5 = r4.z
            r1 = 0
            r5.b(r0, r1, r6)
            com.fasterxml.jackson.core.JsonToken r5 = r4.ja()
            return r5
        L47:
            int r6 = r6 + 1
            int r2 = r4.p
            int r2 = r2 + 1
            r4.p = r2
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.a.a.d(int, int):com.fasterxml.jackson.core.JsonToken");
    }

    protected JsonToken e(int i, int i2) throws IOException {
        String e2 = e(i);
        if (i2 == e2.length()) {
            return k(i);
        }
        this.z.b(e2, 0, i2);
        ka();
        throw null;
    }

    protected JsonToken i(String str) throws IOException {
        a("Unrecognized token '%s': was expecting %s", this.z.d(), "'null', 'true' or 'false'");
        throw null;
    }

    protected JsonToken ja() throws IOException {
        do {
            int i = this.p;
            if (i < this.q) {
                byte[] bArr = this.ha;
                this.p = i + 1;
                char c2 = (char) bArr[i];
                if (!Character.isJavaIdentifierPart(c2)) {
                    break;
                }
                this.z.a(c2);
            } else {
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                this.m = jsonToken;
                return jsonToken;
            }
        } while (this.z.o() < 256);
        i(this.z.d());
        throw null;
    }

    protected JsonToken ka() throws IOException {
        i(this.z.d());
        throw null;
    }

    protected JsonToken l(int i) throws IOException {
        if (i <= 48) {
            if (i == 48) {
                return na();
            }
            d(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
            throw null;
        }
        if (i > 57) {
            if (i == 73) {
                return d(3, 2);
            }
            d(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
            throw null;
        }
        char[] e2 = this.z.e();
        e2[0] = '-';
        e2[1] = (char) i;
        this.K = 1;
        return a(e2, 2);
    }

    protected final JsonToken la() throws IOException {
        int i;
        int i2;
        int f2 = f(this.V, this.W);
        if (f2 < 0) {
            this.Z = 8;
            return JsonToken.NOT_AVAILABLE;
        }
        int i3 = this.R;
        int[] iArr = this.Q;
        if (i3 >= iArr.length) {
            this.Q = com.fasterxml.jackson.core.b.b.a(iArr, 32);
        }
        int i4 = this.T;
        int i5 = this.U;
        int i6 = 1;
        if (f2 > 127) {
            if (i5 >= 4) {
                int[] iArr2 = this.Q;
                int i7 = this.R;
                this.R = i7 + 1;
                iArr2[i7] = i4;
                i4 = 0;
                i5 = 0;
            }
            if (f2 < 2048) {
                i = i4 << 8;
                i2 = (f2 >> 6) | 192;
            } else {
                int i8 = (i4 << 8) | (f2 >> 12) | 224;
                i5++;
                if (i5 >= 4) {
                    int[] iArr3 = this.Q;
                    int i9 = this.R;
                    this.R = i9 + 1;
                    iArr3[i9] = i8;
                    i8 = 0;
                    i5 = 0;
                }
                i = i8 << 8;
                i2 = ((f2 >> 6) & 63) | 128;
            }
            i4 = i | i2;
            i5++;
            f2 = (f2 & 63) | 128;
        }
        if (i5 < 4) {
            i6 = 1 + i5;
            f2 |= i4 << 8;
        } else {
            int[] iArr4 = this.Q;
            int i10 = this.R;
            this.R = i10 + 1;
            iArr4[i10] = i4;
        }
        if (this.aa == 9) {
            return e(this.R, f2, i6);
        }
        return g(this.R, f2, i6);
    }

    protected JsonToken m(int i) throws IOException {
        this.J = false;
        char[] e2 = this.z.e();
        e2[0] = (char) i;
        int i2 = this.p;
        if (i2 >= this.q) {
            this.Z = 26;
            this.z.b(1);
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.m = jsonToken;
            return jsonToken;
        }
        int i3 = this.ha[i2] & 255;
        int i4 = 1;
        while (true) {
            if (i3 < 48) {
                if (i3 == 46) {
                    this.K = i4;
                    this.p++;
                    return a(e2, i4, i3);
                }
            } else if (i3 <= 57) {
                if (i4 >= e2.length) {
                    e2 = this.z.f();
                }
                int i5 = i4 + 1;
                e2[i4] = (char) i3;
                int i6 = this.p + 1;
                this.p = i6;
                if (i6 >= this.q) {
                    this.Z = 26;
                    this.z.b(i5);
                    JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
                    this.m = jsonToken2;
                    return jsonToken2;
                }
                i3 = this.ha[this.p] & 255;
                i4 = i5;
            } else if (i3 == 101 || i3 == 69) {
                this.K = i4;
                this.p++;
                return a(e2, i4, i3);
            }
        }
        this.K = i4;
        this.z.b(i4);
        JsonToken jsonToken3 = JsonToken.VALUE_NUMBER_INT;
        c(jsonToken3);
        return jsonToken3;
    }

    protected JsonToken ma() throws IOException {
        byte b2;
        int i = this.L;
        char[] h2 = this.z.h();
        int j = this.z.j();
        while (true) {
            byte[] bArr = this.ha;
            int i2 = this.p;
            this.p = i2 + 1;
            b2 = bArr[i2];
            if (b2 < 48 || b2 > 57) {
                break;
            }
            i++;
            if (j >= h2.length) {
                h2 = this.z.f();
            }
            int i3 = j + 1;
            h2[j] = (char) b2;
            if (this.p >= this.q) {
                this.z.b(i3);
                this.L = i;
                return JsonToken.NOT_AVAILABLE;
            }
            j = i3;
        }
        if (i != 0) {
            this.L = i;
            this.z.b(j);
            if (b2 != 101 && b2 != 69) {
                this.p--;
                this.z.b(j);
                this.M = 0;
                JsonToken jsonToken = JsonToken.VALUE_NUMBER_FLOAT;
                c(jsonToken);
                return jsonToken;
            }
            this.z.a((char) b2);
            this.M = 0;
            int i4 = this.p;
            if (i4 >= this.q) {
                this.Z = 31;
                return JsonToken.NOT_AVAILABLE;
            }
            this.Z = 32;
            byte[] bArr2 = this.ha;
            this.p = i4 + 1;
            return b(true, bArr2[i4] & 255);
        }
        d(b2, "Decimal point not followed by a digit");
        throw null;
    }

    protected JsonToken na() throws IOException {
        int i;
        do {
            int i2 = this.p;
            if (i2 >= this.q) {
                this.Z = 25;
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                this.m = jsonToken;
                return jsonToken;
            }
            byte[] bArr = this.ha;
            this.p = i2 + 1;
            i = bArr[i2] & 255;
            if (i < 48) {
                if (i == 46) {
                    char[] e2 = this.z.e();
                    e2[0] = '-';
                    e2[1] = '0';
                    this.K = 1;
                    return a(e2, 2, i);
                }
            } else if (i > 57) {
                if (i == 101 || i == 69) {
                    char[] e3 = this.z.e();
                    e3[0] = '-';
                    e3[1] = '0';
                    this.K = 1;
                    return a(e3, 2, i);
                }
                if (i != 93 && i != 125) {
                    d(i, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
                    throw null;
                }
            } else if (!a(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
                g("Leading zeroes not allowed");
                throw null;
            }
            this.p--;
            return e(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } while (i == 48);
        char[] e4 = this.z.e();
        e4[0] = '-';
        e4[1] = (char) i;
        this.K = 1;
        return a(e4, 2);
    }

    protected JsonToken oa() throws IOException {
        int i;
        do {
            int i2 = this.p;
            if (i2 >= this.q) {
                this.Z = 24;
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                this.m = jsonToken;
                return jsonToken;
            }
            byte[] bArr = this.ha;
            this.p = i2 + 1;
            i = bArr[i2] & 255;
            if (i < 48) {
                if (i == 46) {
                    char[] e2 = this.z.e();
                    e2[0] = '0';
                    this.K = 1;
                    return a(e2, 1, i);
                }
            } else if (i > 57) {
                if (i == 101 || i == 69) {
                    char[] e3 = this.z.e();
                    e3[0] = '0';
                    this.K = 1;
                    return a(e3, 1, i);
                }
                if (i != 93 && i != 125) {
                    d(i, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
                    throw null;
                }
            } else if (!a(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
                g("Leading zeroes not allowed");
                throw null;
            }
            this.p--;
            return e(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } while (i == 48);
        char[] e4 = this.z.e();
        e4[0] = (char) i;
        this.K = 1;
        return a(e4, 1);
    }

    protected final JsonToken pa() throws IOException {
        int i = this.Z;
        if (i == 1) {
            return n(this.T);
        }
        if (i == 4) {
            byte[] bArr = this.ha;
            int i2 = this.p;
            this.p = i2 + 1;
            return u(bArr[i2] & 255);
        }
        if (i != 5) {
            switch (i) {
                case 7:
                    return g(this.R, this.T, this.U);
                case 8:
                    return la();
                case 9:
                    return e(this.R, this.T, this.U);
                case 10:
                    return f(this.R, this.T, this.U);
                default:
                    switch (i) {
                        case 12:
                            byte[] bArr2 = this.ha;
                            int i3 = this.p;
                            this.p = i3 + 1;
                            return x(bArr2[i3] & 255);
                        case 13:
                            byte[] bArr3 = this.ha;
                            int i4 = this.p;
                            this.p = i4 + 1;
                            return A(bArr3[i4] & 255);
                        case 14:
                            byte[] bArr4 = this.ha;
                            int i5 = this.p;
                            this.p = i5 + 1;
                            return z(bArr4[i5] & 255);
                        case 15:
                            byte[] bArr5 = this.ha;
                            int i6 = this.p;
                            this.p = i6 + 1;
                            return y(bArr5[i6] & 255);
                        case 16:
                            return a("null", this.T, JsonToken.VALUE_NULL);
                        case 17:
                            return a(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, this.T, JsonToken.VALUE_TRUE);
                        case 18:
                            return a("false", this.T, JsonToken.VALUE_FALSE);
                        case 19:
                            return d(this.ca, this.T);
                        default:
                            switch (i) {
                                case 23:
                                    byte[] bArr6 = this.ha;
                                    int i7 = this.p;
                                    this.p = i7 + 1;
                                    return l(bArr6[i7] & 255);
                                case 24:
                                    return oa();
                                case 25:
                                    return na();
                                case 26:
                                    return a(this.z.h(), this.z.j());
                                default:
                                    switch (i) {
                                        case 30:
                                            return ma();
                                        case 31:
                                            byte[] bArr7 = this.ha;
                                            int i8 = this.p;
                                            this.p = i8 + 1;
                                            return b(true, bArr7[i8] & 255);
                                        case 32:
                                            byte[] bArr8 = this.ha;
                                            int i9 = this.p;
                                            this.p = i9 + 1;
                                            return b(false, bArr8[i9] & 255);
                                        default:
                                            switch (i) {
                                                case 40:
                                                    return Ca();
                                                case 41:
                                                    int f2 = f(this.V, this.W);
                                                    if (f2 < 0) {
                                                        return JsonToken.NOT_AVAILABLE;
                                                    }
                                                    this.z.a((char) f2);
                                                    if (this.aa == 45) {
                                                        return Ba();
                                                    }
                                                    return Ca();
                                                case 42:
                                                    e eVar = this.z;
                                                    int i10 = this.T;
                                                    byte[] bArr9 = this.ha;
                                                    int i11 = this.p;
                                                    this.p = i11 + 1;
                                                    eVar.a((char) g(i10, bArr9[i11]));
                                                    if (this.aa == 45) {
                                                        return Ba();
                                                    }
                                                    return Ca();
                                                case 43:
                                                    int i12 = this.T;
                                                    int i13 = this.U;
                                                    byte[] bArr10 = this.ha;
                                                    int i14 = this.p;
                                                    this.p = i14 + 1;
                                                    if (!b(i12, i13, bArr10[i14])) {
                                                        return JsonToken.NOT_AVAILABLE;
                                                    }
                                                    if (this.aa == 45) {
                                                        return Ba();
                                                    }
                                                    return Ca();
                                                case 44:
                                                    int i15 = this.T;
                                                    int i16 = this.U;
                                                    byte[] bArr11 = this.ha;
                                                    int i17 = this.p;
                                                    this.p = i17 + 1;
                                                    if (!c(i15, i16, bArr11[i17])) {
                                                        return JsonToken.NOT_AVAILABLE;
                                                    }
                                                    if (this.aa == 45) {
                                                        return Ba();
                                                    }
                                                    return Ca();
                                                case 45:
                                                    return Ba();
                                                default:
                                                    switch (i) {
                                                        case 50:
                                                            return ja();
                                                        case 51:
                                                            return w(this.T);
                                                        case 52:
                                                            return a(this.T, true);
                                                        case 53:
                                                            return a(this.T, false);
                                                        case 54:
                                                            return o(this.T);
                                                        case 55:
                                                            return p(this.T);
                                                        default:
                                                            g.a();
                                                            throw null;
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        byte[] bArr12 = this.ha;
        int i18 = this.p;
        this.p = i18 + 1;
        return v(bArr12[i18] & 255);
    }

    protected final JsonToken qa() throws IOException {
        JsonToken jsonToken = this.m;
        int i = this.Z;
        if (i == 3) {
            return fa();
        }
        if (i == 12) {
            return fa();
        }
        if (i != 50) {
            switch (i) {
                case 16:
                    int i2 = this.T;
                    JsonToken jsonToken2 = JsonToken.VALUE_NULL;
                    b("null", i2, jsonToken2);
                    return jsonToken2;
                case 17:
                    int i3 = this.T;
                    JsonToken jsonToken3 = JsonToken.VALUE_TRUE;
                    b(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, i3, jsonToken3);
                    return jsonToken3;
                case 18:
                    int i4 = this.T;
                    JsonToken jsonToken4 = JsonToken.VALUE_FALSE;
                    b("false", i4, jsonToken4);
                    return jsonToken4;
                case 19:
                    return e(this.ca, this.T);
                default:
                    switch (i) {
                        case 24:
                        case 25:
                            return e(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        case 26:
                            int j = this.z.j();
                            if (this.J) {
                                j--;
                            }
                            this.K = j;
                            JsonToken jsonToken5 = JsonToken.VALUE_NUMBER_INT;
                            c(jsonToken5);
                            return jsonToken5;
                        default:
                            switch (i) {
                                case 30:
                                    this.M = 0;
                                    break;
                                case 31:
                                    a(": was expecting fraction after exponent marker", JsonToken.VALUE_NUMBER_FLOAT);
                                    throw null;
                                case 32:
                                    break;
                                default:
                                    switch (i) {
                                        case 52:
                                        case 53:
                                            a(": was expecting closing '*/' for comment", JsonToken.NOT_AVAILABLE);
                                            throw null;
                                        case 54:
                                        case 55:
                                            return fa();
                                        default:
                                            a(": was expecting rest of token (internal state: " + this.Z + ")", this.m);
                                            throw null;
                                    }
                            }
                            JsonToken jsonToken6 = JsonToken.VALUE_NUMBER_FLOAT;
                            c(jsonToken6);
                            return jsonToken6;
                    }
            }
        }
        ka();
        throw null;
    }

    protected JsonToken ra() throws IOException {
        int i = this.p;
        char[] e2 = this.z.e();
        int[] iArr = fa;
        int min = Math.min(this.q, e2.length + i);
        byte[] bArr = this.ha;
        int i2 = 0;
        while (i < min) {
            int i3 = bArr[i] & 255;
            if (i3 == 39) {
                this.p = i + 1;
                this.z.b(i2);
                JsonToken jsonToken = JsonToken.VALUE_STRING;
                c(jsonToken);
                return jsonToken;
            }
            if (iArr[i3] != 0) {
                break;
            }
            i++;
            e2[i2] = (char) i3;
            i2++;
        }
        this.z.b(i2);
        this.p = i;
        return Ba();
    }

    protected JsonToken sa() throws IOException {
        int i;
        int i2 = this.p;
        if (i2 + 4 < this.q) {
            byte[] bArr = this.ha;
            int i3 = i2 + 1;
            if (bArr[i2] == 97) {
                int i4 = i3 + 1;
                if (bArr[i3] == 108) {
                    int i5 = i4 + 1;
                    if (bArr[i4] == 115) {
                        int i6 = i5 + 1;
                        if (bArr[i5] == 101 && ((i = bArr[i6] & 255) < 48 || i == 93 || i == 125)) {
                            this.p = i6;
                            JsonToken jsonToken = JsonToken.VALUE_FALSE;
                            c(jsonToken);
                            return jsonToken;
                        }
                    }
                }
            }
        }
        this.Z = 18;
        return a("false", 1, JsonToken.VALUE_FALSE);
    }

    protected JsonToken ta() throws IOException {
        this.J = true;
        int i = this.p;
        if (i >= this.q) {
            this.Z = 23;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.m = jsonToken;
            return jsonToken;
        }
        byte[] bArr = this.ha;
        this.p = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 <= 48) {
            if (i2 == 48) {
                return na();
            }
            d(i2, "expected digit (0-9) to follow minus sign, for valid numeric value");
            throw null;
        }
        int i3 = 2;
        if (i2 > 57) {
            if (i2 == 73) {
                return d(3, 2);
            }
            d(i2, "expected digit (0-9) to follow minus sign, for valid numeric value");
            throw null;
        }
        char[] e2 = this.z.e();
        e2[0] = '-';
        e2[1] = (char) i2;
        int i4 = this.p;
        if (i4 >= this.q) {
            this.Z = 26;
            this.z.b(2);
            this.K = 1;
            JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
            this.m = jsonToken2;
            return jsonToken2;
        }
        int i5 = this.ha[i4];
        while (true) {
            if (i5 < 48) {
                if (i5 == 46) {
                    this.K = i3 - 1;
                    this.p++;
                    return a(e2, i3, i5);
                }
            } else if (i5 <= 57) {
                if (i3 >= e2.length) {
                    e2 = this.z.f();
                }
                int i6 = i3 + 1;
                e2[i3] = (char) i5;
                int i7 = this.p + 1;
                this.p = i7;
                if (i7 >= this.q) {
                    this.Z = 26;
                    this.z.b(i6);
                    JsonToken jsonToken3 = JsonToken.NOT_AVAILABLE;
                    this.m = jsonToken3;
                    return jsonToken3;
                }
                i5 = this.ha[this.p] & 255;
                i3 = i6;
            } else if (i5 == 101 || i5 == 69) {
                this.K = i3 - 1;
                this.p++;
                return a(e2, i3, i5);
            }
        }
        this.K = i3 - 1;
        this.z.b(i3);
        JsonToken jsonToken4 = JsonToken.VALUE_NUMBER_INT;
        c(jsonToken4);
        return jsonToken4;
    }

    protected JsonToken ua() throws IOException {
        int i;
        int i2 = this.p;
        if (i2 + 3 < this.q) {
            byte[] bArr = this.ha;
            int i3 = i2 + 1;
            if (bArr[i2] == 117) {
                int i4 = i3 + 1;
                if (bArr[i3] == 108) {
                    int i5 = i4 + 1;
                    if (bArr[i4] == 108 && ((i = bArr[i5] & 255) < 48 || i == 93 || i == 125)) {
                        this.p = i5;
                        JsonToken jsonToken = JsonToken.VALUE_NULL;
                        c(jsonToken);
                        return jsonToken;
                    }
                }
            }
        }
        this.Z = 16;
        return a("null", 1, JsonToken.VALUE_NULL);
    }

    protected JsonToken va() throws IOException {
        int i = this.p;
        if (i >= this.q) {
            this.Z = 24;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this.m = jsonToken;
            return jsonToken;
        }
        int i2 = i + 1;
        int i3 = this.ha[i] & 255;
        if (i3 < 48) {
            if (i3 == 46) {
                this.p = i2;
                this.K = 1;
                char[] e2 = this.z.e();
                e2[0] = '0';
                return a(e2, 1, i3);
            }
        } else {
            if (i3 <= 57) {
                return oa();
            }
            if (i3 == 101 || i3 == 69) {
                this.p = i2;
                this.K = 1;
                char[] e3 = this.z.e();
                e3[0] = '0';
                return a(e3, 1, i3);
            }
            if (i3 != 93 && i3 != 125) {
                d(i3, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
                throw null;
            }
        }
        return e(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    protected JsonToken wa() throws IOException {
        int i = this.p;
        char[] e2 = this.z.e();
        int[] iArr = fa;
        int min = Math.min(this.q, e2.length + i);
        byte[] bArr = this.ha;
        int i2 = 0;
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
                this.z.b(i2);
                JsonToken jsonToken = JsonToken.VALUE_STRING;
                c(jsonToken);
                return jsonToken;
            }
        }
        this.z.b(i2);
        this.p = i;
        return Ca();
    }

    protected JsonToken xa() throws IOException {
        int i;
        int i2 = this.p;
        if (i2 + 3 < this.q) {
            byte[] bArr = this.ha;
            int i3 = i2 + 1;
            if (bArr[i2] == 114) {
                int i4 = i3 + 1;
                if (bArr[i3] == 117) {
                    int i5 = i4 + 1;
                    if (bArr[i4] == 101 && ((i = bArr[i5] & 255) < 48 || i == 93 || i == 125)) {
                        this.p = i5;
                        JsonToken jsonToken = JsonToken.VALUE_TRUE;
                        c(jsonToken);
                        return jsonToken;
                    }
                }
            }
        }
        this.Z = 17;
        return a(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1, JsonToken.VALUE_TRUE);
    }

    protected JsonToken b(boolean z, int i) throws IOException {
        if (z) {
            this.Z = 32;
            if (i == 45 || i == 43) {
                this.z.a((char) i);
                int i2 = this.p;
                if (i2 >= this.q) {
                    this.Z = 32;
                    this.M = 0;
                    return JsonToken.NOT_AVAILABLE;
                }
                byte[] bArr = this.ha;
                this.p = i2 + 1;
                i = bArr[i2];
            }
        }
        char[] h2 = this.z.h();
        int j = this.z.j();
        int i3 = this.M;
        while (i >= 48 && i <= 57) {
            i3++;
            if (j >= h2.length) {
                h2 = this.z.f();
            }
            int i4 = j + 1;
            h2[j] = (char) i;
            int i5 = this.p;
            if (i5 >= this.q) {
                this.z.b(i4);
                this.M = i3;
                return JsonToken.NOT_AVAILABLE;
            }
            byte[] bArr2 = this.ha;
            this.p = i5 + 1;
            i = bArr2[i5];
            j = i4;
        }
        int i6 = i & 255;
        if (i3 != 0) {
            this.p--;
            this.z.b(j);
            this.M = i3;
            JsonToken jsonToken = JsonToken.VALUE_NUMBER_FLOAT;
            c(jsonToken);
            return jsonToken;
        }
        d(i6, "Exponent indicator not followed by a digit");
        throw null;
    }

    private JsonToken e(int i, int i2, int i3) throws IOException {
        int[] iArr = this.Q;
        int[] iArr2 = ga;
        while (true) {
            int i4 = this.p;
            if (i4 >= this.q) {
                this.R = i;
                this.T = i2;
                this.U = i3;
                this.Z = 9;
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                this.m = jsonToken;
                return jsonToken;
            }
            byte[] bArr = this.ha;
            this.p = i4 + 1;
            int i5 = bArr[i4] & 255;
            if (i5 == 39) {
                if (i3 > 0) {
                    if (i >= iArr.length) {
                        iArr = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                        this.Q = iArr;
                    }
                    iArr[i] = b.b(i2, i3);
                    i++;
                } else if (i == 0) {
                    return h("");
                }
                String b2 = this.P.b(iArr, i);
                if (b2 == null) {
                    b2 = a(iArr, i, i3);
                }
                return h(b2);
            }
            if (i5 != 34 && iArr2[i5] != 0) {
                if (i5 != 92) {
                    c(i5, "name");
                } else {
                    i5 = ya();
                    if (i5 < 0) {
                        this.Z = 8;
                        this.aa = 9;
                        this.R = i;
                        this.T = i2;
                        this.U = i3;
                        JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
                        this.m = jsonToken2;
                        return jsonToken2;
                    }
                }
                if (i5 > 127) {
                    if (i3 >= 4) {
                        if (i >= iArr.length) {
                            iArr = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                            this.Q = iArr;
                        }
                        iArr[i] = i2;
                        i++;
                        i2 = 0;
                        i3 = 0;
                    }
                    if (i5 < 2048) {
                        i2 = (i2 << 8) | (i5 >> 6) | 192;
                        i3++;
                    } else {
                        int i6 = (i2 << 8) | (i5 >> 12) | 224;
                        int i7 = i3 + 1;
                        if (i7 >= 4) {
                            if (i >= iArr.length) {
                                int[] a2 = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                                this.Q = a2;
                                iArr = a2;
                            }
                            iArr[i] = i6;
                            i++;
                            i6 = 0;
                            i7 = 0;
                        }
                        i2 = (i6 << 8) | ((i5 >> 6) & 63) | 128;
                        i3 = i7 + 1;
                    }
                    i5 = (i5 & 63) | 128;
                }
            }
            if (i3 < 4) {
                i3++;
                i2 = (i2 << 8) | i5;
            } else {
                if (i >= iArr.length) {
                    iArr = com.fasterxml.jackson.core.b.b.a(iArr, iArr.length);
                    this.Q = iArr;
                }
                iArr[i] = i2;
                i++;
                i2 = i5;
                i3 = 1;
            }
        }
    }

    private final boolean c(int i, int i2, int i3) throws IOException {
        if (i2 == 1) {
            if ((i3 & 192) == 128) {
                i = (i << 6) | (i3 & 63);
                int i4 = this.p;
                if (i4 >= this.q) {
                    this.Z = 44;
                    this.T = i;
                    this.U = 2;
                    return false;
                }
                byte[] bArr = this.ha;
                this.p = i4 + 1;
                i3 = bArr[i4];
                i2 = 2;
            } else {
                c(i3 & 255, this.p);
                throw null;
            }
        }
        if (i2 == 2) {
            if ((i3 & 192) == 128) {
                i = (i << 6) | (i3 & 63);
                int i5 = this.p;
                if (i5 >= this.q) {
                    this.Z = 44;
                    this.T = i;
                    this.U = 3;
                    return false;
                }
                byte[] bArr2 = this.ha;
                this.p = i5 + 1;
                i3 = bArr2[i5];
            } else {
                c(i3 & 255, this.p);
                throw null;
            }
        }
        if ((i3 & 192) == 128) {
            int i6 = ((i << 6) | (i3 & 63)) - 65536;
            this.z.a((char) (55296 | (i6 >> 10)));
            this.z.a((char) ((i6 & 1023) | 56320));
            return true;
        }
        c(i3 & 255, this.p);
        throw null;
    }

    protected JsonToken a(String str, int i, JsonToken jsonToken) throws IOException {
        int length = str.length();
        while (true) {
            int i2 = this.p;
            if (i2 >= this.q) {
                this.T = i;
                JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
                this.m = jsonToken2;
                return jsonToken2;
            }
            byte b2 = this.ha[i2];
            if (i == length) {
                if (b2 < 48 || b2 == 93 || b2 == 125) {
                    c(jsonToken);
                    return jsonToken;
                }
            } else {
                if (b2 != str.charAt(i)) {
                    break;
                }
                i++;
                this.p++;
            }
        }
        this.Z = 50;
        this.z.b(str, 0, i);
        return ja();
    }

    private final int d(int i, int i2, int i3) throws IOException {
        int i4 = i & 15;
        if ((i2 & 192) != 128) {
            c(i2 & 255, this.p);
            throw null;
        }
        int i5 = (i4 << 6) | (i2 & 63);
        if ((i3 & 192) == 128) {
            return (i5 << 6) | (i3 & 63);
        }
        c(i3 & 255, this.p);
        throw null;
    }

    private final String h(int i, int i2, int i3) throws IOException {
        byte[] bArr = this.ha;
        int[] iArr = ga;
        int i4 = i + 1;
        int i5 = bArr[i] & 255;
        if (iArr[i5] != 0) {
            if (i5 != 34) {
                return null;
            }
            this.p = i4;
            return a(this.S, i3, i2, 1);
        }
        int i6 = i5 | (i2 << 8);
        int i7 = i4 + 1;
        int i8 = bArr[i4] & 255;
        if (iArr[i8] != 0) {
            if (i8 != 34) {
                return null;
            }
            this.p = i7;
            return a(this.S, i3, i6, 2);
        }
        int i9 = (i6 << 8) | i8;
        int i10 = i7 + 1;
        int i11 = bArr[i7] & 255;
        if (iArr[i11] != 0) {
            if (i11 != 34) {
                return null;
            }
            this.p = i10;
            return a(this.S, i3, i9, 3);
        }
        int i12 = (i9 << 8) | i11;
        int i13 = i10 + 1;
        if ((bArr[i10] & 255) != 34) {
            return null;
        }
        this.p = i13;
        return a(this.S, i3, i12, 4);
    }

    private int f(int i, int i2) throws IOException {
        int i3 = this.p;
        int i4 = this.q;
        if (i3 >= i4) {
            this.V = i;
            this.W = i2;
            return -1;
        }
        byte[] bArr = this.ha;
        this.p = i3 + 1;
        byte b2 = bArr[i3];
        if (i2 == -1) {
            if (b2 == 34 || b2 == 47 || b2 == 92) {
                return b2;
            }
            if (b2 == 98) {
                return 8;
            }
            if (b2 == 102) {
                return 12;
            }
            if (b2 == 110) {
                return 10;
            }
            if (b2 == 114) {
                return 13;
            }
            if (b2 == 116) {
                return 9;
            }
            if (b2 != 117) {
                char c2 = (char) b2;
                a(c2);
                return c2;
            }
            int i5 = this.p;
            if (i5 >= i4) {
                this.W = 0;
                this.V = 0;
                return -1;
            }
            this.p = i5 + 1;
            b2 = bArr[i5];
            i2 = 0;
        }
        while (true) {
            int i6 = b2 & 255;
            int a2 = com.fasterxml.jackson.core.io.a.a(i6);
            if (a2 < 0) {
                b(i6, "expected a hex-digit for character escape sequence");
                throw null;
            }
            i = (i << 4) | a2;
            i2++;
            if (i2 == 4) {
                return i;
            }
            int i7 = this.p;
            if (i7 >= this.q) {
                this.W = i2;
                this.V = i;
                return -1;
            }
            byte[] bArr2 = this.ha;
            this.p = i7 + 1;
            b2 = bArr2[i7];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:            r4.K = r0 + r6;        r4.z.b(r6);        r5 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT;        c(r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.fasterxml.jackson.core.JsonToken a(char[] r5, int r6) throws java.io.IOException {
        /*
            r4 = this;
            boolean r0 = r4.J
            if (r0 == 0) goto L6
            r0 = -1
            goto L7
        L6:
            r0 = 0
        L7:
            int r1 = r4.p
            int r2 = r4.q
            if (r1 < r2) goto L1b
            r5 = 26
            r4.Z = r5
            com.fasterxml.jackson.core.util.e r5 = r4.z
            r5.b(r6)
            com.fasterxml.jackson.core.JsonToken r5 = com.fasterxml.jackson.core.JsonToken.NOT_AVAILABLE
            r4.m = r5
            return r5
        L1b:
            byte[] r2 = r4.ha
            r2 = r2[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 48
            if (r2 >= r3) goto L35
            r3 = 46
            if (r2 != r3) goto L42
            int r0 = r0 + r6
            r4.K = r0
            int r1 = r1 + 1
            r4.p = r1
            com.fasterxml.jackson.core.JsonToken r5 = r4.a(r5, r6, r2)
            return r5
        L35:
            r3 = 57
            if (r2 <= r3) goto L5e
            r1 = 101(0x65, float:1.42E-43)
            if (r2 == r1) goto L50
            r1 = 69
            if (r2 != r1) goto L42
            goto L50
        L42:
            int r0 = r0 + r6
            r4.K = r0
            com.fasterxml.jackson.core.util.e r5 = r4.z
            r5.b(r6)
            com.fasterxml.jackson.core.JsonToken r5 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT
            r4.c(r5)
            return r5
        L50:
            int r0 = r0 + r6
            r4.K = r0
            int r0 = r4.p
            int r0 = r0 + 1
            r4.p = r0
            com.fasterxml.jackson.core.JsonToken r5 = r4.a(r5, r6, r2)
            return r5
        L5e:
            int r1 = r1 + 1
            r4.p = r1
            int r1 = r5.length
            if (r6 < r1) goto L6b
            com.fasterxml.jackson.core.util.e r5 = r4.z
            char[] r5 = r5.f()
        L6b:
            int r1 = r6 + 1
            char r2 = (char) r2
            r5[r6] = r2
            r6 = r1
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.a.a.a(char[], int):com.fasterxml.jackson.core.JsonToken");
    }

    private final boolean b(int i, int i2, int i3) throws IOException {
        if (i2 == 1) {
            if ((i3 & 192) == 128) {
                i = (i << 6) | (i3 & 63);
                int i4 = this.p;
                if (i4 >= this.q) {
                    this.Z = 43;
                    this.T = i;
                    this.U = 2;
                    return false;
                }
                byte[] bArr = this.ha;
                this.p = i4 + 1;
                i3 = bArr[i4];
            } else {
                c(i3 & 255, this.p);
                throw null;
            }
        }
        if ((i3 & 192) == 128) {
            this.z.a((char) ((i << 6) | (i3 & 63)));
            return true;
        }
        c(i3 & 255, this.p);
        throw null;
    }

    private final int g(int i, int i2) throws IOException {
        if ((i2 & 192) == 128) {
            return ((i & 31) << 6) | (i2 & 63);
        }
        c(i2 & 255, this.p);
        throw null;
    }

    private final int b(int i, int i2, int i3, int i4) throws IOException {
        if ((i2 & 192) != 128) {
            c(i2 & 255, this.p);
            throw null;
        }
        int i5 = ((i & 7) << 6) | (i2 & 63);
        if ((i3 & 192) != 128) {
            c(i3 & 255, this.p);
            throw null;
        }
        int i6 = (i5 << 6) | (i3 & 63);
        if ((i4 & 192) == 128) {
            return ((i6 << 6) | (i4 & 63)) - 65536;
        }
        c(i4 & 255, this.p);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:            r3 = r3 & 255;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:            if (r9 == 0) goto L23;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:            r3 = r10;        r10 = r11;        r11 = r3;     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0058, code lost:            d(r3, "Decimal point not followed by a digit");     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x005d, code lost:            throw null;     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0117  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00f7 -> B:39:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.fasterxml.jackson.core.JsonToken a(char[] r9, int r10, int r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.a.a.a(char[], int, int):com.fasterxml.jackson.core.JsonToken");
    }

    private final boolean a(int i, int i2, boolean z) throws IOException {
        if (i2 == 1) {
            int f2 = f(0, -1);
            if (f2 < 0) {
                this.Z = 41;
                return false;
            }
            this.z.a((char) f2);
            return true;
        }
        if (i2 == 2) {
            if (z) {
                byte[] bArr = this.ha;
                int i3 = this.p;
                this.p = i3 + 1;
                this.z.a((char) g(i, bArr[i3]));
                return true;
            }
            this.Z = 42;
            this.T = i;
            return false;
        }
        if (i2 == 3) {
            int i4 = i & 15;
            if (z) {
                byte[] bArr2 = this.ha;
                int i5 = this.p;
                this.p = i5 + 1;
                return b(i4, 1, bArr2[i5]);
            }
            this.Z = 43;
            this.T = i4;
            this.U = 1;
            return false;
        }
        if (i2 != 4) {
            if (i < 32) {
                c(i, "string value");
                this.z.a((char) i);
                return true;
            }
            h(i);
            throw null;
        }
        int i6 = i & 7;
        if (z) {
            byte[] bArr3 = this.ha;
            int i7 = this.p;
            this.p = i7 + 1;
            return c(i6, 1, bArr3[i7]);
        }
        this.T = i6;
        this.U = 1;
        this.Z = 44;
        return false;
    }
}
