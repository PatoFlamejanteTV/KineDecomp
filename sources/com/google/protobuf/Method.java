package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Method extends GeneratedMessageLite<Method, Builder> implements MethodOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Method f18656d = new Method();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Method> f18657e;

    /* renamed from: f, reason: collision with root package name */
    private int f18658f;
    private boolean i;
    private boolean k;
    private int m;

    /* renamed from: g, reason: collision with root package name */
    private String f18659g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f18660h = "";
    private String j = "";
    private Internal.ProtobufList<Option> l = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Method, Builder> implements MethodOrBuilder {
        /* synthetic */ Builder(K k) {
            this();
        }

        private Builder() {
            super(Method.f18656d);
        }
    }

    static {
        f18656d.l();
    }

    private Method() {
    }

    public static Parser<Method> q() {
        return f18656d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18659g.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        if (!this.f18660h.isEmpty()) {
            codedOutputStream.b(2, o());
        }
        boolean z = this.i;
        if (z) {
            codedOutputStream.b(3, z);
        }
        if (!this.j.isEmpty()) {
            codedOutputStream.b(4, p());
        }
        boolean z2 = this.k;
        if (z2) {
            codedOutputStream.b(5, z2);
        }
        for (int i = 0; i < this.l.size(); i++) {
            codedOutputStream.c(6, this.l.get(i));
        }
        if (this.m != Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.e(7, this.m);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f18659g.isEmpty() ? CodedOutputStream.a(1, n()) + 0 : 0;
        if (!this.f18660h.isEmpty()) {
            a2 += CodedOutputStream.a(2, o());
        }
        boolean z = this.i;
        if (z) {
            a2 += CodedOutputStream.a(3, z);
        }
        if (!this.j.isEmpty()) {
            a2 += CodedOutputStream.a(4, p());
        }
        boolean z2 = this.k;
        if (z2) {
            a2 += CodedOutputStream.a(5, z2);
        }
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            a2 += CodedOutputStream.a(6, this.l.get(i2));
        }
        if (this.m != Syntax.SYNTAX_PROTO2.getNumber()) {
            a2 += CodedOutputStream.a(7, this.m);
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18659g;
    }

    public String o() {
        return this.f18660h;
    }

    public String p() {
        return this.j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        K k = null;
        switch (K.f18632a[methodToInvoke.ordinal()]) {
            case 1:
                return new Method();
            case 2:
                return f18656d;
            case 3:
                this.l.L();
                return null;
            case 4:
                return new Builder(k);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Method method = (Method) obj2;
                this.f18659g = visitor.a(!this.f18659g.isEmpty(), this.f18659g, !method.f18659g.isEmpty(), method.f18659g);
                this.f18660h = visitor.a(!this.f18660h.isEmpty(), this.f18660h, !method.f18660h.isEmpty(), method.f18660h);
                boolean z = this.i;
                boolean z2 = method.i;
                this.i = visitor.a(z, z, z2, z2);
                this.j = visitor.a(!this.j.isEmpty(), this.j, !method.j.isEmpty(), method.j);
                boolean z3 = this.k;
                boolean z4 = method.k;
                this.k = visitor.a(z3, z3, z4, z4);
                this.l = visitor.a(this.l, method.l);
                this.m = visitor.a(this.m != 0, this.m, method.m != 0, method.m);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18658f |= method.f18658f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f18659g = codedInputStream.w();
                            } else if (x == 18) {
                                this.f18660h = codedInputStream.w();
                            } else if (x == 24) {
                                this.i = codedInputStream.c();
                            } else if (x == 34) {
                                this.j = codedInputStream.w();
                            } else if (x == 40) {
                                this.k = codedInputStream.c();
                            } else if (x == 50) {
                                if (!this.l.M()) {
                                    this.l = GeneratedMessageLite.a(this.l);
                                }
                                this.l.add((Option) codedInputStream.a(Option.p(), extensionRegistryLite));
                            } else if (x != 56) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.m = codedInputStream.f();
                            }
                        }
                        r1 = true;
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
                if (f18657e == null) {
                    synchronized (Method.class) {
                        if (f18657e == null) {
                            f18657e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18656d);
                        }
                    }
                }
                return f18657e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18656d;
    }
}
