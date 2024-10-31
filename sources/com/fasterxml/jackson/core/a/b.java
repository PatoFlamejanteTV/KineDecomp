package com.fasterxml.jackson.core.a;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.b.d;
import com.fasterxml.jackson.core.io.f;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: ParserBase.java */
/* loaded from: classes.dex */
public abstract class b extends c {
    static final BigInteger s = BigInteger.valueOf(-2147483648L);
    static final BigInteger t = BigInteger.valueOf(2147483647L);
    static final BigInteger u = BigInteger.valueOf(Long.MIN_VALUE);
    static final BigInteger v = BigInteger.valueOf(Long.MAX_VALUE);
    static final BigDecimal w = new BigDecimal(u);
    static final BigDecimal x = new BigDecimal(v);
    static final BigDecimal y = new BigDecimal(s);
    static final BigDecimal z = new BigDecimal(t);
    protected int B;
    protected long C;
    protected double D;
    protected BigInteger E;
    protected BigDecimal F;
    protected boolean G;
    protected int H;
    protected int I;
    protected int J;
    protected final com.fasterxml.jackson.core.io.c b;
    protected boolean c;
    protected d l;
    protected JsonToken m;
    protected final com.fasterxml.jackson.core.util.b n;
    protected byte[] r;
    protected int d = 0;
    protected int e = 0;
    protected long f = 0;
    protected int g = 1;
    protected int h = 0;
    protected long i = 0;
    protected int j = 1;
    protected int k = 0;
    protected char[] o = null;
    protected boolean p = false;
    protected com.fasterxml.jackson.core.util.a q = null;
    protected int A = 0;

    protected abstract boolean p() throws IOException;

    protected abstract void q() throws IOException, JsonParseException;

