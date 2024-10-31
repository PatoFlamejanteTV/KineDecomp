package com.fasterxml.jackson.core.b;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.c.d;
import com.fasterxml.jackson.core.io.f;
import com.fasterxml.jackson.core.util.e;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/* compiled from: ParserBase.java */
/* loaded from: classes.dex */
public abstract class b extends c {
    protected char[] A;
    protected boolean B;
    protected byte[] C;
    protected int D;
    protected int E;
    protected long F;
    protected double G;
    protected BigInteger H;
    protected BigDecimal I;
    protected boolean J;
    protected int K;
    protected int L;
    protected int M;
    protected final com.fasterxml.jackson.core.io.c n;
    protected boolean o;
    protected int p;
    protected int q;
    protected long r;
    protected int s;
    protected int t;
    protected long u;
    protected int v;
    protected int w;
    protected d x;
    protected JsonToken y;
    protected final e z;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(com.fasterxml.jackson.core.io.c cVar, int i) {
        super(i);
        this.s = 1;
        this.v = 1;
        this.D = 0;
        this.n = cVar;
        this.z = cVar.e();
        this.x = d.a(JsonParser.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i) ? com.fasterxml.jackson.core.c.b.a(this) : null);
    }

    private void e(int i) throws IOException {
        try {
            if (i == 16) {
                this.I = this.z.b();
                this.D = 16;
            } else {
                this.G = this.z.c();
                this.D = 8;
            }
        } catch (NumberFormatException e2) {
            b("Malformed numeric value '" + this.z.d() + "'", e2);
            throw null;
        }
    }

    private void h(int i) throws IOException {
        String d2 = this.z.d();
        try {
            int i2 = this.K;
            char[] k = this.z.k();
            int l = this.z.l();
            if (this.J) {
                l++;
            }
            if (f.a(k, l, i2, this.J)) {
                this.F = Long.parseLong(d2);
                this.D = 2;
            } else {
                this.H = new BigInteger(d2);
                this.D = 4;
            }
        } catch (NumberFormatException e2) {
            b("Malformed numeric value '" + d2 + "'", e2);
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.b.c
    public void N() throws JsonParseException {
        if (this.x.f()) {
            return;
        }
        a(String.format(": expected close marker for %s (start marker at %s)", this.x.d() ? "Array" : "Object", this.x.a(U())), (JsonToken) null);
        throw null;
    }

    protected abstract void S() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public final int T() throws JsonParseException {
        N();
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object U() {
        if (JsonParser.Feature.INCLUDE_SOURCE_IN_LOCATION.enabledIn(this.f9672a)) {
            return this.n.g();
        }
        return null;
    }

    protected int V() throws IOException {
        if (this.m == JsonToken.VALUE_NUMBER_INT && this.K <= 9) {
            int a2 = this.z.a(this.J);
            this.E = a2;
            this.D = 1;
            return a2;
        }
        d(1);
        if ((this.D & 1) == 0) {
            aa();
        }
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W() throws IOException {
        this.z.m();
        char[] cArr = this.A;
        if (cArr != null) {
            this.A = null;
            this.n.b(cArr);
        }
    }

    protected void X() throws IOException {
        int i = this.D;
        if ((i & 8) != 0) {
            this.I = f.a(A());
        } else if ((i & 4) != 0) {
            this.I = new BigDecimal(this.H);
        } else if ((i & 2) != 0) {
            this.I = BigDecimal.valueOf(this.F);
        } else if ((i & 1) != 0) {
            this.I = BigDecimal.valueOf(this.E);
        } else {
            P();
            throw null;
        }
        this.D |= 16;
    }

    protected void Y() throws IOException {
        int i = this.D;
        if ((i & 16) != 0) {
            this.H = this.I.toBigInteger();
        } else if ((i & 2) != 0) {
            this.H = BigInteger.valueOf(this.F);
        } else if ((i & 1) != 0) {
            this.H = BigInteger.valueOf(this.E);
        } else if ((i & 8) != 0) {
            this.H = BigDecimal.valueOf(this.G).toBigInteger();
        } else {
            P();
            throw null;
        }
        this.D |= 4;
    }

    protected void Z() throws IOException {
        int i = this.D;
        if ((i & 16) != 0) {
            this.G = this.I.doubleValue();
        } else if ((i & 4) != 0) {
            this.G = this.H.doubleValue();
        } else if ((i & 2) != 0) {
            this.G = this.F;
        } else if ((i & 1) != 0) {
            this.G = this.E;
        } else {
            P();
            throw null;
        }
        this.D |= 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken a(boolean z, int i, int i2, int i3) {
        if (i2 < 1 && i3 < 1) {
            return a(z, i);
        }
        return b(z, i, i2, i3);
    }

    protected void aa() throws IOException {
        int i = this.D;
        if ((i & 2) != 0) {
            long j = this.F;
            int i2 = (int) j;
            if (i2 == j) {
                this.E = i2;
            } else {
                f("Numeric value (" + A() + ") out of range of int");
                throw null;
            }
        } else if ((i & 4) != 0) {
            if (c.f9685e.compareTo(this.H) <= 0 && c.f9686f.compareTo(this.H) >= 0) {
                this.E = this.H.intValue();
            } else {
                Q();
                throw null;
            }
        } else if ((i & 8) != 0) {
            double d2 = this.G;
            if (d2 >= -2.147483648E9d && d2 <= 2.147483647E9d) {
                this.E = (int) d2;
            } else {
                Q();
                throw null;
            }
        } else if ((i & 16) != 0) {
            if (c.k.compareTo(this.I) <= 0 && c.l.compareTo(this.I) >= 0) {
                this.E = this.I.intValue();
            } else {
                Q();
                throw null;
            }
        } else {
            P();
            throw null;
        }
        this.D |= 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken b(boolean z, int i, int i2, int i3) {
        this.J = z;
        this.K = i;
        this.L = i2;
        this.M = i3;
        this.D = 0;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    protected void ba() throws IOException {
        int i = this.D;
        if ((i & 1) != 0) {
            this.F = this.E;
        } else if ((i & 4) != 0) {
            if (c.f9687g.compareTo(this.H) <= 0 && c.f9688h.compareTo(this.H) >= 0) {
                this.F = this.H.longValue();
            } else {
                R();
                throw null;
            }
        } else if ((i & 8) != 0) {
            double d2 = this.G;
            if (d2 >= -9.223372036854776E18d && d2 <= 9.223372036854776E18d) {
                this.F = (long) d2;
            } else {
                R();
                throw null;
            }
        } else if ((i & 16) != 0) {
            if (c.i.compareTo(this.I) <= 0 && c.j.compareTo(this.I) >= 0) {
                this.F = this.I.longValue();
            } else {
                R();
                throw null;
            }
        } else {
            P();
            throw null;
        }
        this.D |= 2;
    }

    public d ca() {
        return this.x;
    }

    @Override // com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.o) {
            return;
        }
        this.p = Math.max(this.p, this.q);
        this.o = true;
        try {
            S();
        } finally {
            W();
        }
    }

    protected void d(int i) throws IOException {
        JsonToken jsonToken = this.m;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
            int i2 = this.K;
            if (i2 <= 9) {
                this.E = this.z.a(this.J);
                this.D = 1;
                return;
            }
            if (i2 <= 18) {
                long b2 = this.z.b(this.J);
                if (i2 == 10) {
                    if (this.J) {
                        if (b2 >= -2147483648L) {
                            this.E = (int) b2;
                            this.D = 1;
                            return;
                        }
                    } else if (b2 <= 2147483647L) {
                        this.E = (int) b2;
                        this.D = 1;
                        return;
                    }
                }
                this.F = b2;
                this.D = 2;
                return;
            }
            h(i);
            return;
        }
        if (jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            e(i);
        } else {
            a("Current token (%s) not numeric, can not use numeric value accessors", (Object) jsonToken);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String r() throws IOException {
        d j;
        JsonToken jsonToken = this.m;
        if ((jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) && (j = this.x.j()) != null) {
            return j.b();
        }
        return this.x.b();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigDecimal u() throws IOException {
        int i = this.D;
        if ((i & 16) == 0) {
            if (i == 0) {
                d(16);
            }
            if ((this.D & 16) == 0) {
                X();
            }
        }
        return this.I;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double v() throws IOException {
        int i = this.D;
        if ((i & 8) == 0) {
            if (i == 0) {
                d(8);
            }
            if ((this.D & 8) == 0) {
                Z();
            }
        }
        return this.G;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public float w() throws IOException {
        return (float) v();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int x() throws IOException {
        int i = this.D;
        if ((i & 1) == 0) {
            if (i == 0) {
                return V();
            }
            if ((i & 1) == 0) {
                aa();
            }
        }
        return this.E;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long y() throws IOException {
        int i = this.D;
        if ((i & 2) == 0) {
            if (i == 0) {
                d(2);
            }
            if ((this.D & 2) == 0) {
                ba();
            }
        }
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken a(boolean z, int i) {
        this.J = z;
        this.K = i;
        this.L = 0;
        this.M = 0;
        this.D = 0;
        return JsonToken.VALUE_NUMBER_INT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken a(String str, double d2) {
        this.z.a(str);
        this.G = d2;
        this.D = 8;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigInteger a() throws IOException {
        int i = this.D;
        if ((i & 4) == 0) {
            if (i == 0) {
                d(4);
            }
            if ((this.D & 4) == 0) {
                Y();
            }
        }
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, char c2) throws JsonParseException {
        d ca = ca();
        f(String.format("Unexpected close marker '%s': expected '%c' (for %s starting at %s)", Character.valueOf((char) i), Character.valueOf(c2), ca.g(), ca.a(U())));
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int[] a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return Arrays.copyOf(iArr, iArr.length + i);
    }
}
