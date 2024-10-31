package com.fasterxml.jackson.core.c.a;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.c.d;
import com.fasterxml.jackson.core.io.c;
import java.io.IOException;

/* compiled from: NonBlockingJsonParserBase.java */
/* loaded from: classes.dex */
public abstract class b extends com.fasterxml.jackson.core.b.b {
    protected static final String[] N = {"NaN", "Infinity", "+Infinity", "-Infinity"};
    protected static final double[] O = {Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
    protected final com.fasterxml.jackson.core.d.a P;
    protected int[] Q;
    protected int R;
    protected int S;
    protected int T;
    protected int U;
    protected int V;
    protected int W;
    protected int X;
    protected int Y;
    protected int Z;
    protected int aa;
    protected boolean ba;
    protected int ca;
    protected int da;
    protected int ea;

    public b(c cVar, int i, com.fasterxml.jackson.core.d.a aVar) {
        super(cVar, i);
        this.Q = new int[8];
        this.ba = false;
        this.da = 0;
        this.ea = 1;
        this.P = aVar;
        this.m = null;
        this.X = 0;
        this.Y = 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final int b(int i, int i2) {
        return i2 == 4 ? i : i | ((-1) << (i2 << 3));
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String A() throws IOException {
        JsonToken jsonToken = this.m;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return this.z.d();
        }
        return b(jsonToken);
    }

    @Override // com.fasterxml.jackson.core.b.b
    protected void S() throws IOException {
        this.da = 0;
        this.q = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.b.b
    public void W() throws IOException {
        super.W();
        this.P.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(int i, int i2) throws JsonParseException {
        int b2 = b(i, i2);
        String d2 = this.P.d(b2);
        if (d2 != null) {
            return d2;
        }
        int[] iArr = this.Q;
        iArr[0] = b2;
        return a(iArr, 1, i2);
    }

    protected final String b(JsonToken jsonToken) {
        int id;
        if (jsonToken == null || (id = jsonToken.id()) == -1) {
            return null;
        }
        if (id == 5) {
            return this.x.b();
        }
        if (id != 6 && id != 7 && id != 8) {
            return jsonToken.asString();
        }
        return this.z.d();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation c() {
        return new JsonLocation(U(), this.r + (this.p - this.da), -1L, Math.max(this.s, this.ea), (this.p - this.t) + 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken da() throws IOException {
        int i;
        if (this.x.d()) {
            d j = this.x.j();
            this.x = j;
            if (j.e()) {
                i = 3;
            } else {
                i = j.d() ? 6 : 1;
            }
            this.X = i;
            this.Y = i;
            JsonToken jsonToken = JsonToken.END_ARRAY;
            this.m = jsonToken;
            return jsonToken;
        }
        a(93, '}');
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken e(int i, String str) throws IOException {
        this.z.a(str);
        this.K = str.length();
        this.D = 1;
        this.E = i;
        this.X = this.Y;
        JsonToken jsonToken = JsonToken.VALUE_NUMBER_INT;
        this.m = jsonToken;
        return jsonToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken ea() throws IOException {
        int i;
        if (this.x.e()) {
            d j = this.x.j();
            this.x = j;
            if (j.e()) {
                i = 3;
            } else {
                i = j.d() ? 6 : 1;
            }
            this.X = i;
            this.Y = i;
            JsonToken jsonToken = JsonToken.END_OBJECT;
            this.m = jsonToken;
            return jsonToken;
        }
        a(125, ']');
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken fa() throws IOException {
        this.X = 7;
        if (!this.x.f()) {
            N();
        }
        close();
        this.m = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken ga() throws IOException {
        this.x = this.x.a(-1, -1);
        this.X = 5;
        this.Y = 6;
        JsonToken jsonToken = JsonToken.START_ARRAY;
        this.m = jsonToken;
        return jsonToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken h(String str) throws IOException {
        this.X = 4;
        this.x.a(str);
        JsonToken jsonToken = JsonToken.FIELD_NAME;
        this.m = jsonToken;
        return jsonToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken ha() throws IOException {
        this.x = this.x.b(-1, -1);
        this.X = 2;
        this.Y = 3;
        JsonToken jsonToken = JsonToken.START_OBJECT;
        this.m = jsonToken;
        return jsonToken;
    }

    protected void i(int i) throws JsonParseException {
        f("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ia() {
        this.v = Math.max(this.s, this.ea);
        this.w = this.p - this.t;
        this.u = this.r + (r0 - this.da);
    }

    protected void j(int i) throws JsonParseException {
        f("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken k(int i) throws IOException {
        String str = N[i];
        this.z.a(str);
        if (a(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            this.K = 0;
            this.D = 8;
            this.G = O[i];
            this.X = this.Y;
            JsonToken jsonToken = JsonToken.VALUE_NUMBER_FLOAT;
            this.m = jsonToken;
            return jsonToken;
        }
        a("Non-standard token '%s': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow", str);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken c(JsonToken jsonToken) throws IOException {
        this.X = this.Y;
        this.m = jsonToken;
        return jsonToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(int i) throws JsonParseException {
        if (i < 32) {
            c(i);
            throw null;
        }
        i(i);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(int i, int i2, int i3) throws JsonParseException {
        int b2 = b(i2, i3);
        String b3 = this.P.b(i, b2);
        if (b3 != null) {
            return b3;
        }
        int[] iArr = this.Q;
        iArr[0] = i;
        iArr[1] = b2;
        return a(iArr, 2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i, int i2) throws JsonParseException {
        this.p = i2;
        j(i);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String e(int i) {
        return N[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(int i, int i2, int i3, int i4) throws JsonParseException {
        int b2 = b(i3, i4);
        String b3 = this.P.b(i, i2, b2);
        if (b3 != null) {
            return b3;
        }
        int[] iArr = this.Q;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = b(b2, i4);
        return a(iArr, 3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(int[] iArr, int i, int i2) throws JsonParseException {
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
                        i(i10);
                        throw null;
                    }
                    i4 = i10 & 7;
                    i5 = 3;
                }
                if (i8 + i5 <= i6) {
                    int i11 = iArr[i8 >> 2] >> ((3 - (i8 & 3)) << 3);
                    i8++;
                    if ((i11 & 192) != 128) {
                        j(i11);
                        throw null;
                    }
                    int i12 = (i4 << 6) | (i11 & 63);
                    if (i5 > 1) {
                        int i13 = iArr[i8 >> 2] >> ((3 - (i8 & 3)) << 3);
                        i8++;
                        if ((i13 & 192) != 128) {
                            j(i13);
                            throw null;
                        }
                        int i14 = (i13 & 63) | (i12 << 6);
                        if (i5 > 2) {
                            int i15 = iArr[i8 >> 2] >> ((3 - (i8 & 3)) << 3);
                            i8++;
                            if ((i15 & 192) != 128) {
                                j(i15 & 255);
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
        return this.P.a(str, iArr, i);
    }
}
