package com.umeng.commonsdk.proguard;

import com.umeng.commonsdk.proguard.ac;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TDeserializer.java */
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final ai f26269a;

    /* renamed from: b, reason: collision with root package name */
    private final av f26270b;

    public m() {
        this(new ac.a());
    }

    private ad j(byte[] bArr, q qVar, q... qVarArr) throws p {
        this.f26270b.a(bArr);
        q[] qVarArr2 = new q[qVarArr.length + 1];
        int i = 0;
        qVarArr2[0] = qVar;
        int i2 = 0;
        while (i2 < qVarArr.length) {
            int i3 = i2 + 1;
            qVarArr2[i3] = qVarArr[i2];
            i2 = i3;
        }
        this.f26269a.j();
        ad adVar = null;
        while (i < qVarArr2.length) {
            adVar = this.f26269a.l();
            if (adVar.f26172b == 0 || adVar.f26173c > qVarArr2[i].a()) {
                return null;
            }
            if (adVar.f26173c != qVarArr2[i].a()) {
                al.a(this.f26269a, adVar.f26172b);
                this.f26269a.m();
            } else {
                i++;
                if (i < qVarArr2.length) {
                    this.f26269a.j();
                }
            }
        }
        return adVar;
    }

    public void a(j jVar, byte[] bArr) throws p {
        try {
            this.f26270b.a(bArr);
            jVar.read(this.f26269a);
        } finally {
            this.f26270b.e();
            this.f26269a.B();
        }
    }

    public Byte b(byte[] bArr, q qVar, q... qVarArr) throws p {
        return (Byte) a((byte) 3, bArr, qVar, qVarArr);
    }

    public Double c(byte[] bArr, q qVar, q... qVarArr) throws p {
        return (Double) a((byte) 4, bArr, qVar, qVarArr);
    }

    public Short d(byte[] bArr, q qVar, q... qVarArr) throws p {
        return (Short) a((byte) 6, bArr, qVar, qVarArr);
    }

    public Integer e(byte[] bArr, q qVar, q... qVarArr) throws p {
        return (Integer) a((byte) 8, bArr, qVar, qVarArr);
    }

    public Long f(byte[] bArr, q qVar, q... qVarArr) throws p {
        return (Long) a((byte) 10, bArr, qVar, qVarArr);
    }

    public String g(byte[] bArr, q qVar, q... qVarArr) throws p {
        return (String) a((byte) 11, bArr, qVar, qVarArr);
    }

    public ByteBuffer h(byte[] bArr, q qVar, q... qVarArr) throws p {
        return (ByteBuffer) a((byte) 100, bArr, qVar, qVarArr);
    }

    public Short i(byte[] bArr, q qVar, q... qVarArr) throws p {
        Short sh;
        try {
            try {
                if (j(bArr, qVar, qVarArr) != null) {
                    this.f26269a.j();
                    sh = Short.valueOf(this.f26269a.l().f26173c);
                } else {
                    sh = null;
                }
                return sh;
            } catch (Exception e2) {
                throw new p(e2);
            }
        } finally {
            this.f26270b.e();
            this.f26269a.B();
        }
    }

    public m(ak akVar) {
        this.f26270b = new av();
        this.f26269a = akVar.a(this.f26270b);
    }

    public void a(j jVar, String str, String str2) throws p {
        try {
            try {
                a(jVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new p("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f26269a.B();
        }
    }

    public void a(j jVar, byte[] bArr, q qVar, q... qVarArr) throws p {
        try {
            try {
                if (j(bArr, qVar, qVarArr) != null) {
                    jVar.read(this.f26269a);
                }
            } catch (Exception e2) {
                throw new p(e2);
            }
        } finally {
            this.f26270b.e();
            this.f26269a.B();
        }
    }

    public Boolean a(byte[] bArr, q qVar, q... qVarArr) throws p {
        return (Boolean) a((byte) 2, bArr, qVar, qVarArr);
    }

    private Object a(byte b2, byte[] bArr, q qVar, q... qVarArr) throws p {
        Object obj;
        try {
            try {
                ad j = j(bArr, qVar, qVarArr);
                if (j != null) {
                    if (b2 != 2) {
                        if (b2 != 3) {
                            if (b2 != 4) {
                                if (b2 != 6) {
                                    if (b2 != 8) {
                                        if (b2 != 100) {
                                            if (b2 != 10) {
                                                if (b2 == 11 && j.f26172b == 11) {
                                                    obj = this.f26269a.z();
                                                }
                                            } else if (j.f26172b == 10) {
                                                obj = Long.valueOf(this.f26269a.x());
                                            }
                                        } else if (j.f26172b == 11) {
                                            obj = this.f26269a.A();
                                        }
                                    } else if (j.f26172b == 8) {
                                        obj = Integer.valueOf(this.f26269a.w());
                                    }
                                } else if (j.f26172b == 6) {
                                    obj = Short.valueOf(this.f26269a.v());
                                }
                            } else if (j.f26172b == 4) {
                                obj = Double.valueOf(this.f26269a.y());
                            }
                        } else if (j.f26172b == 3) {
                            obj = Byte.valueOf(this.f26269a.u());
                        }
                    } else if (j.f26172b == 2) {
                        obj = Boolean.valueOf(this.f26269a.t());
                    }
                    return obj;
                }
                obj = null;
                return obj;
            } catch (Exception e2) {
                throw new p(e2);
            }
        } finally {
            this.f26270b.e();
            this.f26269a.B();
        }
    }

    public void a(j jVar, String str) throws p {
        a(jVar, str.getBytes());
    }
}
