package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.SourceContext;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Enum extends GeneratedMessageLite<Enum, Builder> implements EnumOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Enum f18552d = new Enum();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Enum> f18553e;

    /* renamed from: f, reason: collision with root package name */
    private int f18554f;

    /* renamed from: g, reason: collision with root package name */
    private String f18555g = "";

    /* renamed from: h, reason: collision with root package name */
    private Internal.ProtobufList<EnumValue> f18556h = GeneratedMessageLite.k();
    private Internal.ProtobufList<Option> i = GeneratedMessageLite.k();
    private SourceContext j;
    private int k;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Enum, Builder> implements EnumOrBuilder {
        /* synthetic */ Builder(C1664s c1664s) {
            this();
        }

        private Builder() {
            super(Enum.f18552d);
        }
    }

    static {
        f18552d.l();
    }

    private Enum() {
    }

    public static Parser<Enum> p() {
        return f18552d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18555g.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        for (int i = 0; i < this.f18556h.size(); i++) {
            codedOutputStream.c(2, this.f18556h.get(i));
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            codedOutputStream.c(3, this.i.get(i2));
        }
        if (this.j != null) {
            codedOutputStream.c(4, o());
        }
        if (this.k != Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.e(5, this.k);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f18555g.isEmpty() ? CodedOutputStream.a(1, n()) + 0 : 0;
        for (int i2 = 0; i2 < this.f18556h.size(); i2++) {
            a2 += CodedOutputStream.a(2, this.f18556h.get(i2));
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            a2 += CodedOutputStream.a(3, this.i.get(i3));
        }
        if (this.j != null) {
            a2 += CodedOutputStream.a(4, o());
        }
        if (this.k != Syntax.SYNTAX_PROTO2.getNumber()) {
            a2 += CodedOutputStream.a(5, this.k);
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18555g;
    }

    public SourceContext o() {
        SourceContext sourceContext = this.j;
        return sourceContext == null ? SourceContext.n() : sourceContext;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1664s c1664s = null;
        switch (C1664s.f18796a[methodToInvoke.ordinal()]) {
            case 1:
                return new Enum();
            case 2:
                return f18552d;
            case 3:
                this.f18556h.L();
                this.i.L();
                return null;
            case 4:
                return new Builder(c1664s);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Enum r8 = (Enum) obj2;
                this.f18555g = visitor.a(!this.f18555g.isEmpty(), this.f18555g, !r8.f18555g.isEmpty(), r8.f18555g);
                this.f18556h = visitor.a(this.f18556h, r8.f18556h);
                this.i = visitor.a(this.i, r8.i);
                this.j = (SourceContext) visitor.a(this.j, r8.j);
                this.k = visitor.a(this.k != 0, this.k, r8.k != 0, r8.k);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18554f |= r8.f18554f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r0) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f18555g = codedInputStream.w();
                            } else if (x == 18) {
                                if (!this.f18556h.M()) {
                                    this.f18556h = GeneratedMessageLite.a(this.f18556h);
                                }
                                this.f18556h.add((EnumValue) codedInputStream.a(EnumValue.o(), extensionRegistryLite));
                            } else if (x == 26) {
                                if (!this.i.M()) {
                                    this.i = GeneratedMessageLite.a(this.i);
                                }
                                this.i.add((Option) codedInputStream.a(Option.p(), extensionRegistryLite));
                            } else if (x == 34) {
                                SourceContext.Builder b2 = this.j != null ? this.j.b() : null;
                                this.j = (SourceContext) codedInputStream.a(SourceContext.p(), extensionRegistryLite);
                                if (b2 != null) {
                                    b2.b((SourceContext.Builder) this.j);
                                    this.j = b2.T();
                                }
                            } else if (x != 40) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.k = codedInputStream.f();
                            }
                        }
                        r0 = true;
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
                if (f18553e == null) {
                    synchronized (Enum.class) {
                        if (f18553e == null) {
                            f18553e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18552d);
                        }
                    }
                }
                return f18553e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18552d;
    }
}
