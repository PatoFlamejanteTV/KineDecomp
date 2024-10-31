package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Documentation extends GeneratedMessageLite<Documentation, Builder> implements DocumentationOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Documentation f14414d = new Documentation();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Documentation> f14415e;

    /* renamed from: f, reason: collision with root package name */
    private int f14416f;

    /* renamed from: g, reason: collision with root package name */
    private String f14417g = "";

    /* renamed from: h, reason: collision with root package name */
    private Internal.ProtobufList<Page> f14418h = GeneratedMessageLite.k();
    private Internal.ProtobufList<DocumentationRule> i = GeneratedMessageLite.k();
    private String j = "";
    private String k = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Documentation, Builder> implements DocumentationOrBuilder {
        /* synthetic */ Builder(C1479q c1479q) {
            this();
        }

        private Builder() {
            super(Documentation.f14414d);
        }
    }

    static {
        f14414d.l();
    }

    private Documentation() {
    }

    public static Documentation n() {
        return f14414d;
    }

    public static Parser<Documentation> r() {
        return f14414d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14417g.isEmpty()) {
            codedOutputStream.b(1, q());
        }
        if (!this.k.isEmpty()) {
            codedOutputStream.b(2, p());
        }
        for (int i = 0; i < this.i.size(); i++) {
            codedOutputStream.c(3, this.i.get(i));
        }
        if (!this.j.isEmpty()) {
            codedOutputStream.b(4, o());
        }
        for (int i2 = 0; i2 < this.f14418h.size(); i2++) {
            codedOutputStream.c(5, this.f14418h.get(i2));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f14417g.isEmpty() ? CodedOutputStream.a(1, q()) + 0 : 0;
        if (!this.k.isEmpty()) {
            a2 += CodedOutputStream.a(2, p());
        }
        int i2 = a2;
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            i2 += CodedOutputStream.a(3, this.i.get(i3));
        }
        if (!this.j.isEmpty()) {
            i2 += CodedOutputStream.a(4, o());
        }
        for (int i4 = 0; i4 < this.f14418h.size(); i4++) {
            i2 += CodedOutputStream.a(5, this.f14418h.get(i4));
        }
        this.f18584c = i2;
        return i2;
    }

    public String o() {
        return this.j;
    }

    public String p() {
        return this.k;
    }

    public String q() {
        return this.f14417g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1479q c1479q = null;
        switch (C1479q.f15034a[methodToInvoke.ordinal()]) {
            case 1:
                return new Documentation();
            case 2:
                return f14414d;
            case 3:
                this.f14418h.L();
                this.i.L();
                return null;
            case 4:
                return new Builder(c1479q);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Documentation documentation = (Documentation) obj2;
                this.f14417g = visitor.a(!this.f14417g.isEmpty(), this.f14417g, !documentation.f14417g.isEmpty(), documentation.f14417g);
                this.f14418h = visitor.a(this.f14418h, documentation.f14418h);
                this.i = visitor.a(this.i, documentation.i);
                this.j = visitor.a(!this.j.isEmpty(), this.j, !documentation.j.isEmpty(), documentation.j);
                this.k = visitor.a(!this.k.isEmpty(), this.k, true ^ documentation.k.isEmpty(), documentation.k);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14416f |= documentation.f14416f;
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
                                this.f14417g = codedInputStream.w();
                            } else if (x == 18) {
                                this.k = codedInputStream.w();
                            } else if (x == 26) {
                                if (!this.i.M()) {
                                    this.i = GeneratedMessageLite.a(this.i);
                                }
                                this.i.add((DocumentationRule) codedInputStream.a(DocumentationRule.q(), extensionRegistryLite));
                            } else if (x == 34) {
                                this.j = codedInputStream.w();
                            } else if (x != 42) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.f14418h.M()) {
                                    this.f14418h = GeneratedMessageLite.a(this.f14418h);
                                }
                                this.f14418h.add((Page) codedInputStream.a(Page.p(), extensionRegistryLite));
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
                if (f14415e == null) {
                    synchronized (Documentation.class) {
                        if (f14415e == null) {
                            f14415e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14414d);
                        }
                    }
                }
                return f14415e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14414d;
    }
}
