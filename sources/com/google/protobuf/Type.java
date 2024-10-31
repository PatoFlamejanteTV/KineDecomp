package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.SourceContext;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Type extends GeneratedMessageLite<Type, Builder> implements TypeOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Type f18697d = new Type();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Type> f18698e;

    /* renamed from: f, reason: collision with root package name */
    private int f18699f;

    /* renamed from: g, reason: collision with root package name */
    private String f18700g = "";

    /* renamed from: h, reason: collision with root package name */
    private Internal.ProtobufList<Field> f18701h = GeneratedMessageLite.k();
    private Internal.ProtobufList<String> i = GeneratedMessageLite.k();
    private Internal.ProtobufList<Option> j = GeneratedMessageLite.k();
    private SourceContext k;
    private int l;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Type, Builder> implements TypeOrBuilder {
        /* synthetic */ Builder(ca caVar) {
            this();
        }

        private Builder() {
            super(Type.f18697d);
        }
    }

    static {
        f18697d.l();
    }

    private Type() {
    }

    public static Parser<Type> q() {
        return f18697d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18700g.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        for (int i = 0; i < this.f18701h.size(); i++) {
            codedOutputStream.c(2, this.f18701h.get(i));
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            codedOutputStream.b(3, this.i.get(i2));
        }
        for (int i3 = 0; i3 < this.j.size(); i3++) {
            codedOutputStream.c(4, this.j.get(i3));
        }
        if (this.k != null) {
            codedOutputStream.c(5, p());
        }
        if (this.l != Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.e(6, this.l);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f18700g.isEmpty() ? CodedOutputStream.a(1, n()) + 0 : 0;
        for (int i2 = 0; i2 < this.f18701h.size(); i2++) {
            a2 += CodedOutputStream.a(2, this.f18701h.get(i2));
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.i.size(); i4++) {
            i3 += CodedOutputStream.a(this.i.get(i4));
        }
        int size = a2 + i3 + (o().size() * 1);
        for (int i5 = 0; i5 < this.j.size(); i5++) {
            size += CodedOutputStream.a(4, this.j.get(i5));
        }
        if (this.k != null) {
            size += CodedOutputStream.a(5, p());
        }
        if (this.l != Syntax.SYNTAX_PROTO2.getNumber()) {
            size += CodedOutputStream.a(6, this.l);
        }
        this.f18584c = size;
        return size;
    }

    public String n() {
        return this.f18700g;
    }

    public List<String> o() {
        return this.i;
    }

    public SourceContext p() {
        SourceContext sourceContext = this.k;
        return sourceContext == null ? SourceContext.n() : sourceContext;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        ca caVar = null;
        switch (ca.f18747a[methodToInvoke.ordinal()]) {
            case 1:
                return new Type();
            case 2:
                return f18697d;
            case 3:
                this.f18701h.L();
                this.i.L();
                this.j.L();
                return null;
            case 4:
                return new Builder(caVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Type type = (Type) obj2;
                this.f18700g = visitor.a(!this.f18700g.isEmpty(), this.f18700g, !type.f18700g.isEmpty(), type.f18700g);
                this.f18701h = visitor.a(this.f18701h, type.f18701h);
                this.i = visitor.a(this.i, type.i);
                this.j = visitor.a(this.j, type.j);
                this.k = (SourceContext) visitor.a(this.k, type.k);
                this.l = visitor.a(this.l != 0, this.l, type.l != 0, type.l);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18699f |= type.f18699f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r0) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    this.f18700g = codedInputStream.w();
                                } else if (x == 18) {
                                    if (!this.f18701h.M()) {
                                        this.f18701h = GeneratedMessageLite.a(this.f18701h);
                                    }
                                    this.f18701h.add((Field) codedInputStream.a(Field.r(), extensionRegistryLite));
                                } else if (x == 26) {
                                    String w = codedInputStream.w();
                                    if (!this.i.M()) {
                                        this.i = GeneratedMessageLite.a(this.i);
                                    }
                                    this.i.add(w);
                                } else if (x == 34) {
                                    if (!this.j.M()) {
                                        this.j = GeneratedMessageLite.a(this.j);
                                    }
                                    this.j.add((Option) codedInputStream.a(Option.p(), extensionRegistryLite));
                                } else if (x == 42) {
                                    SourceContext.Builder b2 = this.k != null ? this.k.b() : null;
                                    this.k = (SourceContext) codedInputStream.a(SourceContext.p(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((SourceContext.Builder) this.k);
                                        this.k = b2.T();
                                    }
                                } else if (x != 48) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.l = codedInputStream.f();
                                }
                            }
                            r0 = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        }
                    } catch (IOException e3) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f18698e == null) {
                    synchronized (Type.class) {
                        if (f18698e == null) {
                            f18698e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18697d);
                        }
                    }
                }
                return f18698e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18697d;
    }
}
