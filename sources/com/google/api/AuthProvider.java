package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class AuthProvider extends GeneratedMessageLite<AuthProvider, Builder> implements AuthProviderOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final AuthProvider f14329d = new AuthProvider();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<AuthProvider> f14330e;

    /* renamed from: f, reason: collision with root package name */
    private String f14331f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f14332g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f14333h = "";
    private String i = "";
    private String j = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthProvider, Builder> implements AuthProviderOrBuilder {
        /* synthetic */ Builder(C1464b c1464b) {
            this();
        }

        private Builder() {
            super(AuthProvider.f14329d);
        }
    }

    static {
        f14329d.l();
    }

    private AuthProvider() {
    }

    public static Parser<AuthProvider> s() {
        return f14329d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14331f.isEmpty()) {
            codedOutputStream.b(1, p());
        }
        if (!this.f14332g.isEmpty()) {
            codedOutputStream.b(2, q());
        }
        if (!this.f14333h.isEmpty()) {
            codedOutputStream.b(3, r());
        }
        if (!this.i.isEmpty()) {
            codedOutputStream.b(4, n());
        }
        if (this.j.isEmpty()) {
            return;
        }
        codedOutputStream.b(5, o());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f14331f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, p());
        if (!this.f14332g.isEmpty()) {
            a2 += CodedOutputStream.a(2, q());
        }
        if (!this.f14333h.isEmpty()) {
            a2 += CodedOutputStream.a(3, r());
        }
        if (!this.i.isEmpty()) {
            a2 += CodedOutputStream.a(4, n());
        }
        if (!this.j.isEmpty()) {
            a2 += CodedOutputStream.a(5, o());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.i;
    }

    public String o() {
        return this.j;
    }

    public String p() {
        return this.f14331f;
    }

    public String q() {
        return this.f14332g;
    }

    public String r() {
        return this.f14333h;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1464b c1464b = null;
        switch (C1464b.f14577a[methodToInvoke.ordinal()]) {
            case 1:
                return new AuthProvider();
            case 2:
                return f14329d;
            case 3:
                return null;
            case 4:
                return new Builder(c1464b);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                AuthProvider authProvider = (AuthProvider) obj2;
                this.f14331f = visitor.a(!this.f14331f.isEmpty(), this.f14331f, !authProvider.f14331f.isEmpty(), authProvider.f14331f);
                this.f14332g = visitor.a(!this.f14332g.isEmpty(), this.f14332g, !authProvider.f14332g.isEmpty(), authProvider.f14332g);
                this.f14333h = visitor.a(!this.f14333h.isEmpty(), this.f14333h, !authProvider.f14333h.isEmpty(), authProvider.f14333h);
                this.i = visitor.a(!this.i.isEmpty(), this.i, !authProvider.i.isEmpty(), authProvider.i);
                this.j = visitor.a(!this.j.isEmpty(), this.j, true ^ authProvider.j.isEmpty(), authProvider.j);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f14331f = codedInputStream.w();
                            } else if (x == 18) {
                                this.f14332g = codedInputStream.w();
                            } else if (x == 26) {
                                this.f14333h = codedInputStream.w();
                            } else if (x == 34) {
                                this.i = codedInputStream.w();
                            } else if (x != 42) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.j = codedInputStream.w();
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
                if (f14330e == null) {
                    synchronized (AuthProvider.class) {
                        if (f14330e == null) {
                            f14330e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14329d);
                        }
                    }
                }
                return f14330e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14329d;
    }
}
