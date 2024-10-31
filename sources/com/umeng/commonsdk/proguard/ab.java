package com.umeng.commonsdk.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TBinaryProtocol.java */
/* loaded from: classes3.dex */
public class ab extends ai {

    /* renamed from: a, reason: collision with root package name */
    protected static final int f26145a = -65536;

    /* renamed from: b, reason: collision with root package name */
    protected static final int f26146b = -2147418112;

    /* renamed from: h, reason: collision with root package name */
    private static final an f26147h = new an();

    /* renamed from: c, reason: collision with root package name */
    protected boolean f26148c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f26149d;

    /* renamed from: e, reason: collision with root package name */
    protected int f26150e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f26151f;
    private byte[] i;
    private byte[] j;
    private byte[] k;
    private byte[] l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    /* compiled from: TBinaryProtocol.java */
    /* loaded from: classes3.dex */
    public static class a implements ak {

        /* renamed from: a, reason: collision with root package name */
        protected boolean f26152a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f26153b;

        /* renamed from: c, reason: collision with root package name */
        protected int f26154c;

        public a() {
            this(false, true);
        }

        @Override // com.umeng.commonsdk.proguard.ak
        public ai a(aw awVar) {
            ab abVar = new ab(awVar, this.f26152a, this.f26153b);
            int i = this.f26154c;
            if (i != 0) {
                abVar.c(i);
            }
            return abVar;
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f26152a = false;
            this.f26153b = true;
            this.f26152a = z;
            this.f26153b = z2;
            this.f26154c = i;
        }
    }

    public ab(aw awVar) {
        this(awVar, false, true);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public ByteBuffer A() throws p {
        int w = w();
        d(w);
        if (this.f26186g.h() >= w) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f26186g.f(), this.f26186g.g(), w);
            this.f26186g.a(w);
            return wrap;
        }
        byte[] bArr = new byte[w];
        this.f26186g.d(bArr, 0, w);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a() {
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a(ag agVar) throws p {
        if (this.f26149d) {
            a(f26146b | agVar.f26180b);
            a(agVar.f26179a);
            a(agVar.f26181c);
        } else {
            a(agVar.f26179a);
            a(agVar.f26180b);
            a(agVar.f26181c);
        }
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a(an anVar) {
    }

    public String b(int i) throws p {
        try {
            d(i);
            byte[] bArr = new byte[i];
            this.f26186g.d(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new p("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void b() {
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void c() {
    }

    public void c(int i) {
        this.f26150e = i;
        this.f26151f = true;
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void d() throws p {
        a((byte) 0);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void e() {
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void f() {
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void g() {
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public ag h() throws p {
        int w = w();
        if (w < 0) {
            if (((-65536) & w) == f26146b) {
                return new ag(z(), (byte) (w & 255), w());
            }
            throw new aj(4, "Bad version in readMessageBegin");
        }
        if (!this.f26148c) {
            return new ag(b(w), u(), w());
        }
        throw new aj(4, "Missing version in readMessageBegin, old client?");
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void i() {
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public an j() {
        return f26147h;
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void k() {
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public ad l() throws p {
        byte u = u();
        return new ad("", u, u == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void m() {
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public af n() throws p {
        return new af(u(), u(), w());
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void o() {
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public ae p() throws p {
        return new ae(u(), w());
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void q() {
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public am r() throws p {
        return new am(u(), w());
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void s() {
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public boolean t() throws p {
        return u() == 1;
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public byte u() throws p {
        if (this.f26186g.h() >= 1) {
            byte b2 = this.f26186g.f()[this.f26186g.g()];
            this.f26186g.a(1);
            return b2;
        }
        a(this.m, 0, 1);
        return this.m[0];
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public short v() throws p {
        byte[] bArr = this.n;
        int i = 0;
        if (this.f26186g.h() >= 2) {
            bArr = this.f26186g.f();
            i = this.f26186g.g();
            this.f26186g.a(2);
        } else {
            a(this.n, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public int w() throws p {
        byte[] bArr = this.o;
        int i = 0;
        if (this.f26186g.h() >= 4) {
            bArr = this.f26186g.f();
            i = this.f26186g.g();
            this.f26186g.a(4);
        } else {
            a(this.o, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public long x() throws p {
        byte[] bArr = this.p;
        int i = 0;
        if (this.f26186g.h() >= 8) {
            bArr = this.f26186g.f();
            i = this.f26186g.g();
            this.f26186g.a(8);
        } else {
            a(this.p, 0, 8);
        }
        return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public double y() throws p {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public String z() throws p {
        int w = w();
        if (this.f26186g.h() >= w) {
            try {
                String str = new String(this.f26186g.f(), this.f26186g.g(), w, "UTF-8");
                this.f26186g.a(w);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new p("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return b(w);
    }

    public ab(aw awVar, boolean z, boolean z2) {
        super(awVar);
        this.f26148c = false;
        this.f26149d = true;
        this.f26151f = false;
        this.i = new byte[1];
        this.j = new byte[2];
        this.k = new byte[4];
        this.l = new byte[8];
        this.m = new byte[1];
        this.n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.f26148c = z;
        this.f26149d = z2;
    }

    protected void d(int i) throws p {
        if (i >= 0) {
            if (this.f26151f) {
                this.f26150e -= i;
                if (this.f26150e >= 0) {
                    return;
                }
                throw new aj("Message length exceeded: " + i);
            }
            return;
        }
        throw new aj("Negative length: " + i);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a(ad adVar) throws p {
        a(adVar.f26172b);
        a(adVar.f26173c);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a(af afVar) throws p {
        a(afVar.f26176a);
        a(afVar.f26177b);
        a(afVar.f26178c);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a(ae aeVar) throws p {
        a(aeVar.f26174a);
        a(aeVar.f26175b);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a(am amVar) throws p {
        a(amVar.f26196a);
        a(amVar.f26197b);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a(boolean z) throws p {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a(byte b2) throws p {
        byte[] bArr = this.i;
        bArr[0] = b2;
        this.f26186g.b(bArr, 0, 1);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a(short s) throws p {
        byte[] bArr = this.j;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.f26186g.b(bArr, 0, 2);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a(int i) throws p {
        byte[] bArr = this.k;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.f26186g.b(bArr, 0, 4);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a(long j) throws p {
        byte[] bArr = this.l;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        this.f26186g.b(bArr, 0, 8);
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a(double d2) throws p {
        a(Double.doubleToLongBits(d2));
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a(String str) throws p {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f26186g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new p("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.commonsdk.proguard.ai
    public void a(ByteBuffer byteBuffer) throws p {
        int limit = byteBuffer.limit() - byteBuffer.position();
        a(limit);
        this.f26186g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    private int a(byte[] bArr, int i, int i2) throws p {
        d(i2);
        return this.f26186g.d(bArr, i, i2);
    }
}