    protected abstract void r() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(com.fasterxml.jackson.core.io.c cVar, int i) {
        this.f417a = i;
        this.b = cVar;
        this.n = cVar.d();
        this.l = d.g();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String d() throws IOException, JsonParseException {
        return (this.K == JsonToken.START_OBJECT || this.K == JsonToken.START_ARRAY) ? this.l.i().h() : this.l.h();
    }

    @Override // com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.c) {
            this.c = true;
            try {
                r();
            } finally {
                s();
            }
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation e() {
        return new JsonLocation(this.b.a(), (this.f + this.d) - 1, this.g, (this.d - this.h) + 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o() throws IOException {
        if (!p()) {
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() throws IOException {
        this.n.a();
        char[] cArr = this.o;
        if (cArr != null) {
            this.o = null;
            this.b.c(cArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.a.c
    public void t() throws JsonParseException {
        if (!this.l.b()) {
            c(": expected close marker for " + this.l.d() + " (from " + this.l.a(this.b.a()) + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, char c) throws JsonParseException {
        d("Unexpected close marker '" + ((char) i) + "': expected '" + c + "' (for " + this.l.d() + " starting at " + ("" + this.l.a(this.b.a())) + ")");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken a(boolean z2, int i, int i2, int i3) {
        return (i2 >= 1 || i3 >= 1) ? b(z2, i, i2, i3) : a(z2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken a(boolean z2, int i) {
        this.G = z2;
        this.H = i;
        this.I = 0;
        this.J = 0;
        this.A = 0;
        return JsonToken.VALUE_NUMBER_INT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken b(boolean z2, int i, int i2, int i3) {
        this.G = z2;
        this.H = i;
        this.I = i2;
        this.J = i3;
        this.A = 0;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken a(String str, double d) {
        this.n.a(str);
        this.D = d;
        this.A = 8;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int i() throws IOException, JsonParseException {
        if ((this.A & 1) == 0) {
            if (this.A == 0) {
                a(1);
            }
            if ((this.A & 1) == 0) {
                u();
            }
        }
        return this.B;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long j() throws IOException, JsonParseException {
        if ((this.A & 2) == 0) {
            if (this.A == 0) {
                a(2);
            }
            if ((this.A & 2) == 0) {
                v();
            }
        }
        return this.C;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigInteger k() throws IOException, JsonParseException {
        if ((this.A & 4) == 0) {
            if (this.A == 0) {
                a(4);
            }
            if ((this.A & 4) == 0) {
                w();
            }
        }
        return this.E;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public float l() throws IOException, JsonParseException {
        return (float) m();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double m() throws IOException, JsonParseException {
        if ((this.A & 8) == 0) {
            if (this.A == 0) {
                a(8);
            }
            if ((this.A & 8) == 0) {
                x();
            }
        }
        return this.D;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigDecimal n() throws IOException, JsonParseException {
        if ((this.A & 16) == 0) {
            if (this.A == 0) {
                a(16);
            }
            if ((this.A & 16) == 0) {
                y();
            }
        }
        return this.F;
    }

    protected void a(int i) throws IOException, JsonParseException {
        if (this.K == JsonToken.VALUE_NUMBER_INT) {
            char[] e = this.n.e();
            int d = this.n.d();
            int i2 = this.H;
            if (this.G) {
                d++;
            }
            if (i2 <= 9) {
                int a2 = f.a(e, d, i2);
                if (this.G) {
                    a2 = -a2;
                }
                this.B = a2;
                this.A = 1;
                return;
            }
            if (i2 <= 18) {
                long b = f.b(e, d, i2);
                if (this.G) {
                    b = -b;
                }
                if (i2 == 10) {
                    if (this.G) {
                        if (b >= -2147483648L) {
                            this.B = (int) b;
                            this.A = 1;
                            return;
                        }
                    } else if (b <= 2147483647L) {
                        this.B = (int) b;
                        this.A = 1;
                        return;
                    }
                }
                this.C = b;
                this.A = 2;
                return;
            }
            a(i, e, d, i2);
            return;
        }
        if (this.K == JsonToken.VALUE_NUMBER_FLOAT) {
            d(i);
        } else {
            d("Current token (" + this.K + ") not numeric, can not use numeric value accessors");
        }
    }

    private void d(int i) throws IOException, JsonParseException {
        try {
            if (i == 16) {
                this.F = this.n.h();
                this.A = 16;
            } else {
                this.D = this.n.i();
                this.A = 8;
            }
        } catch (NumberFormatException e) {
            a("Malformed numeric value '" + this.n.f() + "'", e);
        }
    }

    private void a(int i, char[] cArr, int i2, int i3) throws IOException, JsonParseException {
        String f = this.n.f();
        try {
            if (f.a(cArr, i2, i3, this.G)) {
                this.C = Long.parseLong(f);
                this.A = 2;
            } else {
                this.E = new BigInteger(f);
                this.A = 4;
            }
        } catch (NumberFormatException e) {
            a("Malformed numeric value '" + f + "'", e);
        }
    }

    protected void u() throws IOException, JsonParseException {
        if ((this.A & 2) != 0) {
            int i = (int) this.C;
            if (i != this.C) {
                d("Numeric value (" + f() + ") out of range of int");
            }
            this.B = i;
        } else if ((this.A & 4) != 0) {
            if (s.compareTo(this.E) > 0 || t.compareTo(this.E) < 0) {
                z();
            }
            this.B = this.E.intValue();
        } else if ((this.A & 8) != 0) {
            if (this.D < -2.147483648E9d || this.D > 2.147483647E9d) {
                z();
            }
            this.B = (int) this.D;
        } else if ((this.A & 16) != 0) {
            if (y.compareTo(this.F) > 0 || z.compareTo(this.F) < 0) {
                z();
            }
            this.B = this.F.intValue();
        } else {
            E();
        }
        this.A |= 1;
    }

    protected void v() throws IOException, JsonParseException {
        if ((this.A & 1) != 0) {
            this.C = this.B;
        } else if ((this.A & 4) != 0) {
            if (u.compareTo(this.E) > 0 || v.compareTo(this.E) < 0) {
                A();
            }
            this.C = this.E.longValue();
        } else if ((this.A & 8) != 0) {
            if (this.D < -9.223372036854776E18d || this.D > 9.223372036854776E18d) {
                A();
            }
            this.C = (long) this.D;
        } else if ((this.A & 16) != 0) {
            if (w.compareTo(this.F) > 0 || x.compareTo(this.F) < 0) {
                A();
            }
            this.C = this.F.longValue();
        } else {
            E();
        }
        this.A |= 2;
    }

    protected void w() throws IOException, JsonParseException {
        if ((this.A & 16) != 0) {
            this.E = this.F.toBigInteger();
        } else if ((this.A & 2) != 0) {
            this.E = BigInteger.valueOf(this.C);
        } else if ((this.A & 1) != 0) {
            this.E = BigInteger.valueOf(this.B);
        } else if ((this.A & 8) != 0) {
            this.E = BigDecimal.valueOf(this.D).toBigInteger();
        } else {
            E();
        }
        this.A |= 4;
    }

    protected void x() throws IOException, JsonParseException {
        if ((this.A & 16) != 0) {
            this.D = this.F.doubleValue();
        } else if ((this.A & 4) != 0) {
            this.D = this.E.doubleValue();
        } else if ((this.A & 2) != 0) {
            this.D = this.C;
        } else if ((this.A & 1) != 0) {
            this.D = this.B;
        } else {
            E();
        }
        this.A |= 8;
    }

    protected void y() throws IOException, JsonParseException {
        if ((this.A & 8) != 0) {
            this.F = new BigDecimal(f());
        } else if ((this.A & 4) != 0) {
            this.F = new BigDecimal(this.E);
        } else if ((this.A & 2) != 0) {
            this.F = BigDecimal.valueOf(this.C);
        } else if ((this.A & 1) != 0) {
            this.F = BigDecimal.valueOf(this.B);
        } else {
            E();
        }
        this.A |= 16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, String str) throws JsonParseException {
        String str2 = "Unexpected character (" + c(i) + ") in numeric value";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        d(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) throws JsonParseException {
        d("Invalid numeric value: " + str);
    }

    protected void z() throws IOException, JsonParseException {
        d("Numeric value (" + f() + ") out of range of int (" + NexEditorDeviceProfile.UNKNOWN + " - 2147483647)");
    }

    protected void A() throws IOException, JsonParseException {
        d("Numeric value (" + f() + ") out of range of long (-9223372036854775808 - 9223372036854775807)");
    }

    protected char B() throws IOException, JsonParseException {
        throw new UnsupportedOperationException();
    }
}
