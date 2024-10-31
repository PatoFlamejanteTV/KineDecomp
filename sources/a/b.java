package a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite<b, a> implements c {

    /* renamed from: d, reason: collision with root package name */
    private static final b f1d = new b();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<b> f2e;

    /* renamed from: f, reason: collision with root package name */
    private int f3f;

    /* renamed from: g, reason: collision with root package name */
    private Internal.ProtobufList<d> f4g = GeneratedMessageLite.k();

    /* renamed from: h, reason: collision with root package name */
    private String f5h = "";
    private long i;
    private long j;
    private int k;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes.dex */
    public static final class a extends GeneratedMessageLite.Builder<b, a> implements c {
        /* synthetic */ a(a.a aVar) {
            this();
        }

        private a() {
            super(b.f1d);
        }
    }

    static {
        f1d.l();
    }

    private b() {
    }

    public static b n() {
        return f1d;
    }

    public static Parser<b> t() {
        return f1d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f4g.size(); i++) {
            codedOutputStream.c(1, this.f4g.get(i));
        }
        if ((this.f3f & 1) == 1) {
            codedOutputStream.b(2, o());
        }
        if ((this.f3f & 2) == 2) {
            codedOutputStream.e(3, this.i);
        }
        if ((this.f3f & 4) == 4) {
            codedOutputStream.e(4, this.j);
        }
        if ((this.f3f & 8) == 8) {
            codedOutputStream.g(5, this.k);
        }
        this.f18583b.a(codedOutputStream);
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f4g.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f4g.get(i3));
        }
        if ((this.f3f & 1) == 1) {
            i2 += CodedOutputStream.a(2, o());
        }
        if ((this.f3f & 2) == 2) {
            i2 += CodedOutputStream.b(3, this.i);
        }
        if ((this.f3f & 4) == 4) {
            i2 += CodedOutputStream.b(4, this.j);
        }
        if ((this.f3f & 8) == 8) {
            i2 += CodedOutputStream.c(5, this.k);
        }
        int c2 = i2 + this.f18583b.c();
        this.f18584c = c2;
        return c2;
    }

    public String o() {
        return this.f5h;
    }

    public boolean p() {
        return (this.f3f & 8) == 8;
    }

    public boolean q() {
        return (this.f3f & 1) == 1;
    }

    public boolean r() {
        return (this.f3f & 4) == 4;
    }

    public boolean s() {
        return (this.f3f & 2) == 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a.a aVar = null;
        switch (a.a.f0a[methodToInvoke.ordinal()]) {
            case 1:
                return new b();
            case 2:
                return f1d;
            case 3:
                this.f4g.L();
                return null;
            case 4:
                return new a(aVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                b bVar = (b) obj2;
                this.f4g = visitor.a(this.f4g, bVar.f4g);
                this.f5h = visitor.a(q(), this.f5h, bVar.q(), bVar.f5h);
                this.i = visitor.a(s(), this.i, bVar.s(), bVar.i);
                this.j = visitor.a(r(), this.j, bVar.r(), bVar.j);
                this.k = visitor.a(p(), this.k, bVar.p(), bVar.k);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f3f |= bVar.f3f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                if (!this.f4g.M()) {
                                    this.f4g = GeneratedMessageLite.a(this.f4g);
                                }
                                this.f4g.add((d) codedInputStream.a(d.u(), extensionRegistryLite));
                            } else if (x == 18) {
                                String v = codedInputStream.v();
                                this.f3f = 1 | this.f3f;
                                this.f5h = v;
                            } else if (x == 24) {
                                this.f3f |= 2;
                                this.i = codedInputStream.k();
                            } else if (x == 32) {
                                this.f3f |= 4;
                                this.j = codedInputStream.k();
                            } else if (x != 40) {
                                if (!a(x, codedInputStream)) {
                                }
                            } else {
                                this.f3f |= 8;
                                this.k = codedInputStream.j();
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw new RuntimeException(e2.setUnfinishedMessage(this));
                    } catch (IOException e3) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f2e == null) {
                    synchronized (b.class) {
                        if (f2e == null) {
                            f2e = new GeneratedMessageLite.DefaultInstanceBasedParser(f1d);
                        }
                    }
                }
                return f2e;
            default:
                throw new UnsupportedOperationException();
        }
        return f1d;
    }
}
