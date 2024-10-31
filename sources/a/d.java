package a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes.dex */
public final class d extends GeneratedMessageLite<d, a> implements e {

    /* renamed from: d, reason: collision with root package name */
    private static final d f6d = new d();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<d> f7e;

    /* renamed from: f, reason: collision with root package name */
    private int f8f;

    /* renamed from: g, reason: collision with root package name */
    private String f9g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f10h = "";
    private long i;
    private float j;
    private double k;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes.dex */
    public static final class a extends GeneratedMessageLite.Builder<d, a> implements e {
        /* synthetic */ a(a.a aVar) {
            this();
        }

        private a() {
            super(d.f6d);
        }
    }

    static {
        f6d.l();
    }

    private d() {
    }

    public static Parser<d> u() {
        return f6d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if ((this.f8f & 1) == 1) {
            codedOutputStream.b(1, n());
        }
        if ((this.f8f & 2) == 2) {
            codedOutputStream.b(2, o());
        }
        if ((this.f8f & 4) == 4) {
            codedOutputStream.e(3, this.i);
        }
        if ((this.f8f & 8) == 8) {
            codedOutputStream.b(4, this.j);
        }
        if ((this.f8f & 16) == 16) {
            codedOutputStream.b(5, this.k);
        }
        this.f18583b.a(codedOutputStream);
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = (this.f8f & 1) == 1 ? 0 + CodedOutputStream.a(1, n()) : 0;
        if ((this.f8f & 2) == 2) {
            a2 += CodedOutputStream.a(2, o());
        }
        if ((this.f8f & 4) == 4) {
            a2 += CodedOutputStream.b(3, this.i);
        }
        if ((this.f8f & 8) == 8) {
            a2 += CodedOutputStream.a(4, this.j);
        }
        if ((this.f8f & 16) == 16) {
            a2 += CodedOutputStream.a(5, this.k);
        }
        int c2 = a2 + this.f18583b.c();
        this.f18584c = c2;
        return c2;
    }

    public String n() {
        return this.f9g;
    }

    public String o() {
        return this.f10h;
    }

    public boolean p() {
        return (this.f8f & 16) == 16;
    }

    public boolean q() {
        return (this.f8f & 8) == 8;
    }

    public boolean r() {
        return (this.f8f & 4) == 4;
    }

    public boolean s() {
        return (this.f8f & 1) == 1;
    }

    public boolean t() {
        return (this.f8f & 2) == 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a.a aVar = null;
        switch (a.a.f0a[methodToInvoke.ordinal()]) {
            case 1:
                return new d();
            case 2:
                return f6d;
            case 3:
                return null;
            case 4:
                return new a(aVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                d dVar = (d) obj2;
                this.f9g = visitor.a(s(), this.f9g, dVar.s(), dVar.f9g);
                this.f10h = visitor.a(t(), this.f10h, dVar.t(), dVar.f10h);
                this.i = visitor.a(r(), this.i, dVar.r(), dVar.i);
                this.j = visitor.a(q(), this.j, dVar.q(), dVar.j);
                this.k = visitor.a(p(), this.k, dVar.p(), dVar.k);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f8f |= dVar.f8f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    String v = codedInputStream.v();
                                    this.f8f = 1 | this.f8f;
                                    this.f9g = v;
                                } else if (x == 18) {
                                    String v2 = codedInputStream.v();
                                    this.f8f |= 2;
                                    this.f10h = v2;
                                } else if (x == 24) {
                                    this.f8f |= 4;
                                    this.i = codedInputStream.k();
                                } else if (x == 37) {
                                    this.f8f |= 8;
                                    this.j = codedInputStream.i();
                                } else if (x != 41) {
                                    if (!a(x, codedInputStream)) {
                                    }
                                } else {
                                    this.f8f |= 16;
                                    this.k = codedInputStream.e();
                                }
                            }
                            z = true;
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw new RuntimeException(e3.setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f7e == null) {
                    synchronized (d.class) {
                        if (f7e == null) {
                            f7e = new GeneratedMessageLite.DefaultInstanceBasedParser(f6d);
                        }
                    }
                }
                return f7e;
            default:
                throw new UnsupportedOperationException();
        }
        return f6d;
    }
}
