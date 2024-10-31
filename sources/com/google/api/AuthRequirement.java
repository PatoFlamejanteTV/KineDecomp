package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class AuthRequirement extends GeneratedMessageLite<AuthRequirement, Builder> implements AuthRequirementOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final AuthRequirement f14334d = new AuthRequirement();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<AuthRequirement> f14335e;

    /* renamed from: f, reason: collision with root package name */
    private String f14336f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f14337g = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthRequirement, Builder> implements AuthRequirementOrBuilder {
        /* synthetic */ Builder(C1465c c1465c) {
            this();
        }

        private Builder() {
            super(AuthRequirement.f14334d);
        }
    }

    static {
        f14334d.l();
    }

    private AuthRequirement() {
    }

    public static Parser<AuthRequirement> p() {
        return f14334d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14336f.isEmpty()) {
            codedOutputStream.b(1, o());
        }
        if (this.f14337g.isEmpty()) {
            return;
        }
        codedOutputStream.b(2, n());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f14336f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
        if (!this.f14337g.isEmpty()) {
            a2 += CodedOutputStream.a(2, n());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14337g;
    }

    public String o() {
        return this.f14336f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1465c c1465c = null;
        switch (C1465c.f14578a[methodToInvoke.ordinal()]) {
            case 1:
                return new AuthRequirement();
            case 2:
                return f14334d;
            case 3:
                return null;
            case 4:
                return new Builder(c1465c);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                AuthRequirement authRequirement = (AuthRequirement) obj2;
                this.f14336f = visitor.a(!this.f14336f.isEmpty(), this.f14336f, !authRequirement.f14336f.isEmpty(), authRequirement.f14336f);
                this.f14337g = visitor.a(!this.f14337g.isEmpty(), this.f14337g, true ^ authRequirement.f14337g.isEmpty(), authRequirement.f14337g);
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
                                this.f14336f = codedInputStream.w();
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f14337g = codedInputStream.w();
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
                if (f14335e == null) {
                    synchronized (AuthRequirement.class) {
                        if (f14335e == null) {
                            f14335e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14334d);
                        }
                    }
                }
                return f14335e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14334d;
    }
}
