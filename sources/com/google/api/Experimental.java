package com.google.api;

import com.google.api.AuthorizationConfig;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Experimental extends GeneratedMessageLite<Experimental, Builder> implements ExperimentalOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Experimental f14429d = new Experimental();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Experimental> f14430e;

    /* renamed from: f, reason: collision with root package name */
    private AuthorizationConfig f14431f;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Experimental, Builder> implements ExperimentalOrBuilder {
        /* synthetic */ Builder(C1481t c1481t) {
            this();
        }

        private Builder() {
            super(Experimental.f14429d);
        }
    }

    static {
        f14429d.l();
    }

    private Experimental() {
    }

    public static Experimental o() {
        return f14429d;
    }

    public static Parser<Experimental> p() {
        return f14429d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f14431f != null) {
            codedOutputStream.c(8, n());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f14431f != null ? 0 + CodedOutputStream.a(8, n()) : 0;
        this.f18584c = a2;
        return a2;
    }

    public AuthorizationConfig n() {
        AuthorizationConfig authorizationConfig = this.f14431f;
        return authorizationConfig == null ? AuthorizationConfig.n() : authorizationConfig;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1481t c1481t = null;
        switch (C1481t.f15038a[methodToInvoke.ordinal()]) {
            case 1:
                return new Experimental();
            case 2:
                return f14429d;
            case 3:
                return null;
            case 4:
                return new Builder(c1481t);
            case 5:
                this.f14431f = (AuthorizationConfig) ((GeneratedMessageLite.Visitor) obj).a(this.f14431f, ((Experimental) obj2).f14431f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x != 66) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    AuthorizationConfig.Builder b2 = this.f14431f != null ? this.f14431f.b() : null;
                                    this.f14431f = (AuthorizationConfig) codedInputStream.a(AuthorizationConfig.p(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((AuthorizationConfig.Builder) this.f14431f);
                                        this.f14431f = b2.T();
                                    }
                                }
                            }
                            z = true;
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
                if (f14430e == null) {
                    synchronized (Experimental.class) {
                        if (f14430e == null) {
                            f14430e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14429d);
                        }
                    }
                }
                return f14430e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14429d;
    }
}
