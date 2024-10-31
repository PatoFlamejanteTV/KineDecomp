package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.SourceContext;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Api extends GeneratedMessageLite<Api, Builder> implements ApiOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Api f18376d = new Api();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Api> f18377e;

    /* renamed from: f, reason: collision with root package name */
    private int f18378f;
    private SourceContext k;
    private int m;

    /* renamed from: g, reason: collision with root package name */
    private String f18379g = "";

    /* renamed from: h, reason: collision with root package name */
    private Internal.ProtobufList<Method> f18380h = GeneratedMessageLite.k();
    private Internal.ProtobufList<Option> i = GeneratedMessageLite.k();
    private String j = "";
    private Internal.ProtobufList<Mixin> l = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Api, Builder> implements ApiOrBuilder {
        /* synthetic */ Builder(C1649c c1649c) {
            this();
        }

        private Builder() {
            super(Api.f18376d);
        }
    }

    static {
        f18376d.l();
    }

    private Api() {
    }

    public static Parser<Api> q() {
        return f18376d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18379g.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        for (int i = 0; i < this.f18380h.size(); i++) {
            codedOutputStream.c(2, this.f18380h.get(i));
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            codedOutputStream.c(3, this.i.get(i2));
        }
        if (!this.j.isEmpty()) {
            codedOutputStream.b(4, p());
        }
        if (this.k != null) {
            codedOutputStream.c(5, o());
        }
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            codedOutputStream.c(6, this.l.get(i3));
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
        int a2 = !this.f18379g.isEmpty() ? CodedOutputStream.a(1, n()) + 0 : 0;
        for (int i2 = 0; i2 < this.f18380h.size(); i2++) {
            a2 += CodedOutputStream.a(2, this.f18380h.get(i2));
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            a2 += CodedOutputStream.a(3, this.i.get(i3));
        }
        if (!this.j.isEmpty()) {
            a2 += CodedOutputStream.a(4, p());
        }
        if (this.k != null) {
            a2 += CodedOutputStream.a(5, o());
        }
        for (int i4 = 0; i4 < this.l.size(); i4++) {
            a2 += CodedOutputStream.a(6, this.l.get(i4));
        }
        if (this.m != Syntax.SYNTAX_PROTO2.getNumber()) {
            a2 += CodedOutputStream.a(7, this.m);
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18379g;
    }

    public SourceContext o() {
        SourceContext sourceContext = this.k;
        return sourceContext == null ? SourceContext.n() : sourceContext;
    }

    public String p() {
        return this.j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1649c c1649c = null;
        switch (C1649c.f18746a[methodToInvoke.ordinal()]) {
            case 1:
                return new Api();
            case 2:
                return f18376d;
            case 3:
                this.f18380h.L();
                this.i.L();
                this.l.L();
                return null;
            case 4:
                return new Builder(c1649c);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Api api = (Api) obj2;
                this.f18379g = visitor.a(!this.f18379g.isEmpty(), this.f18379g, !api.f18379g.isEmpty(), api.f18379g);
                this.f18380h = visitor.a(this.f18380h, api.f18380h);
                this.i = visitor.a(this.i, api.i);
                this.j = visitor.a(!this.j.isEmpty(), this.j, !api.j.isEmpty(), api.j);
                this.k = (SourceContext) visitor.a(this.k, api.k);
                this.l = visitor.a(this.l, api.l);
                this.m = visitor.a(this.m != 0, this.m, api.m != 0, api.m);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18378f |= api.f18378f;
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
                                this.f18379g = codedInputStream.w();
                            } else if (x == 18) {
                                if (!this.f18380h.M()) {
                                    this.f18380h = GeneratedMessageLite.a(this.f18380h);
                                }
                                this.f18380h.add((Method) codedInputStream.a(Method.q(), extensionRegistryLite));
                            } else if (x == 26) {
                                if (!this.i.M()) {
                                    this.i = GeneratedMessageLite.a(this.i);
                                }
                                this.i.add((Option) codedInputStream.a(Option.p(), extensionRegistryLite));
                            } else if (x == 34) {
                                this.j = codedInputStream.w();
                            } else if (x == 42) {
                                SourceContext.Builder b2 = this.k != null ? this.k.b() : null;
                                this.k = (SourceContext) codedInputStream.a(SourceContext.p(), extensionRegistryLite);
                                if (b2 != null) {
                                    b2.b((SourceContext.Builder) this.k);
                                    this.k = b2.T();
                                }
                            } else if (x == 50) {
                                if (!this.l.M()) {
                                    this.l = GeneratedMessageLite.a(this.l);
                                }
                                this.l.add((Mixin) codedInputStream.a(Mixin.p(), extensionRegistryLite));
                            } else if (x != 56) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.m = codedInputStream.f();
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
                if (f18377e == null) {
                    synchronized (Api.class) {
                        if (f18377e == null) {
                            f18377e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18376d);
                        }
                    }
                }
                return f18377e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18376d;
    }
}
