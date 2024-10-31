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
public final class Authentication extends GeneratedMessageLite<Authentication, Builder> implements AuthenticationOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Authentication f14338d = new Authentication();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Authentication> f14339e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<AuthenticationRule> f14340f = GeneratedMessageLite.k();

    /* renamed from: g, reason: collision with root package name */
    private Internal.ProtobufList<AuthProvider> f14341g = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Authentication, Builder> implements AuthenticationOrBuilder {
        /* synthetic */ Builder(C1466d c1466d) {
            this();
        }

        private Builder() {
            super(Authentication.f14338d);
        }
    }

    static {
        f14338d.l();
    }

    private Authentication() {
    }

    public static Authentication n() {
        return f14338d;
    }

    public static Parser<Authentication> o() {
        return f14338d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f14340f.size(); i++) {
            codedOutputStream.c(3, this.f14340f.get(i));
        }
        for (int i2 = 0; i2 < this.f14341g.size(); i2++) {
            codedOutputStream.c(4, this.f14341g.get(i2));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14340f.size(); i3++) {
            i2 += CodedOutputStream.a(3, this.f14340f.get(i3));
        }
        for (int i4 = 0; i4 < this.f14341g.size(); i4++) {
            i2 += CodedOutputStream.a(4, this.f14341g.get(i4));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1466d c1466d = null;
        switch (C1466d.f15021a[methodToInvoke.ordinal()]) {
            case 1:
                return new Authentication();
            case 2:
                return f14338d;
            case 3:
                this.f14340f.L();
                this.f14341g.L();
                return null;
            case 4:
                return new Builder(c1466d);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Authentication authentication = (Authentication) obj2;
                this.f14340f = visitor.a(this.f14340f, authentication.f14340f);
                this.f14341g = visitor.a(this.f14341g, authentication.f14341g);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 26) {
                                if (!this.f14340f.M()) {
                                    this.f14340f = GeneratedMessageLite.a(this.f14340f);
                                }
                                this.f14340f.add((AuthenticationRule) codedInputStream.a(AuthenticationRule.p(), extensionRegistryLite));
                            } else if (x != 34) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.f14341g.M()) {
                                    this.f14341g = GeneratedMessageLite.a(this.f14341g);
                                }
                                this.f14341g.add((AuthProvider) codedInputStream.a(AuthProvider.s(), extensionRegistryLite));
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
                if (f14339e == null) {
                    synchronized (Authentication.class) {
                        if (f14339e == null) {
                            f14339e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14338d);
                        }
                    }
                }
                return f14339e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14338d;
    }
}
